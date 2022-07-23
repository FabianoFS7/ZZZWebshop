package data;

/**
 * Bestellungsklasse, erbt vom Warenkorb, hat zusaetzlich eine eigene id, Menge
 * und Bestellzeitpunkt.
 * 
 * @author Fabian Segieth
 *
 */

public class Bestellung extends Warenkorb {

	private int bestellId;
	private int bestellNummer;
	private int menge;
	private String bestellDatum;

	/**
	 * Defaultkonstruktor fuer eine Bestellung.
	 */
	public Bestellung() {
	}

	/**
	 * Getter fuer Bestell-Id.
	 * 
	 * @return Id einer Bestellung.
	 */
	public int getBestellId() {
		return bestellId;
	}

	/**
	 * Setter fuer Bestell-Id.
	 * 
	 * @param bestellId
	 */
	public void setBestellId(int bestellId) {
		this.bestellId = bestellId;
	}

	/**
	 * Getter fuer Bestellnummer.
	 * 
	 * @return
	 */
	public int getBestellNummer() {
		return bestellNummer;
	}

	/**
	 * Setter fuer Bestellnummer.
	 * 
	 * @param bestellNummer
	 */
	public void setBestellNummer(int bestellNummer) {
		this.bestellNummer = bestellNummer;
	}

	/**
	 * Getter fuer Menge.
	 */
	public int getMenge() {
		return menge;
	}

	/**
	 * Setter fuer Menge.
	 */
	public void setMenge(int menge) {
		this.menge = menge;
	}

	/**
	 * Getter fuer Datum der Bestellung.
	 * 
	 * @return
	 */
	public String getBestellDatum() {
		return bestellDatum;
	}

	/**
	 * Setter fuer Datum der Bestellung.
	 * 
	 * @param bestellDatum
	 */
	public void setBestellDatum(String bestellDatum) {
		this.bestellDatum = bestellDatum;
	}
}