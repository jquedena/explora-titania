package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_campanias_detalle
 */
public interface Tiido_campanias_detalleLocalHome
	extends
		javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_campanias_detalle
	 */
	public entities.Tiido_campanias_detalleLocal create(
		java.lang.Integer cod_camp_deta,
		entities.Tiido_campaniasLocal argTiido_camdet_campanias_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_campanias_detalle
	 */
	public entities.Tiido_campanias_detalleLocal create(
		java.lang.Integer cod_camp_deta,
		java.lang.Integer tiido_camdet_campanias_fk_cod_camp,
		java.lang.String tiido_camdet_campanias_fk_anho,
		java.lang.String tiido_camdet_campanias_fk_mes,
		java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic,
		java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_campanias_detalle
	 */
	public entities.Tiido_campanias_detalleLocal findByPrimaryKey(
		entities.Tiido_campanias_detalleKey primaryKey)
		throws javax.ejb.FinderException;
}
