package forms;

import gui.WindowContainerStart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import contests.Contest;
import contests.Prize;
import contests.maincontest.MainContest;
import dialog.ImageDialog;

public class MainContestForm extends JPanel {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -4306745152649428256L;

	public final static int WIDTH = WindowContainerStart.WIDTH;
	public final static int HEIGHT = 500;

	private final JLabel name;
	private final JLabel startDate;
	private final JLabel endDate;
	private final JLabel prizeName;
	private final JLabel prizeText;
	private final JLabel prizeImg;
	private final JLabel img;
	private final JLabel content;

	private final JTextField textName;
	private final JTextField textStartDate;
	private final JTextField textEndDate;
	private final JTextField namePrize;
	private final JTextField textPrize;
	private BufferedImage prizeImage;
	private final JTextArea textContent;
	private BufferedImage image;

	private final JButton submitButton;
	private final JButton cancelButton;
	private final JButton prizeImageButton;
	private final JButton imageButton;
	private final JPanel buttonPanel = new JPanel();
	private final JPanel buttonPanel2 = new JPanel();
	private final JPanel buttonPanel3 = new JPanel();

	private final JPanel panelImage = new JPanel();
	private final JPanel outerPanel = new JPanel();

	public MainContestForm() {
		this.setPreferredSize(new Dimension(WindowContainerStart.WIDTH, HEIGHT));
		this.setBorder(BorderFactory.createEmptyBorder(20,
				WindowContainerStart.WIDTH / 6, 20,
				WindowContainerStart.WIDTH / 6));
		name = new JLabel();
		startDate = new JLabel();
		endDate = new JLabel();
		prizeName = new JLabel();
		prizeImg = new JLabel();
		prizeText = new JLabel();
		img = new JLabel();
		content = new JLabel();

		textName = new JTextField(20);
		textStartDate = new JTextField(20);
		textEndDate = new JTextField(20);
		textContent = new JTextArea(10, 20);
		textContent.setLineWrap(true);

		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));

		JScrollPane scrollPane = new JScrollPane(textContent);
		outerPanel.add(scrollPane, BorderLayout.CENTER);
		namePrize = new JTextField(20);
		textPrize = new JTextField(20);

		submitButton = new JButton("Erstellen");
		cancelButton = new JButton("Abbrechen");
		prizeImageButton = new JButton("Upload");
		imageButton = new JButton("Upload");

		this.initializeForm();
	}

	public void initializeForm() {
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.X_AXIS));
		buttonPanel3.setLayout(new BoxLayout(buttonPanel3, BoxLayout.X_AXIS));

		submitButton.addActionListener(new okPressedListener());
		cancelButton.addActionListener(new cancelListener());
		imageButton.addActionListener(new uploadListener());
		prizeImageButton.addActionListener(new uploadListener());

		this.setLayout(new GridLayout(20, 1));
		name.setText("Name des Wettbewerbs: ");
		startDate.setText("Startdatum: ");
		endDate.setText("Enddatum: ");
		prizeName.setText("Preisname: ");
		prizeImg.setText("Bildupload Preis: ");
		prizeText.setText("Beschreibung: ");
		img.setText("Bildupload Wettbewerb: ");
		content.setText("Beschreibung des Wettbewerbs: ");

		this.add(img);
		buttonPanel.add(imageButton);
		this.add(buttonPanel);
		this.add(name);
		this.add(textName);
		this.add(content);
		this.add(outerPanel);
		this.add(startDate);
		this.add(textStartDate);
		this.add(endDate);
		this.add(textEndDate);
		this.add(prizeName);
		this.add(namePrize);
		this.add(prizeImg);
		buttonPanel2.add(prizeImageButton);
		this.add(buttonPanel2);
		this.add(prizeText);
		this.add(textPrize);
		buttonPanel3.add(submitButton);
		buttonPanel3.add(cancelButton);
		this.add(buttonPanel3);

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
		}
	}

	public class uploadListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();
			if (button.equals(imageButton)) {
				ImageDialog imgDialog = new ImageDialog();
				image = imgDialog.getImage();
				add(new JLabel(new ImageIcon(image)));
			}
			if (button.equals(prizeImageButton)) {
				ImageDialog imgDialog = new ImageDialog();
				prizeImage = imgDialog.getImage();
			}
		}
	}
}
