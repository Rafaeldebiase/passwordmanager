package com.rafael.passwordmanager.enums;

public enum ProfileEnum {
	ADMIN(1, "ROLE_ADMIN");
	
	private int cod;
	private String description;
	
	private ProfileEnum(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ProfileEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (ProfileEnum x: ProfileEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
