package com.github.atcw.client.gui;

import com.github.atcw.client.gui.login.LoginPresenter;
import com.github.atcw.client.gui.login.LoginPresenterImpl;
import com.github.atcw.client.gui.login.LoginView;
import com.github.atcw.client.gui.login.LoginViewImpl;
import com.github.atcw.client.gui.main.MainMenuPresenter;
import com.github.atcw.client.gui.main.MainMenuPresenterImpl;
import com.github.atcw.client.gui.main.MainMenuView;
import com.github.atcw.client.gui.main.MainMenuViewImpl;
import com.github.atcw.client.gui.network.Network;

public class SuperController {

	private final Network network;
	private Presenter presenter;

	public SuperController(Network network) {
		this.network = network;
	}

	private void disconnect() {
		if(presenter != null) {
			network.disconnectFromOutput(presenter);
			presenter = null;
		}
	}

	public void openLogin() {
		disconnect();
		LoginPresenter presenter = new LoginPresenterImpl(network, this);
		network.connectToOutput(presenter);
		LoginView loginView = new LoginViewImpl();
		presenter.init(loginView);
		this.presenter = presenter;
	}

	public void openMainMenu() {
		disconnect();
		MainMenuPresenter presenter = new MainMenuPresenterImpl();
		network.connectToOutput(presenter);
		MainMenuView loginView = new MainMenuViewImpl();
		presenter.init(loginView);
		this.presenter = presenter;
	}
}
