package data;

/**
 * Artikelklasse, hier wird das Artikelobjekt aufgebaut.
 * 
 * @author Fabian Segieth
 *
 */
public class Artikel {

	private int id;
	private String name;
	private double preis;
	private String beschreibung;
	private String kategorie;
	private String bild;

	/**
	 * Konstruktor fuer das Artikel objekt, ein Artikel hat folgende Atribute.
	 * 
	 * @param id           eindeutige Artikel-Id.
	 * @param name         Artikelname.
	 * @param preis        Artikelpreis.
	 * @param beschreibung Artikelbeschreibung.
	 * @param kategorie    Artikelkategorie, jeder Artikel gehoert zu einer
	 *                     bestimmten Kategorie.
	 * @param bild         String, um auf die Ressource zu gelangen.
	 */
	public Artikel(int id, String name, double preis, String beschreibung, String kategorie, String bild) {
		this.id = id;
		this.name = name;
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
		this.bild = bild;
	}

	/**
	 * Konstruktor ohne Artikel-Id, da diese innerhalb der Session nicht notwendig
	 * ist.
	 * 
	 * @param name
	 * @param preis
	 * @param beschreibung
	 * @param kategorie
	 * @param bild
	 */
	public Artikel(String name, double preis, String beschreibung, String kategorie, String bild) {
		this.name = name;
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
		this.bild = bild;
	}

	/**
	 * Defaultkonstruktor fuer Artikel.
	 */
	public Artikel() {
	}

	/**
	 * Seetter fuer Artikel-Id.
	 * 
	 * @param id entspricht Artikel-Id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Setter fuer den Artikelnamen.
	 * 
	 * @param name Artikelname.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter fuer den Artikelpreis.
	 * 
	 * @param preis Artikelpreis.
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * Setter fuer die Artikelbeschreibung.
	 * 
	 * @param beschreibung Artikelbeschreibung.
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * Setter fuer die Artikelkategorie.
	 * 
	 * @param kategorie Artikelkategorie.
	 */
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	/**
	 * Setter fuer die Bildquelle des Artikels.
	 * 
	 * @param bild Bildquelle als String.
	 */
	public void setBild(String bild) {
		this.bild = bild;
	}

	/**
	 * Getter fuer Artikel-Id.
	 * 
	 * @return Artikel-Id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter fuer Artikelname.
	 * 
	 * @return Artikelname.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter fuer Artikelpreis.
	 * 
	 * @return Artikelpreis.
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * Getter fuer Artikelbeschreibung.
	 * 
	 * @return Artikelbeschreibung.
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * Getter fuer Artikelkategorie.
	 * 
	 * @return Artikelkategorie.
	 */
	public String getKategorie() {
		return kategorie;
	}

	/**
	 * Getter fuer Artikelbild.
	 * 
	 * @return Artikelbild.
	 */
	public String getBild() {
		return bild;
	}
}