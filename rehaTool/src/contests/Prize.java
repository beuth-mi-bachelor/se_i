package contests;

import java.awt.image.BufferedImage;

public class Prize {

	private final String name;
	private final BufferedImage image;
	private final int price;

	public Prize(String name, int price, BufferedImage image) {
		this.name = name;
		this.price = price;
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public int getPrice() {
		return this.price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.image == null ? 0 : this.image.hashCode());
		result = prime * result
				+ (this.name == null ? 0 : this.name.hashCode());
		result = prime * result + this.price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Prize other = (Prize) obj;
		if (this.image == null) {
			if (other.image != null) {
				return false;
			}
		} else if (!this.image.equals(other.image)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.price != other.price) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Prize [name=" + this.name + ", image=" + this.image
				+ ", price=" + this.price + "]";
	}

}
