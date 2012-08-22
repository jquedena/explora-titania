package entities;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
/**
 * Local Home interface for Enterprise Bean: Tiido_planes
 */
public interface Tiido_planesLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_planes
	 */
	public entities.Tiido_planesLocal create(
		java.lang.String mes_plan,
		java.lang.String anho_plan,
		java.lang.String cod_epigrafe,
		entities.Tiido_oficinaLocal argTiido_pla_oficina_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiido_planes
	 */
	public entities.Tiido_planesLocal create(
		java.lang.String mes_plan,
		java.lang.String anho_plan,
		java.lang.String cod_epigrafe,
		java.lang.String tiido_pla_oficina_fk_cod_ofic,
		java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiido_planes
	 */
	public entities.Tiido_planesLocal findByPrimaryKey(
		entities.Tiido_planesKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findConsultaPlanes(
		java.lang.String codOficina,
		java.lang.String anho,
		java.lang.String mes) throws javax.ejb.FinderException;
	public java.util.Collection findConsultarPlanesxMes(
		java.lang.String codOficina,
		java.lang.String anho) throws javax.ejb.FinderException;
	public entities.Tiido_planesLocal findPlanByObject(
		java.lang.String mes,
		java.lang.String anho,
		java.lang.String codEpigrafe,
		java.lang.String codOficina) throws javax.ejb.FinderException;
	public entities.Tiido_planesLocal findConsultaPlanesResumen(
		java.lang.String mes,
		java.lang.String anho,
		java.lang.String codEpigrafe,
		java.lang.String codOficina) throws javax.ejb.FinderException;
	/**
	 * ejbCreate
	 */
	public entities.Tiido_planesLocal create(Plan plan)
		throws javax.ejb.CreateException;
	public entities.Tiido_planesLocal findConsultaPlanesPrioridad(
		java.lang.String mes,
		java.lang.String anho,
		java.lang.String codEpigrafe,
		java.lang.String codOficina) throws javax.ejb.FinderException;
}
