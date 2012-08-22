package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.LogueoForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.Date;
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

@SuppressWarnings({"unused", "unchecked"})
public class LogueoAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(LogueoAction.class);
	
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
		Calendar calendario = Calendar.getInstance();
		Date fecha = calendario.getTime();
		File f = null;
		String carpetaArchivo = null; 
		String nombreArchivo = null;
		String errorBD = "";
		HttpSession sesion = null; 
		Gestor gestor = null;
		Oficina oficinaActual = null;
		
		
		try {			
				log.info("[LogueoAction :: execute] Inicio");
			
				errorBD = conexion.testearBD();
				if(errorBD != null) {
					throw new Exception("ErrorBD");
				}
				
				if(request.getSession(false) != null) {
					request.getSession(false).invalidate();
				}
				
				sesion = request.getSession(true);
				
				synchronized(sesion) {				
					usuario = logueoForm.getUsuario().toUpperCase();
					user = IILDPeUsuario.recuperarUsuario(usuario.toUpperCase());
					log.info("[LogueoAction :: execute] Usuario:" + usuario.toUpperCase());	
					
					if (user != null) {
						/*-sesion.setAttribute("codOficina", user.getBancoOficina().getCodigo());
						sesion.setAttribute("desOficina", user.getBancoOficina().getDescripcion());
						sesion.setAttribute("registro", usuario);
						sesion.setAttribute(								"nombre",
								user.getNombre() + " " + user.getApellido1() + " "
										+ user.getApellido2());					
						*/ 
						
						permisoPerfil = conexion.findPermisoPerfilxTipAccxValorRCP(usuario, user
								.getCargo().getCodigo(), "");
						log.info("[LogueoAction :: execute] Cargo Usuario " + user.getCargo().getCodigo());						
						
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
				        
				        // Consulta Imagen de bienvenida de Ruta Dentro del Sistema
				        carpetaArchivo = getServlet().getServletContext().getRealPath("images")+ File.separator;
				        
				        nombreArchivo = "bienvenida1.jpg"; 
				        f = new File(carpetaArchivo + nombreArchivo);					
						if(!f.exists()) {
							nombreArchivo = "bienvenida2.jpg"; 
					        f = new File(carpetaArchivo + nombreArchivo);
					        if(!f.exists()) {
					        	String carpetaImagenes = ((Multitabla)conexion.findByCodMulti("T10").elementAt(0)).getValor1() + File.separator;
					        	nombreArchivo = "bienvenida.jpg";
					        	
				        		// copiar
					        	FileInputStream fis = new FileInputStream(carpetaImagenes + nombreArchivo); 
					        	FileOutputStream fos = new FileOutputStream(carpetaArchivo + nombreArchivo);				        		
				                FileChannel canalFuente = fis.getChannel(); 
				                FileChannel canalDestino = fos.getChannel(); 
				                canalFuente.transferTo(0, canalFuente.size(), canalDestino); 
				                fis.close(); 
				                fos.close(); 
					        }
						}					
						
						sesion.setAttribute("archivoBienvenida", nombreArchivo);
				        
						if (user.getCargo() == null){
							request.setAttribute("txtError", "Usuario no Tiene c" + (char) 243 + "digo de cargo asignado.");
							forward = mapping.findForward("login");	
						}
						 gestor = buscarGestor(usuario);
							
						if (gestor == null || gestor.getCodigoPerfil() == null){
							request.setAttribute("txtError", "Usuario no Tiene permisos necesarios.");
							forward = mapping.findForward("login");
						}
						
						oficinaActual = conexion.findByCodOficina(gestor.getCodigoOficina());						
						
						if (oficinaActual == null){
							request.setAttribute("txtError", "Usted no tiene oficina asignada en el Sistema.");
							forward = mapping.findForward("login");
						}					
						
						Territorio territorioActual = conexion.findByCodTerritorio(oficinaActual.getTerr() != null ? oficinaActual.getTerr().getCodTerr() : "-1");
						if (territorioActual == null){
							request.setAttribute("txtError", "Usted no tiene territorio asignado en el Sistema.");
							forward = mapping.findForward("login");
						}
						
						if(gestor.getCodigoPerfil().equals("GTE") || gestor.getCodigoPerfil().equals("JPR")){
							if(gestor.getCodigoOficina() == null) {
								request.setAttribute("txtError", "Usted no tiene territorio asignado en el Sistema.");
								forward = mapping.findForward("login");
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
			        	int ultimo = cnx.nuevoIngreso(String.valueOf(cnx.busID_IngresoMax()+1),usuario,gestor.getPerfilMostrar(), nomTerritorio, user.getBancoOficina().getCodigo(), gestor.getNombreGestor());
			        	sesion.setAttribute("idIngresoUsuario", new Integer(ultimo));		        	
					} else {
						if(gestor == null || gestor.getCodigoPerfil() == null) {
							forward = mapping.findForward("login");				
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
					forward = mapping.findForward("login");				
					request.setAttribute("txtError", "Usuario no Existe");
				}						
			}		
				
			log.info("[LogueoAction :: execute] Fin");	
		} catch (Exception e) {
			log.error("[LogueoAction :: execute] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			if(errorBD != null) {
				forward = mapping.findForward("login");				
				request.setAttribute("txtError", "Intentelo Nuevamente!!! 12505");
				errors.add("name", new ActionError("id"));
			} else {
				String mensaje = e.getMessage();
				errors.add("name", new ActionError("id"));
				forward = mapping.findForward("login");
			}
		}
		
		return (forward);

	}
	
	public Gestor buscarGestor(String codigoUsuario) {
		Gestor gestor = null;
		Connection conexion = new Connection();
		
		try {
			log.info("[LogueoAction :: buscarGestor] Inicio");	
			
			IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(codigoUsuario);
			String NombreGestor = user.getNombre() + " " + user.getApellido1() + " "
				+ user.getApellido2();				
			NombreGestor = NombreGestor.toUpperCase();
			String codigoCargo = user.getCargo().getCodigo();
			Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(codigoCargo);
			
			if (equivalencia != null && equivalencia.getCodPerfil() != null) {
				String codigoPerfil = equivalencia.getCodPerfil();
				
				/*String codigoTerritorio = user.getBancoOficina().getCodigo();
				String codigoOficina = codigoTerritorio;
				Oficina oficina = null;				4
				
				if(codigoTerritorio != null && !codigoTerritorio.equals("")) {
					if(codigoTerritorio.substring(0,1).equals("0")) {
						codigoTerritorio = "3" + codigoTerritorio.substring(1, codigoTerritorio.length()); 
					}
				} 
				
				Territorio territorio =  conexion.findByCodTerritorio(codigoTerritorio);
				String newCodTerritorio = "";				
				
				if (territorio != null && territorio.getCodTerr() != null) {
					newCodTerritorio = territorio.getCodTerr();
					codigoOficina = "";
				} else {
					oficina = conexion.findByCodOficina(codigoOficina);
					
					if (oficina != null && oficina.getTerr() != null) {
						newCodTerritorio = oficina.getTerr().getCodTerr();						
					}
				}*/				
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
				
				gestor.setCodigoOficina(codigoOficina);				
				gestor.setNombreOficina(nombreOficina);
				gestor.setCodigoTerritorio(codTerritorio);
			}
			
			log.info("[LogueoAction :: buscarGestor] Fin");
		} catch (IILDPeExcepcion e) {
			log.error("[LogueoAction :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[LogueoAction :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return gestor;
	}
}