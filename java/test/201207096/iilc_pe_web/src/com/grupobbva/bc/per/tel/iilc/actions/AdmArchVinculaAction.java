package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.ReporteVinculacionDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;

public class AdmArchVinculaAction extends Action {

	static Logger logger = Logger.getLogger(AdmArchVinculaAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ConexionDAO con = new ConexionDAO();
		AdministracionCargaVinculacion objBean = new AdministracionCargaVinculacion();
		ReporteVinculacionDAO dao = new ReporteVinculacionDAO();
		String fecha = "";
		String fechaOld = ""; // objBean.getFecha().substring(0,10)
		
		boolean sw = false;
		try {

			Calendar hoy = Calendar.getInstance();
			String usuario = request.getSession().getAttribute("usuario").toString();
			String tipo = request.getParameter("tipo");
			fecha = request.getParameter("fecha_" + tipo);
			String fechaOficinal = Utilitario.dosCeros(hoy
					.get(Calendar.DAY_OF_MONTH))
					+ "-"
					+ Utilitario.dosCeros((hoy.get(Calendar.MONTH) + 1))
					+ "-"
					+ hoy.get(Calendar.YEAR)
					+ " "
					+ Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))
					+ ":"
					+ Utilitario.dosCeros(hoy.get(Calendar.MINUTE) - 10)
					+ ":"
					+ Utilitario.dosCeros(hoy.get(Calendar.SECOND));

			if(request.getParameter("fecha_original") != null) {
				fechaOld = request.getParameter("fecha_original").substring(0,10);
				fechaOficinal = fechaOficinal.substring(0,10);
			}
			
			if (fecha == null || fecha.equals("null") || fecha.equals("")) {
				request.setAttribute("mensaje", "Debe registrar una fecha");
			} else if (dao.validarFechas(fechaOficinal, fecha, "dd-MM-yyyy HH24:mi:ss").equals("1")) {
				request.setAttribute("mensaje", "La fecha y hora ingresadas deben ser posteriores a la fecha y hora actual");
			} else if (dao.validarFechas(fechaOficinal, fechaOld, "dd-MM-yyyy").equals("1") && request.getParameter("org") != null) {
				request.setAttribute("mensaje", Constantes.MENASJE_MODIFICAR_PROCESO_POSTERIOR);
			} else {

				java.util.Date utilDate = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

				if (fecha != null)
					objBean.setFecha(fecha);

				if (tipo.equals("V")) {
					objBean.setTipo(1);
				} else if (tipo.equals("G")) {
					objBean.setTipo(2);
				} else if (tipo.equals("P")) {
					objBean.setTipo(3);
				}

				objBean.setId_estado(1);// Pendiente
				objBean.setUsureg(usuario);
				objBean.setFecreg(sqlDate);

				int estado = con.verificarExistenciaCarga(objBean);
				
				if (request.getParameter("org") != null) {					
					if (request.getParameter("sobreescritura") != null) {
						con.actualizarCargaVinculacion(objBean, fechaOld);
						sw = true;
					}
					
					request.setAttribute("fecha_" + tipo, fecha);
					request.setAttribute("tipo", tipo);
				} else {
					if (estado == 0) {
	
						if (request.getParameter("sobreescritura") != null) {
							con.actualizarCargaVinculacion(objBean);
						} else {
							request.setAttribute("mensajeInformacion", "La fecha programada ya existe &#191;desea reemplazarla?");
						}
	
						request.setAttribute("fecha_" + tipo, fecha);
						request.setAttribute("tipo", tipo);
	
					} else if (estado == 1) {
	
						request.setAttribute("mensaje", "Esta carga se encuentra en proceso, esperar que el proceso este concluido");
						request.setAttribute("fecha_" + tipo, fecha);
						request.setAttribute("tipo", tipo);
	
					} else if (estado == -1) {
						con.crearCargaVinculacion(objBean);
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (request.getParameter("org") == null) {
			return mapping.findForward("grabar");
		} else {
			String tipo = request.getParameter("tipo");
	 		String tipo_numerico = "";
			if(tipo.equals("V")){
				tipo_numerico="1";
			}else if(tipo.equals("G")){
				tipo_numerico="2";
			}else if(tipo.equals("P")){
				tipo_numerico="3";
			}
			
			try {	 			 		
	 			@SuppressWarnings("unchecked")
				List lista=con.listarCargasVinculacion(tipo_numerico);
	 			request.getSession().setAttribute("listaCargas", lista);
	 		} catch (Exception e) {
	 			request.getSession().setAttribute("listaCargas", null);
				logger.error(e.getMessage());
				e.printStackTrace();
			}			
			
			request.setAttribute("fecha", fecha);
			request.setAttribute("modificacion", (sw ? "" : "mostrarDIV"));
			request.setAttribute("fecha_" + tipo, fecha);
			request.setAttribute("tipo", tipo);
			return mapping.findForward("listar");
		}
	}
}
