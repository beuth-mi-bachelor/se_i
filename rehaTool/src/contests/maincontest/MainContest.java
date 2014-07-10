package contests.maincontest;

import java.awt.image.BufferedImage;

import contests.Contest;
import contests.Prize;

public class MainContest extends Contest {

	public MainContest(String startDate, String endDate, String name,
			Prize prize, BufferedImage image) {
		super(startDate, endDate, name, prize, image);
	}

}
