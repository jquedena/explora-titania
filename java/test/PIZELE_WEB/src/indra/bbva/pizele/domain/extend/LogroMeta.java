package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class LogroMeta implements Serializable 
{

	private static final long serialVersionUID = 2251245105532159742L;
	
	private String codigo;
	private Long idRubro;
	private Long monto;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getMonto() {
		return monto;
	}
	public void setMonto(Long monto) {
		this.monto = monto;
	}
	public Long getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(Long idRubro) {
		this.idRubro = idRubro;
	}
	
}
