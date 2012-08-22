package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_firmasBeanCacheEntryImpl_7cbca68a
 */
public class Tiido_firmasBeanCacheEntryImpl_7cbca68a extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_firmasBeanCacheEntry_7cbca68a {
	static final long serialVersionUID = 61;
	/**
	 * getCod_firma
	 */
	public java.lang.String getCod_firma() {
		return COD_FIRMA_Data;
	}
	/**
	 * setCod_firma
	 */
	public void setCod_firma(String data) {
		this.COD_FIRMA_Data=data;
	}
	/**
	 * setDataForCOD_FIRMA
	 */
	public void setDataForCOD_FIRMA(String data) {
		this.COD_FIRMA_Data=data;
	}
	private String COD_FIRMA_Data;
	/**
	 * getAnho_firm
	 */
	public java.lang.String getAnho_firm() {
		return ANHO_FIRM_Data;
	}
	/**
	 * setAnho_firm
	 */
	public void setAnho_firm(String data) {
		this.ANHO_FIRM_Data=data;
	}
	/**
	 * setDataForANHO_FIRM
	 */
	public void setDataForANHO_FIRM(String data) {
		this.ANHO_FIRM_Data=data;
	}
	private String ANHO_FIRM_Data;
	/**
	 * getMes_firm
	 */
	public java.lang.String getMes_firm() {
		return MES_FIRM_Data;
	}
	/**
	 * setMes_firm
	 */
	public void setMes_firm(String data) {
		this.MES_FIRM_Data=data;
	}
	/**
	 * setDataForMES_FIRM
	 */
	public void setDataForMES_FIRM(String data) {
		this.MES_FIRM_Data=data;
	}
	private String MES_FIRM_Data;
	/**
	 * getItem_firm
	 */
	public java.lang.String getItem_firm() {
		return ITEM_FIRM_Data;
	}
	/**
	 * setItem_firm
	 */
	public void setItem_firm(String data) {
		this.ITEM_FIRM_Data=data;
	}
	/**
	 * setDataForITEM_FIRM
	 */
	public void setDataForITEM_FIRM(String data) {
		this.ITEM_FIRM_Data=data;
	}
	private String ITEM_FIRM_Data;
	/**
	 * getCod_gestor
	 */
	public java.lang.String getCod_gestor() {
		return COD_GESTOR_Data;
	}
	/**
	 * setCod_gestor
	 */
	public void setCod_gestor(String data) {
		this.COD_GESTOR_Data=data;
	}
	/**
	 * setDataForCOD_GESTOR
	 */
	public void setDataForCOD_GESTOR(String data) {
		this.COD_GESTOR_Data=data;
	}
	private String COD_GESTOR_Data;
	/**
	 * getDescripcion
	 */
	public java.lang.String getDescripcion() {
		return DESCRIPCION_Data;
	}
	/**
	 * setDescripcion
	 */
	public void setDescripcion(String data) {
		this.DESCRIPCION_Data=data;
	}
	/**
	 * setDataForDESCRIPCION
	 */
	public void setDataForDESCRIPCION(String data) {
		this.DESCRIPCION_Data=data;
	}
	private String DESCRIPCION_Data;
	/**
	 * getFec_firm
	 */
	public java.sql.Date getFec_firm() {
		return FEC_FIRM_Data;
	}
	/**
	 * setFec_firm
	 */
	public void setFec_firm(java.sql.Date data) {
		if (data == null)
			this.FEC_FIRM_Data= null;
		else {
			this.FEC_FIRM_Data=data; }
	}
	/**
	 * setDataForFEC_FIRM
	 */
	public void setDataForFEC_FIRM(java.sql.Date data) {
		this.FEC_FIRM_Data=data;
	}
	private java.sql.Date FEC_FIRM_Data;
	/**
	 * getTiido_fir_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_fir_oficina_fk_cod_ofic() {
		return COD_OFIC_Data;
	}
	/**
	 * setTiido_fir_oficina_fk_cod_ofic
	 */
	public void setTiido_fir_oficina_fk_cod_ofic(String data) {
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
	 * getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr() {
		return COD_TERR_Data;
	}
	/**
	 * setTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr(String data) {
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
	 * getTiido_fir_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_fir_oficina_fkKey() {
		if(COD_OFIC_Data==null||COD_TERR_Data==null)
			return null;
		entities.Tiido_oficinaKey key=new entities.Tiido_oficinaKey();
		key.cod_ofic=COD_OFIC_Data;
		key.tiido_territorio_fk_cod_terr=COD_TERR_Data;
		return key;
	}
	/**
	 * setTiido_fir_oficina_fkKey
	 */
	public void setTiido_fir_oficina_fkKey(entities.Tiido_oficinaKey data) {
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
		if(role.equals("tiido_fir_oficina_fk"))
			return getTiido_fir_oficina_fkKey();
		else
			return null;
	}
}
