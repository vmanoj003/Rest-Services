package com.manoj.restservices.restservicesin28.model;

import java.time.*;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@Entity
public class User {

	@Id
	private Integer id;
	@ApiModelProperty(notes="the name size is must not be less then two ")
	private String name;
	@ApiModelProperty(notes="the DOB must not be in the future")
	private LocalDateTime birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	protected User() {

	}

	public User(Integer id, String name, LocalDateTime birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPost() {
		return posts;
	}

	public void setPost(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

}
