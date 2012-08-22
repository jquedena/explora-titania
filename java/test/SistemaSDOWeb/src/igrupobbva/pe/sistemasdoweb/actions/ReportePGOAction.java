package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.ReportePGOForm;
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

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Firmas;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.ListaReportePGO;
import com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG;
import com.grupobbva.bc.per.tele.sdo.serializable.Seguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings({"unchecked", "unused"})
public class ReportePGOAction extends DispatchAction{
	private static Logger log = Logger.getLogger(ReportePGOAction.class);
	
	private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private SimpleDateFormat sdfAnho = new SimpleDateFormat("yyyy");
	private SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
	private SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
	
	public ActionForward inicioReportePGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		Connection conexion = new Connection();
		forward = mapping.findForward("conDato");		
		Vector listaOficina = null;		
		Vector listaAnhos = null;		
		Vector listaPlanes = null;
		Vector listaCampDetalle = null;	
		ReportePGOForm reportPGOForm = (ReportePGOForm) form;
		Multitabla mul = null;
		String codigoGestor;			
		UtilListas utilList = new UtilListas();
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[ReportePGOAction :: inicioReportePGO] Inicio");
			
			sesion = request.getSession(false);
			
			mul = conexion.findMultiByPrimaryKey("T02","1");
			String anhoBase = mul.getValor1();
			String indicador = "1";
			int rango = Integer.parseInt(mul.getValor2());
			listaAnhos = utilList.obtenerListAnhos(anhoBase,rango);
			
			gestor = (Gestor) sesion.getAttribute("gestor");		 
			codigoGestor = gestor.getCodigoGestor();
			String anho = null , mes= null, codOficina = null, presuReferencia= null;		
			Calendar calendario = Calendar.getInstance();
			Date fecha = calendario.getTime();

			mes = sdfMes.format(fecha);
			anho = sdfAnho.format(fecha);			
			codOficina = gestor.getCodigoOficina();			
			
			if(gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")){
				listaOficina = 	conexion.findAllOficinaByCodTerri(gestor.getCodigoTerritorio());
			}else{
				if(gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP") ){
					listaOficina = conexion.findAllOficinas();	
				}else{
					listaOficina = conexion.findListaByCodOficina(gestor.getCodigoOficina());
				}
			}
			
			java.util.Date fechaCalendario = calendario.getTime();
			try {
				fechaCalendario = sdf.parse(sdf.format(fechaCalendario));
			} catch (ParseException pe) {
				pe.printStackTrace();
			}
			
			Firmas firma = null;
			String fechaActual = anho + mes;
			String fCalendario = sdfAnho.format(fechaCalendario)
					+ sdfMes.format(fechaCalendario);
			
