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

public class WarenkorbTag extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		
		ArrayList<Warenkorb> warenkorb = WarenkorbDatabase.getWarenkorb(benutzer.getId());
		session.setAttribute("warenkorb", warenkorb);
		
		double gesamtpreis = 0.00;
		int anzahl = 1;
		
		for(Warenkorb ware : warenkorb) {
			out.print("				<tr class=\"align-middle\">"
					+ "					<th scope=\"row\">" + anzahl + "</th>"
					+ "					<td>" + ware.getName() + "</td>"
					+ "					<td>" + ware.getKategorie() + "</td>"
					+ "					<td>"
					+ "						<a href=artikel-Menge?methode=minus&id=" + ware.getId() + "&menge=" + ware.getMenge() + "><i class=\"bi bi-dash-square-fill\"></i></a>"
					+ "						"+ ware.getMenge() +"\r\n"
					+ "						<a href=artikel-Menge?methode=plus&id=" + ware.getId() + "&menge=" + ware.getMenge() + "><i class=\"bi bi-plus-square-fill\"></i></a>"
					+ "					</td>"
					+ "					<td>" + String.format("%.02f", ware.getPreis()) + " €</td>"
					+ "				</tr>");
			gesamtpreis += ware.getPreis() * ware.getMenge();
			anzahl++;
		}
		out.print("<tr class=\"align-middle table-light\">"
				+ "		<td scope=\"row\" colspan=\"4\">Gesamtpreis</td>"
				+ "		<td class=\"fw-bold\">" + String.format("%.02f", gesamtpreis) + " €</td>"
				+ "</tr>");
	}	
		

}
