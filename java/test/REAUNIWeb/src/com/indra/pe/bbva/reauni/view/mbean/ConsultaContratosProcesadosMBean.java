package com.indra.pe.bbva.reauni.view.mbean;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.primefaces.event.DateSelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.LogEMailDto;
import com.indra.pe.bbva.reauni.task.thread.ContratoProcesadoCorreo;
import com.indra.pe.bbva.reauni.util.Constantes;

@Controller("consultaContratosProcesadosMBean")
@Scope("session")
public class ConsultaContratosProcesadosMBean extends GenericMBean{
	
	private static Logger logger = Logger.getLogger(ConsultaContratosProcesadosMBean.class);
	private Date fechaInicio;
	private Date fechaFin;
	private List<LogEMailDto> listaEmail;
	private int nroContratos;
	
	public ConsultaContratosProcesadosMBean() {
		fechaInicio = new Date();
		fechaFin = new Date();
		listaEmail = new ArrayList<LogEMailDto>();
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		ConsultaContratosProcesadosMBean.logger = logger;
	}
	
	public String index() {
		return Constantes.UrlNavegacion.URL_LISTA_CONTRATO_PROCESADO;
	}

	public void enviar() {
		Date temp;
		if(fechaInicio.compareTo(fechaFin) == 1) {
			temp = fechaFin;
			fechaFin = fechaInicio;
			fechaInicio = temp;
		}
		ContratoProcesadoCorreo correo = new ContratoProcesadoCorreo(fechaInicio, fechaFin);
		this.setListaEmail(correo.enviarContratos());
		this.setNroContratos(correo.getNroContratos());
	}
	
	public void listenerAsignarFechaInicio(DateSelectEvent event) {
        this.setFechaInicio(event.getDate());
    }
	
	public void listenerAsignarFechaHasta(DateSelectEvent event) {  
        this.setFechaFin(event.getDate());  
    }
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<LogEMailDto> getListaEmail() {
		return listaEmail;
	}

	public void setListaEmail(List<LogEMailDto> listaEmail) {
		this.listaEmail = listaEmail;
	}

	public int getNroContratos() {
		return nroContratos;
	}

	public void setNroContratos(int nroContratos) {
		this.nroContratos = nroContratos;
	}
}
