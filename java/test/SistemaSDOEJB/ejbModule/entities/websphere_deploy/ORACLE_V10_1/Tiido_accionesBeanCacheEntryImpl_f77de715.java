package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_accionesBeanCacheEntryImpl_f77de715
 */
public class Tiido_accionesBeanCacheEntryImpl_f77de715 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_accionesBeanCacheEntry_f77de715 {
	static final long serialVersionUID = 61;
	/**
	 * getCod_acci
	 */
	public java.lang.Integer getCod_acci() {
		if(COD_ACCI_IsNull)
			return null;
		else
			return new Integer(COD_ACCI_Data);
	}
	/**
	 * setCod_acci
	 */
	public void setCod_acci(Integer data) {
		if (data == null)
			this.COD_ACCI_IsNull= true;
		else {
			this.COD_ACCI_IsNull= false;
			this.COD_ACCI_Data=data.intValue(); }
	}
	/**
	 * setDataForCOD_ACCI
	 */
	public void setDataForCOD_ACCI(int data, boolean isNull) {
		this.COD_ACCI_Data=data;
		this.COD_ACCI_IsNull=isNull;
	}
	private int COD_ACCI_Data;
	private boolean COD_ACCI_IsNull = true;
	/**
	 * getNom_acci
	 */
	public java.lang.String getNom_acci() {
		return NOM_ACCI_Data;
	}
	/**
	 * setNom_acci
	 */
	public void setNom_acci(String data) {
		this.NOM_ACCI_Data=data;
	}
	/**
	 * setDataForNOM_ACCI
	 */
	public void setDataForNOM_ACCI(String data) {
		this.NOM_ACCI_Data=data;
	}
	private String NOM_ACCI_Data;
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
	 * getMes_acci
	 */
	public java.lang.String getMes_acci() {
		return MES_ACCI_Data;
	}
	/**
	 * setMes_acci
	 */
	public void setMes_acci(String data) {
		this.MES_ACCI_Data=data;
	}
	/**
	 * setDataForMES_ACCI
	 */
	public void setDataForMES_ACCI(String data) {
		this.MES_ACCI_Data=data;
	}
	private String MES_ACCI_Data;
	/**
	 * getNro_clie
	 */
	public java.math.BigDecimal getNro_clie() {
		return NRO_CLIE_Data;
	}
	/**
	 * setNro_clie
	 */
	public void setNro_clie(java.math.BigDecimal data) {
		if (data == null)
			this.NRO_CLIE_Data= null;
		else {
			this.NRO_CLIE_Data=data; }
	}
	/**
	 * setDataForNRO_CLIE
	 */
	public void setDataForNRO_CLIE(java.math.BigDecimal data) {
		this.NRO_CLIE_Data=data;
	}
	private java.math.BigDecimal NRO_CLIE_Data;
	/**
	 * getComp_gest
	 */
	public java.math.BigDecimal getComp_gest() {
		return COMP_GEST_Data;
	}
	/**
	 * setComp_gest
	 */
	public void setComp_gest(java.math.BigDecimal data) {
		if (data == null)
			this.COMP_GEST_Data= null;
		else {
			this.COMP_GEST_Data=data; }
	}
	/**
	 * setDataForCOMP_GEST
	 */
	public void setDataForCOMP_GEST(java.math.BigDecimal data) {
		this.COMP_GEST_Data=data;
	}
	private java.math.BigDecimal COMP_GEST_Data;
	/**
	 * getNro_gest_segu_1
	 */
	public java.math.BigDecimal getNro_gest_segu_1() {
		return NRO_GEST_SEGU_1_Data;
	}
	/**
	 * setNro_gest_segu_1
	 */
	public void setNro_gest_segu_1(java.math.BigDecimal data) {
		if (data == null)
			this.NRO_GEST_SEGU_1_Data= null;
		else {
			this.NRO_GEST_SEGU_1_Data=data; }
	}
	/**
	 * setDataForNRO_GEST_SEGU_1
	 */
	public void setDataForNRO_GEST_SEGU_1(java.math.BigDecimal data) {
		this.NRO_GEST_SEGU_1_Data=data;
	}
	private java.math.BigDecimal NRO_GEST_SEGU_1_Data;
	/**
	 * getNro_conc_segu_1
	 */
	public java.math.BigDecimal getNro_conc_segu_1() {
		return NRO_CONC_SEGU_1_Data;
	}
	/**
	 * setNro_conc_segu_1
	 */
	public void setNro_conc_segu_1(java.math.BigDecimal data) {
		if (data == null)
			this.NRO_CONC_SEGU_1_Data= null;
		else {
			this.NRO_CONC_SEGU_1_Data=data; }
	}
	/**
	 * setDataForNRO_CONC_SEGU_1
	 */
	public void setDataForNRO_CONC_SEGU_1(java.math.BigDecimal data) {
		this.NRO_CONC_SEGU_1_Data=data;
	}
	private java.math.BigDecimal NRO_CONC_SEGU_1_Data;
	/**
	 * getMon_segu_1
	 */
	public java.math.BigDecimal getMon_segu_1() {
		return MON_SEGU_1_Data;
	}
	/**
	 * setMon_segu_1
	 */
	public void setMon_segu_1(java.math.BigDecimal data) {
		if (data == null)
			this.MON_SEGU_1_Data= null;
		else {
			this.MON_SEGU_1_Data=data; }
	}
	/**
	 * setDataForMON_SEGU_1
	 */
	public void setDataForMON_SEGU_1(java.math.BigDecimal data) {
		this.MON_SEGU_1_Data=data;
	}
	private java.math.BigDecimal MON_SEGU_1_Data;
	/**
	 * getNro_gest_segu_2
	 */
	public java.math.BigDecimal getNro_gest_segu_2() {
		return NRO_GEST_SEGU_2_Data;
	}
	/**
	 * setNro_gest_segu_2
	 */
	public void setNro_gest_segu_2(java.math.BigDecimal data) {
		if (data == null)
			this.NRO_GEST_SEGU_2_Data= null;
		else {
			this.NRO_GEST_SEGU_2_Data=data; }
	}
	/**
	 * setDataForNRO_GEST_SEGU_2
	 */
	public void setDataForNRO_GEST_SEGU_2(java.math.BigDecimal data) {
		this.NRO_GEST_SEGU_2_Data=data;
	}
	private java.math.BigDecimal NRO_GEST_SEGU_2_Data;
	/**
	 * getNro_conc_segu_2
	 */
	public java.math.BigDecimal getNro_conc_segu_2() {
		return NRO_CONC_SEGU_2_Data;
	}
	/**
	 * setNro_conc_segu_2
	 */
	public void setNro_conc_segu_2(java.math.BigDecimal data) {
		if (data == null)
			this.NRO_CONC_SEGU_2_Data= null;
		else {
			this.NRO_CONC_SEGU_2_Data=data; }
	}
	/**
	 * setDataForNRO_CONC_SEGU_2
	 */
	public void setDataForNRO_CONC_SEGU_2(java.math.BigDecimal data) {
		this.NRO_CONC_SEGU_2_Data=data;
	}
	private java.math.BigDecimal NRO_CONC_SEGU_2_Data;
	/**
	 * getMon_segu_2
	 */
	public java.math.BigDecimal getMon_segu_2() {
		return MON_SEGU_2_Data;
	}
	/**
	 * setMon_segu_2
	 */
	public void setMon_segu_2(java.math.BigDecimal data) {
		if (data == null)
			this.MON_SEGU_2_Data= null;
		else {
			this.MON_SEGU_2_Data=data; }
	}
	/**
	 * setDataForMON_SEGU_2
	 */
	public void setDataForMON_SEGU_2(java.math.BigDecimal data) {
		this.MON_SEGU_2_Data=data;
	}
	private java.math.BigDecimal MON_SEGU_2_Data;
	/**
	 * getFec_segu_1
	 */
	public java.sql.Date getFec_segu_1() {
		return FEC_SEGU_1_Data;
	}
	/**
	 * setFec_segu_1
	 */
	public void setFec_segu_1(java.sql.Date data) {
		if (data == null)
			this.FEC_SEGU_1_Data= null;
		else {
			this.FEC_SEGU_1_Data=data; }
	}
	/**
	 * setDataForFEC_SEGU_1
	 */
	public void setDataForFEC_SEGU_1(java.sql.Date data) {
		this.FEC_SEGU_1_Data=data;
	}
	private java.sql.Date FEC_SEGU_1_Data;
	/**
	 * getFec_segu_2
	 */
	public java.sql.Date getFec_segu_2() {
		return FEC_SEGU_2_Data;
	}
	/**
	 * setFec_segu_2
	 */
	public void setFec_segu_2(java.sql.Date data) {
		if (data == null)
			this.FEC_SEGU_2_Data= null;
		else {
			this.FEC_SEGU_2_Data=data; }
	}
	/**
	 * setDataForFEC_SEGU_2
	 */
	public void setDataForFEC_SEGU_2(java.sql.Date data) {
		this.FEC_SEGU_2_Data=data;
	}
	private java.sql.Date FEC_SEGU_2_Data;
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
	 * getTiido_acc_epigrafe_fk_cod_epigrafe
	 */
	public java.lang.String getTiido_acc_epigrafe_fk_cod_epigrafe() {
		return COD_EPIGRAFE_Data;
	}
	/**
	 * setTiido_acc_epigrafe_fk_cod_epigrafe
	 */
	public void setTiido_acc_epigrafe_fk_cod_epigrafe(String data) {
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
	 * getTiido_acc_epigrafe_fk_anho
	 */
	public java.lang.String getTiido_acc_epigrafe_fk_anho() {
		return ANHO_Data;
	}
	/**
	 * setTiido_acc_epigrafe_fk_anho
	 */
	public void setTiido_acc_epigrafe_fk_anho(String data) {
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
	 * getTiido_acc_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_acc_oficina_fk_cod_ofic() {
		return COD_OFIC_Data;
	}
	/**
	 * setTiido_acc_oficina_fk_cod_ofic
	 */
	public void setTiido_acc_oficina_fk_cod_ofic(String data) {
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
	 * getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr() {
		return COD_TERR_Data;
	}
	/**
	 * setTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr(String data) {
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
	 * getTiido_acc_epigrafe_fkKey
	 */
	public entities.Tiido_epigrafeKey getTiido_acc_epigrafe_fkKey() {
		if(COD_EPIGRAFE_Data==null||ANHO_Data==null)
			return null;
		entities.Tiido_epigrafeKey key=new entities.Tiido_epigrafeKey();
		key.cod_epigrafe=COD_EPIGRAFE_Data;
		key.anho=ANHO_Data;
		return key;
	}
	/**
	 * setTiido_acc_epigrafe_fkKey
	 */
	public void setTiido_acc_epigrafe_fkKey(entities.Tiido_epigrafeKey data) {
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
	 * getTiido_acc_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_acc_oficina_fkKey() {
		if(COD_OFIC_Data==null||COD_TERR_Data==null)
			return null;
		entities.Tiido_oficinaKey key=new entities.Tiido_oficinaKey();
		key.cod_ofic=COD_OFIC_Data;
		key.tiido_territorio_fk_cod_terr=COD_TERR_Data;
		return key;
	}
	/**
	 * setTiido_acc_oficina_fkKey
	 */
	public void setTiido_acc_oficina_fkKey(entities.Tiido_oficinaKey data) {
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
		if(role.equals("tiido_acc_epigrafe_fk"))
			return getTiido_acc_epigrafe_fkKey();
		if(role.equals("tiido_acc_oficina_fk"))
			return getTiido_acc_oficina_fkKey();
		else
			return null;
	}
}
