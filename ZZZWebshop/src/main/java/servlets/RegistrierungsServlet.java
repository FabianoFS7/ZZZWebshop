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
		
		request.setCharacterEncoding("UTF-8");

		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String mail = request.getParameter("mail");
		String passwort = request.getParameter("passwort");
		String passwortWDH = request.getParameter("passwortWDH");
		String strasse = request.getParameter("strasse");
		String hausnummer = request.getParameter("hausnummer");
		String postleitzahl = request.getParameter("postleitzahl");
		String ort = request.getParameter("ort");
		String fehler = "";
		String weiterleitung = "registrierung.jsp";

		if (!EingabeValidierung.istLeer(vorname) && !EingabeValidierung.istLeer(nachname)
				&& !EingabeValidierung.istLeer(mail) && !EingabeValidierung.istLeer(passwort)
				&& !EingabeValidierung.istLeer(passwortWDH) && !EingabeValidierung.istLeer(strasse)
				&& !EingabeValidierung.istLeer(hausnummer) && !EingabeValidierung.istLeer(postleitzahl)
				&& !EingabeValidierung.istLeer(ort)) {
			if(RegEx.pruefeEmail(mail)) {
				if(EingabeValidierung.wiederholePW(passwort, passwortWDH)) {
					if (RegEx.pruefePasswort(passwort)) {
						if(RegEx.pruefeHausnummer(hausnummer)) {
							if(EingabeValidierung.istZahl(postleitzahl) && postleitzahl.length() > 4 &&
									postleitzahl.length() < 6) {
								HttpSession session = request.getSession();
								Benutzer benutzer = new Benutzer(vorname, nachname, mail, passwort, strasse, hausnummer, Integer.parseInt(postleitzahl), ort, false);
								
								try {
									benutzer = RegistriereBenutzer.registriereBenutzer(benutzer);
									if (benutzer == null) {
										session.setAttribute("benutzer", benutzer);
										weiterleitung = "index.jsp";
										request.setAttribute("erfolg", "Du bist nun Registriert.");
									} else {
										fehler += "Benutzer existiert bereits! ";
									}
								} catch (NullPointerException npe) {
									
								} catch (Exception e) {
									
								}
							} else {
								fehler += "Postleitzahl entspricht nicht dem richtigen Format! (5 Zahlen)";
							}
						} else {
							fehler += "Hausnummer entspricht nicht dem richtigen Format! (3 Zeichen)";
						}
					} else {
						fehler += "Passwört entspricht nicht dem richtigen Format! (mind. 8 Zeichen inkl. Großbuchstabe, Kleinbuchstabe & Sonderzeichen)";
					}
					
				} else {
					fehler += "Passwörter stimmen nicht überein! ";
				}
			} else {
				fehler += "Die Email entspricht nicht der Vorgabe! ";
			}

		} else {
			fehler += "Es wurden nicht alle Pflichtfelder ausgefüllt!";
		}
		request.setAttribute("fehler", fehler);
		request.getRequestDispatcher(weiterleitung).forward(request, response);

	}

}
