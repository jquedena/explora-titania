package com.indra.pe.bbva.reauni.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.SituacionDto;
import com.indra.pe.bbva.reauni.service.SituacionesBO;

@Controller("situacionModel")
@Scope("session")
public class SituacionModel implements Serializable{
 
	private static final long serialVersionUID = -6977531763500807866L;
	
	private SituacionDto dto;
	private SituacionDto dtoFiltro;
	private List<SituacionDto> lista;
	
	@Autowired
	private SituacionesBO situacionesBO;
	
	public SituacionModel() {
		this.reset();
	}
	
	public void reset(){
		dto = new SituacionDto();
		dtoFiltro = new SituacionDto();
		lista = new ArrayList<SituacionDto>();
	}

	public SituacionDto getDto() {
		return dto;
	}

	public void setDto(SituacionDto dto) {
		this.dto = dto;
	}

	public SituacionDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(SituacionDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<SituacionDto> getLista() {
		return lista;
	}

	public void setLista(List<SituacionDto> lista) {
		this.lista = lista;
	}

	public SituacionesBO getSituacionesBO() {
		return situacionesBO;
	}
	
	
	
}
