package com.manoj.java.Messenger.model;
import java.time.*;


public class Profile {
	
	private Long id;
	private String profileName;
	private String fname;
	private String lname;
	private LocalDateTime create;
	
	public Profile(){
		
	}
	
	
	public Profile(Long id, String profileName, String fname, String lname) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.fname = fname;
		this.lname = lname;
		this.create = LocalDateTime.now();
	}
	
	
	public LocalDateTime getCreate() {
		return create;
	}


	public void setCreate(LocalDateTime create) {
		this.create = create;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	 


}
