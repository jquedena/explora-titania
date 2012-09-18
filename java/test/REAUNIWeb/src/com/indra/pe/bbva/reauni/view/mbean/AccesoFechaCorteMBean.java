package com.indra.pe.bbva.reauni.view.mbean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.ldap.model.entidad.LdapDto;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDetaDto;
import com.indra.pe.bbva.reauni.service.AccesoFechaCorteBO;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.service.PerfilBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.model.AccesoFechaCorteModel;

@SuppressWarnings({"unused", "rawtypes", "unchecked"})
@Controller("accesoFechaCorteMBean")
@Scope("session")
public class AccesoFechaCorteMBean extends GenericMBean implements Serializable {

private static final long serialVersionUID = -757019952522172281L;
	
	private static Logger logger = Logger.getLogger(FechaCorteMBean.class);
	
	@Autowired
	private AccesoFechaCorteBO accesoFechaCorteBO;
	
	@Autowired
	private ParametroBO parametroBO;
	
	@Autowired
	private PerfilBO perfilBO;
	
	@Autowired
	private AccesoFechaCorteModel accesoFechaCorteModel;
	
	@Autowired
	private SessionMBean sessionMBean;
	
	@Autowired
	private LdapService ldapService;
	
	public AccesoFechaCorteMBean() {
	}
	
	
	public String iniciar () {
		
		if(getAccesoFechaCorteModel()!=null){
			getAccesoFechaCorteModel().setLista(new ArrayList());
		}
		
		return Constantes.UrlNavegacion.URL_LISTA_ACCESO_FECHA_CORTE;
	}

	public void buscarListaAccesoFechaCorte(ActionEvent actionEvent) {
		try {
			this.getAccesoFechaCorteModel().setLista(accesoFechaCorteBO.obtenerListaAccesoFechaCorteBusqueda(this.getAccesoFechaCorteModel().getDtoFiltro()));
		} catch (ServiceException e) {
			String msg = "NO SE PUDO RECUPERAR LOS ACCESOS DE LAS FECHAS DE CORTE";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);
		}
	}

	public String nuevo(){
		this.sessionMBean.setAccion(Constantes.Formulario.NUEVO);
		FechaCorteDetaDto obj  = new FechaCorteDetaDto();
		obj.setCantidadSolicitud(1);
		this.getAccesoFechaCorteModel().setDto(obj);		
		return Constantes.UrlNavegacion.URL_ACCESO_FECHA_CORTE;
	}
	
	public String editar(){
		this.sessionMBean.setAccion(Constantes.Formulario.EDITAR);
		
		return Constantes.UrlNavegacion.URL_ACCESO_FECHA_CORTE;
	}
	
	public String ver(){
		this.sessionMBean.setAccion(Constantes.Formulario.VER);
		
		return Constantes.UrlNavegacion.URL_ACCESO_FECHA_CORTE;
	}
 
	
	public String guardar(){
		try{
			if(this.getAccesoFechaCorteModel().getDto().getFechaCorteDto()==null || this.getAccesoFechaCorteModel().getDto().getFechaCorteDto().getId()==null ){
				showError("FECHA DE CORTE: SELECCIONE UNA FECHA DE CORTE");
				return "";
			}
			Long id = 0L;
			if (this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO) {
				id = 0L;
			}else {
				id = this.getAccesoFechaCorteModel().getDto().getId();
			}
			
			if (!accesoFechaCorteBO.existeRegistroFechaCorte(this.getAccesoFechaCorteModel().getDto().getRegistroResponsable(), this.getAccesoFechaCorteModel().getDto().getFechaCorteDto(), id)){
				if(this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO){				
					this.getAccesoFechaCorteModel().getDto().setFechaCreacion(Utilitarios.Fecha.obtenerFechaActualDate());
					
					this.getAccesoFechaCorteModel().getDto().setUsuarioCreacion(sessionMBean.getRegistro());
					
					accesoFechaCorteBO.insertarAccesoFechaCorte(this.getAccesoFechaCorteModel().getDto());
					
					showMessage("SE REGISTRÓ EL ACCESO FECHA DE CORTE SATISFACTORIAMENTE");
					buscarListaAccesoFechaCorte(null);
					return Constantes.UrlNavegacion.URL_LISTA_ACCESO_FECHA_CORTE;
				}else if(this.sessionMBean.getAccion() == Constantes.Formulario.EDITAR){					
						this.getAccesoFechaCorteModel().getDto().setFechaModificacion(Utilitarios.Fecha.obtenerFechaActualDate());
						this.getAccesoFechaCorteModel().getDto().setUsuarioModificacion(sessionMBean.getRegistro());
						accesoFechaCorteBO.actualizarAccesoFechaCorte(this.getAccesoFechaCorteModel().getDto());
						showMessage("SE ACTUALIZÓ EL EL ACCESO FECHA DE CORTE SATISFACTORIAMENTE.");
						buscarListaAccesoFechaCorte(null);
						return Constantes.UrlNavegacion.URL_LISTA_ACCESO_FECHA_CORTE;
					
				}else {
					return null;
				}
			}else {
				showWarning("NO SE PUEDE CREAR EL ACCESO; PORQUE YA EXISTE UN ACCESO PARA EL REGISTRO Y LA FECHA DE CORTE SELECCIONADA");
				return null;
			}
			 
			
			
		}catch(Exception e){
			String msg = e.getMessage();
			showError(msg);			
			logger.error(e);
			return null;
		}	
		
	}
	
	public String eliminar(){
		try {
			accesoFechaCorteBO.eliminarAccesoFechaCorte(this.getAccesoFechaCorteModel().getDto());
			buscarListaAccesoFechaCorte(null);
			showMessage("SE ELIMINÓ EL ACCESO DE FECHA DE CORTE SATISFACTORIAMENTE.");
			
		} catch (Exception e) {
			String msg = "NO SE PUDO ELIMINAR EL ACCESO FECHA DE CORTE";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);	
		}
		
		return Constantes.UrlNavegacion.URL_LISTA_ACCESO_FECHA_CORTE; 
	}
	
	public void cargar(){

		try {
			LdapDto ldapDto = ldapService.obtenerInformacionPorRegistro(this.getAccesoFechaCorteModel().getDto().getRegistroResponsable().trim());
			this.getAccesoFechaCorteModel().getDto().setNombreResponsable(ldapDto.getApepat() + " " +ldapDto.getApemat() +" " + ldapDto.getNombre());
		} catch (ServiceException e) {
			showError("EL REGISTRO INGRESADO NO SE ENCUENTRA EN EL LDAP");
		}
	}
	
	public String retroceder(){

		return Constantes.UrlNavegacion.URL_LISTA_ACCESO_FECHA_CORTE;
	}
 
	public AccesoFechaCorteModel getAccesoFechaCorteModel() {
		return accesoFechaCorteModel;
	}
	
	public String seleccionarFechaCorte(){

		this.getAccesoFechaCorteModel().getDto().setFechaCorteDto(this.getAccesoFechaCorteModel().getFechaCorteSeleccionado());
		
		return null;
	}



}
