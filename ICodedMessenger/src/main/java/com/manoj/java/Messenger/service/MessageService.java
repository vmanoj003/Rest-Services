package com.manoj.java.Messenger.service;
import java.time.*;
import java.util.*;

import com.manoj.java.Messenger.Exception.DataNotFoundException;
import com.manoj.java.Messenger.database.DatabaseClass;
import com.manoj.java.Messenger.model.Message;
public class MessageService {
	
	
	Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		
		messages.put(1L,new Message(1L,"this REST WEBservice","Manoj"));
		messages.put(2L,new Message(2L,"this REST WEBservice Designing","Kumar"));
	}
	
	
	public List<Message> getAllMessages(){
			
		return new ArrayList<Message>(messages.values());
		
	}
	
	
		public Message getMessage(Long id){
			
			Message msg = messages.get(id);
			
			if (msg == null) {
				throw new DataNotFoundException("Message with id " + id + " not found");
			}
			return msg;
		}
		
		
		public Message addMessage(Message message){
			
			message.setId((long) (messages.size()+1));
			messages.put(message.getId(),message);
			
			return message;
		}
		
		
		public Message  updateMessage(Message message){
			
			if(message.getId() < 0) return null;
			else messages.put(message.getId(), message);
			return message;
		}
		
		
		public Message removeMessage(Long id){
			
			return messages.remove(id);
			//return message;
		}

	
	
	
}
