package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.util.ThreadMigracionData;

import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tele.sdo.serializable.TAcciones;
import com.grupobbva.bc.per.tele.sdo.serializable.TCampanhas;
import com.grupobbva.bc.per.tele.sdo.serializable.TCampanhasDetalle;
import com.grupobbva.bc.per.tele.sdo.serializable.TEpigrafes;
import com.grupobbva.bc.per.tele.sdo.serializable.TEquivalencias;
import com.grupobbva.bc.per.tele.sdo.serializable.TFirmas;
import com.grupobbva.bc.per.tele.sdo.serializable.TMaestroPlanes;
import com.grupobbva.bc.per.tele.sdo.serializable.TMetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.TOficina;
import com.grupobbva.bc.per.tele.sdo.serializable.TParametros;
import com.grupobbva.bc.per.tele.sdo.serializable.TPerfiles;
import com.grupobbva.bc.per.tele.sdo.serializable.TPlanes;
import com.grupobbva.bc.per.tele.sdo.serializable.TTerritorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import proxy.load.Connection;

import org.apache.log4j.Logger;

public class MigrarDatosAction extends DispatchAction {
	private static Logger log = Logger.getLogger(MigrarDatosAction.class);
	
	public ActionForward inicio (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		
		try {
			log.info("[MigrarDatosAction :: inicio] Inicio");
			
			String estadoFlag = ejb.buscarEstadoFlag();
			request.setAttribute("estado",estadoFlag);
			
			log.info("[MigrarDatosAction :: inicio] Fin");
		} catch(Exception e) {
			log.error("[MigrarDatosAction :: inicio] ");
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
	public ActionForward hilo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value			
		Connection ejb = new Connection();
		int indicador=0;
		ThreadMigracionData th = new ThreadMigracionData();
		
		try {
			log.info("[MigrarDatosAction :: hilo] Inicio");
			
			indicador=ejb.actualizarEstadoFlag(ConstantesUtil.ESTADO_PROCESO_ACTIVO);
			
			th.start();
			request.setAttribute("estado","0");
			
			log.info("[MigrarDatosAction :: hilo] Fin");
		} catch(Exception e) {
			log.error("[MigrarDatosAction :: hilo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error"); 
		} else {
			forward = mapping.findForward("ok"); 
		}
		// Finish with
		return (forward);
		}		
}