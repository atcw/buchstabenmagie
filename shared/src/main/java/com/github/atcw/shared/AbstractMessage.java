package com.github.atcw.shared;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractMessage implements Serializable {

	private User user;

	public Optional<User> getUser() {
		return Optional.ofNullable(user);
	}

	public void setUser(User user) {
		this.user = user;
	}

}
