package views;

import gui.WindowContainerStart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import projects.Project;
import projects.featureproject.FeatureProject;
import user.User;
import utils.Utilities;
import contests.Contest;
import contests.Prize;
import contests.maincontest.MainContest;
import dialog.ImageDialog;

import java.awt.Font;

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
	private BufferedImage prizeImage;
	private BufferedImage image;

	private final JPanel panelImage = new JPanel();
	private JPanel panel;
	private final JLabel lblNewLabel = new JLabel();
	private JLabel lblProjektname;
	private JLabel lblContent;
	private JLabel lblUsername;
	private JLabel lblcontest;
	private Project featureProject;
	private JLabel projekt;

	public FeatureProjectView(Project featureProject) {
		this.setPreferredSize(new Dimension(WindowContainerStart.WIDTH, HEIGHT));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.featureProject = featureProject;
		this.initializeForm();
	}

	public void initializeForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {150, 500, 150};
		gridBagLayout.rowHeights = new int[] {10, 150, 30, 0, 30, 30};
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
										gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
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
										gbc_lblContent.insets = new Insets(0, 0, 0, 5);
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
						
								lblcontest = new JLabel(this.featureProject.getBelongsToProject().getName());
						GridBagConstraints gbc_lblContest = new GridBagConstraints();
						gbc_lblContest.insets = new Insets(0, 0, 5, 0);
						gbc_lblContest.gridx = 1;
						gbc_lblContest.gridy = 9;
						add(lblcontest, gbc_lblContest);
	}

}
