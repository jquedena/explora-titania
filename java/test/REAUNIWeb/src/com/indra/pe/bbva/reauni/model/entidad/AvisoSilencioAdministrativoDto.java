package com.indra.pe.bbva.reauni.model.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VREAUNI_AVISO_SIL_ADM", schema = "REAUNI")
public class AvisoSilencioAdministrativoDto {

	@Id
	@Column(name = "VALOR")
	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
