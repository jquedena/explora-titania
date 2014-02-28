package com.indra.pe.bbva.core.exception;


public class ServiceException extends Exception {

	private static final long serialVersionUID = 4537005451517865885L;

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String mensaje) {
		super(mensaje);
	}

	public ServiceException(String mensaje, Throwable e) {
		super(mensaje, e);
	}
}
