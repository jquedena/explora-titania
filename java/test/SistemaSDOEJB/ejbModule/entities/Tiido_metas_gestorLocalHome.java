package entities;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import entities.Tiido_epigrafeLocal;
import entities.Tiido_oficinaLocal;
/**
 * Local Home interface for Enterprise Bean: Tiido_metas_gestor
 */
public interface Tiido_metas_gestorLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_metas_gestor
	 */
	public entities.Tiido_metas_gestorLocal create(
		java.lang.String cod_meta_gestor,
		entities.Tiido_epigrafeLocal argTiido_metges_epigrafe_fk,
		entities.Tiido_oficinaLocal argTiido_metges_oficina_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_metas_gestor
	 */
	public entities.Tiido_metas_gestorLocal create(
		java.lang.String cod_meta_gestor,
		java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe,
		java.lang.String tiido_metges_epigrafe_fk_anho,
		java.lang.String tiido_metges_oficina_fk_cod_ofic,
		java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_metas_gestor
	 */
	public entities.Tiido_metas_gestorLocal findByPrimaryKey(
		entities.Tiido_metas_gestorKey primaryKey)
		throws javax.ejb.FinderException;
	public entities.Tiido_metas_gestorLocal findMetGestorByPrimaryKey(
		java.lang.String codEpigrafe,
		java.lang.String anho,
		java.lang.String codOficina,
		java.lang.String mes,
		java.lang.String codGestor) throws javax.ejb.FinderException;
	/**
	 * ejbCreate
	 */
	public entities.Tiido_metas_gestorLocal create(
		MetasGestor metasGestor,
		Tiido_epigrafeLocal epigrafeLocal,
		Tiido_oficinaLocal oficinaLocal) throws javax.ejb.CreateException;
	
	public entities.Tiido_metas_gestorLocal findGestorByCodigo(
		java.lang.String codGestor) throws javax.ejb.FinderException;
}
