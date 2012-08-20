package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: Tiilc_oficina
 */
public interface Tiilc_oficinaBeanInternalLocalHome_9f94ea7f {
	/**
	 * findTiilc_oficinaByTiilc_territorio_fkKey_Local
	 */
	public java.util.Collection findTiilc_oficinaByTiilc_territorio_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException;
	/**
	 * findTiilc_oficina_fkByTiilc_gestorKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findTiilc_oficina_fkByTiilc_gestorKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findByPrimaryKeyForCMR(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException;
}
