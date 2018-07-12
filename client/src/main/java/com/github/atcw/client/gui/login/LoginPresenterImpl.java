package com.github.atcw.client.gui.login;

import com.github.atcw.client.gui.SuperController;
import com.github.atcw.client.gui.network.Network;
import com.github.atcw.shared.Login;
import com.github.atcw.shared.LoginResponse;
import com.google.common.eventbus.Subscribe;
import javafx.application.Platform;

public class LoginPresenterImpl implements LoginPresenter {

	private LoginView view;
	private final Network network;
	private final SuperController superController;

	public LoginPresenterImpl(Network network, SuperController superController) {
		this.network = network;
		this.superController = superController;
	}

	@Override
	public void set(LoginView view) {
		this.view = view;
	}

	@Override
	public void doLogin() {
		network.send(new Login(view.enteredUserName()));
	}

	@Subscribe
	public void loginResponse(LoginResponse loginResponse) {
		Platform.runLater(superController::openMainMenu);
	}
}
