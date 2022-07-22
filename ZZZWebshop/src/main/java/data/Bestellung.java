package data;

<<<<<<< HEAD
/**
 * Bestellungsklasse, erbt vom Warenkorb, hat zusaetzlich eine eigene id, menge und Bestellzeitpunkt.
 * @author Fabian Segieth
 *
 */
public class Bestellung extends Warenkorb{
=======

public class Bestellung extends Warenkorb {
>>>>>>> branch 'master' of https://github.com/FabianoFS7/ZZZWebshop.git

	private int bestellId;
	private int bestellNummer;
	private int menge;
	private String bestellDatum;
	
<<<<<<< HEAD
	/**
	 * Defaultkonstruktor fuer eine Bestellung.
	 */
	public Bestellung() {		
	}
	
	public String getBestelltAm() {
		return bestelltAm;
	}

	public void setBestelltAm(String bestelltAm) {
		this.bestelltAm = bestelltAm;
	}

=======
	public Bestellung() {
		
	}
>>>>>>> branch 'master' of https://github.com/FabianoFS7/ZZZWebshop.git

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
	
	public String getBestelltAm() {
		return bestellDatum;
	}

	public void setBestelltAm(String bestellDatum) {
		this.bestellDatum = bestellDatum;
	}
}