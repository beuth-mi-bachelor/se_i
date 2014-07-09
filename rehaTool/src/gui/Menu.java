package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;

public class Menu extends JMenu {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -5617155576631422259L;

	private final List<MenuItem> menuItems;

	public Menu(String name) {
		super(name);
		this.menuItems = new ArrayList<MenuItem>();
	}

	public List<MenuItem> getMenu() {
		return this.menuItems;
	}

	public void addMenu(String name) {
		MenuItem temporaryMenu = new MenuItem(name);
		this.menuItems.add(temporaryMenu);
		this.add(temporaryMenu);
	}

}
