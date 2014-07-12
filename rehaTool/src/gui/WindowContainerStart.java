package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import forms.FeatureContestForm;
import forms.MainContestForm;
import forms.UserDetails;
import tests.CreateDummyData;
import utils.Utilities;
import views.FeatureProjectView;
import views.ImageRenderer;
import views.MainView;
import views.TableInterface;
import views.TableView;

/**
 * @author Angelina Staeck, Michael Duve & Paul Sprotte
 */
public class WindowContainerStart extends JFrame implements ActionListener{

	/*
	 * generated serial id
	 */
	private static final long serialVersionUID = 3055528933453917278L;

	public final static int WIDTH = 1000;
	public final static int HEIGHT = 720;

	public ActionListener event = this;
	public WindowContainerStart window = this;
	public Container currentActivePanel;
	private TableView table;
	private final MenuBar menu;
	private CreateDummyData data;
	
	public WindowContainerStart() {
		this.setWindowPreferences();
        
		this.menu = new MenuBar();
        
		this.createMenu();
        
		data = new CreateDummyData(50);
		
		showMain();
		//showUserDetails() ;
		//showMainContestForm();
		//showContestTable(data);
		//showFeatureContestTable(data);
		//showMainContestTable(data);
		//showUserTable(data);
		//showFeatureProjectTable(data);
		//showMainProjectTable(data);
		//showProjectTable(data);
		//showFeatureProjectDetails();
		//showMainProjectDetails();
		this.setVisible(true);
		
	}
		
	public void showFeatureProjectDetails() {
		currentActivePanel = new FeatureProjectView(data.featureProjects.get(0));
		this.add(currentActivePanel, BorderLayout.CENTER);
	}
	public void showMainProjectDetails() {
		currentActivePanel = new FeatureProjectView(data.mainProjects.get(0));
		this.add(currentActivePanel, BorderLayout.CENTER);
	}
	
	public void showUserDetails() {
		currentActivePanel = new UserDetails(data.users.get(0));
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}
    
    public void showMain() {
		this.currentActivePanel = new MainView("img/reha-logo.png");
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}
	
	public void showMainContestForm() {
		currentActivePanel = new MainContestForm(this);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void changeWindow() {
		this.remove(currentActivePanel);
		if(table !=null){
		this.remove(table.getScrollpane());		
		}
		
		
		
	}
	public void repaintWindow() {
		this.repaint();
	}
	public void showContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertContestList(data.allContests);
		
		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table.getScrollpane();
		this.add(currentActivePanel);
		this.repaint();
	}
    
    public void showFeatureContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
        .convertContestList(data.featureContests);
		
		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
        .setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}
    
	public void showMainContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
        .convertContestList(data.mainContests);
		
		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
        .setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}
	
	
	
	public void showUserTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
        .convertUserList(data.users);
		
		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
		.setCellRenderer(new ImageRenderer());
        table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}
    
	public void showMainProjectTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
        .convertProjectList(data.mainProjects);
		
		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
        .setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}
	
	public void showFeatureProjectTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
        .convertProjectList(data.featureProjects);
		
		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
        .setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}
	
	public void showProjectTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
        .convertProjectList(data.allProjects);
		
		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
        .setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}


	private void createMenu() {
		this.menu.addMenuWithItems(this, "Datei", "Beenden");
		this.menu.addMenuWithItems(this, "Benutzer",
				"Benutzer Erstellen","Benutzer Anzeigen");
		this.menu.addMenuWithItems(this, "Hauptwettbewerb",
				"Hauptwettbewerb Erstellen","Hauptwettbewerbe Anzeigen");
		this.menu.addMenuWithItems(this, "Nebenwettbewerb",
				"Nebenwettbewerb Erstellen","Nebenwettbewerbe Anzeigen");
		this.menu.addMenuWithItems(this, "Projekte", "Projekte Suchen"
				,"Projekte Anzeigen");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Beenden")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Benutzer Erstellen")) {
			changeWindow();
			showUserDetails();
			validate();			
		} else if (e.getActionCommand().equals("Benutzer Anzeigen")) {
			changeWindow();
			showUserTable(data);
			validate();			
		} else if (e.getActionCommand().equals("Hauptwettbewerb Erstellen")) {
			changeWindow();
			showMainContestForm();
			validate();
		} else if (e.getActionCommand().equals("Hauptwettbewerbe Anzeigen")) {
			changeWindow();
			showMainContestTable(data);
			validate();			
		} else if (e.getActionCommand().equals("Nebenwettbewerb Erstellen")) {
			changeWindow();
			showFeatureContestTable(data);
			validate();				
		} else if (e.getActionCommand().equals("Nebenwettbewerb Anzeigen")) {
			changeWindow();
			showFeatureContestTable(data);		
			validate();				
		} else if (e.getActionCommand().equals("Projekt ")) {
			changeWindow();
			// TO DO
			validate();				
		} else if (e.getActionCommand().equals("Projekte Anzeigen")) {
			changeWindow();
			showProjectTable(data);
			validate();				
		} else {
			changeWindow();
			showMain();
			validate();
		}
		
		
	}

	

}
