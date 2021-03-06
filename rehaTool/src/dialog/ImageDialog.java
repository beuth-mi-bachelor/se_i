package dialog;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImageDialog extends JFileChooser {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = 5717879261840584332L;
	private BufferedImage image;
	private Image scaledImage;

	public ImageDialog() {
		this.image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		JFileChooser filechooser = new JFileChooser();
		final int chosenFile = filechooser.showOpenDialog(getParent());
		if (chosenFile == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			try {
				this.image = ImageIO.read(file);
				this.scaledImage = image.getScaledInstance(150, 150,
						Image.SCALE_SMOOTH);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Image getImage() {
		return this.scaledImage;
	}

}
