package com.manoj.restservices.restservicesin28.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping("/personv1")
	public PersonV1 returnPersonv1() {
		
		return new PersonV1("Manoj");
	}
	
	@GetMapping("/personv2")
	public PersonV2 returnPersonV2() {
		
		return new PersonV2(new Name("manoj","kumar"));
	}
	
	@GetMapping(value = "/person/param", params ="version=1")
	public PersonV1 paramPersonv1() {
		
		return new PersonV1("Manoj");
	}
	
	@GetMapping(value = "/person/param", params="version=2")
	public PersonV2 paramPersonV2() {
		
		return new PersonV2(new Name("manoj","kumar"));
	}
	
	@GetMapping(value="/person/header" ,headers="X-API-VERSION=1")
	public PersonV1 headerPersonv1() {
		
		return new PersonV1("Manoj");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 headerPersonV2() {
		
		return new PersonV2(new Name("manoj","kumar"));
	}

}
