package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.reauni.model.entidad.EjecucionProcesoDto;

public interface EjecucionProcesoBO {
	public List<EjecucionProcesoDto> obtenerEjecuciones(String nombreProceso,String fechaEjecucion, String horaEjecucion);
	public List<EjecucionProcesoDto> obtenerEjecuciones(String nombreProceso,String fechaEjecucion);	
	public void insertar(EjecucionProcesoDto ejecucionProcesoDto);
	public void editar(EjecucionProcesoDto ejecucionProcesoDto);
	

}
