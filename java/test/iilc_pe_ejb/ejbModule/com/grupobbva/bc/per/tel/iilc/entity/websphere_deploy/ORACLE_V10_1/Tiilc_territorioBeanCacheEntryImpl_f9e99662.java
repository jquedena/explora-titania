package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_territorioBeanCacheEntryImpl_f9e99662
 */
public class Tiilc_territorioBeanCacheEntryImpl_f9e99662 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanCacheEntry_f9e99662 {
	static final long serialVersionUID = 61;
	/**
	 * getCod_territorio
	 */
	public java.lang.String getCod_territorio() {
		return COD_TERRITORIO_Data;
	}
	/**
	 * setCod_territorio
	 */
	public void setCod_territorio(String data) {
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
	 * getDes_territorio
	 */
	public java.lang.String getDes_territorio() {
		return DES_TERRITORIO_Data;
	}
	/**
	 * setDes_territorio
	 */
	public void setDes_territorio(String data) {
		this.DES_TERRITORIO_Data=data;
	}
	/**
	 * setDataForDES_TERRITORIO
	 */
	public void setDataForDES_TERRITORIO(String data) {
		this.DES_TERRITORIO_Data=data;
	}
	private String DES_TERRITORIO_Data;
	/**
	 * getTiilc_area_fk_cod_area
	 */
	public java.lang.String getTiilc_area_fk_cod_area() {
		return COD_AREA_Data;
	}
	/**
	 * setTiilc_area_fk_cod_area
	 */
	public void setTiilc_area_fk_cod_area(String data) {
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
	 * getTiilc_area_fkKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey getTiilc_area_fkKey() {
		if(COD_AREA_Data==null)
			return null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key=new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey();
		key.cod_area=COD_AREA_Data;
		return key;
	}
	/**
	 * setTiilc_area_fkKey
	 */
	public void setTiilc_area_fkKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey data) {
		if(data==null)
		{
			this.COD_AREA_Data= null;
		}
		else {
		this.COD_AREA_Data=data.cod_area;
		}
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("tiilc_area_fk"))
			return getTiilc_area_fkKey();
		else
			return null;
	}
}
