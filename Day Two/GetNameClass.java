package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetNameClass {
	
	@Value("${name}")
	private String nameString;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello "+nameString;
	}

}
