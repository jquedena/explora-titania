package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanListadoDescripcionCarpetas;

@SuppressWarnings({"unused", "unchecked"})
public class ListadoDescripcionCarpetasAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		FormBeanListadoDescripcionCarpetas actionForm = (FormBeanListadoDescripcionCarpetas) form;
		AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();
		List listadoDocumento = daolistado.obtenerDescripcion("6");
		
		if (listadoDocumento != null) {
			request.getSession().setAttribute("listadoVin6", listadoDocumento);
		}

		return mapping.findForward("consulta");
	}
}
