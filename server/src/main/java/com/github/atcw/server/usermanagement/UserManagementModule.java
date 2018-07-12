package com.github.atcw.server.usermanagement;

import com.google.inject.AbstractModule;

public class UserManagementModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(UserManagement.class).to(UserManagementImpl.class);
	}

}
