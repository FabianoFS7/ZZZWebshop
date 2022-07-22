package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Artikel;
import database.ArtikelDatabase;
import inputmanager.EingabeValidierung;

/**
 * Servlet implementation class SuchServlet
 */
@WebServlet("/SuchServlet")
public class SuchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("gefiltereArtikelliste");
		request.getRequestDispatcher("artikeluebersicht.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Such- und Kategorie Parameter werden UTF-8 codiert eingelesen und in request gespeichert
		// um diese nach der eig. Suche wieder in den Input feldern anzuzeigen
		request.setCharacterEncoding("UTF-8");
		String suchfilter = request.getParameter("suchfilter");
		String suchkategorie = request.getParameter("suchkategorie");
		request.setAttribute("suchfilter", suchfilter);
		request.setAttribute("suchkategorie", suchkategorie);
		
		// alle Artikel werden aus der Session ausgelesen
		HttpSession session = request.getSession();
		ArrayList<Artikel> artikelListe = (ArrayList<Artikel>) session.getAttribute("artikelListe");
		ArrayList<Artikel> gefiltereArtikelliste = new ArrayList<Artikel>();
		
		// Artikel werden anhand der Parameter gefiltert und per request-Parameter der Artikelübersicht zur verfügung gestellt
		if (suchkategorie.equals("all")) {
			gefiltereArtikelliste = (ArrayList<Artikel>) artikelListe.stream()
				.filter(artikel -> artikel.getBeschreibung().toLowerCase().contains(suchfilter.toLowerCase())
				|| artikel.getName().toLowerCase().contains(suchfilter.toLowerCase()))
				.collect(Collectors.toList());
		} else {
			gefiltereArtikelliste = (ArrayList<Artikel>) artikelListe.stream()
					.filter(artikel -> (artikel.getBeschreibung().toLowerCase().contains(suchfilter.toLowerCase())
							|| artikel.getName().toLowerCase().contains(suchfilter.toLowerCase()))
							&& artikel.getKategorie().toLowerCase().equals(suchkategorie.toLowerCase()))
					.collect(Collectors.toList());
		}

		request.setAttribute("gefiltereArtikelliste", gefiltereArtikelliste);
		
		request.getRequestDispatcher("artikeluebersicht.jsp").forward(request, response);
	}

}
