package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

public class ProgSeguimiento implements Serializable{
	private static Logger log = Logger.getLogger(ProgSeguimiento.class);
	
	private String codTerritorio;
	private String nomTerritorio;
	private String nomMes;
	private String mes;
	private int anio;
	private String seg1Ini;
	private String seg2Ini;
	private String seg1Fin;
	private String seg2Fin;	
	private String usuCrea;
	private String usuActu;
	private java.sql.Date fecCrea;
	private java.sql.Date fecActu;
	/**
	 * @return Returns the nomMes.
	 */
	public String getNomMes() {
		return nomMes;
	}
	/**
	 * @param nomMes The nomMes to set.
	 */
	public void setNomMes(String nomMes) {
		this.nomMes = nomMes;
	}
		
	/**
	 * @return Returns the codTerritorio.
	 */
	public String getCodTerritorio() {
		return codTerritorio;
	}
	/**
	 * @param codTerritorio The codTerritorio to set.
	 */
	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}
	/**
	 * @return Returns the fecActu.
	 */
	public java.sql.Date getFecActu() {
		return fecActu;
	}
	/**
	 * @param fecActu The fecActu to set.
	 */
	public void setFecActu(java.sql.Date fecActu) {
		this.fecActu = fecActu;
	}
	/**
	 * @return Returns the fecCrea.
	 */
	public java.sql.Date getFecCrea() {
		return fecCrea;
	}
	/**
	 * @param fecCrea The fecCrea to set.
	 */
	public void setFecCrea(java.sql.Date fecCrea) {
		this.fecCrea = fecCrea;
	}
	/**
	 * @return Returns the mes.
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes The mes to set.
	 */
	public void setMes(String mes) {
		log.info("[ProgSeguimiento :: mes] Inicio");
		
		if(mes != null && mes.length() == 1) {
			mes = "0" + mes;
		}
		
		if(mes != null) {
			switch(Integer.parseInt(mes)) {
				case 1: this.nomMes = "Enero"; break;
				case 2: this.nomMes = "Febrero"; break;
				case 3: this.nomMes = "Marzo"; break;
				case 4: this.nomMes = "Abril"; break;
				case 5: this.nomMes = "Mayo"; break;
				case 6: this.nomMes = "Junio"; break;
				case 7: this.nomMes = "Julio"; break;
				case 8: this.nomMes = "Agosto"; break;
				case 9: this.nomMes = "Setiembre"; break;
				case 10: this.nomMes = "Octubre"; break;
				case 11: this.nomMes = "Noviembre"; break;
				case 12: this.nomMes = "Diciembre"; break;
			}
		}
		
		this.mes = mes;
		
		log.info("[ProgSeguimiento :: mes] Fin");
	}
	/**
	 * @return Returns the seg1Fin.
	 */
	public String getSeg1Fin() {
		return seg1Fin;
	}
	/**
	 * @param seg1Fin The seg1Fin to set.
	 */
	public void setSeg1Fin(String seg1Fin) {
		this.seg1Fin = seg1Fin;
	}
	/**
	 * @return Returns the seg1Ini.
	 */
	public String getSeg1Ini() {
		return seg1Ini;
	}
	/**
	 * @param seg1Ini The seg1Ini to set.
	 */
	public void setSeg1Ini(String seg1Ini) {
		this.seg1Ini = seg1Ini;
	}
	/**
	 * @return Returns the seg2Fin.
	 */
	public String getSeg2Fin() {
		return seg2Fin;
	}
	/**
	 * @param seg2Fin The seg2Fin to set.
	 */
	public void setSeg2Fin(String seg2Fin) {
		this.seg2Fin = seg2Fin;
	}
	/**
	 * @return Returns the seg2Ini.
	 */
	public String getSeg2Ini() {
		return seg2Ini;
	}
	/**
	 * @param seg2Ini The seg2Ini to set.
	 */
	public void setSeg2Ini(String seg2Ini) {
		this.seg2Ini = seg2Ini;
	}
	/**
	 * @return Returns the usuActu.
	 */
	public String getUsuActu() {
		return usuActu;
	}
	/**
	 * @param usuActu The usuActu to set.
	 */
	public void setUsuActu(String usuActu) {
		this.usuActu = usuActu;
	}
	/**
	 * @return Returns the usuCrea.
	 */
	public String getUsuCrea() {
		return usuCrea;
	}
	/**
	 * @param usuCrea The usuCrea to set.
	 */
	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}
	/**
	 * @param anio The anio to set.
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}
	/**
	 * @return Returns the anio.
	 */
	public int getAnio() {
		return anio;
	}
	/**
	 * @return Returns the nomTerritorio.
	 */
	public String getNomTerritorio() {
		return nomTerritorio;
	}
	/**
	 * @param nomTerritorio The nomTerritorio to set.
	 */
	public void setNomTerritorio(String nomTerritorio) {
		this.nomTerritorio = nomTerritorio;
	}
	
	public String validarFechas(int mes) {
		String mensaje = null;
		java.util.Calendar seg1Ini = null; 
		java.util.Calendar seg2Ini = null;
		java.util.Calendar seg1Fin = null;
		java.util.Calendar seg2Fin = null;
		java.util.Calendar fechaActual = null;
		
		try {
			log.info("[ProgSeguimiento :: validarFechas] Inicio");
			
			if(	this.seg1Ini == null ||
				this.seg1Ini == null ||
				this.seg1Ini == null ||
				this.seg1Ini == null) {
				mensaje = "Fechas contienen valores nulos";
			} else {
				seg1Ini = ConstantesUtil.parseDate(this.seg1Ini); 
				seg2Ini = ConstantesUtil.parseDate(this.seg2Ini);
				seg1Fin = ConstantesUtil.parseDate(this.seg1Fin);
				seg2Fin = ConstantesUtil.parseDate(this.seg2Fin);
				
				fechaActual = GregorianCalendar.getInstance();
				fechaActual.set(Calendar.HOUR, 0);
				fechaActual.set(Calendar.MINUTE, 0);
				fechaActual.set(Calendar.SECOND, 0);								
				
				if(mensaje == null) {
					if(seg1Fin.before(seg1Ini)) { 
						mensaje = "La fecha de inicio seguimiento 1 no puede ser mayor a la fecha de fin seguimiento 1.";
					} else {
						if(seg2Fin.before(seg2Ini)) {  
							mensaje = "La fecha de inicio de cierre de mes no puede ser mayor a la fecha de fin de cierre de mes.";
						}
					}	
				}
			}
			
			log.info("[ProgSeguimiento :: validarFechas] Fin");
		} catch(Exception e) {
			log.error("[ProgSeguimiento :: validarFechas] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			mensaje = "Fechas no válidas";
		}
		
		return mensaje;
	}
	
	public boolean isEditableSeg1() {
		boolean edit = false;
		java.util.Calendar seg1Ini = null; 
		java.util.Calendar seg1Fin = null;
		java.util.Calendar fechaActual = null;
		
		try {
			log.info("[ProgSeguimiento :: isEditableSeg1] Inicio");
			
			fechaActual = GregorianCalendar.getInstance();
			fechaActual.set(Calendar.HOUR, 0);
			fechaActual.set(Calendar.MINUTE, 0);
			fechaActual.set(Calendar.SECOND, 0);
			
			seg1Ini = ConstantesUtil.parseDate(this.seg1Ini); 
			seg1Fin = ConstantesUtil.parseDate(this.seg1Fin);
			
			
			if((fechaActual.after(seg1Ini) && fechaActual.before(seg1Fin))
				|| (ConstantesUtil.equalsDate(fechaActual, seg1Ini))	
				|| (ConstantesUtil.equalsDate(fechaActual, seg1Fin))
				) {
				edit = true;
			}
			
			log.info("[ProgSeguimiento :: isEditableSeg1] Fin");
		} catch(Exception e) {
			log.error("[ProgSeguimiento :: isEditableSeg1] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return edit;
	}
	
	public boolean isEditableSeg2() {
		boolean edit = false;
		java.util.Calendar seg2Ini = null; 
		java.util.Calendar seg2Fin = null;
		java.util.Calendar fechaActual = null;
		
		try {
			log.info("[ProgSeguimiento :: isEditableSeg2] Inicio");
			
			fechaActual = GregorianCalendar.getInstance();
			fechaActual.set(Calendar.HOUR, 0);
			fechaActual.set(Calendar.MINUTE, 0);
			fechaActual.set(Calendar.SECOND, 0);
			
			seg2Ini = ConstantesUtil.parseDate(this.seg2Ini); 
			seg2Fin = ConstantesUtil.parseDate(this.seg2Fin);
			
			if((fechaActual.after(seg2Ini) && fechaActual.before(seg2Fin))
				|| (ConstantesUtil.equalsDate(fechaActual, seg2Ini))
				|| (ConstantesUtil.equalsDate(fechaActual, seg2Fin))
				) {
				edit = true;
			}
			
			log.info("[ProgSeguimiento :: isEditableSeg2] Fin");
		} catch(Exception e) {
			log.error("[ProgSeguimiento :: isEditableSeg2] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return edit;
	}
}
