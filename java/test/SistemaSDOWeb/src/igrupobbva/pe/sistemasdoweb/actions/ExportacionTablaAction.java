package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.ExportacionTablaForm;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"unused", "unchecked"})
public class ExportacionTablaAction extends DispatchAction{
	private static Logger log = Logger.getLogger(ExportacionTablaAction.class);
	
	public ActionForward inicioExportacionTabla(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		HttpSession sesion = null;
		String mensajeError = null;
		ConstantesUtil constantesUtil = null;
		Multitabla multitabla = null;
		UtilListas utilListas = null;
		Vector listaAnio = null;
		
		try{
			log.info("[ExportacionTablaAction :: inicioExportacionTabla] Inicio");
			
			conexion = new Connection();
			constantesUtil = new ConstantesUtil();
			utilListas = new UtilListas();
			sesion = request.getSession(false);
			forward = new ActionForward(); 
			
			multitabla = conexion.findMultiByPrimaryKey("T02", "1");
			listaAnio = utilListas.obtenerListAnhos(multitabla.getValor1(), Integer.parseInt(multitabla.getValor2()));
			
        	request.setAttribute("listaExportacion", constantesUtil.listarExportacionForm());
        	request.setAttribute("listaAnio", listaAnio);
        	
        	log.info("[ExportacionTablaForm :: inicioExportacionTabla] Fin");
		}catch(Exception e){
			log.error("[ExportacionTablaForm :: inicioExportacionTabla] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensajeError = ConstantesUtil.MENSAJE_ERROR_GENERICO;
		}
		
		request.setAttribute("mensajeError", mensajeError);
		forward = mapping.findForward("inicioExportacionTabla"); 
				
		return (forward);
	}
	
	public ActionForward exportarTabla(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {				
		ActionForward forward = null; 
		Connection conexion = null;		
		HttpSession sesion = null;
		String mensajeError = null;
		Vector listaAnio = null;
		ExportacionTablaForm exportacionTablaForm = null;
		Vector listaDatos = null;
		PrintWriter printerWriter = null;
		Iterator iterListaDatos = null;
		
		try{
			log.info("[ExportacionTablaAction :: exportarTabla] Inicio");
			
			response.setContentType("text/plain");
			response.setHeader("Content-Disposition",
			   "attachment; filename=tabla.txt");
			
			sesion = request.getSession(false);
			forward = new ActionForward();
			conexion = new Connection();
			
			exportacionTablaForm = (ExportacionTablaForm)form;
			
        	listaDatos = conexion.exportarTablasTXT(Integer.parseInt(exportacionTablaForm.getCodigoTabla()), 
        			Integer.parseInt(exportacionTablaForm.getMes()), 
					Integer.parseInt(exportacionTablaForm.getAnio()));
        	
        	printerWriter = response.getWriter();
        	if(listaDatos != null) {
        		iterListaDatos = listaDatos.iterator();
        		
        		while(iterListaDatos.hasNext()) {
        			String linea = (String)iterListaDatos.next();
        			printerWriter.write(linea);
        			printerWriter.write("\n");
        		}
        	} 
			
        	printerWriter.flush();
        	printerWriter.close();
			
        	log.info("[ExportacionTablaAction :: exportarTabla] Fin");
		}catch(Exception e){
			log.error("[ExportacionTablaAction :: exportarTabla] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			mensajeError = ConstantesUtil.MENSAJE_ERROR_GENERICO;
		}
		
		forward = mapping.findForward("exportarTabla"); 
				
		return (forward);
	}
}
