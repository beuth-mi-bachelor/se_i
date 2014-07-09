package win;

import java.awt.image.BufferedImage;

public class WinItem {

	private final String name;
	private final BufferedImage image;
	private final int price;

	public WinItem(String name, int price, BufferedImage image) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
	}

}
