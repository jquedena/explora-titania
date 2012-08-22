package indra.bbva.pizele.persistence;


import indra.bbva.pizele.domain.base.ConfEpigrafeAsignados;

import java.util.HashMap;
import java.util.List;

public interface ConfEpigrafeAsigPersistence {
	
	@SuppressWarnings("unchecked")
	List listarEpigrafesAsignados(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarRubros(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarEpigrafeMIS(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarEpigrafeSDO(HashMap params);
	
	void insertarRubroEpigrafe(ConfEpigrafeAsignados objConfEpigrafeAsignados);
	
	void eliminarRubroEpigrafe(ConfEpigrafeAsignados objConfEpigrafeAsignados);

	@SuppressWarnings("unchecked")
	void copiarRubroEpigrafe(HashMap params);
}
