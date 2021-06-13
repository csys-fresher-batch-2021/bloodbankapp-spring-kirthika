package in.kirthika.util;
import in.kirthika.exception.InvalidMobileNumberException;
import in.kirthika.exception.InvalidNumberLengthException;
import in.kirthika.exception.NumberCannotBeNegativeException;
import in.kirthika.exception.IsValidStartingNumberException;

public class MobileNumberValidator {
	private MobileNumberValidator() {
		// default constructor
	}

	/**
	 * This method checks whether the length of mobile number is 10 digits
	 * 
	 * @param number
	 * @return
	 * @throws InvalidNumberLengthException
	 */
	public static boolean isNumberValidLength(Long number) throws InvalidNumberLengthException {
		int numberString = String.valueOf(number).trim().length();
		if ((numberString == 10) && number != 0) {
			return true;
		} else {
			throw new InvalidNumberLengthException("Invalid Mobile Number");
		}
	}

	public static boolean isNumberPositive(Long number) throws NumberCannotBeNegativeException {
		boolean isValidNumber = false;
		if (number != null) {
			if (number > 0) {
				isValidNumber = true;
			} else {
				throw new NumberCannotBeNegativeException("Mobile Cannot be Negative");
			}
		}
		return isValidNumber;
	}

	public static boolean isValidNumber(Long number) throws IsValidStartingNumberException {
		boolean isValidNumber = false;
		String num = String.valueOf(number);
		if (num.startsWith("6") || num.startsWith("7") || num.startsWith("8") || num.startsWith("9")) {
			isValidNumber = true;
		} else {
			throw new IsValidStartingNumberException("Invalid Mobile Number");
		}
		return isValidNumber;
	}

	/**
	 * This method checks whether a given mobile number is a 10 digit number and the
	 * number is not negative and the number is not zero.
	 * 
	 * @param mobileNumber
	 * @return
	 * @throws InvalidMobileNumberException
	 */
	public static boolean isValidMobileNumber(long mobileNumber) throws InvalidMobileNumberException {
		try {

			MobileNumberValidator.isNumberValidLength(mobileNumber);
			MobileNumberValidator.isNumberPositive(mobileNumber);
			MobileNumberValidator.isValidNumber(mobileNumber);
			return true;

		} catch (Exception e) {
			throw new InvalidMobileNumberException(e.getMessage());
		}

	}

}
