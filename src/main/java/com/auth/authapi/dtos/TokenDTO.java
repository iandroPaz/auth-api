package com.auth.authapi.dtos;

public class TokenDTO {

	private String login;

	private String password;
	
	private String resourceId;

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public String getResourceId() {
		return resourceId;
	}

	public TokenDTO() { }

}
