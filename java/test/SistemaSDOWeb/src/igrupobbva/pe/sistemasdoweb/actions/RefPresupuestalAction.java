package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.RefPresupuestalForm;
import igrupobbva.pe.sistemasdoweb.util.Meses;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"unused", "unchecked", "static-access"})
public class RefPresupuestalAction extends BaseLoadDataAction {
	private static Logger log = Logger.getLogger(RefPresupuestalAction.class);
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward referencia =new ActionForward();
		Connection ejb =new Connection();
		RefPresupuestalForm mesform =(RefPresupuestalForm)form;
		//Vector mul =null;
		referencia =mapping.findForward("inicio");
		int mesActual = -1;
		int anioActual = -1;
		ConstantesUtil consUtil = null;
		boolean resp = false;
		String mesSelec = null;
		String anho;
		String anio;
		
		// Meses
		ArrayList listaMeses = new ArrayList();
		Meses mes;
		
		mes = new Meses("0","Seleccionar");
		listaMeses.add(mes);
		mes = new Meses("1","Enero");
		listaMeses.add(mes);
		mes = new Meses("2","Febrero");
		listaMeses.add(mes);
		mes = new Meses("3","Marzo");
		listaMeses.add(mes);
		mes = new Meses("4","Abril");
		listaMeses.add(mes);
		mes = new Meses("5","Mayo");
		listaMeses.add(mes);
		mes = new Meses("6","Junio");
		listaMeses.add(mes);
		mes = new Meses("7","Julio");
		listaMeses.add(mes);
		mes = new Meses("8","Agosto");
		listaMeses.add(mes);
		mes = new Meses("9","Setiembre");
		listaMeses.add(mes);
		mes = new Meses("10","Octubre");
		listaMeses.add(mes);
		mes = new Meses("11","Noviembre");
		listaMeses.add(mes);
		mes = new Meses("12","Diciembre");
		listaMeses.add(mes);
		
		HttpSession sesion = request.getSession(false);
		sesion.setAttribute("listaMeses", listaMeses);
		
