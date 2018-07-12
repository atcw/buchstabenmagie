package com.github.atcw.server.network;

import com.github.atcw.shared.User;
import com.github.thorbenkuck.netcom2.network.shared.Session;

import java.util.Objects;

class NetComUser implements User {

	private final Session session;

	NetComUser(Session session) {
		this.session = session;
	}

	@Override
	public String getUsername() {
		return session.getIdentifier();
	}

	@Override
	public void notify(Object object) {
		session.send(object);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		NetComUser that = (NetComUser) object;
		return Objects.equals(session, that.session);
	}

	@Override
	public int hashCode() {
		return Objects.hash(session);
	}
}
