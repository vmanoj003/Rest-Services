package com.Manoj.WebServices.restwebServices.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	public UserDao userDao;
	
	@GetMapping(path="/getAllUsers/")
	public List<User> getUsers() {
		
	return userDao.getAll();
	
	}
	
	@GetMapping(path="/getUser/{id}")
	public User getUser(@PathVariable Integer id){
		
		User user = userDao.oneUser(id);
		
		return user;
		
	}
	
	@PostMapping(path="/users/")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		User savedUser = userDao.addUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	

}
