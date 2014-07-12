package forms;

import gui.WindowContainerStart;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.User;
import utils.Utilities;

public class UserDetails extends JPanel {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -4306745152649428256L;

	public final static int WIDTH = WindowContainerStart.WIDTH;
	public final static int HEIGHT = 500;

	private JLabel name;
	private JLabel content;

	@SuppressWarnings("unused")
	private final JPanel panelImage = new JPanel();
	private JPanel panel;
	private final JLabel lblNewLabel = new JLabel();
	private JLabel lblUsername;
	private JLabel lblDatum;
	private final User user;
	private JLabel lblBenutzerDetails;

	public UserDetails(User user) {
		this.setPreferredSize(new Dimension(WindowContainerStart.WIDTH, HEIGHT));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.user = user;
		this.initializeForm();
	}

	public void initializeForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 500, 150 };
		gridBagLayout.rowHeights = new int[] { 10, 150, 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		lblBenutzerDetails = new JLabel("Benutzer Details");
		lblBenutzerDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_lblBenutzerDetails = new GridBagConstraints();
		gbc_lblBenutzerDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzerDetails.gridx = 1;
		gbc_lblBenutzerDetails.gridy = 0;
		add(lblBenutzerDetails, gbc_lblBenutzerDetails);

		panel = new JPanel();

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		lblNewLabel.setIcon(new ImageIcon(this.user.getImage()));
		panel.add(lblNewLabel);

		name = new JLabel();
		name.setText("Name des Users: ");
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.BOTH;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 1;
		gbc_name.gridy = 3;
		this.add(name, gbc_name);

		lblUsername = new JLabel(this.user.getName());
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 4;
		add(lblUsername, gbc_lblUsername);
		content = new JLabel();
		content.setText("Registriert seit:");
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.insets = new Insets(0, 0, 5, 5);
		gbc_content.gridx = 1;
		gbc_content.gridy = 5;
		this.add(content, gbc_content);

		lblDatum = new JLabel(Utilities.dateToTextfield(this.user
				.getRegisteredDate()));
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.insets = new Insets(0, 0, 0, 5);
		gbc_lblDatum.gridx = 1;
		gbc_lblDatum.gridy = 6;
		add(lblDatum, gbc_lblDatum);
	}

}
