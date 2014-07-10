package projects.mainproject;

import java.awt.image.BufferedImage;

import projects.Project;
import user.User;
import contests.Contest;

public class MainProject extends Project {

	public MainProject(String name, String content, User creator, Contest belongsToProject,
			BufferedImage image) {
		super(name, content, creator, belongsToProject, image);
	}

}
