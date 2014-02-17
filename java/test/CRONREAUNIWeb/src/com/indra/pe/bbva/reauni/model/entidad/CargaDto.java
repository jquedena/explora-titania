/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.indra.pe.bbva.core.util.Utilitarios;

/**
 *
 * @author Indra
 */
@Entity
@Table(name = "TREAUNI_CARGAS",schema="REAUNI")
public class CargaDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CargaDtoPK cargaDtoPK;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FEC_INI_TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIniTemp;
    @Column(name = "FEC_FIN_TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFinTemp;
    @Column(name = "FEC_INI_VAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIniVal;
    @Column(name = "FEC_FIN_VAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFinVal;
    @Column(name = "TOT_VAL_OK")
    private BigInteger totValOk;
    @Column(name = "TOT_VAL")
    private BigInteger totVal;    
    
    @Transient
    private int tiempoEjecucion;
    @Transient    
    private BigInteger errores;
    
    public CargaDto() {
    }

    public CargaDto(CargaDtoPK cargaDtoPK) {
        this.cargaDtoPK = cargaDtoPK;        
    }

    public CargaDto(String proceso, Date fecha) {
        this.cargaDtoPK = new CargaDtoPK(proceso, fecha);
    }

    public CargaDtoPK getCargaDtoPK() {
        return cargaDtoPK;
    }

    public void setCargaDtoPK(CargaDtoPK cargaDtoPK) {
        this.cargaDtoPK = cargaDtoPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFecIniTemp() {
        return fecIniTemp;
    }

    public void setFecIniTemp(Date fecIniTemp) {
        this.fecIniTemp = fecIniTemp;
    }

    public Date getFecFinTemp() {
        return fecFinTemp;
    }

    public void setFecFinTemp(Date fecFinTemp) {
        this.fecFinTemp = fecFinTemp;
    }

    public Date getFecIniVal() {
        return fecIniVal;
    }

    public void setFecIniVal(Date fecIniVal) {
        this.fecIniVal = fecIniVal;
    }

    public Date getFecFinVal() {
        return fecFinVal;
    }

    public void setFecFinVal(Date fecFinVal) {
        this.fecFinVal = fecFinVal;
    }

    public BigInteger getTotValOk() {
        return totValOk;
    }

    public void setTotValOk(BigInteger totValOk) {
        this.totValOk = totValOk;
    }

    public BigInteger getTotVal() {
        return totVal;
    }

    public void setTotVal(BigInteger totVal) {
        this.totVal = totVal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargaDtoPK != null ? cargaDtoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CargaDto)) {
            return false;
        }
        CargaDto other = (CargaDto) object;
        if ((this.cargaDtoPK == null && other.cargaDtoPK != null) || (this.cargaDtoPK != null && !this.cargaDtoPK.equals(other.cargaDtoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.CargaDto[ cargaDtoPK=" + cargaDtoPK + " ]";
    }

	public int getTiempoEjecucion() {
		this.tiempoEjecucion = Utilitarios.Fecha.diferenciaFechasSegundos(this.fechaInicio, this.fecFinVal);
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(int tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}

	public BigInteger getErrores() {
		this.errores = this.totVal.subtract(this.totValOk);
		return errores;
	}

	public void setErrores(BigInteger errores) {
		this.errores = errores;
	}
    
    
    
}
