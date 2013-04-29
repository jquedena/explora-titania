package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "TREAUNI_OFICINA_INVOLUCRADO",schema="REAUNI")
@Proxy( lazy=false )
public class OficinaInvolucradoDto implements Serializable, Comparable<Object> {
	
	public static Long VOTO_PENDIENTE = 1034L;
	public static Long VOTO_ACEPTADO = 1029L;
	public static Long VOTO_RECHAZADO = 1030L;
	public static String GERENTE_TERRITORIAL = "CH1";
	public static String JEFE_PROMOCION_NEGOCIOS = "CH6";
	public static String GERENTE_REGIONAL_BANCA_EMPRESAS = "OS8";
	
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_OFICINA_INVOLUCRADO")
	@TableGenerator(name = "SEQ_OFICINA_INVOLUCRADO", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_OFICINA_INVOLUCRADO", allocationSize = 1)
    private Long id;
    
    @JoinColumn(name = "OFICINA_SOLICITUD", referencedColumnName = "ID")
    @ManyToOne
    private OficinaSolicitudDto oficinaSolicitudDto;
    
    @JoinColumn(name = "INVOLUCRADO", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.FALSE)
    private InvolucradoDto involucradoDto;    
    
    @JoinColumn(name = "ESTADO", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto estadoDto;
    
    @Transient
    private ParametroDto estadoDtoBkp; 
   
    @Column(name = "COMENTARIO")
    private String comentario;
    
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "FECHA_VOTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVoto;
    
    public OficinaInvolucradoDto() {
    }

    public OficinaInvolucradoDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }  

    public OficinaSolicitudDto getOficinaSolicitudDto() {
		return oficinaSolicitudDto;
	}

	public void setOficinaSolicitudDto(OficinaSolicitudDto oficinaSolicitudDto) {
		this.oficinaSolicitudDto = oficinaSolicitudDto;
	}

    public InvolucradoDto getInvolucradoDto() {
		return involucradoDto;
	}

	public void setInvolucradoDto(InvolucradoDto involucradoDto) {
		this.involucradoDto = involucradoDto;
	}

	public ParametroDto getEstadoDto() {
		return estadoDto;
	}

	public void setEstadoDto(ParametroDto estadoDto) {
		this.estadoDto = estadoDto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ParametroDto getEstadoDtoBkp() {
		return estadoDtoBkp;
	}

	public void setEstadoDtoBkp(ParametroDto estadoDtoBkp) {
		this.estadoDtoBkp = estadoDtoBkp;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof OficinaInvolucradoDto)) {
            return false;
        }
        OficinaInvolucradoDto other = (OficinaInvolucradoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.OficinaInvolucradoDto[ id=" + id + " ]";
    }

	public String getCargo() {
		return involucradoDto.getCargo();
	}
	
	public Boolean getRealizoVoto() {
		Boolean realizoVoto = Boolean.FALSE;
		
		if(getEstadoDtoBkp() != null) {	
			if(OficinaInvolucradoDto.VOTO_PENDIENTE.compareTo(getEstadoDtoBkp().getId()) != 0) {
				realizoVoto = Boolean.TRUE;
			}
		}
		return realizoVoto;
	}
	
	public BigDecimal getOrden() {
		if(involucradoDto.getCargoDto() != null)
			return involucradoDto.getCargoDto().getOrden();
		else
			return BigDecimal.TEN;
	}

	public String getPerfil() {
		if(involucradoDto.getCargoDto() != null)
			return involucradoDto.getCargoDto().getPerfil();
		else
			return "";
	}
	

	public String getNombreCompleto() {
		if(involucradoDto != null) 
			return involucradoDto.getNombres() + " " + involucradoDto.getApellidoPaterno() + " " + involucradoDto.getApellidoMaterno();
		else
			return "";
	}
	
	@Override
	public int compareTo(Object o) {
		int compare = -1;

		if(o != null && this.getId() != null && this.getInvolucradoDto() != null && this.getInvolucradoDto().getRegistro() != null) {
			if(o instanceof OficinaInvolucradoDto) {
				OficinaInvolucradoDto c = (OficinaInvolucradoDto) o;
				compare = this.getId().compareTo(c.getId());
			}
			if(o instanceof InvolucradoDto) {
				InvolucradoDto c = (InvolucradoDto) o;
				compare = this.getInvolucradoDto().getRegistro().compareToIgnoreCase(c.getRegistro());
			}
			if(o instanceof String) {
				String c = (String) o;
				String territorioCargo = this.getInvolucradoDto().getCargo() + this.getOficinaSolicitudDto().getOficinaDto().getTerritorioDto().getCodTerritorio();
				compare = territorioCargo.compareToIgnoreCase(c);
			}
		}
	
		return compare;
	}

	public Date getFechaVoto() {
		return fechaVoto;
	}

	public void setFechaVoto(Date fechaVoto) {
		this.fechaVoto = fechaVoto;
	}
}
