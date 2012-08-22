package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_parametros
 */
public interface Tiido_parametrosLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_parametros
	 */
	public entities.Tiido_parametrosLocal create(java.lang.String cod_parametro)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_parametros
	 */
	public entities.Tiido_parametrosLocal findByPrimaryKey(
		entities.Tiido_parametrosKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllParametros() throws javax.ejb.FinderException;
	public entities.Tiido_parametrosLocal findParametroAll()
		throws javax.ejb.FinderException;
}
