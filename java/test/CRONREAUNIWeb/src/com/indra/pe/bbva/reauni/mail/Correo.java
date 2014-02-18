package com.indra.pe.bbva.reauni.mail;

import java.io.File;

public class Correo {
	
	private String emailFrom = null;
	private String from = null;
	private String mensaje;
	private String asunto;
	private String listaTo;
	private String listaCc;	
	private String mensajeAdjunto;
	private String fileName;
	private File mensajeAdjuntoExcel;
	private File mensajeAdjuntoExcel2;
	
	public Correo() {
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getListaTo() {
		return listaTo;
	}

	public void setListaTo(String listaTo) {
		this.listaTo = listaTo;
	}

	public String getListaCc() {
		if(listaCc == null) {
			listaCc = "";
		}
		return listaCc;
	}

	public void setListaCc(String listaCc) {
		this.listaCc = listaCc;
	}

	public String getMensajeAdjunto() {
		return mensajeAdjunto;
	}

	public void setMensajeAdjunto(String mensajeAdjunto) {
		this.mensajeAdjunto = mensajeAdjunto;
	}

	public File getMensajeAdjuntoExcel() {
		return mensajeAdjuntoExcel;
	}

	public void setMensajeAdjuntoExcel(File mensajeAdjuntoExcel) {
		this.mensajeAdjuntoExcel = mensajeAdjuntoExcel;
	}

	public File getMensajeAdjuntoExcel2() {
		return mensajeAdjuntoExcel2;
	}

	public void setMensajeAdjuntoExcel2(File mensajeAdjuntoExcel2) {
		this.mensajeAdjuntoExcel2 = mensajeAdjuntoExcel2;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		if(fileName == null) 
			fileName = "sin_nombre.txt";
		this.fileName = fileName;
	}
}
