package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.common.Utilitario;

public class HoraServidorAjax extends Action {
	
	private static Logger log = Logger.getLogger(HoraServidorAjax.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		Calendar hoy = Calendar.getInstance();
		String fechaServidor=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR)+ " "+ Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+":"+Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
		response.setContentType("text/plain"); 
		try {
			PrintWriter writer = response.getWriter();
			writer.print("Fecha Actual:"+fechaServidor);
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			log.error("Error imprimiendo hora del servidor") ;
		}
		return null;
	}

}
