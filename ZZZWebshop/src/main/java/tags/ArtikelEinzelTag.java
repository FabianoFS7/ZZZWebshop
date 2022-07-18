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

public class ArtikelEinzelTag extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		int artikelId = Integer.parseInt(request.getParameter("artikelId"));

				


		Artikel artikel = ArtikelDatabase.getArtikel(artikelId);
		out.print("<div class=\"row mx-4 mt-4\">\r\n"
				+ "				<div class=\"col col-11 p-0\">\r\n"
				+ "					<h5 class=\"card-title\">"+ artikel.getName() +"</h5>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"col col-1\">\r\n"
				+ "					<a href=\"add-warenkorb?id="+ artikel.getId() +"\" class=\"btn btn-dark bi bi-cart-plus-fill\" type=\"button\"></a>\r\n"
				+ "				</div>\r\n"
				+ "			</div>\r\n"
				+ "			<p class=\"card-text\">" + artikel.getBeschreibung() + "</p>\r\n"
				+ "			<div class=\"row mx-4\">\r\n"
				+ "				<div class=\"col col-10 p-0\">\r\n"
				+ "					<p class=\"card-text\">\r\n"
				+ "						<small class=\"text-muted\">Kategorie:\r\n"
				+ "							" + artikel.getKategorie() + "</small>\r\n"
				+ "					</p>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"col col-2\">\r\n"
				+ "					<h5 class=\"card-title\">" + artikel.getPreis() + "</h5>\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
	}

}
