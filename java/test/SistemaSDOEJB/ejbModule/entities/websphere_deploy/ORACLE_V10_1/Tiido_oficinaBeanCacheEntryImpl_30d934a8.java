package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_oficinaBeanCacheEntryImpl_30d934a8
 */
public class Tiido_oficinaBeanCacheEntryImpl_30d934a8 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_oficinaBeanCacheEntry_30d934a8 {
	static final long serialVersionUID = 61;
	/**
	 * getCod_ofic
	 */
	public java.lang.String getCod_ofic() {
		return COD_OFIC_Data;
	}
	/**
	 * setCod_ofic
	 */
	public void setCod_ofic(String data) {
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
	 * getNom_ofic
	 */
	public java.lang.String getNom_ofic() {
		return NOM_OFIC_Data;
	}
	/**
	 * setNom_ofic
	 */
	public void setNom_ofic(String data) {
		this.NOM_OFIC_Data=data;
	}
	/**
	 * setDataForNOM_OFIC
	 */
	public void setDataForNOM_OFIC(String data) {
		this.NOM_OFIC_Data=data;
	}
	private String NOM_OFIC_Data;
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
	public java.sql.Date getFec_regi() {
		return FEC_REGI_Data;
	}
	/**
	 * setFec_regi
	 */
	public void setFec_regi(java.sql.Date data) {
		if (data == null)
			this.FEC_REGI_Data= null;
		else {
			this.FEC_REGI_Data=data; }
	}
	/**
	 * setDataForFEC_REGI
	 */
	public void setDataForFEC_REGI(java.sql.Date data) {
		this.FEC_REGI_Data=data;
	}
	private java.sql.Date FEC_REGI_Data;
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
		return FEC_ACTU_Data;
	}
	/**
	 * setFec_actu
	 */
	public void setFec_actu(java.sql.Date data) {
		if (data == null)
			this.FEC_ACTU_Data= null;
		else {
			this.FEC_ACTU_Data=data; }
	}
	/**
	 * setDataForFEC_ACTU
	 */
	public void setDataForFEC_ACTU(java.sql.Date data) {
		this.FEC_ACTU_Data=data;
	}
	private java.sql.Date FEC_ACTU_Data;
	/**
	 * getEstado
	 */
	public java.lang.String getEstado() {
		return ESTADO_Data;
	}
	/**
	 * setEstado
	 */
	public void setEstado(String data) {
		this.ESTADO_Data=data;
	}
	/**
	 * setDataForESTADO
	 */
	public void setDataForESTADO(String data) {
		this.ESTADO_Data=data;
	}
	private String ESTADO_Data;
	/**
	 * getTiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_territorio_fk_cod_terr() {
		return COD_TERR_Data;
	}
	/**
	 * setTiido_territorio_fk_cod_terr
	 */
	public void setTiido_territorio_fk_cod_terr(String data) {
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
	 * getTiido_territorio_fkKey
	 */
	public entities.Tiido_territorioKey getTiido_territorio_fkKey() {
		if(COD_TERR_Data==null)
			return null;
		entities.Tiido_territorioKey key=new entities.Tiido_territorioKey();
		key.cod_terr=COD_TERR_Data;
		return key;
	}
	/**
	 * setTiido_territorio_fkKey
	 */
	public void setTiido_territorio_fkKey(entities.Tiido_territorioKey data) {
		if(data==null)
		{
			this.COD_TERR_Data= null;
		}
		else {
		this.COD_TERR_Data=data.cod_terr;
		}
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("tiido_territorio_fk"))
			return getTiido_territorio_fkKey();
		else
			return null;
	}
}
