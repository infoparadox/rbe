package com.rbena;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Blob;

public class CopyOfFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CopyOfFileUpload.class
			.getName());
	private BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	@SuppressWarnings("deprecation")
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String uName = "";
		String iName = "";
		try {
			ServletFileUpload upload = new ServletFileUpload();
			res.setContentType("text/plain");
			FileItemIterator iterator = upload.getItemIterator(req);
			while (iterator.hasNext()) {
				FileItemStream item = iterator.next();
				if (item.isFormField()) {
					log.warning("Got a form field: key: " + item.getFieldName());
					uName = item.getFieldName();
				} else {
					log.warning("Got an uploaded file: " + item.getFieldName()
							+ ", name = " + item.getName());
					iName = item.getFieldName();
					InputStream imgStream = item.openStream();
					// construct our entity objects
					Blob imageBlob = new Blob(IOUtils.toByteArray(imgStream));
					MyImage myImage = new MyImage(uName, iName, imageBlob);

					// persist image
					PersistenceManager pm = PMF.get().getPersistenceManager();
					pm.makePersistent(myImage);
					pm.close();

					// respond to query
					res.setContentType("text/plain");
					res.getOutputStream().write("OK!".getBytes());
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

}