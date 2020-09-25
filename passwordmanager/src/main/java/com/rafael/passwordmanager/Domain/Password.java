package com.rafael.passwordmanager.Domain;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Password {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String password;
	private Boolean priority;
	private Boolean alreadyBeenCalled;
	private LocalDateTime date;
	
	public Password() {
		super();
	}
	
	public Password(String password, 
			Boolean priority, Boolean alreadyBeenCalled) {
		super();
		this.password = password;
		this.priority = priority;
		this.alreadyBeenCalled = alreadyBeenCalled;
		this.date = LocalDateTime.now();
	}

	public Boolean getAlreadyBeenCalled() {
		return alreadyBeenCalled;
	}

	public void setAlreadyBeenCalled(Boolean alreadyBeenCalled) {
		this.alreadyBeenCalled = alreadyBeenCalled;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getpriority() {
		return priority;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Password other = (Password) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
