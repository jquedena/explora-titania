package igrupobbva.pe.sistemasdoweb.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ProgSeguimientoForm extends ActionForm{	
	private String codTerritorio;
	private String mes;
	private String anio;
	private String seg1Ini;
	private String seg2Ini;
	private String seg1Fin;
	private String seg2Fin;	
	private String method;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codTerritorio = "";
		mes = "";
		anio = "";
		seg1Ini = "";
		seg2Ini = "";
		seg1Fin = "";
		seg2Fin = "";
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
	 * @return Returns the codTerritorio.
	 */
	public String getCodTerritorio() {
		return codTerritorio;
	}
	/**
	 * @param codTerritorio The codTerritorio to set.
	 */
	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
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
	 * @return Returns the seg1Fin.
	 */
	public String getSeg1Fin() {
		return seg1Fin;
	}
	/**
	 * @param seg1Fin The seg1Fin to set.
	 */
	public void setSeg1Fin(String seg1Fin) {
		this.seg1Fin = seg1Fin;
	}
	/**
	 * @return Returns the seg1Ini.
	 */
	public String getSeg1Ini() {
		return seg1Ini;
	}
	/**
	 * @param seg1Ini The seg1Ini to set.
	 */
	public void setSeg1Ini(String seg1Ini) {
		this.seg1Ini = seg1Ini;
	}
	/**
	 * @return Returns the seg2Fin.
	 */
	public String getSeg2Fin() {
		return seg2Fin;
	}
	/**
	 * @param seg2Fin The seg2Fin to set.
	 */
	public void setSeg2Fin(String seg2Fin) {
		this.seg2Fin = seg2Fin;
	}
	/**
	 * @return Returns the seg2Ini.
	 */
	public String getSeg2Ini() {
		return seg2Ini;
	}
	/**
	 * @param seg2Ini The seg2Ini to set.
	 */
	public void setSeg2Ini(String seg2Ini) {
		this.seg2Ini = seg2Ini;
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
