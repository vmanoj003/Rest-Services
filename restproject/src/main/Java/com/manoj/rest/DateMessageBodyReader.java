package com.manoj.rest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

public class DateMessageBodyReader implements MessageBodyReader<Date>{

	public boolean isReadable(Class<?> type, Type type1, Annotation[] annotate, MediaType mt) {
		// TODO Auto-generated method stub
		return Date.class.isAssignableFrom(type);
	}

	public Date readFrom(Class<Date> type, Type type1, Annotation[] annotate, MediaType mt,
			MultivaluedMap<String, String> mm, InputStream input) throws IOException, WebApplicationException {
		
		return null;
	}

}
