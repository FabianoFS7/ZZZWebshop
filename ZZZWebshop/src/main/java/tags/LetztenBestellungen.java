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

public class LetztenBestellungen extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		System.out.println("BenutzerId: " + benutzer.getId());

		ArrayList<ArrayList<Bestellung>> alleBestellungen = new ArrayList<ArrayList<Bestellung>>();
		List<Integer> bestellnummern = BestellungDatabase.getBestellnummern(benutzer.getId());
		ArrayList<Bestellung> bestellung = new ArrayList<Bestellung>();
		
		System.out.println("Bestellnummern: " + bestellnummern.toString());
		
		if (bestellnummern != null || bestellnummern.size() == 0) {
			System.out.println("Bestellungen gefunden!");
			
			for (Integer bsNr : bestellnummern) {
				bestellung = BestellungDatabase.getBestellungen(benutzer.getId(), bsNr);
				alleBestellungen.add(bestellung);
			}
			int i = 1;
			for (ArrayList<Bestellung> bestellungen : alleBestellungen) {
				double gesamtpreis = 0.00;
				for (Bestellung bs : bestellungen) {
					gesamtpreis += bs.getPreis() * bs.getMenge();
				}
				out.print("	<div class=\"accordion-item\" id=\"accordion\">"
						+ "		<h2 class=\"accordion-header\" id=\"heading_" + i + "\">"
						+ "			<button class=\"accordion-button\" type=\"button\""
						+ "				data-bs-toggle=\"collapse\" data-bs-target=\"#collapse_" + i + "\""
						+ "				aria-expanded=\"false\" aria-controls=\"collapse_" + i + "\">"
						+ "				<div class=\"row w-100\">"
						+ "					<div class=\"col-10\">Bestellung vom " + bestellungen.get(0).getBestelltAm() + "</div>"
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
		} else {
			System.out.println("keine Bestellungen!");
			out.print("<div class=\"fw-bolder\">"
					+ "		keine Bestellungen verfügbar"
					+ "</div>");
		}

		

		System.out.println(alleBestellungen.get(0).get(0).getBestelltAm());
	}

}
