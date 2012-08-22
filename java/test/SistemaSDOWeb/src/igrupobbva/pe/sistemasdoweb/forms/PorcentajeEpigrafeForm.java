/*
 * Created on 23-sep-2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.forms;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author pobregon
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PorcentajeEpigrafeForm extends ActionForm {
	
	private String strAnio;
	private String strCodEpigrafe;
	private List lstAnios;
	private String strNombreEpigrafe;
	private BigDecimal intPorcMax;
	private BigDecimal intPorcMin;
	
	
	
	
	/**
	 * @return Returns the strCodEpigrafe.
	 */
	public String getStrCodEpigrafe() {
		return strCodEpigrafe;
	}
	/**
	 * @param strCodEpigrafe The strCodEpigrafe to set.
	 */
	public void setStrCodEpigrafe(String strCodEpigrafe) {
		this.strCodEpigrafe = strCodEpigrafe;
	}
	/**
	 * @return Returns the intPorcMax.
	 */
	public BigDecimal getIntPorcMax() {
		return intPorcMax;
	}
	/**
	 * @param intPorcMax The intPorcMax to set.
	 */
	public void setIntPorcMax(BigDecimal intPorcMax) {
		this.intPorcMax = intPorcMax;
	}
	/**
	 * @return Returns the intPorcMin.
	 */
	public BigDecimal getIntPorcMin() {
		return intPorcMin;
	}
	/**
	 * @param intPorcMin The intPorcMin to set.
	 */
	public void setIntPorcMin(BigDecimal intPorcMin) {
		this.intPorcMin = intPorcMin;
	}
	/**
	 * @return Returns the lstAnios.
	 */
	public List getLstAnios() {
		return lstAnios;
	}
	/**
	 * @param lstAnios The lstAnios to set.
	 */
	public void setLstAnios(List lstAnios) {
		this.lstAnios = lstAnios;
	}
	/**
	 * @return Returns the strAnio.
	 */
	public String getStrAnio() {
		return strAnio;
	}
	/**
	 * @param strAnio The strAnio to set.
	 */
	public void setStrAnio(String strAnio) {
		this.strAnio = strAnio;
	}
	/**
	 * @return Returns the strNombreEpigrafe.
	 */
	public String getStrNombreEpigrafe() {
		return strNombreEpigrafe;
	}
	/**
	 * @param strNombreEpigrafe The strNombreEpigrafe to set.
	 */
	public void setStrNombreEpigrafe(String strNombreEpigrafe) {
		this.strNombreEpigrafe = strNombreEpigrafe;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		strAnio = "";
		strCodEpigrafe = "";
		strNombreEpigrafe = "";
		BigDecimal intPorcMax = new BigDecimal(0);
		BigDecimal intPorcMin = new BigDecimal(0);
		super.reset(arg0, arg1);
	}
	
}
