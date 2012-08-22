package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.EquivalenciaForm;
import igrupobbva.pe.sistemasdoweb.util.GestorPerfil;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.sql.Date;
import java.sql.Timestamp;
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
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings({"unchecked", "unused"})
public class EquivalenciaAction extends DispatchAction{
	private static Logger log = Logger.getLogger(EquivalenciaAction.class);
	
	public ActionForward inicioEquivalencia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		Vector listaEquivalencias = null;
		IILDPeUsuario usuario = null;
    	GestorPerfil codPerfil= new GestorPerfil();
    	String CodigoUsuario = null;
    	HttpSession sesion = null;
    	Gestor gestor = null;
    	
		try {
			log.info("[EquivalenciaAction :: inicioEquivalencia] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			CodigoUsuario = gestor.getCodigoGestor();
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
	    	// YA NO SE UTILIZA
	    	//String perfil = null;
			
			listaEquivalencias = conexion.findAllEquivalencias();
			
			sesion.setAttribute("listaAllEquiva", listaEquivalencias);
			request.setAttribute("perfil",perfil);
			
			log.info("[EquivalenciaAction :: inicioEquivalencia] Fin");
		} catch (Exception e) {
			log.error("[EquivalenciaAction :: inicioEquivalencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("equivalenciaLista"); 
		}		
		
		return (forward);
	}
	
	public ActionForward mostrarEquivalencia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		HttpSession sesion = null;
		
		try {
			log.info("[EquivalenciaAction :: mostrarEquivalencia] Inicio");
			
			sesion = request.getSession(false);
			
			String _codCargo  = request.getParameter("codCargo");
			String _codPerfil = request.getParameter("codPerfil");
			
			EquivalenciaForm equivaFrm = (EquivalenciaForm) form;
			equivaFrm.setCodPerfil(_codPerfil);
			equivaFrm.setNomPerfil(_codPerfil);
			Equivalencia equivalencia = new Equivalencia(); 
		
			listaPerfiles = conexion.findAllPerfil();
			// EQUIVALENCIA NO SE USARA
			//equivalencia = conexion.findEquivalenciaByCodCargo(_codCargo);
			sesion.setAttribute("codigoCargo", _codCargo);
			sesion.setAttribute("codigoPerfil", _codPerfil);
			sesion.setAttribute("listaAllPerfil", listaPerfiles);
			
			log.info("[EquivalenciaAction :: mostrarEquivalencia] Fin");
		} catch (Exception e) {
			log.error("[EquivalenciaAction :: mostrarEquivalencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("mostrarEquivalenciaSel"); 
		}
		
		return (forward);
	}
	
	public ActionForward modificarEquivalencia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		Vector listaEquivalencias = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[EquivalenciaAction :: modificarEquivalencia] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			String _CodCargo  = request.getParameter("txtcodCargo");
			String _CodPerfil = request.getParameter("codPerfil");
			
			EquivalenciaForm equivaFrm = (EquivalenciaForm) form;
			Equivalencia equivalencia = new Equivalencia();
			
			equivaFrm.setCodPerfil(_CodPerfil);
			
			equivalencia.setCodCargo(_CodCargo);
			equivalencia.setCodPerfil(_CodPerfil);
			
			IILDPeUsuario usuario = null;
	    	GestorPerfil codPerfil= new GestorPerfil();
	    	String CodigoUsuario= gestor.getCodigoGestor();
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
	    	// YA NO SE UTILIZA
	    	//String perfil = null;
		
			boolean resultOk = conexion.updateEquivalencia(equivalencia);
			
			listaEquivalencias = conexion.findAllEquivalencias();
			sesion.setAttribute("listaAllEquiva", listaEquivalencias);
			request.setAttribute("perfil",perfil);
			
			log.info("[EquivalenciaAction :: modificarEquivalencia] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[EquivalenciaAction :: modificarEquivalencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("equivalenciaLista"); 
		}
		
		return (forward);
	}

	public ActionForward nuevaEquivalencia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		Vector listaPerfiles = null;
		HttpSession sesion = null;
		
