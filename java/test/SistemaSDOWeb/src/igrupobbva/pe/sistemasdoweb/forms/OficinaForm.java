/*
 * Created on 01-jun-2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.forms;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;

/**
 * @author ocortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OficinaForm extends ActionForm{
	
	private String codOfic;	
	private String codNomOficina;
	private Territorio Terr;
	private Date fecActu;
	private Date fecRegi;
	private String usuActu;
	private String usuRegi;
	private String estado;
	
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
	 * @return Returns the terr.
	 */
	public Territorio getTerr() {
		return Terr;
	}
	/**
	 * @param terr The terr to set.
	 */
	public void setTerr(Territorio terr) {
		Terr = terr;
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
	
    public String getEstado()
    {
        return estado;
    }
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }

}
