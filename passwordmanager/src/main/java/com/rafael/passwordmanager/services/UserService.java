package com.rafael.passwordmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rafael.passwordmanager.Domain.Manager;
import com.rafael.passwordmanager.repositories.ManagerRepository;
import com.rafael.passwordmanager.security.UserSecurity;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private ManagerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Manager manager = repository.findByUserName(userName);
		if (manager == null)
			throw new UsernameNotFoundException(userName); 
		
		return new UserSecurity(manager.getId(), manager.getUser(), 
				manager.getPassword(), manager.getProfile());
	}

}
