package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.MenuForm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import proxy.load.Connection;

@SuppressWarnings({"unchecked", "unused"})
public class MenuAction extends DispatchAction {
	private static Logger log = Logger.getLogger(MenuAction.class);

	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		HttpSession sesion = null;
		
		try {
			log.info("[MenuAction :: inicio] Inicio");
			
			sesion = request.getSession(false);
			Vector obj=conexion.findAllMenu();
			
			for(int i=0;i<obj.size();i++)
			{
				com.grupobbva.bc.per.tele.sdo.serializable.Menu menu=(com.grupobbva.bc.per.tele.sdo.serializable.Menu)obj.get(i);				
			}
			sesion.setAttribute("listaMenu", conexion.findAllMenu());
			
			log.info("[MenuAction :: inicio] Fin");
		} catch (Exception e) {
			log.error("[MenuAction :: inicio] ");
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
	
	public ActionForward editar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listMenu = null;
		String padre = (String) request.getParameter("padre");
		String hijo = (String) request.getParameter("hijo");
		String descripcion = (String) request.getParameter("descripcion");
		String codPerfil = (String) request.getParameter("codPerfil");
		String link = (String) request.getParameter("link");		
		HttpSession sesion = null;
		
		try {
			log.info("[MenuAction :: editar] Inicio");
			
			sesion = request.getSession(false);
			
			com.grupobbva.bc.per.tele.sdo.serializable.Menu menu = new com.grupobbva.bc.per.tele.sdo.serializable.Menu();
			menu.setPadre(padre);
			menu.setHijo(hijo);			
			menu.setCodPerfil(codPerfil);
			menu.setDescripcion(descripcion);
			menu.setLink(link);
			conexion.updateMenu(menu);
		    
			sesion.setAttribute("listaMenu", conexion.findAllMenu());		
			
			log.info("[MenuAction :: editar] Fin");
		} catch (Exception e) {
			log.error("[MenuAction :: editar] ");
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
	
	public ActionForward nuevo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listMenu = null;
		String padre = (String) request.getParameter("padre");
		String hijo = (String) request.getParameter("hijo");
		String descripcion = (String) request.getParameter("descripcion");
		String codPerfil = (String) request.getParameter("codPerfil");
		String link = (String) request.getParameter("link");
		ArrayList collecUsuario=new ArrayList();
		ArrayList listaTitulo = new ArrayList();
		HttpSession sesion = null;
		
		try { 
			log.info("[MenuAction :: nuevo] Inicio");
			
			sesion = request.getSession(false);
			
			com.grupobbva.bc.per.tele.sdo.serializable.Menu menu = new com.grupobbva.bc.per.tele.sdo.serializable.Menu();
			menu.setPadre(padre);
			menu.setHijo(hijo);			
			menu.setCodPerfil(codPerfil);
			menu.setDescripcion(descripcion);
			menu.setLink(link);
			conexion.createMenu(menu);		
			sesion.setAttribute("listaMenu", conexion.findAllMenu());
			
			log.info("[MenuAction :: nuevo] Fin");
		} catch (Exception e) {
			log.error("[MenuAction :: nuevo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("ok"); 
		} else {
			forward = mapping.findForward("ok"); 
		}

		return (forward);	
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();		
		Connection conexion = new Connection();
		Vector listMenu = null; 
		String padre = (String) request.getParameter("padre");
		HttpSession sesion = null;
		
		try {
			log.info("[MenuAction :: delete] Inicio");
			
			sesion = request.getSession(false);
			String temp[]=padre.split("-");		
			
			for(int i=0;i < temp.length;i++){		
				conexion.deleteMenu(new BigDecimal(String.valueOf(temp[i])));
			}			
			sesion.setAttribute("listaMenu", conexion.findAllMenu());
			
			log.info("[MenuAction :: delete] Fin");
		} catch (Exception e) {
			log.error("[MenuAction :: delete] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("ok"); 
		} else {
			forward = mapping.findForward("ok"); 
		}
		
		return (forward);	

	}
	public ActionForward mostrarEditar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		MenuForm menuForm = (MenuForm) form;
		Connection conexion = new Connection();
		Vector listMenu = null;	
		String padre = (String) request.getParameter("padre");
		HttpSession sesion = null;
		
		try { 
			log.info("[MenuAction :: mostrarEditar] Inicio");
			
			sesion = request.getSession(false);
			
			com.grupobbva.bc.per.tele.sdo.serializable.Menu menu = conexion.findxIdMenu(new BigDecimal(padre));
			menuForm.setPadre(menu.getPadre());
			menuForm.setHijo(menu.getHijo());			
			menuForm.setCodPerfil(menu.getCodPerfil());
			menuForm.setDescripcion(menu.getDescripcion());
			menuForm.setLink(menu.getLink());
			request.setAttribute("method", "editar");
			request.setAttribute("menu", "true");
			request.setAttribute("listaMenu", conexion.findAllMenu());
			
			log.info("[MenuAction :: mostrarEditar] Fin");
		} catch (Exception e) {
			log.error("[MenuAction :: mostrarEditar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("nuevo"); 
		}
		
		return (forward);	
	}
	
	public ActionForward mostrarNuevo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		MenuForm perfilForm = (MenuForm) form;
		Connection conexion = new Connection();
		Vector listMenu = null;			
		
		try { 
			log.info("[MenuAction :: mostrarNuevo] Inicio");
			
			perfilForm.setCodPerfil("");
			perfilForm.setPadre("");	
			perfilForm.setHijo("");
			perfilForm.setDescripcion("");
			perfilForm.setLink("");
			request.setAttribute("method", "nuevo");
			request.setAttribute("menu", "false");
			
			log.info("[MenuAction :: mostrarNuevo] Fin");
		} catch (Exception e) {
			log.error("[MenuAction :: mostrarNuevo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("nuevo"); 
		}

		return (forward);	

	}
}
