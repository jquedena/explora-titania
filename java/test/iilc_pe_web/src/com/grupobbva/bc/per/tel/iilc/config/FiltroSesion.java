package com.grupobbva.bc.per.tel.iilc.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class FiltroSesion implements Filter {
	
	private static Logger log = Logger.getLogger(FiltroSesion.class);
    private FilterConfig config = null;

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest
    		, ServletResponse servletResponse
    		, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        String url = null;
        
        try {      	
	        url = request.getServletPath();
	        
	        if(session == null && (!url.equals("/accesoIilc.do") && !url.equals("/iilc_end2.jsp") && !url.equals("/iilc_mail.jsp"))){
	    		log.info("[FiltroSesion :: doFilter] Sesion ha terminado.");
	    		request.setAttribute("mensaje", "La sesi&oacute;n a terminado.");
	    		
	            dispatcher = request.getRequestDispatcher("iilc_error.jsp");
	            dispatcher.forward(request, response);
	        } else {
	        	if(session != null && session.getAttribute("usuario") == null && (!url.equals("/accesoIilc.do") && !url.equals("/iilc_end2.jsp") && !url.equals("/iilc_mail.jsp"))) {
	        		log.info("[FiltroSesion :: doFilter] Sesion ha terminado.");
	        		request.setAttribute("mensaje", "La sesi&oacute;n a terminado.");

	                dispatcher = request.getRequestDispatcher("iilc_error.jsp");		                
	                dispatcher.forward(request, response);
	        	} else {
	        		filterChain.doFilter(servletRequest, servletResponse);
	        	}	        		
	        }
        }catch(Exception e) {
        	log.error(e.getMessage());
    	}    
    }
    
    public String getFilterName(){
        return config.getFilterName();
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
}