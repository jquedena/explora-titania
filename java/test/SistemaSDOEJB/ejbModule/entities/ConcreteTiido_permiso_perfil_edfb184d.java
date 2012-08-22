package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_permiso_perfilBeanCacheEntry_edfb184d;

/**
 * Bean implementation class for Enterprise Bean: Tiido_permiso_perfil
 */
public class ConcreteTiido_permiso_perfil_edfb184d extends entities.Tiido_permiso_perfilBean implements javax.ejb.EntityBean, ConcreteBean {
	static final long serialVersionUID = 61;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
		instanceExtension.setEntityContext(ctx);
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		super.unsetEntityContext();
		instanceExtension.unsetEntityContext();
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
			super.ejbActivate();
			instanceExtension.ejbActivate();
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
		instanceExtension.ejbLoad();
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
		super.ejbPassivate();
		instanceExtension.ejbPassivate();
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
		super.ejbRemove();
		instanceExtension.ejbRemove();
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
		super.ejbStore();
		instanceExtension.ejbStore();
	}
	private ConcreteBeanInstanceExtension instanceExtension;
	private Tiido_permiso_perfilBeanCacheEntry_edfb184d dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_permiso_perfil_edfb184d
	 */
	public ConcreteTiido_permiso_perfil_edfb184d() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_permiso_perfilBeanInjector_edfb184d getInjector() {
		return (entities.websphere_deploy.Tiido_permiso_perfilBeanInjector_edfb184d)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_permiso_perfilBeanCacheEntry_edfb184d) inRecord;
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_permiso_perfilKey ejbFindByPrimaryKey(entities.Tiido_permiso_perfilKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_permiso_perfilKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllPermisoPerfil_Local
	 */
	public java.util.Collection ejbFindAllPermisoPerfil_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllPermisoPerfil", null);
	}
	/**
	 * ejbFindPermisoPerfilxTipAccxValorRCP_Local
	 */
	public java.util.Collection ejbFindPermisoPerfilxTipAccxValorRCP_Local(java.lang.String tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindPermisoPerfilxTipAccxValorRCP");
		getInjector().ejbFindPermisoPerfilxTipAccxValorRCP(tipo_acceso, valor_rcp, record);
		return (java.util.Collection) instanceExtension.executeFind("FindPermisoPerfilxTipAccxValorRCP", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_permiso_perfilKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_permiso_perfilKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_permiso_perfilKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_permiso_perfilKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_permiso_perfilKey ejbCreate(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_permiso_perfilBeanCacheEntry_edfb184d) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(permisoPerfil);
		return (entities.Tiido_permiso_perfilKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
		super.ejbPostCreate(permisoPerfil);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_permiso_perfilKey ejbCreate(java.lang.String cod_perfil, java.lang.String tip_acceso, java.lang.String valor_rcp) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_permiso_perfilBeanCacheEntry_edfb184d) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_perfil, tip_acceso, valor_rcp);
		return (entities.Tiido_permiso_perfilKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_perfil, java.lang.String tip_acceso, java.lang.String valor_rcp) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_perfil, tip_acceso, valor_rcp);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_permiso_perfilKey pk = new entities.Tiido_permiso_perfilKey();
		pk.cod_perfil = getCod_perfil();
		pk.tip_acceso = getTip_acceso();
		pk.valor_rcp = getValor_rcp();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 8;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_perfil
	 */
	public java.lang.String getCod_perfil() {
		return dataCacheEntry.getCod_perfil();
	}
	/**
	 * Set accessor for persistent attribute: cod_perfil
	 */
	public void setCod_perfil(java.lang.String newCod_perfil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_perfil(),newCod_perfil);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_perfil(newCod_perfil);
	}
	/**
	 * Get accessor for persistent attribute: tip_acceso
	 */
	public java.lang.String getTip_acceso() {
		return dataCacheEntry.getTip_acceso();
	}
	/**
	 * Set accessor for persistent attribute: tip_acceso
	 */
	public void setTip_acceso(java.lang.String newTip_acceso) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getTip_acceso(),newTip_acceso);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setTip_acceso(newTip_acceso);
	}
	/**
	 * Get accessor for persistent attribute: valor_rcp
	 */
	public java.lang.String getValor_rcp() {
		return dataCacheEntry.getValor_rcp();
	}
	/**
	 * Set accessor for persistent attribute: valor_rcp
	 */
	public void setValor_rcp(java.lang.String newValor_rcp) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getValor_rcp(),newValor_rcp);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setValor_rcp(newValor_rcp);
	}
	/**
	 * Get accessor for persistent attribute: usuario
	 */
	public java.lang.String getUsuario() {
		return dataCacheEntry.getUsuario();
	}
	/**
	 * Set accessor for persistent attribute: usuario
	 */
	public void setUsuario(java.lang.String newUsuario) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getUsuario(),newUsuario);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setUsuario(newUsuario);
	}
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public java.lang.String getUsu_regi() {
		return dataCacheEntry.getUsu_regi();
	}
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public void setUsu_regi(java.lang.String newUsu_regi) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getUsu_regi(),newUsu_regi);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setUsu_regi(newUsu_regi);
	}
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public java.sql.Timestamp getFec_regi() {
		return dataCacheEntry.getFec_regi();
	}
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public void setFec_regi(java.sql.Timestamp newFec_regi) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setFec_regi(newFec_regi);
	}
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public java.lang.String getUsu_actu() {
		return dataCacheEntry.getUsu_actu();
	}
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public void setUsu_actu(java.lang.String newUsu_actu) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setUsu_actu(newUsu_actu);
	}
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public java.sql.Date getFec_actu() {
		return dataCacheEntry.getFec_actu();
	}
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public void setFec_actu(java.sql.Date newFec_actu) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setFec_actu(newFec_actu);
	}
}
