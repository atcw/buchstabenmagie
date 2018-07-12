package com.github.atcw.server.network;

import com.google.inject.AbstractModule;

public class NetworkModule extends AbstractModule {

	@Override
	public void configure() {
		bind(NetworkBase.class).to(NetworkBaseImpl.class);
	}

}
