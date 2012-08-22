package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.RubroLogro;

import java.util.HashMap;
import java.util.List;

public interface RubroLogroPersistence {

	@SuppressWarnings("unchecked")
	List listarRubroLogro(HashMap params);
	
	void insertarRubroLogro(RubroLogro rubroLogro);
	
	void eliminarRubroLogro(RubroLogro rubroLogro);
	
}
