package data;

/**
 * Warenkorbklasse, erbt vom Artikel und hat zusatzlich eine eigene Warenkorb.Id und eine Menge. 
 * @author Fabian Segieth
 *
 */
public class Warenkorb extends Artikel {
	
	private int warenkorbId;
	private int menge;

	/**
	 * Defaultkonstruktor fuer den Warenkorb.
	 */
	public Warenkorb() {

	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public int getWarenkorbId() {
		return warenkorbId;
	}

	public void setWarenkorbId(int warenkorbId) {
		this.warenkorbId = warenkorbId;
	}

	
}