package com.manoj.java.Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import com.manoj.java.Messenger.Exception.DataNotFoundException;
import com.manoj.java.Messenger.database.DatabaseClass;
import com.manoj.java.Messenger.model.Comment;
import com.manoj.java.Messenger.model.ErrorMessage;
import com.manoj.java.Messenger.model.Message;

 

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Message message = messages.get(messageId);
		ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushik.org");
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		
		if (message == null) {
			throw new WebApplicationException(response);
		}
		Comment comment = comments.get(commentId);
		if (comment == null) 
			throw new NotFoundException(response);
		
			return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}
