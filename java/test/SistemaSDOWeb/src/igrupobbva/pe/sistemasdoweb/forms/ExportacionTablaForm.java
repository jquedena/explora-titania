package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;

public class ExportacionTablaForm extends ActionForm{
	private String codigoTabla;
	private String mes;
	private String anio;
	private String method;
	
	public ExportacionTablaForm() {
		
	}
	
	/**
	 * @return Returns the anio.
	 */
	public String getAnio() {
		return anio;
	}
	/**
	 * @param anio The anio to set.
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}
	/**
	 * @return Returns the codigoTabla.
	 */
	public String getCodigoTabla() {
		return codigoTabla;
	}
	/**
	 * @param codigoTabla The codigoTabla to set.
	 */
	public void setCodigoTabla(String codigoTabla) {
		this.codigoTabla = codigoTabla;
	}
	/**
	 * @return Returns the mes.
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes The mes to set.
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
	/**
	 * @return Returns the method.
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method The method to set.
	 */
	public void setMethod(String method) {
		this.method = method;
	}
}
