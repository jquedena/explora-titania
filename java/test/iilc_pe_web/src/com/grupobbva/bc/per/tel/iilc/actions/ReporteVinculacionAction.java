package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.beans.PermisoUsuario;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.ReporteVinculacionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.impl.OficinaTerritorioDAOImpl;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanReporteVinculacionVIP;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;
import com.grupobbva.bc.per.tel.iilc.serializable.Consulta;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.json.Respuesta;

@SuppressWarnings({"unused","unchecked", "finally"})
public class ReporteVinculacionAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(ReporteVinculacionAction.class.getName());
	
	private String validarTexto(String campo) {
		String result = "";
		
		if(campo == null){
			result = "-1";
		} else if(campo.equalsIgnoreCase("null")){
			result = "-1";
		} else {
			result = campo.trim().replaceAll("\'", "");
		}
		
		return result;
	}
	
	private String[] validaTerritorioOficinaGestor(String territorio, String oficina, String gestor, String codUsuario) {

		String result[] = new String[3];
		String pTerritorio = "";
		String pOficina = "";
		OficinaTerritorioDAOImpl dao = new OficinaTerritorioDAOImpl();
		List<PermisoUsuario> listaPermisoUsuario = dao.listarPermiso(codUsuario);
				
		for (PermisoUsuario o : listaPermisoUsuario) {
			if (pTerritorio.indexOf(o.getCodTerritorio()) == -1) {
				pTerritorio += o.getCodTerritorio().trim() + ",";
			}
			if (pOficina.indexOf(o.getCodOficina()) == -1) {
				pOficina += o.getCodOficina().trim() + ",";
			}
		}
		
		if (pTerritorio.length() > 1) {
			pTerritorio = pTerritorio.substring(0, pTerritorio.length() - 1);
		}
		
		if (pOficina.length() > 1) {
			pOficina = pOficina.substring(0, pOficina.length() - 1);
		}
		
		if(territorio.equalsIgnoreCase("-1")){
			territorio = pTerritorio;
		}
		
		if(oficina.equalsIgnoreCase("-1")){
			oficina = pOficina;
		}
		
		result[0] = territorio;
		result[1] = oficina;
		result[2] = gestor;
		
		return result;
	}
	
	  public ActionForward espera(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {

	        ActionErrors errors = new ActionErrors();
	        ActionForward forward = new ActionForward(); // return value
	                       
	        try {
	            request.setAttribute("file",null);
	            request.setAttribute("rootpath",null);
	            
		        String origenVinculacion=request.getParameter("origenVinculacion");
		        request.setAttribute("origenVinculacion", origenVinculacion);
		        String tipoReporte=request.getParameter("tipoReporte");
				String territorio = validarTexto(request.getParameter("territorio"));
				String oficina = validarTexto(request.getParameter("oficina")); 
				String gestor = validarTexto(request.getParameter("gestor"));
				FormBeanReporteVinculacionVIP actionForm = (FormBeanReporteVinculacionVIP) form;
				Consulta con = new Consulta();
				con.setPagActual(1);
				
				ReporteVinculacionDAO daoReporte = new ReporteVinculacionDAO();
				List lista = daoReporte.obtenerCabeceras(tipoReporte);
	
				String cargo=request.getSession().getAttribute("codperfil").toString();

				List listaDetalleList = null;
				logger.info(cargo);
				String codUsuario = "";
				if(cargo.equalsIgnoreCase("LC06")){
					codUsuario = (String) request.getSession().getAttribute("usuario");
					String result[] = validaTerritorioOficinaGestor(territorio, oficina, gestor, codUsuario);
					territorio = result[0];
					oficina = result[1];
				}
	
				if(tipoReporte.equals(Constantes.CODIGO_VIP)){
					listaDetalleList= daoReporte.construirSelectVinculacionVIPCompleto(territorio,oficina,gestor);
				}else if(tipoReporte.equals(Constantes.CODIGO_GCO)){
					listaDetalleList= daoReporte.construirSelectVinculacionGCOCompleto(territorio,oficina,gestor);
				}else if(tipoReporte.equals(Constantes.CODIGO_PH)){
					listaDetalleList= daoReporte.construirSelectVinculacionPHCompleto(territorio,oficina,gestor);
				}
				request.getSession().setAttribute("listadoDetalle", listaDetalleList);
				
				

	        } catch (Exception e) {
	            errors.add("name", new ActionError("id"));
	            logger.error("Error al intentar exportar");
	            saveErrors(request, errors);
	        }
	        forward = mapping.findForward(Constantes.FW_ESPERA_EXPORTACION);
	        return (forward);
	        
	    }

	
	public ActionForward buscar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String tipoReporte=request.getParameter("tipoReporte");
		try{
			String territorio = validarTexto(request.getParameter("territorio"));
			String oficina = validarTexto(request.getParameter("oficina")); 
			String gestor = validarTexto(request.getParameter("gestor"));
			FormBeanReporteVinculacionVIP actionForm = (FormBeanReporteVinculacionVIP) form;
			Consulta con = new Consulta();
			con.setPagActual(1);
			
			ReporteVinculacionDAO daoReporte = new ReporteVinculacionDAO();
			List lista = daoReporte.obtenerCabeceras(tipoReporte);
	
			String cargo=request.getSession().getAttribute("codperfil").toString();
			logger.info("Cargo->" + cargo);
	
			//Indicadores si existiera valores por defecto y carga sus descripciones para los botones
			String hid_oficina="";
			String hid_territorio="";
			String hid_gestor=""; 
	
			if(cargo.equals("LC02") || cargo.equals("LC03")){
				hid_territorio=daoReporte.obtenerDescripcionTerritorio(request.getSession().getAttribute("cod_territorio").toString());
				// territorio="'"+request.getSession().getAttribute("cod_territorio").toString()+"'";
				territorio=request.getSession().getAttribute("cod_territorio").toString();
			}
			
			if(cargo.equals("LC03")){
				hid_oficina=daoReporte.obtenerDescripcionOficina(request.getSession().getAttribute("cod_oficina").toString());
				// oficina="'"+request.getSession().getAttribute("cod_oficina").toString()+"'";
				oficina=request.getSession().getAttribute("cod_oficina").toString();
			} 
			
			if(cargo.equals("LC04")){
				hid_territorio=daoReporte.obtenerDescripcionTerritorio(request.getSession().getAttribute("cod_territorio").toString());
				hid_oficina=daoReporte.obtenerDescripcionOficina(request.getSession().getAttribute("cod_oficina").toString());
				hid_gestor=daoReporte.obtenerDescripcionGestor(request.getSession().getAttribute("gestor").toString());
				/*
				territorio="'"+request.getSession().getAttribute("cod_territorio").toString()+"'";
				oficina="'"+request.getSession().getAttribute("cod_oficina").toString()+"'";
				gestor="'"+request.getSession().getAttribute("gestor").toString()+"'";
				*/
				territorio=request.getSession().getAttribute("cod_territorio").toString();
				oficina=request.getSession().getAttribute("cod_oficina").toString();
				gestor=request.getSession().getAttribute("gestor").toString();
			} 
			
			request.setAttribute("territorio", territorio);
			request.setAttribute("oficina", oficina);
			request.setAttribute("gestor", gestor);
			
			List listaDetalleList = new ArrayList();
			String pagina=request.getParameter("paginaActual");
			int cantidadDetalleList=0;
			if(pagina==null || pagina.equals("0")  || pagina.equals("") ){
				pagina="1";
			}
			
			String paginaAnt = request.getSession().getAttribute("paginaActual") == null ? "0" : request.getSession().getAttribute("paginaActual").toString();
			
			AdministracionCargaVinculacion objBean=new AdministracionCargaVinculacion();
			
			int estado = 0;
			try {
				objBean.setTipo(Integer.parseInt(tipoReporte)); // Pendiente
				ConexionDAO conDao=new ConexionDAO();
				estado=conDao.verificarExistenciaCargaSinFecha(objBean);
			} catch (NumberFormatException e) {
				log.info("Pagina diferente a las de vinculaci" + (char) 243 + "n");
			} catch (Exception e) {
				log.error(e);
			} 
			
			String codUsuario = "";
			codUsuario = (String) request.getSession().getAttribute("usuario");
			
			String perfil=request.getSession().getAttribute("codperfil").toString();
			logger.info(perfil);
			
			if(territorio.equalsIgnoreCase("-1")) {
				request.setAttribute("desc_filtro", "SIN FILTROS");
			}
			else {
				OficinaTerritorioDAOImpl ofic = new OficinaTerritorioDAOImpl();
				String temp = ofic.obtenerFiltroTerritorio(territorio, oficina, gestor, (perfil.equalsIgnoreCase("LC06") ? codUsuario : "")); 
				logger.info(temp);
				if(temp.equalsIgnoreCase("-1 (-1 (-1))")) {
					temp = "No se encuentra informaci" + (char) 243 + "n con el filtro seleccionado.";	
				}
				request.setAttribute("desc_filtro", temp);
			}
			
			if(perfil.equalsIgnoreCase("LC06")){
				String result[] = validaTerritorioOficinaGestor(territorio, oficina, gestor, codUsuario);
				territorio = result[0];
				oficina = result[1];
			}
						
			if(estado==1){
				String tipoStr="";
				if(tipoReporte.equals(Constantes.CODIGO_VIP)){
					tipoStr=Constantes.VIP_DESCRIPCION;
				}else if(tipoReporte.equals(Constantes.CODIGO_GCO)){
					tipoStr=Constantes.GCO_DESCRIPCION;
				}else if(tipoReporte.equals(Constantes.CODIGO_PH)){
					tipoStr=Constantes.PH_DESCRIPCION;
				}	
				request.setAttribute("mensaje", Constantes.MENASJE_PROCESANDO+tipoStr);
			}else{
				if(tipoReporte.equals(Constantes.CODIGO_VIP)){
					cantidadDetalleList= daoReporte.contarSelectVinculacionVIP(territorio,oficina,gestor);
				}else if(tipoReporte.equals(Constantes.CODIGO_GCO)){
					cantidadDetalleList= daoReporte.contarSelectVinculacionGCO(territorio,oficina,gestor);
				}else if(tipoReporte.equals(Constantes.CODIGO_PH)){
					cantidadDetalleList= daoReporte.contarSelectVinculacionPH(territorio,oficina,gestor);
				}
					
					
				if( Integer.parseInt(pagina)>cantidadDetalleList ){
					pagina=cantidadDetalleList+"";
				}
					
				if(tipoReporte.equals(Constantes.CODIGO_VIP)){
					listaDetalleList= daoReporte.construirSelectVinculacionVIP(pagina,territorio,oficina,gestor);
				}else if(tipoReporte.equals(Constantes.CODIGO_GCO)){
					listaDetalleList= daoReporte.construirSelectVinculacionGCO(pagina,territorio,oficina,gestor);
				}else if(tipoReporte.equals(Constantes.CODIGO_PH)){
					listaDetalleList= daoReporte.construirSelectVinculacionPH(pagina,territorio,oficina,gestor);
				}
			}
			
			request.setAttribute("hid_oficina",hid_oficina);
			request.setAttribute("hid_territorio",hid_territorio);
			request.setAttribute("hid_gestor",hid_gestor);
			request.setAttribute("paginaActual", pagina);
			request.setAttribute("hayResultados",listaDetalleList.size()>0?true:false);
			request.setAttribute("listadoDetalle", listaDetalleList);
			request.setAttribute("cantidadDetalle", cantidadDetalleList);

			request.getSession().setAttribute("paginaActual", pagina);
			request.getSession().setAttribute("cabecera", lista);
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
		}finally{
			return mapping.findForward("reporte"+tipoReporte);
		}
	}
	
	private Multitabla[] datosCabeceras(List lista) {

		Multitabla[] res = new Multitabla[0];
 
		if (lista != null) {
			res = new Multitabla[lista.size()];
			for (int i = 0; i < lista.size(); i++) {
				Multitabla multitabla=new Multitabla();
				Tiilc_conf_cabeceras_rep cabecera=(Tiilc_conf_cabeceras_rep)lista.get(i);
				multitabla.setValor1(cabecera.getDeslarga());
				res[i] = multitabla;
			}
		}

		return res;
	}
	
	
	private void respuestaArray(HttpServletResponse response, String[][] listaDetalle,List cabecera,Consulta con) throws IOException {
		PrintWriter out = response.getWriter();
		int numColumnas = 1;
		JSONArray jsonArray;
		Respuesta resp = new Respuesta();
		String strSalida;
		 
		// Cabeceras
		resp.setCabeceras(datosCabeceras(cabecera));
		numColumnas = resp.getCabeceras().length;

		// detalle filtros
		//resp.setDatosDetalleFiltros(datosDetalleFiltro(con));

		if (listaDetalle.length>1) {
			// datos


			numColumnas = resp.getCabeceras().length;

			resp.setDatos( listaDetalle );

			// paginacion
			resp.setPagActual(con.getPagActual());
			resp.setNumPags(con.getNumPags());
		}

		jsonArray = JSONArray.fromObject(resp);
		strSalida = jsonArray.toString();
		strSalida = Utilitario.ajaxEncode(strSalida);
		out.print(strSalida);
	}
	
	
}
