package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.excel.ExcelIngresos;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import pe.com.bbva.model.dao.ReporteIngresoDAO;
import pe.com.indra.component.model.MetaData;
import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

public class ActionReportesUsuarioAction extends Action {
	
	private static Logger log = Logger.getLogger(ActionReportesUsuarioAction.class);
	private static SimpleDateFormat formatter = new SimpleDateFormat();
	private static final String FORMATO_DDMMYYYY = "dd/MM/yyyy";	
	private static final String FORMATO_YYYYMMDD = "yyyyMMdd";
	private static final String FORMATO_YYYYMM = "yyyyMM";
	private static final String FORMATO_YYYY = "yyyy";
	
	private Connection cnx = new Connection();
	private String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};  
	

    @SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward();
        HttpSession session = null;
		Gestor gestor = null;
		String codTerritorio = "";
		String codOficina = "";
		UtilListas util =new UtilListas();
    	int opcion = -1;
        int tipo = -1;
        int dia = 1;
        int mes = -1;
        int anio = -1;
        int rango = 0;
        Vector listaAnio = null;
        Multitabla mul = null;
        String accion = "";
        String anhoBase = "";
        String modo = "";
        String modoDia = null;
    	String fileName = "";
    	String sheetName = "";
    	String title = "";
    	String hoy = "";
        
        Calendar calendar = Calendar.getInstance();
        // calendar.setTimeInMillis((new java.util.Date()).getTime());
        formatter = new SimpleDateFormat(ActionReportesUsuarioAction.FORMATO_DDMMYYYY);
        hoy = formatter.format(calendar.getTime());
        
        try { 
        	log.info("[ActionReportesUsuarioAction :: execute] Inicio");

			mul = cnx.findMultiByPrimaryKey("T02", "1");
			anhoBase = mul.getValor1();
			rango = Integer.parseInt(mul.getValor2());
			listaAnio = util.obtenerListAnhos(anhoBase, rango);
	    	
			opcion = request.getParameter("pOpcion") == null ? 1 : Integer.parseInt(request.getParameter("pOpcion"));
	        tipo = request.getParameter("pTipo") == null ? -1 : Integer.parseInt(request.getParameter("pTipo"));
	        mes = request.getParameter("pMes") == null ? (calendar.get(Calendar.MONTH) + 1) : Integer.parseInt(request.getParameter("pMes"));
	        anio = request.getParameter("pAnio") == null ? calendar.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("pAnio"));
	        modo = request.getParameter("modo") == null ? "1" : request.getParameter("modo");
	        accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");
	        
			calendar.set(Calendar.YEAR, anio);
	    	calendar.set(Calendar.MONTH, mes - 1);

        	session = request.getSession(false);
			gestor = (Gestor) session.getAttribute("gestor");
			if(gestor != null && (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP"))) {
				codTerritorio = "";
				codOficina = "";
			}else if(gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")) {
				codTerritorio = gestor.getCodigoTerritorio();
			}else {
				codOficina = gestor.getCodigoOficina();
			}
			
        	if (request.getParameter("pOpcion") != null) {
		        
				String path = ((Multitabla) cnx.findByCodMulti("T11").elementAt(0)).getValor1();
		    	ReporteIngresoDAO dao = new ReporteIngresoDAO();
		    	Date periodo = new Date(calendar.getTime().getTime());
		    	
		    	if(accion.equalsIgnoreCase("D2")) {
		    		tipo = ReporteIngresoDAO.REPORTE_POR_GESTOR;
		    		opcion = ReporteIngresoDAO.REPORTE_DIARIO;
		    		periodo = new Date();
		    		calendar = Calendar.getInstance();
		    		calendar.setTime(periodo);
		    		anio = calendar.get(Calendar.YEAR);
		    		mes = calendar.get(Calendar.MONTH) + 1;
		    		dia = calendar.get(Calendar.DATE);
		    		modoDia = "1";
		    	} else {
		    		modo = "2";
		    	}
		    	
		    	List<Object[]> result = dao.findIngreso(tipo, opcion, mes, anio, dia, codTerritorio, codOficina);
		    	List<MetaData> cols = dao.getCols();
		    	ExcelIngresos excelIngreso= new ExcelIngresos();
		    	fileName = nombreArchivo(opcion, tipo, mes, anio, dia);
		    	sheetName = "";
		    	
		    	if(opcion == ReporteIngresoDAO.REPORTE_DIARIO) {
		    		sheetName = "Reporte diario";
		    		title = "Reporte de Ingresos del Dia " + hoy;
		    	} else {
			    	if(tipo == ReporteIngresoDAO.REPORTE_POR_GESTOR) {
			    		sheetName = "Reporte por Usuario";
			    		title = "Reporte de Ingresos por Usuario por ";
			    	} else if(tipo == ReporteIngresoDAO.REPORTE_POR_OFICINA) {
			    		sheetName = "Reporte por Oficina";
			    		title = "Reporte de Ingresos por Oficina por ";
		    		} else if(tipo == ReporteIngresoDAO.REPORTE_POR_TERRITORIO) {
			    		sheetName = "Reporte por Territorio";
			    		title = "Reporte de Ingresos por Territorio por ";
		    		}
			    	
			    	if(opcion == ReporteIngresoDAO.REPORTE_ANUAL) {
			    		title += "A" + (char) 241 + "o de planificaci" + (char) 243 + "n - " + anio;
			    	} else if(opcion == ReporteIngresoDAO.REPORTE_MENSUAL) {
			    		title += "Mes de planificaci" + (char) 243 + "n - " + meses[mes] + " " + anio;
			    	}
		    	}
		    	excelIngreso.generarReporte(path + fileName, sheetName, result, cols, title);
        	}		
	    	
			log.info("[ActionReportesUsuarioAction :: execute] Fin");
        } catch (Exception e) {
        	log.error("[ActionReportesUsuarioAction :: execute] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
            errors.add("name", new ActionError("id"));
        }
        
        request.setAttribute("modoDia", modoDia);
        request.setAttribute("modo", modo);
		request.setAttribute("listaAnio", listaAnio);
		request.setAttribute("lOpcionSeleccionado", String.valueOf(opcion));	
		request.setAttribute("lTipoSeleccionado", String.valueOf(tipo));
		request.setAttribute("lMesSeleccionado", String.valueOf(mes));
		request.setAttribute("lAnioSeleccionado", String.valueOf(anio));
		
		if(modo.equals("2")) {
			request.setAttribute("file", fileName);
		}
		
		if(modoDia != null) {
			request.setAttribute("fileDia", fileName);
		}
		
    	
    	// Para la busqueda del acceso diario
    	if(gestor != null && (gestor.getCodigoPerfil().equals("CON") || gestor.getCodigoPerfil().equals("ADM") || gestor.getCodigoPerfil().equals("SUP"))) {
    		codTerritorio = null;
    	} else { 
    		codTerritorio = gestor.getCodigoTerritorio();
    	}

		request.setAttribute("fechaHoy", hoy);
		int dias = cnx.listadoIngresoxDia(hoy, codTerritorio); 
		request.setAttribute("contadorDia", String.valueOf(dias));
        
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        } else {        	
        	forward = mapping.findForward("res");
        }

        return (forward);
    }

	private String nombreArchivo(int tipoPeriodo, int tipoReporte, int mes, int anio, int dia) {		
		String fileName = "";
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.YEAR, anio);
    	calendar.set(Calendar.MONTH, mes - 1);
    	calendar.set(Calendar.DATE, dia);
    	log.info("[ActionReportesUsuarioAction :: nombreArchivo] Inicio");
    	
    	switch(tipoPeriodo) {
    	case ReporteIngresoDAO.REPORTE_ANUAL:
    		formatter = new SimpleDateFormat(ActionReportesUsuarioAction.FORMATO_YYYY);
    		fileName = formatter.format(calendar.getTime());
    		break;
    	case ReporteIngresoDAO.REPORTE_MENSUAL:
    		formatter = new SimpleDateFormat(ActionReportesUsuarioAction.FORMATO_YYYYMM);
    		fileName = formatter.format(calendar.getTime());
    		break;
    	case ReporteIngresoDAO.REPORTE_DIARIO:
    		formatter = new SimpleDateFormat(ActionReportesUsuarioAction.FORMATO_YYYYMMDD);
    		fileName = formatter.format(calendar.getTime());
    		break;
    	}
    	
    	if(tipoPeriodo != ReporteIngresoDAO.REPORTE_DIARIO) {
	    	if(tipoReporte == ReporteIngresoDAO.REPORTE_POR_GESTOR)
	    		fileName+= "U";
	    	else if(tipoReporte == ReporteIngresoDAO.REPORTE_POR_OFICINA)
				fileName+= "O";
	    	else if(tipoReporte == ReporteIngresoDAO.REPORTE_POR_TERRITORIO)
	    		fileName+= "T";
	    	
	    	fileName += "SDO";
    	}
    	
    	fileName += ".xls";
    	log.info("[ActionReportesUsuarioAction :: nombreArchivo] Fin");
    	
		return fileName;
	}
}