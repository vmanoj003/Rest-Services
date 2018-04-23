package com.manoj.java.Messenger.RESTAPIConsumption;


import java.io.IOException;
import java.util.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.*;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecureFilter implements ContainerRequestFilter{
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secure";



	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
	if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){	
	List<String> authHeader = 	requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
	
	if(authHeader.size()>0){
		
		String authToken = authHeader.get(0);
		
		authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");
		
		String decodeString = Base64.decodeAsString(authToken);
		
		StringTokenizer tokenizer = new StringTokenizer(decodeString,":");
		
		String userName = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		
		
		if("user".equals(userName) && "123456".equals(password)){
			
			return ;
		}

		
	}
	
	Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("user cannnot acess this page").build();
	
	requestContext.abortWith(unauthorizedStatus);
		
		
	}
	}
}
