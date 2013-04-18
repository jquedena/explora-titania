package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.ObjetivosForm;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
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

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"unchecked","unused"})
public class ObjetivosAction extends DispatchAction{
	private static Logger log = Logger.getLogger(ObjetivosAction.class);
	
	// private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	// private SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	// private SimpleDateFormat sdfDia = new SimpleDateFormat("dd"); listaOficina
	private SimpleDateFormat sdfAnho = new SimpleDateFormat("yyyy");
	private SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
	private String tipo, mensaje;

	public ActionForward inicioObjetivo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection conexion = new Connection();
		forward = mapping.findForward("ok");
		Vector listaOficina = null;
		Vector listaEpigrafes = null;
		Vector listaAnhos = null;
		Vector listaGestores = null;
		Plan planes = null;
		ObjetivosForm objetivoForm = (ObjetivosForm) form;
		HttpSession sesion = null;
		Gestor gestor = null;
		String anho = null; 
		String mes= null;
		String codOficina = null;
		String codEpigrafe= null;
		
		try {
			log.info("[ObjetivosAction :: inicioObjetivo] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor) sesion.getAttribute("gestor");
			
			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anho = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anho = request.getParameter("anho");
				mes = request.getParameter("mes");
				codOficina = request.getParameter("codOficina");
			}

			if(anho == null || mes == null){
				Calendar calendario = Calendar.getInstance();
				Date fecha = calendario.getTime();
				mes = sdfMes.format(fecha);
				anho = sdfAnho.format(fecha);
			}
			
			codEpigrafe = request.getParameter("codEpigrafe");
				
			Multitabla mul = null;
			UtilListas utilList = new UtilListas();
			
			mul = conexion.findMultiByPrimaryKey("T02","1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());
			listaAnhos = utilList.obtenerListAnhos(anhoBase,rango);
				
			if(gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")){
				listaOficina = 	conexion.findAllOficinaByCodTerri(gestor.getCodigoTerritorio());
			}else{
				if (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")) {
					listaOficina = conexion.findAllOficinas();
				}else{
					if(codOficina != null) {
						log.info("[ObjetivosAction :: inicioObjetivo] El codigo de oficina usado fue " + codOficina);
						listaOficina = conexion.findListaByCodOficina(codOficina);
					} else {
						log.info("[ObjetivosAction :: inicioObjetivo] El codigo de oficina usado fue " + gestor.getCodigoOficina());
						listaOficina = conexion.findListaByCodOficina(gestor.getCodigoOficina());
					}
				}
			}
			
			if(	(codOficina == null || (codOficina != null && codOficina.equals("%"))) && 
				listaOficina != null &&  listaOficina.size() > 0){
				log.info("[ObjetivosAction :: inicioObjetivo] Nro. de Oficinas: " + listaOficina.size());
				codOficina = ((Oficina) listaOficina.elementAt(0)).getCodOfic();
			}
			
			listaEpigrafes = conexion.findEpigrafesinPlanes(codOficina,anho,mes);
			
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
			}
			
			Collections.sort(listaEpigrafes);
			
			if(listaEpigrafes.size()>0){
				codEpigrafe = codEpigrafe != null ? codEpigrafe :  ((Epigrafe) listaEpigrafes.elementAt(0)).getCodEpigrafe();
				
				planes = conexion.findConsultaPlanesResumen(mes, anho, codEpigrafe, codOficina);
				if(planes!=null){
					if(planes.getCodEpigrafe() == null){
						codEpigrafe = (listaEpigrafes != null ? ((Epigrafe) listaEpigrafes.elementAt(0)).getCodEpigrafe() : "");
						planes = conexion.findConsultaPlanesResumen(mes, anho, codEpigrafe, codOficina);
					}
				}
			}else{
				objetivoForm.setIndMostrarEpigrafe("0");
			}
			
			if(planes!=null){
				if(planes.getCodEpigrafe()!=null){
					listaGestores = utilList.listarGestores(codOficina, codEpigrafe, mes, anho);
					
					// Gestores de las Oficinas hijas
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
										gestor1.setNombreGestor(gestor1.getNombreGestor() + " *" ); // Modificado
										BigDecimal monto;
										monto = conexion.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, anho, codOficina, mes);
										
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
					
					// TODO: Actualizar el cargo de los gestors LDAP 
					conexion.actualizarCargoGestoresLDAP(listaGestores, codEpigrafe, anho, codOficina, mes, gestor.getPerfilMostrar());
					
					// TODO: Actualizar de estado gestores eliminados del LDAP
					conexion.actualizarGestoresEliminadosLDAP(listaGestores, codEpigrafe, anho, codOficina, mes, gestor.getCodigoGestor());
					
					// Distribuir meta al GOF si se han eliminados gestores del LDAP
					listaGestores = conexion.distribuirGOF(listaGestores, codEpigrafe, anho, codOficina, mes);
					
					if(listaGestores.size()>0){
						objetivoForm.setIndMostrarGerente("1");
						objetivoForm.setEpigrafe(planes.getNomEpigrafe());
						objetivoForm.setPrioridad(planes.getPrioridad() != null ? planes.getPrioridad().toString() : null);
						objetivoForm.setRestoOficina(planes.getFactAjusTerri() != null ? planes.getFactAjusTerri().toString() : "");
					}else{
						objetivoForm.setIndMostrarGerente("0");
					}
					objetivoForm.setIndMostrarEpigrafe("1");
				}else{
					objetivoForm.setIndMostrarEpigrafe("0");
				}
			}else{
				objetivoForm.setIndMostrarEpigrafe("0");
				objetivoForm.setIndMostrarGerente("0");
			}
			
