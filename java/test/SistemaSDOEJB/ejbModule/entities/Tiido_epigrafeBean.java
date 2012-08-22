package entities;

import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;

/**
 * Bean implementation class for Enterprise Bean: Tiido_epigrafe
 */
public abstract class Tiido_epigrafeBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_epigrafeKey ejbCreate(
		java.lang.String cod_epigrafe,
		java.lang.String anho) throws javax.ejb.CreateException {
		setCod_epigrafe(cod_epigrafe);
		setAnho(anho);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(Epigrafe epigrafe) throws javax.ejb.CreateException {
	}
	
	/**
	 * ejbCreate
	 */
	public entities.Tiido_epigrafeKey ejbCreate(Epigrafe epigrafe) throws javax.ejb.CreateException {
		setAbreviatura(epigrafe.getAbreviatura());
		setAnho(epigrafe.getAnho());
		setCod_epigrafe(epigrafe.getCodEpigrafe());
		setInd_afecta(epigrafe.getIndAfecta());
		setInd_clase(epigrafe.getIndClase());
		setInd_grupo(epigrafe.getIndGrupo());
		setInd_hijo(epigrafe.getIndHijo());
		setInd_sub_clase(epigrafe.getIndSubClase());
		setNom_epigrafe(epigrafe.getNomEpigrafe());
		setOrden(epigrafe.getOrden());
		return null;
	}
	
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_epigrafe,
		java.lang.String anho) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: cod_epigrafe
	 */
	public abstract java.lang.String getCod_epigrafe();
	/**
	 * Set accessor for persistent attribute: cod_epigrafe
	 */
	public abstract void setCod_epigrafe(java.lang.String newCod_epigrafe);
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public abstract java.lang.String getAnho();
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public abstract void setAnho(java.lang.String newAnho);
	/**
	 * Get accessor for persistent attribute: nom_epigrafe
	 */
	public abstract java.lang.String getNom_epigrafe();
	/**
	 * Set accessor for persistent attribute: nom_epigrafe
	 */
	public abstract void setNom_epigrafe(java.lang.String newNom_epigrafe);
	/**
	 * Get accessor for persistent attribute: ind_clase
	 */
	public abstract java.lang.String getInd_clase();
	/**
	 * Set accessor for persistent attribute: ind_clase
	 */
	public abstract void setInd_clase(java.lang.String newInd_clase);
	/**
	 * Get accessor for persistent attribute: ind_sub_clase
	 */
	public abstract java.lang.String getInd_sub_clase();
	/**
	 * Set accessor for persistent attribute: ind_sub_clase
	 */
	public abstract void setInd_sub_clase(java.lang.String newInd_sub_clase);
	/**
	 * Get accessor for persistent attribute: orden
	 */
	public abstract java.lang.String getOrden();
	/**
	 * Set accessor for persistent attribute: orden
	 */
	public abstract void setOrden(java.lang.String newOrden);
	/**
	 * Get accessor for persistent attribute: ind_grupo
	 */
	public abstract java.lang.String getInd_grupo();
	/**
	 * Set accessor for persistent attribute: ind_grupo
	 */
	public abstract void setInd_grupo(java.lang.String newInd_grupo);
	/**
	 * Get accessor for persistent attribute: abreviatura
	 */
	public abstract java.lang.String getAbreviatura();
	/**
	 * Set accessor for persistent attribute: abreviatura
	 */
	public abstract void setAbreviatura(java.lang.String newAbreviatura);
	/**
	 * Get accessor for persistent attribute: ind_hijo
	 */
	public abstract java.lang.String getInd_hijo();
	/**
	 * Set accessor for persistent attribute: ind_hijo
	 */
	public abstract void setInd_hijo(java.lang.String newInd_hijo);
	/**
	 * Get accessor for persistent attribute: ind_afecta
	 */
	public abstract java.lang.String getInd_afecta();
	/**
	 * Set accessor for persistent attribute: ind_afecta
	 */
	public abstract void setInd_afecta(java.lang.String newInd_afecta);
	/**
	 * This method was generated for supporting the relationship role named tiido_acciones.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_acciones();
	/**
	 * This method was generated for supporting the relationship role named tiido_acciones.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_acciones(java.util.Collection aTiido_acciones);
	/**
	 * This method was generated for supporting the relationship role named tiido_metas_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_metas_gestor();
	/**
	 * This method was generated for supporting the relationship role named tiido_metas_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_metas_gestor(
		java.util.Collection aTiido_metas_gestor);
	/**
	 * Get accessor for persistent attribute: porcentaje_max
	 */
	public abstract java.math.BigDecimal getPorcentaje_max();
	/**
	 * Set accessor for persistent attribute: porcentaje_max
	 */
	public abstract void setPorcentaje_max(
		java.math.BigDecimal newPorcentaje_max);
	/**
	 * Get accessor for persistent attribute: porcentaje_min
	 */
	public abstract java.math.BigDecimal getPorcentaje_min();
	/**
	 * Set accessor for persistent attribute: porcentaje_min
	 */
	public abstract void setPorcentaje_min(
		java.math.BigDecimal newPorcentaje_min);
}
