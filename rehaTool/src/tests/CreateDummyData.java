package tests;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import projects.Project;
import projects.featureproject.FeatureProject;
import projects.mainproject.MainProject;
import user.User;
import utils.Utilities;

import comments.Comment;

import contests.Contest;
import contests.Prize;
import contests.featurecontest.FeatureContest;
import contests.maincontest.MainContest;

public class CreateDummyData {

	public List<User> users = new ArrayList<User>();
	public List<Comment> comments = new ArrayList<Comment>();
	public List<Project> allProjects = new ArrayList<Project>();
	public List<Project> mainProjects = new ArrayList<Project>();
	public List<Project> featureProjects = new ArrayList<Project>();
	public List<Contest> allContests = new ArrayList<Contest>();
	public List<Contest> mainContests = new ArrayList<Contest>();
	public List<Contest> featureContests = new ArrayList<Contest>();

	public CreateDummyData(int items) {
		this.users = createUserDummyList(items);
		this.comments = createCommentDummyList(items, this.users);
		this.mainContests = createMainContestDummyList(items / 2);
		this.featureContests = createFeatureContestDummyList(items / 2);
		this.allContests.addAll(this.mainContests);
		this.allContests.addAll(this.featureContests);
		this.mainProjects = createMainProjectDummyList(items / 2, this.users,
				this.mainContests);
		this.featureProjects = createMainProjectDummyList(items / 2,
				this.users, this.featureContests);
		this.allProjects.addAll(this.mainProjects);
		this.allProjects.addAll(this.featureProjects);
		fillWithComments(this.comments);
	}

	@Override
	public String toString() {
		return "CreateDummyData [users=" + this.users + ", comments="
				+ this.comments + ", allProjects=" + this.allProjects
				+ ", mainProjects=" + this.mainProjects + ", featureProjects="
				+ this.featureProjects + ", allContests=" + this.allContests
				+ ", mainContests=" + this.mainContests + ", featureContests="
				+ this.featureContests + "]";
	}

	public static List<Comment> createCommentDummyList(int numberOfElements,
			List<User> userList) {
		String[] textArray = getRandomText();
		List<Comment> commentList = new ArrayList<Comment>();
		for (int i = 0; i < numberOfElements; i++) {
			User randomUser = userList.get(getRandomNumberBetween(0,
					userList.size()));
			commentList.add(new Comment(randomUser, textArray[i
					% textArray.length]));
		}
		return commentList;
	}

	public void fillWithComments(List<Comment> comments) {
		long seed = System.nanoTime();
		for (int i = 0; i < this.allProjects.size(); i++) {
			Project project = this.allProjects.get(i);
			Collections.shuffle(comments, new Random(seed));
			project.setComments(comments);
		}
		for (int i = 0; i < this.featureProjects.size(); i++) {
			Project project = this.featureProjects.get(i);
			Collections.shuffle(comments, new Random(seed));
			project.setComments(comments);
		}
		for (int i = 0; i < this.mainProjects.size(); i++) {
			Project project = this.mainProjects.get(i);
			Collections.shuffle(comments, new Random(seed));
			project.setComments(comments);
		}
	}

	public static List<Project> createFeatureProjectDummyList(
			int numberOfElements, List<User> userList, List<Contest> contestList) {
		List<Project> projectList = new ArrayList<Project>();
		for (int i = 0; i < numberOfElements; i++) {
			User randomUser = userList.get(getRandomNumberBetween(0,
					userList.size()));
			Contest randomContest = contestList.get(getRandomNumberBetween(0,
					contestList.size()));
			projectList.add(new FeatureProject("Feature Project "
					+ getRandomNumber(), getRandomText()[0], randomUser,
					randomContest, createRandomImage()));
		}
		return projectList;
	}

	public static List<Project> createMainProjectDummyList(
			int numberOfElements, List<User> userList, List<Contest> contestList) {
		List<Project> projectList = new ArrayList<Project>();
		for (int i = 0; i < numberOfElements; i++) {
			User randomUser = userList.get(getRandomNumberBetween(0,
					userList.size()));
			Contest randomContest = contestList.get(getRandomNumberBetween(0,
					contestList.size()));
			projectList.add(new MainProject(
					"Main Project " + getRandomNumber(), getRandomText()[0],
					randomUser, randomContest, createRandomImage()));
		}
		return projectList;
	}

