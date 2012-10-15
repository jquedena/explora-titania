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
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.ibm.etools.service.locator.ServiceLocatorManager;
/**
 * Bean implementation class for Enterprise Bean: SessionTerritorio
 */
public class SessionTerritorioBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiilc_territorioLocalHome_REF_NAME = "ejb/Tiilc_territorio";
	private final static Class<Tiilc_territorioLocalHome> STATIC_Tiilc_territorioLocalHome_CLASS = Tiilc_territorioLocalHome.class;
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

	public Territorio datosTerritorio(String codigo) {
		Territorio res = new Territorio();
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
			try {
				String sql =
				"select cod_area, cod_territorio, des_territorio " +
				"from iilc.tiilc_territorio " + 
				"where cod_territorio='" + codigo + "'";

				ResultSet rst = s.executeQuery(sql);
				while (rst.next()) {
					res = new Territorio();
					res.setCod_area(rst.getString("cod_area"));
					res.setCod_territorio(rst.getString("cod_territorio"));
					res.setDes_territorio(rst.getString("des_territorio"));
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

	public Vector<Territorio> findAllTerritorio(String cod_area) throws FinderException {
		Vector<Territorio> territorios = new Vector<Territorio>();
		InitialContext contexto;
		Tiilc_territorioLocalHome territorioLocalHome = null;
		Iterator<Tiilc_territorioLocal> territoriosIterator = null;
		Collection<Tiilc_territorioLocal> territoriosCollection = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_TERRITORIO);
			territorioLocalHome = (Tiilc_territorioLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_territorioLocalHome.class);
			
			if (cod_area.equals(Constantes.TODOS_TERRITORIOS))
				territoriosCollection = territorioLocalHome.findAllTerritorio();
			else
				territoriosCollection = territorioLocalHome.findAllTerritorioxAr(cod_area);
			
			territoriosIterator = territoriosCollection.iterator();

			while (territoriosIterator.hasNext()) {
				Tiilc_territorioLocal territorioLocal = territoriosIterator.next();
				
				// if (territorioLocal.getDes_territorio().substring(0,4).equals("G.T.")){
					Territorio territorio = new Territorio();
					territorio.setCod_area(territorioLocal.getTiilc_area_fk().getCod_area());
					territorio.setCod_territorio(territorioLocal.getCod_territorio());
					territorio.setDes_territorio(territorioLocal.getDes_territorio());
					territorios.add(territorio);
				//}
			}
		} catch (NamingException e) {
			e.printStackTrace();			
			System.err.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
		}

		return territorios;

	}

	protected Collection<Tiilc_territorioLocal> find_Tiilc_territorioLocalHome_findAllTerritorioxAr(
			String cod_area) {
		Tiilc_territorioLocalHome aTiilc_territorioLocalHome = (Tiilc_territorioLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_territorioLocalHome_REF_NAME,
						STATIC_Tiilc_territorioLocalHome_CLASS);
		try {
			if (aTiilc_territorioLocalHome != null)
				return aTiilc_territorioLocalHome
						.findAllTerritorioxAr(cod_area);
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		}
		return null;
	}
}
