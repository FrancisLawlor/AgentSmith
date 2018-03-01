package gui.utils;

public class InputValidator {
	public static boolean isValidInteger(String integer) {
		if (integer == null) {
			return false;
		}
		
		for (int i = 0; i < integer.length(); i++) {
			if (integer.charAt(i) < '0' || integer.charAt(i) > '9') {
				return false;
			}
		}
		
		int value = Integer.parseInt(integer);
		
		if (value < 0 || value > Integer.MAX_VALUE) {
			return false;
		}
		
		return true;
	}
}
