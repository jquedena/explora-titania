package indra.bbva.pizele.service;

import java.util.HashMap;
import java.util.List;

import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.AsignacionRubro;
import indra.bbva.pizele.domain.base.ConfEpigrafeAsignados;
import indra.bbva.pizele.domain.base.Epigrafe;
import indra.bbva.pizele.persistence.ConfEpigrafeAsigPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("unchecked")
public class ConfEpigrafeAsigService {

	@Autowired
	private ConfEpigrafeAsigPersistence confEpigrafeAsigPersistence;

	public List<Epigrafe> listarEpigrafesAsignados(AsignacionRubro objAsignacionRubro) {
		HashMap map = new HashMap();

		if (objAsignacionRubro.getIdrubro() != null && objAsignacionRubro.getIdrubro() != 0L)
			map.put("PI_ID_RUBRO", objAsignacionRubro.getIdrubro());

		if (objAsignacionRubro.getAnio() != null && objAsignacionRubro.getAnio() != 0L)
			map.put("PI_ANIO", objAsignacionRubro.getAnio());

		if (objAsignacionRubro.getMes() != null)
			map.put("PI_MES", objAsignacionRubro.getMes());

		confEpigrafeAsigPersistence.listarEpigrafesAsignados(map);

		return (List<Epigrafe>) map.get("CONFIG_EPIG_ASIG_CUR_REF");
	}
	
	public List<Epigrafe> listarEpigrafesAsignados(ConfEpigrafeAsignados objConfEpigrafeAsignados) {
		HashMap map = new HashMap();

		if (objConfEpigrafeAsignados.getId_rubro() != null && objConfEpigrafeAsignados.getId_rubro() != 0L)
			map.put("PI_ID_RUBRO", objConfEpigrafeAsignados.getId_rubro());

		if (objConfEpigrafeAsignados.getAnio() != null && objConfEpigrafeAsignados.getAnio() != 0L)
			map.put("PI_ANIO", objConfEpigrafeAsignados.getAnio());

		if (objConfEpigrafeAsignados.getMes() != null)
			map.put("PI_MES", objConfEpigrafeAsignados.getMes());

		confEpigrafeAsigPersistence.listarEpigrafesAsignados(map);

		return (List<Epigrafe>) map.get("CONFIG_EPIG_ASIG_CUR_REF");
	}

	public List<AsignacionRubro> listarRubros(AsignacionRubro objAsignacionRubro) {
		HashMap map = new HashMap();

		if (objAsignacionRubro.getIdrubro() != null
				&& objAsignacionRubro.getIdrubro() != 0L)
			map.put("PI_ID_RUBRO", objAsignacionRubro.getIdrubro());

		if (objAsignacionRubro.getCodterr() != null)
			map.put("PI_COD_TERR", objAsignacionRubro.getCodterr());

		if (objAsignacionRubro.getCodofic() != null)
			map.put("PI_COD_OFIC", objAsignacionRubro.getCodofic());

		if (objAsignacionRubro.getAnio() != null
				&& objAsignacionRubro.getAnio() != 0L)
			map.put("PI_ANIO", objAsignacionRubro.getAnio());

		if (objAsignacionRubro.getMes() != null)
			map.put("PI_MES", objAsignacionRubro.getMes());

		confEpigrafeAsigPersistence.listarRubros(map);

		return (List<AsignacionRubro>) map.get("LIST_RUBROS_CUR_REF");
	}
	
	public List<Epigrafe> listarEpigrafeMIS(AsignacionRubro objAsignacionRubro, String codEpigrafe, String nomEpigrafe) {
		HashMap map = new HashMap();

		if (objAsignacionRubro.getIdrubro() != null
				&& objAsignacionRubro.getIdrubro() != 0L)
			map.put("PI_ID_RUBRO", objAsignacionRubro.getIdrubro());

		if(codEpigrafe != null && codEpigrafe.length() >0)
			map.put("PI_COD_EPI", codEpigrafe);
		
		if(nomEpigrafe != null && nomEpigrafe.length() >0)
			map.put("PI_NOM_EPI", nomEpigrafe);
		
		if (objAsignacionRubro.getAnio() != null
				&& objAsignacionRubro.getAnio() != 0L)
			map.put("PI_ANIO", objAsignacionRubro.getAnio());

		if (objAsignacionRubro.getMes() != null)
			map.put("PI_MES", objAsignacionRubro.getMes());

		confEpigrafeAsigPersistence.listarEpigrafeMIS(map);

		return (List<Epigrafe>) map.get("EPIGRAFE_MIS_CUR_REF");
	}

