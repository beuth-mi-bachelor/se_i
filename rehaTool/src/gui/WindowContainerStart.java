package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import forms.MainContestForm;
import forms.UserDetails;
import tests.CreateDummyData;
import utils.Utilities;
import views.ImageRenderer;
import views.MainView;
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

	public JPanel currentActivePanel;
	
	private final MenuBar menu;
	private CreateDummyData data;
	
	public WindowContainerStart() {
		this.setWindowPreferences();

		this.menu = new MenuBar();

		this.createMenu();

		data = new CreateDummyData(50);
		
		//showMain();
		//showUserDetails() ;
		//showMainContestForm();
		//showContestTable(data);
		//showFeatureContestTable(data);
		//showMainContestTable(data);
		//showUserTable(data);
		//showFeatureProjectTable(data);
		//showMainProjectTable(data);
		showProjectTable(data);
		this.setVisible(true);
		
	}
	
	public void showMain() {
		this.currentActivePanel = new MainView("img/reha-logo.png");
		this.add(currentActivePanel, BorderLayout.CENTER);
	}
	
	public void showUserDetails() {
		currentActivePanel = new UserDetails(data.users.get(0));
		this.add(currentActivePanel, BorderLayout.CENTER);
	}
	
	public void showMainContestForm() {
		currentActivePanel = new MainContestForm(this);
		this.add(currentActivePanel, BorderLayout.CENTER);
	}

	public void changeWindow() {
		this.remove(currentActivePanel);
		this.repaint();
	}
	
	public void showContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertContestList(data.allContests);
		
		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
	}
	
	public void showFeatureContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertContestList(data.featureContests);
		
		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
	}

	public void showMainContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertContestList(data.mainContests);
		
		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
	}
	
	
	
	public void showUserTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertUserList(data.users);
		
		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
		.setCellRenderer(new ImageRenderer());
table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
	}

	public void showMainProjectTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertProjectList(data.mainProjects);
		
		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
	}
	
	public void showFeatureProjectTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertProjectList(data.featureProjects);
		
		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
	}
	
	public void showProjectTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertProjectList(data.allProjects);
		
		TableView table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
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
