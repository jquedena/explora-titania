package com.indra.pe.bbva.reauni.view.mbean;

import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;

@Controller("aplicacionMBean")
@Scope("application")
public class AplicacionMBean {
	
	private static Logger logger = Logger.getLogger(AplicacionMBean.class);
	private String numeroRegistros;
	private String formatoFecha = "dd/MM/yyyy";
	private String formatoFechaHora = "dd/MM/yyyy hh:mm";
	private String formatoMontos = "##########.00";
	private TimeZone timeZone;
    private List<CatalogoParametroDto> listaCatalogos;
    private List<TerritorioDto> listaTerritorios;
    private List<OficinaDto> listaOficinas;
    private List<GestorDto> listaGestores;
    
	public AplicacionMBean() {
	}

	public void cambiarLocale () {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
	        fc.getViewRoot().setLocale(new Locale("es_PE"));
	        fc.getApplication().setDefaultLocale(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		}catch (Exception e) {
			logger.error("cambiarLocale", e);
		}
	}
	
	public String getNumeroRegistros() {
		return numeroRegistros;
	}

	public void setNumeroRegistros(String numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}

	public String getFormatoFecha() {
		return formatoFecha;
	}

	public void setFormatoFecha(String formatoFecha) {
		this.formatoFecha = formatoFecha;
	}

	public List<CatalogoParametroDto> getListaCatalogos() {
		return listaCatalogos;
	}

	public void setListaCatalogos(List<CatalogoParametroDto> listaCatalogos) {
		this.listaCatalogos = listaCatalogos;
	}

	public List<TerritorioDto> getListaTerritorios() {
		return listaTerritorios;
	}

	public void setListaTerritorios(List<TerritorioDto> listaTerritorios) {
		this.listaTerritorios = listaTerritorios;
	}

	public List<OficinaDto> getListaOficinas() {
		return listaOficinas;
	}

	public void setListaOficinas(List<OficinaDto> listaOficinas) {
		this.listaOficinas = listaOficinas;
	}

	public List<GestorDto> getListaGestores() {
		return listaGestores;
	}

	public void setListaGestores(List<GestorDto> listaGestores) {
		this.listaGestores = listaGestores;
	}

	public String getFormatoFechaHora() {
		return formatoFechaHora;
	}

	public void setFormatoFechaHora(String formatoFechaHora) {
		this.formatoFechaHora = formatoFechaHora;
	}

	public String getFormatoMontos() {
		return formatoMontos;
	}

	public void setFormatoMontos(String formatoMontos) {
		this.formatoMontos = formatoMontos;
	}

	public TimeZone getTimeZone() {
		this.timeZone = TimeZone.getDefault();
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
}
