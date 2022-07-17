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
import data.Warenkorb;
import database.ArtikelDatabase;

public class AddWarenkorbTag extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Artikel> artikelListe = (ArrayList<Artikel>) session.getAttribute("artikelListe");
		double gesamtpreis = 0.00;
		out.print("<h1>Warenkorb</h1>");
		if(artikelListe != null) {
			
			for(Artikel item : artikelListe) {
				out.print(item.getId() + " " + item.getName() + " Anzahl: <input type=\"number\" min=\"1\" value=\"1\"> Preis: " + item.getPreis() 
				+ " <button type=\"button\" class=\"btn btn-danger\">Remove</button><br>");
				gesamtpreis += item.getPreis();
			}
		}
		out.print("Gesamtpreis: " + gesamtpreis);
		artikelListe.get(1).getName();
	}
	
	

}