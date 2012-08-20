package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.dao.ReporteVinculacionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.impl.OficinaTerritorioDAOImpl;

@SuppressWarnings({"unused", "unchecked"})
public class ReporteHistoricoSeguimientoAction extends DispatchAction {

	static Logger logger = Logger.getLogger(ReporteVinculacionAction.class
			.getName());

	
	public ActionForward espera(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		
        ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
                       
        try {
            request.setAttribute("file",null);
            request.setAttribute("rootpath",null);
            
        } catch (Exception e) {
            errors.add("name", new ActionError("id"));
            e.printStackTrace();
        }
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }
        
        
		String tipoReporte = request.getParameter("tipoReporte");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String territorio = request.getParameter("territorio");
		String oficina = request.getParameter("oficina");
		String perfil = request.getParameter("perfil");
		String gestor = request.getParameter("gestor");
		String fechaOficinal="";
		ReporteVinculacionDAO dao=new ReporteVinculacionDAO();
		Calendar hoy = Calendar.getInstance();
		
		fechaOficinal=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR);
		
		
		if(fechaInicio==null){
			fechaInicio=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR);
		}
		
		if(fechaFin==null){
			fechaFin=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR);
		}
		
		try {
 
			//Indicadores si existiera valores por defecto y carga sus descripciones para los botones
			String hid_oficina="";
			String hid_territorio="";
			String hid_gestor="";
			String cargo=request.getSession().getAttribute("codperfil").toString();
			String cod_area=request.getSession().getAttribute("cod_area").toString();
			
			if(cargo.equals("LC02") || cargo.equals("LC03")){
				hid_territorio=dao.obtenerDescripcionTerritorio(request.getSession().getAttribute("cod_territorio").toString());
				territorio="'"+request.getSession().getAttribute("cod_territorio").toString()+"'";
			}
			
			if(cargo.equals("LC03")){
				hid_oficina=dao.obtenerDescripcionOficina(request.getSession().getAttribute("cod_oficina").toString());
				oficina="'"+request.getSession().getAttribute("cod_oficina").toString()+"'";
			} 
			
			if(cargo.equals("LC04")){
				hid_gestor=dao.obtenerDescripcionGestor(request.getSession().getAttribute("gestor").toString());
				gestor="'"+request.getSession().getAttribute("gestor").toString()+"'";
				hid_territorio=dao.obtenerDescripcionTerritorio(request.getSession().getAttribute("cod_territorio").toString());
				territorio="'"+request.getSession().getAttribute("cod_territorio").toString()+"'";
				hid_oficina=dao.obtenerDescripcionOficina(request.getSession().getAttribute("cod_oficina").toString());
				oficina="'"+request.getSession().getAttribute("cod_oficina").toString()+"'";
			} 
			
 
			
			ReporteVinculacionDAO daoReporte = new ReporteVinculacionDAO();
			List listaDetalleList = daoReporte.construirSelectHistoricoCompleto(tipoReporte,fechaInicio,fechaFin,territorio,oficina,perfil,gestor);
 
	        String origenVinculacion=request.getParameter("origenVinculacion");
	        request.setAttribute("origenVinculacion", origenVinculacion);
			request.getSession().setAttribute("listadoDetalle", listaDetalleList); 

			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return mapping.findForward("espera_exportacion");
	}
	
	public ActionForward buscar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String tipoReporte = request.getParameter("tipoReporte");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String territorio = request.getParameter("territorio");
		String oficina = request.getParameter("oficina");
		String perfil = request.getParameter("perfil");
		String gestor = request.getParameter("gestor");
		String fechaOficinal="";
		ReporteVinculacionDAO dao=new ReporteVinculacionDAO();
		Calendar hoy = Calendar.getInstance();
		
		
		fechaOficinal=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR);
		
		
		if(fechaInicio==null){
			fechaInicio=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR);
		}
		
		if(fechaFin==null){
			fechaFin=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR);
		}
		
		try {
 
		 
			//Indicadores si existiera valores por defecto y carga sus descripciones para los botones
			String hid_oficina="";
			String hid_territorio="";
			String hid_gestor="";
			String cargo=request.getSession().getAttribute("codperfil").toString();
 
			if(cargo.equals("LC02") || cargo.equals("LC03")){
				hid_territorio=dao.obtenerDescripcionTerritorio(request.getSession().getAttribute("cod_territorio").toString());
				territorio="'"+request.getSession().getAttribute("cod_territorio").toString()+"'";
			}
			
			if(cargo.equals("LC03")){
				hid_oficina=dao.obtenerDescripcionOficina(request.getSession().getAttribute("cod_oficina").toString());
				oficina="'"+request.getSession().getAttribute("cod_oficina").toString()+"'";
			} 
			
			if(cargo.equals("LC04")){
				hid_gestor=dao.obtenerDescripcionGestor(request.getSession().getAttribute("gestor").toString());
				gestor="'"+request.getSession().getAttribute("gestor").toString()+"'";
				hid_territorio=dao.obtenerDescripcionTerritorio(request.getSession().getAttribute("cod_territorio").toString());
				territorio="'"+request.getSession().getAttribute("cod_territorio").toString()+"'";
				hid_oficina=dao.obtenerDescripcionOficina(request.getSession().getAttribute("cod_oficina").toString());
				oficina="'"+request.getSession().getAttribute("cod_oficina").toString()+"'";
			} 
			
			String pagina=request.getParameter("paginaActual");
			int cantidadDetalleList=0;
			
			ReporteVinculacionDAO daoReporte = new ReporteVinculacionDAO();
			cantidadDetalleList= daoReporte.contarSelectHistorico(tipoReporte,fechaInicio,fechaFin,territorio,oficina,perfil,gestor);
			if(pagina==null || pagina.equals("0")  || pagina.equals("") ){
				pagina="1";
			}else if( Integer.parseInt(pagina)>cantidadDetalleList ){
				pagina=cantidadDetalleList+"";
			}
			
			
			List listaDetalleList = new ArrayList();

			if(dao.validarFechas(fechaInicio,fechaFin,"dd-MM-yyyy").equals("1")){
				request.setAttribute("mensaje", "La fecha de inicio debe ser anterior a la fecha de fin"); 
			}else{
				listaDetalleList=daoReporte.construirSelectHistorico(tipoReporte,fechaInicio,fechaFin,territorio,oficina,perfil,gestor,pagina);
				request.setAttribute("mensaje", "");
			}

			String perfil_x=request.getSession().getAttribute("codperfil").toString();
			logger.info(perfil_x);
			String codUsuario = "";
			if(perfil_x.equalsIgnoreCase("LC06")){
				codUsuario = (String) request.getSession().getAttribute("usuario");
			}
			
			OficinaTerritorioDAOImpl ofic = new OficinaTerritorioDAOImpl();
			String temp = "";
			if(territorio.equalsIgnoreCase("-1") && perfil.equalsIgnoreCase("-1")) {
				request.setAttribute("desc_filtro", "SIN FILTROS");
			}
			else {
				if(!territorio.equalsIgnoreCase("-1")) {
					temp = ofic.obtenerFiltroTerritorio(territorio, oficina, gestor, codUsuario); 
					logger.info(temp);
				}
				
				if(!perfil.equalsIgnoreCase("-1")) {
					if(temp.length() > 0) temp += "<br>";
					temp += ofic.obtenerFiltroPerfil(perfil); 
					logger.info(temp);
				}
				
				request.setAttribute("desc_filtro", temp);
			}			

			request.setAttribute("paginaActual", pagina);
			request.setAttribute("cantidadDetalle", cantidadDetalleList);
			request.setAttribute("fechaOriginal",fechaOficinal);
			request.setAttribute("hid_oficina",hid_oficina);
			request.setAttribute("hid_territorio",hid_territorio);
			request.setAttribute("hid_gestor",hid_gestor);
			request.setAttribute("fechaFin",fechaFin);
			request.setAttribute("fechaInicio",fechaInicio);
			request.setAttribute("hayResultados",listaDetalleList.size() > 0 ? true : false);
			request.setAttribute("listadoDetalle", listaDetalleList); 

			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return mapping.findForward("reporte");
	}


}