/**
 * Nombre	   : Equivalencia.java  
 * Version     : 1.0
 * Creacion    : 14/04/2009
 * Autor       : Godofredo Ureta.
 * Usuario     : P020912
 * Finalidad   : Unifica la llamada de todos los sessions de modo que este se llame en la parte web.
 *
 * Modificacion: << fecha de modificacion>>
 * Autor       : <<quien actualizo el archivo>>
 * Usuario     : <<codigo de usuario modificador>>
 * Detalle     : <<descripcion de la modificacion>>
 */

package igrupobbva.pe.sistemasdoweb.forms;


import org.apache.struts.action.ActionForm;

public class EquivalenciaForm extends ActionForm{

    private String codPerfil;
    
    private String nomPerfil;
    
    private String usuRegi;
	private String fecRegi;
	private String usuActu;
	private String fecActu;
    
    
	/**
	 * @return Returns the fecActu.
	 */
	public String getFecActu() {
		return fecActu;
	}
	/**
	 * @param fecActu The fecActu to set.
	 */
	public void setFecActu(String fecActu) {
		this.fecActu = fecActu;
	}
	/**
	 * @return Returns the fecRegi.
	 */
	public String getFecRegi() {
		return fecRegi;
	}
	/**
	 * @param fecRegi The fecRegi to set.
	 */
	public void setFecRegi(String fecRegi) {
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
	 * @return Returns the nomPerfil.
	 */
	public String getNomPerfil() {
		return nomPerfil;
	}
	/**
	 * @param nomPerfil The nomPerfil to set.
	 */
	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}
    private String componente;
   
	/**
	 * @return Returns the codPerfil.
	 */
	public String getCodPerfil() {
		return codPerfil;
	}
	/**
	 * @param codPerfil The codPerfil to set.
	 */
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}
	/**
	 * @return Returns the componente.
	 */
	public String getComponente() {
		return componente;
	}
	/**
	 * @param componente The componente to set.
	 */
	public void setComponente(String componente) {
		this.componente = componente;
	}
	

}