package com.manoj.restservices.restservicesin28.model;

import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String message;
	private String author;
	private LocalDateTime datetime;
	 	 
	
	public Message(){}
	public Message(Long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.datetime = LocalDateTime.now();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDateTime getDate() {
		return datetime;
	}
	public void setDate(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	 

	 

}

