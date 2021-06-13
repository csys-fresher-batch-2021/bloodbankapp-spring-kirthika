package in.kirthika.service;

import java.sql.SQLException;
import java.util.Map;

import in.kirthika.dao.UserManagerDao;
import in.kirthika.model.UserDetail;

public class UserManager {
	private UserManager() {
		// default constructor
	}

	private static UserManagerDao user = new UserManagerDao();

	public static boolean addUser(UserDetail detail) throws ClassNotFoundException, SQLException {

		return (user.addUser(detail));
	}

	public static boolean userCheck(String userName, String userPassword) {
		boolean isValid = false;
		Map<String, String> userCredentials = user.checkUserCredential(userName, userPassword);

		if (userCredentials.containsKey(userName) && userPassword.equals(userCredentials.get(userName))) {
			isValid = true;
		}
		return isValid;
	}

}
