package com.indra.pe.bbva.reauni.view.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.TipoPrestamoDto;
import com.indra.pe.bbva.reauni.service.TipoPrestamoBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.model.TipoPrestamoModel;

@SuppressWarnings({"unchecked", "rawtypes"})
@Controller("tipoPrestamoMBean")
@Scope("request")
public class TipoPrestamoMBean extends GenericMBean implements Serializable{
	
	private static final long serialVersionUID = 6261687741618010423L;

	private static Logger logger = Logger.getLogger(TipoPrestamoMBean.class);
	
	@Resource
	private TipoPrestamoModel tipoPrestamoModel;
	
	@Autowired
	private TipoPrestamoBO tipoPrestamoBO;
	
	@Autowired
	private SessionMBean sessionMBean;
	
	public TipoPrestamoMBean() {
 
	}
	
	public String iniciar () {
		
		if(getTipoPrestamoModel()!=null){
			getTipoPrestamoModel().setLista(new ArrayList());
			getTipoPrestamoModel().setDtoFiltro(new TipoPrestamoDto());
		}
		
		return Constantes.UrlNavegacion.URL_LISTA_TIPO_PRESTAMO;
	}

	public void buscarListaTipoPrestamo(ActionEvent actionEvent) {

		try {
			getTipoPrestamoModel().setLista(getTipoPrestamoModel().getTipoPrestamoBO().obtenerListaTipoPrestamos(getTipoPrestamoModel().getDtoFiltro()));
		} catch (ServiceException e) {
			String msg = "No se pudo recuperar los tipos de préstamo";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg), e);        	
		}
	}
	

	public String nuevo(){
		this.sessionMBean.setAccion(Constantes.Formulario.NUEVO);		
		this.sessionMBean.setEditable(Constantes.Formulario.HABILITAR);
		getTipoPrestamoModel().setDto(new TipoPrestamoDto());
		getTipoPrestamoModel().setLista(new ArrayList<TipoPrestamoDto>());
		return Constantes.UrlNavegacion.URL_TIPO_PRESTAMO;
	}
	
	public String editar(){
		this.sessionMBean.setAccion(Constantes.Formulario.EDITAR);
		this.sessionMBean.setEditable(Constantes.Formulario.DESHABILITAR);
		return Constantes.UrlNavegacion.URL_TIPO_PRESTAMO;
	}
	
	public String ver(){
		this.sessionMBean.setAccion(Constantes.Formulario.VER);
		this.sessionMBean.setEditable(Constantes.Formulario.DESHABILITAR);
		return Constantes.UrlNavegacion.URL_TIPO_PRESTAMO;
	}
 
	public String guardar(){
 		
		try {
 
				if(this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO){
					String mensaje = tipoPrestamoBO.validarExistenciaTipoPrestamo(this.getTipoPrestamoModel().getDto().getCodigo());
					if(mensaje.trim().length()<=0){
						getTipoPrestamoModel().getDto().setEstado(Constantes.Estado.ACTIVO);
						getTipoPrestamoModel().getDto().setFechaCreacion(new Date());
						getTipoPrestamoModel().getDto().setUsuarioCreacion(sessionMBean.getRegistro());
						getTipoPrestamoModel().getTipoPrestamoBO().insertarTipoPrestamo(getTipoPrestamoModel().getDto());
						showMessage("Se registró el tipo de préstamo satisfactoriamente.");
					}else{
						showError(mensaje);
						return "";
					}	
				}else{
					if(this.sessionMBean.getAccion() == Constantes.Formulario.EDITAR){
						getTipoPrestamoModel().getDto().setEstado(Constantes.Estado.ACTIVO);
						getTipoPrestamoModel().getDto().setFechaModificacion(new Date());
						getTipoPrestamoModel().getDto().setUsuarioModificacion(sessionMBean.getRegistro());
						getTipoPrestamoModel().getTipoPrestamoBO().actualizarTipoPrestamo(getTipoPrestamoModel().getDto());
						showMessage("Se actualizó el tipo de préstamo satisfactoriamente.");	
					}
				}	
			buscarListaTipoPrestamo(null);
		} catch (ServiceException e) {
			String msg = "No se pudo guardar el tipo prestamo";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg), e);        		
		}
		return Constantes.UrlNavegacion.URL_LISTA_TIPO_PRESTAMO;
	}
	
	public String eliminar(){

		try {

			getTipoPrestamoModel().getTipoPrestamoBO().eliminarTipoPrestamo(getTipoPrestamoModel().getDto().getId());
			showMessage("Se eliminó el tipo de préstamo satisfactoriamente.");
			buscarListaTipoPrestamo(null);
		} catch (ServiceException e) {
			String msg = "No se pudo eliminar el tipo de préstamo";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg), e);        	
		}
		return Constantes.UrlNavegacion.URL_LISTA_TIPO_PRESTAMO; 
	}
	
	public String retroceder(){
		buscarListaTipoPrestamo(null);
		return Constantes.UrlNavegacion.URL_LISTA_TIPO_PRESTAMO;
	}

	public TipoPrestamoModel getTipoPrestamoModel() {
		return tipoPrestamoModel;
	}
	
	
}
