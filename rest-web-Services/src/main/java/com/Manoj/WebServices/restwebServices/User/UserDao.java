package com.Manoj.WebServices.restwebServices.User;

import java.util.*;

import org.springframework.stereotype.Component;

import java.time.*;

@Component
public class UserDao {
	
	public static List<User> userList = new ArrayList<>();
	
	public int userCount = 2;
	static {
		
		userList.add(new User(1,"manoj",LocalDate.of(1992,07,20)));
		userList.add(new User(2,"manojkumar",LocalDate.of(1992,07,20)));
		
	}
	
	public List<User> getAll(){
		
		return userList;
	}
	
	public User oneUser(int id) {
		
		for(User i: userList) {
			
			if(i.getId() == id) 
				return i;

		}
		return null;
		
	}
	
	public User addUser(User user) {
		
		if(user.getId() == null) {
			
			user.setId(++userCount);
		}
		
		userList.add(user);
		
		return user;
	}
	
	

}
