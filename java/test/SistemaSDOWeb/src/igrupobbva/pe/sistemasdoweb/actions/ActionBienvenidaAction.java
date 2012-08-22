package igrupobbva.pe.sistemasdoweb.actions;

import igrupobbva.pe.sistemasdoweb.forms.BienvenidaForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

public class ActionBienvenidaAction extends Action {
	private static Logger log = Logger.getLogger(ActionBienvenidaAction.class);
	
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		String accion = request.getParameter("accion");
		String textoIn = request.getParameter("texto");
		Connection cnx = new Connection();
		HttpSession sesion = null;
		
		try {
			log.info("[ActionBienvenidaAction :: execute] Inicio");
			
			sesion = request.getSession(false);
			Gestor gestor = (Gestor)sesion.getAttribute("gestor");
			ProgSeguimiento bus = new ProgSeguimiento();
			bus.setCodTerritorio(gestor.getCodigoTerritorio());
			bus.setAnio(0);
			bus.setMes("0");
			ProgSeguimiento seg = cnx.findProgTerritorio(bus);
			
			if(seg != null) {
				log.info(seg.getSeg1Fin());
				log.info(seg.getSeg2Fin());
				String mensajeVencimiento = "<b>Proximos Venciminentos<br/>"
					+ "1er. Cierre : "
					+ seg.getSeg1Fin()
					+ "<br/>"
					+ "2do. Cierre : "
					+ seg.getSeg2Fin()
					+ "</b>";
				request.setAttribute("mensajeVencimientos", mensajeVencimiento);
			} else {
				log.info("No cargo la fechas de seguimiento");
			}
			
			String ruta = ((Multitabla) cnx.findByCodMulti("T10").elementAt(0)).getValor1();
			String txtFinal = ruta + "bienvenida_final.txt";
			String txtPreview = ruta + "bienvenida_preview.txt";
			String cRutaFile = request.getParameter("txtRuta");
			String texto;
			String nombreArchivo = null;
			String carpetaArchivo = null;
			String rutaArchivo = null;
			FileOutputStream archivo = null;
			File f = null;
		
			if (accion == null)
				accion = "";
			if (textoIn == null)
				textoIn = "";
			if (cRutaFile == null)
				cRutaFile = "";

			// Mostrar pagina inicial
			if (accion.equals("")) {
				texto = leerArchivo(txtFinal);
				
				// Mensaje Territorial
				Vector lista = null;
				ListabusAllTerritorio bean = null;
				String mensajeTerritorio = ""; 
				String colorFondo = "#ffffff";
				
				lista = cnx.busTerritorioxCod(gestor.getCodigoTerritorio());
				if(lista != null && lista.size() > 0) {
    				bean = (ListabusAllTerritorio)lista.get(0);
    				
    				mensajeTerritorio = bean.getMensaje() != null ? bean.getMensaje() : "";
    				colorFondo = bean.getColorFondo();
    			}
				
				request.setAttribute("mensajeTerritorio", mensajeTerritorio);
				request.setAttribute("colorFondo", colorFondo);
				
				request.setAttribute("msg", texto.toString());
				forward = mapping.findForward("ok_preview");
			}

			BienvenidaForm frmBienvenida = (BienvenidaForm) form;
			
			// Guardar texto e imagen editados
			if (accion.equals("G")) {
				FormFile file = frmBienvenida.getFileInput();
				carpetaArchivo = ruta + File.separator;
				log.info(carpetaArchivo);
				String nombreArchivoActual = cnx.nombreImagen(Connection.IMAGEN_PRINCIPAL);
				

				guardarArchivo(txtFinal, textoIn);
				guardarArchivo(txtPreview, textoIn);
				textoIn = textoIn.replaceAll("&", "&amp;");
				request.setAttribute("msg", textoIn);
				
				if (file != null) {
					log.error("Formato del Archivo a cargar: " + file.getContentType().trim());
					log.warn("Formatos Soportados.");
					log.warn(ConstantesUtil.SWS_IMAGEN_JPG);
					log.warn("image/jpeg");
					if (file.getContentType().trim().equalsIgnoreCase(ConstantesUtil.SWS_IMAGEN_JPG) || file.getContentType().trim().equalsIgnoreCase("image/jpeg")){						
						f = new File(carpetaArchivo + nombreArchivoActual);
						if(f.exists()) {
							f.delete();
						}
						
						if (file.getFileSize() > 0) {						
							nombreArchivoActual = Connection.FORMATTER.format(new Date()) + ".jpg";
							f = new File(carpetaArchivo + nombreArchivoActual);
							archivo = new FileOutputStream(f);
							archivo.write(file.getFileData());
							archivo.flush();
							archivo.close();
							
							cnx.actualizaImagen(nombreArchivoActual, Connection.IMAGEN_PRINCIPAL);
							request.setAttribute("alerta", ConstantesUtil.MENSAJE_EXITO);
						}
					} else {
						request.setAttribute("alerta", "Solo se aceptan imagenes en formato jpg. , vuelva a cargar la imagen y grabe.");
					}
				} else {
					String nombreArchivoPrevio = cnx.nombreImagen(Connection.IMAGEN_PREVIA);
					File origen = new File(carpetaArchivo + nombreArchivoPrevio);
			        try{
			              FileChannel in = (new FileInputStream(origen)).getChannel();
			              FileChannel out = (new FileOutputStream(f)).getChannel();
			              in.transferTo(0, origen.length(), out);
			              in.close();
			              out.close();
			              request.setAttribute("alerta", ConstantesUtil.MENSAJE_EXITO);
			        }
			        catch(Exception e){
			            ConstantesUtil.mostrarMensajeExcepcion(e);
			        }
				}
				
				sesion.setAttribute("archivoBienvenida", carpetaArchivo+nombreArchivo);

				forward = mapping.findForward("ok_mostrar");
			}

			// Vista previa
			if (accion.equals("P")) {
				// Ahora en la carpeta de imagenes 
				String carpetaDisco = ruta + File.separator;
				String nombreArchivoDisco = cnx.nombreImagen(Connection.IMAGEN_PREVIA);
				
				File fileDisco = new File(carpetaDisco + nombreArchivoDisco);
				if(fileDisco.exists()) {
					fileDisco.delete();
				}
				
				FormFile file = frmBienvenida.getFileInput();
				if (file != null) {
					if (file.getContentType().trim().equalsIgnoreCase(ConstantesUtil.SWS_IMAGEN_JPG) || file.getContentType().trim().equalsIgnoreCase("image/jpeg")){
						FileOutputStream archivoDisco = null;
						try {
							nombreArchivoDisco = Connection.FORMATTER.format(new Date()) + ".jpg";
							
							fileDisco = new File(carpetaDisco + nombreArchivoDisco);
							archivoDisco= new FileOutputStream(fileDisco);
							archivoDisco.write(file.getFileData());
							archivoDisco.flush();
							archivoDisco.close();
							cnx.actualizaImagen(nombreArchivoDisco, Connection.IMAGEN_PREVIA);
						} catch(Exception e) {
							e.printStackTrace();
						}
						
						guardarArchivo(txtPreview, textoIn);
						request.setAttribute("msg", textoIn);
						request.setAttribute("preview", "1");
						sesion.setAttribute("rutaArchivo", rutaArchivo);
						sesion.setAttribute("archivoBienvenida", carpetaDisco+nombreArchivoDisco);
						forward = mapping.findForward("ok_preview");
					} else {
						request.setAttribute("msg", textoIn);
						request.setAttribute("preview", "1");
						sesion.setAttribute("rutaArchivo", rutaArchivo);
						sesion.setAttribute("archivoBienvenida", carpetaDisco+nombreArchivoDisco);
						request.setAttribute("alerta", "Solo se aceptan imagenes en formato jpg. Vuelva a cargar la imagen.");
						forward = mapping.findForward("ok_mostrar");
					}
				} else {
					request.setAttribute("msg", textoIn);
					request.setAttribute("preview", "1");
					sesion.setAttribute("rutaArchivo", rutaArchivo);
					sesion.setAttribute("archivoBienvenida", carpetaDisco+nombreArchivoDisco);
					request.setAttribute("alerta", "Seleccione una imagen.");
					forward = mapping.findForward("ok_mostrar");
				}
			}

			// Iniciar editor
			if (accion.equals("E")) {
				nuevoPreview(txtFinal, txtPreview);
				accion = "E2";
			}

			// Retornar de vista previa
			if (accion.equals("E2")) {
				texto = leerArchivo(txtPreview);
				texto = texto.replaceAll("&", "&amp;");
				request.setAttribute("msg", texto);
				sesion.removeAttribute("visitaBienvenida");
				forward = mapping.findForward("ok_mostrar");
			}
			
			log.info("[ActionBienvenidaAction :: execute] Fin");
		} catch (Exception e) {
			request.setAttribute("alerta", ConstantesUtil.MENSAJE_ERROR);
			log.error("[ActionBienvenidaAction :: execute] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			errors.add("name", new ActionError("id"));
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		} else {
		}

		return (forward);
	}

