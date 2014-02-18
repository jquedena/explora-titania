package com.indra.pe.bbva.reauni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.pe.bbva.core.transactional.AppReauniTxReadOnly;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.model.entidad.TareaDto;
import com.indra.pe.bbva.reauni.service.ProcedimientoService;

@Service("procedimientoService")
public class ProcedimientoServiceImpl implements ProcedimientoService {

	@Autowired
	private DAOGenerico<TareaDto> daoTarea;

	@Override
	@AppReauniTxReadOnly
	public void ejecutarProcesoSilencioAdministrativo() throws DAOException {
		daoTarea.executeProcedure("{call reauni.sp_proceso_silencio_adm()}");
	}

	@Override
	@AppReauniTxReadOnly
	public void ejecutarProcesoEvaluacionContrato() throws DAOException {
		daoTarea.executeProcedure("{call reauni.sp_proceso_evalua_contrato()}");
	}

	@Override
	@AppReauniTxReadOnly
	public void ejecutarProcesoCargaArchivo() throws DAOException {
		daoTarea.executeProcedure("{call REAUNI.PCK_CARGA_ARCHIVOS.EJECUTAR_CARGA_DIARIA()}");
	}

}
