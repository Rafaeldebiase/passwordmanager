package com.rafael.passwordmanager.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.passwordmanager.Domain.Password;


@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {
	
	@Transactional
	public Password findTopByPriorityOrderByIdDesc(Boolean priority);
	
	@Transactional
	public List<Password> findByAlreadyBeenCalledOrderById(Boolean alreadyBeenCalled);
}

