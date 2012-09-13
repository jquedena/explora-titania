package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.ObjetivosForm;
import igrupobbva.pe.sistemasdoweb.forms.PlaneacionForm;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
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
import org.apache.struts.upload.FormFile;

import pe.com.bbva.model.dao.PerfilDAO;
import pe.com.stefanini.common.exception.BaseException;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeVector;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeCriterioBusqueda;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeGestorUsuarios;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
import com.grupobbva.bc.per.tele.sdo.serializable.PlanResumen;
import com.grupobbva.bc.per.tele.sdo.serializable.ResumenObjetivo;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.grupobbva.bc.per.tele.sdo.util.Especial;

@SuppressWarnings({"unchecked","unused"})
public class PlaneacionAction extends BaseLoadDataAction {
	private static Logger log = Logger.getLogger(PlaneacionAction.class);
	private SimpleDateFormat sdfAnho = new SimpleDateFormat("yyyy");
	private SimpleDateFormat sdfMes = new SimpleDateFormat("MM");

	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		forward = mapping.findForward("ok");
		Vector listaOficina = null;
		Vector listaPresup = null;
		Vector listaAnhos = null;
		Vector listaPlanes = null;
		Vector listaTablaPlanes = null;
		MaestroPlan maestro = null;
		PlaneacionForm planForm = (PlaneacionForm) form;
		HttpSession sesion = null;
		Gestor gestor = null;
		String anho = null;
		String mes = null;
		String codOficina = null;

		try {
			log.info("[PlaneacionAction :: inicio] Inicio");

			sesion = request.getSession(false);
			int primerMesPresupuesto = conexion.obtenerPrimerMesPresup();
			String strPrimerMesPresupuesto = "";

			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anho = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anho = request.getParameter("anho");
				mes = request.getParameter("mesPlanificacion");
				codOficina = request.getParameter("codOficina");
			}
			
			/*
			if (sesion.getAttribute("objeFormu") != null) {
				anho = (String) sesion.getAttribute("objeFormuAnho");
				mes = (String) sesion.getAttribute("objeFormuMes");
				codOficina = (String) sesion.getAttribute("objeFormuCodOficina");

				sesion.removeAttribute("objeFormu");
				sesion.removeAttribute("objeFormuAnho");
				sesion.removeAttribute("objeFormuMes");
				sesion.removeAttribute("objeFormuCodOficina");
			} else {
				if (sesion.getAttribute("planesHistFormu") != null) {
					anho = (String) sesion.getAttribute("planesHistFormuAnho");
					codOficina = (String) sesion.getAttribute("planesHistFormuCodOficina");

					sesion.removeAttribute("planesHistFormu");
					sesion.removeAttribute("planesHistFormuAnho");
					sesion.removeAttribute("planesHistFormuCodOficina");
				} else {
					if (sesion.getAttribute("planesResuFormu") != null) {
						anho = (String) sesion.getAttribute("planesResuFormuAnho");
						mes = (String) sesion.getAttribute("planesResuFormuMes");
						codOficina = (String) sesion.getAttribute("planesResuFormuCodOficina");

						sesion.removeAttribute("planesResuFormu");
						sesion.removeAttribute("planesResuFormuAnho");
						sesion.removeAttribute("planesResuFormuMes");
						sesion.removeAttribute("planesResuFormuCodOficina");
						sesion.removeAttribute("planesResuFormuCodEpigrafe");
					} else {
						anho = request.getParameter("anho");
						mes = request.getParameter("mesPlanificacion");
						codOficina = request.getParameter("codOficina");
					}
				}
			}
			*/
			
			String mesEvalMostrar = "";
			String mesEvalMostrarAnte = "";
			UtilListas utilList = new UtilListas();
			Multitabla mul = conexion.findMultiByPrimaryKey("T02", "1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());

			log.info("[PlaneacionAction :: inicio] Anio ---->" + anhoBase + " ---Rango----->" + rango);

			listaAnhos = utilList.obtenerListAnhos(anhoBase, rango);

			gestor = (Gestor) sesion.getAttribute("gestor");

			String mesPres, presuReferencia, fechita = "";
			// anho = planForm.getAnho();
			presuReferencia = planForm.getPreReferencia();
			if ((presuReferencia == null) || (presuReferencia == "")) {
				presuReferencia = "12";
			}

			// mes = planForm.getMesPlanificacion();
			// codOficina = planForm.getCodOficina();
			mesPres = planForm.getPreReferencia();

			if ((anho == null) || (mes == null) || (codOficina == null)) {
				Calendar calendario = Calendar.getInstance();
				Date fecha = calendario.getTime();
				mes = sdfMes.format(fecha);
				anho = sdfAnho.format(fecha);
			}

			// Se obtiene mes de referencia de la tabla tiido_meses_referencia
			int mesReferencia = conexion.findMesesReferencia(Integer.parseInt(mes), Integer.parseInt(anho));
			if (mesReferencia > 0) {
				listaPresup = new Vector();
				Multitabla multi = new Multitabla();
				ConstantesUtil constantesUtil = new ConstantesUtil();

				multi.setCodelem(String.valueOf(mesReferencia));
				multi.setValor1(constantesUtil.litMes(mesReferencia));

				listaPresup.add(multi);

				presuReferencia = multi.getCodelem();
				strPrimerMesPresupuesto = multi.getValor1();
			} else {
				Multitabla multi = new Multitabla();
				listaPresup = new Vector();
				ConstantesUtil constantesUtil = new ConstantesUtil();

				int nuevoMesReferencia = 0;
				if (mes != null) {
					if (Integer.parseInt(mes) > 6) {
						nuevoMesReferencia = 12;
					} else {
						nuevoMesReferencia = 6;
					}
				} else {
					nuevoMesReferencia = 12;
				}
				presuReferencia = ConstantesUtil.dosCeros(nuevoMesReferencia);
				multi.setCodelem(String.valueOf(nuevoMesReferencia));
				multi.setValor1(constantesUtil.litMes(nuevoMesReferencia));
				listaPresup.add(multi);
			}

			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				listaOficina = conexion.findAllOficinaByCodTerri(gestor
						.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON")
						|| gestor.getCodigoPerfil().equals("ADM")
						|| gestor.getCodigoPerfil().equals("SUP")) {
					listaOficina = conexion.findAllOficinas();
				} else {
					codOficina = gestor.getCodigoOficina();
					if (codOficina != null) {
						log.info("[PlaneacionAction :: inicio] El codigo de oficina usado fue : " + codOficina);
						listaOficina = conexion.findListaByCodOficina(codOficina);
					} else {
						log.info("[PlaneacionAction :: inicio] El codigo de oficina usado fue : " + gestor.getCodigoOficina());
						listaOficina = conexion.findListaByCodOficina(gestor.getCodigoOficina());
					}
				}
			}

			if ((codOficina == null || (codOficina != null && codOficina.equals("%")))
					&& listaOficina != null && listaOficina.size() > 0) {
				codOficina = ((Oficina) listaOficina.elementAt(0)).getCodOfic();
				log.info("[PlaneacionAction :: inicio] CodOficina: " + codOficina);
			}

			mesEvalMostrarAnte = utilList.obtenerNomMesAnterior(mes);
			mesEvalMostrar = utilList.obtenerNomMes(presuReferencia);
			planForm.setAnho(anho);
			planForm.setMesPlanificacion(mes);
			planForm.setCodOficina(codOficina);
			planForm.setPreReferencia(presuReferencia);

			listaPlanes = conexion.findConsultaPlanes("", codOficina, anho, mes, presuReferencia);
			Vector listaAnual = null;
			listaAnual = conexion.findConsultarPlanesxMes(codOficina, anho);
			listaTablaPlanes = conexion.findConsultarPlanesxMes(codOficina,
					anho);
			planForm.setListaPlanes(listaPlanes);
			planForm.setListaOficina(listaOficina);
			planForm.setListaAnhos(listaAnhos);
			planForm.setListaPresup(listaPresup);

			int mesEval = Integer.valueOf(mes).intValue();

			if (listaPlanes != null && listaPlanes.size() > 0) {
				planForm.setIndMostrar("1");
			} else {
				planForm.setIndMostrar("0");
			}

			sesion.setAttribute("listaPlanes", listaPlanes);
			sesion.setAttribute("listaPlanesComp", listaPlanes);
			sesion.setAttribute("listaOficina", listaOficina);
			sesion.setAttribute("listaAnhos", listaAnhos);
			sesion.setAttribute("listaPresup", listaPresup);
			sesion.setAttribute("mesEvalMostrar", mesEvalMostrar);
			sesion.setAttribute("mesEvalMostrarAnte", mesEvalMostrarAnte);
			sesion.setAttribute("indMostrar", planForm.getIndMostrar());
			sesion.setAttribute("mesPresupuesto", presuReferencia);
			sesion.setAttribute("primerMesPresupuesto", strPrimerMesPresupuesto);

			/*
			sesion.setAttribute("planesFormu", "1");
			sesion.setAttribute("planesFormuAnho", anho);
			sesion.setAttribute("planesFormuMes", mes);
			sesion.setAttribute("planesFormuCodOficina", codOficina);
			*/
			
