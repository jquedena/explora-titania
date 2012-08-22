package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_maestro_planesBeanCacheEntryImpl_83d95438
 */
public class Tiido_maestro_planesBeanCacheEntryImpl_83d95438 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_maestro_planesBeanCacheEntry_83d95438 {
	static final long serialVersionUID = 61;
	/**
	 * getMes
	 */
	public java.lang.String getMes() {
		return MES_Data;
	}
	/**
	 * setMes
	 */
	public void setMes(String data) {
		this.MES_Data=data;
	}
	/**
	 * setDataForMES
	 */
	public void setDataForMES(String data) {
		this.MES_Data=data;
	}
	private String MES_Data;
	/**
	 * getAnho
	 */
	public java.lang.String getAnho() {
		return ANHO_Data;
	}
	/**
	 * setAnho
	 */
	public void setAnho(String data) {
		this.ANHO_Data=data;
	}
	/**
	 * setDataForANHO
	 */
	public void setDataForANHO(String data) {
		this.ANHO_Data=data;
	}
	private String ANHO_Data;
	/**
	 * getPrioridad
	 */
	public java.math.BigDecimal getPrioridad() {
		return PRIORIDAD_Data;
	}
	/**
	 * setPrioridad
	 */
	public void setPrioridad(java.math.BigDecimal data) {
		if (data == null)
			this.PRIORIDAD_Data= null;
		else {
			this.PRIORIDAD_Data=data; }
	}
	/**
	 * setDataForPRIORIDAD
	 */
	public void setDataForPRIORIDAD(java.math.BigDecimal data) {
		this.PRIORIDAD_Data=data;
	}
	private java.math.BigDecimal PRIORIDAD_Data;
	/**
	 * getFec_grab
	 */
	public java.sql.Date getFec_grab() {
		return FEC_GRAB_Data;
	}
	/**
	 * setFec_grab
	 */
	public void setFec_grab(java.sql.Date data) {
		if (data == null)
			this.FEC_GRAB_Data= null;
		else {
			this.FEC_GRAB_Data=data; }
	}
	/**
	 * setDataForFEC_GRAB
	 */
	public void setDataForFEC_GRAB(java.sql.Date data) {
		this.FEC_GRAB_Data=data;
	}
	private java.sql.Date FEC_GRAB_Data;
	/**
	 * getTiido_maepla_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_maepla_oficina_fk_cod_ofic() {
		return COD_OFIC_Data;
	}
	/**
	 * setTiido_maepla_oficina_fk_cod_ofic
	 */
	public void setTiido_maepla_oficina_fk_cod_ofic(String data) {
		this.COD_OFIC_Data=data;
	}
	/**
	 * setDataForCOD_OFIC
	 */
	public void setDataForCOD_OFIC(String data) {
		this.COD_OFIC_Data=data;
	}
	private String COD_OFIC_Data;
	/**
	 * getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr() {
		return COD_TERR_Data;
	}
	/**
	 * setTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr(String data) {
		this.COD_TERR_Data=data;
	}
	/**
	 * setDataForCOD_TERR
	 */
	public void setDataForCOD_TERR(String data) {
		this.COD_TERR_Data=data;
	}
	private String COD_TERR_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
	/**
	 * getTiido_maepla_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_maepla_oficina_fkKey() {
		if(COD_OFIC_Data==null||COD_TERR_Data==null)
			return null;
		entities.Tiido_oficinaKey key=new entities.Tiido_oficinaKey();
		key.cod_ofic=COD_OFIC_Data;
		key.tiido_territorio_fk_cod_terr=COD_TERR_Data;
		return key;
	}
	/**
	 * setTiido_maepla_oficina_fkKey
	 */
	public void setTiido_maepla_oficina_fkKey(entities.Tiido_oficinaKey data) {
		if(data==null)
		{
			this.COD_OFIC_Data= null;
			this.COD_TERR_Data= null;
		}
		else {
		this.COD_OFIC_Data=data.cod_ofic;
		this.COD_TERR_Data=data.tiido_territorio_fk_cod_terr;
		}
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("tiido_maepla_oficina_fk"))
			return getTiido_maepla_oficina_fkKey();
		else
			return null;
	}
}
