package com.indra.pe.bbva.reauni.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.TipoPrestamoDto;
import com.indra.pe.bbva.reauni.service.TipoPrestamoBO;

@Controller("tipoPrestamoModel")
@Scope("session")
public class TipoPrestamoModel implements Serializable{
 
	private static final long serialVersionUID = -523282832203282830L;
	
	private TipoPrestamoDto dto;
	private TipoPrestamoDto dtoFiltro;
	private List<TipoPrestamoDto> lista;
	
	@Autowired
	private TipoPrestamoBO tipoPrestamoBO;
	
	public TipoPrestamoModel() {
		this.reset();
	}
	
	public void reset(){

		this.dto = new TipoPrestamoDto();
		this.dtoFiltro  = new TipoPrestamoDto();
		this.lista = new ArrayList<TipoPrestamoDto>();
	}

	public TipoPrestamoDto getDto() {
		return dto;
	}

	public void setDto(TipoPrestamoDto dto) {
		this.dto = dto;
	}

	public TipoPrestamoDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(TipoPrestamoDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<TipoPrestamoDto> getLista() {
		return lista;
	}

	public void setLista(List<TipoPrestamoDto> lista) {
		this.lista = lista;
	}

	public TipoPrestamoBO getTipoPrestamoBO() {
		return tipoPrestamoBO;
	}
	
	
}