	public List<Epigrafe> listarEpigrafeSDO(AsignacionRubro objAsignacionRubro) {
		HashMap map = new HashMap();

		if (objAsignacionRubro.getIdrubro() != null
				&& objAsignacionRubro.getIdrubro() != 0L)
			map.put("PI_ID_RUBRO", objAsignacionRubro.getIdrubro());

		if (objAsignacionRubro.getAnio() != null
				&& objAsignacionRubro.getAnio() != 0L)
			map.put("PI_ANIO", objAsignacionRubro.getAnio());

		if (objAsignacionRubro.getMes() != null)
			map.put("PI_MES", objAsignacionRubro.getMes());

		confEpigrafeAsigPersistence.listarEpigrafeSDO(map);

		return (List<Epigrafe>) map.get("EPIGRAFE_SDO_CUR_REF");
	}
	
	@Transactional
	public void guardarRubroEpigrafe(List<ConfEpigrafeAsignados> listaConfEpigrafeAsignados) {
		List<Epigrafe> asignados = this.listarEpigrafesAsignados(listaConfEpigrafeAsignados.get(0));
		ConfEpigrafeAsignados o = null; 
		String rubroEpigrafe = "!"; 
		int index = 0;
		
		for (index = 0; index < listaConfEpigrafeAsignados.size(); index++) {
			o = listaConfEpigrafeAsignados.get(index);
			
			if(o.getId().compareTo(-1L) == 0) {
				confEpigrafeAsigPersistence.insertarRubroEpigrafe(o);
			}
			
			rubroEpigrafe += o.getId().toString() + "!"; 
		}
		
		Epigrafe e;
		for(index = 0; index < asignados.size(); index++) {
			e = asignados.get(index);
			if(rubroEpigrafe.indexOf(e.getId().toString()) == -1) {
				
				o = new ConfEpigrafeAsignados();
				o.setUsuarioCreacion(listaConfEpigrafeAsignados.get(0).getUsuarioCreacion());
				o.setId(e.getId());
				
				confEpigrafeAsigPersistence.eliminarRubroEpigrafe(o);
			}
		}
	}
	
	@Transactional
	public void eliminarTotalRubroEpigrafe(ConfEpigrafeAsignados epigrafeAsignado) {
		List<Epigrafe> asignados = this.listarEpigrafesAsignados(epigrafeAsignado);
		ConfEpigrafeAsignados o = null; 
		Epigrafe e;
		int index = 0;

		for(index = 0; index < asignados.size(); index++) {
			e = asignados.get(index);
		
			o = new ConfEpigrafeAsignados();
			o.setUsuarioCreacion(CurrentUser.Instance().getCodigoRegistro());
			o.setId(e.getId());
			
			confEpigrafeAsigPersistence.eliminarRubroEpigrafe(o);
		}
	}
	
	@Transactional
	public void eliminarRubroEpigrafe(ConfEpigrafeAsignados objConfEpigrafeAsignados) {
		confEpigrafeAsigPersistence.eliminarRubroEpigrafe(objConfEpigrafeAsignados);
	}

	@Transactional
	public void copiarRubroepigrafe(Long anio, Long mes, Long id_rubro, Long anio_dest, Long mes_dest, String usuario) {
		HashMap map = new HashMap();

		if (id_rubro != null && id_rubro != 0L)
			map.put("PI_ID_RUBRO", id_rubro);

		if (anio != null && anio != 0L)
			map.put("PI_ANIO_ORIGEN", anio);

		if (mes != null && mes != 0L)
			map.put("PI_MES_ORIGEN", mes);
		
		if (anio_dest != null && anio_dest != 0L)
			map.put("PI_ANIO_DESTINO", anio_dest);

		if (mes_dest != null && mes_dest != 0L)
			map.put("PI_MES_DESTINO", mes_dest);

		if (usuario != null && usuario != "")
			map.put("PI_COD_USU", usuario);
		
		confEpigrafeAsigPersistence.copiarRubroEpigrafe(map);
	}
	
}
