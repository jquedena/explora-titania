package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.TerritorioForm;
import igrupobbva.pe.sistemasdoweb.util.GestorPerfil;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings( { "unused", "unchecked" })
public class MantenimientoTerritorioAction extends DispatchAction {
	private static Logger log = Logger
			.getLogger(MantenimientoTerritorioAction.class);

	public ActionForward mostrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		Vector rel1 = null;
		GestorPerfil codPerfil = new GestorPerfil();
		HttpSession sesion = null;
		Gestor gestor = null;

		try {
			log.info("[MantenimientoTerritorioAction :: mostrar] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			String CodigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario
					.recuperarUsuario(CodigoUsuario);
			String perfil = codPerfil.buscarGestor(CodigoUsuario)
					.getCodigoPerfil();

			rel1 = ejb.busAllTerritorioActivo();
			request.setAttribute("listaTerritorio", rel1);
			request.setAttribute("perfil", perfil);

			log.info("[MantenimientoTerritorioAction :: mostrar] Fin");
		} catch (Exception e) {
			log.error("[MantenimientoTerritorioAction :: mostrar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("ok");
		}

		return (forward);
	}

	public ActionForward nuevo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();
		TerritorioForm TerritorioForm = new TerritorioForm();
		String rel1 = null;
		String rel2 = null;
		rel1 = "";
		rel2 = "";

		log.info("[MantenimientoTerritorioAction :: nuevo] Inicio");

		request.setAttribute("codTerritorio", rel1);
		request.setAttribute("nomTerritorio", rel2);

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("nuevo");
		}

		log.info("[MantenimientoTerritorioAction :: nuevo] Fin");

