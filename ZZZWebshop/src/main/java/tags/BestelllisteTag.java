package tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Benutzer;
import data.Warenkorb;
import database.WarenkorbDatabase;

/**
 * BestelllisteTag 
 * Tag visualisiert Bestellung eines Nutzers
 * 
 * @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266)
 */

public class BestelllisteTag extends SimpleTagSupport {

	/*
	 * Abfrage des aktuellen Warenkorbs aus der Datenbank und anhand dessen
	 * auflistung aller Artikel mit Name, Menge, Preis und Kategorie
	 */
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		ArrayList<Warenkorb> warenkorb = WarenkorbDatabase.getWarenkorb(benutzer.getId());
		session.setAttribute("warenkorb", warenkorb);
		double gesamtpreis = 0.00;

		/*
		 * Ausgabe der Artikel aus der Bestellung
		 */
		for (Warenkorb ware : warenkorb) {
			out.print("	<div class=\"card my-4\">"  // Erstellung Card, für jeden einezlenen Artikel
					+ "		<div class=\"card-body\">" 
					+ "			<div class=\"row\">" // Erzeugung erste Zeile
					+ "				<div class=\"col col-6\">" // Erzeugung erste Spalte, für Darstellung des Artikelnamen
					+ "					<h5 class=\"card-title\">"+ ware.getName() + "</h5>" 
					+ "				</div>" 
					+ "				<div class=\"col col-3\">" // Erzeugung zweite Spalte, für Darstellung des Artikeleinzelpreises und der Menge
					+ "					<h5 class=\"card-title\">" + ware.getMenge() + " x " + String.format("%.02f", ware.getPreis()) + " &euro;</h5>" + "				</div>" // String.format gibt Preis im gerundeten Euroformat aus
					+ "				<div class=\"col col-3\">"  // Erzeugung dritte Spalte, für Darstellung des Preises für gesmate Menge des Artikels
					+ "					<h5 class=\"card-title\">= "+ String.format("%.02f", ware.getPreis() * ware.getMenge()) + " &euro;</h5>" // String.format gibt Preis im gerundeten Euroformat aus
					+ "				</div>" 
					+ "			</div>" 
					+ "		</div>"
					+ "		<div class=\"card-footer text-muted\">Kategorie: " + ware.getKategorie() + "</div>" //Zeite Zeile, für Ausgabe der Kategorie
					+ "	</div>");
			gesamtpreis += ware.getPreis() * ware.getMenge(); // Berechnung des Gesamtpreises
		}
		out.print("<h4>Gesamtpreis: " + String.format("%.02f", gesamtpreis) + " &euro;</h4>"); // Ausgabe Gesamtpreis; String.format gibt Preis im gerundeten Euroformat aus
	}
}
