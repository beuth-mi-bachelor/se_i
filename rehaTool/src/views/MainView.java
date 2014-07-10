package views;

import gui.WindowContainerStart;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

public class MainView extends JPanel {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -6826161044686784696L;
	
	public final static JLabel TITLE = new JLabel("AMP RehaTool");
	public BufferedImage img;
			
	public MainView(String filePath) {
		
		try {
			File file = new File(filePath);
			this.img = ImageIO.read(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		JLabel logo = new JLabel(new ImageIcon(this.img));
		TITLE.setHorizontalAlignment(SwingConstants.CENTER);
		TITLE.setFont(new Font("Adobe Heiti Std", Font.BOLD, 46));
		
		this.setLayout(new GridBagLayout());
		
		this.add(TITLE);
		this.add(logo);
		this.setPreferredSize(new Dimension(WindowContainerStart.WIDTH, WindowContainerStart.HEIGHT));
		
	}
	
	
	
}