		return (forward);
	}

	public ActionForward grabarTerritorio(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		TerritorioForm TerritorioForm = new TerritorioForm();
		HttpSession sesion = null;
		Gestor gestor = null;

		try {
			log.info("[MantenimientoTerritorioAction :: grabarTerritorio] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");

			String codTerritorio = request.getParameter("codTerritorio").toUpperCase().trim();
			String nomTerritorio = request.getParameter("nomTerritorio").toUpperCase().trim();
			String mensaje = request.getParameter("mensaje") != null ? request.getParameter("mensaje") : "";
			String colorFondo = request.getParameter("colorFondo");

			Vector rel = null;

			rel = ejb.nuevoTerritorio(codTerritorio, nomTerritorio, mensaje,
					colorFondo, gestor.getCodigoGestor());

			GestorPerfil codPerfil = new GestorPerfil();
			String CodigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
			String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
			Vector relN = null;

			relN = ejb.busAllTerritorioActivo();
			request.setAttribute("listaTerritorio", relN);
			request.setAttribute("perfil", perfil);

			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
			log.info("[MantenimientoTerritorioAction :: grabarTerritorio] Fin");
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", "Error al actualizar.");
			log.error("[MantenimientoTerritorioAction :: grabarTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		// Revisar mensaje de grabado
		/*
		 * if (!errors.isEmpty()) { saveErrors(request, errors); forward =
		 * mapping.findForward("error"); } else { forward =
		 * mapping.findForward("ok"); }
		 */

		forward = mapping.findForward("ok");

		return (forward);
	}

	public ActionForward mostrarEditar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		TerritorioForm TerritorioForm = new TerritorioForm();
		HttpSession sesion = null;

		try {
			log.info("[MantenimientoTerritorioAction :: mostrarEditar] Inicio");

			sesion = request.getSession(false);
			String codTerritorio = request.getParameter("codTerritorio");
			Vector rel1 = null;
			rel1 = ejb.busTerritorioxCod(codTerritorio);
			int tam = rel1.size();
			request.setAttribute("listaMostrarEditar", rel1);

			log.info("[MantenimientoTerritorioAction :: mostrarEditar] Fin");
		} catch (Exception e) {
			log.error("[MantenimientoTerritorioAction :: mostrarEditar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrarEditar");
		}

		return (forward);
	}

	public ActionForward editar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		TerritorioForm TerritorioForm = new TerritorioForm();
		HttpSession sesion = null;
		Gestor gestor = null;

		try {
			log.info("[MantenimientoTerritorioAction :: editar] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");

			String codTerritorio = request.getParameter("codTerritorio");
			String nomTerritorio = request.getParameter("nomTerritorio").toUpperCase().trim();
			String estado = request.getParameter("estado");
			String mensaje = request.getParameter("mensaje") != null ? request.getParameter("mensaje") : "";
			String colorFondo = request.getParameter("colorFondo");

			Vector rel = null;

			rel = ejb.modificarTerritorio(codTerritorio, nomTerritorio, estado,	mensaje, colorFondo, gestor.getCodigoGestor());

			Vector relE = null;
			GestorPerfil codPerfil = new GestorPerfil();
			String CodigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
			String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();

			relE = ejb.busAllTerritorioActivo();
			request.setAttribute("listaTerritorio", relE);
			request.setAttribute("perfil", perfil);

			log.info("[MantenimientoTerritorioAction :: editar] Fin");
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", "Error al actualizar.");
			log.error("[MantenimientoTerritorioAction :: editar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("ok");
		}

		return (forward);
	}

	public ActionForward eliminarTerritorio(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		TerritorioForm TerritorioForm = new TerritorioForm();
		HttpSession sesion = null;
		Gestor gestor = null;

		try {
			log.info("[MantenimientoTerritorioAction :: eliminarTerritorio] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");

			String codigos = request.getParameter("codigos");
			String codigosTerritorio[] = codigos.split(";");

			for (int i = 0; i < codigosTerritorio.length; i++) {

				codigos = codigosTerritorio[i];
				Vector rel = null;
				rel = ejb.eliminarTerritorio(codigos);

			}
			Vector relEli = null;
			GestorPerfil codPerfil = new GestorPerfil();
			String CodigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
			String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();

			relEli = ejb.busAllTerritorioActivo();
			request.setAttribute("listaTerritorio", relEli);
			request.setAttribute("perfil", perfil);

			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
			log.info("[MantenimientoTerritorioAction :: eliminarTerritorio] Fin");
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", "Error al actualizar.");
			log.error("[MantenimientoTerritorioAction :: eliminarTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("ok");
		}

		return (forward);
	}

	public ActionForward mostrarMensajeTerritorio(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		TerritorioForm TerritorioForm = new TerritorioForm();
		HttpSession sesion = null;
		Gestor gestor = null;
		String codTerritorio = null;
		String mensajeTerritorio = "";
		String colorFondo = "#ffffff";
		ListabusAllTerritorio bean = null;
		Vector lista = null;

		try {
			log.info("[MantenimientoTerritorioAction :: mostrarMensajeTerritorio] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			codTerritorio = gestor.getCodigoTerritorio();
			lista = conexion.busTerritorioxCod(codTerritorio);

			if (lista != null && lista.size() > 0) {
				bean = (ListabusAllTerritorio) lista.get(0);

				mensajeTerritorio = bean.getMensaje() != null ? bean.getMensaje() : "";
				colorFondo = bean.getColorFondo();
			}

			request.setAttribute("mensajeTerritorio", mensajeTerritorio);
			request.setAttribute("colorFondo", colorFondo);

			log.info("[MantenimientoTerritorioAction :: mostrarMensajeTerritorio] Fin");
		} catch (Exception e) {
			log.error("[MantenimientoTerritorioAction :: mostrarMensajeTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrarMensajeTerritorio");
		}

		return (forward);
	}

	public ActionForward editarMensajeTerritorio(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		TerritorioForm TerritorioForm = new TerritorioForm();
		String codTerritorio = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		String mensaje = null;
		Vector lista = null;
		ListabusAllTerritorio bean = null;
		String mensajeTerritorio = "";
		String colorFondo = null;

		try {
			log.info("[MantenimientoTerritorioAction :: editarMensajeTerritorio] Inicio");

			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			codTerritorio = gestor.getCodigoTerritorio();
			mensaje = request.getParameter("mensaje") != null ? request.getParameter("mensaje") : "";
			colorFondo = request.getParameter("colorFondo");

			// editar
			conexion.editarMensajeTerritorio(codTerritorio, mensaje, colorFondo);

			// listar
			lista = conexion.busTerritorioxCod(codTerritorio);
			colorFondo = "#ffffff";
			if (lista != null && lista.size() > 0) {
				bean = (ListabusAllTerritorio) lista.get(0);

				mensajeTerritorio = bean.getMensaje() != null ? bean.getMensaje() : "";
				colorFondo = bean.getColorFondo();
			}

			request.setAttribute("mensajeTerritorio", mensajeTerritorio);
			request.setAttribute("colorFondo", colorFondo);

			log.info("[MantenimientoTerritorioAction :: editarMensajeTerritorio] Fin");

			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_EXITO);
		} catch (Exception e) {
			// Revisar mensaje de grabado
			request.getSession().setAttribute("error_Territorio", ConstantesUtil.MENSAJE_ERROR);
			log.error("[MantenimientoTerritorioAction :: editarMensajeTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		/*
		 * if (!errors.isEmpty()) { saveErrors(request, errors); forward =
		 * mapping.findForward("error"); } else { forward =
		 * mapping.findForward("mostrarMensajeTerritorio"); }
		 */

		forward = mapping.findForward("mostrarMensajeTerritorio");
		return (forward);
	}

	public ActionForward popupSelectorColor(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ActionForward forward = new ActionForward();

		log.info("[MantenimientoTerritorioAction :: popupSelectorColor] Inicio");

		forward = mapping.findForward("popupSelectorColor");

		log.info("[MantenimientoTerritorioAction :: popupSelectorColor] Fin");

		return (forward);
	}
}
