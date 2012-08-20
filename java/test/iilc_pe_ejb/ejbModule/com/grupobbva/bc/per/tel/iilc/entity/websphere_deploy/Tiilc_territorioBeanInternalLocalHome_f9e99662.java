package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: Tiilc_territorio
 */
public interface Tiilc_territorioBeanInternalLocalHome_f9e99662 {
	/**
	 * findTiilc_territorioByTiilc_area_fkKey_Local
	 */
	public java.util.Collection findTiilc_territorioByTiilc_area_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key) throws javax.ejb.FinderException;
	/**
	 * findTiilc_territorio_fkByTiilc_oficinaKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findTiilc_territorio_fkByTiilc_oficinaKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findByPrimaryKeyForCMR(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException;
}
