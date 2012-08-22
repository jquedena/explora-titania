package indra.bbva.pizele.persistence;


import java.util.HashMap;
import java.util.List;

public interface OpcionPersistence 
{

	@SuppressWarnings("unchecked")
	List listarOpciones(HashMap params);
	
}
