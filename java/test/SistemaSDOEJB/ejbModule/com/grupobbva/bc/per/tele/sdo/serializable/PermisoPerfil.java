package com.grupobbva.bc.per.tele.sdo.serializable;


import java.io.Serializable;

public class PermisoPerfil implements Serializable{

    private String codPerfil;    
    private String nombrePerfil;
    private String tipoAcceso;    
    private String nombreTipoAcceso;
    private String valorRCP;    
    private Perfil perfil;    
    private String usuario;
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
	 * @return Returns the usuario.
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario The usuario to set.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	 * @return Returns the desPerfil.
	 */
	public String getDesPerfil() {
		return usuario;
	}
	/**
	 * @param desPerfil The desPerfil to set.
	 */
	public void setDesPerfil(String desPerfil) {
		this.usuario = desPerfil;
	}
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
	 * @return Returns the perfil.
	 */
	public Perfil getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil The perfil to set.
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	/**
	 * @return Returns the tipoAcceso.
	 */
	public String getTipoAcceso() {
		return tipoAcceso;
	}
	/**
	 * @param tipoAcceso The tipoAcceso to set.
	 */
	public void setTipoAcceso(String tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}
	/**
	 * @return Returns the valorRCP.
	 */
	public String getValorRCP() {
		return valorRCP;
	}
	/**
	 * @param valorRCP The valorRCP to set.
	 */
	public void setValorRCP(String valorRCP) {
		this.valorRCP = valorRCP;
	}
	/**
	 * @return Returns the nombrePerfil.
	 */
	public String getNombrePerfil() {
		return nombrePerfil;
	}
	/**
	 * @param nombrePerfil The nombrePerfil to set.
	 */
	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}
	/**
	 * @return Returns the nombreTipoAcceso.
	 */
	public String getNombreTipoAcceso() {
		return nombreTipoAcceso;
	}
	/**
	 * @param nombreTipoAcceso The nombreTipoAcceso to set.
	 */
	public void setNombreTipoAcceso(String nombreTipoAcceso) {
		this.nombreTipoAcceso = nombreTipoAcceso;
	}
}
