package projects;

import java.util.Collection;
import java.util.Date;

import user.User;
import comments.Comment;
import contests.Contest;

public abstract class Project {

	private long ID;

	private Date created;
	private String name;
	private User creator;
	private Contest belongsToProject;
	private Collection<Comment> comments;

}
