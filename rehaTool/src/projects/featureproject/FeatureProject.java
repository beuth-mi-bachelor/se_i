package projects.featureproject;

import java.awt.image.BufferedImage;

import projects.Project;
import user.User;
import contests.Contest;

public class FeatureProject extends Project {

	public FeatureProject(String name, String content, User creator, Contest belongsToProject,
			BufferedImage image) {
		super(name, content, creator, belongsToProject, image);
	}

}
