
package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.TerritorioForm;

import java.util.Date;

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

import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

public class TerritorioAction extends DispatchAction{
	private static Logger log = Logger.getLogger(TerritorioAction.class);
	
	public ActionForward listarTerritorio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();	
		TerritorioForm objForm=(TerritorioForm)form;
		
		try {
			log.info("[TerritorioAction :: listarTerritorio] Inicio");
			
			String desTerritorio = objForm.getNomTerritorio();
			
			log.info("[TerritorioAction :: listarTerritorio] Fin");
		}catch (Exception e) {
			log.error("[TerritorioAction :: listarTerritorio] " +  e);
			errors.add("name", new ActionError("id"));
		}
		
		if(!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		}else {
			forward = mapping.findForward("lista"); 
		}
		
		return (forward);
	}
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		HttpSession sesion = null;
		
		try {
			log.info("[TerritorioAction :: inicio] Inicio");
			
			sesion = request.getSession(false);
			sesion.setAttribute("listaEstado", conexion.findByCodMulti("T13"));
			
			log.info("[TerritorioAction :: inicio] Fin");
		}catch(Exception e){
			log.error("[TerritorioAction :: inicio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("inicio"); 
		}
		
		return (forward);
	}
	
	public ActionForward crear(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		TerritorioForm objForm=(TerritorioForm)form;
		Date fecha = new Date();	
		Connection con = new Connection();
		HttpSession sesion = null;
		
		try {
			log.info("[TerritorioAction :: crear] Inicio");
			
			sesion = request.getSession(false);
			sesion.setAttribute("territorio", objForm.getTerritorio());
			sesion.setAttribute("tipo", "Registro");
			
			log.info("[TerritorioAction :: crear] Fin");
		}catch (Exception e) {
			log.error("[TerritorioAction :: crear] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("ok"); 
		}		
		
		return (forward);		
	}
	
	public ActionForward actualizar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		TerritorioForm objForm=(TerritorioForm)form;
		Connection con = new Connection();
		HttpSession sesion = null;
		
		try {
			log.info("[TerritorioAction :: actualizar] Inicio");
			
			sesion = request.getSession(false);
			
			sesion.setAttribute("territorio", objForm.getTerritorio());
			sesion.setAttribute("tipo", "Actualiz" + (char) 243);
			
			log.info("[TerritorioAction :: actualizar] Fin");
		}catch (Exception e) {
			log.error("[TerritorioAction :: actualizar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("ok"); 
		}		
		
		return (forward);		
	}
	
	public ActionForward mostrarTerritorio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();
			Connection conexion = new Connection();	
			TerritorioForm objForm=(TerritorioForm)form;
			Territorio territorio = null;
			HttpSession sesion = null;
			
			try{
				log.info("[TerritorioAction :: mostrarTerritorio] Inicio");
				
				String codTerritorio = request.getParameter("codTerritorio");
				sesion = request.getSession(false);
				
				sesion.setAttribute("listaEstado", conexion.findByCodMulti("T13"));
				
				log.info("[TerritorioAction :: mostrarTerritorio] Inicio");
			} catch (Exception e) {
				log.error("[TerritorioAction :: mostrarTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				errors.add("name", new ActionError("id"));
			}
			
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				forward = mapping.findForward("error"); 
			} else {
				forward = mapping.findForward("editar"); 
			}
			
			return (forward);
	}
}