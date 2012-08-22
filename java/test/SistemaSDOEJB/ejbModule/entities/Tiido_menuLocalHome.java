package entities;
import com.grupobbva.bc.per.tele.sdo.serializable.Menu;
/**
 * Local Home interface for Enterprise Bean: Tiido_menu
 */
public interface Tiido_menuLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_menu
	 */
	public entities.Tiido_menuLocal create(java.lang.String padre)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_menu
	 */
	public entities.Tiido_menuLocal findByPrimaryKey(
		entities.Tiido_menuKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findxCodPerfil(java.lang.String codPerfil) throws javax.ejb.FinderException;
	public java.util.Collection findAllMenu() throws javax.ejb.FinderException;
	public entities.Tiido_menuLocal create(Menu mp)
		throws javax.ejb.CreateException;
}
