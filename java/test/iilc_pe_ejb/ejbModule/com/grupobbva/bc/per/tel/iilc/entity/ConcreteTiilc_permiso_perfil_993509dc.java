package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_permiso_perfilBeanCacheEntry_993509dc;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_permiso_perfil
 */
public class ConcreteTiilc_permiso_perfil_993509dc extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiilc_permiso_perfilBeanCacheEntry_993509dc dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_permiso_perfil_993509dc
	 */
	public ConcreteTiilc_permiso_perfil_993509dc() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_permiso_perfilBeanInjector_993509dc getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_permiso_perfilBeanInjector_993509dc)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_permiso_perfilBeanCacheEntry_993509dc) inRecord;
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindPermisoPerfil_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbFindPermisoPerfil_Local(java.lang.String cod_perfil, int tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindPermisoPerfil");
		getInjector().ejbFindPermisoPerfil(cod_perfil, tipo_acceso, valor_rcp, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey) instanceExtension.executeFind("FindPermisoPerfil", record);
	}
	/**
	 * ejbFindPermisoPerfilxTipAccxValorRCP_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbFindPermisoPerfilxTipAccxValorRCP_Local(int tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindPermisoPerfilxTipAccxValorRCP");
		getInjector().ejbFindPermisoPerfilxTipAccxValorRCP(tipo_acceso, valor_rcp, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey) instanceExtension.executeFind("FindPermisoPerfilxTipAccxValorRCP", record);
	}
	/**
	 * ejbFindAllPermisoPerfil_Local
	 */
	public java.util.Collection ejbFindAllPermisoPerfil_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllPermisoPerfil", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbCreate(com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_permiso_perfilBeanCacheEntry_993509dc) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(permisoPerfil);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
		super.ejbPostCreate(permisoPerfil);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbCreate(java.lang.String cod_perfil, java.math.BigDecimal tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_permiso_perfilBeanCacheEntry_993509dc) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_perfil, tipo_acceso, valor_rcp);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_perfil, java.math.BigDecimal tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_perfil, tipo_acceso, valor_rcp);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey();
		pk.cod_perfil = getCod_perfil();
		pk.tipo_acceso = getTipo_acceso();
		pk.valor_rcp = getValor_rcp();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 3;
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
	 * Get accessor for persistent attribute: tipo_acceso
	 */
	public java.math.BigDecimal getTipo_acceso() {
		return dataCacheEntry.getTipo_acceso();
	}
	/**
	 * Set accessor for persistent attribute: tipo_acceso
	 */
	public void setTipo_acceso(java.math.BigDecimal newTipo_acceso) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getTipo_acceso(),newTipo_acceso);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setTipo_acceso(newTipo_acceso);
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
}
