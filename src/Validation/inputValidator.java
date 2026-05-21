package Validation;

public class inputValidator {
	public static boolean validatePlate(String plate) {
    return plate.matches("[A-Z]{3}[0-9]{3}");
	    }
	}

