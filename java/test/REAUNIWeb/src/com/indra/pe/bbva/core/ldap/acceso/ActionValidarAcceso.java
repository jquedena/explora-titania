package com.indra.pe.bbva.core.ldap.acceso;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;
import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.ldap2db.IIWXPeUsuario;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.model.entidad.OperacionCentralizadaDto;
import com.indra.pe.bbva.reauni.model.entidad.PermisoPerfilDto;
import com.indra.pe.bbva.reauni.service.OficinaBO;
import com.indra.pe.bbva.reauni.service.OperacionesCentralesBO;
import com.indra.pe.bbva.reauni.service.PermisoPerfilBO;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

/**
 * 
 * @author INDRA PERU SA
 */
public class ActionValidarAcceso extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 2692392374210259330L;

	private static Logger logger = Logger.getLogger(ActionValidarAcceso.class);

	public ActionValidarAcceso() {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("Validando Acceso Sistema Reasignacion-Unificacion...");
		response.setCharacterEncoding("ISO-8859-1");
		IILDPeUsuario iildPeUsuario = null;
		ServiciosSeguridadBbva objSeguridad = null;
		String reg = "";
		String msg = "Usted no tiene acceso al sistema. ";
		try {

			objSeguridad = new ServiciosSeguridadBbva(request);
			objSeguridad.obtener_ID();
			reg = objSeguridad.getUsuario().toUpperCase();
			try {
				iildPeUsuario = IILDPeUsuario.recuperarUsuario(reg);
			} catch(Exception ex) {
				iildPeUsuario = IIWXPeUsuario.recuperarUsuario(reg);
			}
			
			if (iildPeUsuario != null) {

				PermisoPerfilBO permisoPerfilBO = (PermisoPerfilBO) WebServletContextListener.getApplicationContext().getBean("permisoPerfilBO");
				PermisoPerfilDto permisoPerfilDto = permisoPerfilBO.obtenerPerfilSegunRegistroOCargo(iildPeUsuario.getUID(), iildPeUsuario.getCargo().getCodigo());
				LdapService ldapService = (LdapService) WebServletContextListener.getApplicationContext().getBean("ldapService");
				if (permisoPerfilDto != null) {
					SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");
					sessionMBean.setNombresApellidos(iildPeUsuario
							.getApellido1()
							+ " "
							+ iildPeUsuario.getApellido2()
							+ " "
							+ iildPeUsuario.getNombre());
					sessionMBean.setRegistro(iildPeUsuario.getUID());
					sessionMBean.setCodCargo(iildPeUsuario.getCargo().getCodigo());
					sessionMBean.setDesCargo(iildPeUsuario.getCargo().getDescripcion());
					sessionMBean.setPerfilDto(permisoPerfilDto.getPerfil());
					sessionMBean.setCodOficina(iildPeUsuario.getBancoOficina().getCodigo());
					sessionMBean.setDesOficina(iildPeUsuario.getBancoOficina().getDescripcion());

					// Obteniendo el territorio de la oficina
					OficinaBO oficinaBO = (OficinaBO) WebServletContextListener.getApplicationContext().getBean("oficinaBO");
					OficinaDto oficinaDto = oficinaBO.obtenerOficina(sessionMBean.getCodOficina());

					if (oficinaDto != null) {
						sessionMBean.setCodTerritorio(oficinaDto.getTerritorioDto().getCodTerritorio());
						sessionMBean.setDesTerritorio(oficinaDto.getTerritorioDto().getDesTerritorio());
					}
					// Obteniendo el producto de operaciones centralizadas
					OperacionesCentralesBO operacionesCentralesBO = (OperacionesCentralesBO) WebServletContextListener.getApplicationContext().getBean("operacionesCentralesBO");
					OperacionCentralizadaDto oc = new OperacionCentralizadaDto();
					oc.setRegistro(sessionMBean.getRegistro());
					sessionMBean.setProductosOperacionesCentralizadas(operacionesCentralesBO.obtenerListaSituaciones(oc));
					
					sessionMBean.setUsuarioLdapSesion(ldapService.obtenerInformacionPorRegistro(iildPeUsuario.getUID()));
					response.sendRedirect("/REAUNIWeb/faces/pages/principal.xhtml");
				} else {
					request.getSession(true).setAttribute("strMensaje", msg);
					response.sendRedirect("/REAUNIWeb/faces/sinAcceso.xhtml");
				}
			} else {
				request.getSession(true).setAttribute("strMensaje", msg);
				response.sendRedirect("/REAUNIWeb/faces/sinAcceso.xhtml");
			}

		} catch (Exception e) {
			msg = "Error al conectar al Ldap ";
			logger.error(Utilitarios.Log.error(e, msg), e);
			request.getSession(true).setAttribute("strMensaje", msg);
			response.sendRedirect("/REAUNIWeb/faces/sinAcceso.xhtml");
		}

	}

}
