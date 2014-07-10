package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import forms.MainContestForm;
import forms.UserDetails;
import tests.CreateDummyData;
import utils.Utilities;
import views.ImageRenderer;
import views.TableInterface;
import views.TableView;

/**
 * @author Angelina Staeck, Michael Duve & Paul Sprotte
 */
public class WindowContainerStart extends JFrame {

	/*
	 * generated serial id
	 */
	private static final long serialVersionUID = 3055528933453917278L;

	public final static int WIDTH = 1000;
	public final static int HEIGHT = 720;

	private final MenuBar menu;

	public WindowContainerStart() {
		this.setWindowPreferences();

		this.menu = new MenuBar();

		this.createMenu();

		CreateDummyData data = new CreateDummyData(50);

		this.add(new MainContestForm(), BorderLayout.CENTER);
		//this.add(new UserDetails(data.users.get(0)), BorderLayout.CENTER);


		//showContestTable(data);

		this.setVisible(true);
		
		
	}

	public void changeWindow() {
		this.removeAll();
		this.repaint();
	}
	
	public void showContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertContestList(data.allContests);

		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		this.add(table.getScrollpane());
	}

	private void createMenu() {
		this.menu.addMenuWithItems("Datei", "Beenden");
		this.menu.addMenuWithItems("Hauptwettbewerb",
				"Hauptwettbewerb Erstellen");
		this.menu.addMenuWithItems("Nebenwettbewerb",
				"Nebenwettbewerb Erstellen");
		this.menu.addMenuWithItems("Projekte", "Projekte Suchen",
				"Ideen Suchen");
		this.add(this.menu, BorderLayout.NORTH);
	}

	private void setWindowPreferences() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
