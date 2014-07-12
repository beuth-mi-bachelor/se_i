package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import projects.Project;
import tests.CreateDummyData;
import user.User;
import utils.Utilities;
import views.FeatureContestView;
import views.FeatureProjectView;
import views.ImageRenderer;
import views.MainContestView;
import views.MainProjectView;
import views.MainView;
import views.TableInterface;
import views.TableView;
import contests.Contest;
import forms.FeatureContestForm;
import forms.FeatureProjectForm;
import forms.MainContestForm;
import forms.MainProjectForm;
import forms.UserDetails;
import forms.UserForm;

/**
 * @author Angelina Staeck, Michael Duve & Paul Sprotte
 */
public class WindowContainerStart extends JFrame implements ActionListener {

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
	private final CreateDummyData data;

	public WindowContainerStart() {
		this.setWindowPreferences();
		this.menu = new MenuBar();
		this.createMenu();
		data = new CreateDummyData(5);
		showMain();
		this.setVisible(true);
	}

	public void showFeatureProjectDetails() {
		currentActivePanel = new FeatureProjectView(data.featureProjects.get(0));
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showMainProjectDetails() {
		currentActivePanel = new FeatureProjectView(data.mainProjects.get(0));
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showUserDetails() {
		currentActivePanel = new UserDetails(data.users.get(0));
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showUserDetails(User user) {
		currentActivePanel = new UserDetails(user);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showMain() {
		this.currentActivePanel = new MainView("img/reha-logo.png");
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showUserForm() {
		currentActivePanel = new UserForm(this);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showMainContestForm() {
		currentActivePanel = new MainContestForm(this);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showFeatureContestForm() {
		currentActivePanel = new FeatureContestForm(this);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showFeatureContestView(Contest contest) {
		currentActivePanel = new FeatureContestView(contest);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showMainContestView(Contest contest) {
		currentActivePanel = new MainContestView(contest);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showFeatureProjectView(Project project) {
		currentActivePanel = new FeatureProjectView(project);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showMainProjectView(Project project) {
		currentActivePanel = new MainProjectView(project);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showMainProjectForm() {
		currentActivePanel = new MainProjectForm(this);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void showFeatureProjectForm() {
		currentActivePanel = new FeatureProjectForm(this);
		this.add(currentActivePanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void changeWindow() {
		this.remove(currentActivePanel);
		if (table != null) {
			this.remove(table.getScrollpane());
		}

	}

	public void repaintWindow() {
		this.repaint();
	}

	/*
	 * public void showContestTable(CreateDummyData data) { List<TableInterface>
	 * list = Utilities .convertContestList(data.allContests);
	 * 
	 * table = new TableView(Utilities.getTableData(list));
	 * table.getTable().getColumnModel().getColumn(0) .setCellRenderer(new
	 * ImageRenderer()); table.getTable().setRowHeight(150);
	 * table.getTable().setCellSelectionEnabled(true); ListSelectionModel
	 * cellSelectionModel = table.getTable().getSelectionModel();
	 * 
	 * cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	 * public void valueChanged(ListSelectionEvent e) { changeWindow();
	 * showMainContestView(CreateDummyData.createMainContest()); validate(); }
	 * 
	 * }); currentActivePanel = table.getScrollpane();
	 * this.add(currentActivePanel); this.repaint(); }
	 */

	public void showFeatureContestTable(CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertContestList(data.featureContests);

		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);

		table.getTable().setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = table.getTable()
				.getSelectionModel();

		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						changeWindow();
						showFeatureContestView(CreateDummyData
								.createFeatureContest());
						validate();
					}

				});
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
		table.getTable().setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = table.getTable()
				.getSelectionModel();

		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						changeWindow();
						showMainContestView(CreateDummyData.createMainContest());
						validate();
					}

				});
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}

	public void showUserTable(CreateDummyData data) {
		List<TableInterface> list = Utilities.convertUserList(data.users);

		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		table.getTable().setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = table.getTable()
				.getSelectionModel();

		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						changeWindow();
						showUserDetails(CreateDummyData.createRandomUser());
						validate();
					}

				});
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}

	public void showMainProjectTable(final CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertProjectList(data.mainProjects);

		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		table.getTable().setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = table.getTable()
				.getSelectionModel();

		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						changeWindow();
						showMainProjectView(data.mainProjects.get(0));
						validate();
					}

				});
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}

	public void showFeatureProjectTable(final CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertProjectList(data.featureProjects);

		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		table.getTable().setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = table.getTable()
				.getSelectionModel();

		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						changeWindow();
						showFeatureProjectView(data.featureProjects.get(0));
						validate();
					}

				});
		currentActivePanel = table;
		this.add(table.getScrollpane());
		this.repaint();
	}

	public void showProjectTable(final CreateDummyData data) {
		List<TableInterface> list = Utilities
				.convertProjectList(data.allProjects);

		table = new TableView(Utilities.getTableData(list));
		table.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(new ImageRenderer());
		table.getTable().setRowHeight(150);
		table.getTable().setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = table.getTable()
				.getSelectionModel();

		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						changeWindow();
						showFeatureProjectView(data.allProjects.get(0));
						validate();
					}

				});
		currentActivePanel = table;

		this.add(table.getScrollpane());
		this.repaint();
	}

	private void createMenu() {
		this.menu.addMenuWithItems(this, "Datei", "Beenden");
		this.menu.addMenuWithItems(this, "Benutzer", "Benutzer Erstellen",
				"Benutzerliste anzeigen");
		this.menu.addMenuWithItems(this, "Wettbewerbe",
				"Hauptwettbewerb Erstellen", "Hauptwettbewerbe Anzeigen",
				"Nebenwettbewerb Erstellen", "Nebenwettbewerbe Anzeigen");
		this.menu.addMenuWithItems(this, "Projekte", "Projekte Anzeigen",
				"Featureprojekte anzeigen", "Mainprojekte anzeigen",
				"Featureprojekt erstellen", "Mainprojekt erstellen");
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
			showUserForm();
			validate();
		} else if (e.getActionCommand().equals("Benutzerliste anzeigen")) {
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
			showFeatureContestForm();
			validate();
		} else if (e.getActionCommand().equals("Nebenwettbewerbe Anzeigen")) {
			changeWindow();
			showFeatureContestTable(data);
			validate();
		} else if (e.getActionCommand().equals("Projekte Anzeigen")) {
			changeWindow();
			showProjectTable(data);
			validate();
		} else if (e.getActionCommand().equals("Featureprojekte anzeigen")) {
			changeWindow();
			showFeatureProjectTable(data);
			validate();
		} else if (e.getActionCommand().equals("Mainprojekte anzeigen")) {
			changeWindow();
			showMainProjectTable(data);
			validate();
		} else if (e.getActionCommand().equals("Mainprojekt erstellen")) {
			changeWindow();
			showMainProjectForm();
			validate();
		} else if (e.getActionCommand().equals("Featureprojekt erstellen")) {
			changeWindow();
			showFeatureProjectForm();
			validate();
		} else {
			changeWindow();
			showMain();
			validate();
		}

	}
}