			if (!(gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")) 
					&& (!gestor.getCodigoPerfil().equals("GTE"))){
				try{
					if (Integer.parseInt(fechaActual) == Integer.parseInt(fCalendario)) {
						firma = conexion.findFirmByAnoMesCgesItem(anho,mes,codigoGestor,"00000001");
						if (!firma.getItemFirma().equals("00000001")) {
							forward = mapping.findForward("sinDato");
							indicador = "0";
						}
					}	
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(indicador.equals("1")){
				Gestor gestores = utilList.buscarGestor(codigoGestor);
				Vector listaGestores = utilList.listarGestoresNormal(codOficina);
				
				listaPlanes = conexion.consultarPLanesAccion(codOficina, mes, anho, codigoGestor);
				listaCampDetalle = conexion.consultarCampaniasDetalles(codOficina, mes, anho, codigoGestor);
				sesion.setAttribute("listaPlanesAcciones", listaPlanes);
				sesion.setAttribute("listaCampanias", listaCampDetalle);
			}
			reportPGOForm.setAnho(anho);
			reportPGOForm.setMes(mes);
			reportPGOForm.setCodOficina(codOficina);
	
			if(listaPlanes!=null){
				if(listaPlanes.size()>0){
					forward = mapping.findForward("conDato");
				}
				else{
					forward = mapping.findForward("conDato");
				}
			}
			sesion.setAttribute("listaPlanes", listaPlanes);
			sesion.setAttribute("gestor", gestor);
			sesion.setAttribute("listaOficina", listaOficina);
			sesion.setAttribute("listaAnhos", listaAnhos);
			
			log.info("[ReportePGOAction :: inicioReportePGO] Fin");
		} catch (Exception e) {
			log.error("[ReportePGOAction :: inicioReportePGO] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			errors.add("name", new ActionError("id"));			
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);			 
		} 

		return (forward);
	}
	
	public ActionForward inicioReportePGOResumen(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
	 		ActionErrors errors = new ActionErrors();
        	ActionForward forward = new ActionForward();
        	Connection ejb = new Connection();     
        	ReportePPG bean=null;
        	ListabusAllTerritorio bean1=null;
        	HttpSession sesion = null;
        	Gestor gestor = null;
        	
        	try {
        		log.info("[ReportePGOAction :: inicioReportePGOResumen] Inicio");
        		
        		sesion = request.getSession(false);
        		gestor = (Gestor)sesion.getAttribute("gestor"); 
        		
        		String CodigoUsuario = gestor.getNombreGestor();
	        	String codMes=null;
	        	String codAnho=null;  
	        	String codGestor=CodigoUsuario;        	
	        	String codOficina=null;
	        	
				ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
				if(defecto.isCargarPorDefecto()){
					codAnho = defecto.getAnho();
					codMes = defecto.getMes();
					codOficina = defecto.getOficina();
				}else{
					codAnho = request.getParameter("codAnho");
					codMes = request.getParameter("codMes");
				}
	        	
				if(codOficina == null) {
					codOficina = gestor.getCodigoOficina();
				}
				
	        	Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
	        	String codTerritorio = "";
	        	String nomTerritorio = "";
	        	if(terr != null) {
	        		codTerritorio = terr.getCodTerr();
	        		nomTerritorio = terr.getNomTerr();
	        	}
	        	
	        	if(request.getParameter("cmbTerritorio")!=null) {
	        		codTerritorio = request.getParameter("cmbTerritorio");
	        	}
        	
	        	Vector rel=null;
	        	Vector listaTerritorio = null;
				
				Calendar calendario = Calendar.getInstance();
				Date fecha = calendario.getTime();
				
				if(codMes == null) {
					codMes = sdfMes.format(fecha);
				}
				
				if(codAnho == null) {
					codAnho = sdfAnho.format(fecha);
				}		
			
				String codTerritorioLDAP = codTerritorio;
				
	    		// Territorio
				if(gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")){			
					listaTerritorio = ejb.busAllTerritorio();	
					if(codTerritorioLDAP == null) {
						if(listaTerritorio != null && listaTerritorio.size() > 0) {
							codTerritorioLDAP = ((ListabusAllTerritorio)listaTerritorio.get(0)).getCodTerritorio();						
						}
					}
				} 
				
				rel = ejb.reportePGOResumenxAnioMes(codTerritorioLDAP, codMes, codAnho);
				
				// Buscando el primer epigrafe
				Vector listEpigrafeLDAP = null;
				String codOficinaLDAP = null;
				Gestor gestorLDAP = null;
				Epigrafe epigrafeLDAP = null;
				String codEpiLDAP = null;
				UtilListas utilListLDAP = new UtilListas();
				
				if(rel != null && rel.size() > 0) {
					gestorLDAP = (Gestor) rel.get(0);
					codOficinaLDAP = gestorLDAP.getCodigoOficina();
					
					if(codOficinaLDAP != null) {
						listEpigrafeLDAP = ejb.findEpigrafesinPlanes(codOficinaLDAP, codAnho, codMes);
						// si no hay epigrafes en el mes, buscar del anterior mes
						if(listEpigrafeLDAP == null || (listEpigrafeLDAP != null && listEpigrafeLDAP.size() == 0)) {
							String anteriorMes = codMes;
							String anteriorAnio = codAnho;						
							
							if(Integer.parseInt(anteriorMes) == 1) {
								codMes = "12";
								anteriorAnio = String.valueOf(Integer.parseInt(anteriorAnio) - 1);
							} else {
								anteriorMes = String.valueOf(Integer.parseInt(anteriorMes) - 1);
							}
							
							listEpigrafeLDAP = ejb.findEpigrafesinPlanes(codOficinaLDAP, anteriorAnio, anteriorMes);
						}					
						
						if(listEpigrafeLDAP != null && listEpigrafeLDAP.size() > 0) {
							epigrafeLDAP = (Epigrafe)listEpigrafeLDAP.get(0);
							if(epigrafeLDAP != null) {
								codEpiLDAP = epigrafeLDAP.getCodEpigrafe(); 
							}						
						}
					}
					
					if(codEpiLDAP != null && rel != null) {
						Iterator iter = rel.iterator();
						
						int gestoresTotal = 0;
						int ingresosTotal = 0;
						int pendientesTotal = 0;
						for(int i = 0; i < rel.size() - 1; i++) {
							Gestor g = (Gestor)rel.get(i);
							Vector v = utilListLDAP.listarGestores(g.getCodigoOficina(), codEpiLDAP, codMes, codAnho);
							
							// Gestores de las Oficinas hijas
							Vector listaEpigrafes = ejb.findEpigrafesinPlanes(g.getCodigoOficina(), codAnho, codMes);			
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
							
							Vector listaOficinaHija = ejb.findHijas(g.getCodigoOficina());
							if(listaOficinaHija != null) {
								Iterator iterHijas = listaOficinaHija.iterator();
								Vector listaGestoresHijas = null;
								
								if(v == null) {
									v = new Vector();
								}
								
								while(iterHijas.hasNext()) {
									OficinaHija oficinaHija = (OficinaHija)iterHijas.next();
									if(oficinaHija != null) {
										listaGestoresHijas = utilListLDAP.listarGestores(oficinaHija.getCodigoOficinaHija(), codEpigrafe, codMes, codAnho);								
										if(listaGestoresHijas != null) {
											Iterator iterListaGestoresHijas = listaGestoresHijas.iterator();
											
											while(iterListaGestoresHijas.hasNext()) {
												Gestor gestor1 = (Gestor)iterListaGestoresHijas.next();
												BigDecimal monto = ejb.buscarMontoGestor(gestor1.getCodigoGestor(), codEpigrafe, codAnho, g.getCodigoOficina(), codMes);
												if(gestor1.getMetaGestor() == null) {
													MetasGestor metasGestor = new MetasGestor();
													gestor1.setMetaGestor(metasGestor);																						
												} 
												gestor1.setPorcAsignado(monto);
												gestor1.getMetaGestor().setPorcAsignado(monto);
											}
										}
										
										
										if(listaGestoresHijas != null) {
											v.addAll(listaGestoresHijas);	
										}
									}
								}
							}
							
							int ingresos = 0;
							
							if(v != null) {
								ingresos = v.size();
							}
							
							g.setTotalGestores(ingresos);
							g.setTotalpendientes(ingresos - g.getTotalIngresos());
							
							gestoresTotal += g.getTotalGestores();
							ingresosTotal += g.getTotalIngresos();
							pendientesTotal += g.getTotalpendientes();
						}
						
						Gestor g = (Gestor)rel.get(rel.size() - 1);
						if(g != null) {
							g.setSumtotalGestores(gestoresTotal);
							g.setSumtotalIngresos(ingresosTotal);
							g.setSumtotalPendientes(pendientesTotal);
						}
					}
				}
	
	        	Multitabla mul = null;			
	    		UtilListas utilList = new UtilListas();
	    		
	    		mul = ejb.findMultiByPrimaryKey("T02","1");
	    		String anhoBase = mul.getValor1();
	    		int rango = Integer.parseInt(mul.getValor2());		
	    		Vector rel2= utilList.obtenerListAnhos(anhoBase,rango);       	
	    		
	        	request.setAttribute("listaReportePGOResumen",rel);
	        	request.setAttribute("listaAnhos",rel2);
	        	request.setAttribute("codAnhoReturn",codAnho);
	        	request.setAttribute("codMesReturn",codMes);
	        	request.setAttribute("codTerritorioReturn",codTerritorio); // codTerritorioLDAP
	        	request.setAttribute("nomTerritorio",nomTerritorio);
	        	request.setAttribute("listaTerritorio",listaTerritorio);
	        		        	
	        	log.info("[ReportePGOAction :: inicioReportePGOResumen] Fin");
        	} catch(Exception e) {
        		log.error("[ReportePGOAction :: inicioReportePGOResumen] ");
        		ConstantesUtil.mostrarMensajeExcepcion(e);
        	}
        	
	        if (!errors.isEmpty()) {
	            saveErrors(request, errors);
	            forward = mapping.findForward("error");
	        } else {
	            forward = mapping.findForward("resumen");	        
	        }       	         

	        return (forward);        	        
	 }
        	
	public ActionForward reportePGO(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
			IILDPeUsuario usuario = null;
	 		ActionErrors errors = new ActionErrors();
        	ActionForward forward = new ActionForward();
        	Connection ejb = new Connection();
        	GestorPerfil codPerfil= new GestorPerfil();
        	HttpSession sesion = null;
        	Gestor gestor = null;
    		Multitabla mul = null;
    		UtilListas utilList = new UtilListas();
			String codMes = null;
			String codAnho = null;
			String codOficina = null;
			
        	try {
        		log.info("[ReportePGOAction :: reportePGO] Inicio");
        		
        		sesion = request.getSession(false);
        		gestor = (Gestor) sesion.getAttribute("gestor");
        		String CodigoUsuario = gestor.getCodigoGestor(); 
        		String nomGestor = gestor.getNombreGestor();
				// 201206053 - Por validacion de perfiles
	        	String perfil = codPerfil.buscarGestor(CodigoUsuario).getPerfilMostrar();
				
				ValorDefecto defecto = RegistraValorDefecto.getInstancia().leer(request);
				if(defecto.isCargarPorDefecto()){
					codAnho = defecto.getAnho();
					codMes = defecto.getMes();
					codOficina = defecto.getOficina();
					
					if(request.getParameter("oficinaCompleto") != null){
						if(request.getParameter("oficinaCompleto").length() > 0) {
							codOficina = request.getParameter("oficinaCompleto");
						}
					}
				}else{
					codAnho = request.getParameter("codAnho");
					codMes = request.getParameter("codMes");
					codOficina = request.getParameter("oficinaCompleto");
				}
				
        		Calendar calendario = Calendar.getInstance();
    			Date fecha = calendario.getTime();
    			
    			if(codMes == null) {
    				codMes = sdfMes.format(fecha);
    			}
    			
    			if(codAnho == null) {
    				codAnho = sdfAnho.format(fecha);
    			}	
	        	
    			if(codOficina == null) {
    				String oficinaCompleto=null;
            		oficinaCompleto=request.getParameter("oficinaCompleto");
            		if(oficinaCompleto!=null) {
	            		String ofic[]=oficinaCompleto.split("-");
	                	codOficina=ofic[0];
            		} else {
            			codOficina = gestor.getCodigoOficina();
            		}
    			}	
    			
	        	// Territorio terr = ejb.findTerritorioByCodOficina(gestor.getCodigoOficina());
    			Territorio terr = ejb.findTerritorioByCodOficina(codOficina);
	        	String codTerritorio = "";
	        	String nomTerritorio = "";
	        	if(terr != null) {
	        		codTerritorio = terr.getCodTerr();
	        		nomTerritorio = terr.getNomTerr() != null ? terr.getNomTerr() : "";
	        	}
	        	
	        	Campanias bean=null;
	        	ReportePPG bean1=null;
	        	ListaReportePGO bean2=null;
	        	Vector newListaOficina = null;
	        	
	        	if(request.getParameter("oficinaCompleto")==null){
	        		
	    			mul = ejb.findMultiByPrimaryKey("T02","1");
	    			String anhoBase = mul.getValor1();
	    			int rango = Integer.parseInt(mul.getValor2());
	    			Vector rel1 = utilList.obtenerListAnhos(anhoBase,rango);
	        		
		        	Vector rel2=ejb.busOficinaCodyNom(codTerritorio);
	        		
	        		if(gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")){
	        			newListaOficina = ejb.findAllOficinaByCodTerri(gestor.getCodigoTerritorio());
	        		}else{
	        			if(gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")){
	        				newListaOficina = ejb.findAllOficinas();	
	        			}else{
	        				newListaOficina = ejb.findListaByCodOficina(gestor.getCodigoOficina());		
	        			}
	        		}        	
	        		 
	        		if(codOficina == null && newListaOficina != null &&  newListaOficina.size() > 0) {
	        			codOficina = ((Oficina)newListaOficina.get(0)).getCodOfic();
	        		}
		        	
		        	request.setAttribute("listaAnhos",rel1);
		        	request.setAttribute("listaOficina",rel2);
		        	request.setAttribute("newListaOficina", newListaOficina);	        	
		        	request.setAttribute("codGestor",nomGestor);
		        	request.setAttribute("perfil",perfil);
		        	request.setAttribute("nomTerritorio",nomTerritorio);
		        	request.setAttribute("codAnhoReturn",codAnho);
		        	request.setAttribute("codMesReturn",codMes);
		        	request.setAttribute("codOficinaReturn", codOficina);
		        	
		        	Vector<Seguimiento> listaSeguimiento = ejb.consultaSeguimientoAccionEsfuerzoPGO(codOficina, codMes, codAnho) ;
		        	request.setAttribute("listaSeguimiento", listaSeguimiento);
		        	if(listaSeguimiento != null && listaSeguimiento.size() > 0) {
						request.setAttribute("codEpigrafe", listaSeguimiento.get(0).getCodEpigrafe());
					} else {
						request.setAttribute("codEpigrafe", "***");
					}
	        	}
	        	else{
	        		
	    			mul = ejb.findMultiByPrimaryKey("T02","1");
	    			String anhoBase = mul.getValor1();
	    			int rango = Integer.parseInt(mul.getValor2());
	    			Vector rel1 = utilList.obtenerListAnhos(anhoBase,rango);
		        	Vector rel2=ejb.busOficinaCodyNom(codTerritorio);        		        	
		        	
		        	Territorio territorio = ejb.findTerritorioByCodOficina(codOficina);
		        	if(territorio == null) {	        		
		        		territorio = new Territorio();
		        	}	        	        	
		        	nomTerritorio = territorio.getNomTerr();
		        	
		        	if(gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")){
	        			newListaOficina = 	ejb.findAllOficinaByCodTerri(gestor.getCodigoTerritorio());
	        		}else{
	        			if(gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP")){
	        				newListaOficina = ejb.findAllOficinas();	
	        			}else{
	        				newListaOficina = ejb.findListaByCodOficina(gestor.getCodigoOficina());	
	        			}
	        		}
		        	
		        	request.setAttribute("listaAnhos", rel1);
		        	request.setAttribute("listaOficina", rel2);
		        	request.setAttribute("newListaOficina", newListaOficina);
		        	request.setAttribute("codGestor", nomGestor);
		        	request.setAttribute("perfil", perfil);
		        	request.setAttribute("nomTerritorio", nomTerritorio);
		        	request.setAttribute("codAnhoReturn", codAnho);
		        	request.setAttribute("codMesReturn", codMes);
		        	request.setAttribute("codOficinaReturn", codOficina);
		        	
		        	
		        	Vector<Seguimiento> listaSeguimiento = ejb.consultaSeguimientoAccionEsfuerzoPGO(codOficina, codMes, codAnho) ;
		        	request.setAttribute("listaSeguimiento", listaSeguimiento);
		        	if(listaSeguimiento != null && listaSeguimiento.size() > 0) {
						request.setAttribute("codEpigrafe", listaSeguimiento.get(0).getCodEpigrafe());
					} else {
						request.setAttribute("codEpigrafe", "***");
					}
	        	}
	        	
	        	log.info("[ReportePGOAction :: reportePGO] Fin");
        	} catch(Exception e) {
        		log.error("[ReportePGOAction :: reportePGO] ");
        		ConstantesUtil.mostrarMensajeExcepcion(e);
        	}
        	
	        if (!errors.isEmpty()) {
	            saveErrors(request, errors);
	            forward = mapping.findForward("error");
	        } else {
	            forward = mapping.findForward("reportePGO");	        
	        }       	         

			RegistraValorDefecto.getInstancia().registrar(request, codAnho, codMes, codOficina);
	        
	        return (forward);        	        
	 }
}