package data;

/**
 * Benutzerklasse, hier wird ein Benutzerobjekt konstruiert.
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
	 * Konstruktor fuer Benutzerobjekt.
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
	public Benutzer(int id, String vorname, String nachname, String email, String passwort, String strasse, String hausnummer, int postleitzahl, String ort, boolean admin) {
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
	
	public Benutzer(String vorname, String nachname, String email, String passwort, String strasse, String hausnummer, int postleitzahl, String ort, boolean admin) {
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
	
	public Benutzer () {		
	}

	public int getId() {
		return id;
	}
	public String getVorname() {
		return vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public String getFullName() {
		return vorname + " " + nachname;
	}
	public String getEmail() {
		return email;
	}
	public String getPasswort() {
		return passwort;
	}
	public String getStrasse() {
		return strasse;
	}
	public String getHausnummer() {
		return hausnummer;
	}
	public String getFullStrasse() {
		return strasse + " " + hausnummer;
	}
	public int getPostleitzahl() {
		return postleitzahl;
	}
	public String getOrt() {
		return ort;
	}
	public String getFullOrt() {
		return postleitzahl + " " + ort;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}