package com.grupobbva.bc.per.tele.sdo.sesion;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_multitablaKey;
import entities.Tiido_multitablaLocal;
import entities.Tiido_multitablaLocalHome;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionMultitabla
 */
public class SesionMultitablaBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionMultitablaBean.class);
	
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiido_multitablaLocalHome_REF_NAME = "ejb/Tiido_multitabla";

	private final static Class STATIC_Tiido_multitablaLocalHome_CLASS = Tiido_multitablaLocalHome.class;
	
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

	public Multitabla findByID(String id) {
		Multitabla multi = new Multitabla();
		
		try {
			log.info("[SesionMultitablaBean :: findByID] Inicio");
			
			Tiido_multitablaLocal aTiido_multitablaLocal = find_Tiido_multitablaLocalHome_findByID(id);
			if (aTiido_multitablaLocal != null) {
				multi.setCodelem(aTiido_multitablaLocal.getCod_elem());
				multi.setCodMult(aTiido_multitablaLocal.getCod_mult());
				multi.setValor1(aTiido_multitablaLocal.getValor1());
				multi.setValor2(aTiido_multitablaLocal.getValor2());
				multi.setValor3(aTiido_multitablaLocal.getValor3());
				multi.setValor4(aTiido_multitablaLocal.getValor4());
			}
			
			log.info("[SesionMultitablaBean :: findByID] Fin");
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: findByID] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return multi;
	}

	public Multitabla findMultiByPrimaryKey(String codMulti, String codElem) {
		Multitabla multi = new Multitabla();
		
		try {
			log.info("[SesionMultitablaBean :: findMultiByPrimaryKey] Inicio");
			
			Tiido_multitablaLocal aTiido_multitablaLocal = find_Tiido_multitablaLocalHome_findMultiByPrimaryKey(
					codMulti, codElem);
			if (aTiido_multitablaLocal != null) {
				multi.setCodelem(aTiido_multitablaLocal.getCod_elem());
				multi.setCodMult(aTiido_multitablaLocal.getCod_mult());
				multi.setValor1(aTiido_multitablaLocal.getValor1());
				multi.setValor2(aTiido_multitablaLocal.getValor2());
				multi.setValor3(aTiido_multitablaLocal.getValor3());
				multi.setValor4(aTiido_multitablaLocal.getValor4());
			}
			
			log.info("[SesionMultitablaBean :: findMultiByPrimaryKey] Fin");
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: findMultiByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return multi;
	}

	public Multitabla findByID(String codMulti, String codElem) {
		Multitabla multi = new Multitabla();
		
		try {
			log.info("[SesionMultitablaBean :: findByID] Inicio");
			
			Tiido_multitablaLocal aTiido_multitablaLocal = find_Tiido_multitablaLocalHome_findMultiByPrimaryKey(
					codMulti, codElem);
			if (aTiido_multitablaLocal != null) {
				multi.setCodelem(aTiido_multitablaLocal.getCod_elem());
				multi.setCodMult(aTiido_multitablaLocal.getCod_mult());
				multi.setValor1(aTiido_multitablaLocal.getValor1());
				multi.setValor2(aTiido_multitablaLocal.getValor2());
				multi.setValor3(aTiido_multitablaLocal.getValor3());
				multi.setValor4(aTiido_multitablaLocal.getValor4());
			}
			
			log.info("[SesionMultitablaBean :: findByID] Fin");
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: findByID] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return multi;
	}

	public Vector findByCodMulti(String codMulti) {

		Vector records = new Vector();
		Iterator multiIterator = null;
		Tiido_multitablaLocalHome multiLocalHome = null;
		Collection aCollection = null;
		
		try {
			log.info("[SesionMultitablaBean :: findByCodMulti] Inicio");
			
			aCollection = find_Tiido_multitablaLocalHome_findByCodMulti(codMulti);
			multiIterator = aCollection.iterator();
			while (multiIterator.hasNext()) {
				Tiido_multitablaLocal multiLocal = (Tiido_multitablaLocal) multiIterator
						.next();
				if (!(multiLocal.getCod_elem().equals("0000"))) {
					Multitabla multi = new Multitabla();
					multi.setCodelem(multiLocal.getCod_elem());
					multi.setCodMult(multiLocal.getCod_mult());
					multi.setValor1(multiLocal.getValor1());
					multi.setValor2(multiLocal.getValor2());
					multi.setValor3(multiLocal.getValor3());
					multi.setValor4(multiLocal.getValor4());
					records.add(multi);
				}
			}
			
			log.info("[SesionMultitablaBean :: findByCodMulti] Fin");
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: findByCodMulti] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return records;
	}

	public Vector findByMultiForPresup(String codMulti, String Valor2) {

		Vector records = new Vector();
		Iterator multiIterator = null;
		Tiido_multitablaLocalHome multiLocalHome = null;
		String valorBusqueda = "%" + Valor2 + "%";
		
		try {
			log.info("[SesionMultitablaBean :: findByMultiForPresup] Inicio");
			
			Collection aCollection = find_Tiido_multitablaLocalHome_findByMultiForPresup(
					codMulti, valorBusqueda);
			multiIterator = aCollection.iterator();
			while (multiIterator.hasNext()) {
				Tiido_multitablaLocal multiLocal = (Tiido_multitablaLocal) multiIterator
						.next();
				Multitabla multi = new Multitabla();
				multi.setCodelem(multiLocal.getCod_elem());
				multi.setCodMult(multiLocal.getCod_mult());
				multi.setValor1(multiLocal.getValor1());
				multi.setValor2(multiLocal.getValor2());
				multi.setValor3(multiLocal.getValor3());
				multi.setValor4(multiLocal.getValor4());
				records.add(multi);
			}
			
			log.info("[SesionMultitablaBean :: findByMultiForPresup] Fin");
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: findByMultiForPresup] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return records;
	}

	public boolean updateMultitabla(Multitabla multi) {
		try {
			log.info("[SesionMultitablaBean :: updateMultitabla] Inicio");
			
			Tiido_multitablaLocal aTiido_multitablaLocal = find_Tiido_multitablaLocalHome_findByPrimaryKey(new Tiido_multitablaKey(
					multi.getCodelem(), multi.getCodMult()));
			if (aTiido_multitablaLocal != null) {
				aTiido_multitablaLocal.setValor1(multi.getValor1());
				aTiido_multitablaLocal.setValor2(multi.getValor2());
				aTiido_multitablaLocal.setValor3(multi.getValor3());
				aTiido_multitablaLocal.setValor4(multi.getValor4());
				return true;
			}
			
			log.info("[SesionMultitablaBean :: updateMultitabla] Fin");
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: updateMultitabla] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public boolean updateElemMultitabla(Multitabla multi){
		Context initialContext =null;
		Statement st =null;
		Connection conn =null;
		String sql="";
		
		try{
			log.info("[SesionMultitablaBean :: updateElemMultitabla] Inicio");
			
			initialContext =new InitialContext();
			if(initialContext==null) return false;
			DataSource datasource =(DataSource)initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if(datasource!=null){
				conn =datasource.getConnection();
			}else{
				initialContext=null;
				
				log.info("[SesionMultitablaBean :: updateElemMultitabla] Fin");
				return false;
			}
			
			st =conn.createStatement();
			try{
				sql="update iido.tiido_multitabla set cod_elem ='"+ multi.getCodelem() +"', valor1 ='"+ multi.getValor1() +"' where cod_mult='"+ multi.getCodMult()+"'";
				
				log.error("[SesionMultitablaBean :: updateElemMultitabla] SQL: " + sql);
				
				st.execute(sql);
			}catch(Exception e){
				log.error("[SesionMultitablaBean :: updateElemMultitabla] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
			
			log.info("[SesionMultitablaBean :: updateElemMultitabla] Fin");
		}catch(Exception e){
			log.error("[SesionMultitablaBean :: updateElemMultitabla] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return false;
		} finally{
			try{
				if(st!=null) st.close();
				if(conn!=null) conn.close();
				if(initialContext!=null) initialContext.close();
			}catch(Exception e){
				log.error("[SesionMultitablaBean :: updateElemMultitabla] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}
		
		return true;
	}
	
	public int obtenerPrimerMesPresup() {
		Vector listPresup = null;
		int valor = 99;
		Multitabla multi = null;

		try {
			log.info("[SesionMultitablaBean :: obtenerPrimerMesPresup] Inicio");
			
			listPresup = findByMultiForPresup("T03", "13");

			if (listPresup != null && listPresup.size() > 0) {
				if (listPresup.get(0) != null) {
					multi = (Multitabla) listPresup.get(0);
					valor = Integer.parseInt(multi.getCodelem());
				} else {
					log.error("[SesionMultitablaBean :: obtenerPrimerMesPresup] No se encontro el valor en la tabla MultiTabla");
				}
			} else {
				log.error("[SesionMultitablaBean :: obtenerPrimerMesPresup] No se encontro el valor en la tabla MultiTabla");
			}
			
			log.info("[SesionMultitablaBean :: obtenerPrimerMesPresup] No se encontro el valor en la tabla MultiTabla");
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: obtenerPrimerMesPresup] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return valor;
	}

	public ProgSeguimiento obtenerProgramacionSeguimientoDefault(String mes,
			String anio) {
		Vector listPresup = null;
		ProgSeguimiento progSeguimiento = null;
		Multitabla multi = null;
		String seg1Ini = null;
		String seg1Dias = null;
		String seg2Ini = null;
		String seg2Dias = null;
		Calendar fecha = null;

		try {
			log.info("[SesionMultitablaBean :: obtenerProgramacionSeguimientoDefault] Inicio");
			
			progSeguimiento = new ProgSeguimiento();
			listPresup = findByCodMulti("T13");

			if (listPresup != null && listPresup.size() > 0) {
				if (listPresup.get(0) != null) {
					multi = (Multitabla) listPresup.get(0);

					// Recibiendo y validando valores
					seg1Ini = multi.getValor1();
					if (seg1Ini != null) {
						Integer.parseInt(seg1Ini);
					}

					seg1Dias = multi.getValor2();
					if (seg1Dias != null) {
						Integer.parseInt(seg1Dias);
					}

					seg2Ini = multi.getValor3();
					if (seg2Ini != null) {
						Integer.parseInt(seg2Ini);
					}

					seg2Dias = multi.getValor4();
					if (seg2Dias != null) {
						Integer.parseInt(seg2Dias);
					}

					// Formando las fechas
					fecha = GregorianCalendar.getInstance();

					fecha.set(Integer.parseInt(anio),
							Integer.parseInt(mes) - 1, Integer
									.parseInt(seg1Ini), 0, 0, 0);
					progSeguimiento.setSeg1Ini(ConstantesUtil
							.parseCalendarToString(fecha));
					if (progSeguimiento.getSeg1Ini() == null) {
						throw new Exception("Fecha no es valida");
					}

					fecha.add(Calendar.DATE, Integer.parseInt(seg1Dias));
					progSeguimiento.setSeg1Fin(ConstantesUtil
							.parseCalendarToString(fecha));
					if (progSeguimiento.getSeg1Fin() == null) {
						throw new Exception("Fecha no es valida");
					}

					fecha.set(Integer.parseInt(anio), Integer.parseInt(mes) - 1,
							Integer.parseInt(seg2Ini), 0, 0, 0);
					progSeguimiento.setSeg2Ini(ConstantesUtil
							.parseCalendarToString(fecha));
					if (progSeguimiento.getSeg2Ini() == null) {
						throw new Exception("Fecha no es valida");
					}

					fecha.add(Calendar.DATE, Integer.parseInt(seg2Dias));
					progSeguimiento.setSeg2Fin(ConstantesUtil
							.parseCalendarToString(fecha));
					if (progSeguimiento.getSeg2Fin() == null) {
						throw new Exception("Fecha no es valida");
					}
				} else {
					log.error("[SesionMultitablaBean :: obtenerProgramacionSeguimientoDefault] " + 
							"No se encontro el valor en la tabla MultiTabla para programaci" + (char) 243 + "n de seguimiento");
				}
			} else {
				log.error("[SesionMultitablaBean :: obtenerProgramacionSeguimientoDefault] " + 
				"No se encontro el valor en la tabla MultiTabla para programaci" + (char) 243 + "n de seguimiento");
			}
			
			log.info("[SesionMultitablaBean :: obtenerProgramacionSeguimientoDefault] Fin");
		} catch (Exception e) {
			progSeguimiento = null;
			
			log.error("[SesionMultitablaBean :: obtenerProgramacionSeguimientoDefault] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return progSeguimiento;
	}

	protected Tiido_multitablaLocal find_Tiido_multitablaLocalHome_findByID(
			String id) {
		try {
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByID] Inicio");
			
			Tiido_multitablaLocalHome aTiido_multitablaLocalHome = (Tiido_multitablaLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_multitablaLocalHome_REF_NAME,
					STATIC_Tiido_multitablaLocalHome_CLASS);
			 
			if (aTiido_multitablaLocalHome != null) {
				log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByID] Fin");
				
				return aTiido_multitablaLocalHome.findByID(id);
			}
			
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByID] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByID] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Collection find_Tiido_multitablaLocalHome_findByCodMulti(
			String codMulti) {
		
		try {
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByCodMulti] Inicio");
			
			Tiido_multitablaLocalHome aTiido_multitablaLocalHome = (Tiido_multitablaLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_multitablaLocalHome_REF_NAME,
					STATIC_Tiido_multitablaLocalHome_CLASS);
			
			if (aTiido_multitablaLocalHome != null) {
				log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByCodMulti] Fin");
				
				return aTiido_multitablaLocalHome.findByCodMulti(codMulti);
			}
			
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByCodMulti] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByCodMulti] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Tiido_multitablaLocal find_Tiido_multitablaLocalHome_findByPrimaryKey(
			Tiido_multitablaKey primaryKey) {
		
		try {
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_multitablaLocalHome aTiido_multitablaLocalHome = (Tiido_multitablaLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_multitablaLocalHome_REF_NAME,
					STATIC_Tiido_multitablaLocalHome_CLASS);
			
			if (aTiido_multitablaLocalHome != null) {
				log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_multitablaLocalHome.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Tiido_multitablaLocal find_Tiido_multitablaLocalHome_findMultiByPrimaryKey(
			String codMulti, String codElem) {
		try {
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findMultiByPrimaryKey] Inicio");
			
			Tiido_multitablaLocalHome aTiido_multitablaLocalHome = (Tiido_multitablaLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_multitablaLocalHome_REF_NAME,
					STATIC_Tiido_multitablaLocalHome_CLASS);
			
			if (aTiido_multitablaLocalHome != null) {
				log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findMultiByPrimaryKey] Fin");
				
				return aTiido_multitablaLocalHome.findMultiByPrimaryKey(
						codMulti, codElem);
			}
			
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findMultiByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findMultiByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Collection find_Tiido_multitablaLocalHome_findByMultiForPresup(
			String codMulti, String Valor2) {
		
		try {
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByMultiForPresup] Inicio");
			
			Tiido_multitablaLocalHome aTiido_multitablaLocalHome = (Tiido_multitablaLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_multitablaLocalHome_REF_NAME,
					STATIC_Tiido_multitablaLocalHome_CLASS);
			
			if (aTiido_multitablaLocalHome != null) {
				log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByMultiForPresup] Fin");
				
				return aTiido_multitablaLocalHome.findByMultiForPresup(
						codMulti, Valor2);
			}
			
			log.info("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByMultiForPresup] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMultitablaBean :: find_Tiido_multitablaLocalHome_findByMultiForPresup] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
}