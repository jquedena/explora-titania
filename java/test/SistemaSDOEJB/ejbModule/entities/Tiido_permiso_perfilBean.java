package entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;

/**
 * Bean implementation class for Enterprise Bean: Tiido_permiso_perfil
 */
public abstract class Tiido_permiso_perfilBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_permiso_perfilKey ejbCreate(
		java.lang.String cod_perfil,
		java.lang.String tip_acceso,
		java.lang.String valor_rcp) throws javax.ejb.CreateException {
		setCod_perfil(cod_perfil);
		setTip_acceso(tip_acceso);
		setValor_rcp(valor_rcp);
		return null;
	}
	
	public entities.Tiido_permiso_perfilKey ejbCreate(
			PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
			setCod_perfil(permisoPerfil.getCodPerfil());
			setTip_acceso(permisoPerfil.getTipoAcceso());
			setValor_rcp(permisoPerfil.getValorRCP());
			setUsuario(permisoPerfil.getUsuario());
			setUsu_regi(permisoPerfil.getUsuRegi());	
			setFec_regi(new Timestamp((new java.util.Date()).getTime()));			
			setUsu_actu(null);
			setFec_actu(null);
			
			return null;
		}
	
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_perfil,
		java.lang.String tip_acceso,
		java.lang.String valor_rcp) throws javax.ejb.CreateException {
	}
	
	public void ejbPostCreate(PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: cod_perfil
	 */
	public abstract java.lang.String getCod_perfil();
	/**
	 * Set accessor for persistent attribute: cod_perfil
	 */
	public abstract void setCod_perfil(java.lang.String newCod_perfil);
	/**
	 * Get accessor for persistent attribute: tip_acceso
	 */
	public abstract java.lang.String getTip_acceso();
	/**
	 * Set accessor for persistent attribute: tip_acceso
	 */
	public abstract void setTip_acceso(java.lang.String newTip_acceso);
	/**
	 * Get accessor for persistent attribute: valor_rcp
	 */
	public abstract java.lang.String getValor_rcp();
	/**
	 * Set accessor for persistent attribute: valor_rcp
	 */
	public abstract void setValor_rcp(java.lang.String newValor_rcp);
	/**
	 * Get accessor for persistent attribute: usuario
	 */
	public abstract java.lang.String getUsuario();
	/**
	 * Set accessor for persistent attribute: usuario
	 */
	public abstract void setUsuario(java.lang.String newUsuario);
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
	 * Get accessor for persistent attribute: fec_actu
	 */
	public abstract java.sql.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public abstract void setFec_actu(java.sql.Date newFec_actu);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public abstract java.sql.Timestamp getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public abstract void setFec_regi(java.sql.Timestamp newFec_regi);
}
