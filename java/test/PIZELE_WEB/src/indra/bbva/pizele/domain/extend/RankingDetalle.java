package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class RankingDetalle implements Serializable 
{

	private static final long serialVersionUID = 1751245455532159742L;
	
	private String descRubro;
	private String codGestor;
	private String nomGestor;
	private String apellPatGestor;
	private String apellMatGestor;
	
	private Long porcentajeCumplimiento;
	private String color;
	
	public String getDescRubro() {
		return descRubro;
	}
	public void setDescRubro(String descRubro) {
		this.descRubro = descRubro;
	}
	public String getCodGestor() {
		return codGestor;
	}
	public void setCodGestor(String codGestor) {
		this.codGestor = codGestor;
	}
	public String getNomGestor() {
		return nomGestor;
	}
	public void setNomGestor(String nomGestor) {
		this.nomGestor = nomGestor;
	}
	public String getApellPatGestor() {
		return apellPatGestor;
	}
	public void setApellPatGestor(String apellPatGestor) {
		this.apellPatGestor = apellPatGestor;
	}
	public String getApellMatGestor() {
		return apellMatGestor;
	}
	public void setApellMatGestor(String apellMatGestor) {
		this.apellMatGestor = apellMatGestor;
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
	
}
