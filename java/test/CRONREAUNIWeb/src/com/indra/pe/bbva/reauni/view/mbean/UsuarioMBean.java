package com.indra.pe.bbva.reauni.view.mbean;


import java.util.ArrayList;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.PermisoPerfilDto;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.model.UsuarioModel;

@Controller("usuarioMBean")
@Scope("request")
public class UsuarioMBean extends GenericMBean{
	
	private static Logger logger = Logger.getLogger(UsuarioMBean.class);
	
//	@Autowired 
	@Resource
	public UsuarioModel usuarioModel;
	
	public UsuarioMBean() {
//		usuarioModel.reset();
	}
	
	public void buscarListaUsuarios(ActionEvent actionEvent) {
		try {

			getUsuarioModel().setLista(getUsuarioModel().getPermisoPerfilBO().obtenerListaPermisoPerfil(getUsuarioModel().getDtoFiltro()));

		} catch (ServiceException e) {
			String msg = "No se pudo recuperar los usuarios";
			showError(msg);
			logger.error("",e);
		}
	}

	public String nuevo(){
		SessionMBean.ACCION = Constantes.Formulario.NUEVO;
		getUsuarioModel().setDto(new PermisoPerfilDto());
		getUsuarioModel().setLista(new ArrayList<PermisoPerfilDto>());
		return Constantes.UrlNavegacion.URL_USUARIO;
	}
	
	public String editar(){
		SessionMBean.ACCION = Constantes.Formulario.EDITAR;
		return Constantes.UrlNavegacion.URL_USUARIO;
	}
	
	public String ver(){
		SessionMBean.ACCION = Constantes.Formulario.VER;
		
		return Constantes.UrlNavegacion.URL_USUARIO;
	}
 
	public String guardar(){
		try {
			if(SessionMBean.ACCION == Constantes.Formulario.NUEVO){
				getUsuarioModel().getPermisoPerfilBO().insertarPermisoPerfil(getUsuarioModel().getDto());
				showMessage("Se registró el usuario satisfactoriamente.");
			}else{
				if(SessionMBean.ACCION == Constantes.Formulario.EDITAR){
					getUsuarioModel().getPermisoPerfilBO().actualizarPermisoPerfil(getUsuarioModel().getDto());	
					showMessage("Se actualizó el usuario satisfactoriamente.");
				}
			}
		} catch (ServiceException e) {
			String msg = "No se pudo guardar el usuario";
			showError(msg);
			logger.error("",e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_USUARIOS;
	}
	
	public String eliminar(){
		try {

			getUsuarioModel().getPermisoPerfilBO().eliminarPermisoPerfil(getUsuarioModel().getDto().getId());
		} catch (Exception e) {
			String msg = "No se pudo eliminar el usuario";
			showError(msg);
			logger.error("",e);	
		}
		return Constantes.UrlNavegacion.URL_LISTA_USUARIOS; 
	}
	
	public String retroceder(){
		return Constantes.UrlNavegacion.URL_LISTA_USUARIOS;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	
 
}