	private void nuevoPreview(String txtFinal, String txtPreview)
			throws IOException {
		
		log.info("[ActionBienvenidaAction :: nuevoPreview] Inicio");
		
		File inputFile = new File(txtFinal);
		File outputFile = new File(txtPreview);

		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		int c;

		while ((c = in.read()) != -1)
			out.write(c);

		in.close();
		out.close();
		
		log.info("[ActionBienvenidaAction :: nuevoPreview] Fin");
	}

	private void guardarArchivo(String ruta, String datos) throws IOException {
		log.info("[ActionBienvenidaAction :: guardarArchivo] Inicio");
		
		FileWriter t_FileWriter = new FileWriter(ruta);
		t_FileWriter.write(datos);
		t_FileWriter.close();
		
		log.info("[ActionBienvenidaAction :: guardarArchivo] Fin");
	}

	private String leerArchivo(String ruta) throws IOException {
		FileReader in = null;
		BufferedReader bufIng = null;
		
		log.info("[ActionBienvenidaAction :: leerArchivo] Inicio");
		
		in = new FileReader(ruta);
		bufIng = new BufferedReader(in);
		StringBuffer texto = new StringBuffer();
		int c;
		while ((c = bufIng.read()) != -1)
			texto.append((char) c);
		bufIng.close();
		in.close();
		
		log.info("[ActionBienvenidaAction :: leerArchivo] Fin");
		
		return texto.toString();
	}
}