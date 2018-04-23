package com.manoj.java.Messenger.model;

import java.util.Date;

public class Comment {
	

	private long id;
    private String cMessage;
    private Date created;
    private String author;
    
    public Comment() {
    	
    }
    
    public Comment(long id, String cMessage, String author) {
    	this.id = id;
    	this.cMessage = cMessage;
    	this.author = author;
    	this.created = new Date();
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	 
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getcMessage() {
		return cMessage;
	}

	public void setcMessage(String cMessage) {
		this.cMessage = cMessage;
	}
    
    

}
