package com.indra.pe.bbva.reauni.view.mbean;

import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.CargaDto;
import com.indra.pe.bbva.reauni.service.CargaBO;

@SuppressWarnings("unused")
@Controller("cargaMBean")
@Scope("session")
public class CargaMBean extends GenericMBean {
	private static Logger logger = Logger.getLogger(CargaMBean.class);

	private CargaDto dto;
	private CargaDto dtoFiltro;
	private List<CargaDto> lista;	
	private Date fechaBusqueda;
	
	@Autowired
	private CargaBO bo;

	public CargaMBean() {
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		//this.fechaBusqueda = //Utilitarios.Fecha.construirFecha(Utilitarios.Fecha.obtenerAnioActual(), Utilitarios.Fecha.obtenerMesActual(), Utilitarios.Fecha.obtenerDiaActual());
		
		
		this.dtoFiltro = new CargaDto();
	}

	public String listar() {
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		this.dtoFiltro = new CargaDto();
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_CARGA;
	}
	

	public void buscar(ActionEvent ae) {

		this.lista = bo.obtenerCargasPorFecha(this.fechaBusqueda);		
	}

	

	public String retroceder() {
		buscar(null);
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_CARGA;
	}

	public CargaDto getDto() {
		return dto;
	}

	public void setDto(CargaDto dto) {
		this.dto = dto;
	}

	public CargaDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(CargaDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<CargaDto> getLista() {
		return lista;
	}

	public void setLista(List<CargaDto> lista) {
		this.lista = lista;
	}

	public CargaBO getBo() {
		return bo;
	}

	public void setBo(CargaBO bo) {
		this.bo = bo;
	}

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {

		this.fechaBusqueda = fechaBusqueda;
	}

	
	
	
	
	
}
