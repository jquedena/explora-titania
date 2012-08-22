package indra.bbva.pizele.service;

import indra.bbva.iiwx.domain.base.LDAPPERU2;
import indra.bbva.pizele.domain.base.Gerente;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class GerenteService 
{

	@Resource
	private LDAPPERU2Service ldapperu2service;

	public Gerente listarGestorGerente(String codigoOficina) 
	{
		List<Gerente> listaGestor = new ArrayList<Gerente>();
		
		List<LDAPPERU2> listaLDAP = ldapperu2service.obtenerListaDatosGerente(codigoOficina);
		Gerente gerente = null;
		for (LDAPPERU2 ldapperu2 : listaLDAP) 
		{
			gerente = new Gerente();
			gerente.setCodigoRegistro(ldapperu2.getCodusu());
			gerente.setNombre(ldapperu2.getNombre());
			gerente.setApellidoPaterno(ldapperu2.getApepat());
			gerente.setApellidoMaterno(ldapperu2.getApemat());		
		}
		
		return gerente;
		
	}
	
	public Gerente obtenerGerente(String codigoGerente, List<Gerente> listGerente    ) 
	{
		Gerente gerente = new Gerente();
        System.out.println("codigo gerente 1 : " +  codigoGerente);
		for( Gerente gerenteParam: listGerente  ){
			if(gerenteParam.getCodigoRegistro().equalsIgnoreCase(codigoGerente)){
				gerente = gerenteParam;
				break;	
			}
		}
		return gerente;
	}
	
}
