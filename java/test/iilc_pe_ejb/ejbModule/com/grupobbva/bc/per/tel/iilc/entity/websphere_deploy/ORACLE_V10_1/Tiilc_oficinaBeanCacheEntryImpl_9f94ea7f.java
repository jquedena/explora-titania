package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_oficinaBeanCacheEntryImpl_9f94ea7f
 */
public class Tiilc_oficinaBeanCacheEntryImpl_9f94ea7f extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanCacheEntry_9f94ea7f {
	static final long serialVersionUID = 61;
	/**
	 * getCod_oficina
	 */
	public java.lang.String getCod_oficina() {
		return COD_OFICINA_Data;
	}
	/**
	 * setCod_oficina
	 */
	public void setCod_oficina(String data) {
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
	 * getDes_oficina
	 */
	public java.lang.String getDes_oficina() {
		return DES_OFICINA_Data;
	}
	/**
	 * setDes_oficina
	 */
	public void setDes_oficina(String data) {
		this.DES_OFICINA_Data=data;
	}
	/**
	 * setDataForDES_OFICINA
	 */
	public void setDataForDES_OFICINA(String data) {
		this.DES_OFICINA_Data=data;
	}
	private String DES_OFICINA_Data;
	/**
	 * getTiilc_territorio_fk_cod_territorio
	 */
	public java.lang.String getTiilc_territorio_fk_cod_territorio() {
		return COD_TERRITORIO_Data;
	}
	/**
	 * setTiilc_territorio_fk_cod_territorio
	 */
	public void setTiilc_territorio_fk_cod_territorio(String data) {
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
	 * getTiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public java.lang.String getTiilc_territorio_fk_tiilc_area_fk_cod_area() {
		return COD_AREA_Data;
	}
	/**
	 * setTiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public void setTiilc_territorio_fk_tiilc_area_fk_cod_area(String data) {
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
	 * getTiilc_territorio_fkKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey getTiilc_territorio_fkKey() {
		if(COD_TERRITORIO_Data==null||COD_AREA_Data==null)
			return null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key=new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey();
		key.cod_territorio=COD_TERRITORIO_Data;
		key.tiilc_area_fk_cod_area=COD_AREA_Data;
		return key;
	}
	/**
	 * setTiilc_territorio_fkKey
	 */
	public void setTiilc_territorio_fkKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey data) {
		if(data==null)
		{
			this.COD_TERRITORIO_Data= null;
			this.COD_AREA_Data= null;
		}
		else {
		this.COD_TERRITORIO_Data=data.cod_territorio;
		this.COD_AREA_Data=data.tiilc_area_fk_cod_area;
		}
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("tiilc_territorio_fk"))
			return getTiilc_territorio_fkKey();
		else
			return null;
	}
}
