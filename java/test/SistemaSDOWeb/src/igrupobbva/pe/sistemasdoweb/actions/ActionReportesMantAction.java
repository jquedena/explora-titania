package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.excel.ExcelPPG;
import igrupobbva.pe.sistemasdoweb.excel.ExcelPlan;
import igrupobbva.pe.sistemasdoweb.excel.ExcelSeg;

import java.util.Calendar;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

public class ActionReportesMantAction extends Action{
	private static Logger log = Logger.getLogger(ActionReportesMantAction.class);
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward(); // return value
        Connection cnx = new Connection();
        HttpSession sesion = null;
        String accion = null; 
        Gestor gestor = null;
        
        try {
        	log.info("[ActionReportesMantAction :: execute] Inicio");
        	
        	sesion = request.getSession(false);
        	gestor = (Gestor)sesion.getAttribute("gestor"); 
        	
			accion = request.getParameter("accion");
			String tipo = request.getParameter("tipo");
			
			if (tipo==null) {
				tipo = "";
			}
	        //String tipoLit = request.getParameter("tipo");
	        //int tipo = text2index(tipoLit);
	        String anio = request.getParameter("anio");
	        String file = request.getParameter("file");
	        String path = "";
	        String titulo = "";
	        
	        String acceso = (String)sesion.getAttribute("acceso");
	        String registro = (String)gestor.getCodigoGestor();
	        String territorio;
	        //String oficina = (String)sesion.getAttribute("codOficina");
	        String oficina = gestor.getCodigoOficina();
	        
	        String sTipo = "";
	        String sCod = "";
	        
	        Vector datos = null;
	        boolean res = false;
		
			if(accion==null) accion = "";
			
			if(accion.equals("")){
				String fechas = datosComboFechas();
				request.setAttribute("fechas",fechas);
				request.setAttribute("modo","1");
			}
			
			if(accion.equals("C")){
				//combo fechas
				String fechas=datosComboFechas();
				request.setAttribute("fechas",fechas);
				
				IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(registro);
				if(user.getCargo().getCodigo().equals("CH1")){
					sTipo = "T";
					sCod = cnx.findByCodOficina(oficina).getTerr().getCodTerr();
				}
				else if(user.getCargo().getCodigo().equals("CH6")){
					sTipo = "T";
					sCod = cnx.findByCodOficina(oficina).getTerr().getCodTerr();
				}
				else if(user.getCargo().getCodigo().equals("B21")){
					sTipo = "O";
					sCod = oficina;
				}
				else{
					if(acceso.equals("2")){
						sTipo = "A";
						sCod = "";
					}
				}
				
				Calendar cal = Calendar.getInstance();
				int mes = cal.get(Calendar.MONTH);
				String cMes = String.valueOf(mes);
				if (mes<10) {
					cMes = "0"+String.valueOf(mes);
				}

				cMes = "08";
				
				//busqueda oscar
				if(tipo.equals("0")){
					datos = cnx.listaReportePlanificacion();
				}
				else if(tipo.equals("1")){
					datos = cnx.listaReportePPG(anio, cMes);
				}
				else if(tipo.equals("2")){
					datos = cnx.listaReporteSeguimiento1(anio, cMes);
				}
				else if(tipo.equals("3")){
					datos = cnx.listaReporteSeguimiento2(anio, cMes);
				}
				
				if(datos!=null){
					if(datos.size()>0){
						file = nombreArchivo(tipo,anio,registro);
						path = ((Multitabla)cnx.findByCodMulti("T11").elementAt(0)).getValor1();
						res = true;
						
						if(tipo.equals("0")){
							ExcelPlan xls = new ExcelPlan();
							titulo = "Reporte Planificaci" + (char) 243 + "n " + anio;
							xls.generarExcel(datos,path + file,titulo);
						}
						else if(tipo.equals("1")){
							ExcelPPG xls = new ExcelPPG();
							titulo = "Reporte PPG " + anio;
							xls.generarExcel(datos,path + file,titulo);
						}
						else if(tipo.equals("2")){
							ExcelSeg xls = new ExcelSeg();
							titulo = "Reporte Seguimiento 1 " + anio;
							xls.generarExcel(datos,path + file);
						}
						else if(tipo.equals("3")){
							ExcelSeg xls = new ExcelSeg();
							titulo = "Reporte Cierre " + anio;
							xls.generarExcel(datos,path + file);
						}
					}
				}
				
				if(res) {
					request.setAttribute("file",file);
				}
				
				request.setAttribute("modo","2");
				request.setAttribute("lTiposSeleccionado",tipo);
				request.setAttribute("lAnioSeleccionado",anio);
			}
			
			if(accion.equals("D")){
				path = ((Multitabla)cnx.findByCodMulti("T11").elementAt(0)).getValor1();
				request.setAttribute("file",file);
				request.setAttribute("rootpath",path);
				request.setAttribute("nombreSalida",file);
			}
			
			log.info("[ActionReportesMantAction :: execute] Fin");
        } catch (Exception e) {
        	log.error("[ActionReportesMantAction :: execute] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
            errors.add("name", new ActionError("id"));
        }

        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        } else {
        	if(accion.equals("D")) {
        		forward = mapping.findForward("descarga");
        	}
        	else {
        		forward = mapping.findForward("res");
        	}
        }

        return (forward);
    }
    
	private String nombreArchivo(String tipo, String anio, String reg) {
		log.info("[ActionReportesMantAction :: nombreArchivo] Inicio");
		
		String res = anio + "_" + reg + ".xls";
		
		if(tipo.equals("0"))
			res = "PLAN_" + res;
		else if(tipo.equals("1"))
			res = "RPPG_" + res;
		else if(tipo.equals("2"))
			res = "SEG1_" + res;
		else if(tipo.equals("3"))
			res = "SEG2_" + res;
		
		log.info("[ActionReportesMantAction :: nombreArchivo] Fin");
		
		return res;
	}

	private String datosComboFechas() {
		log.info("[ActionReportesMantAction :: datosComboFechas] Inicio");
		
		int y = Calendar.getInstance().get(Calendar.YEAR);
		String res = y + ",";
		
		for(int i=0;i<4;i++){
			y--;
			if(i+1==4)
				res+=y;
			else
				res+=y + ",";
		}
		
		log.info("[ActionReportesMantAction :: datosComboFechas] Fin");
		
		return res;
	}
	
	private int text2index(String literal){
		int res = 0;
		
		log.info("[ActionReportesMantAction :: text2index] Inicio");
		
		if(literal!=null){
			if(literal.equals("Planificaci" + (char) 243 + "n"))
				res = 1;
			else if(literal.equals("Reporte PPG"))
				res=2;
			else if(literal.equals("Seguimiento 1"))
				res=3;
			else if(literal.equals("Cierre 2"))
				res=4;
		}
		
		log.info("[ActionReportesMantAction :: text2index] Fin");
		
		return res;
	}
}