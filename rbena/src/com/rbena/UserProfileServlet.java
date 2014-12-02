package com.rbena;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.rbena.closet.Closet;
import com.rbena.closet.Costume;
import com.rbena.closet.Closet.CLOSET_TYPE;
import com.rbena.closet.Costume.Material;
import com.rbena.closet.Costume.OCCASSION;
import com.rbena.closet.Costume.PART;

public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = -5277199783611904157L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");

		String blobKey = req.getParameter("blobKey");
		String blobPath = req.getParameter("blobPath");
		String imgName = req.getParameter("imgName");
		String latLong = req.getParameter("latLong");
		String make = req.getParameter("make");

		ImageDetail imgDetail = new ImageDetail(blobKey, blobPath, imgName,
				latLong, make);

		UserProfile uProf = new UserProfile(userEmail);
		uProf.setUserName(userName);
		Set<Closet> closets = new HashSet<Closet>();
		Closet c = new Closet();
		c.setType(CLOSET_TYPE.WINTER);
		Costume costume = new Costume();
		costume.setMaterial(Material.COTTON);
		costume.setPart(PART.TOP);
		Set<OCCASSION> occassions = new HashSet<OCCASSION>();
		occassions.add(OCCASSION.CASUAL);
		costume.setOccassion(occassions);
		Set<ImageDetail> images = new HashSet<ImageDetail>();
		images.add(imgDetail);
		costume.setImageDetails(images);
		c.addCostume(costume);

		closets.add(c);
		uProf.setCloset(closets);
		System.out.println("**** Gonna Persist: " + uProf);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(uProf);
		pm.close();

		res.setStatus(HttpServletResponse.SC_OK);
		res.setContentType("text/plain");
	}

}
