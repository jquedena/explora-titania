package com.grupobbva.bc.per.tel.iilc.service;

import java.util.List;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;

@SuppressWarnings("unchecked")
public interface ICargaOtrasOfertasService {
	public int crearProgramacionCarga(String fecha,String usureg,boolean sobreescritura);
	public int eliminarProgramacionCarga(String arreglo[]) throws Exception;
	public List listarFechasProgramadas();
	public List listarLogError(String tipo);
	public Tiilc_adm_carga_archivo visualizarEstadoCarga();
	public boolean verificarProcesamientoCarga(int id);
	public int actualizarProgramacion(int id,String fecha,String fecha_original);
	public String getMensaje();
}
