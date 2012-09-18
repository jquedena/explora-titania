/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Indra
 */
@Embeddable
public class EjecucionProcesoDtoPK implements Serializable {
	
	private static final long serialVersionUID = 3563477720660617610L;
	
	@Basic(optional = false)
    @Column(name = "PROCESO")
    private String proceso;
    @Basic(optional = false)
    @Column(name = "FECHA")
    private String fecha;
    @Basic(optional = false)
    @Column(name = "HORA")
    private String hora;

    public EjecucionProcesoDtoPK() {
    }

    public EjecucionProcesoDtoPK(String proceso, String fecha, String hora) {
        this.proceso = proceso;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proceso != null ? proceso.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (hora != null ? hora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EjecucionProcesoDtoPK)) {
            return false;
        }
        EjecucionProcesoDtoPK other = (EjecucionProcesoDtoPK) object;
        if ((this.proceso == null && other.proceso != null) || (this.proceso != null && !this.proceso.equals(other.proceso))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.hora == null && other.hora != null) || (this.hora != null && !this.hora.equals(other.hora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jbiss.sion.util.EjecucionProcesoDtoPK[ proceso=" + proceso + ", fecha=" + fecha + ", hora=" + hora + " ]";
    }
    
}
