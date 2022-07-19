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

public class BestelllisteTag extends SimpleTagSupport {
	//generiert Inhalte auf der warenkorbliste.jsp im templates ordner.
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession(); 
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		ArrayList<Warenkorb> warenkorb = WarenkorbDatabase.getWarenkorb(benutzer.getId());
		session.setAttribute("warenkorb", warenkorb);
		double gesamtpreis = 0.00;
		
		for(Warenkorb ware : warenkorb) {	
			out.print("	<div class=\"card my-4\" style=\"width: 34rem;\">"
					+ "		<div class=\"row card-body\">"
					+ "			<div class=\"col col-8\">"
					+ "				<h5 class=\"card-title\">" + ware.getName() + "</h5>"
					+ "			</div>"
					+ "			<div class=\"col col-2\">"
					+ "				<h5 class=\"card-title\">" + ware.getMenge() + " x</h5>"
					+ "			</div>"
					+ "			<div class=\"col col-2\">"
					+ "				<h5 class=\"card-title\">" + String.format("%.02f",ware.getPreis()) + " &euro;</h5>"
					+ "			</div>"
					+ "		</div>"
					+ "		<div class=\"card-footer text-muted\">Kategorie: " + ware.getKategorie() + "</div>"
					+ "	</div>");
			gesamtpreis += ware.getPreis() * ware.getMenge();
		}
		out.print("<h4>Gesamtpreis: " + String.format("%.02f", gesamtpreis) + " &euro;</h4>");
	}
}
