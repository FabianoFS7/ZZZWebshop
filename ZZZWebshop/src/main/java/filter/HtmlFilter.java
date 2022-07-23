package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Klasse wurde aus dem Learnweb uebernommen. Wird bei jeder Url aufgerufen.
 * Filtert HTML aus Benutzereingaben
 * 
 * @author Leon Schaffert
 *
 */
@WebFilter( urlPatterns={"/*"})
public class HtmlFilter extends BaseFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException 
	{
		HtmlRequestWrapper wrapper = new HtmlRequestWrapper((HttpServletRequest) req);
		chain.doFilter(wrapper, res);
	}
}

/**
 * Erweitert Funktionen des HttpServletResponseWrappers
 * 
 * @author Leon Schaffert
 *
 */
class HtmlRequestWrapper extends HttpServletRequestWrapper implements HttpServletRequest 
{
	
	/**
	 * Konstruktor
	 * 
	 * @param request
	 */
	public HtmlRequestWrapper(HttpServletRequest request) 
	{
		super(request);
	}
	
	/**
	 * 
	 * @param str
	 * @return String ohne html code
	 */
	public String getParameter(String str)
	{ 
	    return super.getParameter(str) == null ? "" : super.getParameter(str).replaceAll("<(.|\n)*?>", "");
	}
	
	
}
