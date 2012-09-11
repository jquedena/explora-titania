package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.LogueoForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;



public class AccesoAction extends DispatchAction {
	private static Logger log = Logger.getLogger(AccesoAction.class);
	
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		LogueoForm logueoForm = (LogueoForm) form;
		Connection conexion = new Connection();
		Vector listMenu = null;
		PermisoPerfil permisoPerfil = null;
		forward = mapping.findForward("ok");
		IILDPeUsuario user = null;
		String usuario = ""; 
		String mensaje = "Intentelo Nuevamente!!!";
		File f = null;
		String carpetaArchivo = null; 
		String nombreArchivo = null;
		String errorBD = "";
		HttpSession sesion = null; 
		Gestor gestor = null;
		
		try {	
			log.info("[AccesoAction :: execute] Inicio");
			
			errorBD = conexion.testearBD();
			if(errorBD != null) {
				throw new Exception("ErrorBD");
			}
			
			if(request.getSession(false) != null) {
				request.getSession(false).invalidate();
			}
			
			sesion = request.getSession(true);
			
			synchronized(sesion) {
					ServiciosSeguridadBbva ssBbva = new ServiciosSeguridadBbva(request);
					if (ssBbva != null) {
						try{
							ssBbva.obtener_ID();
							usuario  =  ssBbva.getUsuario().toUpperCase();
							log.info("[LogueoAction :: execute] Usuario:" + usuario.toUpperCase());
						}
						catch(Exception e){
							try{
								usuario = logueoForm.getUsuario().toUpperCase();
							}
							catch(Exception e2){
							}
						}
					}
						
					user = IILDPeUsuario.recuperarUsuario(usuario);	
						
					if (user != null) {
						permisoPerfil = conexion.findPermisoPerfilxTipAccxValorRCP(usuario, user.getCargo().getCodigo(), "");
						log.info("[AccesoAction :: execute] CARGO USUARIO "+user.getCargo().getCodigo());
					
						String ruta = ((Multitabla)conexion.findByCodMulti("T10").elementAt(0)).getValor1();
				        String txtFinal = ruta + "bienvenida_final.txt";
				        
				        String texto = "";
				        
				        // Leyendo de el archivo Texto
				        FileReader in = null;
						BufferedReader bufIng = null;
						
						in = new FileReader(txtFinal);
						bufIng = new BufferedReader(in);
						StringBuffer textoSF = new StringBuffer();
				        int c;
				        
				        while ((c = bufIng.read()) != -1)
				        	textoSF.append((char)c);
				        
				        bufIng.close();
				        in.close();
				        texto = textoSF.toString();
				        
				        sesion.setAttribute("msg",texto);
				        carpetaArchivo = ((Multitabla)conexion.findByCodMulti("T10").elementAt(0)).getValor1()+ File.separator;
				        
				        nombreArchivo = conexion.nombreImagen(Connection.IMAGEN_PRINCIPAL); 
				        f = new File(carpetaArchivo + nombreArchivo);					
						if(f.exists()) {
							String rutaIMG = ((Multitabla) conexion.findByCodMulti("T10").elementAt(0)).getValor1();
							sesion.setAttribute("archivoBienvenida", rutaIMG+nombreArchivo);
						}else{
							sesion.setAttribute("archivoBienvenida", "");
						}
						
						if (user.getCargo() == null){
							request.setAttribute("txtError", "Usuario no Tiene c" + (char) 243 + "digo de cargo asignado.");
							mensaje = "Usuario no Tiene c" + (char) 243 + "digo de cargo asignado.";
							sesion.setAttribute("mensaje", mensaje);
							forward = mapping.findForward("error");
							return (forward);
						}
						
						gestor = buscarGestor(usuario);
							
						if (gestor == null || gestor.getCodigoPerfil() == null || gestor.getCodigoPerfil().length() == 0){
							request.setAttribute("txtError", "Usuario no Tiene permisos necesarios.");
							mensaje = "Usuario no Tiene permisos necesarios.";
							sesion.setAttribute("mensaje", mensaje);
							forward = mapping.findForward("error");
							return (forward);
						}
						
						Oficina oficinaActual = conexion.findByCodOficina(gestor.getCodigoOficina());
						if (oficinaActual == null){
							request.setAttribute("txtError", "Usted no tiene oficina asignada en el Sistema.");
							mensaje = "Usted no tiene oficina asignada en el Sistema.";
							sesion.setAttribute("mensaje", mensaje);
							forward = mapping.findForward("error");
							return (forward);
						}					
						
						Territorio territorioActual = conexion.findByCodTerritorio(oficinaActual.getTerr() != null ? oficinaActual.getTerr().getCodTerr() : "-1");
						if (territorioActual == null){
							request.setAttribute("txtError", "Usted no tiene territorio asignado en el Sistema.");
							mensaje = "Usted no tiene territorio asignado en el Sistema.";
							sesion.setAttribute("mensaje", mensaje);;
							forward = mapping.findForward("error");
							return (forward);
						}
						
						if(gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")){
							if(gestor.getCodigoOficina() == null) {
								request.setAttribute("txtError", "Usted no tiene territorio asignado en el Sistema.");
								mensaje = "Usted no tiene territorio asignado en el Sistema.";
								sesion.setAttribute("mensaje", mensaje);;
								forward = mapping.findForward("error");
								return (forward);
							}
						}
						
					if (permisoPerfil != null) {
						sesion.setAttribute("acceso", permisoPerfil.getCodPerfil());
		
						listMenu = conexion.findxCodPerfil(permisoPerfil.getCodPerfil());
						
						gestor.setCodigoPerfil(permisoPerfil.getCodPerfil());
						sesion.setAttribute("gestor", gestor);						
						sesion.setAttribute("listaAccesoMenu", listMenu);
						
						Connection cnx = new Connection();
						
						Territorio terr = cnx.findTerritorioByCodOficina(user.getBancoOficina().getCodigo());
			        	String nomTerritorio = "";		        	
			        	if(terr != null && terr.getNomTerr() != null) {
			        		nomTerritorio = terr.getNomTerr();	        		
			        	}
		
			        	// 201206053 - Por validacion de perfiles
			        	int ultimo = cnx.nuevoIngreso(String.valueOf(cnx.busID_IngresoMax()+1),usuario,gestor.getPerfilMostrar(),nomTerritorio, user.getBancoOficina().getCodigo(), gestor.getNombreGestor());
			        	sesion.setAttribute("idIngresoUsuario", new Integer(ultimo));		    	        	
					} else {
						if(gestor == null || gestor.getCodigoPerfil() == null  || gestor.getCodigoPerfil().length() == 0) {
							mensaje = "Usuario no tiene privilegio!!!";
							sesion.setAttribute("mensaje", mensaje);
							forward = mapping.findForward("error");				
							request.setAttribute("txtError", "Usuario no Tiene Permiso Para acceder al Sistema.");
						} else {	
							sesion.setAttribute("acceso", gestor.getCodigoPerfil());
							
							listMenu = conexion.findxCodPerfil(gestor.getCodigoPerfil());
							
							sesion.setAttribute("gestor", gestor);						
							sesion.setAttribute("listaAccesoMenu", listMenu);
							
							Connection cnx = new Connection();
							
							Territorio terr = cnx.findTerritorioByCodOficina(user.getBancoOficina().getCodigo());
				        	String nomTerritorio = "";		        	
				        	if(terr != null && terr.getNomTerr() != null) {
				        		nomTerritorio = terr.getNomTerr();	        		
				        	}
						
				        	// 201206053 - Por validacion de perfiles
				        	int ultimo = cnx.nuevoIngreso(String.valueOf(cnx.busID_IngresoMax()+1),usuario,gestor.getPerfilMostrar(), nomTerritorio, user.getBancoOficina().getCodigo(), gestor.getNombreGestor());
				        	sesion.setAttribute("idIngresoUsuario", new Integer(ultimo));
						}
					}
				} else {
					mensaje = "Usuario no Existe";
					sesion.setAttribute("mensaje", mensaje);
					forward = mapping.findForward("error");				
					request.setAttribute("txtError", "Usuario no Existe");
				}			
			}
			
			log.info("[AccesoAction :: execute] Fin");
		} catch (Exception e) {
			log.error("[AccesoAction :: execute] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			if(errorBD != null) {
				errors.add("name", new ActionError("id"));
				forward = mapping.findForward("error");				
				request.setAttribute("txtError", "Intentelo Nuevamente!!! 12505");				
			} else {
				errors.add("name", new ActionError("id"));
				sesion.setAttribute("mensaje", mensaje);
				forward = mapping.findForward("error");		
			}
		}
		
