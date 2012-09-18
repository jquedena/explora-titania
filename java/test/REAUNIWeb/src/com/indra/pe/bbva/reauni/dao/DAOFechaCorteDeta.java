package com.indra.pe.bbva.reauni.dao;

import java.math.BigDecimal;
import java.util.List;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;

public interface DAOFechaCorteDeta<FechaCorteDetaDto> extends DAOGenerico<FechaCorteDetaDto>{
	public List<FechaCorteDetaDto> obtenerListaFechaCorteDeta(FechaCorteDetaDto fechaCorteDetaDto) throws DAOException;
	public List<FechaCorteDetaDto> obtenerFechasCorte(String registro) throws DAOException ;
	public BigDecimal validarFechaCorte(String registro, FechaCorteDto fechaCorte) throws DAOException ;
	public boolean existeRegistroFechaCorte(String registro, FechaCorteDto fechaCorte, Long id) throws DAOException;
}
