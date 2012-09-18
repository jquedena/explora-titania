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

import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.model.FechaCorteModel;

@Controller("fechaCorteMBean")
@Scope("request")
public class FechaCorteMBean extends GenericMBean implements Serializable{
 
	private static final long serialVersionUID = -757019952522172281L;
	
	private static Logger logger = Logger.getLogger(FechaCorteMBean.class);
	
	@Resource
	private FechaCorteModel fechaCorteModel;
	
	@Autowired
	private SessionMBean sessionMBean;
  
	public FechaCorteMBean() {
	}

	public void buscarListaFechaCorte(ActionEvent actionEvent) {
		try {
			getFechaCorteModel().setLista(getFechaCorteModel().getFechaCorteBO().obtenerListaFechaCortePorRangoFecha(getFechaCorteModel().getDtoFiltro()));
		} catch (ServiceException e) {
			String msg = "NO SE PUDO RECUPERAR LAS FECHAS DE CORTE";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);
		}
	}

	public String nuevo(){
		this.sessionMBean.setAccion(Constantes.Formulario.NUEVO);
		getFechaCorteModel().setDto(new FechaCorteDto());
		getFechaCorteModel().setLista(new ArrayList<FechaCorteDto>());
		return Constantes.UrlNavegacion.URL_FECHA_CORTE;
	}
	
	public String editar(){
		this.sessionMBean.setAccion(Constantes.Formulario.EDITAR);		
		return Constantes.UrlNavegacion.URL_FECHA_CORTE;
	}
	
	public String ver(){
		this.sessionMBean.setAccion(Constantes.Formulario.VER);
		
		return Constantes.UrlNavegacion.URL_FECHA_CORTE;
	}
 
	public String guardar(){
		try {
			
			if(!Utilitarios.Fecha.validarRangoFechas(getFechaCorteModel().getDto().getFechaInicio(),getFechaCorteModel().getDto().getFechaFin())){
				try {
					Long idExcepto = null;
					if(this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO){
						idExcepto = 0L;
					}else {
						idExcepto = getFechaCorteModel().getDto().getId();
					}
					FechaCorteDto fcInicio = getFechaCorteModel().getFechaCorteBO().obtenerFechaCorte(getFechaCorteModel().getDto().getFechaInicio(), idExcepto);
					FechaCorteDto fcFin = getFechaCorteModel().getFechaCorteBO().obtenerFechaCorte(getFechaCorteModel().getDto().getFechaFin(), idExcepto);
					
					if (fcInicio==null && fcFin==null) {
						if(this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO){
							getFechaCorteModel().getDto().setFechaCreacion(new Date());
							getFechaCorteModel().getDto().setUsuarioCreacion(sessionMBean.getRegistro());
							getFechaCorteModel().getFechaCorteBO().insertarFechaCorte(getFechaCorteModel().getDto());
							showMessage("SE REGISTRÓ LA FECHA DE CORTE SATISFACTORIAMENTE.");
						}else{
							if(this.sessionMBean.getAccion() == Constantes.Formulario.EDITAR){
								getFechaCorteModel().getDto().setFechaModificacion(new Date());
								getFechaCorteModel().getDto().setUsuarioModificacion(sessionMBean.getRegistro());
								getFechaCorteModel().getFechaCorteBO().actualizarFechaCorte(getFechaCorteModel().getDto());
								showMessage("SE ACTUALIZÓ LA FECHA DE CORTE SATISFACTORIAMENTE.");	
							}
						}
						buscarListaFechaCorte(null);
					}else if (fcInicio != null) {
						showError("YA EXISTE UNA FECHA DE CORTE ("+fcInicio.getNombreActividad()+" : "+ fcInicio.getFechaInicio()+" A "+fcInicio.getFechaFin()+") PARA LA FECHA DE INICIO."  );
						return "";
					}else if (fcFin !=null) {
						showError("YA EXISTE UNA FECHA DE CORTE ("+fcFin.getNombreActividad()+" : "+ fcFin.getFechaInicio()+" A "+fcFin.getFechaFin()+") PARA LA FECHA DE FIN."  );
						return "";
					}
				} catch (DAOException e) {
					logger.error(e);
				}
				
				
				
				
				
			}else{
				showError("EL RANGO DE FECHAS ES INCORRECTO!");
				return "";
			}	
		} catch (ServiceException e) {
			String msg = "NO SE PUDO GUARDAR LA FECHA DE CORTE";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_FECHA_CORTE;
	}
	
	
	public String eliminar(){
		try {
			getFechaCorteModel().getFechaCorteBO().eliminarFechaCorte(getFechaCorteModel().getDto().getId().longValue());
			showMessage("SE ELIMINÓ EL ACCESO FECHA DE CORTE SATISFACTORIAMENTE.");
		} catch (Exception e) {
			String msg = "NO SE PUDO ELIMINAR LA FECHA DE CORTE";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_FECHA_CORTE; 
	}
	
	public String retroceder(){
		buscarListaFechaCorte(null);
		return Constantes.UrlNavegacion.URL_LISTA_FECHA_CORTE;
	}
	
 
	public FechaCorteModel getFechaCorteModel() {
		return fechaCorteModel;
	} 
	
	
}
