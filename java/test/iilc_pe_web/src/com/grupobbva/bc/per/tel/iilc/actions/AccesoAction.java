package com.grupobbva.bc.per.tel.iilc.actions;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.beans.PermisoUsuario;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionEJB;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanConsulta;
import com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.service.impl.OficinaTerritorioServiceImpl;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;

public class AccesoAction extends Action {

	private Logger logger = Logger.getLogger(this.getClass());
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// ServletBeanFactory factory=new ServletBeanFactory();
		// factory.inicializarBeans(request);

		ActionForward forward = new ActionForward();
		FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
		Connection conexion = new Connection();
		String usuario = "";
		PermisoPerfil permisoPerfil = null;

		usuario = (String) request.getSession().getAttribute("usuario");
		String pTerritorio = "";
		String pOficina = "";
		OficinaTerritorioServiceImpl oficinaTerritorioService = new OficinaTerritorioServiceImpl();
		List<PermisoUsuario> listaPermisoUsuario = oficinaTerritorioService.listarPermiso(usuario);
		
		for(PermisoUsuario o : listaPermisoUsuario) {
			if(pTerritorio.indexOf(o.getCodTerritorio())==-1) {
				pTerritorio += o.getCodTerritorio().trim() + ",";
			}
			if(pOficina.indexOf(o.getCodOficina())==-1) {
				pOficina += o.getCodOficina().trim() + ",";
			}
		}
		
		if(pTerritorio.length()>1){
			pTerritorio = pTerritorio.substring(0, pTerritorio.length() -1);
		}
		
		if(pOficina.length()>1){
			pOficina = pOficina.substring(0, pOficina.length() -1);
		}
		
