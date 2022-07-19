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
		
		for(Warenkorb ware : warenkorb) {	
			out.print("				<tr class=\"align-middle\">\r\n"
					+ "					<th scope=\"row\">1</th>\r\n"
					+ "					<td>" + ware.getName() + "</td>\r\n"
					+ "					<td>" + ware.getKategorie() + "</td>\r\n"
					+ "					<td>\r\n"
					+ "						<a href=artikel-Menge?methode=minus&id=" + ware.getId() + "&menge=" + ware.getMenge() + "><i class=\"bi bi-dash-square-fill\"></i></a>\r\n"
					+ "						"+ ware.getMenge() +"\r\n"
					+ "						<a href=artikel-Menge?methode=plus&id=" + ware.getId() + "&menge=" + ware.getMenge() + "><i class=\"bi bi-plus-square-fill\"></i></a>\r\n"
					+ "						</td>\r\n"
					+ "					<td>" + ware.getPreis() + "€</td>\r\n"
					+ "				</tr>");
			gesamtpreis += ware.getPreis();
		}
		session.setAttribute("gesamtpreis", gesamtpreis);
	}	
		

}
