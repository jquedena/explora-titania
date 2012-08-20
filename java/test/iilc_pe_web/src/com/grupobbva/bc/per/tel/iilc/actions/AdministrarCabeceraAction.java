package com.grupobbva.bc.per.tel.iilc.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;

@SuppressWarnings("unchecked")
public class AdministrarCabeceraAction extends DispatchAction {

	public ActionForward administrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("default");
	}
	
	public ActionForward listarCarpeta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String tipo = request.getParameter("tipo") == null ? "7" :  request.getParameter("tipo");
		AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();
		List listCarpeta = daolistado.obtenerDescripcion(tipo);
		
		String title = "";
		if(tipo.equalsIgnoreCase("7")) title = "ADMINISTRADOR CABECERA PESTA&Ntilde;A TODO";
		if(tipo.equalsIgnoreCase("8")) title = "ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE ACTIVO";
		if(tipo.equalsIgnoreCase("9")) title = "ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE TARJETA";
		if(tipo.equalsIgnoreCase("10")) title = "ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE PASIVO";
		if(tipo.equalsIgnoreCase("11")) title = "ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE SERVICIOS";
		if(tipo.equalsIgnoreCase("12")) title = "ADMINISTRADOR CABECERA PESTA&Ntilde;A OTRAS OFERTAS";
		if(tipo.equalsIgnoreCase("13")) title = "ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE OFERTAS";
		
		
		if (listCarpeta != null) {
			request.getSession().setAttribute("carpeta", listCarpeta);
			request.setAttribute("title", title);
		}
		return mapping.findForward("administrar");
	}
	
	public ActionForward glosario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();
		List listCarpeta = daolistado.obtenerDescripcion("6");
		request.setAttribute("listadoRadios", listCarpeta);
		
		int i;
		// 7 a 13 -- Cabeceras de Carpetas Comerciales
		List<List> listas = new ArrayList<List>();
		for(i = 7; i < 14; i++) {
			listCarpeta = daolistado.obtenerDescripcion(String.valueOf(i));
			if (listCarpeta != null) {
				listas.add(listCarpeta);
			}
		}
		request.setAttribute("carpetas", listas);
		return mapping.findForward("glosario");
	}
	
	public ActionForward registrarCabecera(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();     
		List listado = (List) request.getSession().getAttribute("carpeta");
		Tiilc_conf_cabeceras_rep e;
		String corta;
		String larga;
		String agrupador1;
		String agrupador2;
		String oculto;
		String usuario = request.getSession().getAttribute("usuario").toString();
		for(int i = 0; i < listado.size() ; i++){	
			e = (Tiilc_conf_cabeceras_rep) listado.get(i);
			if(e.getDetalle().indexOf("disabled") == -1) {
				corta = request.getParameter("corta_" + e.getOrden());
				larga = request.getParameter("larga_" + e.getOrden());
				agrupador1 = request.getParameter("agrupacion_1_" + e.getOrden());
				agrupador2 = request.getParameter("agrupacion_2_" + e.getOrden());
				oculto = request.getParameter("oculto_" + e.getOrden()) == null ? "" : request.getParameter("oculto_" + e.getOrden());
				e.setDescorta(corta);
				e.setDeslarga(larga);
				e.setAgrupador1(agrupador1);
				e.setAgrupador2(agrupador2);
				e.setOculto(oculto.equalsIgnoreCase("on") ? "1" : "0");
				e.setUsuaModi(usuario);
				daolistado.actualizarDescripcionAgrupada(e);
			}
		}
		request.getSession().removeAttribute("carpeta");
		request.setAttribute("mensaje", "Registros actualizados correctamente.");                                                 
		// return mapping.findForward("administrar");
		return listarCarpeta(mapping, form, request, response);
	}
}
