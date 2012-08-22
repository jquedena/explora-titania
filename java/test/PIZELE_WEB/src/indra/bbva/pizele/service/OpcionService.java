package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.OpcionMenu;
import indra.bbva.pizele.persistence.OpcionPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionService 
{
	@Autowired
	private OpcionPersistence opcionPersistence;
	
	@SuppressWarnings("unchecked")
	public List<OpcionMenu> listarOpciones(String codPerfil)
	{
		HashMap map = new HashMap();
		map.put("PI_COD_PER", codPerfil);
		opcionPersistence.listarOpciones(map);
		return (List<OpcionMenu>)map.get("OPCIONES_CUR_REF");
	}
	
}
