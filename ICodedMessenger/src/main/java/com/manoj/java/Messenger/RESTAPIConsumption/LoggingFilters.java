package com.manoj.java.Messenger.RESTAPIConsumption;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.*;

@Provider
public class LoggingFilters implements ContainerRequestFilter,ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestFilter, ContainerResponseContext responseFilter) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Response Filter:");
		System.out.println(responseFilter.getHeaders());
		
	}

	@Override
	public void filter(ContainerRequestContext requestFilter) throws IOException {
		
		System.out.println("Request Filter:");
		System.out.println(requestFilter.getHeaders());
		// TODO Auto-generated method stub
		
	}

}
