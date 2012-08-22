package com.grupobbva.bc.per.tele.sdo.util;

/**
 * Nombre	   : ConstantesUtil.java  
 * Version     : 1.0	
 * Creacion    : 25/11/2008
 * Autor       : Carlos Chau.
 * Usuario     : P020912
 * Finalidad   : Unifica la llamada de todos los sessions de modo que este se llame en la parte web.
 * Modificacion: << fecha de modificacion>>
 * Autor       : <<quien actualizo el archivo>>
 * Usuario     : <<codigo de usuario modificador>>
 * Detalle     : <<descripcion de la modificacion>>
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.serializable.ExportacionTabla;

@SuppressWarnings({"unchecked", "unused"})
public class ConstantesUtil  {
	private static Logger log = Logger.getLogger(ConstantesUtil.class);
	private static final String DATE_TIME_FORMAT="dd/MM/yyyy HH:mm:ss";
	private static final String DATE_FORMAT="dd/MM/yyyy";
	private static final String DATE_FORMAT2="yyyyMMdd";
	
    public static final String SEPARADOR_CODIGOS = "-";
    public static final String SEPARADOR_ARROBA = "@";
    public static final String TXT = "T01TXT";
    public static final String LOG = "T01LOGS";
    public static final String CIS = "T01CIS";
    public static final String INPUT = "T01IN";
	public static final String PARAM_ACCION = "accion";
	public static final String PARAM_REGEMP = "regemp";
	public static final String PARAM_RES = "res";
	public static final String DATOSLOGIN = "datosLogin";
    
    public static final String SEG_ACTUALIZAR_NUM_GEST = "1";
    public static final String SEG_ACTUALIZAR_NUM_CONCR = "2";
    public static final String SEG_ACTUALIZAR_NUM_MONTO = "3";   
    public static final String ERROR_SISTEMA = "ERROR SDO";
    public static final String MENSAJE_SISTEMA = "MENSAJE SDO";
    public static final String MENSAJE_EXITO_GENERICO = "La operacion se realizo en forma satisfactoria.";
    public static final String MENSAJE_ERROR_GENERICO = "La operacion no se realizo en forma satisfactoria.";
    public static final String MENSAJE_EXITO_GENERICO2 = "La operaci&oacute;n se realiz&oacute; en forma satisfactoria.";
    public static final String MENSAJE_ERROR_GENERICO2 = "La operaci&oacute;n no se realiz&oacute; en forma satisfactoria.";
    public static final String MENSAJE_ERROR_EXISTE_REGISTRO = "Error, el registro ya sido insertado anteriormente.";
    public static final String MENSAJE_ERROR_CODIGO_EXISTE = "Error, el registro con ese codigo ya sido insertado anteriormente.";
    public static final String MENSAJE_ERROR_CODIGO_EXISTE_OFIC = "Error, el registro con ese codigo es el mismo de una oficina padre.";
    public static final String MENSAJE_ERROR_CODIGO_EXISTE2 = "Error, el registro con ese c&oacute;digo ya sido insertado anteriormente.";
    public static final String MENSAJE_ERROR_CODIGO_EXISTE_OFIC2 = "Error, el registro con ese c&oacute;digo es el mismo de una oficina padre.";
    public static final String MENSAJE_ERROR_SESION_TERMINO = "La sesi&oacute;n ha expirado. Por favor, vuelva a ingresar al sistema.";
    
    public static final String MENSAJE_EXITO = "Se actualiz\u00F3 con \u00E9xito.";
    public static final String MENSAJE_ERROR = "Error al actualizar.";
    
    public static final String SWS_IMAGEN_JPG = "image/pjpeg";
    public static final String SWS_IMAGEN_GIF = "image/gif";
    
    public static final String OFICINA_ESTADO_ACTIVO="1";
    public static final String OFICINA_ESTADO_INACTIVO="0";
    
    
    /**
	  * Metodo que convierte una fecha en formato date a formato dd/mm/yyyy
	  * @param date fecha que se quiere convertir.
	  * @return Retorna la fecha en formato dd/mm/yyyy.
	  * @throws ParseException Dispara la excepcion si ocurre.
	  */
	 public static String intToString(String date) {
	 		log.info("[ConstantesUtil :: intToString] Inicio");
	 	
			String anho= date.substring(0,4);
			String mes= date.substring(4,6);
			String dia= date.substring(6,8);
			String fecha=dia+"-"+mes+"-"+anho; 
		    
			log.info("[ConstantesUtil :: intToString] Fin");
			return fecha;
	 } 
	 
	 public static String estatura(String size) {	
	 	log.info("[ConstantesUtil :: estatura] Inicio");
	 	
	 	if(size.trim()!=""){
	 		String m= size.substring(0,1);
			String c= size.substring(1,3);
			size=m+"."+c;	       
	    } 
	 	log.info("[ConstantesUtil :: estatura] Fin");
	 	
	 	return size;
	 }
	 
  public static String estadoCivil(String eCivil) {	
	 	String civil="";
	 	
	 	try{	 		
	 		log.info("[ConstantesUtil :: estadoCivil] Inicio");
	 		
		 	if(eCivil.trim()!=""){
		 		if(eCivil.equals("1")) civil="Soltero";
		 		if(eCivil.equals("2")) civil="Casado";
		 		if(eCivil.equals("3")) civil="Viudo";
		 		if(eCivil.equals("4")) civil="Divorsiado";	 	      
		    } 
		 	
		 	log.info("[ConstantesUtil :: estadoCivil] Fin");
	 	}catch(Exception e){
	 		log.error("[ConstantesUtil :: estadoCivil] ");
	 		ConstantesUtil.mostrarMensajeExcepcion(e);
	 		
	 		civil="";
	 	}
	 	 return civil;
	 }
  public static String sexo(String sexo) {	
 	String rta="";
 	
 	try{		
 		log.info("[ConstantesUtil :: sexo] Inicio");
	 		
 		if(sexo.equals("1")) rta="Masculino";	 		
 		if(sexo.equals("2")) rta="Femenino";
	 	
 		log.info("[ConstantesUtil :: sexo] Fin");	
 	}catch(Exception e){
 		log.error("[ConstantesUtil :: sexo] ");
 		ConstantesUtil.mostrarMensajeExcepcion(e);
 		rta="";
 	}
 	 return rta;
 }

  
  public static String gradoInst(String gradoI) {	
 	String grado="";
 	
 	try{
 		log.info("[ConstantesUtil :: gradoInst] Inicio");
 		
 		gradoI=gradoI.substring(0,1);
 		
	 	if(gradoI.trim()!=""){
	 		if(gradoI.equals("1")) grado="Primaria";
	 		else if(gradoI.equals("2")) grado="Secundaria";
	 		else if(gradoI.equals("3")) grado="Superior";
	 		else if(gradoI.equals("4")) grado="Iletrado";
	 		else if(gradoI.equals("5")) grado="T" + (char) 233 + "cnica";
	 		else if(gradoI.equals("6")) grado="Especial";
	 		else grado="";
	    } 
	 	
	 	log.info("[ConstantesUtil :: gradoInst] Fin");
 	}catch(Exception e){
 		log.error("[ConstantesUtil :: gradoInst] ");
 		ConstantesUtil.mostrarMensajeExcepcion(e);
 		
 		grado="";
 	}
 	 return grado;
 }
  public static String estado(String estado) {	
 	String est="";
 	
 	try{	 		
 		log.info("[ConstantesUtil :: estado] Inicio");
 		
 		if(estado.equals(" ")) est="Activo";
	 		else if(estado.equals("1")) est="Activo";
	 		else if(estado.equals("6")) est="Activo";
	 		else if(estado.equals("0")) est="INCAPACIDAD MENTAL";
	 		else if(estado.equals("2")) est="Presenta Restricciones de acuerdo al articulo 33" + (char) 176 + " Constituci" + (char) 243 + "n Pol" + (char) 237 + "tica del Per" + (char) 250 + " ";
	 		else if(estado.equals(")")) est="DNI S/VIG. EXT. DEL DOM Y ESTCIV";
	 		else if(estado.equals("{")) est="DNI S/VIG. EN EL EXT. DEL DOMIC";
	 		else if(estado.equals("}")) est="DNI S/VIG. EN EL EXT. DEL ESTCIV";
	 		else if(estado.equals("A")) est="Fallecimiento";
	 		else if(estado.equals("R")) est="RENUNCIA A LA NACIONAL PERUANA";	 		
	 		else est="";
	   
 		log.info("[ConstantesUtil :: estado] Fin");
 	}catch(Exception e){
 		log.error("[ConstantesUtil :: estado] ");
 		ConstantesUtil.mostrarMensajeExcepcion(e);
 		
 		est="";
 	}
 	 return est;
 }
  
  public static String votacion(String votacion) {	
 	String rta="";
 	
 	try{
 		log.info("[ConstantesUtil :: votacion] Inicio");
 		
 		if(votacion.equals(" ")) rta="Sugrag" + (char) 243;
 		if(votacion.equals("N")) rta="No Sugrag" + (char) 243;
 		
 		log.info("[ConstantesUtil :: votacion] Fin");
 	}catch(Exception e){
 		log.error("[ConstantesUtil :: votacion] ");
 		ConstantesUtil.mostrarMensajeExcepcion(e);
 		
 		rta="";
 	}
 	 return rta;
 }
  public static String anioEstudios(String anioE) {	
 	String rta="";
 	
 	try{
 		log.info("[ConstantesUtil :: anioEstudios] Inicio");
 		
 		if(anioE.equals("0"))
 			{
 			rta="Completo";
 			}
 		else{
 			rta =anioE+" A" + (char) 241 + "os";
 			}	
 		
 		log.info("[ConstantesUtil :: anioEstudios] Fin");
 	}catch(Exception e){
 		log.error("[ConstantesUtil :: anioEstudios] ");
 		ConstantesUtil.mostrarMensajeExcepcion(e);
 		
 		rta="";
 	}
 	 return rta;
 }
  
  public static String anioEstudiosAM(String anioE) {	
 
 	try{
 		log.info("[ConstantesUtil :: anioEstudiosAM] Inicio");
 		
 		if(anioE.equals("0"))
 			{
 			anioE="Completo";
 			} 		
 		
 		log.info("[ConstantesUtil :: anioEstudiosAM] Fin");
 	}catch(Exception e){
 		log.error("[ConstantesUtil :: anioEstudiosAM] ");
 		ConstantesUtil.mostrarMensajeExcepcion(e);
 		
 		anioE="";
 	}
 	 return anioE;
 }
  public static String docSustentatorio(String doc) {	
  	 
  	 	try{
  	 		log.info("[ConstantesUtil :: docSustentatorio] Inicio");
  	 		
  	 		doc=doc.substring(1,doc.length());
  	 		
  	 		log.info("[ConstantesUtil :: docSustentatorio] Fin");
  	 	}catch(Exception e){
  	 		log.error("[ConstantesUtil :: docSustentatorio] ");
  	 		ConstantesUtil.mostrarMensajeExcepcion(e);	
  	 		
  	 		doc="";
  	 	}
  	 	 return doc;
  	 }

  /**
   * Metodo que permite Completar espacios en blanco y ceros.	
   * @param longMax Longitud Maxima de la cadena.
   * @param cadena cadena que requieres de espacios en blanco.
   * @return space String quee contiene ceros y espacios en blanco.
   */ 
  	 public static String completarSpace(String cadena,int longMax)
  	 {
  		 /** Space in White**/	
  		 String space="";
  		 
  		log.info("[ConstantesUtil :: completarSpace] Fin");
  		 
  		 for(int i=0;i<longMax;i++)
  		 {
  			space=" "+space; 			 
  		 }
  		 space=cadena+space.substring(0,longMax-cadena.length());
  		 
  		log.info("[ConstantesUtil :: completarSpace] Fin");
  		 
  		 return space;
  		 
  	 }
  	 
  	 //	OSCAR CORTEZ - CONSTANTES
    public static final String DATASOURCE_CONTEXT = "jdbc/IIDO";
  	public static final String DATASOURCE_LDAP = "jdbc/ORA_Biiwx001";
  	public static final String DATASOURCE_CONTEXT_ANTIGUO = "jdbc/IIGO";
  	public static final String ESTADO_PROCESO_ACTIVO="0";
  	public static final String ESTADO_PROCESO_OK="1";  	
  	// FIN - OSCAR CORTEZ - CONSTANTES    	 
   	 public String litMes(int mes){
		String res = "";
		
		log.info("[ConstantesUtil :: litMes] Inicio");
		
		switch(mes){
			case 1:  res = "Enero";		break;
			case 2:  res = "Febrero";	break;
			case 3:  res = "Marzo";		break;
			case 4:  res = "Abril";		break;
			case 5:  res = "Mayo";		break;
			case 6:  res = "Junio";		break;
			case 7:  res = "Julio";		break;
			case 8:  res = "Agosto";	break;
			case 9:  res = "Setiembre";	break;
			case 10: res = "Octubre";	break;
			case 11: res = "Noviembre";	break;
			case 12: res = "Diciembre";	break;
		}
		
		log.info("[ConstantesUtil :: litMes] Fin");
		
		return res;
	  }
    	
   	 public static String dosCeros(int i){
   	 	String str = "" + i;
   	 	if(str.length()<2)
   	 		return "0" + str;
   	 	else
   	 		return str;
	}
   	 
   	public String eliminarComa(String numero){
   		String nuevoNumero = numero;
   		
   		try {
   			log.info("[ConstantesUtil :: eliminarComa] Inicio");
   			
   			int indice = numero.indexOf(",");
   			
	   	 	if(indice > 0) {
	   	 		nuevoNumero =  numero.substring(0, indice) + numero.substring(indice, numero.length() - 1) ;  
	   	 	}
	   	 	
	   	 log.info("[ConstantesUtil :: eliminarComa] Fin");
   		} catch(Exception e) {
   			log.error("[ConstantesUtil :: eliminarComa] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
   		}
   		
   	 	return nuevoNumero;
	}
    
    public static String formatearFechaString(String fecha) {
    	String nuevaFecha = "";
    	
     	try{
     		log.info("[ConstantesUtil :: formatearFechaString] Inicio");
     		
     		if(fecha != null) {
     			nuevaFecha = 	fecha.substring(8, 10) + "/" +
								fecha.substring(5, 7) + "/" +
								fecha.substring(0, 4);
     		}     		
     		
     		log.info("[ConstantesUtil :: formatearFechaString] Fin");
     	 }catch(Exception e){
     	 	log.error("[ConstantesUtil :: formatearFechaString] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
     	 }
     	 
     	 return nuevaFecha;
   }
    
    public static String formatearFechaString2(String fecha) {
    	String nuevaFecha = "";
    	
     	try{
     		log.info("[ConstantesUtil :: formatearFechaString2] Inicio");
     		
     		if(fecha != null) {
     			nuevaFecha = 	fecha.substring(6, 8) + "/" +
								fecha.substring(4, 6) + "/" +
								fecha.substring(0, 4);
     		}     		
     		
     		log.info("[ConstantesUtil :: formatearFechaString2] Fin");
     	 }catch(Exception e){
     	 	log.error("[ConstantesUtil :: formatearFechaString2] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
     	 }
     	 
     	 return nuevaFecha;
   }
    
    public static java.util.Calendar parseDate(String strFecha){
		SimpleDateFormat sdf = null;  
		int dia = 0;
		int mes = 0;
		int anio = 0;
		java.util.Calendar dateFecha = null; 
		
		try{
			log.info("[ConstantesUtil :: parseDate] Inicio");
			
			sdf = new SimpleDateFormat(DATE_FORMAT);			
			
			dia = Integer.parseInt(strFecha.substring(0, 2));
			mes = Integer.parseInt(strFecha.substring(3, 5));
			anio = Integer.parseInt(strFecha.substring(6, 10));
			
			dateFecha = GregorianCalendar.getInstance();
			dateFecha.set(anio, mes - 1, dia, 0, 0, 0);		
			
			log.info("[ConstantesUtil :: parseDate] Fin");
		}catch(Exception e){
			log.error("[ConstantesUtil :: parseDate] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return dateFecha;
	} 
    
    public static String parseCalendarToString(Calendar calendar){
    	String fechaString = null;
    	Date fechaDate = null;
    	
		try{
			log.info("[ConstantesUtil :: parseCalendarToString] Inicio");
			
			fechaString = parseSQLString(calendar.getTime());
			
			log.info("[ConstantesUtil :: parseCalendarToString] Fin");
		}catch(Exception e){
			log.error("[ConstantesUtil :: parseCalendarToString] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return fechaString;
	} 
    
    public static String parseSQLString(java.util.Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String fecha = null;

		try{
			log.info("[ConstantesUtil :: parseSQLString] Inicio");
			
			fecha = sdf.format(date);
			
			log.info("[ConstantesUtil :: parseSQLString] Fin");
		}catch(Exception e){
			log.error("[ConstantesUtil :: parseSQLString] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}			
		
		return fecha;
	}	
    
    public static boolean equalsDate(Calendar fecha1, Calendar fecha2){
    	boolean resp = false;
    	
		try{
			log.info("[ConstantesUtil :: equalsDate] Inicio");
			
			if(	(fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR)) &&
				(fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH)) &&
				(fecha1.get(Calendar.DATE) == fecha2.get(Calendar.DATE))
				)	{
				resp = true;
			}
			
			log.info("[ConstantesUtil :: equalsDate] Fin");
		}catch(Exception e){
			log.error("[ConstantesUtil :: equalsDate] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}			
		
		return resp;
	}	
    
    public static String getAnioActual(){
    	String strAnio = "";
    	int intAnio = 0;
		java.util.Calendar fechaActual = null;
		
		try {
			log.info("[ConstantesUtil :: getAnioActual] Inicio");
			
			fechaActual = GregorianCalendar.getInstance();
			intAnio = fechaActual.get(Calendar.YEAR);
			if(intAnio < 10) {
				strAnio = "0" + String.valueOf(intAnio);
			} else {
				strAnio = String.valueOf(intAnio);
			}
			
			log.info("[ConstantesUtil :: getAnioActual] Fin");
		} catch(Exception e) {
			log.error("[ConstantesUtil :: getAnioActual] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return strAnio;
	} 
    
    public static String getMesActual(){
    	String strMes = "";
    	int intMes = 0;
		java.util.Calendar fechaActual = null;
		
		try {
			log.info("[ConstantesUtil :: getMesActual] Inicio");
			
			fechaActual = GregorianCalendar.getInstance();
			intMes = fechaActual.get(Calendar.MONTH) + 1;
			if(intMes < 10) {
				strMes = "0" + String.valueOf(intMes);
			} else {
				strMes = String.valueOf(intMes);
			}
			
			log.info("[ConstantesUtil :: getMesActual] Fin");
		} catch(Exception e) {
			log.error("[ConstantesUtil :: getMesActual] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return strMes;
	} 
    
    public static String fechaFormatoAnsi(String fecha){
    	String formatoFecha = "";
		
		try {
			log.info("[ConstantesUtil :: fechaFormatoAnsi] Inicio");
			
			if(fecha != null && !fecha.equals("")) {
				formatoFecha = 	fecha.substring(6, 10) + 
								fecha.substring(3, 5) + 
								fecha.substring(0, 2);
			}			
			
			log.info("[ConstantesUtil :: fechaFormatoAnsi] Fin");
		} catch(Exception e) {
			log.error("[ConstantesUtil :: fechaFormatoAnsi] ");
   			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return formatoFecha;
	}
    
    public static ArrayList diasMesesReporte(int mes, int anio) {
    	ArrayList lista = new ArrayList();
    	Calendar dateFecha = null;
    	Calendar fechaActual = null;
    	int mesActual = -1;
    	int anioActual = -1;
    	int mesSiguiente = -1;
    	int anioSiguiente = -1;
    	int diaSemana = -1;
    	boolean valido = true;
    	
    	try {
    		log.info("[ConstantesUtil :: diasMesesReporte] Inicio");
    		
    		fechaActual = GregorianCalendar.getInstance();
    		
    		mesActual = mes;
        	anioActual = anio;
        	
    		if(mesActual == 12) {
    			mesSiguiente = 1;
    	    	anioSiguiente = anioActual + 1;
    		} else {
    			mesSiguiente = mesActual + 1;
    			anioSiguiente = anioActual;
    		}
        	
    		// mes actual
    		for(int i = 1; i <= 31; i++) {
    			try {
    				dateFecha = GregorianCalendar.getInstance();
    				
    				valido = ConstantesUtil.isFechaValida(i, mesActual, anioActual);
    				if(!valido) {
    					continue;
    				}
    				
    				dateFecha.set(anioActual, mesActual - 1, i, 0, 0, 0);
    				
    				diaSemana = dateFecha.get(Calendar.DAY_OF_WEEK);
    				
    				//if	((diaSemana == Calendar.SATURDAY) || 
    				if(diaSemana == Calendar.SUNDAY){
    					continue;
    				}
    				
    				if(dateFecha.before(fechaActual)) {
    					lista.add(ConstantesUtil.fechaFormatNum(i) + ConstantesUtil.fechaFormatNum(mesActual) + String.valueOf(anioActual));
    					if( (dateFecha.get(Calendar.DATE) == fechaActual.get(Calendar.DATE)) && 
    						(dateFecha.get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH)) &&
    						(dateFecha.get(Calendar.YEAR) == fechaActual.get(Calendar.YEAR)))  {
    						lista.add(ConstantesUtil.fechaFormatNum(i) + ConstantesUtil.fechaFormatNum(mesActual) + String.valueOf(anioActual));
    					}
    				}    				
    			} catch(Exception e) {
    				log.error("[ConstantesUtil :: diasMesesReporte] ");
    	    		ConstantesUtil.mostrarMensajeExcepcion(e);
    			}
    		}
    		
    		// mes siguiente
    		for(int i = 1; i <= 31; i++) {
    			try {
    				dateFecha = GregorianCalendar.getInstance();
    				
    				valido = ConstantesUtil.isFechaValida(i, mesActual, anioActual);
    				if(!valido) {
    					continue;
    				}
    				
    				dateFecha.set(anioSiguiente, mesSiguiente - 1, i, 0, 0, 0);
    				
    				diaSemana = dateFecha.get(Calendar.DAY_OF_WEEK);
    				
    				//if	((diaSemana == Calendar.SATURDAY) || 
    				if(diaSemana == Calendar.SUNDAY){
    					continue;
    				}
    				
    				if(dateFecha.before(fechaActual)) {
    					lista.add(ConstantesUtil.fechaFormatNum(i) + ConstantesUtil.fechaFormatNum(mesSiguiente) + String.valueOf(anioSiguiente));
    				} else {
    					if( (dateFecha.get(Calendar.DATE) == fechaActual.get(Calendar.DATE)) && 
    						(dateFecha.get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH)) &&
    						(dateFecha.get(Calendar.YEAR) == fechaActual.get(Calendar.YEAR)))  {
    						lista.add(ConstantesUtil.fechaFormatNum(i) + ConstantesUtil.fechaFormatNum(mesSiguiente) + String.valueOf(anioSiguiente));
    					}
    				}    				
    			} catch(Exception e) {
    				log.error("[ConstantesUtil :: diasMesesReporte] ");
    	    		ConstantesUtil.mostrarMensajeExcepcion(e);
    			}
    		}
    		
    		//(2011.02.04) Eliminar fechas duplicadas de la lista
    		for(int i=1; i<lista.size(); i++){
    			if(lista.get(i).equals(lista.get(i-1))){
    				lista.remove(i);
    				i--;
    			}
    		}
    		
    		log.info("[ConstantesUtil :: diasMesesReporte] Fin");
    	} catch(Exception e) {
    		log.error("[ConstantesUtil :: diasMesesReporte] ");
    		ConstantesUtil.mostrarMensajeExcepcion(e);
    	}
    	
    	return lista;
    }
    
    public static ArrayList diaReporte(int dia, int mes, int anio) {
    	ArrayList lista = new ArrayList();
    	Calendar dateFecha = null;
    	Calendar fechaActual = null;
    	int diaSemana = -1;
    	boolean valido = true;
    	
    	try {
    		log.info("[ConstantesUtil :: diaReporte] Inicio");
    		
			dateFecha = GregorianCalendar.getInstance();
			valido = ConstantesUtil.isFechaValida(dia, mes, anio);
			
			if(valido) {
    			dateFecha.set(anio, mes - 1, dia, 0, 0, 0);
    			
    			diaSemana = dateFecha.get(Calendar.DAY_OF_WEEK);
				
    			if (diaSemana != Calendar.SUNDAY){
					lista.add(	ConstantesUtil.fechaFormatNum(dia) + 
							ConstantesUtil.fechaFormatNum(mes) + 
							String.valueOf(anio));
				}
			}
				
    		log.info("[ConstantesUtil :: diaReporte] Fin");
    	} catch(Exception e) {
    		log.error("[ConstantesUtil :: diaReporte] ");
    		ConstantesUtil.mostrarMensajeExcepcion(e);
    	}
    	
    	return lista;
    }
    
    public static ArrayList diasMesesReportexAnio(int mes, int anio) {
    	ArrayList lista = new ArrayList();
    	Calendar dateFecha = null;
    	int diaSemana = -1;
    	boolean valido = true;
    	
    	try {
    		log.info("[ConstantesUtil :: diasMesesReportexAnio] Inicio");
    		
    		// mes actual
    		for(int i = 1; i <= 31; i++) {
    			try {
    				dateFecha = GregorianCalendar.getInstance();
    				
    				valido = ConstantesUtil.isFechaValida(i, mes, anio);
    				if(!valido) {
    					continue;
    				}
    				
    				dateFecha.set(anio, mes - 1, i, 0, 0, 0);
    				
    				diaSemana = dateFecha.get(Calendar.DAY_OF_WEEK);
    				
    				//if	((diaSemana == Calendar.SATURDAY) || 
    				if(diaSemana == Calendar.SUNDAY){
    					continue;
    				}
    				
    				lista.add(ConstantesUtil.fechaFormatNum(i) + ConstantesUtil.fechaFormatNum(mes) + String.valueOf(anio));
    				
    				    				
    			} catch(Exception e) {
    				
    			}
    		}
    		
    		log.info("[ConstantesUtil :: diasMesesReportexAnio] Fin");
    	} catch(Exception e) {
    		log.error("[ConstantesUtil :: diasMesesReportexAnio] ");
    		ConstantesUtil.mostrarMensajeExcepcion(e);
    	}
    	
    	return lista;
    }
    
    public static String fechaFormatNum(int diaMes) {
    	String format = "";
    	
    	log.info("[ConstantesUtil :: fechaFormatNum] Inicio");
    	
    	if(diaMes < 10) {
    		format = "0" + String.valueOf(diaMes);
    	} else {
    		format = String.valueOf(diaMes);
    	}
    	
    	log.info("[ConstantesUtil :: fechaFormatNum] Fin");
    	
    	return format;
    } 
    
    public static String fechaFormatText(String diaMes) {
    	String format = "";
    	String dia = "";
    	String mes = "";
    	String anio = "";
    	
    	log.info("[ConstantesUtil :: fechaFormatText] Inicio");
    	
    	if(diaMes != null && diaMes.length() == 4) {
    		dia = diaMes.substring(0, 2);
    		format += dia;
    		
    		mes = diaMes.substring(2, 4);
    		
    		switch(Integer.parseInt(mes)) {
    			case 1:	 	format += "-ene";
    						break; 
    			case 2:	 	format += "-feb"; 
							break;	
    			case 3:	 	format += "-mar"; 
							break;
    			case 4:	 	format += "-abr"; 
							break;			
    			case 5:	 	format += "-may"; 
							break;
    			case 6:	 	format += "-jun"; 
							break;
    			case 7:	 	format += "-jul"; 
							break;			
    			case 8:	 	format += "-ago"; 
							break;
    			case 9:	 	format += "-set"; 
							break;
    			case 10:	format += "-oct"; 
							break;
    			case 11:	format += "-nov"; 
							break;
    			case 12:	format += "-dic"; 
							break;
						
    		}
    	} 
    	
    	if(diaMes != null && diaMes.length() == 8) {
    		dia = diaMes.substring(0, 2);
    		format += dia;
    		
    		mes = diaMes.substring(2, 4);
    		anio = diaMes.substring(4, 8);
    		
    		switch(Integer.parseInt(mes)) {
    			case 1:	 	format += "-ene";
    						break; 
    			case 2:	 	format += "-feb"; 
							break;	
    			case 3:	 	format += "-mar"; 
							break;
    			case 4:	 	format += "-abr"; 
							break;			
    			case 5:	 	format += "-may"; 
							break;
    			case 6:	 	format += "-jun"; 
							break;
    			case 7:	 	format += "-jul"; 
							break;			
    			case 8:	 	format += "-ago"; 
							break;
    			case 9:	 	format += "-set"; 
							break;
    			case 10:	format += "-oct"; 
							break;
    			case 11:	format += "-nov"; 
							break;
    			case 12:	format += "-dic"; 
							break;
						
    		}
    		format += "-" + anio; 
    	} 
    	
    	log.info("[ConstantesUtil :: fechaFormatText] Fin");
    	
    	return format;
    }
    
    public static String[] formatMesAnioText(int mes, int anio) {
    	int mesActual = -1;
    	int anioActual = -1;
    	int mesSiguiente = -1;
    	int anioSiguiente = -1;
    	String mesAnio[] = new String[]{"", ""};
    	
    	try {
    		log.info("[ConstantesUtil :: formatMesAnioText] Inicio");
    		
	    	mesActual = mes;
	    	anioActual = anio;
	    	
	    	if(mesActual == 12) {
	    		mesSiguiente = 1;
	        	anioSiguiente = anioActual + 1;
	    	} else {
	    		mesSiguiente = mesActual + 1;
	    		anioSiguiente = anioActual;
	    	}
	    	mesAnio[0] = ConstantesUtil.fechaFormatNum(mesActual) + anioActual;
	    	mesAnio[1] = ConstantesUtil.fechaFormatNum(mesSiguiente) + anioSiguiente;
	    	
	    	log.info("[ConstantesUtil :: formatMesAnioText] Fin");
    	} catch(Exception e) {
    		log.error("[ConstantesUtil :: formatMesAnioText] ");
    		ConstantesUtil.mostrarMensajeExcepcion(e);
    	}
    	
    	return mesAnio;
    }
    
    public static String formatMesAnioFec(String fecha, int tipo) {
    	String format = "";
    	
    	try {
    		log.info("[ConstantesUtil :: formatMesAnioFec] Inicio");
    		
   			format = fecha.substring(0, 2) + fecha.substring(3, 5) + fecha.substring(6, 10);
    		
    		log.info("[ConstantesUtil :: formatMesAnioFec] Fin");
    	} catch(Exception e) {
    		log.error("[ConstantesUtil :: formatMesAnioFec] ");
    		ConstantesUtil.mostrarMensajeExcepcion(e);
    	}
    	
    	return format;
    }
    
    public static int sumarValorLista(ArrayList lista) {
    	int suma = 0;
    	Iterator iter = null; 
    	
    	try {
    		log.info("[ConstantesUtil :: sumarValorLista] Inicio");
    		
    		if(lista != null && lista.size() > 0) {
    			iter = lista.iterator();
    			
    			while(iter.hasNext()) {
    				String valor = (String)iter.next();
    				
    				suma += (valor != null && !valor.equals("") ? 
    						Integer.parseInt(valor) : 0);
    			}
    		}
    		
    		log.info("[ConstantesUtil :: sumarValorLista] Fin");
    	} catch(Exception e) {
    		log.error("[ConstantesUtil :: sumarValorLista] ");
    		ConstantesUtil.mostrarMensajeExcepcion(e);
    	}
    	
    	return suma;
    }
    
    public static int sumarContLista(ArrayList lista) {
    	int suma = 0;
    	Iterator iter = null; 
    	
    	try {
    		log.info("[ConstantesUtil :: sumarContLista] Inicio");
    		
    		if(lista != null && lista.size() > 0) {
    			iter = lista.iterator();
    			
    			while(iter.hasNext()) {
    				String valor = (String)iter.next();
    				suma += (valor != null && !valor.equals("") ? 1 : 0);
    			}
    		}
    		
    		log.info("[ConstantesUtil :: sumarContLista] Fin");
    	} catch(Exception e) {
    		log.error("[ConstantesUtil :: sumarContLista] ");
    		ConstantesUtil.mostrarMensajeExcepcion(e);
    	}
    	
    	return suma;
    }
    
    public static String parseSQLString2(java.util.Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT2);
		String fecha = null;

		try{
			log.info("[ConstantesUtil :: parseSQLString2] Inicio");
			
			fecha = sdf.format(date);
			
			log.info("[ConstantesUtil :: parseSQLString2] Fin");
		}catch(Exception e){
			log.error("[ConstantesUtil :: parseSQLString2] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}			
		
		return fecha;
	}
    
    private static boolean isFechaValida(int dia, int mes, int anio) {
       String fechax = "";
       String diaFormat = null;
       String mesFormat = null;
       String anioFormat = null;
        
	   try {
	   		log.info("[ConstantesUtil :: isFechaValida] Inicio");
	   	
		   	 if(dia < 10) {
		   		 diaFormat = "0" + dia;
		   	 } else {
		   		diaFormat = String.valueOf(dia);
		   	 }
		   	 
		   	 if(mes < 10) {
		   		 mesFormat = "0" + mes;
		   	 } else {
		   		mesFormat = String.valueOf(mes);
		   	 }
		   	 
		   	 fechax = diaFormat + "/" + mesFormat + "/" + String.valueOf(anio); 
		   	 
	         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
	         formatoFecha.setLenient(false);
	         formatoFecha.parse(fechax);
	         
	         log.info("[ConstantesUtil :: isFechaValida] Fin");
	   } catch (ParseException e) {
	   		log.error("[ConstantesUtil :: isFechaValida] ");
	   		ConstantesUtil.mostrarMensajeExcepcion(e);
	   	
	        return false;
	   } catch (Exception e) {
	   		log.error("[ConstantesUtil :: isFechaValida] ");
	   		ConstantesUtil.mostrarMensajeExcepcion(e);
	   		
	   		return false;
	   }
    
	   return true;
    } 
    
    public static void mostrarMensajeExcepcion(Exception e) {
		 StackTraceElement[] traza = null;
		 
		 try {
			 log.error("[ConstantesUtil :: mostrarMensajeExcepcion] Inicio");
			 log.error("Mensaje: " + e.getMessage());
			 log.error("Traza: ");
			 traza = e.getStackTrace();
			 
			 if(traza != null && traza.length > 0) {
				 int linea = 0;
				 for(int i = 0; i < traza.length; i++) {
					 log.error(traza[i]);
					 
					 if(linea == 15) {
						 break;
					 }
					 
					 linea++;
				 }
			 }
			 
			 log.error("[ConstantesUtil :: mostrarMensajeExcepcion] Fin");
		 } catch(Exception ex) {
			 log.error(e);
		 }
	 }
    
    public ArrayList listarExportacionForm() {
    	ArrayList listaFormularios = null;
    	ExportacionTabla exportacionTabla = null; 
    	
		try {
			listaFormularios = new ArrayList();
			
			exportacionTabla = new ExportacionTabla();
			exportacionTabla.setId("1");
			exportacionTabla.setDescripcion("TIIDO_PLANES");
			listaFormularios.add(exportacionTabla);
			
			exportacionTabla = new ExportacionTabla();
			exportacionTabla.setId("2");
			exportacionTabla.setDescripcion("TIIDO_METAS_GESTOR");
			listaFormularios.add(exportacionTabla);
			
			exportacionTabla = new ExportacionTabla();
			exportacionTabla.setId("3");
			exportacionTabla.setDescripcion("TIIDO_ACCIONES");
			listaFormularios.add(exportacionTabla);
			
			exportacionTabla = new ExportacionTabla();
			exportacionTabla.setId("4");
			exportacionTabla.setDescripcion("TIIDO_CAMPANIAS");
			listaFormularios.add(exportacionTabla);
			
			exportacionTabla = new ExportacionTabla();
			exportacionTabla.setId("5");
			exportacionTabla.setDescripcion("TIIDO_CAMPANIAS_DETALLE");
			listaFormularios.add(exportacionTabla);
			
			exportacionTabla = new ExportacionTabla();
			exportacionTabla.setId("6");
			exportacionTabla.setDescripcion("TIIDO_INGRESOS");
			listaFormularios.add(exportacionTabla);
			
			exportacionTabla = new ExportacionTabla();
			exportacionTabla.setId("7");
			exportacionTabla.setDescripcion("TIIDO_INGRESOS_FORM");
			listaFormularios.add(exportacionTabla);
			
		} catch(Exception e) {
			log.error("[ConstantesUtil :: listarExportacionForm] " + e);
		}
		    
		return listaFormularios;    
    }
    
    public static HashMap totalizarEpigrafe(List detallesPorEpigrafe){
        List nroClientes=new ArrayList();
        List compGestores=new ArrayList();
        List nroGestores=new ArrayList();
        List nroConcrs=new ArrayList();
        List montos=new ArrayList();       
        List desviaciones=new ArrayList();
        
        log.info("[ConstantesUtil :: totalizarEpigrafe] Inicio");
        if(detallesPorEpigrafe!=null){       
	        for (Iterator iterator = detallesPorEpigrafe.iterator(); iterator.hasNext();)
	        {
	            HashMap hashMap = (HashMap) iterator.next();
	            nroClientes.add(hashMap.get("NROCLIENTE"));
	            compGestores.add(hashMap.get("COMPGESTOR"));
	            nroGestores.add(hashMap.get("NROGESTOR"));
	            nroConcrs.add(hashMap.get("NROCONCR"));
	            montos.add(hashMap.get("MONTO"));
	            desviaciones.add(hashMap.get("DESVIACION"));                                   
	        }
	        
	        HashMap totales = new HashMap();
	        totales.put("NROCLIENTE", sumArrayIntegers(nroClientes));
	        totales.put("COMPGESTOR", sumArrayIntegers(compGestores));
	        totales.put("NROGESTOR", sumArrayIntegers(nroGestores));
	        totales.put("NROCONCR", sumArrayIntegers(nroConcrs));
	        totales.put("MONTO", sumArrayIntegers(montos));
	        totales.put("DESVIACION", sumArrayIntegers(desviaciones));
	        
	        log.info("[ConstantesUtil :: totalizarEpigrafe] Fin");
	        
	        return totales;
        }
        
        log.info("[ConstantesUtil :: totalizarEpigrafe] Fin");
        
        return null;
    }
    
    public static Integer sumArrayIntegers(List integers){
        int suma=0;
        
        log.info("[ConstantesUtil :: sumArrayIntegers] Inicio");
        
        for (Iterator iterator = integers.iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer) iterator.next();
            suma+=integer.intValue();            
        }
        
        log.info("[ConstantesUtil :: sumArrayIntegers] Fin");
        
        return new Integer(suma);
    }
    
    public static void main(String args[]) {
    	int i = 0;
    	i = 355550000 + 1;
    	
    }
}