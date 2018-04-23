package com.manoj.java.Messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.manoj.java.Messenger.model.Profile;
import com.manoj.java.Messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
ProfileService service = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllMessages(){
		
		return service.getAllProfiles();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String name){
		
		return service.getProfile(name);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addMessage(Profile profile){
		
		return service.addProfile(profile);
	}
	
	
	@PUT
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateMessage(@PathParam("profileName") String name,Profile profile){
		
		profile.setProfileName(name);
		return service.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile deleteMessage(@PathParam("profileName") String name){
		
		return service.removeProfile(name);
	}



}
