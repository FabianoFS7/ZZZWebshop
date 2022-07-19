package data;

import java.util.ArrayList;

public class Warenkorb extends Artikel {
	
	private int warenkorbId;
	private int menge;

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