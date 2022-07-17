package data;

public class Artikel {


	private int id;
	private String name;
	private int nummer;
	private double preis;
	private String beschreibung;
	private String kategorie;
	
	public Artikel(int id, String name, int nummer, double preis, String beschreibung, String kategorie) {
		this.id = id;
		this.name = name;
		this.nummer = nummer;
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
	}
	
	public Artikel() {
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getNummer() {
		return nummer;
	}
	public double getPreis() {
		return preis;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public String getKategorie() {
		return kategorie;
	}
	
}