package com.indra.pe.bbva.core.dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface ReporteDAO {
	
	public List generarReportePorOficina();
	public List generarReportePorTerritorio();
	public List generarReportePorTiempoTramite();
	public List generarReportePorTipoSolicitante();
	//public List generarReportePorTiempoTramiteUnificacion();
}