		try {
			log.info("[EquivalenciaAction :: nuevaEquivalencia] Inicio");
			
			sesion = request.getSession(false);
			
			String _codCargo  = request.getParameter("codCargo");
			String _codPerfil = request.getParameter("codPerfil");
			
			log.info("[EquivalenciaAction :: nuevaEquivalencia] Cargo Recibido:" + _codCargo);
			log.info("[EquivalenciaAction :: nuevaEquivalencia] Perfil Recibido:" + _codPerfil);
			
			EquivalenciaForm equivaFrm = (EquivalenciaForm) form;
			equivaFrm.setCodPerfil(_codPerfil);
			equivaFrm.setNomPerfil(_codPerfil);
			
			Equivalencia equivalencia = new Equivalencia(); 
		
			listaPerfiles = conexion.findAllPerfil();

			sesion.setAttribute("codigoCargo", _codCargo);
			sesion.setAttribute("codigoPerfil", _codPerfil);
			sesion.setAttribute("listaAllPerfil", listaPerfiles);
			
			log.info("[EquivalenciaAction :: nuevaEquivalencia] Fin");
		} catch (Exception e) {
			log.error("[EquivalenciaAction :: nuevaEquivalencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));  
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("nuevaEquivalencia"); 
		}
		
		return (forward);
	}
	
	public ActionForward ingresarEquivalencia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		Vector listaEquivalencias = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[EquivalenciaAction :: ingresarEquivalencia] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			Timestamp fechaActual = new Timestamp(Calendar.getInstance().getTime().getTime());		
			Date data;
			SimpleDateFormat formatter=  new SimpleDateFormat("yyyy-MM-dd");
			data = new Date(fechaActual.getTime());
			
			String _CodCargo  = request.getParameter("txtcodCargo");
			String _CodPerfil = request.getParameter("codPerfil");
					
			Equivalencia equivalencia = new Equivalencia();
			
			equivalencia.setCodCargo(_CodCargo);
			equivalencia.setCodPerfil(_CodPerfil);
			equivalencia.setFecActualizo(data);
			equivalencia.setFecActualizo(data);
			
			IILDPeUsuario usuario = null;
	    	GestorPerfil codPerfil= new GestorPerfil();
	    	String CodigoUsuario = gestor.getCodigoGestor();
	    	usuario=com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	String perfil=codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
	    	// YA NO SE UTILIZA
	    	//String perfil = null;
		
			boolean resultOk = conexion.createEquivalencia(equivalencia);
			
			listaEquivalencias = conexion.findAllEquivalencias();
			sesion.setAttribute("listaAllEquiva", listaEquivalencias);
			request.setAttribute("perfil",perfil);
			
			log.info("[EquivalenciaAction :: ingresarEquivalencia] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[EquivalenciaAction :: EquivalenciaAction] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("equivalenciaLista"); 
		}
		return (forward);
	}
	
	public ActionForward eliminarEquivalencia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		Vector listaEquivalencias = null;
		String valorCod = "";
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[EquivalenciaAction :: eliminarEquivalencia] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			String[] _hidValor = UtilListas.getArrayStrings(request.getParameter("codigos"),"|");
			
			int nNum = _hidValor.length;
			
			IILDPeUsuario usuario = null;
	    	GestorPerfil codPerfil= new GestorPerfil();
	    	String CodigoUsuario = gestor.getCodigoGestor();
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
	    	//String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
	    	// ya no se utiliza
	    	String perfil = null;

	    	boolean resultOk = false; 
			
			for(int i =0; i<nNum; i++) {
				valorCod = _hidValor[i];
				// Eliminando los registros Seleccionados
				resultOk = conexion.deleteEquivalencia(valorCod);
			}
			
			listaEquivalencias = conexion.findAllEquivalencias();
			sesion.setAttribute("listaAllEquiva", listaEquivalencias);
			request.setAttribute("perfil",perfil);
			
			log.info("[EquivalenciaAction :: eliminarEquivalencia] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[EquivalenciaAction :: eliminarEquivalencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("equivalenciaLista"); 
		}
		
		return (forward);
	}
}
