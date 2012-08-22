package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.AsignacionRubro;


import java.util.HashMap;
import java.util.List;

public interface AsignacionRubroPersistence 
{

	@SuppressWarnings("unchecked")
	List listarRubrosAsignados(HashMap params);
		
	@SuppressWarnings("unchecked")
	List listarRubrosAsignShort(HashMap params);
	
	void insertarAsignacionRubro(AsignacionRubro objAsigRubro);
	
	void eliminarAsignacionRubro(AsignacionRubro objAsigRubro);

	@SuppressWarnings("unchecked")
	List existeRelacionEpigrafe(HashMap params);
	
	@SuppressWarnings("unchecked")
	List existeRelacionRubroLogro(HashMap params);
	
}
