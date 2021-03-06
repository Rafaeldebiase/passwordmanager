package com.rafael.passwordmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.passwordmanager.dto.ManagerDto;
import com.rafael.passwordmanager.services.ManagerService;



@RestController
@RequestMapping(value = "/rest/v1/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService service;
	
	@PostMapping(value = "/create")
	public void create(@RequestBody ManagerDto managerDto) {
		service.Create(managerDto);
	}
	
	

}
