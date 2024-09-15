package com.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.service.AgeCalculatorService;

@RestController
public class CreateController {
	@Autowired
	AgeCalculatorService ageCalculatorService;
	
	
	@GetMapping("/checkConnection")
	public String checkConnection() {
		return "Connection Successful";

	}
	
    @GetMapping("/calculateAge")
    public String calculateAge(@RequestParam("dob") String dob) {

    	// Call the service to calculate age
        return ageCalculatorService.calculateAge(dob);
    }
}
