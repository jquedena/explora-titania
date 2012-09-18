package com.indra.pe.bbva.reauni.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDetaDto;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;
import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;
import com.indra.pe.bbva.reauni.service.PerfilBO;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;

@Controller("accesoFechaCorteModel")
@Scope("session")
public class AccesoFechaCorteModel implements Serializable{
 
	private static final long serialVersionUID = 4763656254259581544L;
	private static Logger logger = Logger.getLogger(AccesoFechaCorteModel.class);
	private FechaCorteDetaDto dto;
	private FechaCorteDetaDto dtoFiltro;
	private List<FechaCorteDetaDto> lista;
	private List<SelectItem> listaEstados;
	private SelectItem[] listaPerfiles;
	
	private FechaCorteDto fechaCorteSeleccionado; 
	
	private Long seleccione = -1L;
	
	@Autowired
	private PerfilBO perfilBO;
	
	public AccesoFechaCorteModel() {
		this.reset();
	}
	
	public void reset(){
		this.dto = new FechaCorteDetaDto();
		this.dtoFiltro = new FechaCorteDetaDto(); 
		this.lista = new ArrayList<FechaCorteDetaDto>();
		this.fechaCorteSeleccionado = new FechaCorteDto();
	}

	public FechaCorteDetaDto getDto() {
		return dto;
	}

	public void setDto(FechaCorteDetaDto dto) {
		this.dto = dto;
	}

	public FechaCorteDetaDto getDtoFiltro() {
		return dtoFiltro;
	}
	
	public void setDtoFiltro(FechaCorteDetaDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}
	
	public List<FechaCorteDetaDto> getLista() {
		return lista;
	}

	public void setLista(List<FechaCorteDetaDto> lista) {
		this.lista = lista;
	}

	public List<SelectItem> getListaEstados() {
		return listaEstados;
	}

	
	
	public FechaCorteDto getFechaCorteSeleccionado() {
		return fechaCorteSeleccionado;
	}

	public void setFechaCorteSeleccionado(FechaCorteDto fechaCorteSeleccionado) {
		this.fechaCorteSeleccionado = fechaCorteSeleccionado;
	}

	public SelectItem[] getListaPerfiles() {
		try{
			if(listaPerfiles == null){
				listaPerfiles = SelectOneMenuHelper.listaPerfiles(perfilBO.obtenerListaPerfiles(new PerfilDto()));
			}
		}catch(Exception e){
			logger.error("Error en utilitario " + e.getMessage());
		}	
		return listaPerfiles;
	}

	public Long getSeleccione() {
		return seleccione;
	}
	
	
}
