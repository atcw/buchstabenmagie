package com.github.atcw.shared;

public class Login extends AbstractMessage {

	private final String username;

	public Login(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}
