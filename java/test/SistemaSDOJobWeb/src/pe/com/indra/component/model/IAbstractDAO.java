package pe.com.indra.component.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface IAbstractDAO<T> {

	/**
	 * Guarda y/o actualiza, utilizar para entidades con Primary Key autogeneradas.
	 * @param T entity Entidad a guardar y/o actualizar
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public void saveOrUpdate(T entity) throws DataAccessException;
	
	/**
	 * Guarda, utilizar par entidades con Primary Key generadas manualmente.
	 * @param T entity Entidad a guardar
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public void save(T entity) throws DataAccessException;
	
	/**
	 * Actualiza, utilizar par entidades con Primary Key generadas manualmente.
	 * @param T entity Entidad a actualizar
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public void update(T entity) throws DataAccessException;
	
	/**
	 * Elimina una entidad
	 * @param T entity entidad a eliminar
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public void delete(T entity) throws DataAccessException;
	
	/**
	 * Busca un objecto por su Primary Key
	 * @param Class&lt;?&gt; classType Clase Entidad
	 * @param &lt;ID&gt; id Tipo de dato del Primary Key
	 * @return T Retorna el objecto encontrado caso contrario retorna null
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public T findById(Class<?> classType, Object id) throws DataAccessException;
	
	/**
	 * Busca objectos coincidentes con los parametros
	 * @param Class&lt;?&gt; classType Clase Entidad
	 * @param HashMap&lt;String,TD&gt; parameters La llave de esta coleccion es el nombre del campo
	 * @return List&lt;T&gt; Retorna una lista de objectos encontrados caso contrario retorna una lista vacia
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public List<T> findByParams(Class<?> classType, HashMap<String, Object> parameters) throws DataAccessException;	
	
	/**
	 * Ejecuta una consulta sql sobre la conexion activa
	 * @param String sql Instruccion a ejecutar
	 * @return List&lt;Object&gt; Retorna una lista de objectos encontrados caso contrario retorna una lista vacia
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public List<Object> executeSQL(String sql) throws DataAccessException;
	
	/**
	 * Ejecuta una consulta de actualizacion sobre la conexion activa
	 * @param String nameQuery Instruccion a ejecutar
	 * @param List&lt;Object&gt; Lista de parametros
	 * @return List&lt;Object&gt; Retorna la cantidad de filas afectadas
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public int executeNamedQuery(String nameQuery, List<Object> parameters) throws DataAccessException;
		
	/**
	 * Ejecuta una consulta de seleccion sobre la conexion activa
	 * @param String nameQuery Instruccion a ejecutar
	 * @param List&lt;Object&gt; Lista de parametros
	 * @return List&lt;T&gt; Retorna una lista de objectos encontrados caso contrario retorna una lista vacia
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public List<T> listNamedQuery(String nameQuery, List<Object> parameters) throws DataAccessException;
	
	/**
	 * Guarda una coleccion de objectos
	 * @param Collection&lt;?&gt; collection Coleccion a guardar
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public void saveCollection(Collection<?> collection) throws DataAccessException;
	
	/**
	 * Elimina una coleccion de objectos
	 * @param Collection&lt;?&gt; collection Coleccion a eliminar
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public void deleteCollection(Collection<?> collection) throws DataAccessException;
	
	/**
	 * Lista la informacion contenidad en la entidad
	 * @param T entity Entidad a consultar
	 * @return List&lt;T&gt; Retorna una lista de objectos encontrados caso contrario retorna una lista vacia
	 * @throws DataAccessException Error ocurrido durante la ejecucion del metodo.
	 */
	public List<T> getList(Class<?> classType) throws DataAccessException;
}