package indra.bbva.pizele.service;

import java.util.HashMap;
import java.util.List;

import indra.bbva.pizele.domain.base.Territorio;
import indra.bbva.pizele.persistence.TerritorioPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerritorioService 
{

	@Autowired
	private TerritorioPersistence territorioPersistence;
	
	@SuppressWarnings("unchecked")
	public List<Territorio> listarTerritorios()
	{
		HashMap map = new HashMap();
		territorioPersistence.listarTerritorios(map);
		return (List<Territorio>)map.get("TERRITORIOS_CUR_REF");
	}
	
	@SuppressWarnings("unchecked")
	public Territorio obtenerTerritorio(String codTerr)
	{
		HashMap map = new HashMap();
		map.put("PI_COD_TERR", codTerr);
		territorioPersistence.listarTerritorios(map);
		List<Territorio> listaTerritorio = (List<Territorio>)map.get("TERRITORIOS_CUR_REF");
		if(listaTerritorio.size() == 0)
			return null;
		else
			return listaTerritorio.get(0);
	}
	
}
