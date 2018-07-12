package com.github.atcw.client.gui.login;

import com.github.atcw.client.gui.Presenter;

public interface LoginPresenter extends Presenter<LoginView> {

	default void init(LoginView loginView) {
		set(loginView);
		loginView.init(this);
	}

	void set(LoginView loginView);

	void doLogin();
}
