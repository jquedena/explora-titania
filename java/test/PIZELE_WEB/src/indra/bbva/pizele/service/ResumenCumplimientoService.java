package indra.bbva.pizele.service;

import java.util.HashMap;
import java.util.List;

import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.domain.base.RubroLogro;
import indra.bbva.pizele.domain.extend.LogroMeta;
import indra.bbva.pizele.domain.extend.OficinaGestor;
import indra.bbva.pizele.domain.extend.RankingDetalle;
import indra.bbva.pizele.persistence.ResumenCumplimientoPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumenCumplimientoService 
{

	@Autowired
	private ResumenCumplimientoPersistence resumenCumplimientoPersistence;
	
	@SuppressWarnings("unchecked")
	public List<RankingDetalle> listarRankingRubro(RubroLogro objRubroLogro)
	{
		HashMap map = new HashMap();
		
		map.put("PI_COD_TERR", objRubroLogro.getCodigoTerritorio());
		map.put("PI_COD_OFI", objRubroLogro.getCodigoOficina());
		map.put("PI_ANIO", objRubroLogro.getAnio());
		map.put("PI_MES", objRubroLogro.getMes());
		map.put("PI_SEMANA", objRubroLogro.getSemana());
		
		this.resumenCumplimientoPersistence.listarRankingRubro(map);
		
		return (List<RankingDetalle>)map.get("RUBROS_PORC_CUMP_CUR_REF");
			
	}
	
	@SuppressWarnings("unchecked")
	public List<RankingDetalle> listarRankingGestor(RubroLogro objRubroLogro)
	{
		HashMap map = new HashMap();
		
		map.put("PI_COD_TERR", objRubroLogro.getCodigoTerritorio());
		map.put("PI_COD_OFI", objRubroLogro.getCodigoOficina());
		map.put("PI_ANIO", objRubroLogro.getAnio());
		map.put("PI_MES", objRubroLogro.getMes());
		map.put("PI_SEMANA", objRubroLogro.getSemana());
		
		this.resumenCumplimientoPersistence.listarRankingGestor(map);
		
		return (List<RankingDetalle>)map.get("GESTORES_PORC_CUMP_CUR_REF");
			
	}
}
