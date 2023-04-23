package com.satishlabs.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//RSET API

@RestController
public class HelloWorldController {
	
	// hello-world
	//@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		System.out.println("Launch - helloWorld()");
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		System.out.println("Launch - helloWorldBean()");
		return new HelloWorldBean("Hello World Bean");
	}
	
}
