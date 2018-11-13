package com.Manoj.WebServices.restwebServices.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@GetMapping(path="/hello")
	public String hello(){
	
		return "Hello_World";
	}
	
	@GetMapping(path="/helloBean")
	public HelloWorldBean helloBean(){
	
		return new HelloWorldBean("Hello");
	}

}
