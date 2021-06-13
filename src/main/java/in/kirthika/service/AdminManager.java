package in.kirthika.service;

public class AdminManager {
	private AdminManager() {
		// default constructor
	}

	public static boolean adminCheck(String userName, String userPassword) {
		boolean isValid = false;
		if (userName.equalsIgnoreCase("admin") && userPassword.equalsIgnoreCase("welcome")) {
			isValid = true;
		}
		return isValid;
	}

}
