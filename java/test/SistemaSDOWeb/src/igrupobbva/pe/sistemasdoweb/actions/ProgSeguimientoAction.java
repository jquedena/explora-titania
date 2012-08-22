package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.ProgSeguimientoForm;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.util.Calendar;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings({"unused", "unchecked"})
public class ProgSeguimientoAction extends DispatchAction{
	private static Logger log = Logger.getLogger(ProgSeguimientoAction.class);
	
	public ActionForward inicioProgSeguimiento(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		ProgSeguimiento progSeguimiento = null; 
		IILDPeUsuario usuario = null;
		String codUsuario = null;
		HttpSession sesion = null;
		Territorio territorio = null;
		String mensajeError = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Gestor gestor = null;
		Vector listaProgSeguimiento = null;
		
		try{
			log.info("[ProgSeguimientoAction :: inicioProgSeguimiento] Inicio");
			
			sesion = request.getSession(false);
			forward = new ActionForward(); 
			conexion = new Connection();
			progSeguimiento = new ProgSeguimiento();			
			gestor = (com.grupobbva.bc.per.tele.sdo.serializable.Gestor)sesion.getAttribute("gestor");
			codUsuario = gestor.getCodigoGestor();
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(codUsuario);	    				
	    		    		    	 	    	
        	if(!(gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("CON"))) {
        		territorio = conexion.findTerritorioByCodOficina(usuario.getBancoOficina().getCodigo());
        		
        		if(territorio != null) {
            		if(	territorio.getCodTerr() == null || 
            			territorio.getNomTerr() == null)  {
            			throw new  Exception("SDO: Territorio no esta bien configurado");
            		}            		
            		progSeguimiento.setCodTerritorio(territorio.getCodTerr());
            		sesion.setAttribute("codTerrProgSeguimiento", territorio.getCodTerr());
            		sesion.setAttribute("nomTerrProgSeguimiento", territorio.getNomTerr());
            	} else {
            		throw new  Exception("SDO: No existe territorio");
            	}          	        	
        	} 
        	
        	listaProgSeguimiento = conexion.findTodosProgTerritorio(progSeguimiento);
        	request.setAttribute("listaProgSeguimiento", listaProgSeguimiento);
        	
        	log.info("[ProgSeguimientoAction :: inicioProgSeguimiento] Fin");
		}catch(Exception e){
			log.error("[ProgSeguimientoAction :: inicioProgSeguimiento] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR_GENERICO2;
		}
		
		request.setAttribute("mensajeError", mensajeError);
		forward = mapping.findForward("listarProgSeguimiento"); 
				
		return (forward);
	}
	
	public ActionForward listarProgSeguimiento(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		ProgSeguimiento progSeguimiento = null; 
		HttpSession sesion = null;
		Territorio territorio = null;
		String mensajeExito = null;
		String mensajeError = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Gestor gestor = null;
		String codTerrProgSeguimiento = null;
		String nomTerrProgSeguimiento = null;
		ProgSeguimientoForm progSeguimientoForm = null;
		
		try{
			log.info("[ProgSeguimientoAction :: listarProgSeguimiento] Inicio");
			
			sesion = request.getSession(false);
			forward = new ActionForward(); 
			conexion = new Connection();
			progSeguimiento = new ProgSeguimiento();			
			gestor = (Gestor)sesion.getAttribute("gestor");
			progSeguimientoForm = (ProgSeguimientoForm)form;
			
			progSeguimientoForm.reset(mapping, request);
	    		    		    	 	    	
        	request.setAttribute("listaProgSeguimiento", conexion.findTodosProgTerritorio(progSeguimiento));
        	
        	log.info("[ProgSeguimientoAction :: listarProgSeguimiento] Fin");
		}catch(Exception e){
			log.error("[ProgSeguimientoAction :: listarProgSeguimiento] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR_GENERICO2;
		}
		
		request.setAttribute("mensajeError", mensajeError);
		forward = mapping.findForward("listarProgSeguimiento"); 
		
		return (forward);
	}
	
	public ActionForward mostrarNuevoEditarProgSeguimiento(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		ProgSeguimiento progSeguimiento = null; 
		Territorio territorio = null;
		String mensajeError = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Gestor gestor = null;
		String nuevoEditar = null;
		ProgSeguimientoForm progSeguimientoForm = null; 
		Vector listaTerritorio = null;
		Vector listaAnio = null;
		Multitabla multitabla = null;
		UtilListas utilList = null;
		HttpSession sesion = null;
		String mensajeExito = null;
		String codTerrProgSeguimiento = null;
		String nomTerrProgSeguimiento = null;
		String codUsuario = null;
		IILDPeUsuario usuario = null;
		
		try{
			log.info("[ProgSeguimientoAction :: mostrarNuevoEditarProgSeguimiento] Inicio");
			
			sesion = request.getSession(false);
			forward = new ActionForward(); 
			conexion = new Connection();
			progSeguimiento = new ProgSeguimiento();
			progSeguimientoForm = (ProgSeguimientoForm)form;			
			
			gestor = (com.grupobbva.bc.per.tele.sdo.serializable.Gestor)sesion.getAttribute("gestor");
			codUsuario = gestor.getCodigoGestor();
			
	    	usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(codUsuario);
	    	
	    	progSeguimiento.setAnio(Integer.parseInt(ConstantesUtil.getAnioActual()));
	    	progSeguimiento.setMes(ConstantesUtil.getMesActual());
	    	
			listaTerritorio = conexion.busAllTerritorio();
    		request.setAttribute("listaTerritorio", listaTerritorio);
	    	
    		// listar anios
	    	utilList = new UtilListas();
	    	multitabla = conexion.findMultiByPrimaryKey("T02", "1");
	    	listaAnio = utilList.obtenerListAnhos(multitabla.getValor1(), 
    					Integer.parseInt(multitabla.getValor2()));        	 	       	
	    	request.setAttribute("listaAnio", listaAnio);	    	
    		
	    	// Setear Sesion de Territorio
        	if(!(gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("CON"))) {
        		territorio = conexion.findTerritorioByCodOficina(usuario.getBancoOficina().getCodigo());
        		
        		if(territorio != null) {
            		if(	territorio.getCodTerr() == null || 
            			territorio.getNomTerr() == null)  {
            			throw new  Exception("SDO: Territorio no esta bien configurado");
            		}            		
            		sesion.setAttribute("codTerrProgSeguimiento", territorio.getCodTerr());
            		sesion.setAttribute("nomTerrProgSeguimiento", territorio.getNomTerr());
            		
            		progSeguimiento.setCodTerritorio(territorio.getCodTerr());
            	} else {
            		sesion.removeAttribute("codTerrProgSeguimiento");
            		sesion.removeAttribute("nomTerrProgSeguimiento");
            		throw new  Exception("SDO: No existe territorio");
            	}          	        	
        	} else {
        		sesion.removeAttribute("codTerrProgSeguimiento");
        		sesion.removeAttribute("nomTerrProgSeguimiento");
        	}
    		
    		// Mostrar        	
        	if(request.getParameter("limpiarForm") != null) {
        		progSeguimientoForm.reset(mapping, request);
        	}	
        	
    		if(	!progSeguimientoForm.getCodTerritorio().equals("") &&
    			!progSeguimientoForm.getMes().equals("") &&
				!progSeguimientoForm.getAnio().equals("")	
    			) {
    			progSeguimiento = conexion.findProgramacionSeguimiento(
					progSeguimientoForm.getMes(), progSeguimientoForm.getAnio(), progSeguimientoForm.getCodTerritorio());
    		}
    		
    		if((progSeguimiento.getCodTerritorio() != null && !progSeguimiento.getCodTerritorio().equals(""))
    			&& (progSeguimiento.getMes() != null && !progSeguimiento.getMes().equals("")) 
    			&& progSeguimiento.getAnio() != 0) {
    			progSeguimiento = conexion.findProgramacionSeguimiento(
    				progSeguimiento.getMes(), String.valueOf(progSeguimiento.getAnio()), progSeguimiento.getCodTerritorio());
    		}
    		
	    	request.setAttribute("progSeguimiento", progSeguimiento);
	    	
	    	log.info("[ProgSeguimientoAction :: mostrarNuevoEditarProgSeguimiento] Fin");
		}catch(Exception e){
			log.error("[ProgSeguimientoAction :: mostrarNuevoEditarProgSeguimiento] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR_GENERICO2;
		}
				
		forward = mapping.findForward("nuevoEditarProgSeguimiento");
		request.setAttribute("mensajeError", mensajeError);
				
		return (forward);
	}
	
	public ActionForward grabarProgSeguimiento(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		ProgSeguimiento progSeguimiento = null; 
		String mensajeExito = null;
		String mensajeError = null;
		String mensajeValidarFecha = null;
		Gestor gestor = null;
		String codTerritorio = null;
		ProgSeguimientoForm progSeguimientoForm = null; 
		HttpSession sesion = null;
		boolean resp = false; 	
		java.sql.Date fechaActual = null; 
		Vector listaAnio = null;
		Multitabla multitabla = null;
		UtilListas utilList = null;
		Vector listaTerritorio = null;
		
		try{
			log.info("[ProgSeguimientoAction :: grabarProgSeguimiento] Inicio");
			
			sesion = request.getSession(false);
			forward = new ActionForward(); 
			conexion = new Connection();
			progSeguimiento = new ProgSeguimiento();
			progSeguimientoForm = (ProgSeguimientoForm)form;			
			gestor = (Gestor)sesion.getAttribute("gestor");
			fechaActual = new java.sql.Date(Calendar.getInstance().getTimeInMillis()); 
			
			// Setear Combos
			listaTerritorio = conexion.busAllTerritorio();
    		request.setAttribute("listaTerritorio", listaTerritorio);
			// listar aÃ±os
	    	utilList = new UtilListas();
	    	multitabla = conexion.findMultiByPrimaryKey("T02", "1");
	    	listaAnio = utilList.obtenerListAnhos(multitabla.getValor1(), 
    					Integer.parseInt(multitabla.getValor2()));        	 	       	
	    	request.setAttribute("listaAnio", listaAnio);
			
	    	//
			codTerritorio = progSeguimientoForm.getCodTerritorio();
			if(codTerritorio == null) {
				// No existe parameter codTerritorio cuando perfil no es perfil ADM
				codTerritorio = (String)sesion.getAttribute("codTerrProgSeguimiento");
			}
			
			progSeguimiento.setCodTerritorio(codTerritorio);	    	
			progSeguimiento.setMes(progSeguimientoForm.getMes());
			progSeguimiento.setAnio(Integer.parseInt(progSeguimientoForm.getAnio()));
			progSeguimiento.setSeg1Ini(progSeguimientoForm.getSeg1Ini());	    	
			progSeguimiento.setSeg1Fin(progSeguimientoForm.getSeg1Fin());
			progSeguimiento.setSeg2Ini(progSeguimientoForm.getSeg2Ini());	    	
			progSeguimiento.setSeg2Fin(progSeguimientoForm.getSeg2Fin());		
			
			request.setAttribute("progSeguimiento", progSeguimiento);  
			
			mensajeValidarFecha = progSeguimiento.validarFechas(Integer.parseInt(progSeguimientoForm.getMes()));
			if(mensajeValidarFecha != null) {
				mensajeError = mensajeValidarFecha;
				throw new Exception("SDO: Fechas no validas");
			}	
			
			if(conexion.findProgTerritorio(progSeguimiento) != null) {
				progSeguimiento.setFecActu(fechaActual);
				progSeguimiento.setUsuActu(gestor.getCodigoGestor());
				resp = conexion.actualizarProgTerritorio(progSeguimiento);
			} else {
				progSeguimiento.setFecCrea(fechaActual);
				progSeguimiento.setUsuCrea(gestor.getCodigoGestor());
				resp = conexion.crearProgTerritorio(progSeguimiento);
			}	
			
			if(!resp) {
				mensajeExito = ConstantesUtil.MENSAJE_ERROR;
				throw new Exception("SDO: No se pudo grabar el registro");
			}
        	
			mensajeExito = ConstantesUtil.MENSAJE_EXITO;
			
			log.info("[ProgSeguimientoAction :: grabarProgSeguimiento] Fin");
		}catch(Exception e){
			log.error("[ProgSeguimientoAction :: grabarProgSeguimiento] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		forward = mapping.findForward("nuevoEditarProgSeguimiento");  
		request.setAttribute("mensajeExito", mensajeExito);
		// request.setAttribute("mensajeError", mensajeError);
				
		return (forward);
	}
	
	public ActionForward eliminarProgSeguimiento(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		ProgSeguimiento progSeguimiento = null; 
		String mensajeExito = null;
		String mensajeError = null;
		Gestor gestor = null;
		boolean resp = false;
		HttpSession sesion = null;
		String codTerrProgSeguimiento = null;
		String nomTerrProgSeguimiento = null;
		ProgSeguimientoForm progSeguimientoForm = null; 
		
		try{
			log.info("[ProgSeguimientoAction :: eliminarProgSeguimiento] Inicio");
			
			forward = new ActionForward(); 
			conexion = new Connection();
			progSeguimiento = new ProgSeguimiento();
			sesion = request.getSession(false);
			forward = new ActionForward(); 
			conexion = new Connection();
			gestor = (Gestor)sesion.getAttribute("gestor");
			progSeguimientoForm = (ProgSeguimientoForm)form;
			
			progSeguimiento.setCodTerritorio(request.getParameter("codTerritorio"));	    	
			progSeguimiento.setMes(request.getParameter("mes"));
			progSeguimiento.setAnio(Integer.parseInt(request.getParameter("anio")));
        	
			resp = conexion.eliminarProgTerritorio(progSeguimiento);
			if(!resp) {
				throw new  Exception("SDO: No se pudo eliminar el registro");
			}
			
			progSeguimiento = new ProgSeguimiento();	    		    		    	 	    	
        	request.setAttribute("listaProgSeguimiento", conexion.findTodosProgTerritorio(progSeguimiento));        	
        	
			mensajeExito = ConstantesUtil.MENSAJE_EXITO_GENERICO;
			
			log.info("[ProgSeguimientoAction :: eliminarProgSeguimiento] Fin");
		}catch(Exception e){
			log.error("[ProgSeguimientoAction :: eliminarProgSeguimiento] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR_GENERICO;
		} finally {
			forward = mapping.findForward("listarProgSeguimiento");
		}
		
		request.setAttribute("mensajeExito", mensajeExito);
		request.setAttribute("mensajeError", mensajeError);
				
		return (forward);
	}
	
	public ActionForward verProgSeguimiento(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		ProgSeguimiento progSeguimiento = null; 
		String mensajeError = null;
		ProgSeguimientoForm progSeguimientoForm = null; 
		
		try{
			log.info("[ProgSeguimientoAction :: verProgSeguimiento] Inicio");
			
			forward = new ActionForward(); 
			conexion = new Connection();
			progSeguimiento = new ProgSeguimiento();
			progSeguimientoForm = (ProgSeguimientoForm)form;
			
			progSeguimiento.setCodTerritorio(progSeguimientoForm.getCodTerritorio());	    	
			progSeguimiento.setMes(progSeguimientoForm.getMes());
			progSeguimiento.setAnio(Integer.parseInt(progSeguimientoForm.getAnio()));
				
			progSeguimiento = conexion.findProgTerritorio(progSeguimiento);
				
			if(progSeguimiento == null) {
				throw new  Exception("SDO: No existe la programaciÃ³n del seguimiento para ese registro");
			}								
			
        	request.setAttribute("progSeguimiento", progSeguimiento);
        	
        	log.info("[ProgSeguimientoAction :: verProgSeguimiento] Fin");
		}catch(Exception e){
			log.error("[ProgSeguimientoAction :: verProgSeguimiento] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR_GENERICO;
		}
				
		forward = mapping.findForward("verProgSeguimiento");
		request.setAttribute("mensajeError", mensajeError);
				
		return (forward);
	}
}