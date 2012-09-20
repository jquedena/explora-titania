package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class MetaMensual  extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 8751245105532159742L;
	
	private  Long    id_rubro;
	private  String  cod_gestor;
	private  String  nom_gestor;
	private  String  apell_pat_gestor;
	private  String  apell_mat_gestor;
	private  String  cod_terr;
	private  String  cod_ofi;
	private  Long    anio;
	private  Long    mes;
	private  Long    semana1 = 0L;
	private  Long    semana2 = 0L;
	private  Long    semana3 = 0L;
	private  Long    semana4 = 0L;
	private  Long    semana5 = 0L;
	private  String ausente1 = "N";
	private  String ausente2 = "N";
	private  String ausente3 = "N";
	private  String ausente4 = "N";
	private  String ausente5 = "N";
	private  String  cod_perfil = "";
	private  String  perfil = "";
	private  String flag_epigrafe_sdo = "N";
	private  Long    meta_sdo = 0L;
	private  Long    meta_mensual = 0L;
	private  Long    semana1Minimo = 0L;
	private  Long    semana2Minimo = 0L;
	private  Long    semana3Minimo = 0L;
	private  Long    semana4Minimo = 0L;
	private  Long    semana5Minimo = 0L;
	
	
	public Long getId_rubro() {
		return id_rubro;
	}
	public void setId_rubro(Long id_rubro) {
		this.id_rubro = id_rubro;
	}
	public String getCod_gestor() {
		return cod_gestor;
	}
	public void setCod_gestor(String cod_gestor) {
		this.cod_gestor = cod_gestor;
	}
	public String getNom_gestor() {
		return nom_gestor;
	}
	public void setNom_gestor(String nom_gestor) {
		this.nom_gestor = nom_gestor;
	}
	public String getApell_pat_gestor() {
		return apell_pat_gestor;
	}
	public void setApell_pat_gestor(String apell_pat_gestor) {
		this.apell_pat_gestor = apell_pat_gestor;
	}
	public String getApell_mat_gestor() {
		return apell_mat_gestor;
	}
	public void setApell_mat_gestor(String apell_mat_gestor) {
		this.apell_mat_gestor = apell_mat_gestor;
	}
	public String getCod_terr() {
		return cod_terr;
	}
	public void setCod_terr(String cod_terr) {
		this.cod_terr = cod_terr;
	}
	public String getCod_ofi() {
		return cod_ofi;
	}
	public void setCod_ofi(String cod_ofi) {
		this.cod_ofi = cod_ofi;
	}
	public Long getAnio() {
		return anio;
	}
	public void setAnio(Long anio) {
		this.anio = anio;
	}
	public Long getMes() {
		return mes;
	}
	public void setMes(Long mes) {
		this.mes = mes;
	}
	public Long getSemana1() {
		return semana1;
	}
	public void setSemana1(Long semana1) {
		this.semana1 = semana1;
	}
	public Long getSemana2() {
		return semana2;
	}
	public void setSemana2(Long semana2) {
		this.semana2 = semana2;
	}
	public Long getSemana3() {
		return semana3;
	}
	public void setSemana3(Long semana3) {
		this.semana3 = semana3;
	}
	public Long getSemana4() {
		return semana4;
	}
	public void setSemana4(Long semana4) {
		this.semana4 = semana4;
	}
	public Long getSemana5() {
		return semana5;
	}
	public void setSemana5(Long semana5) {
		this.semana5 = semana5;
	}
	public Long getMeta_mensual() {
		return meta_mensual;
	}
	public void setMeta_mensual(Long meta_mensual) {
		this.meta_mensual = meta_mensual;
	}
	public Long getMeta_sdo() {
		return meta_sdo;
	}
	public void setMeta_sdo(Long meta_sdo) {
		this.meta_sdo = meta_sdo;
	}
	public String getAusente1() {
		return ausente1;
	}
	public void setAusente1(String ausente1) {
		this.ausente1 = ausente1;
	}
	public String getAusente2() {
		return ausente2;
	}
	public void setAusente2(String ausente2) {
		this.ausente2 = ausente2;
	}
	public String getAusente3() {
		return ausente3;
	}
	public void setAusente3(String ausente3) {
		this.ausente3 = ausente3;
	}
	public String getAusente4() {
		return ausente4;
	}
	public void setAusente4(String ausente4) {
		this.ausente4 = ausente4;
	}
	public String getAusente5() {
		return ausente5;
	}
	public void setAusente5(String ausente5) {
		this.ausente5 = ausente5;
	}
	public String getCod_perfil() {
		return cod_perfil;
	}
	public void setCod_perfil(String cod_perfil) {
		this.cod_perfil = cod_perfil;
	}
	public String getFlag_epigrafe_sdo() {
		return flag_epigrafe_sdo;
	}
	public void setFlag_epigrafe_sdo(String flag_epigrafe_sdo) {
		this.flag_epigrafe_sdo = flag_epigrafe_sdo;
	}
	public Long getSemana1Minimo() {
		return semana1Minimo;
	}
	public void setSemana1Minimo(Long semana1Minimo) {
		this.semana1Minimo = semana1Minimo;
	}
	public Long getSemana2Minimo() {
		return semana2Minimo;
	}
	public void setSemana2Minimo(Long semana2Minimo) {
		this.semana2Minimo = semana2Minimo;
	}
	public Long getSemana3Minimo() {
		return semana3Minimo;
	}
	public void setSemana3Minimo(Long semana3Minimo) {
		this.semana3Minimo = semana3Minimo;
	}
	public Long getSemana4Minimo() {
		return semana4Minimo;
	}
	public void setSemana4Minimo(Long semana4Minimo) {
		this.semana4Minimo = semana4Minimo;
	}
	public Long getSemana5Minimo() {
		return semana5Minimo;
	}
	public void setSemana5Minimo(Long semana5Minimo) {
		this.semana5Minimo = semana5Minimo;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}