package entities;
/**
 * Local Home interface for Enterprise Bean: Tiido_firmas
 */
public interface Tiido_firmasLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_firmas
	 */
	public entities.Tiido_firmasLocal create(
		java.lang.String cod_firma,
		entities.Tiido_oficinaLocal argTiido_fir_oficina_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_firmas
	 */
	public entities.Tiido_firmasLocal create(
		java.lang.String cod_firma,
		java.lang.String tiido_fir_oficina_fk_cod_ofic,
		java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_firmas
	 */
	public entities.Tiido_firmasLocal findByPrimaryKey(
		entities.Tiido_firmasKey primaryKey) throws javax.ejb.FinderException;
	public entities.Tiido_firmasLocal findFirmByAnoMesCgesItem(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item) throws javax.ejb.FinderException;
}
