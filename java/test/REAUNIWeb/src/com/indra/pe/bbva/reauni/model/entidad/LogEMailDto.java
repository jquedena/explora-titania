
package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TREAUNI_LOG_EMAIL",schema="REAUNI")
public class LogEMailDto implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_LOG_EMAIL")
	@TableGenerator(name = "SEQ_LOG_EMAIL", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_LOG_EMAIL", allocationSize = 1)
    private Long id;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "REGISTRO")
    private String registro;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "NRO_CONTRATOS")
    private Long nroContratos;
    
    @Column(name = "ESTADO")
    private BigDecimal estado;
    
    @Column(name = "FECHA_ENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    @Column(name = "COD_TERRITORIO")
    private String codTerritorio;
    
    @Column(name = "DES_TERRITORIO")
    private String desTerritorio;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNroContratos() {
		return nroContratos;
	}

	public void setNroContratos(Long nroContratos) {
		this.nroContratos = nroContratos;
	}

	public BigDecimal getEstado() {
		return estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getCodTerritorio() {
		return codTerritorio;
	}

	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}

	public String getDesTerritorio() {
		return desTerritorio;
	}

	public void setDesTerritorio(String desTerritorio) {
		this.desTerritorio = desTerritorio;
	}
}
