package com.grupobbva.bc.per.tel.iilc.session;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.naming.InitialContext;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.sql.DataSource;

/**
 * Bean implementation class for Enterprise Bean: SessionPermisoPerfil
 */
public class SessionPermisoPerfilBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiilc_permiso_perfilLocalHome_REF_NAME = "ejb/Tiilc_permiso_perfil";

	private final static Class STATIC_Tiilc_permiso_perfilLocalHome_CLASS = Tiilc_permiso_perfilLocalHome.class;

	private final static String STATIC_Tiilc_perfilLocalHome_REF_NAME = "ejb/Tiilc_perfil";

	private final static Class STATIC_Tiilc_perfilLocalHome_CLASS = Tiilc_perfilLocalHome.class;

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

	public PermisoPerfil findComponente(String codReg, String codCat,
			String path) throws FinderException {
		String componente = null;
		PermisoPerfil permisoPerfil = null;
		Tiilc_permiso_perfilLocal permisoPerfilLocal = null;
		String codRcp = null;

		//int idReg = 1, idCat = 2, idEqu = 3
		for (int y = 1; y <= 2; y++) {

			switch (y) {
			case 1:
				codRcp = codReg;
				break;
			case 2:
				codRcp = codCat;
				break;
			case 3:
				codRcp = path;
				break;
			}

			Tiilc_permiso_perfilLocal aTiilc_permiso_perfilLocal = find_Tiilc_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP(
					y, codRcp);
			if (aTiilc_permiso_perfilLocal != null) {
				Tiilc_perfilLocal aTiilc_perfilLocal = find_Tiilc_perfilLocalHome_findByPrimaryKey(new Tiilc_perfilKey(
						aTiilc_permiso_perfilLocal.getCod_perfil()));
				permisoPerfil = new PermisoPerfil();
				permisoPerfil.setCod_perfil(aTiilc_permiso_perfilLocal
						.getCod_perfil());
				permisoPerfil.setTipo_acceso(aTiilc_permiso_perfilLocal
						.getTipo_acceso());
				permisoPerfil.setValor_rcp(aTiilc_permiso_perfilLocal
						.getValor_rcp());

				Perfil perfil = new Perfil();
				perfil.setCod_perfil(aTiilc_perfilLocal.getCod_perfil());
				perfil.setDes_perfil(aTiilc_perfilLocal.getDes_perfil());
				perfil.setComponente(aTiilc_perfilLocal.getComponente());

				permisoPerfil.setPerfil(perfil);
			}
			if (permisoPerfil != null) {
				//System.out.println("Perfil encontrado: " + permisoPerfil.getCod_perfil() + "-" + permisoPerfil.getPerfil().getDes_perfil());
				y = 4;
			}

		}
		if (permisoPerfil == null)
			return null;
		return permisoPerfil;
	}

	protected Tiilc_permiso_perfilLocal find_Tiilc_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP(
			int tipo_acceso, String valor_rcp) {
		Tiilc_permiso_perfilLocalHome aTiilc_permiso_perfilLocalHome = (Tiilc_permiso_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_permiso_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_permiso_perfilLocalHome_CLASS);
		try {
			if (aTiilc_permiso_perfilLocalHome != null)
				return aTiilc_permiso_perfilLocalHome
						.findPermisoPerfilxTipAccxValorRCP(tipo_acceso,
								valor_rcp);
		} catch (javax.ejb.FinderException fe) {
			System.err.println("Tabla: PermisoPerfil");
			System.err
					.println("Error: No se encontro permiso perfil correspondiente a tipo acceso: "
							+ tipo_acceso + " y valorrcp: " + valor_rcp);
		}
		return null;
	}

	protected Tiilc_perfilLocal find_Tiilc_perfilLocalHome_findByPrimaryKey(
			Tiilc_perfilKey primaryKey) {
		Tiilc_perfilLocalHome aTiilc_perfilLocalHome = (Tiilc_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_perfilLocalHome_CLASS);
		try {
			if (aTiilc_perfilLocalHome != null)
				return aTiilc_perfilLocalHome.findByPrimaryKey(primaryKey);
		} catch (javax.ejb.FinderException fe) {
			System.err.println("Tabla: PermisoPerfil");
			System.err
					.println("Error: No se encontro permiso perfil correspondiente a cod_perfil: "
							+ primaryKey.cod_perfil);
		}
		return null;
	}

	public Vector findAllPerfil() throws FinderException {
		Vector listaPerfil = new Vector();
		InitialContext contexto;
		Iterator perfilesIterator = null;
		Collection perfilesCollection = null;
		Object obj = null;
		try {
			perfilesCollection = find_Tiilc_perfilLocalHome_findAllPerfil();
			perfilesIterator = perfilesCollection.iterator();

			while (perfilesIterator.hasNext()) {
				Tiilc_perfilLocal perfilLocal = (Tiilc_perfilLocal) perfilesIterator
						.next();
				Perfil perfil = new Perfil();
				perfil.setCod_perfil(perfilLocal.getCod_perfil());
				perfil.setDes_perfil(perfilLocal.getDes_perfil());
				perfil.setComponente(perfilLocal.getComponente());
				listaPerfil.add(perfil);
			}
		} catch (Exception e) {
			System.err.println("Error al traer data de la tabla Perfil");
		}

		return listaPerfil;
	}

	protected Collection find_Tiilc_perfilLocalHome_findAllPerfil() {
		Tiilc_perfilLocalHome aTiilc_perfilLocalHome = (Tiilc_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_perfilLocalHome_CLASS);
		try {
			if (aTiilc_perfilLocalHome != null)
				return aTiilc_perfilLocalHome.findAllPerfil();
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		}
		return null;
	}

	public Vector findAllPermisoPerfil() throws FinderException {
		Vector listaPermisoPerfil = new Vector();
		InitialContext contexto;
		Iterator permisoPerfilesIterator = null;
		Collection permisoPerfilesCollection = null;
		Object obj = null;
		try {
			permisoPerfilesCollection = find_Tiilc_permiso_perfilLocalHome_findAllPermisoPerfil();
			;
			permisoPerfilesIterator = permisoPerfilesCollection.iterator();

			while (permisoPerfilesIterator.hasNext()) {
				Tiilc_permiso_perfilLocal permisoPerfilLocal = (Tiilc_permiso_perfilLocal) permisoPerfilesIterator
						.next();
				PermisoPerfil permisoPerfil = new PermisoPerfil();
				permisoPerfil.setCod_perfil(permisoPerfilLocal.getCod_perfil());
				permisoPerfil.setTipo_acceso(permisoPerfilLocal
						.getTipo_acceso());
				permisoPerfil.setValor_rcp(permisoPerfilLocal.getValor_rcp());
				listaPermisoPerfil.add(permisoPerfil);
			}
		} catch (Exception e) {
			System.err.println("Error al traer data de la tabla PermisoPerfil");
		}

		return listaPermisoPerfil;
	}

	protected Collection find_Tiilc_permiso_perfilLocalHome_findAllPermisoPerfil() {
		Tiilc_permiso_perfilLocalHome aTiilc_permiso_perfilLocalHome = (Tiilc_permiso_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_permiso_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_permiso_perfilLocalHome_CLASS);
		try {
			if (aTiilc_permiso_perfilLocalHome != null)
				return aTiilc_permiso_perfilLocalHome.findAllPermisoPerfil();
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		}
		return null;
	}

	public Perfil findPerfil(String cod_perfil) {
		Perfil perfil = null;
		try {
			Tiilc_perfilLocal aTiilc_perfilLocal = find_Tiilc_perfilLocalHome_findPerfil(cod_perfil);
			if (aTiilc_perfilLocal != null) {
				perfil = new Perfil();
				perfil.setCod_perfil(aTiilc_perfilLocal.getCod_perfil());
				perfil.setDes_perfil(aTiilc_perfilLocal.getDes_perfil());
				perfil.setComponente(aTiilc_perfilLocal.getComponente());
			}
		} catch (Exception e) {
			System.err.println("Error al traer data de la tabla Perfil");
		}
		return perfil;
	}

	public boolean updatePerfil(Perfil perfil){

		try {
			Tiilc_perfilLocal aTiilc_perfilLocal = find_Tiilc_perfilLocalHome_findPerfil(perfil.getCod_perfil());
					
			if (aTiilc_perfilLocal != null){
				aTiilc_perfilLocal.setDes_perfil(perfil.getDes_perfil());
				aTiilc_perfilLocal.setComponente(perfil.getComponente());
				return true;
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar tabla PermisoPerfil");
		}
		return false;
	}
	
	public boolean deletePerfil(String cod_perfil){

		try {
			Tiilc_perfilLocal aTiilc_perfilLocal = find_Tiilc_perfilLocalHome_findPerfil(cod_perfil);
					
			if (aTiilc_perfilLocal != null){
				aTiilc_perfilLocal.remove();
				return true;
			}
		} catch (Exception e) {
			System.err.println("Error al eliminar tabla PermisoPerfil");
		}
		return false;
	}
	protected Tiilc_perfilLocal find_Tiilc_perfilLocalHome_findPerfil(
			String cod_perfil) {
		Tiilc_perfilLocalHome aTiilc_perfilLocalHome = (Tiilc_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_perfilLocalHome_CLASS);
		try {
			if (aTiilc_perfilLocalHome != null)
				return aTiilc_perfilLocalHome.findPerfil(cod_perfil);
		} catch (javax.ejb.FinderException fe) {
			System.err
					.println("Tabla: Perfil - No se encontro registro con c" + (char) 243 + "digo "
							+ cod_perfil);
		}
		return null;
	}

	public PermisoPerfil findPermisoPerfil(String cod_perfil, int tipo_acceso,
			String valor_rcp) {
		PermisoPerfil permisoPerfil = null;
		try {
			Tiilc_permiso_perfilLocal aTiilc_permiso_perfilLocal = find_Tiilc_permiso_perfilLocalHome_findPermisoPerfil(
					cod_perfil, tipo_acceso, valor_rcp);
			if (aTiilc_permiso_perfilLocal != null){
				permisoPerfil = new PermisoPerfil();
				permisoPerfil.setCod_perfil(aTiilc_permiso_perfilLocal.getCod_perfil());
				permisoPerfil.setTipo_acceso(aTiilc_permiso_perfilLocal.getTipo_acceso());
				permisoPerfil.setValor_rcp(aTiilc_permiso_perfilLocal.getValor_rcp());
			}
		} catch (Exception e) {
			System.err.println("Error al traer data de la tabla PermisoPerfil");
		}
		return permisoPerfil;
	} 
	
	public boolean deletePermisoPerfil(String cod_perfil, int tipo_acceso,
			String valor_rcp){

		try {
			Tiilc_permiso_perfilLocal aTiilc_permiso_perfilLocal = find_Tiilc_permiso_perfilLocalHome_findPermisoPerfil(
					cod_perfil, tipo_acceso, valor_rcp);
					
			if (aTiilc_permiso_perfilLocal != null){
				aTiilc_permiso_perfilLocal.remove();
				return true;
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar tabla PermisoPerfil");
		}
		return false;
	}
	
	protected Tiilc_permiso_perfilLocal find_Tiilc_permiso_perfilLocalHome_findPermisoPerfil(
			String cod_perfil, int tipo_acceso, String valor_rcp) {
		Tiilc_permiso_perfilLocalHome aTiilc_permiso_perfilLocalHome = (Tiilc_permiso_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_permiso_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_permiso_perfilLocalHome_CLASS);
		try {
			if (aTiilc_permiso_perfilLocalHome != null)
				return aTiilc_permiso_perfilLocalHome.findPermisoPerfil(
						cod_perfil, tipo_acceso, valor_rcp);
		} catch (javax.ejb.FinderException fe) {
			System.err
			.println("Tabla: PermisoPerfil - No se encontro registro con c" + (char) 243 + "digo "
					+ cod_perfil + " tipo acceso " + tipo_acceso+ " valor rcp " +valor_rcp);
		}
		return null;
	}

	public String findPerfilxRegistro(String registro) {

		String Perfil = null;
				
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
					"select cod_perfil from iilc.tiilc_permiso_perfil where valor_rcp='"+registro+"' ";
				
				ResultSet rst = s.executeQuery(sql);
				while (rst.next()) {
					Perfil=rst.getString(1);
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
		return Perfil;
	}	
	//FIN - OSCAR CORTEZ -  BUSCA PERFIL DE USUARIO
}