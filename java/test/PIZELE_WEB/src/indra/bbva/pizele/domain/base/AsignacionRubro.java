package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class AsignacionRubro  extends GenericBean implements Serializable  {
	

	private static final long serialVersionUID = 8751245105532159742L;
	
	private  Long  idrubro;
	private  String codterr;
	private  String codofic;
	private  Long  anio;
	private  Long mes;

	public Long getIdrubro() {
		return idrubro;
	}
	public void setIdrubro(Long idrubro) {
		this.idrubro = idrubro;
	}
	public String getCodterr() {
		return codterr;
	}
	public void setCodterr(String codterr) {
		this.codterr = codterr;
	}
	public String getCodofic() {
		return codofic;
	}
	public void setCodofic(String codofic) {
		this.codofic = codofic;
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
