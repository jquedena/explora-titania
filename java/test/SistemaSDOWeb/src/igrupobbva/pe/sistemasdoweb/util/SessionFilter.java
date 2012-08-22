package igrupobbva.pe.sistemasdoweb.util;

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

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

public class SessionFilter implements Filter {
	private static Logger log = Logger.getLogger(SessionFilter.class);
    private FilterConfig config = null;

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
                    throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        String servletPedido = null;
        
        try {
        	log.info("[SessionFilter :: doFilter] Inicio");
        	
	        servletPedido = request.getServletPath();
	        
	        if(session == null && (!servletPedido.equals("/logueoAction.do") && !servletPedido.equals("/accesoAction.do"))){
	        		log.info("[SessionFilter :: doFilter] Sesion ha terminado");
	                
	                request.setAttribute("mensajeSesionTermino", ConstantesUtil.MENSAJE_ERROR_SESION_TERMINO);
	                dispatcher = request.getRequestDispatcher("errorSesionTermino.jsp");                
	                
	                dispatcher.forward(request, response);
	        } else {
		        	if(session != null && session.getAttribute("gestor") == null && (!servletPedido.equals("/logueoAction.do") && !servletPedido.equals("/accesoAction.do"))) {
		        		log.info("[SessionFilter :: doFilter] Sesion ha terminado");
		        		
		                request.setAttribute("mensajeSesionTermino", ConstantesUtil.MENSAJE_ERROR_SESION_TERMINO);
		                dispatcher = request.getRequestDispatcher("errorSesionTermino.jsp");                
		                
		                dispatcher.forward(request, response);
		        	} else { 
		        		filterChain.doFilter(servletRequest, servletResponse);
		        	}		        		
	        }
	        
	        log.info("[SessionFilter :: doFilter] Fin");
        }catch(Exception e) {
        	log.error("[SessionFilter :: doFilter] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
    	}    
    }
    
    public String getFilterName(){
        return config.getFilterName();
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
}

