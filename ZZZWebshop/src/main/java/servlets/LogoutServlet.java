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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		try {
			Benutzer benutzer = (Benutzer) session.getAttribute("kunde"); 
			session.removeAttribute("benutzer");
			session.invalidate();
			// if (session != null) -> false!
			
		} catch (NullPointerException npe) {
			request.setAttribute("error", "Ups! Die Session ist verloren gegangen.");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
