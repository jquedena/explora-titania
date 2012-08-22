/*
 * Created on 20/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("serial")
public class Territorio implements Serializable{
	private String codTerr;
	private String nomTerr;
	private Date fecActu;
	private Date fecRegi;
	private String usuActu;
	private String usuRegi;
	/**
	 * @return Returns the nomTerr.
	 */
	public String getNomTerr() {
		return nomTerr;
	}
	/**
	 * @param nomTerr The nomTerr to set.
	 */
	public void setNomTerr(String nomTerr) {
		this.nomTerr = nomTerr;
	}
	

	/**
	 * @return Returns the codTerr.
	 */
	public String getCodTerr() {
		return codTerr;
	}
	/**
	 * @param codTerr The codTerr to set.
	 */
	public void setCodTerr(String codTerr) {
		this.codTerr = codTerr;
	}
	/**
	 * @return Returns the fecActu.
	 */
	public Date getFecActu() {
		return fecActu;
	}
	/**
	 * @param fecActu The fecActu to set.
	 */
	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}
	/**
	 * @return Returns the fecRegi.
	 */
	public Date getFecRegi() {
		return fecRegi;
	}
	/**
	 * @param fecRegi The fecRegi to set.
	 */
	public void setFecRegi(Date fecRegi) {
		this.fecRegi = fecRegi;
	}
	/**
	 * @return Returns the usuActu.
	 */
	public String getUsuActu() {
		return usuActu;
	}
	/**
	 * @param usuActu The usuActu to set.
	 */
	public void setUsuActu(String usuActu) {
		this.usuActu = usuActu;
	}
	/**
	 * @return Returns the usuRegi.
	 */
	public String getUsuRegi() {
		return usuRegi;
	}
	/**
	 * @param usuRegi The usuRegi to set.
	 */
	public void setUsuRegi(String usuRegi) {
		this.usuRegi = usuRegi;
	}
}
