package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import database.RegistriereBenutzer;
import inputmanager.EingabeValidierung;
import inputmanager.RegEx;

/**
 * Servlet implementation class RegistrieurngsServlet
 */
@WebServlet("/RegistrierungsServlet")
public class RegistrierungsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String mail = request.getParameter("mail");
		String passwort = request.getParameter("passwort");
		String passwortWDH = request.getParameter("passwortWDH");
		String strasse = request.getParameter("strasse");
		String hausnummer = request.getParameter("hausnummer");
		String postleitzahl = request.getParameter("postleitzahl");
		String ort = request.getParameter("ort");
		String eingabeError = "";
		String weiterleitung = "registrierung.jsp";

		if (!EingabeValidierung.istLeer(vorname)) {
			request.setAttribute("reqVorname", vorname);
		}
		if (!EingabeValidierung.istLeer(nachname)) {
			request.setAttribute("reqNachname", nachname);
		}
		if (!EingabeValidierung.istLeer(mail)) {
			request.setAttribute("reqEmail", mail);
		}
		if (!EingabeValidierung.istLeer(strasse)) {
			request.setAttribute("reqStrasse", strasse);
		}
		if (!EingabeValidierung.istLeer(hausnummer)) {
			request.setAttribute("reqBank", hausnummer);
		}
		if (!EingabeValidierung.istLeer(postleitzahl)) {
			request.setAttribute("reqPLZ", postleitzahl);
		}
		if (!EingabeValidierung.istLeer(ort)) {
			request.setAttribute("reqOrt", ort);
		}

		if (!EingabeValidierung.istLeer(vorname) && !EingabeValidierung.istLeer(nachname)
				&& !EingabeValidierung.istLeer(mail) && !EingabeValidierung.istLeer(passwort)
				&& !EingabeValidierung.istLeer(passwortWDH) && !EingabeValidierung.istLeer(strasse)
				&& !EingabeValidierung.istLeer(hausnummer) && !EingabeValidierung.istLeer(postleitzahl)
				&& !EingabeValidierung.istLeer(ort)) {
			if(RegEx.pruefeEmail(mail)) {
				if(EingabeValidierung.wiederholePW(passwort, passwortWDH)) {
					if(RegEx.pruefeHausnummer(hausnummer)) {
						if(EingabeValidierung.istZahl(postleitzahl) && postleitzahl.length() > 4 &&
								postleitzahl.length() < 6) {
							System.out.println("[DEBUG] Alle Felder richtig ausgefüllt");
							HttpSession session = request.getSession();
							Benutzer benutzer = new Benutzer(vorname, nachname, mail, passwort, strasse, hausnummer, Integer.parseInt(postleitzahl), ort);
							
							try {
								if(RegistriereBenutzer.registriereBenutzer(benutzer)) {
									session.setAttribute("benutzer", benutzer);
									weiterleitung = "index.jsp";
								} else {
									eingabeError += "Benutzer existiert bereits";
								}
							} catch (NullPointerException npe) {
								
							} catch (Exception e) {
								
							}
						}
					} else {
						eingabeError += "Hausnummer entspricht nicht dem richtigen Format";
					}
				} else {
					eingabeError += "Passwörter stimmen nicht überein";
				}
			} else {
				eingabeError += "Die Email entspricht nicht der Vorgabe!";
			}

		} else {
			eingabeError += "Es wurden nicht alle Pflichtfelder ausgefüllt!";
		}


		
		
		request.setAttribute("eingabeError", eingabeError);
		request.getRequestDispatcher(weiterleitung).forward(request, response);

	}

}
