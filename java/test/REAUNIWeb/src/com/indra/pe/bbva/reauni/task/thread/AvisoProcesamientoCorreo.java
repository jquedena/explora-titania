package com.indra.pe.bbva.reauni.task.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.mail.CorreoElectronico;
import com.indra.pe.bbva.reauni.mail.GestionCorreo;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@SuppressWarnings({"unchecked", "rawtypes"})
public class AvisoProcesamientoCorreo   extends Thread  {

	protected static String REASIGNACION = "1007";
	protected static String UNIFICACION = "1006";
	protected static int FORMATO_MENSUAL = 1;
	protected static int FORMATO_DIARIO = 2;
	private static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	private static Logger logger = Logger.getLogger(AvisoProcesamientoCorreo.class);
	private DAOGenerico<SolicitudDto> daoTarea;
	@Autowired
	private GestionCorreo gestionCorreo;
	private String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	private Boolean esPrimerDiaUtil;
	
	public AvisoProcesamientoCorreo (Boolean esPrimerDiaUtil) {
		this.esPrimerDiaUtil = esPrimerDiaUtil;
	}
	
	@Override
	public void run() {
		try{
			Calendar hoy=Calendar.getInstance();
			String dia1 = ApplicationHelper.obtenerParametroPorId(1053L).getValorCadena();
			String dia2 = ApplicationHelper.obtenerParametroPorId(1054L).getValorCadena();
			int int_dia=hoy.get(Calendar.DAY_OF_WEEK);
			
			boolean es_dia_de_proceso=false;
			 
			if(int_dia == Integer.parseInt(dia1) ){
				es_dia_de_proceso=true;
			}else if(int_dia == Integer.parseInt(dia2) ){
				es_dia_de_proceso=true;
			}
 
			CorreoElectronico correoElectronico = new CorreoElectronico();
			String dia = AvisoProcesamientoCorreo.formatoFecha.format(new Date());

			List lista_unificacion = null;
			List lista_reasignacion = null;
			String listaCorreo = null; 
			
			if(es_dia_de_proceso) { // Si es que es un dia de proceso en la semana (parametrizable en treauni_parametro)
 				
				lista_unificacion = obtenerListado(AvisoProcesamientoCorreo.UNIFICACION, AvisoProcesamientoCorreo.FORMATO_DIARIO);
				lista_reasignacion = obtenerListado(AvisoProcesamientoCorreo.REASIGNACION, AvisoProcesamientoCorreo.FORMATO_DIARIO);
				listaCorreo = obtenerListadoCorreo(AvisoProcesamientoCorreo.FORMATO_DIARIO);
				
		  		try {
		  			correoElectronico =  new CorreoElectronico();
		  			correoElectronico.enviar(getGestionCorreo().obtenerCorreoProcesamientoCorreo(listaCorreo, dia, lista_unificacion, lista_reasignacion));
		  		} catch(Exception e) {
		  			logger.error("Enviando correo aviso procesamiento reasignación", e);
		  		}
			}

			if(esPrimerDiaUtil) { // Si es primer dia habil del mes
			  
				dia = meses[hoy.get(Calendar.MONTH)]+" - "+hoy.get(Calendar.YEAR);
 				
				lista_unificacion = obtenerListado(AvisoProcesamientoCorreo.UNIFICACION, AvisoProcesamientoCorreo.FORMATO_MENSUAL);
				lista_reasignacion = obtenerListado(AvisoProcesamientoCorreo.REASIGNACION, AvisoProcesamientoCorreo.FORMATO_MENSUAL);
				listaCorreo = obtenerListadoCorreo(AvisoProcesamientoCorreo.FORMATO_MENSUAL);
				
		  		try {
		  			correoElectronico =  new CorreoElectronico();
		  			correoElectronico.enviar(getGestionCorreo().obtenerCorreoProcesamientoCorreo(listaCorreo, dia, lista_reasignacion, lista_reasignacion));
		  		} catch(Exception e) {
		  			logger.error("Enviando correo aviso procesamiento reasignación", e);
		  		}
			}
			
		} catch(Exception e) {
			logger.error("AvisoProcesamientoCorreo",e);
		}
	}
	
	private List<Object> obtenerListado(String tipoSolicitud, int tipoFormato){
		String query = "";
		List<Object> listaSolicitudes = null;
		
		query += "select a.resultado from reauni.vreauni_correo_procesado a where ";
		query += "a.tipo=" + tipoSolicitud + " and ";
		if(tipoFormato == AvisoProcesamientoCorreo.FORMATO_MENSUAL) {
			query += "to_char(a.fecha_creacion,'YYYYMM')=to_char(add_months(sysdate, -1), 'YYYYMM')";
		}
		if(tipoFormato == AvisoProcesamientoCorreo.FORMATO_DIARIO) {
			query += "to_char(a.fecha_estado,'DDMMYYYY')=to_char(sysdate,'DDMMYYYY') ";
		}
		
		try {
			listaSolicitudes = getDaoTarea().ejecutarSQL(query);
		} catch (DAOException e) {
			logger.error("SQL :: " + query, e);
		}
		
		return listaSolicitudes;
	}
	
	private String obtenerListadoCorreo(int tipoFormato){
		String email = "";
		String query = "";
		List<Object> listaSolicitudes = null;
		
		query += "select i.email ";
		query += "from reauni.treauni_solicitud s ";
		query += "inner join reauni.treauni_oficina_solicitud os on os.solicitud=s.id ";
		query += "inner join reauni.treauni_oficina_involucrado oi on os.id=oi.oficina_solicitud ";
		query += "inner join reauni.treauni_involucrado i on oi.involucrado=i.id and i.cargo in('CH1', 'CH6') "; 
		query += "inner join reauni.treauni_contrato c on c.oficina_solicitud=os.id and c.estado=1035 ";
		query += "where i.cargo in('CH1', 'CH6') and ";
		if(tipoFormato == AvisoProcesamientoCorreo.FORMATO_MENSUAL) {
			query += "to_char(s.fecha_creacion,'YYYYMM')=to_char(add_months(sysdate, -1), 'YYYYMM') ";
		}
		if(tipoFormato == AvisoProcesamientoCorreo.FORMATO_DIARIO) {
			query += "to_char(c.fecha_estado,'DDMMYYYY')=to_char(sysdate,'DDMMYYYY') ";
		}
		query += "group by i.email";
		
		try {
			listaSolicitudes = getDaoTarea().ejecutarSQL(query);
			if(listaSolicitudes != null) {
				for(Object _email : listaSolicitudes) {
					if(email.length() > 0) email += ","; 
					email += _email.toString();
				}
			}
		} catch (DAOException e) {
			logger.error("SQL :: " + query, e);
		}
		
		return email;
	}
	
	public GestionCorreo getGestionCorreo() {
		if(gestionCorreo ==  null){
			gestionCorreo = (GestionCorreo) WebServletContextListener.getApplicationContext().getBean("gestionCorreo");
		}
		return gestionCorreo;
	}	
	
	public DAOGenerico<SolicitudDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<SolicitudDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}
}
