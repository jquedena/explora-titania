package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.Oficina;
import indra.bbva.pizele.persistence.OficinaPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OficinaService 
{

	@Autowired
	private OficinaPersistence oficinaPersistence;
	
	@SuppressWarnings("unchecked")
	public List<Oficina> listarOficinas(String codTerr)
	{
		HashMap map = new HashMap();
		map.put("PI_COD_TERR", codTerr);
		oficinaPersistence.listarOficinas(map);
		return (List<Oficina>)map.get("OFICINAS_CUR_REF");
	}

	@SuppressWarnings("unchecked")
	public List<Oficina> listarOficinasHijas(String codOfic)
	{
		HashMap map = new HashMap();
		map.put("PI_COD_OFIC", codOfic);
		oficinaPersistence.listarOficinasHijas(map);
		return (List<Oficina>)map.get("OFICINAS_CUR_REF");
	}
	
	@SuppressWarnings("unchecked")
	public Oficina obtenerOficina(String codOfic)
	{
		HashMap map = new HashMap();
		map.put("PI_COD_OFIC", codOfic);
		oficinaPersistence.listarOficinas(map);
		List<Oficina> listaOficina = (List<Oficina>)map.get("OFICINAS_CUR_REF");
		if(listaOficina.size() == 0)
			return null;
		else
			return listaOficina.get(0);
	}
	
}
