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

/**
 * WarenkorbTag
 * In diesem tag wird der Warenkorb visualisiert.
 * @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266)
 */

public class WarenkorbTag extends SimpleTagSupport{
	
	/**
	 * Wir holen uns alle Informationen ueber den Warenkorb eines Benutzers aus der Datenbank und speichern
	 * diese in einer Liste. Danach generieren wir fuer jeden Eintrag der Liste einen Posten im Warenkorb.
	 * Dieser Warenkorb wird somit fuer den Nutzer visualisiert.
	 */
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
		
		 /*
	        * Ausgabe der Artikel im Warenkorb
	        */		
		for(Warenkorb ware : warenkorb) {
			out.print("<tr class=\"align-middle\">"
					+ "		<th scope=\"row\">" + anzahl + "</th>" // erste Spalte: Zuordnung der Zeilen mit Posten
					+ "		<td>" + ware.getName() + "</td>" // zweite Spalte: Anzeige Artikelname
					+ "		<td>" + ware.getKategorie() + "</td>" // dritte Spalte: Anzeige Artikel Kategorie
					+ "		<td>"
					+ "			<a href=artikel-Menge?methode=minus&id=" + ware.getId() + "&menge=" + ware.getMenge() + "><i class=\"bi bi-dash-square-fill\"></i></a> "
					+ 			ware.getMenge() 
					+ "			<a href=artikel-Menge?methode=plus&id=" + ware.getId() + "&menge=" + ware.getMenge() + "><i class=\"bi bi-plus-square-fill\"></i></a>"
					+ "		</td>" // vierte Spalte: Anzeige Menge inkl. Buttons zum verringern & vermehren dieser
					+ "		<td>" + String.format("%.02f", ware.getPreis()) + " €</td>" // fünfte Spalte: Anzeige Artikelpreis
					+ "	</tr>");
			 /*
		        * Berechnung & Anzeige in letzter Zeile des Gesamtpreises aus Artikelpreis & jeweiliger Menge
		        */	
			gesamtpreis += ware.getPreis() * ware.getMenge();
			anzahl++;
		}
		out.print("<tr class=\"align-middle table-light\">"
				+ "		<td scope=\"row\" colspan=\"4\">Gesamtpreis</td>"
				+ "		<td class=\"fw-bold\">" + String.format("%.02f", gesamtpreis) + " €</td>"
				+ "</tr>");
	}	
		

}
