package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Warenkorb;
import database.BestellungDatabase;
import database.WarenkorbDatabase;

/**
 * Servlet implementation class BestellungsServlet
 */
@WebServlet("/BestellungsServlet")
public class BestellungsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zahlungsmethode = request.getParameter("zahlunngsmethode");
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<Warenkorb> warenkorb = (ArrayList<Warenkorb>) session.getAttribute("warenkorb");

		//Bestellung in die Datenbank eintragen
		for(Warenkorb ware : warenkorb) {
			BestellungDatabase.fuegeBestellung(ware, zahlungsmethode);
			WarenkorbDatabase.deletePosten(ware.getWarenkorbId(), ware.getId());
		}
		
		request.getRequestDispatcher("rechnung.jsp").forward(request, response);

		
	}

}
