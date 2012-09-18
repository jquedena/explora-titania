package com.indra.pe.bbva.core.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;

/**
 * 
 * @author INDRA PERU SA
 */
@SuppressWarnings({"unchecked", "rawtypes", "unused"})
@Repository("daoGenerico")
public class DAOGenericoImpl<Dto> extends HibernateDaoSupport implements
		DAOGenerico<Dto>, Serializable {

	private static final long serialVersionUID = 7924055871810120486L;

	@Autowired
	public DAOGenericoImpl(@Qualifier("sessionFactoryReauni") SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void saveOrUpdate(Dto dto) throws DAOException{
		super.getHibernateTemplate().saveOrUpdate(dto);
		super.getHibernateTemplate().flush();
	}

	public void merge(Dto dto) throws DAOException{
		super.getHibernateTemplate().merge(dto);
		super.getHibernateTemplate().flush();
	}
	
	public void save(Dto dto) throws DAOException{
		super.getHibernateTemplate().save(dto);
		super.getHibernateTemplate().flush();
	}

	@Override
	public void update(Dto dto) throws DAOException{
		super.getHibernateTemplate().update(dto);
		super.getHibernateTemplate().flush();
	}

	public void delete(Dto dto) throws DAOException{
		super.getHibernateTemplate().delete(dto);
		super.getHibernateTemplate().flush();		
	}

	public <TID> Dto obtenerDtoPorId(Class c, TID id) throws DAOException{
		Dto dto = null;
		List list = null;
		if (id instanceof String) {
			list = super.getHibernateTemplate().find(
					"from " + c.getSimpleName() + " where id='" + id + "'");
		} else {
			list = super.getHibernateTemplate().find(
					"from " + c.getSimpleName() + " where id=" + id);
		}
		if (!list.isEmpty()) {
			dto = (Dto) list.get(0);
		}
		return dto;
	}
	
	public Dto obtenerDtoPorId(Class c, Serializable id) throws DAOException{
		return (Dto) super.getHibernateTemplate().get(c, id);
	}
	
	public List<Dto> obtenerDtosConFiltros(Class c, Map<String, Object> maparib_val) throws DAOException{
		List<Dto> list = null;
		String criterio = " ";
		String query = "from " + c.getSimpleName() + " ";
		String orders = " order by ";
		if (maparib_val != null && !maparib_val.isEmpty()) {
			criterio = " where ";
			for (Entry<String, Object> entri : maparib_val.entrySet()) {
				if (entri.getValue() instanceof String) {
					criterio = criterio + " upper(" + entri.getKey() + ") like '%"
							+ entri.getValue().toString().toUpperCase() + "%' and";
				} else {
					criterio = criterio + " " + entri.getKey() + " = "
							+ entri.getValue() + " and";
				}
			}
			criterio = criterio.substring(0, criterio.length() - 3);

		} else {
			maparib_val = null;
		}
		list = super.getHibernateTemplate().find(query + (criterio == null ? "" : criterio));
		
		return list;
	}
	
	public List<Dto> obtenerDtosConFiltrosEq(Class c, Map<String, Object> maparib_val) throws DAOException{
		List<Dto> list = null;
		String criterio = " ";
		String query = "from " + c.getSimpleName() + " ";
		String orders = " order by ";
		if (maparib_val != null && !maparib_val.isEmpty()) {
			criterio = " where ";
			for (Entry<String, Object> entri : maparib_val.entrySet()) {
				if (entri.getValue() instanceof String) {
					criterio = criterio + " upper(" + entri.getKey() + ") = '"
							+ entri.getValue().toString().toUpperCase() + "' and";
				} else {
					criterio = criterio + " " + entri.getKey() + " = "
							+ entri.getValue() + " and";
				}
			}
			criterio = criterio.substring(0, criterio.length() - 3);

		} else {
			maparib_val = null;
		}
		list = super.getHibernateTemplate().find(query + (criterio == null ? "" : criterio));
		
		return list;
	}

	public List<Dto> obtenerDtosConFiltrosConOrden(Class c, Map<String, Object> maparib_val, Map<String, String> order) throws DAOException{
		List<Dto> list = null;
		String criterio = " ";
		String query = "from " + c.getSimpleName() + " ";
		String orders = " order by ";
		if (maparib_val != null && !maparib_val.isEmpty()) {
			criterio = " where ";
			for (Entry<String, Object> entri : maparib_val.entrySet()) {
				if (entri.getValue() instanceof String) {
					criterio = criterio + " upper(" + entri.getKey()
							+ ") like '%"
							+ entri.getValue().toString().toUpperCase()
							+ "%' and";
				} else {
					criterio = criterio + " " + entri.getKey() + " = "
							+ entri.getValue() + " and";
				}
			}
			criterio = criterio.substring(0, criterio.length() - 3);

		} else {
			criterio = null;
		}

		if (order != null && !order.isEmpty()) {
			boolean flagfirst = false;
			for (Entry<String, String> entri : order.entrySet()) {
				if (flagfirst) {
					orders += " , " + entri.getKey() + " " + entri.getValue();
				} else {
					flagfirst = true;
					orders = orders + entri.getKey() + " " + entri.getValue();
				}
			}
		} else {
			orders = null;
		}

		list = super.getHibernateTemplate().find(
				query + (criterio == null ? "" : criterio)
						+ (orders == null ? "" : orders));
		return list;
	}

	public List<Dto> buscarObjetos(Dto dto) throws DAOException{
		List<Dto> lista = null;
		return lista;
	}

	public List ejecutarSQL(String sql) throws DAOException{
		List lista = null;
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			lista = session.createSQLQuery(sql).list();
		}catch (Exception e) {
			logger.error("SQL :: " + sql, e);
		} finally {
			session.close();
		}
		
		return lista;
	}

	public int ejecutarNombreQuery(String nameQuery, List parametros) throws DAOException{
		Session session = null;
		int res = 0;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.getNamedQuery(nameQuery);
			int i = 0;
			for (Object param : parametros) {
				query.setParameter(i++, param);
			}
			res = query.executeUpdate();

		} finally {
			session.close();
		}
		return res;
	}

	public List ejecutarListaNombresQuerys(String nameQuery, List parametros) throws DAOException{
		Session session = null;
		List lista = null;
		try {
			session = super.getHibernateTemplate().getSessionFactory()
					.openSession();
			Query query = session.getNamedQuery(nameQuery);
			int i = 0;
			for (Object param : parametros) {
				query.setParameter(i++, param);
			}
			lista = query.list();

		} finally {
			session.close();
		}
		return lista;
	}

	public List<Dto> listarNombreQuery(String nameQuery, List parametros) throws DAOException{
		Session session = null;
		List<Dto> lista = null;
		try {
			session = super.getHibernateTemplate().getSessionFactory()
					.openSession();
			Query query = session.getNamedQuery(nameQuery);
			int i = 0;
			for (Object param : parametros) {
				query.setParameter(i++, param);
			}
			lista = (List<Dto>) query.list();

		} finally {
			session.close();
		}
		return lista;
	}

	public void guardarColeccion(Collection<?> collection) throws DAOException{
		super.getHibernateTemplate().saveOrUpdateAll(collection);
	}

	public void borrarColeccion(Collection<?> collection) throws DAOException{
		super.getHibernateTemplate().deleteAll(collection);
	}

	public List<Dto> ejecutarQuery(String query, List<Object> params) throws DAOException{
		return (List<Dto>) super.getHibernateTemplate().find(query,params.toArray());
	}

	public List<Dto> ejecutarQuery(String query) throws DAOException{
		return (List<Dto>) super.getHibernateTemplate().find(query);
	}

	@Override
	public List<Dto> listarTodosDtos(Class<Dto> entityClass) throws DAOException{
		Session session = null;
		List<Dto> lista = null;
		try {
			session = super.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery("from " + entityClass.getSimpleName() + " as e");
			lista = (List<Dto>) query.list();

		} finally {
			session.close();
		}
		return lista;
	}

	@Override
    public List<Dto> obtenerDtosPorQuery(String query, Object... params) {

        List<Dto> lista = null;
    	Session session = super.getHibernateTemplate().getSessionFactory().openSession();
        try {
            Query q = session.createQuery(query);
            if (params!= null && params.length > 0) {
                int i = 0;
                for (Object o : params) {
                    q.setParameter(i++, o);
                }
            }
            lista = q.list();

        } catch (HibernateException e) {
            logger.error("Error en obtenerDtosPorQuery", e);
        }finally {
			session.close();
		}
        return lista;
    }
	
	public int executeProcedure(String procedure) throws DAOException{
		Session session = null;
		int i = -1;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			i = session.createSQLQuery(procedure).executeUpdate();
		}finally {
			session.close();
		}	
		return i;
	}
	
}
