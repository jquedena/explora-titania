package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VREAUNI_GESTOR",schema="REAUNI")
public class GestorDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_GESTOR", insertable = false, updatable = false)
	private String codGestor;
	
	@Column(name = "COD_AREA")
	private String codArea;
	
	@Column(name = "NOM_GESTOR")
	private String nomGestor;
	
	@Column(name = "REG_GESTOR")
	private String regGestor;
	
	@Column(name = "PERFIL_GESTOR")
	private String perfilGestor;
	
	@Column(name = "COD_TERRITORIO")
	private String codTerritorio;
	
	@Column(name = "COD_OFICINA")
	private String codOficina;

	public GestorDto() {
	}

	public String getCodGestor() {
		if(codGestor == null) {
			return ""; 
		}
		return codGestor;
	}

	public void setCodGestor(String codGestor) {
		this.codGestor = codGestor;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getNomGestor() {
		return nomGestor;
	}

	public void setNomGestor(String nomGestor) {
		this.nomGestor = nomGestor;
	}

	public String getRegGestor() {
		return regGestor;
	}

	public void setRegGestor(String regGestor) {
		this.regGestor = regGestor;
	}

	public String getPerfilGestor() {
		if(perfilGestor == null) {
			return ""; 
		}
		return perfilGestor;
	}

	public void setPerfilGestor(String perfilGestor) {
		this.perfilGestor = perfilGestor;
	}

	public String getCodTerritorio() {
		return codTerritorio;
	}

	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codGestor != null ? this.codGestor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof GestorDto)) {
            return false;
        }
        GestorDto other = (GestorDto) object;
        if ((this.codGestor == null && other.codGestor != null) || (this.codGestor != null && !this.codGestor.equals(other.codGestor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.GestorDto[ codGestor=" + codGestor + " ]";
    }

	public GestorDto(String codGestor, String nomGestor, String regGestor) {
		super();
		this.codGestor = codGestor;
		this.nomGestor = nomGestor;
		this.regGestor = regGestor;
	}
	
	public String getID() {
		return this.getPerfilGestor() + this.getCodGestor();
	}
}
