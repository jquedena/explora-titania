package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class LogroDetalle implements Serializable 
{

	private static final long serialVersionUID = 8751245105532159742L;
	
	private String codigo;
	private Long idRubro;
	private Long meta;
	private Long logro;
	private String porcentaje;
	private String color;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(Long idRubro) {
		this.idRubro = idRubro;
	}
	public Long getMeta() {
		return meta;
	}
	public void setMeta(Long meta) {
		this.meta = meta;
	}
	public Long getLogro() {
		return logro;
	}
	public void setLogro(Long logro) {
		this.logro = logro;
	}
	public String getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
