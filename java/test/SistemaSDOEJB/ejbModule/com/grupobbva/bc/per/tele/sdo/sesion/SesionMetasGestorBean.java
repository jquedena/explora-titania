package com.grupobbva.bc.per.tele.sdo.sesion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Formatter.BigDecimalLayoutForm;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.ListaReportePGO;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG;
import com.grupobbva.bc.per.tele.sdo.serializable.ResumenObjetivo;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_epigrafeKey;
import entities.Tiido_epigrafeLocal;
import entities.Tiido_epigrafeLocalHome;
import entities.Tiido_metas_gestorKey;
import entities.Tiido_metas_gestorLocal;
import entities.Tiido_metas_gestorLocalHome;
import entities.Tiido_oficinaKey;
import entities.Tiido_oficinaLocal;
import entities.Tiido_oficinaLocalHome;
import entities.Tiido_territorioKey;

/**
 * Bean implementation class for Enterprise Bean: SesionMetasGestor
 */
@SuppressWarnings({ "unchecked", "serial", "unused" })
public class SesionMetasGestorBean implements javax.ejb.SessionBean {

	private static Logger log = Logger.getLogger(SesionMetasGestorBean.class);
	private javax.ejb.SessionContext mySessionCtx;
	private final static String STATIC_Tiido_metas_gestorLocalHome_REF_NAME = "ejb/Tiido_metas_gestor";
	private final static Class STATIC_Tiido_metas_gestorLocalHome_CLASS = Tiido_metas_gestorLocalHome.class;
	private final static String STATIC_Tiido_epigrafeLocalHome_REF_NAME = "ejb/Tiido_epigrafe";
	private final static Class STATIC_Tiido_epigrafeLocalHome_CLASS = Tiido_epigrafeLocalHome.class;
	private final static String STATIC_Tiido_oficinaLocalHome_REF_NAME = "ejb/Tiido_oficina";
	private final static Class STATIC_Tiido_oficinaLocalHome_CLASS = Tiido_oficinaLocalHome.class;
	private final static String STATIC_SesionOficinaHome_REF_NAME = "ejb/SesionOficina";
	private final static Class STATIC_SesionOficinaHome_CLASS = SesionOficinaHome.class;
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

