package data;

public class Artikel {


	private int id;
	private String name;
	private double preis;
	private String beschreibung;
	private String kategorie;
	private String bild;
	
	public Artikel(int id, String name, double preis, String beschreibung, String kategorie, String bild) {
		this.id = id;
		this.name = name;
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
		this.bild = bild;
	}
	
	public Artikel(String name, double preis, String beschreibung, String kategorie, String bild) {
		this.name = name;
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
		this.bild = bild;
	}
	
	public Artikel() {
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setBild(String bild) {
		this.bild = bild;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
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
	public String getBild() {
		return bild;
	}
}