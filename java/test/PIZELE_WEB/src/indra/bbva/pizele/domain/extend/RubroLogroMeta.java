package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class RubroLogroMeta implements Serializable 
{

	private static final long serialVersionUID = 8751245105532159754L;
	
	private Long idRubro;
	private String descRubro;
	private Long logro;
	private Long meta;
	private Long porcentajeCumplimiento;
	private String color;
	private Long promedioHistorico;
	private String pathReporte;
	
	public Long getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(Long idRubro) {
		this.idRubro = idRubro;
	}
	public String getDescRubro() {
		return descRubro;
	}
	public void setDescRubro(String descRubro) {
		this.descRubro = descRubro;
	}
	public Long getLogro() {
		return logro;
	}
	public void setLogro(Long logro) {
		this.logro = logro;
	}
	public Long getMeta() {
		return meta;
	}
	public void setMeta(Long meta) {
		this.meta = meta;
	}
	public Long getPorcentajeCumplimiento() {
		return porcentajeCumplimiento;
	}
	public void setPorcentajeCumplimiento(Long porcentajeCumplimiento) {
		this.porcentajeCumplimiento = porcentajeCumplimiento;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getPromedioHistorico() {
		return promedioHistorico;
	}
	public void setPromedioHistorico(Long promedioHistorico) {
		this.promedioHistorico = promedioHistorico;
	}
	public String getPathReporte() {
		return pathReporte;
	}
	public void setPathReporte(String pathReporte) {
		this.pathReporte = pathReporte;
	}
	
}
