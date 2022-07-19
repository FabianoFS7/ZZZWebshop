package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Bestellung;

import java.util.ArrayList;

public class BestellungAuflisten extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession(); 
		ArrayList<Bestellung> bestellung = (ArrayList<Bestellung>) session.getAttribute("bestellung");
		
		for(Bestellung bs : bestellung) {	
			out.print("	<div class=\"card my-4\" style=\"width: 34rem;\">\r\n"
					+ "		<div class=\"row\">\r\n"
					+ "			<div class=\"col\">\r\n"
					+ "				<div class=\"card-body\">\r\n"
					+ "					<h5 class=\"card-title\">" + bs.getName() + "</h5>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"col my-auto col-md-3\">\r\n"
					+ "				<div class=\"btn-group btn-group-sm\" role=\"group\">\r\n"
					+ "					<div class=\"col my-auto col-md-2\">				\r\n"
					+ "						<h5 class=\"card-title\">"+bs.getMenge()+"</h5>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"col my-auto col-md-2\">\r\n"
					+ "				<h5 class=\"card-title\">" + bs.getPreis() + "</h5>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "		<div class=\"row\">\r\n"
					+ "			<div class=\"col\">\r\n"
					+ "				<div class=\"card-body\">\r\n"
					+ "					<p class=\"card-text\">Kategorie: " + bs.getKategorie() + "</p>\r\n"
					+ "	\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "	</div>");
		}
		
	}	
}
