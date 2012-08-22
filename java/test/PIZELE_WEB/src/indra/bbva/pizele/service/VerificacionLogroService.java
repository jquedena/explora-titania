package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.extend.VerificacionLogroDetalle;
import indra.bbva.pizele.domain.extend.VerificacionLogroParametro;
import indra.bbva.pizele.persistence.VerificacionLogroPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificacionLogroService 
{

	@Autowired
	private VerificacionLogroPersistence verificacionLogroPersistence;
	
	@SuppressWarnings("unchecked")
	public List<VerificacionLogroDetalle>  listarVerificacionLogro(VerificacionLogroParametro objVerificacionLogroParametro) 
	{
		HashMap map = new HashMap();
		map.put("PI_COD_TERR", objVerificacionLogroParametro.getCodigoTerritorio());
		map.put("PI_COD_OFI", objVerificacionLogroParametro.getCodigoOficina());
		map.put("PI_COD_GEST", objVerificacionLogroParametro.getCodigoGestor());
		if(objVerificacionLogroParametro.getFechaDesde() != null && objVerificacionLogroParametro.getFechaDesde().length() > 0)
			map.put("PI_FECHA_DESDE", objVerificacionLogroParametro.getFechaDesde());
		if(objVerificacionLogroParametro.getFechaHasta() != null && objVerificacionLogroParametro.getFechaHasta().length() > 0)
			map.put("PI_FECHA_HASTA", objVerificacionLogroParametro.getFechaHasta());
		
		this.verificacionLogroPersistence.listarVerificacionLogro(map);

		return (List<VerificacionLogroDetalle>)map.get("LISTA_VERIF_LOGRO_CUR_REF");
		
	}
	
}
