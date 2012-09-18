package com.indra.pe.bbva.reauni.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;
import com.indra.pe.bbva.reauni.model.entidad.PermisoPerfilDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.service.PerfilBO;
import com.indra.pe.bbva.reauni.service.PermisoPerfilBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;

@Controller("usuarioModel")
@Scope("session")
public class UsuarioModel implements Serializable{
	private static Logger logger = Logger.getLogger(UsuarioModel.class);
	private static final long serialVersionUID = 1207846828658820705L;
	
	private Long seleccione  = -1L;
	
	private PermisoPerfilDto dto;
	private PermisoPerfilDto dtoFiltro;
	private List<PermisoPerfilDto> lista;

	private SelectItem[] listaTipoAcceso;
	private SelectItem[] listaPerfiles;
	
	@Autowired
	private PermisoPerfilBO permisoPerfilBO;
	
	@Autowired
	private PerfilBO perfilBO;
	
	@Autowired
	private ParametroBO parametroBO;
	
	public UsuarioModel() {
		this.reset();
	}
 
	public void reset(){
		this.dto = new PermisoPerfilDto();
		this.dtoFiltro = new PermisoPerfilDto();
		this.lista = new ArrayList<PermisoPerfilDto>();
	}
	
	
	public PermisoPerfilDto getDto() {
		return dto;
	}
 
	public void setDto(PermisoPerfilDto dto) {
		this.dto = dto;
	}
 
	public PermisoPerfilDto getDtoFiltro() {
		return dtoFiltro;
	}
 
	public void setDtoFiltro(PermisoPerfilDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}
 
	public List<PermisoPerfilDto> getLista() {
		return lista;
	}
 
	public void setLista(List<PermisoPerfilDto> lista) {
		this.lista = lista;
	}
 
	public PermisoPerfilBO getPermisoPerfilBO() {
		return permisoPerfilBO;
	}

	public SelectItem[] getListaTipoAcceso(){
		try{
			if(listaTipoAcceso == null){
				ParametroDto parametroDto = new ParametroDto();
				CatalogoParametroDto catalogoParametroDto = new CatalogoParametroDto();
				catalogoParametroDto.setId(Constantes.VariablesCatalogoParametros.VARIABLE_ID_TIPO_ACCESO); 
				parametroDto.setCatalogoParametroDto(catalogoParametroDto);
				listaTipoAcceso = SelectOneMenuHelper.listaParametro(parametroBO.obtenerListaParametros(parametroDto));
			}
		}catch(Exception e){
			logger.error("Error " + e.getMessage());
		}
		return listaTipoAcceso;
	}

	public SelectItem[] getListaPerfiles(){
		try{
			if(listaPerfiles == null){
				listaPerfiles = SelectOneMenuHelper.listaPerfiles(perfilBO.obtenerListaPerfiles(new PerfilDto()));
			}
		}catch(Exception e){
			logger.error("Error " + e.getMessage());
		}	
		return listaPerfiles;
	}

	public Long getSeleccione() {
		return seleccione;
	}

	public void setSeleccione(Long seleccione) {
		this.seleccione = seleccione;
	}
 
}
