/*
 * Created on 18-ene-2010
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ocortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TParametros implements Serializable{

	Date fechaAccion;
	Date fechaSeguimiento1;
	Date fechaSeguimiento2;
	String afectaAccion;
	String afectaSeguimiento;
	String afectaPlanificacion;
	Date fechaPlanificacion;
	
	
	/**
	 * @return Returns the afectaAccion.
	 */
	public String getAfectaAccion() {
		return afectaAccion;
	}
	/**
	 * @param afectaAccion The afectaAccion to set.
	 */
	public void setAfectaAccion(String afectaAccion) {
		this.afectaAccion = afectaAccion;
	}
	/**
	 * @return Returns the afectaPlanificacion.
	 */
	public String getAfectaPlanificacion() {
		return afectaPlanificacion;
	}
	/**
	 * @param afectaPlanificacion The afectaPlanificacion to set.
	 */
	public void setAfectaPlanificacion(String afectaPlanificacion) {
		this.afectaPlanificacion = afectaPlanificacion;
	}
	/**
	 * @return Returns the afectaSeguimiento.
	 */
	public String getAfectaSeguimiento() {
		return afectaSeguimiento;
	}
	/**
	 * @param afectaSeguimiento The afectaSeguimiento to set.
	 */
	public void setAfectaSeguimiento(String afectaSeguimiento) {
		this.afectaSeguimiento = afectaSeguimiento;
	}
	/**
	 * @return Returns the fechaAccion.
	 */
	public Date getFechaAccion() {
		return fechaAccion;
	}
	/**
	 * @param fechaAccion The fechaAccion to set.
	 */
	public void setFechaAccion(Date fechaAccion) {
		this.fechaAccion = fechaAccion;
	}
	/**
	 * @return Returns the fechaPlanificacion.
	 */
	public Date getFechaPlanificacion() {
		return fechaPlanificacion;
	}
	/**
	 * @param fechaPlanificacion The fechaPlanificacion to set.
	 */
	public void setFechaPlanificacion(Date fechaPlanificacion) {
		this.fechaPlanificacion = fechaPlanificacion;
	}
	/**
	 * @return Returns the fechaSeguimiento1.
	 */
	public Date getFechaSeguimiento1() {
		return fechaSeguimiento1;
	}
	/**
	 * @param fechaSeguimiento1 The fechaSeguimiento1 to set.
	 */
	public void setFechaSeguimiento1(Date fechaSeguimiento1) {
		this.fechaSeguimiento1 = fechaSeguimiento1;
	}
	/**
	 * @return Returns the fechaSeguimiento2.
	 */
	public Date getFechaSeguimiento2() {
		return fechaSeguimiento2;
	}
	/**
	 * @param fechaSeguimiento2 The fechaSeguimiento2 to set.
	 */
	public void setFechaSeguimiento2(Date fechaSeguimiento2) {
		this.fechaSeguimiento2 = fechaSeguimiento2;
	}
}
