package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import database.WarenkorbDatabase;

/**
 * ArtikelmengeServlet
 * Servlet aktuallisiert  Menge eines Artikels, je nach dem ob sie
 * gemindert oder vermehrt wird
 * 
 * @author Fabian Segieth (360266)
 */
@WebServlet("/artikel-Menge")
public class ArtikelmengeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Erhalt einer Methode, id und Menge aus der Request, nach dem Menge betaetigt wurde.
	 * Menge eines Artikels werden hier je nach Mehtode auf Datenbankebene angepasst. Wenn die
	 * Menge 1 ist und der Minus Button betatigt wird, wird der Artikel aus dem
	 * Warenkorb auf Datenbankebene gelöscht.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String methode = request.getParameter("methode");
		int artikelid = Integer.parseInt(request.getParameter("id"));
		int menge = Integer.parseInt(request.getParameter("menge"));
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");

		if (methode.equals("minus")) {
			if (menge == 1) {
				WarenkorbDatabase.deletePosten(benutzer.getId(), artikelid);
				request.setAttribute("info", "Artikel im Warenkorb gelöscht.");
			} else {
				request.setAttribute("info", "Artikelmenge im Warenkorb verringert.");
			}
			WarenkorbDatabase.updateMenge(menge - 1, benutzer.getId(), artikelid);
		} else if (methode.equals("plus")) {
			WarenkorbDatabase.updateMenge(menge + 1, benutzer.getId(), artikelid);
			request.setAttribute("info", "Artikelmenge im Warenkorb erhöht.");
		}
		request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
	}
}
