package com.github.atcw.client.gui;

public interface View<T extends Presenter> {

	void init(T presenter);

}
