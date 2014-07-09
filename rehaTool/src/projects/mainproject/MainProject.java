package projects.mainproject;

import projects.Project;
import user.User;
import contests.Contest;

public class MainProject extends Project {

	public MainProject(String name, User creator, Contest belongsToProject) {
		super(name, creator, belongsToProject);
	}

}
