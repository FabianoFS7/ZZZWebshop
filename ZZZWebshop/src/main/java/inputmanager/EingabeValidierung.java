package inputmanager;

public class EingabeValidierung {
	
	/** Prueft auf leeren String
	 * @param eingabe
	 * @return
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
	
	/** Prueft Passwortwiederholung.
	 * @param passwort
	 * @param passwortWDH
	 * @return
	 */
	public static boolean wiederholePW(String passwort, String passwortWDH) {
		return passwort.equals(passwortWDH);
	}
	
	/** Prueft, ob wirklich eine Zahl eingeben wurde.
	 * @param eingabe
	 * @return
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
