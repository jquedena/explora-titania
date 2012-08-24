package indra.bbva.pizele.persistence;

import indra.bbva.iiwx.domain.base.LDAPPERU2;

import java.util.List;

public interface LDAPPERU2Persistence {

	@SuppressWarnings("unchecked")
	List obtenerDatosUsuario(String codofi);
	
	@SuppressWarnings("unchecked")
	List obtenerDatosUsuarioSinSubGerente(String codofi);
	
	@SuppressWarnings("unchecked")
	List obtenerDatosGerente(String codofi);
	
	LDAPPERU2 obtenerGOF(String codofi);
}