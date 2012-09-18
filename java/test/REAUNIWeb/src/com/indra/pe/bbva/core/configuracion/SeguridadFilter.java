package com.indra.pe.bbva.core.configuracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

public class SeguridadFilter implements Filter {
	
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        
        if (validarURL(httpRequest.getServletPath())) {          
            chain.doFilter(request, response);
            return;
        }
        
        SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");

        if (session == null || sessionMBean == null || sessionMBean.getRegistro() == null) {           
        	httpRequest.getSession(true).setAttribute("strMensaje", "LA SESSIÓN HA A CADUCADO");
        	httpRequest.getSession().invalidate();
			httpRequest.getRequestDispatcher("/faces/sinAcceso.xhtml").forward(httpRequest, httpResponse);	 
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    public boolean validarURL(String url) {
        List<String> listaUrls = new ArrayList<String>();
        listaUrls.add("");
        listaUrls.add("/ActionValidarAcceso.do");
        listaUrls.add("/faces/reauni-ldap.xhtml");
        listaUrls.add("/faces/sinAcceso.xhtml");
        listaUrls.add("/reauni-ldap.xhtml");
                
        if (!listaUrls.contains(url)) {
            return false;
        }
        return true;
    }
}
