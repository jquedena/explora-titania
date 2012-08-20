package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionEJB;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanMantenimiento;
import com.grupobbva.bc.per.tel.iilc.logic.CargaATOG;
import com.grupobbva.bc.per.tel.iilc.logic.CargaLC;
import com.grupobbva.bc.per.tel.iilc.logic.OpArchivos;
import com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

/**
 * @version 	1.0
 * @author
 */
public class CargaMasivaAction extends DispatchAction

{

	static Logger logger = Logger.getLogger(CargaMasivaAction.class);
    public ActionForward carga(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionErrors errors = new ActionErrors();
        FormBeanMantenimiento formBeanMantenimiento = (FormBeanMantenimiento) form;

        try {
        	InputStream archivo = formBeanMantenimiento.getArchivo().getInputStream();
        	if (formBeanMantenimiento.getArchivo().getFileName().endsWith(".zip")){
        		OpArchivos.decompresion(archivo);
        		archivo = new FileInputStream(OpArchivos.getPath());
        	}
        	char tipo = formBeanMantenimiento.getTipo().charAt(0);
        	String mensaje =null;
        	
        	switch (tipo){
        		case 'C':
        			CargaLC cargaLC = new CargaLC();
                	cargaLC.setIsarchivo(archivo);
        	        if (cargaLC.isEstado()){
        		        if (cargaLC.cargaMasiva()){
        		        	mensaje = "El archivo ha sido procesado\n" +
			        		        	"-Registros leidos    : " + cargaLC.getRegistros_leidos() + "\n" +
			        		        	" Tipo1:" + cargaLC.getRegistros1_leidos() + " | " +
			        		        	" Tipo2:" + cargaLC.getRegistros2_leidos() + " | " +
			        		        	" Tipo3:" + cargaLC.getRegistros3_leidos() + " | " +
			        		        	" Tipo4:" + cargaLC.getRegistros4_leidos() + " | " +
			        		        	" Tipo5:" + cargaLC.getRegistros5_leidos() + " | " +
			        		        	" Tipo6:" + cargaLC.getRegistros6_leidos() + " | " +
			        		        	" Tipo7:" + cargaLC.getRegistros7_leidos() + "\n" +
										"-Clientes insertados : " + cargaLC.getClientes_insertados() + "\n" +
										"-Totales insertados  : " + cargaLC.getTotales_insertados();
        		        	if (cargaLC.getRegistros_leidos() == cargaLC.getClientes_insertados() + cargaLC.getTotales_insertados()){
        		        		mensaje = mensaje + "\nOperaci" + (char) 243 + "n Exitosa";
        		        	}
        		        }else mensaje = "El archivo es inv" + (char) 225 + "lido";
        	        }else mensaje = "No se pudo realizar la carga masiva";
        			break;
                default:
                    CargaATOG cargaATOG = new CargaATOG(tipo);
                    cargaATOG.setIsarchivo(archivo);
                    if(cargaATOG.isEstado()){
                        if(cargaATOG.cargaMasiva())
                            switch(tipo){
                            	case Constantes.AREA:
	                    			mensaje = "El archivo se cargo con &eacute;xito\n-Registros leidos    : " + cargaATOG.getRegistros_leidos() + "\n-Areas insertadas : " + cargaATOG.getAreas_insertados();
	                                if(cargaATOG.getRegistros_leidos() == cargaATOG.getAreas_insertados())
	                                    mensaje = mensaje + "\nOperaci&oacute;n Exitosa";
	                                break;
                            	case Constantes.TERRITORIO:
                                    mensaje = "El archivo se cargo con &eacute;xito\n-Registros leidos    : " + cargaATOG.getRegistros_leidos() + "\n-Territorios insertados : " + cargaATOG.getTerritorios_insertados();
                                    if(cargaATOG.getRegistros_leidos() == cargaATOG.getTerritorios_insertados())
                                        mensaje = mensaje + "\nOperaci&oacute;n Exitosa";
                                    break;
                            	case Constantes.OFICINA:
                                    mensaje = "El archivo se cargo con &eacute;xito\n-Registros leidos    : " + cargaATOG.getRegistros_leidos() + "\n-Oficinas insertadas : " + cargaATOG.getOficinas_insertados();
                                    if(cargaATOG.getRegistros_leidos() == cargaATOG.getOficinas_insertados())
                                        mensaje = mensaje + "\nOperaci&oacute;n Exitosa";
                                    break;
                            	case Constantes.GESTOR:
	                                mensaje = "El archivo se cargo con &eacute;xito\n-Registros leidos    : " + cargaATOG.getRegistros_leidos() + "\n-Gestores insertados : " + cargaATOG.getGestores_insertados();
	                                if(cargaATOG.getRegistros_leidos() == cargaATOG.getGestores_insertados())
	                                    mensaje = mensaje + "\nOperaci&oacute;n Exitosa";
	                                break;
                            	case Constantes.EMPRESA:
	                                mensaje = "El archivo se cargo con &eacute;xito\n-Registros leidos    : " + cargaATOG.getRegistros_leidos() + "\n-Gestores insertados : " + cargaATOG.getEmpresas_insertadas();
	                                if(cargaATOG.getRegistros_leidos() == cargaATOG.getGestores_insertados())
	                                    mensaje = mensaje + "\nOperaci&oacute;n Exitosa";
	                                break;
                            }
                        else mensaje = "El archivo es inv&aacute;lido";
                    } else mensaje = "No se pudo realizar la carga masiva";
                    break;
        	}
        	
        	formBeanMantenimiento.setMensaje(mensaje);
        	logger.info(mensaje);
        	logger.info("Termino la carga");
        } catch (Exception e) {
        	e.printStackTrace();
            // Report the error using the appropriate name and ID.
            errors.add("name", new ActionError("id"));
        }

        // If a message is required, save the specified key(s)
        // into the request for use by the <struts:errors> tag.

        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        } 
        // Finish with
        return mapping.findForward(Constantes.FW_CARGA_MASIVA);
    }
    
    
    

	@SuppressWarnings("unchecked")
	public ActionForward descargaLog(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		ConexionDAO con = new ConexionDAO();

    	String file="";
    	String path = con.findRecord(Constantes.PATH).getValor1().trim()+"uploads"+File.separator; 
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        { 
	        	file="log_error.txt";
	        	archivoNuevo(path, file);
	        	fichero = new FileWriter(path+file);
	            List lista=con.listarLogErrorLConduc(); 
	            pw = new PrintWriter(fichero);

	            for(int i = 0;i<lista.size();i++){
	            	 pw.println(lista.get(i));
	    		} 
	            pw.close();
	            fichero.close();
	            
	            request.setAttribute("origenVinculacion", "111");		
				request.getSession().setAttribute(Constantes.EXPORTACION_ARCHIVO, file);
				request.getSession().setAttribute(Constantes.EXPORTACION_RUTA, path);
								
	        }catch(Exception e){
	        	e.printStackTrace();
	        } 
	       
	        return mapping.findForward("descarga");
	}

    
    public ActionForward estadoCargaCliente(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionErrors errors = new ActionErrors();
        ConexionEJB ejb = new ConexionEJB();
        ConexionDAO con = new ConexionDAO();
        try {
        	EstadoCarga bean = ejb.ultimoEstadoCarga();
        	Multitabla config = con.findRecord("T00CARGA0");
        	StringBuffer desc = new StringBuffer("Carga ");
        	String dias = config.getValor1();
        	boolean flag = false;
        	
        	if(dias.equals("0000000"))
        		desc.append("no programada");
        	else{
        		desc.append("programada los ");
        		for(int i=0; i<6; i++){
        			if(dias.substring(i,i+1).equals("1")){
        				if(flag)
        					desc.append(", ");
        				desc.append(Utilitario.litDiaSemana(i,true));
        				flag = true;
        			}
        		}
        		desc.append(" a las " + config.getValor2() + ":" + config.getValor3() + " horas.");
        	}
        	
        	request.setAttribute("descCarga",desc.toString());
        	request.setAttribute("bean",bean);
        	
        	
        	        	
        	
        } catch (Exception e) {
        	e.printStackTrace();
            // Report the error using the appropriate name and ID.
            errors.add("name", new ActionError("id"));

        }

        // If a message is required, save the specified key(s)
        // into the request for use by the <struts:errors> tag.

        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        } 
        // Finish with
        return mapping.findForward(Constantes.FW_ESTADO_CARGA);
    }


    private boolean archivoNuevo(String ruta, String nombre) {
		log.info("[ExportObject :: archivoNuevo] inicio");
		boolean res = false;
		try {
			File f = new File(ruta, nombre);
			f.createNewFile();
			f = null;
		} catch (Throwable e) {
			e.printStackTrace();
			log.info("[ExportObject :: archivoNuevo] error");
			log.info("[ExportObject :: archivoNuevo] " + e.getMessage());
		}
		log.info("[ExportObject :: archivoNuevo] fin");
		return res;
	}

}