package data;


public class Bestellung extends Artikel{

	private int bestellId;
	private int menge;
	private String bestelldatum;
	
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

	public String getBestelldatum() {
		return bestelldatum;
	}

	public void setBestelldatum(String bestelldatum) {
		this.bestelldatum = bestelldatum;
	}
	
	
	
}