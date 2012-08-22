package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_acciones
 */
public interface Tiido_accionesLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_acciones
	 */
	public entities.Tiido_accionesLocal create(
		java.lang.Integer cod_acci,
		entities.Tiido_epigrafeLocal argTiido_acc_epigrafe_fk,
		entities.Tiido_oficinaLocal argTiido_acc_oficina_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_acciones
	 */
	public entities.Tiido_accionesLocal create(
		java.lang.Integer cod_acci,
		java.lang.String tiido_acc_epigrafe_fk_cod_epigrafe,
		java.lang.String tiido_acc_epigrafe_fk_anho,
		java.lang.String tiido_acc_oficina_fk_cod_ofic,
		java.lang.String tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_acciones
	 */
	public entities.Tiido_accionesLocal findByPrimaryKey(
		entities.Tiido_accionesKey primaryKey) throws javax.ejb.FinderException;
}
