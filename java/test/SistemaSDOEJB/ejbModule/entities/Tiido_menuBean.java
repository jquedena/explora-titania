package entities;

import com.grupobbva.bc.per.tele.sdo.serializable.Menu;

/**
 * Bean implementation class for Enterprise Bean: Tiido_menu
 */
public abstract class Tiido_menuBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_menuKey ejbCreate(java.lang.String padre)
		throws javax.ejb.CreateException {
		setPadre(padre);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String padre)
		throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: padre
	 */
	public abstract java.lang.String getPadre();
	/**
	 * Set accessor for persistent attribute: padre
	 */
	public abstract void setPadre(java.lang.String newPadre);
	/**
	 * Get accessor for persistent attribute: link
	 */
	public abstract java.lang.String getLink();
	/**
	 * Set accessor for persistent attribute: link
	 */
	public abstract void setLink(java.lang.String newLink);
	/**
	 * Get accessor for persistent attribute: hijo
	 */
	public abstract java.lang.String getHijo();
	/**
	 * Set accessor for persistent attribute: hijo
	 */
	public abstract void setHijo(java.lang.String newHijo);
	/**
	 * Get accessor for persistent attribute: descripcion
	 */
	public abstract java.lang.String getDescripcion();
	/**
	 * Set accessor for persistent attribute: descripcion
	 */
	public abstract void setDescripcion(java.lang.String newDescripcion);
	/**
	 * Get accessor for persistent attribute: cod_perfil
	 */
	public abstract java.lang.String getCod_perfil();
	/**
	 * Set accessor for persistent attribute: cod_perfil
	 */
	public abstract void setCod_perfil(java.lang.String newCod_perfil);
	
	public entities.Tiido_menuKey ejbCreate(Menu mp) throws javax.ejb.CreateException {
		setCod_perfil(mp.getCodPerfil());
		setDescripcion(mp.getDescripcion());
		setHijo(mp.getHijo());
		setLink(mp.getLink());
		setPadre(mp.getPadre());
		return null;
	}
	
	public void ejbPostCreate(Menu mp)
	throws javax.ejb.CreateException {
	}
}
