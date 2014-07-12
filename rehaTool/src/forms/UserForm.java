package forms;

import gui.WindowContainerStart;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import user.User;
import dialog.ImageDialog;

public class UserForm extends JPanel {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -4306745152649428256L;

	public final static int WIDTH = WindowContainerStart.WIDTH;
	public final static int HEIGHT = 500;

	private JLabel name;
	private JLabel img;
	private JLabel titel;

	private JTextField textName;
	private Image image;

	private JButton submitButton;
	private JButton cancelButton;
	private JButton imageButton;
	private final JPanel buttonPanel = new JPanel();
	private final JPanel buttonPanel2 = new JPanel();
	private final JPanel buttonPanel3 = new JPanel();

	@SuppressWarnings("unused")
	private final JPanel panelImage = new JPanel();
	private JPanel panel;
	private final JLabel lblNewLabel = new JLabel();
	private JPanel panel_1;
	private final JLabel lblBottomimage = new JLabel();
	private final WindowContainerStart parent;

	public UserForm(WindowContainerStart parent) {
		this.parent = parent;
		this.setPreferredSize(new Dimension(WindowContainerStart.WIDTH, HEIGHT));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));

		this.initializeForm();
	}

	public void initializeForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 133, 534, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 23, 23, 23, 23, 100, 23, 23,
				23, 23, 23, 23, 23, 23, 23, 23, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.X_AXIS));
		imageButton = new JButton("Upload");
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		imageButton.addActionListener(new uploadListener());

		titel = new JLabel();
		titel.setText("Benutzer erstellen");
		titel.setFont(new Font("Arial", Font.ITALIC, 20));
		GridBagConstraints gbc_titel = new GridBagConstraints();
		gbc_titel.fill = GridBagConstraints.BOTH;
		gbc_titel.insets = new Insets(0, 0, 5, 5);
		gbc_titel.gridx = 0;
		gbc_titel.gridy = 0;
		this.add(titel, gbc_titel);

		img = new JLabel();
		img.setText("Profilbild: ");

		GridBagConstraints gbc_img = new GridBagConstraints();
		gbc_img.fill = GridBagConstraints.BOTH;
		gbc_img.insets = new Insets(0, 0, 5, 5);
		gbc_img.gridx = 1;
		gbc_img.gridy = 0;
		this.add(img, gbc_img);
		buttonPanel.add(imageButton);
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 1;
		this.add(buttonPanel, gbc_buttonPanel);

		panel = new JPanel();

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);

		panel.add(lblNewLabel);

		name = new JLabel();
		name.setText("Name des Benutzers");
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.BOTH;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 1;
		gbc_name.gridy = 2;
		this.add(name, gbc_name);

		textName = new JTextField(20);
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.fill = GridBagConstraints.BOTH;
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 3;
		this.add(textName, gbc_textName);

		submitButton = new JButton("Erstellen");
		cancelButton = new JButton("Abbrechen");
		buttonPanel3.setLayout(new BoxLayout(buttonPanel3, BoxLayout.X_AXIS));

		submitButton.addActionListener(new okPressedListener());
		cancelButton.addActionListener(new cancelListener());
		buttonPanel3.add(submitButton);
		buttonPanel3.add(cancelButton);
		GridBagConstraints gbc_buttonPanel3 = new GridBagConstraints();
		gbc_buttonPanel3.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPanel3.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel3.gridx = 1;
		gbc_buttonPanel3.gridy = 11;
		this.add(buttonPanel3, gbc_buttonPanel3);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 13;
		add(panel_1, gbc_panel_1);

		panel_1.add(lblBottomimage);
	}

	public class okPressedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			User user = new User(textName.getText(), image);
			parent.changeWindow();
			parent.showUserDetails(user);
			parent.validate();
		}
	}

	public class cancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.changeWindow();
			parent.showMain();
			parent.validate();
		}
	}

	public class uploadListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();
			if (button.equals(imageButton)) {
				ImageDialog imgDialog = new ImageDialog();
				image = imgDialog.getImage();
				lblNewLabel.setIcon(new ImageIcon(image));
			}

		}
	}

}
