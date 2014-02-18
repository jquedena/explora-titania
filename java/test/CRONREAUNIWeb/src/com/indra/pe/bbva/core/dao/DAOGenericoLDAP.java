package com.indra.pe.bbva.core.dao;

import com.indra.pe.bbva.core.exception.DAOException;

public interface DAOGenericoLDAP<Dto> {
	
	public String obtenerTerritorio(String codOfi) throws DAOException;	
}