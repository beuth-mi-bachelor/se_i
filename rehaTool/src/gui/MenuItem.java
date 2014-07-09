package gui;

import gui.handler.MenuEventHandler;

import javax.swing.JMenuItem;

public class MenuItem extends JMenuItem {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -1510770963891463007L;

	public MenuItem(String name, MenuEventHandler menuEventHandler) {
		super(name);
		this.addActionListener(menuEventHandler);
	}

}
