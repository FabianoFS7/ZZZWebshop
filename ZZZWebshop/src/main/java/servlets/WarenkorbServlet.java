package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Artikel;
import data.Warenkorb;
import database.ArtikelDatabase;

/**
 * Servlet implementation class WarenkorbServlet
 */
@WebServlet("/add-warenkorb")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(); 
	
		Artikel artikel = ArtikelDatabase.getArtikel(id);
		
		ArrayList<Warenkorb> warenkorb = (ArrayList<Warenkorb>) session.getAttribute("warenkorb");
		if(warenkorb == null) {
			warenkorb = new ArrayList<Warenkorb>();
		}
		
		warenkorb.add(new Warenkorb());
		
		
		
		
		ArrayList<Artikel> artikelListe = (ArrayList<Artikel>) session.getAttribute("artikelListe");
		if(artikelListe == null) {
			artikelListe = new ArrayList<Artikel>();
		}
		boolean enthalten = false;
		for(Artikel item : artikelListe) {
			if(item.getId() == artikel.getId()) {	
				enthalten = true;
			}
		}
		System.out.println(enthalten);
		if(!enthalten) {			
			artikelListe.add(artikel);
			int menge = 1;
			session.setAttribute("menge", menge);
		}
		int artikelAnzahl = artikelListe.size();
		double gesamtPreis = 0.00;
		for(Artikel item : artikelListe) {
			gesamtPreis += item.getPreis();
		}
		session.setAttribute("gesamtPreis", gesamtPreis);
		session.setAttribute("artikelAnzahl", artikelAnzahl);
		session.setAttribute("artikelListe", artikelListe);
		response.sendRedirect("artikel.jsp?artikelId=" + id);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