			log.info("[ObjetivosAction :: inicioObjetivo] IndMostrarEpigrafe: " + objetivoForm.getIndMostrarEpigrafe());
			log.info("[ObjetivosAction :: inicioObjetivo] IndMostrarGerente: " + objetivoForm.getIndMostrarGerente());
					
			request.setAttribute("anho", anho);
			request.setAttribute("mes", mes);
			request.setAttribute("codOficina", codOficina);
			
			synchronized(request) {
				request.setAttribute("listaGestores", listaGestores);
				sesion.setAttribute("listaGestoresComp", listaGestores);
			}
			
			request.setAttribute("planes", planes);
			request.setAttribute("listaOficina", listaOficina);
			request.setAttribute("listaAnhos", listaAnhos);
			request.setAttribute("listaEpigrafes", listaEpigrafes);
			request.setAttribute("indMostrarEpigrafe", objetivoForm.getIndMostrarEpigrafe());
			request.setAttribute("indMostrarGerente", objetivoForm.getIndMostrarGerente());
			
			mensaje=mensaje + "";
			tipo= tipo + "";
			sesion.setAttribute("mensaje", mensaje);
			sesion.setAttribute("tipo", tipo);
			
			log.info("[ObjetivosAction :: inicioObjetivo] Fin");
		} catch (Exception e) {
			log.error("[ObjetivosAction :: inicioObjetivo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));  //$NON-NLS-2$
			sesion.setAttribute("indMostrar", "0");
		}
		
		RegistraValorDefecto.getInstancia().registrar(request, anho, mes, codOficina);
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("ok"); 
		} else {
			forward = mapping.findForward("ok"); 
		}

		return (forward);
	}
	
	public ActionForward actualizarObjetivo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		Plan planes = null;
		ActionErrors errors = new ActionErrors();
		Connection conexion = new Connection();
		ObjetivosForm objetivoForm = (ObjetivosForm) form;
		Object objIngresoUsuario = null;
		int idIngresoUsuario = 0;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[ObjetivosAction :: actualizarObjetivo] Inicio");
			
			sesion = request.getSession(false);
			gestor = (Gestor)sesion.getAttribute("gestor");
			
			String anho,mes,codOficina,codEpigrafe,montoTotal;
			anho = request.getParameter("anho");
			mes = request.getParameter("mes");
			codOficina = request.getParameter("codOficina");
			codEpigrafe = request.getParameter("codEpigrafe");
			montoTotal = objetivoForm.getMontoTotal();
			
			String codPorcentaje = request.getParameter("codPorcentaje");
			String[] listaPorcentajes = null;
			listaPorcentajes = codPorcentaje.split(",");
					
			String codGestor = request.getParameter("codGestor");
			String[] listaGestores = null;
			listaGestores = codGestor.split(",");
			
			String totalOficina = request.getParameter("restoOficina");
			String nomGestor = request.getParameter("nomGestor");
			String[] listaNomGestores = null;
			listaNomGestores = nomGestor.split(",");
			
			String codPerfil = request.getParameter("codPerfil");
			String[] listaCodPerfiles = null;
			listaCodPerfiles = codPerfil.split(",");
			
			Oficina oficina = conexion.findByCodOficina(codOficina);
			Epigrafe epigrafe = conexion.findByCodEpigAnho(codEpigrafe, anho);
			
			objIngresoUsuario = sesion.getAttribute("idIngresoUsuario");
			if(objIngresoUsuario != null) {
				idIngresoUsuario = Integer.parseInt(objIngresoUsuario.toString());
			} 
			
			planes = conexion.findConsultaPlanesResumen(mes,anho,codEpigrafe,codOficina);
			planes.setMetaGereOficina(new BigDecimal(listaPorcentajes[0].toString()));
			
			conexion.updatePlan(planes);
			
			planes = conexion.findConsultaPlanesResumen(mes,anho,codEpigrafe,codOficina);
		
			// Imprimir en el log los gestores grabados
			log.info("[ObjetivosAction :: actualizarObjetivo] ====================================");
			log.info("[ObjetivosAction :: actualizarObjetivo] Inserci" + (char) 243 + "n Objetivo");
			log.info("[ObjetivosAction :: actualizarObjetivo] Objetivo Oficina:" + codOficina);
			log.info("[ObjetivosAction :: actualizarObjetivo] Objetivo  Nro. de gestores:");
			log.info("[ObjetivosAction :: actualizarObjetivo] " + listaPorcentajes != null ? String.valueOf(listaPorcentajes.length) : "0");
			
			boolean status = true;
			MetasGestor metasGestor  = null;
			for(int i = 0; i < listaPorcentajes.length; i++){
				
				// MetasGestor metasGestor  = null;
				// metasGestor = conexion.findMetGestorByPrimaryKey (codEpigrafe, anho, codOficina, mes, listaGestores[i].toString());
				
				metasGestor  = new MetasGestor();
				metasGestor.setMes(mes);
				metasGestor.setAnho(anho);
				metasGestor.setCodEpigrafe(codEpigrafe);
				metasGestor.setOficina(oficina);
				metasGestor.setCodGestor(listaGestores[i].toString());
				metasGestor.setUsuario(gestor.getCodigoGestor());
				metasGestor.setEstado("A");
				
				metasGestor.setNomEpigrafe(epigrafe.getNomEpigrafe());
				metasGestor.setNomGestor(listaNomGestores[i].toString());
				metasGestor.setPorcAsignado(new BigDecimal(listaPorcentajes[i].toString()));
				metasGestor.setCodPerfil(listaCodPerfiles[i].toString());
				
				if(metasGestor!= null && metasGestor.getCodMetaGestor()!=null){
					mensaje = ConstantesUtil.MENSAJE_EXITO;
					tipo= "A";
					sesion.setAttribute("mensaje", mensaje);
					sesion.setAttribute("tipo", tipo);
					
					metasGestor.setUsuario(gestor.getCodigoGestor());
					status = status && conexion.updateMetasGestor(metasGestor);
					
					// TODO: Actualizar de estado gestores eliminados y distribuidos del LDAP
					conexion.actualizarGestoresDistribuidosLDAP(codEpigrafe, anho, codOficina, mes, gestor.getCodigoGestor());
					
					log.info("[ObjetivosAction :: actualizarObjetivo] "  + 
						"Actualizaci" + (char) 243 + "n Objetivo Gestor " + (i + 1)  + ":" + listaGestores[i].toString() + "-" + listaNomGestores[i].toString());
				}else{
					metasGestor.setCodMetaGestor(conexion.getCorrelativo("TIIDO_METAS_GESTOR","COD_META_GESTOR","8"));
					
					status = status && conexion.createMetasGestor(metasGestor);
					log.info("[ObjetivosAction :: actualizarObjetivo] "  +
							"Inserci" + (char) 243 + "n Objetivo Gestor " + (i + 1)  + ":" + listaGestores[i].toString() + "-" + listaNomGestores[i].toString());					
					mensaje= ConstantesUtil.MENSAJE_EXITO;
					tipo="B";
					
					sesion.setAttribute("tipo", tipo);
					sesion.setAttribute("mensaje", mensaje );
				}
			}
			log.info("[ObjetivosAction :: actualizarObjetivo] ==================================== ");
			
			if(listaPorcentajes.length > 0 && idIngresoUsuario != 0) {
				conexion.actualizarIngreso(1, idIngresoUsuario, mes, anho);
			}
			
			// Comparar
			Vector listaGestoresComp = (Vector) sesion.getAttribute("listaGestoresComp");
			Gestor usuario = (Gestor)sesion.getAttribute("gestor");
			
			if(conexion.existeIngresoForm(2, Integer.parseInt(mes), Integer.parseInt(anho), usuario.getCodigoGestor(), ConstantesUtil.parseSQLString2(new Date()), "", codOficina) == 0) {
				if(!compararCambios(listaGestoresComp, listaGestores, listaPorcentajes)) {
					conexion.insertarIngresoForm(2, Integer.parseInt(mes), Integer.parseInt(anho), usuario.getCodigoGestor(), "0", "", codOficina);
				}
			}
			
			log.info("[ObjetivosAction :: actualizarObjetivo] Fin");
			if(status) {
				request.setAttribute("ERROR_SDO", "Ok");
			} else {
				request.setAttribute("ERROR_SDO", ConstantesUtil.MENSAJE_ERROR);
			}
		} catch (Exception e) {
			request.setAttribute("ERROR_SDO", ConstantesUtil.MENSAJE_ERROR);
			log.error("[ObjetivosAction :: actualizarObjetivo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));
			sesion.setAttribute("indMostrar", "0");
			mensaje = "Surgio un Error.";
			tipo="C";
			sesion.setAttribute("mensaje", mensaje);
			sesion.setAttribute("tipo", tipo);
			return inicioObjetivo(mapping, form, request,  response);
		}
		
		return inicioObjetivo(mapping, form, request,  response);
	}
	
	public boolean compararCambios(Vector listaGestores, String listaCodGestores[], String listaMontos[]) {
		boolean resp = true;
		Iterator iter = null; 
		int i = 0;
		BigDecimal valor1 = null;
		BigDecimal valor2 = null;
		int tamLista = 0;
		
		try {
			log.info("[ObjetivosAction :: actualizarObjetivo] Inicio");
			
			if(listaGestores != null) {
				if(listaMontos != null) {
					tamLista = listaMontos.length;
				} else {
					tamLista = 0;
				}
				
				iter = listaGestores.iterator(); 
				while(iter.hasNext()) {
					Gestor g = (Gestor)iter.next();
					
					valor1 = g.getPorcAsignado() != null ? g.getPorcAsignado() : new BigDecimal(-99);
					
					if(tamLista >= i) {
						valor2 = listaMontos != null ? new BigDecimal(listaMontos[i]) : new BigDecimal(-99);
					} else {
						valor2 = listaMontos != null ? g.getPorcAsignado() : new BigDecimal(-99);
					}
					
					if(!valor1.equals(valor2)) {
						resp = false;
						break;
					}
					
					i++;
				}
			}
			
			log.info("[ObjetivosAction :: actualizarObjetivo] Fin");
		} catch(Exception e) {
			log.error("[ObjetivosAction :: actualizarObjetivo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return resp;
	}
	
	public HashMap<Gestor, Boolean> compararCambios(Vector listaGestores, String listaCodGestores[], String listaMontos[], String ty) {
		HashMap<Gestor, Boolean> resp = new HashMap<Gestor, Boolean>();
		Iterator iter = null; 
		int i = 0;
		BigDecimal valor1 = null;
		BigDecimal valor2 = null;
		int tamLista = 0;
		boolean temp = true;
		
		try {
			
			log.info("[ObjetivosAction :: actualizarObjetivo] Inicio");
			
			if(listaGestores != null) {
				if(listaMontos != null) {
					tamLista = listaMontos.length;
				} else {
					tamLista = 0;
				}
				
				iter = listaGestores.iterator(); 
				while(iter.hasNext()) {
					Gestor g = (Gestor) iter.next();
					temp = true;
					
					valor1 = g.getPorcAsignado() != null ? g.getPorcAsignado() : new BigDecimal(-99);
					
					if(tamLista >= i) {
						valor2 = listaMontos != null ? new BigDecimal(listaMontos[i]) : new BigDecimal(-99);
					} else {
						valor2 = listaMontos != null ? g.getPorcAsignado() : new BigDecimal(-99);
					}
					
					if(!valor1.equals(valor2)) {
						// resp = false;
						// break;
						temp=false;
					}
					
					resp.put(g, temp);
					i++;
				}
			}
			
			log.info("[ObjetivosAction :: actualizarObjetivo] Fin");
		} catch(Exception e) {
			log.error("[ObjetivosAction :: actualizarObjetivo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return resp;
	}
//	public boolean compararCambios(String listaGestores, String listaCodGestores, String listaMontos) {
//		boolean resp = true;
//		Iterator iter = null; 
//		int i = 0;
//		BigDecimal valor1 = null;
//		BigDecimal valor2 = null;
//		int tamLista = 0;
//		
//		try {
//			log.info("[ObjetivosAction :: actualizarObjetivo] Inicio");
//			
//			if(listaGestores != null) {
//				/*if(listaMontos != null) {
//					tamLista = listaMontos.length;
//				} else {
//					tamLista = 0;
//				}*/
//				
//				/*iter = listaGestores.iterator(); 
//				while(iter.hasNext()) {
//					Gestor g = (Gestor)iter.next();
//					
//					valor1 = g.getPorcAsignado() != null ? g.getPorcAsignado() : new BigDecimal(-99);
//					
//					if(tamLista >= i) {
//						valor2 = listaMontos != null ? new BigDecimal(listaMontos[i]) : new BigDecimal(-99);
//					} else {
//						valor2 = listaMontos != null ? g.getPorcAsignado() : new BigDecimal(-99);
//					}
//					
//					if(!valor1.equals(valor2)) {
//						resp = false;
//						break;
//					}
//					
//					i++;
//				}*/
//			}
//			
//			log.info("[ObjetivosAction :: actualizarObjetivo] Fin");
//		} catch(Exception e) {
//			log.error("[ObjetivosAction :: actualizarObjetivo] ");
//			ConstantesUtil.mostrarMensajeExcepcion(e);
//		}
//		
//		return resp;
//	}
}