package com.grupobbva.bc.per.tel.iilc.actions;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanMantenimiento;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;

public class MantenimientoTablasAction extends DispatchAction {
	
	public ActionForward mantenimiento(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		Connection conexion = new Connection();
		try {
			;
			request.getSession().setAttribute("listaMultitabla",conexion.findAllMultitabla());
			request.getSession().setAttribute("listaPerfil",conexion.findAllPerfil());
			request.getSession().setAttribute("listaPermisoPerfil",conexion.findAllPermisoPerfil());
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
		}
		if (!errors.isEmpty())
			saveErrors(request, errors);
		return mapping.findForward(Constantes.FW_MANTENIMIENTO_TABLAS);
	}
	
	public ActionForward agregar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		FormBeanMantenimiento formBeanMantenimiento = (FormBeanMantenimiento) form;
		Connection conexion = new Connection();
		try {
			char tipo = formBeanMantenimiento.getTipo().charAt(0);
			switch(tipo){
	        	case Constantes.MULTITABLA:
	        		Multitabla multitabla = new Multitabla();
	        		BeanUtils.copyProperties(multitabla, formBeanMantenimiento);
	        		conexion.createMultitabla(multitabla);
	        		request.getSession().setAttribute("listaMultitabla",conexion.findAllMultitabla());
	                break;
	        	case Constantes.PERFIL:
	        		Perfil perfil = new Perfil();
	        		BeanUtils.copyProperties(perfil, formBeanMantenimiento);
	        		conexion.createPerfil(perfil);
	        		request.getSession().setAttribute("listaPerfil",conexion.findAllPerfil());
	                break;
	        	case Constantes.PERMISO_PERFIL:
	        		PermisoPerfil permisoPerfil = new PermisoPerfil();
	        		permisoPerfil.setCod_perfil(formBeanMantenimiento.getCod_perfil());
	        		permisoPerfil.setTipo_acceso(new BigDecimal(formBeanMantenimiento.getTipo_acceso()));
					permisoPerfil.setValor_rcp(formBeanMantenimiento.getValor_rcp());
        			conexion.createPermisoPerfil(permisoPerfil);
        			request.getSession().setAttribute("listaPermisoPerfil",conexion.findAllPermisoPerfil());
	                break;
	        }
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
		}
		if (!errors.isEmpty())
			saveErrors(request, errors);
		return mapping.findForward(Constantes.FW_MANTENIMIENTO_TABLAS);
	}
	
	public ActionForward modificar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		FormBeanMantenimiento formBeanMantenimiento = (FormBeanMantenimiento) form;
		Connection conexion = new Connection();
		try {
			char tipo = formBeanMantenimiento.getTipo().charAt(0);
			switch(tipo){
	        	case Constantes.MULTITABLA:
	        		Multitabla multitabla = new Multitabla();
	        		BeanUtils.copyProperties(multitabla, formBeanMantenimiento);
	        		conexion.updateMultitabla(multitabla);
	        		request.getSession().setAttribute("listaMultitabla",conexion.findAllMultitabla());
	                break;
	        	case Constantes.PERFIL:
	        		Perfil perfil = new Perfil();
	        		BeanUtils.copyProperties(perfil, formBeanMantenimiento);
	        		conexion.updatePerfil(perfil);
	        		request.getSession().setAttribute("listaPerfil",conexion.findAllPerfil());
	                break;
	        }
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
		}
		if (!errors.isEmpty())
			saveErrors(request, errors);
		return mapping.findForward(Constantes.FW_MANTENIMIENTO_TABLAS);
	}
	
	public ActionForward eliminar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		FormBeanMantenimiento formBeanMantenimiento = (FormBeanMantenimiento) form;
		Connection conexion = new Connection();
		try {
			String cod_mult,cod_ele,cod_perfil,tipo_acceso,valor_rcp;
			String[] cods;
			String[] codElementos = request.getParameterValues("seleccion");
			char tipo = formBeanMantenimiento.getTipo().charAt(0);
			for(int i=0; i<codElementos.length; i++){
				switch(tipo){
	        	case Constantes.MULTITABLA:
	        		cods = codElementos[i].split("-");
	        		cod_mult= cods[0];cod_ele= cods[1];
	        		conexion.deleteMultitabla(cod_mult,cod_ele);
	        		request.getSession().setAttribute("listaMultitabla",conexion.findAllMultitabla());
	        		break;
	        	case Constantes.PERFIL:
	        		conexion.deletePerfil(codElementos[i]);
	        		request.getSession().setAttribute("listaPerfil",conexion.findAllPerfil());
	                break;
	        	case Constantes.PERMISO_PERFIL:
	        		cods = codElementos[i].split("-");
	        		cod_perfil= cods[0];tipo_acceso= cods[1];valor_rcp=cods[2];
	        		conexion.deletePermisoPerfil(cod_perfil,Integer.parseInt(tipo_acceso),valor_rcp);
	        		request.getSession().setAttribute("listaPermisoPerfil",conexion.findAllPermisoPerfil());
	                break;
				}
			}
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
		}
		if (!errors.isEmpty())
			saveErrors(request, errors);
		return mapping.findForward(Constantes.FW_MANTENIMIENTO_TABLAS);
	}
	
	public ActionForward forward(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		FormBeanMantenimiento formBeanMantenimiento = (FormBeanMantenimiento) form;
		Connection conexion = new Connection();
		ConexionDAO conexion2 = new ConexionDAO();
		try {
			char tipo = formBeanMantenimiento.getTipo().charAt(0);
			char fw = formBeanMantenimiento.getForward().toUpperCase().charAt(0);
			switch(fw){
	        	case Constantes.AGREGAR:
			        switch(tipo){
			        	case Constantes.MULTITABLA:
			        		formBeanMantenimiento.setCod_mult("");formBeanMantenimiento.setCod_ele("");
			        		formBeanMantenimiento.setValor1("");formBeanMantenimiento.setValor2("");
			        		formBeanMantenimiento.setValor3("");formBeanMantenimiento.setValor4("");
			        		request.setAttribute("mult","false");request.setAttribute("ele","false");
			        		forward = mapping.findForward(Constantes.FW_REG_MOD_MULTITABLA);
			                break;
			        	case Constantes.PERFIL:
			        		formBeanMantenimiento.setCod_perfil("");formBeanMantenimiento.setDes_perfil("");
			        		formBeanMantenimiento.setComponente("");
			        		request.setAttribute("ele","false");
			        		forward = mapping.findForward(Constantes.FW_REG_MOD_PERFIL);
			                break;
			        	case Constantes.PERMISO_PERFIL:
			        		formBeanMantenimiento.setCod_perfil("");formBeanMantenimiento.setTipo_acceso("");
			        		formBeanMantenimiento.setValor_rcp("");
			        		forward = mapping.findForward(Constantes.FW_REG_MOD_PERMISO_PERFIL);
			                break;
			        }
	                break;
	        	case Constantes.MODIFICAR:
			        switch(tipo){
			        	case Constantes.MULTITABLA:
			        		BeanUtils.copyProperties(formBeanMantenimiento, conexion2.findRecord(formBeanMantenimiento.getCod_mult()+formBeanMantenimiento.getCod_ele()));
			        		request.setAttribute("mult","true");request.setAttribute("ele","true");
			        		forward = mapping.findForward(Constantes.FW_REG_MOD_MULTITABLA);
			                break;
			        	case Constantes.PERFIL:
			        		BeanUtils.copyProperties(formBeanMantenimiento, conexion.findPerfil(formBeanMantenimiento.getCod_perfil()));
			        		request.setAttribute("ele","true");
			        		forward = mapping.findForward(Constantes.FW_REG_MOD_PERFIL);
			                break;
			        	case Constantes.PERMISO_PERFIL:
			        		PermisoPerfil permisoPerfil = conexion.findPermisoPerfil(formBeanMantenimiento.getCod_perfil(),Integer.parseInt(formBeanMantenimiento.getTipo_acceso()),formBeanMantenimiento.getValor_rcp());
			        		formBeanMantenimiento.setCod_perfil(permisoPerfil.getCod_perfil());
			        		formBeanMantenimiento.setTipo_acceso(String.valueOf(permisoPerfil.getTipo_acceso()));
			        		formBeanMantenimiento.setValor_rcp(permisoPerfil.getValor_rcp());
			        		forward = mapping.findForward(Constantes.FW_REG_MOD_PERMISO_PERFIL);
			                break;
			        }
	                break;
	        	case Constantes.VER:
			        switch(tipo){
			        	case Constantes.MULTITABLA:
			        		BeanUtils.copyProperties(formBeanMantenimiento, conexion2.findRecord(formBeanMantenimiento.getCod_mult()+formBeanMantenimiento.getCod_ele()));
			        		forward = mapping.findForward(Constantes.FW_VER_MULTITABLA);
			                break;
			        	case Constantes.PERFIL:
			        		BeanUtils.copyProperties(formBeanMantenimiento, conexion.findPerfil(formBeanMantenimiento.getCod_perfil()));
			        		forward = mapping.findForward(Constantes.FW_VER_PERFIL);
			                break;
			        	case Constantes.PERMISO_PERFIL:
			        		PermisoPerfil permisoPerfil = conexion.findPermisoPerfil(formBeanMantenimiento.getCod_perfil(),Integer.parseInt(formBeanMantenimiento.getTipo_acceso()),formBeanMantenimiento.getValor_rcp());
			        		formBeanMantenimiento.setCod_perfil(permisoPerfil.getCod_perfil());
			        		formBeanMantenimiento.setTipo_acceso(String.valueOf(permisoPerfil.getTipo_acceso()));
			        		formBeanMantenimiento.setValor_rcp(permisoPerfil.getValor_rcp());
			        		forward = mapping.findForward(Constantes.FW_VER_PERMISO_PERFIL);
			                break;
			        }
	                break;    
	        	case Constantes.ELIMINAR:
	        		switch(tipo){
			        	case Constantes.MULTITABLA:
			        		conexion.deleteMultitabla(formBeanMantenimiento.getCod_mult(),formBeanMantenimiento.getCod_ele());
			        		request.getSession().setAttribute("listaMultitabla",conexion.findAllMultitabla());
			        		break;
			        	case Constantes.PERFIL:
			        		conexion.deletePerfil(formBeanMantenimiento.getCod_perfil());
			        		request.getSession().setAttribute("listaPerfil",conexion.findAllPerfil());
			                break;
			        	case Constantes.PERMISO_PERFIL:
			        		conexion.deletePermisoPerfil(formBeanMantenimiento.getCod_perfil(),Integer.parseInt(formBeanMantenimiento.getTipo_acceso()),formBeanMantenimiento.getValor_rcp());
			        		request.getSession().setAttribute("listaPermisoPerfil",conexion.findAllPermisoPerfil());
			                break;
	        		}
	        		forward = mapping.findForward(Constantes.FW_MANTENIMIENTO_TABLAS);
	                break;
	        }
		} catch (Exception e) {
			errors.add("name", new ActionError("id"));
		}
		if (!errors.isEmpty())
			saveErrors(request, errors);
		return forward;
	}
}