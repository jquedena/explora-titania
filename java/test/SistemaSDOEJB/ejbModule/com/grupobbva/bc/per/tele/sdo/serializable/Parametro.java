/*
 * Created on 23/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Parametro implements Serializable{
private String codParametro;
private Date fecAccion;
private Date fecSeguimiento1;
private Date fecSeguimiento2;
private String afectaAccion;
private String afectaSeguimiento;
private String afectaPlan;
private Date fecPlan;


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
 * @return Returns the afectaPlan.
 */
public String getAfectaPlan() {
	return afectaPlan;
}
/**
 * @param afectaPlan The afectaPlan to set.
 */
public void setAfectaPlan(String afectaPlan) {
	this.afectaPlan = afectaPlan;
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
 * @return Returns the codParametro.
 */
public String getCodParametro() {
	return codParametro;
}
/**
 * @param codParametro The codParametro to set.
 */
public void setCodParametro(String codParametro) {
	this.codParametro = codParametro;
}
/**
 * @return Returns the fecAccion.
 */
public Date getFecAccion() {
	return fecAccion;
}
/**
 * @param fecAccion The fecAccion to set.
 */
public void setFecAccion(Date fecAccion) {
	this.fecAccion = fecAccion;
}
/**
 * @return Returns the fecPlan.
 */
public Date getFecPlan() {
	return fecPlan;
}
/**
 * @param fecPlan The fecPlan to set.
 */
public void setFecPlan(Date fecPlan) {
	this.fecPlan = fecPlan;
}
/**
 * @return Returns the fecSeguimiento1.
 */
public Date getFecSeguimiento1() {
	return fecSeguimiento1;
}
/**
 * @param fecSeguimiento1 The fecSeguimiento1 to set.
 */
public void setFecSeguimiento1(Date fecSeguimiento1) {
	this.fecSeguimiento1 = fecSeguimiento1;
}
/**
 * @return Returns the fecSeguimiento2.
 */
public Date getFecSeguimiento2() {
	return fecSeguimiento2;
}
/**
 * @param fecSeguimiento2 The fecSeguimiento2 to set.
 */
public void setFecSeguimiento2(Date fecSeguimiento2) {
	this.fecSeguimiento2 = fecSeguimiento2;
}
}
