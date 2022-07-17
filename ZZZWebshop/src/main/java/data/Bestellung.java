package data;

import java.util.ArrayList;

public class Bestellung {

	//private int bestellungsId;
	//private int benutzerId;
	private ArrayList<ArrayList<Integer>> artikelundAnzahl;

	public Bestellung(ArrayList<ArrayList<Integer>> artikelundAnzahl) {
		this.artikelundAnzahl = artikelundAnzahl;
	}
	
}