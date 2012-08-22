package indra.bbva.pizele.domain.extend;

import indra.bbva.pizele.domain.base.AsignacionRubro;

public class AsignacionRubroDetalle extends AsignacionRubro
{

	private static final long serialVersionUID = 8726745105532159742L;
	
	private String nombreRubro;
	private String tipoRubro;
	private String comportamientoNegativo;
	
	public String getNombreRubro() {
		return nombreRubro;
	}

	public void setNombreRubro(String nombreRubro) {
		this.nombreRubro = nombreRubro;
	}

	public String getTipoRubro() {
		return tipoRubro;
	}

	public void setTipoRubro(String tipoRubro) {
		this.tipoRubro = tipoRubro;
	}

	public String getComportamientoNegativo() {
		return comportamientoNegativo;
	}

	public void setComportamientoNegativo(String comportamientoNegativo) {
		this.comportamientoNegativo = comportamientoNegativo;
	}
	
	public String getCodigos()
	{
		return this.getId() + "|" + this.getIdrubro();
	}
	
}
