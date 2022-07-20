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

/**
 * ArtikelEinzelTag
 * TODO Beschreibung vervollständigen
 * @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266)
 */

public class ArtikelEinzelTag extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		int artikelId = Integer.parseInt(request.getParameter("artikelId"));

		 /*
	        * Ausgabe des jeweiligen Artikels
	        */
		Artikel artikel = ArtikelDatabase.getArtikel(artikelId);
		out.print("		<img src=\"assets/images/"+ artikel.getBild() + "\"" + "class=\"card-img-top card-img-produkt\" alt=\"Artikelbild\">" // Einbindung des Artikelbilds
				+ " 	<div class=\"row mx-4 mt-4\">" // Erzeugung erste Zeile
				+ "			<div class=\"col col-11 p-0\">" // Erzeugung erste Spalte
				+ "				<h5 class=\"card-title\">"+ artikel.getName() +"</h5>" // Anzeige des Artikelnames
				+ "			</div>"
				+ "			<div class=\"col col-1\">" // Erzeugung zweite Spalte
				+ "				<a href=\"add-warenkorb?id="+ artikel.getId() +"\" class=\"btn btn-dark bi bi-cart-plus-fill\" type=\"button\"></a>" // Button, damit Artikel zum Warenkorb hinzugefügt werden kann
				+ "			</div>"
				+ "			<div class=\"col col-11 p-0\">" + artikel.getBeschreibung() // Anzeige vollständige Artikelbeschreibung
				+ "			</div>"
				+ "		</div>"
				+ "		<div class=\"row m-4\">" // Erzeugung zweite Zeile
				+ "			<div class=\"col col-10 p-0\">" // Erzeugung erste Spalte
				+ "				<p class=\"card-text\">"
				+ "					<small class=\"text-muted\">Kategorie: " + "" + artikel.getKategorie() + "</small>" // Anzeige derb Artikelkategorie
				+ "				</p>"
				+ "			</div>"
				+ "			<div class=\"col col-2\">" // Erzeugung zweite Spalte
				+ "				<h5 class=\"card-title\">" + String.format("%.02f", artikel.getPreis()) + " &euro;</h5>" // Anzeige des Artikelpreises
				+ "			</div>"
				+ " 	</div>");
	}

}
