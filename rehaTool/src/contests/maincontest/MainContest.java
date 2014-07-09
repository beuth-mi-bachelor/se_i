package contests.maincontest;

import java.util.Date;

import contests.Contest;
import contests.Prize;

public class MainContest extends Contest {

	public MainContest(Date startDate, Date endDate, String name, Prize prize) {
		super(startDate, endDate, name, prize);
	}

	@Override
	public long getID() {
		return super.getID();
	}

	@Override
	public void setID(long iD) {
		super.setID(iD);
	}

	@Override
	public Date getStart() {
		return super.getStart();
	}

	@Override
	public void setStart(Date start) {
		super.setStart(start);
	}

	@Override
	public Date getEnd() {
		return super.getEnd();
	}

	@Override
	public void setEnd(Date end) {
		super.setEnd(end);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public Prize getWinItem() {
		return super.getWinItem();
	}

	@Override
	public void setWinItem(Prize winItem) {
		super.setWinItem(winItem);
	}

}
