package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiilc_permiso_perfil
 */
public interface Tiilc_permiso_perfilBeanInjector_993509dc extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindPermisoPerfil
	 */
	public void ejbFindPermisoPerfil(java.lang.String cod_perfil, int tipo_acceso, java.lang.String valor_rcp, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindPermisoPerfilxTipAccxValorRCP
	 */
	public void ejbFindPermisoPerfilxTipAccxValorRCP(int tipo_acceso, java.lang.String valor_rcp, javax.resource.cci.IndexedRecord record);
}
