package data;

/**
 * Benutzerklasse, hier wird ein Benutzerobjekt konstruiert.
 * 
 * @author Fabian Segieth.
 *
 */
public class Benutzer {

	private int id;
	private String vorname;
	private String nachname;
	private String email;
	private String passwort;
	private String strasse;
	private String hausnummer;
	private int postleitzahl;
	private String ort;
	private boolean admin;

	/**
	 * Konstruktor fuer Benutzerobjekt mit Benutzer-Id.
	 * 
	 * @param id
	 * @param vorname
	 * @param nachname
	 * @param email
	 * @param passwort
	 * @param strasse
	 * @param hausnummer
	 * @param postleitzahl
	 * @param ort
	 * @param admin
	 */
	public Benutzer(int id, String vorname, String nachname, String email, String passwort, String strasse,
			String hausnummer, int postleitzahl, String ort, boolean admin) {
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
		this.admin = admin;
	}

	/**
	 * Konstruktor ohne Id.
	 * 
	 * @param vorname
	 * @param nachname
	 * @param email
	 * @param passwort
	 * @param strasse
	 * @param hausnummer
	 * @param postleitzahl
	 * @param ort
	 * @param admin
	 */
	public Benutzer(String vorname, String nachname, String email, String passwort, String strasse, String hausnummer,
			int postleitzahl, String ort, boolean admin) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
		this.admin = admin;
	}

	/**
	 * Default Konstruktor.
	 */
	public Benutzer() {
	}

	/**
	 * Getter fuer die Benutzer-Id.
	 * 
	 * @return id vom Benutzer.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter fuer den Vornamen.
	 * 
	 * @return Vorname vom Benutzer.
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Getter fuer den Nachnamen.
	 * 
	 * @return Vorname vom Benutzer.
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Getter fuer den vollen Namen.
	 * 
	 * @return Vor- und Nachname vom Benutzer.
	 */
	public String getFullName() {
		return vorname + " " + nachname;
	}

	/**
	 * Getter fuer die Email.
	 * 
	 * @return Email vom Benutzer.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Getter fuer das Passwort.
	 * 
	 * @return Passwort vom Benutzer.
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * Getter fuer die Strasse.
	 * 
	 * @return Strasse vom Benutzer.
	 */
	public String getStrasse() {
		return strasse;
	}

	/**
	 * Getter fuer die Hausnummer.
	 * 
	 * @return Hausnummer vom Benutzer.
	 */
	public String getHausnummer() {
		return hausnummer;
	}

	/**
	 * Getter fuer Strasse und Hausnummer.
	 * 
	 * @return Strasse und Hausnummer vom Benutzer.
	 */
	public String getFullStrasse() {
		return strasse + " " + hausnummer;
	}

	/**
	 * Getter fuer die Postleitzahl.
	 * 
	 * @return Postleitzahl vom Benutzer.
	 */
	public int getPostleitzahl() {
		return postleitzahl;
	}

	/**
	 * Getter fuer Ort.
	 * 
	 * @return Ort vom Benutzer.
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * Getter fuer Plz und Ort.
	 * 
	 * @return Plz plus Ort vom Benutzer.
	 */
	public String getFullOrt() {
		return postleitzahl + " " + ort;
	}

	/**
	 * Getter fuer Admin.
	 * 
	 * @return True, wenn Benutzer Admin ist.
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Setter fuer Benutzer-Id.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Setter fuer Benutzer Vorname.
	 * 
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Setter fuer Benutzer Nachname.
	 * 
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Setter fuer Benutzer Email.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Setter fuer Benutzer Passwort.
	 * 
	 * @param passwort
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * Setter fuer Benutzer Strasse.
	 * 
	 * @param strasse
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	/**
	 * Setter fuer Benutzer Hausnummer.
	 * 
	 * @param hausnummer
	 */
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	/**
	 * Setter fuer Benutzer Postleitzahl.
	 * 
	 * @param postleitzahl
	 */
	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	/**
	 * Setter fuer Benutzer Ort.
	 * 
	 * @param ort
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/**
	 * Setter fuer Benutzer Adminstatus.
	 * 
	 * @param admin
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}