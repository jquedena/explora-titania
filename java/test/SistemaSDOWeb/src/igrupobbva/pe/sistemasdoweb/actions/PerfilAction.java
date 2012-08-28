package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.PerfilForm;
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
import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings({"unchecked", "unused"})
public class PerfilAction extends DispatchAction{
	private static Logger log = Logger.getLogger(PerfilAction.class);
	
	public ActionForward inicioPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		IILDPeUsuario usuario = null;
    	GestorPerfil codPerfil= new GestorPerfil();
    	HttpSession sesion = null;
    	Gestor gestor = null;
    	
    	try {
    		log.info("[PerfilAction :: inicioPerfil] Inicio");
    		
    		sesion = request.getSession(false);
    		gestor = (Gestor)sesion.getAttribute("gestor"); 
    		
	    	String CodigoUsuario = gestor.getCodigoGestor();
	    	usuario=com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	String perfil=codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
			PerfilForm perfilFrm = (PerfilForm) form;
			listaPerfiles = conexion.findAllPerfil();
			
			sesion.setAttribute("listaAllPerfil", listaPerfiles);
			request.setAttribute("perfil",perfil);
			
			log.info("[PerfilAction :: inicioPerfil] Fin");
		} catch (Exception e) {
			log.error("[PerfilAction :: inicioPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("perfilLista"); 
		}		
		
		return (forward);
	}
	
	public ActionForward mostrarPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		HttpSession sesion = null;
		
		try {
			log.info("[PerfilAction :: mostrarPerfil] Inicio");
			
			sesion = request.getSession(false);
			
			String[] _hidValor = UtilListas.getArrayStrings(request.getParameter("codPerfil"),"|");
			
			PerfilForm perfilFrm = (PerfilForm) form;
			perfilFrm.setCodPerfil(_hidValor[0]);
			perfilFrm.setNomPerfil(_hidValor[1]);
			perfilFrm.setPerfil(_hidValor[2]);
			
			sesion.setAttribute("codigoPerfil", perfilFrm.getCodPerfil());
			sesion.setAttribute("nombrePerfil", perfilFrm.getNomPerfil());
			sesion.setAttribute("perfil", perfilFrm.getPerfil());
			
			log.info("[PerfilAction :: mostrarPerfil] Fin");
		} catch (Exception e) {
			log.error("[PerfilAction :: mostrarPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("mostrarPerfilSel"); 
		}		
		
		return (forward);
	}
	
	public ActionForward modificarPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[PerfilAction :: modificarPerfil] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			String valorCod = request.getParameter("txtcodPerfil");
			String valorNom = request.getParameter("txtnomPerfil");
			String valorPerfil = request.getParameter("txtperfil");
			
			Perfil perfil = new Perfil();
			perfil.setCodPerfil(valorCod);
			perfil.setNomPerfil(valorNom);
			perfil.setPerfil(valorPerfil);
			
			SimpleDateFormat formatter=  new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			String fechaActual = formatter.format(cal.getTime());
			
			perfil.setFecRegi(fechaActual);
			perfil.setFecActu(fechaActual);
			perfil.setUsuRegi(gestor.getCodigoGestor());
			
			IILDPeUsuario usuario = null;
	    	GestorPerfil codPerfil = new GestorPerfil();
	    	String CodigoUsuario = gestor.getCodigoGestor();
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	String perfilIng = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
			
			boolean resultOk = conexion.updatePerfil(perfil);
			
			listaPerfiles = conexion.findAllPerfil();
			sesion.setAttribute("listaAllPerfil", listaPerfiles);
			request.setAttribute("perfil",perfilIng);
			
			log.info("[PerfilAction :: modificarPerfil] Fin");
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[PerfilAction :: modificarPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("perfilLista"); 
		}
		
		return (forward);
	}

	public ActionForward nuevoPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PerfilForm perfilFrm = (PerfilForm) form;
		perfilFrm.setCodPerfil("");
		perfilFrm.setNomPerfil("");
		perfilFrm.setPerfil("");
		
		HttpSession sesion = request.getSession(false);
		sesion.setAttribute("codigoPerfil", perfilFrm.getCodPerfil());
		sesion.setAttribute("nombrePerfil", perfilFrm.getNomPerfil());
		sesion.setAttribute("perfil", perfilFrm.getPerfil());
		
		return mapping.findForward("nuevoPerfil");
	}
	
	public ActionForward ingresarPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[PerfilAction :: ingresarPerfil] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
		
			String valorCod = request.getParameter("txtcodPerfil");
			String valorNom = request.getParameter("txtnomPerfil");
			String valorPerfil = request.getParameter("txtperfil");
			
			Perfil perfil = new Perfil();
			perfil.setCodPerfil(valorCod);
			perfil.setNomPerfil(valorNom);
			perfil.setPerfil(valorPerfil);
			
			SimpleDateFormat formatter=  new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			String fechaActual = formatter.format(cal.getTime());
			
			perfil.setFecRegi(fechaActual);
			perfil.setFecActu(fechaActual);
			perfil.setUsuRegi(gestor.getCodigoGestor());
			
			IILDPeUsuario usuario = null;
	    	GestorPerfil codPerfil= new GestorPerfil();
	    	String CodigoUsuario = gestor.getCodigoGestor();
	    	usuario=com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	String perfilIng=codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
		
			boolean resultOk = conexion.createPerfil(perfil);
			
			listaPerfiles = conexion.findAllPerfil();
			sesion.setAttribute("listaAllPerfil", listaPerfiles);
			request.setAttribute("perfil",perfilIng);
			
			log.info("[PerfilAction :: ingresarPerfil] Fin");
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[PerfilAction :: ingresarPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("perfilLista"); 
		}		
		
		return (forward);
	}
	
	public ActionForward eliminarPerfil(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		String valorCod = "";
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[PerfilAction :: eliminarPerfil] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			String[] _hidValor = UtilListas.getArrayStrings(request.getParameter("codigos"),"|");
			
			int nNum = _hidValor.length;
			
			IILDPeUsuario usuario = null;
	    	GestorPerfil codPerfil= new GestorPerfil();
	    	String CodigoUsuario = gestor.getCodigoGestor();
	    	usuario=com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	String perfil=codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
		
			boolean resultOk = false; 
			
			for(int i =0; i<nNum; i++) {
				valorCod = _hidValor[i];
				resultOk = conexion.deletePerfil(valorCod);
			}
			
			listaPerfiles = conexion.findAllPerfil();
			sesion.setAttribute("listaAllPerfil", listaPerfiles);
			request.setAttribute("perfil",perfil);
			
			log.info("[PerfilAction :: eliminarPerfil] Fin");
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[PerfilAction :: eliminarPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("perfilLista"); 
		}
		
		return (forward);
	}
}
