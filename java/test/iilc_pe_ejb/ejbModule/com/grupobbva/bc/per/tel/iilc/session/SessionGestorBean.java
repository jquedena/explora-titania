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
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;

import com.ibm.etools.service.locator.ServiceLocatorManager;

import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey;
/**
 * Bean implementation class for Enterprise Bean: SessionGestor
 */
public class SessionGestorBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiilc_gestorLocalHome_REF_NAME = "ejb/Tiilc_gestor";

	private final static Class STATIC_Tiilc_gestorLocalHome_CLASS = Tiilc_gestorLocalHome.class;

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

	public Gestor datosGestor(String codigo) {
		Gestor res = new Gestor();
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
				"select cod_area, cod_territorio, cod_oficina, cod_gestor, nom_gestor, reg_gestor, perfil_gestor " +
				"from iilc.tiilc_gestor " + 
				"where cod_gestor='" + codigo + "'";

				ResultSet rst = s.executeQuery(sql);
				while (rst.next()) {
					res = new Gestor();
					res.setCod_area(rst.getString("cod_area"));
					res.setCod_territorio(rst.getString("cod_territorio"));
					res.setCod_oficina(rst.getString("cod_oficina"));
					res.setCod_gestor(rst.getString("cod_gestor"));
					res.setNom_gestor(rst.getString("nom_gestor"));
					res.setReg_gestor(rst.getString("reg_gestor"));
					res.setPerfil_gestor(rst.getString("perfil_gestor"));
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

	public Vector<Gestor> findAllGestorxOfxTe(String cod_area, String cod_territorio,
			String cod_oficina) throws FinderException {
		Vector<Gestor> gestores = new Vector<Gestor>();
		InitialContext contexto;
		Tiilc_gestorLocalHome gestorLocalHome = null;
		Iterator<Gestor> gestoresIterator = null;
		Collection<Gestor> gestoresCollection = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_GESTOR);
			gestorLocalHome = (Tiilc_gestorLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_gestorLocalHome.class);
			gestoresCollection = gestorLocalHome.findAllGestorxOfxTexAr(
					cod_oficina, cod_territorio, cod_area);
			gestoresIterator = gestoresCollection.iterator();

			while (gestoresIterator.hasNext()) {
				Tiilc_gestorLocal gestorLocal = (Tiilc_gestorLocal) gestoresIterator
						.next();
				Gestor gestor = new Gestor();
				gestor.setCod_area(gestorLocal.getTiilc_oficina_fk()
						.getTiilc_territorio_fk().getTiilc_area_fk()
						.getCod_area());
				gestor.setCod_territorio(gestorLocal.getTiilc_oficina_fk()
						.getTiilc_territorio_fk().getCod_territorio());
				gestor.setCod_oficina(gestorLocal.getTiilc_oficina_fk()
						.getCod_oficina());
				gestor.setCod_gestor(gestorLocal.getCod_gestor());
				gestor.setNom_gestor(gestorLocal.getNom_gestor());
				gestor.setReg_gestor(gestorLocal.getReg_gestor());
				gestor.setPerfil_gestor(gestorLocal.getPerfil_gestor());
				gestores.add(gestor);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err
					.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
		}

		return gestores;

	}

	public Vector<String> findATOG(String cod_usuario) throws FinderException {
		Vector<String> atog = new Vector<String>();
		InitialContext contexto;
		Tiilc_gestorLocalHome gestorLocalHome = null;
		Object obj = null;
		String cod_gestor = "-1", cod_oficina = "-1", cod_territorio = "-1", cod_area = "-1";
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_GESTOR);
			gestorLocalHome = (Tiilc_gestorLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_gestorLocalHome.class);
			Tiilc_gestorLocal gestorLocal = gestorLocalHome
					.findGestorxRegGestor(cod_usuario);

			if (gestorLocal != null) {
				cod_gestor = gestorLocal.getCod_gestor();
				if (gestorLocal.getTiilc_oficina_fk() != null) {
					cod_oficina = gestorLocal.getTiilc_oficina_fk()
							.getCod_oficina();
					if (gestorLocal.getTiilc_oficina_fk()
							.getTiilc_territorio_fk() != null) {
						cod_territorio = gestorLocal.getTiilc_oficina_fk()
								.getTiilc_territorio_fk().getCod_territorio();
						if (gestorLocal.getTiilc_oficina_fk()
								.getTiilc_territorio_fk().getTiilc_area_fk() != null) {
							cod_area = gestorLocal.getTiilc_oficina_fk()
									.getTiilc_territorio_fk()
									.getTiilc_area_fk().getCod_area();
						}
					}
				}

			}

			atog.add(cod_area);
			atog.add(cod_territorio);
			atog.add(cod_oficina);
			atog.add(cod_gestor);
		} catch (NamingException e) {
			System.err.println("Error al probar ejb de entidad: Naming Exception"+ e.getMessage());
		}

		return atog;

	}

	public boolean deleteAllGestor(String cod_area){
		boolean respuesta = true;
		Iterator<Tiilc_gestorLocal> gestoresIterator = null;
		try {

			Collection<Tiilc_gestorLocal> gestoresCollection =  find_Tiilc_gestorLocalHome_findAllGestor(cod_area);
			gestoresIterator =  gestoresCollection.iterator();
			
			while (gestoresIterator.hasNext()){
				Tiilc_gestorLocal gestorLocal = gestoresIterator.next();
				gestorLocal.remove();
			}
		} catch (Exception e) {
			System.err.println("Error al borrar gestor " + e.getMessage());
			respuesta = false;
		}

		return respuesta;

	}
	protected Collection<Tiilc_gestorLocal> find_Tiilc_gestorLocalHome_findAllGestor(
			String cod_area) {
		Tiilc_gestorLocalHome aTiilc_gestorLocalHome = (Tiilc_gestorLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_gestorLocalHome_REF_NAME,
						STATIC_Tiilc_gestorLocalHome_CLASS);
		try {
			if (aTiilc_gestorLocalHome != null)
				return aTiilc_gestorLocalHome.findAllGestor(cod_area);
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		}
		return null;
	}
