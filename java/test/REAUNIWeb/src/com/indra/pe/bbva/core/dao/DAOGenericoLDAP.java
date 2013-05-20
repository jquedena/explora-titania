package com.indra.pe.bbva.core.dao;

import java.util.List;

import com.indra.pe.bbva.core.exception.DAOException;

@SuppressWarnings({"rawtypes"})
public interface DAOGenericoLDAP<Dto> {
	
	public List<Dto> obtenerDtosConFiltros(Class c,String columna,Object valor) throws DAOException;
	public List<Dto> obtenerDtosInvolucrados(Class c, String codOficina,String...codCargos) throws DAOException;
	public List<Dto> obtenerDtosInvolucradosGT(Class c, String codOficina,String...codCargos) throws DAOException;
	public String obtenerDtosInvolucrados(String codOfi) throws DAOException;	
}
