package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_metas_gestorBeanCacheEntryImpl_238e66e0
 */
public class Tiido_metas_gestorBeanCacheEntryImpl_238e66e0 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_metas_gestorBeanCacheEntry_238e66e0 {
	static final long serialVersionUID = 61;
	/**
	 * getCod_meta_gestor
	 */
	public java.lang.String getCod_meta_gestor() {
		return COD_META_GESTOR_Data;
	}
	/**
	 * setCod_meta_gestor
	 */
	public void setCod_meta_gestor(String data) {
		this.COD_META_GESTOR_Data=data;
	}
	/**
	 * setDataForCOD_META_GESTOR
	 */
	public void setDataForCOD_META_GESTOR(String data) {
		this.COD_META_GESTOR_Data=data;
	}
	private String COD_META_GESTOR_Data;
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
	 * getPorc_asig
	 */
	public java.math.BigDecimal getPorc_asig() {
		return PORC_ASIG_Data;
	}
	/**
	 * setPorc_asig
	 */
	public void setPorc_asig(java.math.BigDecimal data) {
		if (data == null)
			this.PORC_ASIG_Data= null;
		else {
			this.PORC_ASIG_Data=data; }
	}
	/**
	 * setDataForPORC_ASIG
	 */
	public void setDataForPORC_ASIG(java.math.BigDecimal data) {
		this.PORC_ASIG_Data=data;
	}
	private java.math.BigDecimal PORC_ASIG_Data;
	/**
	 * getNom_epigrafe
	 */
	public java.lang.String getNom_epigrafe() {
		return NOM_EPIGRAFE_Data;
	}
	/**
	 * setNom_epigrafe
	 */
	public void setNom_epigrafe(String data) {
		this.NOM_EPIGRAFE_Data=data;
	}
	/**
	 * setDataForNOM_EPIGRAFE
	 */
	public void setDataForNOM_EPIGRAFE(String data) {
		this.NOM_EPIGRAFE_Data=data;
	}
	private String NOM_EPIGRAFE_Data;
	/**
	 * getNom_gestor
	 */
	public java.lang.String getNom_gestor() {
		return NOM_GESTOR_Data;
	}
	/**
	 * setNom_gestor
	 */
	public void setNom_gestor(String data) {
		this.NOM_GESTOR_Data=data;
	}
	/**
	 * setDataForNOM_GESTOR
	 */
	public void setDataForNOM_GESTOR(String data) {
		this.NOM_GESTOR_Data=data;
	}
	private String NOM_GESTOR_Data;
	/**
	 * getCod_perfil_gestor
	 */
	public java.lang.String getCod_perfil_gestor() {
		return COD_PERFIL_Data;
	}
	/**
	 * setCod_perfil_gestor
	 */
	public void setCod_perfil_gestor(String data) {
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
	 * getFec_actu
	 */
	public java.util.Date getFec_actu() {
		java.sql.Timestamp tempData_fec_actu;
		tempData_fec_actu =FEC_ACTU_Data;
		Object tempConvertedObject_fec_actu = com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().objectFrom(tempData_fec_actu);
		return (tempConvertedObject_fec_actu == null) ? null : (java.util.Date) tempConvertedObject_fec_actu;
	}
	/**
	 * setFec_actu
	 */
	public void setFec_actu(java.util.Date data) {
		this.FEC_ACTU_Data=(java.sql.Timestamp) com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(data);
	}
	/**
	 * setDataForFEC_ACTU
	 */
	public void setDataForFEC_ACTU(java.sql.Timestamp data) {
		this.FEC_ACTU_Data=data;
	}
	private java.sql.Timestamp FEC_ACTU_Data;
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
	 * getTiido_metges_epigrafe_fk_cod_epigrafe
	 */
	public java.lang.String getTiido_metges_epigrafe_fk_cod_epigrafe() {
		return COD_EPIGRAFE_Data;
	}
	/**
	 * setTiido_metges_epigrafe_fk_cod_epigrafe
	 */
	public void setTiido_metges_epigrafe_fk_cod_epigrafe(String data) {
		this.COD_EPIGRAFE_Data=data;
	}
	/**
	 * setDataForCOD_EPIGRAFE
	 */
	public void setDataForCOD_EPIGRAFE(String data) {
		this.COD_EPIGRAFE_Data=data;
	}
	private String COD_EPIGRAFE_Data;
	/**
	 * getTiido_metges_epigrafe_fk_anho
	 */
	public java.lang.String getTiido_metges_epigrafe_fk_anho() {
		return ANHO_Data;
	}
	/**
	 * setTiido_metges_epigrafe_fk_anho
	 */
	public void setTiido_metges_epigrafe_fk_anho(String data) {
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
	 * getTiido_metges_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_metges_oficina_fk_cod_ofic() {
		return COD_OFIC_Data;
	}
	/**
	 * setTiido_metges_oficina_fk_cod_ofic
	 */
	public void setTiido_metges_oficina_fk_cod_ofic(String data) {
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
	 * getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr() {
		return COD_TERR_Data;
	}
	/**
	 * setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(String data) {
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
	 * getTiido_metges_epigrafe_fkKey
	 */
	public entities.Tiido_epigrafeKey getTiido_metges_epigrafe_fkKey() {
		if(COD_EPIGRAFE_Data==null||ANHO_Data==null)
			return null;
		entities.Tiido_epigrafeKey key=new entities.Tiido_epigrafeKey();
		key.cod_epigrafe=COD_EPIGRAFE_Data;
		key.anho=ANHO_Data;
		return key;
	}
	/**
	 * setTiido_metges_epigrafe_fkKey
	 */
	public void setTiido_metges_epigrafe_fkKey(entities.Tiido_epigrafeKey data) {
		if(data==null)
		{
			this.COD_EPIGRAFE_Data= null;
			this.ANHO_Data= null;
		}
		else {
		this.COD_EPIGRAFE_Data=data.cod_epigrafe;
		this.ANHO_Data=data.anho;
		}
	}
	/**
	 * getTiido_metges_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_metges_oficina_fkKey() {
		if(COD_OFIC_Data==null||COD_TERR_Data==null)
			return null;
		entities.Tiido_oficinaKey key=new entities.Tiido_oficinaKey();
		key.cod_ofic=COD_OFIC_Data;
		key.tiido_territorio_fk_cod_terr=COD_TERR_Data;
		return key;
	}
	/**
	 * setTiido_metges_oficina_fkKey
	 */
	public void setTiido_metges_oficina_fkKey(entities.Tiido_oficinaKey data) {
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
		if(role.equals("tiido_metges_epigrafe_fk"))
			return getTiido_metges_epigrafe_fkKey();
		if(role.equals("tiido_metges_oficina_fk"))
			return getTiido_metges_oficina_fkKey();
		else
			return null;
	}
}
