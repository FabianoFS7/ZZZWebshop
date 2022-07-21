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
 * BestellungAuflisten.java
 * TODO Beschreibung vervollständigen
 * @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266)
 */

public class BestellungAuflisten extends SimpleTagSupport{
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
		for(Bestellung bestellung : bestellungen) {	
			out.print("	<div class=\"card my-4\" style=\"width: 34rem;\">"
					+ "		<div class=\"row\">"
					+ "			<div class=\"col\">"
					+ "				<div class=\"card-body\">"
					+ "					<h5 class=\"card-title\">" + bestellung.getName() + "</h5>"
					+ "				</div>"
					+ "			</div>"
					+ "			<div class=\"col my-auto col-md-3\">"
					+ "				<div class=\"btn-group btn-group-sm\" role=\"group\">"
					+ "					<h5 class=\"card-title\">" + bestellung.getMenge() + "x</h5>"
					+ "				</div>"
					+ "			</div>"
					+ "			<div class=\"col my-auto col-md-2\">"
					+ "				<h5 class=\"card-title\">" + bestellung.getPreis() + "</h5>"
					+ "			</div>"
					+ "		</div>"
					+ "		<div class=\"row\">"
					+ "			<div class=\"col\">"
					+ "				<div class=\"card-body\">"
					+ "					<p class=\"card-text\">Kategorie: " + bestellung.getKategorie() + "</p>"
					+ "				</div>"
					+ "			</div>"
					+ "		</div>"
					+ "	</div>");
			gesamtpreis += bestellung.getPreis() * bestellung.getMenge();
		}
		out.print("<h4>Gesamtpreis: " + String.format("%.02f", gesamtpreis) + " &euro;</h4>");

	}	
}
