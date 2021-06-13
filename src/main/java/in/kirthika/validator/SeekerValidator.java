package in.kirthika.validator;

import java.sql.SQLException;

import java.util.HashMap;

import java.util.Map;

import in.kirthika.dao.SeekerManagerDao;
import in.kirthika.exception.NotRegisteredException;

public class SeekerValidator {

	static Map<Long, String> numberList = new HashMap<>();

	private SeekerValidator() {

	}

	public static boolean seekerNumberValidator(Long number, String name, String errorMessage)
			throws NotRegisteredException, ClassNotFoundException, SQLException {

		boolean isValidNumber = false;
		SeekerManagerDao manager = new SeekerManagerDao();
		String num = String.valueOf(number);
		Map<String, String> numberList = manager.seekerNumber(number, name);

		if (numberList.containsKey(num) && name.equals(numberList.get(num))) {
			isValidNumber = true;

		}

		if (!isValidNumber) {
			throw new NotRegisteredException(errorMessage);
		}
		return isValidNumber;

	}
}
