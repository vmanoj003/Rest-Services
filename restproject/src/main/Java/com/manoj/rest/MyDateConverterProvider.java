package com.manoj.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.*;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;


@Provider
public class MyDateConverterProvider implements ParamConverterProvider{

	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		
		if(rawType.getName().equals(Date.class.getName())) {
			
			return new ParamConverter<T>() {
				
				public T fromString(String value) {
					
					LocalDate date = LocalDate.now();
					if("tomorrow".equals(value)) {
						date = date.plusDays(1);
							//return rawType.cast(date);

					}else if("yesterday".equals(value)){
						date = date.minusDays(1);
						//return rawType.cast(date);

						
					}
					
					Date date1 = new Date();
					
					date1.setDay(date.getDayOfMonth());
					date1.setMonth(date.getMonthValue());
					date1.setYear(date.getYear());
					
					return rawType.cast(date1);
						
					}
				
				public String toString(T myBean) {
					if(myBean == null) {
						return null;
					}else return myBean.toString();
				}
				};
			}
		return null;
		}
	}


