package in.kirthika.validator;

import in.kirthika.exception.InvalidPlaceException;

public class PlaceValidator {
	private PlaceValidator() {
		// default constructor
	}

	public static boolean donorPlaceValidator(String place, String errorMessage) throws InvalidPlaceException {
		if (place == null || place.trim().isEmpty() || place.equalsIgnoreCase("Enter district")) {
			throw new InvalidPlaceException(errorMessage);
		}
		return true;
	}

}
