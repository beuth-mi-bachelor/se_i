package dialog;

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

	public ImageDialog() {
		this.image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		JFileChooser filechooser = new JFileChooser();
		final int chosenFile = filechooser.showOpenDialog(getParent());
		if (chosenFile == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			try {
				this.image = ImageIO.read(file);
				System.out.println(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public BufferedImage getImage() {
		return this.image;
	}

}
