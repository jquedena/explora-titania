package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

import indra.bbva.pizele.domain.base.Rubro;

public class RubroDetalle extends Rubro implements Serializable 
{
	
	private static final long serialVersionUID = 1751245105532159742L;
	
	private Long idDiff;
	private String descFiltro;
	private String descCompleto;
	

	public Long getIdDiff() {
		return idDiff;
	}

	public void setIdDiff(Long idDiff) {
		this.idDiff = idDiff;
	}

	public String getDescFiltro() {
		return descFiltro;
	}

	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro;
	}

	public String getDescCompleto() {
		return descCompleto;
	}

	public void setDescCompleto(String descCompleto) {
		this.descCompleto = descCompleto;
	}

	public String getDatos()
	{
		return this.getId() + "|" + this.getDescrubro() + "|" + this.getTiprubro() + "|" + this.getComp_nega();
	}
		
}
