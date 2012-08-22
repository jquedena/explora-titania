package com.grupobbva.bc.per.tele.sdo.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 * @author user
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public final class Especial {
	private static Logger log = Logger.getLogger(Especial.class);
	/**
	 * Constructor for Especial.
	 */
	public Especial() {
		super();
	}
	
	public String formatoDecimal(BigDecimal number){
		log.info("[Especial :: formatoDecimal] Inicio");
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("###.##",dfs);
		
		log.info("[Especial :: inicioPerfil] Fin");
		return df.format(number);
	}

	public String respetaCeros(BigDecimal number){
		log.info("[Especial :: respetaCeros] Inicio");
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("###.00",dfs);
		
		log.info("[Especial :: respetaCeros] Fin");
		return df.format(number);
	}

	public String formatoDecimal2(BigDecimal number){
		log.info("[Especial :: formatoDecimal2] Inicio");
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("###.####",dfs);
		
		log.info("[Especial :: formatoDecimal2] Fin");
		return df.format(number);
	}
	
	public String formatoDecimal3(BigDecimal number){
		log.info("[Especial :: formatoDecimal3] Inicio");
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');		
		DecimalFormat df = new DecimalFormat("#######.##",dfs);
		
		log.info("[Especial :: formatoDecimal3] Fin");
		return df.format(number);
	}
	
	public String formatoEntero(BigDecimal number){
		log.info("[Especial :: formatoEntero] Inicio");
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("###",dfs);
		
		log.info("[Especial :: formatoEntero] Fin");
		return df.format(number);
	}

	public String formatoMiles(BigDecimal number){
		log.info("[Especial :: formatoMiles] Inicio");
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("###,###",dfs);
		
		log.info("[Especial :: formatoMiles] Fin");
		return df.format(number);
	}
	
	public static String eliminarComa(String numero){
   		String nuevoNumero = numero;
   		int indice = numero.indexOf(",");
   			
   		try {
   			log.info("[Especial :: eliminarComa] Inicio");
   			
	   	 	if(indice > 0) {
	   	 		nuevoNumero =  numero.substring(0, indice) + numero.substring(indice + 1, numero.length() - 1) ;
	   	 		
	   	 		indice = nuevoNumero.indexOf(",");
	   	 		if(indice > 0) {
	   	 			nuevoNumero =  nuevoNumero.substring(0, indice) + nuevoNumero.substring(indice + 1, nuevoNumero.length() - 1);
	   	 		}
	   	 	}
	   	 log.info("[Especial :: eliminarComa] Fin");
   		} catch(Exception e) {
   			log.error("[Especial :: eliminarComa] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
   		}
   		
   	 	return nuevoNumero;
	}
	
	public boolean esMesyAnioActual(String mes,  String anio){
		boolean resp = false;
		Calendar calendario= Calendar.getInstance();
		
		try {
			log.info("[Especial :: esMesyAnioActual] Inicio");
			
			int mesActual = calendario.get(Calendar.MONTH);
			int anioActual = calendario.get(Calendar.YEAR);			
			
			if(mes != null && anio == null) {
				if(mesActual == Integer.parseInt(mes) && anioActual == Integer.parseInt(anio)) {
					resp = true;
				}
			}
			
			log.info("[Especial :: esMesyAnioActual] Fin");
		} catch(Exception e) {
			log.error("[Especial :: esMesyAnioActual] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return resp;
	}
	
	public static String formatearMontoVista(String monto){
		String resulMonto = ""; 
		
		try{
			log.info("[Especial :: formatearMontoVista] Inicio");
			
			DecimalFormatSymbols dec_f = new DecimalFormatSymbols();
			DecimalFormat f = new DecimalFormat("#########.##");
			
			f.setDecimalFormatSymbols(dec_f);
			f.setDecimalSeparatorAlwaysShown(false);
			f.setGroupingUsed(true);
			f.setGroupingSize(3);
			
			resulMonto = f.format(Double.parseDouble(monto));
			
			log.info("[Especial :: formatearMontoVista] Fin");
		}catch(Exception e){			
			log.error("[Especial :: formatearMontoVista] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
			
		return resulMonto;
	}
}
