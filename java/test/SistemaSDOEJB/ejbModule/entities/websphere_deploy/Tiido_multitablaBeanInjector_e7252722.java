package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_multitabla
 */
public interface Tiido_multitablaBeanInjector_e7252722 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByID
	 */
	public void ejbFindByID(java.lang.String id, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindMultiByPrimaryKey
	 */
	public void ejbFindMultiByPrimaryKey(java.lang.String codMulti, java.lang.String codElem, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByCodMulti
	 */
	public void ejbFindByCodMulti(java.lang.String codMulti, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByMultiForPresup
	 */
	public void ejbFindByMultiForPresup(java.lang.String codMulti, java.lang.String Valor2, javax.resource.cci.IndexedRecord record);
}
