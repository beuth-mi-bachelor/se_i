package forms;

import gui.WindowContainerStart;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
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

import contests.Contest;
import contests.Prize;
import contests.maincontest.MainContest;
import dialog.ImageDialog;

public class MainContestForm extends JPanel {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -4306745152649428256L;

	public JPanel self = this;
	public Component parent = self.getParent();
	
	public final static int WIDTH = WindowContainerStart.WIDTH;
	public final static int HEIGHT = 500;

	private JLabel name;
	private JLabel startDate;
	private JLabel endDate;
	private JLabel prizeName;
	private JLabel prizeText;
	private JLabel prizeImg;
	private JLabel img;
	private JLabel content;

	private JTextField textName;
	private JTextField textStartDate;
	private JTextField textEndDate;
	private JTextField namePrize;
	private JTextField textPrize;
	private BufferedImage prizeImage;
	private JTextArea textContent;
	private BufferedImage image;

	private JButton submitButton;
	private JButton cancelButton;
	private JButton prizeImageButton;
	private JButton imageButton;
	private final JPanel buttonPanel = new JPanel();
	private final JPanel buttonPanel2 = new JPanel();
	private final JPanel buttonPanel3 = new JPanel();

	private final JPanel panelImage = new JPanel();
	private final JPanel outerPanel = new JPanel();
	private JPanel panel;
	private final JLabel lblNewLabel = new JLabel();
	private JPanel panel_1;
	private final JLabel lblBottomimage = new JLabel();

