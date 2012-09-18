package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VREAUNI_TERRITORIO",schema="REAUNI")
public class TerritorioDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_TERRITORIO", insertable = false, updatable = false)
	private String codTerritorio;
	@Basic(optional = false)
	@Column(name = "COD_AREA")
	private String codArea;
	@Column(name = "DES_TERRITORIO")
	private String desTerritorio;

	public TerritorioDto() {
	}

	public String getCodTerritorio() {
		return codTerritorio;
	}

	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getDesTerritorio() {
		return (desTerritorio != null) ? desTerritorio.trim() : desTerritorio;
	}

	public void setDesTerritorio(String desTerritorio) {
		this.desTerritorio = desTerritorio;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codTerritorio != null ? this.codTerritorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof TerritorioDto)) {
            return false;
        }
        TerritorioDto other = (TerritorioDto) object;
        if ((this.codTerritorio == null && other.codTerritorio != null) || (this.codTerritorio != null && !this.codTerritorio.equals(other.codTerritorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.TerritorioDto[ codTerritorio=" + codTerritorio + " ]";
    }

}
