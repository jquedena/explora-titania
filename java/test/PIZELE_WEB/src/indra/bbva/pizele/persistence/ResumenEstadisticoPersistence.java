package indra.bbva.pizele.persistence;

import java.util.HashMap;
import java.util.List;

public interface ResumenEstadisticoPersistence 
{

	@SuppressWarnings("unchecked")
	List listarPorcentajeCumplimiento(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarLogro(HashMap params);

	@SuppressWarnings("unchecked")
	List listarPromedioLogroHistorico(HashMap params);
	
}
