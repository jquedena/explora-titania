package com.grupobbva.bc.per.tel.iilc.actions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.beans.Menu;
import com.grupobbva.bc.per.tel.iilc.beans.PermisoUsuario;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;
import com.grupobbva.bc.per.tel.iilc.dao.impl.OficinaTerritorioDAOImpl;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanConsulta;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.service.impl.OficinaTerritorioServiceImpl;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;

public class IndexAction extends Action {

	private Logger logger = Logger.getLogger(this.getClass());
			
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String usuario = "";
		PermisoPerfil permisoPerfil = null;
		FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
		ServiciosSeguridadBbva ssBbva = new ServiciosSeguridadBbva(request);
		Connection conexion = new Connection();
		ConexionDAO conexion2 = new ConexionDAO();
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		List<Menu> listMenu = null;
		IILDPeUsuario user = null;

		String componente;
		String terr;
		String ofic = "";
		String gest;
		
		try {
			String opt = request.getParameter("opt") == null ? "" : request.getParameter("opt");
			if(opt.equalsIgnoreCase("vinculacion")){
				listMenu = createMenuVinculacion("");
				request.setAttribute("menuVinculacion", listMenu);
				request.setAttribute("indexPage", listMenu.get(0).getHref());
				request.setAttribute("frameName", "frameBodyChild");
				forward = mapping.findForward("default");
				return forward;
			}
			
			if (formBeanConsulta.getUsuario() != null) {
				usuario = formBeanConsulta.getUsuario().toUpperCase();
			}else {
				if (ssBbva != null) {
					ssBbva.obtener_ID();
					usuario = ssBbva.getUsuario();
				}
			}

			user = IILDPeUsuario.recuperarUsuario(usuario.trim().toUpperCase());
			String cod_cargo = user.getCargo().getCodigo();
			request.getSession().setAttribute("nombre_usuario", user.getNombreCompleto().toUpperCase());
			request.getSession().setAttribute("usuario", usuario);

			if (user != null) {
				permisoPerfil = conexion.findComponente(usuario, cod_cargo, "");
				
				if (permisoPerfil != null) {
					if (!permisoPerfil.getPerfil().getDes_perfil().equals("ADMINISTRADOR")) {
						componente = permisoPerfil.getPerfil().getComponente();
						terr = componente.substring(0, componente.indexOf("-"));
						ofic = componente.substring((componente.indexOf("-") + 1), componente.lastIndexOf("-"));
						gest = "";

						if (cod_cargo.equals("B25")
								|| cod_cargo.equals("B52")
								|| cod_cargo.equals("B23")
								|| cod_cargo.equals("B67")) {
							gest = "TRUE";
						} else {
							gest = componente.substring((componente.lastIndexOf("-") + 1), componente.length());
						}

						request.getSession().setAttribute("cod_cargo", cod_cargo);
						request.getSession().setAttribute("terr", terr);
						request.getSession().setAttribute("ofic", ofic);
						request.getSession().setAttribute("gest", gest);
						request.getSession().setAttribute("codperfil", permisoPerfil.getPerfil().getCod_perfil());
						request.getSession().setAttribute("perfil", permisoPerfil);
						request.getSession().setAttribute("codigoCargo", user.getCargo().getCodigo());

						AdmDescCabRepDAO dao = new AdmDescCabRepDAO();
						List<?> listadoRadios = dao.obtenerDescripcion("6");
						request.getSession().setAttribute("listadoRadios", listadoRadios);
					}
				} else {
					OficinaTerritorioServiceImpl oficina = new OficinaTerritorioServiceImpl();
					List<PermisoUsuario> lista = oficina.listarPermiso(usuario.trim().toUpperCase());
					if(lista!=null){
						if(lista.size()>0){
							request.getSession().setAttribute("cod_cargo", cod_cargo);
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
							request.getSession().setAttribute("perfil", permisoPerfil);
							request.getSession().setAttribute("codperfil", permisoPerfil.getPerfil().getCod_perfil());
							request.getSession().setAttribute("codigoCargo", user.getCargo().getCodigo());
							
							AdmDescCabRepDAO dao = new AdmDescCabRepDAO();
							List<?> listadoRadios = dao.obtenerDescripcion("6");
							request.getSession().setAttribute("listadoRadios", listadoRadios);
						}
					}
				}
				
				OficinaTerritorioDAOImpl oficinaDao = new OficinaTerritorioDAOImpl();
				if(!oficinaDao.verificarGestor(usuario.trim().toUpperCase(), user.getBancoOficina().getCodigo(), cod_cargo) && !(
						permisoPerfil.getCod_perfil().equalsIgnoreCase("LC06") ||
						permisoPerfil.getCod_perfil().equalsIgnoreCase("LC05") ||
						permisoPerfil.getCod_perfil().equalsIgnoreCase("LC02") ||
						permisoPerfil.getCod_perfil().equalsIgnoreCase("LC01") )) {
					request.setAttribute("mensaje", "Su c&oacute;digo de registro no est&aacute; registrado en el archivo de gestores de la aplicaci&oacute;n de Carpetas Comerciales.");
					forward = mapping.findForward(Constantes.FW_ERROR);
					return forward;
				}
				
			}
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			request.setAttribute("mensaje", "La p&aacute;gina no se encuentra disponible");
			forward = mapping.findForward(Constantes.FW_ERROR);
		} else {
			if (permisoPerfil != null) {
				if (permisoPerfil.getPerfil().getDes_perfil().equals("ADMINISTRADOR")) {
					String rutaLog = conexion2.findRecord(Constantes.PATH).getValor1().trim() + "temp/";
					request.setAttribute("rutaLog", rutaLog);
					forward = mapping.findForward(Constantes.FW_ADMINISTRADOR);
				} else {
					listMenu = createMenu(permisoPerfil.getCod_perfil());
					request.setAttribute("menu", listMenu);
					request.setAttribute("indexPage", listMenu.get(0).getHref());
					request.setAttribute("frameName", "frameBody");
					forward = mapping.findForward("default");
				}
			} else {
				request.setAttribute("mensaje", "Usuario no tiene acceso");
				forward = mapping.findForward(Constantes.FW_ERROR);
			}
		}

