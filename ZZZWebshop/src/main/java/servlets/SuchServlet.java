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
