package com.github.atcw.server;

import com.github.atcw.server.network.NetworkBase;
import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MainModule());

		injector.getInstance(NetworkBase.class).launch(new EventBus());

		System.out.println("Server Launched");
	}

}
