package views;

import java.awt.Component;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRenderer extends DefaultTableCellRenderer {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -6500569835702497864L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Object selected = table.getValueAt(row, column);
		if (selected instanceof BufferedImage) {
			ImageIcon icon = new ImageIcon((BufferedImage) selected);
			this.setIcon(icon);
			this.setText("");
		}
		return this;
	}

}