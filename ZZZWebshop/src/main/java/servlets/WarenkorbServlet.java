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
 * Dieses Servlet fuegt einen Artiekl zum Warenkorb hinzu.
 * @author Fabian Segieth
 * Servlet implementation class WarenkorbServlet
 */
@WebServlet("/add-warenkorb")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Nach dem betaetigen des hinzufuegen Buttons wird der Artikel auf Datenbankebene in den Warenkorb gelegt.
	 * Wenn der Artikel bereits im Warenkorb ist, wird eine Benachrichtigung darueber gemacht.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
}
