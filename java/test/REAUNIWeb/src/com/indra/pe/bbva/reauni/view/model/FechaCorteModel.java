package com.indra.pe.bbva.reauni.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.FechaCorteBO;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;

@Controller("fechaCorteModel")
@Scope("session")
public class FechaCorteModel implements Serializable{
 
	private static final long serialVersionUID = -459331647291769012L;
	private static Logger logger = Logger.getLogger(FechaCorteModel.class);
	private FechaCorteDto dto;
	private FechaCorteDto dtoFiltro;
	private List<FechaCorteDto> lista;
	private SelectItem[] listaEstados;
	
	@Autowired
	private FechaCorteBO fechaCorteBO;
	
	@Autowired
	private ParametroBO parametroBO;
	
	public FechaCorteModel() {
		this.reset();
	}
 
	public void reset(){
		this.dto = new FechaCorteDto();
		this.dtoFiltro = new FechaCorteDto();
		this.lista =  new ArrayList<FechaCorteDto>();
	}
	
	public FechaCorteDto getDto() {
		return dto;
	}

	public void setDto(FechaCorteDto dto) {
		this.dto = dto;
	}

	public FechaCorteDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(FechaCorteDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<FechaCorteDto> getLista() {
		return lista;
	}

	public void setLista(List<FechaCorteDto> lista) {
		this.lista = lista;
	}

	
	public String iniciar () {
		this.dto = new FechaCorteDto();
		this.dtoFiltro = new FechaCorteDto();
		this.lista =  new ArrayList<FechaCorteDto>();
		
		return Constantes.UrlNavegacion.URL_LISTA_FECHA_CORTE;
	}
 
	
	public SelectItem[] getListaEstados() {
		try{
			if(listaEstados == null){
				ParametroDto parametroDto = new ParametroDto();
				CatalogoParametroDto catalogoParametroDto = new CatalogoParametroDto();
				catalogoParametroDto.setId(Constantes.VariablesCatalogoParametros.VARIABLE_ID_ESTADOS); 
				parametroDto.setCatalogoParametroDto(catalogoParametroDto);
				listaEstados = SelectOneMenuHelper.listaParametro(parametroBO.obtenerListaParametros(parametroDto));
			}
		}catch(Exception e){
			logger.error("Error en utilitario " + e.getMessage());
		}
		return listaEstados;
	}
 

	public FechaCorteBO getFechaCorteBO() {
		return fechaCorteBO;
	}

	public ParametroBO getParametroBO() {
		return parametroBO;
	}
 
}
