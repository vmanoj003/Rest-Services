package com.manoj.java.Messenger.RESTAPIConsumption;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {
	
	public static void main(String[] args){
		
		InvocationDemo invocationDemo = new InvocationDemo();
		
		Invocation invocation = invocationDemo.prepareRequestForMessageByYear(2018);
		
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
	}
	
	
	public Invocation prepareRequestForMessageByYear(int year){
		
		Client client = ClientBuilder.newClient();
		
		return client.target("http://localhost:8080/ICodedMessenger/webapi/")
				.path("messages").queryParam("year","2018").request(MediaType.APPLICATION_JSON).buildGet();
		
	}

}
