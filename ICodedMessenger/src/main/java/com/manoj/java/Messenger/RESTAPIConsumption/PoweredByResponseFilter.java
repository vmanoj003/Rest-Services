package com.manoj.java.Messenger.RESTAPIConsumption;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContect, ContainerResponseContext responseContext) throws IOException {
		// TODO Auto-generated method stub
		
		responseContext.getHeaders().add("X-PoweredBy", "Manoj");
	}

}
