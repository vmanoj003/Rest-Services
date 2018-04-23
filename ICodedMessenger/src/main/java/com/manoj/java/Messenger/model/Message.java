package com.manoj.java.Messenger.model;

import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;




@XmlRootElement
public class Message {
	
	
	private Long id;
	private String message;
	private String author;
	private LocalDateTime datetime;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();
	 
	
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
	
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url, String rel){
		Link link = new Link();
		
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	 

}

