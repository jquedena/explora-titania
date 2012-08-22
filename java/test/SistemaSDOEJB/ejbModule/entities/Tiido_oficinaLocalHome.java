package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_oficina
 */
public interface Tiido_oficinaLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_oficina
	 */
	public entities.Tiido_oficinaLocal create(
		java.lang.String cod_ofic,
		entities.Tiido_territorioLocal argTiido_territorio_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_oficina
	 */
	public entities.Tiido_oficinaLocal create(
		java.lang.String cod_ofic,
		java.lang.String tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_oficina
	 */
	public entities.Tiido_oficinaLocal findByPrimaryKey(
		entities.Tiido_oficinaKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findAllOficinaByCodTerri(
		java.lang.String codTerritorio) throws javax.ejb.FinderException;
	public entities.Tiido_oficinaLocal findByCodOficina(
		java.lang.String codOficina) throws javax.ejb.FinderException;
	public java.util.Collection findListaByCodOficina(
		java.lang.String codOficina) throws javax.ejb.FinderException;
	/**
	 * ejbCreate
	 */
	public entities.Tiido_oficinaLocal create(
		java.lang.String cod_ofic,
		java.lang.String nom_ofic,
		java.lang.String tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
}
