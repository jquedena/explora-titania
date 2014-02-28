package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_FECHA_CORTE_DETA",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechaCorteDetaDto.findAll", query = "SELECT t FROM FechaCorteDetaDto t"),
    @NamedQuery(name = "FechaCorteDetaDto.findById", query = "SELECT t FROM FechaCorteDetaDto t WHERE t.id = :id"),
    @NamedQuery(name = "FechaCorteDetaDto.findByRegistroResponsable", query = "SELECT t FROM FechaCorteDetaDto t WHERE t.registroResponsable = :registroResponsable"),    
    @NamedQuery(name = "FechaCorteDetaDto.findByCantidadSolicitud", query = "SELECT t FROM FechaCorteDetaDto t WHERE t.cantidadSolicitud = :cantidadSolicitud")})
public class FechaCorteDetaDto implements Serializable {
 
	private static final long serialVersionUID = 4896270206213562371L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_FECHA_CORTE_DETA")
	@TableGenerator(name = "SEQ_FECHA_CORTE_DETA", schema="REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_FECHA_CORTE_DETA", allocationSize = 1)
    private Long id;
    
    @Column(name = "REGISTRO_RESPONSABLE")
    private String registroResponsable;
    
    @Column(name = "NOMBRE_RESPONSABLE")
    private String nombreResponsable;
 
    @Column(name = "CANTIDAD_SOLICITUD")
    private Integer cantidadSolicitud;
    
    @JoinColumn(name = "FECHA_CORTE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.FALSE)
    private FechaCorteDto fechaCorteDto;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Column(name = "PERFIL")    
    private Long perfil;
    
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    
    public FechaCorteDetaDto() {    	
    	fechaCorteDto =  new FechaCorteDto();
    }

    public FechaCorteDetaDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistroResponsable() {
        return registroResponsable;
    }

    public void setRegistroResponsable(String registroResponsable) {
        this.registroResponsable = registroResponsable;
    }
 

    public Integer getCantidadSolicitud() {
        return cantidadSolicitud;
    }

    public void setCantidadSolicitud(Integer cantidadSolicitud) {
        this.cantidadSolicitud = cantidadSolicitud;
    }

    public FechaCorteDto getFechaCorteDto() {
        return fechaCorteDto;
    }

    public void setFechaCorteDto(FechaCorteDto fechaCorte) {
        this.fechaCorteDto = fechaCorte;
    }
 
    public String getNombreResponsable() {
		return nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof FechaCorteDetaDto)) {
            return false;
        }
        FechaCorteDetaDto other = (FechaCorteDetaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.FechaCorteDetaDto[ id=" + id + " ]";
    }

	

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Long getPerfil() {
		return perfil;
	}

	public void setPerfil(Long perfil) {
		this.perfil = perfil;
	}
}
