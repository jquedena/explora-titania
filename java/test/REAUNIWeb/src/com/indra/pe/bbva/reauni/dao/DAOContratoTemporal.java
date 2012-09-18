package com.indra.pe.bbva.reauni.dao;

import java.util.List;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;

public interface DAOContratoTemporal<ContratoTemporalDto> extends DAOGenerico<ContratoTemporalDto> {
	
	public List<ContratoTemporalDto> listaContratosTemporalesPorCliente(String codigoCliente)throws DAOException;
	
	public ContratoTemporalDto obtenerContratoTemporalesPorNumeroContrato (String numeroContrato)  throws DAOException;
}
