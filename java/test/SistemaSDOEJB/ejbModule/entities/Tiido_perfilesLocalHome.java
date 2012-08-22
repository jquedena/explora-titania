package entities;

import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;

@SuppressWarnings("unchecked")
public interface Tiido_perfilesLocalHome extends javax.ejb.EJBLocalHome {

	public entities.Tiido_perfilesLocal create(java.lang.String cod_perfil)
		throws javax.ejb.CreateException;

	public entities.Tiido_perfilesLocal findByPrimaryKey(entities.Tiido_perfilesKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findAllPerfil() throws javax.ejb.FinderException;
	public entities.Tiido_perfilesLocal create(Perfil per) throws javax.ejb.CreateException;
}
