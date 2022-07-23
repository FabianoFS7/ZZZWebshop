package data;

/**
 * Warenkorbklasse, erbt vom Artikel und hat zusatzlich eine eigene Warenkorb.Id
 * und eine Menge.
 * 
 * @author Fabian Segieth
 *
 */
public class Warenkorb extends Artikel {

	private int warenkorbId;
	private int warenkorbNummer;
	private int menge;

	/**
	 * Defaultkonstruktor fuer den Warenkorb.
	 */
	public Warenkorb() {

	}

	/**
	 * Getter fuer Warenkorb
	 * 
	 * @return
	 */
	public int getWarenkorbId() {
		return warenkorbId;
	}

	/**
	 * Setter fuer die Warenkorb-Id.
	 * 
	 * @param warenkorbId
	 */
	public void setWarenkorbId(int warenkorbId) {
		this.warenkorbId = warenkorbId;
	}

	/**
	 * Getter fuer die Warenkorbnummer;
	 * 
	 * @return
	 */
	public int getWarenkorbNummer() {
		return warenkorbNummer;
	}

	/**
	 * Setter fuer die Warenkorbnummer.
	 * 
	 * @param warenkorbNummer
	 */
	public void setWarenkorbNummer(int warenkorbNummer) {
		this.warenkorbNummer = warenkorbNummer;
	}

	/**
	 * Getter fuer Menge eines Artikels.
	 * 
	 * @return
	 */
	public int getMenge() {
		return menge;
	}

	/**
	 * Setter fuer Menge eines Artikels.
	 * 
	 * @param menge
	 */
	public void setMenge(int menge) {
		this.menge = menge;
	}
}