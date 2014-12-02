package com.rbena;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = -5277199783611904157L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	@Override	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String blobUploadUrl = blobstoreService.createUploadUrl("/_ah/uploaded");

		res.setStatus(HttpServletResponse.SC_OK);
		res.setContentType("text/plain");

		PrintWriter out = res.getWriter();
		out.print(blobUploadUrl);
	}
}
