package com.manoj.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter{

	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		
		responseContext.getHeaders().add("x-poweredBy","Manojkumar");
		
	}

}
