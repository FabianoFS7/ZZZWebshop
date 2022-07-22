package tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Artikel;
import database.ArtikelDatabase;

/**
 * ArtikelTag
 * TODO Beschreibung vervollständigen
 * @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266)
 */

public class ArtikelTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		
		ArrayList<Artikel> artikelListe = ArtikelDatabase.getAlleArtikel();
		
		session.setAttribute("artikelListe", artikelListe);
		
		if (request.getAttribute("gefiltereArtikelliste") != null) {
			artikelListe = (ArrayList<Artikel>) request.getAttribute("gefiltereArtikelliste");
		}
		 /*
	        * Ausgabe der Artikelübersicht
	        */
		for(Artikel artikel : artikelListe) {
			out.print("		<div class=\"col-sm-3 col-md-4\">" // Erzeugung der Spalte
					+ "			<div class=\"card shadow mb-3\">" // Hintergrundschatten hinzufügen
					+ "				<img src=\"assets/images/"+ artikel.getBild() + "\"" // Anzeige des Artikelbilds
					+ "					class=\"card-img-top card-img-produkt\" alt=\"Artikelbild\">"
					+ "				<div class=\"card-body\">"
					+ "					<h5 class=\"card-title\">"+ artikel.getName() + "</h5>" //Anzeige des Artikelnames
					+ "					<a href=\"artikel.jsp?artikelId="+ artikel.getId() +"\" class=\"stretched-link\"></a>" // gesamte Card anklickbar machen
					+ "					<div class=\"card-text text-truncate mb-2\">" + artikel.getBeschreibung() +"}</div>" // Anzeige Artikelbeschreibung, Benutzung von text-truncate zum Kürzen der Beschreibung auf eine Zeile
					+ "					<div class=\"card-text row\">" // Erzeugung einer Zeile
					+ "						<div class=\"col col-8\">" // Erzeugung erster Spalte
					+ "							<small class=\"text-muted\">Kategorie: " + artikel.getKategorie() + "</small>" // Anzeige der Artikelkategorie
					+ "						</div>"
					+ "						<div class=\"col col-4\">" // Erzeugung zweiter Spalte
					+ "							<h5 class=\"card-title\">" + String.format("%.02f", artikel.getPreis()) + " &euro;</h5>" // Anzeige des Artikelpreises
					+ "						</div>"
					+ "					</div>"
					+ "				</div>"
					+ "			</div>"
					+ "		</div>");
		}
		
	}
}
