package com.grupobbva.bc.per.tel.iilc.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 14 fields on this form:
 * <ul>
 * <li>mensaje - [your comment here]
 * <li>valor3 - [your comment here]
 * <li>archivo - [your comment here]
 * <li>des_perfil - [your comment here]
 * <li>valor2 - [your comment here]
 * <li>componente - [your comment here]
 * <li>tipo_acceso - [your comment here]
 * <li>tipo - [your comment here]
 * <li>cod_perfil - [your comment here]
 * <li>cod_mult - [your comment here]
 * <li>valor1 - [your comment here]
 * <li>valor_rcp - [your comment here]
 * <li>valor4 - [your comment here]
 * <li>cod_ele - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class FormBeanMantenimiento extends ActionForm

{

    private String mensaje = null;

    private String valor3 = null;

    private org.apache.struts.upload.FormFile archivo = null;

    private String des_perfil = null;

    private String valor2 = null;

    private String componente = null;

    private String tipo_acceso = null;

    private String tipo = null;

    private String cod_perfil = null;

    private String cod_mult = null;

    private String valor1 = null;

    private String valor_rcp = null;

    private String valor4 = null;

    private String cod_ele = null;
    
    private String forward = null;

    /**
     * Get mensaje
     * @return String
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Set mensaje
     * @param <code>String</code>
     */
    public void setMensaje(String m) {
        this.mensaje = m;
    }

    /**
     * Get valor3
     * @return String
     */
    public String getValor3() {
        return valor3;
    }

    /**
     * Set valor3
     * @param <code>String</code>
     */
    public void setValor3(String v) {
        this.valor3 = v;
    }

    /**
     * Get archivo
     * @return org.apache.struts.upload.FormFile
     */
    public org.apache.struts.upload.FormFile getArchivo() {
        return archivo;
    }

    /**
     * Set archivo
     * @param <code>org.apache.struts.upload.FormFile</code>
     */
    public void setArchivo(org.apache.struts.upload.FormFile a) {
        this.archivo = a;
    }

    /**
     * Get des_perfil
     * @return String
     */
    public String getDes_perfil() {
        return des_perfil;
    }

    /**
     * Set des_perfil
     * @param <code>String</code>
     */
    public void setDes_perfil(String d) {
        this.des_perfil = d;
    }

    /**
     * Get valor2
     * @return String
     */
    public String getValor2() {
        return valor2;
    }

    /**
     * Set valor2
     * @param <code>String</code>
     */
    public void setValor2(String v) {
        this.valor2 = v;
    }

    /**
     * Get componente
     * @return String
     */
    public String getComponente() {
        return componente;
    }

    /**
     * Set componente
     * @param <code>String</code>
     */
    public void setComponente(String c) {
        this.componente = c;
    }

    /**
     * Get tipo_acceso
     * @return String
     */
    public String getTipo_acceso() {
        return tipo_acceso;
    }

    /**
     * Set tipo_acceso
     * @param <code>String</code>
     */
    public void setTipo_acceso(String t) {
        this.tipo_acceso = t;
    }

    /**
     * Get tipo
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Set tipo
     * @param <code>String</code>
     */
    public void setTipo(String t) {
        this.tipo = t;
    }

    /**
     * Get cod_perfil
     * @return String
     */
    public String getCod_perfil() {
        return cod_perfil;
    }

    /**
     * Set cod_perfil
     * @param <code>String</code>
     */
    public void setCod_perfil(String c) {
        this.cod_perfil = c;
    }

    /**
     * Get cod_mult
     * @return String
     */
    public String getCod_mult() {
        return cod_mult;
    }

    /**
     * Set cod_mult
     * @param <code>String</code>
     */
    public void setCod_mult(String c) {
        this.cod_mult = c;
    }

    /**
     * Get valor1
     * @return String
     */
    public String getValor1() {
        return valor1;
    }

    /**
     * Set valor1
     * @param <code>String</code>
     */
    public void setValor1(String v) {
        this.valor1 = v;
    }

    /**
     * Get valor_rcp
     * @return String
     */
    public String getValor_rcp() {
        return valor_rcp;
    }

    /**
     * Set valor_rcp
     * @param <code>String</code>
     */
    public void setValor_rcp(String v) {
        this.valor_rcp = v;
    }

    /**
     * Get valor4
     * @return String
     */
    public String getValor4() {
        return valor4;
    }

    /**
     * Set valor4
     * @param <code>String</code>
     */
    public void setValor4(String v) {
        this.valor4 = v;
    }

    /**
     * Get cod_ele
     * @return String
     */
    public String getCod_ele() {
        return cod_ele;
    }

    /**
     * Set cod_ele
     * @param <code>String</code>
     */
    public void setCod_ele(String c) {
        this.cod_ele = c;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

        // Reset values are provided as samples only. Change as appropriate.

    }

    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        // Validate the fields in your form, adding
        // adding each error to this.errors as found, e.g.

        // if ((field == null) || (field.length() == 0)) {
        //   errors.add("field", new org.apache.struts.action.ActionError("error.field.required"));
        // }
        return errors;

    }
	/**
	 * @return Returns the forward.
	 */
	public String getForward() {
		return forward;
	}
	/**
	 * @param forward The forward to set.
	 */
	public void setForward(String forward) {
		this.forward = forward;
	}
}
