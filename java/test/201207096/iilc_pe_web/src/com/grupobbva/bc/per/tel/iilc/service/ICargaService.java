package com.grupobbva.bc.per.tel.iilc.service;

import java.sql.SQLException;
import java.util.Date;

public interface ICargaService 
{

	public String verificarConflictoCarga(String tipo, Date fecha) throws SQLException ;
	
}
