package com.indra.pe.bbva.core.ldap.acceso;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;
import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;
 
@SuppressWarnings("unused")
public class ActionValidarAcceso extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID = 2692392374210259330L;
	
	private static Logger logger = Logger.getLogger(ActionValidarAcceso.class);
	
	@Autowired
	private ParametroBO parametroBo;


    public ActionValidarAcceso() {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	logger.info("Sistema CRON Reasignacion-Unificacion - Validando Ingreso");
	response.setCharacterEncoding("ISO-8859-1");
        IILDPeUsuario iildPeUsuario = null;
        ServiciosSeguridadBbva objSeguridad = null;
        String reg = "";
        String msg = "Usted no tiene acceso al sistema!";
        try {
            
            objSeguridad = new ServiciosSeguridadBbva(request);
            objSeguridad.obtener_ID();
            reg = objSeguridad.getUsuario().toUpperCase();
            iildPeUsuario = IILDPeUsuario.recuperarUsuario(reg);
            if(iildPeUsuario != null){
            	
            	SessionMBean sessionMBean = (SessionMBean)WebServletContextListener.getApplicationContext().getBean("sessionMBean");
            	sessionMBean.setNombresApellidos(iildPeUsuario.getApellido1() + " " + iildPeUsuario.getApellido2() + " " + iildPeUsuario.getNombre());
            	sessionMBean.setRegistro(iildPeUsuario.getUID());
            	sessionMBean.setCodCargo(iildPeUsuario.getCargo().getCodigo());
            	sessionMBean.setDesCargo(iildPeUsuario.getCargo().getDescripcion());
            	response.sendRedirect("/CRONREAUNIWeb/faces/levanta.jsp");
            	
            	
            }else{
        		request.getSession(true).setAttribute("strMensaje",msg);
                response.sendRedirect("/CRONREAUNIWeb/faces/sinAcceso.xhtml");    
            }
            
        }catch(Exception e){
        	msg = "Error al conectar al Ldap ";
            //logger.error(Utilitarios.Log.error(e,msg), e);        	
            request.getSession(true).setAttribute("strMensaje",msg);
            response.sendRedirect("/CRONREAUNIWeb/faces/sinAcceso.xhtml");
        }
        
    }
 
}