		request.setAttribute("pTerritorio", pTerritorio);
		request.setAttribute("pOficina", pOficina);
		
		
		if (request.getParameter("salteando").equalsIgnoreCase("true")) {
			usuario = request.getSession().getAttribute("usuario").toString();
			IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(usuario.trim().toUpperCase());
			String cod_cargo = user.getCargo().getCodigo();
			String des_cargo = user.getCargo().getDescripcion();
			request.getSession().setAttribute("cod_cargo", cod_cargo);
			request.getSession().setAttribute("des_cargo", des_cargo);
			if (user != null) {
				permisoPerfil = conexion.findComponente(usuario, cod_cargo, "");
			}			
			
			if(permisoPerfil == null) {
				OficinaTerritorioServiceImpl oficina = new OficinaTerritorioServiceImpl();
				List<PermisoUsuario> lista = oficina.listarPermiso(usuario.trim().toUpperCase());
				if(lista!=null){
					if(lista.size()>0){

						request.getSession().setAttribute("terr", "FALSE");
						request.getSession().setAttribute("ofic", "FALSE");
						request.getSession().setAttribute("gest", "");
						request.getSession().setAttribute("codperfil", "LC06");
						Perfil perfil = new Perfil();
						perfil.setCod_perfil("LC06");
						perfil.setDes_perfil("CONSULTA");
						perfil.setComponente("TRUE-TRUE-FALSE");
						permisoPerfil = new PermisoPerfil();
						permisoPerfil.setCod_perfil("LC06");
						permisoPerfil.setTipo_acceso(BigDecimal.ONE);
						permisoPerfil.setValor_rcp(usuario.trim().toUpperCase());
						permisoPerfil.setPerfil(perfil);
					}
				}
			}
			
			if (!carga(request, permisoPerfil.getPerfil(), formBeanConsulta, usuario, user)) {
				request.setAttribute("mensaje", "Usuario no tiene acceso");
				return mapping.findForward(Constantes.FW_ERROR);
			}
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			ConexionEJB ejb = new ConexionEJB();
			EstadoCarga estado = ejb.ultimoFechaCarga();
			if(estado != null){
				if(estado.getFechaFin() != null) {
					request.setAttribute("fechaCarga", formatter.format(estado.getFechaFin()));
				} else {
					request.setAttribute("fechaCarga", "No se han ejecutado cargas hasta el momento.");
				}
			} else {
				request.setAttribute("fechaCarga", "Ha ocurrido un error al realizarce la carga.");
			}
			
			forward = mapping.findForward(Constantes.FW_PRINCIPAL);
		}
		return (forward);
	}
	
	private boolean carga(HttpServletRequest request, Perfil perfil,
			FormBeanConsulta formBeanConsulta, String usuario,
			IILDPeUsuario user) {
		Connection conexion = new Connection();
		ConexionDAO conexion2 = new ConexionDAO();
		Vector<Territorio> listaTerritorio = new Vector<Territorio>();
		Vector<Oficina> listaOficina = new Vector<Oficina>();
		Vector<Gestor> listaGestor = new Vector<Gestor>();

		Vector<String> atog = new Vector<String>();
		Vector<String> atogAux = new Vector<String>();

		Oficina beanOfi = null;
		Territorio beanTer = null;
		beanOfi = conexion.datosOficina(user.getBancoOficina().getCodigo());
		if (beanOfi != null && beanOfi.getCod_oficina() != null) {
			// Gerente de Oficina
			atogAux.add(beanOfi.getCod_area());
			atogAux.add(beanOfi.getCod_territorio());
			atogAux.add(beanOfi.getCod_oficina());
			atogAux.add("");
		} else {
			if (user.getNivel3().getCodigo().equals(user.getNivel4().getCodigo())) {
				// Gerente Territorial
				beanTer = conexion.datosTerritorio(user.getBancoOficina().getCodigo());
				atogAux.add(beanTer.getCod_area());
				atogAux.add(beanTer.getCod_territorio());
				atogAux.add(beanTer.getCod_territorio());
				atogAux.add("");
			} else {
				atogAux.add("");
				atogAux.add("");
				atogAux.add("");
				atogAux.add("");
			}
		}
		try {
			atog = conexion.findATOG(usuario);
		} catch (Exception e) {
			logger.error("No se encontro la secuencia ATOG: " + usuario);
		}
		if (atog == null || atog.size() == 0) {
			if (perfil.getComponente().equalsIgnoreCase("TRUE-TRUE-TRUE"))
				return false;
			else {
				if (perfil.getComponente().equalsIgnoreCase("TRUE-FALSE-FALSE"))
					atogAux.setElementAt("", 2);
				if (perfil.getComponente().equalsIgnoreCase("FALSE-FALSE-FALSE")) {
					atogAux.setElementAt("", 2);
					atogAux.setElementAt("", 1);
				}
				atog = atogAux;
			}
		}
		formBeanConsulta.setAtog(atog);
		formBeanConsulta.setCod_perfil(perfil.getCod_perfil());
		String cod_area = atog.get(0) == null ? "" : atog.get(0);
		String cod_territorio = atog.get(1);
		String cod_oficina = atog.get(2);
		String cod_gestor = atog.get(3);

		if (perfil.getCod_perfil().equals("LC01")) {
			cod_oficina = user.getBancoOficina().getCodigo();
		}

		request.getSession().setAttribute("cod_oficina", cod_oficina);
		request.getSession().setAttribute("cod_area", cod_area);
		request.getSession().setAttribute("cod_territorio", cod_territorio);

		String cod_cargo = (String) request.getSession().getAttribute("codigoCargo");

		switch (Integer.parseInt(perfil.getCod_perfil().substring(2, 4))) {
		case 4:
			formBeanConsulta.setTerritorio(cod_territorio);
			formBeanConsulta.setOficina(cod_oficina);
			if (cod_cargo.equals("B23")) {
				String codGestorMasa = conexion.findGestorMasaOficina(cod_oficina);
				request.getSession().setAttribute("gestor", codGestorMasa);
				formBeanConsulta.setGestor(codGestorMasa);
			} else {
				formBeanConsulta.setGestor(cod_gestor);
				request.getSession().setAttribute("gestor", cod_gestor);
			}
			listaTerritorio = conexion.findAllTerritorio(cod_area);
			listaOficina = conexion.findAllOficinaxTe(cod_area, cod_territorio);
			listaGestor = conexion.findAllGestorxOfxTe(cod_area, cod_territorio, cod_oficina);
			break;
		case 3:
			formBeanConsulta.setTerritorio(cod_territorio);
			formBeanConsulta.setOficina(cod_oficina);

			if (cod_cargo.equals("B25") || cod_cargo.equals("B52") || cod_cargo.equals("B67")) {
				formBeanConsulta.setGestor(cod_gestor);
			} else {
				formBeanConsulta.setGestor("-1");
			}
			listaTerritorio = conexion.findAllTerritorio(cod_area);
			listaOficina = conexion.findAllOficinaxTe(cod_area, cod_territorio);
			listaGestor = conexion.findAllGestorxOfxTe(cod_area, cod_territorio, cod_oficina);
			break;
		case 2:
			formBeanConsulta.setTerritorio(cod_territorio);
			formBeanConsulta.setOficina("-1");
			formBeanConsulta.setGestor("-1");
			listaTerritorio = conexion.findAllTerritorio(cod_area);
			listaOficina = conexion.findAllOficinaxTe(cod_area, cod_territorio);
			break;
		case 1:
			formBeanConsulta.setTerritorio("-1");
			formBeanConsulta.setOficina("-1");
			formBeanConsulta.setGestor("-1");
			listaTerritorio = conexion.findAllTerritorio(Constantes.TODOS_TERRITORIOS);
			break;
		}

		request.setAttribute("listaNivelVinculacion", conexion.findAllRecord(Constantes.TABLA_NIVEL_VINCULACION));
		request.setAttribute("listaClasificacion", conexion.findAllRecord(Constantes.TABLA_CLASIFICACION));
		request.setAttribute("listaMargenOrdinario", conexion.findAllRecord(Constantes.TABLA_MARGEN_ORDINARIO));
		request.setAttribute("listaEtiqueta", conexion.findAllRecord(Constantes.TABLA_ETIQUETA));
		request.setAttribute("listaEdad", conexion.findAllRecord(Constantes.TABLA_EDAD));
		request.setAttribute("listaCuotaRiesgoTotal", conexion.findAllRecord(Constantes.TABLA_CUOTA_RIESGO_TOTAL));
		request.setAttribute("link1", conexion2.findRecord(Constantes.LINK1).getValor1());

		request.setAttribute("listaTerritorio", listaTerritorio);
		request.setAttribute("listaOficina", listaOficina);
		request.setAttribute("listaGestor", listaGestor);
		request.getSession().setAttribute("listaConduccion", null);
		formBeanConsulta.setTipo_detalle("dt_general");
		request.getSession().setAttribute("detalle", formBeanConsulta.getTipo_detalle());
		request.getSession().setAttribute("table_width", "3150px");

		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("usuario", usuario);
		
		request.getSession().setAttribute("atog", atog);
		request.getSession().setAttribute("perfil", perfil);

		request.getSession().removeAttribute("listaFamilias");
		request.getSession().removeAttribute("listaNivelVin");
		request.getSession().removeAttribute("tituloNV");
		request.getSession().removeAttribute("listaEtiSeg");
		request.getSession().removeAttribute("tituloETySEG");

		return true;
	}
}