package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.RubroLogro;
import indra.bbva.pizele.persistence.RubroLogroPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RubroLogroService {

	@Autowired
	private RubroLogroPersistence rubroLogroPersistence;
	
	@SuppressWarnings("unchecked")
	public List<RubroLogro> listarRubro(RubroLogro rubroLogro) {
		HashMap map = new HashMap();
		
		if(rubroLogro.getCodigoTerritorio() != null && rubroLogro.getCodigoTerritorio().length() > 0)
			map.put("PI_COD_TERR", rubroLogro.getCodigoTerritorio());
		
		if(rubroLogro.getCodigoOficina() != null && rubroLogro.getCodigoOficina().length() > 0)
			map.put("PI_COD_OFIC", rubroLogro.getCodigoOficina());
		
		if(rubroLogro.getDia() != null && rubroLogro.getDia() != 0L)
			map.put("PI_DIA", rubroLogro.getDia());
		
		if(rubroLogro.getMes() != null && rubroLogro.getMes() != 0L)
			map.put("PI_MES", rubroLogro.getMes());
		
		if(rubroLogro.getAnio() != null && rubroLogro.getAnio() != 0L)
			map.put("PI_ANIO", rubroLogro.getAnio());
		
		rubroLogroPersistence.listarRubroLogro(map);
		
		return (List<RubroLogro>)map.get("RUBRO_LOGRO_CUR_REF");
	}
	
	
	@Transactional
	public void insertarRubroLogro(RubroLogro rubroLogro) {
		rubroLogroPersistence.insertarRubroLogro(rubroLogro);
	}
	
	@Transactional
	public void eliminarRubroLogro(RubroLogro rubroLogro) {
		rubroLogroPersistence.eliminarRubroLogro(rubroLogro);
	}

}
