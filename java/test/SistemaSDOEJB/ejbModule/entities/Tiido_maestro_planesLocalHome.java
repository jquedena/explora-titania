package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_maestro_planes
 */
public interface Tiido_maestro_planesLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_maestro_planes
	 */
	public entities.Tiido_maestro_planesLocal create(
		java.lang.String mes,
		java.lang.String anho,
		entities.Tiido_oficinaLocal argTiido_maepla_oficina_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_maestro_planes
	 */
	public entities.Tiido_maestro_planesLocal create(
		java.lang.String mes,
		java.lang.String anho,
		java.lang.String tiido_maepla_oficina_fk_cod_ofic,
		java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_maestro_planes
	 */
	public entities.Tiido_maestro_planesLocal findByPrimaryKey(
		entities.Tiido_maestro_planesKey primaryKey)
		throws javax.ejb.FinderException;
	public entities.Tiido_maestro_planesLocal findUbicar(
		java.lang.String mes,
		java.lang.String anho,
		java.lang.String codOficina) throws javax.ejb.FinderException;
}
