package com.manoj.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("test")
public class MyResource {
	
//	@PathParam("pathParam") public String pathParam;
//	@QueryParam("query") public String queryParam;
	
	
	@GET
	@Produces(value= {MediaType.TEXT_PLAIN,"text/shortdate"})
	public String Test() {
		
		LocalDate date = LocalDate.now();
		return "Test" + "  "+ date + "this is secured";
	}

}
