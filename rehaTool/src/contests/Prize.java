package contests;

import java.awt.Image;

import views.TableInterface;

public class Prize extends TableInterface {

	private final String name;
	private final String description;
	private final Image image;

	public Prize(String name, Image prizeImage, String description) {
		this.name = name;
		this.image = prizeImage;
		this.description = description;
	}

	@Override
	public Object[] getColumn() {
		return new Object[] { "Bild", "Name", "Beschreibung" };
	}

	@Override
	public Object[] getRow() {
		return new Object[] { this.image, this.name, this.description };
	}

	public String getDescription() {
		return this.description;
	}

	public String getName() {
		return this.name;
	}

	public Image getImage() {
		return this.image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.description == null ? 0 : this.description.hashCode());
		result = prime * result
				+ (this.image == null ? 0 : this.image.hashCode());
		result = prime * result
				+ (this.name == null ? 0 : this.name.hashCode());
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
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
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
		return true;
	}

	@Override
	public String toString() {
		return "Prize [name=" + this.name + ", description=" + this.description
				+ ", image=" + this.image + "]";
	}

}
