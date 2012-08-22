package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_permiso_perfilBeanCacheEntryImpl_edfb184d
 */
public class Tiido_permiso_perfilBeanCacheEntryImpl_edfb184d extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_permiso_perfilBeanCacheEntry_edfb184d {
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
	 * getTip_acceso
	 */
	public java.lang.String getTip_acceso() {
		return TIP_ACCESO_Data;
	}
	/**
	 * setTip_acceso
	 */
	public void setTip_acceso(String data) {
		this.TIP_ACCESO_Data=data;
	}
	/**
	 * setDataForTIP_ACCESO
	 */
	public void setDataForTIP_ACCESO(String data) {
		this.TIP_ACCESO_Data=data;
	}
	private String TIP_ACCESO_Data;
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
	 * getUsuario
	 */
	public java.lang.String getUsuario() {
		return USUARIO_Data;
	}
	/**
	 * setUsuario
	 */
	public void setUsuario(String data) {
		this.USUARIO_Data=data;
	}
	/**
	 * setDataForUSUARIO
	 */
	public void setDataForUSUARIO(String data) {
		this.USUARIO_Data=data;
	}
	private String USUARIO_Data;
	/**
	 * getUsu_regi
	 */
	public java.lang.String getUsu_regi() {
		return USU_REGI_Data;
	}
	/**
	 * setUsu_regi
	 */
	public void setUsu_regi(String data) {
		this.USU_REGI_Data=data;
	}
	/**
	 * setDataForUSU_REGI
	 */
	public void setDataForUSU_REGI(String data) {
		this.USU_REGI_Data=data;
	}
	private String USU_REGI_Data;
	/**
	 * getFec_regi
	 */
	public java.sql.Timestamp getFec_regi() {
		return FEC_REGI_Data;
	}
	/**
	 * setFec_regi
	 */
	public void setFec_regi(java.sql.Timestamp data) {
		if (data == null)
			this.FEC_REGI_Data= null;
		else {
			this.FEC_REGI_Data=data; }
	}
	/**
	 * setDataForFEC_REGI
	 */
	public void setDataForFEC_REGI(java.sql.Timestamp data) {
		this.FEC_REGI_Data=data;
	}
	private java.sql.Timestamp FEC_REGI_Data;
	/**
	 * getUsu_actu
	 */
	public java.lang.String getUsu_actu() {
		return USU_ACTU_Data;
	}
	/**
	 * setUsu_actu
	 */
	public void setUsu_actu(String data) {
		this.USU_ACTU_Data=data;
	}
	/**
	 * setDataForUSU_ACTU
	 */
	public void setDataForUSU_ACTU(String data) {
		this.USU_ACTU_Data=data;
	}
	private String USU_ACTU_Data;
	/**
	 * getFec_actu
	 */
	public java.sql.Date getFec_actu() {
		return (FEC_ACTU_Data == null) ? null : new java.sql.Date(FEC_ACTU_Data.getTime());
	}
	/**
	 * setFec_actu
	 */
	public void setFec_actu(java.sql.Date data) {
		if (data == null)
			this.FEC_ACTU_Data= null;
		else {
			this.FEC_ACTU_Data=new java.sql.Timestamp(data.getTime()); }
	}
	/**
	 * setDataForFEC_ACTU
	 */
	public void setDataForFEC_ACTU(java.sql.Timestamp data) {
		this.FEC_ACTU_Data=data;
	}
	private java.sql.Timestamp FEC_ACTU_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
