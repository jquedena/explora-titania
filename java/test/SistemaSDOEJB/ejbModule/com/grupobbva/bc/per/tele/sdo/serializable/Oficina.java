package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Oficina implements Serializable{
	private String codOfic;	
	private String nomOficina;
	private String codNomOficina;
	private Territorio Terr;
	private Date fecActu;
	private Date fecRegi;
	private String usuActu;
	private String usuRegi;
	private String codTerritorio;
	private String estado;
	

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
	 * @return Returns the terr.
	 */
	public Territorio getTerr() {
		return Terr;
	}
	/**
	 * @return Returns the codNomOficina.
	 */
	public String getCodNomOficina() {
		return codNomOficina;
	}
	/**
	 * @param codNomOficina The codNomOficina to set.
	 */
	public void setCodNomOficina(String codNomOficina) {
		this.codNomOficina = codNomOficina;
	}
	/**
	 * @param terr The terr to set.
	 */
	public void setTerr(Territorio terr) {
		Terr = terr;
	}
	/**
	 * @return Returns the codOfic.
	 */
	public String getCodOfic() {
		return codOfic;
	}
	/**
	 * @param codOfic The codOfic to set.
	 */
	public void setCodOfic(String codOfic) {
		this.codOfic = codOfic;
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
	/**
	 * @return Returns the nomOficina.
	 */
	public String getNomOficina() {
		return nomOficina;
	}
	/**
	 * @param nomOficina The nomOficina to set.
	 */
	public void setNomOficina(String nomOficina) {
		this.nomOficina = nomOficina;
	}
    public String getEstado()
    {
        return estado;
    }
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
	
	
}
