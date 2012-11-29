package com.indra.pe.bbva.reauni.task.thread;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.mail.CorreoElectronico;
import com.indra.pe.bbva.reauni.mail.GestionCorreo;
import com.indra.pe.bbva.reauni.model.entidad.LogEMailDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;

@SuppressWarnings({"unchecked", "rawtypes"})
public class ContratoProcesadoCorreo extends Thread  {

	protected static String REASIGNACION = "1007";
	protected static String UNIFICACION = "1006";
	private static SimpleDateFormat formatDateTime = new SimpleDateFormat("dd/MM/yyyy");
	private static Logger logger = Logger.getLogger(ContratoProcesadoCorreo.class);
	
	@Autowired
	private GestionCorreo gestionCorreo;
	private DAOGenerico<SolicitudDto> daoTarea;
	private DAOGenerico<LogEMailDto> daoLog;
	private Date fechaInicio;
	private Date fechaFin;
	private List<LogEMailDto> listaEmail;
	
	public ContratoProcesadoCorreo(Date fechaInicio, Date fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	@Override
	public void run() {
		try{
			CorreoElectronico correoElectronico = new CorreoElectronico();

			List lista_unificacion = null;
			List lista_reasignacion = null;
			String listaCorreo = null;
			String dia = "";
			String dia1 = formatDateTime.format(fechaInicio);
			String dia2 = formatDateTime.format(fechaFin);
			
			if(dia1.compareTo(dia2) == 0) {
				dia = formatDateTime.format(fechaInicio);
			} else {
				dia = formatDateTime.format(fechaInicio) + " al " + formatDateTime.format(fechaFin);
			}
			
			lista_unificacion = obtenerListado(ContratoProcesadoCorreo.UNIFICACION);
			lista_reasignacion = obtenerListado(ContratoProcesadoCorreo.REASIGNACION);
			listaCorreo = obtenerListadoCorreo();
			
	  		try {
	  			if(listaCorreo != null && listaCorreo.length() > 0) {
	  				correoElectronico =  new CorreoElectronico();
	  				correoElectronico.enviar(getGestionCorreo().obtenerCorreoContratoProcesado(listaCorreo, dia, lista_unificacion, lista_reasignacion));
	  			}
	  		} catch(Exception e) {
	  			logger.error("Enviando correo de contratos procesados", e);
	  			for(LogEMailDto le : listaEmail) {
		  			le.setEstado(BigDecimal.ZERO);
		  			try {
		  				getDaoLog().save(le);
		  			} catch(Exception ex) {
			  			logger.error("Actualizando estado por error", ex);
		  			}
	  			}
	  		}
		} catch(Exception e) {
			logger.error("ContratoProcesadoCorreo", e);
		}
	}
	
	private List<Object> obtenerListado(String tipo){
		String query = "";
		List<Object> listaSolicitudes = null;
		
		query += "select " +
			"a.fecha_creacion" +
			"|| '|' || A.fecha_estado" +
			"|| '|' || a.codigo_cliente" +
			"|| '|' || a.codigo_contrato" +
			"|| '|' || a.fecha_apertura" +
			"|| '|' || a.cod_territorio" +
			"|| '|' || a.des_territorio" +
			"|| '|' || a.cod_oficina" +
			"|| '|' || a.des_oficina" +
			"|| '|' || a.territorio_receptor" +
			"|| '|' || a.des_territorio_receptor" +
			"|| '|' || a.oficina_receptor" +
			"|| '|' || a.des_oficina_receptor" +
			"|| '|' || a.gestor_receptor" +
			"|| '|' || a.nom_gestor" +
			"|| '|' || a.producto" +
			"|| '|' || a.des_producto" +
			"|| '|' || a.ajuste_bonificacion" +
			"|| '|' || a.moneda_importe";
		if(tipo == ContratoProcesadoCorreo.UNIFICACION) {
			query += "|| '|' || a.ajuste_50";
		}
		query += "|| '|' || a.total_activo" +
			"|| '|' || a.total_pasivo as resultado " +
			"from reauni.vreauni_contrato_procesado a where ";
		query += "a.tipo=" + tipo + " and ";
		if(fechaInicio != null && fechaFin != null) {
			query += "a.fecha_estado>=to_date('" + formatDateTime.format(fechaInicio) + " 00:00', 'dd/MM/yyyy HH24:mi') and ";
			query += "a.fecha_estado<=to_date('" + formatDateTime.format(fechaFin) + " 23:59', 'dd/MM/yyyy HH24:mi') ";
		}
		
		try {
			listaSolicitudes = getDaoTarea().ejecutarSQL(query);
		} catch (DAOException e) {
			logger.error("SQL :: " + query, e);
		}
		
		return listaSolicitudes;
	}
	
	private String obtenerListadoCorreo(){
		String email = "";
		String query = "";
		LogEMailDto logEMail = null;
		List<Object[]> listaSolicitudes = null;
		
		query += "select email, registro, nombres, count(1) nro_contratos from ( select i.email, c.codigo_contrato, i.registro, i.nombres || ' ' || i.apellido_paterno || ' ' || i.apellido_materno nombres ";
		query += "from reauni.treauni_solicitud s ";
		query += "inner join reauni.treauni_oficina_solicitud os on os.solicitud=s.id ";
		query += "inner join reauni.treauni_oficina_involucrado oi on os.id=oi.oficina_solicitud ";
		query += "inner join reauni.treauni_involucrado i on oi.involucrado=i.id and i.cargo in('CH1', 'CH6') "; 
		query += "inner join reauni.treauni_contrato c on c.oficina_solicitud=os.id and c.estado=1035 ";
		query += "where i.cargo in('CH1', 'CH6') and ";
		if(fechaInicio != null && fechaFin != null) {
			query += "c.fecha_estado>=to_date('" + formatDateTime.format(fechaInicio) + " 00:00', 'dd/MM/yyyy HH24:mi') and ";
			query += "c.fecha_estado<=to_date('" + formatDateTime.format(fechaFin) + " 23:59', 'dd/MM/yyyy HH24:mi') ";
		}
		query += "group by i.email, c.codigo_contrato, i.registro, i.nombres || ' ' || i.apellido_paterno || ' ' || i.apellido_materno) z group by email, registro, nombres";
		
		try {
			listaSolicitudes = getDaoTarea().ejecutarSQL(query);
			if(listaSolicitudes != null) {
				listaEmail = new ArrayList<LogEMailDto>();
				for(Object[] _email : listaSolicitudes) {
					if(email.length() > 0) email += ","; 
					email += _email[0].toString();
					
					try {
						logEMail = new LogEMailDto();
						logEMail.setEmail(_email[0].toString());
						logEMail.setRegistro(_email[1].toString());
						logEMail.setNombre(_email[2].toString());
						logEMail.setNroContratos(BigDecimal.valueOf(Double.parseDouble(_email[3].toString())));
						logEMail.setEstado(BigDecimal.ONE);
						logEMail.setFechaEnvio(new Date());
						getDaoLog().save(logEMail);
						listaEmail.add(logEMail);
					} catch(Exception ex) {
						logger.error("", ex);	
					}
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

	public DAOGenerico<LogEMailDto> getDaoLog() {
		if(daoLog ==  null){
			daoLog = (DAOGenerico<LogEMailDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoLog;
	}

	public List<LogEMailDto> getListaEmail() {
		return listaEmail;
	}
}
