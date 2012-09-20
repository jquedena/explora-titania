package indra.ldap2db.persistencia;

import indra.ldap2db.conexion.zConexion;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;

public class zIILDPeUsuarioPersistencia {

	public com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario recuperar(String identificador) throws IILDPeExcepcion {
		try {
			zConexion ejb = new zConexion();
			com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario peUsuario = new com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario();
			com.grupobbva.bc.per.tele.ldap.serializable.IILDPeUsuario peUsuarioOr = ejb.recuperarUsuario(identificador);
			if (peUsuarioOr != null) {
				BeanUtils.copyProperties(peUsuario, peUsuarioOr);
				return peUsuario;
			}
		} catch (IllegalAccessException e1) {
			return null;
		} catch (InvocationTargetException e1) {
			return null;
		}
		return null;
	}
}
