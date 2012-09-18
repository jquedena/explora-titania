package com.indra.pe.bbva.reauni.dao;

import java.util.List;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;

public interface DAOFechaCorte<FechaCorteDto> extends DAOGenerico<FechaCorteDto> {

	public List<FechaCorteDto> obtenerListaFechaCorte(FechaCorteDto fechaCorteDto) throws DAOException;
}
