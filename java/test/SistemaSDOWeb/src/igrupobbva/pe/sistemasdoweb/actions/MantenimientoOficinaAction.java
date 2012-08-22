package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.OficinaForm;
import igrupobbva.pe.sistemasdoweb.util.GestorPerfil;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings( { "unused", "unchecked" })
public class MantenimientoOficinaAction extends DispatchAction {
	private static Logger log = Logger
			.getLogger(MantenimientoOficinaAction.class);

	public ActionForward mostrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		GestorPerfil codPerfil = new GestorPerfil();
		HttpSession sesion = null;
		Gestor gestor = null;

		try {
			log.info("[MantenimientoOficinaAction :: mostrar] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			String CodigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario
					.recuperarUsuario(CodigoUsuario);
			String perfil = codPerfil.buscarGestor(CodigoUsuario)
					.getCodigoPerfil();
			OficinaForm OficinaForm = new OficinaForm();
			String codTerritorio = request.getParameter("codTerritorio");
			Vector listaOficinas = null;
			Vector rel2 = null;
			listaOficinas = ejb.busOficinaxTerritorio(codTerritorio, true);
			rel2 = ejb.busAllTerritorio();
			request.setAttribute("listaOficinas", listaOficinas);
			request.setAttribute("listaTerritorios", rel2);
			request.setAttribute("codTerritorio", codTerritorio);
			request.setAttribute("perfil", perfil);

			log.info("[MantenimientoOficinaAction :: mostrar] Fin");
		} catch (Exception e) {
			log.error("[MantenimientoOficinaAction :: mostrar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrar");
		}

		return (forward);
	}

	public ActionForward nuevo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();

		String rel1 = null;
		String rel2 = null;
		Vector rel3 = null;
		HttpSession sesion = null;

