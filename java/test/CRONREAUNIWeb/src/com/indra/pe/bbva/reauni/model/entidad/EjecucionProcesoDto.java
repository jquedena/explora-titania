/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Indra
 */
@Entity
@Table(name = "TREAUNI_EJECUCION_PROCESO",schema="REAUNI")
public class EjecucionProcesoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EjecucionProcesoDtoPK ejecucionProcesoDtoPK;
    @Column(name = "FECHA_HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;
    
    @Column(name = "RESULTADO")
    private Boolean resultado;

    public EjecucionProcesoDto() {
    }
    
    public EjecucionProcesoDto(String proceso, String fechaEjecucion, String horaEjecucion, Date fechaHoraInicio) {
    	this.ejecucionProcesoDtoPK = new EjecucionProcesoDtoPK(proceso, fechaEjecucion, horaEjecucion);
    	this.fechaHoraInicio = fechaHoraInicio;
    	this.resultado = Boolean.TRUE;
    }

    public EjecucionProcesoDto(EjecucionProcesoDtoPK ejecucionProcesoDtoPK) {
        this.ejecucionProcesoDtoPK = ejecucionProcesoDtoPK;
    }

    public EjecucionProcesoDto(String proceso, String fecha, String hora) {
        this.ejecucionProcesoDtoPK = new EjecucionProcesoDtoPK(proceso, fecha, hora);
    }

    public EjecucionProcesoDtoPK getEjecucionProcesoDtoPK() {
        return ejecucionProcesoDtoPK;
    }

    public void setEjecucionProcesoDtoPK(EjecucionProcesoDtoPK ejecucionProcesoDtoPK) {
        this.ejecucionProcesoDtoPK = ejecucionProcesoDtoPK;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejecucionProcesoDtoPK != null ? ejecucionProcesoDtoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EjecucionProcesoDto)) {
            return false;
        }
        EjecucionProcesoDto other = (EjecucionProcesoDto) object;
        if ((this.ejecucionProcesoDtoPK == null && other.ejecucionProcesoDtoPK != null) || (this.ejecucionProcesoDtoPK != null && !this.ejecucionProcesoDtoPK.equals(other.ejecucionProcesoDtoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jbiss.sion.util.EjecucionProcesoDto[ ejecucionProcesoDtoPK=" + ejecucionProcesoDtoPK + " ]";
    }
    
}
