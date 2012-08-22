package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.Parametro;

import java.util.HashMap;
import java.util.List;

public interface ParametroPersistence 
{

	@SuppressWarnings("unchecked")
	List listarParametroFiltro(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarParametro(HashMap params);
	
	void insertarParametro(Parametro objParametro);
	
	void actualizarParametro(Parametro objParametro);
	
	@SuppressWarnings("unchecked")
	List diasHabiles(HashMap params);
	
}
