package contests;

import java.util.Date;

import win.WinItem;

public abstract class Contest {

	private long ID;

	private Date start;
	private Date end;

	private String name;
	private WinItem winItem;

	public long getID() {
		return this.ID;
	}

	public void setID(long iD) {
		this.ID = iD;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return this.end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WinItem getWinItem() {
		return this.winItem;
	}

	public void setWinItem(WinItem winItem) {
		this.winItem = winItem;
	}

}
