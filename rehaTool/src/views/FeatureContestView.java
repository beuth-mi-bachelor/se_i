package views;

import gui.WindowContainerStart;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import contests.Contest;

public class FeatureContestView extends JPanel {

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
	private BufferedImage prizeImage;
	private BufferedImage image;

	private final JPanel panelImage = new JPanel();
	private JPanel panel;
	private final JLabel lblNewLabel = new JLabel();
	private JLabel lblProjektname;
	private JLabel lblContent;
	private JLabel lblUsername;
	private JLabel lblcontest;
	private final Contest featureContest;
	private JLabel projekt;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblEnde;
	private JLabel label;
	private JLabel label_1;

	public FeatureContestView(Contest featureContest) {
		this.setPreferredSize(new Dimension(WindowContainerStart.WIDTH, HEIGHT));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.featureContest = featureContest;
		this.initializeForm();
	}

	public void initializeForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 500, 150 };
		gridBagLayout.rowHeights = new int[] { 10, 150, 30, 0, 30, 30, 30, 30,
				30, 0, 0, 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		projekt = new JLabel("Feature Wettbewerb Details");
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
		lblNewLabel.setIcon(new ImageIcon(this.featureContest.getImage()));
		panel.add(lblNewLabel);

		name = new JLabel();
		name.setText("Name des Feature Wettbewerbs: ");
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.BOTH;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 1;
		gbc_name.gridy = 2;
		this.add(name, gbc_name);

		lblProjektname = new JLabel(this.featureContest.getName());
		GridBagConstraints gbc_lblProjektname = new GridBagConstraints();
		gbc_lblProjektname.insets = new Insets(0, 0, 5, 5);
		gbc_lblProjektname.gridx = 1;
		gbc_lblProjektname.gridy = 3;
		add(lblProjektname, gbc_lblProjektname);

		username = new JLabel();
		username.setText("Start: ");
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.fill = GridBagConstraints.BOTH;
		gbc_username.insets = new Insets(0, 0, 5, 5);
		gbc_username.gridx = 1;
		gbc_username.gridy = 4;
		this.add(username, gbc_username);

		lblNewLabel_1 = new JLabel(this.featureContest.getStart());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblEnde = new JLabel("Ende:");
		lblEnde.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEnde = new GridBagConstraints();
		gbc_lblEnde.anchor = GridBagConstraints.WEST;
		gbc_lblEnde.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnde.gridx = 1;
		gbc_lblEnde.gridy = 6;
		add(lblEnde, gbc_lblEnde);

		label = new JLabel(this.featureContest.getEnd());
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 7;
		add(label, gbc_label);

		content = new JLabel();
		content.setText("Beschreibung: ");
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.insets = new Insets(0, 0, 5, 5);
		gbc_content.gridx = 1;
		gbc_content.gridy = 8;
		this.add(content, gbc_content);

		lblNewLabel_2 = new JLabel(this.featureContest.getDescription());
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 9;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		contest = new JLabel();
		contest.setText("Preis: ");
		GridBagConstraints gbc_contest = new GridBagConstraints();
		gbc_contest.fill = GridBagConstraints.BOTH;
		gbc_contest.insets = new Insets(0, 0, 5, 5);
		gbc_contest.gridx = 1;
		gbc_contest.gridy = 10;
		this.add(contest, gbc_contest);

		label_1 = new JLabel(this.featureContest.getWinItem().toString());
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 11;
		add(label_1, gbc_label_1);

	}

}
