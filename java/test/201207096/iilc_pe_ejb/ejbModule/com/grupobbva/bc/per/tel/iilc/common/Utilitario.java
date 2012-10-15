/*
 * Created on 01/07/2008
 */
package com.grupobbva.bc.per.tel.iilc.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @author P020796
 */
public class Utilitario {
	
	/**
	 * Quita acentos de vocales y cambia ni por N
	 * @param in. Texto de entrada en mayusculas
	 * @return Texto de salida en mayusculas
	 */
	
	public static String getString(Object obj){
		try{
			
			if(obj.toString()==null || obj.toString().equals("null") ){
				return "";
			}
			return obj.toString();
			
			
		}catch(Exception e){
			return "";
		}
	}
	
	public static String stringOracle(String in){
		String res =in;
		
		if(res!=null){
			res = res.replace((char) 193,'A');
			res = res.replace((char) 201,'E');
			res = res.replace((char) 205,'I');
			res = res.replace((char) 211,'O');
			res = res.replace((char) 218,'U');
			res = res.replace((char) 209,'N');
		}
		
		return res;
	}
	
	public static String longitudMinima(String in, int longitud){
		String res = in;
		if(res!=null){
			if(res.length()<longitud){
				char chars[] = new char[longitud - res.length()];
				Arrays.fill(chars, ' ');
				res = res + (new String(chars));
			}
		}
		return res;
	}
	
	public String nonNullString(String str, String alternativeText){
		if(str!=null)
			return str;
		else
			return alternativeText;
	}
	
	public String nonNullString(String str){
		return nonNullString(str,"");
	}
	
	public static String nonEmptyString(String str, String alternativeText){
		String res = str;
		if(str==null)
			res = alternativeText;
		else
			if(str.trim().length()==0)
				res = alternativeText;
		
		return res;
	}
	
	public static String ajaxEncode(String str) throws UnsupportedEncodingException{
		return URLEncoder.encode(str, "ISO-8859-1");
	}
	
	public static String dosCeros(int numero){
		return dosCeros(String.valueOf(numero));
	}
	
	public static String dosCeros(String numero){
		String res = "";
		
		if (numero.length() == 0)
			res = "00";
		else if (numero.length() == 1)
			res = "0" + numero;
		else
			res = numero;
		return res;
	}

	public static String litDiaSemana(int dia, boolean plural) {
		String res = "";
		if(dia==0)
			res = "domingo";
		else if(dia==1)
			res = "lunes";
		else if(dia==2)
			res = "martes";
		else if(dia==3)
			res = "mi" + (char) 233 + "rcoles";
		else if(dia==4)
			res = "jueves";
		else if(dia==5)
			res = "viernes";
		else if(dia==6)
			res = "s" + (char) 225 + "bado";
		
		if((dia==6 || dia==0) && plural)
			if(plural) res = res + "s";
		return res;
	}
}
