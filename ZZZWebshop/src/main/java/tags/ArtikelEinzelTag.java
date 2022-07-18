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
		out.print("		<img src=\"assets/images/"+ artikel.getBild() + "\""
				+ "			class=\"card-img-top card-img-produkt\" alt=\"Artikelbild\">"
				+ "<div class=\"row mx-4 mt-4\">"
				+ "				<div class=\"col col-11 p-0\">"
				+ "					<h5 class=\"card-title\">"+ artikel.getName() +"</h5>"
				+ "				</div>"
				+ "				<div class=\"col col-1\">"
				+ "					<a href=\"add-warenkorb?id="+ artikel.getId() +"\" class=\"btn btn-dark bi bi-cart-plus-fill\" type=\"button\"></a>"
				+ "				</div>"
				+ "			</div>"
				+ "			<div class=\"card-text\">" + artikel.getBeschreibung() + "</div>"
				+ "			<div class=\"row mx-4\">"
				+ "				<div class=\"col col-10\">"
				+ "					<p class=\"card-text\">"
				+ "						<small class=\"text-muted\">Kategorie:"
				+ "							" + artikel.getKategorie() + "</small>"
				+ "					</p>"
				+ "				</div>"
				+ "				<div class=\"col col-2\">"
				+ "					<h5 class=\"card-title\">" + artikel.getPreis() + "</h5>"
				+ "				</div>"
				+ "			</div>");
	}

}
