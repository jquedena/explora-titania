package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.ReportePPGForm;
import igrupobbva.pe.sistemasdoweb.util.GestorPerfil;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Avance;
import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
import com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG;
import com.grupobbva.bc.per.tele.sdo.serializable.Seguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"unchecked", "unused"})
public class ReportePPGAction extends DispatchAction {
	
	private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfAnho = new SimpleDateFormat("yyyy");
	private SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
	private SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
	private static Logger log = Logger.getLogger(ReportePPGAction.class);

	private void registraIngreso(String codMes, String codAnho, Gestor usuario, String codGestor, String codOficina) {
		Connection ejb = new Connection();
		long id =  ejb.existeIngresoForm(3
				, Integer.parseInt(codMes)
				, Integer.parseInt(codAnho)
				, usuario.getCodigoGestor()
				, ConstantesUtil.parseSQLString2(new Date())
				, codGestor
				, codOficina);
		
		String editUsuario = !usuario.getCodigoGestor().equals(codGestor) ? "1" : "0";
		
		if(id == 0) {
			ejb.insertarIngresoForm(3, Integer.parseInt(codMes), Integer.parseInt(codAnho), 
					usuario.getCodigoGestor(), editUsuario, codGestor, codOficina);
		} else {
			if(editUsuario.equals("1")) {
				ejb.actualizarIngresoFormEditUsuario(id);
			}
		}
	}
	
	public ActionForward reporteAvance(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = null;
		ActionForward forward = null;
		Connection conexion = null;
		HttpSession sesion = null;
		Multitabla multitabla = null;
		UtilListas utilList = null;
		Gestor sesionGestor = null;
		Vector listaMes = null;
		Vector listaAnio = null;
		Vector listaOficina = null;
		Vector listaOficinaHija = null;
		Vector listaGestor = null;
		Vector listaAcciones = null;
		Vector listaEsfuerzosAdicionales = null;
		String mes = null;
		String anio = null;
		String codOficina = null;
		String codGestor = null;
		String codGestorParam = null;
		String codPerfilGestor = null;
		
		try {
			log.info("[ReportePPGAction :: reporteAvance] Inicio");
			
			errors = new ActionErrors();
			forward = new ActionForward();
			conexion = new Connection();
			utilList = new UtilListas();
			
			sesion = request.getSession(false);
			sesionGestor = (Gestor) sesion.getAttribute("gestor");
			codGestorParam = request.getParameter("codGestor");
			String codTerr = request.getParameter("codTerr");
			
			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anio = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anio = request.getParameter("anho");
				mes = request.getParameter("mes");
				codOficina = request.getParameter("codOficina");
			}
			
			// Seleccionar mes y anio actual
			if(mes == null) {
				mes = ConstantesUtil.getMesActual();
			}
			
			if(anio == null) {
				anio = ConstantesUtil.getAnioActual();
			}
			
			// Carga Territorios
			Territorio lsterritorio;
			Vector listaTerritorio = new Vector();
			listaOficina = new Vector();
			Vector lstOficina = new Vector();
			String codTerritorio;
			if (sesionGestor.getCodigoPerfil().equals("GTE") || sesionGestor.getCodigoPerfil().equals("JPR")) {
				lsterritorio = conexion.findByCodTerritorio(sesionGestor.getCodigoTerritorio());
				listaTerritorio.add(lsterritorio);
				codTerritorio = sesionGestor.getCodigoTerritorio();
			} else if (sesionGestor.getCodigoPerfil().equals("CON") 
					|| sesionGestor.getCodigoPerfil().equals("ADM")
					|| sesionGestor.getCodigoPerfil().equals("SUP")) {
				listaTerritorio = conexion.findAllTerritorio();

				if (codTerr == null) {
					if (codOficina != null) {
						Territorio ox = conexion.findTerritorioByCodOficina(codOficina); 
						codTerritorio = "";
						if(ox != null) {
							codTerritorio = ox.getCodTerr();
						}
					} else {
						codTerritorio = ((Territorio) listaTerritorio.elementAt(0)).getCodTerr();
					}
				} else {
					codTerritorio = request.getParameter("codTerr");
				}
			} else {

				listaTerritorio = null;
				codTerritorio = "";
			}
			
			// Carga lista de anios
			multitabla = conexion.findMultiByPrimaryKey("T02", "1");
			listaAnio = utilList.obtenerListAnhos(multitabla.getValor1(), Integer.parseInt(multitabla.getValor2()));
			
			// Carga lista de oficinas
			listaOficina = conexion.findAllOficinaByCodTerri(codTerritorio);
			Oficina ox = conexion.findByCodOficina(sesionGestor.getCodigoOficina());
			ox.setCodOfic("%");
			ox.setNomOficina("-- Todos --");
			ox.setCodNomOficina("-- Todos --");
			listaOficina.add(ox);
			
			// Seleccionar oficina actual
			if(codOficina == null) {
				codOficina = ox.getCodOfic();
			}
			
			// Carga lista de gestores
			Gestor gestorHijo;
			listaGestor = utilList.listarGestoresNormal(codOficina);
			listaOficinaHija = conexion.findHijas(codOficina);
			if(listaOficinaHija != null) {
				Iterator iterHijas = listaOficinaHija.iterator();
				Vector listaGestoresHijas = null;
				
				if(listaGestor == null) {
					listaGestor = new Vector();
				}
				
				while(iterHijas.hasNext()) {
					OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
					
					if(oficinaHija != null) {
						listaGestoresHijas = utilList.listarGestoresSinMontos(oficinaHija.getCodigoOficinaHija());
						
						Iterator gestoresHijo = listaGestoresHijas.iterator();
						while(gestoresHijo.hasNext()) {
							gestorHijo = (Gestor) gestoresHijo.next();
							gestorHijo.setNombreGestor(gestorHijo.getNombreGestor() + " *");
						}
						
						if(listaGestoresHijas != null) {
							listaGestor.addAll(listaGestoresHijas);	
						}
					}
				}
			}
			
			gestorHijo = new Gestor();
			gestorHijo.setCodigoGestor("%");
			gestorHijo.setNombreGestor("-- Todos --");
			
			
			// 201206053 - Por validacion de perfiles
			if (sesionGestor.getCodigoPerfil().equals("GCO")
					|| sesionGestor.getCodigoPerfil().equals("GPE")
					|| sesionGestor.getCodigoPerfil().equals("GPT")
					|| sesionGestor.getCodigoPerfil().equals("EEM")) {
				Gestor obGestor = new Gestor();
				obGestor.setCodigoGestor(sesionGestor.getCodigoGestor());
				obGestor.setNombreGestor(sesionGestor.getNombreGestor());
				obGestor.setCodigoPerfil(sesionGestor.getCodigoPerfil());
				obGestor.setPerfilMostrar(sesionGestor.getPerfilMostrar());
				
				listaGestor = new Vector();
				listaGestor.add(obGestor);
			}
			
			if(listaGestor == null) {
				listaGestor = new Vector();
			}
			listaGestor.add(gestorHijo);
			
			// Seleccionar el gestor actual
			if(codGestorParam != null && !codGestorParam.equals("")) {
				if(listaGestor !=  null) {
					boolean existe = false;
					Iterator iterListaGestores = listaGestor.iterator();
					
					while(iterListaGestores.hasNext()) {
						Gestor gestorTemp = (Gestor)iterListaGestores.next();
						
						if(gestorTemp.getCodigoGestor().equals(codGestorParam)) {
							codGestor  = codGestorParam;
							codPerfilGestor = gestorTemp.getPerfilMostrar();
							existe = true;
							break;
						}
					}
					
					if(!existe) {
						if(listaGestor != null && listaGestor.size() > 0) {
							codGestor  = ((Gestor) listaGestor.get(0)).getCodigoGestor();
							codPerfilGestor = ((Gestor) listaGestor.get(0)).getPerfilMostrar();
						}
					}
				}
			} else {
				if(listaGestor !=  null && listaGestor.size() > 0) {
					codGestor  = "%";
					codPerfilGestor = ((Gestor) listaGestor.get(0)).getPerfilMostrar();
				}
			}
			
			if(codTerr == null){
				if(listaTerritorio!=null) {
					codTerr = ((Territorio) listaTerritorio.get(0)).getCodTerr();
				} else {
					codTerr = "";
				}
			}
			
			Vector<Avance> listaSeguimiento = conexion.avance(anio, mes, codTerr, codOficina, codGestor);
			
			request.setAttribute("mes", mes);
			request.setAttribute("anio", anio);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codTerr", codTerritorio);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codPerfilGestor", codPerfilGestor);
			request.setAttribute("listaMes", listaMes);
			request.setAttribute("listaAnio", listaAnio);
			request.setAttribute("listaOficina", listaOficina);
			request.setAttribute("listaGestor", listaGestor);
			request.setAttribute("listaSeguimiento", listaSeguimiento);
			request.setAttribute("listaTerritorio", listaTerritorio);
			if(listaSeguimiento != null && listaSeguimiento.size() > 0) {
				request.setAttribute("codEpigrafe", listaSeguimiento.get(0).getCodEpigrafe());
			} else {
				request.setAttribute("codEpigrafe", "***");
			}
			
			forward = mapping.findForward("reporteAvance");
			
