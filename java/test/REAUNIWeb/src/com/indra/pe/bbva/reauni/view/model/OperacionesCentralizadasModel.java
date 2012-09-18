package com.indra.pe.bbva.reauni.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.OperacionCentralizadaDto;
import com.indra.pe.bbva.reauni.service.OperacionesCentralesBO;
import com.indra.pe.bbva.reauni.util.Constantes;

@Controller("operacionesCentralizadasModel")
@Scope("session")
public class OperacionesCentralizadasModel implements Serializable{
 
	private static final long serialVersionUID = 8992289457884696529L;

	private OperacionCentralizadaDto dto;
	private OperacionCentralizadaDto dtoFiltro;
	private List<OperacionCentralizadaDto> lista;
	
	@Autowired
	private OperacionesCentralesBO operacionesCentralesBO;

	public String iniciar () {
		
		this.dto = new OperacionCentralizadaDto();
		this.dtoFiltro = new OperacionCentralizadaDto();
		this.lista = new ArrayList<OperacionCentralizadaDto>();
		
		return Constantes.UrlNavegacion.URL_LISTA_OPERACIONES_CENTRALES;
	}
	
	public OperacionesCentralizadasModel() {
		this.dto = new OperacionCentralizadaDto();
		this.dtoFiltro = new OperacionCentralizadaDto();
		this.lista = new ArrayList<OperacionCentralizadaDto>();
	}

	public OperacionCentralizadaDto getDto() {
		return dto;
	}

	public void setDto(OperacionCentralizadaDto dto) {
		this.dto = dto;
	}

	public OperacionCentralizadaDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(OperacionCentralizadaDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<OperacionCentralizadaDto> getLista() {
		return lista;
	}

	public void setLista(List<OperacionCentralizadaDto> lista) {
		this.lista = lista;
	}

	public OperacionesCentralesBO getOperacionesCentralesBO() {
		return operacionesCentralesBO;
	}
 
}
