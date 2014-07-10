package gui;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class MenuItem extends JMenuItem {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -1510770963891463007L;

	public MenuItem(ActionListener event, String name) {
		super(name);
		this.addActionListener(event);
	}

}
