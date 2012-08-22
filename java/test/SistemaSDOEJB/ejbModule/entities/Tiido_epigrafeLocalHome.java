package entities;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
/**
 * Local Home interface for Enterprise Bean: Tiido_epigrafe
 */
public interface Tiido_epigrafeLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_epigrafe
	 */
	public entities.Tiido_epigrafeLocal create(
		java.lang.String cod_epigrafe,
		java.lang.String anho) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_epigrafe
	 */
	public entities.Tiido_epigrafeLocal findByPrimaryKey(
		entities.Tiido_epigrafeKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findEpiByAnho(java.lang.String anho) throws javax.ejb.FinderException;
	/**
	 * ejbCreate
	 */
	public entities.Tiido_epigrafeLocal create(Epigrafe epigrafe)
		throws javax.ejb.CreateException;
	public entities.Tiido_epigrafeLocal findByCodEpigAnho(java.lang.String codEpigrafe, java.lang.String anho) throws javax.ejb.FinderException;
	public entities.Tiido_epigrafeLocal findByCodEpig(java.lang.String codEpigrafe) throws javax.ejb.FinderException;
}