	public MetasGestor findGestorByCodigo(String codGestor) {
		MetasGestor metasGestor = new MetasGestor();
		try {
			log.info("[SesionMetasGestorBean :: findGestorByCodigo] Inicio");
			
			Tiido_metas_gestorLocal aTiido_metas_gestorLocal = find_Tiido_metas_gestorLocalHome_findGestorByCodigo(codGestor);
			if(aTiido_metas_gestorLocal !=null){
				metasGestor.setCodGestor(aTiido_metas_gestorLocal.getCod_gestor());
				metasGestor.setNomGestor(aTiido_metas_gestorLocal.getNom_gestor());
			}else{
				metasGestor =null;
			}
			
			log.info("[SesionMetasGestorBean :: findGestorByCodigo] Fin");
		} catch (Exception e) {
			log.error("[SesionMetasGestorBean :: findGestorByCodigo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			metasGestor =null;
		}
		
		return metasGestor;
	}
	
	public MetasGestor findMetGestorByPrimaryKey(String codEpigrafe,
			String anho, String codOficina, String mes, String codGestor) {
		MetasGestor metasGestor = new MetasGestor();
		
		try {
			log.info("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] Inicio");
			
			Tiido_metas_gestorLocal aTiido_metas_gestorLocal = find_Tiido_metas_gestorLocalHome_findMetGestorByPrimaryKey(
					codEpigrafe, anho, codOficina, mes, codGestor);
			if (aTiido_metas_gestorLocal != null) {
				metasGestor.setAnho(aTiido_metas_gestorLocal.getTiido_metges_epigrafe_fk().getAnho());
				metasGestor.setCodEpigrafe(aTiido_metas_gestorLocal.getTiido_metges_epigrafe_fk().getCod_epigrafe());
				metasGestor.setCodGestor(aTiido_metas_gestorLocal.getCod_gestor());
				metasGestor.setCodMetaGestor(aTiido_metas_gestorLocal.getCod_meta_gestor());

				SesionOficina aSesionOficina = createSesionOficina();
				Oficina anOficina=null;
				try {
					 anOficina = aSesionOficina.findByCodOficina(codOficina);
				} catch (RemoteException e) {
					log.error("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] ");
					ConstantesUtil.mostrarMensajeExcepcion(e);
				}				
				
				metasGestor.setOficina(anOficina);											
				//metasGestor.setFecRegistro(aTiido_metas_gestorLocal
				//		.getFec_regi());
				metasGestor.setMes(aTiido_metas_gestorLocal.getMes());
				metasGestor.setNomEpigrafe(aTiido_metas_gestorLocal
						.getNom_epigrafe());
				metasGestor.setNomGestor(aTiido_metas_gestorLocal
						.getNom_gestor());
				metasGestor.setPorcAsignado(aTiido_metas_gestorLocal
						.getPorc_asig());
			}
			
			log.info("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] Fin");
		} catch (Exception e) {
			log.error("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return metasGestor;
	}

	public boolean createMetasGestor(MetasGestor metasGestor) {
		try {
			log.info("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] createMetasGestor");
			
			Tiido_epigrafeLocal aTiido_epigrafeLocal = null;
			Tiido_oficinaLocal aTiido_oficinaLocal = null;
			if (metasGestor.getCodMetaGestor() != null) {
				if (!metasGestor.getCodMetaGestor().equals("")) {
					aTiido_epigrafeLocal = find_Tiido_epigrafeLocalHome_findByPrimaryKey(new Tiido_epigrafeKey(metasGestor.getCodEpigrafe(), metasGestor.getAnho()));
					aTiido_oficinaLocal = find_Tiido_oficinaLocalHome_findByPrimaryKey(new Tiido_oficinaKey(metasGestor.getOficina().getCodOfic(), new Tiido_territorioKey(metasGestor.getOficina().getTerr().getCodTerr())));
				}
			}
			
			log.info("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] Epigrafe:" + aTiido_epigrafeLocal.getCod_epigrafe());
			log.info("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] Oficina:" + ((Tiido_oficinaKey)aTiido_oficinaLocal.getPrimaryKey()).getCod_ofic());
			
			Tiido_metas_gestorLocal aTiido_metas_gestorLocal = createTiido_metas_gestorLocal(metasGestor, aTiido_epigrafeLocal, aTiido_oficinaLocal);
			
			//aTiido_metas_gestorLocal.setFec_regi(new java.sql.Date(new java.util.Date().getTime()));
			
			log.info("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] Fin");
		} catch (Exception e) {
			log.error("[SesionMetasGestorBean :: findMetGestorByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return false;
		}
		return true;
	}
	
	
	
	public boolean updateMetasGestor(MetasGestor metasGestor) {
		try {
			log.info("[SesionMetasGestorBean :: updateMetasGestor] Inicio");
			
			Tiido_metas_gestorLocal aTiido_metas_gestorLocal = null;
			
		//	aTiido_metas_gestorLocal.setCod_gestor(metasGestor.getCodGestor());

			Tiido_epigrafeLocal aTiido_epigrafeLocal = find_Tiido_epigrafeLocalHome_findByPrimaryKey(new Tiido_epigrafeKey(
					metasGestor.getCodEpigrafe(), metasGestor.getAnho()));

			Tiido_oficinaLocal aTiido_oficinaLocal = find_Tiido_oficinaLocalHome_findByPrimaryKey(new Tiido_oficinaKey(
					metasGestor.getOficina().getCodOfic(),
					new Tiido_territorioKey(metasGestor.getOficina().getTerr()
							.getCodTerr())));

			aTiido_metas_gestorLocal = find_Tiido_metas_gestorLocalHome_findByPrimaryKey(new Tiido_metas_gestorKey(
					metasGestor.getCodMetaGestor(),new Tiido_epigrafeKey(metasGestor.getCodEpigrafe(), metasGestor.getAnho()),
					new Tiido_oficinaKey(metasGestor.getOficina().getCodOfic(),new Tiido_territorioKey(metasGestor.getOficina().getTerr().getCodTerr()))));
		
		if(aTiido_metas_gestorLocal!=null){
			aTiido_metas_gestorLocal.setOrden(metasGestor.getOrden());
			aTiido_metas_gestorLocal.setPorc_asig(metasGestor.getPorcAsignado());
			aTiido_metas_gestorLocal.setCod_perfil_gestor(metasGestor.getCodPerfil());
			aTiido_metas_gestorLocal.setUsu_actu(metasGestor.getUsuario());
			aTiido_metas_gestorLocal.setFec_actu(new java.util.Date());
		}
		
		log.info("[SesionMetasGestorBean :: updateMetasGestor] Fin");
		}catch(Exception e){
			log.error("[SesionIngresosBean :: updateMetasGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		return true;
	}
	
	public Vector nuevaMetaGestor(String codMetaGestor, String codTerritorio,
			String codOficina, String codEpigrafe, String anho,
			String codGestor, String codigoPerfil, String mes, Double porc_asig,
			String nom_epigrafe, String nom_gestor, String usuario) {

		Vector res = null;
		MetasGestor bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: nuevaMetaGestor] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: nuevaMetaGestor] Fin");
				
				return null;
			}
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: nuevaMetaGestor] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql = "insert into tiido_metas_gestor "
						+ "(COD_META_GESTOR, COD_TERR, COD_OFIC, COD_EPIGRAFE, ANHO, COD_GESTOR, "
						+ "MES, PORC_ASIG, NOM_EPIGRAFE, NOM_GESTOR, COD_PERFIL, ESTADO, USU_REGI) values ('"
						+ codMetaGestor + "','" + codTerritorio + "','"
						+ codOficina + "','" + codEpigrafe + "','" + anho
						+ "','" + codGestor + "','" + mes + "','" + 0
						+ "','" + nom_epigrafe + "','" + nom_gestor + "', '" + codigoPerfil +  "', 'A', '" + usuario + "')";

				log.info("[SesionMetasGestorBean :: nuevaMetaGestor] SQL:" + sql);
				rst = s.executeQuery(sql);
				/*while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new MetasGestor();
					res.add(bean);
				}*/
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: nuevaMetaGestor] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMetasGestorBean :: nuevaMetaGestor] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: nuevaMetaGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (s != null)
					s.close();
				if (con != null)
					con.close();
				if (initialContext != null)
					initialContext.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: nuevaMetaGestor] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		return res;
	}								
	
	public MetasGestor findGestorByCodMonthYear(String anho, String mes, String codOficina, String codGestor){
		Connection con =null;
		Statement s =null;
		ResultSet rst =null;
		Context initialContext =null;
		String sql ="";
		MetasGestor bean =null;
		
		try{
			log.info("[SesionMetasGestorBean :: findGestorByCodMonthYear] Inicio");
			
			initialContext =new InitialContext();
			if(initialContext==null) {
				log.info("[SesionMetasGestorBean :: findGestorByCodMonthYear] Fin");
				
				return null;
			}
			DataSource dataSource=(DataSource)initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if(dataSource!=null){
				con =dataSource.getConnection();
			}else{
				initialContext=null;
				log.info("[SesionMetasGestorBean :: findGestorByCodMonthYear] Fin");
				
				return null;
			}
			s =con.createStatement();
			try{
				sql ="select cod_meta_gestor, cod_epigrafe, anho, cod_gestor, mes, orden, fec_regi, " +
					 "porc_asig, nom_epigrafe, nom_gestor from tiido_metas_gestor where anho= '"+anho+
					 "' and mes= '"+mes+"' and cod_ofic= '"+codOficina+"' and cod_gestor='"+codGestor+"'";
				
				log.info("[SesionMetasGestorBean :: findGestorByCodMonthYear] SQL:" + sql);
				
				rst =s.executeQuery(sql);
				if(rst.next()){
					bean =new MetasGestor();
					bean.setCodMetaGestor(rst.getString(1));
					bean.setCodEpigrafe(rst.getString(2));
					bean.setAnho(rst.getString(3));
					bean.setCodGestor(rst.getString(4));
					bean.setMes(rst.getString(5));
					bean.setOrden(rst.getString(6));
					bean.setFecRegistro(rst.getDate(7));
					bean.setPorcAsignado(rst.getBigDecimal(8));
					bean.setNomEpigrafe(rst.getString(9));
					bean.setNomGestor(rst.getString(10));
				}
			}catch(Exception e){
				log.error("[SesionIngresosBean :: findGestorByCodMonthYear] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
			
			log.info("[SesionMetasGestorBean :: findGestorByCodMonthYear] Fin");
		}catch(Exception e){
			log.error("[SesionIngresosBean :: findGestorByCodMonthYear] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}finally{
			try{
				if(s!=null) s.close();
				if(rst!=null) rst.close();
				if(con!=null) con.close();
				if(initialContext!=null) initialContext.close();
			}catch(Exception e){
				log.error("[SesionIngresosBean :: findGestorByCodMonthYear] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		
		return bean;
	}
	
	protected Tiido_metas_gestorLocal find_Tiido_metas_gestorLocalHome_findGestorByCodigo(String codGestor) {
		try {
			log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findGestorByCodigo] Inicio");
			
			Tiido_metas_gestorLocalHome aTiido_metas_gestorLocalHome = (Tiido_metas_gestorLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_metas_gestorLocalHome_REF_NAME,
					STATIC_Tiido_metas_gestorLocalHome_CLASS);
			
			if (aTiido_metas_gestorLocalHome != null) {
				log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findGestorByCodigo] Fin");
				
				return aTiido_metas_gestorLocalHome.findGestorByCodigo(codGestor);
			}
			
			log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findGestorByCodigo] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: find_Tiido_metas_gestorLocalHome_findGestorByCodigo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		return null;
	}
	
	protected Tiido_metas_gestorLocal find_Tiido_metas_gestorLocalHome_findMetGestorByPrimaryKey(
			String codEpigrafe, String anho, String codOficina, String mes,
			String codGestor) {
		
		try {
			log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findMetGestorByPrimaryKey] Inicio");
			
			Tiido_metas_gestorLocalHome aTiido_metas_gestorLocalHome = (Tiido_metas_gestorLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_metas_gestorLocalHome_REF_NAME,
					STATIC_Tiido_metas_gestorLocalHome_CLASS);
			
			if (aTiido_metas_gestorLocalHome != null) {
				log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findMetGestorByPrimaryKey] Fin");
				
				return aTiido_metas_gestorLocalHome.findMetGestorByPrimaryKey(
						codEpigrafe, anho, codOficina, mes, codGestor);
			}
			
			log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findMetGestorByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: find_Tiido_metas_gestorLocalHome_findMetGestorByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_epigrafeLocal find_Tiido_epigrafeLocalHome_findByPrimaryKey(
			Tiido_epigrafeKey primaryKey) {
		
		try {
			log.info("[SesionMetasGestorBean :: find_Tiido_epigrafeLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_epigrafeLocalHome aTiido_epigrafeLocalHome = (Tiido_epigrafeLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_epigrafeLocalHome_REF_NAME,
					STATIC_Tiido_epigrafeLocalHome_CLASS);
			
			if (aTiido_epigrafeLocalHome != null) {
				log.info("[SesionMetasGestorBean :: find_Tiido_epigrafeLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_epigrafeLocalHome.findByPrimaryKey(primaryKey);
			}
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: find_Tiido_epigrafeLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_oficinaLocal find_Tiido_oficinaLocalHome_findByPrimaryKey(
			Tiido_oficinaKey primaryKey) {
		
		try {
			log.info("[SesionMetasGestorBean :: find_Tiido_oficinaLocalHome_findByPrimaryKey] Fin");
			
			Tiido_oficinaLocalHome aTiido_oficinaLocalHome = (Tiido_oficinaLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_oficinaLocalHome_REF_NAME,
					STATIC_Tiido_oficinaLocalHome_CLASS);
			 
			if (aTiido_oficinaLocalHome != null) {
				log.info("[SesionMetasGestorBean :: find_Tiido_oficinaLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_oficinaLocalHome.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionMetasGestorBean :: find_Tiido_oficinaLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: find_Tiido_oficinaLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		return null;
	}
	protected Tiido_metas_gestorLocal createTiido_metas_gestorLocal(MetasGestor metasGestor, Tiido_epigrafeLocal epigrafeLocal, Tiido_oficinaLocal oficinaLocal) {
		
		try {
			log.info("[SesionMetasGestorBean :: createTiido_metas_gestorLocal] Inicio");
			
			Tiido_metas_gestorLocalHome aTiido_metas_gestorLocalHome = (Tiido_metas_gestorLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_metas_gestorLocalHome_REF_NAME,
					STATIC_Tiido_metas_gestorLocalHome_CLASS);
			
			if (aTiido_metas_gestorLocalHome != null) {
				log.info("[SesionMetasGestorBean :: createTiido_metas_gestorLocal] Fin");
				
				return aTiido_metas_gestorLocalHome.create(metasGestor,
						epigrafeLocal, oficinaLocal);
			}
			
			log.info("[SesionMetasGestorBean :: createTiido_metas_gestorLocal] Fin");
		} catch (javax.ejb.CreateException e) {
			log.error("[SesionIngresosBean :: createTiido_metas_gestorLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: createTiido_metas_gestorLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_metas_gestorLocal find_Tiido_metas_gestorLocalHome_findByPrimaryKey(
			Tiido_metas_gestorKey primaryKey) {
	
		try {
			log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_metas_gestorLocalHome aTiido_metas_gestorLocalHome = (Tiido_metas_gestorLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_metas_gestorLocalHome_REF_NAME,
					STATIC_Tiido_metas_gestorLocalHome_CLASS);
			
			if (aTiido_metas_gestorLocalHome != null) {
				log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_metas_gestorLocalHome
						.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMetasGestorBean :: find_Tiido_metas_gestorLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		return null;
	}
	protected Tiido_oficinaLocal find_Tiido_oficinaLocalHome_findByCodOficina(
			String codOficina) {
		
		try {
			log.info("[SesionMetasGestorBean :: find_Tiido_oficinaLocalHome_findByCodOficina] Inicio");
			
			Tiido_oficinaLocalHome aTiido_oficinaLocalHome = (Tiido_oficinaLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_oficinaLocalHome_REF_NAME,
					STATIC_Tiido_oficinaLocalHome_CLASS);
			
			if (aTiido_oficinaLocalHome != null) {
				log.info("[SesionMetasGestorBean :: find_Tiido_oficinaLocalHome_findByCodOficina] Fin");
				
				return aTiido_oficinaLocalHome.findByCodOficina(codOficina);
			}
			
			log.info("[SesionMetasGestorBean :: find_Tiido_oficinaLocalHome_findByCodOficina] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: find_Tiido_oficinaLocalHome_findByCodOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		return null;
	}
	protected SesionOficina createSesionOficina() {
		
		try {
			log.info("[SesionMetasGestorBean :: createSesionOficina] Inicio");
			
			SesionOficinaHome aSesionOficinaHome = (SesionOficinaHome) ServiceLocatorManager
			.getRemoteHome(STATIC_SesionOficinaHome_REF_NAME,
					STATIC_SesionOficinaHome_CLASS);
			 
			if (aSesionOficinaHome != null) {
				log.info("[SesionMetasGestorBean :: createSesionOficina] Fin");
				
				return aSesionOficinaHome.create();
			}
			
			log.info("[SesionMetasGestorBean :: createSesionOficina] Fin");
		} catch (javax.ejb.CreateException e) {
			log.error("[SesionIngresosBean :: createSesionOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (RemoteException e) {
			log.error("[SesionIngresosBean :: createSesionOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: createSesionOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	
//	OSCAR CORTEZ - BUSCAR TODOS LOS ANHOS
	public Vector busAllAnhos() {
		Vector res = null;
		ReportePPG bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: busAllAnhos] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: busAllAnhos] Fin");
				
				return null;
			}			
			
			log.info("[SesionMetasGestorBean :: busAllAnhos] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: busAllAnhos] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"select distinct(anho) as anho from tiido_metas_gestor order by anho DESC";									
					
				log.info("[SesionMetasGestorBean :: busAllAnhos] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();
					
					bean.setAnho(rst.getString(1));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busAllAnhos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busAllAnhos] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: busAllAnhos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	//FIN - OSCAR CORTEZ - BUSCAR TODOS LOS ANHOS
	
	//OSCAR CORTEZ - BUSCAR GESTOR X OFICINA
	public Vector busGestorxOficina(String codOficina) {
		Vector res = null;
		ReportePPG bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: busGestorxOficina] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: busGestorxOficina] Fin");
				
				return null;
			}			
			
			log.info("[SesionMetasGestorBean :: busGestorxOficina] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: busGestorxOficina] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"select distinct nom_gestor,cod_gestor from tiido_metas_gestor where cod_ofic ='"+codOficina+"'";									
					
				log.info("[SesionMetasGestorBean :: busGestorxOficina] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();
					
					bean.setNomGestor(rst.getString(1));
					bean.setCodGestor(rst.getString(2));					
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionMetasGestorBean :: busGestorxOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
		} catch (Exception e) {
			log.error("[SesionMetasGestorBean :: busGestorxOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionMetasGestorBean :: busGestorxOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	
	
	//FIN - OSCAR CORTEZ - BUSCAR GESTOR X OFICINA
	
	public Vector busGestorxOficinaxAnioxMes(String codOficina, String mes, String anio) {
		Vector res = null;
		ReportePPG bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: busGestorxOficinaxAnioxMes] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: busGestorxOficinaxAnioxMes] Fin");
				
				return null;
			}			
			
			log.info("[SesionMetasGestorBean :: busGestorxOficinaxAnioxMes] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: busGestorxOficinaxAnioxMes] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =					
					" SELECT DISTINCT nom_gestor, cod_gestor FROM tiido_metas_gestor WHERE cod_ofic ='"+codOficina+"' AND " +
					" mes = '" + mes + "' AND anho ='" + anio +"'";									
					
				log.info("[SesionMetasGestorBean :: busGestorxOficinaxAnioxMes] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();
					
					bean.setNomGestor(rst.getString(1));
					bean.setCodGestor(rst.getString(2));					
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busGestorxOficinaxAnioxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionMetasGestorBean :: busGestorxOficinaxAnioxMes] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busGestorxOficinaxAnioxMes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: busGestorxOficinaxAnioxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}					
		
		return res;	
	}	
	
//	OSCAR CORTEZ - BUSCAR CODIGO Y NOMBRE DE OFICINA
	public Vector busOficinaCodyNom(String codTerritorio) {
		Vector res = null;
		ReportePPG bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: busOficinaCodyNom] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: busOficinaCodyNom] Fin");
				
				return null;
			}			
			
			log.info("[SesionMetasGestorBean :: busOficinaCodyNom] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: busOficinaCodyNom] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"select cod_ofic, nom_ofic from tiido_oficina where cod_terr='"+codTerritorio+"' order by cod_ofic asc";									
					
				log.info("[SesionMetasGestorBean :: busOficinaCodyNom] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();
					
					bean.setCodOficina(rst.getString(1));
					bean.setNomOficina(rst.getString(2));	
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busOficinaCodyNom] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMetasGestorBean :: busOficinaCodyNom] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busOficinaCodyNom] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: busOficinaCodyNom] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	//FIN - OSCAR CORTEZ - BUSCAR CODIGO Y NOMBRE DE OFICINA
	
//	OSCAR CORTEZ - BUSCAR EPIGREAFE
	public Vector busEpigrafeAcciones2(String codGestor, String anho, String mes, String codOficina) {
		Vector res = null;
		ReportePPG bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: busEpigrafeAcciones2] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: busEpigrafeAcciones2] Fin");
				
				return null;
			}
			
			log.info("[SesionMetasGestorBean :: busEpigrafeAcciones2] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: busEpigrafeAcciones2] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"select a.cod_Epigrafe, a.nom_Epigrafe, a.ind_Clase, b.prioridad," +
					"nvl( (select c.porc_asig from tiido_metas_gestor c where c.cod_epigrafe=a.cod_epigrafe and" +
					" c.cod_Gestor ='"+codGestor+"' and c.anho='"+anho+"' and c.mes='"+mes+"' and" + 
					" c.cod_ofic='"+codOficina+"' and b.cod_ofic=c.cod_ofic),0) as orden from" +
					" tiido_epigrafe a, tiido_planes b where a.anho='"+anho+"' and a.cod_epigrafe=b.cod_epigrafe and" + 
					" b.anho_plan='"+anho+"' and b.mes_plan='"+mes+"' and b.cod_ofic='"+codOficina+"' " + 
					//" AND a.abreviatura ='PRUEBA' order by b.prioridad, orden desc, b.met_messald_punt";											
					" order by b.prioridad, orden desc, b.met_messald_punt";
					
				log.info("[SesionMetasGestorBean :: busEpigrafeAcciones2] SQL:" + sql);
				rst = s.executeQuery(sql);				
				SesionEpigrafeBean aSesionEpigrafe = new SesionEpigrafeBean();
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();
					
					bean.setCodEpigrafe(rst.getString(1));
					bean.setNomEpigrafe(rst.getString(2));
					bean.setPrioridad(rst.getString(4));
					
					Epigrafe anEpigrafe = aSesionEpigrafe.findByCodEpigAnho(bean.getCodEpigrafe(), anho);
					if (anEpigrafe != null){
						String dato=anEpigrafe.getIndAfecta();
						bean.setIndAfecta(dato);
					} else {
						bean.setIndAfecta("N");
					}
					
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busEpigrafeAcciones2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMetasGestorBean :: busEpigrafeAcciones2] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busEpigrafeAcciones2] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: busEpigrafeAcciones2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	//FIN - OSCAR CORTEZ - BUSCAR EPIGREAFE
	
//	OSCAR CORTEZ - REPORTE PGO
	public Vector reportePGO1(String codAnho, String codMes, String codOficina) {
		Vector res = null;
		ListaReportePGO bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: reportePGO1] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: reportePGO1] Fin");
				
				return null;
			}		
			
			log.info("[SesionMetasGestorBean :: reportePGO1] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}
			int numeroCliente=0;
			int compGestor=0;
			int numeroGest1=0;
			int numeroConcr1=0;
			int monto1=0;
			int numeroGest2=0;
			int numeroConcr2=0;
			int monto2=0;
			int desv1=0;
			int desv2=0;
			int totalDesv1=0;
			int totalDesv2=0;

			s = con.createStatement();
			try {
				/*
				String sql =
					
					"SELECT a.COD_EPIGRAFE as codEpigrafe, a.NOM_EPIGRAFE as nomEpigrafe, "+
			        "a.COD_OFIC as codOficina, a.MES_PLAN as mesPlan," + 
			        "a.ANHO_PLAN as anoPlan, (ROUND(a.Fact_ajus_terri) - ROUND(a.Fact_asig_gte_of)) as metMesSaldPuntual, "+
					"a.PRIORIDAD as prioridad, a.MET_GER_OFI as metGestOficina, "+ 
			        "b.NOM_ACCI as nomAccion, b.COD_GEST as codGestor, "+
			        "b.NRO_CLIE as nroCliente, b.COMP_GEST as compGestor, "+ 
			        "b.NRO_GEST_SEGU_1 as nroGestSeg1, b.NRO_CONC_SEGU_1 as nroConcSeg1, "+ 
			        "b.MON_SEGU_1 as montSeg1, b.NRO_GEST_SEGU_2 as nroGestSeg2, "+  
			        "b.NRO_CONC_SEGU_2 as nroConcSeg2, b.MON_SEGU_2 as montSeg1, "+
			        "b.COD_ACCI as codAccion, d.IND_AFECTA as indAfecta, "+ 
			        "nvl((SELECT c.PORC_ASIG from TIIDO_METAS_GESTOR c "+ 
			        "where c.COD_EPIGRAFE=d.COD_EPIGRAFE and c.COD_GESTOR =b.COD_GEST and "+ 
			        "c.ANHO = '"+codAnho+"' and c.MES = '"+codMes+"' and c.COD_OFIC = '"+codOficina+"' and "+ 
			        "a.COD_OFIC=c.COD_OFIC ),0) as porAsignado "+ 
			        "from TIIDO_PLANES a, TIIDO_ACCIONES b, TIIDO_EPIGRAFE d where "+ 
			        "a.COD_EPIGRAFE = b.COD_EPIGRAFE and "+ 
			        "a.COD_EPIGRAFE = d.COD_EPIGRAFE and "+
			        "a.COD_OFIC = '"+codOficina+"' and a.ANHO_PLAN = '"+codAnho+"' "+ 
			        "and b.COD_OFIC = '"+codOficina+"' and b.ANHO = '"+codAnho+"' "+ 
			        "and a.MES_PLAN = '"+codMes+"' and b.MES_ACCI = '"+codMes+"' "+ 
			        "and d.ANHO = '"+codAnho+"' "+ 
			        "Order by a.PRIORIDAD, a.MET_MESSALD_PUNT, a.COD_EPIGRAFE , b.COD_GEST , b.COD_ACCI";									
				*/
				
				String sql = "SELECT (SELECT e.cod_epigrafe FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = ta.cod_epigrafe and e.anho = ta.anho) codEpigrafe, " + 
							 "(SELECT e.nom_epigrafe FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = ta.cod_epigrafe and e.anho = ta.anho) nomEpigrafe, " +   
							 "ta.cod_ofic, ta.mes_acci, ta.anho, " +						     
						     "(SELECT p.fact_ajus_terri " + 
						     "FROM tiido_planes p " +
						     "WHERE p.cod_ofic = ta.cod_ofic AND " +     
						     "        p.anho_plan = ta.anho AND " +     
						     "        p.mes_plan =ta.mes_acci AND " +    
						     "        p.cod_epigrafe = ta.cod_epigrafe " +
						     ") fact_ajus_terri, " + 
						     "(SELECT p.prioridad " +
						     "FROM tiido_planes p " + 
						     "WHERE p.cod_ofic = ta.cod_ofic AND " +     
						     "      p.anho_plan = ta.anho AND " +     
						     "      p.mes_plan =ta.mes_acci AND " +    
						     "      p.cod_epigrafe = ta.cod_epigrafe " +
						     ") prioridad, " +
						     "(SELECT p.met_ger_ofi " +
						     "FROM tiido_planes p " + 
						     "WHERE p.cod_ofic = ta.cod_ofic AND " +    
						     "	p.anho_plan = ta.anho AND " +     
						     "   p.mes_plan =ta.mes_acci AND " +    
						     "   p.cod_epigrafe = ta.cod_epigrafe " + 
						     ") met_ger_ofi, " + 
						     "ta.nom_acci,  ta.cod_gest, ta.nro_clie, ta.comp_gest, ta.nro_gest_segu_1, ta.nro_conc_segu_1, " + 
						     "ROUND(NVL(ta.mon_segu_1, 0)) mon_segu_1, ta.nro_gest_segu_2, ta.nro_conc_segu_2, ROUND(NVL(ta.mon_segu_2, 0)) mon_segu_2, ta.cod_acci, " + 
						     "(SELECT e.ind_Afecta FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = ta.cod_epigrafe AND e.anho = ta.anho) indAfecta, " +
						     "NVL((SELECT SUM(d.porc_asig) " + 
						     "       FROM tiido_metas_gestor d " +   
						     "       WHERE d.cod_gestor = ta.cod_gest AND " + 
						     "            d.cod_ofic = ta.cod_ofic AND " +         
						     "            d.anho = ta.anho AND " + 
						     "            d.mes = ta.mes_acci AND " +
						     "            d.cod_epigrafe = ta.cod_epigrafe), 0) porc_asig " + 
						"FROM TIIDO_ACCIONES ta " + 
						"WHERE ta.cod_ofic = '" + codOficina + "' AND " +    
						"      ta.anho = " + codAnho + " AND " +     
						"      ta.mes_acci = " + codMes + " " + 
						"ORDER BY prioridad, fact_ajus_terri, ta.cod_epigrafe, ta.cod_gest, ta.cod_acci ";
				
				log.info("[SesionMetasGestorBean :: reportePGO1] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListaReportePGO();
					
					bean.setCodEpigrafe(rst.getString("codEpigrafe"));
					bean.setNomEpigrafe(rst.getString("nomEpigrafe"));
					bean.setCodOficina(rst.getString("cod_ofic"));
					bean.setMesPlan(rst.getString("mes_acci"));
					bean.setAnoPlan(rst.getString("anho"));
					// Seg����������n del usuario
					bean.setMetMesSaldPuntual(rst.getString("fact_ajus_terri"));
					bean.setPrioridad(rst.getString("prioridad"));
					bean.setMetGestOficina(rst.getString("met_ger_ofi"));
					bean.setNomAccion(rst.getString("nom_acci"));
					bean.setCodGestor(rst.getString("cod_gest"));
					bean.setNroCliente(rst.getString("nro_clie"));
					bean.setCompGestor(rst.getString("comp_gest"));
					bean.setNroGestSeg1(rst.getString("nro_gest_segu_1"));
					bean.setNroConcSeg1(rst.getString("nro_conc_segu_1"));
					bean.setMontSeg1(rst.getString("mon_segu_1"));
					bean.setNroGestSeg2(rst.getString("nro_gest_segu_2"));
					bean.setNroConcSeg2(rst.getString("nro_conc_segu_2"));
					bean.setMontSeg1_1(rst.getString("mon_segu_2"));
					bean.setCodAccion(rst.getString("cod_acci"));
					bean.setIndAfecta(rst.getString("indAfecta"));
					bean.setPorAsignado(rst.getString("porc_asig"));
					
					desv1 = Integer.parseInt(bean.getMontSeg1()) - Integer.parseInt(bean.getCompGestor());
					bean.setDesv1(String.valueOf(desv1));
					
					desv2 = Integer.parseInt(bean.getMontSeg1_1())-Integer.parseInt(bean.getCompGestor());
					bean.setDesv2(String.valueOf(desv2));
					
					totalDesv1 = totalDesv1 + desv1;
					totalDesv2 = totalDesv2 + desv2;
					
					numeroCliente = numeroCliente+Integer.parseInt(bean.getNroCliente());
					compGestor = compGestor+Integer.parseInt(bean.getCompGestor());
					
					numeroGest1 = numeroGest1+Integer.parseInt(bean.getNroGestSeg1());
					numeroConcr1 = numeroConcr1+Integer.parseInt(bean.getNroConcSeg1());
					monto1 = monto1 + Integer.parseInt(bean.getMontSeg1());
					
					numeroGest2 = numeroGest2 + Integer.parseInt(bean.getNroGestSeg2());
					numeroConcr2 = numeroConcr2 + Integer.parseInt(bean.getNroConcSeg2());
					monto2 = monto2 + Integer.parseInt(bean.getMontSeg1_1());
					
					res.add(bean);
				}
				
				bean = new ListaReportePGO();
				bean.setTotalnumeroCliente(numeroCliente);
				bean.setTotalcompGestor(compGestor);
				bean.setTotalnumeroGest1(numeroGest1);
				bean.setTotalnumeroConcr1(numeroConcr1);
				bean.setTotalmonto1(monto1);
				bean.setTotalnumeroGest2(numeroGest2);
				bean.setTotalnumeroConcr2(numeroConcr2);
				bean.setTotalmonto2(monto2);				
				bean.setTotaldesv1(totalDesv1);
				bean.setTotaldesv2(totalDesv2);
				
				if (res == null)
					res = new Vector(0, 1);
				
				res.add(bean);
				
		
			} catch (SQLException e) {
				log.error("[SesionMetasGestorBean :: reportePGO1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionMetasGestorBean :: reportePGO1] Fin");
		} catch (Exception e) {
			log.error("[SesionMetasGestorBean :: reportePGO1] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionMetasGestorBean :: reportePGO1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	
	public Vector reportePGOEsfuerzos(String codAnho, String codMes, String codOficina) {
		Vector cabLista = null;
		Iterator iterCabLista = null;
		Vector detLista = null;
		Iterator iterDetLista = null;
		Vector totalLista = null;
		Iterator iterTotalLista = null;
		ListaReportePGO cabBean = null;
		ListaReportePGO detBean = null;

		try {
			log.info("[SesionMetasGestorBean :: reportePGOEsfuerzos] Inicio");
			
			int totalNroCli = 0;
			int totalCompGestor = 0;
			int totalNroGest = 0;
			int totalConcr = 0;
			int totalMonto = 0;
			int totalDesv = 0;
				
			cabLista = reportePGOCabEsfuerzos(codAnho, codMes, codOficina);			
			if(cabLista  != null) {
				iterCabLista = cabLista.iterator();
				int nroCli=0;
				int comprGest=0;
				int nroGestor=0;
				int nroConcr=0;
				int montoNro=0;
				int desv=0;
				while(iterCabLista.hasNext()) {
					cabBean = (ListaReportePGO)iterCabLista.next();
					
					if (totalLista == null) {
						totalLista = new Vector(0, 1);
					}
					
					totalLista.add(cabBean);					
					detLista = reportePGODetEsfuerzos(codAnho, codMes, codOficina, cabBean.getCodAccion());
					
					if(detLista  != null) {
						iterDetLista = detLista.iterator();
						while(iterDetLista.hasNext()) {
							detBean = (ListaReportePGO)iterDetLista.next();
							
							if(detBean.getNroCliente() != null) {
								totalNroCli += Integer.parseInt(detBean.getNroCliente().toString());
								nroCli += Integer.parseInt(detBean.getNroCliente().toString());
							}
							
							if(detBean.getCompGestor() != null) {
								totalCompGestor += Integer.parseInt(detBean.getCompGestor().toString());
								comprGest += Integer.parseInt(detBean.getCompGestor().toString());
							}
							
							if(detBean.getNroGestSeg2() != null) {
								totalNroGest += Integer.parseInt(detBean.getNroGestSeg2().toString());
								nroGestor += Integer.parseInt(detBean.getNroGestSeg2().toString());
							}
							
							if(detBean.getNroConcSeg2() != null) {
								totalConcr += Integer.parseInt(detBean.getNroConcSeg2().toString());
								nroConcr += Integer.parseInt(detBean.getNroConcSeg2().toString());
							}
							
							if(detBean.getMontSeg1_1() != null) {
								totalMonto += Integer.parseInt(detBean.getMontSeg1_1().toString());
								montoNro += Integer.parseInt(detBean.getMontSeg1_1().toString());
							}
							
							if(detBean.getDesv2() != null) {
								totalDesv += Integer.parseInt(detBean.getDesv2().toString());
								desv += Integer.parseInt(detBean.getDesv2().toString());
							}
							
							totalLista.add(detBean);	
						}
						
						//add
						ListaReportePGO totalPorEpigrafe = new ListaReportePGO();	
						totalPorEpigrafe.setResumenPorEpigrafe(true);
						totalPorEpigrafe.setNroCliente(new Integer(nroCli).toString());
						totalPorEpigrafe.setCompGestor(new Integer(comprGest).toString());
						totalPorEpigrafe.setNroGestSeg2(new Integer(nroGestor).toString());
						totalPorEpigrafe.setNroConcSeg2(new Integer(nroConcr).toString());
						totalPorEpigrafe.setMontSeg1_1(new Integer(montoNro).toString());																	
						totalPorEpigrafe.setDesv2(new Integer(desv).toString());
						totalPorEpigrafe.setNomAccion("Total Oficina - "+cabBean.getNomEpigrafe());						
						Integer montoObjetivo = StringUtils.isNotEmpty(cabBean.getMetMesSaldPuntual())? Integer.valueOf(cabBean.getMetMesSaldPuntual()):new Integer(0);
						if(montoNro<montoObjetivo.intValue()){
							totalPorEpigrafe.setBackgroundColor("#FFB1B1");
						}
						if(montoNro==montoObjetivo.intValue()){
							totalPorEpigrafe.setBackgroundColor("#FEFECC");
						}
						if(montoNro>montoObjetivo.intValue()){
							totalPorEpigrafe.setBackgroundColor("#D6FED9");
						}
						totalLista.add(totalPorEpigrafe);
						nroCli=0;comprGest=0;nroGestor=0;nroConcr=0;montoNro=0;desv=0;
					}
				}
				
				detBean = new ListaReportePGO();
				detBean.setTotalnumeroCliente(totalNroCli);
				detBean.setTotalcompGestor(totalCompGestor);
				detBean.setTotalnumeroGest2(totalNroGest);
				detBean.setTotalnumeroConcr2(totalConcr);
				detBean.setTotalnumeroConcr2(totalConcr);
				detBean.setTotalmonto2(totalMonto);
				detBean.setTotaldesv2(totalDesv);
				totalLista.add(detBean);
			}
			
			log.info("[SesionMetasGestorBean :: reportePGOEsfuerzos] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: reportePGOEsfuerzos] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return totalLista;	
	}	
	
	public Vector reportePGOCabEsfuerzos(String codAnho, String codMes, String codOficina) {
		Vector res = null;
		ListaReportePGO bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMetasGestorBean :: reportePGOCabEsfuerzos] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: reportePGOCabEsfuerzos] Fin");
				
				return null;
			}		
			
			log.info("[SesionMetasGestorBean :: reportePGOCabEsfuerzos] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: reportePGOCabEsfuerzos] Fin");
				
				return null;
			}

			s = con.createStatement();
			
			try {
				String sql =					
					"SELECT c.nom_camp nom_camp, c.cod_camp id_camp, c.cod_gest gest, c.orden " + 
					"FROM tiido_campanias c " + 
					"WHERE c.anho = '" + codAnho + "' and c.mes = '" + codMes + "' and c.cod_ofic = '" +  codOficina + "'" +
					//"ORDER BY c.cod_camp";									
					"ORDER BY c.orden";
					
				log.info("[SesionMetasGestorBean :: reportePGOCabEsfuerzos] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null) {
						res = new Vector(0, 1);
					}
					
					bean = new ListaReportePGO();	
					bean.setNomEpigrafe(rst.getString(1));
					bean.setCodAccion(rst.getString(2));
					bean.setCodGestor(rst.getString(3));
					bean.setPrioridad(rst.getString(4));
					
					res.add(bean);
				}		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: reportePGOCabEsfuerzos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMetasGestorBean :: reportePGOCabEsfuerzos] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: reportePGOCabEsfuerzos] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: reportePGOCabEsfuerzos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	
	public Vector reportePGODetEsfuerzos(String codAnho, String codMes, String codOficina, String idEsfuerzo) {
		Vector res = null;
		ListaReportePGO bean = null;
		int desv1 = 0;
		int desv2 = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			log.info("[SesionMetasGestorBean :: reportePGODetEsfuerzos] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: reportePGODetEsfuerzos] Fin");
				
				return null;
			}			
			
			log.info("[SesionMetasGestorBean :: reportePGODetEsfuerzos] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: reportePGODetEsfuerzos] Fin");
				
				return null;
			}

			s = con.createStatement();
			
			try {
				String sql =					
					"SELECT d.nom_camp nom_camp, d.nro_clie, d.comp_gest, " +  
					"NVL(d.nro_gest_segu_1, 0) + NVL(d.nro_gest_segu_2, 0), " + 
					"NVL(d.nro_conc_segu_1, 0) + NVL(d.nro_conc_segu_2, 0), " + 
					"NVL(d.mont_segu_1, 0) + NVL(d.mont_segu_2, 0), " +
					"NVL(d.mont_segu_1, 0),  NVL(d.mont_segu_2, 0) " +
					"FROM tiido_campanias_detalle d " +
					"WHERE d.cod_camp = '" + idEsfuerzo + "' and d.anho = '" + codAnho + "' and d.mes = '" + codMes + "' and d.cod_ofic = '" + codOficina + "'";								
					
				log.info("[SesionMetasGestorBean :: reportePGODetEsfuerzos] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null) {
						res = new Vector(0, 1);
					}
					
					bean = new ListaReportePGO();	
					bean.setNomAccion(rst.getString(1));
					bean.setNroCliente(rst.getString(2));
					bean.setCompGestor(rst.getString(3));
					bean.setNroGestSeg2(rst.getString(4));
					bean.setNroConcSeg2(rst.getString(5));
					bean.setMontSeg1_1(rst.getString(6));
					
					desv1 = Integer.parseInt(rst.getString(7))-Integer.parseInt(rst.getString(3));
					bean.setDesv1(String.valueOf(desv1));
					
					desv2 = Integer.parseInt(rst.getString(8))-Integer.parseInt(rst.getString(3));
					bean.setDesv2(String.valueOf(desv2));
					
					res.add(bean);
				}		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: reportePGODetEsfuerzos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMetasGestorBean :: reportePGODetEsfuerzos] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: reportePGODetEsfuerzos] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: reportePGODetEsfuerzos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	
	public Vector findMetGestores(String codEpigrafe, String anho,
			String codOficina, String mes, String estado) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Gestor gestor = null;
		Vector metasGestores = null;
		String sql = "";

		try {
			log.info("[SesionMetasGestorBean :: findMetGestores] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: findMetGestores] Fin");
				
				return null;
			}
			DataSource ds = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: findMetGestores] Fin");
				
				return null;
			}
			st = cn.createStatement();
			
			sql = 	"SELECT cod_gestor, nom_gestor, porc_asig, cod_perfil " +
					"FROM iido.tiido_metas_gestor o " + 
					"WHERE o.cod_epigrafe ='" + codEpigrafe + "' and o.anho ='"+ anho + "' and o.cod_ofic ='" + 
					codOficina + "' " + "and o.mes ='" + mes + "' and estado = '" + estado + "'";
			
			log.info("[SesionMetasGestorBean :: findMetGestores] SQL:" + sql);
			
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (metasGestores == null)
					metasGestores = new Vector(0, 1);
				
				gestor = new Gestor();
				gestor.setCodigoGestor(rs.getString("cod_gestor"));
				gestor.setNombreGestor(rs.getString("nom_gestor"));
				gestor.setCodigoPerfil(rs.getString("cod_perfil"));
				gestor.setPorcAsignado(rs.getBigDecimal("porc_asig"));
				
				metasGestores.add(gestor);
			}			
			
			log.info("[SesionMetasGestorBean :: findMetGestores] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: findMetGestores] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: findMetGestores] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		
		return metasGestores;
	}
	
	public Vector distribuirGOF(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes) {
		Vector listaGestoresEliminadosBD = null;
		BigDecimal acumPorcAsignadoElimGestores = new BigDecimal(0);
		Iterator iterListaGestoresLDAP = null;
		Iterator iterListaGestoresEliminadosBD = null;
		boolean existe = false;
		
		try {
			log.info("[SesionMetasGestorBean :: distribuirGOF] Inicio");
			
			if(codEpigrafe == null || anho == null || codOficina == null || mes == null ) {
				log.info("[SesionMetasGestorBean :: distribuirGOF] Fin");
				
				return new Vector(0, 1);
			}
			
			listaGestoresEliminadosBD = findMetGestores(codEpigrafe, anho, codOficina, mes, "E");
			
			if(listaGestoresLDAP == null || listaGestoresEliminadosBD == null) {
				log.info("[SesionMetasGestorBean :: distribuirGOF] Fin");
				
				return listaGestoresLDAP;
			}
						
			// Gestores nuevos en el LDAP
			iterListaGestoresEliminadosBD = listaGestoresEliminadosBD.iterator();
			while(iterListaGestoresEliminadosBD.hasNext()) {				
				Gestor gestorBD = (Gestor)iterListaGestoresEliminadosBD.next();								
				acumPorcAsignadoElimGestores = acumPorcAsignadoElimGestores.add(gestorBD.getPorcAsignado());
			}
			
			// Asignar el porc asignado acumulado al GOF
			iterListaGestoresLDAP = listaGestoresLDAP.iterator();
			while(iterListaGestoresLDAP.hasNext()) {				
				Gestor gestorLDAP = (Gestor)iterListaGestoresLDAP.next();
				
				if(	gestorLDAP.getCodigoPerfil() != null &&
					gestorLDAP.getCodigoPerfil().equals("GOF")	
					) {
					BigDecimal porcAsignadoGOF = 
							gestorLDAP.getPorcAsignado() != null ?
							gestorLDAP.getPorcAsignado() :
							new BigDecimal(0);
					
					gestorLDAP.setPorcAsignado(porcAsignadoGOF.add(acumPorcAsignadoElimGestores));
					break;
				}
			}
			
			log.info("[SesionMetasGestorBean :: distribuirGOF] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: distribuirGOF] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaGestoresLDAP;
	}
	
	public void actualizarGestoresEliminadosLDAP(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		Vector listaGestoresBD = null;
		BigDecimal acumPorcAsignadoNuevosGestores = new BigDecimal(0);
		Iterator iterListaGestoresLDAP = null;
		Iterator iterListaGestoresBD = null;
		boolean existe = false;
		Vector listaGestoresEliminadosLDAP = null;
		Iterator iterListaGestoresEliminadosLDAP = null;
		
		try {
			log.info("[SesionMetasGestorBean :: actualizarGestoresEliminadosLDAP] Inicio");
			
			if(codEpigrafe == null || anho == null || codOficina == null || mes == null ) {
				log.info("[SesionMetasGestorBean :: actualizarGestoresEliminadosLDAP] Fin");
				
				return;
			}
			
			listaGestoresBD = findMetGestores(codEpigrafe, anho, codOficina, mes, "A");
			
			if(listaGestoresLDAP == null || listaGestoresBD == null) {
				log.info("[SesionMetasGestorBean :: actualizarGestoresEliminadosLDAP] Fin");
				
				return;
			}
						
			// Gestores nuevos en el LDAP
			iterListaGestoresBD = listaGestoresBD.iterator();
			while(iterListaGestoresBD.hasNext()) {				
				Gestor gestorBD = (Gestor)iterListaGestoresBD.next();
				iterListaGestoresLDAP = listaGestoresLDAP.iterator();
				existe = false;
				
				while(iterListaGestoresLDAP.hasNext()) {
					Gestor gestorLDAP = (Gestor)iterListaGestoresLDAP.next();
					String codGestorLDAP = gestorLDAP.getCodigoGestor() != null ? gestorLDAP.getCodigoGestor() : "";
					String codGestorBD = gestorBD.getCodigoGestor() != null ? gestorBD.getCodigoGestor() : "";
					String codPerfilLDAP = gestorLDAP.getCodigoPerfil() != null ? gestorLDAP.getCodigoPerfil() : "";
					String codPerfilBD = gestorBD.getCodigoPerfil() != null ? gestorBD.getCodigoPerfil() : "";
					
					
					if(codGestorLDAP.equals(codGestorBD)) {
						existe = true;
						break;
					}
				}
				
				if(!existe) {
					if(listaGestoresEliminadosLDAP == null) {
						listaGestoresEliminadosLDAP = new Vector(0, 1);
					}
					
					listaGestoresEliminadosLDAP.add(gestorBD.getCodigoGestor());
				}				
			}
			
			// Actualizar el estado a eliminado
			if(listaGestoresEliminadosLDAP != null) {
				iterListaGestoresEliminadosLDAP = listaGestoresEliminadosLDAP.iterator();
				while(iterListaGestoresEliminadosLDAP.hasNext()) {				
					String codGestor = (String)iterListaGestoresEliminadosLDAP.next();
					
					actualizarEstadoMetaGestores(codGestor, "E", usuario);
				}
			}
			
			log.info("[SesionMetasGestorBean :: actualizarGestoresEliminadosLDAP] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: actualizarGestoresEliminadosLDAP] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return;
	}
	
	public void actualizarCargoGestoresLDAP(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		Vector listaGestoresBD = null;
		BigDecimal acumPorcAsignadoNuevosGestores = new BigDecimal(0);
		Iterator iterListaGestoresLDAP = null;
		Iterator iterListaGestoresBD = null;
		boolean existe = false;
		Vector listaGestoresEliminadosLDAP = null;
		Iterator iterListaGestoresEliminadosLDAP = null;
		
		try {
			log.info("[SesionMetasGestorBean :: actualizarCargoGestoresLDAP] Inicio");
			
			if(codEpigrafe == null || anho == null || codOficina == null || mes == null ) {
				log.info("[SesionMetasGestorBean :: actualizarCargoGestoresLDAP] Fin");
				
				return;
			}
			
			listaGestoresBD = findMetGestores(codEpigrafe, anho, codOficina, mes, "A");
			
			if(listaGestoresLDAP == null || listaGestoresBD == null) {
				log.info("[SesionMetasGestorBean :: actualizarCargoGestoresLDAP] Fin");
				
				return;
			}
						
			// Gestores nuevos en el LDAP
			iterListaGestoresBD = listaGestoresBD.iterator();
			while(iterListaGestoresBD.hasNext()) {				
				Gestor gestorBD = (Gestor)iterListaGestoresBD.next();
				iterListaGestoresLDAP = listaGestoresLDAP.iterator();
				existe = false;
				
				while(iterListaGestoresLDAP.hasNext()) {
					Gestor gestorLDAP = (Gestor)iterListaGestoresLDAP.next();
					String codGestorLDAP = gestorLDAP.getCodigoGestor() != null ? gestorLDAP.getCodigoGestor() : "";
					String codGestorBD = gestorBD.getCodigoGestor() != null ? gestorBD.getCodigoGestor() : "";
					String codPerfilLDAP = gestorLDAP.getCodigoPerfil() != null ? gestorLDAP.getCodigoPerfil() : "";
					String codPerfilBD = gestorBD.getCodigoPerfil() != null ? gestorBD.getCodigoPerfil() : "";
					
					
					if(codGestorLDAP.equals(codGestorBD) && !codPerfilLDAP.equals(codPerfilBD)) {
						// Actualizar cargo gestor
						actualizarCargoMetaGestores(codGestorBD, codPerfilLDAP, usuario);
					}
				}								
			}
			
			log.info("[SesionMetasGestorBean :: actualizarCargoGestoresLDAP] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: actualizarCargoGestoresLDAP] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return;
	}
	
	public void actualizarGestoresDistribuidosLDAP(String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		Vector listaGestoresBD = null;
		Iterator iterListaGestoresBD = null;
		
		try {
			log.info("[SesionMetasGestorBean :: actualizarGestoresDistribuidosLDAP] Inicio");
			
			if(codEpigrafe == null || anho == null || codOficina == null || mes == null ) {
				log.info("[SesionMetasGestorBean :: actualizarGestoresDistribuidosLDAP] Fin");
				
				return;
			}
			
			listaGestoresBD = findMetGestores(codEpigrafe, anho, codOficina, mes, "E");
			
			// Actualizar el estado a eliminado
			if(listaGestoresBD != null) {
				iterListaGestoresBD = listaGestoresBD.iterator();
			
				while(iterListaGestoresBD.hasNext()) {				
					Gestor gestor = (Gestor)iterListaGestoresBD.next();;
					String codGestor = gestor.getCodigoGestor(); 
					
					actualizarEstadoMetaGestores(codGestor, "I", usuario);
				}
			}
			
			log.info("[SesionMetasGestorBean :: actualizarGestoresDistribuidosLDAP] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: actualizarGestoresDistribuidosLDAP] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return;
	}
	
	public void actualizarMetaGestoresPlanes(Vector listaEpigrafe, String anho,
			String codOficina, String mes, String codGestorGOF, String usuario) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		String sql = "";
		Iterator iterListaEpigrafe = null;

		try {
			log.info("[SesionMetasGestorBean :: actualizarMetaGestoresPlanes] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: actualizarMetaGestoresPlanes] Fin");
				
				return;
			}
			
			DataSource ds = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: actualizarMetaGestoresPlanes] Fin");
				
				return;
			}
			st = cn.createStatement();
			
			if(listaEpigrafe != null && listaEpigrafe.size() > 0) {
				iterListaEpigrafe = listaEpigrafe.iterator();
				
				while(iterListaEpigrafe.hasNext()) {
					Epigrafe epigrafe = (Epigrafe) iterListaEpigrafe.next();
					
					if(epigrafe.getPorcAsignado().doubleValue() > 0) { 					
						sql = 	"UPDATE tiido_metas_gestor SET porc_asig = " + epigrafe.getPorcAsignado().doubleValue() + " " +
						", usu_actu='" + usuario + "', fec_actu=SYSDATE " + 
						"WHERE cod_epigrafe = '" + epigrafe.getCodEpigrafe() + "' AND anho = '" + anho + "' AND cod_ofic = '" + codOficina + "' " +
						"AND mes = '" + mes + "' AND cod_gestor = '" + codGestorGOF + "' AND porc_asig < " + epigrafe.getPorcAsignado().doubleValue();
						
						log.info("[SesionMetasGestorBean :: actualizarMetaGestoresPlanes] SQL:" + sql);
						st.executeUpdate(sql);
					}
				}
			}  			
			
			log.info("[SesionMetasGestorBean :: actualizarMetaGestoresPlanes] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: actualizarMetaGestoresPlanes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: actualizarMetaGestoresPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return;
			}
		}
	}
	
	public void actualizarEstadoMetaGestores(String codGestor, String estado, String usuario) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		String sql = "";

		try {
			log.info("[SesionMetasGestorBean :: actualizarEstadoMetaGestores] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: actualizarEstadoMetaGestores] Fin");
				
				return;
			}
			
			DataSource ds = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: actualizarEstadoMetaGestores] Fin");
				
				return;
			}
			st = cn.createStatement();
			
			if(codGestor != null) {
				sql = 	"UPDATE tiido_metas_gestor SET estado = '" + estado +"', usu_actu = '" + usuario + "', fec_actu = SYSDATE " + 
						"WHERE cod_gestor = '"  + codGestor + "'";	
				log.info("[SesionMetasGestorBean :: actualizarEstadoMetaGestores] SQL:" + sql);
				st.executeUpdate(sql);
			}  		
			
			log.info("[SesionMetasGestorBean :: actualizarEstadoMetaGestores] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: actualizarEstadoMetaGestores] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: actualizarEstadoMetaGestores] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return;
			}
		}
	}
	
	public void actualizarCargoMetaGestores(String codGestor, String codPerfil, String usuario) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		String sql = "";

		try {
			log.info("[SesionMetasGestorBean :: actualizarCargoMetaGestores] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: actualizarCargoMetaGestores] Fin");
				
				return;
			}
			
			DataSource ds = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: actualizarCargoMetaGestores] Fin");
				
				return;
			}
			st = cn.createStatement();
			
			if(codGestor != null) {
				sql = 	"UPDATE tiido_metas_gestor SET cod_perfil = '" + codPerfil + "', usu_actu='" + 
						usuario + "', fec_actu = SYSDATE " +
						"WHERE cod_gestor = '"  + codGestor + "'";	
				log.info("[SesionMetasGestorBean :: actualizarCargoMetaGestores] SQL:" + sql);
				st.executeUpdate(sql);
			}  			
			
			log.info("[SesionMetasGestorBean :: actualizarCargoMetaGestores] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: actualizarCargoMetaGestores] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: actualizarCargoMetaGestores] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return;
			}
		}
	}
	
	public HashMap buscarResumenMontos(Vector listaEpigrafe, String codTerritorio, String codOficina, String anho,
			String mes) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Iterator iterListaEpigrafe  = null;
		String sql = "";
		HashMap listaEpigraMonto = null;
		String cond = null;
		ResumenObjetivo resumenObjetivo = null;
		BigDecimal montoEliminadosGOF = null;
		HashMap listaEpigraMontoPlanes = null;

		try {
			log.info("[SesionMetasGestorBean :: buscarResumenMontos] Inicio");
			
			initialContext = new InitialContext(); 
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: buscarResumenMontos] Fin");
				
				return null;
			}
			DataSource ds = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: buscarResumenMontos] Fin");
				
				return null;
			}
			st = cn.createStatement();
			
			if(codTerritorio == null) {
				if(codOficina == null) {
					log.info("[SesionMetasGestorBean :: buscarResumenMontos] Fin");
					return null;
				}
				
				cond = "cod_ofic = '"  + codOficina + "' AND ";  
			} else {
				cond = "cod_terr = '"  + codTerritorio + "' AND ";
			}			
			
			
			if(listaEpigrafe != null) {
				listaEpigraMontoPlanes = buscarValorMetasPlanesMontos(listaEpigrafe, codTerritorio, codOficina, anho, mes); 
				
				iterListaEpigrafe = listaEpigrafe.iterator();				 
				listaEpigraMonto = new HashMap();
				
				while(iterListaEpigrafe.hasNext()) {
					String codEpigrafe = (String)iterListaEpigrafe.next(); 
					
					sql = "SELECT NVL(SUM(NVL(porc_asig, 0)), 0) GOF " +					       
					  "FROM tiido_metas_gestor " + 
					  "WHERE " + cond + 				  
					  "mes = '" + mes + "' AND " + 
					  "anho = '" + anho + "' AND " + 
					  "cod_epigrafe = '" + codEpigrafe +  "' AND estado = 'E'";
					
					log.info("[SesionMetasGestorBean :: buscarResumenMontos] SQL" + sql);
					rs = st.executeQuery(sql);
					
					if(rs.next()) {
						montoEliminadosGOF = new BigDecimal(rs.getString("GOF") != null ? rs.getString("GOF") : "0");
					} else {
						montoEliminadosGOF = new BigDecimal(0);
					}					
					
					sql = "SELECT NVL(SUM(DECODE(cod_perfil, 'GOF', NVL(porc_asig, 0), 0)), 0) GOF, " +
					  "NVL(SUM(DECODE(cod_perfil, 'GCO', NVL(porc_asig, 0), 0)), 0) GCO, " + 
					  "NVL(SUM(DECODE(cod_perfil, 'GPE', NVL(porc_asig, 0), 0)), 0) GPE, " +
					  "NVL(SUM(DECODE(cod_perfil, 'GPT', NVL(porc_asig, 0), 0)), 0) GPT " +             
					  "FROM tiido_metas_gestor " + 
					  "WHERE " + cond + 				  
					  "mes = '" + mes + "' AND " + 
					  "anho = '" + anho + "' AND " + 
					  "cod_epigrafe = '" + codEpigrafe +  "' AND estado = 'A'";
					
					log.info("[SesionMetasGestorBean :: buscarResumenMontos] SQL" + sql);
					rs = st.executeQuery(sql);
					
					resumenObjetivo = null;
					if(rs.next()) {
						resumenObjetivo = new ResumenObjetivo();   
						
						resumenObjetivo.setGOF(new BigDecimal(rs.getString("GOF")));
						resumenObjetivo.setGOF(resumenObjetivo.getGOF().add(montoEliminadosGOF));
						
						BigDecimal valorPlanesGOF = (BigDecimal)listaEpigraMontoPlanes.get(codEpigrafe);
						if(valorPlanesGOF != null) {
							resumenObjetivo.setGOF(resumenObjetivo.getGOF().add(valorPlanesGOF));
						}
						
						resumenObjetivo.setGCO(new BigDecimal(rs.getString("GCO")));
						resumenObjetivo.setGPE(new BigDecimal(rs.getString("GPE")));
						resumenObjetivo.setGPT(new BigDecimal(rs.getString("GPT")));
						
						resumenObjetivo.setTotalAsignadoObjetivos(new BigDecimal(0));
						resumenObjetivo.setTotalAsignadoObjetivos(resumenObjetivo.getTotalAsignadoObjetivos().add(resumenObjetivo.getGOF()));
						resumenObjetivo.setTotalAsignadoObjetivos(resumenObjetivo.getTotalAsignadoObjetivos().add(resumenObjetivo.getGCO()));
						resumenObjetivo.setTotalAsignadoObjetivos(resumenObjetivo.getTotalAsignadoObjetivos().add(resumenObjetivo.getGPE()));
						resumenObjetivo.setTotalAsignadoObjetivos(resumenObjetivo.getTotalAsignadoObjetivos().add(resumenObjetivo.getGPT()));
						
						resumenObjetivo.setPorcGOF(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP));						
						resumenObjetivo.setPorcGPE(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP));
						resumenObjetivo.setPorcGCO(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP));
						resumenObjetivo.setPorcGPT(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP));
						
						BigDecimal[] ajuste = new BigDecimal[4];
						if(resumenObjetivo.getTotalAsignadoObjetivos().intValue() != 0) {
							
							resumenObjetivo.setPorcGOF(
									resumenObjetivo.getGOF().divide(resumenObjetivo.getTotalAsignadoObjetivos(), 4,
											BigDecimal.ROUND_HALF_UP).multiply(
											new BigDecimal(100)).setScale(2,
											BigDecimal.ROUND_HALF_UP));
							ajuste[0] = resumenObjetivo.getPorcGOF();
							
							resumenObjetivo.setPorcGPE(
									resumenObjetivo.getGPE().divide(resumenObjetivo.getTotalAsignadoObjetivos(), 4,
											BigDecimal.ROUND_HALF_UP).multiply(
											new BigDecimal(100)).setScale(2,
											BigDecimal.ROUND_HALF_UP));
							ajuste[1] = resumenObjetivo.getPorcGPE();
							
							resumenObjetivo.setPorcGCO(
									resumenObjetivo.getGCO().divide(resumenObjetivo.getTotalAsignadoObjetivos(), 4,
											BigDecimal.ROUND_HALF_UP).multiply(
											new BigDecimal(100)).setScale(2,
											BigDecimal.ROUND_HALF_UP));
							ajuste[2] = resumenObjetivo.getPorcGCO();
							
							resumenObjetivo.setPorcGPT(
									resumenObjetivo.getGPT().divide(resumenObjetivo.getTotalAsignadoObjetivos(), 4,
											BigDecimal.ROUND_HALF_UP).multiply(
											new BigDecimal(100)).setScale(2,
											BigDecimal.ROUND_HALF_UP));
							ajuste[3] = resumenObjetivo.getPorcGPT();
							
							int i = 0;
							int j = 0;
							double a = 0;
							for(i = 0; i < ajuste.length; i++){
								a += ajuste[i].doubleValue();
								if(ajuste[i].compareTo(BigDecimal.ZERO) == 1){
									j = i;
								}
							}
							
							ajuste[j] = ajuste[j].add(new BigDecimal(100 - a).setScale(2, BigDecimal.ROUND_HALF_UP));
							
							if(j == 0) {
								resumenObjetivo.setPorcGOF(ajuste[j]);
							}else if(j == 1) {
								resumenObjetivo.setPorcGPE(ajuste[j]);
							}else if(j == 2) {
								resumenObjetivo.setPorcGCO(ajuste[j]);
							}else {
								resumenObjetivo.setPorcGPT(ajuste[j]);
							}
							
						}
					}
					
					listaEpigraMonto.put(codEpigrafe, resumenObjetivo);
				}
			}
			
			log.info("[SesionMetasGestorBean :: buscarResumenMontos] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: buscarResumenMontos] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: buscarResumenMontos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		
		return listaEpigraMonto;
	}
	
	public HashMap buscarValorMetasPlanesMontos(Vector listaEpigrafe, String codTerritorio, String codOficina, String anho,
			String mes) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Iterator iterListaEpigrafe  = null;
		String sql = "";
		Vector listaOficina = new Vector(0, 1);
		Iterator iterListaOficina  = null;
		Vector listaSesionOficina = null;
		Iterator iterListaSesionOficina  = null;
		SesionOficina aSesionOficina = null;
		BigDecimal montoAcumulado = null;
		
		HashMap listaEpigraMonto = null;
		ResumenObjetivo resumenObjetivo = null;
		BigDecimal montoEliminadosGOF = null;

		try {
			log.info("[SesionMetasGestorBean :: buscarValorMetasPlanesMontos] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: buscarValorMetasPlanesMontos] Fin");
				
				return null;
			}
			
			DataSource ds = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: buscarValorMetasPlanesMontos] Fin");
				
				return null;
			}
			st = cn.createStatement();
			
			// Establecer lista de oficinas
			if(codTerritorio == null) {
				if(codOficina == null) {
					log.info("[SesionMetasGestorBean :: buscarValorMetasPlanesMontos] Fin");
					
					return null;
				}
				
				listaOficina.add(codOficina); 
			} else {
				aSesionOficina = createSesionOficina();
				listaSesionOficina = aSesionOficina.findAllOficinaByCodTerri(codTerritorio);
				
				if(listaSesionOficina != null) {
					iterListaSesionOficina = listaSesionOficina.iterator();
					while(iterListaSesionOficina.hasNext()) {
						Oficina ofi = (Oficina)iterListaSesionOficina.next();
						
						if(ofi != null) {
							listaOficina.add(ofi.getCodOfic());
						}
					}
				}
			}			
			
			
			if(listaEpigrafe != null) {
				iterListaEpigrafe = listaEpigrafe.iterator();				 
				listaEpigraMonto = new HashMap();
				
				while(iterListaEpigrafe.hasNext()) {
					String codEpigrafe = (String)iterListaEpigrafe.next(); 
					montoAcumulado = new BigDecimal(0);
					
					if(listaOficina != null) {
						iterListaOficina = listaOficina.iterator();
						
						while(iterListaOficina.hasNext()) {
							String codOfi = (String)iterListaOficina.next();
							BigDecimal tempMonto = new BigDecimal(0);
							
							sql = 	"SELECT SUM(NVL(porc_asig, 0)) " +              
								 	"FROM tiido_metas_gestor " +
									"WHERE 	cod_ofic = '" + codOfi + "' AND " +
											"mes = '" + mes + "' AND " +
											"anho = '" + anho + "' AND " +											
											"cod_epigrafe = '" + codEpigrafe + "' AND estado = 'A' AND cod_perfil = 'GOF'";
							
							log.info("[SesionMetasGestorBean :: buscarValorMetasPlanesMontos] SQL:" + sql);
							rs = st.executeQuery(sql);
							
							if(rs.next()) {
								tempMonto = new BigDecimal(rs.getString(1) != null ? rs.getString(1) : "0");
							}  				
							
							if(tempMonto.doubleValue() == 0.0) {
								BigDecimal tempMontoPlanes = new BigDecimal(0);
								sql = "SELECT NVL(fact_asig_gte_of, 0) " + 
									  "FROM tiido_planes " +  
									  "WHERE mes_plan = '" + mes + "' AND anho_plan = '" + anho + "' AND " +
									  		"cod_ofic = '" + codOfi + "' AND cod_epigrafe = '" + codEpigrafe + "'"; 	
									
								log.info("[SesionMetasGestorBean :: buscarValorMetasPlanesMontos] SQL:" + sql);
								rs = st.executeQuery(sql);
								
								if(rs.next()) {
									tempMontoPlanes = new BigDecimal(rs.getString(1) != null ? rs.getString(1) : "0");
								}
								
								montoAcumulado = montoAcumulado.add(tempMontoPlanes);
							}
						}
						listaEpigraMonto.put(codEpigrafe, montoAcumulado);
					}
				}
			}
			
			log.info("[SesionMetasGestorBean :: buscarValorMetasPlanesMontos] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: buscarValorMetasPlanesMontos] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: buscarValorMetasPlanesMontos] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		
		return listaEpigraMonto;
	}
	
	public BigDecimal buscarMontoGestor(String codGestor, String codEpigrafe, String anho,
			String codOficina, String mes) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "";
		BigDecimal monto = new BigDecimal(0);

		try {
			log.info("[SesionMetasGestorBean :: buscarMontoGestor] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: buscarMontoGestor] Fin");
				
				return monto;
			}
			
			DataSource ds = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: buscarMontoGestor] Fin");
				
				return monto;
			}
			st = cn.createStatement();
			
			sql = 	"SELECT porc_asig " +
					"FROM iido.tiido_metas_gestor " + 
					"WHERE cod_gestor ='" + codGestor + "' and cod_epigrafe ='" + codEpigrafe + "' and anho ='"+ anho + "' and cod_ofic ='" + 
					codOficina + "' " + "and mes ='" + mes + "'";
			
			log.info("[SesionMetasGestorBean :: buscarMontoGestor] SQL:" + sql);
			
			rs = st.executeQuery(sql);
			if(rs.next()) {				
				monto = new BigDecimal(rs.getString("porc_asig") != null ? rs.getString("porc_asig") : "0");				
			}			
			
			log.info("[SesionMetasGestorBean :: buscarMontoGestor] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: buscarMontoGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return monto;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: buscarMontoGestor] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return monto;
			}
		}
		
		return monto;
	}
	
	public void eliminarMetaGestoresHijas(Vector listaGestores) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		String sql = "";
		Iterator iterListaGestores = null;

		try {
			log.info("[SesionMetasGestorBean :: eliminarMetaGestoresHijas] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: eliminarMetaGestoresHijas] Fin");
				
				return;
			}
			
			DataSource ds = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: eliminarMetaGestoresHijas] Fin");
				
				return;
			}
			st = cn.createStatement();
			
			if(listaGestores != null && listaGestores.size() > 0) {
				iterListaGestores = listaGestores.iterator();
				
				while(iterListaGestores.hasNext()) {
					String codGestor = (String) iterListaGestores.next();
					
					sql = "UPDATE tiido_metas_gestor SET estado = 'E' WHERE cod_gestor = '"  + codGestor + "' AND estado != 'I'";
					
					log.info("[SesionMetasGestorBean :: eliminarMetaGestoresHijas] SQL:" + sql);
					
					st.executeUpdate(sql);
				}
			}
			
			log.info("[SesionMetasGestorBean :: eliminarMetaGestoresHijas] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: eliminarMetaGestoresHijas] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: eliminarMetaGestoresHijas] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return;
			}
		}
	}
	
	public BigDecimal promedioMensual(String anho, String mes, String codOfi, String codTerr, String codEpi, String codGestor) {
		InitialContext initialContext = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "";
		BigDecimal monto = new BigDecimal(0);

		try {
			log.info("[SesionMetasGestorBean :: promedioMensual] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionMetasGestorBean :: promedioMensual] Fin");
				
				return monto;
			}
			
			DataSource ds = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionMetasGestorBean :: promedioMensual] Fin");
				
				return monto;
			}
			st = cn.createStatement();
			
			// Revisar Filtro Fecha
			sql = "SELECT COD_GESTOR, ROUND(SUM(TOTAL)/SUM(OPERACIONES), 2) PROM ";
			sql += "FROM VIIDO_MIS ";
			sql += "WHERE COD_EPI='" + codEpi + "' ";
			// sql += "AND COD_TERRITORIO='" + codTerr + "'";
			sql += "AND COD_OFICINA='" + codOfi + "'";
			sql += "AND COD_GESTOR='" + codGestor + "'";
			// sql += "AND (TO_NUMBER(MES)>=(TO_NUMBER(TO_CHAR(SYSDATE, 'MM')) - 6) and TO_NUMBER(MES)<TO_NUMBER(TO_CHAR(SYSDATE, 'MM'))) ";
			sql += "AND TO_DATE('01-' || MES || '-' || ANHO, 'dd-MM-yyyy') >= ADD_MONTHS(TO_DATE('01-" + mes + "-" + anho + "', 'dd-MM-yyyy'), -6) ";
			sql += "AND TO_DATE('01-' || MES || '-' || ANHO, 'dd-MM-yyyy') < TO_DATE('01-" + mes + "-" + anho + "', 'dd-MM-yyyy') ";
			// sql += "AND ANHO='" + anho + "' ";
			sql += "GROUP BY COD_GESTOR";
			
			log.info("[SesionMetasGestorBean :: promedioMensual] SQL:" + sql);
			
			rs = st.executeQuery(sql);
			if(rs.next()) {				
				monto = new BigDecimal(rs.getString("PROM") != null ? rs.getString("PROM") : "0");
				// monto.setScale(0, BigDecimal.ROUND_HALF_DOWN);
			}
			log.info("Gestor: " + codGestor);
			log.info("Promedio: " + monto);
			log.info("[SesionMetasGestorBean :: promedioMensual] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: promedioMensual] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return monto;
		} finally {
			try {
				if (initialContext != null)
					initialContext.close();
				if (cn != null)
					cn.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.error("[SesionIngresosBean :: promedioMensual] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return monto;
			}
		}
		
		return monto;
	}
}
