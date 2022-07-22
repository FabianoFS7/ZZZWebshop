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
 * Dieses Servlet aktuallisiert die Menge einen Artikels, je nach dem ob sie gemindert oder vermehrt wird.
 * @author Fabian Segieth.
 * Servlet implementation class ArtikelmengeServlet
 */
@WebServlet("/artikel-Menge")
public class ArtikelmengeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Wir bekommen eine methode, id und menge aus der Request, nach dem wir den Plus oder Minus Button 
	 * neben der Menge betaetigt haben. Die Menge eines Artikels werden hier je nach Mehtode auf Datenbankebene
	 * angepasst. Wenn die Menge 1 ist und der Minus Button betatigt wird, wird der Artikel aus dem Warenkorb
	 * auf Datenbankebene geloescht.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			WarenkorbDatabase.updateMenge(menge-1, benutzer.getId(), artikelid);	
		} else if (methode.equals("plus")) {
			WarenkorbDatabase.updateMenge(menge+1, benutzer.getId(), artikelid);
			request.setAttribute("info", "Artikelmenge im Warenkorb erhÃ¶ht.");
		}
		request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
	}
}
