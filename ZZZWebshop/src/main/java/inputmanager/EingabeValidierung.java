package inputmanager;

/**
 * In dieser Klasse gibt es Methoden, zum pruefen von Eingaben des Nutzers.
 * 
 * @author Fabian Segieth
 *
 */
public class EingabeValidierung {

	/**
	 * Prueft auf leeren String
	 * 
	 * @param eingabe Zu pruefender String.
	 * @return True, wenn String leer ist. False sonst.
	 */
	public static boolean istLeer(String eingabe) {
		boolean isEmpty = false;
		try {
			if (eingabe.isEmpty()) {
				isEmpty = true;
			}
		} catch (Exception e) {
		}
		return isEmpty;
	}

	/**
	 * Prueft ob zwei Strings gleich sind.
	 * 
	 * @param passwort
	 * @param passwortWDH
	 * @return True, wenn Passwoerter uebereinstimmen, false sont.
	 */
	public static boolean wiederholePW(String passwort, String passwortWDH) {
		return passwort.equals(passwortWDH);
	}

	/**
	 * Prueft, ob es sich um eine Zahl handelt.
	 * 
	 * @param eingabe Stringeingabe des Benutzers.
	 * @return True, wenn eingabe eine Zahl ist, false sonst.
	 */
	public static boolean istZahl(String eingabe) {
		boolean isZahl = false;
		try {
			Integer.parseInt(eingabe);
			isZahl = true;
		} catch (NumberFormatException nfe) {
		}
		return isZahl;
	}
}
