package com.github.atcw.server;

import com.github.atcw.server.network.NetworkModule;
import com.github.atcw.server.usermanagement.UserManagementModule;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

	@Override
	public void configure() {
		install(new NetworkModule());
		install(new UserManagementModule());
	}

}
