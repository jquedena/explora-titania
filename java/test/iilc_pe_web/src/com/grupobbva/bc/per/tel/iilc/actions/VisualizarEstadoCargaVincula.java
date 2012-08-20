package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;

@SuppressWarnings("unused")
public class VisualizarEstadoCargaVincula extends DispatchAction {

	static Logger logger = Logger.getLogger(VisualizarEstadoCargaVincula.class);

	public ActionForward carga(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ConexionDAO con = new ConexionDAO();
		AdministracionCargaVinculacion objBean = new AdministracionCargaVinculacion();
		try {
			
			String usuario = request.getSession().getAttribute("usuario").toString();

			String tipo = request.getParameter("tipo");
			String tipo_numerico = "";
			String tipoNormal = "";
			if (tipo.equals("V")) {
				tipo_numerico = "1";
				tipoNormal = "VIP";
			} else if (tipo.equals("G")) {
				tipo_numerico = "2";
				tipoNormal = "GCO";
			} else if (tipo.equals("P")) {
				tipo_numerico = "3";
				tipoNormal = "PH";
			}
			objBean = con.listarCargaVinculacion(tipo_numerico);
			request.setAttribute("objBean", objBean);
			request.setAttribute("tipo", tipo);
			// Se creara el txt de log
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return mapping.findForward("listar");

	}

	public ActionForward descargaLogVinculacion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		
		ConexionDAO con = new ConexionDAO();
		AdministracionCargaVinculacion objBean = new AdministracionCargaVinculacion();

		
		try {

			String tipo = request.getParameter("tipo");
			String tipo_numerico = "";
			String tipoNormal = "";
			if (tipo.equals("V")) {
				tipo_numerico = "1";
				tipoNormal = "VIP";
			} else if (tipo.equals("G")) {
				tipo_numerico = "2";
				tipoNormal = "GCO";
			} else if (tipo.equals("P")) {
				tipo_numerico = "3";
				tipoNormal = "PH";
			}  
			
			
			objBean = con.listarCargaVinculacion(tipo_numerico);	
			
			if (objBean!=null && (  objBean.getId_estado() == 4  ) ) {
				String file = "";
				String path = con.findRecord(Constantes.PATHVINCULACION).getValor1().trim();
				FileWriter fichero = null;
				PrintWriter pw = null;
				try {
					file = "LOG_VINC_" + tipoNormal + "_" + objBean.getFecha()
							+ ".txt";
					path = path + "/";
					fichero = new FileWriter(path + file);

					List lista = con.listarLogVinculacion(tipo_numerico);
					pw = new PrintWriter(fichero);

					for (int i = 0; i < lista.size(); i++) {

						pw.println(lista.get(i));
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != fichero) {
							fichero.close();
							request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
							request.getSession() .setAttribute(Constantes.EXPORTACION_RUTA, path);
							request.setAttribute("origenVinculacion", "111");						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}



		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return mapping.findForward("descarga");

	}

}