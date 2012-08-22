package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.PorcentajeEpigrafeForm;
import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.xslt4j.bcel.classfile.Constant;

@SuppressWarnings({"unchecked", "unused", "null"})
public class PorcentajeEpigrafeAction extends DispatchAction {
	private static Logger log = Logger.getLogger(PorcentajeEpigrafeAction.class);
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PorcentajeEpigrafeForm formulario = (PorcentajeEpigrafeForm)form;
		Connection conexion = new Connection();
		Multitabla mul = null;
		UtilListas utilList = new UtilListas();
		HttpSession sesion = null;
		
		try {
			log.info("[PorcentajeEpigrafeAction :: inicio] Inicio");
			
			sesion = request.getSession(false);
			mul = conexion.findMultiByPrimaryKey("T02","1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());
			List lstAnios = utilList.obtenerListAnhos(anhoBase,rango);			
			formulario.setLstAnios(lstAnios);
			if(lstAnios !=null || lstAnios.size()>0){
			    String anio = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
			    formulario.setStrAnio(anio);
			}
			if(formulario.getStrAnio()!=null){
			    List lstEpigrafes =  conexion.findEpiByAnho(formulario.getStrAnio());
			    sesion.setAttribute("lstEpigrafes",lstEpigrafes);
			}
			
			log.info("[PorcentajeEpigrafeAction :: inicio] Fin");
		} catch(Exception e) {
			log.error("[PorcentajeEpigrafeAction :: inicio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}	
		
		return mapping.findForward("mostrar");
	}
	
	public ActionForward consultarPorcentaje(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PorcentajeEpigrafeForm formulario = (PorcentajeEpigrafeForm)form;
		
		String codEpigrafe = request.getParameter("codEpigrafe");
		String anio = request.getParameter("anio");
		Connection conexion = new Connection();
		Epigrafe epi = null;
		
		try {
			log.info("[PorcentajeEpigrafeAction :: consultarPorcentaje] Inicio");
			
			epi = conexion.findByCodEpigAnho(codEpigrafe,anio);
			formulario.setStrCodEpigrafe(epi.getCodEpigrafe());
			formulario.setIntPorcMax(epi.getPorcentajeMax());
			formulario.setIntPorcMin(epi.getPorcentajeMin());
			formulario.setStrNombreEpigrafe(epi.getNomEpigrafe());
			formulario.setStrAnio(epi.getAnho());
			
			log.info("[PorcentajeEpigrafeAction :: consultarPorcentaje] Fin");
		} catch(Exception e) {
			log.error("[PorcentajeEpigrafeAction :: consultarPorcentaje] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return mapping.findForward("consultarEpigrafe");
	
	}
	
	public ActionForward actualizarPorcertaje(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PorcentajeEpigrafeForm formulario = (PorcentajeEpigrafeForm)form;
		
		try {
			log.info("[PorcentajeEpigrafeAction :: actualizarPorcertaje] Inicio");
			
			String codEpigrafe = request.getParameter("codEpigrafe");
			String anio = request.getParameter("anio");
			Connection conexion = new Connection();
			
			Epigrafe epi = new Epigrafe();
			epi.setAnho(formulario.getStrAnio());
			epi.setCodEpigrafe(formulario.getStrCodEpigrafe());
			epi.setPorcentajeMax(formulario.getIntPorcMax());
			epi.setPorcentajeMin(formulario.getIntPorcMin());
			
			if (conexion.actualizarPorcentajeEpigrafe(epi)==1){
				request.setAttribute("msj", ConstantesUtil.MENSAJE_EXITO);
			}else{
				request.setAttribute("msj", ConstantesUtil.MENSAJE_ERROR);
			}
			
			log.info("[PorcentajeEpigrafeAction :: actualizarPorcertaje] Fin");
		} catch(Exception e) {
			log.error("[PorcentajeEpigrafeAction :: actualizarPorcertaje] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
			
		return buscaXAnio(mapping,form,request,response);
	
	}
	public ActionForward buscaXAnio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PorcentajeEpigrafeForm formulario = (PorcentajeEpigrafeForm)form;
		Connection conexion = new Connection();
		Multitabla mul = null;
		UtilListas utilList = new UtilListas();
		HttpSession sesion = null;
		
		try {
			log.info("[PorcentajeEpigrafeAction :: buscaXAnio] Inicio");
			
			sesion = request.getSession(false);
			
			mul = conexion.findMultiByPrimaryKey("T02","1");
			String anhoBase = mul.getValor1();
			int rango = Integer.parseInt(mul.getValor2());
			List lstAnios = utilList.obtenerListAnhos(anhoBase,rango);
			
			formulario.setLstAnios(lstAnios);
			String anio =  (String)(formulario.getStrAnio()!=null?formulario.getStrAnio():request.getAttribute("strAnio"));
			List lstEpigrafes =  null;
			if (anio != null){
				lstEpigrafes = conexion.findEpiByAnho(anio);
			}else{
				lstEpigrafes = conexion.findEpiByAnho(((Multitabla)lstAnios.get(0)).getCodelem());
			}
			formulario.setStrAnio(anio);
			sesion.setAttribute("lstEpigrafes",lstEpigrafes);
			
			log.info("[PorcentajeEpigrafeAction :: buscaXAnio] Fin");
		} catch(Exception e) {
			log.error("[PorcentajeEpigrafeAction :: buscaXAnio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return mapping.findForward("mostrar");
	}
}