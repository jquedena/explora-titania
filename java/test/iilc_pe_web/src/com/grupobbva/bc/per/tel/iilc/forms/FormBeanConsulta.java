package com.grupobbva.bc.per.tel.iilc.forms;

/**
 * @author: Maria Paula Tomaylla codigo : P020795 fecha : 27/11/2007
 * 
 */
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.logic.FormateaListado;

/**
 * Form bean for a Struts application.
 * Users may access 15 fields on this form:
 * <ul>
 * <li>edad - [your comment here]
 * <li>detalle - [your comment here]
 * <li>oficina - [your comment here]
 * <li>tipo_detalle - [your comment here]
 * <li>gestor - [your comment here]
 * <li>nivel_vinculacion - [your comment here]
 * <li>buscar - [your comment here]
 * <li>clasificacion - [your comment here]
 * <li>territorio - [your comment here]
 * <li>cuota_riesgo_total - [your comment here]
 * <li>etiqueta - [your comment here]
 * <li>margen_ordinario - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
@SuppressWarnings("unchecked")
public class FormBeanConsulta extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String edad;
    private String detalle;
    private String oficina;
    private String tipo_detalle;
    private String gestor;
    private String nivel_vinculacion;
    private String buscar;
    private String clasificacion;
    private String territorio;
    private String cuota_riesgo_total;
    private String etiqueta;
    private String margen_ordinario;  
    private int pagina;
    private FormateaListado formato;
    private FormateaListado formatoXLS;
    private Vector atog;
    private String cod_perfil;
    
	/**
     * @author: Edgar Ivan Zavaleta Sierralta
     * fecha  : 03/12/2007
     */

    private String usuario;
    private String clave;
    
    /**
     * 
     * P060049 Edgar Zavaleta Sierralta
     */
    private String cod_empresa;
    private String des_empresa;
    private String codigoCargo;
    
    
	/**
	 * @return Returns the codigoCargo.
	 */
	public String getCodigoCargo() {
		return codigoCargo;
	}
	/**
	 * @param codigoCargo The codigoCargo to set.
	 */
	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
    /**
     * Get edad
     * @return String
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Set edad
     * @param <code>String</code>
     */
    public void setEdad(String e) {
        this.edad = e;
    }

    /**
     * Get detalle
     * @return String
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Set detalle
     * @param <code>String</code>
     */
    public void setDetalle(String d) {
        this.detalle = d;
    }

    /**
     * Get oficina
     * @return String
     */
    public String getOficina() {
        return oficina;
    }

    /**
     * Set oficina
     * @param <code>String</code>
     */
    public void setOficina(String o) {
        this.oficina = o;
    }

    /**
     * Get tipo_detalle
     * @return String
     */
    public String getTipo_detalle() {
        return tipo_detalle;
    }

    /**
     * Set tipo_detalle
     * @param <code>String</code>
     */
    public void setTipo_detalle(String t) {
        this.tipo_detalle = t;
    }

    /**
     * Get gestor
     * @return String
     */
    public String getGestor() {
        return gestor;
    }

    /**
     * Set gestor
     * @param <code>String</code>
     */
    public void setGestor(String g) {
        this.gestor = g;
    }

    /**
     * Get nivel_vinculacion
     * @return String
     */
    public String getNivel_vinculacion() {
        return nivel_vinculacion;
    }

    /**
     * Set nivel_vinculacion
     * @param <code>String</code>
     */
    public void setNivel_vinculacion(String n) {
        this.nivel_vinculacion = n;
    }

    /**
     * Get buscar
     * @return String
     */
    public String getBuscar() {
        return buscar;
    }

    /**
     * Set buscar
     * @param <code>String</code>
     */
    public void setBuscar(String b) {
        this.buscar = b;
    }

    /**
     * Get clasificacion
     * @return String
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Set clasificacion
     * @param <code>String</code>
     */
    public void setClasificacion(String c) {
        this.clasificacion = c;
    }

    /**
     * Get territorio
     * @return String
     */
    public String getTerritorio() {
        return territorio;
    }

    /**
     * Set territorio
     * @param <code>String</code>
     */
    public void setTerritorio(String t) {
        this.territorio = t;
    }

    /**
     * Get cuota_riesgo_total
     * @return String
     */
    public String getCuota_riesgo_total() {
        return cuota_riesgo_total;
    }

    /**
     * Set cuota_riesgo_total
     * @param <code>String</code>
     */
    public void setCuota_riesgo_total(String c) {
        this.cuota_riesgo_total = c;
    }

    /**
     * Get etiqueta
     * @return String
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Set etiqueta
     * @param <code>String</code>
     */
    public void setEtiqueta(String e) {
        this.etiqueta = e;
    }

    /**
     * Get margen_ordinario
     * @return String
     */
    public String getMargen_ordinario() {
        return margen_ordinario;
    }

    /**
     * Set margen_ordinario
     * @param <code>String</code>
     */
    public void setMargen_ordinario(String m) {
        this.margen_ordinario = m;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

        // Reset values are provided as samples only. Change as appropriate.

        edad = "-1";
        detalle = "dt_general";
        oficina = "-1";
        tipo_detalle = null;
        gestor = "-1";
        nivel_vinculacion = "-1";
        buscar = null;
        clasificacion = "-1";
        territorio = "-1";
        cuota_riesgo_total = "-1";
        etiqueta = "-1";
        margen_ordinario = "-1";

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
     * @return Returns the pagina.
     */
    public int getPagina() {
        return pagina;
    }
    /**
     * @param pagina The pagina to set.
     */
    public void setPagina(int pagina) {
        this.pagina = pagina;
    }
    /**
     * @return Returns the formato.
     */
    public FormateaListado getFormato() {
        return formato;
    }
    /**
     * @param formato The formato to set.
     */
    public void setFormato(FormateaListado formato) {
        this.formato = formato;
    }
    /**
     * @return Returns the clave.
     */
    public String getClave() {
        return clave;
    }
    /**
     * @param clave The clave to set.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * @return Returns the usuario.
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * @param usuario The usuario to set.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * @return Returns the atog.
     */
    public Vector getAtog() {
        return atog;
    }
    /**
     * @param atog The atog to set.
     */
    public void setAtog(Vector atog) {
        this.atog = atog;
    }
    /**
     * @return Returns the cod_perfil.
     */
    public String getCod_perfil() {
        return cod_perfil;
    }
    /**
     * @param cod_perfil The cod_perfil to set.
     */
    public void setCod_perfil(String cod_perfil) {
        this.cod_perfil = cod_perfil;
    }
    
    /**
     * @return Returns the cod_empresa.
     */
    public String getCod_empresa() {
        return cod_empresa;
    }
    /**
     * @param cod_empresa The cod_empresa to set.
     */
    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }
    /**
     * @return Returns the des_empresa.
     */
    public String getDes_empresa() {
        return des_empresa;
    }
    /**
     * @param des_empresa The des_empresa to set.
     */
    public void setDes_empresa(String des_empresa) {
        this.des_empresa = des_empresa;
    }
	public FormateaListado getFormatoXLS() {
		return formatoXLS;
	}
	public void setFormatoXLS(FormateaListado formatoXLS) {
		this.formatoXLS = formatoXLS;
	}
}
