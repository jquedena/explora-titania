package com.grupobbva.bc.per.tel.iilc.service;

import java.util.List;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;

@SuppressWarnings("unchecked")
public interface ICargaOfertasService {
	public boolean grabarIntervalos(String valor1[],String valor2[]);
	public List listarIntervalos();
	public int crearProgramacionCarga(String fecha,String usureg,boolean sobreescritura,String tipoCarga);
	public int eliminarProgramacionCarga(String arreglo[]) throws Exception;
	public List listarFechasProgramadas(String tipoCarga);
	public Tiilc_adm_carga_archivo visualizarEstadoCarga(String tipoCarga);
	public boolean verificarProcesamientoCarga(int id);
	public int actualizarProgramacion(int id,String fecha,String fecha_original,String tipoCarga);
	public int validacionIntervalos(String valor1,String valor2,String cod_ele);
}
