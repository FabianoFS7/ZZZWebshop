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
			out.print("	<div class=\"card my-4\" style=\"width: 34rem;\">\r\n"
					+ "		<div class=\"row\">\r\n"
					+ "			<div class=\"col\">\r\n"
					+ "				<div class=\"card-body\">\r\n"
					+ "					<h5 class=\"card-title\">" + ware.getName() + "</h5>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"col my-auto col-md-3\">\r\n"
					+ "				<div class=\"btn-group btn-group-sm\" role=\"group\">\r\n"
					+ "\r\n"
					+ "					\r\n"
					+ "					<a href=bestell-Menge?methode=minus&id=" + ware.getId() + "&menge=" + ware.getMenge() + ">-</a>\r\n"
					+ "					\r\n"
					+ "					<div class=\"col my-auto col-md-2\">				\r\n"
					+ "						<h5 class=\"card-title\">"+ware.getMenge()+"</h5>\r\n"
					+ "					</div>\r\n"
					+ "					\r\n"
					+ "					<a href=bestell-Menge?methode=plus&id=" + ware.getId() + "&menge=" + ware.getMenge() + ">+</a>\r\n"
					+ "					\r\n"
					+ "\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"col my-auto col-md-2\">\r\n"
					+ "				<h5 class=\"card-title\">" + ware.getPreis() + "</h5>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "		<div class=\"row\">\r\n"
					+ "			<div class=\"col\">\r\n"
					+ "				<div class=\"card-body\">\r\n"
					+ "					<p class=\"card-text\">Kategorie: " + ware.getKategorie() + "</p>\r\n"
					+ "	\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "	</div>");
			gesamtpreis += ware.getPreis();
		}
		session.setAttribute("gesamtpreis", gesamtpreis);
	}

}
