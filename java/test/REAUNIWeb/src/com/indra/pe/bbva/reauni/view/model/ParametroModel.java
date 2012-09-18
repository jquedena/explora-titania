package com.indra.pe.bbva.reauni.view.model;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

@SuppressWarnings({"unused"})
@Controller("parametroModel")
@Scope("session")
public class ParametroModel extends GenericMBean {
	private static Logger logger = Logger.getLogger(ParametroModel.class);

	private CatalogoParametroDto dto;
	private CatalogoParametroDto dtoFiltro;
	private List<CatalogoParametroDto> lista;

	private ParametroDto parametroDto;
	private int accionParametro;
	private SelectItem[] siTipos;	
	private List<ParametroDto> listaParametrosPadre;
	
	
	@Autowired
	private static AplicacionMBean aplicacionMBean;
	
	@Autowired
	private ParametroBO bo;

	@Autowired
	private SessionMBean sessionMBean;
	public ParametroModel() {
		
	}

	public void buscar(ActionEvent ae) {		
		this.lista = bo.obtenerCatalogosParametro(this.dtoFiltro);		
	}

	@SuppressWarnings("static-access")
	public String guardar() {
		String to = null;
		String mensajeTrx = "";		

		if (this.sessionMBean.getAccion() == Constantes.Form.NUEVO) {
			try {
				this.bo.insertar(this.dto);				
				showMessage("TRANSACCION REALIZADA DE MANERA SATISFACTORIA");	
				 //Cargamos los parametros
				this.aplicacionMBean.setListaCatalogos(bo.obtenerTodosCatalogosParametros());
				//this.aplicacionMBean.setListaParametros(bo.obtenerTodosParametros());
				to = retroceder();
				 
			} catch (Exception ex) {
				showError(ex.getMessage());
				to = null;
			}
		} else if (this.sessionMBean.getAccion() == Constantes.Form.EDITAR) {
			try {
				this.bo.editar(this.dto);
				showMessage("TRANSACCION REALIZADA DE MANERA SATISFACTORIA");
				 //Cargamos los parametros
				this.aplicacionMBean.setListaCatalogos(bo.obtenerTodosCatalogosParametros());
				//this.aplicacionMBean.setListaParametros(bo.obtenerTodosParametros());
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
		this.sessionMBean.setAccion(Constantes.Form.LISTA);		
		return "/pages/administracion/parametro/listaCatalogosParametro";
	}

	public String nuevoParametro() {
		this.accionParametro = Constantes.Form.NUEVO;
		this.parametroDto = new ParametroDto();		
		this.parametroDto.setTipo("N");
		this.parametroDto.setEstado(Boolean.TRUE);
		this.parametroDto.setValorBoolean(Boolean.FALSE);	
		this.parametroDto.setCatalogoParametroDto(ApplicationHelper.obtenerCatalogoPorId(0L));
		this.parametroDto.setParametroPadreDto(ApplicationHelper.obtenerParametroPorId(1005L));
		return "/pages/administracion/parametro/parametro";
	}

	public String editarParametro() {
		this.accionParametro = Constantes.Form.EDITAR;
		return "/pages/administracion/parametro/parametro";
	}

	public String verParametro() {
		this.accionParametro = Constantes.Form.VER;
		return "/pages/administracion/parametro/parametro";
	}

	public String agregarParametro() {
		if (this.accionParametro == Constantes.Form.NUEVO) {
			this.parametroDto.setCatalogoParametroDto(this.dto);
			this.dto.getListaParametros().add(parametroDto);
		}

		return "/pages/administracion/parametro/catalogoParametro";
	}

	public String retrocederParametro() {
		return "/pages/administracion/parametro/catalogoParametro";
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
