package com.indra.pe.bbva.reauni.view.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.FechaCorteBO;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;

@Controller("buscarFechaCorteMBean")
@Scope("session")
public class BuscarFechaCorteMBean extends GenericMBean implements Serializable{
 
	private static final long serialVersionUID = 8845949299640139457L;
	
	private static Logger logger = Logger.getLogger(BuscarFechaCorteMBean.class);
	
	private FechaCorteDto dtoFiltro;
	private List<FechaCorteDto> lista;
	
	private SelectItem[] listaEstados;

	@Autowired
	private FechaCorteBO fechaCorteBO;
	
	@Autowired
	private ParametroBO parametroBO;

	public BuscarFechaCorteMBean() {
		this.dtoFiltro = new FechaCorteDto();
		this.lista = new ArrayList<FechaCorteDto>();
//		fechaCorteBO = (FechaCorteBO) WebServletContextListener.getApplicationContext().getBean("fechaCorteBO");
//		parametroBO = (ParametroBO)WebServletContextListener.getApplicationContext().getBean("parametroBO");
	}
	
	public void buscarListaFechaCorte(ActionEvent actionEvent) {

		try {
			fechaCorteBO = (FechaCorteBO) WebServletContextListener.getApplicationContext().getBean("fechaCorteBO");

			this.lista = fechaCorteBO.obtenerListaFechaCortePorRangoFecha(this.getDtoFiltro());			

		}catch(Exception e){
			String msg = "NO SE PUDO RECUPERAR LAS FECHAS DE CORTE";
			showError(msg);
			logger.error(Utilitarios.Log.error(e,msg),e);
		}
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
	
	public SelectItem[] getListaEstados() {
		try{
			parametroBO = (ParametroBO)WebServletContextListener.getApplicationContext().getBean("parametroBO");
			if(listaEstados == null){
				ParametroDto parametroDto = new ParametroDto();
				CatalogoParametroDto catalogoParametroDto = new CatalogoParametroDto();
				catalogoParametroDto.setId(Constantes.VariablesCatalogoParametros.VARIABLE_ID_ESTADOS); 
				parametroDto.setCatalogoParametroDto(catalogoParametroDto);
				listaEstados = SelectOneMenuHelper.listaParametro(parametroBO.obtenerListaParametros(parametroDto));
			}
		}catch(Exception e){
			logger.error("ERROR EN UTILITARIO " + e.getMessage());
		}
		return listaEstados;
	}
	
	

}
