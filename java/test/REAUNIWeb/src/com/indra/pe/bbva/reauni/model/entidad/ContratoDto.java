package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

import org.apache.log4j.Logger;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.service.ProductoBO;
import com.indra.pe.bbva.reauni.service.SituacionesBO;
import com.indra.pe.bbva.reauni.service.SolicitudBO;
import com.indra.pe.bbva.reauni.service.TipoPrestamoBO;

@Entity
@Table(name = "TREAUNI_CONTRATO",schema="REAUNI")
public class ContratoDto implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(ContratoDto.class);
    
    @Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_CONTRATO")
	@TableGenerator(name = "SEQ_CONTRATO", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_CONTRATO", allocationSize = 1)
    private Long id;
    
    @Column(name = "CODIGO_CONTRATO")
    private String codigoContrato;
    
	@Column(name = "PRODUCTO")
	private String producto;
	
	@Transient
	private ProductoDto productoDto;
    
    @JoinColumn(name = "ESTADO", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto estadoDto;
    
    @Column(name = "SALDOD")
	private BigDecimal saldoD;
	
	@Column(name = "SALMORA")
	private BigDecimal salMora;
	
	@Column(name = "SALDOA")
	private BigDecimal saldoA;
	
	@Column(name = "SALDOVEN")
	private BigDecimal saldoVen;
	
	@Transient
	private BigDecimal totalActivo;
	
	@Transient
	private BigDecimal totalPasivo;
	
    @Column(name = "IMPORTE")
    private BigDecimal importe;
    
    @Column(name = "MONEDA_IMPORTE")
    private String monedaImporte;
    
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    
    @Column(name = "COMENTARIO_ESTADO")
	private String comentarioEstado;
    
    @Column(name = "USUARIO_ESTADO")
	private String usuarioEstado;
    
    @Column(name = "FECHA_ESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstado;
    
    @Column(name = "FECHA_RECEPCION_FILE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcionFile;
    
    @Column(name = "USUARIO_RECEPCION_FILE")
	private String usuarioRecepcionFile;

    @Column(name = "TIPO_PRESTAMO")
    private String tipoPrestamo;
    
    @JoinColumn(name = "SITUACION", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SituacionDto situacion;
    
    @JoinColumn(name = "OFICINA_SOLICITUD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.FALSE)
    private OficinaSolicitudDto oficinaSolicitudDto;
    
    @Column(name = "ESTADO_FILE")
    private Boolean estadoFile;
    
    @Transient
    private ParametroDto estadoBkp = null;
    
    @Column(name = "CODIGO_APLICATIVO")
	private String codigoAplicativo;
    
    @Column(name = "CODIGO_SITUACION")
	private String codigoSituacion;
    
    @Column(name = "FECHA_APERTURA")
	private String fechaApertura;
    
    @Transient
	private String descripcionSituacion;

    public ContratoDto() {
    }

    public ContratoDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public ProductoDto getProductoDto() {
		ProductoBO productoBO = (ProductoBO) WebServletContextListener.getApplicationContext().getBean("productoBO");
		try {
			productoDto = productoBO.obtenerProducto(producto);
		} catch (Exception e) {
			productoDto = new ProductoDto();
			productoDto.setCodProd(producto);
			productoDto.setDescProd("");
		}		
		return productoDto;
	}

    public ParametroDto getEstadoDto() {
		return estadoDto;
	}

	public void setEstadoDto(ParametroDto estadoDto) {
		this.estadoDto = estadoDto;
		if(this.estadoBkp == null){
			this.estadoBkp = estadoDto;
		}
	}

	public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getMonedaImporte() {
        return monedaImporte;
    }

    public void setMonedaImporte(String monedaImporte) {
        this.monedaImporte = monedaImporte;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getTipoPrestamo() {
		return this.tipoPrestamo;
	}
    
    public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	public TipoPrestamoDto getTipoPrestamoDto() {
		TipoPrestamoBO tipoPrestamoBO = (TipoPrestamoBO) WebServletContextListener.getApplicationContext().getBean("tipoPrestamoBO");
		List<TipoPrestamoDto> tiposPrestamo = null;
		TipoPrestamoDto tipoPrestamo = new TipoPrestamoDto();
		tipoPrestamo.setCodigo(getTipoPrestamo());
		if(getTipoPrestamo() != null && getTipoPrestamo().trim().length() > 0) {
			try {
				tiposPrestamo = tipoPrestamoBO.obtenerListaTipoPrestamos(tipoPrestamo);
				if(tiposPrestamo != null && tiposPrestamo.size() > 0) {
					tipoPrestamo = tiposPrestamo.get(0);
				}
			} catch (ServiceException e) {
				logger.error("Tipo de prestamo", e) ;
				tipoPrestamo = new TipoPrestamoDto();
				tipoPrestamo.setCodigo(getTipoPrestamo());
				tipoPrestamo.setDescripcion("");
			}
		}
		return tipoPrestamo;
    }

    public SituacionDto getSituacion() {
        return situacion;
    }

    public void setSituacion(SituacionDto situacion) {
        this.situacion = situacion;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OficinaSolicitudDto getOficinaSolicitudDto() {
		return oficinaSolicitudDto;
	}

	public void setOficinaSolicitudDto(OficinaSolicitudDto oficinaSolicitudDto) {
		this.oficinaSolicitudDto = oficinaSolicitudDto;
	}

	public Boolean getEstadoFile() {
		return estadoFile;
	}

	public void setEstadoFile(Boolean estadoFile) {
		this.estadoFile = estadoFile;
	}

	public String getComentarioEstado() {
		return comentarioEstado;
	}

	public void setComentarioEstado(String comentarioEstado) {
		this.comentarioEstado = comentarioEstado;
	}

	public String getUsuarioEstado() {
		return usuarioEstado;
	}

	public void setUsuarioEstado(String usuarioEstado) {
		this.usuarioEstado = usuarioEstado;
	}

	public Date getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}
	
	
	public String getFechaApertura() {		
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaRecepcionFile() {
		return fechaRecepcionFile;
	}

	public void setFechaRecepcionFile(Date fechaRecepcionFile) {
		this.fechaRecepcionFile = fechaRecepcionFile;
	}

	public String getUsuarioRecepcionFile() {
		return usuarioRecepcionFile;
	}

	public void setUsuarioRecepcionFile(String usuarioRecepcionFile) {
		this.usuarioRecepcionFile = usuarioRecepcionFile;
	}

	public ParametroDto getEstadoBkp() {
		return estadoBkp;
	}

	public void setEstadoBkp(ParametroDto estadoBkp) {
		this.estadoBkp = estadoBkp;
	}	    
	
	public String getCodigoAplicativo() {
		return codigoAplicativo;
	}

	public void setCodigoAplicativo(String codigoAplicativo) {
		this.codigoAplicativo = codigoAplicativo;
	}

	public String getCodigoSituacion() {
		return codigoSituacion;
	}

	public void setCodigoSituacion(String codigoSituacion) {
		this.codigoSituacion = codigoSituacion;
	}

	public String getDescripcionSituacion() {
		SituacionesBO situacionesBO = (SituacionesBO) WebServletContextListener.getApplicationContext().getBean("situacionesBO");
		try {
			SituacionDto s = situacionesBO.obtenerSituacionPorApicativoCodigo(this.codigoAplicativo, this.codigoSituacion);
			if(s != null) {
				descripcionSituacion = s.getDescripcion();
			}
		} catch (Exception e) {
			descripcionSituacion = " ";
		}
		return descripcionSituacion;
	}

	public void setDescripcionSituacion(String descripcionSituacion) {
		this.descripcionSituacion = descripcionSituacion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ContratoDto)) {
            return false;
        }
        ContratoDto other = (ContratoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.ContratoDto[ id=" + id + " ]";
    }
    
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
	public BigDecimal getSaldoD() {
		if (this.saldoD==null)
			saldoD = BigDecimal.ZERO;
		return saldoD;
	}

	public void setSaldoD(BigDecimal saldoD) {
		this.saldoD = saldoD;
	}

	public BigDecimal getSalMora() {
		return salMora;
	}

	public void setSalMora(BigDecimal salMora) {
		if (this.salMora==null)
			salMora = BigDecimal.ZERO;
		this.salMora = salMora;
	}

	public BigDecimal getSaldoA() {
		if (this.saldoA==null)
			saldoA = BigDecimal.ZERO;
		return saldoA;
	}

	public void setSaldoA(BigDecimal saldoA) {
		this.saldoA = saldoA;
	}

	public BigDecimal getSaldoVen() {
		if (this.saldoVen==null)
			saldoVen = BigDecimal.ZERO;
		return saldoVen;
	}

	public void setSaldoVen(BigDecimal saldoVen) {
		this.saldoVen = saldoVen;
	}

	public BigDecimal getTotalActivo() {
		this.totalActivo = this.getSaldoD();
		return totalActivo;
	}

	public void setTotalActivo(BigDecimal totalActivo) {
		this.totalActivo = totalActivo;
	}

	public BigDecimal getTotalPasivo() {
		this.totalPasivo = getSaldoA();
		return totalPasivo;
	}

	public void setTotalPasivo(BigDecimal totalPasivo) {
		this.totalPasivo = totalPasivo;
	}
	
	public String getOficinaOrigen() {
		String o = "";
		
		SolicitudBO solicitudBO = (SolicitudBO) WebServletContextListener.getApplicationContext().getBean("solicitudBO");
		try {
			ContratoTemporalDto c = solicitudBO.obtenerContratoTemporalesPorNumeroContrato(this.getCodigoContrato());
			if(c != null) {
				o = c.getOficina();
				if(o == null) {
					o = "";
				}
			}
		} catch (Exception e) {
			logger.error("Obteniendo la oficina de origen ", e);
			o = "";
		}
		
		return o;
	}
}