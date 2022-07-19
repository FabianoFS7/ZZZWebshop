package tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Artikel;
import database.ArtikelDatabase;

public class ArtikelVerwaltung extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		ArrayList<Artikel> artikelListe = ArtikelDatabase.getAlleArtikel();	
		
		for(Artikel artikel : artikelListe) {
			out.print("		<tr class=\"align-middle artikel_eintrag\""
					+ "			data-id=\"" + artikel.getId() + "\""
					+ "			data-name=\"" + artikel.getName() + "\""
					+ "			data-bild=\"" + artikel.getBild() + "\""
					+ "			data-beschreibung=\"" + artikel.getBeschreibung() + "\""
					+ "			data-kategorie=\"" + artikel.getKategorie() + "\""
					+ "			data-preis=\"" + artikel.getPreis() + "\">"
					+ "			<th scope=\"row\">" + artikel.getId() + "</th>"
					+ "			<td class=\"artikel_name\">" + artikel.getName() + "</td>"
					+ "			<td class=\"artikel_bild\"><img src=\"assets/images/" + artikel.getBild() + "\" "
					+ "			class=\"d-block h-100 w-100\"alt=\"Artikelbild\"</td>"
					+ "			<td class=\"artikel_beschreibung\">" + artikel.getBeschreibung() + "</td>"
					+ "			<td class=\"artikel_kategorie\">" + artikel.getKategorie() + "</td>"
					+ "			<td class=\"artikel_preis\">" + String.format("%.02f", artikel.getPreis()) + " &euro;</td>"
					+ "		</tr>");
		}
	}
}