package projects.mainproject;

import java.awt.Image;

import projects.Project;
import user.User;
import contests.Contest;

public class MainProject extends Project {

	public MainProject(String name, String content, User creator,
			Contest belongsToProject, Image image) {
		super(name, content, creator, belongsToProject, image);
	}

}
