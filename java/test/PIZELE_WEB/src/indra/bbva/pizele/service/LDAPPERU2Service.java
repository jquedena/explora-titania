package indra.bbva.pizele.service;

import indra.bbva.iiwx.domain.base.LDAPPERU2;
import indra.bbva.pizele.domain.base.Gestor;
import indra.bbva.pizele.persistence.LDAPPERU2Persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LDAPPERU2Service {
   
	@Resource
	@Qualifier("ldapPeru2PersistenceImpl")
	private LDAPPERU2Persistence ldapPeru2PersistenceImpl;
		
	@SuppressWarnings("unchecked")
	public List<LDAPPERU2> obtenerListaDatosUsuario(String cod_ofic)
	{
		List<LDAPPERU2> listaLDAP = (List<LDAPPERU2>) ldapPeru2PersistenceImpl.obtenerDatosUsuario(cod_ofic);
		return listaLDAP;
	}
	
	@SuppressWarnings("unchecked")
	public List<LDAPPERU2> obtenerListaDatosUsuarioSinSubGerente(String cod_ofic)
	{
		List<LDAPPERU2> listaLDAP = (List<LDAPPERU2>) ldapPeru2PersistenceImpl.obtenerDatosUsuarioSinSubGerente(cod_ofic);
		return listaLDAP;
	}
	
	public Gestor fn_ObtenerDatosUsuario(String codusu, String codofi) {
		Gestor gestor = new Gestor();

		List<LDAPPERU2> listaLDAP = obtenerListaDatosUsuario(codofi); 
		
		for (LDAPPERU2 ldapperu2 : listaLDAP) {
			if (ldapperu2.getCodusu().equalsIgnoreCase(codusu)) {
				gestor.setNombre(ldapperu2.getNombre());
				gestor.setApellidoPaterno(ldapperu2.getApepat());
				gestor.setApellidoMaterno(ldapperu2.getApemat());
				gestor.setCodigoRegistro(ldapperu2.getCodusu());
				gestor.setCargo(ldapperu2.getCargo());
				gestor.setPerfil(ldapperu2.getPerfil());
				gestor.setPerfilID(ldapperu2.getPerfilID());
				break;
			}
		}
		return gestor;
	}

	public Gestor fn_ObtenerDatosUsuarioSinSubGerente(String codusu, String codofi) {
		Gestor gestor = new Gestor();
		
		List<LDAPPERU2> listaLDAP = obtenerListaDatosUsuarioSinSubGerente(codofi); 
		
		for (LDAPPERU2 ldapperu2 : listaLDAP) {
			if (ldapperu2.getCodusu().equalsIgnoreCase(codusu)) {
				gestor.setNombre(ldapperu2.getNombre());
				gestor.setApellidoPaterno(ldapperu2.getApepat());
				gestor.setApellidoMaterno(ldapperu2.getApemat());
				gestor.setCodigoRegistro(ldapperu2.getCodusu());
				gestor.setCargo(ldapperu2.getCargo());
				gestor.setPerfil(ldapperu2.getPerfil());
				gestor.setPerfilID(ldapperu2.getPerfilID());
				break;
			}
		}
		return gestor;
	}
	
	@SuppressWarnings("unchecked")
	public List<LDAPPERU2> obtenerListaDatosGerente(String cod_ofic)
	{
		
		List<LDAPPERU2> listaLDAP = (List<LDAPPERU2>) ldapPeru2PersistenceImpl.obtenerDatosGerente(cod_ofic);
		return listaLDAP;
	}
	
	public LDAPPERU2 obtenerGOF(String codofi) {
		return ldapPeru2PersistenceImpl.obtenerGOF(codofi);
	}
}