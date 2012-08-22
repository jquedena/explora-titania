package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.util.GestorPerfil;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings({"unused","unchecked"})
public class SeguimientosAction extends DispatchAction {
	private static Logger log = Logger.getLogger(SeguimientosAction.class);
	
	private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private SimpleDateFormat sdfAnho = new SimpleDateFormat("yyyy");
	private SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
	private SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
	
	public ActionForward reporteSeguimiento1(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		GestorPerfil codPerfil = new GestorPerfil();
		UtilListas utilList = new UtilListas();
		HttpSession sesion = null;
		Gestor gestor = null;
		Multitabla multitabla = null;
		Vector listaAnio = null;
		String anio;
		
		String CodigoUsuario;
		String nomGestor;
		
		String codTerritorio = "";
		String nomTerritorio = "";

		String anho = request.getParameter("codAnho");
		String codGestor = request.getParameter("codigoGestor");
		String mes = null;
		String codOficina = null;
		
		try {
			log.info("[SeguimientosAction :: reporteSeguimiento1] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			CodigoUsuario = gestor.getCodigoGestor();
			nomGestor = gestor.getNombreGestor();
			
			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anho = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anho = request.getParameter("codAnho");
				mes = request.getParameter("codMes");
				String codOficinaCompleto = request.getParameter("oficinaCompleto");
				if (codOficinaCompleto != null) {
					String codOficina1[] = codOficinaCompleto.split("-");
					codOficina = codOficina1[0];
				}
			}
			
			Calendar calendario = Calendar.getInstance();
			Date fecha = calendario.getTime();

			if (mes == null) {
				mes = sdfMes.format(fecha);
				log.info("[SeguimientosAction :: reporteSeguimiento1] Seguimiento mes: " + mes);
			}
			
			// Carga lista de anios			
			multitabla = ejb.findMultiByPrimaryKey("T02", "1");
			listaAnio = utilList.obtenerListAnhos(multitabla.getValor1(), Integer.parseInt(multitabla.getValor2()));

			if(anho != null && !anho.equals("")) {
				anio = anho;
			} else {
				anio = ConstantesUtil.getAnioActual();
				anho = ConstantesUtil.getAnioActual();
			}

			Vector newListaOficina = null;

			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				newListaOficina = ejb.findAllOficinaByCodTerri(gestor
						.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")) {
					newListaOficina = ejb.findAllOficinas();
				} else {					
					newListaOficina = ejb.findListaByCodOficina(gestor.getCodigoOficina());
				}
			}

			Oficina ofi = null;
			if (newListaOficina != null && newListaOficina.size() > 0) {
				ofi = (Oficina) newListaOficina.get(0);
			}

			if(codOficina == null) {
				if (ofi != null) {
					codOficina = ofi.getCodOfic();
				} else {
					codOficina = gestor.getCodigoOficina();
				}
			}

			Vector rel4 = utilList.listarGestores(codOficina, "", mes, anho);
			
			// Gestores de las Oficinas hijas
			Vector listaEpigrafes = ejb.findEpigrafesinPlanes(codOficina, anho, mes);			
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
				
				if(rel4 == null) {
					rel4 = new Vector();
				}
				
				while(iterHijas.hasNext()) {
					OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
					if(oficinaHija != null) {
						listaGestoresHijas = utilList.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, mes, anho);								
						if(listaGestoresHijas != null) {
							Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
							
							while(iterListaGestoresHijas.hasNext()) {
								Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
								BigDecimal monto = ejb.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, anho,
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
							rel4.addAll(listaGestoresHijas);	
						}
					}
				}
			}
			
			if (gestor.getCodigoPerfil().equals("GPE") || gestor.getCodigoPerfil().equals("GCO")
					|| gestor.getCodigoPerfil().equals("GPT")|| gestor.getCodigoPerfil().equals("EEM")) {
				Gestor ob = new Gestor();
				ob.setCodigoGestor(CodigoUsuario);
				ob.setNombreGestor(nomGestor);
				
				rel4 = new Vector();
				rel4.add(ob);
			}

			if (codGestor == null || codGestor.equals("null") || codGestor.equals("")) {
				if (rel4 != null && rel4.size() > 0) {
					Gestor epi = (Gestor) rel4.get(0);
					codGestor = epi.getCodigoGestor();
				}
			}

