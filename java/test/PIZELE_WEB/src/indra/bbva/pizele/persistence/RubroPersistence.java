package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.Rubro;

import java.util.HashMap;
import java.util.List;

public interface RubroPersistence {

	@SuppressWarnings("unchecked")
	List listarRubro(HashMap params);
	
	void insertarRubro(Rubro objRubro);
	
	void actualizarRubro(Rubro objRubro);
	
}
