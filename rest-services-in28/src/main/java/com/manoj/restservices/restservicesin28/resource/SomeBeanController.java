package com.manoj.restservices.restservicesin28.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.restservices.restservicesin28.model.SomeBean;

@RestController
public class SomeBeanController {
	
	@GetMapping("/somebean")
	public List<SomeBean> returnSomeBean() {
		
		return new ArrayList<SomeBean>(Arrays.asList(new SomeBean("bean1","bean2","bean3"),new SomeBean("bean11","bean21","bean31")));
	}
	
	@GetMapping("/somebean1")
	public SomeBean returnSomeBean1() {
		
		return new SomeBean("bean11","bean21","bean3");
	}

}
