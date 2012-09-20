package indra.bbva.pizele.service;


import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.domain.base.ConfBasicaMeta;
import indra.bbva.pizele.domain.base.Gestor;
import indra.bbva.pizele.domain.base.MetaMensual;
import indra.bbva.pizele.domain.extend.MetaMensualDetalle;
import indra.bbva.pizele.persistence.MetaMensualPersistence;
import indra.core.FechaUtil;
import indra.core.MathUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MetaMensualService {

	private List<MetaMensualDetalle> listaMetasMensuales;
	
	@Autowired
	private MetaMensualPersistence metaMensualPersistence;

	@Resource
	private GestorService gestorService;
	
	@Resource
	private ConfBasicaMetaService confBasicaMetaService;
	
	@SuppressWarnings("unchecked")
	public List<MetaMensualDetalle> listarConfMetas(MetaMensual objMetaMensual) 
	{
		HashMap map = new HashMap();

		if(objMetaMensual.getCod_terr() != null )
			map.put("PI_COD_TERR", objMetaMensual.getCod_terr());
		if(objMetaMensual.getCod_ofi() != null )
			map.put("PI_COD_OFI", objMetaMensual.getCod_ofi());
		if(objMetaMensual.getAnio() != null && objMetaMensual.getAnio() != 0L)
			map.put("PI_ANIO", objMetaMensual.getAnio());
		if(objMetaMensual.getMes() != null)
			map.put("PI_MES", objMetaMensual.getMes());
		if(objMetaMensual.getId_rubro() != null)
			map.put("PI_ID_RUBRO", objMetaMensual.getId_rubro());
		metaMensualPersistence.listarConfMetas(map);

		return (List<MetaMensualDetalle>)map.get("CONF_META_MENS_CUR_REF");
	}

	@Transactional
	public void registrarMeta(MetaMensual objMetaMensual) 
	{
		metaMensualPersistence.insertarConfMetaMensual(objMetaMensual);
	}
	
	@Transactional
	public void actualizarMeta(MetaMensual objMetaMensual) 
	{
		metaMensualPersistence.actualizarConfMetaMensual(objMetaMensual);
	}
	
	public List<MetaMensual> getListaCompletaMetasMensuales(String cod_ter, String cod_ofi, Long anio, Long idMes, Long idRubro) throws Exception {
		
		List<MetaMensual> listaCompletaMetasMensuales = new ArrayList<MetaMensual>();
		
		MetaMensual objMetaMensual = new MetaMensual();
		objMetaMensual.setCod_terr(cod_ter);
		objMetaMensual.setCod_ofi(cod_ofi);
		objMetaMensual.setAnio(anio);
		objMetaMensual.setMes(idMes);
		objMetaMensual.setId_rubro(idRubro);
		
		List<Gestor> listGestores_x_Oficina = this.getGestorService().listarGestorOficinaSinSubGerente(cod_ofi);
		setListaMetasMensuales(listarConfMetas(objMetaMensual));
		
		ConfBasicaMeta confBasicaMeta = confBasicaMetaService.obtenerConfBasicaMeta_x_CAB(cod_ter, cod_ofi, anio, idMes);
		
		if(confBasicaMeta == null) {
			throw new Exception("No existe una configuración definida para este rubro en este mes.");
		}
				
		for (Gestor gestor: listGestores_x_Oficina) {
			MetaMensual metaMensual = buscarMetaMensual_x_Gestor(gestor.getCodigoRegistro());
			metaMensual.setCod_terr(cod_ter);
			metaMensual.setCod_ofi(cod_ofi);
			metaMensual.setAnio(anio);
			metaMensual.setMes(idMes);
			metaMensual.setId_rubro(idRubro);
			metaMensual.setCod_gestor(gestor.getCodigoRegistro());
			metaMensual.setNom_gestor(gestor.getNombre());
			metaMensual.setApell_pat_gestor(gestor.getApellidoPaterno());
			metaMensual.setApell_mat_gestor(gestor.getApellidoMaterno() + " " + gestor.getOficinaHija());
			metaMensual.setCod_perfil(gestor.getPerfilID());
			metaMensual.setPerfil(gestor.getPerfil());
			
			if ((Constantes.RubroFijosNoDesasignables.CONTACTOS.equals(metaMensual.getId_rubro())) ||
				(Constantes.RubroFijosNoDesasignables.VISITAS.equals(metaMensual.getId_rubro())) ) {
				
				int[] diasUtilesArray = FechaUtil.obtenerDiasUtiles(anio.intValue(), idMes.intValue() - 6);
				long[] metaSemanalArray = new long[5];
				long configMinima = 0;
				
				if (Constantes.RubroFijosNoDesasignables.CONTACTOS.equals(metaMensual.getId_rubro())) {
					if (Constantes.Perfil.GESTORES_NO_PERSONALIZADOS.equals(metaMensual.getCod_perfil()))
						configMinima = confBasicaMeta.getMin_con_dia_no_perso().longValue();
					else
						configMinima = confBasicaMeta.getMin_con_dia_perso().longValue();
				}
				else if (Constantes.RubroFijosNoDesasignables.VISITAS.equals(metaMensual.getId_rubro())) {
					if (Constantes.Perfil.GESTORES_NO_PERSONALIZADOS.equals(metaMensual.getCod_perfil()))
						configMinima = confBasicaMeta.getMin_vis_dia_no_perso().longValue();
					else
						configMinima = confBasicaMeta.getMin_vis_dia_perso().longValue();
				}
				
				for (int i=0; i<diasUtilesArray.length; i++) {
					metaSemanalArray[i] = diasUtilesArray[i] * configMinima;
				}
				
				if (metaMensual.getId().equals(0L)){
					metaMensual.setSemana1(metaSemanalArray[0]);
					metaMensual.setSemana2(metaSemanalArray[1]);
					metaMensual.setSemana3(metaSemanalArray[2]);
					metaMensual.setSemana4(metaSemanalArray[3]);
					metaMensual.setSemana5(metaSemanalArray[4]);
					metaMensual.setMeta_mensual(MathUtil.sumar(metaSemanalArray));
				}
				metaMensual.setSemana1Minimo(metaSemanalArray[0]);
				metaMensual.setSemana2Minimo(metaSemanalArray[1]);
				metaMensual.setSemana3Minimo(metaSemanalArray[2]);
				metaMensual.setSemana4Minimo(metaSemanalArray[3]);
				metaMensual.setSemana5Minimo(metaSemanalArray[4]);
				
			}
			else {
				if (metaMensual.getId().equals(0L)){
					metaMensual.setSemana1(0L);
					metaMensual.setSemana2(0L);
					metaMensual.setSemana3(0L);
					metaMensual.setSemana4(0L);
					metaMensual.setSemana5(0L);
					metaMensual.setMeta_mensual(0L);
				}
			}
		
			listaCompletaMetasMensuales.add(metaMensual);
		}
		
		return listaCompletaMetasMensuales;
	}

	private MetaMensual buscarMetaMensual_x_Gestor(String cod_gestor) {
		MetaMensual metaMensual = new MetaMensual();
		
		int  i=0;
		for (MetaMensualDetalle metaMensualRecord: getListaMetasMensuales()) {
			if (metaMensualRecord.getCod_gestor().equalsIgnoreCase(cod_gestor)) {
				metaMensual = metaMensualRecord;
				metaMensual.setFlag_epigrafe_sdo(metaMensualRecord.getCont_epigrafe_sdo().intValue()>0 ? "S" : "N");
				break;
			}
			i++;
		}
		if (metaMensual.getId()==null)
			metaMensual.setId(0L);
		
		return metaMensual;
	}
	
	public void copiarMetasMensuales(String cod_ter, String cod_ofi, Long idRubro, String usuario
			, Long anioOrigen, Long idMesOrigen, Long anioDestino, Long idMesDestino) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		if(cod_ter != null )
			params.put("P_ID_TERR", cod_ter);
		
		if(cod_ofi != null )
			params.put("P_ID_OFIC", cod_ofi);
		
		if(idRubro != null )
			params.put("P_ID_RUBRO", idRubro);
		
		if(usuario != null )
			params.put("P_ID_USER", usuario);
		
		if(anioOrigen != null && anioOrigen != 0L)
			params.put("P_ANIO_ORIGEN", anioOrigen);
		
		if(idMesOrigen != null && idMesOrigen != 0L)
			params.put("P_MES_ORIGEN", idMesOrigen);
		
		if(anioDestino != null && anioDestino != 0L)
			params.put("P_ANIO_DESTINO", anioDestino);
		
		if(idMesDestino != null && idMesDestino != 0L)
			params.put("P_MES_DESTINO", idMesDestino);

		metaMensualPersistence.copiarConfMetaMensual(params);
	}
	
	public GestorService getGestorService() {
		return gestorService;
	}

	public void setGestorService(GestorService gestorService) {
		this.gestorService = gestorService;
	}

	public List<MetaMensualDetalle> getListaMetasMensuales() {
		return listaMetasMensuales;
	}

	public void setListaMetasMensuales(List<MetaMensualDetalle> listaMetasMensuales) {
		this.listaMetasMensuales = listaMetasMensuales;
	}
}