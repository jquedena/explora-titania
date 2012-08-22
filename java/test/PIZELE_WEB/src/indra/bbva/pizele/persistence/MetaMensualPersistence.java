package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.MetaMensual;

import java.util.HashMap;
import java.util.List;

public interface MetaMensualPersistence {
	
	@SuppressWarnings("unchecked")
	List listarConfMetas(HashMap params);

	void insertarConfMetaMensual(MetaMensual objMetaMensual);
	
	void actualizarConfMetaMensual(MetaMensual objMetaMensual);
	
	@SuppressWarnings("unchecked")
	void copiarConfMetaMensual(HashMap params);
}
