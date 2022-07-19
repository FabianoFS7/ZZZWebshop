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
 * Servlet implementation class ArtikelmengeServlet
 */
@WebServlet("/artikel-Menge")
public class ArtikelmengeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methode = request.getParameter("methode");
		int artikelid = Integer.parseInt(request.getParameter("id"));
		int menge = Integer.parseInt(request.getParameter("menge"));
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		if(methode.equals("minus")) {
			if(menge == 1) {
				WarenkorbDatabase.deletePosten(benutzer.getId(), artikelid);
			}
			WarenkorbDatabase.updateMenge(menge-1, benutzer.getId(), artikelid);	
		}
		
		if(methode.equals("plus")) {
			WarenkorbDatabase.updateMenge(menge+1, benutzer.getId(), artikelid);	
		}
		response.sendRedirect("warenkorb.jsp");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
