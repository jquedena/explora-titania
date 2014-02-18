package com.indra.pe.bbva.reauni.service;

import com.indra.pe.bbva.core.exception.DAOException;

public interface ProcedimientoService {

	void ejecutarProcesoSilencioAdministrativo() throws DAOException;
	void ejecutarProcesoEvaluacionContrato() throws DAOException;
	void ejecutarProcesoCargaArchivo() throws DAOException;
	
}
