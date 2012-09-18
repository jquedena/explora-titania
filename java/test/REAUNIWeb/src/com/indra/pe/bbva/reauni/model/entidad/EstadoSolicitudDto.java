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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.ldap.model.entidad.LdapDto;
import com.indra.pe.bbva.ldap.service.LdapService;

@SuppressWarnings("unused")
@Entity
@Table(name = "TREAUNI_ESTADO_SOLICITUD",schema="REAUNI")
public class EstadoSolicitudDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_SOLICITUD_ESTADO")
	@TableGenerator(name = "SEQ_SOLICITUD_ESTADO", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_ESTADO_SOLICITUD", allocationSize = 1)
    private Long id;
    @JoinColumn(name = "ESTADO", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto estadoDto;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "USUARIO")
    private String usuario;
    
    @Transient
    private LdapDto usuarioDto;   
    
    
    @JoinColumn(name = "SOLICITUD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SolicitudDto solicitudDto;   
    @Column(name = "COMENTARIO")
    private String comentario;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParametroDto getEstadoDto() {
		return estadoDto;
	}

	public void setEstadoDto(ParametroDto estadoDto) {
		this.estadoDto = estadoDto;
	}

	public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    

	public LdapDto getUsuarioDto() {
		LdapService ldapService = (LdapService) WebServletContextListener.getApplicationContext().getBean("ldapService");
		try {
			return ldapService.obtenerInformacionPorRegistro(this.usuario);
		} catch (ServiceException e) {
			return null;
		}		
	}

	public void setUsuarioDto(LdapDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	

	public SolicitudDto getSolicitudDto() {
		return solicitudDto;
	}

	public void setSolicitudDto(SolicitudDto solicitudDto) {
		this.solicitudDto = solicitudDto;
	}

	
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    
    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EstadoSolicitudDto)) {
            return false;
        }
        EstadoSolicitudDto other = (EstadoSolicitudDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.EstadoSolicitudDto[ id=" + id + " ]";
    }
    
}
