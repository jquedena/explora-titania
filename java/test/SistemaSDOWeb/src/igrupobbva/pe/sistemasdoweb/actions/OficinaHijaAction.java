package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.OficinaHijaForm;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings({"unchecked","unused"})
public class OficinaHijaAction extends DispatchAction{
	private static Logger log = Logger.getLogger(OficinaHijaAction.class);
	
	public ActionForward inicioOficinaHija(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		String mensajeError = null;
		Vector listaOficinaHija = null;
		
		try{
			log.info("[OficinaHijaAction :: inicioOficinaHija] Inicio");
			
			forward = new ActionForward(); 
			conexion = new Connection();			
			listaOficinaHija = conexion.findTodosOficinaHija();
			
			request.setAttribute("listaOficinaHija", listaOficinaHija);
			
			log.info("[OficinaHijaAction :: inicioOficinaHija] Fin");
		}catch(Exception e){
			log.error("[OficinaHijaAction :: inicioOficinaHija] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR;
		}
		
		request.setAttribute("mensajeExito", mensajeError);
		forward = mapping.findForward("listarOficinaHija"); 
				
		return (forward);
	}
	
	public ActionForward listarOficinaHija(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		String mensajeError = null;
		Vector listaOficinaHija = null;
		
		try{
			log.info("[OficinaHijaAction :: listarOficinaHija] Inicio");
			
			forward = new ActionForward(); 
			conexion = new Connection();			
			listaOficinaHija = conexion.findTodosOficinaHija();
			
			request.setAttribute("listaOficinaHija", listaOficinaHija);
			
			log.info("[OficinaHijaAction :: listarOficinaHija] Fin");
		}catch(Exception e){
			log.error("[OficinaHijaAction :: listarOficinaHija] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR;
		}
		
		request.setAttribute("mensajeExito", mensajeError);
		forward = mapping.findForward("listarOficinaHija"); 
				
		return (forward);
	}
	
	public ActionForward mostrarNuevoEditarOficinaHija(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		OficinaHija oficinaHija = null; 
		OficinaHijaForm oficinaHijaForm = null;  
		String mensajeError = null;
		String mostrarEditar = null;
		Vector listaOficinaPadre = null;
		String codigoOficinaHija = null;
		
		try{
			log.info("[OficinaHijaAction :: mostrarNuevoEditarOficinaHija] Inicio");
			
			forward = new ActionForward(); 
			conexion = new Connection();
			oficinaHija = new OficinaHija();
			oficinaHijaForm = (OficinaHijaForm)form;			
			
			mostrarEditar = oficinaHijaForm.getMostrarEditar();		
			if(mostrarEditar.equals("2")) {
				codigoOficinaHija = oficinaHijaForm.getCodigoOficinaHija();
				oficinaHija.setCodigoOficinaHija(codigoOficinaHija);
				oficinaHija = conexion.findOficinaHija(oficinaHija);
				
				request.setAttribute("oficinaHija", oficinaHija);
			}
			
			listaOficinaPadre = conexion.findAllOficinas();
			
			request.setAttribute("mostrarEditar", mostrarEditar);
			request.setAttribute("listaOficinaPadre", listaOficinaPadre);
			
			log.info("[OficinaHijaAction :: mostrarNuevoEditarOficinaHija] Fin");
		}catch(Exception e){
			log.error("[OficinaHijaAction :: mostrarNuevoEditarOficinaHija] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR;
		}
				
		forward = mapping.findForward("nuevoEditarOficinaHija");
		request.setAttribute("mensajeExito", mensajeError);
				
		return (forward);
	}
	
	public ActionForward grabarOficinaHija(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;
		OficinaHija oficinaHija = null; 
		OficinaHijaForm oficinaHijaForm = null;  
		String mensajeExito = null;
		String mensajeError = null;
		String mostrarEditar = null;
		Vector listaOficinaPadre = null;
		boolean resp = false; 
		Gestor gestor = null;
		HttpSession sesion = null;
		
		try{
			log.info("[OficinaHijaAction :: grabarOficinaHija] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor");
			
			forward = new ActionForward(); 
			conexion = new Connection();
			oficinaHija = new OficinaHija();
			oficinaHijaForm = (OficinaHijaForm)form;		
			mostrarEditar = oficinaHijaForm.getMostrarEditar();
        				
			oficinaHija.setCodigoOficinaHija(oficinaHijaForm.getCodigoOficinaHija().trim());
			oficinaHija.setNombreOficinaHija(oficinaHijaForm.getDescripcion().trim());
			oficinaHija.setCodigoOficinaPadre(oficinaHijaForm.getCodigoOficinaPadre().trim());
			oficinaHija.setUsuario(gestor.getCodigoGestor());
			
			listaOficinaPadre = conexion.findAllOficinas();
			request.setAttribute("listaOficinaPadre", listaOficinaPadre);			
			request.setAttribute("mostrarEditar", mostrarEditar); 
			request.setAttribute("oficinaHija", oficinaHija);			
			
			if(mostrarEditar.equals("1")) {
				// nuevo
				if(conexion.findByCodigoOficina(oficinaHija.getCodigoOficinaHija())) {
					mensajeError = ConstantesUtil.MENSAJE_ERROR;
					throw new Exception("SDO: No se pudo grabar el registro");
				}
				
				if(conexion.findOficinaHija(oficinaHija) == null) {
					resp = conexion.crearOficinaHija(oficinaHija);
				} else {
					mensajeError = ConstantesUtil.MENSAJE_ERROR;
					throw new Exception("SDO: No se pudo grabar el registro");
				}
			} else {
				// editar
				if(mostrarEditar.equals("2")) {
					resp = conexion.actualizarOficinaHija(oficinaHija);
				}
			}						
			
			if(!resp) {
				mensajeError = ConstantesUtil.MENSAJE_ERROR;
				throw new Exception("SDO: No se pudo grabar el registro");
			}
			
			mensajeError = ConstantesUtil.MENSAJE_EXITO;
			
			log.info("[OficinaHijaAction :: grabarOficinaHija] Fin");
		}catch(Exception e){
			mensajeError = ConstantesUtil.MENSAJE_ERROR;
			log.error("[OficinaHijaAction :: grabarOficinaHija] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		forward = mapping.findForward("nuevoEditarOficinaHija");  
		request.setAttribute("mensajeExito", mensajeError);
		// request.setAttribute("mensajeError", mensajeError);
				
		return (forward);
	}
	
	public ActionForward eliminarOficinaHija(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		OficinaHija oficinaHija = null; 
		String mensajeExito = null;
		String mensajeError = null;
		boolean resp = false;		
		OficinaHijaForm oficinaHijaForm = null; 
		UtilListas utilList = null;
		Vector listaGestores = null; 
		Iterator iterListaGestores = null;
		Vector listaCodGestores = null;
		
		try{
			log.info("[OficinaHijaAction :: eliminarOficinaHija] Inicio");
			
			forward = new ActionForward(); 
			conexion = new Connection();
			oficinaHija = new OficinaHija();
			forward = new ActionForward(); 
			conexion = new Connection();
			oficinaHijaForm = (OficinaHijaForm)form;
			
			oficinaHija.setCodigoOficinaHija(oficinaHijaForm.getCodigoOficinaHija());
			resp = conexion.eliminarOficinaHija(oficinaHija);
			if(!resp) {
				throw new  Exception("SDO: No se pudo eliminar el registro");
			}
			
			utilList = new UtilListas();			
			listaGestores = utilList.listarGestoresSinMontos(oficinaHijaForm.getCodigoOficinaHija());			
			if(listaGestores != null && listaGestores.size() > 0) {
				iterListaGestores = listaGestores.iterator();
				listaCodGestores = new Vector(0, 1);
				
				while(iterListaGestores.hasNext()) {
					Gestor gestor = (Gestor)iterListaGestores.next();
					  
					listaCodGestores.add(gestor.getCodigoGestor());
				}
				
				conexion.eliminarMetaGestoresHijas(listaCodGestores);
			}			
			
			
			request.setAttribute("listaOficinaHija", conexion.findTodosOficinaHija());
			
			mensajeExito = ConstantesUtil.MENSAJE_EXITO;
			
			log.info("[OficinaHijaAction :: eliminarOficinaHija] Fin");
		}catch(Exception e){
			log.error("[OficinaHijaAction :: eliminarOficinaHija] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeExito = ConstantesUtil.MENSAJE_ERROR;
		} finally {
			forward = mapping.findForward("listarOficinaHija");
		}
		
		request.setAttribute("mensajeExito", mensajeExito);
		// request.setAttribute("mensajeError", mensajeError);
				
		return (forward);
	}
}
