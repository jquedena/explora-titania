package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.beans.OficinaTerritorio;
import com.grupobbva.bc.per.tel.iilc.beans.PermisoUsuario;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.service.impl.OficinaTerritorioServiceImpl;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;

@SuppressWarnings("unchecked")
public class PermisoUsuarioAction extends DispatchAction {
	
	private OficinaTerritorioServiceImpl oficinaTerritorioService; 
	
	public PermisoUsuarioAction(){
		oficinaTerritorioService = new OficinaTerritorioServiceImpl();
	}
	
	public ActionForward listar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		Connection conexion = new Connection();
		Vector<Territorio> listaTerritorio;
		List<OficinaTerritorio> listaOficina;
		
		listaTerritorio = conexion.findAllTerritorio(Constantes.TODOS_TERRITORIOS);
		listaOficina = oficinaTerritorioService.listarOficina();
		request.getSession().setAttribute("listaTerritorio", listaTerritorio);
		request.getSession().setAttribute("listaOficina", listaOficina);
		
		return mapping.findForward("listar");
	}
	
	public ActionForward registrar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		List<OficinaTerritorio> listaOficina;
		PermisoUsuario u;
		listaOficina = (List<OficinaTerritorio>) request.getSession().getAttribute("listaOficina");
		String usuReg = (String) request.getSession().getAttribute("usuario");
		String codUsuario = (String) request.getParameter("registro").toUpperCase();
		String nCheck = "";
		
		String codCargo = "";
		String nombre = "";
		String oficina = "";
		IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(codUsuario);
		if(user!=null){
			codCargo = user.getCargo().getCodigo();
			nombre = user.getNombreCompleto();
			oficina = user.getBancoOficina().getCodigo() + " - " + user.getBancoOficina().getDescripcion();
		}
		int perfil = oficinaTerritorioService.perfil(codUsuario, codCargo);
		
		if(perfil == -1) {
			for(OficinaTerritorio o : listaOficina) {
				u = new PermisoUsuario();
				u.setCodArea(o.getCodArea());
				u.setCodOficina(o.getCodOficina());
				u.setCodTerritorio(o.getCodTerritorio());
				u.setCodUsuario(codUsuario);
				u.setUsuReg(usuReg);
				nCheck = (String) request.getParameter("ofic_" + o.getCodTerritorio() + "_" + o.getCodOficina());
				nCheck = nCheck == null ? "" : nCheck;
				u.setChecked(nCheck);
				oficinaTerritorioService.registrarPermiso(u);
				// log.info(u.getCodTerritorio()+" -> "+u.getCodOficina()+" -> "+nCheck+".");
			}
		}
		
		request.setAttribute("codCargo", codCargo);
		request.setAttribute("oficina", oficina);
		request.setAttribute("nombre", nombre);
		request.setAttribute("perfil", perfil);
		request.setAttribute("registro", codUsuario);
		return mapping.findForward("listar");
	}
	
	public ActionForward eliminar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		PrintWriter out = response.getWriter();
		String codUsuario = request.getParameter("codUsuario") == null ? "" : request.getParameter("codUsuario").toUpperCase();
		String result = "Se eliminio con exito la configuraci" + (char) 243 + "n para el registro " + codUsuario + ".";
		if(!oficinaTerritorioService.eliminarPermiso(codUsuario)) {
			result = "Ocurrio un error al realizar la actualizaci" + (char) 243 + "n.";
		}

		out.println(result);
		
		return null;
	}
	
	public ActionForward buscar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		String codUsuario = request.getParameter("codUsuario") == null ? "" : request.getParameter("codUsuario").toUpperCase();
		String verificar = request.getParameter("verificar") == null ? "" : request.getParameter("verificar");
		List<PermisoUsuario> listaPermisoUsuario = oficinaTerritorioService.listarPermiso(codUsuario);
		
		String codCargo = "";
		String nombre = "";
		String oficina = "";
		IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(codUsuario);
		if(user!=null){
			codCargo = user.getCargo().getCodigo();
			nombre = user.getNombreCompleto();
			oficina = user.getBancoOficina().getCodigo() + " - " + user.getBancoOficina().getDescripcion();
		}
		int perfil = oficinaTerritorioService.perfil(codUsuario, codCargo);
		
		// log.info(codUsuario);
		JSONArray json = JSONArray.fromObject(listaPermisoUsuario);
		request.setAttribute("listaPermisoUsuario", json.toString());
		request.setAttribute("verificar", verificar);
		request.setAttribute("codCargo", codCargo);
		request.setAttribute("oficina", oficina);
		request.setAttribute("nombre", nombre);
		request.setAttribute("perfil", perfil);
		// log.info(json.toString());
		return mapping.findForward("buscar");
	}
}