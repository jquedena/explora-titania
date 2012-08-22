package indra.bbva.pizele.filter;


import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.common.Resultado;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class SeguridadFilter implements javax.servlet.Filter
{

	private String URL_LOGIN = "loginAction.do";
	private String URL_LOGOUT = "cerrarSesion.do";
	
	public void destroy() 
	{
		// TODO	
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException 
	{
				
		HttpServletRequest httpRequest = (HttpServletRequest)req; 
		HttpServletResponse httpResponse = (HttpServletResponse)resp; 
		
		
		String url = httpRequest.getRequestURI();
		
		if(url.indexOf(URL_LOGIN) != -1 && url.substring(url.length() - URL_LOGIN.length(),url.length()).equals(URL_LOGIN))
		{
			chain.doFilter(req, resp);						
		}
		else if(url.indexOf(URL_LOGOUT) != -1 && url.substring(url.length() - URL_LOGOUT.length(),url.length()).equals(URL_LOGOUT))
		{						
			httpRequest.getSession().invalidate();
			httpRequest.getRequestDispatcher("/common/log-out.jsp").forward(req, resp);			
		}
		else
		{
			if(httpRequest.getSession().getAttribute(Constantes.Sesion.CURRENT_USER) != null)
				chain.doFilter(req, resp);
			else
			{
				httpRequest.getRequestDispatcher("/common/log-out.jsp").forward(req, resp);
			}
							
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException 
	{
		// TODO Auto-generated method stub		
	}

}
