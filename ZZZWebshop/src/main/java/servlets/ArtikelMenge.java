package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ArtikelMenge
 */
@WebServlet("/artikel-Menge")
public class ArtikelMenge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtikelMenge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methode = request.getParameter("methode");
		HttpSession session = request.getSession();
		int menge = (int) session.getAttribute("menge");
		if(methode.equals("mengePlus")) {
			session.setAttribute("menge", menge+1);
		}
		if(methode.equals("mengeMinus")) {
			session.setAttribute("menge", menge-1);
		}
		response.sendRedirect("warenkorb.jsp");
	}



}
