/*
 * Created on 19/07/2007
 */
package com.grupobbva.bc.per.tel.iilc.common;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/**
 * @author c20795
 */
public class Fecha {
    
	private static Logger logger = Logger.getLogger(Fecha.class);
    private Date fecha;
	private String hora;
	
	public Fecha(){
	    java.util.Calendar ca = java.util.Calendar.getInstance();
		fecha = new java.sql.Date(ca.getTimeInMillis());
		
		Timestamp timestamp = new Timestamp(ca.getTimeInMillis());
		hora = timestamp.toString();
		hora = hora.substring(11,hora.length());
	}
	
	public java.sql.Date dateFormat(String date){
		
		java.util.Date dateUtil=null;
		try {
			if (date == null){
				return null;
			}
			if (date.equals("")){
				return null;
			}
			SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
			dateUtil= df.parse(date);
	    }
	    catch (Exception e) {
	    	logger.error(e.getMessage());
	    }

		java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
		
		return dateSql;
	}
	
	public String format(String date){
		if (date.equals("")){
			return "";
		}
		return date.substring(8,10) + "/" + date.substring(5,7)+ "/" + date.substring(0,4);
		
	}
	public String stringFormat(Date date){
		if (date == null){
			return "";
		}
		return this.format(date.toString());
		
	}
	public java.sql.Date today(){
		return fecha;
	}

	public String clock(){
		return hora;
	}

	public String hh(){
	    return hora.substring(0,2);
	}
	public String mm(){
	    return hora.substring(3,5);
	}
	public String ss(){
	    return hora.substring(6,8);
	}
	public java.sql.Date fechaMin(){
		return this.dateFormat("01/01/0001");
	}
}
