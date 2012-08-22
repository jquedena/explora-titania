package entities;

import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;

/**
 * Bean implementation class for Enterprise Bean: Tiido_metas_gestor
 */
@SuppressWarnings("serial")
public abstract class Tiido_metas_gestorBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_metas_gestorKey ejbCreate(
		java.lang.String cod_meta_gestor,
		entities.Tiido_epigrafeLocal argTiido_metges_epigrafe_fk,
		entities.Tiido_oficinaLocal argTiido_metges_oficina_fk)
		throws javax.ejb.CreateException {
		setCod_meta_gestor(cod_meta_gestor);
		entities.Tiido_epigrafeKey argTiido_metges_epigrafe_fkPK = (entities.Tiido_epigrafeKey) argTiido_metges_epigrafe_fk
			.getPrimaryKey();
		setTiido_metges_epigrafe_fk_cod_epigrafe(argTiido_metges_epigrafe_fkPK.cod_epigrafe);
		setTiido_metges_epigrafe_fk_anho(argTiido_metges_epigrafe_fkPK.anho);
		entities.Tiido_oficinaKey argTiido_metges_oficina_fkPK = (entities.Tiido_oficinaKey) argTiido_metges_oficina_fk
			.getPrimaryKey();
		setTiido_metges_oficina_fk_cod_ofic(argTiido_metges_oficina_fkPK.cod_ofic);
		setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(argTiido_metges_oficina_fkPK.tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_meta_gestor,
		entities.Tiido_epigrafeLocal argTiido_metges_epigrafe_fk,
		entities.Tiido_oficinaLocal argTiido_metges_oficina_fk)
		throws javax.ejb.CreateException {
		setTiido_metges_epigrafe_fk(argTiido_metges_epigrafe_fk);
		setTiido_metges_oficina_fk(argTiido_metges_oficina_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_metas_gestorKey ejbCreate(
		java.lang.String cod_meta_gestor,
		java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe,
		java.lang.String tiido_metges_epigrafe_fk_anho,
		java.lang.String tiido_metges_oficina_fk_cod_ofic,
		java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setCod_meta_gestor(cod_meta_gestor);
		setTiido_metges_epigrafe_fk_cod_epigrafe(tiido_metges_epigrafe_fk_cod_epigrafe);
		setTiido_metges_epigrafe_fk_anho(tiido_metges_epigrafe_fk_anho);
		setTiido_metges_oficina_fk_cod_ofic(tiido_metges_oficina_fk_cod_ofic);
		setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_meta_gestor,
		java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe,
		java.lang.String tiido_metges_epigrafe_fk_anho,
		java.lang.String tiido_metges_oficina_fk_cod_ofic,
		java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_metas_gestorKey ejbCreate(MetasGestor metasGestor, Tiido_epigrafeLocal epigrafeLocal, Tiido_oficinaLocal oficinaLocal)
		throws javax.ejb.CreateException {		
		setCod_meta_gestor(metasGestor.getCodMetaGestor());
		setTiido_metges_epigrafe_fk_cod_epigrafe(metasGestor.getCodEpigrafe());
		setTiido_metges_epigrafe_fk_anho(metasGestor.getAnho());
		setTiido_metges_oficina_fk_cod_ofic(metasGestor.getOficina().getCodOfic());
		setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(metasGestor.getOficina().getTerr().getCodTerr());
		setCod_gestor(metasGestor.getCodGestor());
		//setFec_regi(new java.util.Date());
		setMes(metasGestor.getMes());
		setNom_epigrafe(metasGestor.getNomEpigrafe());
		setNom_gestor(metasGestor.getNomGestor());
		setOrden(metasGestor.getOrden());
		setPorc_asig(metasGestor.getPorcAsignado());
		setCod_perfil_gestor(metasGestor.getCodPerfil());
		setEstado(metasGestor.getEstado());
		setUsu_regi(metasGestor.getUsuario());
		setFec_regi(new java.sql.Date(new java.util.Date().getTime()));
		
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(MetasGestor metasGestor, Tiido_epigrafeLocal epigrafeLocal, Tiido_oficinaLocal oficinaLocal)
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
	 * Get accessor for persistent attribute: cod_meta_gestor
	 */
	public abstract java.lang.String getCod_meta_gestor();
	/**
	 * Set accessor for persistent attribute: cod_meta_gestor
	 */
	public abstract void setCod_meta_gestor(java.lang.String newCod_meta_gestor);
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public abstract java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public abstract void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public abstract java.lang.String getMes();
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public abstract void setMes(java.lang.String newMes);
	/**
	 * Get accessor for persistent attribute: orden
	 */
	public abstract java.lang.String getOrden();
	/**
	 * Set accessor for persistent attribute: orden
	 */
	public abstract void setOrden(java.lang.String newOrden);
	/**
	 * Get accessor for persistent attribute: porc_asig
	 */
	public abstract java.math.BigDecimal getPorc_asig();
	/**
	 * Set accessor for persistent attribute: porc_asig
	 */
	public abstract void setPorc_asig(java.math.BigDecimal newPorc_asig);
	/**
	 * Get accessor for persistent attribute: nom_epigrafe
	 */
	public abstract java.lang.String getNom_epigrafe();
	/**
	 * Set accessor for persistent attribute: nom_epigrafe
	 */
	public abstract void setNom_epigrafe(java.lang.String newNom_epigrafe);
	/**
	 * Get accessor for persistent attribute: nom_gestor
	 */
	public abstract java.lang.String getNom_gestor();
	/**
	 * Set accessor for persistent attribute: nom_gestor
	 */
	public abstract void setNom_gestor(java.lang.String newNom_gestor);
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_epigrafeLocal getTiido_metges_epigrafe_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_metges_epigrafe_fk(
		entities.Tiido_epigrafeLocal aTiido_metges_epigrafe_fk);
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_oficinaLocal getTiido_metges_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_metges_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_metges_oficina_fk);
	/**
	 * Get accessor for persistent attribute: tiido_metges_epigrafe_fk_cod_epigrafe
	 */
	public abstract java.lang.String getTiido_metges_epigrafe_fk_cod_epigrafe();
	/**
	 * Set accessor for persistent attribute: tiido_metges_epigrafe_fk_cod_epigrafe
	 */
	public abstract void setTiido_metges_epigrafe_fk_cod_epigrafe(
		java.lang.String newTiido_metges_epigrafe_fk_cod_epigrafe);
	/**
	 * Get accessor for persistent attribute: tiido_metges_epigrafe_fk_anho
	 */
	public abstract java.lang.String getTiido_metges_epigrafe_fk_anho();
	/**
	 * Set accessor for persistent attribute: tiido_metges_epigrafe_fk_anho
	 */
	public abstract void setTiido_metges_epigrafe_fk_anho(
		java.lang.String newTiido_metges_epigrafe_fk_anho);
	/**
	 * Get accessor for persistent attribute: tiido_metges_oficina_fk_cod_ofic
	 */
	public abstract java.lang.String getTiido_metges_oficina_fk_cod_ofic();
	/**
	 * Set accessor for persistent attribute: tiido_metges_oficina_fk_cod_ofic
	 */
	public abstract void setTiido_metges_oficina_fk_cod_ofic(
		java.lang.String newTiido_metges_oficina_fk_cod_ofic);
	/**
	 * Get accessor for persistent attribute: tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(
		java.lang.String newTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
	/**
	 * Get accessor for persistent attribute: cod_perfil_gestor
	 */
	public abstract java.lang.String getCod_perfil_gestor();
	/**
	 * Set accessor for persistent attribute: cod_perfil_gestor
	 */
	public abstract void setCod_perfil_gestor(
		java.lang.String newCod_perfil_gestor);
	/**
	 * Get accessor for persistent attribute: estado
	 */
	public abstract java.lang.String getEstado();
	/**
	 * Set accessor for persistent attribute: estado
	 */
	public abstract void setEstado(java.lang.String newEstado);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public abstract java.util.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public abstract void setFec_actu(java.util.Date newFec_actu);
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public abstract java.lang.String getUsu_regi();
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public abstract void setUsu_regi(java.lang.String newUsu_regi);
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public abstract java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public abstract void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public abstract java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public abstract void setFec_regi(java.sql.Date newFec_regi);
}
