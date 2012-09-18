/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Indra
 */
@Embeddable
public class CargaDtoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PROCESO")
    private String proceso;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public CargaDtoPK() {
    }

    public CargaDtoPK(String proceso, Date fecha) {
        this.proceso = proceso;
        this.fecha = fecha;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proceso != null ? proceso.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CargaDtoPK)) {
            return false;
        }
        CargaDtoPK other = (CargaDtoPK) object;
        if ((this.proceso == null && other.proceso != null) || (this.proceso != null && !this.proceso.equals(other.proceso))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.CargaDtoPK[ proceso=" + proceso + ", fecha=" + fecha + " ]";
    }
    
}
