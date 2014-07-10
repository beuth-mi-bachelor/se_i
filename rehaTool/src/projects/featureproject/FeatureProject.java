package projects.featureproject;

import java.awt.image.BufferedImage;

import projects.Project;
import user.User;
import contests.Contest;

public class FeatureProject extends Project {

	public FeatureProject(String name, User creator, Contest belongsToProject,
			BufferedImage image) {
		super(name, creator, belongsToProject, image);
	}

}
