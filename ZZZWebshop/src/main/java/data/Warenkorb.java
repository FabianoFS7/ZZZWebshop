package data;

public class Warenkorb extends Artikel {
	
	private int warenkorbId;
	private int warenkorbNummer;
	private int menge;

	public Warenkorb() {

	}

	public int getWarenkorbId() {
		return warenkorbId;
	}

	public void setWarenkorbId(int warenkorbId) {
		this.warenkorbId = warenkorbId;
	}
	
	public int getWarenkorbNummer() {
		return warenkorbNummer;
	}

	public void setWarenkorbNummer(int warenkorbNummer) {
		this.warenkorbNummer = warenkorbNummer;
	}
	
	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
}