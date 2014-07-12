package views;

import gui.WindowContainerStart;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import projects.Project;

public class FeatureProjectView extends JPanel {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -4306745152649428256L;

	public final static int WIDTH = WindowContainerStart.WIDTH;
	public final static int HEIGHT = 500;

	private JLabel name;
	private JLabel username;
	private JLabel content;
	private JLabel contest;

	private JPanel panel;
	private final JLabel lblNewLabel = new JLabel();
	private JLabel lblProjektname;
	private JLabel lblContent;
	private JLabel lblUsername;
	private JLabel lblcontest;
	private final Project featureProject;
	private JLabel projekt;
	private JButton btnBewerten;
	private JLabel lblBewertung;
	private JLabel label;

	public FeatureProjectView(Project featureProject) {
		this.setPreferredSize(new Dimension(WindowContainerStart.WIDTH, HEIGHT));
		this.featureProject = featureProject;
		this.initializeForm();
	}

	public void initializeForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 500, 150 };
		gridBagLayout.rowHeights = new int[] { 10, 150, 30, 30, 30, 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		projekt = new JLabel("Projekt Details");
		projekt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_lblBenutzerDetails = new GridBagConstraints();
		gbc_lblBenutzerDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzerDetails.gridx = 1;
		gbc_lblBenutzerDetails.gridy = 0;
		add(projekt, gbc_lblBenutzerDetails);

		panel = new JPanel();

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		lblNewLabel.setIcon(new ImageIcon(this.featureProject.getImage()));
		panel.add(lblNewLabel);

		name = new JLabel();
		name.setText("Name des Projektes: ");
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.BOTH;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 1;
		gbc_name.gridy = 2;
		this.add(name, gbc_name);

		lblProjektname = new JLabel(this.featureProject.getName());
		GridBagConstraints gbc_lblProjektname = new GridBagConstraints();
		gbc_lblProjektname.insets = new Insets(0, 0, 5, 5);
		gbc_lblProjektname.gridx = 1;
		gbc_lblProjektname.gridy = 3;
		add(lblProjektname, gbc_lblProjektname);

		username = new JLabel();
		username.setText("Autor: ");
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.fill = GridBagConstraints.BOTH;
		gbc_username.insets = new Insets(0, 0, 5, 5);
		gbc_username.gridx = 1;
		gbc_username.gridy = 4;
		this.add(username, gbc_username);

		lblUsername = new JLabel(this.featureProject.getCreator().getName());
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 5;
		add(lblUsername, gbc_lblUsername);

		content = new JLabel();
		content.setText("Beschreibung: ");
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.insets = new Insets(0, 0, 5, 5);
		gbc_content.gridx = 1;
		gbc_content.gridy = 6;
		this.add(content, gbc_content);

		lblContent = new JLabel(this.featureProject.getContent());
		GridBagConstraints gbc_lblContent = new GridBagConstraints();
		gbc_lblContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblContent.gridx = 1;
		gbc_lblContent.gridy = 7;
		add(lblContent, gbc_lblContent);

		contest = new JLabel();
		contest.setText("Wettbewerb: ");
		GridBagConstraints gbc_contest = new GridBagConstraints();
		gbc_contest.fill = GridBagConstraints.BOTH;
		gbc_contest.insets = new Insets(0, 0, 5, 5);
		gbc_contest.gridx = 1;
		gbc_contest.gridy = 8;
		this.add(contest, gbc_contest);

		lblcontest = new JLabel(this.featureProject.getBelongsToProject()
				.getName());
		GridBagConstraints gbc_lblContest = new GridBagConstraints();
		gbc_lblContest.insets = new Insets(0, 0, 5, 5);
		gbc_lblContest.gridx = 1;
		gbc_lblContest.gridy = 9;
		add(lblcontest, gbc_lblContest);

		lblBewertung = new JLabel("Bewertung");
		GridBagConstraints gbc_lblBewertung = new GridBagConstraints();
		gbc_lblBewertung.anchor = GridBagConstraints.WEST;
		gbc_lblBewertung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBewertung.gridx = 1;
		gbc_lblBewertung.gridy = 10;
		add(lblBewertung, gbc_lblBewertung);

		label = new JLabel(this.featureProject.getScore() + " Sterne");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 11;
		add(label, gbc_label);

		btnBewerten = new JButton("Bewerten");
		GridBagConstraints gbc_btnBewerten = new GridBagConstraints();
		gbc_btnBewerten.insets = new Insets(0, 0, 0, 5);
		gbc_btnBewerten.gridx = 1;
		gbc_btnBewerten.gridy = 12;
		add(btnBewerten, gbc_btnBewerten);
		btnBewerten.addActionListener(new ScoreListener());
	}

	public class ScoreListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int arg = JOptionPane.showOptionDialog(null,
					"Wie viele Sterne möchten Sie vergeben?", "Optionsdialog",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new String[] { "1",
							"2", "3", "4", "5" }, null);
			featureProject.setScore(arg + 1);
			label.setText(featureProject.getScore() + "Sterne");
			btnBewerten.setEnabled(false);
			repaint();
		}
	}

}
