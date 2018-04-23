package com.manoj.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("date/{dateString}")
public class MyDateResource {
	
	@GET
	public String test(@PathParam("dateString") Date dateString) {
		
		return "day is "+ dateString.toString();
		
	}

}
