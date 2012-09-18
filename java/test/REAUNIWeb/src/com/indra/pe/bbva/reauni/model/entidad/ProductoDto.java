package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO",schema="REAUNI")
public class ProductoDto  implements Serializable{
	
	private static final long serialVersionUID = 7041078105902611761L;

	@Id
	@Column(name = "COD_PROD", insertable = false, updatable = false)
	private String codProd;
	
	@Column(name = "DESC_PROD")
	private String descProd;

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getDescProd() {
		return descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}
	
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codProd != null ? this.codProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ProductoDto)) {
            return false;
        }
        ProductoDto other = (ProductoDto) object;
        if ((this.codProd == null && other.codProd != null) || (this.codProd != null && !this.codProd.equals(other.codProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.ProductoDto[ codProd=" + codProd + " ]";
    }
}
