package data;


public class Bestellung extends Warenkorb{

	private int bestellId;
	private int menge;
	private String bestelltAm;
	
	public String getBestelltAm() {
		return bestelltAm;
	}

	public void setBestelltAm(String bestelltAm) {
		this.bestelltAm = bestelltAm;
	}

	public Bestellung() {
		
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