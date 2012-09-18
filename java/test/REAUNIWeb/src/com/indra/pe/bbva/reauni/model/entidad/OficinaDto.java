package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VREAUNI_OFICINA",schema="REAUNI")
public class OficinaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_OFICINA", insertable = false, updatable = false)
	private String codOficina;
	
	@Column(name = "COD_AREA")
	private String codArea;
	
	@Column(name = "DES_OFICINA")
	private String desOficina;

	@JoinColumn(name = "COD_TERRITORIO", referencedColumnName = "COD_TERRITORIO")
	@ManyToOne
	private TerritorioDto territorioDto;

	public OficinaDto() {
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getDesOficina() {
		return (desOficina != null) ? desOficina.trim() : desOficina;
	}

	public void setDesOficina(String desOficina) {
		this.desOficina = desOficina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TerritorioDto getTerritorioDto() {
		return territorioDto;
	}

	public void setTerritorioDto(TerritorioDto territorioDto) {
		this.territorioDto = territorioDto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codOficina != null ? this.codOficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof OficinaDto)) {
            return false;
        }
        OficinaDto other = (OficinaDto) object;
        if ((this.codOficina == null && other.codOficina != null) || (this.codOficina != null && !this.codOficina.equals(other.codOficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.OficinaDto[ codOficina=" + codOficina + " ]";
    }

}
