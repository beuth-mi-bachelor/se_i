package projects.featureproject;

import projects.Project;
import user.User;
import contests.Contest;

public class FeatureProject extends Project {

	public FeatureProject(String name, User creator, Contest belongsToProject) {
		super(name, creator, belongsToProject);
	}

}
