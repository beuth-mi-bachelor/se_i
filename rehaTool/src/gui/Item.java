package gui;

import java.util.concurrent.Callable;

public class Item {

	public final String name;
	public final Callable<?> action;

	public Item(String name, Callable<?> action) {
		this.name = name;
		this.action = action;
	}

}