//	OSCAR CORTEZ - Gestor x Registro
	public Vector findGestorxRegistro(String registro, String codTerritorio, String codOficina) {

		Vector res = null;
		Gestor bean = null;

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
				"select cod_area, cod_territorio, cod_oficina, cod_gestor, nom_gestor, reg_gestor from iilc.tiilc_gestor where reg_gestor='"+registro+"' and cod_territorio='"+codTerritorio+"' and cod_oficina='"+codOficina+"' ";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Gestor();
					
					bean.setCod_area(rst.getString("cod_area"));
					bean.setCod_territorio(rst.getString("cod_territorio"));
					bean.setCod_oficina(rst.getString("cod_oficina"));
					bean.setCod_gestor(rst.getString("cod_gestor"));
					bean.setNom_gestor(rst.getString("nom_gestor"));
					bean.setReg_gestor(rst.getString("reg_gestor"));
					
					res.add(bean);					
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

	//FIN - OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS
	
	public String findGestorMasaOficina(String cod_oficina){
		String res = null;
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
				String sql = "select cod_gestor from iilc.tiilc_gestor " +
							"where cod_oficina = '" + cod_oficina + "' " + 
							"and perfil_gestor = 'M'";

				ResultSet rst = s.executeQuery(sql);
				if (rst.next()) {
					res = rst.getString("cod_gestor");
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
	
	protected Tiilc_gestorLocal find_Tiilc_gestorLocalHome_findByPrimaryKey(
			Tiilc_gestorKey primaryKey) {
		Tiilc_gestorLocalHome aTiilc_gestorLocalHome = (Tiilc_gestorLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_gestorLocalHome_REF_NAME,
						STATIC_Tiilc_gestorLocalHome_CLASS);
		try {
			if (aTiilc_gestorLocalHome != null)
				return aTiilc_gestorLocalHome.findByPrimaryKey(primaryKey);
		} catch (javax.ejb.FinderException fe) {
			System.err.println("No se encontr" + (char) 243 + " el gestor (" + primaryKey.getCod_gestor() + ")");
			//fe.printStackTrace();
		}
		return null;
	}
}