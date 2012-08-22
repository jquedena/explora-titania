package indra.bbva.pizele.persistence;

import java.util.HashMap;
import java.util.List;

public interface TerritorioPersistence 
{
	
	@SuppressWarnings("unchecked")
	List listarTerritorios(HashMap params);
	
}
