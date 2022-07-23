package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Bestellung;

import java.util.ArrayList;

/**
 * BestellungAuflisten
 * Tag dient zur Auflistung einer Bestellung der rechnung.jsp.
 * 
 * @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266)
 */

public class BestellungAuflisten extends SimpleTagSupport {

	/*
	 * Fuer jeden Eintrag in der Bestellliste, aus der Session wird dynamisch eine Card erstellt
	 */
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Bestellung> bestellungen = (ArrayList<Bestellung>) session.getAttribute("bestellung");
		double gesamtpreis = 0.00;

		/*
		 * Ausgabe der Artikel aus der Bestellung
		 */
		for (Bestellung bestellung : bestellungen) {
			out.print("	<div class=\"card mb-3\">" // Erstellung Card, für jeden einezlenen Artikel
					+ "		<div class=\"card-body\">" 
					+ "			<div class=\"row\">" // Erzeugung erste Zeile
					+ "				<div class=\"col col-6\">"  // Erzeugung erste Spalte, für Darstellung des Artikelnamen
					+ "					<h5 class=\"card-title\">" + bestellung.getName() + "</h5>" 
					+ "				</div>"
					+ "				<div class=\"col col-3\">"  // Erzeugung zweite Spalte, für Darstellung des Artikeleinzelpreises und der Menge; String.format gibt Preis im gerundeten Euroformat aus
					+ "					<h5 class=\"card-title\">" + bestellung.getMenge() + " x " + String.format("%.02f", bestellung.getPreis()) + " &euro;</h5>"
					+ "				</div>" 
					+ "				<div class=\"col col-3\">" // Erzeugung dritte Spalte, für Darstellung des Preises für gesmate Menge des Artikels; String.format gibt Preis im gerundeten Euroformat aus
					+ "					<h5 class=\"card-title\">= " + String.format("%.02f", bestellung.getPreis() * bestellung.getMenge()) + " &euro;</h5>"
					+ "				</div>" 
					+ "			</div>"
					+ "		</div>"
					+ "		<div class=\"card-footer text-muted\">Kategorie: " + bestellung.getKategorie() + "</div>" //Zeite Zeile, für Ausgabe der Kategorie
					+ "	</div>");
			gesamtpreis += bestellung.getPreis() * bestellung.getMenge(); // Berechnung des Gesamtpreises
		}
		out.print("<h4>Gesamtpreis: " + String.format("%.02f", gesamtpreis) + " &euro;</h4>"); // Ausgabe Gesamtpreis; String.format gibt Preis im gerundeten Euroformat aus

	}
}
