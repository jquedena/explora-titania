package igrupobbva.pe.sistemasdoweb.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

public class LogOffAction extends Action {
	private static Logger log = Logger.getLogger(MantenimientoTerritorioAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
	  
		  HttpSession session = null;
		  
		  try {
			  log.info("[LogOffAction :: execute] Inicio");
			  
			  session = request.getSession(false);
			  
			  if(session != null) {
			  	session.invalidate();
			  }
			  
			  log.info("[LogOffAction :: execute] Fin");
		  } catch(Exception e) {
			  log.error("[LogOffAction :: execute] ");
			  ConstantesUtil.mostrarMensajeExcepcion(e);
		  }
		  
		  return mapping.findForward("inicio");
	  }
	
}
