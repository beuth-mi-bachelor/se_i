package views;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class TableView {

	private final JTable table;
	private final JScrollPane scrollpane;

	public TableView(Object[][] rows, Object[] columns) {
		this.table = new JTable(rows, columns);
		this.scrollpane = new JScrollPane(this.table);
		this.table.setAlignmentX(SwingConstants.CENTER);
		this.table.setAlignmentY(SwingConstants.CENTER);
		this.table.setFillsViewportHeight(true);
	}

	public TableView(TableDisplayItem item) {
		this.table = new JTable(item.getRows(), item.getColumn());
		this.scrollpane = new JScrollPane(this.table);
		this.table.setFillsViewportHeight(true);
	}

	public JTable getTable() {
		return this.table;
	}

	public JScrollPane getScrollpane() {
		return this.scrollpane;
	}

}
