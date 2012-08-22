package entities;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
/**
 * Local Home interface for Enterprise Bean: Tiido_permiso_perfil
 */
public interface Tiido_permiso_perfilLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_permiso_perfil
	 */
	public entities.Tiido_permiso_perfilLocal create(
		java.lang.String cod_perfil,
		java.lang.String tip_acceso,
		java.lang.String valor_rcp) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_permiso_perfil
	 */
	public entities.Tiido_permiso_perfilLocal findByPrimaryKey(
		entities.Tiido_permiso_perfilKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findPermisoPerfilxTipAccxValorRCP(
		java.lang.String tipo_acceso,
		java.lang.String valor_rcp) throws javax.ejb.FinderException;
	public java.util.Collection findAllPermisoPerfil() throws javax.ejb.FinderException;
	public entities.Tiido_permiso_perfilLocal create(PermisoPerfil permisoPerfil)
		throws javax.ejb.CreateException;
}
