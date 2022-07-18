package tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Artikel;
import database.ArtikelDatabase;

public class ArtikelTag extends SimpleTagSupport {
	//Produkte anzeigen, wird aktuell genutzt
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		ArrayList<Artikel> artikelListe = ArtikelDatabase.getAlleArtikel();
		HttpSession session = request.getSession();          
		int cartcounter = 0;                                 
		session.setAttribute("cartCounter", cartcounter);    
		for(Artikel artikel : artikelListe) {
			System.out.println(artikel.getId());
			out.print("			<div class=\"col-sm-3 col-md-4\">\r\n"
					+ "			<div class=\"card mb-3\">\r\n"
					+ "				<img src=\"assets/images/hund1.png\"\r\n"
					+ "					class=\"card-img-top card-img-produkt\" alt=\"Hund1\">\r\n"
					+ "				<div class=\"card-body\">\r\n"
					+ "					<h5 class=\"card-title\">"+ artikel.getName() + "</h5>\r\n"
					+ "					<p class=\"card-text\">" + artikel.getBeschreibung() +"}</p>\r\n"
					+ "					<p class=\"card-text\">\r\n"
					+ "						<small class=\"text-muted\">Kategorie: "+ artikel.getKategorie() +"</small>\r\n"
					+ "					</p>\r\n"
					+ "				<div class=\"col col-1\">\r\n"
					+ "					<a href=\"artikel.jsp?artikelId="+ artikel.getId() +"\" class=\"btn btn-primary\" type=\"button\">Zum Artikel</a>\r\n"
					+ "				</div>"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "			</div>");
		}
		
	}
}

