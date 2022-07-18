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
			out.print("		<div class=\"col-sm-3 col-md-4\">"
					+ "			<div class=\"card shadow mb-3\">" 
					+ "				<img src=\"assets/images/"+ artikel.getBild() + "\""
					+ "					class=\"card-img-top card-img-produkt\" alt=\"Artikelbild\">"
					+ "				<div class=\"card-body\">"
					+ "					<h5 class=\"card-title\">"+ artikel.getName() + "</h5>"
					+ "					<a href=\"artikel.jsp?artikelId="+ artikel.getId() +"\" class=\"stretched-link\"></a>"
					+ "					<div class=\"card-text text-truncate mb-2\">" + artikel.getBeschreibung() +"}</div>"		
					+ "					<div class=\"card-text row\">"
					+ "						<div class=\"col col-9\">"
					+ "							<small class=\"text-muted\">Kategorie: " + artikel.getKategorie() + "</small>"
					+ "						</div>"
					+ "						<div class=\"col col-3\">"
					+ "							<h5 class=\"card-title\">" + artikel.getPreis() + " &euro;</h5>"
					+ "						</div>"
					+ "					</div>"
					+ "				</div>"
					+ "			</div>"
					+ "		</div>");
		}
		
	}
}
