package com.grupobbva.bc.per.tel.iilc.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.config.SingletonBeanFactory;
import com.grupobbva.bc.per.tel.iilc.service.ICargaConduccionService;

public class AdmCargaConduccionAction extends DispatchAction  {


	private static Logger log = Logger.getLogger(AdmCargaConduccionAction.class);
	
	@Autowired
	private ICargaConduccionService iCargaConduccionService;
		
	public ActionForward crearProgramacionCarga(ActionMapping mapping, ActionForm form,
										HttpServletRequest request, HttpServletResponse response)
										throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			
			iCargaConduccionService = SingletonBeanFactory.getInstancia().getCargaConduccionService();
			String fecha = request.getParameter("fecha");
			String sobreescritura = request.getParameter("sobreescritura"); 
			int resultadoOperacion=0;
			if(fecha==null || fecha.equals("null") || fecha.equals("")){
				request.setAttribute("mensaje",Constantes.MENASJE_REGISTRAR_FECHA);
			}else{
				String usuario=request.getSession().getAttribute("usuario").toString();
				
				resultadoOperacion=iCargaConduccionService.crearProgramacionCarga(fecha,usuario,sobreescritura==null?false:true);
				
				if(resultadoOperacion==1){
					request.setAttribute("mensaje",Constantes.MENASJE_FECHA_ERRONEA);
				}else if(resultadoOperacion==2){
					request.setAttribute("mensajeInformacion",Constantes.MENASJE_FECHA_EXISTE);
				}else if(resultadoOperacion==3){
					request.setAttribute("mensaje",Constantes.MENASJE_CARGA_PROCESO);
				}
				else if(resultadoOperacion == 10){
					request.setAttribute("mensaje",iCargaConduccionService.getMensaje());
				}
			}
			
			request.setAttribute("fecha",fecha);
			forward = mapping.findForward(Constantes.FW_ADMINISTRADOR); 
			return (forward);
		}catch(Exception e){
			e.printStackTrace();
			log.error("Error en crearProgramacionCarga");
			forward = mapping.findForward(Constantes.FW_ERROR); 
			return (forward);
		}
		
	}
	
	
	public ActionForward listarFechasProgramadas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			List lista=null;
			iCargaConduccionService = SingletonBeanFactory.getInstancia().getCargaConduccionService();
			lista=iCargaConduccionService.listarFechasProgramadas();
			request.getSession().setAttribute("listaCargas", lista);
			forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS); 
			return (forward);
		}catch(Exception e){
			log.error("Error en listarFechasProgramadas");
			forward = mapping.findForward(Constantes.FW_ERROR); 
		return (forward);
		} 
	}
	
	
	public ActionForward eliminarFechasProgramadas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
		List lista;
		iCargaConduccionService = SingletonBeanFactory.getInstancia().getCargaConduccionService();
		String arreglo[]=request.getParameterValues("arregloEliminar");

		if(iCargaConduccionService.eliminarProgramacionCarga(arreglo)==1){
			request.setAttribute("mensaje", Constantes.MENASJE_ELIMINAR_PROCESO);
		}
		
		lista=iCargaConduccionService.listarFechasProgramadas();
		request.getSession().setAttribute("listaCargas", lista);

		forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS); 
		return (forward);
		}catch(Exception e){
			log.error("Error en eliminarFechasProgramadas");
			forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS);
			return (forward);
		} 
	}

	
	

	public ActionForward validarEstadoProceso(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			
			iCargaConduccionService = SingletonBeanFactory.getInstancia().getCargaConduccionService();
			List lista=iCargaConduccionService.listarFechasProgramadas();
			request.getSession().setAttribute("listaCargas", lista);
			
			String id=request.getParameter("id");
			String fecha=request.getParameter("fecha");
			boolean resultadoValidacion= iCargaConduccionService.verificarProcesamientoCarga(Integer.parseInt(id));
				if(resultadoValidacion){
					request.setAttribute("mensaje",Constantes.MENASJE_MODIFICAR_PROCESO);
				}else{
					request.setAttribute("modificacion","mostrarDIV");
					request.setAttribute("fecha",fecha);
					request.setAttribute("fecha_original",fecha); 
					request.setAttribute("id",id);
				}
			 
			forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS); 
			return (forward);
		}catch(Exception e){
			log.error("Error en validarEstadoProceso");
			forward = mapping.findForward(Constantes.FW_ERROR); 
		return (forward);
		} 
	}
	
	
	
	
	public ActionForward actualizarProgramacion(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaConduccionService = SingletonBeanFactory.getInstancia().getCargaConduccionService();
			String fecha = request.getParameter("fecha");
			String fecha_original= request.getParameter("fecha_original");
			String id = request.getParameter("id"); 
			int resultadoOperacion=0;
			if(fecha==null || fecha.equals("null") || fecha.equals("")){
				request.setAttribute("mensaje","Debe registrar una fecha");
				request.setAttribute("modificacion","mostrarDIV");
			}else{ 
				
				resultadoOperacion=iCargaConduccionService.actualizarProgramacion(Integer.parseInt(id),fecha,fecha_original);
				
				if(resultadoOperacion==0){
					request.setAttribute("mensaje",Constantes.MENASJE_MODIFICAR_PROCESO_POSTERIOR);
					request.setAttribute("modificacion","mostrarDIV");
				}else if(resultadoOperacion==1){
					request.setAttribute("mensaje",Constantes.MENASJE_FECHA_ERRONEA);
					request.setAttribute("modificacion","mostrarDIV");
				}else if(resultadoOperacion==2){
					request.setAttribute("mensaje",Constantes.MENASJE_FECHA_EXISTE_ELIMINAR);
					request.setAttribute("modificacion","mostrarDIV");
				}else if(resultadoOperacion==3){
					request.setAttribute("mensaje",Constantes.MENASJE_ESPERAR_CULMINADO);
					request.setAttribute("modificacion","mostrarDIV");
				}
				else if(resultadoOperacion == 10){
					request.setAttribute("mensaje",iCargaConduccionService.getMensaje());
					request.setAttribute("modificacion","mostrarDIV");
				}
			}
			
			request.setAttribute("fecha",fecha);
			request.setAttribute("id",id);
			request.setAttribute("fecha_original",fecha_original);
			
			List lista=iCargaConduccionService.listarFechasProgramadas();
			request.getSession().setAttribute("listaCargas", lista);
			
			
			forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS); 
			return (forward);
		}catch(Exception e){
				log.error("Error en actualizarProgramacion");
				forward = mapping.findForward(Constantes.FW_ERROR); 
				return (forward);
		}
		
	}


	
	@Autowired
	public ICargaConduccionService getICargaConduccionService() {
		return iCargaConduccionService;
	}
	@Autowired
	public void setICargaConduccionService( ICargaConduccionService cargaConduccionService) {
		iCargaConduccionService = cargaConduccionService;
	}
	
	
	
	
}
