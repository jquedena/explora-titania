package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class VerificacionLogroDetalle implements Serializable
{

	private static final long serialVersionUID = 6751245105532159742L;
	
	private Long idRubro;
	private String descRubro;
	private Long logroReportado;
	private Long logroConcretado;
	
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
	public Long getLogroReportado() {
		return logroReportado;
	}
	public void setLogroReportado(Long logroReportado) {
		this.logroReportado = logroReportado;
	}
	public Long getLogroConcretado() {
		return logroConcretado;
	}
	public void setLogroConcretado(Long logroConcretado) {
		this.logroConcretado = logroConcretado;
	}
	
}
