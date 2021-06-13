package in.kirthika.validator;

import java.sql.SQLException;
import java.util.Map;
import in.kirthika.dao.DonorManagerDao;
import in.kirthika.exception.DonorAlreadyExist;

public class DonorValidator {

	private DonorValidator() {

	}

	public static boolean isAlreadyExist(String name, Long number, String errorMessage)
			throws DonorAlreadyExist, ClassNotFoundException, SQLException {

		boolean isValidNumber = true;
		DonorManagerDao manager = new DonorManagerDao();
		String num = String.valueOf(number);
		Map<String, String> donorCheckList = manager.donorExistCheck(num, name);

		if (donorCheckList.containsKey(num) && name.equals(donorCheckList.get(num))) {

			isValidNumber = false;

		}

		if (!isValidNumber) {
			throw new DonorAlreadyExist(errorMessage);
		}
		return isValidNumber;

	}
}
