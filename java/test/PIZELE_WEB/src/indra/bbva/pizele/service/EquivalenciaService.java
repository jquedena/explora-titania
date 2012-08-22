package indra.bbva.pizele.service;

import java.util.HashMap;
import java.util.List;

import indra.bbva.pizele.domain.base.Equivalencia;
import indra.bbva.pizele.persistence.EquivalenciaPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquivalenciaService 
{

	@Autowired
	private EquivalenciaPersistence equivalenciaPersistence;
	
	@SuppressWarnings("unchecked")
	public Equivalencia listarEquivalencia(String codCargo) 
	{
		HashMap map = new HashMap();
		
		map.put("PI_COD_CAR", codCargo);
		
		equivalenciaPersistence.listarEquivalencia(map);
		
		List<Equivalencia> listaEquivalencia = (List<Equivalencia>)map.get("EQUIV_CUR_REF");
		
		if(listaEquivalencia.size() == 0)
			return null;
		else
			return listaEquivalencia.get(0);
		
	}
	
}
