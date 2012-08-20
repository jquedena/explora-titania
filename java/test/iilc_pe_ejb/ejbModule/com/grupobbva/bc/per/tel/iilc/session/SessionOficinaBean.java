package com.grupobbva.bc.per.tel.iilc.session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;

/**
 * Bean implementation class for Enterprise Bean: SessionOficina
 */
public class SessionOficinaBean implements javax.ejb.SessionBean {
    private javax.ejb.SessionContext mySessionCtx;
    /**
     * getSessionContext
     */
    public javax.ejb.SessionContext getSessionContext() {
        return mySessionCtx;
    }
    /**
     * setSessionContext
     */
    public void setSessionContext(javax.ejb.SessionContext ctx) {
        mySessionCtx = ctx;
    }
    /**
     * ejbCreate
     */
    public void ejbCreate() throws javax.ejb.CreateException {
    }
    /**
     * ejbActivate
     */
    public void ejbActivate() {
    }
    /**
     * ejbPassivate
     */
    public void ejbPassivate() {
    }
    /**
     * ejbRemove
     */
    public void ejbRemove() {
    }

	public Oficina datosOficina(String codigo) {
		Oficina res = new Oficina();
		try {
			Connection con = null;
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			DataSource datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			Statement s = con.createStatement();
			String etiqueta="";
			try {
				String sql =
				"select cod_area, cod_territorio, cod_oficina, des_oficina " +
				"from iilc.tiilc_oficina " + 
				"where cod_oficina='" + codigo + "'";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					res = new Oficina();
					res.setCod_area(rst.getString("cod_area"));
					res.setCod_territorio(rst.getString("cod_territorio"));
					res.setCod_oficina(rst.getString("cod_oficina"));
					res.setDes_oficina(rst.getString("des_oficina"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			s.close();
			con.close();
			initialContext.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
    
    public Vector findAllOficinaxTe(String cod_area, String cod_territorio) throws FinderException {
		Vector oficinas = new Vector();
		InitialContext contexto;
		Tiilc_oficinaLocalHome oficinaLocalHome = null;
		Iterator oficinasIterator = null;
		Collection oficinasCollection = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_OFICINA);
			oficinaLocalHome = (Tiilc_oficinaLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_oficinaLocalHome.class);
			//oficinasCollection = oficinaLocalHome.findAllOficinaxTexAr(cod_territorio, cod_area);
			oficinasCollection = oficinaLocalHome.findAllOficinaxTer(cod_territorio);
			oficinasIterator =  oficinasCollection.iterator();
			
			while (oficinasIterator.hasNext()){
				Tiilc_oficinaLocal oficinaLocal = (Tiilc_oficinaLocal) oficinasIterator.next();
				Oficina oficina = new Oficina();
				oficina.setCod_area(oficinaLocal.getTiilc_territorio_fk().getTiilc_area_fk().getCod_area());
				oficina.setCod_territorio(oficinaLocal.getTiilc_territorio_fk().getCod_territorio());
				oficina.setCod_oficina(oficinaLocal.getCod_oficina());
				oficina.setDes_oficina(oficinaLocal.getDes_oficina());
				oficinas.add(oficina);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err.println("Error al probar ejb de entidad: Naming Exception" + e.getMessage());
		}

		return oficinas;

	}
    
    
    public Vector<Oficina> findAllOficinaxTerr(String cod_territorio) throws FinderException {
		Vector<Oficina> oficinas = new Vector<Oficina>();
		InitialContext contexto;
		Tiilc_oficinaLocalHome oficinaLocalHome = null;
		Iterator<Tiilc_oficinaLocal> oficinasIterator = null;
		Collection<Tiilc_oficinaLocal> oficinasCollection = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_OFICINA);
			oficinaLocalHome = (Tiilc_oficinaLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_oficinaLocalHome.class);
			oficinasCollection = oficinaLocalHome.findAllOficinaxTer(cod_territorio);
			oficinasIterator =  oficinasCollection.iterator();
			
			while (oficinasIterator.hasNext()){
				Tiilc_oficinaLocal oficinaLocal = oficinasIterator.next();
				Oficina oficina = new Oficina();
				oficina.setCod_area(oficinaLocal.getTiilc_territorio_fk().getTiilc_area_fk().getCod_area());
				oficina.setCod_territorio(oficinaLocal.getTiilc_territorio_fk().getCod_territorio());
				oficina.setCod_oficina(oficinaLocal.getCod_oficina());
				oficina.setDes_oficina(oficinaLocal.getDes_oficina());
				oficinas.add(oficina);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err.println("Error al probar ejb de entidad: Naming Exception" + e.getMessage());
		}

		return oficinas;

	}
}
