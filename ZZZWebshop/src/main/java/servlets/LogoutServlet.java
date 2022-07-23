package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;

/**
 * Hier wird der Logout vom Benutzer gemanaged.
 * 
 * @author Fabian Segieth Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Beim Aufrufen dieser Methode wird das Benutzerobjekt aus der Session
	 * geloescht und die Session invalidiert.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
			request.setAttribute("info",
					"Bis zum nächsten mal " + benutzer.getFullName() + ". Du bist nun abgemeldet.");

			session.removeAttribute("benutzer");
			session.invalidate();
		} catch (NullPointerException npe) {
			request.setAttribute("error", "Ups! Die Session ist verloren gegangen.");
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
