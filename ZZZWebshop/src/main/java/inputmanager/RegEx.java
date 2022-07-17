package inputmanager;

import java.util.regex.Pattern;

public class RegEx {
	
	public static boolean pruefeEmail(String email) {
		boolean erfolg = false;
		if (email.length() < 264 && Pattern.matches("[a-z|.|+|-]{3,64}@[a-z|.|+|-]+.[a-z]+", email)) {

			erfolg = true;
		}
		return erfolg;
	}
	
	public static boolean pruefeVornameNachname(String name) {
		return Pattern.matches("[A-Z]{1}[a-z]+(-?|\s?)?([A-Z][a-z]+)?", name);
	}
	
	public static boolean pruefeHausnummer(String hausnummer) {
		return Pattern.matches("[1-9]{1,1}[0-9]{0,2}[a-zA-Z]?", hausnummer);
	}

}