			log.info("[ReportePPGAction :: reporteAvance] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: reporteAvance] Error");
			log.error(e);
			errors.add("name", new ActionError("id"));	
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		} 
		
		RegistraValorDefecto.getInstancia().registrar(request, anio, mes, codOficina);
		
		return forward;
	}	
	
	public ActionForward nuevoInicioReportePPG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = null;
		ActionForward forward = null;
		Connection conexion = null;
		HttpSession sesion = null;
		Multitabla multitabla = null;
		UtilListas utilList = null;
		Gestor sesionGestor = null;
		Vector listaMes = null;
		Vector listaAnio = null;
		Vector listaOficina = null;
		Vector listaOficinaHija = null;
		Vector listaGestor = null;
		Vector listaAcciones = null;
		Vector listaEsfuerzosAdicionales = null;
		String mes = null;
		String anio = null;
		String codOficina = null;
		String codGestor = null;
		String mesParam = null;
		String anioParam = null;
		String codOficinaParam = null;
		String codGestorParam = null;
		String codPerfilGestor = null;
		
		try {
			log.info("[ReportePPGAction :: nuevoInicioReportePPG] Inicio");
			
			errors = new ActionErrors();
			forward = new ActionForward();
			conexion = new Connection();
			utilList = new UtilListas();
			
			sesion = request.getSession(false);
			sesionGestor = (Gestor) sesion.getAttribute("gestor");
			
			mesParam = request.getParameter("mes");
			anioParam = request.getParameter("anho");
			codOficinaParam = request.getParameter("codOficina");
			codGestorParam = request.getParameter("codGestor");
			
			// Carga lista de anios
			multitabla = conexion.findMultiByPrimaryKey("T02", "1");
			listaAnio = utilList.obtenerListAnhos(multitabla.getValor1(), Integer.parseInt(multitabla.getValor2()));
			
			// Carga lista de oficinas
			if (sesionGestor.getCodigoPerfil().equals("GTE") || sesionGestor.getCodigoPerfil().equals("JPR")) {
				listaOficina = conexion.findAllOficinaByCodTerri(sesionGestor.getCodigoTerritorio());
			} else {
				if (sesionGestor.getCodigoPerfil().equals("CON") || sesionGestor.getCodigoPerfil().equals("ADM") || sesionGestor.getCodigoPerfil().equals("SUP")) {
					listaOficina = conexion.findAllOficinas();
				} else {
					listaOficina  = conexion.findListaByCodOficina(sesionGestor.getCodigoOficina());	
				}
			}	

			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anio = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anio = anioParam;
				mes = mesParam;
				
				// Seleccionar oficina actual
				if(codOficinaParam != null && !codOficinaParam.equals("")) {
					codOficina = codOficinaParam;
				} else {
					codOficina = ((Oficina) listaOficina.get(0)).getCodOfic();
				}
			}
			
			if(mes == null) {
				mes = ConstantesUtil.getMesActual();
			}
			
			if(anio == null) {
				anio = ConstantesUtil.getAnioActual();
			}
			
			// Carga lista de gestores
			listaGestor = utilList.listarGestoresNormal(codOficina);
			listaOficinaHija = conexion.findHijas(codOficina);
			if(listaOficinaHija != null) {
				Iterator iterHijas = listaOficinaHija.iterator();
				Vector listaGestoresHijas = null;
				
				if(listaGestor == null) {
					listaGestor = new Vector();
				}
				
				Gestor gestorHijo;
				
				while(iterHijas.hasNext()) {
					OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
					
					if(oficinaHija != null) {
						listaGestoresHijas = utilList.listarGestoresSinMontos(oficinaHija.getCodigoOficinaHija());
						
						Iterator gestoresHijo = listaGestoresHijas.iterator();
						while(gestoresHijo.hasNext()) {
							gestorHijo = (Gestor) gestoresHijo.next();
							gestorHijo.setNombreGestor(gestorHijo.getNombreGestor() + " *");
						}
						
						if(listaGestoresHijas != null) {
							listaGestor.addAll(listaGestoresHijas);
						}
					}
				}
			}
			
			// 201206053 - Por validacion de perfiles
			if (sesionGestor.getCodigoPerfil().equals("GCO")
					|| sesionGestor.getCodigoPerfil().equals("GPE")
					|| sesionGestor.getCodigoPerfil().equals("GPT")
					|| sesionGestor.getCodigoPerfil().equals("EEM")) {
				Gestor obGestor = new Gestor();
				obGestor.setCodigoGestor(sesionGestor.getCodigoGestor());
				obGestor.setNombreGestor(sesionGestor.getNombreGestor());
				obGestor.setCodigoPerfil(sesionGestor.getCodigoPerfil());
				obGestor.setPerfilMostrar(sesionGestor.getPerfilMostrar());
				
				listaGestor = new Vector();
				listaGestor.add(obGestor);
			}
			
			// Seleccionar el gestor actual
			if(codGestorParam != null && !codGestorParam.equals("")) {
				if(listaGestor !=  null) {
					boolean existe = false;
					Iterator iterListaGestores = listaGestor.iterator();
					
					while(iterListaGestores.hasNext()) {
						Gestor gestorTemp = (Gestor)iterListaGestores.next();
						
						if(gestorTemp.getCodigoGestor().equals(codGestorParam)) {
							codGestor  = codGestorParam;
							codPerfilGestor = gestorTemp.getPerfilMostrar();
							existe = true;
							break;
						}
					}
					
					if(!existe) {
						if(listaGestor != null && listaGestor.size() > 0) {
							codGestor  = ((Gestor) listaGestor.get(0)).getCodigoGestor();
							codPerfilGestor = ((Gestor) listaGestor.get(0)).getPerfilMostrar();
						}
					}
				}
			} else {
				if(listaGestor !=  null && listaGestor.size() > 0) {
					codGestor  = ((Gestor) listaGestor.get(0)).getCodigoGestor();
					codPerfilGestor = ((Gestor) listaGestor.get(0)).getPerfilMostrar();
				}
			}
			
			// Modificado - Extrayendo codigo de la vista.
			Vector<Seguimiento> listaSeguimiento = conexion.consultaSeguimientoAccionEsfuerzo(codOficina, mes, anio, codGestor) ;
			
			request.setAttribute("mes", mes);
			request.setAttribute("anio", anio);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codPerfilGestor", codPerfilGestor);
			request.setAttribute("listaMes", listaMes);
			request.setAttribute("listaAnio", listaAnio);
			request.setAttribute("listaOficina", listaOficina);
			request.setAttribute("listaGestor", listaGestor);
			request.setAttribute("listaSeguimiento", listaSeguimiento);
			if(listaSeguimiento != null && listaSeguimiento.size() > 0) {
				request.setAttribute("codEpigrafe", listaSeguimiento.get(0).getCodEpigrafe());
			} else {
				request.setAttribute("codEpigrafe", "***");
			}
			
			forward = mapping.findForward("conDato");
			
			log.info("[ReportePPGAction :: nuevoInicioReportePPG] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: nuevoInicioReportePPG] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));	
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}
		
		RegistraValorDefecto.getInstancia().registrar(request, anio, mes, codOficina);
		
		return forward;
	}
	
	
	public ActionForward inicioReportePPG(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	    log.debug("inicio inicioReportePPG");
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		forward = mapping.findForward("conDato");
		Vector listaOficina = null;
		Vector listaAnhos = null;
		Vector listaPlanes = null;
		Vector listaCampDetalle = null;
		GestorPerfil codPerfil = new GestorPerfil();
		ReportePPGForm reportPPGForm = (ReportePPGForm) form;
		Multitabla mul = null;
		String codigoGestor;
		UtilListas utilList = new UtilListas();
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: inicioReportePPG] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			mul = conexion.findMultiByPrimaryKey("T02", "1");
			String anhoBase = mul.getValor1();
			String indicador = "1";
			int rango = Integer.parseInt(mul.getValor2());
			listaAnhos = utilList.obtenerListAnhos(anhoBase, rango);
	
			gestor = (Gestor)sesion.getAttribute("gestor");
			String perfilGestor = gestor.getCodigoPerfil();
	
			String anho = null, mes = null, codOficina = null, presuReferencia = null;
			Calendar calendario = Calendar.getInstance();
			Date fecha = calendario.getTime();
	
			anho = (String) request.getParameter("anho");
			mes = (String) request.getParameter("mes");
			codOficina = (String) request.getParameter("codOficina");
			codigoGestor = (String) request.getParameter("codGestor");
	
			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				listaOficina = conexion.findAllOficinaByCodTerri(gestor
						.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")) {
					listaOficina = conexion.findAllOficinas();
				} else {
					listaOficina  = conexion.findListaByCodOficina(gestor.getCodigoOficina());	
				}
			}
	
			Gestor gestores = utilList.buscarGestor(codigoGestor);
			
			//(2011.02.16) Adicion de EBE(B67) como gestor
			if (gestor.getCodigoPerfil().equals("GCO")
					|| gestor.getCodigoPerfil().equals("GPE")
					|| gestor.getCodigoPerfil().equals("GPT")
					|| gestor.getCodigoPerfil().equals("EEM")) {
					codOficina = gestor.getCodigoOficina();
			}		
			
			Vector listaGestores = utilList.listarGestoresNormal(codOficina);
			Vector listaEpigrafes = conexion.findEpigrafesinPlanes(codOficina, anho, mes);			
			Vector temp = new Vector();
			String codEpigrafe = "";
			
			if (listaEpigrafes!= null){
				Epigrafe dato=null;
				for(int j= 0; j < listaEpigrafes.size(); j++){
					dato=(Epigrafe)listaEpigrafes.get(j);
					if(dato.getIndAfecta()!= null && dato.getIndAfecta().equals("S")){
						temp.add(dato);
					}
				}
				listaEpigrafes = temp;
			}
			
			if(listaEpigrafes != null && listaEpigrafes.size() > 0) {
				codEpigrafe = ((Epigrafe)listaEpigrafes.get(0)).getCodEpigrafe();
			}
			
			Vector listaOficinaHija = conexion.findHijas(codOficina);
			if(listaOficinaHija != null) {
				Iterator iterHijas = listaOficinaHija.iterator();
				Vector listaGestoresHijas = null;
				
				if(listaGestores == null) {
					listaGestores = new Vector();
				}
				
				while(iterHijas.hasNext()) {
					OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
					if(oficinaHija != null) {
						listaGestoresHijas = utilList.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, mes, anho);								
						if(listaGestoresHijas != null) {
							Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
							
							while(iterListaGestoresHijas.hasNext()) {
								Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
								// gestor1.setNombreGestor(gestor.getNombreGestor() + " *");
								BigDecimal monto = conexion.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, anho,
										codOficina, mes);
								
								if(gestor1.getMetaGestor() == null) {
									MetasGestor metasGestor = new MetasGestor();
									gestor1.setMetaGestor(metasGestor);																						
								} 
								gestor1.setPorcAsignado(monto);
								gestor1.getMetaGestor().setPorcAsignado(monto);
							}
						}
						
						if(listaGestoresHijas != null) {
							listaGestores.addAll(listaGestoresHijas);	
						}
					}
				}
			}
			
			//(2011.02.16) Adicion de EBE(B67) como gestor
			/*if (gestor.getCodigoPerfil().equals("GCO")
					|| gestor.getCodigoPerfil().equals("GPE")
					|| gestor.getCodigoPerfil().equals("GPT")) {*/
			if (gestor.getCodigoPerfil().equals("GCO")
					|| gestor.getCodigoPerfil().equals("GPE")
					|| gestor.getCodigoPerfil().equals("GPT")
					|| gestor.getCodigoPerfil().equals("EEM")) {
				listaGestores = new Vector();
	
				Gestor gest = new Gestor();
				gest.setCodigoGestor(gestor.getCodigoGestor());
				gest.setNombreGestor(gestor.getNombreGestor());
	
				listaGestores.add(gest);
			}
	
			if (codigoGestor == null || codigoGestor.equals("null")) {
				if (listaGestores != null && listaGestores.size() > 0) {
					codigoGestor = ((Gestor) listaGestores.get(0))
							.getCodigoGestor();
				}
			}
	
			String perfil = "";
	
			if (codigoGestor != null) {
				Gestor gestor1 = codPerfil.buscarGestor(codigoGestor);
	
				if (gestor1 != null) {
					perfil = gestor1.getCodigoPerfil();
				}
			}	
			listaPlanes = conexion.consultarPlanesAccionesPPG(codOficina, mes,
					anho, codigoGestor);
			listaCampDetalle = conexion.consultarCampaniasDetallesPGG(codOficina,
					mes, anho, codigoGestor);
			if (listaPlanes != null) {
				if (listaPlanes.size() > 0) {
					request.setAttribute("listaPlanesAcciones", listaPlanes);
				}
			}
			if (listaCampDetalle != null) {
				if (listaCampDetalle.size() > 0) {
					request.setAttribute("listaCampanias", listaCampDetalle);
				}
			}
			if (listaGestores != null) {
				if (listaGestores.size() > 0) {
					request.setAttribute("listaGestores", listaGestores);
				}
			}
			java.util.Date fechaCalendario = calendario.getTime();
			try {
				fechaCalendario = sdf.parse(sdf.format(fechaCalendario));
			} catch (ParseException pe) {
				pe.printStackTrace();
			}
			reportPPGForm.setAnho(anho);
			reportPPGForm.setMes(mes);
			reportPPGForm.setCodOficina(codOficina);
			if (listaPlanes != null) {
				if (listaPlanes.size() > 0) {
					forward = mapping.findForward("conDato");
				} else {
					forward = mapping.findForward("conDato");
				}
			}			
			request.setAttribute("listaOficina", listaOficina);
			request.setAttribute("listaAnhos", listaAnhos);
			request.setAttribute("perfilGestor", perfilGestor);
			request.setAttribute("perfil", perfil);
			
			log.info("[ReportePPGAction :: inicioReportePPG] Fin");
		} catch (Exception e) {
			log.error("[ReportePPGAction :: inicioReportePPG] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id")); //$NON-NLS-2$			
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		} 
		
		return (forward);
	}

	public ActionForward inicioReporte(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();// return value
		Connection conexion = new Connection();
		forward = mapping.findForward("conDato");
		Vector listaOficina = null;
		Vector listaAnhos = null;
		Vector listaPlanes = null;
		Vector listaCampDetalle = null;
		Vector listaGestores = null;
		GestorPerfil codPerfil = new GestorPerfil();
		UtilListas utilList = new UtilListas();
		String imp = (String) request.getParameter("imp");
		String anho = (String) request.getParameter("anho");
		String mes = (String) request.getParameter("mes");
		String codOficina = (String) request.getParameter("codOficina");
		String codigoGestor = (String) request.getParameter("codGestor");
		String presuReferencia = null;
		StringBuffer ajaxOut = new StringBuffer();
		Gestor beanGestor;
		HttpSession sesion = null;
		Gestor gestor = null;
		String inicio=request.getParameter("inicio");
		
		log.info("[ReportePPGAction :: inicioReporte] Inicio");
		
		if(inicio!=null && "1".equals(inicio)){
		    request.setAttribute("inicio2", "1");
		}
		String consultarDespuesDeCargar=request.getParameter("consultarDespuesDeCargar");
        if(consultarDespuesDeCargar!=null && "1".equals(consultarDespuesDeCargar)){
            request.setAttribute("consultarDespuesDeCargar2", "1");
        }
		try {
			sesion = request.getSession(false);
			
			if (imp != null) {
				forward = mapping.findForward("imp");
				request.setAttribute("listaOficina", sesion.getAttribute("listaOficina"));
				request.setAttribute("listaAnhos", sesion.getAttribute("listaAnhos"));				
				return (forward);
			}
	
			ReportePPGForm reportPPGForm = (ReportePPGForm) form;
			Multitabla mul = null;
			mul = conexion.findMultiByPrimaryKey("T02", "1");
			String anhoBase = mul.getValor1();
			String indicador = "1";
			int rango = Integer.parseInt(mul.getValor2());
			listaAnhos = utilList.obtenerListAnhos(anhoBase, rango);
	
			gestor = (Gestor) sesion.getAttribute("gestor");
	
			if (anho == null) {
				Calendar calendario = Calendar.getInstance();
				Date fecha = calendario.getTime();
				mes = sdfMes.format(fecha);
				anho = sdfAnho.format(fecha);
	
				java.util.Date fechaCalendario = calendario.getTime();
				try {
					fechaCalendario = sdf.parse(sdf.format(fechaCalendario));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
	
			String perfilGestor = gestor.getCodigoPerfil();
	
			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				listaOficina = conexion.findAllOficinaByCodTerri(gestor
						.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")) {
					listaOficina = conexion.findAllOficinas();
				} else {
					listaOficina  = conexion.findListaByCodOficina(gestor.getCodigoOficina());	
				}
			}
	
			if (codOficina == null) {
				if (listaOficina != null && listaOficina.size() > 0) {
					codOficina = ((Oficina) listaOficina.get(0)).getCodOfic();
				}
			}
	
			listaGestores = utilList.listarGestoresNormal(codOficina);
			
			// Gestores de las Oficinas hijas
			Vector listaEpigrafes = conexion.findEpigrafesinPlanes(codOficina, anho, mes);			
			Vector temp = new Vector();
			String codEpigrafe = "";
			
			if (listaEpigrafes!= null){
				Epigrafe dato=null;
				for(int i= 0; i < listaEpigrafes.size(); i++){
					dato=(Epigrafe)listaEpigrafes.get(i);
					if(dato.getIndAfecta()!= null && dato.getIndAfecta().equals("S")){
						temp.add(dato);
					}
				}
				listaEpigrafes = temp;
			}
			
			if(listaEpigrafes != null && listaEpigrafes.size() > 0) {
				codEpigrafe = ((Epigrafe)listaEpigrafes.get(0)).getCodEpigrafe();
			}
			
			Vector listaOficinaHija = conexion.findHijas(codOficina);
			if(listaOficinaHija != null) {
				Iterator iterHijas = listaOficinaHija.iterator();
				Vector listaGestoresHijas = null;
				
				if(listaGestores == null) {
					listaGestores = new Vector();
				}
				
				while(iterHijas.hasNext()) {
					OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
					if(oficinaHija != null) {
						listaGestoresHijas = utilList.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, mes, anho);								
						if(listaGestoresHijas != null) {
							Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
							
							while(iterListaGestoresHijas.hasNext()) {
								Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
								BigDecimal monto = conexion.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, anho,
										codOficina, mes);
								if(gestor1.getMetaGestor() == null) {
									MetasGestor metasGestor = new MetasGestor();
									gestor1.setMetaGestor(metasGestor);																						
								} 
								gestor1.setPorcAsignado(monto);
								gestor1.getMetaGestor().setPorcAsignado(monto);
							}
						}
						
						
						if(listaGestoresHijas != null) {
							listaGestores.addAll(listaGestoresHijas);	
						}
					}
				}
			}
			
			
			//(2011.02.16) Adicion de EBE(B67) como gestor
			/*if (gestor.getCodigoPerfil().equals("GCO")
					|| gestor.getCodigoPerfil().equals("GPE")
					|| gestor.getCodigoPerfil().equals("GPT")) {*/
			if (gestor.getCodigoPerfil().equals("GCO")
					|| gestor.getCodigoPerfil().equals("GPE")
					|| gestor.getCodigoPerfil().equals("GPT")
					|| gestor.getCodigoPerfil().equals("EEM")) {
				listaGestores = new Vector();
	
				Gestor gest = new Gestor();
				gest.setCodigoGestor(gestor.getCodigoGestor());
				gest.setNombreGestor(gestor.getNombreGestor());
				
				listaGestores = new Vector();
				
				listaGestores.add(gest);
			}
	
			if (codigoGestor == null || codigoGestor.equals("null")) {
				if (listaGestores != null && listaGestores.size() > 0) {
					codigoGestor = ((Gestor) listaGestores.get(0))
							.getCodigoGestor();
				}
			}
	
			String perfil = "";
	
			if (codigoGestor != null) {
				Gestor gestor1 = codPerfil.buscarGestor(codigoGestor);
	
				if (gestor != null) {
					perfil = gestor1.getCodigoPerfil();
				}
			}
	
			if (listaOficina != null) {
				for (int i = 0; i < listaOficina.size(); i++) {
					if (((Oficina) listaOficina.elementAt(i)).getCodOfic().length() > 3) {
						if (((Oficina) listaOficina.elementAt(i)).getCodOfic()
								.substring(1, 4).equals(
										(((Oficina) listaOficina.elementAt(i))
												.getTerr().getCodTerr().substring(
												1, 4)))) {
							listaOficina.remove(i);
							i--;
						}
					}
				}
			}
	
			listaPlanes = conexion.consultarPlanesAccionesPPG(codOficina, mes,
					anho, codigoGestor);
			listaCampDetalle = conexion.consultarCampaniasDetallesPGG(codOficina,
					mes, anho, codigoGestor);
			
			if (listaPlanes != null) {
				if (listaPlanes.size() > 0) {
					request.setAttribute("listaPlanesAcciones", listaPlanes);
					sesion.setAttribute("listaPlanesAcciones",
							listaPlanes);
				}
			}
			if (listaCampDetalle != null) {
				if (listaCampDetalle.size() > 0) {
					request.setAttribute("listaCampanias", listaCampDetalle);
					sesion.setAttribute("listaCampanias",
							listaCampDetalle);
				}
			}
			if (listaGestores != null) {
				if (listaGestores.size() > 0) {
					String listaPerfiles = "";
					for (int i = 0; i < listaGestores.size(); i++) {
						listaPerfiles += ((Gestor) listaGestores.elementAt(i))
								.getCodigoPerfil()
								+ ",";
					}
					request.setAttribute("listaPerfilesG", listaPerfiles);
					request.setAttribute("listaGestores", listaGestores);
				}
			}

			reportPPGForm.setAnho(anho);
			reportPPGForm.setMes(mes);
			reportPPGForm.setCodOficina(codOficina);
			if (listaPlanes != null) {
				if (listaPlanes.size() > 0) {
					forward = mapping.findForward("conDato");
				} else {
					forward = mapping.findForward("conDato");
				}
			}
			request.setAttribute("perfilGestor", perfilGestor);
			sesion.setAttribute("listaOficina", listaOficina);
			sesion.setAttribute("listaAnhos", listaAnhos);
			request.setAttribute("perfil", perfil);
			
			log.info("[ReportePPGAction :: inicioReporte] Fin");
		} catch (Exception e) {
			log.error("[ReportePPGAction :: inicioReporte] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));	
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		} 
		
		return (forward);
	}
	
	
	public ActionForward inicioReportePGGAcciones(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward =  null;
		Gestor gestor = null;
		String codAnho = request.getParameter("codAnho");
		String codMes = request.getParameter("codMes");
		String codOficina = request.getParameter("codOficina");
		
		try {
			log.info("[ReportePPGAction :: inicioReportePGGAcciones] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			String CodigoUsuario = gestor.getCodigoGestor();
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			Campanias bean = null;
			Vector newListaOficina = null;
			
			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				codAnho = defecto.getAnho();
				codMes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				codAnho = request.getParameter("codAnho") == null ? defecto.getAnho() : request.getParameter("codAnho");
				codMes = request.getParameter("codMes") == null ? defecto.getMes() : request.getParameter("codMes");
				if(request.getParameter("codOficina") == null) {
					codOficina = defecto.getOficina();
				} else {
					String codOficina_ = request.getParameter("codOficina");
					String ofic[] = codOficina.split(" - ");
					codOficina = ofic[0];
				}
			}
			
			Calendar calendario = Calendar.getInstance();
			Date fecha = calendario.getTime();
			if (codMes == null) {
				codMes = sdfMes.format(fecha);
			}
			if (codAnho == null) {
				codAnho = sdfAnho.format(fecha);
			}
			
			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				newListaOficina = ejb.findAllOficinaByCodTerri(gestor.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")) {
					newListaOficina = ejb.findAllOficinas();
				} else {								
					newListaOficina = ejb.findListaByCodOficina(gestor.getCodigoOficina());	
				}
			}
	
			Multitabla mul = null;
			UtilListas utilList = new UtilListas();
			mul = ejb.findMultiByPrimaryKey("T02", "1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());
			Oficina ofi = null;
	
			if (request.getParameter("codOficina") == null) {	
				Territorio terr = ejb.findTerritorioByCodOficina(gestor.getCodigoOficina());
				String codTerritorio = "";
				if (terr != null) {
					codTerritorio = terr.getCodTerr();
				}
	
				//Vector
				Vector codOficMax = ejb.codOficinaMax(codTerritorio);
				bean = (Campanias) codOficMax.elementAt(0);
				// String codOficina1 = "0" + bean.getCodOficicina();

				if(codOficina == null) {
					if (newListaOficina != null && newListaOficina.size() > 0) {
						ofi = (Oficina) newListaOficina.get(0);
					}
					if(ofi != null) { 
						codOficina = ofi.getCodOfic();
					}
				}

				Vector rel1 = utilList.obtenerListAnhos(anhoBase, rango);
	
				request.setAttribute("listaAnhos", rel1);
				Vector rel2 = ejb.busOficinaCodyNom(codTerritorio);
				request.setAttribute("listaOficina", rel2);
	
				Vector rel3 = null;
				rel3 = utilList.listarGestores(codOficina, "", codMes, codAnho); // codOficina1 
				
				// Gestores de las Oficinas hijas
				Vector listaEpigrafes = ejb.findEpigrafesinPlanes(codOficina, codAnho, codMes);			
				Vector temp = new Vector();
				String codEpigrafe = "";
				
				if (listaEpigrafes!= null){
					Epigrafe dato=null;
					for(int i= 0; i < listaEpigrafes.size(); i++){
						dato=(Epigrafe)listaEpigrafes.get(i);
						if(dato.getIndAfecta()!= null && dato.getIndAfecta().equals("S")){
							temp.add(dato);
						}
					}
					listaEpigrafes = temp;
				}
				
				if(listaEpigrafes != null && listaEpigrafes.size() > 0) {
					codEpigrafe = ((Epigrafe)listaEpigrafes.get(0)).getCodEpigrafe();
				}
				
				Vector listaOficinaHija = ejb.findHijas(codOficina);
				if(listaOficinaHija != null) {
					Iterator iterHijas = listaOficinaHija.iterator();
					Vector listaGestoresHijas = null;
					
					if(rel3 == null) {
						rel3 = new Vector();
					}
					
					while(iterHijas.hasNext()) {
						OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
						if(oficinaHija != null) {
							listaGestoresHijas = utilList.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, codMes, codAnho);								
							if(listaGestoresHijas != null) {
								Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
								
								while(iterListaGestoresHijas.hasNext()) {
									Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
									BigDecimal monto = ejb.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, codAnho, codOficina, codMes);
									if(gestor1.getMetaGestor() == null) {
										MetasGestor metasGestor = new MetasGestor();
										gestor1.setMetaGestor(metasGestor);																						
									} 
									gestor1.setPorcAsignado(monto);
									gestor1.getMetaGestor().setPorcAsignado(monto);
								}
							}
							
							
							if(listaGestoresHijas != null) {
								rel3.addAll(listaGestoresHijas);	
							}
						}
					}
				}
	
				// 201206053 - Por validacion de perfiles
				if (gestor.getCodigoPerfil().equals("GCO")
						|| gestor.getCodigoPerfil().equals("GPE")
						|| gestor.getCodigoPerfil().equals("GPT")
						|| gestor.getCodigoPerfil().equals("EEM")) {
					rel3 = new Vector();
					Gestor gest = new Gestor();
					gest.setCodigoGestor(gestor.getCodigoGestor());
					gest.setNombreGestor(gestor.getNombreGestor());
					gest.setCodigoPerfil(gestor.getCodigoPerfil());
					gest.setPerfilMostrar(gestor.getPerfilMostrar());
					
					rel3.add(gest);
				}
	
				request.setAttribute("listaGestor", rel3);
				request.setAttribute("codOficinaReturn", codOficina); // codOficina1
				request.setAttribute("codAnhoReturn", codAnho);
				request.setAttribute("codMesReturn", codMes);
				request.setAttribute("newListaOficina", newListaOficina);
			} else {
				// String codOficina = request.getParameter("codOficina");
				// String ofic[] = codOficina.split(" - ");
				// String codOficina1 = ofic[0];
				// String codAnho = request.getParameter("codAnho");
				// String codMes = request.getParameter("codMes");
	
				Territorio terr = ejb.findTerritorioByCodOficina(gestor.getCodigoOficina());
				
				String codTerritortio = "";
				if (terr != null) {
					codTerritortio = terr.getCodTerr();
				}
	
				Vector rel1 = utilList.obtenerListAnhos(anhoBase, rango);
				request.setAttribute("listaAnhos", rel1);
				Vector rel2 = ejb.busOficinaCodyNom(codTerritortio);
				request.setAttribute("listaOficina", rel2);
				Vector rel3 = utilList.listarGestores(codOficina, "", codMes, codAnho); // codOficina1
	
				// Gestores de las Oficinas hijas
				Vector listaEpigrafes = ejb.findEpigrafesinPlanes(codOficina, codAnho, codMes);			
				Vector temp = new Vector();
				String codEpigrafe = "";
				
				if (listaEpigrafes!= null){
					Epigrafe dato=null;
					for(int i= 0; i < listaEpigrafes.size(); i++){
						dato=(Epigrafe)listaEpigrafes.get(i);
						if(dato.getIndAfecta()!= null && dato.getIndAfecta().equals("S")){
							temp.add(dato);
						}
					}
					listaEpigrafes = temp;
				}
				
				if(listaEpigrafes != null && listaEpigrafes.size() > 0) {
					codEpigrafe = ((Epigrafe)listaEpigrafes.get(0)).getCodEpigrafe();
				}
				
				Vector listaOficinaHija = ejb.findHijas(codOficina);
				if(listaOficinaHija != null) {
					Iterator iterHijas = listaOficinaHija.iterator();
					Vector listaGestoresHijas = null;
					
					if(rel3 == null) {
						rel3 = new Vector();
					}
					
					while(iterHijas.hasNext()) {
						OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
						if(oficinaHija != null) {
							listaGestoresHijas = utilList.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, codMes, codAnho);								
							if(listaGestoresHijas != null) {
								Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
								
								while(iterListaGestoresHijas.hasNext()) {
									Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
									BigDecimal monto = ejb.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, codAnho,
											codOficina, codMes);
									if(gestor1.getMetaGestor() == null) {
										MetasGestor metasGestor = new MetasGestor();
										gestor1.setMetaGestor(metasGestor);																						
									} 
									gestor1.setPorcAsignado(monto);
									gestor1.getMetaGestor().setPorcAsignado(monto);
								}
							}
							
							
							if(listaGestoresHijas != null) {
								rel3.addAll(listaGestoresHijas);	
							}
						}
					}
				}
				
				//(2011.02.16) Adicion de EBE(B67) como gestor
				/*if (gestor.getCodigoPerfil().equals("GCO")
						|| gestor.getCodigoPerfil().equals("GPE")
						|| gestor.getCodigoPerfil().equals("GPT")) {*/
				if (gestor.getCodigoPerfil().equals("GCO")
						|| gestor.getCodigoPerfil().equals("GPE")
						|| gestor.getCodigoPerfil().equals("GPT")
						|| gestor.getCodigoPerfil().equals("EEM")) {
					rel3 = new Vector();
	
					// 201206053 - Por validacion de perfiles
					Gestor gest = new Gestor();
					gest.setCodigoGestor(gestor.getCodigoGestor());
					gest.setNombreGestor(gestor.getNombreGestor());
					gest.setCodigoPerfil(gestor.getCodigoPerfil());
					gest.setPerfilMostrar(gestor.getPerfilMostrar());
					
					rel3.add(gest);
				}
				
				request.setAttribute("listaGestor", rel3);
				
				request.setAttribute("codOficinaReturn", codOficina);
				request.setAttribute("codAnhoReturn", codAnho);
				request.setAttribute("codMesReturn", codMes);
				request.setAttribute("newListaOficina", newListaOficina);
				
			}
			
			log.info("[ReportePPGAction :: inicioReportePGGAcciones] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: inicioReportePGGAcciones] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones1");
		}

		RegistraValorDefecto.getInstancia().registrar(request, codAnho, codMes, codOficina);
		
		return (forward);
	}

	public ActionForward inicioReportePGGAcciones2(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionForward forward = null;
		ActionErrors errors = null; 
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: inicioReportePGGAcciones2] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			IILDPeUsuario usuario = null;
			//String CodigoUsuario = (String) sesion.getAttribute("registro");
			String CodigoUsuario = gestor.getCodigoGestor();
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
			errors = new ActionErrors();
			forward = new ActionForward(); 
			Connection ejb = new Connection();
			
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String nomGestor = request.getParameter("nombreGestorAccion");
			
			String arreglo[] = null; 
			String nuevoCodGestor = null;
			String nuevoCodPerfil = null;
			if(codGestor != null) {
				arreglo = codGestor.split("-");
			}
			
			if(arreglo.length > 1) {
				nuevoCodGestor = arreglo[0];
				nuevoCodPerfil = arreglo[1];
			} else {
				if(arreglo.length == 1) {
					nuevoCodGestor = arreglo[0];
				}
			}
			
			MetasGestor metasGestor = ejb.findGestorByCodMonthYear(codAnho, codMes, codOficina, nuevoCodGestor);
			if (metasGestor == null) {
				try {
					String codMetaGestor = ejb.getCorrelativo("TIIDO_METAS_GESTOR", "COD_META_GESTOR", "8");
					String codTerritorio = ejb.findTerritorioByCodOficina(
							codOficina).getCodTerr();
					Double porc_asig = new Double(0);
					
					if(codMetaGestor != null && nuevoCodGestor != null) {
						Vector rel = ejb.nuevaMetaGestor(codMetaGestor, codTerritorio,
								codOficina, "0001001", codAnho, nuevoCodGestor, nuevoCodPerfil, codMes,
								porc_asig, "CARTERA ATRASADA MONTO", nomGestor, CodigoUsuario);
					}
				} catch (Exception ex) {
					log.error("[ReportePPGAction :: inicioReportePGGAcciones2] ");
					log.error(ex.getMessage());
					ex.printStackTrace();
				}
			}
	
			Vector rel1 = ejb.busEpigrafeAcciones2(nuevoCodGestor, codAnho, codMes, codOficina);
			Vector temp = new Vector();
			if (rel1 != null) {
				ReportePPG dato = null;
				for (int i = 0; i < rel1.size(); i++) {
					dato = (ReportePPG) rel1.get(i);
					if (dato.getIndAfecta() != null
							&& dato.getIndAfecta().equals("S")) {
						temp.add(dato);
					}
				}
				rel1 = temp;
			}

			request.setAttribute("listaEpigrafe", rel1);
			Vector rel2 = ejb.busAllAnhos();
			request.setAttribute("listaAnhos", rel2);
			Vector rel3 = ejb.mostrarEsfuerzoCampania(nuevoCodGestor, codMes, codAnho, codOficina);
			request.setAttribute("listaEsfuerzos", rel3);
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", nuevoCodGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
	
			if (request.getParameter("nombreGestorAccion") != null) {
				sesion.setAttribute("nombreGestorAccion", request.getParameter("nombreGestorAccion"));
			}
			
			log.info("[ReportePPGAction :: inicioReportePGGAcciones2] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: inicioReportePGGAcciones2] ");
			log.error(e.getMessage());
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	
			
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones2");
		}
		
		return (forward);
	}

	public ActionForward mostrarNuevaCampania(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IILDPeUsuario usuario = null;
		HttpSession sesion = null;
		ActionForward forward = null;
		ActionErrors errors = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: mostrarNuevaCampania] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			//String CodigoUsuario = (String) sesion.getAttribute(
			//		"registro");
			String CodigoUsuario = gestor.getNombreGestor();
			
			usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario.recuperarUsuario(CodigoUsuario);
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
	
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
	
			String nomCampania = null;
			String prioridad = null;
			nomCampania = "";
			prioridad = "";
	
			Vector listaEpigrafes = ejb.findEpigrafesinPlanes(codOficina,codAnho,codMes);			
			Vector temp = new Vector();
			
			if (listaEpigrafes!= null){
				Epigrafe dato=null;
				for(int i= 0; i < listaEpigrafes.size(); i++){
					dato=(Epigrafe)listaEpigrafes.get(i);
					if(dato.getIndAfecta()!= null && dato.getIndAfecta().equals("S")){
						temp.add(dato);
					}
				}
				listaEpigrafes=temp;
				dato =  new Epigrafe();
				dato.setCodEpigrafe("***");
				dato.setNomEpigrafe("--Seleccionar--");
				listaEpigrafes.add(dato);
			}
			request.setAttribute("listaEpigrafes", listaEpigrafes);
			
			
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
	
			request.setAttribute("nomCampania", nomCampania);
			request.setAttribute("prioridad", prioridad);
			
			log.info("[ReportePPGAction :: mostrarNuevaCampania] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: mostrarNuevaCampania] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrarNuevaCampania");
		}

		return (forward);
	}

	
	public ActionForward nuevaCampania(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = null; 
		ActionForward forward = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: nuevaCampania] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			String CodigoUsuario = gestor.getCodigoGestor();
			// String CodigoUsuario = (String) sesion.getAttribute("registro");
			
			Connection ejb = new Connection();
			errors = new ActionErrors();
			forward = new ActionForward();
	
			String codMes = request.getParameter("codMes");
			String codAnho = request.getParameter("codAnho");
			String nomCampania = request.getParameter("nomCampania");
			String prioridad = request.getParameter("prioridad");
			String codOficina = request.getParameter("codOficina");
			String codGestor = request.getParameter("codGestor");
			String codEpigrafe = request.getParameter("codEpigrafe");
			String gte = "10";
	
			int codCamp = 0;
			codCamp = ejb.codigoCampMax();
			codCamp = codCamp + 1;
	
			Vector rel1 = null;
			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			String codTerritorio = "";
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
			}
	
			rel1 = ejb.nuevaCampania(codCamp, nomCampania, codOficina,
					codTerritorio, codGestor, codAnho, codMes, prioridad, gte,
					gestor.getCodigoGestor(), codEpigrafe);
	
			String codOficinaCompletoNC = request
					.getParameter("codOficinaCompleto");
			String codGestorNC = request.getParameter("codGestor");
	
			String codAnhoNC = request.getParameter("codAnho");
			String codMesNC = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompletoNC.split(" - ");
			String codOficinaNC = codOficina1[0];
	
			Vector rel1NC = ejb.busEpigrafeAcciones2(codGestorNC, codAnhoNC,
					codMesNC, codOficinaNC);
			request.setAttribute("listaEpigrafe", rel1NC);
	
			Vector rel2NC = ejb.busAllAnhos();
			request.setAttribute("listaAnhos", rel2NC);
	
			Vector rel3NC = ejb.mostrarEsfuerzoCampania(codGestorNC, codMesNC,
					codAnhoNC, codOficinaNC);
			request.setAttribute("listaEsfuerzos", rel3NC);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompletoNC);
			request.setAttribute("codOficina", codOficinaNC);
			request.setAttribute("codGestor", codGestorNC);
			request.setAttribute("codAnho", codAnhoNC);
			request.setAttribute("codMes", codMesNC);
			
			// GSI-F20120731 [nuevaCampania]
			Gestor usuario = (Gestor) sesion.getAttribute("gestor");
			registraIngreso(codMes, codAnho, usuario, codGestor, codOficina);
			
			log.info("[ReportePPGAction :: nuevaCampania] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: nuevaCampania] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones2");
		}

		return (forward);
	}

	
	public ActionForward eliminarCampania(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = null;
		ActionForward forward = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: eliminarCampania] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			//String CodigoUsuario = (String) sesion.getAttribute("registro");
			String CodigoUsuario = gestor.getCodigoGestor();
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codigos = request.getParameter("codigos");
			String codigosCampanias[] = codigos.split(";");
	
			for (int i = 0; i < codigosCampanias.length; i++) {
	
				codigos = codigosCampanias[i];
				Vector rel = null;
				rel = ejb.eliminarCampania(codigos);
			}
	
			String codOficinaCompletoEli = request.getParameter("codOficinaCompleto");
			String codGestorEli = request.getParameter("codGestor");
			String codAnhoEli = request.getParameter("codAnho");
			String codMesEli = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompletoEli.split(" - ");
			String codOficinaEli = codOficina1[0];
	
			Vector rel1Eli = ejb.busEpigrafeAcciones2(codGestorEli, codAnhoEli, codMesEli, codOficinaEli);
			request.setAttribute("listaEpigrafe", rel1Eli);
	
			Vector rel2Eli = ejb.busAllAnhos();
			request.setAttribute("listaAnhos", rel2Eli);
	
			Vector rel3Eli = ejb.mostrarEsfuerzoCampania(codGestorEli, codMesEli, codAnhoEli, codOficinaEli);
			request.setAttribute("listaEsfuerzos", rel3Eli);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompletoEli);
			request.setAttribute("codOficina", codOficinaEli);
			request.setAttribute("codGestor", codGestorEli);
			request.setAttribute("codAnho", codAnhoEli);
			request.setAttribute("codMes", codMesEli);
			
			// GSI-F20120731 [eliminarCampania]
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			registraIngreso(codMesEli, codAnhoEli, usuario, codGestorEli, codOficinaEli);
			
			log.info("[ReportePPGAction :: eliminarCampania] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: eliminarCampania] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones2");
		}

		return (forward);
	}

	public ActionForward mostrarEditarCampania(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = null;
		ActionForward forward = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: mostrarEditarCampania] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			//String CodigoUsuario = (String) sesion.getAttribute("registro");
			String CodigoUsuario = gestor.getCodigoGestor();
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codCamp = request.getParameter("codCamp");
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
	
			Vector rel = null;
			rel = ejb.mostrarEditarCampania(codCamp);
			
			Vector listaEpigrafes = ejb.findEpigrafesinPlanes(codOficinaCompleto,codAnho,codMes);			
			Vector temp = new Vector();
			
			if (listaEpigrafes!= null){
				Epigrafe dato=null;
				for(int i= 0; i < listaEpigrafes.size(); i++){
					dato=(Epigrafe)listaEpigrafes.get(i);
					if(dato.getIndAfecta()!= null && dato.getIndAfecta().equals("S")){
						temp.add(dato);
					}
				}
				listaEpigrafes=temp;
				dato =  new Epigrafe();
				dato.setCodEpigrafe("***");
				dato.setNomEpigrafe("--Seleccionar--");
				listaEpigrafes.add(dato);
			}
			request.setAttribute("listaEpigrafes", listaEpigrafes);
			
			
			request.setAttribute("listaEditar", rel);
			request.setAttribute("codCamp", codCamp);
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			
			log.info("[ReportePPGAction :: mostrarEditarCampania] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: mostrarEditarCampania] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");

		} else {
			forward = mapping.findForward("editarCampania");
		}
		
		return (forward);
	}
	
	
	public ActionForward editarCampania(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = null; 
		ActionForward forward = null; 
		HttpSession sesion = null;
		Gestor gestor = null;
			
		try {
			log.info("[ReportePPGAction :: editarCampania] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codCamp = request.getParameter("CodigoCamp");
			String anho = request.getParameter("codAnho");
			String mes = request.getParameter("codMes");
			String nomCamp = request.getParameter("nomCampania");
			String codOrden = request.getParameter("codOrden");
			String codEpigrafe = request.getParameter("codEpigrafe");
			Vector rel = null;
	
			rel = ejb.editarCampania(anho, mes, nomCamp, codOrden, codCamp, 
					gestor.getCodigoGestor(), codEpigrafe);
	
			String codOficinaCompletoEC = request.getParameter("codOficinaCompleto");
			String codGestorEC = request.getParameter("codGestor");
	
			String codAnhoEC = request.getParameter("codAnho");
			String codMesEC = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompletoEC.split(" - ");
			String codOficinaEC = codOficina1[0];
	
			Vector rel1EC = ejb.busEpigrafeAcciones2(codGestorEC, codAnhoEC,
					codMesEC, codOficinaEC);
			request.setAttribute("listaEpigrafe", rel1EC);
	
			Vector rel2NC = ejb.busAllAnhos();
			request.setAttribute("listaAnhos", rel2NC);
	
			Vector rel3NC = ejb.mostrarEsfuerzoCampania(codGestorEC, codMesEC,
					codAnhoEC, codOficinaCompletoEC);
			request.setAttribute("listaEsfuerzos", rel3NC);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompletoEC);
			request.setAttribute("codOficina", codOficinaEC);
			request.setAttribute("codGestor", codGestorEC);
			request.setAttribute("codAnho", codAnhoEC);
			request.setAttribute("codMes", codMesEC);
			
			// GSI-F20120731 [editarCampania]
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			registraIngreso(codMesEC, codAnhoEC, usuario, codGestorEC, codOficinaEC);
			
			log.info("[ReportePPGAction :: editarCampania] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: editarCampania] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones2");
		}

		return (forward);
	}

	
	public ActionForward inicioReportePGGAcciones3(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		ActionForward forward = null; 
		
		try {
			log.info("[ReportePPGAction :: inicioReportePGGAcciones3] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			//String CodigoUsuario = (String) sesion.getAttribute("registro");
			String CodigoUsuario = gestor.getCodigoGestor();
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codEpigrafe = request.getParameter("codEpigrafe");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String nomEpigrafe = request.getParameter("nomEpigrafe");
			String prioridad = request.getParameter("prioridad");
	
			Plan planes = ejb.findConsultaPlanesResumen(codMes, codAnho, codEpigrafe, codOficina);
			String restoOficina = planes.getRestoOficina() != null ? planes.getRestoOficina().toString() : "";
	
			String metaGestor = "";
			UtilListas utilList = new UtilListas();
			Vector listaGestores = utilList.listarGestores(codOficina, codEpigrafe, codMes, codAnho);
			
			// Gestores de las Oficinas hijas
			Vector listaOficinaHija = ejb.findHijas(codOficina);
			if(listaOficinaHija != null) {
				Iterator iterHijas = listaOficinaHija.iterator();
				Vector listaGestoresHijas = null;
				
				if(listaGestores == null) {
					listaGestores = new Vector();
				}
				
				while(iterHijas.hasNext()) {
					OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
					if(oficinaHija != null) {
						listaGestoresHijas = utilList.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, codMes, codAnho);								
						if(listaGestoresHijas != null) {
							Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
							
							while(iterListaGestoresHijas.hasNext()) {
								Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
								BigDecimal monto = ejb.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, codAnho,
										codOficina, codMes);
								if(gestor1.getMetaGestor() == null) {
									MetasGestor metasGestor = new MetasGestor();
									gestor1.setMetaGestor(metasGestor);																						
								} 
								gestor1.setPorcAsignado(monto);
								gestor1.getMetaGestor().setPorcAsignado(monto);
							}
						}
						
						
						if(listaGestoresHijas != null) {
							listaGestores.addAll(listaGestoresHijas);	
						}
					}
				}
			}
			
			// Busqueda de la meta del gestor	
			if (listaGestores != null) {
				for (int i = 0; i < listaGestores.size(); i++) {
					Gestor gestor1 = (Gestor) listaGestores.get(i);
					if (gestor1 != null && gestor1.getCodigoGestor().equalsIgnoreCase(codGestor)) {
						metaGestor = gestor1.getPorcAsignado().toString();
						break;
					}
				}
			}
	
			String perfil = "";
			perfil = gestor.getCodigoPerfil();
	
			Vector rel1 = ejb.busAccionesPGG3(codAnho, codMes, codGestor, codEpigrafe);
	
			request.setAttribute("listaAcciones", rel1);
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("nomEpigrafe", nomEpigrafe);
			request.setAttribute("prioridad", prioridad);
			request.setAttribute("restoOficina", String.valueOf(restoOficina));
			request.setAttribute("metaGestor", String.valueOf(metaGestor));
			request.setAttribute("codEpigrafe", codEpigrafe);
			request.setAttribute("perfil", perfil);
			sesion.setAttribute("___objGestor", String.valueOf(metaGestor));
			
			log.info("[ReportePPGAction :: inicioReportePGGAcciones3] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: inicioReportePGGAcciones3] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			e.printStackTrace();
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones3");
		}

		return (forward);
	}

	
	public ActionForward mostarNuevaAccion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = null;
		HttpSession sesion = null;
		ActionForward forward = null; 
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: mostarNuevaAccion] Inicio");
			
			sesion = request.getSession(false);
			//String CodigoUsuario = (String) sesion.getAttribute("registro");
			//usuario = com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario
			//		.recuperarUsuario(CodigoUsuario);
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
	
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String nomEpigrafe = request.getParameter("nomEpigrafe");
			String prioridad = request.getParameter("prioridad");
			String restoOficina = request.getParameter("restoOficina");
			String metaGestor = request.getParameter("metaGestor");
			String codEpigrafe = request.getParameter("codEpigrafe");
			Vector<Accion> listaAccion = ejb.busAccionesPGG3(codAnho, codMes, codGestor, codEpigrafe);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("nomEpigrafe", nomEpigrafe);
			request.setAttribute("prioridad", prioridad);
			request.setAttribute("restoOficina", String.valueOf(restoOficina));
			request.setAttribute("metaGestor", String.valueOf(metaGestor));
			request.setAttribute("codEpigrafe", codEpigrafe);
			if(listaAccion == null) {
				request.setAttribute("totalAcciones", "0");
			} else {
				int totalAcciones = 0;
				int temp;
				for(Accion o : listaAccion) {
					temp = Integer.parseInt(o.getCompGestor());
					totalAcciones += temp;
				}
				request.setAttribute("totalAcciones", String.valueOf(totalAcciones));
			}
			
			log.info("[ReportePPGAction :: mostarNuevaAccion] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: mostarNuevaAccion] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones3nuevo");
		}

		return (forward);
	}

	
	public ActionForward nuevaAccion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = null;
		ActionForward forward = null;
		HttpSession sesion = null;
		Gestor usuario = null; 
			
		try {
			log.info("[ReportePPGAction :: nuevaAccion] Inicio");
			
			sesion = request.getSession(false);
			
			usuario = (Gestor)sesion.getAttribute("gestor");
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();

			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codEpigrafe = request.getParameter("codEpigrafe");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String nomEpigrafe = request.getParameter("nomEpigrafe");
			String prioridad = request.getParameter("prioridad");
			String restoOficina = request.getParameter("restoOficina");
			String metaGestor = request.getParameter("metaGestor");
			String descAccion = request.getParameter("descAccion");
			String numeroCliente = request.getParameter("numeroCliente");
			String compromisoGestor = request.getParameter("compromisoGestor");
	
			Object objIngresoUsuario = null;
			int idIngresoUsuario = 0;
	
			int codAccion = 0;
			codAccion = ejb.codigoAccion();
			log.info("[ReportePPGAction :: nuevaAccion] codAccion::: " + codAccion);
			codAccion = codAccion + 1;
			String codigoAccion = String.valueOf(codAccion);
	
			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			String codTerritorio = "";
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
			}
			
			Vector rel1 = null;
			if(codigoAccion != null) {			
				rel1 = ejb.nuevaAccion(codigoAccion, codEpigrafe, codAnho,
					codTerritorio, codOficina, descAccion.trim(), codGestor,
					codMes, numeroCliente, compromisoGestor, "0", "0", "0", "0",
					"0", "0", usuario.getCodigoGestor());
			}
	
			Vector rel1NA = ejb.busAccionesPGG3(codAnho, codMes, codGestor,
					codEpigrafe);
	
			request.setAttribute("listaAcciones", rel1NA);
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("nomEpigrafe", nomEpigrafe);
			request.setAttribute("prioridad", prioridad);
			request.setAttribute("restoOficina", String.valueOf(restoOficina));
			request.setAttribute("metaGestor", String.valueOf(metaGestor));
			request.setAttribute("codEpigrafe", codEpigrafe);
	
			objIngresoUsuario = sesion.getAttribute("idIngresoUsuario");
			if (objIngresoUsuario != null) {
				idIngresoUsuario = Integer.parseInt(objIngresoUsuario.toString());
			}
	
			if (idIngresoUsuario != 0) {
				ejb.actualizarIngreso(2, idIngresoUsuario, codMes, codAnho);
			}
			
			// GSI-F20120731 [nuevaAccion]
			registraIngreso(codMes, codAnho, usuario, codGestor, codOficina);
			
			log.info("[ReportePPGAction :: nuevaAccion] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: nuevaAccion] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones3");
		}

		return (forward);
	}

	
	public ActionForward eliminarAccion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward = null;
		
		try {
			log.info("[ReportePPGAction :: eliminarAccion] Inicio");
			
			sesion = request.getSession(false);
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codigos = request.getParameter("codigos");
			String codigosAcciones[] = codigos.split(";");
	
			for (int i = 0; i < codigosAcciones.length; i++) {
	
				codigos = codigosAcciones[i];
				Vector rel = null;
				rel = ejb.eliminarAccion(codigos);
			}
	
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codEpigrafe = request.getParameter("codEpigrafe");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String nomEpigrafe = request.getParameter("nomEpigrafe");
			String prioridad = request.getParameter("prioridad");
			String restoOficina = request.getParameter("restoOficina");
			String metaGestor = request.getParameter("metaGestor");
	
			Vector rel1NA = ejb.busAccionesPGG3(codAnho, codMes, codGestor,	codEpigrafe);
	
			request.setAttribute("listaAcciones", rel1NA);
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("nomEpigrafe", nomEpigrafe);
			request.setAttribute("prioridad", prioridad);
			request.setAttribute("restoOficina", String.valueOf(restoOficina));
			request.setAttribute("metaGestor", String.valueOf(metaGestor));
			request.setAttribute("codEpigrafe", codEpigrafe);
			
			// GSI-F20120731 [eliminarAccion]
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			registraIngreso(codMes, codAnho, usuario, codGestor, codOficina);
			
			log.info("[ReportePPGAction :: eliminarAccion] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: eliminarAccion] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones3");
		}

		return (forward);
	}

	public Gestor buscarGestor(String codigoUsuario) {
		Gestor gestor = null;
		Connection conexion = new Connection();
		
		try {
			log.info("[ReportePPGAction :: buscarGestor] Inicio");
			
			IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(codigoUsuario);
			String NombreGestor = user.getNombreCompleto();
			String codigoCargo = user.getCargo().getCodigo();
			Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(codigoCargo);
			if (equivalencia != null) {
				// 201206053 - Por validacion de perfiles
				String codigoPerfil = equivalencia.getCodPerfil();
				String perfilMostrar = equivalencia.getPerfil();
				String codigoOficina = user.getBancoOficina().getCodigo();
				Oficina oficina = conexion.findByCodOficina(codigoOficina);
				String codigoTerritorio = "";
				if (oficina != null && oficina.getTerr() != null) {
					codigoTerritorio = oficina.getTerr().getCodTerr();
				}
				gestor = new Gestor();
				gestor.setCodigoGestor(codigoUsuario);
				gestor.setPasswordGestor("");
				gestor.setNombreGestor(NombreGestor);
				gestor.setCodigoPerfil(codigoPerfil);
				gestor.setPerfilMostrar(perfilMostrar);
				gestor.setCodigoOficina(codigoOficina);
				gestor.setCodigoTerritorio(codigoTerritorio);
			}
			
			log.info("[ReportePPGAction :: buscarGestor] Fin");
		} catch (IILDPeExcepcion e) {
			log.error("[ReportePPGAction :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return gestor;
	}

	
	public ActionForward mostrarEdicionCampaniaDetalle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: mostrarEdicionCampaniaDetalle] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			String codCamp = request.getParameter("codCamp");
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String descCampania = request.getParameter("descCampania");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
	
			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			String codTerritorio = "";
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
			}
	
			Vector listaCampaniasDetalles = ejb.listaCampaniaDetalle(codTerritorio,
					codOficina, codCamp, codMes, codAnho);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("descCampania", descCampania);
			request.setAttribute("codCamp", codCamp);
			request.setAttribute("listaCampaniasDetalles", listaCampaniasDetalles);
			
			log.info("[ReportePPGAction :: mostrarEdicionCampaniaDetalle] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: mostrarEdicionCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrarEdicionCampaniaDetalle");
		}

		return (forward);
	}

	public ActionForward mostrarNuevoCampaniaDetalle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward = null;
		
		try {
			log.info("[ReportePPGAction :: mostrarNuevoCampaniaDetalle] Inicio");	
			
			sesion = request.getSession(false);
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codCamp = request.getParameter("codCamp");
			String descCampania = request.getParameter("descCampania");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("codCamp", codCamp);
			request.setAttribute("descCampania", descCampania);
			
			log.info("[ReportePPGAction :: mostrarNuevoCampaniaDetalle] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: mostrarNuevoCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");

		} else {
			forward = mapping.findForward("mostrarNuevoCampaniaDetalle");
		}

		return (forward);
	}

	public ActionForward mostrarEditCampaniaDetalle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward = null;
		
		try {
			log.info("[ReportePPGAction :: mostrarEditCampaniaDetalle] Inicio");
			
			sesion = request.getSession(false);
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			String codCampaniaDetalle = request.getParameter("codCampaniaDetalle");
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codCamp = request.getParameter("codCamp");
			String descCampania = request.getParameter("descCampania");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
	
			Campanias campanias = ejb.busCampaniaDetalle(codCampaniaDetalle);
	
			request.setAttribute("codCampaniaDetalle", codCampaniaDetalle);
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("codCamp", codCamp);
			request.setAttribute("descCampania", descCampania);
			request.setAttribute("dtoCampaniaDetalle", campanias);
			
			log.info("[ReportePPGAction :: mostrarEditCampaniaDetalle] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: mostrarEditCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");

		} else {
			forward = mapping.findForward("mostrarEditCampaniaDetalle");
		}

		return (forward);
	}

	public ActionForward grabarCampaniaDetalle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: grabarCampaniaDetalle] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor");
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codCamp = request.getParameter("codCamp");
			String descCampania = request.getParameter("descCampania");
			String nomCampaniaDetalle = request.getParameter("nombreAccion");
			int numeroCliente = Integer.parseInt(request.getParameter("numeroCliente").toString());
			double compromisoGestor = Double.parseDouble(request.getParameter("compromisoGestor").toString());
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
	
			Object objIngresoUsuario = null;
			int idIngresoUsuario = 0;
	
			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			String codTerritorio = "";
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
			}
	
			ejb.nuevoCampaniaDetalle(codTerritorio, codOficina, codCamp, codMes,
					codAnho, nomCampaniaDetalle.trim(), codGestor, numeroCliente,
					compromisoGestor, gestor.getCodigoGestor());
	
			Vector listaCampaniasDetalles = ejb.listaCampaniaDetalle(codTerritorio,
					codOficina, codCamp, codMes, codAnho);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("codCamp", codCamp);
			request.setAttribute("descCampania", descCampania);
			request.setAttribute("listaCampaniasDetalles", listaCampaniasDetalles);
	
			// Ingresos
			objIngresoUsuario = sesion.getAttribute("idIngresoUsuario");
			if (objIngresoUsuario != null) {
				idIngresoUsuario = Integer.parseInt(objIngresoUsuario.toString());
			}
	
			if (idIngresoUsuario != 0) {
				ejb.actualizarIngreso(2, idIngresoUsuario, codMes, codAnho);
			}
			
			// GSI-F20120731 [grabarCampaniaDetalle]
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			registraIngreso(codMes, codAnho, usuario, codGestor, codOficina);
			
			log.info("[ReportePPGAction :: grabarCampaniaDetalle] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: grabarCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");

		} else {
			forward = mapping.findForward("mostrarEdicionCampaniaDetalle");
		}

		return (forward);
	}

	public ActionForward eliminarCampaniaDetalle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward = null;
		
		try {
			log.info("[ReportePPGAction :: eliminarCampaniaDetalle] Inicio");
			
			sesion = request.getSession(false);
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			String codigos = request.getParameter("codigos");
			String codigosCampanias[] = codigos.split(";");
			String codCamp = request.getParameter("codCamp");
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String descCampania = request.getParameter("descCampania");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
	
			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			String codTerritorio = "";
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
			}
	
			Vector listaCampaniasDetalles = null;
	
			for (int i = 0; i < codigosCampanias.length; i++) {
				codigos = codigosCampanias[i];
				ejb.eliminarCampaniaDetalle(codigos);
			}
	
			listaCampaniasDetalles = ejb.listaCampaniaDetalle(codTerritorio, codOficina, codCamp, codMes, codAnho);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("descCampania", descCampania);
			request.setAttribute("codCamp", codCamp);
			request.setAttribute("listaCampaniasDetalles", listaCampaniasDetalles);
			
			// GSI-F20120731 [eliminarCampaniaDetalle]
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			registraIngreso(codMes, codAnho, usuario, codGestor, codOficina);
			
			log.info("[ReportePPGAction :: eliminarCampaniaDetalle] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: eliminarCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrarEdicionCampaniaDetalle");
		}

		return (forward);
	}

	public ActionForward mostrarEditarAccion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = null;
		ActionForward forward = null;
		ActionErrors errors = null;
		
		try {
			log.info("[ReportePPGAction :: mostrarEditarAccion] Inicio");
			
			sesion = request.getSession(false);
			errors = new ActionErrors();
			forward = new ActionForward(); // return value
			Connection ejb = new Connection();
	
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
	
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String nomEpigrafe = request.getParameter("nomEpigrafe");
			String prioridad = request.getParameter("prioridad");
			String restoOficina = request.getParameter("restoOficina");
			String metaGestor = request.getParameter("metaGestor");
			String codEpigrafe = request.getParameter("codEpigrafe");
			String codAccion = request.getParameter("codAccion");
			Accion accion = ejb.busAccion(codAccion);
			Vector<Accion> listaAccion = ejb.busAccionesPGG3(codAnho, codMes, codGestor, codEpigrafe);
			
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("nomEpigrafe", nomEpigrafe);
			request.setAttribute("prioridad", prioridad);
			request.setAttribute("restoOficina", String.valueOf(restoOficina));
			request.setAttribute("metaGestor", String.valueOf(metaGestor));
			request.setAttribute("codEpigrafe", codEpigrafe);
			request.setAttribute("codAccion", codAccion);
			request.setAttribute("dtoAccion", accion);
			if(listaAccion == null) {
				request.setAttribute("totalAcciones", "0");
			} else {
				int totalAcciones = 0;
				int temp;
				for(Accion o : listaAccion) {
					temp = Integer.parseInt(o.getCompGestor());
					totalAcciones += temp;
				}
				request.setAttribute("totalAcciones", String.valueOf(totalAcciones));
			}
			
			log.info("[ReportePPGAction :: mostrarEditarAccion] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: mostrarEditarAccion] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
				
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones3edicion");
		}

		return (forward);
	}

	
	public ActionForward edicionAccion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession sesion = null;
		ActionErrors errors = null;
		ActionForward forward = null;	
		Gestor usuario = null;
		
		try {
			log.info("[ReportePPGAction :: edicionAccion] Inicio");
			
			sesion = request.getSession(false);
			
			usuario = (Gestor)sesion.getAttribute("gestor"); 
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
	
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codEpigrafe = request.getParameter("codEpigrafe");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String nomEpigrafe = request.getParameter("nomEpigrafe");
			String prioridad = request.getParameter("prioridad");
			String restoOficina = request.getParameter("restoOficina");
			String metaGestor = request.getParameter("metaGestor");
			String descAccion = request.getParameter("descAccion");
			String numeroCliente = request.getParameter("numeroCliente");
			String compromisoGestor = request.getParameter("compromisoGestor");
			String codAccion = request.getParameter("codAccion");
	
			ejb.edicionAccion(codAccion, descAccion, numeroCliente, compromisoGestor, usuario.getCodigoGestor());
	
			Vector rel1NA = ejb.busAccionesPGG3(codAnho, codMes, codGestor, codEpigrafe);
	
			request.setAttribute("listaAcciones", rel1NA);
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("nomEpigrafe", nomEpigrafe);
			request.setAttribute("prioridad", prioridad);
			request.setAttribute("restoOficina", String.valueOf(restoOficina));
			request.setAttribute("metaGestor", String.valueOf(metaGestor));
			request.setAttribute("codEpigrafe", codEpigrafe);
			
			// GSI-F20120731 [edicionAccion]
			registraIngreso(codMes, codAnho, usuario, codGestor, codOficina);
			
			log.info("[ReportePPGAction :: edicionAccion] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: edicionAccion] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("acciones3");
		}

		return (forward);
	}

	public ActionForward edicionCampaniaDetalle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = null;
		ActionForward forward = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePPGAction :: edicionCampaniaDetalle] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor");
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			String codOficinaCompleto = request.getParameter("codOficinaCompleto");
			String codGestor = request.getParameter("codGestor");
			String codAnho = request.getParameter("codAnho");
			String codMes = request.getParameter("codMes");
			String codOficina1[] = codOficinaCompleto.split(" - ");
			String codOficina = codOficina1[0];
			String descAccion = request.getParameter("descAccion");
			String codAccion = request.getParameter("codAccion");
			String codCamp = request.getParameter("codCamp");
			String numeroCliente = request.getParameter("numeroCliente");
			String compromisoGestor = request.getParameter("compromisoGestor");
			String codCampaniaDetalle = request.getParameter("codCampaniaDetalle");
			String descCampania = request.getParameter("descCampania");
			int intNumeroCliente = 0;
			double dblCompromisoGestor = 0;
			Vector listaCampaniasDetalles = null;
	
			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			String codTerritorio = "";
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
			}
	
			if (numeroCliente != null) {
				intNumeroCliente = Integer.parseInt(numeroCliente);
			}
	
			if (compromisoGestor != null) {
				dblCompromisoGestor = Double.parseDouble(compromisoGestor);
			}
	
			ejb.edicionCampaniaDetalle(codCampaniaDetalle, descAccion,
					intNumeroCliente, dblCompromisoGestor, gestor.getCodigoGestor());
	
			listaCampaniasDetalles = ejb.listaCampaniaDetalle(codTerritorio,
					codOficina, codCamp, codMes, codAnho);
	
			request.setAttribute("codOficinaCompleto", codOficinaCompleto);
			request.setAttribute("codOficina", codOficina);
			request.setAttribute("codGestor", codGestor);
			request.setAttribute("codAnho", codAnho);
			request.setAttribute("codMes", codMes);
			request.setAttribute("descCampania", descCampania);
			request.setAttribute("codCamp", codCamp);
			request.setAttribute("listaCampaniasDetalles", listaCampaniasDetalles);
			
			// GSI-F20120731 [editarCampaniaDetalle]
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			registraIngreso(codMes, codAnho, usuario, codGestor, codOficina);
			
			log.info("[ReportePPGAction :: edicionCampaniaDetalle] Fin");
		} catch(Exception e) {
			log.error("[ReportePPGAction :: edicionCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("mostrarEdicionCampaniaDetalle");
		}

		return (forward);
	}
}