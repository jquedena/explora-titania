package com.indra.pe.bbva.reauni.view.mbean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.SituacionDto;
import com.indra.pe.bbva.reauni.service.SituacionesBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.model.SituacionModel;

@SuppressWarnings({"rawtypes", "unchecked"})
@Controller("situacionesMBean")
@Scope("request")
public class SituacionesMBean extends GenericMBean implements Serializable{

	private static final long serialVersionUID = 6261687741618010423L;

	private static Logger logger = Logger.getLogger(SituacionesMBean.class);
	
	@Resource
	private SituacionModel situacionModel;
	
	@Autowired
	private SituacionesBO situacionesBO;
	
	@Autowired 
	private SessionMBean sessionMBean;
	
	public SituacionesMBean() {
	}
	
	
	public String iniciar () {
		
		if(getSituacionModel()!=null){
			getSituacionModel().setLista(new ArrayList());
		}
		
		return Constantes.UrlNavegacion.URL_LISTA_SITUACIONES;
	}
	
	public void buscarListaSituaciones(ActionEvent actionEvent) {
		try {
			getSituacionModel().getDtoFiltro().setCodigoAplicativo(getSituacionModel().getDtoFiltro().getCodigoAplicativo().trim());
			getSituacionModel().getDtoFiltro().setCodigoSituacion(getSituacionModel().getDtoFiltro().getCodigoSituacion().trim());
			getSituacionModel().getDtoFiltro().setDescripcion(getSituacionModel().getDtoFiltro().getDescripcion().trim());
			getSituacionModel().setLista(getSituacionModel().getSituacionesBO().obtenerListaSituaciones(getSituacionModel().getDtoFiltro()));
		} catch (ServiceException e) {
			String msg = "NO SE PUDO RECUPERAR LAS SITUACIONES";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);
		}
	}

	public String nuevo(){
		this.sessionMBean.setAccion(Constantes.Formulario.NUEVO);
		this.sessionMBean.setEditable(Constantes.Formulario.HABILITAR);
		getSituacionModel().setDto( new SituacionDto());
		getSituacionModel().setLista(new ArrayList<SituacionDto>());
		return Constantes.UrlNavegacion.URL_SITUACIONES;
	}
	
	public String editar(){
		this.sessionMBean.setAccion(Constantes.Formulario.EDITAR);
		this.sessionMBean.setEditable(Constantes.Formulario.DESHABILITAR);
		return Constantes.UrlNavegacion.URL_SITUACIONES;
	}
	
	public String ver(){
		this.sessionMBean.setAccion(Constantes.Formulario.VER);
		this.sessionMBean.setEditable(Constantes.Formulario.DESHABILITAR);
		return Constantes.UrlNavegacion.URL_SITUACIONES;
	}
 
	public String guardar(){
		try {
			String mensaje = "";
			
				if(this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO){
					mensaje = situacionesBO.verificarExistenciaSituacion(getSituacionModel().getDto().getCodigoSituacion());
					if(mensaje.trim().length()<=0){
						getSituacionModel().getSituacionesBO().insertarSituacion(getSituacionModel().getDto());
						showMessage("SE REGISTRÓ LA SITUACIÓN SATISFACTORIAMENTE.");
					}else{
						showError(mensaje);
						return "";
					}
				}else{
					if(this.sessionMBean.getAccion() == Constantes.Formulario.EDITAR){
						getSituacionModel().getSituacionesBO().actualizarSituacion(getSituacionModel().getDto());	
						showMessage("SE ACTUALIZÓ LA SITUACIÓN SATISFACTORIAMENTE.");
					}
				}
			
			buscarListaSituaciones(null);
		} catch (ServiceException e) {
			String msg = "NO SE PUDO GUARDAR LA SITUACIÓN";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_SITUACIONES;
	}
	
	public String eliminar(){
		try {


			getSituacionModel().getSituacionesBO().eliminarSituacion(getSituacionModel().getDto().getId());
			this.buscarListaSituaciones(null);
			showMessage("SE ELIMINÓ SATISFACTORIAMENTE.");
		} catch (Exception e) {
			String msg = "NO SE PUDO ELIMINAR LA SITUACION";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);
		}
		return Constantes.UrlNavegacion.URL_LISTA_SITUACIONES; 
	}
	
	public String retroceder(){
		return Constantes.UrlNavegacion.URL_LISTA_SITUACIONES;
	}

	public SituacionModel getSituacionModel() {
		return situacionModel;
	}
	
}