		try{
			log.info("[RefPresupuestalAction :: inicio] Inicio");
			
			consUtil = new ConstantesUtil();
			
			mesActual = Integer.parseInt(consUtil.getMesActual()); 
			anioActual = Integer.parseInt(consUtil.getAnioActual());		
			
			anho = request.getParameter("anho");
			if(anho != null && !anho.equals("")) {
				anio = anho;
			} else {
				anio = ConstantesUtil.getAnioActual();
			}
			
			mesSelec = String.valueOf(ejb.findMesesReferencia(mesActual, anioActual));
			
			if(Integer.parseInt(mesSelec) < 10) {
				mesSelec = "0"  + mesSelec;
			}

			// Obteniendi lista de anios
            Multitabla mul = conexion.findMultiByPrimaryKey("T02", "1");
            String anhoBase = mul.getValor1();
            int rango = Integer.parseInt(mul.getValor2());
            
            UtilListas utilList = new UtilListas();
            Vector listaAnhos = utilList.obtenerListAnhos(anhoBase, rango);
            sesion.setAttribute("listaAnhos", listaAnhos);           
            
            mesform = setDatosListaMes(request, mesform, Integer.parseInt(anio));
            request.setAttribute("anio", anio);
            //request.setAttribute("mesSelec", mesform.getIdMes11());
			
			log.info("[RefPresupuestalAction :: inicio] Fin");
		}catch(Exception e){
			log.error("[RefPresupuestalAction :: inicio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return  (referencia);
	}
	
	public ActionForward referencia(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward referencia =new ActionForward();
		Connection ejb =new Connection();
		RefPresupuestalForm mesform =(RefPresupuestalForm)form;
		Vector mul =null;
		referencia =mapping.findForward("referencia");
		int mesActual = -1;
		int anioActual = -1;
		ConstantesUtil consUtil = null;
		boolean resp = false;
		String mesSelec = null;
		
		try{
			log.info("[RefPresupuestalAction :: referencia] Inicio");
			
			//if(mesform.getCod_elem()!=null && mesform.getCod_elem()!=""){
				consUtil = new ConstantesUtil();
				mesActual = Integer.parseInt(consUtil.getMesActual()); 
				anioActual = Integer.parseInt(consUtil.getAnioActual());				
			
				// Guardar en la tabla de mes de referencia		
				//resp = ejb.insertUpdateMesesReferencia(mesActual, anioActual, Integer.parseInt(mesform.getCod_elem()));
				if(Integer.parseInt(mesform.getIdMes1()) > 0){resp = ejb.insertUpdateMesesReferencia(1, anioActual, Integer.parseInt(mesform.getIdMes1()));}
				if(Integer.parseInt(mesform.getIdMes2()) > 0){resp = ejb.insertUpdateMesesReferencia(2, anioActual, Integer.parseInt(mesform.getIdMes2()));}
				if(Integer.parseInt(mesform.getIdMes3()) > 0){resp = ejb.insertUpdateMesesReferencia(3, anioActual, Integer.parseInt(mesform.getIdMes3()));}
				if(Integer.parseInt(mesform.getIdMes4()) > 0){resp = ejb.insertUpdateMesesReferencia(4, anioActual, Integer.parseInt(mesform.getIdMes4()));}
				if(Integer.parseInt(mesform.getIdMes5()) > 0){resp = ejb.insertUpdateMesesReferencia(5, anioActual, Integer.parseInt(mesform.getIdMes5()));}
				if(Integer.parseInt(mesform.getIdMes6()) > 0){resp = ejb.insertUpdateMesesReferencia(6, anioActual, Integer.parseInt(mesform.getIdMes6()));}
				if(Integer.parseInt(mesform.getIdMes7()) > 0){resp = ejb.insertUpdateMesesReferencia(7, anioActual, Integer.parseInt(mesform.getIdMes7()));}
				if(Integer.parseInt(mesform.getIdMes8()) > 0){resp = ejb.insertUpdateMesesReferencia(8, anioActual, Integer.parseInt(mesform.getIdMes8()));}
				if(Integer.parseInt(mesform.getIdMes9()) > 0){resp = ejb.insertUpdateMesesReferencia(9, anioActual, Integer.parseInt(mesform.getIdMes9()));}
				if(Integer.parseInt(mesform.getIdMes10()) > 0){resp = ejb.insertUpdateMesesReferencia(10, anioActual, Integer.parseInt(mesform.getIdMes10()));}
				if(Integer.parseInt(mesform.getIdMes11()) > 0){resp = ejb.insertUpdateMesesReferencia(11, anioActual, Integer.parseInt(mesform.getIdMes11()));}
				if(Integer.parseInt(mesform.getIdMes12()) > 0){resp = ejb.insertUpdateMesesReferencia(12, anioActual, Integer.parseInt(mesform.getIdMes12()));}
				
				if(resp) {					
					request.setAttribute("mensajeExito", ConstantesUtil.MENSAJE_EXITO);
				} else {
					request.setAttribute("mensajeExito", ConstantesUtil.MENSAJE_ERROR);
				}
				
				mesSelec = String.valueOf(ejb.findMesesReferencia(mesActual, anioActual));
				
				if(Integer.parseInt(mesSelec) < 10) {
					mesSelec = "0"  + mesSelec;
				}
				
				//request.setAttribute("mesSelec", mesSelec);
				
				mesform = setDatosListaMes(request, mesform, Integer.parseInt(mesform.getAnho()));
			//}
			
			log.info("[RefPresupuestalAction :: referencia] Fin");
		}catch(Exception e){
			log.error("[RefPresupuestalAction :: referencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return (referencia);
	}
	
	private RefPresupuestalForm setDatosListaMes(HttpServletRequest request, RefPresupuestalForm fromMes, int year)
	{
		RefPresupuestalForm mesform = fromMes;
		ConstantesUtil consUtil = new ConstantesUtil();
		int anioActual = Integer.parseInt(consUtil.getAnioActual());
		int mesActual = Integer.parseInt(consUtil.getMesActual()); 
		
		// Obteniendo la lista de meses por anio
        HashMap mapaDatos = conexion.getListaMeses(year);
        
        if(mapaDatos.get("1") != null)
        {
        	mesform.setIdMes1(mapaDatos.get("1").toString());
        	if(anioActual > year || mesActual > 1){request.setAttribute("disabledMes1", true);}
        }
        else
        {
        	mesform.setIdMes1("0");
        	if(anioActual > year){request.setAttribute("disabledMes1", true);}
        }
        
        if(mapaDatos.get("2") != null)
        {
        	mesform.setIdMes2(mapaDatos.get("2").toString());
        	if(anioActual > year || mesActual > 2){request.setAttribute("disabledMes2", true);}
        }
        else
        {
        	mesform.setIdMes2("0");
        	if(anioActual > year){request.setAttribute("disabledMes2", true);}
        }
        
        if(mapaDatos.get("3") != null)
        {
        	mesform.setIdMes3(mapaDatos.get("3").toString());
        	if(anioActual > year || mesActual > 3){request.setAttribute("disabledMes3", true);}
        }
        else
        {
        	mesform.setIdMes3("0");
        	if(anioActual > year){request.setAttribute("disabledMes3", true);}
        }
        
        if(mapaDatos.get("4") != null)
		{
			mesform.setIdMes4(mapaDatos.get("4").toString());
			if(anioActual > year || mesActual > 4){request.setAttribute("disabledMes4", true);}
		}
        else
        {
        	mesform.setIdMes4("0");
        	if(anioActual > year){request.setAttribute("disabledMes4", true);}
        }
        
        if(mapaDatos.get("5") != null)
        {
        	mesform.setIdMes5(mapaDatos.get("5").toString());
        	if(anioActual > year || mesActual > 5){request.setAttribute("disabledMes5", true);}
        }
        else
        {
        	mesform.setIdMes5("0");
        	if(anioActual > year){request.setAttribute("disabledMes5", true);}
        }
        
        if(mapaDatos.get("6") != null)
        {
        	mesform.setIdMes6(mapaDatos.get("6").toString());
        	if(anioActual > year || mesActual > 6){request.setAttribute("disabledMes6", true);}
        }
        else
        {
        	mesform.setIdMes6("0");
        	if(anioActual > year){request.setAttribute("disabledMes6", true);}
        }
        
        if(mapaDatos.get("7") != null)
        {
        	mesform.setIdMes7(mapaDatos.get("7").toString());
        	if(anioActual > year || mesActual > 7){request.setAttribute("disabledMes7", true);}
        }
        else
        {
        	mesform.setIdMes7("0");
        	if(anioActual > year){request.setAttribute("disabledMes7", true);}
        }
        
        if(mapaDatos.get("8") != null)
        {
        	mesform.setIdMes8(mapaDatos.get("8").toString());
        	if(anioActual > year || mesActual > 8){request.setAttribute("disabledMes8", true);}
        }
        else
        {
        	mesform.setIdMes8("0");
        	if(anioActual > year){request.setAttribute("disabledMes8", true);}
        }
        
        if(mapaDatos.get("9") != null)
        {
        	mesform.setIdMes9(mapaDatos.get("9").toString());
        	if(anioActual > year || mesActual > 9){request.setAttribute("disabledMes9", true);}
        }
        else
        {
        	mesform.setIdMes9("0");
        	if(anioActual > year){request.setAttribute("disabledMes9", true);}
        }
        
        if(mapaDatos.get("10") != null)
        {
        	mesform.setIdMes10(mapaDatos.get("10").toString());
        	if(anioActual > year || mesActual > 10){request.setAttribute("disabledMes10", true);}
        }
        else
        {
        	mesform.setIdMes10("0");
        	if(anioActual > year){request.setAttribute("disabledMes10", true);}
        }
        
        if(mapaDatos.get("11") != null)
        {
        	mesform.setIdMes11(mapaDatos.get("11").toString());
        	if(anioActual > year || mesActual > 11){request.setAttribute("disabledMes11", true);}
        }
        else
        {
        	mesform.setIdMes11("0");
        	if(anioActual > year){request.setAttribute("disabledMes11", true);}
        }
        
        if(mapaDatos.get("12") != null)
        {
        	mesform.setIdMes12(mapaDatos.get("12").toString());
        	if(anioActual > year || mesActual > 12){request.setAttribute("disabledMes12", true);}
        }
        else
        {
        	mesform.setIdMes12("0");
        	if(anioActual > year){request.setAttribute("disabledMes12", true);}
        }
        
        Boolean grabar = new Boolean(false);
        
        if(anioActual > year)
        {
        	grabar = true;
        }
        
        if(!grabar && anioActual < year)
        {
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes1");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes2");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes3");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes4");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes5");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes6");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes7");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes8");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes9");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes10");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes11");
	        grabar = grabar && (Boolean) request.getAttribute("disabledMes12");
        }
        
        log.info("grabar: " + grabar);
        
        request.setAttribute("grabarListaMeses", grabar);
		
		return mesform;
	}
	
	public ActionForward buscarListaMeses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward referencia = new ActionForward();
		RefPresupuestalForm mesform = (RefPresupuestalForm) form;
		referencia = mapping.findForward("listaMeses");
		
		log.info("Anio seleccionado: " + mesform.getAnho());
		
		mesform = setDatosListaMes(request, mesform, Integer.parseInt(mesform.getAnho()));
		request.setAttribute("anio", mesform.getAnho());
		return (referencia);
	}
}