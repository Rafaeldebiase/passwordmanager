package com.rafael.passwordmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.passwordmanager.services.PasswordService;

@RestController
@RequestMapping(value = "/rest/v1/password")
public class PasswordController {
	
	@Autowired
	private PasswordService passwordService;

	@GetMapping(value = "/getpassword={priority}")
	public String getPassword(@PathVariable Boolean priority) {
		return passwordService.getPassword(priority);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(value = "/initialize")
	public void initializePassword() {
		passwordService.initializePassword();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/nextpassword")
	public String nextPassword() {
		return passwordService.nextPassword();		
	}
	
	
}
