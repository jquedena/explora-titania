package com.grupobbva.bc.per.tel.iilc.actions;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.beans.Descarga;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.dao.impl.ClienteDAOImpl;
import com.grupobbva.bc.per.tel.iilc.dao.impl.DescargaDAOImpl;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanConsulta;
import com.grupobbva.bc.per.tel.iilc.serializable.Consulta;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.task.HiloExportar;

public class ConsultaListadoConduccionAction extends DispatchAction {

	private static Logger log = Logger.getLogger(ConsultaListadoConduccionAction.class);

	public ActionForward carga(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;
		Connection conexion = new Connection();
		Vector<Territorio> listaTerritorio = new Vector<Territorio>();
		Vector<Oficina> listaOficina = new Vector<Oficina>();
		Vector<Gestor> listaGestor = new Vector<Gestor>();

		try {
			String codArea = (String) formBeanConsulta.getAtog().get(0);

			if (formBeanConsulta.getTerritorio() == null)
				formBeanConsulta.setTerritorio((String) formBeanConsulta.getAtog().get(1));
			if (formBeanConsulta.getOficina() == null)
				formBeanConsulta.setOficina((String) formBeanConsulta.getAtog().get(2));

			String codTerritorio = formBeanConsulta.getTerritorio();
			String codOficina = formBeanConsulta.getOficina();

			if (codTerritorio.equals("-1")) {
				listaTerritorio = conexion.findAllTerritorio(codArea);
				formBeanConsulta.setOficina("-1");
				formBeanConsulta.setGestor("-1");
			} else {
				if (codOficina.equals("-1")) {
					listaTerritorio = conexion.findAllTerritorio(codArea);
					listaOficina = conexion.findAllOficinaxTe(codArea, codTerritorio);
					formBeanConsulta.setGestor("-1");
				} else {
					listaTerritorio = conexion.findAllTerritorio(codArea);
					listaOficina = conexion.findAllOficinaxTe(codArea, codTerritorio);
					listaGestor = conexion.findAllGestorxOfxTe(codArea, codTerritorio, codOficina);
				}
			}

			request.setAttribute("listaNivelVinculacion", conexion.findAllRecord(Constantes.TABLA_NIVEL_VINCULACION));
			request.setAttribute("listaClasificacion", conexion.findAllRecord(Constantes.TABLA_CLASIFICACION));
			request.setAttribute("listaMargenOrdinario", conexion.findAllRecord(Constantes.TABLA_MARGEN_ORDINARIO));
			request.setAttribute("listaEtiqueta", conexion.findAllRecord(Constantes.TABLA_ETIQUETA));
			request.setAttribute("listaEdad", conexion.findAllRecord(Constantes.TABLA_EDAD));
			request.setAttribute("listaCuotaRiesgoTotal", conexion.findAllRecord(Constantes.TABLA_CUOTA_RIESGO_TOTAL));
			request.setAttribute("listaTerritorio", listaTerritorio);
			request.setAttribute("listaOficina", listaOficina);
			request.setAttribute("listaGestor", listaGestor);

		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			log.error("", e);
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		forward = mapping.findForward(Constantes.FW_PRINCIPAL);
		return (forward);

	}

	public ActionForward espera(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();

		try {
			request.setAttribute("file", null);
			request.setAttribute("rootpath", null);
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
			log.error("espera", e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}

		String origenVinculacion = request.getParameter("origenVinculacion");
		String tipo = request.getParameter("tipo");

		request.setAttribute("origenVinculacion", origenVinculacion);

		if (tipo.equals("impresion"))
			forward = mapping.findForward(Constantes.FW_ESPERA_IMPRESION);
		else
			forward = mapping.findForward(Constantes.FW_ESPERA_EXPORTACION);

		return (forward);
	}

	public ActionForward descargar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			
			
			
			FormBeanConsulta formConsulta = (FormBeanConsulta) form;
			String idsession =  request.getSession().getAttribute("idSession").toString();
			String registro = (String) request.getSession().getAttribute("usuario");
			Consulta consulta = (Consulta) request.getSession().getAttribute("parametrosConsulta");
			int tipoDetalle = (int) consulta.getTipoDetalle();
				
			ClienteDAOImpl dao = new ClienteDAOImpl();
			
			HiloExportar proceso = new HiloExportar();
			proceso.setForm(formConsulta);
			proceso.setId(idsession);
			proceso.setRegistro(registro);
			proceso.setTipoDetalle(tipoDetalle);
			proceso.setDescripcion(dao.datosDetalleFiltro2(consulta));
			Thread hilo = new Thread(proceso);
			hilo.start();
		} catch (Exception e) {
			log.error("ConsultaListadoConduccionAction :: descargar", e);
		}
		
		return null;
	}
	
	public ActionForward eliminar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			DescargaDAOImpl dao = new DescargaDAOImpl();
			dao.eliminar(id);
			
		} catch (Exception e) {
			log.error("ConsultaListadoConduccionAction :: eliminar", e);
		}
		
		return null;
	}
	
	public ActionForward listarDescargas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			String registro = (String) request.getSession().getAttribute("usuario");
			ConexionDAO cnn = new ConexionDAO();
			List<Descarga> lista = cnn.listarDescarga(registro);
			request.setAttribute("detalles", lista);
		} catch (Exception e) {
			log.error("ConsultaListadoConduccionAction :: listarDescargas", e);
		}
		
		return mapping.findForward("lista_descarga");
	}
}
