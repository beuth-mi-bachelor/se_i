package comments;

import java.util.Date;

import user.User;

public class Comment {

	public static long UNIQUE_ID = 0;
	private long id;
	private User user;
	private String text;
	private Date creationDate;

	public Comment(User user, String text) {
		super();
		this.id = Comment.UNIQUE_ID++;
		this.user = user;
		this.text = text;
		this.creationDate = new Date();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (this.creationDate == null ? 0 : this.creationDate.hashCode());
		result = prime * result + (int) (this.id ^ this.id >>> 32);
		result = prime * result
				+ (this.text == null ? 0 : this.text.hashCode());
		result = prime * result
				+ (this.user == null ? 0 : this.user.hashCode());
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
		Comment other = (Comment) obj;
		if (this.creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!this.creationDate.equals(other.creationDate)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!this.text.equals(other.text)) {
			return false;
		}
		if (this.user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!this.user.equals(other.user)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + this.id + ", user=" + this.user + ", text="
				+ this.text + ", creationDate=" + this.creationDate + "]";
	}

}
