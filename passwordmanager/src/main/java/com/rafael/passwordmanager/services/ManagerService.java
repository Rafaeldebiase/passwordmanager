package com.rafael.passwordmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rafael.passwordmanager.Domain.Manager;
import com.rafael.passwordmanager.dto.ManagerDto;
import com.rafael.passwordmanager.repositories.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void Create(ManagerDto managerDto) {
		Manager manager = new Manager (managerDto.getUserName(),
				bCryptPasswordEncoder.encode(managerDto.getPassword()));
		repository.save(manager);
	}

}
