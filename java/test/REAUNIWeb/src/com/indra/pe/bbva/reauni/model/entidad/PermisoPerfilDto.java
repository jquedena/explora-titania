package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_PERMISO_PERFIL",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisoPerfilDto.findAll", query = "SELECT t FROM PermisoPerfilDto t"),
    @NamedQuery(name = "PermisoPerfilDto.findById", query = "SELECT t FROM PermisoPerfilDto t WHERE t.id = :id"),
    @NamedQuery(name = "PermisoPerfilDto.findByTipoAcceso", query = "SELECT t FROM PermisoPerfilDto t WHERE t.tipoAcceso = :tipoAcceso"),
    @NamedQuery(name = "PermisoPerfilDto.findByValor", query = "SELECT t FROM PermisoPerfilDto t WHERE t.valor = :valor")})
public class PermisoPerfilDto implements Serializable {
 
	private static final long serialVersionUID = -7323205903374440423L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_PERMISO_PERFIL")
    @TableGenerator(name = "SEQ_PERMISO_PERFIL", schema="REAUNI", table = "TREAUNI_ENTIDAD", 
    		pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_PERMISO_PERFIL", allocationSize = 1)
    private Long id;
    
    @Column(name = "TIPO_ACCESO")
    private Long tipoAcceso;
    
    @Column(name = "VALOR")
    private String valor;
    
    @JoinColumn(name = "PERFIL", referencedColumnName = "ID")
    @ManyToOne
    @LazyToOne(LazyToOneOption.FALSE)
    private PerfilDto perfil;
    
    public PermisoPerfilDto() {
    	perfil = new PerfilDto();
    }

    public PermisoPerfilDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(Long tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public PerfilDto getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDto perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PermisoPerfilDto)) {
            return false;
        }
        PermisoPerfilDto other = (PermisoPerfilDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.PermisoPerfilDto[ id=" + id + " ]";
    }
    
}
