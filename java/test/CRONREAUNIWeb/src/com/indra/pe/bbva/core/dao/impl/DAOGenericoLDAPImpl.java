package com.indra.pe.bbva.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.indra.pe.bbva.core.dao.DAOGenericoLDAP;
import com.indra.pe.bbva.core.exception.DAOException;

@SuppressWarnings({"unchecked", "rawtypes"})
@Repository("daoGenericoLdap")
public class DAOGenericoLDAPImpl<Dto> extends HibernateDaoSupport implements DAOGenericoLDAP<Dto>, Serializable {
 
	private static final long serialVersionUID = -8895299671262815827L;

	@Autowired
	public DAOGenericoLDAPImpl(@Qualifier("sessionFactoryLdap") SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Dto> obtenerDtosConFiltros(Class c, String columna, Object valor)
			throws DAOException {
		List<Dto> list = null;
		String criterio = " ";
		String query = "from " + c.getSimpleName() + " ";
		criterio = " where ";
		if (valor instanceof String) {
			criterio = criterio + " upper(" + columna + ")  = '"
					+ valor.toString().toUpperCase() + "' ";
		} else {
			criterio = criterio + " " + columna + " = "
					+ valor + " ";
		}
		list = super.getHibernateTemplate().find(query + (criterio == null ? "" : criterio));
		
		return list;
	}
	
	@Override
	public List<Dto> obtenerDtosInvolucrados(Class c, String codOficina,String...codCargos) throws DAOException {
		List<Dto> list = null;
		String criterio = " ";
		String query = "from " + c.getSimpleName() + " ";
		criterio = " where " + " upper(codofi)  = '" + codOficina.toString().toUpperCase() + "' and codCargo in (";
		
		for (String cargo : codCargos) {
			criterio +=  "'" + cargo +"',";
		}
		
		criterio = criterio.substring(0, criterio.length() - 1);
		criterio += ")";
		
		list = super.getHibernateTemplate().find(query + (criterio == null ? "" : criterio));
		
		return list;
	}
	
	
	@Override
	public String obtenerTerritorio(String codOfi) throws DAOException {
		String territorio = "";
		String query = "select t.desofi from iiwx.ldapperu2 t where t.codofi='" + codOfi + "' and rownum=1";
		logger.info(query);
		Session session = getSession();
		
		Query q = session.createSQLQuery(query);
		territorio = (String) q.uniqueResult();
		session.close();
		
		return territorio;
	}


	
}