package entities.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: Tiido_campanias
 */
public interface Tiido_campaniasBeanInternalLocalHome_97b3883c {
	/**
	 * findTiido_campaniasByTiido_cam_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_campaniasByTiido_cam_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException;
	/**
	 * findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local
	 */
	public entities.Tiido_campaniasLocal findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local(entities.Tiido_campanias_detalleKey key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public entities.Tiido_campaniasLocal findByPrimaryKeyForCMR(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException;
}
