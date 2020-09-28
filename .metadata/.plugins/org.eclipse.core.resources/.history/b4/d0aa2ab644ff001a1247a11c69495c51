package com.rafael.passwordmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.passwordmanager.interfaces.IPasswordService;

@RestController
@RequestMapping(value = "/rest/v1/customer")
public class CustomerController {
	
	@Autowired
	private IPasswordService passwordService;

	@GetMapping(value = "/getpassword={priority}")
	public String getPassword(@PathVariable Boolean priority) {
		
		return passwordService.getPassword(priority);

	}
}
