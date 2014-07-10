package views;

public class TableDisplayItem {

	private Object[] column;
	private Object[][] rows;

	public TableDisplayItem(Object[] column, Object[][] rows) {
		super();
		this.column = column;
		this.rows = rows;
	}

	public Object[] getColumn() {
		return this.column;
	}

	public void setColumn(Object[] column) {
		this.column = column;
	}

	public Object[][] getRows() {
		return this.rows;
	}

	public void setRows(Object[][] rows) {
		this.rows = rows;
	}

}
