package contests.featurecontest;

import java.awt.Image;

import contests.Contest;
import contests.Prize;

public class FeatureContest extends Contest {

	public FeatureContest(String startDate, String description, String endDate,
			String name, Prize prize, Image image) {
		super(startDate, description, endDate, name, prize, image);
	}

}