		try {
			log.info("[MantenimientoOficinaAction :: nuevo] Inicio");

			sesion = request.getSession(false);
			rel1 = "";
			rel2 = "";
			rel3 = ejb.busAllTerritorio();
			request.setAttribute("codOficina", rel1);
			request.setAttribute("nomOficina", rel2);
			request.setAttribute("listaTerritorios", rel3);

			log.info("[MantenimientoOficinaAction :: nuevo] Fin");
		} catch (Exception e) {
			log.error("[MantenimientoOficinaAction :: nuevo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		forward = mapping.findForward("nuevo");
		return (forward);
	}

	public ActionForward grabarOficina(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = null;
		OficinaForm OficinaForm = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		String perfil = null;

		try {
			log.info("[MantenimientoOficinaAction :: grabarOficina] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			ejb = new Connection();
			OficinaForm = new OficinaForm();

			String codTerritorio = request.getParameter("codTerritorio").toUpperCase();
			String codOficina = request.getParameter("codOficina");
			String nomOficina = request.getParameter("nomOficina").toUpperCase();
			Vector rel = null;
			Vector rel2 = null;

			int res = ejb.nuevaOficina(codTerritorio, codOficina, nomOficina,
					gestor.getCodigoGestor());
			rel2 = ejb.busAllTerritorio();
			perfil = gestor.getCodigoPerfil();

			//  Revisar mensaje de grabado
			if (res != 1) {
				request.setAttribute("msg", "La oficina ingresada ya existe");
				request.getSession().setAttribute("error_Territorio", "La oficina ingresada ya existe");
			} else {
				request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
			}

			request.setAttribute("listaTerritorios", rel2);
			request.setAttribute("perfil", perfil);

			log.info("[MantenimientoOficinaAction :: grabarOficina] Fin");			
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[MantenimientoOficinaAction :: grabarOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrar");
		}

		return (forward);
	}

	public ActionForward mostrarEditar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();
		OficinaForm oficinaForm = new OficinaForm();
		HttpSession sesion = null;

		try {
			log.info("[MantenimientoOficinaAction :: mostrarEditar] Inicio");

			sesion = request.getSession(false);
			String codTerritorio = request.getParameter("codTerritorio");
			String codOficina = request.getParameter("codOficina");
			String nomOficina = request.getParameter("nomOficina");
			String estado = request.getParameter("estado");

			Vector rel2 = null;
			rel2 = ejb.busAllTerritorio();

			request.setAttribute("listaTerritorios", rel2);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("nomOficina", nomOficina);
			request.setAttribute("codTerritorio", codTerritorio);
			oficinaForm.setEstado(estado);

			log.info("[MantenimientoOficinaAction :: mostrarEditar] Fin");
		} catch (Exception e) {
			log.error("[MantenimientoOficinaAction :: mostrarEditar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		forward = mapping.findForward("editar");
		return (forward);
	}

	public ActionForward editar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		OficinaForm oficinaForm = (OficinaForm) form;
		HttpSession sesion = null;
		Gestor gestor = null;
		String perfil = null;

		try {
			log.info("[MantenimientoOficinaAction :: editar] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			String codTerritorioNUE = request.getParameter("codTerritorioNUE");
			String codTerritorioACT = request.getParameter("codTerritorioACT");
			String codOficina = request.getParameter("codOficina");
			String nomOficina = request.getParameter("nomOficina").toUpperCase();
			Vector rel2 = null;

			log.info("[MantenimientoOficinaAction :: editar] codOficina " + codOficina);
			log.info("[MantenimientoOficinaAction :: editar] codTerritorioNUE" + codTerritorioNUE);
			log.info("[MantenimientoOficinaAction :: editar] codTerritorioACT" + codTerritorioACT);

			/*
			 * if(codTerritorioACT.equals(codTerritorioNUE)){ Oficina oficina =
			 * new Oficina(); oficina.setCodTerritorio(codTerritorioACT);
			 * oficina.setCodOfic(codOficina);
			 * oficina.setNomOficina(nomOficina);
			 * oficina.setEstado(oficinaForm.getEstado());
			 * oficina.setUsuActu(gestor.getCodigoGestor());
			 * ejb.editarOficina(oficina); } else{
			 * ejb.editarTerritoriosDeOficinas(codOficina, codTerritorioNUE);
			 */
			Oficina oficina = new Oficina();
			oficina.setCodTerritorio(codTerritorioNUE);
			oficina.setCodOfic(codOficina);
			oficina.setNomOficina(nomOficina);
			oficina.setEstado(oficinaForm.getEstado());
			oficina.setUsuActu(gestor.getCodigoGestor());
			ejb.editarOficina(oficina);
			/* } */

			rel2 = ejb.busAllTerritorio();
			perfil = gestor.getCodigoPerfil();
			request.setAttribute("listaTerritorios", rel2);
			request.setAttribute("perfil", perfil);

			log.info("[MantenimientoOficinaAction :: editar] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[MantenimientoOficinaAction :: editar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrar");
		}

		return (forward);
	}

	public ActionForward eliminar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();
		OficinaForm OficinaForm = new OficinaForm();
		HttpSession sesion = null;
		Gestor gestor = null;

		try {
			log.info("[MantenimientoOficinaAction :: eliminar] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");

			String codigos = request.getParameter("codigos");
			String codigosOficinas[] = codigos.split(";");

			GestorPerfil codPerfil = new GestorPerfil();
			String CodigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario
					.recuperarUsuario(CodigoUsuario);
			String perfil = codPerfil.buscarGestor(CodigoUsuario)
					.getCodigoPerfil();

			for (int i = 0; i < codigosOficinas.length; i++) {
				codigos = codigosOficinas[i];
				Vector rel = null;
				ejb.eliminarOficina(codigos);
			}

			Vector rel2 = null;
			rel2 = ejb.busAllTerritorio();
			request.setAttribute("listaTerritorios", rel2);
			request.setAttribute("perfil", perfil);

			log.info("[MantenimientoOficinaAction :: eliminar] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[MantenimientoOficinaAction :: eliminar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrar");
		}

		return (forward);
	}
}
