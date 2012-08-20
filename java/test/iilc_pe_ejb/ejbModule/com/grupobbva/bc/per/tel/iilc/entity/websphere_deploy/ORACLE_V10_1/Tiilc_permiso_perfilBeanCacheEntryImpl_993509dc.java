package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_permiso_perfilBeanCacheEntryImpl_993509dc
 */
public class Tiilc_permiso_perfilBeanCacheEntryImpl_993509dc extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_permiso_perfilBeanCacheEntry_993509dc {
	static final long serialVersionUID = 61;
	/**
	 * getCod_perfil
	 */
	public java.lang.String getCod_perfil() {
		return COD_PERFIL_Data;
	}
	/**
	 * setCod_perfil
	 */
	public void setCod_perfil(String data) {
		this.COD_PERFIL_Data=data;
	}
	/**
	 * setDataForCOD_PERFIL
	 */
	public void setDataForCOD_PERFIL(String data) {
		this.COD_PERFIL_Data=data;
	}
	private String COD_PERFIL_Data;
	/**
	 * getTipo_acceso
	 */
	public java.math.BigDecimal getTipo_acceso() {
		return TIPO_ACCESO_Data;
	}
	/**
	 * setTipo_acceso
	 */
	public void setTipo_acceso(java.math.BigDecimal data) {
		if (data == null)
			this.TIPO_ACCESO_Data= null;
		else {
			this.TIPO_ACCESO_Data=data; }
	}
	/**
	 * setDataForTIPO_ACCESO
	 */
	public void setDataForTIPO_ACCESO(java.math.BigDecimal data) {
		this.TIPO_ACCESO_Data=data;
	}
	private java.math.BigDecimal TIPO_ACCESO_Data;
	/**
	 * getValor_rcp
	 */
	public java.lang.String getValor_rcp() {
		return VALOR_RCP_Data;
	}
	/**
	 * setValor_rcp
	 */
	public void setValor_rcp(String data) {
		this.VALOR_RCP_Data=data;
	}
	/**
	 * setDataForVALOR_RCP
	 */
	public void setDataForVALOR_RCP(String data) {
		this.VALOR_RCP_Data=data;
	}
	private String VALOR_RCP_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
