package com.indra.pe.bbva.reauni.view.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;

@SuppressWarnings({"unused"})
@Controller("parametroMBean")
@Scope("session")
public class ParametroMBean extends GenericMBean {
	private static Logger logger = Logger.getLogger(ParametroMBean.class);

	private CatalogoParametroDto dto;
	private CatalogoParametroDto dtoFiltro;
	private List<CatalogoParametroDto> lista;

	private ParametroDto parametroDto;
	private int accionParametro;
	private SelectItem[] siTipos;	
	private List<ParametroDto> listaParametrosPadre;
	
	
	
	@Autowired
	private ParametroBO bo;

	public ParametroMBean() {
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		this.dtoFiltro = new CatalogoParametroDto();
	}

	public String listar() {
		SessionMBean.ACCION = Constantes.Form.LISTA;		
		this.dtoFiltro = new CatalogoParametroDto();
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_CATALOGO_PARAMETRO;
	}

	public String nuevo() {
		SessionMBean.ACCION = Constantes.Form.NUEVO;		
		this.lista = new ArrayList<CatalogoParametroDto>();
		this.dto = new CatalogoParametroDto();		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_CATALOGO_PARAMETRO;
	}

	public String editar() {
		SessionMBean.ACCION = Constantes.Form.EDITAR;		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_CATALOGO_PARAMETRO;
	}

	public String ver() {
		SessionMBean.ACCION = Constantes.Form.VER;		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_CATALOGO_PARAMETRO;
		
	}

	public void buscar(ActionEvent ae) {		
		this.lista = bo.obtenerCatalogosParametro(this.dtoFiltro);
		
	}

	public String guardar() {
		String to = null;
		String mensajeTrx = "";		

		if (SessionMBean.ACCION == Constantes.Form.NUEVO) {
			try {
				this.bo.insertar(this.dto);				
				showMessage(Utilitarios.Internacionalizacion.getMensajeInternacional("form.general.mensaje.transaccion.ok"));	
				 //Cargamos los parametros
			
				to = retroceder();
				 
			} catch (Exception ex) {
				showError(ex.getMessage());
				to = null;
			}
		} else if (SessionMBean.ACCION == Constantes.Form.EDITAR) {
			try {
				this.bo.editar(this.dto);
				showMessage(Utilitarios.Internacionalizacion.getMensajeInternacional("form.general.mensaje.transaccion.ok"));
				 //Cargamos los parametros
				
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
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_CATALOGO_PARAMETRO;
	}

	public String nuevoParametro() {
		this.accionParametro = Constantes.Form.NUEVO;
		this.parametroDto = new ParametroDto();		
		this.parametroDto.setTipo("N");
		this.parametroDto.setEstado(Boolean.TRUE);
		this.parametroDto.setValorBoolean(Boolean.FALSE);	
		this.parametroDto.setCatalogoParametroDto(ApplicationHelper.obtenerCatalogoPorId(0L));
		this.parametroDto.setParametroPadreDto(ApplicationHelper.obtenerParametroPorId(1005L));
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_PARAMETRO;
	}

	public String editarParametro() {
		this.accionParametro = Constantes.Form.EDITAR;
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_PARAMETRO;
	}

	public String verParametro() {
		this.accionParametro = Constantes.Form.VER;
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_PARAMETRO;
	}

	public String agregarParametro() {
		if (this.accionParametro == Constantes.Form.NUEVO) {
			this.parametroDto.setCatalogoParametroDto(this.dto);
			this.dto.getListaParametros().add(parametroDto);
		}

		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_CATALOGO_PARAMETRO;
	}

	public String retrocederParametro() {
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_CATALOGO_PARAMETRO;
	}

	public void cambioCatalogoParametro(javax.faces.event.AjaxBehaviorEvent a) {     
        this.listaParametrosPadre = getListaParametrosPadre();
    }
	
	public CatalogoParametroDto getDto() {
		return dto;
	}

	public void setDto(CatalogoParametroDto dto) {
		this.dto = dto;
	}

	public CatalogoParametroDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(CatalogoParametroDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<CatalogoParametroDto> getLista() {
		return lista;
	}

	public void setLista(List<CatalogoParametroDto> lista) {
		this.lista = lista;
	}

	public ParametroDto getParametroDto() {
		return parametroDto;
	}

	public void setParametroDto(ParametroDto parametroDto) {
		this.parametroDto = parametroDto;
	}

	public int getAccionParametro() {
		return accionParametro;
	}

	public void setAccionParametro(int accionParametro) {
		this.accionParametro = accionParametro;
	}

	public SelectItem[] getSiTipos() {
		this.siTipos = siTiposParametro();
		return siTipos;
	}

	public void setSiTipos(SelectItem[] siTipos) {
		this.siTipos = siTipos;
	}

	public ParametroBO getBo() {
		return bo;
	}

	public void setBo(ParametroBO bo) {
		this.bo = bo;
	}
	
	private SelectItem[] siTiposParametro() {
        SelectItem[] si = new SelectItem[2];
        si[0] = new SelectItem("N", "NEGOCIO");
        si[1] = new SelectItem("S", "SISTEMA");
        return si;
    }

	public List<ParametroDto> getListaParametrosPadre() {
		return SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(this.parametroDto.getCatalogoParametroPadreDto().getId());
		
	}

	public void setListaParametrosPadre(List<ParametroDto> listaParametrosPadre) {
		this.listaParametrosPadre = listaParametrosPadre;
	}

	

	
	
	
}
