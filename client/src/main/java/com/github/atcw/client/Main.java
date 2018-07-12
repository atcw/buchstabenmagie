package com.github.atcw.client;

import com.github.atcw.client.gui.SuperController;
import com.github.atcw.client.gui.network.Network;
import com.google.common.eventbus.EventBus;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Network network = new Network();
		network.registerOutput();
		network.launch();

		SuperController superController = new SuperController(network);
		superController.openLogin();
	}
}
