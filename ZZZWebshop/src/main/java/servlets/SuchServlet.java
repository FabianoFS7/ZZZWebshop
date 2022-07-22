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

/**
 * Implementation der Suchfunktion auf der artikeluebersicht.jsp.
 * @author Fabian Segieth.
 * Servlet implementation class SuchServlet
 */
@WebServlet("/SuchServlet")
public class SuchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Mit dieser Methode wird der Suchfilter wieder entfernt.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("gefiltereArtikelliste");
		request.getRequestDispatcher("artikeluebersicht.jsp").forward(request, response);

	}

	/**
	 * Wir bekommen einen String als Filter. Wir ueberpruefen alle Artikelnamen sowie deren Beschreibungen auf
	 * uebereinstimmung mit der Eingabe, groﬂ und kleinschreibung wird dabei nicht beachtet. Wenn ein Artikel uebereinstimmt,
	 * wird dieser in eine Liste aufgenommen, die die gefilterten Artikel enthaelt.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String suchfilter = request.getParameter("suchfilter");
		request.setAttribute("suchfilter", suchfilter);

		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		ArrayList<Artikel> artikelListe = (ArrayList<Artikel>) session.getAttribute("artikelListe");

		ArrayList<Artikel> gefiltereArtikelliste = (ArrayList<Artikel>) artikelListe.stream()
				.filter(artikel -> artikel.getBeschreibung().toLowerCase().contains(suchfilter.toLowerCase())
						|| artikel.getName().toLowerCase().contains(suchfilter.toLowerCase()))
				.collect(Collectors.toList());

		request.setAttribute("gefiltereArtikelliste", gefiltereArtikelliste);

		request.getRequestDispatcher("artikeluebersicht.jsp").forward(request, response);
	}

}
