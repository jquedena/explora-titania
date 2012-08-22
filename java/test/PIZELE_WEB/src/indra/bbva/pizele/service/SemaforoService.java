package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.Semaforo;
import indra.bbva.pizele.persistence.SemaforoPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SemaforoService {
	
	@Autowired
	private SemaforoPersistence semaforoPersistence;

	public List<Semaforo> listarSemaforo(Semaforo objSemaforo) 
	{
		HashMap map = new HashMap();
		
		if(objSemaforo != null && objSemaforo.getId() != null && objSemaforo.getId() != 0L)
			map.put("PI_ID", objSemaforo.getId());
	
		semaforoPersistence.listarSemaforo(map);
				
		return (List<Semaforo>)map.get("SEMA_CUR_REF");
	}
	
	@Transactional
	public void actualizarSemaforos(List<Semaforo> listaSemaforo) 
	{
		for(int index = 0; index < listaSemaforo.size(); index++)
		{
			semaforoPersistence.actualizarSemaforo(listaSemaforo.get(index));
		}					
	}
	

}
