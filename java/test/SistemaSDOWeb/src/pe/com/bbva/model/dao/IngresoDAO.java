package pe.com.bbva.model.dao;

import java.util.HashMap;

import pe.com.indra.component.model.AbstractSQL;

public class IngresoDAO extends AbstractSQL {

	public int insertarIngreso(String codUsuario, String cargo, String territorio, String oficina, String usuario) {
		int id = -1;
		Object[] parameters = new Object[5];
		
		parameters[0] = codUsuario;
		parameters[1] = cargo;
		parameters[2] = territorio;
		parameters[3] = oficina;
		parameters[4] = usuario;
		
		id = this.executeProcedureToInt("IIDO.PKG_INGRESO.PROC_INSERTAR_INGRESO", parameters);
		
		return id;
	}
	
	public void insertarIngresoDetalle(int id, int tipo, String mes, String anio) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("P_ID", id); 
		parameters.put("P_TIPO",  tipo);
		parameters.put("P_MES", mes);
		parameters.put("P_ANIO", anio);
		
		this.executeProcedure("IIDO.PKG_INGRESO.PROC_INSERTAR_INGRESO_DETALLE", parameters);
	}
	
	public void insertarIngresoForm(String tipo, String mes, String anio, String codUsuario, String modo, String codGestor, String codOficina) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("P_TIPO",  tipo);
		parameters.put("P_MES", mes);
		parameters.put("P_ANIO", anio);
		parameters.put("P_COD_USUARIO", codUsuario); 
		parameters.put("P_MODO", modo); 
		parameters.put("P_COD_GESTOR", codGestor);
		parameters.put("P_COD_OFICINA", codOficina);
		
		this.executeProcedure("IIDO.PKG_INGRESO.PROC_INSERTAR_INGRESO_FORM", parameters);
	}
	
	public int existeIngresoForm(String tipo, String mes, String anio, String codUsuario, String codGestor, String codOficina) {
		int id = -1;
		Object[] parameters = new Object[7];
		parameters[0] = tipo;
		parameters[1] = mes;
		parameters[2] = anio;
		parameters[3] = codUsuario;
		parameters[4] = codGestor;
		parameters[5] = codOficina;
		
		id = this.executeProcedureToInt("IIDO.PKG_INGRESO.PROC_EXISTE_INGRESO_FORM", parameters);
		
		return id;
	}
	
	public void actualizarIngresoForm(long id) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("P_ID", id);
		
		this.executeProcedure("IIDO.PKG_INGRESO.PROC_ACTUALIZAR_INGRESO_FORM", parameters);
	}
}
