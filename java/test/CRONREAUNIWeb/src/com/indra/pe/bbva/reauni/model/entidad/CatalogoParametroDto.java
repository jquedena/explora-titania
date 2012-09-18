package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_CATALOGO_PARAMETRO",schema="REAUNI")
public class CatalogoParametroDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_CATALOGO_PARAMETRO")
    @TableGenerator(name = "SEQ_CATALOGO_PARAMETRO", schema="REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_CATALOGO_PARAMETRO", allocationSize = 1)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogoParametroDto", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ParametroDto> listaParametros;
    
    @Transient
    private int cantidadParametros;

    public CatalogoParametroDto() {
    }

    public CatalogoParametroDto(Long id) {
        this.id = id;
    }

    public CatalogoParametroDto(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ParametroDto> getListaParametros() {
		return listaParametros;
	}

	public void setListaParametros(List<ParametroDto> listaParametros) {
		this.listaParametros = listaParametros;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CatalogoParametroDto)) {
            return false;
        }
        CatalogoParametroDto other = (CatalogoParametroDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.CatalogoParametroDto[ id=" + id + " ]";
    }
    
    public int getCantidadParametros() {
		this.cantidadParametros =  (this.getListaParametros()!=null?this.listaParametros.size():0) ;
		return cantidadParametros;
	}

	public void setCantidadParametros(int cantidadParametros) {
		this.cantidadParametros = cantidadParametros;
	}
    
}
