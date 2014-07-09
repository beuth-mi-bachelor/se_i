package forms;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import contests.Contest;
import contests.Prize;
import contests.maincontest.MainContest;
import dialog.ImageDialog;

public class MainContestForm extends JPanel {

		JPanel panel;

		JLabel name;
		JLabel startDate;
		JLabel endDate;
		JLabel prizeName;
		JLabel prizeText;
		JLabel prizeImg;
		JLabel img;
		JLabel content;

		JTextField textName;
		JTextField textStartDate;
		JTextField textEndDate;
		JTextField namePrize;
		JTextField textPrize;
		BufferedImage prizeImage;
		JTextArea textContent;
		BufferedImage image;
		
		JButton submitButton;
		JButton cancelButton;
		JButton prizeImageButton;
		JButton imageButton;

		
		public MainContestForm() {
			
			panel = new JPanel();
			name = new JLabel();
			startDate = new JLabel();
			endDate = new JLabel();
			prizeName = new JLabel();
			prizeImg = new JLabel();
			prizeText = new JLabel();
			img = new JLabel();
			content = new JLabel();
			
			textName = new JTextField();
			textStartDate = new JTextField();
			textEndDate = new JTextField();
			textContent = new JTextArea(10, 20);
			textContent.setLineWrap(true);
			namePrize = new JTextField();
			textPrize = new JTextField();
			
			submitButton = new JButton("Erstellen");
			cancelButton = new JButton("Abbrechen");
			prizeImageButton = new JButton("Upload");
			imageButton = new JButton("Upload");
		
		}

		public void start()
		{
			submitButton.addActionListener(new okPressedListener());
			cancelButton.addActionListener(new cancelListener());
			imageButton.addActionListener(new uploadListener());
			prizeImageButton.addActionListener(new uploadListener());

			panel.setLayout(new FlowLayout());
			name.setText("Name des Wettbewerbs: ");
			startDate.setText("Startdatum: ");
			endDate.setText("Enddatum: ");
			prizeName.setText("Preisname: ");
			prizeImg.setText("Bildupload Preis: ");
			prizeText.setText("Beschreibung: ");
			img.setText("Bildupload Wettbewerb: ");
			content.setText("Beschreibung des Wettbewerbs: ");

			panel.add(img);
			panel.add(imageButton);
			panel.add(name);
			panel.add(textName);
			panel.add(startDate);
			panel.add(textStartDate);
			panel.add(endDate);
			panel.add(textEndDate);
			panel.add(prizeName);
			panel.add(namePrize);
			panel.add(prizeImg);
			panel.add(prizeImageButton);
			panel.add(submitButton);
			panel.add(cancelButton);
			panel.add(name);
			
		}
		
		
		public class okPressedListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				Prize prize = new Prize(namePrize.getText(), prizeImage, textPrize.getText());
				Contest contest = new MainContest(textStartDate.getText(), textEndDate.getText(), textName.getText(), prize, image);
			}
		}
		
		public class cancelListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
			}
		}
		
		public class uploadListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				JButton button = (JButton) e.getSource();
				if (button.equals(imageButton)) {
					ImageDialog imgDialog = new ImageDialog();
					image = imgDialog.getImage();
				}
				if (button.equals(prizeImageButton)) {
					ImageDialog imgDialog = new ImageDialog();
					prizeImage = imgDialog.getImage();
			}
		}
		}
		
}
