package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import data.Warenkorb;
import database.WarenkorbDatabase;

/**
 * Servlet implementation class WarenkorbServlet
 */
@WebServlet("/add-warenkorb")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		ArrayList<Warenkorb> warenkorb = WarenkorbDatabase.getWarenkorb(benutzer.getId());
		
		boolean enthalten = false;
		if (!warenkorb.isEmpty()) {
			for (Warenkorb ware : warenkorb) {
				if (ware.getId() == id) {
					enthalten = true;
				}
			}
		}
		if (!enthalten) {
			WarenkorbDatabase.fuegeWarenkorb(benutzer.getId(), id, 1);
			request.setAttribute("erfolg", "Artikel wurde zum Warenkorb hinzugefügt.");
		} else {
			request.setAttribute("info", "Der Artikel befindet sich bereits im Warenkorb.");
		}
		request.getRequestDispatcher("artikel.jsp?artikelId=" + id).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
