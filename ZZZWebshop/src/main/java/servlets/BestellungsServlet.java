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
import data.Bestellung;
import data.Warenkorb;
import database.BestellungDatabase;
import database.WarenkorbDatabase;

/**
 * In dieser Klasse bekommen wir Informationen ueber die Bestellung, nachdem wir den Bestellen Button
 * auf der bestelluebersich.jsp betaetigt haben.
 * Servlet implementation class BestellungsServlet
 */
@WebServlet("/BestellungsServlet")
public class BestellungsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * Der Inhalt der Warenkorbliste wird hier in eine Bestellliste kopiert, die dann in die Session gespeichert wird und bei der
	 * Rechnungsbestatigung angezeigt wird. Beim Bestellen wird au�erdem der Warenkorb des Benutzers geloescht.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String zahlungsmethode = request.getParameter("zahlungsmethode");
		HttpSession session = request.getSession();		
		@SuppressWarnings("unchecked")
		ArrayList<Warenkorb> warenkorb = (ArrayList<Warenkorb>) session.getAttribute("warenkorb");
		ArrayList<Bestellung> bestellung = new ArrayList<Bestellung>();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		int bestellid = BestellungDatabase.hoechsteBestellid(benutzer.getId()) + 1;		
		// Bestellung in die Datenbank eintragen
		for (Warenkorb ware : warenkorb) {
			Bestellung bs = new Bestellung();
			bs.setName(ware.getName());
			bs.setMenge(ware.getMenge());
			bs.setPreis(ware.getPreis());
			bs.setKategorie(ware.getKategorie());
			bestellung.add(bs);
			BestellungDatabase.fuegeBestellung(ware, zahlungsmethode, bestellid);
			WarenkorbDatabase.deletePosten(ware.getWarenkorbId(), ware.getId());
		}
		session.setAttribute("bestellung", bestellung);
		request.getRequestDispatcher("rechnung.jsp").forward(request, response);
	}

}
