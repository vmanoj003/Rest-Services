package com.manoj.rest;

import java.io.IOException;
import org.glassfish.jersey.internal.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter{
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private final static String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URL_PREFIX = "test";

	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		if(requestContext.getUriInfo().getPath().contains("test")) {
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		
		if(authHeader != null && authHeader.size() > 0) {
			
			String authToken = authHeader.get(0);
			
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");
			String decodedString = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodedString);
			
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			if("user".equals(userName) && "password".equals(password)) {
				return;
			}
			
		}
		
		Response unauthorizedUser = Response.status(Response.Status.UNAUTHORIZED).entity("this is Unauthorized Request").build();
		
		requestContext.abortWith(unauthorizedUser);
		
		
	}

}
}