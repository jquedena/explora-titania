package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_multitabla
 */
public abstract class Tiido_multitablaBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_multitablaKey ejbCreate(
		java.lang.String cod_mult,
		java.lang.String cod_elem) throws javax.ejb.CreateException {
		setCod_mult(cod_mult);
		setCod_elem(cod_elem);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_mult,
		java.lang.String cod_elem) throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: cod_mult
	 */
	public abstract java.lang.String getCod_mult();
	/**
	 * Set accessor for persistent attribute: cod_mult
	 */
	public abstract void setCod_mult(java.lang.String newCod_mult);
	/**
	 * Get accessor for persistent attribute: cod_elem
	 */
	public abstract java.lang.String getCod_elem();
	/**
	 * Set accessor for persistent attribute: cod_elem
	 */
	public abstract void setCod_elem(java.lang.String newCod_elem);
	/**
	 * Get accessor for persistent attribute: valor1
	 */
	public abstract java.lang.String getValor1();
	/**
	 * Set accessor for persistent attribute: valor1
	 */
	public abstract void setValor1(java.lang.String newValor1);
	/**
	 * Get accessor for persistent attribute: valor2
	 */
	public abstract java.lang.String getValor2();
	/**
	 * Set accessor for persistent attribute: valor2
	 */
	public abstract void setValor2(java.lang.String newValor2);
	/**
	 * Get accessor for persistent attribute: valor3
	 */
	public abstract java.lang.String getValor3();
	/**
	 * Set accessor for persistent attribute: valor3
	 */
	public abstract void setValor3(java.lang.String newValor3);
	/**
	 * Get accessor for persistent attribute: valor4
	 */
	public abstract java.lang.String getValor4();
	/**
	 * Set accessor for persistent attribute: valor4
	 */
	public abstract void setValor4(java.lang.String newValor4);
}
