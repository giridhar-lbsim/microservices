package com.giridhar.microservices.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping
	public String retrieveUsers() {
		return "list of users";
	}

}
