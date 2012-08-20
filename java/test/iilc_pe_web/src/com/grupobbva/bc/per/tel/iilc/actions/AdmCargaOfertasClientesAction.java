package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.config.SingletonBeanFactory;
import com.grupobbva.bc.per.tel.iilc.service.ICargaOfertasService;

public class AdmCargaOfertasClientesAction extends DispatchAction  {

	private static Logger log = Logger.getLogger(AdmCargaOtrasOfertasAction.class);
	  
	@Autowired
	private ICargaOfertasService iCargaOfertasService;
 
 
	@Autowired
	public ICargaOfertasService getICargaOfertasService() {
		return iCargaOfertasService;
	}

	@Autowired
	public void setICargaOfertasService(ICargaOfertasService cargaOfertasService) {
		iCargaOfertasService = cargaOfertasService;
	}

	public ActionForward crearProgramacionCarga(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
										throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			String tipo = request.getParameter("tipo");
			String fecha = request.getParameter("fecha_"+tipo);
			
			String sobreescritura = request.getParameter("sobreescritura"); 
			int resultadoOperacion=0;
			if(fecha==null || fecha.equals("null") || fecha.equals("")){
				request.setAttribute("mensaje",Constantes.MENASJE_REGISTRAR_FECHA);
			}else{
				String usuario=request.getSession().getAttribute("usuario").toString();
				
				resultadoOperacion=iCargaOfertasService.crearProgramacionCarga(fecha,usuario,sobreescritura==null?false:true,tipo);
				
				if(resultadoOperacion==1){
					request.setAttribute("mensaje",Constantes.MENASJE_FECHA_ERRONEA);
				}else if(resultadoOperacion==2){
					request.setAttribute("mensajeInformacion",Constantes.MENASJE_FECHA_EXISTE);
				}else if(resultadoOperacion==3){
					request.setAttribute("mensaje",Constantes.MENASJE_CARGA_PROCESO);
				}
			}
			
			request.setAttribute("fecha_"+tipo,fecha);
			request.setAttribute("tipo",tipo);
			
			forward = mapping.findForward(Constantes.FW_ADMINISTRADOR); 
			return (forward);
		}catch(Exception e){
			log.error("Error en crearProgramacionCarga");
			log.error(e.getMessage());
			e.printStackTrace();
			forward = mapping.findForward(Constantes.FW_ERROR); 
			return (forward);
		}
		
	}
	
	public ActionForward listarFechasProgramadas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			List lista;
			String tipo = request.getParameter("tipo");
			
			lista=iCargaOfertasService.listarFechasProgramadas(tipo);
			request.getSession().setAttribute("listaCargas", lista);
			request.setAttribute("tipo",tipo);
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
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
		List lista;
		String tipo = request.getParameter("tipo");
		String arreglo[]=request.getParameterValues("arregloEliminar");
		
		if(iCargaOfertasService.eliminarProgramacionCarga(arreglo)==1){
			request.setAttribute("mensaje",  Constantes.MENASJE_ELIMINAR_PROCESO);
		}
		
		lista=iCargaOfertasService.listarFechasProgramadas(tipo);
		request.getSession().setAttribute("listaCargas", lista);
		request.setAttribute("tipo",tipo);
		forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS); 
		return (forward);
		}catch(Exception e){
			log.error("Error en eliminarFechasProgramadas");
			forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS);
			return (forward);
		} 
	}

	public ActionForward visualizarEstadoCarga(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			String tipo = request.getParameter("tipo");
			
			Tiilc_adm_carga_archivo beanCarga = iCargaOfertasService.visualizarEstadoCarga(tipo);
			request.setAttribute("beanCarga", beanCarga); 
			request.setAttribute("tipo",tipo);
			forward = mapping.findForward(Constantes.FW_ESTADO_CARGA); 
			return (forward);
		}catch(Exception e){
			e.printStackTrace();
			log.error("Error en visualizarEstadoCarga");
			forward = mapping.findForward(Constantes.FW_ERROR); 
		return (forward);
		} 
	}
	
	public ActionForward estadoCarga(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			String tipo = request.getParameter("tipo");
			Tiilc_adm_carga_archivo beanCarga = iCargaOfertasService.visualizarEstadoCarga(tipo);
			
			PrintWriter writer = response.getWriter();
			writer.print(beanCarga.getId_estado());
			/*if(beanCarga.getFecha_fin() == null) {
				writer.print(2);
			} else {
				writer.print(beanCarga.getId_estado());
			}*/
			
			writer.close();
		}catch(Exception e){
			log.error(e); 
		} 
		return null;
	}	
	
	public ActionForward validarEstadoProceso(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			String tipo = request.getParameter("tipo");
			List lista=iCargaOfertasService.listarFechasProgramadas(tipo);
			request.getSession().setAttribute("listaCargas", lista);
			
			String id=request.getParameter("id");
			String fecha=request.getParameter("fecha");
			
			boolean resultadoValidacion= iCargaOfertasService.verificarProcesamientoCarga(Integer.parseInt(id));
				if(resultadoValidacion){
					request.setAttribute("mensaje",Constantes.MENASJE_MODIFICAR_PROCESO);
				}else{
					request.setAttribute("modificacion","mostrarDIV");
					request.setAttribute("fecha",fecha);
					request.setAttribute("fecha_original",fecha); 
					request.setAttribute("id",id);
				}
			
			request.setAttribute("tipo",tipo);
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
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			String fecha = request.getParameter("fecha");
			String tipo = request.getParameter("tipo");
			String fecha_original= request.getParameter("fecha_original");
			String id = request.getParameter("id"); 
			int resultadoOperacion=0;
			if(fecha==null || fecha.equals("null") || fecha.equals("")){
				request.setAttribute("mensaje","Debe registrar una fecha");
				request.setAttribute("modificacion","mostrarDIV");
			}else{ 
				
				resultadoOperacion=iCargaOfertasService.actualizarProgramacion(Integer.parseInt(id),fecha,fecha_original,tipo);
				
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
			}
			
			request.setAttribute("fecha",fecha);
			request.setAttribute("id",id);
			request.setAttribute("fecha_original",fecha_original);
			request.setAttribute("tipo",tipo);
			List lista=iCargaOfertasService.listarFechasProgramadas(tipo);
			request.getSession().setAttribute("listaCargas", lista);
			
			
			forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS); 
			return (forward);
		}catch(Exception e){
				log.error("Error en actualizarProgramacion");
				forward = mapping.findForward(Constantes.FW_ERROR); 
				return (forward);
		}
		
	}
	
	public ActionForward listarIntervalos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			List lista=iCargaOfertasService.listarIntervalos();
			
			request.setAttribute("listaIntervalos", lista);
			forward = mapping.findForward(Constantes.FW_INTERVAOS); 
			return (forward);
		}catch(Exception e){
			log.error("Error en listarIntervalos");
			forward = mapping.findForward(Constantes.FW_ERROR); 
		return (forward);
		} 
	}
	
	public ActionForward validarIntervalos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			 
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			String valor1=request.getParameter("valor1");
			String valor2=request.getParameter("valor2");
			String cod_ele=request.getParameter("cod_ele");
			
			PrintWriter writer = response.getWriter();
			int resultadoValidacion=iCargaOfertasService.validacionIntervalos(valor1,valor2,cod_ele);
			if(resultadoValidacion<1){
				writer.print("Debe ingresar un intervalo valido en el registro numero ");
			}else{
				writer.print("");
			}
			writer.flush();
			writer.close();
			return null;
		}catch(Exception e){
			log.error("Error en validarIntervalos");
			forward = mapping.findForward(Constantes.FW_ERROR); 
			return null;
		} 
	}
	
	public ActionForward actualizarIntervalos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOfertasService = SingletonBeanFactory.getInstancia().getCargaOfertasService();
			String valor1[]=request.getParameterValues("valor1");
			String valor2[]=request.getParameterValues("valor2");
 

			boolean resultadoGrabacion=iCargaOfertasService.grabarIntervalos(valor1,valor2);
			String mensaje = resultadoGrabacion ? "Registro Correcto." : "Conflicto con un intervalo existente."; 
			List lista=iCargaOfertasService.listarIntervalos();
			request.setAttribute("listaIntervalos", lista);
			request.setAttribute("mensaje", mensaje);
			
			forward = mapping.findForward(Constantes.FW_INTERVAOS);
		}catch(Exception e){
			log.error("Error en actualizarIntervalos");
			forward = mapping.findForward(Constantes.FW_ERROR); 
			
		} 
		return (forward);
	}
	
	
	
	
}
