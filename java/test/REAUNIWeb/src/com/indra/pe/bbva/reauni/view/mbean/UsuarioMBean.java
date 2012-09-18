package com.indra.pe.bbva.reauni.view.mbean;


import java.util.ArrayList;
 
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.reauni.model.entidad.PermisoPerfilDto;
import com.indra.pe.bbva.reauni.service.PermisoPerfilBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.model.UsuarioModel;

@SuppressWarnings({"unchecked", "rawtypes", "unused"})
@Controller("usuarioMBean")
@Scope("session")
public class UsuarioMBean extends GenericMBean{
	
	private static Logger logger = Logger.getLogger(UsuarioMBean.class);
	
	@Autowired 
	private UsuarioModel usuarioModel;
	
	@Autowired
	private LdapService ldapService;
	
	@Autowired
	private PermisoPerfilBO permisoPerfilBO;
	
	@Autowired
	private SessionMBean sessionMBean;
	
	public UsuarioMBean() {
	}
	
	public String iniciar () {
		
		if(getUsuarioModel()!=null){
			getUsuarioModel().setLista(new ArrayList());
		}
		
		return Constantes.UrlNavegacion.URL_LISTA_USUARIOS;
	}
 
	public void buscarListaUsuarios(ActionEvent actionEvent) {
		try {
			if(getUsuarioModel().getDtoFiltro().getTipoAcceso()!=null && getUsuarioModel().getDtoFiltro().getTipoAcceso()==-1L){
				getUsuarioModel().getDtoFiltro().setTipoAcceso(null);
			}
			if(getUsuarioModel().getDtoFiltro().getPerfil()!=null && 
			   getUsuarioModel().getDtoFiltro().getPerfil().getId()!=null && 
			   getUsuarioModel().getDtoFiltro().getPerfil().getId()==-1L){
				getUsuarioModel().getDtoFiltro().getPerfil().setId(null);
			}
			
			getUsuarioModel().setLista(getUsuarioModel().getPermisoPerfilBO().obtenerListaPermisoPerfil(getUsuarioModel().getDtoFiltro()));
		} catch (ServiceException e) {
			String msg = "NO SE PUDO RECUPERAR LOS USUARIOS";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);
		}
	}

	public String nuevo(){
		this.sessionMBean.setAccion(Constantes.Formulario.NUEVO);
		this.sessionMBean.setEditable(Constantes.Formulario.HABILITAR);
		getUsuarioModel().setDto(new PermisoPerfilDto());
		getUsuarioModel().getDto().setTipoAcceso(Constantes.VariablesCatalogoParametros.VARIABLE_REGISTRO);
		getUsuarioModel().setLista(new ArrayList<PermisoPerfilDto>());
		return Constantes.UrlNavegacion.URL_USUARIO;
	}
	
	public String editar(){
		this.sessionMBean.setAccion(Constantes.Formulario.EDITAR);
		this.sessionMBean.setEditable(Constantes.Formulario.HABILITAR);
		return Constantes.UrlNavegacion.URL_USUARIO;
	}
	
	public String ver(){
		this.sessionMBean.setAccion(Constantes.Formulario.VER);
		this.sessionMBean.setEditable(Constantes.Formulario.DESHABILITAR);
		return Constantes.UrlNavegacion.URL_USUARIO;
	}
 
	public String guardar(){
		try {
			if(!this.getUsuarioModel().getDto().getValor().equalsIgnoreCase("")){
				
				if(this.sessionMBean.getAccion() == Constantes.Formulario.NUEVO){
					if(this.getUsuarioModel().getDto().getTipoAcceso().equals(Constantes.VariablesCatalogoParametros.VARIABLE_CARGO)){
						String validarCargo = permisoPerfilBO.validarRegistroCargo(com.indra.pe.bbva.ldap.util.Constantes.ColumnasLdap.CARGO,this.getUsuarioModel().getDto().getValor());
						if(validarCargo.length()>0){
							showError(validarCargo);
							return "";
						}
					}else if(this.getUsuarioModel().getDto().getTipoAcceso().equals(Constantes.VariablesCatalogoParametros.VARIABLE_REGISTRO)){
						String validarRegistro = permisoPerfilBO.validarRegistroCargo(com.indra.pe.bbva.ldap.util.Constantes.ColumnasLdap.REGISTRO,this.getUsuarioModel().getDto().getValor());
						if(validarRegistro.length()>0){
							showError(validarRegistro);
							return "";
						} 
					}
					getUsuarioModel().getPermisoPerfilBO().insertarPermisoPerfil(getUsuarioModel().getDto());
					buscarListaUsuarios(null);
					showMessage("SE REGISTRÓ EL USUARIO SATISFACTORIAMENTE.");
				}else{
					if(this.sessionMBean.getAccion() == Constantes.Formulario.EDITAR){
						getUsuarioModel().getPermisoPerfilBO().actualizarPermisoPerfil(getUsuarioModel().getDto());
						buscarListaUsuarios(null);
						showMessage("SE ACTUALIZÓ EL USUARIO SATISFACTORIAMENTE.");
					}
				}
				
				getUsuarioModel().setLista(getUsuarioModel().getPermisoPerfilBO().obtenerListaPermisoPerfil(getUsuarioModel().getDtoFiltro()));
			}else{
				showError("EL CAMPO VALOR ES REQUERIDO");
				return "";
			}	
		} catch (ServiceException e) {
			String msg = "NO SE PUDO GUARDAR EL USUARIO";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_USUARIOS;
	}
	
	public String eliminar(){
		try {
			getUsuarioModel().getPermisoPerfilBO().eliminarPermisoPerfil2(getUsuarioModel().getDto());
			buscarListaUsuarios(null);
			showMessage("SE ELIMINÓ SATISFACTORIAMENTE.");
		} catch (Exception e) {
			String msg = "NO SE PUDO ELIMINAR EL USUARIO";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_USUARIOS; 
	}
	
	public String retroceder(){
		try{
			if(getUsuarioModel().getDtoFiltro().getTipoAcceso()!=null && getUsuarioModel().getDtoFiltro().getTipoAcceso()==-1L){
				getUsuarioModel().getDtoFiltro().setTipoAcceso(null);
			}
			if(getUsuarioModel().getDtoFiltro().getPerfil()!=null && 
			   getUsuarioModel().getDtoFiltro().getPerfil().getId()!=null && 
			   getUsuarioModel().getDtoFiltro().getPerfil().getId()==-1L){
				getUsuarioModel().getDtoFiltro().getPerfil().setId(null);
			}
			
			getUsuarioModel().setLista(getUsuarioModel().getPermisoPerfilBO().obtenerListaPermisoPerfil(getUsuarioModel().getDtoFiltro()));
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return Constantes.UrlNavegacion.URL_LISTA_USUARIOS;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public String cambiarTipoAcceso(ValueChangeEvent event ){
		this.getUsuarioModel().getDto().setValor("");
		Long codTipoAcceso = (Long)event.getNewValue();
		if(codTipoAcceso.equals(Constantes.VariablesCatalogoParametros.VARIABLE_CARGO)){
			this.sessionMBean.setTipoAcceso(1L);
		}else{
			this.sessionMBean.setTipoAcceso(0L);
		}
		return "";
	}
	
	public void cambiarTipoAcceso2(){		
		this.getUsuarioModel().getDto().setValor("");
		Long codTipoAcceso = usuarioModel.getDto().getTipoAcceso();
		
		if(codTipoAcceso.equals(Constantes.VariablesCatalogoParametros.VARIABLE_CARGO)){
			this.sessionMBean.setTipoAcceso(1L);
		}else{
			this.sessionMBean.setTipoAcceso(0L);
		}
		
	}
	
}
