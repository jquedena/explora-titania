package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.service.ProductoBO;
import com.indra.pe.bbva.reauni.service.SituacionesBO;
import com.indra.pe.bbva.reauni.service.TipoPrestamoBO;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;

@Entity
@Table(name = "TREAUNI_CONTRATO_TEMPORAL",schema="REAUNI")
public class ContratoTemporalDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ContratoTemporalDto.class);
	
	@Id
	@Column(name = "CONTRATO")
	private String codigoContrato;
	
	@Column(name = "CODIGO_APLICATIVO")
	private String codigoAplicativo;
	
	@Column(name = "SITUACION")
	private String situacion;
	
	@Column(name = "CODIGO_CENTRAL")
	private String codigoCentral;
	
	@Column(name = "PRODUCTOS")
	private String producto;
	
	@Transient
	private ProductoDto productoDto;
	
	@Column(name = "SALDOD")
	private BigDecimal saldoD;
	
	@Column(name = "SALMORA")
	private BigDecimal salMora;
	
	@Column(name = "SALDOA")
	private BigDecimal saldoA;
	
	@Column(name = "SALDOVEN")
	private BigDecimal saldoVen;
	
	@Column(name = "FECHA_APERTURA")
	private String fechaApertura;
	
	@Transient
	private BigDecimal totalActivo;
	
	@Transient
	private BigDecimal totalPasivo;
	
	@Column(name = "CECONTA")
	private String oficina;
	
	@Column(name = "TIPO_PRESTAMO")
	private String tipoPrestamo;
	
	@Transient
	private OficinaDto oficinaDto;
	
	@Transient
	private BigDecimal importe;
	
	@Transient
	private String moneda;
	
	@Transient
	private BigDecimal importeSoles;
	
	@Transient
	private Boolean reasignarUnificar;
	
	@Transient
	private String descripcionSituacion;
	
	public ContratoTemporalDto() {
	}

	public ContratoTemporalDto(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public String getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public OficinaDto getOficinaDto() {
		this.oficinaDto = SelectOneMenuHelper.obtenerOficina(this.oficina);
		return oficinaDto;
	}

	public void setOficinaDto(OficinaDto oficinaDto) {
		this.oficinaDto = oficinaDto;
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

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public BigDecimal getImporte() {
		this.importe = this.saldoD.add(this.saldoA).add(this.saldoVen);
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getImporteSoles() {	
		return importeSoles;
	}

	public void setImporteSoles(BigDecimal importeSoles) {
		this.importeSoles = importeSoles;
	}

	public Boolean getReasignarUnificar() {
		return reasignarUnificar;
	}

	public void setReasignarUnificar(Boolean reasignarUnificar) {
		this.reasignarUnificar = reasignarUnificar;
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
	
	public String getCodigoCentral() {
		return codigoCentral;
	}

	public void setCodigoCentral(String codigoCentral) {
		this.codigoCentral = codigoCentral;
	}

	public String getCodigoAplicativo() {
		return codigoAplicativo;
	}

	public void setCodigoAplicativo(String codigoAplicativo) {
		this.codigoAplicativo = codigoAplicativo;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getDescripcionSituacion() {
		SituacionesBO situacionesBO = (SituacionesBO) WebServletContextListener.getApplicationContext().getBean("situacionesBO");
		try {
			SituacionDto s = situacionesBO.obtenerSituacionPorApicativoCodigo(this.codigoAplicativo, this.situacion);
			descripcionSituacion = s.getDescripcion();
		} catch (Exception e) {
			descripcionSituacion = "";
		}
		return descripcionSituacion;
	}

	public void setDescripcionSituacion(String descripcionSituacion) {
		this.descripcionSituacion = descripcionSituacion;
	}

	public String getFechaApertura() {
		String fecha = fechaApertura;
		if (fecha != null && fecha.length()==8) {
			fecha = fecha.substring(6,8) + "/" + fecha.substring(4,6) + "/" + fecha.substring(0,4); 
		}else {
			fecha = "";
		}
		return fecha;
	}

	public void setFechaApertura(String fechaApertura) {		
		this.fechaApertura = fechaApertura;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codigoContrato != null ? this.codigoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ContratoTemporalDto)) {
            return false;
        }
        ContratoTemporalDto other = (ContratoTemporalDto) object;
        if ((this.codigoContrato == null && other.codigoContrato != null) || (this.codigoContrato != null && !this.codigoContrato.equals(other.codigoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.ContratoTemporalDto[ codigoContrato=" + codigoContrato + " ]";
    }

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getTipoPrestamo() {
		return tipoPrestamo;
	}
	
	public TipoPrestamoDto getTipoPrestamoDto() {
		TipoPrestamoBO tipoPrestamoBO = (TipoPrestamoBO) WebServletContextListener.getApplicationContext().getBean("tipoPrestamoBO");
		List<TipoPrestamoDto> tiposPrestamo = null;
		TipoPrestamoDto tipoPrestamo = new TipoPrestamoDto();
		if(getTipoPrestamo() != null && getTipoPrestamo().trim().length() > 0) {
			tipoPrestamo.setCodigo(getTipoPrestamo());
			try {
				tiposPrestamo = tipoPrestamoBO.obtenerListaTipoPrestamos(tipoPrestamo);
				if(tiposPrestamo != null && tiposPrestamo.size() > 0) {
					tipoPrestamo = tiposPrestamo.get(0);
				}
			} catch (ServiceException e) {
				logger.error("Tipo de prestamo", e) ;
				tipoPrestamo = new TipoPrestamoDto();
				tipoPrestamo.setCodigo(getTipoPrestamo());
				tipoPrestamo.setDescripcion(getTipoPrestamo());
			}
		}
		return tipoPrestamo;
    }

	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}
}
