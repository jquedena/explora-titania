package entities;

import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;

/**
 * Local Home interface for Enterprise Bean: Tiido_equivalencias
 */
public interface Tiido_equivalenciasLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_equivalencias
	 */
	public entities.Tiido_equivalenciasLocal create(java.lang.String cod_car)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_equivalencias
	 */
	public entities.Tiido_equivalenciasLocal findByPrimaryKey(
		entities.Tiido_equivalenciasKey primaryKey)
		throws javax.ejb.FinderException;
	public entities.Tiido_equivalenciasLocal findEquivalenciaByCodCargo(
		java.lang.String codCargo) throws javax.ejb.FinderException;
	public java.util.Collection findAllEquivalencias() throws javax.ejb.FinderException;
	public Tiido_equivalenciasLocal create(Equivalencia Equivalencia)
	throws javax.ejb.CreateException;
}
