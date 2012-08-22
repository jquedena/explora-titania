package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class RubroLogro extends GenericBean implements Serializable
{

	private static final long serialVersionUID = 8751245105532159742L;
	private Long id_rubro;
	private String codigoTerritorio;
	private String codigoOficina;
	private Long dia;
	private Long semana;
	private Long mes;
	private Long anio;
	private String cod_gestor;
	private String nom_ges_sup;
	private String apell_pat_ges_sup;
	private String apell_mat_ges_sup;
	private String cod_cargo;
	private Long logro;
	
	public Long getId_rubro() {
		return id_rubro;
	}
	public void setId_rubro(Long id_rubro) {
		this.id_rubro = id_rubro;
	}
	public String getCodigoTerritorio() {
		return codigoTerritorio;
	}
	public void setCodigoTerritorio(String codigoTerritorio) {
		this.codigoTerritorio = codigoTerritorio;
	}
	public String getCodigoOficina() {
		return codigoOficina;
	}
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}
	public Long getDia() {
		return dia;
	}
	public void setDia(Long dia) {
		this.dia = dia;
	}
	public Long getSemana() {
		return semana;
	}
	public void setSemana(Long semana) {
		this.semana = semana;
	}
	public Long getMes() {
		return mes;
	}
	public void setMes(Long mes) {
		this.mes = mes;
	}
	public Long getAnio() {
		return anio;
	}
	public void setAnio(Long anio) {
		this.anio = anio;
	}
	public String getCod_gestor() {
		return cod_gestor;
	}
	public void setCod_gestor(String cod_gestor) {
		this.cod_gestor = cod_gestor;
	}
	public String getNom_ges_sup() {
		return nom_ges_sup;
	}
	public void setNom_ges_sup(String nom_ges_sup) {
		this.nom_ges_sup = nom_ges_sup;
	}
	public String getApell_pat_ges_sup() {
		return apell_pat_ges_sup;
	}
	public void setApell_pat_ges_sup(String apell_pat_ges_sup) {
		this.apell_pat_ges_sup = apell_pat_ges_sup;
	}
	public String getApell_mat_ges_sup() {
		return apell_mat_ges_sup;
	}
	public void setApell_mat_ges_sup(String apell_mat_ges_sup) {
		this.apell_mat_ges_sup = apell_mat_ges_sup;
	}
	public String getCod_cargo() {
		return cod_cargo;
	}
	public void setCod_cargo(String cod_cargo) {
		this.cod_cargo = cod_cargo;
	}
	public Long getLogro() {
		return logro;
	}
	public void setLogro(Long logro) {
		this.logro = logro;
	}	
}
