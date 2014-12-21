package com.rbena.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.routing.Template;
import org.restlet.routing.TemplateRoute;

public class SampleApplication extends Application {
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		// TemplateRoute def = router.attach("/hey/*", RobeQuery.class);
		// def.setMatchingMode(Template.MODE_EQUALS);
		// router.attachDefault(RobeQuery.class);
		// router.attach("/hey", RobeQuery.class);
		// router.attach("/hey/", RobeQuery.class);
		TemplateRoute route = router.attach("/getFabric", RobeQuery.class);
		route.setMatchingMode(Template.MODE_EQUALS);
		/*
		 * router.attach("/hey", RobeQuery.class); router.attach("/hey",
		 * RobeQuery.class); router.attach("/hey", RobeQuery.class);
		 * router.attach("/hey", RobeQuery.class); router.attach("/hey",
		 * RobeQuery.class);
		 */

		return router;
	}
}