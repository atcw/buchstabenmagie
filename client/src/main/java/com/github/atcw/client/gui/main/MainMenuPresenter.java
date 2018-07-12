package com.github.atcw.client.gui.main;

import com.github.atcw.client.gui.Presenter;

public interface MainMenuPresenter extends Presenter<MainMenuView> {

	default void init(MainMenuView view) {
		view.init(this);
		set(view);
	}

}
