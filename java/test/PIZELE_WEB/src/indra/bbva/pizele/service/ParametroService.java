package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.Parametro;
import indra.bbva.pizele.domain.base.Semana;
import indra.bbva.pizele.persistence.ParametroPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParametroService 
{

	@Autowired
	private ParametroPersistence parametroPersistence;
	
	@SuppressWarnings("unchecked")
	public List<Parametro> listarParametroFiltro(Parametro objParametro) 
	{
		HashMap map = new HashMap();
		
		if(objParametro.getId() != null && objParametro.getId() != 0L)
			map.put("PI_ID_PAR", objParametro.getId());
		if(objParametro.getIdTipoParametro() != null && objParametro.getIdTipoParametro() != 0L)
			map.put("PI_TIP_PAR", objParametro.getIdTipoParametro());
		if(objParametro.getIdParametroPadre() != null && objParametro.getIdParametroPadre() != 0L)
			map.put("PI_PADRE_PAR", objParametro.getIdParametroPadre());
		if(objParametro.getCodigo() != null && objParametro.getCodigo().length() > 0)
			map.put("PI_COD_PAR", objParametro.getCodigo());
		if(objParametro.getNombre() != null && objParametro.getNombre().length() > 0)
			map.put("PI_NOM_PAR", objParametro.getNombre());
		if(objParametro.getEstadoRegistro() != null && objParametro.getEstadoRegistro().length() > 0)
			map.put("PI_EST_REG", objParametro.getEstadoRegistro());
		if(objParametro.getValorEntero() != null && objParametro.getValorEntero() != 0)
			map.put("PI_VAL_ENT_PAR", objParametro.getValorEntero());
		
		parametroPersistence.listarParametroFiltro(map);
				
		return (List<Parametro>)map.get("PARAM_CUR_REF");
	}
	
	@SuppressWarnings("unchecked")
	public List<Parametro> listarParametro(Parametro objParametro) 
	{
		HashMap map = new HashMap();
		
		if(objParametro.getIdParametroPadre() != null && objParametro.getIdParametroPadre() != 0L)
			map.put("PI_PADRE_PAR", objParametro.getIdParametroPadre());
		if(objParametro.getIdTipoParametroDif() != null && objParametro.getIdTipoParametroDif() != 0L)
			map.put("PI_TIP_PAR_DIF", objParametro.getIdTipoParametroDif());
		if(objParametro.getCodigo() != null && objParametro.getCodigo().length() > 0)
			map.put("PI_COD_PAR", objParametro.getCodigo());
		if(objParametro.getNombre() != null && objParametro.getNombre().length() > 0)
			map.put("PI_NOM_PAR", objParametro.getNombre());
		if(objParametro.getIdParametroDif() != null && objParametro.getIdParametroDif() != 0L)
			map.put("PI_ID_PAR_DIF", objParametro.getIdParametroDif());
					
		parametroPersistence.listarParametro(map);
		
		return (List<Parametro>)map.get("PARAM_CUR_REF");
	}
	
	@Transactional
	public void insertarParametro(Parametro objParametro) 
	{
		parametroPersistence.insertarParametro(objParametro);
		
	}
	
	@Transactional
	public void actualizarParametro(Parametro objParametro) 
	{
		parametroPersistence.actualizarParametro(objParametro);		
	}
	
	@SuppressWarnings("unchecked")
	public Parametro obtenerParametro(Long idParametro)
	{
		HashMap map = new HashMap();
		map.put("PI_ID_PAR", idParametro);
				
		parametroPersistence.listarParametroFiltro(map);
		List<Parametro> lista = (List<Parametro>)map.get("PARAM_CUR_REF");
		if(lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Semana> diasHabiles(Long mes, Long anio) {
		HashMap map = new HashMap();
		map.put("MES", mes);
		map.put("ANIO", anio);
		parametroPersistence.diasHabiles(map);
		
		List<Semana> lista = (List<Semana>) map.get("SEMANAS");
		return lista;
	}
}
