package inputmanager;

import java.util.regex.Pattern;

public class RegEx {
	
	public static boolean pruefeEmail(String email) {
		return Pattern.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", email);
	}
	
	public static boolean pruefeVornameNachname(String name) {
		return Pattern.matches("[A-Z]{1}[a-z]+(-?|\s?)?([A-Z][a-z]+)?", name);
	}
	
	public static boolean pruefeHausnummer(String hausnummer) {
		return Pattern.matches("[1-9]{1,1}[0-9]{0,2}[a-zA-Z]?", hausnummer);
	}
	
	public static boolean pruefePasswort(String passwort) {
		return Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!@#&()–{}:;',?/*~$^+=<>]).{8,}$", passwort);
	}
	
	public static boolean pruefePostleitzahl(String passwort) {
		return Pattern.matches("[0-9]{5}$", passwort);
	}

}
