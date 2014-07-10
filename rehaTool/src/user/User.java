package user;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projects.Project;
import views.TableInterface;
import comments.Comment;
import contests.Contest;

public class User extends TableInterface {

	public static long UNIQUE_ID = 0;
	private final long id;
	private final String name;
	private BufferedImage image;
	private final Date registeredDate;
	private final List<Project> projectList;
	private final List<Contest> contestList;
	private final List<Comment> commentList;

	public User(String name, BufferedImage image) {
		this.id = User.UNIQUE_ID++;
		this.name = name;
		this.image = image;
		this.registeredDate = new Date();
		this.projectList = new ArrayList<Project>();
		this.contestList = new ArrayList<Contest>();
		this.commentList = new ArrayList<Comment>();
	}
	
	

	public BufferedImage getImage() {
		return this.image;
	}



	public void setImage(BufferedImage image) {
		this.image = image;
	}



	public Object[] getColumn() {
		return new Object[] { "Bild", "ID", "Name", "Beigetreten am" };
	}

	public Object[] getRow() {
		return new Object[] { this.image, this.id, this.name, this.registeredDate };
	}

	public static long getUNIQUE_ID() {
		return UNIQUE_ID;
	}

	public static void setUNIQUE_ID(long uNIQUE_ID) {
		UNIQUE_ID = uNIQUE_ID;
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Date getRegisteredDate() {
		return this.registeredDate;
	}

	public List<Project> getProjectList() {
		return this.projectList;
	}

	public List<Contest> getContestList() {
		return this.contestList;
	}

	public List<Comment> getCommentList() {
		return this.commentList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.commentList == null ? 0 : this.commentList.hashCode());
		result = prime * result
				+ (this.contestList == null ? 0 : this.contestList.hashCode());
		result = prime * result + (int) (this.id ^ this.id >>> 32);
		result = prime * result
				+ (this.name == null ? 0 : this.name.hashCode());
		result = prime * result
				+ (this.projectList == null ? 0 : this.projectList.hashCode());
		result = prime
				* result
				+ (this.registeredDate == null ? 0 : this.registeredDate
						.hashCode());
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
		User other = (User) obj;
		if (this.commentList == null) {
			if (other.commentList != null) {
				return false;
			}
		} else if (!this.commentList.equals(other.commentList)) {
			return false;
		}
		if (this.contestList == null) {
			if (other.contestList != null) {
				return false;
			}
		} else if (!this.contestList.equals(other.contestList)) {
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
		if (this.projectList == null) {
			if (other.projectList != null) {
				return false;
			}
		} else if (!this.projectList.equals(other.projectList)) {
			return false;
		}
		if (this.registeredDate == null) {
			if (other.registeredDate != null) {
				return false;
			}
		} else if (!this.registeredDate.equals(other.registeredDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name
				+ ", registeredDate=" + this.registeredDate + ", projectList="
				+ this.projectList + ", contestList=" + this.contestList
				+ ", commentList=" + this.commentList + "]";
	}

}
