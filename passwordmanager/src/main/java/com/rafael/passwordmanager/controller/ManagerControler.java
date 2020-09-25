package com.rafael.passwordmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.passwordmanager.interfaces.IPasswordService;

@RestController
@RequestMapping(value = "/rest/v1/manager")
public class ManagerControler {
	
	@Autowired
	private IPasswordService passwordService;
	
	@PostMapping(value = "/initialize")
	public void initializePassword() {
		passwordService.initializePassword();
	}
	
	@GetMapping(value = "/nextpassword")
	public String nextPassword() {
		return passwordService.nextPassword();		
	}

}
