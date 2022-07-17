package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Artikel;
import data.Warenkorb;
import database.ArtikelDatabase;

public class AddWarenkorbTag extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		
		out.print("<div class=\"card my-4\" style=\"width: 34rem;\">\r\n"
				+ "	<div class=\"row\">\r\n"
				+ "		<div class=\"col\">\r\n"
				+ "			<div class=\"card-body\">\r\n"
				+ "				<h5 class=\"card-title\">Special title treatment</h5>\r\n"
				+ "			</div>\r\n"
				+ "		</div>\r\n"
				+ "		<div class=\"col my-auto col-md-3\">\r\n"
				+ "			<div class=\"btn-group btn-group-sm\" role=\"group\">\r\n"
				+ "				<button type=\"button\" class=\"btn btn-dark\">\r\n"
				+ "					<span class=\" bi bi-dash-lg\" aria-hidden=\"true\"></span>\r\n"
				+ "				</button>\r\n"
				+ "				<button type=\"button\" class=\"btn btn-dark\">\r\n"
				+ "					<span class=\" bi bi-x-lg\" aria-hidden=\"true\"></span>\r\n"
				+ "				</button>\r\n"
				+ "				<button type=\"button\" class=\"btn btn-dark\">\r\n"
				+ "					<span class=\" bi bi-plus-lg\" aria-hidden=\"true\"></span>\r\n"
				+ "				</button>\r\n"
				+ "			</div>\r\n"
				+ "		</div>\r\n"
				+ "		<div class=\"col my-auto col-md-2\">\r\n"
				+ "			<h5 class=\"card-title\">X x</h5>\r\n" 
				+ "		</div>\r\n"
				+ "	</div>\r\n"
				+ "\r\n"
				+ "</div>");
	}
	
	

}
