package indra.bbva.pizele.persistence;


import indra.bbva.pizele.domain.base.ProcesoAutomatico;

import java.util.HashMap;
import java.util.List;

public interface ProcesoAutomaticoPersistence {

	@SuppressWarnings("unchecked")
	List listarProcesoAutomatico(HashMap params);
	
	void insertarProcesoAutomatico(ProcesoAutomatico objProcesoAutomatico);
	
	void actualizarProcesoAutomatico(ProcesoAutomatico objProcesoAutomatico);
	
	@SuppressWarnings("unchecked")
	void validaCargarArchivoMISIndependienteSDO(HashMap params);
	
	@SuppressWarnings("unchecked")
	void cargarArchivoMISIndependienteSDO(HashMap params);
	
	@SuppressWarnings("unchecked")
	void cambiaEstadoCargarArchivoMISIndependienteSDO(HashMap params);
	
	@SuppressWarnings("unchecked")
	HashMap obtenerRutaDirectorioExterno();
}
