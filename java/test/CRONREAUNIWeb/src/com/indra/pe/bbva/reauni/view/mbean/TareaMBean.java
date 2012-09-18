package com.indra.pe.bbva.reauni.view.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.TareaDto;
import com.indra.pe.bbva.reauni.service.TareaBO;

@Controller("tareaMBean")
@Scope("session")
public class TareaMBean extends GenericMBean {
	private static Logger logger = Logger.getLogger(TareaMBean.class);

	private TareaDto dto;
	private TareaDto dtoFiltro;
	private List<TareaDto> lista;	
	
	@Autowired
	private TareaBO bo;

	public TareaMBean() {
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		this.dtoFiltro = new TareaDto();
	}

	public String listar() {
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		this.dtoFiltro = new TareaDto();
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_TAREA;
	}

	public String nuevo() {
		SessionMBean.ACCION = Constantes.Form.NUEVO;		
		this.lista = new ArrayList<TareaDto>();
		this.dto = new TareaDto();		
		this.dto.setEstado(Boolean.FALSE);
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_TAREA;
	}

	public String editar() {
		SessionMBean.ACCION = Constantes.Form.EDITAR;		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_TAREA;
	}

	public String ver() {
		SessionMBean.ACCION = Constantes.Form.VER;		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_TAREA;
		
	}

	public void buscar(ActionEvent ae) {		
		this.lista = bo.obtenerTareas(this.dtoFiltro);		
	}

	public String guardar() {
		String to = null;
		String mensajeTrx = "";		

		if (SessionMBean.ACCION == Constantes.Form.NUEVO) {
			try {
				this.bo.insertar(this.dto);				
				showMessage(Utilitarios.Internacionalizacion.getMensajeInternacional("form.general.mensaje.transaccion.ok"));	
				to = retroceder();				 
			} catch (Exception ex) {
				showError(ex.getMessage());
				to = null;
			}
		} else if (SessionMBean.ACCION == Constantes.Form.EDITAR) {
			try {
				this.bo.editar(this.dto);
				showMessage(Utilitarios.Internacionalizacion.getMensajeInternacional("form.general.mensaje.transaccion.ok"));
				to = retroceder();
			} catch (Exception ex) {
				showError(ex.getMessage());
				to = null;
			}
		}
		return to;
	}

	public String retroceder() {
		buscar(null);
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_TAREA;
	}

	public TareaDto getDto() {
		return dto;
	}

	public void setDto(TareaDto dto) {
		this.dto = dto;
	}

	public TareaDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(TareaDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<TareaDto> getLista() {
		return lista;
	}

	public void setLista(List<TareaDto> lista) {
		this.lista = lista;
	}

	public TareaBO getBo() {
		return bo;
	}

	public void setBo(TareaBO bo) {
		this.bo = bo;
	}

	
	

	
	
	
}
