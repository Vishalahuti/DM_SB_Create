package com.dm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateController {
	
	@GetMapping("/checkConnection")
	public String checkConnection() {
		return "Connection Successful";

	}
}
