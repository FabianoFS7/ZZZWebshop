package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Artikel;
import database.ArtikelDatabase;
import inputmanager.EingabeValidierung;

/**
 * ArtikelVerwaltungServlet
 * Einlesen der Formulardaten und entsprechend Artikel verändern
 * 
 * @author Eve-Marie Hellmer (356925)
 */
@WebServlet("/ArtikelVerwaltungServlet")
public class ArtikelVerwaltungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Bekommt type, id, name, bild, beschreibung, kategorie und preis aus der request. 
	 * Dann wird anhand des type ein Artikel erstellt, verändert oder gelöscht
	 * geschrieben.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String bild = request.getParameter("bild");
		String beschreibung = request.getParameter("beschreibung");
		String kategorie = request.getParameter("kategorie");
		String preis = request.getParameter("preis");
		Artikel artikel = new Artikel();

		try {
			switch (type) {
			case "add":
				// Artikel wird in der Datenbank nach prüfen der Eingabeparameter erstellt
				if (!EingabeValidierung.istLeer(type) && !EingabeValidierung.istLeer(name)
						&& !EingabeValidierung.istLeer(bild)
						&& !EingabeValidierung.istLeer(beschreibung) 
						&& !EingabeValidierung.istLeer(kategorie)) {
					artikel.setName(name);
					artikel.setBild(bild);
					artikel.setBeschreibung(beschreibung);
					artikel.setKategorie(kategorie);
					artikel.setPreis(Double.parseDouble(preis));
					ArtikelDatabase.addArtikel(artikel);
				} else {
					request.setAttribute("fehler", "Eingabefehler bei der Artikelerstellung!");
				}
				break;
			case "edit":
				// Artikel wird in der Datenbank nach prüfen der Eingabeparameter verändert
				if (EingabeValidierung.istZahl(id) && !EingabeValidierung.istLeer(type)
						&& !EingabeValidierung.istLeer(bild)
						&& !EingabeValidierung.istLeer(name) 
						&& !EingabeValidierung.istLeer(beschreibung)
						&& !EingabeValidierung.istLeer(kategorie)) {
					artikel.setId(Integer.parseInt(id));
					artikel.setName(name);
					artikel.setBild(bild);
					artikel.setBeschreibung(beschreibung);
					artikel.setKategorie(kategorie);
					artikel.setPreis(Double.parseDouble(preis));
					ArtikelDatabase.updateArtikel(artikel);
				}else {
					request.setAttribute("fehler", "Eingabefehler bei der Artikeländerung");
				}
				break;
			case "delete":
				// Artikel wird in der Datenbank nach prüfen des Eingabeparameters gelöscht
				if (EingabeValidierung.istZahl(id)) {
					artikel.setId(Integer.parseInt(id));
					ArtikelDatabase.deleteArtikel(artikel);
				}else {
					request.setAttribute("fehler", "Eingabefehler bei der Artikellöschung!");
				}
				break;
			default:
				// Falls type nicht korrekt ist wird eine Fehlermeldung ausgegeben
				request.setAttribute("fehler", "Type ist nicht gesetzt!");
				break;
			}
		} catch (NullPointerException npe) {
			request.setAttribute("fehler", "Type ist nicht gesetzt!");
		} catch (Exception e) {
			request.setAttribute("fehler", "Type ist nicht gesetzt!");
		}
		request.getRequestDispatcher("artikelverwaltung.jsp").forward(request, response);
	}

}
