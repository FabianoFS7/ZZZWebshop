package data;

/**
 * Bestellungsklasse, erbt vom Warenkorb, hat zusaetzlich eine eigene id, Menge und Bestellzeitpunkt.
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

	public int getBestellId() {
		return bestellId;
	}

	public void setBestellId(int bestellId) {
		this.bestellId = bestellId;
	}
	
	public int getBestellNummer() {
		return bestellNummer;
	}

	public void setBestellNummer(int bestellNummer) {
		this.bestellNummer = bestellNummer;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public String getBestellDatum() {
		return bestellDatum;
	}

	public void setBestellDatum(String bestellDatum) {
		this.bestellDatum = bestellDatum;
	}
}