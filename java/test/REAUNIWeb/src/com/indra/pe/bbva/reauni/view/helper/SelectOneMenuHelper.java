package com.indra.pe.bbva.reauni.view.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;
import com.indra.pe.bbva.reauni.model.entidad.ProductoDto;
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.service.ProductoBO;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

@Controller("selectOneMenuHelper")
public class SelectOneMenuHelper {
	
	private static Logger logger = Logger.getLogger(SelectOneMenuHelper.class);
	
	public SelectOneMenuHelper() {
		
	}

	@SuppressWarnings("unused")
	public static List<SelectItem> generarLista(List<Object> listaObjeto){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		SelectItem item = null;
		for (Object objeto : listaObjeto) {
		}
		return null;
	}
	
	
	public static SelectItem[] listaProductos(){
		
		ProductoBO bo =  (ProductoBO)WebServletContextListener.getApplicationContext().getBean("productoBO");
		List<ProductoDto> listaProductos = null;
		try {
			listaProductos = bo.obtenerProductos();
		} catch (ServiceException e) {
			logger.error("Error en utilitario " + e.getMessage());
		}
		
		SelectItem[] lista =  null;
		
		if(listaProductos!=null){
			lista = new SelectItem[listaProductos.size()];
			Utilitarios.General.ordena(listaProductos, "descProd");
			for (int i = 0; i < listaProductos.size(); i++) {
				ProductoDto dto = listaProductos.get(i);
				lista[i] = new SelectItem(dto.getCodProd(),dto.getDescProd());
			}
		}
		return lista;
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
	
	public static SelectItem[] listaParametroPorCatalogo(Long cataLong){
		List<ParametroDto> listaParametro = obtenerParametrosActivosPorCatalogo(cataLong);
		
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

	public static List<ParametroDto> obtenerMotivosTraslado(String segmento, int tipo) {
		ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
    	
    	List<ParametroDto> lista;
		try {
			lista = parametroBO.obtenerMotivosTraslado(segmento, tipo);			
		} catch (ServiceException e) {
			lista = null;
			logger.error("obtenerMotivosTraslado", e);
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
			logger.error(e);
		}
    	
//    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
//        List<ParametroDto> lista = new ArrayList<ParametroDto>();
//        for (ParametroDto p : aplicacionMBean.getListaParametros()) {
//            if (p.getCatalogoParametroDto().getId().equals(catalogo) && p.getEstado().equals(Boolean.TRUE) && p.getParametroPadreDto() != null && p.getParametroPadreDto().getId().equals(padre)) {
//                lista.add(p);
//            }
//        }
//        Utilitarios.General.ordena(lista, "descripcion");
        return lista;
    }   
    
    /**
     * Obtiene una lista de Parametros Activos por catalogo adicionando la opcion seleccionar y todos
     * @param catalogo Id Catalogo Principal
     * @param padre Id Parametro Padre
     * @return Lista
     */
    public static List<ParametroDto> obtenerParametrosActivosPorCatalogoAdicional(Long catalogo, Long padre) {
//    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
//        List<ParametroDto> lista = new ArrayList<ParametroDto>();
//        for (ParametroDto p : aplicacionMBean.getListaParametros()) {
//            if (p.getCatalogoParametroDto().getId().equals(catalogo) && p.getEstado().equals(Boolean.TRUE) && p.getParametroPadreDto() != null && p.getParametroPadreDto().getId().equals(padre)) {
//                lista.add(p);
//            }
//        }
//        lista.add(ApplicationHelper.obtenerParametroPorId(1004L));
//        lista.add(ApplicationHelper.obtenerParametroPorId(1005L));
//        Utilitarios.General.ordena(lista, "descripcion");
    	
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
			logger.error(e);
		}
        return lista;
    }
    
    /**
     * Obtiene una lista de Parametros Activos por catalogo adicionando la opcion seleccionar y todos
     * @param catalogo Id Catalogo Principal
     * @return Lista
     */
    public static List<ParametroDto> obtenerParametrosActivosPorCatalogoAdicional(Long catalogo) {
//    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
//        List<ParametroDto> lista = new ArrayList<ParametroDto>();
//        for (ParametroDto p : aplicacionMBean.getListaParametros()) {
//            if (p.getCatalogoParametroDto().getId().equals(catalogo) && p.getEstado().equals(Boolean.TRUE) && p.getParametroPadreDto() != null) {
//                lista.add(p);
//            }
//        }
//        lista.add(ApplicationHelper.obtenerParametroPorId(1004L));
//        lista.add(ApplicationHelper.obtenerParametroPorId(1003L));
//        Utilitarios.General.ordena(lista, "descripcion");
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
			logger.error(e);
		}
		
        return lista;
    }
    
