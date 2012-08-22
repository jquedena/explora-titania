package indra.bbva.pizele.persistence;

import java.util.HashMap;
import java.util.List;

public interface ResumenCumplimientoPersistence 
{

	@SuppressWarnings("unchecked")
	List listarRankingRubro(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarRankingGestor(HashMap params);
	
}
