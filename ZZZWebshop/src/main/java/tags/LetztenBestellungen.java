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
 * Mit diesem Tag werden die letzten Bestellungen auf der Kontoseite des Benutzers angezeigt.
 * @author Fabian Segieth
 *
 */
public class LetztenBestellungen extends SimpleTagSupport {
	
	/**
	 * Aus der Datenbank werden alle Bestellungen eines Nutzers geholt. Dann werden alle Bestellnummern einzelnen 
	 * aus der Datenbank geholt, um die Gesamtbestellungen zu ermitteln. Anhand der Bestellnummern koennen wir uns die 
	 * genauen Bestellungen mit der gleichen Bestellnummer zusammen in einer Liste abspeichern. Diese Bestellungen werden
	 * dann visuell als Art Liste fuer den Benutzer angezeigt.
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
		
		// Wurden bereits Bestellungen geteatigt? Dann alle anzeigen, ansonsten Hinweistext mit dieser Info.
		if (bestellnummern.size() != 0) {
			for (Integer bsNr : bestellnummern) {
				bestellung = BestellungDatabase.getBestellungen(benutzer.getId(), bsNr);
				alleBestellungen.add(bestellung);
			}
			// Variable zum Zählen der Bestellungen um ab dem 5ten Element die .multicollape Klasse hinzuzufügen
			int i = 1;
			// String in dem die .multicollape Klasse gespeichert wird
			String mehrAnzeigen ="";
			for (ArrayList<Bestellung> bestellungen : alleBestellungen) {
				double gesamtpreis = 0.00;
				for (Bestellung bs : bestellungen) {
					gesamtpreis += bs.getPreis() * bs.getMenge();
				}
				if (i > 5) {
					mehrAnzeigen = "collapse multi-collapse";
				}
				out.print("	<div class=\"accordion-item " + mehrAnzeigen + "\" id=\"accordion\">"
						+ "		<h2 class=\"accordion-header\" id=\"heading_" + i + "\">"
						+ "			<button class=\"accordion-button\" type=\"button\""
						+ "				data-bs-toggle=\"collapse\" data-bs-target=\"#collapse_" + i + "\""
						+ "				aria-expanded=\"false\" aria-controls=\"collapse_" + i + "\">"
						+ "				<div class=\"row w-100\">"
						+ "					<div class=\"col-10\">Bestellung vom " + bestellungen.get(0).getBestellDatum() + "</div>"
						+ "					<div class=\"col-2\">" + String.format("%.02f", gesamtpreis) + " &euro;</div>"
						+ "				</div>"
						+ " 		</button>"
						+ "		</h2>"
						+ "		<div id=\"collapse_" + i + "\" class=\"accordion-collapse collapse\""
						+ "			aria-labelledby=\"heading_\"" + i + "\" data-bs-parent=\"#accordion\">"
						+ "			<div class=\"accordion-body\">");
				
				for (Bestellung bs : bestellungen) {
					out.print("			<div class=\"card my-2\">"
							+ "				<div class=\"card-body py-2\">"
							+ "					<div class=\"row\">"
							+ "						<div class=\"col col-6\">"
							+ "							<p class=\"card-text\">" + bs.getName() + "</p>"
							+ "						</div>"
							+ "						<div class=\"col col-4\">"
							+ "							<p class=\"card-text\">" + bs.getMenge() + " x " + String.format("%.02f", bs.getPreis()) + " &euro; </p>"
							+ "						</div>"
							+ "						<div class=\"col col-2\">"
							+ "							<h6 class=\"card-title\">" + String.format("%.02f", bs.getMenge() * bs.getPreis()) + " &euro;</h6>"
							+ "						</div>"
							+ "					</div>"
							+ "				</div>"
							+ "			</div>");
				}
				out.print("			</div>"
						+ "		</div>"
						+ "	</div>");
				i++;
			}
			// Button zum Anzeigen aller Elemente mit .multicollape Klasse
			// Der Button wird dabei auch selbst ausgeblendet
			out.print(" <div class=\"btn btn-dark mt-2 collapse multi-collapse show\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\".multi-collapse\">mehr anzeigen</div>");
		} else {
			out.print("<div>"
					+ "		Es wurde noch keine Bestellung aufgegeben"
					+ "</div>");
		}
	}

}
