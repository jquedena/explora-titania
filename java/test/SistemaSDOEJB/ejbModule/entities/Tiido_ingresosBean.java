package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_ingresos
 */
public abstract class Tiido_ingresosBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_ingresosKey ejbCreate(java.math.BigDecimal id_ingresos)
		throws javax.ejb.CreateException {
		setId_ingresos(id_ingresos);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.math.BigDecimal id_ingresos)
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
	 * Get accessor for persistent attribute: id_ingresos
	 */
	public abstract java.math.BigDecimal getId_ingresos();
	/**
	 * Set accessor for persistent attribute: id_ingresos
	 */
	public abstract void setId_ingresos(java.math.BigDecimal newId_ingresos);
	/**
	 * Get accessor for persistent attribute: veces
	 */
	public abstract java.lang.String getVeces();
	/**
	 * Set accessor for persistent attribute: veces
	 */
	public abstract void setVeces(java.lang.String newVeces);
	/**
	 * Get accessor for persistent attribute: valido_veces
	 */
	public abstract java.lang.String getValido_veces();
	/**
	 * Set accessor for persistent attribute: valido_veces
	 */
	public abstract void setValido_veces(java.lang.String newValido_veces);
	/**
	 * Get accessor for persistent attribute: cod_usuario
	 */
	public abstract java.lang.String getCod_usuario();
	/**
	 * Set accessor for persistent attribute: cod_usuario
	 */
	public abstract void setCod_usuario(java.lang.String newCod_usuario);
	/**
	 * Get accessor for persistent attribute: cargo
	 */
	public abstract java.lang.String getCargo();
	/**
	 * Set accessor for persistent attribute: cargo
	 */
	public abstract void setCargo(java.lang.String newCargo);
	/**
	 * Get accessor for persistent attribute: nom_territorio
	 */
	public abstract java.lang.String getNom_territorio();
	/**
	 * Set accessor for persistent attribute: nom_territorio
	 */
	public abstract void setNom_territorio(java.lang.String newNom_territorio);
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public abstract java.lang.String getCod_oficina();
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public abstract void setCod_oficina(java.lang.String newCod_oficina);
	/**
	 * Get accessor for persistent attribute: fecha
	 */
	public abstract java.lang.String getFecha();
	/**
	 * Set accessor for persistent attribute: fecha
	 */
	public abstract void setFecha(java.lang.String newFecha);
}
