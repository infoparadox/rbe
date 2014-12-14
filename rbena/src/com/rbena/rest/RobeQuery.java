package com.rbena.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.PersistenceManager;
import javax.ws.rs.Path;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.rbena.PMF;
import com.rbena.closet.Costume;

public class RobeQuery extends ServerResource {

	@Get
	@Path("/getFabric")
	public String getFabric() {
		Set<String> fabric = new HashSet<String>();
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query mediaQuery = new Query("Costume");

		List<Entity> results = datastore.prepare(mediaQuery).asList(
				FetchOptions.Builder.withDefaults());

		for (Entity e : results) {
			fabric.add(e.getProperties().get("material").toString());
		}
		return fabric.toString();
	}

	@Get
	@Path("/hey")
	public String reepresent() {
		return "Hello **!";
	}

	@Get
	@Path("/hey/legends")
	public Set<String> getLegends() {
		Set<String> legends = new HashSet<String>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Object[] costumes = pm.getObjectsById(Costume.class);
		for (Object c : costumes) {
			Costume cs = (Costume) c;
			legends.add(cs.getLegend().toString());
		}
		return legends;
	}

	/*
	 * @Get
	 * 
	 * @Path("/getSize") public String getSize() { Set<String> size = new
	 * HashSet<String>(); PersistenceManager pm =
	 * PMF.get().getPersistenceManager(); Object[] costumes =
	 * pm.getObjectsById(Costume.class); for (Object c : costumes) { Costume cs
	 * = (Costume) c; size.add(cs.getSize().toString()); } return
	 * size.toString(); }
	 */

	@Get
	@Path("/getGender")
	public Set<String> getGender() {
		Set<String> gender = new HashSet<String>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Object[] costumes = pm.getObjectsById(Costume.class);
		for (Object c : costumes) {
			Costume cs = (Costume) c;
			gender.add(cs.getGender().toString());
		}
		return gender;
	}

	@Get
	@Path("/getAgeGroups")
	public Set<String> getAgeGroups() {
		Set<String> age = new HashSet<String>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Object[] costumes = pm.getObjectsById(Costume.class);
		for (Object c : costumes) {
			Costume cs = (Costume) c;
			age.add(cs.getAge().toString());
		}
		return age;
	}

}