package com.github.atcw.client.gui.network;

import com.github.thorbenkuck.netcom2.exceptions.StartFailedException;
import com.github.thorbenkuck.netcom2.network.client.ClientStart;
import com.google.common.eventbus.EventBus;

public class Network {

	private ClientStart clientStart = ClientStart.at("localhost", 8081);
	private EventBus eventBus = new EventBus();

	public void launch() {
		try {
			clientStart.launch();
		} catch (StartFailedException e) {
			throw new RuntimeException(e);
		}
	}

	public void send(Object object) {
		clientStart.send()
				.objectToServer(object);
	}

	public void registerOutput() {
		clientStart.getCommunicationRegistration()
				.addDefaultCommunicationHandler(eventBus::post);
	}

	public void connectToOutput(Object object) {
		eventBus.register(object);
	}

	public void disconnectFromOutput(Object object) {
		eventBus.unregister(object);
	}
}
