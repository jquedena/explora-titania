package indra.bbva.pizele.service;

import java.util.HashMap;
import java.util.List;

import indra.bbva.pizele.domain.base.AsignacionRubro;
import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.domain.base.Semaforo;
import indra.bbva.pizele.domain.extend.AsignacionRubroDetalle;
import indra.bbva.pizele.persistence.AsignacionRubroPersistence;
import indra.bbva.pizele.persistence.RubroPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AsignacionRubroService {

	@Autowired
	private AsignacionRubroPersistence   asigRubroPersistence;
	
	@SuppressWarnings("unchecked")
	
	public List<AsignacionRubroDetalle> listarRubrosAsignadosPorTipo(AsignacionRubroDetalle objAsigRubro) 
	{
		
		HashMap map = new HashMap();
		
		if(objAsigRubro.getId() != null && objAsigRubro.getId() != 0L)
			map.put("PI_ID", objAsigRubro.getId());
		if(objAsigRubro.getCodterr() != null && objAsigRubro.getCodterr().length() > 0)
			map.put("PI_COD_TERR", objAsigRubro.getCodterr());
		if(objAsigRubro.getCodofic() != null && objAsigRubro.getCodofic().length() > 0)
			map.put("PI_COD_OFI", objAsigRubro.getCodofic());
		if(objAsigRubro.getAnio() != null && objAsigRubro.getAnio() != 0L)
			map.put("PI_ANIO", objAsigRubro.getAnio());
		if(objAsigRubro.getMes() != null && objAsigRubro.getMes() != 0L)
			map.put("PI_MES", objAsigRubro.getMes());
		if(objAsigRubro.getTipoRubro() != null && objAsigRubro.getTipoRubro().length() > 0)
			map.put("PI_TIP_RUB", objAsigRubro.getTipoRubro());
			
		asigRubroPersistence.listarRubrosAsignados(map);	
		
		return (List<AsignacionRubroDetalle>)map.get("ASIG_RUBRO_CUR_REF");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Rubro> listarRubrosAsignShort(AsignacionRubro objAsigRubro) 
	{
		
		HashMap map = new HashMap();
		
		if(objAsigRubro.getCodterr() != null && objAsigRubro.getCodterr().length() > 0)
			map.put("PI_COD_TERR", objAsigRubro.getCodterr());
		if(objAsigRubro.getCodofic() != null && objAsigRubro.getCodofic().length() > 0)
			map.put("PI_COD_OFIC", objAsigRubro.getCodofic());
		if(objAsigRubro.getAnio() != null && objAsigRubro.getAnio() != 0L)
			map.put("PI_ANIO", objAsigRubro.getAnio());
		if(objAsigRubro.getMes() != null && objAsigRubro.getMes() != 0L)
			map.put("PI_MES", objAsigRubro.getMes());
			
		asigRubroPersistence.listarRubrosAsignShort(map);	
		
		return (List<Rubro>)map.get("LIST_RUBROS_CUR_REF");
		
	}
	
	@Transactional	
	public void guardarAsignacionRubros(AsignacionRubroDetalle objAsigRubro, List<AsignacionRubro> listaAsignacionRubro, String usuario) 
	{   
		
		List<AsignacionRubroDetalle> listaAsignacionRubroDetalle = this.listarRubrosAsignadosPorTipo(objAsigRubro);
		
		boolean eliminar;
		boolean insertar;
		AsignacionRubro objAsignacionRubro = null;
		
		for(int index1 = 0; index1 < listaAsignacionRubroDetalle.size(); index1++)
		{

			eliminar = true;
			
			for(int index2 = 0; index2 < listaAsignacionRubro.size(); index2++)
			{
				if(listaAsignacionRubroDetalle.get(index1).getIdrubro() == listaAsignacionRubro.get(index2).getIdrubro())
				{
					eliminar = false;
					break;
				}
			}
			
			if(eliminar)
			{
				objAsignacionRubro = new AsignacionRubro();
				objAsignacionRubro.setId(listaAsignacionRubroDetalle.get(index1).getId());
				objAsignacionRubro.setUsuarioModificacion(usuario);
				this.asigRubroPersistence.eliminarAsignacionRubro(objAsignacionRubro);
			}
		}	
		
		for(int index1 = 0; index1 < listaAsignacionRubro.size(); index1++)
		{
			
			insertar = true;
			
			for(int index2 = 0; index2 < listaAsignacionRubroDetalle.size(); index2++)
			{
				if(listaAsignacionRubroDetalle.get(index2).getIdrubro() == listaAsignacionRubro.get(index1).getIdrubro())
				{
					insertar = false;
					break;
				}
			}
			
			if(insertar)
			{				
				this.asigRubroPersistence.insertarAsignacionRubro(listaAsignacionRubro.get(index1));
			}
			
		}

	}

	@Transactional	
	public void eliminarAsignacionRubros(List<AsignacionRubro> listaAsignacionRubro, String usuario) 
	{   
		
		for(AsignacionRubro objAsignacionRubro : listaAsignacionRubro)
		{
			objAsignacionRubro.setUsuarioModificacion(usuario);
			this.asigRubroPersistence.eliminarAsignacionRubro(objAsignacionRubro);
		}

	}
	
	public List<Rubro> listarRubros_x_Cabecera(String cod_ter, String cod_ofi, Long anio, Long idMes) {

		AsignacionRubroDetalle objAsigRubro = new AsignacionRubroDetalle();
		objAsigRubro.setCodterr(cod_ter);
		objAsigRubro.setCodofic(cod_ofi);
		objAsigRubro.setAnio(anio);
		objAsigRubro.setMes(idMes);
		
		return listarRubrosAsignShort(objAsigRubro);
	}
	
	@SuppressWarnings("unchecked")
	public boolean existeRelacionEpigrafe(Long id) 
	{
		
		HashMap map = new HashMap();
		map.put("PI_ID", id);
	
		asigRubroPersistence.existeRelacionEpigrafe(map);	
		
		return (((List<Integer>)map.get("VALUE_CUR_REF")).get(0) > 0);
				
	}
	
	@SuppressWarnings("unchecked")
	public boolean existeRelacionRubroLogro(Long id) 
	{
		
		HashMap map = new HashMap();
		map.put("PI_ID", id);
	
		asigRubroPersistence.existeRelacionRubroLogro(map);	
		
		return (((List<Integer>)map.get("VALUE_CUR_REF")).get(0) > 0);
				
	}
}