		// Cuando se hace clic en Buscar grabar Historico
		
		Calendar hoy=Calendar.getInstance();
		String fecha= 
			Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+
			Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+
			hoy.get(Calendar.YEAR)+
			Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+
			Utilitario.dosCeros(hoy.get(Calendar.MINUTE))+
			Utilitario.dosCeros(hoy.get(Calendar.SECOND));
		String idsession = usuario+fecha+request.getSession().getId();
		
		if(request.getSession().getAttribute("idSession") == null) {
			if(idsession.length()>250){
				idsession=idsession.substring(0,249);
			}
			request.getSession().setAttribute("idSession",idsession);
		}
		
		/* Inicio Modificacion */
		Vector<String> atog = new Vector<String>();
		Vector<String> atogAux = new Vector<String>();

		Oficina beanOfi = null;
		Territorio beanTer = null;
		
		beanOfi = null;
		if(user.getBancoOficina() != null)
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
			atog = atogAux;
		}
		request.getSession().setAttribute("atog", atog);
		/* Fin Modificacion */
		return forward;
	}
	
	private List<Menu> createMenu(String codPerfil) {
		List<Menu> listMenu = new ArrayList<Menu>();
		
		listMenu.add(new Menu("Carpetas Comerciales", "/indexApp.do?salteando=true"));
		listMenu.add(new Menu("Listado de Vinculaci&oacute;n", "/accesoIilc.do?opt=vinculacion"));
		// listMenu.add(new Menu("Listado de Vinculaci" + (char) 243 + "n", "/reporteVinculacion.do?method=buscar&tipoReporte=1"));
		
		if(!codPerfil.equalsIgnoreCase("LC04") && !codPerfil.equalsIgnoreCase("LC06")) {
			listMenu.add(new Menu("Seguimiento de Ingreso a la Aplicaci&oacute;n", "/reporteHistoricoSeguimiento.do?method=buscar&tipoReporte=D&territorio=-1&oficina=-1&perfil=-1&gestor=-1"));
		}
		
		if(codPerfil.equalsIgnoreCase("LC01")) {
			listMenu.add(new Menu("Administraci&oacute;n", "/pages/iilc_listado_administrador.jsp"));
		}
		
		return listMenu;
	}
	
	private List<Menu> createMenuVinculacion(String codPerfil) {
		List<Menu> listMenu = new ArrayList<Menu>();
		
		listMenu.add(new Menu("Vinculaci&oacute;n VIP", "/reporteVinculacion.do?method=buscar&tipoReporte=1"));
		listMenu.add(new Menu("Vinculaci&oacute;n GCO", "/reporteVinculacion.do?method=buscar&tipoReporte=2"));
		listMenu.add(new Menu("Vinculaci&oacute;n PH", "/reporteVinculacion.do?method=buscar&tipoReporte=3"));
		
		return listMenu;
	}
}
