package com.indra.pe.bbva.reauni.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.exception.DAOException;

public class Testing {
	
	private static Logger logger = Logger.getLogger(Testing.class);
	
	public static void main(String[] a) throws DAOException {
		File f = new File("formato.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);	
			fw.write(formatoCorreoEvaluacion());
			fw.close();
			
			copiarArchivoHD(new File("c:/plano2.txt"),f);
			
		} catch (IOException e) {
			logger.error("Error en utilitario " + e.getMessage());
		}	 
	}
	
	 public static void copiarArchivoHD(File archivoDestino, File archivoOrigen) {
         FileOutputStream fos;
         try {
             fos = new FileOutputStream(archivoDestino);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             FileInputStream isr = new FileInputStream(archivoOrigen);
             BufferedInputStream bis = new BufferedInputStream(isr);
             int i;
             while ((i = bis.read()) != -1) {
                 bos.write(i);
             }
             isr.close();
             bis.close();
             bos.close();
             bos.flush();
         } catch (FileNotFoundException e) {
             logger.error("Error en utilitario ", e);
         } catch (IOException e) {
             logger.error("Error en utilitario ", e);
         }
     }

	public static String formatoCorreoEvaluacion(){
		String cambioLinea = "\n";
		String mensaje = "" +
				"=======================================================================================================" + cambioLinea + 
				"|  									Solicitud de Reasignación/Unifiación						   |" +cambioLinea +
				"=======================================================================================================" +cambioLinea +
				"|												     												   |" +cambioLinea +
				"| Tipo Sol          : " + "xxxxxxx"+"           Cod.Solicitud: "+ "xxxxxxx"+"    Fecha Registro: "+"xxxxxxx"+"  |" +cambioLinea +
				"| Cod.Cliente       : " + "xxxxxxx" + "               Nombre       : " + "xxxxxxx" + "        Segmento: " + "xxxxxxx"+ " |" +cambioLinea +
				"| Estado Trámite    : En Defición            Desde        : 17/12/2010                                |" +cambioLinea +
				"| Centro Solicitante: " + "xxxxxxx" + "					                                   |" +cambioLinea +
				"| Resp.Solicitante  : " + "xxxxxxx" + "						          					   |" +cambioLinea +
				"|     Total Activo  : S/" + "xxxxxxx"+ "                Total Pasivo: S/" + "xxxxxxx" + "				      			   |" +cambioLinea +
				"|												     												   |" +cambioLinea +
				"|=====================================================================================================|" +cambioLinea +
				"| INGRESO DE DATOS:										      									   |" +cambioLinea +
				"| =================										      									   |" +cambioLinea +
				"| Territorio(*)                         : " + "xxxxxxx" + " - " + "xxxxxxx" + "					      					   |" +cambioLinea +
				"| Oficina Receptora de los Contratos(*) : " + "xxxxxxx" + "					      				   |" +cambioLinea +
				"| Gestor Receptor(*)                    : " + "xxxxxxx" + " " + "xxxxxxx" + " " + "xxxxxxx"+ "			      		   |" +cambioLinea +
				"|=====================================================================================================|" +cambioLinea +
				"| Ajustes [x]:											      										   |" +cambioLinea +
				"| [x] (*)Forma Grupo Económico         [ ] (*)Ventas último ejercicio Anual Sunat > 2.8 MM            |" +cambioLinea +
				"| [ ] Otros: _________________ 									      							   |" +cambioLinea +
				"|												      												   |" +cambioLinea +
				"| Motivo del Traslado(*): [x] Sírvace ejecutar  [ ]Otros:_______________                              |" +cambioLinea +
				"|=====================================================================================================|" +cambioLinea +
				"|CONTRATOS A SEGMENTAR:                                                                               |" +cambioLinea +
				"|=========================================================================================================================================|" + cambioLinea +
				"| EST. SEG.|EST. FILE|OF.PROP|GES. CEDE.|OF.RECE|GES. RECE|C.PROD. |CONTRATOS PRÉST|F.APER. |IMPORTE      |MON|NPLA SIT|DETALLE SITUACION |" ;
				
						
		return mensaje;
	}
	
}
