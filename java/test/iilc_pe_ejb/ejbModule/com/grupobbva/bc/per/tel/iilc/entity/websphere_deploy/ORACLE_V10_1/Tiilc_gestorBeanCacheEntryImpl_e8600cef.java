package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_gestorBeanCacheEntryImpl_e8600cef
 */
public class Tiilc_gestorBeanCacheEntryImpl_e8600cef extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanCacheEntry_e8600cef {
	static final long serialVersionUID = 61;
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
	 * getReg_gestor
	 */
	public java.lang.String getReg_gestor() {
		return REG_GESTOR_Data;
	}
	/**
	 * setReg_gestor
	 */
	public void setReg_gestor(String data) {
		this.REG_GESTOR_Data=data;
	}
	/**
	 * setDataForREG_GESTOR
	 */
	public void setDataForREG_GESTOR(String data) {
		this.REG_GESTOR_Data=data;
	}
	private String REG_GESTOR_Data;
	/**
	 * getPerfil_gestor
	 */
	public java.lang.String getPerfil_gestor() {
		return PERFIL_GESTOR_Data;
	}
	/**
	 * setPerfil_gestor
	 */
	public void setPerfil_gestor(String data) {
		this.PERFIL_GESTOR_Data=data;
	}
	/**
	 * setDataForPERFIL_GESTOR
	 */
	public void setDataForPERFIL_GESTOR(String data) {
		this.PERFIL_GESTOR_Data=data;
	}
	private String PERFIL_GESTOR_Data;
	/**
	 * getTiilc_oficina_fk_cod_oficina
	 */
	public java.lang.String getTiilc_oficina_fk_cod_oficina() {
		return COD_OFICINA_Data;
	}
	/**
	 * setTiilc_oficina_fk_cod_oficina
	 */
	public void setTiilc_oficina_fk_cod_oficina(String data) {
		this.COD_OFICINA_Data=data;
	}
	/**
	 * setDataForCOD_OFICINA
	 */
	public void setDataForCOD_OFICINA(String data) {
		this.COD_OFICINA_Data=data;
	}
	private String COD_OFICINA_Data;
	/**
	 * getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
	 */
	public java.lang.String getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio() {
		return COD_TERRITORIO_Data;
	}
	/**
	 * setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
	 */
	public void setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(String data) {
		this.COD_TERRITORIO_Data=data;
	}
	/**
	 * setDataForCOD_TERRITORIO
	 */
	public void setDataForCOD_TERRITORIO(String data) {
		this.COD_TERRITORIO_Data=data;
	}
	private String COD_TERRITORIO_Data;
	/**
	 * getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public java.lang.String getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area() {
		return COD_AREA_Data;
	}
	/**
	 * setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public void setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(String data) {
		this.COD_AREA_Data=data;
	}
	/**
	 * setDataForCOD_AREA
	 */
	public void setDataForCOD_AREA(String data) {
		this.COD_AREA_Data=data;
	}
	private String COD_AREA_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
	/**
	 * getTiilc_oficina_fkKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey getTiilc_oficina_fkKey() {
		if(COD_OFICINA_Data==null||COD_TERRITORIO_Data==null||COD_AREA_Data==null)
			return null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key=new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey();
		key.cod_oficina=COD_OFICINA_Data;
		key.tiilc_territorio_fk_cod_territorio=COD_TERRITORIO_Data;
		key.tiilc_territorio_fk_tiilc_area_fk_cod_area=COD_AREA_Data;
		return key;
	}
	/**
	 * setTiilc_oficina_fkKey
	 */
	public void setTiilc_oficina_fkKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey data) {
		if(data==null)
		{
			this.COD_OFICINA_Data= null;
			this.COD_TERRITORIO_Data= null;
			this.COD_AREA_Data= null;
		}
		else {
		this.COD_OFICINA_Data=data.cod_oficina;
		this.COD_TERRITORIO_Data=data.tiilc_territorio_fk_cod_territorio;
		this.COD_AREA_Data=data.tiilc_territorio_fk_tiilc_area_fk_cod_area;
		}
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("tiilc_oficina_fk"))
			return getTiilc_oficina_fkKey();
		else
			return null;
	}
}
