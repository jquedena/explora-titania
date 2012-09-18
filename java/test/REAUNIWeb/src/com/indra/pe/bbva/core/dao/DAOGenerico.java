package com.indra.pe.bbva.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.indra.pe.bbva.core.exception.DAOException;

@SuppressWarnings({"rawtypes"})
public interface DAOGenerico<Dto> {
    
	public void saveOrUpdate(Dto dto) throws DAOException;

    public void merge(Dto dto) throws DAOException;
	
    public void save(Dto dto) throws DAOException;

    public void update(Dto dto) throws DAOException;
    
    public int executeProcedure(String procedure) throws DAOException;

    public void delete(Dto dto)throws DAOException;
    
    public List<Dto> listarTodosDtos(Class<Dto> entityClass) throws DAOException;   
    
    public Dto obtenerDtoPorId(Class c, Serializable id) throws DAOException;

    public List<Dto> obtenerDtosConFiltros(Class c, Map<String, Object> maparib_val) throws DAOException;
    
    public List<Dto> obtenerDtosConFiltrosEq(Class c, Map<String, Object> maparib_val) throws DAOException;

    public List<Dto> obtenerDtosConFiltrosConOrden(Class c, Map<String, Object> maparib_val, Map<String, String> order) throws DAOException;

    public List<Dto> buscarObjetos(Dto dto) throws DAOException;

    public List ejecutarSQL(String sql) throws DAOException;

    public int ejecutarNombreQuery(String nameQuery,List parametros)throws DAOException;

    public List ejecutarListaNombresQuerys(String nameQuery,List parametros) throws DAOException;

    public List<Dto> listarNombreQuery(String nameQuery, List parametros) throws DAOException;

    public void guardarColeccion(Collection<?> collection) throws DAOException;

    public void borrarColeccion(Collection<?> collection) throws DAOException;

    public List<Dto> ejecutarQuery(String query, List<Object> params) throws DAOException;

    public List<Dto> ejecutarQuery(String query) throws DAOException;    
    
    public List<Dto> obtenerDtosPorQuery(String query,
            Object... params) throws DAOException;
}
