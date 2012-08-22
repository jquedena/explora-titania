package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.Semaforo;

import java.util.HashMap;
import java.util.List;


public interface SemaforoPersistence {
	
	
	@SuppressWarnings("unchecked")
	List listarSemaforo(HashMap params);

	void actualizarSemaforo(Semaforo objSemaforo);
	
	@SuppressWarnings("unchecked")
	List obtenerSemaforo(HashMap params);
	

}