	public MainContestForm() {
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
		prizeImageButton = new JButton("Upload");
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.X_AXIS));
		prizeImageButton.addActionListener(new uploadListener());
		imageButton = new JButton("Upload");
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		imageButton.addActionListener(new uploadListener());
		img = new JLabel();
		img.setText("Bildupload Wettbewerb: ");

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
		name.setText("Name des Wettbewerbs: ");
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
		content = new JLabel();
		content.setText("Beschreibung des Wettbewerbs: ");
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.insets = new Insets(0, 0, 5, 5);
		gbc_content.gridx = 1;
		gbc_content.gridy = 4;
		this.add(content, gbc_content);
		textContent = new JTextArea(10, 20);
		textContent.setLineWrap(true);

		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));

		JScrollPane scrollPane = new JScrollPane(textContent);
		outerPanel.add(scrollPane, BorderLayout.CENTER);
		GridBagConstraints gbc_outerPanel = new GridBagConstraints();
		gbc_outerPanel.fill = GridBagConstraints.BOTH;
		gbc_outerPanel.insets = new Insets(0, 0, 5, 5);
		gbc_outerPanel.gridx = 1;
		gbc_outerPanel.gridy = 5;
		this.add(outerPanel, gbc_outerPanel);
		startDate = new JLabel();
		startDate.setText("Startdatum: ");
		GridBagConstraints gbc_startDate = new GridBagConstraints();
		gbc_startDate.fill = GridBagConstraints.BOTH;
		gbc_startDate.insets = new Insets(0, 0, 5, 5);
		gbc_startDate.gridx = 1;
		gbc_startDate.gridy = 6;
		this.add(startDate, gbc_startDate);
		textStartDate = new JTextField(20);
		GridBagConstraints gbc_textStartDate = new GridBagConstraints();
		gbc_textStartDate.fill = GridBagConstraints.BOTH;
		gbc_textStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_textStartDate.gridx = 1;
		gbc_textStartDate.gridy = 7;
		this.add(textStartDate, gbc_textStartDate);
		endDate = new JLabel();
		endDate.setText("Enddatum: ");
		GridBagConstraints gbc_endDate = new GridBagConstraints();
		gbc_endDate.fill = GridBagConstraints.BOTH;
		gbc_endDate.insets = new Insets(0, 0, 5, 5);
		gbc_endDate.gridx = 1;
		gbc_endDate.gridy = 8;
		this.add(endDate, gbc_endDate);
		textEndDate = new JTextField(20);
		GridBagConstraints gbc_textEndDate = new GridBagConstraints();
		gbc_textEndDate.fill = GridBagConstraints.BOTH;
		gbc_textEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_textEndDate.gridx = 1;
		gbc_textEndDate.gridy = 9;
		this.add(textEndDate, gbc_textEndDate);
		prizeName = new JLabel();
		prizeName.setText("Preisname: ");
		GridBagConstraints gbc_prizeName = new GridBagConstraints();
		gbc_prizeName.fill = GridBagConstraints.BOTH;
		gbc_prizeName.insets = new Insets(0, 0, 5, 5);
		gbc_prizeName.gridx = 1;
		gbc_prizeName.gridy = 10;
		this.add(prizeName, gbc_prizeName);
		namePrize = new JTextField(20);
		GridBagConstraints gbc_namePrize = new GridBagConstraints();
		gbc_namePrize.fill = GridBagConstraints.BOTH;
		gbc_namePrize.insets = new Insets(0, 0, 5, 5);
		gbc_namePrize.gridx = 1;
		gbc_namePrize.gridy = 11;
		this.add(namePrize, gbc_namePrize);
		prizeImg = new JLabel();
		prizeImg.setText("Bildupload Preis: ");
		GridBagConstraints gbc_prizeImg = new GridBagConstraints();
		gbc_prizeImg.fill = GridBagConstraints.BOTH;
		gbc_prizeImg.insets = new Insets(0, 0, 5, 5);
		gbc_prizeImg.gridx = 1;
		gbc_prizeImg.gridy = 12;
		this.add(prizeImg, gbc_prizeImg);
		buttonPanel2.add(prizeImageButton);
		GridBagConstraints gbc_buttonPanel2 = new GridBagConstraints();
		gbc_buttonPanel2.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel2.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPanel2.gridx = 1;
		gbc_buttonPanel2.gridy = 13;
		this.add(buttonPanel2, gbc_buttonPanel2);

		submitButton = new JButton("Erstellen");
		cancelButton = new JButton("Abbrechen");
		buttonPanel3.setLayout(new BoxLayout(buttonPanel3, BoxLayout.X_AXIS));

		submitButton.addActionListener(new okPressedListener());
		cancelButton.addActionListener(new cancelListener());

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 13;
		add(panel_1, gbc_panel_1);

		panel_1.add(lblBottomimage);

		prizeText = new JLabel();
		prizeText.setText("Beschreibung: ");
		GridBagConstraints gbc_prizeText = new GridBagConstraints();
		gbc_prizeText.fill = GridBagConstraints.BOTH;
		gbc_prizeText.insets = new Insets(0, 0, 5, 5);
		gbc_prizeText.gridx = 1;
		gbc_prizeText.gridy = 14;
		this.add(prizeText, gbc_prizeText);
		textPrize = new JTextField(20);
		GridBagConstraints gbc_textPrize = new GridBagConstraints();
		gbc_textPrize.fill = GridBagConstraints.BOTH;
		gbc_textPrize.insets = new Insets(0, 0, 5, 5);
		gbc_textPrize.gridx = 1;
		gbc_textPrize.gridy = 15;
		this.add(textPrize, gbc_textPrize);
		buttonPanel3.add(submitButton);
		buttonPanel3.add(cancelButton);
		GridBagConstraints gbc_buttonPanel3 = new GridBagConstraints();
		gbc_buttonPanel3.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPanel3.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel3.gridx = 1;
		gbc_buttonPanel3.gridy = 16;
		this.add(buttonPanel3, gbc_buttonPanel3);
	}

	public class okPressedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Prize prize = new Prize(namePrize.getText(), prizeImage,
					textPrize.getText());
			Contest contest = new MainContest(textStartDate.getText(),
					textEndDate.getText(), textName.getText(), prize, image);
			System.out.println(contest);
		}
	}

	public class cancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO: GO TO START
			Container parent = self.getParent();
			parent.remove(self);
			parent.repaint();
		}
	}

	public class uploadListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();
			if (button.equals(imageButton)) {
				ImageDialog imgDialog = new ImageDialog();
				image = imgDialog.getImage();
				Image scaledImage = image.getScaledInstance(100, 100,
						Image.SCALE_SMOOTH);
				lblNewLabel.setIcon(new ImageIcon(scaledImage));
			}
			if (button.equals(prizeImageButton)) {
				ImageDialog imgDialog = new ImageDialog();
				prizeImage = imgDialog.getImage();
				image = imgDialog.getImage();
				Image scaledImage = image.getScaledInstance(100, 100,
						Image.SCALE_SMOOTH);
				lblBottomimage.setIcon(new ImageIcon(scaledImage));
			}
		}
	}

}
