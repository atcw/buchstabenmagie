package com.github.atcw.client.gui.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewImpl implements LoginView {

	private LoginPresenter loginPresenter;
	private Stage stage;
	@FXML
	private TextField username;

	public void init(LoginPresenter presenter) {
		loginPresenter = presenter;
		stage = new Stage();

		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("loginview.fxml"));
			loader.setController(this);
			root = loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public String enteredUserName() {
		return username.getText();
	}

	@FXML
	public void dispatchLogin(MouseEvent event) {
		event.consume();
		loginPresenter.doLogin();
	}
}
