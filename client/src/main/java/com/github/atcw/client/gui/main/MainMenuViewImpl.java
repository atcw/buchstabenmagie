package com.github.atcw.client.gui.main;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuViewImpl implements MainMenuView {

	private MainMenuPresenter presenter;

	@Override
	public void init(MainMenuPresenter presenter) {
		this.presenter = presenter;

		Stage stage = new Stage();
		Scene scene = new Scene(new Label("Main Menu"));
		stage.setScene(scene);
		stage.show();
	}
}
