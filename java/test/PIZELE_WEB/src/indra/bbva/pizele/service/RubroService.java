package indra.bbva.pizele.service;

import java.util.HashMap;
import java.util.List;

import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.domain.extend.RubroDetalle;
import indra.bbva.pizele.persistence.RubroPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RubroService {

	@Autowired
	private RubroPersistence rubroPersistence;
	
	@SuppressWarnings("unchecked")
	
	public List<RubroDetalle> listarRubro(RubroDetalle objRubroDetalle) 
	{
		HashMap map = new HashMap();
		
		if(objRubroDetalle.getId() != null && objRubroDetalle.getId() != 0L)
			map.put("PI_ID", objRubroDetalle.getId());
		if(objRubroDetalle.getIdDiff() != null && objRubroDetalle.getIdDiff() != 0L)
			map.put("PI_ID_DIFF", objRubroDetalle.getIdDiff());
		if(objRubroDetalle.getDescFiltro() != null && objRubroDetalle.getDescFiltro().length() > 0)
			map.put("PI_DES_RUB_FILTR", objRubroDetalle.getDescFiltro());
		if(objRubroDetalle.getDescCompleto() != null && objRubroDetalle.getDescCompleto().length() > 0)
			map.put("PI_DES_RUB_COMP", objRubroDetalle.getDescCompleto());
		if(objRubroDetalle.getTiprubro() != null && objRubroDetalle.getTiprubro().length() > 0)
			map.put("PI_TIP_RUB", objRubroDetalle.getTiprubro());

		rubroPersistence.listarRubro(map);
				
		return (List<RubroDetalle>)map.get("RUBRO_CUR_REF");
	}
	
	
	@Transactional
	public void insertarRubro(Rubro objRubro) 
	{
		rubroPersistence.insertarRubro(objRubro);
		
	}
	
	@Transactional
	public void actualizarRubro(Rubro objRubro) 
	{
		rubroPersistence.actualizarRubro(objRubro);		
	}
	

}
