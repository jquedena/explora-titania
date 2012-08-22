package entities.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: Tiido_epigrafe
 */
public interface Tiido_epigrafeBeanInternalLocalHome_b2c8f8ed {
	/**
	 * findTiido_acc_epigrafe_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_epigrafeLocal findTiido_acc_epigrafe_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_epigrafeLocal findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public entities.Tiido_epigrafeLocal findByPrimaryKeyForCMR(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException;
}
