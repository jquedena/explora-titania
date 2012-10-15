package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_his_ingresos_carp_com;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.NumeroUtil;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionEJB;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;
import com.grupobbva.bc.per.tel.iilc.dao.HistoricoSeguimientoDAO;
import com.grupobbva.bc.per.tel.iilc.dao.ReporteVinculacionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.impl.ClienteDAOImpl;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanConsulta;
import com.grupobbva.bc.per.tel.iilc.logic.FormateaListado;
import com.grupobbva.bc.per.tel.iilc.logic.GridCliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Consulta;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.json.Respuesta;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;

@SuppressWarnings({"unused", "unchecked"})
public class Consulta2Action extends DispatchAction {
	
	private static Logger log = Logger.getLogger(Consulta2Action.class);
	private static String cabeceras_temporales[];
	private FormateaListado formato_general = null;
	private GridCliente grid = new GridCliente();
	private boolean identificador_ajax=false;

	/**
	 * Direcciona a la pagina de seleccion de empresa de pago de haberes
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward cargaEmpresa2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("[Consulta2Action :: cargaEmpresa2] inicio");
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Vector<Empresa> listaEmpresa = new Vector<Empresa>();
		try {
			String cod_territorio = request.getParameter("territorio");
			String cod_oficina = request.getParameter("oficina");
			String cod_gestor = request.getParameter("gestor");
			String nivel_vinculacion = request.getParameter("nivelVinculacion");
			String clasificacion = request.getParameter("clasificacion");
			String margen_ordinario = request.getParameter("margenOrdinario");
			String etiqueta = request.getParameter("etiqueta");
			String edad = request.getParameter("edad");
			String cuota_riesgo_total = request.getParameter("cuotaRiesgoTotal");

			if (cod_territorio.trim().equals(""))
				cod_territorio = "-1";
			if (cod_oficina.trim().equals(""))
				cod_oficina = "-1";
			if (cod_gestor == null || cod_gestor.trim().equals(""))
				cod_gestor = "-1";
			if (nivel_vinculacion.trim().equals(""))
				nivel_vinculacion = "-1";
			if (clasificacion.trim().equals(""))
				clasificacion = "-1";
			if (margen_ordinario.trim().equals(""))
				margen_ordinario = "-1";
			if (etiqueta.trim().equals(""))
				etiqueta = "-1";
			if (edad.trim().equals(""))
				edad = "-1";
			if (cuota_riesgo_total.trim().equals(""))
				cuota_riesgo_total = "-1";

			//TODO Revisar filtro
			
			cod_territorio = cod_territorio.replaceAll("\'", "");
			cod_oficina = cod_oficina.replaceAll("\'", "");
			cod_gestor = cod_gestor.replaceAll("\'", "");
			
			ConexionEJB ejb = new ConexionEJB();
			listaEmpresa = ejb.findAllEmpresasbyFilter(cod_territorio,
					cod_oficina, cod_gestor, nivel_vinculacion, clasificacion,
					margen_ordinario, etiqueta, edad, cuota_riesgo_total, "-1", "-1");

			request.setAttribute("listaEmpresa", listaEmpresa);

		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			log.error("[Consulta2Action :: cargaEmpresa2] " + e.getMessage());
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.
		forward = mapping.findForward(Constantes.FW_VER_EMPRESA);
		// Finish with

		log.info("[Consulta2Action :: cargaEmpresa2] fin");
		return (forward);

	}

	public ActionForward espera(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		try {
			request.setAttribute("file", null);
			request.setAttribute("rootpath", null);

		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			// e.printStackTrace();
			log.error("Exportando archio... :'(");
			log.error(e.getMessage());
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.

		String tipo = request.getParameter("tipo");

		if (tipo.equals("impresion"))
			forward = mapping.findForward(Constantes.FW_ESPERA_IMPRESION);
		else
			forward = mapping.findForward(Constantes.FW_ESPERA_EXPORTACION);
		// Finish with
		return (forward);

	}

	public ActionForward verDetalle(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("[Consulta2Action :: verDetalle] inicio");
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
		Vector<Cliente> listaConduccion = new Vector<Cliente>();
		int tipoDetalle = Integer.parseInt(request.getParameter("tipo_detalle"));
		Consulta con = new Consulta();

		try {
			if (formBeanConsulta.getAtog() == null) {
				response.getWriter().write("exp");
				return null;
			}

			con.setCodPerfil(formBeanConsulta.getCod_perfil());
			con.setCodGestorConsulta((String) formBeanConsulta.getAtog().get(3));

			if (formBeanConsulta.getTerritorio() == null || formBeanConsulta.getTerritorio() == "-1")
				formBeanConsulta.setTerritorio((String) formBeanConsulta.getAtog().get(1));
			if (formBeanConsulta.getOficina() == null || formBeanConsulta.getOficina() == "-1")
				formBeanConsulta.setOficina((String) formBeanConsulta.getAtog().get(2));

			con.setTerritorio(request.getParameter("territorio"));
			con.setOficina(request.getParameter("oficina"));
			con.setGestor(request.getParameter("gestor"));
			con.setNivelVinculacion(request.getParameter("nivelVinculacion"));
			con.setClasificacion(request.getParameter("clasificacion"));
			con.setMargenOrdinario(request.getParameter("margenOrdinario"));
			con.setEtiqueta(request.getParameter("etiqueta"));
			con.setEdad(request.getParameter("edad"));
			con.setCuotaRiesgoTotal(request.getParameter("cuotaRiesgoTotal"));
			con.setCodEmpresa(request.getParameter("codEmpresa"));
			con.setPagActual(1);
			con.setTipoDetalle(Constantes.TAB_GENERAL);

			String tipoCliente = request.getParameter("tipoCliente");
			String codCliente = request.getParameter("codCliente");
			String orden = request.getParameter("orden");
			
			FormateaListado formato = new FormateaListado(con.getCodPerfil()
					, con.getCodGestorConsulta()
					, con.getTerritorio()
					, con.getOficina()
					, con.getGestor()
					, con.getNivelVinculacion()
					, con.getClasificacion()
					, con.getMargenOrdinario()
					, con.getEtiqueta()
					, con.getEdad()
					, con.getCuotaRiesgoTotal()
					, con.getCodEmpresa()
					, tipoCliente
					, codCliente
					, orden
					, Integer.valueOf((String) request.getParameter("numRegXPag"))
					, Constantes.TAB_GENERAL);
			
			formBeanConsulta.setPagina((int) con.getPagActual());
			formBeanConsulta.setFormato(formato);
			formato_general = formato;
			listaConduccion = formato.obtenerListado(formBeanConsulta.getPagina(),(tipoDetalle==0) ? true : false);
					
			con.setNumPags(formato.getNum_paginas());
			
			int i;
			List<Multitabla[]> detalle = new ArrayList<Multitabla[]>();
			Multitabla[] temp;
			Multitabla[] titulo = null;
			List<String[][]> result = new ArrayList<String[][]>();
			if(listaConduccion != null) {
				if(listaConduccion.size()>0) {
					
					for(i = 0; i < 8; i++) {
						temp = grid.datosCabeceras(i, false);
						detalle.add(grid.validacion_cabecera(listaConduccion.get(0), temp.length, i, temp, true));
						if(i == 0) {
							titulo = grid.validacion_cabecera(listaConduccion.get(0), temp.length, i, temp, false);
						}
						result.add(datosResultados(listaConduccion, detalle.get(i).length, i, detalle.get(i)));
						JSONArray jsonArray = JSONArray.fromObject(result.get(i));
						log.info(jsonArray.toString());
					}
					
					request.setAttribute("titulo", detalle);
					request.setAttribute("cuerpo", result);
					
					request.setAttribute("codigo", titulo[0].getValor1());
					request.setAttribute("nombre", titulo[1].getValor1());
					request.setAttribute("tipo_persona", titulo[2].getValor1());
					request.setAttribute("perfil", "PERFIL");
					request.setAttribute("estcivil", titulo[3].getValor1());
					request.setAttribute("prefijo", titulo[4].getValor1());
					request.setAttribute("telefono", titulo[5].getValor1());
					request.setAttribute("segment1", titulo[6].getValor1());
					request.setAttribute("vinculacion", titulo[7].getValor1());
					
					request.setAttribute("cliente", listaConduccion.get(0));
				}
			}

		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			log.error("[Consulta2Action :: verDetalle] " + e);
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		forward = mapping.findForward("verDetalle");
		log.info("[Consulta2Action :: verDetalle] fin");
		return (forward);
	}

	/**
	 * Nuevo metodo de busqueda
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */	
	public ActionForward buscar2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		identificador_ajax=false;
		return buscar2SinImprimir(mapping, form, request, response);
	}
	
	public ActionForward buscar2SinImprimir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("[Consulta2Action :: buscar2] inicio");
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
		Vector<Cliente> listaConduccion = new Vector<Cliente>();
		int tipoDetalle = Integer.parseInt(request.getParameter("tipo_detalle"));
		Consulta con = new Consulta();

		try {
			if (formBeanConsulta.getAtog() == null) {
				response.getWriter().write("exp");
				return null;
			}

			con.setCodPerfil(formBeanConsulta.getCod_perfil());
			con.setCodGestorConsulta((String) formBeanConsulta.getAtog().get(3));

			if (formBeanConsulta.getTerritorio() == null || formBeanConsulta.getTerritorio() == "-1")
				formBeanConsulta.setTerritorio((String) formBeanConsulta.getAtog().get(1));
			if (formBeanConsulta.getOficina() == null || formBeanConsulta.getOficina() == "-1")
				formBeanConsulta.setOficina((String) formBeanConsulta.getAtog().get(2));

			String cod_territorio = request.getParameter("territorio");
			String cod_oficina = request.getParameter("oficina");
			String cod_gestor = request.getParameter("gestor");
			
			if(cod_territorio != null) cod_territorio = cod_territorio.replaceAll("\'", "");
			if(cod_oficina != null) cod_oficina = cod_oficina.replaceAll("\'", "");
			if(cod_gestor != null) cod_gestor = cod_gestor.replaceAll("\'", "");
			
			con.setTerritorio(cod_territorio);
			con.setOficina(cod_oficina);
			con.setGestor(cod_gestor);
			con.setNivelVinculacion(request.getParameter("nivelVinculacion"));
			con.setClasificacion(request.getParameter("clasificacion"));
			con.setMargenOrdinario(request.getParameter("margenOrdinario"));
			con.setEtiqueta(request.getParameter("etiqueta"));
			con.setEdad(request.getParameter("edad"));
			con.setCuotaRiesgoTotal(request.getParameter("cuotaRiesgoTotal"));
			con.setCodEmpresa(request.getParameter("codEmpresa"));
			con.setTipoCliente(request.getParameter("tipoCliente"));
			con.setPagActual(1);
			con.setTipoDetalle(Constantes.TAB_GENERAL);

			String codCliente = request.getParameter("codCliente");
			String orden = request.getParameter("orden");
			
			FormateaListado formato = new FormateaListado(con.getCodPerfil()
					, con.getCodGestorConsulta()
					, con.getTerritorio()
					, con.getOficina()
					, con.getGestor()
					, con.getNivelVinculacion()
					, con.getClasificacion()
					, con.getMargenOrdinario()
					, con.getEtiqueta()
					, con.getEdad()
					, con.getCuotaRiesgoTotal()
					, con.getCodEmpresa()
					, con.getTipoCliente()
					, codCliente
					, orden
					, Integer.valueOf((String) request.getParameter("numRegXPag"))
					, tipoDetalle);
			
			FormateaListado formatoXLS = new FormateaListado(con.getCodPerfil()
					, con.getCodGestorConsulta()
					, con.getTerritorio()
					, con.getOficina()
					, con.getGestor()
					, con.getNivelVinculacion()
					, con.getClasificacion()
					, con.getMargenOrdinario()
					, con.getEtiqueta()
					, con.getEdad()
					, con.getCuotaRiesgoTotal()
					, con.getCodEmpresa()
					, con.getTipoCliente()
					, codCliente
					, orden
					, Integer.valueOf((String) request.getParameter("numRegXPag"))
					, tipoDetalle);
			
			formBeanConsulta.setPagina((int) con.getPagActual());
			formBeanConsulta.setFormato(formato);
			formBeanConsulta.setFormatoXLS(formatoXLS);
			
			formato_general = formato;
			
			// El parametro es true porque siempre se ejecuta este metodo con el boton buscar y siempre muestra la pestana todos
			listaConduccion = formato.obtenerListado(formBeanConsulta.getPagina(),(tipoDetalle==0) ? true : false);
			con.setNumPags(formato.getNum_paginas());
			con.setNumRegistros(formato.getNum_registros());

			request.getSession().setAttribute("listaConduccion", listaConduccion);
			request.getSession().setAttribute("formato", formato);
			request.getSession().setAttribute("parametrosConsulta", con);
			
			if(!identificador_ajax){
				respuestaArray(response, request, listaConduccion, con);
			}

			// Cuando se hace clic en Buscar grabar Historico
			String idsession = request.getSession().getAttribute("idSession").toString();
			HistoricoSeguimientoDAO historicodao = new HistoricoSeguimientoDAO();
			Tiilc_his_ingresos_carp_com historico = null;

			// Buscar si existe la session del usuario en el Historico

			
			historico = historicodao.getHistorico(idsession);

			String nivelVinculacion = (String) request.getParameter("nivelVinculacion");
			String clasificacion = (String) request.getParameter("clasificacion");
			String margenOrdinario = (String) request.getParameter("margenOrdinario");
			String etiqueta = (String) request.getParameter("etiqueta");
			String edad = (String) request.getParameter("edad");
			String cuotaRiesgoTotal = (String) request.getParameter("cuotaRiesgoTotal");
			String pago = (String) request.getParameter("codEmpresa");

			if (nivelVinculacion != null && !nivelVinculacion.equals("-1"))
				nivelVinculacion = "1";
			if (nivelVinculacion != null && nivelVinculacion.equals("-1"))
				nivelVinculacion = "0";
			if (clasificacion != null && !clasificacion.equals("-1"))
				clasificacion = "1";
			if (clasificacion != null && clasificacion.equals("-1"))
				clasificacion = "0";
			if (margenOrdinario != null && !margenOrdinario.equals("-1"))
				margenOrdinario = "1";
			if (margenOrdinario != null && margenOrdinario.equals("-1"))
				margenOrdinario = "0";
			if (etiqueta != null && !etiqueta.equals("-1"))
				etiqueta = "1";
			if (etiqueta != null && etiqueta.equals("-1"))
				etiqueta = "0";

			if (edad != null && !edad.equals("-1"))
				edad = "1";
			if (edad != null && edad.equals("-1"))
				edad = "0";

			if (cuotaRiesgoTotal != null && !cuotaRiesgoTotal.equals("-1"))
				cuotaRiesgoTotal = "1";
			if (cuotaRiesgoTotal != null && cuotaRiesgoTotal.equals("-1"))
				cuotaRiesgoTotal = "0";

			if (pago != null && !pago.equals("-1"))
				pago = "1";
			if (pago != null && pago.equals("-1"))
				pago = "0";

			// Si existe actualiza
			if (historico != null) {
				int cla = historico.getClasificacion();

				if (cla == 1 && (new Integer(clasificacion) == 0))
					clasificacion = "1";
				historico.setClasificacion(new Integer(clasificacion));

				int cuota = historico.getCuota();
				if (cuota == 1 && (new Integer(cuotaRiesgoTotal) == 0))
					cuotaRiesgoTotal = "1";

				historico.setCuota(new Integer(cuotaRiesgoTotal));

				int edad2 = historico.getEdad();
				if (edad2 == 1 && (new Integer(edad) == 0))
					edad = "1";

				historico.setEdad(new Integer(edad));

				int eti = historico.getEtiqueta();
				if (eti == 1 && (new Integer(etiqueta) == 0))
					etiqueta = "1";

				historico.setEtiqueta(new Integer(etiqueta));

				int marg = historico.getMargen_ordinario();
				if (marg == 1 && (new Integer(margenOrdinario) == 0))
					margenOrdinario = "1";

				historico.setMargen_ordinario(new Integer(margenOrdinario));

				int ni = historico.getNivel_vinculacion();
				if (ni == 1 && (new Integer(nivelVinculacion) == 0))
					nivelVinculacion = "1";

				historico.setNivel_vinculacion(new Integer(nivelVinculacion));
				//historico.setActivo(0);
				//historico.setCanales(0);
				//historico.setOfertas(0);

				int pa = historico.getPago();
				if (pa == 1 && (new Integer(pago) == 0))
					pago = "1";

				historico.setPago(new Integer(pago));
				//historico.setPasivo(0);
				//historico.setServicios(0);
				//historico.setTarjetas(0);
				//historico.setTodos(0);
				String us = (String) request.getSession().getAttribute("usuario");
				historico.setUsuario(us);
				historicodao.actualizarHistorico(historico);
			}

			// Si no existe inserta el nuevo
			if (historico == null) {

				Perfil perfil = (Perfil) request.getSession().getAttribute("perfil");
				String usuario = request.getSession().getAttribute("usuario").toString();
				IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(usuario .trim().toUpperCase());

				historico = new Tiilc_his_ingresos_carp_com();
 
				String nombre_usuario=request.getSession().getAttribute("nombre_usuario")==null?"":request.getSession().getAttribute("nombre_usuario").toString();
				historico.setNombre_usuario(nombre_usuario);
				
				
				historico.setRegistro_id(idsession);
				Vector<String> atog = new Vector<String>();
				atog=(Vector)request.getSession().getAttribute("atog");
		        String cod_area = atog.get(0);
		        cod_territorio = atog.get(1);
		        cod_oficina = atog.get(2);
		        cod_gestor = atog.get(3);
		        
		        if(cod_territorio==null || cod_territorio.equals("null") || cod_territorio.equals("") ){
		        	cod_territorio="";
		        }
		        if(cod_oficina==null || cod_oficina.equals("null") || cod_oficina.equals("")){
		        	cod_oficina="";
		        	String cod_perfil=request.getSession().getAttribute("codperfil").toString();
		        	if(cod_perfil.equals("LC01")){
		        		cod_oficina=request.getSession().getAttribute("cod_oficina")==null?"":request.getSession().getAttribute("cod_oficina").toString();
		        	}
		        	
		        }
		        if(cod_gestor==null || cod_gestor.equals("null") || cod_gestor.equals("")){
		        	cod_gestor="";
		        }
		        
		        if(request.getSession().getAttribute("gestor")!=null){
		        	cod_gestor=request.getSession().getAttribute("gestor").toString();
		        }

		        historico.setCod_cargo(request.getSession().getAttribute("cod_cargo").toString().trim());
		        historico.setDes_cargo(request.getSession().getAttribute("des_cargo").toString().trim());
				historico.setCod_gestor(cod_gestor);
				historico.setCod_oficina(cod_oficina);
				historico.setCod_territorio(cod_territorio);
				historico.setCod_perfil(request.getSession().getAttribute("codperfil").toString().trim());
				historico.setClasificacion(new Integer(clasificacion));
				historico.setCuota(new Integer(cuotaRiesgoTotal));
				historico.setEdad(new Integer(edad));
				historico.setEtiqueta(new Integer(etiqueta));
				historico.setMargen_ordinario(new Integer(margenOrdinario));
				historico.setNivel_vinculacion(new Integer(nivelVinculacion));
				historico.setActivo(0);
				historico.setCanales(0);
				historico.setExportar(0);
				historico.setOfertas(0);
				historico.setPago(new Integer(pago));
				historico.setPasivo(0);
				historico.setServicios(0);
				historico.setTarjetas(0);
				historico.setTodos(0);
				String us = (String) request.getSession().getAttribute("usuario");
				historico.setUsuario(us);
				historicodao.registrarHistorico(historico);
			}

			return null;

		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			log.error("[Consulta2Action :: buscar2] ", e);
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.
		forward = mapping.findForward(Constantes.FW_CONSULTA);
		// Finish with
		log.info("[Consulta2Action :: buscar2] fin");
		return (forward);
	}

	/**
	 * Nuevo metodo que retorna una pestana de detalle de busqueda
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward detalle2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		int tipoDetalle = Integer.parseInt(request.getParameter("tipo_detalle"));
		identificador_ajax=true;
		buscar2SinImprimir(mapping,  form,  request,  response);
		
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Consulta con = (Consulta) request.getSession().getAttribute("parametrosConsulta");

		
		con.setTipoDetalle(tipoDetalle);
		try {
			if (request.getSession().getAttribute("formato") == null) {
				response.getWriter().write("exp");
				return null;
			}

			String idsession =  request.getSession().getAttribute("idSession").toString();
			HistoricoSeguimientoDAO historicodao = new HistoricoSeguimientoDAO();
			Tiilc_his_ingresos_carp_com historico = null;

			historico = historicodao.getHistorico(idsession);

			// Si existe actualiza
			if (historico != null) {

				int activo = historico.getActivo();

				if (activo == 0 && tipoDetalle == 1)
					activo = 1;
				historico.setActivo(activo++);

				int can = historico.getCanales();
				if (can == 0 && tipoDetalle == 5)
					can = 1;
				historico.setCanales(can);
				//historico.setExportar(0);

				int of = historico.getOfertas();
				if (of == 0 && tipoDetalle == 6)
					of = 1;

				historico.setOfertas(of);

				int pas = historico.getPasivo();
				if (pas == 0 && tipoDetalle == 3)
					pas = 1;

				historico.setPasivo(pas);

				int serv = historico.getServicios();
				if (serv == 0 && tipoDetalle == 4)
					serv = 1;

				historico.setServicios(serv);

				int t = historico.getTarjetas();
				if (t == 0 && tipoDetalle == 2)
					t = 1;

				historico.setTarjetas(t);

				if (tipoDetalle == 0)
					historico.setTodos(1);
				else
					historico.setTodos(0);

				String us = (String) request.getSession().getAttribute(
						"usuario");

				historico.setUsuario(us);

				historicodao.actualizarHistorico2(historico);
			}

			// Buscar si existe la session del usuario en el Historico

			historico = historicodao.getHistorico(idsession);

			Vector<Cliente> listaConduccion = (Vector<Cliente>) request
					.getSession().getAttribute("listaConduccion");

			FormateaListado formato = (FormateaListado) request.getSession()
					.getAttribute("formato");

			request.getSession().setAttribute("parametrosConsulta", con);
			respuestaArray(response, request, listaConduccion, con);

			return null;

		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			e.printStackTrace();
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.
		forward = mapping.findForward(Constantes.FW_CONSULTA);

		// Finish with
		return (forward);

	}

	/**
	 * Nuevo metodo que retorna una pagina de busqueda
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward paginacion2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Consulta con = (Consulta) request.getSession().getAttribute("parametrosConsulta");

		try {
			if (request.getSession().getAttribute("formato") == null) {
				response.getWriter().write("exp");
				return null;
			}
			
			int tipoDetalle = Integer.parseInt(request.getParameter("tipo_detalle"));

			con.setPagActual(Integer.parseInt(request.getParameter("numPag")));			
			FormateaListado formato = (FormateaListado) request.getSession().getAttribute("formato");
			formato.setNum_registros_x_pag(Integer.valueOf((String) request.getParameter("numRegXPag")));
			formato.setCol_orden((String) request.getParameter("orden"));
			Vector<Cliente> listaConduccion = formato.obtenerListado((int) con.getPagActual(),(tipoDetalle==0) ? true : false);
			con.setNumPags(formato.getNum_paginas());
			request.getSession().setAttribute("formato", formato);
			request.getSession().setAttribute("listaConduccion", listaConduccion);
			request.getSession().setAttribute("parametrosConsulta", con);
			respuestaArray(response, request, listaConduccion, con);

			return null;
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			log.error(e);
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.
		forward = mapping.findForward(Constantes.FW_CONSULTA);

		// Finish with
		return (forward);

	}

	/**
	 * Direcciona a la pagina de opciones de un filtro
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward filtro(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
			String tipo = request.getParameter("tipo");
			String titulo = "";
			String codMult = "";
			if (tipo == null)
				tipo = "0";
			if (tipo.equals("0")) {
				codMult = "T01";
				titulo = "Nivel de Vinculaci&oacute;n";
			} else if (tipo.equals("1")) {
				codMult = "T02";
				titulo = "Clasificaci&oacute;n";
			} else if (tipo.equals("2")) {
				codMult = "T03";
				titulo = "Margen Ordinario";
			} else if (tipo.equals("3")) {
				codMult = "T04";
				titulo = "Etiqueta";
			} else if (tipo.equals("4")) {
				codMult = "T06";
				titulo = "Edad";
			} else if (tipo.equals("5")) {
				codMult = "T07";
				titulo = "Cuota Riesgo Total";
			}else if (tipo.equals("6")) {
				codMult = "T05";
				titulo = "Segmento"; 
			}else if (tipo.equals("9")) {
				codMult = "T10";
				titulo = "Tipo Cliente"; 
			}

			Connection con = new Connection();
			Vector<Multitabla> lista = con.findAllRecord(codMult);
 
			Collections.sort(lista, new BeanComparator("valor1"));
			
			
			request.setAttribute("lista", lista);
			request.setAttribute("codMult", codMult);
			request.setAttribute("titulo", titulo);
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			e.printStackTrace();
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.
		forward = mapping.findForward("filtro");

		// Finish with
		return (forward);

	}

	public ActionForward filtroHistorico(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
		 
			String titulo = "";
			String tipo=request.getParameter("tipo").toString();
			Vector<Multitabla> lista =null;
			ReporteVinculacionDAO con = new ReporteVinculacionDAO();
			String perfil=request.getSession().getAttribute("codperfil").toString();
			String cod_area=request.getSession().getAttribute("cod_area").toString();

			log.info(perfil);
			String codUsuario = "";
			if(perfil.equalsIgnoreCase("LC06")){
				codUsuario = (String) request.getSession().getAttribute("usuario");
			}
			
			if(tipo.equals("0")){
				if(Integer.parseInt(perfil.substring(2,4))==1 ){
					cod_area=Constantes.TODOS_TERRITORIOS;
				}
				
				lista = con.obtenerFiltroTerritorio(cod_area, codUsuario);
				titulo="Territorio";				
			}else if(tipo.equals("1")){
				String cod_territorio=request.getParameter("territorio");
				lista = con.obtenerFiltroOficina(cod_territorio, codUsuario);
				titulo="Oficina";
			}else if(tipo.equals("2")){
				String cod_territorio=request.getParameter("territorio");
				String oficinia=request.getParameter("oficina");
				lista = con.obtenerFiltroGestor(cod_territorio, oficinia);
				titulo="Gestor";
			}else if(tipo.equals("3")){
				lista = con.obtenerFiltroPerfilGeneral();
				titulo="perfil";
			}
			
			request.setAttribute("lista", lista);
			request.setAttribute("titulo", titulo);
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			log.error("Filtro por territorio, oficina, gestor", e);
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.
		forward = mapping.findForward("filtro");

		// Finish with
		return (forward);

	}
	 
	public ActionForward filtroPerfil(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
		 
			String titulo = "Perfil";

			ReporteVinculacionDAO con = new ReporteVinculacionDAO();
			Vector<Multitabla> lista = con.obtenerFiltroPerfil();

			request.setAttribute("lista", lista);
			request.setAttribute("titulo", titulo);
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			e.printStackTrace();
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		// Write logic determining how the user should be forwarded.
		forward = mapping.findForward("filtro");

		// Finish with
		return (forward);

	}

	/**
	 * Construye la matriz de datos con la respuesta a retornar
	 * 
	 * @param response
	 * @param listaConduccion
	 * @param paginaActual
	 * @param numPaginas
	 * @param numTab
	 * @param codVinculacion
	 * @param codEtiqueta
	 * @throws IOException
	 */
	private void respuestaArray(HttpServletResponse response, HttpServletRequest request,
            Vector<Cliente> listaConduccion, Consulta con) throws IOException {
    PrintWriter out = response.getWriter();
    int numColumnas = 1;
    JSONArray jsonArray;
    Respuesta resp = new Respuesta();
    String strSalida;

    // Tipo de Detalle
    resp.setTipoDetalle(con.getTipoDetalle());

    // Cabeceras
    resp.setCabeceras(datosCabeceras(con.getTipoDetalle()));
    numColumnas = resp.getCabeceras().length;
    
    // Detalle Filtros
    ClienteDAOImpl dao = new ClienteDAOImpl();
    resp.setDatosDetalleFiltros(dao.datosDetalleFiltro(con));
    resp.setMensaje("No se encontraron resultados.");
    
    if (listaConduccion != null) {

            Multitabla[] cols = grid.validacion_cabecera(listaConduccion, numColumnas, (int) con.getTipoDetalle(), resp.getCabeceras());
            resp.setCabeceras(cols);
            
            numColumnas = resp.getCabeceras().length;
            resp.setDatos(datosResultados(listaConduccion, numColumnas, (int) con.getTipoDetalle(), cols));

            // Paginacion
            resp.setPagActual(con.getPagActual());
            resp.setNumPags(con.getNumPags());
            resp.setNumRegistros(con.getNumRegistros());
            
            if(listaConduccion == null && !formato_general.getCod_cliente().equalsIgnoreCase("-1")) {
                    ConexionEJB ejb = new ConexionEJB();
                    Map<String, String> result = ejb.findCliente(formato_general.getCod_cliente());
                    if(result != null) {
                            IILDPeUsuario user = (IILDPeUsuario) request.getSession().getAttribute("user");
                            String codOficinaUser = user.getBancoOficina().getCodigo();
                            Perfil perfil = (Perfil) request.getSession().getAttribute("perfil");
                            if(result.get("cod_oficina").equalsIgnoreCase(codOficinaUser) || result.get("cod_territorio").equalsIgnoreCase(codOficinaUser) || perfil.getCod_perfil().equalsIgnoreCase("LC01") || perfil.getCod_perfil().equalsIgnoreCase("LC06") ) {
                                    resp.setMensaje("No se encontraron resultados.");
                            } else {
                            	
                            	StringBuilder sbMensaje = new StringBuilder();
                            	sbMensaje.append("\t\tNo se permite visualizar\n");
                            	sbMensaje.append("Cliente es PRINCIPAL de la oficina ");
                            	sbMensaje.append(result.get("des_oficina").trim());
                            	sbMensaje.append(" y su gestor es\n");
                            	sbMensaje.append("\t\t");
                            	sbMensaje.append(result.get("nom_gestor").trim());
                            	sbMensaje.append(" - ");
                            	sbMensaje.append(result.get("perfil_gestor").trim());

                                resp.setMensaje(sbMensaje.toString());   
                                
                            }
                            resp.setCodigoOficina(result.get("cod_oficina"));
                    } else {
                            resp.setMensaje("El cliente no existe");
                    }
            }
    }

    if(listaConduccion == null && !formato_general.getCod_cliente().equalsIgnoreCase("-1")) {
            ConexionEJB ejb = new ConexionEJB();
            Map<String, String> result = ejb.findCliente(formato_general.getCod_cliente());
            if(result != null) {
                    IILDPeUsuario user = (IILDPeUsuario) request.getSession().getAttribute("user");
                    String codOficinaUser = user.getBancoOficina().getCodigo();
                    Perfil perfil = (Perfil) request.getSession().getAttribute("perfil");
                    if(result.get("cod_oficina").equalsIgnoreCase(codOficinaUser) || result.get("cod_territorio").equalsIgnoreCase(codOficinaUser) || perfil.getCod_perfil().equalsIgnoreCase("LC01") || perfil.getCod_perfil().equalsIgnoreCase("LC06") ) {
                            resp.setMensaje("No se encontraron resultados.");
                    } else {
                    	
                    	StringBuilder sbMensaje = new StringBuilder();
                    	sbMensaje.append("\t\tNo se permite visualizar\n");
                    	sbMensaje.append("Cliente es PRINCIPAL de la oficina ");
                    	sbMensaje.append(result.get("des_oficina").trim());
                    	sbMensaje.append(" y su gestor es\n");
                    	sbMensaje.append("\t\t");
                    	sbMensaje.append(result.get("nom_gestor").trim());
                    	sbMensaje.append(" - ");
                    	sbMensaje.append(result.get("perfil_gestor").trim());

                        resp.setMensaje(sbMensaje.toString()); 
                        
                    }
                    resp.setCodigoOficina(result.get("cod_oficina"));
            } else {
                    resp.setMensaje("El cliente no existe");
            }
    }
    
    jsonArray = JSONArray.fromObject(resp);
    strSalida = jsonArray.toString();
    log.info(strSalida);
    strSalida = Utilitario.ajaxEncode(strSalida);
    out.print(strSalida);
}
	
	private String[][] datosResultados(Vector<Cliente> lista, int numColumnas, int numTab, Multitabla[] cabecera) {
		GridCliente grid = new GridCliente();
		return grid.datosResultados(lista, numColumnas, numTab, cabecera);
	}

	private Multitabla[] datosCabeceras(long tipoDetalle) {
		return grid.datosCabeceras(tipoDetalle);
	}

	public ActionForward listaOficinas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		String strSalida = "";

		Vector<Oficina> res = new Vector<Oficina>(0, 1);
		Connection conexion = new Connection();
		FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
		String codArea = (String) formBeanConsulta.getAtog().get(0);
		String codTerritorio = request.getParameter("cod1");
		res = conexion.findAllOficinaxTe(codArea, codTerritorio);

		JSONArray jsonArray = JSONArray.fromObject(res);
		strSalida = jsonArray.toString();
		strSalida = Utilitario.ajaxEncode(strSalida);
		out.print(strSalida);

		return null;
	}

	public ActionForward listaGestores(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		String strSalida = "";

		Vector<Gestor> res = new Vector<Gestor>(0, 1);
		Connection conexion = new Connection();
		FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
		String codArea = (String) formBeanConsulta.getAtog().get(0);
		String codTerritorio = request.getParameter("cod1");
		String codOficina = request.getParameter("cod2");
		res = conexion.findAllGestorxOfxTe(codArea, codTerritorio, codOficina);

		JSONArray jsonArray = JSONArray.fromObject(res);
		strSalida = jsonArray.toString();
		strSalida = Utilitario.ajaxEncode(strSalida);
		out.print(strSalida);

		return null;
	}

	public ActionForward test(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		out.write("test");
		return null;
	}

}