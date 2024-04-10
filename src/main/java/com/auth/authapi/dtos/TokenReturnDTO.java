package com.auth.authapi.dtos;

import java.util.Date;

public class TokenReturnDTO {
	private String token;
	
	private Date expiresIn;

	public String getToken() {
		return token;
	}
	
	public Date getExpiresIn() {
		return expiresIn;
	}

	public TokenReturnDTO(String token, Date expiresIn) {
		this.token = token;
		this.expiresIn = expiresIn;
	}
}
