package indra.bbva.pizele.service;

import java.util.HashMap;
import java.util.List;

import indra.bbva.pizele.domain.base.Backup;
import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.domain.base.RubroLogro;
import indra.bbva.pizele.domain.extend.LogroMeta;
import indra.bbva.pizele.domain.extend.OficinaGestor;
import indra.bbva.pizele.persistence.ConsultaLogroPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaLogroService 
{

	@Autowired
	private ConsultaLogroPersistence consultaLogroPersistence;
	
	private List<Rubro> listaRubros;
	private List<OficinaGestor> listaOficinasGestores;
	private List<LogroMeta> listaLogros;
	private List<LogroMeta> listaMetas;
	
	@SuppressWarnings("unchecked")
	public void cargarConsultaLogros(RubroLogro objRubroLogro)
	{
		HashMap map = new HashMap();
		
		map.put("PI_COD_TERR", objRubroLogro.getCodigoTerritorio());
		map.put("PI_COD_OFI", objRubroLogro.getCodigoOficina());
		map.put("PI_ANIO", objRubroLogro.getAnio());
		map.put("PI_MES", objRubroLogro.getMes());
		map.put("PI_SEMANA", objRubroLogro.getSemana());
		
		this.consultaLogroPersistence.listarConsultaLogros(map);
				
		this.setListaRubros((List<Rubro>)map.get("RUBROS_CUR_REF"));
		this.setListaOficinasGestores((List<OficinaGestor>)map.get("GESTOR_OFICINA_CUR_REF"));
		this.setListaLogros((List<LogroMeta>)map.get("LOGROS_CUR_REF"));
		this.setListaMetas((List<LogroMeta>)map.get("METAS_CUR_REF"));
		
	}
	
	public List<Rubro> getListaRubros() {
		return listaRubros;
	}
	public void setListaRubros(List<Rubro> listaRubros) {
		this.listaRubros = listaRubros;
	}
	public List<OficinaGestor> getListaOficinasGestores() {
		return listaOficinasGestores;
	}
	public void setListaOficinasGestores(List<OficinaGestor> listaOficinasGestores) {
		this.listaOficinasGestores = listaOficinasGestores;
	}
	public List<LogroMeta> getListaLogros() {
		return listaLogros;
	}
	public void setListaLogros(List<LogroMeta> listaLogros) {
		this.listaLogros = listaLogros;
	}
	public List<LogroMeta> getListaMetas() {
		return listaMetas;
	}
	public void setListaMetas(List<LogroMeta> listaMetas) {
		this.listaMetas = listaMetas;
	}
	
}
