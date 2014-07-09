package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author Angelina Staeck, Michael Duve & Paul Sprotte
 */
public class WindowContainerStart extends JFrame {

	/*
	 * generated serial id
	 */
	private static final long serialVersionUID = 3055528933453917278L;

	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;

	private final MenuBar menu;

	public WindowContainerStart() {
		this.setWindowPreferences();

		this.menu = new MenuBar();

		this.createMenu();

		this.setVisible(true);
	}

	private void createMenu() {

		this.menu.addMenuWithItems("Datei", "Beenden");
		this.menu.addMenuWithItems("Hauptwettbewerb", "Erstellen",
				"Bearbeiten", "Löschen");
		this.menu.addMenuWithItems("Nebenwettbewerb", "Erstellen",
				"Bearbeiten", "Löschen");
		this.add(this.menu, BorderLayout.NORTH);
	}

	private void setWindowPreferences() {
		this.setPreferredSize(new Dimension(800, 600));
		this.pack();
		this.setLocationRelativeTo(null);
	}

	/**
	 * @param args
	 *            arguments for starting
	 */
	public static void main(final String[] args) {
		new WindowContainerStart();
	}

}