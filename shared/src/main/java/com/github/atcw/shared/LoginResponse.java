package com.github.atcw.shared;

import java.io.Serializable;

public class LoginResponse implements Serializable {

	private final boolean okay;

	public LoginResponse(boolean okay) {
		this.okay = okay;
	}

	public boolean isOkay() {
		return okay;
	}
}
