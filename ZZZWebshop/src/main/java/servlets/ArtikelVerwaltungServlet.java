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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/ArtikelVerwaltungServlet")
public class ArtikelVerwaltungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArtikelVerwaltungServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
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
				}
				break;
			case "edit":
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
				}
				break;
			case "delete":
				if (EingabeValidierung.istZahl(id)) {
					artikel.setId(Integer.parseInt(id));
					ArtikelDatabase.deleteArtikel(artikel);
				}
				break;
			default:
				request.setAttribute("fehler", "Type ist nicht gesetzt!");
				break;
			}
		} catch (NullPointerException npe) {
			request.setAttribute("fehler", "NullPointerException !");
		} catch (Exception e) {
			request.setAttribute("fehler", "Exception !");
		}
		request.getRequestDispatcher("artikelverwaltung.jsp").forward(request, response);
	}

}
