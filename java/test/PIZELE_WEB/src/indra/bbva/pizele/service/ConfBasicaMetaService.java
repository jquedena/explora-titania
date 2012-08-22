package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.ConfBasicaMeta;
import indra.bbva.pizele.persistence.ConfBasicaMetaPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfBasicaMetaService {
   
	@Autowired
	private ConfBasicaMetaPersistence confBasicaMetaPersistence;
	
	@SuppressWarnings("unchecked")
	public ConfBasicaMeta obtenerConfBasicaMeta(String cod_terr,String cod_ofic,Long anio, Long mes)
	{
		HashMap map = new HashMap();
		map.put("PI_COD_TERR", cod_terr);
		map.put("PI_COD_OFI", cod_ofic);
		map.put("PI_ANIO", anio);
		map.put("PI_MES", mes);
		
		confBasicaMetaPersistence.obtenerConfBasicaMeta(map);
		List<ConfBasicaMeta> lista = (List<ConfBasicaMeta>)map.get("CONF_BASICA_META_CUR_REF");
		if(lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public ConfBasicaMeta obtenerConfBasicaMeta_x_CAB(String cod_terr,String cod_ofic,Long anio, Long mes)
	{
		HashMap map = new HashMap();
		map.put("PI_COD_TERR", cod_terr);
		map.put("PI_COD_OFI", cod_ofic);
		map.put("PI_ANIO", anio);
		map.put("PI_MES", mes);
		
		confBasicaMetaPersistence.obtenerConfBasicaMeta_x_CAB(map);
		List<ConfBasicaMeta> lista = (List<ConfBasicaMeta>)map.get("CONF_BASICA_META_CUR_REF");
		if(lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}
	
	@Transactional
	public void insertarConfMetaBasica(ConfBasicaMeta objConfBasicaMeta) 
	{
		confBasicaMetaPersistence.insertarConfBasicaMeta(objConfBasicaMeta);
	}
	
	@Transactional
	public void actualizarConfMetaBasica(ConfBasicaMeta objConfBasicaMeta) 
	{
		confBasicaMetaPersistence.actualizarConfBasicaMeta(objConfBasicaMeta);
	}
	
	@Transactional
	public void eliminarConfMetaBasica(ConfBasicaMeta objConfBasicaMeta) 
	{
		confBasicaMetaPersistence.eliminarConfBasicaMeta(objConfBasicaMeta);		
	}
	
}
