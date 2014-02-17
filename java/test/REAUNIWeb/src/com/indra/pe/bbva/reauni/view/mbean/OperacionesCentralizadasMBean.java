package com.indra.pe.bbva.reauni.view.mbean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.OperacionCentralizadaDto;
import com.indra.pe.bbva.reauni.service.OperacionesCentralesBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.model.OperacionesCentralizadasModel;

@Controller("operacionesCentralizadasMBean")
@Scope("request")
public class OperacionesCentralizadasMBean extends GenericMBean implements Serializable{
 
	private static final long serialVersionUID = -7431835724865150515L;
	
	private static Logger logger = Logger.getLogger(OperacionesCentralizadasMBean.class);
	
	@Resource
	private OperacionesCentralizadasModel operacionesCentralizadasModel;
 
	@Autowired
	private OperacionesCentralesBO operacionesCentralesBO;
	
	@Autowired
	private SessionMBean sessionMBean;
	
	public OperacionesCentralizadasMBean() {
		
	}
	
	public void buscarListaOperacionesCentralizadas(ActionEvent actionEvent) {
		try {
			getOperacionesCentralizadasModel().setLista(getOperacionesCentralizadasModel().getOperacionesCentralesBO().obtenerListaSituaciones(getOperacionesCentralizadasModel().getDtoFiltro()));
		} catch (ServiceException e) {
			String msg = "NO SE PUDO RECUPERAR LA COMBINACIÓN REGISTRO/PRODUCTO.";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);
		}
	}

	public String nuevo(){
		this.sessionMBean.setAccion(Constantes.Formulario.NUEVO);
		getOperacionesCentralizadasModel().setDto(new OperacionCentralizadaDto());
		getOperacionesCentralizadasModel().setLista(new ArrayList<OperacionCentralizadaDto>());
		return Constantes.UrlNavegacion.URL_OPERACIONES_CENTRALES;
	}
	
	public String editar(){
		this.sessionMBean.setAccion(Constantes.Formulario.EDITAR);
		
		return Constantes.UrlNavegacion.URL_OPERACIONES_CENTRALES;
	}
	
	public String ver(){
		this.sessionMBean.setAccion(Constantes.Formulario.VER);
		
		return Constantes.UrlNavegacion.URL_OPERACIONES_CENTRALES;
	}
 
	public String guardar(){
		try {
			String mensaje = operacionesCentralesBO.validarExistenciaRegistro(getOperacionesCentralizadasModel().getDto().getRegistro());			
			if(mensaje.trim().length()<=0){
				
					
					getOperacionesCentralizadasModel().getDto().setUsuarioModificacion(sessionMBean.getRegistro());
					getOperacionesCentralizadasModel().getDto().setFechaModificacion(Utilitarios.Fecha
							.obtenerFechaActualDate());
					
					if(this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO){
						boolean noSeRepiteCombinacion = operacionesCentralesBO.noSeRepiteCombinacion(getOperacionesCentralizadasModel().getDto());
						if (noSeRepiteCombinacion) {
						getOperacionesCentralizadasModel().getDto().setProducto(getOperacionesCentralizadasModel().getDto().getProducto().toUpperCase());
						getOperacionesCentralizadasModel().getDto().setRegistro(getOperacionesCentralizadasModel().getDto().getRegistro().toUpperCase());
						getOperacionesCentralizadasModel().getDto().setUsuarioCreacion(sessionMBean.getRegistro());
						getOperacionesCentralizadasModel().getDto().setFechaCreacion(Utilitarios.Fecha
								.obtenerFechaActualDate());
						getOperacionesCentralizadasModel().getOperacionesCentralesBO().insertarOperacionesCentrales(getOperacionesCentralizadasModel().getDto());
						showMessage("SE REGISTRÓ LA COMBINACIÓN REGISTRO/PRODUCTO.");
						}else {
							showError("LA COMBINACIÓN REGISTRO / PRODUCTO YA SE ENCUENTRA REGISTRADA");	
							return "";
						}
					}else{
						if(this.sessionMBean.getAccion() == Constantes.Formulario.EDITAR){
							getOperacionesCentralizadasModel().getOperacionesCentralesBO().actualizarOperacionesCentrales(getOperacionesCentralizadasModel().getDto());	
							showMessage("SE ACTUALIZÓ LA COMBINACIÓN USUARIO/PRODUCTO.");
						}
					}
					buscarListaOperacionesCentralizadas(null);
					//Obteniendo el producto de operaciones centralizadas
	            	OperacionesCentralesBO operacionesCentralesBO = (OperacionesCentralesBO)WebServletContextListener.getApplicationContext().getBean("operacionesCentralesBO");
	            	OperacionCentralizadaDto oc = new OperacionCentralizadaDto();
	            	oc.setRegistro(sessionMBean.getRegistro());                	
	            	sessionMBean.setProductosOperacionesCentralizadas(operacionesCentralesBO.obtenerListaSituaciones(oc));
				
				
            	
			}else{
				showError("USUARIO NO REGISTRADO EN LDAP.");	
				return "";
			}
		} catch (Exception e) {
			String msg = "NO SE PUDO GUARDAR LA COMBINACIÓN USUARIO/PRODUCTO.";
			showError(msg);
			logger.error("", e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_OPERACIONES_CENTRALES;
	}
	
	public String eliminar(){
		try {
			getOperacionesCentralizadasModel().getOperacionesCentralesBO().eliminarOperacionesCentrales(getOperacionesCentralizadasModel().getDto().getId());
			showMessage("SE ELIMINÓ SATISFACTORIAMENTE.");
			buscarListaOperacionesCentralizadas(null);
		} catch (Exception e) {
			String msg = "NO SE PUDO ELIMINAR LA COMBINACIÓN USUARIO/PRODUCTO";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_OPERACIONES_CENTRALES;
	}
	
	public String retroceder(){

		return Constantes.UrlNavegacion.URL_LISTA_OPERACIONES_CENTRALES;
	}

	public OperacionesCentralizadasModel getOperacionesCentralizadasModel() {
		return operacionesCentralizadasModel;
	}
 
}
