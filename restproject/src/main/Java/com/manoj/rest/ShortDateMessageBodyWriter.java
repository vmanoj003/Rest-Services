package com.manoj.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;


@Provider
@Produces("text/shortdate")
public class ShortDateMessageBodyWriter implements MessageBodyWriter<Date>{

	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		
		return -1;
	}

	public boolean isWriteable(Class<?> type, Type arg1, Annotation[] arg2, MediaType arg3) {
		
		return Date.class.isAssignableFrom(type);
	}

	public void writeTo(Date date, Class<?> type, Type type1, Annotation[] annotate, MediaType mt,
			MultivaluedMap<String, Object> mm, OutputStream out) throws IOException, WebApplicationException {
		
		String shortDate = date.getDay() +"-"+date.getMonth() +"-"+ date.getYear();
		
		out.write(shortDate.toString().getBytes());
		
		
	}

}
