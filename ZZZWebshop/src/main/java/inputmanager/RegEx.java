package inputmanager;

import java.util.regex.Pattern;

/**
 * In dieser Klasse gibt es Regex-Checks, um Benutzerinput serverseitig zu
 * pruefen.
 * 
 * @author Fabian Segieth.
 *
 */
public class RegEx {

	/**
	 * Prueft Email auf richtiges Format.
	 * 
	 * @param email
	 * @return
	 */
	public static boolean pruefeEmail(String email) {
		return Pattern.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", email);
	}

	/**
	 * Prueft, ob Eingabe fuer das Muster des Vor- und Nachnamens uebereinstimmt.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean pruefeVornameNachname(String name) {
		return Pattern.matches("[A-Z]{1}[a-z]+(-?|\s?)?([A-Z][a-z]+)?", name);
	}

	/**
	 * Prueft, on die Hausnumemr dem Muster entspricht.
	 * 
	 * @param hausnummer
	 * @return
	 */
	public static boolean pruefeHausnummer(String hausnummer) {
		return Pattern.matches("[1-9]{1,1}[0-9]{0,2}[a-zA-Z]?", hausnummer);
	}

	/**
	 * Prueft ein Passwort, ob es der Vorgabe entspricht.
	 * 
	 * @param passwort
	 * @return
	 */
	public static boolean pruefePasswort(String passwort) {
		return Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!@#&()–{}:;',?/*~$^+=<>]).{8,}$", passwort);
	}

	/**
	 * Prueft, ob eine Postleitzahl aus fuenf Zahlen besteht.
	 * 
	 * @param passwort
	 * @return
	 */
	public static boolean pruefePostleitzahl(String passwort) {
		return Pattern.matches("[0-9]{5}$", passwort);
	}

}
