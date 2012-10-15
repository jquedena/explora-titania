package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_his_ingresos_carp_com;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.HistoricoSeguimientoDAO;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanConsulta;
import com.grupobbva.bc.per.tel.iilc.logic.ExportCarpeta;
import com.grupobbva.bc.per.tel.iilc.logic.ExportObject;
import com.grupobbva.bc.per.tel.iilc.logic.FormateaListado;
import com.grupobbva.bc.per.tel.iilc.serializable.Consulta;

/**
 * @version 	1.0
 * @author
 */
@SuppressWarnings({"unused","unchecked"})
public class ExportacionAction extends DispatchAction {
	
	private static Logger log = Logger.getLogger(ExportacionAction.class);

    public ActionForward exportacion(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    			String origenVinculacion=request.getParameter("origenVinculacion")+"";
    			if(origenVinculacion.equals("null")){
    				exportacionCarpetasComerciales(mapping, form, request, response);
    			}else if(origenVinculacion.equals(Constantes.CODIGO_VIP) || origenVinculacion.equals(Constantes.CODIGO_GCO)  || origenVinculacion.equals(Constantes.CODIGO_PH) ){
    				exportacionVinculacion(mapping, form, request, response);
    			}else if(origenVinculacion.equals(Constantes.CODIGO_VIP_VINCULADO)){
    				exportacionVinculacionVinculada(mapping, form, request, response);
    			}else if(origenVinculacion.equals(Constantes.CODIGO_VIP_SEGMENTADO)){
    				exportacionVinculacionSegmentada(mapping, form, request, response);
    			}else if(origenVinculacion.equals(Constantes.CODIGO_HISTORICO_DIA) || origenVinculacion.equals(Constantes.CODIGO_HISTORICO_TOTAL)){
    				exportacionHistoricoSeguimiento(origenVinculacion,mapping, form, request, response);
    			} else{
    				//Aqui entrarian algunos adicionales que cargen anteriormente en session el path y file del archivo a descargar
    			}
        return null;
    }

    public ActionForward exportacionCarpetasComerciales(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		log.info("[ExportacionAction :: exportacion] inicio");
		ConexionDAO conexion = new ConexionDAO();
    	ActionErrors errors = new ActionErrors();
    	
        FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
        try {
        	
        	//Actualizaremos el historico
        	String idsession =  request.getSession().getAttribute("idSession").toString();
			HistoricoSeguimientoDAO historicodao = new HistoricoSeguimientoDAO();
        	Tiilc_his_ingresos_carp_com historico = null;
        	historico = historicodao.getHistorico(idsession);
			String us = (String) request.getSession().getAttribute("usuario");
			historico.setExportar(1);
			historico.setUsuario(us);
			historicodao.actualizarHistorico2(historico);	
			
        	int tipoDetalle = (int)((Consulta)request.getSession().getAttribute("parametrosConsulta")).getTipoDetalle();
            FormateaListado formato = formBeanConsulta.getFormatoXLS();
            ExportCarpeta exportObject = new ExportCarpeta();
			PrintWriter out = response.getWriter();
            if (formato != null && formato.getNum_registros()<=Constantes.TOT_REGEXCEL){
	            String path = conexion.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";
	            String file = generarNombreArchivo(formato);
	            log.info("[ExportacionAction :: exportacion] file = \"" + file + "\"");
	            
	            boolean res = false;
	            res = exportObject.exportacionMasiva(formato,tipoDetalle,file,path,(tipoDetalle==0)?true:false);	
	            if(!res) {
	            	log.info("Revisar");
	            }
	            
	            request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
	            request.getSession().setAttribute(Constantes.EXPORTACION_RUTA, path);
	            
            } else if (formato.getNum_registros()>Constantes.TOT_REGEXCEL){
            	log.info("too_much");
            	out.print("too_much");
            }
            
        } catch (Exception e) {
        	// e.printStackTrace();
    		log.error("[ExportacionAction :: exportacion] Error Carpetas Comerciales");
    		log.error("[ExportacionAction :: exportacion] " + e.getMessage());
            errors.add("name", new ActionError("id"));
        }

        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }
        