		return (forward);

	}
	
	public Gestor buscarGestor(String codigoUsuario) {
		Gestor gestor = null;
		Connection conexion = new Connection();
		
		try {
			log.info("[AccesoAction :: buscarGestor] Inicio");
			
			IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(codigoUsuario);
			String NombreGestor = user.getNombre() + " " + user.getApellido1() + " " + user.getApellido2();				
			NombreGestor = NombreGestor.toUpperCase();
			String codigoCargo = user.getCargo().getCodigo();
			Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(codigoCargo);
			
			if (equivalencia != null && equivalencia.getCodPerfil() != null) {
				String codigoPerfil = equivalencia.getCodPerfil();
				String perfilMostrar = equivalencia.getPerfil();
				String codigoOficina = null;
				String nombreOficina = "";
				Territorio territorio = null;
				
				Oficina oficina = null; 
				oficina = conexion.findByCodOficinaHija(user.getBancoOficina().getCodigo());
				if(oficina == null || oficina.getCodOfic() == null) {
					oficina = conexion.findByCodOficina(user.getBancoOficina().getCodigo());
				} 							
				
				String codTerritorio = ""; 
				if(oficina != null) {
					if(oficina.getCodOfic() != null) {
						codigoOficina = oficina.getCodOfic();
					}
					
					if(oficina.getNomOficina() != null) {
						nombreOficina = oficina.getNomOficina();
					}
					
					territorio = oficina.getTerr();
					if(territorio != null) {
						codTerritorio = territorio.getCodTerr();  
					}
				}
				
				
				gestor = new Gestor();
				gestor.setCodigoGestor(codigoUsuario);
				gestor.setPasswordGestor("");
				gestor.setNombreGestor(NombreGestor);
				gestor.setCodigoPerfil(codigoPerfil);
				gestor.setPerfilMostrar(perfilMostrar);
				gestor.setCodigoOficina(codigoOficina);				
				gestor.setNombreOficina(nombreOficina);
				gestor.setCodigoTerritorio(codTerritorio);
			}
			
			log.info("[AccesoAction :: buscarGestor] Fin");
		} catch (IILDPeExcepcion e) {
			log.error("[AccesoAction :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[AccesoAction :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return gestor;
	}
}