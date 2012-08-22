package entities.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: Tiido_oficina
 */
public interface Tiido_oficinaBeanInternalLocalHome_30d934a8 {
	/**
	 * findTiido_oficinaByTiido_territorio_fkKey_Local
	 */
	public java.util.Collection findTiido_oficinaByTiido_territorio_fkKey_Local(entities.Tiido_territorioKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_acc_oficina_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_acc_oficina_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_cam_oficina_fkByTiido_campaniasKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_cam_oficina_fkByTiido_campaniasKey_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_fir_oficina_fkByTiido_firmasKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_fir_oficina_fkByTiido_firmasKey_Local(entities.Tiido_firmasKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(entities.Tiido_maestro_planesKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_pla_oficina_fkByTiido_planesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_pla_oficina_fkByTiido_planesKey_Local(entities.Tiido_planesKey key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public entities.Tiido_oficinaLocal findByPrimaryKeyForCMR(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException;
}