    /**
     * Obtiene una lista de Parametros Activos por catalogo adicionando la opcion todos
     * @param catalogo Id Catalogo Principal
     * @return Lista
     */
    public static List<ParametroDto> obtenerParametrosActivosPorCatalogoTodos(Long catalogo) {
//    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
//        List<ParametroDto> lista = new ArrayList<ParametroDto>();
//        for (ParametroDto p : aplicacionMBean.getListaParametros()) {
//            if (p.getCatalogoParametroDto().getId().equals(catalogo) && p.getEstado().equals(Boolean.TRUE) && p.getParametroPadreDto() != null) {
//                lista.add(p);
//            }
//        }        
//        lista.add(ApplicationHelper.obtenerParametroPorId(1003L)); //Parametro todos
//        Utilitarios.General.ordena(lista, "descripcion");
    	ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
    	ParametroDto filtro = new ParametroDto();
    	filtro.setCatalogoParametroDto(new CatalogoParametroDto());
    	filtro.getCatalogoParametroDto().setId(catalogo);
    	
    	
    	List<ParametroDto> lista;
		try {
			lista = parametroBO.obtenerParametrosActivos(filtro);
			lista.add(ApplicationHelper.obtenerParametroPorId(1003L)); //Parametro todos
		} catch (ServiceException e) {
			lista = new ArrayList<ParametroDto>();
			logger.error(e);
		}
        return lista;
    }
    
    /**
     * Obtiene una lista de Parametros Activos por catalogo adicionando la opcion seleccionar
     * @param catalogo Id Catalogo Principal
     * @return Lista
     */
    public static List<ParametroDto> obtenerParametrosActivosPorCatalogoSeleccionar(Long catalogo) {
//    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
//        List<ParametroDto> lista = new ArrayList<ParametroDto>();
//        for (ParametroDto p : aplicacionMBean.getListaParametros()) {
//            if (p.getCatalogoParametroDto().getId().equals(catalogo) && p.getEstado().equals(Boolean.TRUE) && p.getParametroPadreDto() != null) {
//                lista.add(p);
//            }
//        }        
//        lista.add(ApplicationHelper.obtenerParametroPorId(1004L)); //Parametro seleccionar
//        Utilitarios.General.ordena(lista, "descripcion");
//        return lista;
    	ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
    	ParametroDto filtro = new ParametroDto();
    	filtro.setCatalogoParametroDto(new CatalogoParametroDto());
    	filtro.getCatalogoParametroDto().setId(catalogo);
    	
    	
    	List<ParametroDto> lista;
		try {
			lista = parametroBO.obtenerParametrosActivos(filtro);
			lista.add(ApplicationHelper.obtenerParametroPorId(1004L)); //Parametro seleccionar
		} catch (ServiceException e) {
			lista = new ArrayList<ParametroDto>();
			logger.error(e);
		}
        return lista;
    }
	
    
    public static List<TerritorioDto> obtenerTerritorios(String territorio) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
    	List<TerritorioDto> lista = aplicacionMBean.getListaTerritorios();
    	Utilitarios.General.ordena(lista, "desTerritorio");
    	return lista;
    }
    
    public static TerritorioDto obtenerTerritorio(String codTerritorio) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
    	
    	if(codTerritorio == null) {
    		codTerritorio = "";
    	}
    	
    	if(aplicacionMBean.getListaTerritorios() != null) {
	    	for(TerritorioDto t : aplicacionMBean.getListaTerritorios()) {
	    		if (t.getCodTerritorio().equalsIgnoreCase(codTerritorio)) {
	    			return t;    			
	    		}
	    	}
    	}
    	return null;
    }
    
    public static List<OficinaDto> obtenerOficinasPorTerritorio(String codTerritorio) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
    	List<OficinaDto> lista = new ArrayList<OficinaDto>();
    	if (codTerritorio!=null ){
    		for(OficinaDto o : aplicacionMBean.getListaOficinas()) {
        		if(o.getTerritorioDto().getCodTerritorio().equalsIgnoreCase(codTerritorio)) {
        			lista.add(o);
        		}
        	}
        	 Utilitarios.General.ordena(lista, "desOficina");
    	}    	
    	return lista;
    }
    
    public static OficinaDto obtenerOficina(String codOficina) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
    	for(OficinaDto o : aplicacionMBean.getListaOficinas()) {
    		if (codOficina.equalsIgnoreCase(o.getCodOficina())) {
    			return o;    			
    		}
    	}
    	return null;
    }
    
    public static List<GestorDto> obtenerGestoresPorOficina(String codOficina) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
    	List<GestorDto> lista = new ArrayList<GestorDto>();
    	if (codOficina!=null ){
    		for(GestorDto o : aplicacionMBean.getListaGestores()) {
        		if(o.getCodOficina().equalsIgnoreCase(codOficina)) {
        			lista.add(o);
        		}
        	}
        	 Utilitarios.General.ordena(lista, "nomGestor");
    	}    	
    	return lista;
    }
    
    public static GestorDto obtenerGestor(String codGestor) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
    	for(GestorDto o : aplicacionMBean.getListaGestores()) {
    		if (o.getCodGestor().equalsIgnoreCase(codGestor)) {
    			return o;    			
    		}
    	}
    	return null;
    }
    
    
}
