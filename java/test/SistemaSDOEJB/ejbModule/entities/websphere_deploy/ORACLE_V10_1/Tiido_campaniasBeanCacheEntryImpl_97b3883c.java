package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_campaniasBeanCacheEntryImpl_97b3883c
 */
public class Tiido_campaniasBeanCacheEntryImpl_97b3883c extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_campaniasBeanCacheEntry_97b3883c {
	static final long serialVersionUID = 61;
	/**
	 * getCod_camp
	 */
	public java.lang.Integer getCod_camp() {
		if(COD_CAMP_IsNull)
			return null;
		else
			return new Integer(COD_CAMP_Data);
	}
	/**
	 * setCod_camp
	 */
	public void setCod_camp(Integer data) {
		if (data == null)
			this.COD_CAMP_IsNull= true;
		else {
			this.COD_CAMP_IsNull= false;
			this.COD_CAMP_Data=data.intValue(); }
	}
	/**
	 * setDataForCOD_CAMP
	 */
	public void setDataForCOD_CAMP(int data, boolean isNull) {
		this.COD_CAMP_Data=data;
		this.COD_CAMP_IsNull=isNull;
	}
	private int COD_CAMP_Data;
	private boolean COD_CAMP_IsNull = true;
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
	 * getNom_camp
	 */
	public java.lang.String getNom_camp() {
		return NOM_CAMP_Data;
	}
	/**
	 * setNom_camp
	 */
	public void setNom_camp(String data) {
		this.NOM_CAMP_Data=data;
	}
	/**
	 * setDataForNOM_CAMP
	 */
	public void setDataForNOM_CAMP(String data) {
		this.NOM_CAMP_Data=data;
	}
	private String NOM_CAMP_Data;
	/**
	 * getCod_gest
	 */
	public java.lang.String getCod_gest() {
		return COD_GEST_Data;
	}
	/**
	 * setCod_gest
	 */
	public void setCod_gest(String data) {
		this.COD_GEST_Data=data;
	}
	/**
	 * setDataForCOD_GEST
	 */
	public void setDataForCOD_GEST(String data) {
		this.COD_GEST_Data=data;
	}
	private String COD_GEST_Data;
	/**
	 * getOrden
	 */
	public java.lang.String getOrden() {
		return ORDEN_Data;
	}
	/**
	 * setOrden
	 */
	public void setOrden(String data) {
		this.ORDEN_Data=data;
	}
	/**
	 * setDataForORDEN
	 */
	public void setDataForORDEN(String data) {
		this.ORDEN_Data=data;
	}
	private String ORDEN_Data;
	/**
	 * getGte
	 */
	public java.lang.String getGte() {
		return GTE_Data;
	}
	/**
	 * setGte
	 */
	public void setGte(String data) {
		this.GTE_Data=data;
	}
	/**
	 * setDataForGTE
	 */
	public void setDataForGTE(String data) {
		this.GTE_Data=data;
	}
	private String GTE_Data;
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
	 * getTiido_cam_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_cam_oficina_fk_cod_ofic() {
		return COD_OFIC_Data;
	}
	/**
	 * setTiido_cam_oficina_fk_cod_ofic
	 */
	public void setTiido_cam_oficina_fk_cod_ofic(String data) {
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
	 * getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr() {
		return COD_TERR_Data;
	}
	/**
	 * setTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(String data) {
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
	 * getTiido_cam_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_cam_oficina_fkKey() {
		if(COD_OFIC_Data==null||COD_TERR_Data==null)
			return null;
		entities.Tiido_oficinaKey key=new entities.Tiido_oficinaKey();
		key.cod_ofic=COD_OFIC_Data;
		key.tiido_territorio_fk_cod_terr=COD_TERR_Data;
		return key;
	}
	/**
	 * setTiido_cam_oficina_fkKey
	 */
	public void setTiido_cam_oficina_fkKey(entities.Tiido_oficinaKey data) {
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
		if(role.equals("tiido_cam_oficina_fk"))
			return getTiido_cam_oficina_fkKey();
		else
			return null;
	}
}