	public static List<User> createUserDummyList(int numberOfElements) {
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < numberOfElements; i++) {
			userList.add(createRandomUser());
		}
		return userList;
	}

	public static List<Contest> createFeatureContestDummyList(
			int numberOfElements) {
		List<Contest> contestList = new ArrayList<Contest>();
		for (int i = 0; i < numberOfElements; i++) {
			contestList.add(createFeatureContest());
		}
		return contestList;
	}

	public static List<Contest> createMainContestDummyList(int numberOfElements) {
		List<Contest> contestList = new ArrayList<Contest>();
		for (int i = 0; i < numberOfElements; i++) {
			contestList.add(createMainContest());
		}
		return contestList;
	}

	public static Contest createFeatureContest() {
		return new FeatureContest(
				Utilities.dateToTextfield(getRandomDateInThePast()),
				getRandomText()[1],
				Utilities.dateToTextfield(getRandomDateInTheFuture()),
				"Feature Contest " + getRandomNumber(), createPrize(),
				createRandomImage());
	}

	public static Contest createMainContest() {
		return new MainContest(
				Utilities.dateToTextfield(getRandomDateInThePast()),
				getRandomText()[2],
				Utilities.dateToTextfield(getRandomDateInTheFuture()),
				"Main Contest " + getRandomNumber(), createPrize(),
				createRandomImage());
	}

	public static Project createMainProject() {
		return new MainProject("Main Project " + getRandomNumber(),
				getRandomText()[2], createRandomUser(), createMainContest(),
				createRandomImage());
	}

	public static Project createFeatureProject() {
		return new MainProject("Feature Project " + getRandomNumber(),
				getRandomText()[2], createRandomUser(), createFeatureContest(),
				createRandomImage());
	}

	public static Date getRandomDateInThePast() {
		Date now = new Date();
		return new Date(now.getTime() - getRandomDaysOffset());
	}

	public static Date getRandomDateInTheFuture() {
		Date now = new Date();
		return new Date(now.getTime() + getRandomDaysOffset());
	}

	public static int getRandomDaysOffset() {
		return getRandomNumberBetween(10, 50) * 24 * 60 * 60 * 1000;
	}

	public static Prize createPrize() {
		String[] randText = getRandomText();
		return new Prize("Prize " + getRandomNumber(), createRandomImage(),
				randText[getRandomNumberBetween(0, randText.length)]);
	}

	public static BufferedImage createRandomImage() {
		BufferedImage image = new BufferedImage(150, 150,
				BufferedImage.TYPE_INT_RGB);
		int r = getRandomNumberBetween(0, 255);
		int g = getRandomNumberBetween(0, 255);
		int b = getRandomNumberBetween(0, 255);
		Graphics2D g2d = image.createGraphics();
		g2d.setPaint(new Color(r, g, b));
		g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
		return image;
	}

	public static int getRandomNumber() {
		return (int) (Math.random() * 1000);
	}

	public static User createRandomUser() {
		return new User(getRandomName(), createRandomImage());
	}

	public static String[] getRandomText() {
		String[] texts = new String[] {
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
				"Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.",
				"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.",
				"Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.",
				"Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis.",
				"At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, At accusam aliquyam diam diam dolore dolores duo eirmod eos erat, et nonumy sed tempor et et invidunt justo labore Stet clita ea et gubergren, kasd magna no rebum. sanctus sea sed takimata ut vero voluptua. est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.",
				"Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus.",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
				"Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.",
				"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi." };
		return texts;
	}

	public static String getRandomName() {
		String[] names = { "Malaysia", "Papua New Guinea", "New Zealand",
				"Hong Kong", "Sri Lanka", "Indonesia", "Thailand", "Singapore",
				"Philippines", "Australia" };
		return names[CreateDummyData
				.getRandomNumberBetween(0, names.length - 1)];
	}

	public static int getRandomNumberBetween(int min, int max) {
		Random foo = new Random();
		int randomNumber = foo.nextInt(max - min) + min;
		if (randomNumber == min) {
			return min + 1;
		} else {
			return randomNumber;
		}
	}

}
