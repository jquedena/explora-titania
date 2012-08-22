package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_campanias
 */
public interface Tiido_campaniasLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_campanias
	 */
	public entities.Tiido_campaniasLocal create(
		java.lang.Integer cod_camp,
		java.lang.String anho,
		java.lang.String mes,
		entities.Tiido_oficinaLocal argTiido_cam_oficina_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_campanias
	 */
	public entities.Tiido_campaniasLocal create(
		java.lang.Integer cod_camp,
		java.lang.String anho,
		java.lang.String mes,
		java.lang.String tiido_cam_oficina_fk_cod_ofic,
		java.lang.String tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_campanias
	 */
	public entities.Tiido_campaniasLocal findByPrimaryKey(
		entities.Tiido_campaniasKey primaryKey)
		throws javax.ejb.FinderException;
}
