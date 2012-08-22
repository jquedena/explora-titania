package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.InformeUso;
import indra.bbva.pizele.domain.extend.InformeUsoDetalle;
import indra.bbva.pizele.persistence.InformeUsoPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformeUsoService {

	@Autowired
	private InformeUsoPersistence informeusopersistence;
	
	@SuppressWarnings("unchecked")
	public List<InformeUsoDetalle>  listarInformeUso(InformeUso objInformeUso) 
	{
		HashMap map = new HashMap();
		map.put("PI_COD_TERR", objInformeUso.getCodterr());
		map.put("PI_COD_OFIC", objInformeUso.getCodigoOficina());
		if(objInformeUso.getFechaDesde() != null && objInformeUso.getFechaDesde().length() > 0)
			map.put("PI_FECHA_DESDE", objInformeUso.getFechaDesde());
		if(objInformeUso.getFechaHasta() != null && objInformeUso.getFechaHasta().length() > 0)
			map.put("PI_FECHA_HASTA", objInformeUso.getFechaHasta());
		
		informeusopersistence.listarInformeUso(map);

		return (List<InformeUsoDetalle>)map.get("LISTA_INFORME_CUR_REF");
		
	}

}
