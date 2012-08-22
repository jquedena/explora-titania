package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_territorio
 */
public interface Tiido_territorioLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_territorio
	 */
	public entities.Tiido_territorioLocal create(java.lang.String cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_territorio
	 */
	public entities.Tiido_territorioLocal findByPrimaryKey(
		entities.Tiido_territorioKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllTerritorio() throws javax.ejb.FinderException;
	public entities.Tiido_territorioLocal findByCodTerritorio(java.lang.String codTerritorio) throws javax.ejb.FinderException;
}