			log.info("[PlaneacionAction :: inicio] Fin");
			sesion.setAttribute("ERROR_SDO", "");
		} catch (Exception e) {
			log.error("[PlaneacionAction :: inicio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
			sesion.setAttribute("indMostrar", "0");
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("ok");
		} else {
			forward = mapping.findForward("ok");
		}

		RegistraValorDefecto.getInstancia().registrar(request, anho, mes, codOficina);
		
		return (forward);
	}

	public ActionForward grabar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		forward = mapping.findForward("ok");
		PlaneacionForm planForm = (PlaneacionForm) form;
		HttpSession sesion = null;
		Iterator iterListaPlanesComp = null;
		Gestor gestorUsuario = null;

		try {
			log.info("[PlaneacionAction :: grabar] Inicio");

			sesion = request.getSession(false);
			gestorUsuario = (Gestor) sesion.getAttribute("gestor");

			Vector listaPlanesComp1 = new Vector(0, 1);
			Vector listaTemp = (Vector) sesion.getAttribute("listaPlanesComp");
			if (listaTemp != null) {
				iterListaPlanesComp = listaTemp.iterator();

				while (iterListaPlanesComp.hasNext()) {
					Plan plan = (Plan) iterListaPlanesComp.next();
					Plan nuevoPlan = new Plan();

					nuevoPlan.setCodOficina(plan.getCodOficina());
					nuevoPlan.setCodTerritorio(plan.getCodTerritorio());
					nuevoPlan.setMes(plan.getMes());
					nuevoPlan.setAnho(plan.getAnho());
					nuevoPlan.setCodEpigrafe(plan.getCodEpigrafe());
					nuevoPlan.setDesvAjusPpto(plan.getDesvAjusPpto());
					nuevoPlan.setProyCrecMens(plan.getProyCrecMens());
					nuevoPlan.setProyAjusMens(plan.getProyAjusMens());
					nuevoPlan.setDesvPpto(plan.getDesvPpto());
					nuevoPlan.setAjusPpto(plan.getAjusPpto());
					nuevoPlan.setNroMesesFalt(plan.getNroMesesFalt());
					nuevoPlan.setHistBajas(plan.getHistBajas());
					nuevoPlan.setFactAjusTerri(plan.getFactAjusTerri());
					nuevoPlan.setFactAjusGereOfic(plan.getFactAjusGereOfic());
					nuevoPlan.setMetaMesSaldPunt(plan.getMetaMesSaldPunt());
					nuevoPlan.setMetaGereOficina(plan.getMetaGereOficina());
					nuevoPlan.setPrioridad(plan.getPrioridad());

					listaPlanesComp1.add(nuevoPlan);
				}
			}

			Vector listaPlanesComp2 = new Vector(0, 1);

			String[] listaValorAjus = request.getParameterValues("ajusPpto");
			String[] listaValorMeses = request.getParameterValues("nroMesesFalt");
			String[] listaValorSaldo = request.getParameterValues("factAjusSaldPunt");
			String[] listaValorBaja = request.getParameterValues("histBajas");
			String[] listaValorTerri = request.getParameterValues("factAjusTerri");
			String[] listaValorGeren = request.getParameterValues("factAjusGereOfic");
			String[] listaValorDeAPt = request.getParameterValues("desvAjusPpto");
			String[] listaValorPCMen = request.getParameterValues("proyCrecMens");
			String[] listaValorPAMen = request.getParameterValues("proyAjusMens");
			String[] listaValorDePto = request.getParameterValues("desvPpto");
			String[] listaValorPrior = request.getParameterValues("prioridad");
			String[] listaValorObjetivo = request.getParameterValues("metaMesSaldPunt");

			Vector listaMovimientos = new Vector();
			Iterator listaPlanesReq = null;
			Collection aCollection = null;
			int cont;
			cont = 0;

			String anho = planForm.getAnho();
			String mes = planForm.getMesPlanificacion();
			String mesPres = planForm.getPreReferencia();
			String codOficina = planForm.getCodOficina();
			Vector listaPlanes = null;
			Vector listaEpigrafe = null;
			Epigrafe epigrafe = null;
			UtilListas utilList = new UtilListas();
			Object objIngresoUsuario = null;
			int idIngresoUsuario = 0;
			objIngresoUsuario = sesion.getAttribute("idIngresoUsuario");
			if (objIngresoUsuario != null) {
				idIngresoUsuario = Integer.parseInt(objIngresoUsuario.toString());
			}
			aCollection = planForm.getListaPlanes();
			if (aCollection == null) {
				aCollection = (Vector) sesion.getAttribute("listaPlanes");
			}

			listaPlanesReq = aCollection.iterator();

			while (listaPlanesReq.hasNext()) {
				Plan moviLocal = (Plan) listaPlanesReq.next();
				epigrafe = new Epigrafe();

				if (listaEpigrafe == null) {
					listaEpigrafe = new Vector(0, 1);
				}
				epigrafe.setCodEpigrafe(moviLocal.getCodEpigrafe());
				epigrafe.setPorcAsignado(new BigDecimal(listaValorGeren[cont]));

				listaEpigrafe.add(epigrafe);

				moviLocal.setDesvAjusPpto(new BigDecimal(listaValorDeAPt[cont])); // Validado
				moviLocal.setProyCrecMens(new BigDecimal(listaValorPCMen[cont])); // Validado
				moviLocal.setProyAjusMens(new BigDecimal(listaValorPAMen[cont])); // Campo Oculto
				moviLocal.setDesvPpto(new BigDecimal(Especial.eliminarComa(listaValorDePto[cont]))); // Validado
				moviLocal.setAjusPpto(new BigDecimal(listaValorAjus[cont])); // % No se Formatea
				moviLocal.setNroMesesFalt(new BigDecimal(listaValorMeses[cont])); // No se Formatea
				moviLocal.setHistBajas(new BigDecimal(listaValorBaja[cont])); // No se Formatea
				moviLocal.setFactAjusTerri(new BigDecimal(listaValorTerri[cont])); // No se Formatea - Ingresado
				moviLocal.setFactAjusGereOfic(new BigDecimal(listaValorGeren[cont])); // No se Formatea - Ingresado
				moviLocal.setMetaMesSaldPunt(new BigDecimal(listaValorObjetivo[cont])); // Validado
				moviLocal.setMetaGereOficina(new BigDecimal(listaValorObjetivo[cont]));

				String cValPrioridad = listaValorPrior[cont].trim();
				if (!cValPrioridad.equals("")) {
					moviLocal.setPrioridad(new BigDecimal(listaValorPrior[cont]));
				} else {
					moviLocal.setPrioridad(new BigDecimal("99"));
				}

				moviLocal.setUsuario(gestorUsuario.getCodigoGestor());
				boolean flgEstado = conexion.updatePlan(moviLocal);
				cont++;

				listaPlanesComp2.add(moviLocal);
			}

			listaPlanes = conexion.findConsultaPlanes("", codOficina, anho, mes, mesPres);
			sesion.setAttribute("listaPlanes", listaPlanes);

			if (aCollection != null && aCollection.size() > 0
					&& idIngresoUsuario != 0) {
				conexion.actualizarIngreso(5, idIngresoUsuario, mes, anho);
			}

			// Actualizar Asignacion GOF en Objetivos
			if (listaEpigrafe != null && listaEpigrafe.size() > 0) {
				Vector listaGestores = utilList.listarGestores(codOficina,
						((Epigrafe) listaEpigrafe.get(0)).getCodEpigrafe(),
						mes, anho);
				Iterator iterListaGestores = null;
				String codGestorGOF = null;

				if (listaGestores != null && listaGestores.size() > 0) {
					iterListaGestores = listaGestores.iterator();

					while (iterListaGestores.hasNext()) {
						Gestor gestor = (Gestor) iterListaGestores.next();

						if (gestor.getCodigoPerfil().equals("GOF")) {
							codGestorGOF = gestorUsuario.getCodigoGestor();
							break;
						}
					}

					if (codGestorGOF != null) {
						conexion.actualizarMetaGestoresPlanes(listaEpigrafe,
								anho, codOficina, mes, codGestorGOF,
								gestorUsuario.getCodigoGestor());
					}
				}
			}

			// Comparar
			if (conexion.existeIngresoForm(1, Integer.parseInt(mes), Integer
					.parseInt(anho), gestorUsuario.getCodigoGestor(),
					ConstantesUtil.parseSQLString2(new Date()), "", codOficina) == 0) {
				if (!compararCambios(listaPlanesComp1, listaPlanesComp2)) {
					conexion.insertarIngresoForm(1, Integer.parseInt(mes)
							, Integer.parseInt(anho)
							, gestorUsuario.getCodigoGestor()
							, "0"
							, ""
							, codOficina);
				}
			}

			sesion.setAttribute("ERROR_SDO", "Ok");
			log.info("[PlaneacionAction :: grabar] Fin");
		} catch (Exception e) {
			log.error("[PlaneacionAction :: grabar] Error");
			log.error(e);
			sesion.setAttribute("ERROR_SDO", "Error al Grabar");
		}

		return (forward);
	}

	public boolean compararCambios(Vector listaPlanesComp, Vector listaPlanesReq) {
		boolean resp = true;
		Iterator iter1 = null;
		Iterator iter2 = null;
		Plan plan1 = null;
		Plan plan2 = null;

		try {
			log.info("[PlaneacionAction :: compararCambios] Inicio");

			if (listaPlanesComp != null && listaPlanesReq != null) {
				iter1 = listaPlanesComp.iterator();
				while (iter1.hasNext()) {
					plan1 = (Plan) iter1.next();

					iter2 = listaPlanesReq.iterator();
					while (iter2.hasNext()) {
						plan2 = (Plan) iter2.next();
						if (plan2.getCodOficina() != null
								&& plan2.getCodTerritorio() != null
								&& plan2.getMes() != null
								&& plan2.getAnho() != null
								&& plan2.getCodEpigrafe() != null) {

							if (plan2.getCodOficina().equals(
									plan1.getCodOficina())
									&& plan2.getCodTerritorio().equals(
											plan1.getCodTerritorio())
									&& plan2.getMes().equals(plan1.getMes())
									&& plan2.getAnho().equals(plan1.getAnho())
									&& plan2.getCodEpigrafe().equals(
											plan1.getCodEpigrafe())) {

								if (plan1.getDesvAjusPpto() != null
										&& plan2.getDesvAjusPpto() != null) {
									if (!plan1.getDesvAjusPpto().equals(
											plan2.getDesvAjusPpto())) {
										resp = false;
										break;
									}
								}

								if (plan1.getProyCrecMens() != null
										&& plan2.getProyCrecMens() != null) {
									if (!plan1.getProyCrecMens().equals(
											plan2.getProyCrecMens())) {
										resp = false;
										break;
									}
								}

								if (plan1.getProyAjusMens() != null
										&& plan2.getProyAjusMens() != null) {
									if (!plan1.getProyAjusMens().equals(
											plan2.getProyAjusMens())) {
										resp = false;
										break;
									}
								}

								if (plan1.getDesvPpto() != null
										&& plan2.getDesvPpto() != null) {
									if (!plan1.getDesvPpto().equals(
											plan2.getDesvPpto())) {
										resp = false;
										break;
									}
								}

								if (plan1.getAjusPpto() != null
										&& plan2.getAjusPpto() != null) {
									if (!plan1.getAjusPpto().equals(
											plan2.getAjusPpto())) {
										resp = false;
										break;
									}
								}

								if (plan1.getNroMesesFalt() != null
										&& plan2.getNroMesesFalt() != null) {
									if (!plan1.getNroMesesFalt().equals(
											plan2.getNroMesesFalt())) {
										resp = false;
										break;
									}
								}

								if (plan1.getHistBajas() != null
										&& plan2.getHistBajas() != null) {
									if (!plan1.getHistBajas().equals(
											plan2.getHistBajas())) {
										resp = false;
										break;
									}
								}

								if (plan1.getFactAjusTerri() != null
										&& plan2.getFactAjusTerri() != null) {
									if (!plan1.getFactAjusTerri().equals(
											plan2.getFactAjusTerri())) {
										resp = false;
										break;
									}
								}

								if (plan1.getFactAjusGereOfic() != null
										&& plan2.getFactAjusGereOfic() != null) {
									if (!plan1.getFactAjusGereOfic().equals(
											plan2.getFactAjusGereOfic())) {
										resp = false;
										break;
									}
								}

								if (plan1.getMetaMesSaldPunt() != null
										&& plan2.getMetaMesSaldPunt() != null) {
									if (!plan1.getMetaMesSaldPunt().equals(
											plan2.getMetaMesSaldPunt())) {
										resp = false;
										break;
									}
								}

								if (plan1.getMetaGereOficina() != null
										&& plan2.getMetaGereOficina() != null) {
									if (!plan1.getMetaGereOficina().equals(
											plan2.getMetaGereOficina())) {
										resp = false;
										break;
									}
								}

								if (plan1.getPrioridad() != null
										&& plan2.getPrioridad() != null) {
									if (!plan1.getPrioridad().equals(
											plan2.getPrioridad())) {
										resp = false;
										break;
									}
								}
								break;
							}
						}
					}

					if (!resp) {
						break;
					}
				}
			}

			log.info("[PlaneacionAction :: compararCambios] Fin");
		} catch (Exception e) {
			log.error("[PlaneacionAction :: compararCambios] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return resp;
	}

	public ActionForward elegirGestor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Vector listaGestor = null;
		Gestor gestorLista = null;
		IILDPeCriterioBusqueda cb = new IILDPeCriterioBusqueda();
		HttpSession sesion = null;

		try {
			log.info("[PlaneacionAction :: elegirGestor] Inicio");

			sesion = request.getSession(false);

			cb.setCodigoOficina("0228");
			cb.setCodigoEmpresa("");
			cb.setLimiteOcurrencias(100);
			IILDPeVector vectorGestores = IILDPeGestorUsuarios
					.buscarUsuarios(cb);

			forward = mapping.findForward("gestor");
			PlaneacionForm planForm = (PlaneacionForm) form;

			sesion.setAttribute("listaGestor", vectorGestores);

			log.info("[PlaneacionAction :: elegirGestor] Fin");
		} catch (Exception e) {
			log.error("[PlaneacionAction :: elegirGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return (forward);
	}

	public ActionForward resumen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		forward = mapping.findForward("resumen");
		Vector listaTerritorio = new Vector();
		Vector lstOficina = null;
		Vector listaOficina = new Vector();
		Vector listaPresup = null;
		Vector listaMeses = null;
		Vector listaAnhos = null;
		String mesEvaluacion = "12";
		Vector listaPlanes = new Vector();
		Vector listaPlanesResumen = new Vector();
		Vector listaTablaPlanes = null;
		Vector listaGestores = null;
		MaestroPlan maestro = null;
		Territorio lsterritorio = null;
		int primerMesPresupuesto = -1;
		String strPrimerMesPresupuesto = "";
		PlaneacionForm planForm = null;
		ObjetivosForm objetivosForm = null;
		Gestor gestor = null;
		HttpSession sesion = null;
		String anho = null;
		String mes = null;
		String codOficina = null;

		try {
			log.info("[PlaneacionAction :: resumen] Inicio");

			sesion = request.getSession(false);
			primerMesPresupuesto = conexion.obtenerPrimerMesPresup();
			planForm = (PlaneacionForm) form;

			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anho = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anho = request.getParameter("anho");
				mes = request.getParameter("mesPlanificacion");
				codOficina = request.getParameter("codOficina");
			}
			
			/*
			if (sesion.getAttribute("planesFormu") != null) {
				anho = (String) sesion.getAttribute("planesFormuAnho");
				mes = (String) sesion.getAttribute("planesFormuMes");
				codOficina = (String) sesion.getAttribute("planesFormuCodOficina");

				sesion.removeAttribute("planesFormu");
				sesion.removeAttribute("planesFormuAnho");
				sesion.removeAttribute("planesFormuMes");
				sesion.removeAttribute("planesFormuCodOficina");
			} else {
				if (sesion.getAttribute("planesHistFormu") != null) {
					anho = (String) sesion.getAttribute("planesHistFormuAnho");
					codOficina = (String) sesion.getAttribute("planesHistFormuCodOficina");

					sesion.removeAttribute("planesHistFormu");
					sesion.removeAttribute("planesHistFormuAnho");
					sesion.removeAttribute("planesHistFormuCodOficina");
				} else {
					if (sesion.getAttribute("objeFormu") != null) {
						anho = (String) sesion.getAttribute("objeFormuAnho");
						mes = (String) sesion.getAttribute("objeFormuMes");
						codOficina = (String) sesion.getAttribute("objeFormuCodOficina");

						sesion.removeAttribute("objeFormu");
						sesion.removeAttribute("objeFormuAnho");
						sesion.removeAttribute("objeFormuMes");
						sesion.removeAttribute("objeFormuCodOficina");
					} else {
						anho = request.getParameter("anho");
						mes = request.getParameter("mesPlanificacion");
						codOficina = request.getParameter("codOficina");
					}
				}
			}
			 */
			
			gestor = (Gestor) sesion.getAttribute("gestor");
			Multitabla mul = null;
			String mesEvalMostrar = "";
			String mesEvalMostrarAnte = "";
			UtilListas utilList = new UtilListas();

			mul = conexion.findMultiByPrimaryKey("T02", "1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());
			listaAnhos = utilList.obtenerListAnhos(anhoBase, rango);
			String presuReferencia, codTerritorio = "", fechita = "";
			presuReferencia = planForm.getPreReferencia();
			if ((presuReferencia == null) || (presuReferencia == "")) {
				presuReferencia = "12";
			}
			if ((anho == null) || (mes == null)) {
				Calendar calendario = Calendar.getInstance();
				Date fecha = calendario.getTime();
				mes = sdfMes.format(fecha);
				anho = sdfAnho.format(fecha);
			}
			Calendar calendarioActual = Calendar.getInstance();
			Date fechaActual = calendarioActual.getTime();
			String mesActual = sdfMes.format(fechaActual);
			String anhoActual = sdfAnho.format(fechaActual);

			int mesReferencia = conexion.findMesesReferencia(Integer.parseInt(mes), Integer.parseInt(anho));
			if (mesReferencia > 0) {
				listaPresup = new Vector();
				Multitabla multi = new Multitabla();
				ConstantesUtil constantesUtil = new ConstantesUtil();
				multi.setCodelem(String.valueOf(mesReferencia));
				multi.setValor1(constantesUtil.litMes(mesReferencia));
				listaPresup.add(multi);
				presuReferencia = multi.getCodelem();
				strPrimerMesPresupuesto = multi.getValor1();
			} else {
				Multitabla multi = new Multitabla();
				listaPresup = new Vector();
				ConstantesUtil constantesUtil = new ConstantesUtil();

				int nuevoMesReferencia = 0;
				if (mes != null) {
					if (Integer.parseInt(mes) > 6) {
						nuevoMesReferencia = 12;
					} else {
						nuevoMesReferencia = 6;
					}
				} else {
					nuevoMesReferencia = 12;
				}
				multi.setCodelem(String.valueOf(nuevoMesReferencia));
				multi.setValor1(constantesUtil.litMes(nuevoMesReferencia));
				listaPresup.add(multi);
			}

			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				lsterritorio = conexion.findByCodTerritorio(gestor.getCodigoTerritorio());
				listaTerritorio.add(lsterritorio);
				codTerritorio = gestor.getCodigoTerritorio();

				Oficina oTodosOficina = new Oficina();
				oTodosOficina.setCodOfic("");
				oTodosOficina.setCodNomOficina("--Seleccione--");
				listaOficina.add(oTodosOficina);

				oTodosOficina = new Oficina();
				oTodosOficina.setCodOfic("%");
				oTodosOficina.setCodNomOficina("--Todos--");
				listaOficina.add(oTodosOficina);
								
				lstOficina = conexion.findAllOficinaByCodTerri(gestor.getCodigoTerritorio());
				for (int i = 0; i < lstOficina.size(); i++) {
					oTodosOficina = (Oficina) lstOficina.elementAt(i);
					listaOficina.addElement(oTodosOficina);
				}
				if (codOficina == null) {
					if (request.getParameter("codOficina") == null) {
						codOficina = ((Oficina) listaOficina.elementAt(0)).getCodOfic();
					} else {
						codOficina = request.getParameter("codOficina");
					}
				}
			} else if (gestor.getCodigoPerfil().equals("CON") 
					|| gestor.getCodigoPerfil().equals("ADM")
					|| gestor.getCodigoPerfil().equals("SUP")) {
				// Mostrar solo los territorios activos
				listaTerritorio = conexion.findAllTerritorio();
				
				if (planForm.getCodTerritorio() == null) {
					if (codOficina != null) {
						Oficina ox = conexion.findByCodOficina(codOficina);
						codTerritorio = ox.getTerr().getCodTerr();
					} else {
						codTerritorio = ((Territorio) listaTerritorio.elementAt(0)).getCodTerr();
					}
				} else {
					// codTerritorio = planForm.getCodTerritorio();
					codTerritorio = request.getParameter("codTerritorio");
				}
				Oficina oTodosOficina = new Oficina();
				oTodosOficina.setCodOfic("");
				oTodosOficina.setCodNomOficina("--Seleccione--");
				listaOficina.add(oTodosOficina);

				oTodosOficina = new Oficina();
				oTodosOficina.setCodOfic("%");
				oTodosOficina.setCodNomOficina("--Todos--");
				listaOficina.add(oTodosOficina);
				lstOficina = conexion.findAllOficinaByCodTerri(codTerritorio);
				for (int i = 0; i < lstOficina.size(); i++) {
					oTodosOficina = (Oficina) lstOficina.elementAt(i);
					listaOficina.addElement(oTodosOficina);
				}
				if (codOficina == null) {
					codOficina = ((Oficina) listaOficina.elementAt(0)).getCodOfic();
				}
			} else {

				listaTerritorio = null;
				codTerritorio = "";

				if (codOficina != null) {
					log.info("[PlaneacionAction :: resumen] El codigo de oficina usado fue : " + codOficina);
					listaOficina = conexion.findListaByCodOficina(codOficina);
				} else {
					log.info("[PlaneacionAction :: resumen] El codigo de oficina usado fue : " + gestor.getCodigoOficina());
					listaOficina = conexion.findListaByCodOficina(gestor.getCodigoOficina());
				}

				if (request.getParameter("codOficina") == null
						|| request.getParameter("codOficina").equals("")) {
					codOficina = ((Oficina) listaOficina.elementAt(0)).getCodOfic();
				} else {
					codOficina = request.getParameter("codOficina");
				}
			}

			mesEvalMostrarAnte = utilList.obtenerNomMesAnterior(mes);
			mesEvalMostrar = utilList.obtenerNomMes(mes);
			planForm.setAnho(anho);
			planForm.setMesPlanificacion(mes);
			planForm.setCodOficina(codOficina);
			planForm.setCodTerritorio(codTerritorio);
			planForm.setPreReferencia(presuReferencia);

			if(codTerritorio.length()==0) codTerritorio = gestor.getCodigoTerritorio();
			Map<String, Integer> newMap = conexion.findCantidadPersonal(anho, mes, codOficina, codTerritorio);

			listaPlanes = conexion.findConsultaPlanes(codTerritorio, codOficina, anho, mes, presuReferencia);
			if (listaPlanes != null) {
				Iterator iter = listaPlanes.iterator();
				while (iter.hasNext()) {
					Plan plan = (Plan) iter.next();
					PlanResumen planResumen = new PlanResumen();

					planResumen.setPrioridad(plan.getPrioridad());
					planResumen.setCodEpigrafe(plan.getCodEpigrafe());
					planResumen.setNomEpigrafe(plan.getNomEpigrafe());
					planResumen.setFactPlanificacion(plan.getMetaMesSaldPunt());
					planResumen.setAjusteTerrPlanificacion(plan.getFactAjusTerri());
					planResumen.setFactAsigGOFPlanificacion(plan.getNuevoFactAjusGereOfic());

					planResumen.setPorcentajeMax(plan.getPorcentajeMax());
					planResumen.setPorcentajeMin(plan.getPorcentajeMin());
					planResumen.setPorAlcanzado(plan.getPorAlcanzado());
					planResumen.setIndAfecta(plan.getIndAfecta());
					planResumen.setIndHijo(plan.getIndHijo());

					listaPlanesResumen.add(planResumen);
				}
			}

			Iterator iterPlanesResumen = null;
			Iterator iterListaGestores = null;
			Vector listaOficinasxTerr = null;

			if (codOficina.equals("%")) {
				listaOficinasxTerr = conexion.busOficinaxTerritorio(
						codTerritorio, false);
			}

			iterPlanesResumen = listaPlanesResumen.iterator();

			Vector listaEpigrafe = null;
			while (iterPlanesResumen.hasNext()) {
				PlanResumen planResumen = (PlanResumen) iterPlanesResumen.next();

				if (listaEpigrafe == null) {
					listaEpigrafe = new Vector(0, 1);
				}

				listaEpigrafe.add(planResumen.getCodEpigrafe());
			}

			HashMap listaResumenMontos = null;
			if (listaEpigrafe != null) {
				if (codOficina.equals("%")) {
					listaResumenMontos = conexion.buscarResumenMontos(
							listaEpigrafe, codTerritorio, null, anho, mes);
				} else {
					listaResumenMontos = conexion.buscarResumenMontos(
							listaEpigrafe, null, codOficina, anho, mes);
				}

				if (listaResumenMontos != null) {
					iterPlanesResumen = listaPlanesResumen.iterator();
					while (iterPlanesResumen.hasNext()) {
						PlanResumen planResumen = (PlanResumen) iterPlanesResumen.next();
						ResumenObjetivo resumenObjetivo = (ResumenObjetivo) listaResumenMontos.get(planResumen.getCodEpigrafe());

						planResumen.setGOFObjetivos(resumenObjetivo.getGOF());
						planResumen.setGCOObjetivos(resumenObjetivo.getGCO());
						planResumen.setGPEObjetivos(resumenObjetivo.getGPE());
						planResumen.setGPTObjetivos(resumenObjetivo.getGPT());

						planResumen.setTotalAsignadoObjetivos(resumenObjetivo.getTotalAsignadoObjetivos());
						planResumen.setPorcGOFObjetivos(resumenObjetivo.getPorcGOF());
						planResumen.setPorcGPEObjetivos(resumenObjetivo.getPorcGPE());
						planResumen.setPorcGCOObjetivos(resumenObjetivo.getPorcGCO());
						planResumen.setPorcGPTObjetivos(resumenObjetivo.getPorcGPT());

						// pasar nulos a 0
						if (planResumen.getPrioridad() == null)
							planResumen.setPrioridad(new BigDecimal("0"));
						if (planResumen.getFactPlanificacion() == null)
							planResumen.setFactPlanificacion(new BigDecimal("0"));
						if (planResumen.getAjusteTerrPlanificacion() == null)
							planResumen.setAjusteTerrPlanificacion(new BigDecimal("0"));
						if (planResumen.getFactAsigGOFPlanificacion() == null)
							planResumen.setFactAsigGOFPlanificacion(new BigDecimal("0"));
						if (planResumen.getTotalAsignadoObjetivos() == null)
							planResumen.setTotalAsignadoObjetivos(new BigDecimal("0"));
						if (planResumen.getGOFObjetivos() == null)
							planResumen.setGOFObjetivos(new BigDecimal("0"));
						if (planResumen.getPorcGOFObjetivos() == null)
							planResumen.setPorcGOFObjetivos(new BigDecimal("0"));
						if (planResumen.getGCOObjetivos() == null)
							planResumen.setGCOObjetivos(new BigDecimal("0"));
						if (planResumen.getPorcGCOObjetivos() == null)
							planResumen.setPorcGCOObjetivos(new BigDecimal("0"));
						if (planResumen.getGPEObjetivos() == null)
							planResumen.setGPEObjetivos(new BigDecimal("0"));
						if (planResumen.getPorcGPEObjetivos() == null)
							planResumen.setPorcGPEObjetivos(new BigDecimal("0"));
						if (planResumen.getGPTObjetivos() == null)
							planResumen.setGPTObjetivos(new BigDecimal("0"));
						if (planResumen.getPorcGPTObjetivos() == null)
							planResumen.setPorcGPTObjetivos(new BigDecimal("0"));
						if (planResumen.getPorcentajeMax() == null)
							planResumen.setPorcentajeMax(new BigDecimal("0"));
						if (planResumen.getPorcentajeMin() == null)
							planResumen.setPorcentajeMin(new BigDecimal("0"));
						if (planResumen.getPorAlcanzado() == null)
							planResumen.setPorAlcanzado(new BigDecimal("0"));
					}
				}
			}

			request.setAttribute("GOF", newMap.get("GOF") == null ? 0 : newMap.get("GOF"));
			request.setAttribute("GCO", newMap.get("GCO") == null ? 0 : newMap.get("GCO"));
			request.setAttribute("GPE", newMap.get("GPE") == null ? 0 : newMap.get("GPE"));
			request.setAttribute("GPT", newMap.get("GPT") == null ? 0 : newMap.get("GPT"));

			int i;
			PerfilDAO perfilDAO = new PerfilDAO();
			List<Equivalencia> eq = perfilDAO.findEquivalenciaAll();
			for(i = 0; i < eq.size(); i++) {
				if(eq.get(i).getCodPerfil().equalsIgnoreCase("GOF")) {
					request.setAttribute("_GOF", eq.get(i).getPerfil());
				}
				if(eq.get(i).getCodPerfil().equalsIgnoreCase("GCO")) {
					request.setAttribute("_GCO", eq.get(i).getPerfil());
				}
				if(eq.get(i).getCodPerfil().equalsIgnoreCase("GPE")) {
					request.setAttribute("_GPE", eq.get(i).getPerfil());
				}
				if(eq.get(i).getCodPerfil().equalsIgnoreCase("GPT")) {
					request.setAttribute("_GPT", eq.get(i).getPerfil());
				}
			}
			
			request.setAttribute("listaPlanesResumen", listaPlanesResumen);
			request.setAttribute("listaOficina", listaOficina);
			request.setAttribute("listaAnhos", listaAnhos);
			request.setAttribute("listaPresup", listaPresup);
			request.setAttribute("mesEvalMostrar", mesEvalMostrar);
			request.setAttribute("mesEvalMostrarAnte", mesEvalMostrarAnte);
			request.setAttribute("listaTerritorio", listaTerritorio);
			request.setAttribute("mesPresupuesto", presuReferencia);
			request.setAttribute("primerMesPresupuesto", strPrimerMesPresupuesto);

			/*
			sesion.setAttribute("planesResuFormu", "1");
			sesion.setAttribute("planesResuFormuAnho", anho);
			sesion.setAttribute("planesResuFormuMes", mes);
			sesion.setAttribute("planesResuFormuCodOficina", codOficina);
			 */
			log.info("[PlaneacionAction :: resumen] Fin");
		} catch (Exception e) {
			log.error("[PlaneacionAction :: resumen] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("resumen");
		} else {
			forward = mapping.findForward("resumen");
		}

		RegistraValorDefecto.getInstancia().registrar(request, anho, mes, codOficina);
		
		return (forward);
	}

	public ActionForward imprimir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		// Connection conexion = new Connection();
		forward = mapping.findForward("imprimir");
		Vector listaOficina = null;
		Vector listaPresup = null;
		Vector listaMeses = null;
		Vector listaAnhos = null;
		String mesEvaluacion = "12";
		Vector listaPlanes = null;
		Vector listaTablaPlanes = null;
		MaestroPlan maestro = null;
		PlaneacionForm planForm = (PlaneacionForm) form;
		Multitabla mul = null;
		String mesEvalMostrar = "";
		String mesEvalMostrarAnte = "";
		UtilListas utilList = new UtilListas();
		HttpSession sesion = null;
		Gestor gestor = null;

		try {
			log.info("[PlaneacionAction :: imprimir] Inicio");

			sesion = request.getSession(false);

			mul = conexion.findMultiByPrimaryKey("T02", "1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());
			listaAnhos = utilList.obtenerListAnhos(anhoBase, rango);

			gestor = (Gestor) sesion.getAttribute("gestor");

			String anho, mes, codOficina, presuReferencia, fechita = "";
			anho = planForm.getAnho();
			presuReferencia = planForm.getPreReferencia();
			mes = planForm.getMesPlanificacion();
			codOficina = planForm.getCodOficina();

			listaPresup = utilList.obtenerListPresup(mes, gestor
					.getCodigoPerfil());

			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				listaOficina = conexion.findAllOficinaByCodTerri(gestor
						.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON") 
						|| gestor.getCodigoPerfil().equals("ADM")
						|| gestor.getCodigoPerfil().equals("SUP")) {
					listaOficina = conexion.findAllOficinas();
				} else {
					listaOficina = conexion.findListaByCodOficina(gestor
							.getCodigoOficina());
				}
			}

			mesEvalMostrarAnte = utilList.obtenerNomMesAnterior(mes);
			mesEvalMostrar = utilList.obtenerNomMes(mes);
			planForm.setAnho(anho);
			planForm.setMesPlanificacion(mes);
			planForm.setCodOficina(codOficina);
			planForm.setPreReferencia(presuReferencia);

			listaPlanes = conexion.findConsultaPlanes("", codOficina, anho,
					mes, presuReferencia);
			listaTablaPlanes = conexion.findConsultarPlanesxMes(codOficina,
					anho);
			planForm.setListaPlanes(listaPlanes);
			planForm.setListaOficina(listaOficina);
			planForm.setListaAnhos(listaAnhos);
			planForm.setListaPresup(listaPresup);

			if (listaPlanes.size() > 0) {
				planForm.setIndMostrar("1");
			} else {
				planForm.setIndMostrar("0");
			}

			sesion.setAttribute("listaPlanes", listaPlanes);
			sesion.setAttribute("listaOficina", listaOficina);
			sesion.setAttribute("listaAnhos", listaAnhos);
			sesion.setAttribute("listaPresup", listaPresup);
			sesion.setAttribute("mesEvalMostrar", mesEvalMostrar);
			sesion.setAttribute("mesEvalMostrarAnte", mesEvalMostrarAnte);
			sesion.setAttribute("indMostrar", planForm.getIndMostrar());

			log.info("[PlaneacionAction :: imprimir] Fin");
		} catch (Exception e) {
			log.error("[PlaneacionAction :: imprimir] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id")); //$NON-NLS-2$
			sesion.setAttribute("indMostrar", "0");
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else {
			forward = mapping.findForward("imprimir");
		}

		return (forward);
	}

	public static String[] getArrayStrings(String cadena, String delim) {
		log.info("[PlaneacionAction :: getArrayStrings] Inicio");

		if (isStringBlank(cadena)) {
			log.info("[PlaneacionAction :: getArrayStrings] Fin");
			return new String[0];
		}

		StringTokenizer st = new StringTokenizer(cadena, delim);
		String[] array = new String[st.countTokens()];
		int indice = 0;
		while (st.hasMoreTokens()) {
			array[indice] = st.nextToken();
			indice++;
		}

		log.info("[PlaneacionAction :: getArrayStrings] Fin");

		return array;
	}

	public static boolean isStringBlank(String cadena) {
		log.info("[PlaneacionAction :: isStringBlank] Inicio");

		boolean b = false;
		if (cadena == null || cadena.trim().length() == 0)
			b = true;

		log.info("[PlaneacionAction :: getArrayStrings] Fin");

		return b;
	}

	public ActionForward inicioCarga(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("carga");
	}

	public ActionForward inicioCargaEpigrafe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("cargaEpigrafe");
	}

	private String getRutaArchivo() {
		String pathArchivo = "";

		log.info("[PlaneacionAction :: getRutaArchivo] Inicio");

		if (conexion.findByCodMulti("T12") != null) {
			pathArchivo = ((Multitabla) conexion.findByCodMulti("T12")
					.elementAt(0)).getValor1();
		}

		log.info("[PlaneacionAction :: getRutaArchivo] Fin");

		return pathArchivo;
	}

	private void cargarArchivo(FormFile ff, String pathArchivo)
			throws IOException {
		// Carga del archivo
		String data = new String(ff.getFileData());

		log.info("[PlaneacionAction :: cargarArchivo] Inicio");
		log.info("[PlaneacionAction :: cargarArchivo] Se escribe archivo " + ff.getFileName() + " a " + pathArchivo);

		FileOutputStream fos = new java.io.FileOutputStream(pathArchivo + ff.getFileName());
		Writer out = new OutputStreamWriter(fos);
		out.write(data);
		out.close();

		log.info("[PlaneacionAction :: cargarArchivo] Fin");
	}

	public ActionForward borrarPlanes(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession sesion = request.getSession(false);
		Gestor gestor = (Gestor) sesion.getAttribute("gestor");

		log.info("[PlaneacionAction :: borrarPlanes] Inicio");

		forward = mapping.findForward("carga");
		String sCadena;
		String valorDato;
		boolean rst = false;
		String cValorCuadro = "0";
		rst = conexion.borrarPlanIngresado(gestor.getCodigoGestor());

		log.info("[PlaneacionAction :: borrarPlanes] Fin");

		return (forward);
	}

	public ActionForward borrarEpigrafe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("[PlaneacionAction :: borrarEpigrafe] Inicio");

		forward = mapping.findForward("cargaEpigrafe");
		conexion.borrarEpigrafe();

		log.info("[PlaneacionAction :: borrarEpigrafe] Fin");

		return (forward);
	}

	public ActionForward inicioCargaMaestro(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("cargaMaestro");
	}

	public ActionForward borrarMaestro(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("[PlaneacionAction :: borrarMaestro] Inicio");

		forward = mapping.findForward("cargaMaestro");
		conexion.borrarMaestro();

		log.info("[PlaneacionAction :: borrarMaestro] Fin");
		return (forward);
	}

	public ActionForward historial(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		// Connection conexion = new Connection();
		forward = mapping.findForward("resumen");
		Vector listaOficina = null;
		Vector listaPresup = null;
		Vector listaMeses = null;
		Vector listaAnhos = null;
		String mesEvaluacion = "12";
		Vector listaPlanes = null;
		Vector listaTablaPlanes = null;
		Vector listaGestores = null;
		MaestroPlan maestro = null;
		PlaneacionForm planForm = (PlaneacionForm) form;
		Multitabla mul = null;
		String mesEvalMostrar = "";
		String mesEvalMostrarAnte = "";
		UtilListas utilList = new UtilListas();
		HttpSession sesion = null;
		Gestor gestor = null;
		String anho = null;
		String mes = null;
		String codOficina = null;

		try {
			log.info("[PlaneacionAction :: historial] Inicio");

			sesion = request.getSession(false);

			mul = conexion.findMultiByPrimaryKey("T02", "1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());

			listaAnhos = utilList.obtenerListAnhos(anhoBase, rango);
			gestor = (Gestor) sesion.getAttribute("gestor");

			String presuReferencia, fechita = "";
			presuReferencia = planForm.getPreReferencia();

			ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
			if(defecto.isCargarPorDefecto()){
				anho = defecto.getAnho();
				mes = defecto.getMes();
				codOficina = defecto.getOficina();
			}else{
				anho = request.getParameter("anho");
				codOficina = request.getParameter("codOficina");
			}
			
			/*
			if (sesion.getAttribute("planesFormu") != null) {
				anho = (String) sesion.getAttribute("planesFormuAnho");
				mes = (String) sesion.getAttribute("planesFormuMes");
				codOficina = (String) sesion
						.getAttribute("planesFormuCodOficina");

				sesion.removeAttribute("planesFormu");
				sesion.removeAttribute("planesFormuAnho");
				sesion.removeAttribute("planesFormuMes");
				sesion.removeAttribute("planesFormuCodOficina");
			} else {
				if (sesion.getAttribute("planesResuFormu") != null) {
					anho = (String) sesion.getAttribute("planesResuFormuAnho");
					mes = (String) sesion.getAttribute("planesResuFormuMes");
					codOficina = (String) sesion
							.getAttribute("planesResuFormuCodOficina");

					sesion.removeAttribute("planesResuFormu");
					sesion.removeAttribute("planesResuFormuAnho");
					sesion.removeAttribute("planesResuFormuMes");
					sesion.removeAttribute("planesResuFormuCodOficina");
				} else {
					if (sesion.getAttribute("objeFormu") != null) {
						anho = (String) sesion.getAttribute("objeFormuAnho");
						mes = (String) sesion.getAttribute("objeFormuMes");
						codOficina = (String) sesion
								.getAttribute("objeFormuCodOficina");

						sesion.removeAttribute("objeFormu");
						sesion.removeAttribute("objeFormuAnho");
						sesion.removeAttribute("objeFormuMes");
						sesion.removeAttribute("objeFormuCodOficina");
					} else {
						anho = request.getParameter("anho");
						codOficina = request.getParameter("codOficina");
					}
				}
			}
			*/
			
			if (anho == null) {
				Calendar calendario = Calendar.getInstance();
				Date fecha = calendario.getTime();
				mes = sdfMes.format(fecha);
				anho = sdfAnho.format(fecha);
			}

			Calendar calendario = Calendar.getInstance();
			mes = sdfMes.format(calendario.getTime());

			// listaPresup = utilList.obtenerListPresup(mes,
			// gestor.getCodigoPerfil());
			int mesReferencia = conexion.findMesesReferencia(Integer.parseInt(mes), Integer.parseInt(anho));
			if (mesReferencia > 0) {
				listaPresup = new Vector();
				Multitabla multi = new Multitabla();
				ConstantesUtil constantesUtil = new ConstantesUtil();

				multi.setCodelem(String.valueOf(mesReferencia));
				multi.setValor1(constantesUtil.litMes(mesReferencia));

				listaPresup.add(multi);

				presuReferencia = multi.getCodelem();
			} else {
				Multitabla multi = new Multitabla();
				listaPresup = new Vector();
				ConstantesUtil constantesUtil = new ConstantesUtil();

				int nuevoMesReferencia = 0;
				if (mes != null) {
					if (Integer.parseInt(mes) > 6) {
						nuevoMesReferencia = 12;
					} else {
						nuevoMesReferencia = 6;
					}
				} else {
					nuevoMesReferencia = 12;
				}

				multi.setCodelem(String.valueOf(nuevoMesReferencia));
				multi.setValor1(constantesUtil.litMes(nuevoMesReferencia));
				listaPresup.add(multi);
			}

			if (gestor.getCodigoPerfil().equals("GTE")
					|| gestor.getCodigoPerfil().equals("JPR")) {
				listaOficina = conexion.findAllOficinaByCodTerri(gestor
						.getCodigoTerritorio());
			} else {
				if (gestor.getCodigoPerfil().equals("CON") 
						|| gestor.getCodigoPerfil().equals("ADM")
						|| gestor.getCodigoPerfil().equals("SUP")) {
					listaOficina = conexion.findAllOficinas();
				} else {
					codOficina = gestor.getCodigoOficina();
					listaOficina = conexion.findListaByCodOficina(gestor.getCodigoOficina());
				}
			}

			mesEvalMostrarAnte = utilList.obtenerNomMesAnterior(mes);
			mesEvalMostrar = utilList.obtenerNomMes(mes);
			planForm.setAnho(anho);
			planForm.setMesPlanificacion(mes);
			planForm.setCodOficina(codOficina);
			planForm.setPreReferencia(presuReferencia);

			listaPlanes = conexion.findPlanAnual(anho, codOficina);
			listaTablaPlanes = conexion.findConsultarPlanesxMes(codOficina, anho);
			planForm.setListaPlanes(listaPlanes);
			planForm.setListaOficina(listaOficina);
			planForm.setListaAnhos(listaAnhos);
			planForm.setListaPresup(listaPresup);

			if (listaPlanes.size() > 0) {
				planForm.setIndMostrar("1");
			} else {
				planForm.setIndMostrar("0");
			}

			sesion.setAttribute("listaPlanes", listaPlanes);
			sesion.setAttribute("listaOficina", listaOficina);
			sesion.setAttribute("listaAnhos", listaAnhos);
			sesion.setAttribute("listaPresup", listaPresup);
			sesion.setAttribute("mesEvalMostrar", mesEvalMostrar);
			sesion.setAttribute("mesEvalMostrarAnte", mesEvalMostrarAnte);
			sesion.setAttribute("indMostrar", planForm.getIndMostrar());

			/*
			sesion.setAttribute("planesHistFormu", "1");
			sesion.setAttribute("planesHistFormuAnho", anho);
			sesion.setAttribute("planesHistFormuCodOficina", codOficina);
			 */
			
			log.info("[PlaneacionAction :: historial] Fin");
		} catch (Exception e) {
			log.error("[PlaneacionAction :: historial] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
			sesion.setAttribute("indMostrar", "0");
		}

		RegistraValorDefecto.getInstancia().registrar(request, anho, mes, codOficina);
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("historial");
		} else {
			forward = mapping.findForward("historial");
		}

		return (forward);
	}

	public ActionForward cargaData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int nTotal = 0;
		int nTotalBien = 0;
		int nErrorWhen = 0;
		int nError = 0;
		int nTotalError = 0;
		int nLonPlanes = -1;
		Iterator iter = null;
		ArrayList listaEpigrafe = null;
		HttpSession sesion = request.getSession(false);
		Gestor gestor = (Gestor) sesion.getAttribute("gestor");
		// forwar en caso exito u error
		forward = mapping.findForward("carga");
		String pathArchivo = getRutaArchivo();
		PlaneacionForm formBeanCarga = (PlaneacionForm) form;
		FormFile formFile = formBeanCarga.getFileInput();

		log.info("[PlaneacionAction :: cargaData] Inicio");

		cargarArchivo(formFile, pathArchivo);
		// Lectura del archivo
		log.info("[PlaneacionAction :: cargaData] Se lee archivo "
				+ formFile.getFileName() + " de " + pathArchivo);

		FileReader fr = new FileReader(pathArchivo + formFile.getFileName());
		BufferedReader bf = new BufferedReader(fr);
		String sCadena = bf.readLine();
		nLonPlanes = sCadena.length();
		Map map = new HashMap();

		// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
		int registrosOk = 0;
		int registrosErr = 0;
		int registrosTotal = 0;
		int cargadosOk = 0;
		int cargadosErr = 0;
		int nulosErr = 0;
		int totalOk = 0;
		int totalErr = 0;
		int total = 0;
		long nroLinea = 1;

		Map mapaResumenEpig = new HashMap();

		String rutaArchivo = "/mnt/compartido/iido/uti/jsp/CargaPlanes.log";
		String texto = "";
		String saltoLinea = "\r\n";
		OutputStream fichero = new FileOutputStream(rutaArchivo);
		// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

		while (sCadena != null) // && nLonPlanes > 1)
		{
			boolean addResumen = true;
			Plan plan = new Plan();
			// nTotal++;
			String[] _valorLinea = UtilListas.getArrayStrings(sCadena, ",");
			int nNum = _valorLinea.length;

			if (nNum == 26) {
				registrosOk++;

				// Validando si los Campos Principales son nulos o en blanco
				if ((_valorLinea[0].trim().length() == 0)
						|| (_valorLinea[3].trim().length() == 0)
						|| (_valorLinea[17].trim().length() == 0)) {
					// nError++;
					texto = texto + "Nro. Linea: " + String.valueOf(nroLinea) + " - Valores nulos." + saltoLinea;
					nulosErr++;
				} else {
					// (2011.02.04) Tratar de obtener territorio de la base de datos
					try {
						Oficina beanBD = conexion.findByCodOficina(_valorLinea[3]);
						if (beanBD != null && beanBD.getTerr() != null) {
							_valorLinea[17] = beanBD.getTerr().getCodTerr();
						}
					} catch (Throwable e) {
						e.printStackTrace();
						log.error("[PlaneacionAction :: cargaData] Error al intentar obtener codigo de territorio de la tabla");
					}

					plan.setCodEpigrafe(_valorLinea[0]);
					plan.setNomEpigrafe(_valorLinea[1]);
					plan.setPesoDor(new BigDecimal(_valorLinea[2].trim()));
					plan.setCodOficina(_valorLinea[3]);
					plan.setMes(_valorLinea[4]);
					plan.setAnho(_valorLinea[5]);
					plan.setMonto(UtilListas.tramaToBigDecimal(_valorLinea[6].trim(), 2));
					plan.setPorAlcanzado(UtilListas.tramaToBigDecimal(_valorLinea[7].trim(), 2));
					plan.setDesvPpto(UtilListas.tramaToBigDecimal(_valorLinea[8].trim(), 2));
					plan.setNroMesesFalt(UtilListas.tramaToBigDecimal(_valorLinea[9].trim(), 2));
					plan.setProyCrecMens(UtilListas.tramaToBigDecimal(_valorLinea[10].trim(), 2));
					plan.setAjusEstiTerr(UtilListas.tramaToBigDecimal(_valorLinea[11].trim(), 2));
					plan.setProyAjusMens(UtilListas.tramaToBigDecimal(_valorLinea[12].trim(), 2));
					plan.setSaldMediJunio(UtilListas.tramaToBigDecimal(_valorLinea[13].trim(), 2));
					plan.setPorcSaldMedJun(UtilListas.tramaToBigDecimal(_valorLinea[14].trim(), 2));
					plan.setSaldDiciAnter(UtilListas.tramaToBigDecimal(_valorLinea[15].trim(), 2));
					plan.setSaldMediDici(UtilListas.tramaToBigDecimal(_valorLinea[16].trim(), 2));
					plan.setCodTerritorio(_valorLinea[17]);
					plan.setPorcSaldMedDic(UtilListas.tramaToBigDecimal(_valorLinea[18].trim(), 2));
					plan.setFactAjusSaldPunt(UtilListas.tramaToBigDecimal(_valorLinea[19].trim(), 8));
					plan.setHistBajas(UtilListas.tramaToBigDecimal(_valorLinea[20].trim(), 2));
					plan.setMetaMesSaldPunt(UtilListas.tramaToBigDecimal(_valorLinea[21].trim(), 2));
					plan.setMetaGereOficina(UtilListas.tramaToBigDecimal(_valorLinea[22].trim(), 2));
					plan.setPrioridad(UtilListas.tramaToBigDecimal(_valorLinea[23].trim(), 0));
					plan.setMesEval(_valorLinea[24]);
					plan.setIndDor(_valorLinea[25]);
					plan.setUsuario(gestor.getCodigoGestor());
					// Insertando el Registro a la Tabla Planes
					
					conexion.validaPeriodo(plan.getAnho());
					boolean rst = conexion.createUpdatePlan(plan);
					
					if (rst == false) {
						texto = texto + "Nro. Linea: "
								+ String.valueOf(nroLinea)
								+ " Error al guardar - Epigrafe: "
								+ plan.getNomEpigrafe() + " - Oficina: "
								+ plan.getCodOficina() + saltoLinea;
						cargadosErr++;
						addResumen = false;
					} else {
						cargadosOk++;
					}
					// Resumen
					Double saldMediDici = plan.getSaldMediDici() != null ? new Double(
							plan.getSaldMediDici().doubleValue())
							: new Double(0);
					Double saldMediJunio = plan.getSaldMediJunio() != null ? new Double(
							plan.getSaldMediJunio().doubleValue())
							: new Double(0);
					Double factAjustSaldPunt = plan.getFactAjusSaldPunt() != null ? new Double(plan.getFactAjusSaldPunt().doubleValue()) : new Double(0);
					Double newMonto = plan.getMonto() != null ? new Double(plan.getMonto().doubleValue()) : new Double(0);
					Double saldDiciAnter = plan.getSaldDiciAnter() != null ? new Double(plan.getSaldDiciAnter().doubleValue()) : new Double(0);
					String nombreEpigrafe = plan.getNomEpigrafe();
					String codEpigrafe = plan.getCodEpigrafe();

					if (saldMediDici.doubleValue() <= 0
							|| saldMediJunio.doubleValue() <= 0
							|| factAjustSaldPunt.doubleValue() <= 0
							|| newMonto.doubleValue() <= 0
							|| saldDiciAnter.doubleValue() <= 0) {
						if (map.containsKey(codEpigrafe)) {
							Epigrafe e = (Epigrafe) map.get(codEpigrafe);
							e.setListaCodOficina(e.getListaCodOficina() + ", "
									+ plan.getCodOficina());
							map.put(codEpigrafe, e);
						} else {
							Epigrafe e = new Epigrafe();
							e.setCodEpigrafe(codEpigrafe);
							e.setNomEpigrafe(nombreEpigrafe);
							e.setListaCodOficina(plan.getCodOficina());
							map.put(codEpigrafe, e);
						}
					} else {
						if (!map.containsKey(codEpigrafe)) {
							Epigrafe e = new Epigrafe();
							e.setCodEpigrafe(codEpigrafe);
							e.setNomEpigrafe(nombreEpigrafe);
							e.setListaCodOficina("");
							map.put(codEpigrafe, e);
						}
					}

					// Nuevo resumen Epigrafe
					if (addResumen) {
						if (mapaResumenEpig.containsKey(codEpigrafe)) {
							Epigrafe beanEpig = (Epigrafe) mapaResumenEpig
									.get(codEpigrafe);
							beanEpig.setPorcAsignado(BigDecimal
									.valueOf(beanEpig.getPorcAsignado()
											.doubleValue()
											+ plan.getMonto().doubleValue()));
							map.put(codEpigrafe, beanEpig);
						} else {
							Epigrafe beanEpig = new Epigrafe();
							beanEpig.setCodEpigrafe(codEpigrafe);
							beanEpig.setNomEpigrafe(nombreEpigrafe);
							beanEpig.setPorcAsignado(plan.getMonto());
							mapaResumenEpig.put(codEpigrafe, beanEpig);
						}
					}

				}
			} else {
				texto = texto + "Nro. Linea: " + String.valueOf(nroLinea)
						+ " - Linea en blanco o con valores invalidos"
						+ saltoLinea;
				registrosErr++;
			}

			sCadena = bf.readLine();
			nroLinea++;
		}

		if(texto.length()==0) {
			texto="Carga de planes OK";
		}
		
		fichero.write(texto.getBytes());
		fichero.flush();
		fichero.close();

		registrosTotal = registrosOk + registrosErr;
		totalOk = cargadosOk;
		totalErr = cargadosErr + nulosErr;
		total = totalOk + totalErr;

		sesion.setAttribute("registrosOkPlanes", String.valueOf(registrosOk));
		sesion.setAttribute("registrosErrPlanes", String.valueOf(registrosErr));
		sesion.setAttribute("registrosTotalPlanes", String.valueOf(registrosTotal));
		sesion.setAttribute("cargadosOkPlanes", String.valueOf(cargadosOk));
		sesion.setAttribute("cargadosErrPlanes", String.valueOf(cargadosErr));
		sesion.setAttribute("nulosErrPlanes", String.valueOf(nulosErr));
		sesion.setAttribute("totalOkPlanes", String.valueOf(totalOk));
		sesion.setAttribute("totalErrPlanes", String.valueOf(totalErr));
		sesion.setAttribute("totalPlanes", String.valueOf(total));

		request.setAttribute("mostrarResumen", new Boolean(true));

		iter = map.values().iterator();
		listaEpigrafe = new ArrayList();
		while (iter.hasNext()) {
			Epigrafe e = (Epigrafe) iter.next();
			listaEpigrafe.add(e);
		}
		sesion.setAttribute("listaEpigrafe", listaEpigrafe);

		// Nuevo resumen
		iter = mapaResumenEpig.values().iterator();
		listaEpigrafe = new ArrayList();
		while (iter.hasNext()) {
			Epigrafe e = (Epigrafe) iter.next();
			listaEpigrafe.add(e);
		}
		sesion.setAttribute("resumenEpigrafe", listaEpigrafe);

		log.info("[PlaneacionAction :: cargaData] Fin");

		return (forward);
	}

	public ActionForward cargaDataEpigrafe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession sesion = request.getSession(false);
		forward = mapping.findForward("cargaEpigrafe");
		String cRutaFile = (String) request.getParameter("txtRuta");
		String pathArchivo = "";

		log.info("[PlaneacionAction :: cargaDataEpigrafe] Inicio");

		if (conexion.findByCodMulti("T12") != null) {
			pathArchivo = ((Multitabla) conexion.findByCodMulti("T12")
					.elementAt(0)).getValor1();
		}
		PlaneacionForm formBeanCarga = (PlaneacionForm) form;
		FormFile ff = formBeanCarga.getFileInput();
		String nombreArch = ff.getFileName();
		String rutaTc = pathArchivo + nombreArch;
		String data = new String(ff.getFileData());

		FileOutputStream fos = new java.io.FileOutputStream(rutaTc);
		Writer out = new OutputStreamWriter(fos);
		out.write(data);
		out.close();

		FileReader fr = new FileReader(rutaTc);
		BufferedReader bf = new BufferedReader(fr);
		String sCadena;
		String valorDato;
		boolean rst = false;
		sCadena = bf.readLine();
		int nLenCadena = sCadena.length();
		int nTotal = 0;
		int nTotalBien = 0;
		int nErrorWhen = 0;
		int nError = 0;
		int nTotalError = 0;

		int registrosOk = 0;
		int registrosErr = 0;
		int registrosTotal = 0;
		int cargadosOk = 0;
		int cargadosErr = 0;
		int nulosErr = 0;
		int totalOk = 0;
		int totalErr = 0;
		int total = 0;
		String rutaArchivo = "/mnt/compartido/iido/uti/jsp/CargaEpigrafe.log";
		String texto = "";
		String saltoLinea = "\r\n";
		OutputStream fichero = new FileOutputStream(rutaArchivo);

		while (sCadena != null) // && nLenCadena > 1)
		{
			log.info("[PlaneacionAction :: cargaDataEpigrafe] sCadena::"
					+ sCadena);

			Epigrafe epigrafe = new Epigrafe();

			String[] _valorLinea = UtilListas.getArrayStrings(sCadena, ",");
			int nNum = _valorLinea.length;
			log
					.info("[PlaneacionAction :: cargaDataEpigrafe] Numero de Registros::"
							+ nNum);

			if (nNum == 8) {
				// nTotal++;
				registrosOk++;

				if ((_valorLinea[0].trim().length() == 0)
						|| (_valorLinea[1].trim().length() == 0)
						|| (_valorLinea[2].trim().length() == 0)) {
					texto = texto + "Valores nulos" + saltoLinea;
					nulosErr++;
				} else {
					// Ingresando los registros Seleccionados
					epigrafe.setCodEpigrafe(_valorLinea[0].trim());
					epigrafe.setNomEpigrafe(_valorLinea[1].trim());
					epigrafe.setAnho(_valorLinea[2]);
					epigrafe.setIndClase(_valorLinea[3]);
					epigrafe.setIndSubClase(_valorLinea[4]);
					epigrafe.setOrden(_valorLinea[5]);
					epigrafe.setIndHijo(_valorLinea[6]);
					epigrafe.setIndAfecta(_valorLinea[7]);
					// Insertando el Registro a la Tabla Planes
					conexion.validaPeriodo(epigrafe.getAnho());
					rst = conexion.createEpigrafe(epigrafe);

					if (!rst) {
						texto = texto + "Error al guardar" + saltoLinea;
						cargadosErr++;
					} else {
						cargadosOk++;
					}
				}
			} else {
				texto = texto + "Registros en blanco o invalidos" + saltoLinea;
				registrosErr++;
			}

			sCadena = bf.readLine();
			// if (sCadena == null)
			// {
			// nLenCadena = 0;
			// }
			// else
			// {
			// nLenCadena = sCadena.length();
			// }
		}

		// nTotalError = nError + nErrorWhen;
		// sesion.setAttribute("nTotal", String.valueOf(nTotal));
		// sesion.setAttribute("nTotalBien", String.valueOf(nTotalBien));
		// sesion.setAttribute("nError", String.valueOf(nError));
		// sesion.setAttribute("nErrorWhen", String.valueOf(nErrorWhen));
		// sesion.setAttribute("nTotalError", String.valueOf(nTotalError));

		if(texto.length()==0) {
			texto="Carga de planes OK";
		}
		
		fichero.write(texto.getBytes());
		fichero.flush();
		fichero.close();

		registrosTotal = registrosOk + registrosErr;
		totalOk = cargadosOk;
		totalErr = cargadosErr + nulosErr;
		total = totalOk + totalErr;

		sesion.setAttribute("registrosOkEpig", String.valueOf(registrosOk));
		sesion.setAttribute("registrosErrEpig", String.valueOf(registrosErr));
		sesion.setAttribute("registrosTotalEpig", String
				.valueOf(registrosTotal));
		sesion.setAttribute("cargadosOkEpig", String.valueOf(cargadosOk));
		sesion.setAttribute("cargadosErrEpig", String.valueOf(cargadosErr));
		sesion.setAttribute("nulosErrEpig", String.valueOf(nulosErr));
		sesion.setAttribute("totalOkEpig", String.valueOf(totalOk));
		sesion.setAttribute("totalErrEpig", String.valueOf(totalErr));
		sesion.setAttribute("totalEpig", String.valueOf(total));

		request.setAttribute("mostrarResumen", new Boolean(true));

		log.info("[PlaneacionAction :: cargaDataEpigrafe] Fin");

		return (forward);
	}

	public ActionForward cargaDataMaestro(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean primeraVez = true;
		HttpSession sesion = request.getSession(false);
		Gestor gestor = (Gestor) sesion.getAttribute("gestor");

		log.info("[PlaneacionAction :: cargaDataMaestro] Inicio");

		forward = mapping.findForward("cargaMaestro");
		String cRutaFile = (String) request.getParameter("txtRuta");
		String pathArchivo = "";
		if (conexion.findByCodMulti("T12") != null) {
			pathArchivo = ((Multitabla) conexion.findByCodMulti("T12").elementAt(0)).getValor1();
		}
		PlaneacionForm formBeanCarga = (PlaneacionForm) form;
		FormFile ff = formBeanCarga.getFileInput();

		String nombreArch = ff.getFileName();
		String rutaTc = pathArchivo + nombreArch;
		String data = new String(ff.getFileData());
		FileOutputStream fos = new java.io.FileOutputStream(rutaTc);
		Writer out = new OutputStreamWriter(fos);
		out.write(data);
		out.close();

		FileReader fr = new FileReader(rutaTc);
		BufferedReader bf = new BufferedReader(fr);
		String sCadena;
		String valorDato;
		boolean rst = false;
		sCadena = bf.readLine();

		int nTotal = 0;
		int nTotalBien = 0;
		int nErrorWhen = 0;
		int nError = 0;
		int nTotalError = 0;

		// Resumen datos cargados
		int registrosOk = 0;
		int registrosErr = 0;
		int registrosTotal = 0;
		int cargadosOk = 0;
		int cargadosErr = 0;
		int nulosErr = 0;
		int totalOk = 0;
		int totalErr = 0;
		int total = 0;
		String rutaArchivo = "/mnt/compartido/iido/uti/jsp/CargaMaestro.log";
		String texto = "";
		String saltoLinea = "\r\n";
		OutputStream fichero = new FileOutputStream(rutaArchivo);

		int nLenCadena = sCadena.length();
		while (sCadena != null) // && nLenCadena > 1)
		{
			log.info("[PlaneacionAction :: cadena leida: " + sCadena);
			String[] _valorLinea = UtilListas.getArrayStrings(sCadena, ",");
			// Se debe ingresar archivos que contengan data solo de periodos que
			// no tenga data anteriormente.
			if (primeraVez
					&& conexion.existeDataMaestroPlanesMesAnio(_valorLinea[1].trim(), _valorLinea[2].trim())) {
				throw new BaseException("ERR002");
			} else {
				primeraVez = false;
			}
			int nNum = _valorLinea.length;
			log.info("[PlaneacionAction :: NÃºmero de Registros::" + nNum);

			if (nNum == 5) {
				// nTotal++;
				registrosOk++;
				if ((_valorLinea[0].trim().length() == 0)
						|| (_valorLinea[1].trim().length() == 0)
						|| (_valorLinea[2].trim().length() == 0)) {
					texto = texto + "Valores nulos" + saltoLinea;
					nulosErr++;
				} else {
					// (2011.02.04) Tratar de obtener territorio de la base de datos
					try {
						Oficina beanBD = conexion
								.findByCodOficina(_valorLinea[0]);
						if (beanBD != null && beanBD.getTerr() != null) {
							_valorLinea[3] = beanBD.getTerr().getCodTerr();
						}
					} catch (Throwable e) {
						e.printStackTrace();
						log.error("[PlaneacionAction :: cargaDataMaestro] Error al intentar obtener codigo de territorio de la tabla");
					}

					// Si no existe oficina se crea
					if (!conexion.findOficinaAndTerri(_valorLinea[3], _valorLinea[0]) && _valorLinea.length == 5) {
						conexion.nuevaOficina(_valorLinea[3], _valorLinea[0], _valorLinea[4], gestor.getCodigoGestor());
					}
					
					// Insertando el Registro a la Tabla Planes
					conexion.validaPeriodo(_valorLinea[2]);
					rst = conexion.createMaestroPlan(_valorLinea[2], _valorLinea[1], _valorLinea[0], _valorLinea[3]);
					if (rst == false) {
						cargadosErr++;
						texto = texto + "Error al guardar" + saltoLinea;
					} else {
						cargadosOk++;
					}
				}
			} else {
				texto = texto + "Registros en blanco o invalidos" + saltoLinea;
				registrosErr++;
			}

			sCadena = bf.readLine();
			// if (sCadena == null)
			// {
			// nLenCadena = 0;
			// }
			// else
			// {
			// nLenCadena = sCadena.length();
			// }
		}
		// nTotalError = nError + nErrorWhen;
		// sesion.setAttribute("nTotal", String.valueOf(nTotal));
		// sesion.setAttribute("nTotalBien", String.valueOf(nTotalBien));
		// sesion.setAttribute("nError", String.valueOf(nError));
		// sesion.setAttribute("nErrorWhen", String.valueOf(nErrorWhen));
		// sesion.setAttribute("nTotalError", String.valueOf(nTotalError));
		
		if(texto.length()==0) {
			texto="Carga de planes OK";
		}
		
		fichero.write(texto.getBytes());
		fichero.flush();
		fichero.close();

		registrosTotal = registrosOk + registrosErr;
		totalOk = cargadosOk;
		totalErr = cargadosErr + nulosErr;
		total = totalOk + totalErr;

		sesion.setAttribute("registrosOkMaes", String.valueOf(registrosOk));
		sesion.setAttribute("registrosErrMaes", String.valueOf(registrosErr));
		sesion.setAttribute("registrosTotalMaes", String.valueOf(registrosTotal));
		sesion.setAttribute("cargadosOkMaes", String.valueOf(cargadosOk));
		sesion.setAttribute("cargadosErrMaes", String.valueOf(cargadosErr));
		sesion.setAttribute("nulosErrMaes", String.valueOf(nulosErr));
		sesion.setAttribute("totalOkMaes", String.valueOf(totalOk));
		sesion.setAttribute("totalErrMaes", String.valueOf(totalErr));
		sesion.setAttribute("totalMaes", String.valueOf(total));

		request.setAttribute("mostrarResumen", new Boolean(true));

		log.info("[PlaneacionAction :: cargaDataMaestro] Fin");

		return (forward);
	}

}