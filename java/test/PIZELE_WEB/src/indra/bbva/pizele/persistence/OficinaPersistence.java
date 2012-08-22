package indra.bbva.pizele.persistence;

import java.util.HashMap;
import java.util.List;

public interface OficinaPersistence 
{

	@SuppressWarnings("unchecked")
	List listarOficinas(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarOficinasHijas(HashMap params);
}
