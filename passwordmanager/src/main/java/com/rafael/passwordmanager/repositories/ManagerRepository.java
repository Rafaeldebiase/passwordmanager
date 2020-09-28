package com.rafael.passwordmanager.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.passwordmanager.Domain.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	@Transactional
	public Manager findByUserName(String userName);
}
