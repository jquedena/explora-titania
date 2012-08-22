package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.PermisoPerfilForm;
import igrupobbva.pe.sistemasdoweb.util.GestorPerfil;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

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

import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings({"unchecked", "unused"})
public class PermisoPerfilAction extends DispatchAction{
	private static Logger log = Logger.getLogger(PermisoPerfilAction.class);
	
	public ActionForward inicioPermisoPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = null; 
		Connection conexion = null;
		Vector listaPermisoPerfiles = null;
		IILDPeUsuario usuario = null;
		GestorPerfil codPerfil=  new GestorPerfil();
		String codigoUsuario = null;
		String newPerfilUsuario = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[PermisoPerfilAction :: inicioPermisoPerfil] Inicio");
			
			conexion = new Connection();
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			codigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(codigoUsuario);
			newPerfilUsuario = codPerfil.buscarGestor(codigoUsuario).getCodigoPerfil();
			
			listaPermisoPerfiles = conexion.findAllPermisoPerfil();
			request.setAttribute("listaPermisoPerfiles", listaPermisoPerfiles);
			sesion.setAttribute("newPerfilUsuario", newPerfilUsuario);
			
			log.info("[PermisoPerfilAction :: inicioPermisoPerfil] Fin");
		} catch (Exception e) {
			log.error("[PermisoPerfilAction :: inicioPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("errorx"); 
		} else {
			forward = mapping.findForward("listar"); 
		}		
		
		return (forward);
	}
	
	public ActionForward mostrarPermisoPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		PermisoPerfil permisoPerfil = null;
		String perfil = null;
		String tipoAcceso = null;
		String valorRCP = null;
		Vector listaPerfiles = null;
		Vector listaPermisoPerfiles = null;
		HttpSession sesion = null;
		
		try {
			log.info("[PermisoPerfilAction :: mostrarPermisoPerfil] Inicio");
			
			sesion = request.getSession(false);
			
			perfil = (String)request.getParameter("codPerfil");
			tipoAcceso = (String)request.getParameter("tipoAcceso");
			valorRCP = (String)request.getParameter("valorRCP");
			
			permisoPerfil = conexion.findPermisoPerfilById(perfil, tipoAcceso, valorRCP);
			request.setAttribute("permisoPerfil", permisoPerfil);			
			listaPerfiles = conexion.findAllPerfil();
			request.setAttribute("listaPerfiles", listaPerfiles);
			
			log.info("[PermisoPerfilAction :: mostrarPermisoPerfil] Fin");
		} catch (Exception e) {
			log.error("[PermisoPerfilAction :: mostrarPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			listaPermisoPerfiles = conexion.findAllPermisoPerfil();
			request.setAttribute("listaPermisoPerfiles", listaPermisoPerfiles);	
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("listar"); 
		} else {
			forward = mapping.findForward("editar"); 
		}		
		
		return (forward);
	}
	
	public ActionForward modificarPermisoPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		PermisoPerfilForm permisoPerfilForm;
		PermisoPerfil permisoPerfil = null;
		PermisoPerfil origPermisoPerfil = null;
		PermisoPerfil existePerfil = null;
		SimpleDateFormat formatter =  null;
		Calendar cal = null;
		String fechaActual = null; 
		IILDPeUsuario usuario = null;
		String codigoUsuario = null;
		String perfil = null;
		String tipoAcceso = null;
		String valorRCP = null;
		String origPerfil = null;
		String origTipoAcceso = null;
		String origValorRCP = null;
		String mensajeError = "";
		Vector listaPermisoPerfiles = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[PermisoPerfilAction :: modificarPermisoPerfil] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			permisoPerfilForm = (PermisoPerfilForm) form;			
			permisoPerfil = new PermisoPerfil(); 
			origPermisoPerfil = new PermisoPerfil();
			
			codigoUsuario = gestor.getCodigoGestor();
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(codigoUsuario);
			
			formatter=  new SimpleDateFormat("yyyy-MM-dd");
			cal = Calendar.getInstance();			
			fechaActual = formatter.format(cal.getTime());			
			
			origPerfil = (String)request.getParameter("origCodPerfil");
			origTipoAcceso = (String)request.getParameter("origTipoAcceso");
			origValorRCP = (String)request.getParameter("origValorRCP");
			
			origPermisoPerfil.setCodPerfil(origPerfil);
			origPermisoPerfil.setTipoAcceso(origTipoAcceso);
			origPermisoPerfil.setValorRCP(origValorRCP);
			
			perfil = permisoPerfilForm.getCodPerfil();
			tipoAcceso = permisoPerfilForm.getTipoAcceso();
			valorRCP = permisoPerfilForm.getValorRCP().trim();
			
			permisoPerfil.setCodPerfil(perfil);
			permisoPerfil.setTipoAcceso(tipoAcceso);
			permisoPerfil.setValorRCP(valorRCP);			
			permisoPerfil.setUsuActu(gestor.getCodigoGestor());
			
			if(tipoAcceso.equals("1")) {
				permisoPerfil.setValorRCP(valorRCP.toUpperCase());
				valorRCP = valorRCP.toUpperCase();
				
				usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(valorRCP);				
				if(usuario != null) {					
					permisoPerfil.setUsuario(usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2());
				}else {
					permisoPerfil.setUsuario("");
				}
			} else {
				permisoPerfil.setUsuario(permisoPerfilForm.getUsuario().trim());
			}					
			
			if(origPerfil.equals(perfil) && origTipoAcceso.equals(tipoAcceso) && origValorRCP.equals(valorRCP)) {
				existePerfil = null;
			} else {
				existePerfil = conexion.findPermisoPerfilById(perfil, tipoAcceso, valorRCP);
			}			
			
			if(existePerfil == null) {
				boolean resultOk = conexion.updatePermisoPerfil(origPermisoPerfil, permisoPerfil);
			} else {
				mensajeError = "Permiso Perfil ya sido ingresado anteriormente.";
				listaPerfiles = conexion.findAllPerfil();
				request.setAttribute("listaPerfiles", listaPerfiles);
				
				if(tipoAcceso.equals("1")) {	
					permisoPerfil.setUsuario("");
				}
				
				request.setAttribute("permisoPerfil", permisoPerfil);
				request.setAttribute("mensajeError", mensajeError);
			}
			
			log.info("[PermisoPerfilAction :: modificarPermisoPerfil] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[PermisoPerfilAction :: modificarPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
			listaPermisoPerfiles = conexion.findAllPermisoPerfil();
			request.setAttribute("listaPermisoPerfiles", listaPermisoPerfiles);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("listar"); 
		} else {
			if(mensajeError.equals("")) {
				forward = mapping.findForward("ok");
			} else {
				forward = mapping.findForward("editar");
			}			 
		}		
		
		return (forward);
	}

	public ActionForward nuevoPermisoPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); 
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		Vector listaPermisoPerfiles = null;
		
		try {
			log.info("[PermisoPerfilAction :: nuevoPermisoPerfil] Inicio");
			
			conexion = new Connection();			 
			
			listaPerfiles = conexion.findAllPerfil();
			request.setAttribute("listaPerfiles", listaPerfiles);
			
			log.info("[PermisoPerfilAction :: nuevoPermisoPerfil] Fin");
		} catch (Exception e) {
			log.error("[PermisoPerfilAction :: nuevoPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
			listaPermisoPerfiles = conexion.findAllPermisoPerfil();
			request.setAttribute("listaPermisoPerfiles", listaPermisoPerfiles);	
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("listar"); 
		} else {
			forward = mapping.findForward("nuevo"); 
		}		
		
		return (forward);
	}
	
	public ActionForward ingresarPermisoPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		PermisoPerfilForm permisoPerfilForm;
		PermisoPerfil permisoPerfil = null;
		PermisoPerfil existePerfil = null;
		IILDPeUsuario usuario = null;
		String codigoUsuario = null;
		String perfil = null;
		String tipoAcceso = null;
		String valorRCP = null;
		String mensajeError = "";
		Vector listaPermisoPerfiles = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[PermisoPerfilAction :: ingresarPermisoPerfil] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			permisoPerfilForm = (PermisoPerfilForm) form;			
			permisoPerfil = new PermisoPerfil(); 
			
			codigoUsuario = gestor.getCodigoGestor();
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(codigoUsuario);
		
			perfil = permisoPerfilForm.getCodPerfil();
			tipoAcceso = permisoPerfilForm.getTipoAcceso();
			valorRCP = permisoPerfilForm.getValorRCP().trim();
			
			permisoPerfil.setCodPerfil(perfil);
			permisoPerfil.setTipoAcceso(tipoAcceso);
			permisoPerfil.setValorRCP(valorRCP);			
			permisoPerfil.setUsuRegi(gestor.getCodigoGestor());
			
			if(tipoAcceso.equals("1")) {			
				permisoPerfil.setValorRCP(valorRCP.toUpperCase());
				valorRCP = valorRCP.toUpperCase();
				
				usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(valorRCP);
				if(usuario != null) {					
					permisoPerfil.setUsuario(usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2());
				} else {
					permisoPerfil.setUsuario("");
				}
			} else {
				permisoPerfil.setUsuario(permisoPerfilForm.getUsuario().trim());
			}					
			
			existePerfil = conexion.findPermisoPerfilById(perfil, tipoAcceso, valorRCP);
			if(existePerfil == null) {
				boolean resultOk = conexion.createPermisoPerfil(permisoPerfil);
			} else {
				mensajeError = "Permiso Perfil ya sido ingresado anteriormente.";
				listaPerfiles = conexion.findAllPerfil();
				request.setAttribute("listaPerfiles", listaPerfiles);
				
				if(tipoAcceso.equals("1")) {	
					permisoPerfil.setUsuario("");
				}
				
				request.setAttribute("permisoPerfil", permisoPerfil);
				request.setAttribute("mensajeError", mensajeError);
			}
			
			log.info("[PermisoPerfilAction :: ingresarPermisoPerfil] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[PermisoPerfilAction :: ingresarPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));  
			listaPermisoPerfiles = conexion.findAllPermisoPerfil();
			request.setAttribute("listaPermisoPerfiles", listaPermisoPerfiles);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("listar"); 
		} else {
			if(mensajeError.equals("")) {
				forward = mapping.findForward("ok");
			} else {
				forward = mapping.findForward("nuevo");
			}			 
		}		
		
		return (forward);
	}
	
	public ActionForward eliminarPermisoPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listaPermisoPerfiles = null;
		String codPerfil = "";
		String tipoAcceso = "";
		String valorRCP = "";		
		HttpSession sesion = null;	
		String[] _hidValorCodPerfil = null;
		String[] _hidValorTipoAcceso = null;
		String[] _hidValorValorRCP = null;
		PermisoPerfilForm permisoPerfilForm = null;
		int nNum = -1;
		boolean resultOk = false;		
		
		try {
			log.info("[PermisoPerfilAction :: eliminarPermisoPerfil] Inicio");
			
			sesion = request.getSession(false);			
			permisoPerfilForm = (PermisoPerfilForm) form;			
			
			_hidValorCodPerfil = UtilListas.getArrayStrings(permisoPerfilForm.getListaCodPerfil(),"|");
			_hidValorTipoAcceso = UtilListas.getArrayStrings(permisoPerfilForm.getListaTipoAcceso(),"|");
			_hidValorValorRCP = UtilListas.getArrayStrings(permisoPerfilForm.getListaValorRCP(),"|");
			
			nNum = _hidValorCodPerfil.length;
			
			for(int i =0; i<nNum; i++) {
				codPerfil = _hidValorCodPerfil[i];
				tipoAcceso = _hidValorTipoAcceso[i];
				valorRCP = _hidValorValorRCP[i];

				// Eliminando los registros Seleccionados
				resultOk = conexion.deletePermisoPerfil(codPerfil, tipoAcceso, valorRCP);
			}
			
			log.info("[PermisoPerfilAction :: eliminarPermisoPerfil] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[PermisoPerfilAction :: eliminarPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
		} finally {
			listaPermisoPerfiles = conexion.findAllPermisoPerfil();
			request.setAttribute("listaPermisoPerfiles", listaPermisoPerfiles);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("listar"); 
		} else {
			forward = mapping.findForward("listar"); 
		}
		
		return (forward);
	}
}
