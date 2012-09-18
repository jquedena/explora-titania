package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.reauni.model.entidad.TareaDto;

public interface TareaBO {
	
	public void insertar(TareaDto tareaDto);
	public void editar(TareaDto tareaDto);
	public TareaDto obtenerTarea(Long id);
	public List<TareaDto> obtenerTareas(TareaDto tareaDto);	
	

}
