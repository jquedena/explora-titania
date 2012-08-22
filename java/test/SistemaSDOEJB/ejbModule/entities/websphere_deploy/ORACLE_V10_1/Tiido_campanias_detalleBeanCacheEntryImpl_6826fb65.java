package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_campanias_detalleBeanCacheEntryImpl_6826fb65
 */
public class Tiido_campanias_detalleBeanCacheEntryImpl_6826fb65 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements entities.websphere_deploy.Tiido_campanias_detalleBeanCacheEntry_6826fb65 {
	static final long serialVersionUID = 61;
	/**
	 * getCod_camp_deta
	 */
	public java.lang.Integer getCod_camp_deta() {
		if(COD_CAMP_DETA_IsNull)
			return null;
		else
			return new Integer(COD_CAMP_DETA_Data);
	}
	/**
	 * setCod_camp_deta
	 */
	public void setCod_camp_deta(Integer data) {
		if (data == null)
			this.COD_CAMP_DETA_IsNull= true;
		else {
			this.COD_CAMP_DETA_IsNull= false;
			this.COD_CAMP_DETA_Data=data.intValue(); }
	}
	/**
	 * setDataForCOD_CAMP_DETA
	 */
	public void setDataForCOD_CAMP_DETA(int data, boolean isNull) {
		this.COD_CAMP_DETA_Data=data;
		this.COD_CAMP_DETA_IsNull=isNull;
	}
	private int COD_CAMP_DETA_Data;
	private boolean COD_CAMP_DETA_IsNull = true;
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
	 * getMont_segu_1
	 */
	public java.math.BigDecimal getMont_segu_1() {
		return MONT_SEGU_1_Data;
	}
	/**
	 * setMont_segu_1
	 */
	public void setMont_segu_1(java.math.BigDecimal data) {
		if (data == null)
			this.MONT_SEGU_1_Data= null;
		else {
			this.MONT_SEGU_1_Data=data; }
	}
	/**
	 * setDataForMONT_SEGU_1
	 */
	public void setDataForMONT_SEGU_1(java.math.BigDecimal data) {
		this.MONT_SEGU_1_Data=data;
	}
	private java.math.BigDecimal MONT_SEGU_1_Data;
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
	 * getMont_segu_2
	 */
	public java.math.BigDecimal getMont_segu_2() {
		return MONT_SEGU_2_Data;
	}
	/**
	 * setMont_segu_2
	 */
	public void setMont_segu_2(java.math.BigDecimal data) {
		if (data == null)
			this.MONT_SEGU_2_Data= null;
		else {
			this.MONT_SEGU_2_Data=data; }
	}
	/**
	 * setDataForMONT_SEGU_2
	 */
	public void setDataForMONT_SEGU_2(java.math.BigDecimal data) {
		this.MONT_SEGU_2_Data=data;
	}
	private java.math.BigDecimal MONT_SEGU_2_Data;
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
	 * getTiido_camdet_campanias_fk_cod_camp
	 */
	public java.lang.Integer getTiido_camdet_campanias_fk_cod_camp() {
		if(COD_CAMP_IsNull)
			return null;
		else
			return new Integer(COD_CAMP_Data);
	}
	/**
	 * setTiido_camdet_campanias_fk_cod_camp
	 */
	public void setTiido_camdet_campanias_fk_cod_camp(Integer data) {
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
	 * getTiido_camdet_campanias_fk_anho
	 */
	public java.lang.String getTiido_camdet_campanias_fk_anho() {
		return ANHO_Data;
	}
	/**
	 * setTiido_camdet_campanias_fk_anho
	 */
	public void setTiido_camdet_campanias_fk_anho(String data) {
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
	 * getTiido_camdet_campanias_fk_mes
	 */
	public java.lang.String getTiido_camdet_campanias_fk_mes() {
		return MES_Data;
	}
	/**
	 * setTiido_camdet_campanias_fk_mes
	 */
	public void setTiido_camdet_campanias_fk_mes(String data) {
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
	 * getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic() {
		return COD_OFIC_Data;
	}
	/**
	 * setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
	 */
	public void setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic(String data) {
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
	 * getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr() {
		return COD_TERR_Data;
	}
	/**
	 * setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(String data) {
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
	 * getTiido_camdet_campanias_fkKey
	 */
	public entities.Tiido_campaniasKey getTiido_camdet_campanias_fkKey() {
		if(COD_CAMP_IsNull||ANHO_Data==null||MES_Data==null||COD_OFIC_Data==null||COD_TERR_Data==null)
			return null;
		entities.Tiido_campaniasKey key=new entities.Tiido_campaniasKey();
		if(COD_CAMP_IsNull)
			key.cod_camp=null;
		else
			key.cod_camp=new Integer(COD_CAMP_Data);
		key.anho=ANHO_Data;
		key.mes=MES_Data;
		key.tiido_cam_oficina_fk_cod_ofic=COD_OFIC_Data;
		key.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr=COD_TERR_Data;
		return key;
	}
	/**
	 * setTiido_camdet_campanias_fkKey
	 */
	public void setTiido_camdet_campanias_fkKey(entities.Tiido_campaniasKey data) {
		if(data==null)
		{
			COD_CAMP_IsNull= true;
			this.ANHO_Data= null;
			this.MES_Data= null;
			this.COD_OFIC_Data= null;
			this.COD_TERR_Data= null;
		}
		else {
		if (data.cod_camp == null)
			COD_CAMP_IsNull= true;
		else {
			COD_CAMP_IsNull= false;
			this.COD_CAMP_Data=data.cod_camp.intValue(); }
		this.ANHO_Data=data.anho;
		this.MES_Data=data.mes;
		this.COD_OFIC_Data=data.tiido_cam_oficina_fk_cod_ofic;
		this.COD_TERR_Data=data.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr;
		}
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("tiido_camdet_campanias_fk"))
			return getTiido_camdet_campanias_fkKey();
		else
			return null;
	}
}
