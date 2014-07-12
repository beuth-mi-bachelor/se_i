package projects.featureproject;

import java.awt.Image;

import projects.Project;
import user.User;
import contests.Contest;

public class FeatureProject extends Project {

	public FeatureProject(String name, String content, User creator,
			Contest belongsToProject, Image image) {
		super(name, content, creator, belongsToProject, image);
	}

}
