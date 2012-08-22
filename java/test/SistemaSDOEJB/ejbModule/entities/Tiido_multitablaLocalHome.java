package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_multitabla
 */
public interface Tiido_multitablaLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_multitabla
	 */
	public entities.Tiido_multitablaLocal create(
		java.lang.String cod_mult,
		java.lang.String cod_elem) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_multitabla
	 */
	public entities.Tiido_multitablaLocal findByPrimaryKey(
		entities.Tiido_multitablaKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByCodMulti(java.lang.String codMulti) throws javax.ejb.FinderException;
	public entities.Tiido_multitablaLocal findByID(java.lang.String id)
		throws javax.ejb.FinderException;
	public entities.Tiido_multitablaLocal findMultiByPrimaryKey(
		java.lang.String codMulti,
		java.lang.String codElem) throws javax.ejb.FinderException;
	public java.util.Collection findByMultiForPresup(java.lang.String codMulti, java.lang.String Valor2) throws javax.ejb.FinderException;
}
