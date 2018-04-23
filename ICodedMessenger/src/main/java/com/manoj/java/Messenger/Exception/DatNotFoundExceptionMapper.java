package com.manoj.java.Messenger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.manoj.java.Messenger.model.ErrorMessage;

@Provider
public class DatNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),404,"https://www.facebook.com");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
