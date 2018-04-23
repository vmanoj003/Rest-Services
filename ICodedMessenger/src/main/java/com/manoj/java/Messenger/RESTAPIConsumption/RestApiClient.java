package com.manoj.java.Messenger.RESTAPIConsumption;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.manoj.java.Messenger.model.Message;


public class RestApiClient {
	
	public static void main(String[] args){
		
		Client client = ClientBuilder.newClient();
		
		
		WebTarget webTargetBase = client.target("http://localhost:8080/ICodedMessenger/webapi/");
		WebTarget messageTarget =  webTargetBase.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		
	//	Message message = response.readEntity(Message.class);
		
		Message message1 = singleMessageTarget.resolveTemplate("messageId", "1").request(MediaType.APPLICATION_JSON).get(Message.class);
		Message message2 = singleMessageTarget.resolveTemplate("messageId", "2").request(MediaType.APPLICATION_JSON).get(Message.class);
		
		
		Message newMessage = new Message(1L,"this is REST Consumption Post Method Mesage","I am POSting this");
		Response postResponse = messageTarget.request().post(Entity.json(newMessage));
		
		//if(postResponse.getStatus() != 201){System.out.println(postResponse.getStatus());}
		
		Message createdMessage = postResponse.readEntity(Message.class);
		
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());
		System.out.println(createdMessage.getMessage());

	}
	

}
