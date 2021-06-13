package in.kirthika.validator;

import in.kirthika.exception.InvalidAgeException;

public class AgeValidator {
	private AgeValidator() {
		// default constructor
	}

	public static boolean isEligibleDonor(int age, String errorMessage) throws InvalidAgeException {
		if (age <= 60 && age >= 18) {
			return true;
		} else {
			throw new InvalidAgeException(errorMessage);
		}
	}

}
