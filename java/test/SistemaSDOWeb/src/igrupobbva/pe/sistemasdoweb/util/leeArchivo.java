/*
 * Created on 05/06/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;


/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


public class leeArchivo {
	private static Logger log = Logger.getLogger(leeArchivo.class);
	
	public boolean grabaArchivoTexto(String ruta, String datos) throws IOException{
		try{
			log.info("[leeArchivo :: grabaArchivoTexto] Inicio");
			
			FileWriter t_FileWriter = new FileWriter(ruta);
			t_FileWriter.write(datos);
			t_FileWriter.close();
			
			log.info("[leeArchivo :: grabaArchivoTexto] Fin");
			
			return true;
		} catch (Exception e) {
			log.error("[leeArchivo :: grabaArchivoTexto] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
            return false;
        }
    }
    
    public String leerArchivoTexto(String ruta) throws IOException{
    	FileReader in = null;
		BufferedReader bufIng = null;
		
		log.info("[leeArchivo :: leerArchivoTexto] Inicio");
		
		in = new FileReader(ruta);
		bufIng = new BufferedReader(in);
		StringBuffer texto = new StringBuffer();
        int c;
        while ((c = bufIng.read()) != -1)
        	texto.append((char)c);
        bufIng.close();
        in.close();
        
        log.info("[leeArchivo :: leerArchivoTexto] Fin");
        
        return texto.toString();
    }
}
