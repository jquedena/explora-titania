package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class ConfEpigrafeAsignados  extends GenericBean implements Serializable  {
    
	private static final long serialVersionUID = 8751245105532159742L;
	
	private Long id_rubro;
	private String id_epigrafe;
	private String tip_epig;
	private Long anio;
	private Long mes;
	
	public Long getId_rubro() {
		return id_rubro;
	}
	public void setId_rubro(Long id_rubro) {
		this.id_rubro = id_rubro;
	}
	public String getId_epigrafe() {
		return id_epigrafe;
	}
	public void setId_epigrafe(String id_epigrafe) {
		this.id_epigrafe = id_epigrafe;
	}
	public String getTip_epig() {
		return tip_epig;
	}
	public void setTip_epig(String tip_epig) {
		this.tip_epig = tip_epig;
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

}