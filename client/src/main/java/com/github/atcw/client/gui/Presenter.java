package com.github.atcw.client.gui;

public interface Presenter<T extends View> {

	void init(T view);

	void set(T view);

}
