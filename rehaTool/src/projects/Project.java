package projects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import user.User;
import views.TableInterface;

import comments.Comment;

import contests.Contest;

public abstract class Project extends TableInterface {

	public static long UNIQUE_ID = 0;
	private long id;

	private Date created;
	private String name;
	private User creator;
	private Contest belongsToProject;
	private List<Comment> comments;
	private BufferedImage image;
	private String content;

	public Project(String name, String content, User creator, Contest belongsToProject,
			BufferedImage image) {
		super();
		this.id = Project.UNIQUE_ID++;
		this.name = name;
		this.content = content;
		this.creator = creator;
		this.created = new Date();
		this.belongsToProject = belongsToProject;
		this.comments = new ArrayList<Comment>();
		this.image = image;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public Object[] getColumn() {
		return new Object[] { "Bild", "ID", "Projektname", "Erstellt am",
				"Eingestellt von", "Gehört zu" };
	}

	@Override
	public Object[] getRow() {
		return new Object[] { this.image, this.id, this.name, this.created,
				this.creator, this.belongsToProject };
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreator() {
		return this.creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Contest getBelongsToProject() {
		return this.belongsToProject;
	}

	public void setBelongsToProject(Contest belongsToProject) {
		this.belongsToProject = belongsToProject;
	}

	public Collection<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (this.belongsToProject == null ? 0 : this.belongsToProject
						.hashCode());
		result = prime * result
				+ (this.comments == null ? 0 : this.comments.hashCode());
		result = prime * result
				+ (this.created == null ? 0 : this.created.hashCode());
		result = prime * result
				+ (this.creator == null ? 0 : this.creator.hashCode());
		result = prime * result + (int) (this.id ^ this.id >>> 32);
		result = prime * result
				+ (this.name == null ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Project other = (Project) obj;
		if (this.belongsToProject == null) {
			if (other.belongsToProject != null) {
				return false;
			}
		} else if (!this.belongsToProject.equals(other.belongsToProject)) {
			return false;
		}
		if (this.comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!this.comments.equals(other.comments)) {
			return false;
		}
		if (this.created == null) {
			if (other.created != null) {
				return false;
			}
		} else if (!this.created.equals(other.created)) {
			return false;
		}
		if (this.creator == null) {
			if (other.creator != null) {
				return false;
			}
		} else if (!this.creator.equals(other.creator)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + this.id + ", created=" + this.created
				+ ", name=" + this.name + ", creator=" + this.creator
				+ ", belongsToProject=" + this.belongsToProject + ", comments="
				+ this.comments + "]";
	}

}
