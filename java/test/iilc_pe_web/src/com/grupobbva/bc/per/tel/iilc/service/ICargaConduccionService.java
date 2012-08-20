package com.grupobbva.bc.per.tel.iilc.service;
 
import java.util.List;
 
@SuppressWarnings("unchecked")
public interface ICargaConduccionService {
	public boolean verificarProcesamientoCarga(int id);
	public int actualizarProgramacion(int id,String fecha,String fecha_original);
	public int crearProgramacionCarga(String fecha,String usureg,boolean sobreescritura);
	public int eliminarProgramacionCarga(String arreglo[]) throws Exception;
	public List listarFechasProgramadas();
}
