package igrupobbva.pe.sistemasdoweb.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

public class CargaDatosAction extends DispatchAction{
	private static Logger log = Logger.getLogger(CargaDatosAction.class);
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		HttpSession sesion = null;
		
		try {
			log.info("[CargaDatosAction :: inicio] Inicio");
			sesion = request.getSession(false);

			forward = mapping.findForward("ok");
			
			sesion.setAttribute("fileInput", "");
			
			log.info("[CargaDatosAction :: inicio] Fin");
		} catch(Exception e) {
			log.error("[CargaDatosAction :: inicio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("ok"); 
		}
		
		return (forward);
	}
	
	public ActionForward actualizaPlanes(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		HttpSession sesion = null;
		
		try {
			log.info("[CargaDatosAction :: actualizaPlanes] Inicio");
			
			sesion = request.getSession(false);
			
			sesion.removeAttribute("listaCorporativa");
			sesion.setAttribute("listaCorporativa", conexion.findByCodMulti("T01"));
			
			log.info("[CargaDatosAction :: actualizaPlanes] Fin");
		} catch (Exception e) {
			log.error("[CargaDatosAction :: actualizaPlanes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));  //$NON-NLS-2$
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("ok"); 
		}
		
		return (forward);
	}
}
