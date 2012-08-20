package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_error_carga;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.config.SingletonBeanFactory;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanAdmCargaOtrasOfertas;
import com.grupobbva.bc.per.tel.iilc.service.ICargaOtrasOfertasService;

@Service
@SuppressWarnings({"unchecked", "unused"})
public class AdmCargaOtrasOfertasAction extends DispatchAction  {

	private static Logger log = Logger.getLogger(AdmCargaOtrasOfertasAction.class);
	 
	@Autowired
	private ICargaOtrasOfertasService iCargaOtrasOfertasService;
 
	@Autowired
	public void setICargaOtrasOfertasService( ICargaOtrasOfertasService cargaOtrasOfertasService) {
		iCargaOtrasOfertasService = cargaOtrasOfertasService;
	}
	
	public ActionForward crearProgramacionCarga(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
										throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOtrasOfertasService = SingletonBeanFactory.getInstancia().getCargaOtrasOfertasService();
			String fecha = request.getParameter("fecha");
			String sobreescritura = request.getParameter("sobreescritura"); 
			int resultadoOperacion=0;
			if(fecha==null || fecha.equals("null") || fecha.equals("")){
				request.setAttribute("mensaje",Constantes.MENASJE_REGISTRAR_FECHA);
			}else{
				String usuario=request.getSession().getAttribute("usuario").toString();
				resultadoOperacion=iCargaOtrasOfertasService.crearProgramacionCarga(fecha,usuario,sobreescritura==null?false:true);
				
				if(resultadoOperacion==1){
					request.setAttribute("mensaje",Constantes.MENASJE_FECHA_ERRONEA);
				}else if(resultadoOperacion==2){
					request.setAttribute("mensajeInformacion",Constantes.MENASJE_FECHA_EXISTE);
				}else if(resultadoOperacion==3){
					request.setAttribute("mensaje",Constantes.MENASJE_CARGA_PROCESO);
				}
			}
			
			request.setAttribute("fecha",fecha);
			forward = mapping.findForward(Constantes.FW_ADMINISTRADOR); 
			return (forward);
		}catch(Exception e){
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
			iCargaOtrasOfertasService = SingletonBeanFactory.getInstancia().getCargaOtrasOfertasService();
			List lista;
			FormBeanAdmCargaOtrasOfertas formBeanAdmCargaOtrasOfertas = (FormBeanAdmCargaOtrasOfertas) form;
			lista=iCargaOtrasOfertasService.listarFechasProgramadas();
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
			iCargaOtrasOfertasService = SingletonBeanFactory.getInstancia().getCargaOtrasOfertasService();
		List lista;
		FormBeanAdmCargaOtrasOfertas formBeanAdmCargaOtrasOfertas = (FormBeanAdmCargaOtrasOfertas) form;
		String arreglo[]=request.getParameterValues("arregloEliminar");
		if(iCargaOtrasOfertasService.eliminarProgramacionCarga(arreglo)==1){
			request.setAttribute("mensaje",  Constantes.MENASJE_ELIMINAR_PROCESO);
		}
		
		lista=iCargaOtrasOfertasService.listarFechasProgramadas();
		request.getSession().setAttribute("listaCargas", lista);

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
			iCargaOtrasOfertasService = SingletonBeanFactory.getInstancia().getCargaOtrasOfertasService();
			Tiilc_adm_carga_archivo beanCarga  =iCargaOtrasOfertasService.visualizarEstadoCarga();
			request.setAttribute("beanCarga", beanCarga); 
			request.setAttribute("tipo", Constantes.CODIGO_VARIOFER);
			forward = mapping.findForward(Constantes.FW_ESTADO_CARGA); 
			return (forward);
		}catch(Exception e){
			log.error("Error en visualizarEstadoCarga");
			forward = mapping.findForward(Constantes.FW_ERROR); 
		return (forward);
		} 
	}

	public ActionForward validarEstadoProceso(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			iCargaOtrasOfertasService = SingletonBeanFactory.getInstancia().getCargaOtrasOfertasService();
			List lista=iCargaOtrasOfertasService.listarFechasProgramadas();
			request.getSession().setAttribute("listaCargas", lista);
			
			String id=request.getParameter("id");
			String fecha=request.getParameter("fecha");
			boolean resultadoValidacion= iCargaOtrasOfertasService.verificarProcesamientoCarga(Integer.parseInt(id));
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
			iCargaOtrasOfertasService = SingletonBeanFactory.getInstancia().getCargaOtrasOfertasService();
			String fecha = request.getParameter("fecha");
			String fecha_original= request.getParameter("fecha_original");
			String id = request.getParameter("id"); 
			int resultadoOperacion=0;
			if(fecha==null || fecha.equals("null") || fecha.equals("")){
				request.setAttribute("mensaje","Debe registrar una fecha");
				request.setAttribute("modificacion","mostrarDIV");
			}else{ 
				resultadoOperacion=iCargaOtrasOfertasService.actualizarProgramacion(Integer.parseInt(id),fecha,fecha_original);
				
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
			
			List lista=iCargaOtrasOfertasService.listarFechasProgramadas();
			request.getSession().setAttribute("listaCargas", lista);
			
			
			forward = mapping.findForward(Constantes.FW_FECHAS_PROGRAMADAS); 
			return (forward);
		}catch(Exception e){
				log.error("Error en validarEstadoProceso");
				forward = mapping.findForward(Constantes.FW_ERROR); 
				return (forward);
		}
		
	}
	
	public ActionForward descargarLogError(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = new ActionForward(); // return value
		try {
			String tipo=request.getParameter("tipo");
			iCargaOtrasOfertasService = SingletonBeanFactory.getInstancia().getCargaOtrasOfertasService();
			Calendar hoy = Calendar.getInstance();
			String fecha= Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY)) + 
							Utilitario.dosCeros(hoy.get(Calendar.MINUTE))+
							Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+
							Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+
							hoy.get(Calendar.YEAR);
					ConexionDAO con = new ConexionDAO();
					String file = "";
					String path = con.findRecord(Constantes.PATHUPLOADS).getValor1().trim();
					FileWriter fichero = null;
					PrintWriter pw = null;
					try {
						
						if(Constantes.CODIGO_VARIOFER.equals(tipo)){
							file = "LOG_" + Constantes.NOMBRE_VARIOFER + "_" + fecha + ".txt";
						}else if(Constantes.CODIGO_ALMACCC.equals(tipo)){
							file = "LOG_" + Constantes.NOMBRE_ALMACCC + "_" + fecha + ".txt";
						}else if(Constantes.CODIGO_ESTM.equals(tipo)){
							file = "LOG_" + Constantes.NOMBRE_ESTM + "_" + fecha + ".txt";
						}
						path = path + "/";
						fichero = new FileWriter(path + file);
			
						List lista = iCargaOtrasOfertasService.listarLogError(tipo);
						pw = new PrintWriter(fichero);
			
						if(lista!=null){
							for (int i = 0; i < lista.size(); i++) {
								Tiilc_error_carga bean=(Tiilc_error_carga)lista.get(i);
								pw.println( bean.getLinea());
							}
						}
					} catch (Exception e) {
						log.error(e);
					} finally {
						try {
							if (null != fichero) {
								fichero.close();
								request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
								request.getSession().setAttribute(Constantes.EXPORTACION_RUTA, path); 
							}
						} catch (Exception e2) {
							log.error(e2);
						}
						request.setAttribute("origenVinculacion", "log");
					} 
			
				return mapping.findForward("descarga");  
		}catch(Exception e){
				log.error("Error en descargarLogError");
				log.error(e.getMessage());
				e.printStackTrace();
				request.setAttribute("mensaje", "Error: " + e.getMessage());
				forward = mapping.findForward(Constantes.FW_ERROR); 
				return (forward);
		}
		
	}
	
}
