package indra.ldap2db;

import indra.ldap2db.persistencia.zIILDPeUsuarioPersistencia;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;

public class zIILDPeUsuario {

	private static final long serialVersionUID = 3744042231861654299L;
	private static transient zIILDPeUsuarioPersistencia persistencia = new zIILDPeUsuarioPersistencia();

	public static IILDPeUsuario recuperarUsuario(String userId)	throws IILDPeExcepcion {
		return persistencia.recuperar(userId);
	}
}
