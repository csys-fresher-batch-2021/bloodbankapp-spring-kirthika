package in.kirthika.util;

import in.kirthika.exception.EmptyStringException;
import in.kirthika.exception.InvalidNameException;
import in.kirthika.exception.InvalidNameFormatException;

public class NameValidator {
	private NameValidator() {
		// default constructor
	}

	public static boolean isStringNotNullOrEmpty(String stringToValidate) throws EmptyStringException {

		if (stringToValidate == null || stringToValidate.trim().isEmpty()) {
			throw new EmptyStringException("Name cannot be Empty");
		}
		return true;
	}

	public static boolean invalidName(String stringToValidate) throws InvalidNameFormatException {

		if (stringToValidate.trim().matches("^[a-zA-Z]*$")) {
			return true;
		} else {
			throw new InvalidNameFormatException("Invalid name format");
		}
	}

	public static boolean isValidName(String donorName) throws InvalidNameException {
		try {
			isStringNotNullOrEmpty(donorName);
			invalidName(donorName);
			return true;
		} catch (EmptyStringException | InvalidNameFormatException e)// multi catch exception
		{
			throw new InvalidNameException(e.getMessage());
		}
	}
}
