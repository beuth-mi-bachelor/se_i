package user;

import tests.CreateDummyData;

public class ActiveUser {

	public static User getCurrentUser() {
		return CreateDummyData.createRandomUser();
	}
}
