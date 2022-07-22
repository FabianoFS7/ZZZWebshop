package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import database.LoginBenutzer;

/**
 * Bekommt Eingaben des Nutzers beim Login und ueberprueft diese.
 * @author Fabian Segieth
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Bekommt email und passwort aus der request. Dann wird anhand einer Datenbankmethode ueberprueft, ob Logindaten mit 
	 * der Datenbank uebereinstimmen. nach erfolgreichem login wird der Benutzer in die Session geschrieben.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		String passwort = request.getParameter("passwort"); 
		String weiterleitung = "login.jsp"; 
		
		HttpSession session = request.getSession(); 
		try {
			Benutzer benutzer = LoginBenutzer.loginBenutzer(email, passwort); 
				if (benutzer != null) {
					session.setAttribute("benutzer", benutzer);
					weiterleitung = "index.jsp";
					request.setAttribute("erfolg", "Willkommen zurück " + benutzer.getVorname() + ". Du bist nun angemeldet."); 
				} else {
					request.setAttribute("fehler", "Die Kombination aus E-Mail und Passwort ist nicht korrekt!"); 
				}
		} catch (NullPointerException npe) {
			request.setAttribute("fehler", "Es ist ein Fehler aufgetreten. Haben Sie sich bereits registriert?"); 
		}
		request.getRequestDispatcher(weiterleitung).forward(request, response);

	}

}
