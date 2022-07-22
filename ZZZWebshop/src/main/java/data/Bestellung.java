package data;

/**
 * Bestellungsklasse, erbt vom Warenkorb, hat zusaetzlich eine eigene id, menge und Bestellzeitpunkt.
 * @author Fabian Segieth
 *
 */
public class Bestellung extends Warenkorb{

	private int bestellId;
	private int menge;
	private String bestelltAm;
	
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


	public int getBestellId() {
		return bestellId;
	}

	public void setBestellId(int bestellId) {
		this.bestellId = bestellId;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}


	
	
	
}