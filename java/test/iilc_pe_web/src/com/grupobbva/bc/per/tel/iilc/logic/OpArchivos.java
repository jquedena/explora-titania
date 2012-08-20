/*
 * Created on 06/02/2008
 */
package com.grupobbva.bc.per.tel.iilc.logic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.log4j.Logger;


import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;

/**
 * @author P020795
 * 
 */
public class OpArchivos {

	private static Logger logger = Logger.getLogger(OpArchivos.class);
	public static final int BUFFER_SIZE = 1000000;
	private static String path;
	
	public static void decompresion(InputStream inputStream) {
		try {
			// Create a ZipInputStream to read the zip file
			BufferedOutputStream dest = null;
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(inputStream));
			// Loop over all of the entries in the zip file
			int count;
			byte data[] = new byte[BUFFER_SIZE];
			ZipEntry entry;
			ConexionDAO conexion = new ConexionDAO();
			path = conexion.findRecord(Constantes.PATH).getValor1().trim()+ "/temp/descarga.txt";
			while ((entry = zis.getNextEntry()) != null) {
				if (!entry.isDirectory()) {
					String entryName = entry.getName();
					// Write the file to the file system
					FileOutputStream fos = new FileOutputStream(path);
					dest = new BufferedOutputStream(fos, BUFFER_SIZE);
					while ((count = zis.read(data, 0, BUFFER_SIZE)) != -1) {
						dest.write(data, 0, count);
					}
					dest.flush();
					dest.close();
				}
			}
			zis.close();
		} catch (Exception e) {
			logger.error("Error al descomprimir el archivo " + path );
		}
	}
	
	public boolean borrar(String rutaArchivo) {
		boolean respuesta = false;
		try {
		    File file = new File(rutaArchivo);
		    if (!(file.isDirectory()))
		        respuesta = file.delete();

		} catch (Exception e) {
			logger.error("Error al eliminar el archivo " +rutaArchivo );
		}
		return respuesta;
	}
	/**
	 * @return Returns the path.
	 */
	public static String getPath() {
		return path;
	}
	/**
	 * @param path The path to set.
	 */
	public static void setPath(String path) {
		OpArchivos.path = path;
	}
}
