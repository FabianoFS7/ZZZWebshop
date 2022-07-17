package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Artikel;
import database.DatabaseConnection;

/**
 * Servlet implementation class ProduktServlet
 */
@WebServlet("/ProduktServlet")
public class ProduktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduktServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	private static Connection con = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		System.err.println("[ERROR] Test");
		
		ArrayList<Artikel> artikelArray = new ArrayList<Artikel>();

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM artikel");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Artikel artikel = new Artikel();
				artikel.setId(rs.getInt("artikelId"));
				artikel.setName(rs.getString("artikelName"));
				System.err.println("[ERROR] Name: " + rs.getString("artikelName"));
				artikel.setNummer(rs.getInt("artikelNummer"));
				artikel.setPreis(rs.getDouble("artikelPreis"));
				artikel.setBeschreibung(rs.getString("artikelBeschreibung"));
				artikel.setKategorie(rs.getString("artikelKategorie"));
				artikelArray.add(artikel);
			}
		} catch (SQLException throwables) {
		    throwables.printStackTrace();
		}
		request.setAttribute("artikelArray", artikelArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.err.println("[ERROR] Test2");
		doGet(request, response);
	}

}