package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TREAUNI_CARGO", schema = "REAUNI")
public class CargoDto implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id
	@Column(name="CARGO")
	private String cargo;
	
	@Column(name="PERFIL")
	private String perfil;

	@Column(name="ORDEN")
	private BigDecimal orden;
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}
}
