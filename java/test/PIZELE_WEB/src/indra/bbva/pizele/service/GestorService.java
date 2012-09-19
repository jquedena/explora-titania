package indra.bbva.pizele.service;

import indra.bbva.iiwx.domain.base.LDAPPERU2;
import indra.bbva.pizele.domain.base.Gestor;
import indra.bbva.pizele.domain.base.Oficina;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class GestorService 
{

	private static final int GESTORES = 0;
	private static final int GESTORES_SIN_SUBGERENTE = 1;
	
	@Resource
	private LDAPPERU2Service ldapperu2service;
	
	@Resource
	private OficinaService oficinaService;

	private void agregarGestor(List<Gestor> gestores, int tipoBusqueda, String codigoOficina, boolean hija) {
		List<LDAPPERU2> listaLDAP = null;
		
		if(tipoBusqueda == GestorService.GESTORES) {
			listaLDAP = ldapperu2service.obtenerListaDatosUsuario(codigoOficina);
		} else if(tipoBusqueda == GestorService.GESTORES_SIN_SUBGERENTE) {
			listaLDAP = ldapperu2service.obtenerListaDatosUsuarioSinSubGerente(codigoOficina);
		}
		
		if(listaLDAP != null) {
			for (LDAPPERU2 ldapperu2 : listaLDAP) {
				Gestor gestor = new Gestor();
				gestor.setCodigoRegistro(ldapperu2.getCodusu());
				gestor.setNombre(ldapperu2.getNombre());
				gestor.setApellidoPaterno(ldapperu2.getApepat());
				gestor.setApellidoMaterno(ldapperu2.getApemat());
				gestor.setPerfil(ldapperu2.getPerfil());
				gestor.setPerfilID(ldapperu2.getPerfilID());
				gestor.setOficinaHija(hija ? "*" : "");
				gestores.add(gestor);
			}	
		}
	}
	
	public List<Gestor> listarGestorOficina(String codigoOficina) 
	{
				
		List<Gestor> listaGestor = new ArrayList<Gestor>();
		List<Oficina> oficinasHijas = oficinaService.listarOficinasHijas(codigoOficina);
		
		agregarGestor(listaGestor, GestorService.GESTORES, codigoOficina, false);
		if(oficinasHijas != null && oficinasHijas.size() > 0) {
			for(Oficina o : oficinasHijas) {
				agregarGestor(listaGestor, GestorService.GESTORES, o.getCodigo(), true);
			}
		}
		
		return listaGestor;
	}
	
	public List<Gestor> listarGestorOficinaSinSubGerente(String codigoOficina) 
	{
		List<Gestor> listaGestor = new ArrayList<Gestor>();
		List<Oficina> oficinasHijas = oficinaService.listarOficinasHijas(codigoOficina);
		
		agregarGestor(listaGestor, GestorService.GESTORES_SIN_SUBGERENTE, codigoOficina, false);
		if(oficinasHijas != null && oficinasHijas.size() > 0) {
			for(Oficina o : oficinasHijas) {
				agregarGestor(listaGestor, GestorService.GESTORES_SIN_SUBGERENTE, o.getCodigo(), true);
			}
		}
		
		return listaGestor;
	}
	
	public Gestor obtenerGestor(String codigoGestor, List<Gestor>  listaGestorBackup ) 
	{
		Gestor gestor= new Gestor(); 
	

		for( Gestor gestorParam: listaGestorBackup  ){
			if(gestorParam.getCodigoRegistro().equalsIgnoreCase(codigoGestor)){
				gestor = gestorParam;
				break;	
			}
		}
		return gestor;
	}

	public LDAPPERU2 obtenerGOF(String codofi) {
		return ldapperu2service.obtenerGOF(codofi);
	}
}
