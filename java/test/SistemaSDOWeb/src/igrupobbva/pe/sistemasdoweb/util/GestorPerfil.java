/*
 * Created on 29-abr-2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.util;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;


public class GestorPerfil {
	private static Logger log = Logger.getLogger(GestorPerfil.class);
	
	public Gestor buscarGestor(String codigoUsuario) {
		Gestor gestor = null;
		Connection conexion = new Connection();
		
		try {
			log.info("[GestorPerfil :: buscarGestor] Inicio");
			
			String NombreGestor;
			IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(codigoUsuario);
			
			try{
				NombreGestor = user.getNombreCompleto();
			} catch(Exception e){
				log.info("Error al recuperar ");
				NombreGestor = "No se pudo recuperar el nombre";
			}
			
			String codigoCargo = user.getCargo().getCodigo();
			Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(codigoCargo);
			if (equivalencia != null) {
				String codigoPerfil = equivalencia.getCodPerfil();
				String perfilMostrar = equivalencia.getPerfil();
				String codigoOficina = user.getBancoOficina().getCodigo();
				Oficina oficina = conexion.findByCodOficina(codigoOficina);
				String codigoTerritorio = "";
				if (oficina != null && oficina.getTerr() != null) {
					codigoTerritorio = oficina.getTerr().getCodTerr();
				}
				gestor = new Gestor();
				gestor.setCodigoGestor(codigoUsuario);
				gestor.setPasswordGestor("");
				gestor.setNombreGestor(NombreGestor);
				gestor.setCodigoPerfil(codigoPerfil);
				gestor.setPerfilMostrar(perfilMostrar);
				gestor.setCodigoOficina(codigoOficina);
				gestor.setCodigoTerritorio(codigoTerritorio);
			}
			
			log.info("[GestorPerfil :: buscarGestor] Fin");
		} catch (IILDPeExcepcion e) {
			log.error("[GestorPerfil :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		catch (Exception e) {
			log.error("[GestorPerfil :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return gestor;
	}
}
