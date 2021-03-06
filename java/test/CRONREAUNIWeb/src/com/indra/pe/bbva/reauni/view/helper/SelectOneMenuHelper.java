package com.indra.pe.bbva.reauni.view.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;

public class SelectOneMenuHelper {
	private static Logger logger = Logger.getLogger(SelectOneMenuHelper.class);	
	
	public SelectOneMenuHelper() {
	}

	public static List<SelectItem> generarLista(List<Object> listaObjeto){
		return null;
	}
	
	public static SelectItem[] listaParametro(List<ParametroDto> listaParametro){
		SelectItem[] lista = new SelectItem[listaParametro.size()];
		if(listaParametro!=null){
			for (int i = 0; i < listaParametro.size(); i++) {
				ParametroDto parametroDto = listaParametro.get(i);
				lista[i] = new SelectItem(parametroDto.getId(),parametroDto.getDescripcion());
			}
		}
		return lista;
	}
	
	public static SelectItem[] listaPerfiles(List<PerfilDto> listaPerfil){
		SelectItem[] lista = new SelectItem[listaPerfil.size()];
		if(listaPerfil!=null){
			for (int i = 0; i < listaPerfil.size(); i++) {
				PerfilDto perfilDto = listaPerfil.get(i);
				lista[i] = new SelectItem(perfilDto.getId(),perfilDto.getNombre());
			}
		}
		return lista;
	}
	
	 /**
     * Obtiene una lista de Parametros Activos por catalogo adicionando
     * @param catalogo Id Catalogo Principal
     * @return Lista
     */
	public static List<ParametroDto> obtenerParametrosActivosPorCatalogo(Long catalogo) {
		ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
    	ParametroDto filtro = new ParametroDto();
    	filtro.setCatalogoParametroDto(new CatalogoParametroDto());
    	filtro.getCatalogoParametroDto().setId(catalogo);
    	
    	
    	List<ParametroDto> lista;
		try {
			lista = parametroBO.obtenerParametrosActivos(filtro);			
		} catch (ServiceException e) {
			lista = new ArrayList<ParametroDto>();
			logger.error("obtenerParametrosActivosPorCatalogo", e);
		}
        return lista;
    }

	 /**
     * Obtiene una lista de Parametros Activos por catalogo
     * @param catalogo Id Catalogo Principal
     * @param padre Id Parametro Padre
     * @return Lista
     */
	public static List<ParametroDto> obtenerParametrosActivosPorCatalogo(Long catalogo, Long padre) {
    	ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
    	ParametroDto filtro = new ParametroDto();
    	filtro.setCatalogoParametroDto(new CatalogoParametroDto());
    	filtro.getCatalogoParametroDto().setId(catalogo);
    	filtro.setParametroPadreDto(new ParametroDto());
    	filtro.getParametroPadreDto().setId(padre);
    	
    	List<ParametroDto> lista;
		try {
			lista = parametroBO.obtenerParametrosActivos(filtro);
		} catch (ServiceException e) {
			lista = new ArrayList<ParametroDto>();
			logger.error("obtenerParametrosActivosPorCatalogo", e);
		}
        return lista;
    }   
    
    
    /**
     * Obtiene una lista de Parametros Activos por catalogo adicionando la opcion seleccionar y todos
     * @param catalogo Id Catalogo Principal
     * @param padre Id Parametro Padre
     * @return Lista
     */
	public static List<ParametroDto> obtenerParametrosActivosPorCatalogoAdicional(Long catalogo, Long padre) { 	
    	ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
    	ParametroDto filtro = new ParametroDto();
    	filtro.setCatalogoParametroDto(new CatalogoParametroDto());
    	filtro.getCatalogoParametroDto().setId(catalogo);
    	filtro.setParametroPadreDto(new ParametroDto());
    	filtro.getParametroPadreDto().setId(padre);
    	
    	List<ParametroDto> lista;
		try {
			lista = parametroBO.obtenerParametrosActivos(filtro);
			lista.add(ApplicationHelper.obtenerParametroPorId(1004L));
	        lista.add(ApplicationHelper.obtenerParametroPorId(1005L));
		} catch (ServiceException e) {
			lista = new ArrayList<ParametroDto>();
			logger.error("obtenerParametrosActivosPorCatalogoAdicional", e);
		}
        return lista;
    }
    
    /**
     * Obtiene una lista de Parametros Activos por catalogo adicionando la opcion seleccionar y todos
     * @param catalogo Id Catalogo Principal
     * @return Lista
     */
    public static List<ParametroDto> obtenerParametrosActivosPorCatalogoAdicional(Long catalogo) {
    	ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
    	ParametroDto filtro = new ParametroDto();
    	filtro.setCatalogoParametroDto(new CatalogoParametroDto());
    	filtro.getCatalogoParametroDto().setId(catalogo);
 
    	
    	List<ParametroDto> lista;
		try {
			lista = parametroBO.obtenerParametrosActivos(filtro);
	        lista.add(ApplicationHelper.obtenerParametroPorId(1004L));
	        lista.add(ApplicationHelper.obtenerParametroPorId(1003L));
		} catch (ServiceException e) {
			lista = new ArrayList<ParametroDto>();
			logger.error("obtenerParametrosActivosPorCatalogoAdicional", e);
		}
		
        return lista;
    }
}
