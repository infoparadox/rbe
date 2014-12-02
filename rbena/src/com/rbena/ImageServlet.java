package com.rbena;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

@SuppressWarnings("serial")
public class ImageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String user = req.getParameter("userid");
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Filter f = new FilterPredicate("userId", FilterOperator.EQUAL, user);
		Query q = new Query("UserProfile").setFilter(f);
		PreparedQuery pq = datastore.prepare(q);
		byte [] pic = null;
		for (Entity result : pq.asIterable()) {
			System.out.println("Got Entity: " + result.getAppId());
			Blob b = (Blob) result.getProperty("image");
			pic = b.getBytes();
		}	

		resp.setContentType("text/plain");
		resp.getOutputStream().write(pic);
	}
}
