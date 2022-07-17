package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Artikel;
import data.Warenkorb;
import database.ArtikelDatabase;

/**
 * Servlet implementation class WarenkorbServlet
 */
@WebServlet("/add-warenkorb")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(); 

		Artikel artikel = ArtikelDatabase.getArtikel(id);
		Warenkorb warenkorb = new Warenkorb(artikel);
		session.setAttribute("warenkorb", warenkorb);
		System.out.println(artikel.getName());
		int cartCounter = (int) session.getAttribute("cartCounter");		
		session.setAttribute("cartCounter", cartCounter+1);
		System.out.println(cartCounter);
		response.sendRedirect("artikel.jsp?artikelId=" + id);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
