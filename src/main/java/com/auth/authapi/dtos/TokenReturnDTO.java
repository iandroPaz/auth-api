package com.auth.authapi.dtos;

public class TokenReturnDTO {
	private String token;

	public String getToken() {
		return token;
	}
	
	public TokenReturnDTO(String token) {
		this.token = token;
	}
}
