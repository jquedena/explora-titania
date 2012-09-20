package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.extend.InformeParametro;
import indra.bbva.pizele.domain.extend.RubroLogroMeta;
import indra.bbva.pizele.persistence.ResumenEstadisticoPersistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumenEstadisticoService 
{

	@Autowired
	private ResumenEstadisticoPersistence resumenEstadisticoPersistence;
	
	@SuppressWarnings("unchecked")
	public List<RubroLogroMeta> listarRubroEstadistico(InformeParametro objInformeParametro)
	{
		
		HashMap map = new HashMap();		
		map.put("PI_COD_TERR", objInformeParametro.getCodigoTerritorio());
		map.put("PI_COD_OFI", objInformeParametro.getCodigoOficina());
		map.put("PI_COD_GEST", objInformeParametro.getCodigoGestor());
		map.put("PI_ANIO", objInformeParametro.getIdAnio());
		map.put("PI_MES", objInformeParametro.getIdMes());
		
		List<RubroLogroMeta> listaResumenEstadistico = new ArrayList<RubroLogroMeta>();
		RubroLogroMeta objRubroLogroMeta = null;
		
		this.resumenEstadisticoPersistence.listarPorcentajeCumplimiento(map);
		
		for(RubroLogroMeta tempRubroLogroMeta : (List<RubroLogroMeta>)map.get("PORC_PORC_CUMP_CUR_REF"))
		{
			objRubroLogroMeta = new RubroLogroMeta();
			objRubroLogroMeta.setIdRubro(tempRubroLogroMeta.getIdRubro());
			objRubroLogroMeta.setDescRubro(tempRubroLogroMeta.getDescRubro());
			objRubroLogroMeta.setPorcentajeCumplimiento(tempRubroLogroMeta.getPorcentajeCumplimiento());
			objRubroLogroMeta.setColor(tempRubroLogroMeta.getColor());
			objRubroLogroMeta.setLogro(0L);
			objRubroLogroMeta.setMeta(tempRubroLogroMeta.getMeta());
			objRubroLogroMeta.setPromedioHistorico(0L);
			listaResumenEstadistico.add(objRubroLogroMeta);
		}
		
		boolean nuevo;
		
		this.resumenEstadisticoPersistence.listarLogro(map);
		
		for(RubroLogroMeta tempRubroLogroMeta : (List<RubroLogroMeta>)map.get("PORC_LOGRO_CUR_REF"))
		{
			nuevo = true;
			
			for(RubroLogroMeta existeRubroLogroMeta : listaResumenEstadistico)
			{
				if(tempRubroLogroMeta.getIdRubro().compareTo(existeRubroLogroMeta.getIdRubro()) == 0)
				{
					existeRubroLogroMeta.setLogro(tempRubroLogroMeta.getLogro());
					nuevo = false;
				}
			}
			
			if(nuevo)
			{
				objRubroLogroMeta = new RubroLogroMeta();
				objRubroLogroMeta.setIdRubro(tempRubroLogroMeta.getIdRubro());
				objRubroLogroMeta.setDescRubro(tempRubroLogroMeta.getDescRubro());
				objRubroLogroMeta.setPorcentajeCumplimiento(0L);
				objRubroLogroMeta.setColor("");
				objRubroLogroMeta.setLogro(tempRubroLogroMeta.getLogro());
				objRubroLogroMeta.setMeta(0L);
				objRubroLogroMeta.setPromedioHistorico(0L);
				listaResumenEstadistico.add(objRubroLogroMeta);
			}
			
		}
		
		this.resumenEstadisticoPersistence.listarPromedioLogroHistorico(map);
		
		for(RubroLogroMeta tempRubroLogroMeta : (List<RubroLogroMeta>)map.get("PROM_LOGRO_HIST_CUR_REF"))
		{
			nuevo = true;
			
			for(RubroLogroMeta existeRubroLogroMeta : listaResumenEstadistico)
			{
				if(tempRubroLogroMeta.getIdRubro().compareTo(existeRubroLogroMeta.getIdRubro()) == 0)
				{
					existeRubroLogroMeta.setPromedioHistorico(tempRubroLogroMeta.getPromedioHistorico());
					nuevo = false;
				}
			}
			
			if(nuevo)
			{
				objRubroLogroMeta = new RubroLogroMeta();
				objRubroLogroMeta.setIdRubro(tempRubroLogroMeta.getIdRubro());
				objRubroLogroMeta.setDescRubro(tempRubroLogroMeta.getDescRubro());
				objRubroLogroMeta.setPorcentajeCumplimiento(0L);
				objRubroLogroMeta.setColor("");
				objRubroLogroMeta.setLogro(0L);
				objRubroLogroMeta.setMeta(0L);
				objRubroLogroMeta.setPromedioHistorico(tempRubroLogroMeta.getPromedioHistorico());
				listaResumenEstadistico.add(objRubroLogroMeta);
			}
			
		}
		
		return listaResumenEstadistico;
			
	}
	
}