		log.info("[ExportacionAction :: exportacion] fin");
        return null;
    }
    
    public ActionForward exportacionVinculacion(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		ConexionDAO conexion = new ConexionDAO();
    	ActionErrors errors = new ActionErrors();
    	
    	log.info("entro a exportacion vinculacion");
        try {
        	
        	String origenVinculacion=request.getParameter("origenVinculacion")+"";
        	List listadoDetalle=(List)request.getSession().getAttribute("listadoDetalle");
        	String usuario=request.getSession().getAttribute("usuario").toString();
        	String tipoVinculacion="";
        	if(origenVinculacion.equals(Constantes.CODIGO_VIP)){
        		tipoVinculacion=Constantes.VIP_DESCRIPCION;
        	}else if(origenVinculacion.equals(Constantes.CODIGO_GCO)){
        		tipoVinculacion=Constantes.GCO_DESCRIPCION;
        	}else if(origenVinculacion.equals(Constantes.CODIGO_PH)){
        		tipoVinculacion=Constantes.PH_DESCRIPCION;
        	}
        	
            ExportObject exportObject = new ExportObject();
            PrintWriter out = response.getWriter();
            if (listadoDetalle != null && listadoDetalle.size()<=Constantes.TOT_REGEXCEL){
	            String path = conexion.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";
	            String file = "VINC_"+tipoVinculacion+"_"+usuario.toUpperCase()+".xls";
	            
	            boolean res = false;

	            res=exportObject.exportacionMasivaVinculacion(listadoDetalle,origenVinculacion,file,path);

	            
	            request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
	            request.getSession().setAttribute(Constantes.EXPORTACION_RUTA, path);

	            out.print("ok");
            } else if (listadoDetalle.size()>Constantes.TOT_REGEXCEL){
            	out.print("too_much");
            }
            
        } catch (Exception e) {
    		log.error("[ExportacionAction :: exportacion] error");
            errors.add("name", new ActionError("id"));
        }

        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }
        
		log.info("[ExportacionAction :: exportacion] fin");
        return null;
    }
    
    public ActionForward exportacionVinculacionVinculada(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		ConexionDAO conexion = new ConexionDAO();
    	ActionErrors errors = new ActionErrors();
	        try {
	        	String origenVinculacion=request.getParameter("origenVinculacion")+"";
	        	List listadoDetalle=(List)request.getSession().getAttribute("listadoDetalle");
	        	String usuario=request.getSession().getAttribute("usuario").toString();
	 
	            ExportObject exportObject = new ExportObject();
	            PrintWriter out = response.getWriter();
	            if (listadoDetalle != null && listadoDetalle.size()<=Constantes.TOT_REGEXCEL){
		            String path = conexion.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";
		            String file = "VINC_"+Constantes.VIP_VINCULADO_DESCRIPCION+"_"+usuario.toUpperCase()+".xls";
		            log.info("[ExportacionAction :: exportacion] file = \"" + file + "\"");
		            
		            boolean res = false;
		            res=exportObject.exportacionMasivaVinculada(listadoDetalle,file,path);
		            request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
		            request.getSession().setAttribute(Constantes.EXPORTACION_RUTA, path);
	
	            } else if (listadoDetalle.size()>Constantes.TOT_REGEXCEL){
	            	out.print("too_much");
	            }
	            
	        } catch (Exception e) {
	    		log.error("[ExportacionAction :: exportacion] error");
	    		log.error("[ExportacionAction :: exportacion] " + e.getMessage());
	            errors.add("name", new ActionError("id"));
	        }
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }
        
		log.info("[ExportacionAction :: exportacion] fin");
        return null;
    }
    
    
    
    
    public ActionForward exportacionHistoricoSeguimiento(String tipoReporte, ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConexionDAO conexion = new ConexionDAO();
    	ActionErrors errors = new ActionErrors();
	        try {
	        	
	        	List listadoDetalle=(List)request.getSession().getAttribute("listadoDetalle");
	        	String usuario=request.getSession().getAttribute("usuario").toString();
	            ExportObject exportObject = new ExportObject();
	            PrintWriter out = response.getWriter();
	            if (listadoDetalle != null && listadoDetalle.size()<=Constantes.TOT_REGEXCEL){
		            String path = conexion.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";
		            
		            String file = "";
		            
		            if(tipoReporte.equals(Constantes.CODIGO_HISTORICO_DIA)){
		            	file=Constantes.HISTORICO_DIA_DESCRIPCION+usuario.toUpperCase()+".xls";
		            }else{
		            	file=Constantes.HISTORICO_TOTAL_DESCRIPCION+usuario.toUpperCase()+".xls";	
		            }
		            
		            log.info("[ExportacionAction :: exportacion] file = \"" + file + "\"");
		            boolean res = false;
		            res=exportObject.exportacionMasivaHistorico(tipoReporte,listadoDetalle,file,path);
		            request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
		            request.getSession().setAttribute(Constantes.EXPORTACION_RUTA, path);
	            } else if (listadoDetalle.size()>Constantes.TOT_REGEXCEL){
	            	out.print("too_much");
	            }
	        } catch (Exception e) {
	    		log.error("[ExportacionAction :: exportacion] error");
	    		log.error("[ExportacionAction :: exportacion] " + e.getMessage());
	            errors.add("name", new ActionError("id"));
	        }
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }

		log.info("[ExportacionAction :: exportacion] fin");
        return null;
    }
    
    
    public ActionForward exportacionVinculacionSegmentada(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConexionDAO conexion = new ConexionDAO();
    	ActionErrors errors = new ActionErrors();
	        try {
	        	String origenVinculacion=request.getParameter("origenVinculacion")+"";
	        	List listadoDetalle=(List)request.getSession().getAttribute("listadoDetalle");
	        	String usuario=request.getSession().getAttribute("usuario").toString();
	            ExportObject exportObject = new ExportObject();
	            PrintWriter out = response.getWriter();
	            if (listadoDetalle != null && listadoDetalle.size()<=Constantes.TOT_REGEXCEL){
		            String path = conexion.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";
		            String file = "VINC_"+Constantes.VIP_SEGMENTADO_DESCRIPCION+"_"+usuario.toUpperCase()+".xls";
		            log.info("[ExportacionAction :: exportacion] file = \"" + file + "\"");
		            boolean res = false;
		            res=exportObject.exportacionMasivaSegmentada(listadoDetalle,file,path);
		            request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
		            request.getSession().setAttribute(Constantes.EXPORTACION_RUTA, path);
	            } else if (listadoDetalle.size()>Constantes.TOT_REGEXCEL){
	            	out.print("too_much");
	            }
	        } catch (Exception e) {
	    		log.error("[ExportacionAction :: exportacion] error");
	    		log.error("[ExportacionAction :: exportacion] " + e.getMessage());
	            errors.add("name", new ActionError("id"));
	        }
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }

		log.info("[ExportacionAction :: exportacion] fin");
        return null;
    }

	private String generarNombreArchivo(FormateaListado formato) {
		String fechaHoy = formato.getCod_gestor()+ "-" + String.valueOf(new java.util.Date().getTime());
        String res = "iilc-"+fechaHoy+ ".xls";
		return res;
	}
}



