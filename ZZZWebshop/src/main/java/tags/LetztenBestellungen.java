package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Benutzer;
import data.Bestellung;
import database.BestellungDatabase;

/**
 * Letzte Bestellungen 
 * Mit diesem Tag werden die letzten Bestellungen auf der Kontoseite des
 * Benutzers angezeigt.
 * 
 * @author Fabian Segieth (360266) & Eve-Marie Hellmer (356925)
 *
 */
public class LetztenBestellungen extends SimpleTagSupport {

	/*
	 * Aus der Datenbank werden alle Bestellungen eines Nutzers und
	 * alle Bestellnummern einzelnen aus der Datenbank geholt, um die
	 * Gesamtbestellungen jenes Benutzers zu ermitteln. Anhand der Bestellnummern können
	 * die genauen Bestellungen mit der gleichen Bestellnummer zusammen in einer
	 * Liste abspeichert werden. Diese Bestellungen werden dann visuell als Akkordion für
	 * den Nutzer angezeigt.
	 */
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");

		ArrayList<ArrayList<Bestellung>> alleBestellungen = new ArrayList<ArrayList<Bestellung>>();
		List<Integer> bestellnummern = BestellungDatabase.getBestellnummern(benutzer.getId());
		ArrayList<Bestellung> bestellung = new ArrayList<Bestellung>();

		// Wurden bereits Bestellungen geteatigt? Dann alle anzeigen, ansonsten
		// Hinweistext mit Info
		if (bestellnummern.size() != 0) {
			for (Integer bsNr : bestellnummern) {
				bestellung = BestellungDatabase.getBestellungen(benutzer.getId(), bsNr);
				alleBestellungen.add(bestellung);
			}
			// Variable zum Zählen der Bestellungen um ab dem 5ten Element die
			// .multicollapse Klasse hinzuzufügen, damit gemäß Spezifikation zuerst nur 5 Bestellungen angezeigt werden
			int i = 1;
			// String in dem die .multicollapse Klasse gespeichert wird
			String mehrAnzeigen = "";
			
			/*
			 * Auflistung aller Bestellungen zu jenem Konto
			 */
			for (ArrayList<Bestellung> bestellungen : alleBestellungen) {
				double gesamtpreis = 0.00;
				for (Bestellung bs : bestellungen) {
					gesamtpreis += bs.getPreis() * bs.getMenge();
				}
				if (i > 5) {
					mehrAnzeigen = "collapse multi-collapse";
				}
				/*
				 * Ausgabe der Besellung
				 */
				out.print("	<div class=\"accordion-item " + mehrAnzeigen + "\" id=\"accordion\">" // Element des Accordions
						+ "		<h2 class=\"accordion-header\" id=\"heading_" + i + "\">" // Überschrift mit Datum und Gesamtpreis der Bestellung, für mehr Übersichtlichkeit
						+ "			<button class=\"accordion-button\" type=\"button\""
						+ "				data-bs-toggle=\"collapse\" data-bs-target=\"#collapse_" + i + "\""
						+ "				aria-expanded=\"false\" aria-controls=\"collapse_" + i + "\">"
						+ "				<div class=\"row w-100\">"
						+ "					<div class=\"col-10\">Bestellung vom "
						+ bestellungen.get(0).getBestellDatum() + "</div>" + "					<div class=\"col-2\">"
						+ String.format("%.02f", gesamtpreis) + " &euro;</div>" + "				</div>" // String.format gibt Preis im gerundeten Euroformat aus
						+ " 		</button>" + "		</h2>" + "		<div id=\"collapse_" + i
						+ "\" class=\"accordion-collapse collapse\"" + "			aria-labelledby=\"heading_\"" + i
						+ "\" data-bs-parent=\"#accordion\">" + "			<div class=\"accordion-body\">");
				/*
				 * Ausgabe des Inhalts der Besellung
				 */
				for (Bestellung bs : bestellungen) {
					out.print("			<div class=\"card my-2\">" + "				<div class=\"card-body py-2\">" //Inhalt eines Elements, Artikel aus der Bestellung
							+ "					<div class=\"row\">" // Erzuegung Zeile, zur kompakten Darstellung
							+ "						<div class=\"col col-6\">" // Erzeugung erste Spalte, zur Darstellung des Artikelnames
							+ "							<p class=\"card-text\">" + bs.getName() + "</p>"
							+ "						</div>" + "						<div class=\"col col-4\">" // Erzeugung zweite Spalte, zur Darstellung der gekauften Menge
							+ "							<p class=\"card-text\">" + bs.getMenge() + " x "
							+ String.format("%.02f", bs.getPreis()) + " &euro; </p>" + "						</div>" // String.format gibt Preis im gerundeten Euroformat aus
							+ "						<div class=\"col col-2\">" // Erzeugung dritte Spalte, zur Darstellung des Preises
							+ "							<h6 class=\"card-title\">"
							+ String.format("%.02f", bs.getMenge() * bs.getPreis()) + " &euro;</h6>" // String.format gibt Preis im gerundeten Euroformat aus
							+ "						</div>" + "					</div>" + "				</div>"
							+ "			</div>");
				}
				out.print("			</div>" + "		</div>" + "	</div>");
				i++;
			}
			// Button zum Anzeigen aller Elemente mit .multicollapse Klasse
			// Der Button wird dabei auch selbst ausgeblendet
			out.print(
					" <div class=\"btn btn-dark mt-2 collapse multi-collapse show\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\".multi-collapse\">mehr anzeigen</div>");
		} else {
			out.print("<div>" + "		Es wurde noch keine Bestellung aufgegeben" + "</div>");
		}
	}

}
