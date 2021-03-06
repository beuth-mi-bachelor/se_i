package gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -5617155576631422259L;

	public final static int WIDTH = WindowContainerStart.WIDTH;
	public final static int HEIGHT = 30;

	private final List<Menu> menu;
	

	public MenuBar() {
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.menu = new ArrayList<Menu>();
	
	}

	public List<Menu> getMenu() {
		return this.menu;
	}

	/**
	 * creates a Menu with MenuItems
	 * 
	 * @param name
	 *            the name of the Menu
	 * @param names
	 *            the names of the MenuItems
	 */
	public void addMenuWithItems(ActionListener event, String name, String... names) {
		Menu temporaryMenu = new Menu(name);
		for (String menuItemName : names) {
			temporaryMenu
					.add(new MenuItem(event, menuItemName));
		}
		this.menu.add(temporaryMenu);
		this.add(temporaryMenu);
	}
}
