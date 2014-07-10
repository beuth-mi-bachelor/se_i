package contests;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projects.Project;
import views.TableInterface;

public abstract class Contest extends TableInterface {

	public static long UNIQUE_ID = 0;

	private long id;
	private String startDate;
	private String endDate;
	private final Date createdDate;
	private String name;
	private Prize prize;
	private BufferedImage image;
	private List<Project> participants;

	public Contest(String startDate, String endDate, String name, Prize prize,
			BufferedImage image) {
		this.id = Contest.UNIQUE_ID++;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdDate = new Date();
		this.name = name;
		this.prize = prize;
		this.image = image;
		this.participants = new ArrayList<Project>();
	}

	@Override
	public Object[] getColumn() {
		return new Object[] { "Bild", "ID", "Projektname", "Startdatum",
				"Enddatum", "Erstellt am", "Prize", "Eingereichte Projekte" };
	}

	@Override
	public Object[] getRow() {
		return new Object[] { this.image, this.id, this.name, this.startDate,
				this.endDate, this.createdDate, this.prize.getName(),
				this.listAllParticipants() };
	}

	private String listAllParticipants() {
		String projects = "";
		for (Project participant : participants) {
			projects += participant.getName();
		}
		return projects;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public List<Project> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Project> participants) {
		this.participants = participants;
	}

	public long getID() {
		return this.id;
	}

	public void setID(long iD) {
		this.id = iD;
	}

	public String getStart() {
		return this.startDate;
	}

	public void setStart(String start) {
		this.startDate = start;
	}

	public String getEnd() {
		return this.endDate;
	}

	public void setEnd(String end) {
		this.endDate = end;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Prize getWinItem() {
		return this.prize;
	}

	public void setWinItem(Prize winItem) {
		this.prize = winItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.createdDate == null ? 0 : this.createdDate.hashCode());
		result = prime * result
				+ (this.endDate == null ? 0 : this.endDate.hashCode());
		result = prime * result + (int) (this.id ^ this.id >>> 32);
		result = prime * result
				+ (this.name == null ? 0 : this.name.hashCode());
		result = prime
				* result
				+ (this.participants == null ? 0 : this.participants.hashCode());
		result = prime * result
				+ (this.prize == null ? 0 : this.prize.hashCode());
		result = prime * result
				+ (this.startDate == null ? 0 : this.startDate.hashCode());
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
		Contest other = (Contest) obj;
		if (this.createdDate == null) {
			if (other.createdDate != null) {
				return false;
			}
		} else if (!this.createdDate.equals(other.createdDate)) {
			return false;
		}
		if (this.endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!this.endDate.equals(other.endDate)) {
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
		if (this.participants == null) {
			if (other.participants != null) {
				return false;
			}
		} else if (!this.participants.equals(other.participants)) {
			return false;
		}
		if (this.prize == null) {
			if (other.prize != null) {
				return false;
			}
		} else if (!this.prize.equals(other.prize)) {
			return false;
		}
		if (this.startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!this.startDate.equals(other.startDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Contest [id=" + this.id + ", startDate=" + this.startDate
				+ ", endDate=" + this.endDate + ", createdDate="
				+ this.createdDate + ", name=" + this.name + ", prize="
				+ this.prize + ", participants=" + this.participants + "]";
	}

}