			String perfil = "";
			if (codGestor != null) {
				Gestor gestor1 = codPerfil.buscarGestor(codGestor);

				if (gestor1 != null) {
					// perfil = gestor1.getCodigoPerfil();
					// 201206053 - Muestra la nueva descripcion del perfil 
					perfil = gestor1.getPerfilMostrar();
				}
			}

			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
				nomTerritorio = terr.getNomTerr();
			}

			// Buscando parametria
			log.info("[SeguimientosAction :: reporteSeguimiento1] Parametria para el codigo de Territorio: "
					+ codTerritorio);

			ProgSeguimiento progSeguimiento = ejb.findProgramacionSeguimiento(mes, anho, codTerritorio);
			Vector rel1 = null;

			if (progSeguimiento != null) {
				log.info("[SeguimientosAction :: reporteSeguimiento1] territorio tiene parametria");
				log.info("[SeguimientosAction :: reporteSeguimiento1] mes: " + mes + " anio: " + anho
						+ " codOficina: " + codOficina + " codGestor: "
						+ codGestor);
				
				rel1 = ejb.pggSeguimiento1(mes, anho, codOficina, codGestor,
						progSeguimiento);
			} else {
				rel1 = new Vector(0, 1);
			}

			Vector rel2 = ejb.busOficinaCodyNom(codTerritorio);
			Vector rel3 = null;

			if (progSeguimiento != null) {
				rel3 = ejb.pggEsfuerzoAdicional1(mes, anho, codOficina,
						codGestor, progSeguimiento);
			} else {
				rel3 = new Vector(0, 1);
			}
			
			request.setAttribute("listaDatos", rel1);
			request.setAttribute("listaOficina", rel2);
			request.setAttribute("listaEsfuerzo", rel3);
			request.setAttribute("listaGestores", rel4);
			request.setAttribute("nomGestor", nomGestor);
			request.setAttribute("perfil", perfil);
			request.setAttribute("nomTerritorio", nomTerritorio);
			request.setAttribute("codAnhoReturn", anho);
			request.setAttribute("codMesReturn", mes);
			request.setAttribute("codOficinaReturn", codOficina);
			request.setAttribute("codGestorReturn", codGestor);
			request.setAttribute("newListaOficina", newListaOficina);
			
			request.setAttribute("anio", anio);
			request.setAttribute("listaAnio", listaAnio);
			
			sesion.setAttribute("listaAccionesCompSeg1", rel1);
			sesion.setAttribute("listaEsfuerzosCompSeg1", rel3);
			
			log.info("[SeguimientosAction :: reporteSeguimiento1] Parametria para codGestorReturn: " + codGestor);

			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				forward = mapping.findForward("error");
			} else {
				forward = mapping.findForward("seguimiento1");
			}
			
			
			log.info("[SeguimientosAction :: reporteSeguimiento1] Fin");
		} catch (Exception e) {
			log.error("[SeguimientosAction :: reporteSeguimiento1] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			forward = mapping.findForward("error");
		}
		
		RegistraValorDefecto.getInstancia().registrar(request, anho, mes, codOficina);
		
		return (forward);
	}


	public ActionForward reporteSeguimiento2(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = null; 
		ActionErrors errors = null;
		HttpSession sesion = null;
		Gestor gestor = null;
		Multitabla multitabla = null;
		Vector listaAnio = null;
		String anio;
		String codTerritorio = "";
		String nomTerritorio = "";
		String anho = null;
		String codGestor = request.getParameter("codigoGestor");
		String mes = null;
		String codOficina = null;
		
		try {
			log.info("[SeguimientosAction :: reporteSeguimiento2] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			errors = new ActionErrors();
			forward = new ActionForward();
			Connection ejb = new Connection();
			GestorPerfil codPerfil = new GestorPerfil();
			String CodigoUsuario = gestor.getCodigoGestor();
			Vector newListaOficina = null;
			UtilListas utilList = new UtilListas();
			String nomGestor = gestor.getNombreGestor();
	
			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anho = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anho = request.getParameter("codAnho");
				mes = request.getParameter("codMes");
				String codOficinaCompleto = request.getParameter("oficinaCompleto");
				if (codOficinaCompleto != null) {
					String codOficina1[] = codOficinaCompleto.split("-");
					codOficina = codOficina1[0];
				}
			}
			
			Calendar calendario = Calendar.getInstance();
			Date fecha = calendario.getTime();
	
			if (mes == null) {
				mes = sdfMes.format(fecha);
			}
	
			// Carga lista de anios			
			multitabla = ejb.findMultiByPrimaryKey("T02", "1");
			listaAnio = utilList.obtenerListAnhos(multitabla.getValor1(), Integer.parseInt(multitabla.getValor2()));

			if(anho != null && !anho.equals("")) {
				anio = anho;
			} else {
				anio = ConstantesUtil.getAnioActual();
				anho = ConstantesUtil.getAnioActual();
			}
			
			if (gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")) {
				newListaOficina = ejb.findAllOficinaByCodTerri(gestor.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")) {
					newListaOficina = ejb.findAllOficinas();
				} else {
					newListaOficina = ejb.findListaByCodOficina(gestor.getCodigoOficina());	
				}
			}
	
			Oficina ofi = null;
			if (newListaOficina != null && newListaOficina.size() > 0) {
				ofi = (Oficina) newListaOficina.get(0);
			}
	
			if (codOficina == null) {
				if (ofi != null) {
					codOficina = ofi.getCodOfic();
				} else {
					codOficina = gestor.getCodigoOficina();
				}
			}
	
			Vector rel4 =utilList.listarGestores(codOficina, "", mes, anho);
			
			//Gestores de las Oficinas hijas
			Vector listaEpigrafes = ejb.findEpigrafesinPlanes(codOficina, anho, mes);			
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
				
				if(rel4 == null) {
					rel4 = new Vector();
				}
				
				while(iterHijas.hasNext()) {
					OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
					if(oficinaHija != null) {
						listaGestoresHijas = utilList.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, mes, anho);								
						if(listaGestoresHijas != null) {
							Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
							
							while(iterListaGestoresHijas.hasNext()) {
								Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
								BigDecimal monto = ejb.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, anho,
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
							rel4.addAll(listaGestoresHijas);	
						}
					}
				}
			}

			if (gestor.getCodigoPerfil().equals("GPE") || gestor.getCodigoPerfil().equals("GCO") || gestor.getCodigoPerfil().equals("GPT") || gestor.getCodigoPerfil().equals("EEM")) {
				Gestor ob = new Gestor();
				ob.setCodigoGestor(CodigoUsuario);
				ob.setNombreGestor(nomGestor);
				
				rel4 = new Vector();
				
				rel4.add(ob);
			}
	
			if (codGestor == null || codGestor.equals("null") || codGestor.equals("") ) {
				if (rel4 != null && rel4.size() > 0) {
					Gestor epi = (Gestor) rel4.get(0);
					codGestor = epi.getCodigoGestor();
				}
			}
	
			String perfil = "";
	
			if (codGestor != null) {
				Gestor gestor1 = codPerfil.buscarGestor(codGestor);
	
				if (gestor1 != null) {
					// perfil = gestor1.getCodigoPerfil();
					// 201206053 - Muestra la nueva descripcion del perfil 
					perfil = gestor1.getPerfilMostrar();
				}
			}
			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
			terr = ejb.findTerritorioByCodOficina(codOficina);
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
				nomTerritorio = terr.getNomTerr();
			}
	
			ProgSeguimiento progSeguimiento = ejb.findProgramacionSeguimiento(mes, anho, codTerritorio);
			Vector rel1 = null;
	
			if (progSeguimiento != null) {
				rel1 = ejb.pggSeguimiento2(mes, anho, codOficina, codGestor, progSeguimiento);
			} else {
				rel1 = new Vector(0, 1);
			}
	
			Vector rel2 = ejb.busOficinaCodyNom(codTerritorio);
			Vector rel3 = null;
	
			if (progSeguimiento != null) {
				rel3 = ejb.pggEsfuerzoAdicional2(mes, anho, codOficina, codGestor, progSeguimiento);
			} else {
				rel3 = new Vector(0, 1);
			}
	
			request.setAttribute("listaDatos", rel1);
			request.setAttribute("listaOficina", rel2);
			request.setAttribute("listaEsfuerzo", rel3);
			request.setAttribute("listaGestores", rel4);
			request.setAttribute("nomGestor", nomGestor);
			request.setAttribute("perfil", perfil);
			request.setAttribute("nomTerritorio", nomTerritorio);
			request.setAttribute("codAnhoReturn", anho);
			request.setAttribute("codMesReturn", mes);
			request.setAttribute("codOficinaReturn", codOficina);
			request.setAttribute("codGestorReturn", codGestor);
			request.setAttribute("newListaOficina", newListaOficina);
			
			request.setAttribute("anio", anio);
			request.setAttribute("listaAnio", listaAnio);
			
			sesion.setAttribute("listaAccionesCompSeg2", rel1);
			sesion.setAttribute("listaEsfuerzosCompSeg2", rel3);
			
			log.info("[SeguimientosAction :: reporteSeguimiento2] Fin");
		} catch(Exception e) {
			log.error("[SeguimientosAction :: reporteSeguimiento2] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);

			forward = mapping.findForward("error");

		} else {
			forward = mapping.findForward("seguimiento2");
		}
		
		RegistraValorDefecto.getInstancia().registrar(request, anho, mes, codOficina);
		
		return (forward);
	}

	public ActionForward reporteSeguimiento1Grabar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection ejb = new Connection();
		GestorPerfil codPerfil = new GestorPerfil();
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[SeguimientosAction :: reporteSeguimiento1Grabar] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			String CodigoUsuario = gestor.getCodigoGestor(); 
			String nomGestor = 	gestor.getNombreGestor();
			String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
			Territorio terr = ejb.findTerritorioByCodOficina(gestor.getCodigoOficina());
			
			String codTerritorio = "";
			String nomTerritorio = "";
			
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
				nomTerritorio = terr.getNomTerr();
			}
	
			String anho = request.getParameter("codAnho");
			String codGestor = request.getParameter("codigoGestor");
			String mes = request.getParameter("codMes");
			String codOficinaCompleto = request.getParameter("oficinaCompleto");
			String codOficina = null;
			if (codOficinaCompleto != null) {
				String codOficina1[] = codOficinaCompleto.split("-");
				codOficina = codOficina1[0];
			}
	
			//leer bloque datos
			String bloqueDatos = request.getParameter("bloqueDatos");
			String[] lineasDatos = bloqueDatos.split("\n");
			String[] segmentoDatos = null;
			String dato = "";
	
			Object objIngresoUsuario = null;
			int idIngresoUsuario = 0;
	
			//grabar
			for (int i = 0; i < lineasDatos.length; i++) {
				lineasDatos[i] = lineasDatos[i].replaceAll("\r", "");
				segmentoDatos = lineasDatos[i].split("_");
	
				if (segmentoDatos != null && segmentoDatos.length == 5) {
					if (segmentoDatos[0].equals("txtNumGestiones"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST;
					else if (segmentoDatos[0].equals("txtNumConcretados"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR;
					else if (segmentoDatos[0].equals("txtMonto"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO;
	
					ejb.actualizarSeguimiento1(segmentoDatos[1], dato,
							segmentoDatos[2], segmentoDatos[3], segmentoDatos[4], gestor.getCodigoGestor());
				} else {
					log.info("[SeguimientosAction :: reporteSeguimiento1Grabar] no tiene datos segmentos i: " + i);
				}
			}
	
			objIngresoUsuario = sesion.getAttribute("idIngresoUsuario");
			if (objIngresoUsuario != null) {
				idIngresoUsuario = Integer.parseInt(objIngresoUsuario.toString());
			}
	
			if (lineasDatos.length > 0 && idIngresoUsuario != 0) {
				ejb.actualizarIngreso(3, idIngresoUsuario, mes, anho);
			}
			
			// Registra ingresos
			Vector listaAccionesCompSeg1 = (Vector)sesion.getAttribute("listaAccionesCompSeg1");
			Vector listaEsfuerzosCompSeg1 = (Vector)sesion.getAttribute("listaEsfuerzosCompSeg1");
			
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			if(!compararCambiosSeg1(lineasDatos, listaAccionesCompSeg1, listaEsfuerzosCompSeg1)) {
				long id = ejb.existeIngresoForm(4, Integer.parseInt(mes), Integer.parseInt(anho), 
						usuario.getCodigoGestor(), ConstantesUtil.parseSQLString2(new Date()), codGestor, codOficina);
				String editUsuario = !usuario.getCodigoGestor().equals(codGestor) ? "1" : "0";
				
				if(id == 0) {
					ejb.insertarIngresoForm(4, Integer.parseInt(mes), Integer.parseInt(anho), 
							usuario.getCodigoGestor(), editUsuario, codGestor, codOficina);
				} else {
					if(editUsuario.equals("1")) {
						ejb.actualizarIngresoFormEditUsuario(id);
					}
				}
			}
			
			log.info("[SeguimientosAction :: reporteSeguimiento1Grabar] Fin ");
		} catch(Exception e) {
			log.error("[SeguimientosAction :: reporteSeguimiento1Grabar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return (reporteSeguimiento1(mapping, form, request, response));

	}
	
	public boolean compararCambiosSeg1(String[] lineasDatos, Vector listaAcciones, Vector listaEsfuerzos) {
		boolean resp = true;
		Accion accion = null;
		Accion esfuerzo = null;
		Iterator iterAccion = null; 
		Iterator iterEsfuerzo = null;
		String[] valores = null;
		String[] segmentoDatos = null;
		String dato = "";
		
		try {
			log.info("[SeguimientosAction :: compararCambiosSeg1] Inicio");
			
			for (int i = 0; i < lineasDatos.length; i++) {
				lineasDatos[i] = lineasDatos[i].replaceAll("\r", "");
				segmentoDatos = lineasDatos[i].split("_");
	
				if (segmentoDatos != null && segmentoDatos.length == 5) {
					if (segmentoDatos[0].equals("txtNumGestiones"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST;
					else if (segmentoDatos[0].equals("txtNumConcretados"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR;
					else if (segmentoDatos[0].equals("txtMonto"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO;
					
					// Tipo Accion
					if(segmentoDatos[1].equals("1")) {
						if(listaAcciones != null) {
							iterAccion = listaAcciones.iterator();
							while(iterAccion.hasNext()) {
								accion = (Accion)iterAccion.next();
								
								if(accion.getCodAccion() == null) {
									continue;
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroGestiones1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroConcretados1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getMonto1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
							}
						}
					}
					// Tipo Esfuerzo
					if(segmentoDatos[1].equals("2")) {
						if(listaEsfuerzos != null) {
							iterAccion = listaEsfuerzos.iterator();
							while(iterAccion.hasNext()) {
								accion = (Accion)iterAccion.next();
								
								if(accion.getCodAccion() == null) {
									continue;
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroGestiones1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroConcretados1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getMonto1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
							}
						}
					}
				} 
			}
			
			log.info("[SeguimientosAction :: compararCambiosSeg1] Fin");
		} catch(Exception e) {
			log.error("[SeguimientosAction :: compararCambiosSeg1] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return resp;
	}

	public ActionForward reporteSeguimiento2Grabar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IILDPeUsuario usuario = null;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();
		GestorPerfil codPerfil = new GestorPerfil();
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[SeguimientosAction :: reporteSeguimiento2Grabar] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor"); 
			
			String CodigoUsuario = gestor.getCodigoGestor();
			String nomGestor = gestor.getNombreGestor();
			String perfil = codPerfil.buscarGestor(CodigoUsuario).getCodigoPerfil();
	
			Territorio terr = ejb.findTerritorioByCodOficina(gestor.getCodigoOficina());
			String codTerritorio = "";
			String nomTerritorio = "";
			if (terr != null) {
				codTerritorio = terr.getCodTerr();
				nomTerritorio = terr.getNomTerr();
			}
	
			String anho = request.getParameter("codAnho");
			String codGestor = request.getParameter("codigoGestor");
			String mes = request.getParameter("codMes");
			String codOficinaCompleto = request.getParameter("oficinaCompleto");
			String codOficina = null;
			if (codOficinaCompleto != null) {
				String codOficina1[] = codOficinaCompleto.split("-");
				codOficina = codOficina1[0];
			}
	
			//leer bloque datos
			String bloqueDatos = request.getParameter("bloqueDatos");
			String[] lineasDatos = bloqueDatos.split("\n");
			String[] segmentoDatos = null;
			String dato = "";
			log.info("[SeguimientosAction :: reporteSeguimiento2Grabar] Antes del FOR");
	
			Object objIngresoUsuario = null;
			int idIngresoUsuario = 0;
	
			//grabar
			for (int i = 0; i < lineasDatos.length; i++) {
				lineasDatos[i] = lineasDatos[i].replaceAll("\r", "");
				segmentoDatos = lineasDatos[i].split("_");
	
				if (segmentoDatos != null && segmentoDatos.length == 5) {
					if (segmentoDatos[0].equals("txtNumGestiones"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST;
					else if (segmentoDatos[0].equals("txtNumConcretados"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR;
					else if (segmentoDatos[0].equals("txtMonto"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO;
	
					ejb.actualizarSeguimiento2(segmentoDatos[1], dato,
							segmentoDatos[2], segmentoDatos[3], segmentoDatos[4], gestor.getCodigoGestor());
				} else {
					log.info("[SeguimientosAction :: reporteSeguimiento2Grabar] no tiene datos segmentos i: "
									+ i);
				}
			}
	
			objIngresoUsuario = sesion.getAttribute("idIngresoUsuario");
			if (objIngresoUsuario != null) {
				idIngresoUsuario = Integer.parseInt(objIngresoUsuario.toString());
			}
	
			if (lineasDatos.length > 0 && idIngresoUsuario != 0) {
				ejb.actualizarIngreso(4, idIngresoUsuario, mes, anho);
			}
			
			// Registrar ingreso
			Vector listaAccionesCompSeg2 = (Vector)sesion.getAttribute("listaAccionesCompSeg2");
			Vector listaEsfuerzosCompSeg2 = (Vector)sesion.getAttribute("listaEsfuerzosCompSeg2");
			
			Gestor usuario2 = (Gestor)sesion.getAttribute("gestor");
			
			if(!compararCambiosSeg2(lineasDatos, listaAccionesCompSeg2, listaEsfuerzosCompSeg2)) {
				long id = ejb.existeIngresoForm(5, Integer.parseInt(mes), Integer.parseInt(anho), 
						usuario2.getCodigoGestor(), ConstantesUtil.parseSQLString2(new Date()), codGestor, codOficina);
				String editUsuario = !usuario2.getCodigoGestor().equals(codGestor) ? "1" : "0";
				
				if(id == 0) {
					ejb.insertarIngresoForm(5, Integer.parseInt(mes), Integer.parseInt(anho), 
							usuario2.getCodigoGestor(), editUsuario, codGestor, codOficina);
				} else {
					if(editUsuario.equals("1")) {
						ejb.actualizarIngresoFormEditUsuario(id);
					}
				}
			}
			
			log.info("[SeguimientosAction :: reporteSeguimiento2Grabar] Fin");
		} catch(Exception e) {
			log.error("[SeguimientosAction :: reporteSeguimiento2Grabar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return (reporteSeguimiento2(mapping, form, request, response));
	}
	
	public boolean compararCambiosSeg2(String[] lineasDatos, Vector listaAcciones, Vector listaEsfuerzos) {
		boolean resp = true;
		Accion accion = null;
		Accion esfuerzo = null;
		Iterator iterAccion = null; 
		Iterator iterEsfuerzo = null;
		String[] valores = null;
		String[] segmentoDatos = null;
		String dato = "";
		
		try {
			log.info("[SeguimientosAction :: compararCambiosSeg2] Inicio");
			
			for (int i = 0; i < lineasDatos.length; i++) {
				lineasDatos[i] = lineasDatos[i].replaceAll("\r", "");
				segmentoDatos = lineasDatos[i].split("_");
	
				if (segmentoDatos != null && segmentoDatos.length == 5) {
					if (segmentoDatos[0].equals("txtNumGestiones"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST;
					else if (segmentoDatos[0].equals("txtNumConcretados"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR;
					else if (segmentoDatos[0].equals("txtMonto"))
						dato = ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO;
					
					// Tipo Accion
					if(segmentoDatos[1].equals("1")) {
						if(listaAcciones != null) {
							iterAccion = listaAcciones.iterator();
							while(iterAccion.hasNext()) {
								accion = (Accion)iterAccion.next();
								
								if(accion.getCodAccion() == null) {
									continue;
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroGestiones1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroConcretados1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getMonto1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
							}
						}
					}
					// Tipo Esfuerzo
					if(segmentoDatos[1].equals("2")) {
						if(listaEsfuerzos != null) {
							iterAccion = listaEsfuerzos.iterator();
							while(iterAccion.hasNext()) {
								accion = (Accion)iterAccion.next();
								
								if(accion.getCodAccion() == null) {
									continue;
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroGestiones1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getNumeroConcretados1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
								
								if(accion.getCodAccion().equals(segmentoDatos[2])) {
									if(dato == ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO) {
										
										if(		(segmentoDatos[4] != null && !segmentoDatos[4].equals("")) &&
												accion.getMonto1() != Integer.parseInt(segmentoDatos[4])) {
											resp = false;
											break;
										}
									}							
								}
							}
						}
					}
				} 
			}
			
			log.info("[SeguimientosAction :: compararCambiosSeg2] Fin");
		} catch(Exception e) {
			log.error("[SeguimientosAction :: compararCambiosSeg2] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return resp;
	}
}