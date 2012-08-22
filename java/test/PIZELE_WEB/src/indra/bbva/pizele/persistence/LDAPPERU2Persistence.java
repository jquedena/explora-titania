package indra.bbva.pizele.persistence;

import java.util.List;

public interface LDAPPERU2Persistence {

	@SuppressWarnings("unchecked")
	List obtenerDatosUsuario(String codofi);
	
	@SuppressWarnings("unchecked")
	List obtenerDatosUsuarioSinSubGerente(String codofi);
	
	@SuppressWarnings("unchecked")
	List obtenerDatosGerente(String codofi);
	
}