package com.indra.pe.bbva.reauni.mail;

public enum TipoCorreoEnum {
	
	EVALUACION,
	RECHAZO_APROBACION,
	SILENCIO_ADMINISTRATIVO,
	RECEPCION_FILE,
	NO_RECEPCION_FILE,
	PROCESAMIENTO_CORREO,
	CONTRATO_OBSERVADO,
	GESTION_FILE,
	ANULACION_GESTION_FILE;
	
	public static TipoCorreoEnum getTipoCorreoEnum(int index){
		switch(index){
			case 1: 
					return TipoCorreoEnum.EVALUACION;
			case 2: 
					return TipoCorreoEnum.RECHAZO_APROBACION;
			case 3: 
					return TipoCorreoEnum.SILENCIO_ADMINISTRATIVO;
			case 4: 
					return TipoCorreoEnum.RECEPCION_FILE;
			case 5: 
					return TipoCorreoEnum.NO_RECEPCION_FILE;
			case 6: 
					return TipoCorreoEnum.PROCESAMIENTO_CORREO;
			case 7: 
					return TipoCorreoEnum.CONTRATO_OBSERVADO;
			case 8:
					return TipoCorreoEnum.GESTION_FILE;
			case 9:
					return TipoCorreoEnum.ANULACION_GESTION_FILE;
		default:
			throw new RuntimeException("index desconocido " + index);	
		}
	}
}
