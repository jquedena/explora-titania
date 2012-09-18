package com.indra.pe.bbva.reauni.service;

import java.util.Date;
import java.util.List;

import com.indra.pe.bbva.reauni.model.entidad.CargaDto;

public interface CargaBO {
	public List<CargaDto> obtenerCargasPorFecha(Date fecha);	
	

}
