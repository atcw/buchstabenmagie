package com.github.atcw.client.gui.main;

public class MainMenuPresenterImpl implements MainMenuPresenter {

	private MainMenuView view;

	@Override
	public void set(MainMenuView view) {
		this.view = view;
	}
}
