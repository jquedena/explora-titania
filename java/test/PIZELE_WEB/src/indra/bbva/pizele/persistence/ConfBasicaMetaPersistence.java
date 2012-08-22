package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.ConfBasicaMeta;

import java.util.HashMap;
import java.util.List;

public interface ConfBasicaMetaPersistence {

	
	@SuppressWarnings("unchecked")
	List obtenerConfBasicaMeta(HashMap params);
	
	@SuppressWarnings("unchecked")
	List obtenerConfBasicaMeta_x_CAB(HashMap params);
	
	void insertarConfBasicaMeta(ConfBasicaMeta objConfBasicaMeta);
	
	void actualizarConfBasicaMeta(ConfBasicaMeta objConfBasicaMeta);
	
	void eliminarConfBasicaMeta(ConfBasicaMeta objConfBasicaMeta);
	
	
	
}	
	