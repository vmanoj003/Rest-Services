package com.manoj.java.Messenger.RESTAPIConsumption;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secure")
public class SecuredResource {

	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN)
	public String secureMethod(){
		
		return "This is secure API";
	}

}
