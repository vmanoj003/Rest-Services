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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;



import com.manoj.java.Messenger.model.Message;
import com.manoj.java.Messenger.service.MessageService;

@Path("/messages")
 
public class MessageResource {
	
	
	MessageService service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(){
		
		return service.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = service.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfiel(uriInfo, message), "profiel");
		message.addLink(getUriForComment(uriInfo, message), "comments");
		return message;
	}

	private String getUriForComment(UriInfo uriInfo, Message message) {
		
		String uri = uriInfo.getBaseUriBuilder()
				 .path(MessageResource.class)
				 .path(MessageResource.class,"getCommentResource")
				 .path(MessageResource.class)
				 .resolveTemplate("messageId",message.getId())
				 .build()
				 .toString();
				return uri;
	}

	private String getUriForProfiel(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				 .path(ProfileResource.class)
				 .path(message.getAuthor())
				 .build()
				 .toString();
				return uri;
	
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				 .path(MessageResource.class)
				 .path(Long.toString(message.getId()))
				 .build()
				 .toString();
				return uri;
	}	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		
		return service.addMessage(message);
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long Id,Message message){
		
		message.setId(Id);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") Long Id){
		
		return service.removeMessage(Id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
