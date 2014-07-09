package contests.maincontest;

import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.ImageIcon;

import contests.Contest;
import contests.Prize;

public class MainContest extends Contest {

	public MainContest(String startDate, String endDate, String name, Prize prize, BufferedImage image) {
		super(startDate, endDate, name, prize, image);
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
	public String getStart() {
		return super.getStart();
	}

	@Override
	public void setStart(String start) {
		super.setStart(start);
	}

	@Override
	public String getEnd() {
		return super.getEnd();
	}

	@Override
	public void setEnd(String end) {
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
