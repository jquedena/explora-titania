package com.indra.pe.bbva.reauni.view.mbean;

import java.util.List;
import java.util.TimeZone;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;

@Controller("aplicacionMBean")
@Scope("application")
public class AplicacionMBean {

	private String numeroRegistros;
	private String formatoFecha = "dd/MM/yyyy";
	private TimeZone timeZone;
	
    public static List<CatalogoParametroDto> listaCatalogos;
	
	public AplicacionMBean() {
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

	public static List<CatalogoParametroDto> getListaCatalogos() {
		return listaCatalogos;
	}

	public static void setListaCatalogos(List<CatalogoParametroDto> listaCatalogos) {
		AplicacionMBean.listaCatalogos = listaCatalogos;
	}

	public TimeZone getTimeZone() {
		this.timeZone = TimeZone.getDefault();
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

}
