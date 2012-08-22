package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class ConfBasicaMeta   extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 55L;
	
	private  String  cod_terr;
	private  String  cod_ofi;
	private  Long    anio;
	private  Long    mes;
	private  Long    semana1;
	private  Long    semana2;
	private  Long    semana3;
	private  Long    semana4;
	private  Long    semana5;
	private  Long    min_con_dia_perso;
	private  Long    min_con_dia_no_perso;
	private  Long    min_vis_dia_perso;
	private  Long    min_vis_dia_no_perso;
	
	public ConfBasicaMeta() {
		cod_terr 	= "-1";
		cod_ofi		= "-1";
		anio		= -1L;
		mes			= -1L;
		semana1		= 0L;
		semana2		= 0L;
		semana3		= 0L;
		semana4		= 0L;
		semana5		= 0L;
		min_con_dia_perso		= 0L;
		min_con_dia_no_perso	= 0L;
		min_vis_dia_perso		= 0L;
		min_vis_dia_no_perso	= 0L;
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
	public Long getMin_con_dia_perso() {
		return min_con_dia_perso;
	}
	public void setMin_con_dia_perso(Long min_con_dia_perso) {
		this.min_con_dia_perso = min_con_dia_perso;
	}
	public Long getMin_con_dia_no_perso() {
		return min_con_dia_no_perso;
	}
	public void setMin_con_dia_no_perso(Long min_con_dia_no_perso) {
		this.min_con_dia_no_perso = min_con_dia_no_perso;
	}
	public Long getMin_vis_dia_perso() {
		return min_vis_dia_perso;
	}
	public void setMin_vis_dia_perso(Long min_vis_dia_perso) {
		this.min_vis_dia_perso = min_vis_dia_perso;
	}
	public Long getMin_vis_dia_no_perso() {
		return min_vis_dia_no_perso;
	}
	public void setMin_vis_dia_no_perso(Long min_vis_dia_no_perso) {
		this.min_vis_dia_no_perso = min_vis_dia_no_perso;
	}

}
