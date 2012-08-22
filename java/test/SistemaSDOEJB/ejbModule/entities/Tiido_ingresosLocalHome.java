package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_ingresos
 */
public interface Tiido_ingresosLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_ingresos
	 */
	public entities.Tiido_ingresosLocal create(java.math.BigDecimal id_ingresos)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_ingresos
	 */
	public entities.Tiido_ingresosLocal findByPrimaryKey(
		entities.Tiido_ingresosKey primaryKey) throws javax.ejb.FinderException;
}
