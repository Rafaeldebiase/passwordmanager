package com.rafael.passwordmanager.Domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rafael.passwordmanager.enums.ProfileEnum;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Profile")
	private Set<Integer> profiles = new HashSet<>();
	
	public Manager() {
		super();
	}

	public Manager(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		addProfile(ProfileEnum.ADMIN );
	}
	
	public String getUser() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getId() {
		return id;
	}
	
	public Set<ProfileEnum> getProfile() {
		return profiles.stream()
				.map(item -> ProfileEnum.toEnum(item))
				.collect(Collectors.toSet());
	}
	
	public void addProfile(ProfileEnum profile) {
		profiles.add(profile.getCod());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	
	
	
}
