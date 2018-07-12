package com.github.atcw.server.network;

import com.github.atcw.shared.Login;
import com.github.atcw.shared.LoginResponse;
import com.github.thorbenkuck.netcom2.exceptions.ClientConnectionFailedException;
import com.github.thorbenkuck.netcom2.exceptions.StartFailedException;
import com.github.thorbenkuck.netcom2.interfaces.ReceivePipeline;
import com.github.thorbenkuck.netcom2.logging.NetComLogging;
import com.github.thorbenkuck.netcom2.network.interfaces.Logging;
import com.github.thorbenkuck.netcom2.network.server.ServerStart;
import com.google.common.eventbus.EventBus;

public class NetworkBaseImpl implements NetworkBase {

	public void launch(EventBus eventBus) {
		NetComLogging.setLogging(Logging.trace());
		final ServerStart serverStart = ServerStart.at(8081);

		serverStart.getCommunicationRegistration()
				.addDefaultCommunicationHandler(eventBus::post);

		ReceivePipeline<Login> pipeline = serverStart.getCommunicationRegistration()
				.register(Login.class);

		pipeline.addFirst((session, login) -> {
			session.setIdentified(true);
			session.setIdentifier(login.getUsername());
			LoginResponse loginResponse = new LoginResponse(true);
			serverStart.distribute()
					.toAllIdentified(loginResponse);
			login.setUser(new NetComUser(session));
			eventBus.post(login);
		});

		try {
			serverStart.launch();
			serverStart.acceptAllNextClients();
		} catch (StartFailedException | ClientConnectionFailedException e) {
			throw new RuntimeException(e);
		}
	}
}
