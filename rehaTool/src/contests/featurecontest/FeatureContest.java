package contests.featurecontest;

import java.awt.image.BufferedImage;

import contests.Contest;
import contests.Prize;

public class FeatureContest extends Contest {

	public FeatureContest(String startDate, String endDate, String name,
			Prize prize, BufferedImage image) {
		super(startDate, endDate, name, prize, image);
	}

}
