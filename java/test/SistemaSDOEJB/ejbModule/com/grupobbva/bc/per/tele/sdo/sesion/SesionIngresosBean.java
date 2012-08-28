package com.grupobbva.bc.per.tele.sdo.sesion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.serializable.Ingresos;
import com.grupobbva.bc.per.tele.sdo.serializable.ReporteIngreso;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"unused", "unchecked", "serial", "null"})
public class SesionIngresosBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionIngresosBean.class);
	
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
	
	public Vector busAllIngreso(String anho, String mes) {
		Vector res = null;
		Ingresos bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			log.info("[SesionIngresosBean :: busAllIngreso] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busAllIngreso] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busAllIngreso] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busAllIngreso] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, fecha as Fecha FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anho+"' And to_char(FECHA, 'mm') = '"+mes+"' GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, fecha, objetivos, acciones, seguimiento1, seguimiento2";
											
					
				log.info("[SesionIngresosBean :: busAllIngreso] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Ingresos();
					
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));
					bean.setUsuario(rst.getString(3));
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					bean.setFecha(rst.getString(7));
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busAllIngreso] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionIngresosBean :: busAllIngreso] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busAllIngreso] ");
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
				e.printStackTrace();
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR INGRESOS
	
	//OSCAR CORTEZ - NUEVO INGRESO
	
	public int nuevoIngreso(String id_ingresos, String codUsuario, String cargo, String nomTerritorio, 
			String codOficina, String nombres) {
		Vector res = null;
		Ingresos bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		int ultimo = 0;

		try {
			log.info("[SesionIngresosBean :: nuevoIngreso] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: nuevoIngreso] Fin");
				
				return 0;
			}			
			
			log.info("[SesionIngresosBean :: nuevoIngreso] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: nuevoIngreso] Fin");
				
				return 0;
			}

			s = con.createStatement();
			try {
				nombres = nombres != null ? nombres.toUpperCase() : "";
				
				String sql =
					
				"INSERT INTO TIIDO_INGRESOS (ID_INGRESOS, VECES, VALIDO_VECES, COD_USUARIO, CARGO, NOM_TERRITORIO, " +
				"COD_OFICINA, NOMBRES) VALUES ('"+id_ingresos+"', '1', '1', '"+codUsuario+"', '"+cargo+"', '"+
				nomTerritorio+"', '"+codOficina+"', '" + nombres + "')";
											
				log.info("[SesionIngresosBean :: nuevoIngreso] SQL:" + sql);
				s.executeUpdate(sql);		
				
				ultimo = busID_IngresoMax();		
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			log.info("[SesionIngresosBean :: nuevoIngreso] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: nuevoIngreso] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
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
				log.error("[SesionIngresosBean :: nuevoIngreso] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return 0;
			}
		}			
		
		return ultimo;	
	}
	
	public void actualizarIngreso(int tipo, int idIngreso, String mes, String anio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		String sql = null;
		String columna = null;
		ResultSet rst = null;
		int idIngresoDetalle = 0;

		try {
			log.info("[SesionIngresosBean :: actualizarIngreso] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: actualizarIngreso] Fin");
				
				return;
			}			
			
			log.info("[SesionIngresosBean :: actualizarIngreso] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: actualizarIngreso] Fin");
				
				return;
			}

			s = con.createStatement();
			try {
				sql = "SELECT MAX(id) FROM iido.tiido_ingresos_detalle";	
					
				log.info("[SesionIngresosBean :: actualizarIngreso] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				if(rst.next()) {
					idIngresoDetalle = rst.getInt(1) + 1; 
				} else {
					idIngresoDetalle = 1;
				}
				
				switch(tipo) {
					case 1: columna = "objetivos"; break;
					case 2: columna = "acciones"; break;
					case 3: columna = "seg1"; break;
					case 4: columna = "seg2"; break;
					case 5: columna = "planes"; break;
				}
				
				sql = 	"INSERT INTO iido.tiido_ingresos_detalle (id, mes, anio, " + columna + ", id_ingresos) " + 
						"VALUES(" + idIngresoDetalle +  ", '" + mes + "', '" + anio + "', 1, " + idIngreso + ")";
												
				log.info("[SesionIngresosBean :: actualizarIngreso] SQL:" + sql);
				s.executeUpdate(sql);
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: actualizarIngreso] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionIngresosBean :: actualizarIngreso] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: actualizarIngreso] ");
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
				log.error("[SesionIngresosBean :: actualizarIngreso] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		}			
	}
	
	//	FIN - OSCAR CORTEZ - NUEVO INGRESO
	
	//OSCAR CORTEZ - BUSCAR DEL DIA
	public Vector busIngresoxDIA(String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		String cond = "";
		
		try {
			log.info("[SesionIngresosBean :: busIngresoxDIA] Inicio");
			
			Calendar calendario= Calendar.getInstance();
			
			int diaA=calendario.get(Calendar.DAY_OF_MONTH);
			int mesA=calendario.get(Calendar.MONTH)+1;
			int anhoA=calendario.get(Calendar.YEAR);
			
			String cMesA = String.valueOf(mesA);
			String cDiaA = String.valueOf(diaA);
			
			if (mesA < 10) {
				cMesA = "0"+cMesA;
			}
			
			if (diaA < 10) {
				cDiaA = "0"+cDiaA;
			}
			
			if(codTerritorioUsuario != null) {
				cond = "AND cod_oficina IN (SELECT cod_ofic FROM iido.Tiido_Oficina WHERE cod_terr = '" + codTerritorioUsuario + "')";
			}
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxDIA] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxDIA] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxDIA] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					//"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, fecha as Fecha FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anhoA+"' And to_char(FECHA, 'mm') = '"+cMesA+"' And to_char(FECHA, 'dd') = '"+cDiaA+"' GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, fecha";
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, " +
					"nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha, SUM(objetivos) objetivos, SUM(acciones) acciones, SUM(seguimiento1) seguimiento1, SUM(seguimiento2) seguimiento2 " +
					"FROM tiido_ingresos " +
					"WHERE to_char(FECHA, 'yyyy') = '"+anhoA+"' And to_char(FECHA, 'mm') = '"+cMesA+"' And " +
							"to_char(FECHA, 'dd') = '"+cDiaA+"' " + cond + 
					"GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY')";	
					
				log.info("[SesionIngresosBean :: busIngresoxDIA] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Ingresos();
					
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));
					bean.setUsuario(rst.getString(3));
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					bean.setFecha(rst.getString(7));
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));
					
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busIngresoxDIA] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}		
			
			log.info("[SesionIngresosBean :: busIngresoxDIA] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxDIA] ");
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
				log.error("[SesionIngresosBean :: busIngresoxDIA] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR INGRESOS DEL DIA
	
	//OSCAR CORTEZ - BUSCAR x USUARIO x MES
	public Vector busIngresoxUSUARIOxMes(String mes, String codTerritorioUsuario) {
		Vector res = null;
		Ingresos bean = null;
		boolean existenReg = false;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String cond = "";

		try {
			log.info("[SesionIngresosBean :: busIngresoxUSUARIOxMes] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxUSUARIOxMes] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxUSUARIOxMes] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxUSUARIOxMes] Fin");
				
				return null;
			}
			
            //Ursula 
			s = con.createStatement();
			
			try {
				if(codTerritorioUsuario != null) {
					cond = " AND cod_oficina IN (SELECT cod_ofic FROM iido.Tiido_Oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
				}
				
				String sql =
					//"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha FROM tiido_ingresos where to_char(FECHA, 'mm') = '"+mes+"' GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina";
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, " +
					"nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha, SUM(objetivos) objetivos, SUM(acciones) acciones, SUM(seguimiento1) seguimiento1, SUM(seguimiento2) seguimiento2 " +
					"FROM tiido_ingresos where to_char(FECHA, 'mm') = '"+mes+"' " +
					cond + 
					"GROUP BY valido_veces, cod_usuario, nom_territorio, cod_oficina, cargo, " +
					"TO_CHAR(fecha, 'DD/MM/YYYY')  order by cod_usuario, fecha, valido_veces, VECES,cod_oficina";
				
					
				log.info("[SesionIngresosBean :: busIngresoxUSUARIOxMes] SQL:" + sql);
				rst = s.executeQuery(sql);				
				//String codUsuario=null;
				String codOficina=null;
				int totalVeces=0;
				int totalVeces_Valido=0;
				int totalGenVeces=0;
				int totalGenVeces_Valido=0;
				
				while (rst.next()) {
					existenReg = true;
					
					if (res == null)
						res = new Vector(0, 1);
					
					if(res.size()>0){
						if(!codOficina.equals(rst.getString(6))){
							bean = new Ingresos();
							bean.setContVeces(totalVeces);
							bean.setContvalidoVeces(totalVeces_Valido);
							res.add(bean);
							totalVeces=0;
							totalVeces_Valido=0;
							
							//codOficina = null;
							//break;
						}
					}
					bean = new Ingresos();
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));											
					bean.setUsuario(rst.getString(3));
					//codUsuario=rst.getString(3);
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					codOficina=rst.getString(6);
					bean.setFecha(rst.getString(7));
					
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));
					
					totalVeces=totalVeces+rst.getInt(1);
					totalVeces_Valido=totalVeces_Valido+rst.getInt(2);
					totalGenVeces=totalGenVeces+rst.getInt(1);
					totalGenVeces_Valido=totalGenVeces_Valido+rst.getInt(2);				
					
					
					res.add(bean);
				}
				
				// Para el ultimo
				if(existenReg) {	
					bean = new Ingresos();
					bean.setContVeces(totalVeces);
					bean.setContvalidoVeces(totalVeces_Valido);
					res.add(bean);				
				}
					
				// Suma Total
				bean.setContVeces(totalVeces);
				bean.setContvalidoVeces(totalVeces_Valido);
				bean = new Ingresos();
				
				bean.setContGenVeces(totalGenVeces);
				bean.setContGenvalidoVeces(totalGenVeces_Valido);
				
				res.add(bean);
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busIngresoxUSUARIOxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionIngresosBean :: busIngresoxUSUARIOxMes] Fin");
		} catch (Exception e) {	
			log.error("[SesionIngresosBean :: busIngresoxUSUARIOxMes] ");
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
				log.error("[SesionIngresosBean :: busIngresoxUSUARIOxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR x USUARIO x MES
	
//	OSCAR CORTEZ - BUSCAR x USUARIO x AÑO
	public Vector busIngresoxUSUARIOxAnho(String anho, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		boolean existenReg = false;
		String cond = "";

		try {
			log.info("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				if(codTerritorioUsuario != null) {
					cond = " AND cod_oficina IN (SELECT cod_ofic FROM iido.Tiido_Oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
				}
				
				String sql =
					//"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anho+"' GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina";
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, " +
					"nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'MM/YYYY') as Fecha , SUM(objetivos) objetivos, SUM(acciones) acciones, SUM(seguimiento1) seguimiento1, SUM(seguimiento2) seguimiento2 " +
					"FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anho+"' " +
					cond + 
					"GROUP BY valido_veces, cod_usuario, nom_territorio, cod_oficina, cargo,  TO_CHAR(fecha, 'MM/YYYY') order by cod_oficina asc,  nom_territorio asc, fecha asc  , VECES ";
				
				log.info("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] SQL:" + sql);
				rst = s.executeQuery(sql);				
				//String codUsuario=null;
				String codOficina=null;
				String codUsuario=null;
				String codRegistro=null;
				String fecha=null;
				int totalVeces=0;
				int totalVeces_Valido=0;
				int totalGenVeces=0;
				int totalGenVeces_Valido=0;
				
				while (rst.next()) {
					existenReg = true;
					
					if (res == null)
						res = new Vector(0, 1);
					
					if(res.size()>0){
						 if(!codOficina.equals(rst.getString(6))){
							bean = new Ingresos();
							bean.setContVeces(totalVeces);
							bean.setContvalidoVeces(totalVeces_Valido);
							res.add(bean);
							totalVeces=0;
							totalVeces_Valido=0;
							
						}
						 /*if(codOficina.equals(rst.getString(6))){
						   	   if(codRegistro.equals(rst.getString(3))){
						   	       if(fecha.equals(rst.getString(7))){
						   	        bean = new Ingresos();
									bean.setContVeces(totalVeces);
									bean.setContvalidoVeces(totalVeces_Valido);
									res.add(bean);
									totalVeces=totalVeces+rst.getInt(1);
									totalVeces_Valido=totalVeces_Valido+rst.getInt(2);
									totalGenVeces=totalGenVeces+rst.getInt(1);
									totalGenVeces_Valido=totalGenVeces_Valido+rst.getInt(2);
						   	       	
						   	       }
						   	   }
						   } 
						 */
					}
					bean = new Ingresos();
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));											
					bean.setUsuario(rst.getString(3));
					//codUsuario=rst.getString(6);
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					codOficina=rst.getString(6);
					bean.setFecha(rst.getString(7));	
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));
					
					totalVeces=totalVeces+rst.getInt(1);
					totalVeces_Valido=totalVeces_Valido+rst.getInt(2);
					totalGenVeces=totalGenVeces+rst.getInt(1);
					totalGenVeces_Valido=totalGenVeces_Valido+rst.getInt(2);				
					
					res.add(bean);
				}
				
				// Para el ultimo
				if(existenReg) {
					bean = new Ingresos();
					bean.setContVeces(totalVeces);
					bean.setContvalidoVeces(totalVeces_Valido);
					res.add(bean);				
				}
					
				// Para el resumen
				bean.setContVeces(totalVeces);
				bean.setContvalidoVeces(totalVeces_Valido);
				bean = new Ingresos();
				
				bean.setContGenVeces(totalGenVeces);
				bean.setContGenvalidoVeces(totalGenVeces_Valido);
				
				res.add(bean);
				
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}	
			
			log.info("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] ");
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
				log.error("[SesionIngresosBean :: busIngresoxUSUARIOxAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR x USUARIO x AÑO
	
	
	//OSCAR CORTEZ - BUSCAR x OFICINA x MES
	public Vector busIngresoxOFICINAxMes(String mes, String codOficina, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		boolean existenReg = false;
		String cond = "";

		try {
			log.info("[SesionIngresosBean :: busIngresoxOFICINAxMes] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxOFICINAxMes] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxOFICINAxMes] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxOFICINAxMes] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				if(codTerritorioUsuario != null) {
					cond = " AND cod_oficina IN (SELECT cod_ofic FROM iido.Tiido_Oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
				}
				
				String sql =
					//"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha FROM tiido_ingresos where to_char(FECHA, 'mm') = '"+mes+"'  GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina";
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, " +
					"nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha, SUM(objetivos) objetivos, SUM(acciones) acciones, SUM(seguimiento1) seguimiento1, SUM(seguimiento2) seguimiento2 " +
					"FROM tiido_ingresos where to_char(FECHA, 'mm') = '"+mes+"'  " +
					cond + 
					"GROUP BY valido_veces,cod_oficina, cod_usuario, cargo, nom_territorio,  TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina asc, VECES asc";
											
				log.info("[SesionIngresosBean :: busIngresoxOFICINAxMes] SQL:" + sql);
				rst = s.executeQuery(sql);				
				String codUsuario=null;
				
				int totalVeces=0;
				int totalVeces_Valido=0;
				int totalGenVeces=0;
				int totalGenVeces_Valido=0;
				
				while (rst.next()) {
					existenReg = true;
					
					if (res == null)
						res = new Vector(0, 1);
					
					if(res.size()>0){
					        if(!codUsuario.equals(rst.getString(6))){
							bean = new Ingresos();
							bean.setContVeces(totalVeces);
							bean.setContvalidoVeces(totalVeces_Valido);
							res.add(bean);
							totalVeces=0;
							totalVeces_Valido=0;
							
						}
					}
					bean = new Ingresos();
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));											
					bean.setUsuario(rst.getString(3));
					//codUsuario=rst.getString(3);
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					codUsuario=rst.getString(6);
					bean.setFecha(rst.getString(7));		
					
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));
					
					totalVeces=totalVeces+rst.getInt(1);
					totalVeces_Valido=totalVeces_Valido+rst.getInt(2);
					totalGenVeces=totalGenVeces+rst.getInt(1);
					totalGenVeces_Valido=totalGenVeces_Valido+rst.getInt(2);				
					
					
					res.add(bean);
				}
				
				// Para el ultimo
				if(existenReg) {				
					bean = new Ingresos();
					bean.setContVeces(totalVeces);
					bean.setContvalidoVeces(totalVeces_Valido);
					res.add(bean);
				}

				// Para el resumen				
				bean.setContVeces(totalVeces);
				bean.setContvalidoVeces(totalVeces_Valido);
				bean = new Ingresos();
				
				bean.setContGenVeces(totalGenVeces);
				bean.setContGenvalidoVeces(totalGenVeces_Valido);
				
				res.add(bean);
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busIngresoxOFICINAxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxOFICINAxMes] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxOFICINAxMes] ");
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
				log.error("[SesionIngresosBean :: busIngresoxOFICINAxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR x OFICINA x MES
	
//	OSCAR CORTEZ - BUSCAR x OFICINA x AÑO
	public Vector busIngresoxOFICINAxAnho(String anho, String codOficina, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		boolean existenReg = false;
		String cond = "";

		try {
			log.info("[SesionIngresosBean :: busIngresoxOFICINAxAnho] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxOFICINAxAnho] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: busIngresoxOFICINAxAnho] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxOFICINAxAnho] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				if(codTerritorioUsuario != null) {
					cond = " AND cod_oficina IN (SELECT cod_ofic FROM iido.Tiido_Oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
				}
				
				String sql =
					//"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anho+"'  GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina";
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, " +
					"nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'MM/YYYY') as Fecha, SUM(objetivos) objetivos, SUM(acciones) acciones, SUM(seguimiento1) seguimiento1, SUM(seguimiento2) seguimiento2 " +
					"FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anho+"'  " +
					cond + 
					"GROUP BY valido_veces, cod_oficina, nom_territorio ,cargo,  TO_CHAR(fecha, 'MM/YYYY'), cod_usuario order by cod_oficina asc, VECES asc, fecha asc";
					
				log.info("[SesionIngresosBean :: busIngresoxOFICINAxAnho] SQL:"+ sql);
				rst = s.executeQuery(sql);				
				String codUsuario=null;
				String codRegistro=null;
				String fecha=null;
				
				int totalVeces=0;
				int totalVeces_Valido=0;
				int totalGenVeces=0;
				int totalGenVeces_Valido=0;
				
				while (rst.next()) {
					existenReg = true;
					
					if (res == null)
						res = new Vector(0, 1);
					
					if(res.size()>0){
					   if(!codUsuario.equals(rst.getString(6))){	
							bean = new Ingresos();
							bean.setContVeces(totalVeces);
							bean.setContvalidoVeces(totalVeces_Valido);
							res.add(bean);
							totalVeces=0;
							totalVeces_Valido=0;
							
						}
					   if(codUsuario.equals(rst.getString(6))){
					   	   if(codRegistro.equals(rst.getString(3))){
					   	       if(fecha.equals(rst.getString(7))){
					   	        bean = new Ingresos();
								bean.setContVeces(totalVeces);
								bean.setContvalidoVeces(totalVeces_Valido);
								res.add(bean);
								//totalVeces=0;
								//totalVeces_Valido=0;
					   	       	
					   	       }
					   	   }
					   }
					}
					bean = new Ingresos();
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));											
					bean.setUsuario(rst.getString(3));
					//codUsuario=rst.getString(3);
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					codUsuario=rst.getString(6);
					bean.setFecha(rst.getString(7));
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));

					
					totalVeces=totalVeces+rst.getInt(1);
					totalVeces_Valido=totalVeces_Valido+rst.getInt(2);
					totalGenVeces=totalGenVeces+rst.getInt(1);
					totalGenVeces_Valido=totalGenVeces_Valido+rst.getInt(2);				
					
					
					res.add(bean);
				}
				
				//	Para el ultimo
				if(existenReg) {					
					bean = new Ingresos();
					bean.setContVeces(totalVeces);
					bean.setContvalidoVeces(totalVeces_Valido);
					res.add(bean);
				}

				// Para el resumen							
				bean.setContVeces(totalVeces);
				bean.setContvalidoVeces(totalVeces_Valido);
				
				bean = new Ingresos();
				bean.setContGenVeces(totalGenVeces);
				bean.setContGenvalidoVeces(totalGenVeces_Valido);
				
				res.add(bean);
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busIngresoxOFICINAxAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionIngresosBean :: busIngresoxOFICINAxAnho] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxOFICINAxAnho] ");
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
				log.error("[SesionIngresosBean :: busIngresoxOFICINAxAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR x OFICINA x AÑO
	
	
//	OSCAR CORTEZ - BUSCAR x TERRITORIO x MES
	public Vector busIngresoxTERRITORIOxMes(String mes, String nomTerritorio, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		boolean existenReg = false;
		String cond = "";
		
		try {
			log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] Fin");
				
				return null;
			}	
			
			log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				if(codTerritorioUsuario != null) {
					cond = " AND cod_oficina IN (SELECT cod_ofic FROM iido.Tiido_Oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
				}
				
				String sql =
					//"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha FROM tiido_ingresos where to_char(FECHA, 'mm') = '"+mes+"' GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina";
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, " +
					"nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha, SUM(objetivos) objetivos, SUM(acciones) acciones, SUM(seguimiento1) seguimiento1, SUM(seguimiento2) seguimiento2 " +
					"FROM tiido_ingresos where to_char(FECHA, 'mm') = '"+mes+"' " +
					cond + 
					"GROUP BY valido_veces, nom_territorio, cod_usuario, cargo, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina, nom_territorio, VECES asc";
					
				log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				String codUsuario=null;
				int totalVeces=0;
				int totalVeces_Valido=0;
				int totalGenVeces=0;
				int totalGenVeces_Valido=0;
				
				while (rst.next()) {
					existenReg = true;
					
					if (res == null)
						res = new Vector(0, 1);
					
					if(res.size()>0){
						
					    if(!codUsuario.equals(rst.getString(6))){
							bean = new Ingresos();
							bean.setContVeces(totalVeces);
							bean.setContvalidoVeces(totalVeces_Valido);
							res.add(bean);
							totalVeces=0;
							totalVeces_Valido=0;
						}
					}
					
					bean = new Ingresos();
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));											
					bean.setUsuario(rst.getString(3));
					//codUsuario=rst.getString(3);
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					codUsuario=rst.getString(6);
					bean.setFecha(rst.getString(7));		
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));
					
					totalVeces=totalVeces+rst.getInt(1);
					totalVeces_Valido=totalVeces_Valido+rst.getInt(2);
					totalGenVeces=totalGenVeces+rst.getInt(1);
					totalGenVeces_Valido=totalGenVeces_Valido+rst.getInt(2);				
					
					
					res.add(bean);
				}
				//bean.setContVeces(totalVeces);
				//bean.setContvalidoVeces(totalVeces_Valido);
				
				// Para el ultimo
				if(existenReg) {
					bean = new Ingresos();
					bean.setContVeces(totalVeces);
					bean.setContvalidoVeces(totalVeces_Valido);
					res.add(bean);
				}

				// Para el resumen		
				bean.setContVeces(totalVeces);
				bean.setContvalidoVeces(totalVeces_Valido);
				
				bean = new Ingresos();
				bean.setContGenVeces(totalGenVeces);
				bean.setContGenvalidoVeces(totalGenVeces_Valido);
				
				res.add(bean);
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] ");
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
				log.error("[SesionIngresosBean :: busIngresoxTERRITORIOxMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR x TERRITORIO x MES
	
	// OSCAR CORTEZ - BUSCAR x TERRITORIO x AÑO
	public Vector busIngresoxTERRITORIOxAnho(String anho, String nomTerritorio, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		boolean existenReg = false;
		String cond = "";
		
		try {
			log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] ConstantesUtil.DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				if(codTerritorioUsuario != null) {
					cond = " AND cod_oficina IN (SELECT cod_ofic FROM iido.Tiido_Oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
				}
				
				String sql =
					//"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'DD/MM/YYYY') as Fecha FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anho+"' GROUP BY valido_veces, cod_usuario, cargo, nom_territorio, cod_oficina, TO_CHAR(fecha, 'DD/MM/YYYY') order by cod_oficina";
					"SELECT COUNT(VECES) as VECES, valido_veces, cod_usuario as Usuario,cargo as Cargo, " +
					"nom_territorio as Territorio, cod_oficina as Oficina, TO_CHAR(fecha, 'MM/YYYY') as Fecha, SUM(objetivos) objetivos, SUM(acciones) acciones, SUM(seguimiento1) seguimiento1, SUM(seguimiento2) seguimiento2 " +
					" FROM tiido_ingresos where to_char(FECHA, 'yyyy') = '"+anho+"' " +
					cond +
					" GROUP BY valido_veces, nom_territorio,  TO_CHAR(fecha, 'MM/YYYY'), cod_usuario, cargo, cod_oficina order by  nom_territorio, cod_oficina asc, fecha asc";
					
				log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				String codUsuario=null;
				int totalVeces=0;
				int totalVeces_Valido=0;
				int totalGenVeces=0;
				int totalGenVeces_Valido=0;
				
				while (rst.next()) {
					existenReg = true;
					
					if (res == null)
						res = new Vector(0, 1);
					
					if(res.size()>0){
					if(!codUsuario.equals(rst.getString(6))){	
							bean = new Ingresos();
							bean.setContVeces(totalVeces);
							bean.setContvalidoVeces(totalVeces_Valido);
							res.add(bean);
							totalVeces=0;
							totalVeces_Valido=0;
							
						}
					}
					bean = new Ingresos();
					bean.setVeces(rst.getString(1));
					bean.setValido_veces(rst.getString(2));											
					bean.setUsuario(rst.getString(3));
					//codUsuario=rst.getString(3);
					bean.setCargo(rst.getString(4));
					bean.setNomTerritorio(rst.getString(5));
					bean.setCod_oficina(rst.getString(6));
					codUsuario=rst.getString(6);
					bean.setFecha(rst.getString(7));		
					bean.setObjetivos(rst.getInt(8));
					bean.setAcciones(rst.getInt(9));
					bean.setSeguimiento1(rst.getInt(10));
					bean.setSeguimiento2(rst.getInt(11));
					
					totalVeces=totalVeces+rst.getInt(1);
					totalVeces_Valido=totalVeces_Valido+rst.getInt(2);
					totalGenVeces=totalGenVeces+rst.getInt(1);
					totalGenVeces_Valido=totalGenVeces_Valido+rst.getInt(2);				
					
					
					res.add(bean);
				}
				//bean.setContVeces(totalVeces);
				//bean.setContvalidoVeces(totalVeces_Valido);				
				
				// Para el ultimo
				if(existenReg) {
					bean = new Ingresos();
					bean.setContVeces(totalVeces);
					bean.setContvalidoVeces(totalVeces_Valido);
					res.add(bean);
				}

				// Para el resumen				
				bean.setContVeces(totalVeces);
				bean.setContvalidoVeces(totalVeces_Valido);
				
				bean = new Ingresos();				
				bean.setContGenVeces(totalGenVeces);
				bean.setContGenvalidoVeces(totalGenVeces_Valido);
				
				res.add(bean);
		
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] ");
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
				log.error("[SesionIngresosBean :: busIngresoxTERRITORIOxAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	//	FIN - OSCAR CORTEZ - BUSCAR x TERRITORIO x AÑO

	
	public int busID_IngresoMax() {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int idIngreso = 0;

		try {
			log.info("[SesionIngresosBean :: busID_IngresoMax] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busID_IngresoMax] Fin");
				
				return 0;
			}	
			
			log.info("[SesionIngresosBean :: busID_IngresoMax] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busID_IngresoMax] Fin");
				
				return 0;
			}

			s = con.createStatement();
			
			try {
				String sql =
					
					"select max(id_ingresos) from tiido_ingresos";			
					
				log.info("[SesionIngresosBean :: busID_IngresoMax] SQL:" + sql);
				rst = s.executeQuery(sql);				
						
				while (rst.next()) {
					idIngreso= rst.getInt(1);	
				}
				
			} catch (SQLException e) {
				log.error("[SesionIngresosBean :: busID_IngresoMax] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionIngresosBean :: busID_IngresoMax] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busID_IngresoMax] ");
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
				log.error("[SesionIngresosBean :: busID_IngresoMax] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);	

				return 0;
			}
		}			
		
		return idIngreso;		
		
	}
	
	public Vector busIngresoxUsuario(String anho, String mes, String dia, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		Ingresos beanDet = null;
		String sql = null;
		String where = null;
		String order = null;
		ArrayList usuario = null;
		HashMap listaUsuarioSimple = null;
		HashMap listaUsuarioGrupo = null;
		HashMap tempValorIngreso = null;
		int valoresTempIngreso[] = null; 
		Iterator itUsuario = null;
		Iterator itListaUsuario = null;
		ArrayList listListaUsuario = null;
		HashSet listEliminarUsuario = null;
		
		try {
			log.info("[SesionIngresosBean :: busIngresoxUsuario] Inicio");
			
			usuario = busUsuarios(anho, mes, dia, codTerritorioUsuario, 1);
			if(usuario == null) {
				log.info("[SesionIngresosBean :: busIngresoxUsuario] Fin");
				
				return null;
			}
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxUsuario] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
		
		try {
			initialContext = new InitialContext();
			
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxUsuario] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxUsuario] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxUsuario] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			
			where = "WHERE to_char(FECHA, 'yyyy') LIKE '%" + (anho != null ? anho : "") + 
			"%' AND to_char(FECHA, 'mm') LIKE '%" + (mes != null ? mes : "") + "%' " + 
			"AND to_char(FECHA, 'dd') LIKE '%" + (dia != null ? dia : "") + "%' ";
			
			if(codTerritorioUsuario != null) {
				where += "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
			}			
			 
			order = "ORDER BY usuario, fecha";
			
			sql = "SELECT cod_usuario usuario, TO_CHAR(fecha, 'YYYYMMDD') fecha, COUNT(*) ingresos " +        
				  "FROM tiido_ingresos " +
				  where +
				  "GROUP BY cod_usuario, to_char(fecha, 'YYYYMMDD') " +
				  order;
				
			log.info("[SesionIngresosBean :: busIngresoxUsuario] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaUsuarioSimple = new HashMap();			
			while (rst.next()) {
				bean = new Ingresos();
				
				bean.setUsuario(rst.getString("usuario"));
				bean.setNombreUsuario(" ");
				bean.setCargo(" ");
				bean.setNomTerritorio(" ");
				bean.setCod_oficina(" ");
				bean.setNom_oficina(" ");				
				bean.setFecha(ConstantesUtil.formatearFechaString2(rst.getString("fecha")));
				bean.setMes("");
				bean.setAnio("");
				bean.setTotalIngreso(rst.getInt("ingresos"));
				bean.setPlanificacion(0);
				bean.setObjetivos(0);
				bean.setAcciones(0);
				bean.setSeguimiento1(0);
				bean.setSeguimiento2(0);
				bean.setTotal(0);
				
				if(listaUsuarioSimple.containsKey(bean.getUsuario())) {
					ArrayList lista = (ArrayList)listaUsuarioSimple.get(bean.getUsuario());
					
					lista.add(bean);					
				} else {
					ArrayList lista = new ArrayList();
					lista.add(bean);
					
					listaUsuarioSimple.put(bean.getUsuario(), lista);
				}
			}
			
			sql = "SELECT NVL(cod_usuario, '*') usuario, TO_CHAR(i.fecha, 'YYYYMMDD') fecha, NVL(d.mes, 0) mes, NVL(d.anio, '0') anio, " +
				  //"       COUNT(mes) total_ingreso, NVL(SUM(planes), 0) planes, NVL(SUM(objetivos), 0) objetivos, " +
				  "       NVL(SUM(planes), 0) planes, NVL(SUM(objetivos), 0) objetivos, " +
		       	  "		  NVL(SUM(acciones), 0) acciones,NVL(SUM(seg1), 0) seg1, NVL(SUM(seg2), 0) seg2 " +
				  "FROM tiido_ingresos i " + 
				  "INNER JOIN tiido_ingresos_detalle d ON (i.id_ingresos = d.id_ingresos) " +
				  where + 
				  "GROUP BY ROLLUP(cod_usuario, anio, mes, TO_CHAR(i.fecha, 'YYYYMMDD')) ";
				
			log.info("[SesionIngresosBean :: busIngresoxUsuario] SQL:" + sql);
			rst = s.executeQuery(sql);				
			listaUsuarioGrupo = new HashMap();
			
			while (rst.next()) {
				bean = new Ingresos();
				
				bean.setUsuario(rst.getString("usuario"));
				bean.setNombreUsuario(" ");
				bean.setCargo(" ");
				bean.setNomTerritorio(" ");
				bean.setCod_oficina(" ");
				bean.setNom_oficina(" ");				
				bean.setFecha(ConstantesUtil.formatearFechaString2(rst.getString("fecha")));
				bean.setMes(new ConstantesUtil().litMes(rst.getInt("mes")));
				bean.setAnio(rst.getString("anio").equals("0") ? "" : rst.getString("anio"));
				//bean.setTotalIngreso(rst.getInt("total_ingreso"));
				bean.setPlanificacion(rst.getInt("planes"));
				bean.setObjetivos(rst.getInt("objetivos"));
				bean.setAcciones(rst.getInt("acciones"));
				bean.setSeguimiento1(rst.getInt("seg1"));
				bean.setSeguimiento2(rst.getInt("seg2"));
				bean.setTotal(	bean.getPlanificacion() + 
								bean.getObjetivos() +
								bean.getAcciones() +
								bean.getSeguimiento1() +
								bean.getSeguimiento2());
				
				if(listaUsuarioGrupo.containsKey(bean.getUsuario())) {
					ArrayList lista = (ArrayList)listaUsuarioGrupo.get(bean.getUsuario());
					
					lista.add(bean);					
				} else {
					ArrayList lista = new ArrayList();
					lista.add(bean);	
					listaUsuarioGrupo.put(bean.getUsuario(), lista);
				}
			}
			
			// Etiqueta mes o anio
			String lblMesAnio = "";
			if(mes == null) {
				lblMesAnio += (anho != null ? anho : "");
			} else {
				lblMesAnio += (mes != null ? new ConstantesUtil().litMes(Integer.parseInt(mes)) : "");
			}
			
			itUsuario = usuario.iterator();      
			res = new Vector(0, 1);
			int sumaTotalIngresos = 0;
			int sumaGeneralTotalIngresos = 0;
			listEliminarUsuario = new HashSet();
			while (itUsuario.hasNext()) {
				bean = (Ingresos)itUsuario.next();
			
				// Cabecera
				res.add(bean);				
				sumaTotalIngresos = 0;
				
				// Seccion simple
				listListaUsuario = (ArrayList)listaUsuarioSimple.get(bean.getUsuario());
				itListaUsuario = listListaUsuario.iterator();
				tempValorIngreso = new HashMap();			
				while (itListaUsuario.hasNext()) {
					beanDet = (Ingresos)itListaUsuario.next();
					sumaTotalIngresos += beanDet.getTotalIngreso(); 
					beanDet.setUsuario(" ");
					beanDet.setTipo(1);
					res.add(beanDet);
					
					valoresTempIngreso = new int[2];
					valoresTempIngreso[0] = res.size() - 1;					
					valoresTempIngreso[1] = beanDet.getTotalIngreso();
					tempValorIngreso.put(beanDet.getFecha(), valoresTempIngreso);
				}				
				
				sumaGeneralTotalIngresos += sumaTotalIngresos;
				
				// Seccion con grupo
				listListaUsuario = (ArrayList)listaUsuarioGrupo.get(bean.getUsuario());
				if(listListaUsuario != null) {
					itListaUsuario = listListaUsuario.iterator();
					String anios = "";
					int avance = 0;
					while (itListaUsuario.hasNext()) {
						beanDet = (Ingresos)itListaUsuario.next();						
						
						beanDet.setTipo(1);
						beanDet.setUsuario(" ");

						if(beanDet.getFecha() == null || beanDet.getFecha().equals("") ) {
							if(beanDet.getAnio() != null && beanDet.getAnio().equals("")) {
								if(!anios.equals("")) {
									anios = anios.substring(0, anios.length() - 1); 
								}		
								
								beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
								
								beanDet.setMes("Total");
								beanDet.setAnio(anios);
								beanDet.setTipo(3);
							} else {
								if(beanDet.getMes().equals("")) {
									anios += beanDet.getAnio() + "-";
									beanDet.setMes("Total");
									beanDet.setAnio(beanDet.getAnio());									
									beanDet.setTipo(2);
								} else {
									beanDet.setMes("Total " + beanDet.getMes());
									beanDet.setTipo(2);
								}
							}
						}
						
						if(tempValorIngreso.containsKey(beanDet.getFecha())) {
							int valores[] = (int[])tempValorIngreso.get(beanDet.getFecha()); 
							
							listEliminarUsuario.add(new Integer(valores[0]));
							beanDet.setTotalIngreso(valores[1]);
						}
						
						// Para dos fechas iguales y blanquear total ingreso
						if(avance > 1) { 
							for(int i = 1; i <= avance; i++) {
								Ingresos beanFec = (Ingresos)res.get(res.size() - i);
								
								if((beanDet.getFecha() != null && !beanDet.getFecha().equals("")) &&
								   (beanDet.getTotalIngreso() != 0))
								{
									if((beanFec.getFecha().equals(beanDet.getFecha())) && 
									   (beanFec.getTotalIngreso() == beanDet.getTotalIngreso())) {
										//beanFec.setFecha("");	
										beanFec.setTotalIngreso(0);
										break;
									}
								}
							}
						}
						
						res.add(beanDet);
						avance++;
			        }
					
					if(res != null && res.size() > 1) {
						Ingresos beanAntePenultimo = (Ingresos)res.get(res.size() - 2);
						Ingresos beanUltimo = (Ingresos)res.get(res.size() - 1);
						
						if( beanAntePenultimo != null &&
							beanUltimo != null &&
							beanAntePenultimo.getAnio().equals(beanUltimo.getAnio())
						  ) {
							listEliminarUsuario.add(new Integer(res.size() - 2));
						}
					}
					
					// acumula el valor de ingreso total de la seccion simple
					if(res != null && res.size() > 1) {
						beanDet = (Ingresos)res.get(res.size() - 1);
						
						if(beanDet != null) {
							beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaTotalIngresos);
						}
						
						/*beanDet = (Ingresos)res.get(res.size() - 2);
						
						if(beanDet != null) {
							beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaTotalIngresos);
						}*/
					}
				} else {
					beanDet = new Ingresos();
					
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					beanDet.setFecha("");
					beanDet.setMes("Total");
					beanDet.setAnio(anho);
					beanDet.setTotalIngreso(sumaTotalIngresos);
					beanDet.setPlanificacion(0);
					beanDet.setObjetivos(0);
					beanDet.setAcciones(0);
					beanDet.setSeguimiento1(0);
					beanDet.setSeguimiento2(0);
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
					
					beanDet.setTipo(3);
					res.add(beanDet);
				}
	        }
			
			// Valor de Resumen
			listListaUsuario = (ArrayList)listaUsuarioGrupo.get("*");
			if(listListaUsuario != null) {
				beanDet = (Ingresos)listListaUsuario.get(0);
				
				if(res != null) {
					beanDet.setUsuario(" ");
					beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaGeneralTotalIngresos);
					beanDet.setTipo(3);
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
					beanDet.setMes("Total");
					beanDet.setAnio("General");
					
					res.add(beanDet);
				}
			} else {
				if(res != null) {
					beanDet = new Ingresos();
					
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					
					
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
					
					beanDet.setFecha("");
					beanDet.setTotalIngreso(sumaGeneralTotalIngresos);
					beanDet.setPlanificacion(0);
					beanDet.setObjetivos(0);
					beanDet.setAcciones(0);
					beanDet.setSeguimiento1(0);
					beanDet.setSeguimiento2(0);
					
					beanDet.setTipo(3);
					beanDet.setMes("Total");
					beanDet.setAnio("General");
					
					res.add(beanDet);
				}
			}
			
			if(res != null && res.size() > 0) {
				ArrayList lista = new ArrayList();
				Iterator iter = listEliminarUsuario.iterator();
				while(iter.hasNext()) {
					Integer valor = (Integer)iter.next();
					lista.add(valor);
				}
				Collections.sort(lista);
				
				iter = lista.iterator();
				int cont = 0; 
				while(iter.hasNext()) {
					Integer valor = (Integer)iter.next();
					res.remove(valor.intValue() - cont);
					cont++;
				}
			}
			
			log.info("[SesionIngresosBean :: busIngresoxUsuario] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxUsuario] ");
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
				log.error("[SesionIngresosBean :: busIngresoxUsuario] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	public Vector busIngresoxOficina(String anho, String mes, String dia, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		Ingresos beanDet = null;
		String sql = null;
		String where = null;
		String order = null;
		ArrayList usuario = null;
		HashMap listaUsuarioSimple = null;
		HashMap listaUsuarioGrupo = null;
		HashMap tempValorIngreso = null;
		int valoresTempIngreso[] = null; 
		Iterator itUsuario = null;
		Iterator itListaUsuario = null;
		ArrayList listListaUsuario = null;
		String codOficinaAntiguo = null;
		String codOficinaNuevo = null;
		Ingresos totalOficina = null;
		HashSet listEliminarUsuario = null;
		
		try {
			log.info("[SesionIngresosBean :: busIngresoxOficina] Inicio");
			
			usuario = busUsuarios(anho, mes, dia, codTerritorioUsuario, 2);
			if(usuario == null) {
				log.info("[SesionIngresosBean :: busIngresoxOficina] Fin");
				
				return null;
			}
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
		
		try {
			initialContext = new InitialContext();
			
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxOficina] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxOficina] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxOficina] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			
			where = "WHERE to_char(FECHA, 'yyyy') LIKE '%" + (anho != null ? anho : "") + 
			"%' AND to_char(FECHA, 'mm') LIKE '%" + (mes != null ? mes : "") + "%' " + 
			"AND to_char(FECHA, 'dd') LIKE '%" + (dia != null ? dia : "") + "%' ";
			
			if(codTerritorioUsuario != null) {
				where += "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
			}			
			 
			order = "ORDER BY usuario, fecha";
			
			sql = "SELECT cod_usuario usuario, TO_CHAR(fecha, 'YYYYMMDD') fecha, COUNT(*) ingresos " +        
				  "FROM tiido_ingresos " +
				  where +
				  "GROUP BY cod_usuario, to_char(fecha, 'YYYYMMDD') " +
				  order;
				
			log.info("[SesionIngresosBean :: busIngresoxOficina] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaUsuarioSimple = new HashMap();
			while (rst.next()) {
				bean = new Ingresos();
				
				bean.setUsuario(rst.getString("usuario"));
				bean.setNombreUsuario(" ");
				bean.setCargo(" ");
				bean.setNomTerritorio(" ");
				bean.setCod_oficina(" ");
				bean.setNom_oficina(" ");				
				bean.setFecha(ConstantesUtil.formatearFechaString2(rst.getString("fecha")));
				bean.setMes("");
				bean.setAnio("");
				bean.setTotalIngreso(rst.getInt("ingresos"));
				bean.setPlanificacion(0);
				bean.setObjetivos(0);
				bean.setAcciones(0);
				bean.setSeguimiento1(0);
				bean.setSeguimiento2(0);
				bean.setTotal(0);
				
				if(listaUsuarioSimple.containsKey(bean.getUsuario())) {
					ArrayList lista = (ArrayList)listaUsuarioSimple.get(bean.getUsuario());
					
					
					lista.add(bean);					
				} else {
					ArrayList lista = new ArrayList();
					lista.add(bean);
					listaUsuarioSimple.put(bean.getUsuario(), lista);
				}
			}
			
			sql = "SELECT NVL(cod_usuario, '*') usuario, TO_CHAR(i.fecha, 'YYYYMMDD') fecha, NVL(d.mes, 0) mes, NVL(d.anio, '0') anio, " +
				  "       NVL(SUM(planes), 0) planes, NVL(SUM(objetivos), 0) objetivos, " +
		       	  "		  NVL(SUM(acciones), 0) acciones,NVL(SUM(seg1), 0) seg1, NVL(SUM(seg2), 0) seg2 " +
				  "FROM tiido_ingresos i " + 
				  "INNER JOIN tiido_ingresos_detalle d ON (i.id_ingresos = d.id_ingresos) " +
				  where + 
				  "GROUP BY ROLLUP(cod_usuario, anio, mes, TO_CHAR(i.fecha, 'YYYYMMDD')) ";
				
			log.info("[SesionIngresosBean :: busIngresoxOficina] SQL:" + sql);
			rst = s.executeQuery(sql);				
			listaUsuarioGrupo = new HashMap();
			
			while (rst.next()) {
				bean = new Ingresos();
				
				bean.setUsuario(rst.getString("usuario"));
				bean.setNombreUsuario(" ");
				bean.setCargo(" ");
				bean.setNomTerritorio(" ");
				bean.setCod_oficina(" ");
				bean.setNom_oficina(" ");				
				bean.setFecha(ConstantesUtil.formatearFechaString2(rst.getString("fecha")));
				bean.setMes(new ConstantesUtil().litMes(rst.getInt("mes")));
				bean.setAnio(rst.getString("anio").equals("0") ? "" : rst.getString("anio"));
				//bean.setTotalIngreso(rst.getInt("total_ingreso"));
				bean.setPlanificacion(rst.getInt("planes"));
				bean.setObjetivos(rst.getInt("objetivos"));
				bean.setAcciones(rst.getInt("acciones"));
				bean.setSeguimiento1(rst.getInt("seg1"));
				bean.setSeguimiento2(rst.getInt("seg2"));
				bean.setTotal(	bean.getPlanificacion() + 
								bean.getObjetivos() +
								bean.getAcciones() +
								bean.getSeguimiento1() +
								bean.getSeguimiento2());
				
				if(listaUsuarioGrupo.containsKey(bean.getUsuario())) {
					ArrayList lista = (ArrayList)listaUsuarioGrupo.get(bean.getUsuario());
					
					lista.add(bean);					
				} else {
					ArrayList lista = new ArrayList();
					lista.add(bean);	
					listaUsuarioGrupo.put(bean.getUsuario(), lista);
				}
			}
			
			// Etiqueta mes o anio
			String lblMesAnio = "";
			if(mes == null) {
				lblMesAnio += (anho != null ? anho : "");
			} else {
				lblMesAnio += (mes != null ? new ConstantesUtil().litMes(Integer.parseInt(mes)) : "");
			}
			
			itUsuario = usuario.iterator();      
			res = new Vector(0, 1);
			int sumaTotalIngresos = 0;
			int sumaGeneralTotalIngresos = 0;
			int sumaTotalOficinas = 0;
			totalOficina = new Ingresos();
			listEliminarUsuario = new HashSet();
			while (itUsuario.hasNext()) {
				bean = (Ingresos)itUsuario.next();
				
				codOficinaNuevo = bean.getCod_oficina();
				
				if(codOficinaAntiguo == null) {
					codOficinaAntiguo = codOficinaNuevo;
				} else {
					if(!codOficinaAntiguo.equals(codOficinaNuevo)) {
						codOficinaAntiguo = codOficinaNuevo;
						beanDet = new Ingresos();
						
						beanDet.setUsuario(" ");
						beanDet.setNombreUsuario(" ");
						beanDet.setCargo(" ");
						beanDet.setNomTerritorio(" ");
						beanDet.setCod_oficina(" ");
						beanDet.setNom_oficina(" ");				
						beanDet.setFecha("");
						beanDet.setMes("Total");
						beanDet.setAnio("Oficina");
						beanDet.setTotalIngreso(totalOficina.getTotalIngreso());
						beanDet.setPlanificacion(totalOficina.getPlanificacion());
						beanDet.setObjetivos(totalOficina.getObjetivos());
						beanDet.setAcciones(totalOficina.getAcciones());
						beanDet.setSeguimiento1(totalOficina.getSeguimiento1());
						beanDet.setSeguimiento2(totalOficina.getSeguimiento2());
						beanDet.setTotal(totalOficina.getTotal());
						
						beanDet.setTipo(3);
						res.add(beanDet);
						
						totalOficina = new Ingresos();
					}
					
					log.info("[SesionIngresosBean :: busIngresoxOficina] Despues codOficinaAntiguo: " + codOficinaAntiguo 
							+ "codOficinaNuevo: " + codOficinaNuevo); 
				}
				
				// Cabecera
				res.add(bean);				
				sumaTotalIngresos = 0;
				sumaTotalOficinas = 0;
				
				// Seccion simple
				listListaUsuario = (ArrayList)listaUsuarioSimple.get(bean.getUsuario());
				itListaUsuario = listListaUsuario.iterator();
				tempValorIngreso = new HashMap();
				while (itListaUsuario.hasNext()) {
					beanDet = (Ingresos)itListaUsuario.next();
					sumaTotalIngresos += beanDet.getTotalIngreso(); 
					sumaTotalOficinas += beanDet.getTotal();
					beanDet.setUsuario(" ");
					beanDet.setTipo(1);
					res.add(beanDet);
					
					valoresTempIngreso = new int[2];
					valoresTempIngreso[0] = res.size() - 1;					
					valoresTempIngreso[1] = beanDet.getTotalIngreso();
					tempValorIngreso.put(beanDet.getFecha(), valoresTempIngreso);
				}
				sumaGeneralTotalIngresos += sumaTotalIngresos;
				
				// Seccion con grupo
				listListaUsuario = (ArrayList)listaUsuarioGrupo.get(bean.getUsuario());
				if(listListaUsuario != null) {
					itListaUsuario = listListaUsuario.iterator();
					String anios = "";
					int avance = 0;
					while (itListaUsuario.hasNext()) {
						beanDet = (Ingresos)itListaUsuario.next();
						
						beanDet.setTipo(1);
						beanDet.setUsuario(" ");

						if(beanDet.getFecha() == null || beanDet.getFecha().equals("") ) {
							if(beanDet.getAnio() != null && beanDet.getAnio().equals("")) {
								if(!anios.equals("")) {
									anios = anios.substring(0, anios.length() - 1); 
								}
								
								beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
								beanDet.setMes("Total");
								beanDet.setAnio(anios);
								beanDet.setTipo(3);
								totalOficina.setPlanificacion(totalOficina.getPlanificacion() + beanDet.getPlanificacion());
								totalOficina.setObjetivos(totalOficina.getObjetivos() + beanDet.getObjetivos());
								totalOficina.setAcciones(totalOficina.getAcciones() + beanDet.getAcciones());
								totalOficina.setSeguimiento1(totalOficina.getSeguimiento1() + beanDet.getSeguimiento1());
								totalOficina.setSeguimiento2(totalOficina.getSeguimiento2() + beanDet.getSeguimiento2());
								totalOficina.setTotal(totalOficina.getTotal() + beanDet.getTotal());
								sumaTotalOficinas += totalOficina.getTotal();
							} else {
								if(beanDet.getMes().equals("")) {
									anios += beanDet.getAnio() + "-";
									beanDet.setMes("Total");
									beanDet.setAnio(beanDet.getAnio());	
									beanDet.setTipo(2);
								} else {
									beanDet.setMes("Total " + beanDet.getMes());
									beanDet.setTipo(2);
								}
							}
						}
						
						if(tempValorIngreso.containsKey(beanDet.getFecha())) {
							int valores[] = (int[])tempValorIngreso.get(beanDet.getFecha()); 
							
							listEliminarUsuario.add(new Integer(valores[0]));
							beanDet.setTotalIngreso(valores[1]);
						}
						
						// Eliminar dos fechas iguales
						if(avance > 1) { 
							for(int i = 1; i <= avance; i++) {
								Ingresos beanFec = (Ingresos)res.get(res.size() - i);
								
								if((beanDet.getFecha() != null && !beanDet.getFecha().equals("")) &&
								   (beanDet.getTotalIngreso() != 0))
								{
									if((beanFec.getFecha().equals(beanDet.getFecha())) && 
									   (beanFec.getTotalIngreso() == beanDet.getTotalIngreso())) {
										//beanFec.setFecha("");	
										beanFec.setTotalIngreso(0);
										break;
									}
								}
							}
						}
						
						res.add(beanDet);
						avance++;
			        }
					
					if(res != null && res.size() > 1) {
						Ingresos beanAntePenultimo = (Ingresos)res.get(res.size() - 2);
						Ingresos beanUltimo = (Ingresos)res.get(res.size() - 1);
						
						if( beanAntePenultimo != null &&
							beanUltimo != null &&
							beanAntePenultimo.getAnio().equals(beanUltimo.getAnio())
						  ) {
							listEliminarUsuario.add(new Integer(res.size() - 2));
						}
					}
					
					// acumula el valor de ingreso total de la seccion simple
					if(res != null && res.size() > 1) {
						beanDet = (Ingresos)res.get(res.size() - 1);
						
						if(beanDet != null) {
							beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaTotalIngresos);
						}
						
						/*beanDet = (Ingresos)res.get(res.size() - 2);
						
						if(beanDet != null) {
							beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaTotalIngresos);
						}*/
					}
				} else {
					beanDet = new Ingresos();
					
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
					beanDet.setFecha("");
					beanDet.setMes("Total");
					beanDet.setAnio(anho);
					beanDet.setTotalIngreso(sumaTotalIngresos);
					beanDet.setPlanificacion(0);
					beanDet.setObjetivos(0);
					beanDet.setAcciones(0);
					beanDet.setSeguimiento1(0);
					beanDet.setSeguimiento2(0);
					beanDet.setTotal(sumaTotalOficinas);
					
					beanDet.setTipo(3);
					res.add(beanDet);
				}
				
				totalOficina.setTotalIngreso(totalOficina.getTotalIngreso() + beanDet.getTotalIngreso());
	        }
			
			if(res != null) {
				beanDet = new Ingresos();
				
				if(totalOficina != null) {
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					beanDet.setNom_oficina(" ");				
					beanDet.setFecha("");
					beanDet.setMes("Total");
					beanDet.setAnio("Oficina");
					beanDet.setTotalIngreso(totalOficina.getTotalIngreso());
					beanDet.setPlanificacion(totalOficina.getPlanificacion());
					beanDet.setObjetivos(totalOficina.getObjetivos());
					beanDet.setAcciones(totalOficina.getAcciones());
					beanDet.setSeguimiento1(totalOficina.getSeguimiento1());
					beanDet.setSeguimiento2(totalOficina.getSeguimiento2());
					//beanDet.setTotal(totalOficina.getTotal());
					beanDet.setTotal(sumaTotalOficinas);
					beanDet.setTipo(3);
					
					res.add(beanDet);
				}	
			}
			
			// Valor de Resumen
			listListaUsuario = (ArrayList)listaUsuarioGrupo.get("*");
			if(listListaUsuario != null) {
				beanDet = (Ingresos)listListaUsuario.get(0);
				
				if(res != null) {
					beanDet.setUsuario(" ");
					beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaGeneralTotalIngresos);
					beanDet.setTipo(3);
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
					beanDet.setMes("Total");
					beanDet.setAnio("General");
					
					res.add(beanDet);
				}
			} else {
				if(res != null) {
					beanDet = new Ingresos();
					
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);				
					beanDet.setFecha("");
					beanDet.setMes("Total");
					beanDet.setAnio("General");
					beanDet.setTotalIngreso(sumaGeneralTotalIngresos);
					beanDet.setPlanificacion(0);
					beanDet.setObjetivos(0);
					beanDet.setAcciones(0);
					beanDet.setSeguimiento1(0);
					beanDet.setSeguimiento2(0);
					beanDet.setTipo(3);
					
					res.add(beanDet);
				}
			}
			
			if(res != null && res.size() > 0) {
				ArrayList lista = new ArrayList();
				Iterator iter = listEliminarUsuario.iterator();
				while(iter.hasNext()) {
					Integer valor = (Integer)iter.next();
					lista.add(valor);
				}
				Collections.sort(lista);
				
				iter = lista.iterator();
				int cont = 0; 
				while(iter.hasNext()) {
					Integer valor = (Integer)iter.next();
					res.remove(valor.intValue() - cont);
					cont++;
				}
			}
			
			log.info("[SesionIngresosBean :: busIngresoxOficina] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxOficina] ");
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
				log.error("[SesionIngresosBean :: busIngresoxOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	public Vector busIngresoxTerritorio(String anho, String mes, String dia, String codTerritorioUsuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Ingresos bean = null;
		Ingresos beanDet = null;
		String sql = null;
		String where = null;
		String order = null;
		ArrayList usuario = null;
		HashMap listaUsuarioSimple = null;
		HashMap listaUsuarioGrupo = null;
		HashMap tempValorIngreso = null;
		int valoresTempIngreso[] = null; 
		Iterator itUsuario = null;
		Iterator itListaUsuario = null;
		ArrayList listListaUsuario = null;
		String codTerritorioAntiguo = null;
		String codTerritorioNuevo = null;
		Ingresos totalTerritorio = null;
		HashSet listEliminarUsuario = null;
		
		try {
			log.info("[SesionIngresosBean :: busIngresoxTerritorio] Inicio");
			
			usuario = busUsuarios(anho, mes, dia, codTerritorioUsuario, 3);
			if(usuario == null) {
				log.info("[SesionIngresosBean :: busIngresoxTerritorio] Fin");
				
				return null;
			}
		} catch(Exception e) {
			log.info("[SesionIngresosBean :: busIngresoxTerritorio] Fin");
			
			return null;
		}
		
		try {
			initialContext = new InitialContext();
			
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busIngresoxTerritorio] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busIngresoxTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busIngresoxTerritorio] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			
			where = "WHERE to_char(FECHA, 'yyyy') LIKE '%" + (anho != null ? anho : "") + 
			"%' AND to_char(FECHA, 'mm') LIKE '%" + (mes != null ? mes : "") + "%' " + 
			"AND to_char(FECHA, 'dd') LIKE '%" + (dia != null ? dia : "") + "%' ";
			
			if(codTerritorioUsuario != null) {
				where += "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
			}			
			 
			order = "ORDER BY usuario, fecha";
			
			sql = "SELECT cod_usuario usuario, TO_CHAR(fecha, 'YYYYMMDD') fecha, COUNT(*) ingresos " +        
				  "FROM tiido_ingresos " +
				  where +
				  "GROUP BY cod_usuario, to_char(fecha, 'YYYYMMDD') " +
				  order;
				
			log.info("[SesionIngresosBean :: busIngresoxTerritorio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaUsuarioSimple = new HashMap();
			while (rst.next()) {
				bean = new Ingresos();
				
				bean.setUsuario(rst.getString("usuario"));
				bean.setNombreUsuario(" ");
				bean.setCargo(" ");
				bean.setNomTerritorio(" ");
				bean.setCod_oficina(" ");
				bean.setNom_oficina(" ");				
				bean.setFecha(ConstantesUtil.formatearFechaString2(rst.getString("fecha")));
				bean.setMes("");
				bean.setAnio("");
				bean.setTotalIngreso(rst.getInt("ingresos"));
				bean.setPlanificacion(0);
				bean.setObjetivos(0);
				bean.setAcciones(0);
				bean.setSeguimiento1(0);
				bean.setSeguimiento2(0);
				bean.setTotal(0);
				
				if(listaUsuarioSimple.containsKey(bean.getUsuario())) {
					ArrayList lista = (ArrayList)listaUsuarioSimple.get(bean.getUsuario());
					
					
					lista.add(bean);					
				} else {
					ArrayList lista = new ArrayList();
					lista.add(bean);
					listaUsuarioSimple.put(bean.getUsuario(), lista);
				}
			}
			
			sql = "SELECT NVL(cod_usuario, '*') usuario, TO_CHAR(i.fecha, 'YYYYMMDD') fecha, NVL(d.mes, 0) mes, NVL(d.anio, '0') anio, " +
				  "       NVL(SUM(planes), 0) planes, NVL(SUM(objetivos), 0) objetivos, " +
		       	  "		  NVL(SUM(acciones), 0) acciones,NVL(SUM(seg1), 0) seg1, NVL(SUM(seg2), 0) seg2 " +
				  "FROM tiido_ingresos i " + 
				  "INNER JOIN tiido_ingresos_detalle d ON (i.id_ingresos = d.id_ingresos) " +
				  where + 
				  "GROUP BY ROLLUP(cod_usuario, anio, mes, TO_CHAR(i.fecha, 'YYYYMMDD')) ";
				
			log.info("[SesionIngresosBean :: busIngresoxTerritorio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			listaUsuarioGrupo = new HashMap();
			
			while (rst.next()) {
				bean = new Ingresos();
				
				bean.setUsuario(rst.getString("usuario"));
				bean.setNombreUsuario(" ");
				bean.setCargo(" ");
				bean.setNomTerritorio(" ");
				bean.setCod_oficina(" ");
				bean.setNom_oficina(" ");				
				bean.setFecha(ConstantesUtil.formatearFechaString2(rst.getString("fecha")));
				bean.setMes(new ConstantesUtil().litMes(rst.getInt("mes")));
				bean.setAnio(rst.getString("anio").equals("0") ? "" : rst.getString("anio"));
				//bean.setTotalIngreso(rst.getInt("total_ingreso"));
				bean.setPlanificacion(rst.getInt("planes"));
				bean.setObjetivos(rst.getInt("objetivos"));
				bean.setAcciones(rst.getInt("acciones"));
				bean.setSeguimiento1(rst.getInt("seg1"));
				bean.setSeguimiento2(rst.getInt("seg2"));
				bean.setTotal(	bean.getPlanificacion() + 
								bean.getObjetivos() +
								bean.getAcciones() +
								bean.getSeguimiento1() +
								bean.getSeguimiento2());
				
				if(listaUsuarioGrupo.containsKey(bean.getUsuario())) {
					ArrayList lista = (ArrayList)listaUsuarioGrupo.get(bean.getUsuario());
					
					lista.add(bean);					
				} else {
					ArrayList lista = new ArrayList();
					lista.add(bean);	
					listaUsuarioGrupo.put(bean.getUsuario(), lista);
				}
			}
			
			// Etiqueta mes o anio
			String lblMesAnio = "";
			if(mes == null) {
				lblMesAnio += (anho != null ? anho : "");
			} else {
				lblMesAnio += (mes != null ? new ConstantesUtil().litMes(Integer.parseInt(mes)) : "");
			}
			
			itUsuario = usuario.iterator();      
			res = new Vector(0, 1);
			int sumaTotalIngresos = 0;
			int sumaTotalTerritorio = 0;
			int sumaGeneralTotalIngresos = 0;
			totalTerritorio = new Ingresos();
			listEliminarUsuario = new HashSet();
			while (itUsuario.hasNext()) {
				bean = (Ingresos)itUsuario.next();
				
				codTerritorioNuevo = bean.getNomTerritorio();
				
				if(codTerritorioAntiguo == null) {
					codTerritorioAntiguo = codTerritorioNuevo;
				} else {
					if(!codTerritorioAntiguo.equals(codTerritorioNuevo)) {
						codTerritorioAntiguo = codTerritorioNuevo;
						beanDet = new Ingresos();
						
						beanDet.setUsuario(" ");
						beanDet.setNombreUsuario(" ");
						beanDet.setCargo(" ");
						beanDet.setNomTerritorio(" ");
						beanDet.setCod_oficina(" ");
						beanDet.setNom_oficina(" ");				
						beanDet.setFecha("");
						beanDet.setMes("Total");
						beanDet.setAnio("Territorio");
						beanDet.setTotalIngreso(totalTerritorio.getTotalIngreso());
						beanDet.setPlanificacion(totalTerritorio.getPlanificacion());
						beanDet.setObjetivos(totalTerritorio.getObjetivos());
						beanDet.setAcciones(totalTerritorio.getAcciones());
						beanDet.setSeguimiento1(totalTerritorio.getSeguimiento1());
						beanDet.setSeguimiento2(totalTerritorio.getSeguimiento2());
						beanDet.setTotal(totalTerritorio.getTotal());
						
						beanDet.setTipo(3);
						res.add(beanDet);
						
						totalTerritorio = new Ingresos();
					}
				}
				
				// Cabecera
				res.add(bean);				
				sumaTotalIngresos = 0;
				sumaTotalTerritorio = 0;
				
				// Seccion simple
				listListaUsuario = (ArrayList)listaUsuarioSimple.get(bean.getUsuario());
				itListaUsuario = listListaUsuario.iterator();
				tempValorIngreso = new HashMap();	
				while (itListaUsuario.hasNext()) {
					beanDet = (Ingresos)itListaUsuario.next();
					sumaTotalIngresos += beanDet.getTotalIngreso(); 
					beanDet.setUsuario(" ");
					beanDet.setTipo(1);
					res.add(beanDet);
					
					valoresTempIngreso = new int[2];
					valoresTempIngreso[0] = res.size() - 1;					
					valoresTempIngreso[1] = beanDet.getTotalIngreso();
					tempValorIngreso.put(beanDet.getFecha(), valoresTempIngreso);
				}
				sumaGeneralTotalIngresos += sumaTotalIngresos;
				
				// Seccion con grupo
				listListaUsuario = (ArrayList)listaUsuarioGrupo.get(bean.getUsuario());
				if(listListaUsuario != null) {
					itListaUsuario = listListaUsuario.iterator();
					String anios = "";
					int avance = 0;
					while (itListaUsuario.hasNext()) {
						beanDet = (Ingresos)itListaUsuario.next();
						
						beanDet.setTipo(1);
						beanDet.setUsuario(" ");
						
						if(beanDet.getFecha() == null || beanDet.getFecha().equals("") ) {
							if(beanDet.getAnio() != null && beanDet.getAnio().equals("")) {
								if(!anios.equals("")) {
									anios = anios.substring(0, anios.length() - 1); 
								}
								
								beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
								beanDet.setMes("Total");
								beanDet.setAnio(anios);
								beanDet.setTipo(3);
								totalTerritorio.setPlanificacion(totalTerritorio.getPlanificacion() + beanDet.getPlanificacion());
								totalTerritorio.setObjetivos(totalTerritorio.getObjetivos() + beanDet.getObjetivos());
								totalTerritorio.setAcciones(totalTerritorio.getAcciones() + beanDet.getAcciones());
								totalTerritorio.setSeguimiento1(totalTerritorio.getSeguimiento1() + beanDet.getSeguimiento1());
								totalTerritorio.setSeguimiento2(totalTerritorio.getSeguimiento2() + beanDet.getSeguimiento2());
								totalTerritorio.setTotal(totalTerritorio.getTotal() + beanDet.getTotal());
								sumaTotalTerritorio += totalTerritorio.getTotal();
							} else {
								if(beanDet.getMes().equals("")) {
									anios += beanDet.getAnio() + "-";
									beanDet.setMes("Total");
									beanDet.setAnio(beanDet.getAnio());										
									beanDet.setTipo(2);
								} else {
									beanDet.setMes("Total " + beanDet.getMes());
									beanDet.setTipo(2);
								}
							}
						}
						
						if(tempValorIngreso.containsKey(beanDet.getFecha())) {
							int valores[] = (int[])tempValorIngreso.get(beanDet.getFecha()); 
							
							listEliminarUsuario.add(new Integer(valores[0]));
							beanDet.setTotalIngreso(valores[1]);
						}
						
						// Eliminar dos fechas iguales
						if(avance > 1) { 
							for(int i = 1; i <= avance; i++) {
								Ingresos beanFec = (Ingresos)res.get(res.size() - i);
								
								if((beanDet.getFecha() != null && !beanDet.getFecha().equals("")) &&
								   (beanDet.getTotalIngreso() != 0))
								{
									if((beanFec.getFecha().equals(beanDet.getFecha())) && 
									   (beanFec.getTotalIngreso() == beanDet.getTotalIngreso())) {
										//beanFec.setFecha("");	
										beanFec.setTotalIngreso(0);
										break;
									}
								}
							}
						}
						
						res.add(beanDet);
						avance++;
			        }
					
					if(res != null && res.size() > 1) {
						Ingresos beanAntePenultimo = (Ingresos)res.get(res.size() - 2);
						Ingresos beanUltimo = (Ingresos)res.get(res.size() - 1);
						
						if( beanAntePenultimo != null &&
							beanUltimo != null &&
							beanAntePenultimo.getAnio().equals(beanUltimo.getAnio())
						  ) {
							listEliminarUsuario.add(new Integer(res.size() - 2));
						}
					}
					
					// acumula el valor de ingreso total de la seccion simple
					if(res != null && res.size() > 1) {
						beanDet = (Ingresos)res.get(res.size() - 1);
						
						if(beanDet != null) {
							beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaTotalIngresos);
						}
						
						/*beanDet = (Ingresos)res.get(res.size() - 2);
						
						if(beanDet != null) {
							beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaTotalIngresos);
						}*/
					}
				} else {
					beanDet = new Ingresos();
					
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);				
					beanDet.setFecha("");
					beanDet.setMes("Total");
					beanDet.setAnio(anho);
					beanDet.setTotalIngreso(sumaTotalIngresos);
					beanDet.setPlanificacion(0);
					beanDet.setObjetivos(0);
					beanDet.setAcciones(0);
					beanDet.setSeguimiento1(0);
					beanDet.setSeguimiento2(0);
					
					beanDet.setTotal(sumaTotalTerritorio);
					
					beanDet.setTipo(3);
					res.add(beanDet);
				}
				
				totalTerritorio.setTotalIngreso(totalTerritorio.getTotalIngreso() + beanDet.getTotalIngreso());
	        }
			
			if(res != null) {
				beanDet = new Ingresos();
				
				if(totalTerritorio != null) {
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					beanDet.setNom_oficina(" ");				
					beanDet.setFecha("");
					beanDet.setMes("Total");
					beanDet.setAnio("Territorio");
					beanDet.setTotalIngreso(totalTerritorio.getTotalIngreso());
					beanDet.setPlanificacion(totalTerritorio.getPlanificacion());
					beanDet.setObjetivos(totalTerritorio.getObjetivos());
					beanDet.setAcciones(totalTerritorio.getAcciones());
					beanDet.setSeguimiento1(totalTerritorio.getSeguimiento1());
					beanDet.setSeguimiento2(totalTerritorio.getSeguimiento2());
					beanDet.setTotal(sumaTotalTerritorio);
					beanDet.setTipo(3);
					
					res.add(beanDet);
				}	
			}
			
			// Valor de Resumen
			listListaUsuario = (ArrayList)listaUsuarioGrupo.get("*");
			if(listListaUsuario != null) {
				beanDet = (Ingresos)listListaUsuario.get(0);
				
				if(res != null) {
					beanDet.setUsuario(" ");
					beanDet.setTotalIngreso(beanDet.getTotalIngreso() + sumaGeneralTotalIngresos);
					beanDet.setTipo(3);
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);
					beanDet.setMes("Total");
					beanDet.setAnio("General");
					
					res.add(beanDet);
				}
			} else {
				if(res != null) {
					beanDet = new Ingresos();
					
					beanDet.setUsuario(" ");
					beanDet.setNombreUsuario(" ");
					beanDet.setCargo(" ");
					beanDet.setNomTerritorio(" ");
					beanDet.setCod_oficina(" ");
					beanDet.setNom_oficina("Total Ingresos " + lblMesAnio);				
					beanDet.setFecha("");
					beanDet.setMes("Total");
					beanDet.setAnio("General");
					beanDet.setTotalIngreso(sumaGeneralTotalIngresos);
					beanDet.setPlanificacion(0);
					beanDet.setObjetivos(0);
					beanDet.setAcciones(0);
					beanDet.setSeguimiento1(0);
					beanDet.setSeguimiento2(0);
					beanDet.setTipo(3);
					
					res.add(beanDet);
				}
			}
			
			if(res != null && res.size() > 0) {
				ArrayList lista = new ArrayList();
				Iterator iter = listEliminarUsuario.iterator();
				while(iter.hasNext()) {
					Integer valor = (Integer)iter.next();
					lista.add(valor);
				}
				Collections.sort(lista);
				
				iter = lista.iterator();
				int cont = 0; 
				while(iter.hasNext()) {
					Integer valor = (Integer)iter.next();
					res.remove(valor.intValue() - cont);
					cont++;
				}
			}
			
			log.info("[SesionIngresosBean :: busIngresoxTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busIngresoxTerritorio] ");
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
				log.error("[SesionIngresosBean :: busIngresoxTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	private ArrayList busUsuarios(String anho, String mes, String dia, String codTerritorioUsuario, int tipo) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		ArrayList usuarios = null;
		Ingresos bean = null;
		String sql = null;
		String where = null;
		String order = null;
		
		try {
			log.info("[SesionIngresosBean :: busUsuarios] Inicio");
			
			initialContext = new InitialContext();
			
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: busUsuarios] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: busUsuarios] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: busUsuarios] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			
			where = "WHERE to_char(FECHA, 'yyyy') LIKE '%" + (anho != null ? anho : "") + 
			"%' AND to_char(FECHA, 'mm') LIKE '%" + (mes != null ? mes : "") + "%' " + 
			"AND to_char(FECHA, 'dd') LIKE '%" + (dia != null ? dia : "") + "%' ";
			
			if(codTerritorioUsuario != null) {
				where += "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorioUsuario + "') ";
			}			
			
			switch(tipo) {
				case 1: order = " i.cod_usuario, i.fecha DESC "; 
						break;
				case 2: order = " i.cod_oficina, i.cod_usuario, i.fecha DESC"; 
						break;		
				case 3: order = " nom_territorio, i.cod_oficina, i.cod_usuario, i.fecha DESC"; 
						break;		
			} 
			
			sql = "SELECT i.cod_usuario codusuario, NVL(i.nombres, '') nombres, " + 
				  "		  NVL(DECODE(i.cargo, 'null', '', i.cargo), '') cargo, " +
				  "		  NVL(DECODE(NVL(i.nom_territorio, ''), 'null', '', NVL(i.nom_territorio, '')), '') nom_territorio, " +   
				  "		  NVL(DECODE(i.cod_oficina, 'null', '', i.cod_oficina), '') codoficina, " +
				  "		  NVL(UPPER((SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = i.cod_oficina)), '') nom_oficina " + 		
				  "FROM tiido_ingresos i " +
				  where +
				  "ORDER BY " + order;
				
			log.info("[SesionIngresosBean :: busUsuarios] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			usuarios = new ArrayList();
			boolean existe = false;
			while(rst.next()) {
				bean = new Ingresos();
				existe = false;
				
				bean.setUsuario(rst.getString("codusuario"));
				bean.setNombreUsuario(rst.getString("nombres"));
				bean.setCargo(rst.getString("cargo"));
				bean.setNomTerritorio(rst.getString("nom_territorio") != null ? rst.getString("nom_territorio") : "");
				bean.setCod_oficina(rst.getString("codoficina"));
				bean.setNom_oficina(rst.getString("nom_oficina"));
				bean.setMes("");
				bean.setAnio("");
				
				Iterator it = usuarios.iterator();
				while(it.hasNext()) {
					Ingresos ing = (Ingresos)it.next();
					if(bean.getUsuario().equals(ing.getUsuario())) {
						existe = true;
						break;
					}
				}
				
				if(!existe) {
					usuarios.add(bean);
				}
			}
			
			log.info("[SesionIngresosBean :: busUsuarios] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: busUsuarios] ");
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
				log.error("[SesionIngresosBean :: busUsuarios] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return usuarios;	
	}
	
	public Vector reportexUsuario(int dia, int mes, int anio, String codTerritorio) {
		Vector listaRegistro = new Vector(0, 1);
		ArrayList listaUsuario = null;
		ReporteIngreso reporteIngreso = null;
		ReporteIngreso reporteIngresoForm = null;
		ArrayList listaDiasMeses = null; 
		ArrayList listaDatos = null;
		HashMap listaIngresosUsuario = null;
		HashMap listaIngresosAbrevUsuario = null;
		HashMap listaFormUsuarioReporte = null;
		HashMap listaFormUsuarioAbrevReporte = null;
		String mesAnio[] = null; 
		Iterator iterListaUsuario = null;
		Iterator iterListaDiasMeses = null;
		StringBuffer listaCodUsuario = null; 
		int sumaValor = 0;
		
		try {
			log.info("[SesionIngresosBean :: reportexUsuario] Inicio");
			
			mesAnio = ConstantesUtil.formatMesAnioText(mes, anio);
			
			if(dia == -1) {
				listaDiasMeses = ConstantesUtil.diasMesesReporte(mes, anio);
			} else {
				listaDiasMeses = ConstantesUtil.diaReporte(dia, mes, anio);
			}
			
			if(listaDiasMeses == null || listaDiasMeses.size() == 0) {
				log.info("[SesionIngresosBean :: reportexUsuario] Fin");
				
				return listaRegistro;
			}
			
			listaUsuario = listadoUsuarioAbrevReporte(mesAnio, codTerritorio);
			if(listaUsuario != null && listaUsuario.size() > 0) {
				listaCodUsuario = new StringBuffer();
				iterListaUsuario = listaUsuario.iterator();
				
				// lista los codigos del usuario
				while(iterListaUsuario.hasNext()) {
					reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
					
					listaCodUsuario.append("'");
					listaCodUsuario.append(reporteIngreso.getCodUsuario());
					listaCodUsuario.append("'");
					listaCodUsuario.append(",");
				}
				
				listaCodUsuario.deleteCharAt(listaCodUsuario.length() - 1);
				
				listaIngresosAbrevUsuario = listadoIngresosUsuarioReporte(listaCodUsuario.toString(), mesAnio);
				listaFormUsuarioAbrevReporte = listadoFormUsuarioAbrevReporte(listaCodUsuario.toString(), mesAnio, mes, anio);
				
				iterListaUsuario = listaUsuario.iterator();
				while(iterListaUsuario.hasNext()) {
					reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
					
					// ingresos				
					if(listaIngresosAbrevUsuario != null) {
						listaIngresosUsuario = (HashMap)listaIngresosAbrevUsuario.get(reporteIngreso.getCodUsuario());
					} else {
						listaIngresosUsuario = null;
					}
					
					listaDatos = new ArrayList();
					sumaValor = 0;
					if(listaIngresosUsuario != null) {
						if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
							iterListaDiasMeses = listaDiasMeses.iterator(); 
							
							while(iterListaDiasMeses.hasNext()) {
								String tempMesAnio = (String) iterListaDiasMeses.next();							
								String valor = (String)listaIngresosUsuario.get(tempMesAnio);
								
								listaDatos.add(valor != null ? valor : "");
								sumaValor +=  (valor != null ? Integer.parseInt(valor) : 0);
							}
						}
					}
					reporteIngreso.setEtiquetaFechas("N" + (char) 176 + " Ingresos");
					reporteIngreso.setListaDatos(listaDatos);
					reporteIngreso.setFormato(1);
					reporteIngreso.setTotal(String.valueOf(sumaValor));
					listaRegistro.add(reporteIngreso);
					
					// fechas
					if(listaFormUsuarioAbrevReporte != null) {
						listaFormUsuarioReporte = (HashMap)listaFormUsuarioAbrevReporte.get(reporteIngreso.getCodUsuario());
					} else {
						listaFormUsuarioReporte = null;
					}
					
					for(int i = 1; i <= 5; i++) {
						String etiqueta = "";
						//	datos generales
						reporteIngresoForm = new ReporteIngreso();
						reporteIngresoForm.setCodUsuario(reporteIngreso.getCodUsuario());
						reporteIngresoForm.setNombres(reporteIngreso.getNombres());
						reporteIngresoForm.setCargo(reporteIngreso.getCargo());
						reporteIngresoForm.setNomTerritorio(reporteIngreso.getNomTerritorio());
						reporteIngresoForm.setCodOficina(reporteIngreso.getCodOficina());
						reporteIngresoForm.setDescOficina(reporteIngreso.getDescOficina());
						
						switch(i) {
							case 1: 	etiqueta = "Prioridad";
										break;
							case 2: 	etiqueta = "Objetivos";
										break;
							case 3: 	etiqueta = "Acciones";
										break;
							case 4: 	etiqueta = "Seguimiento 1";
										break;
							case 5: 	etiqueta = "Cierre";
										break;
						}
						
						reporteIngresoForm.setEtiquetaFechas(etiqueta);
						listaDatos = new ArrayList();
						
						sumaValor = 0;
						if(listaFormUsuarioReporte != null) {
							iterListaDiasMeses = listaDiasMeses.iterator(); 
							
							while(iterListaDiasMeses.hasNext()) {
								String tempMesAnio = (String) iterListaDiasMeses.next();		
							
								String valor = (String)listaFormUsuarioReporte.get(String.valueOf(i) + tempMesAnio);
								listaDatos.add(valor != null ? valor : "");
								sumaValor +=  (valor != null ? 1 : 0);
							}
						}
						reporteIngresoForm.setListaDatos(listaDatos);
						reporteIngresoForm.setTotal(String.valueOf(sumaValor));
						reporteIngresoForm.setFormato(2);
						
						listaRegistro.add(reporteIngresoForm);
					}
					
					reporteIngreso = new ReporteIngreso();
					reporteIngreso.setCodUsuario("");
					reporteIngreso.setCargo("");
					reporteIngreso.setNomTerritorio("");
					reporteIngreso.setDescOficina("");
					reporteIngreso.setEtiquetaFechas("");
					listaDatos = new ArrayList();
					reporteIngreso.setListaDatos(listaDatos);
					reporteIngreso.setTotal("");
					reporteIngreso.setFormato(3);
					listaRegistro.add(reporteIngreso);
				}
			}
			
			log.info("[SesionIngresosBean :: reportexUsuario] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: reportexUsuario] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaRegistro;
	}
	
	public Vector reportexUsuarioxAnio(int anio, String codTerritorio) {
		Vector listaRegistro = new Vector(0, 1);
		ArrayList listaUsuario = null;
		ReporteIngreso reporteIngreso = null;
		ReporteIngreso reporteIngresoForm = null;
		ReporteIngreso tempReporteIngreso = null;
		ArrayList listaDiasMeses = null; 
		ArrayList listaDatos = null;
		HashMap listaIngresosUsuario = null;
		HashMap listaIngresosAbrevUsuario = null;
		HashMap listaFormUsuarioReporte = null;
		HashMap listaFormUsuarioAbrevReporte = null;
		ArrayList mesAnio = null; 
		Iterator iterListaUsuario = null;  
		Iterator iterListaDiasMeses = null;
		StringBuffer listaCodUsuario = null;
		int sumaValor = 0;
		
		try {
			log.info("[SesionIngresosBean :: reportexUsuarioxAnio] Inicio");
			
			mesAnio = listarFormatMesAnioxAnio(anio);
			
			listaDiasMeses = listarDiasMesesxAnio(anio);
			
			if(listaDiasMeses == null || listaDiasMeses.size() == 0) {
				log.info("[SesionIngresosBean :: reportexUsuarioxAnio] Inicio");
				
				return listaRegistro;
			}
			
			listaUsuario = listadoUsuarioAbrevReportexAnio(mesAnio, codTerritorio);
			if(listaUsuario != null && listaUsuario.size() > 0) {
				listaCodUsuario = new StringBuffer();
				iterListaUsuario = listaUsuario.iterator();

				//lista los codigos del usuario
				while(iterListaUsuario.hasNext()) {
					reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
					
					listaCodUsuario.append("'");
					listaCodUsuario.append(reporteIngreso.getCodUsuario());
					listaCodUsuario.append("'");
					listaCodUsuario.append(",");
				}
				
				listaCodUsuario.deleteCharAt(listaCodUsuario.length() - 1);
				
				listaIngresosAbrevUsuario = listadoIngresosUsuarioReportexAnio(listaCodUsuario.toString(), mesAnio);
				listaFormUsuarioAbrevReporte = listadoFormUsuarioAbrevReportexAnio(listaCodUsuario.toString(), mesAnio, anio);
				
				iterListaUsuario = listaUsuario.iterator();
				
				while(iterListaUsuario.hasNext()) {
					reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
					
					// ingresos				
					if(listaIngresosAbrevUsuario != null) {
						listaIngresosUsuario = (HashMap)listaIngresosAbrevUsuario.get(reporteIngreso.getCodUsuario());
					} else {
						listaIngresosUsuario = null;
					}
						
					listaDatos = new ArrayList();
					sumaValor = 0;
					if(listaIngresosUsuario != null) {
						if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
							iterListaDiasMeses = listaDiasMeses.iterator();
							while(iterListaDiasMeses.hasNext()) {
								String tempMesAnio = (String) iterListaDiasMeses.next();
							
								String valor = (String)listaIngresosUsuario.get(tempMesAnio);
								
								listaDatos.add(valor != null ? valor : "");
								sumaValor +=  (valor != null ? Integer.parseInt(valor) : 0);
							}
						}
					}
					
					reporteIngreso.setEtiquetaFechas("N" + (char) 176 + " Ingresos");
					reporteIngreso.setListaDatos(listaDatos);
					reporteIngreso.setFormato(1);
					reporteIngreso.setTotal(String.valueOf(sumaValor));
					listaRegistro.add(reporteIngreso);
					
					// fechas
					
					
					if(listaFormUsuarioAbrevReporte != null) {
						listaFormUsuarioReporte = (HashMap)listaFormUsuarioAbrevReporte.get(reporteIngreso.getCodUsuario());
					} else {
						listaFormUsuarioReporte = null;
					}
					
					for(int i = 1; i <= 5; i++) {
						String etiqueta = "";
						//	datos generales
						reporteIngresoForm = new ReporteIngreso();
						reporteIngresoForm.setCodUsuario(reporteIngreso.getCodUsuario());
						reporteIngresoForm.setNombres(reporteIngreso.getNombres());
						reporteIngresoForm.setCargo(reporteIngreso.getCargo());
						reporteIngresoForm.setNomTerritorio(reporteIngreso.getNomTerritorio());
						reporteIngresoForm.setCodOficina(reporteIngreso.getCodOficina());
						reporteIngresoForm.setDescOficina(reporteIngreso.getDescOficina());
						
						switch(i) {
							case 1: 	etiqueta = "Prioridad";
										break;
							case 2: 	etiqueta = "Objetivos";
										break;
							case 3: 	etiqueta = "Acciones";
										break;
							case 4: 	etiqueta = "Seguimiento 1";
										break;
							case 5: 	etiqueta = "Cierre";
										break;
						}
						
						reporteIngresoForm.setEtiquetaFechas(etiqueta);
						listaDatos = new ArrayList();
						sumaValor = 0;
						
						if(listaFormUsuarioReporte != null) {
							if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
								iterListaDiasMeses = listaDiasMeses.iterator();
								while(iterListaDiasMeses.hasNext()) {
									String tempMesAnio = (String) iterListaDiasMeses.next();
									String valor = (String)listaFormUsuarioReporte.get(String.valueOf(i) + tempMesAnio);
								
									listaDatos.add(valor != null ? valor : "");
									
									sumaValor +=  (valor != null ? 1 : 0);
								}
							}
						}
						reporteIngresoForm.setListaDatos(listaDatos);
						reporteIngresoForm.setTotal(String.valueOf(sumaValor));
						reporteIngresoForm.setFormato(2);
						
						listaRegistro.add(reporteIngresoForm);
					}
					
					reporteIngreso = new ReporteIngreso();
					reporteIngreso.setCodUsuario("");
					reporteIngreso.setCargo("");
					reporteIngreso.setNomTerritorio("");
					reporteIngreso.setDescOficina("");
					reporteIngreso.setEtiquetaFechas("");
					listaDatos = new ArrayList();
					reporteIngreso.setListaDatos(listaDatos);
					reporteIngreso.setTotal("");
					reporteIngreso.setFormato(3);
					listaRegistro.add(reporteIngreso);
				}
			}
			
			log.info("[SesionIngresosBean :: reportexUsuarioxAnio] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: reportexUsuarioxAnio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaRegistro;
	}
	
	public Vector reportexOficina(int dia, int mes, int anio, String codTerritorio) {
		Vector listaRegistro = new Vector(0, 1);
		ArrayList listaOficina = null;
		ArrayList listaUsuario = null;
		ReporteIngreso reporteIngreso = null;
		ReporteIngreso reporteIngresoForm = null;
		ArrayList listaDiasMeses = null; 
		ArrayList listaDatos = null;
		HashMap listaIngresosUsuario = null;
		HashMap listaIngresosAbrevUsuario = null;
		HashMap listaIngresosAbrevOficina = null;
		HashMap listaFormUsuarioReporte = null;
		HashMap listaFormUsuarioAbrevReporte = null;
		HashMap listaFormUsuarioAbrevReporteOficina = null;
		String mesAnio[] = null; 
		Iterator iterListaOficina = null;
		Iterator iterListaUsuario = null;
		Iterator iterMesAnio = null;
		Iterator iterListaDiasMeses = null;
		StringBuffer listaCodUsuario = null; 
		StringBuffer listaCodOficina = null;
		int sumaValor = 0;
		
		try {
			log.info("[SesionIngresosBean :: reportexOficina] Inicio");
			
			mesAnio = ConstantesUtil.formatMesAnioText(mes, anio);
			
			listaDiasMeses = ConstantesUtil.diasMesesReporte(mes, anio);
			
			if(listaDiasMeses == null || listaDiasMeses.size() == 0) {
				log.info("[SesionIngresosBean :: reportexOficina] Fin");
				
				return listaRegistro;
			}
			
			listaOficina = listadoOficinaReporte(mesAnio, codTerritorio);
			if(listaOficina != null && listaOficina.size() > 0) {
				listaCodOficina = new StringBuffer();
				
				iterListaOficina = listaOficina.iterator();
				
				// lista los codigos del objetivo
				while(iterListaOficina.hasNext()) {
					String codOficina  = (String)iterListaOficina.next();
					
					listaCodOficina.append("'");
					listaCodOficina.append(codOficina);
					listaCodOficina.append("'");
					listaCodOficina.append(",");
				}
				
				listaCodOficina.deleteCharAt(listaCodOficina.length() - 1);
				
				iterListaOficina = listaOficina.iterator();
				
				listaIngresosAbrevOficina = listadoIngresosUsuarioxOficinaReporte(listaCodOficina.toString(), mesAnio);
				listaFormUsuarioAbrevReporteOficina = listadoFormUsuarioxOficinaAbrevReporte(listaCodOficina.toString(), mesAnio, mes, anio);
				
				while(iterListaOficina.hasNext()) {
					String codOficina = (String)iterListaOficina.next();
					
					listaUsuario = listadoUsuarioxOficinaAbrevReporte(mesAnio, codOficina, codTerritorio);
					
					if(listaUsuario != null && listaUsuario.size() > 0) {
						
						if(listaIngresosAbrevOficina != null) {
							listaIngresosAbrevUsuario = (HashMap)listaIngresosAbrevOficina.get(codOficina);
						} else {
							listaIngresosAbrevUsuario = null;
						}
						
						if(listaFormUsuarioAbrevReporteOficina != null) {
							listaFormUsuarioAbrevReporte = (HashMap)listaFormUsuarioAbrevReporteOficina.get(codOficina);
						} else {
							listaFormUsuarioAbrevReporte = null;
						}
						
						iterListaUsuario = listaUsuario.iterator();
						
						while(iterListaUsuario.hasNext() && listaIngresosAbrevUsuario != null) {
							reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
							
							// ingresos				
							listaIngresosUsuario = (HashMap)listaIngresosAbrevUsuario.get(reporteIngreso.getCodUsuario());
							listaDatos = new ArrayList();
							sumaValor = 0;
							if(listaIngresosUsuario != null) {
								if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
									iterListaDiasMeses = listaDiasMeses.iterator(); 
									
									while(iterListaDiasMeses.hasNext()) {
										String tempMesAnio = (String) iterListaDiasMeses.next();							
										String valor = (String)listaIngresosUsuario.get(tempMesAnio);
										
										listaDatos.add(valor != null ? valor : "");
										sumaValor +=  (valor != null ? Integer.parseInt(valor) : 0);
									}
								}
							}
							reporteIngreso.setEtiquetaFechas("N" + (char) 176 + " Ingresos");
							reporteIngreso.setListaDatos(listaDatos);
							reporteIngreso.setFormato(1);
							reporteIngreso.setTotal(String.valueOf(sumaValor));
							listaRegistro.add(reporteIngreso);
							
							// fechas
							if(listaFormUsuarioAbrevReporte != null) {
								listaFormUsuarioReporte = (HashMap)listaFormUsuarioAbrevReporte.get(reporteIngreso.getCodUsuario());
								for(int i = 1; i <= 5; i++) {
									String etiqueta = "";
									//	datos generales
									reporteIngresoForm = new ReporteIngreso();
									reporteIngresoForm.setCodUsuario(reporteIngreso.getCodUsuario());
									reporteIngresoForm.setNombres(reporteIngreso.getNombres());
									reporteIngresoForm.setCargo(reporteIngreso.getCargo());
									reporteIngresoForm.setNomTerritorio(reporteIngreso.getNomTerritorio());
									reporteIngresoForm.setCodOficina(reporteIngreso.getCodOficina());
									reporteIngresoForm.setDescOficina(reporteIngreso.getDescOficina());
									
									switch(i) {
										case 1: 	etiqueta = "Prioridad";
													break;
										case 2: 	etiqueta = "Objetivos";
													break;
										case 3: 	etiqueta = "Acciones";
													break;
										case 4: 	etiqueta = "Seguimiento 1";
													break;
										case 5: 	etiqueta = "Cierre";
													break;
									}
									
									reporteIngresoForm.setEtiquetaFechas(etiqueta);
									listaDatos = new ArrayList();
									sumaValor = 0;
									
									if(listaFormUsuarioReporte != null) {
										if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
											iterListaDiasMeses = listaDiasMeses.iterator();
											
											while(iterListaDiasMeses.hasNext()) {
												String tempMesAnio = (String)iterListaDiasMeses.next(); 
											
												String valor = (String)listaFormUsuarioReporte.get(String.valueOf(i) + tempMesAnio);
												listaDatos.add(valor != null ? valor : "");
												sumaValor +=  (valor != null ? 1 : 0);
											}
										}
									}
									reporteIngresoForm.setListaDatos(listaDatos);
									reporteIngresoForm.setTotal(String.valueOf(sumaValor));
									reporteIngresoForm.setFormato(2);
									
									listaRegistro.add(reporteIngresoForm);
								}
							}
						}
					}
					
					if(listaUsuario != null && listaUsuario.size() > 0) { 
						reporteIngreso = new ReporteIngreso();
						
						reporteIngreso.setCodUsuario("");
						reporteIngreso.setCargo("");
						reporteIngreso.setNomTerritorio("");
						reporteIngreso.setDescOficina("");
						reporteIngreso.setEtiquetaFechas("");
						listaDatos = new ArrayList();
						reporteIngreso.setListaDatos(listaDatos);
						reporteIngreso.setTotal("");
						reporteIngreso.setFormato(3);
						
						listaRegistro.add(reporteIngreso);
					}
				}
			}	
			
			log.info("[SesionIngresosBean :: reportexOficina] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: reportexOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaRegistro;
	}
	
	public Vector reportexOficinaxAnio(int anio, String codTerritorio) {
		Vector listaRegistro = new Vector(0, 1);
		ArrayList listaOficina = null;
		ArrayList listaUsuario = null;
		ReporteIngreso reporteIngreso = null;
		ReporteIngreso reporteIngresoForm = null;
		ArrayList listaDiasMeses = null; 
		ArrayList listaDatos = null;
		HashMap listaIngresosUsuario = null;
		HashMap listaIngresosAbrevUsuario = null;
		HashMap listaIngresosAbrevOficina = null;
		HashMap listaFormUsuarioReporte = null;
		HashMap listaFormUsuarioAbrevReporte = null;
		HashMap listaFormUsuarioAbrevReporteOficina = null;
		ArrayList mesAnio = null; 
		Iterator iterListaOficina = null;
		Iterator iterListaUsuario = null;
		Iterator iterMesAnio = null;
		Iterator iterListaDiasMeses = null;
		StringBuffer listaCodUsuario = null; 
		StringBuffer listaCodOficina = null;
		int sumaValor = 0;
		
		try {
			log.info("[SesionIngresosBean :: reportexOficinaxAnio] Inicio");
			
			mesAnio = listarFormatMesAnioxAnio(anio);
			
			listaDiasMeses = listarDiasMesesxAnio(anio);
			
			if(listaDiasMeses == null || listaDiasMeses.size() == 0) {
				log.info("[SesionIngresosBean :: reportexOficinaxAnio] Fin");
				
				return listaRegistro;
			}
			
			listaOficina = listadoOficinaReportexAnio(mesAnio, codTerritorio);
			if(listaOficina != null && listaOficina.size() > 0) {
				listaCodOficina = new StringBuffer();
				
				iterListaOficina = listaOficina.iterator();
				
				// lista los codigos del objetivo
				while(iterListaOficina.hasNext()) {
					String codOficina  = (String)iterListaOficina.next();
					
					listaCodOficina.append("'");
					listaCodOficina.append(codOficina);
					listaCodOficina.append("'");
					listaCodOficina.append(",");
				}
				
				listaCodOficina.deleteCharAt(listaCodOficina.length() - 1);
				
				iterListaOficina = listaOficina.iterator();
				
				listaIngresosAbrevOficina = listadoIngresosUsuarioxOficinaxAnioReporte(listaCodOficina.toString(), mesAnio);
				listaFormUsuarioAbrevReporteOficina = listadoFormUsuarioxOficinaxAnioAbrevReporte(listaCodOficina.toString(), mesAnio, anio);
				
				while(iterListaOficina.hasNext()) {
					String codOficina = (String)iterListaOficina.next();
					
					listaUsuario = listadoUsuarioxOficinaxAnioAbrevReporte(mesAnio, codOficina, codTerritorio);
					
					if(listaUsuario != null && listaUsuario.size() > 0) {
						
						if(listaIngresosAbrevOficina != null) {
							listaIngresosAbrevUsuario = (HashMap)listaIngresosAbrevOficina.get(codOficina);
						} else {
							listaIngresosAbrevUsuario = null;
						}
						
						if(listaFormUsuarioAbrevReporteOficina != null) {
							listaFormUsuarioAbrevReporte = (HashMap)listaFormUsuarioAbrevReporteOficina.get(codOficina);
						} else {
							listaFormUsuarioAbrevReporte = null;
						}
						
						iterListaUsuario = listaUsuario.iterator();
						
						while(iterListaUsuario.hasNext()) {
							reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
							
							// ingresos				
							listaIngresosUsuario = (HashMap)listaIngresosAbrevUsuario.get(reporteIngreso.getCodUsuario());
							listaDatos = new ArrayList();
							sumaValor = 0;
							if(listaIngresosUsuario != null) {
								if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
									iterListaDiasMeses = listaDiasMeses.iterator(); 
									
									while(iterListaDiasMeses.hasNext()) {
										String tempMesAnio = (String) iterListaDiasMeses.next();							
										String valor = (String)listaIngresosUsuario.get(tempMesAnio);
										
										listaDatos.add(valor != null ? valor : "");
										sumaValor +=  (valor != null ? Integer.parseInt(valor) : 0);
									}
								}
							}
							reporteIngreso.setEtiquetaFechas("N" + (char) 176 + " Ingresos");
							reporteIngreso.setListaDatos(listaDatos);
							reporteIngreso.setFormato(1);
							reporteIngreso.setTotal(String.valueOf(sumaValor));
							listaRegistro.add(reporteIngreso);
							
							// fechas
							if(listaFormUsuarioAbrevReporte != null) {
								listaFormUsuarioReporte = (HashMap)listaFormUsuarioAbrevReporte.get(reporteIngreso.getCodUsuario());
								for(int i = 1; i <= 5; i++) {
									String etiqueta = "";
									//	datos generales
									reporteIngresoForm = new ReporteIngreso();
									reporteIngresoForm.setCodUsuario(reporteIngreso.getCodUsuario());
									reporteIngresoForm.setNombres(reporteIngreso.getNombres());
									reporteIngresoForm.setCargo(reporteIngreso.getCargo());
									reporteIngresoForm.setNomTerritorio(reporteIngreso.getNomTerritorio());
									reporteIngresoForm.setCodOficina(reporteIngreso.getCodOficina());
									reporteIngresoForm.setDescOficina(reporteIngreso.getDescOficina());
									
									switch(i) {
										case 1: 	etiqueta = "Prioridad";
													break;
										case 2: 	etiqueta = "Objetivos";
													break;
										case 3: 	etiqueta = "Acciones";
													break;
										case 4: 	etiqueta = "Seguimiento 1";
													break;
										case 5: 	etiqueta = "Cierre";
													break;
									}
									
									reporteIngresoForm.setEtiquetaFechas(etiqueta);
									listaDatos = new ArrayList();
									sumaValor = 0;
									
									if(listaFormUsuarioReporte != null) {
										if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
											iterListaDiasMeses = listaDiasMeses.iterator();
											
											while(iterListaDiasMeses.hasNext()) {
												String tempMesAnio = (String)iterListaDiasMeses.next(); 
											
												String valor = (String)listaFormUsuarioReporte.get(String.valueOf(i) + tempMesAnio);
												listaDatos.add(valor != null ? valor : "");
												sumaValor +=  (valor != null ? 1 : 0);
											}
										}
									}
									reporteIngresoForm.setListaDatos(listaDatos);
									reporteIngresoForm.setTotal(String.valueOf(sumaValor));
									reporteIngresoForm.setFormato(2);
									
									listaRegistro.add(reporteIngresoForm);
								}
							}
							
							
						}
					}
				
					reporteIngreso = new ReporteIngreso();
					reporteIngreso.setCodUsuario("");
					reporteIngreso.setCargo("");
					reporteIngreso.setNomTerritorio("");
					reporteIngreso.setDescOficina("");
					reporteIngreso.setEtiquetaFechas("");
					listaDatos = new ArrayList();
					reporteIngreso.setListaDatos(listaDatos);
					reporteIngreso.setTotal("");
					reporteIngreso.setFormato(3);
					listaRegistro.add(reporteIngreso);
				}
			}
			
			log.info("[SesionIngresosBean :: reportexOficinaxAnio] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: reportexOficinaxAnio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaRegistro;
	}
	
	public Vector reportexTerritorio(int dia, int mes, int anio, String codTerritorio) {
		Vector listaRegistro = new Vector(0, 1);
		ArrayList listaTerritorio = null;
		ArrayList listaUsuario = null;
		ReporteIngreso reporteIngreso = null;
		ReporteIngreso reporteIngresoForm = null;
		ArrayList listaDiasMeses = null; 
		ArrayList listaDatos = null;
		HashMap listaIngresosUsuario = null;
		HashMap listaIngresosAbrevUsuario = null;
		HashMap listaIngresosAbrevTerritorio = null;
		HashMap listaFormUsuarioReporte = null;
		HashMap listaFormUsuarioAbrevReporte = null;
		HashMap listaFormUsuarioAbrevReporteTerritorio = null;
		String mesAnio[] = null; 
		Iterator iterListaTerritorio = null;
		Iterator iterListaUsuario = null;
		Iterator iterListaDiasMeses = null;
		StringBuffer listaCodUsuario = null; 
		StringBuffer listaCodTerritorio = null;
		int sumaValor = 0;
		
		try {
			log.info("[SesionIngresosBean :: reportexTerritorio] Inicio");
			
			mesAnio = ConstantesUtil.formatMesAnioText(mes, anio);
			
			listaDiasMeses = ConstantesUtil.diasMesesReporte(mes, anio);
			
			if(listaDiasMeses == null || listaDiasMeses.size() == 0) {
				log.info("[SesionIngresosBean :: reportexTerritorio] Fin");
				
				return listaRegistro;
			}
			
			listaTerritorio = listadoTerritorioReporte(mesAnio, codTerritorio);
			
			if(listaTerritorio != null && listaTerritorio.size() > 0) {
				listaCodTerritorio = new StringBuffer();
				
				iterListaTerritorio = listaTerritorio.iterator();
				
				//	lista los codigos del objetivo
				while(iterListaTerritorio.hasNext()) {
					String codTerr  = (String)iterListaTerritorio.next();
					
					listaCodTerritorio.append("'");
					listaCodTerritorio.append(codTerr);
					listaCodTerritorio.append("'");
					listaCodTerritorio.append(",");
				}
				
				listaCodTerritorio.deleteCharAt(listaCodTerritorio.length() - 1);
				
				iterListaTerritorio = listaTerritorio.iterator();
				
				listaIngresosAbrevTerritorio = listadoIngresosUsuarioxTerritorioReporte(listaCodTerritorio.toString(), mesAnio);
				listaFormUsuarioAbrevReporteTerritorio = listadoFormUsuarioxTerritorioAbrevReporte(listaCodTerritorio.toString(), mesAnio, mes, anio);
				
				while(iterListaTerritorio.hasNext()) {
					String codTerr = (String)iterListaTerritorio.next();

					listaUsuario = listadoUsuarioxTerritorioAbrevReporte(mesAnio, codTerr, codTerritorio);
					
					if(listaUsuario != null && listaUsuario.size() > 0) {
						if(listaIngresosAbrevTerritorio != null) {
							listaIngresosAbrevUsuario = (HashMap)listaIngresosAbrevTerritorio.get(codTerr);
						} else {
							listaIngresosAbrevUsuario = null;
						}
						
						if(listaFormUsuarioAbrevReporteTerritorio != null) {
							listaFormUsuarioAbrevReporte = (HashMap)listaFormUsuarioAbrevReporteTerritorio.get(codTerr);
						} else {
							listaFormUsuarioAbrevReporte = null;
						}
						
						iterListaUsuario = listaUsuario.iterator();
					
						while(iterListaUsuario.hasNext() && listaIngresosAbrevUsuario != null ) {
							reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
							
							// ingresos				
							listaIngresosUsuario = (HashMap)listaIngresosAbrevUsuario.get(reporteIngreso.getCodUsuario());
							listaDatos = new ArrayList();
							sumaValor = 0;
							if(listaIngresosUsuario != null) {
								if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
									iterListaDiasMeses = listaDiasMeses.iterator(); 
									
									while(iterListaDiasMeses.hasNext()) {
										String tempMesAnio = (String) iterListaDiasMeses.next();							
										String valor = (String)listaIngresosUsuario.get(tempMesAnio);
										
										listaDatos.add(valor != null ? valor : "");
										sumaValor +=  (valor != null ? Integer.parseInt(valor) : 0);
									}
								}
							}
							reporteIngreso.setEtiquetaFechas("N" + (char) 176 + " Ingresos");
							reporteIngreso.setListaDatos(listaDatos);
							reporteIngreso.setFormato(1);
							reporteIngreso.setTotal(String.valueOf(sumaValor));
							listaRegistro.add(reporteIngreso);
							
							// fechas
							if(listaFormUsuarioAbrevReporte != null) {
								listaFormUsuarioReporte = (HashMap)listaFormUsuarioAbrevReporte.get(reporteIngreso.getCodUsuario());
								for(int i = 1; i <= 5; i++) {
									String etiqueta = "";
									//	datos generales
									reporteIngresoForm = new ReporteIngreso();
									reporteIngresoForm.setCodUsuario(reporteIngreso.getCodUsuario());
									reporteIngresoForm.setNombres(reporteIngreso.getNombres());
									reporteIngresoForm.setCargo(reporteIngreso.getCargo());
									reporteIngresoForm.setNomTerritorio(reporteIngreso.getNomTerritorio());
									reporteIngresoForm.setCodOficina(reporteIngreso.getCodOficina());
									reporteIngresoForm.setDescOficina(reporteIngreso.getDescOficina());
									
									switch(i) {
										case 1: 	etiqueta = "Prioridad";
													break;
										case 2: 	etiqueta = "Objetivos";
													break;
										case 3: 	etiqueta = "Acciones";
													break;
										case 4: 	etiqueta = "Seguimiento 1";
													break;
										case 5: 	etiqueta = "Cierre";
													break;
									}
									
									reporteIngresoForm.setEtiquetaFechas(etiqueta);
									listaDatos = new ArrayList();
									sumaValor = 0;
									
									if(listaFormUsuarioReporte != null) {
										if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
											iterListaDiasMeses = listaDiasMeses.iterator();
											
											while(iterListaDiasMeses.hasNext()) {
												String tempMesAnio = (String)iterListaDiasMeses.next(); 
											
												String valor = (String)listaFormUsuarioReporte.get(String.valueOf(i) + tempMesAnio);
												listaDatos.add(valor != null ? valor : "");
												sumaValor +=  (valor != null ? 1 : 0);
											}
										}
									}
									reporteIngresoForm.setListaDatos(listaDatos);
									reporteIngresoForm.setTotal(String.valueOf(sumaValor));
									reporteIngresoForm.setFormato(2);
									
									listaRegistro.add(reporteIngresoForm);
								}
							}
						}
					}
					
					if(listaUsuario != null && listaUsuario.size() > 0) {
						reporteIngreso = new ReporteIngreso();
						reporteIngreso.setCodUsuario("");
						reporteIngreso.setCargo("");
						reporteIngreso.setNomTerritorio("");
						reporteIngreso.setDescOficina("");
						reporteIngreso.setEtiquetaFechas("");
						listaDatos = new ArrayList();
						reporteIngreso.setListaDatos(listaDatos);
						reporteIngreso.setTotal("");
						reporteIngreso.setFormato(3);
						listaRegistro.add(reporteIngreso);
					}
				}
			}
			
			log.info("[SesionIngresosBean :: reportexTerritorio] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: reportexTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaRegistro;
	}
	
	public Vector reportexTerritorioxAnio(int anio, String codTerritorio) {
		Vector listaRegistro = new Vector(0, 1);
		ArrayList listaTerritorio = null;
		ArrayList listaUsuario = null;
		ReporteIngreso reporteIngreso = null;
		ReporteIngreso reporteIngresoForm = null;
		ArrayList listaDiasMeses = null; 
		ArrayList listaDatos = null;
		HashMap listaIngresosUsuario = null;
		HashMap listaIngresosAbrevUsuario = null;
		HashMap listaIngresosAbrevTerritorio = null;
		HashMap listaFormUsuarioReporte = null;
		HashMap listaFormUsuarioAbrevReporte = null;
		HashMap listaFormUsuarioAbrevReporteTerritorio = null;
		Iterator iterListaTerritorio = null;
		Iterator iterListaUsuario = null;
		Iterator iterListaDiasMeses = null;
		StringBuffer listaCodUsuario = null; 
		StringBuffer listaCodTerritorio = null;
		int sumaValor = 0;
		ArrayList mesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: reportexTerritorioxAnio] Inicio");
			
			mesAnio = listarFormatMesAnioxAnio(anio);
			listaDiasMeses = listarDiasMesesxAnio(anio);
			
			if(listaDiasMeses == null || listaDiasMeses.size() == 0) {
				log.info("[SesionIngresosBean :: reportexTerritorioxAnio] Fin");
				
				return listaRegistro;
			}
			
			listaTerritorio = listadoTerritorioReportexAnio(mesAnio, codTerritorio);
			
			if(listaTerritorio != null && listaTerritorio.size() > 0) {
				listaCodTerritorio = new StringBuffer();
				
				iterListaTerritorio = listaTerritorio.iterator();
				
				//	lista los codigos del objetivo
				while(iterListaTerritorio.hasNext()) {
					String codTerr  = (String)iterListaTerritorio.next();
					
					listaCodTerritorio.append("'");
					listaCodTerritorio.append(codTerr);
					listaCodTerritorio.append("'");
					listaCodTerritorio.append(",");
				}
				
				listaCodTerritorio.deleteCharAt(listaCodTerritorio.length() - 1);
				
				iterListaTerritorio = listaTerritorio.iterator();
				
				listaIngresosAbrevTerritorio = listadoIngresosUsuarioxTerritorioxAnioReporte(listaCodTerritorio.toString(), mesAnio);
				listaFormUsuarioAbrevReporteTerritorio = listadoFormUsuarioxTerritorioxAnioAbrevReporte(listaCodTerritorio.toString(), mesAnio, anio);
				
				while(iterListaTerritorio.hasNext()) {
					String codTerr = (String)iterListaTerritorio.next();

					listaUsuario = listadoUsuarioxTerritorioxAnioAbrevReporte(mesAnio, codTerr, codTerritorio);
					
					if(listaUsuario != null && listaUsuario.size() > 0) {
						
						if(listaIngresosAbrevTerritorio != null) {
							listaIngresosAbrevUsuario = (HashMap)listaIngresosAbrevTerritorio.get(codTerr);
						} else {
							listaIngresosAbrevUsuario = null;
						}
						
						if(listaFormUsuarioAbrevReporteTerritorio != null) {
							listaFormUsuarioAbrevReporte = (HashMap)listaFormUsuarioAbrevReporteTerritorio.get(codTerr);
						} else {
							listaFormUsuarioAbrevReporte = null;
						}
						
						iterListaUsuario = listaUsuario.iterator();
					
						while(iterListaUsuario.hasNext() && listaIngresosAbrevUsuario != null) {
							reporteIngreso = (ReporteIngreso)iterListaUsuario.next();
							
							// ingresos				
							listaIngresosUsuario = (HashMap)listaIngresosAbrevUsuario.get(reporteIngreso.getCodUsuario());
							listaDatos = new ArrayList();
							sumaValor = 0;
							if(listaIngresosUsuario != null) {
								if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
									iterListaDiasMeses = listaDiasMeses.iterator(); 
									
									while(iterListaDiasMeses.hasNext()) {
										String tempMesAnio = (String) iterListaDiasMeses.next();							
										String valor = (String)listaIngresosUsuario.get(tempMesAnio);
										
										listaDatos.add(valor != null ? valor : "");
										sumaValor +=  (valor != null ? Integer.parseInt(valor) : 0);
									}
								}
							}
							reporteIngreso.setEtiquetaFechas("N" + (char) 176 + " Ingresos");
							reporteIngreso.setListaDatos(listaDatos);
							reporteIngreso.setFormato(1);
							reporteIngreso.setTotal(String.valueOf(sumaValor));
							listaRegistro.add(reporteIngreso);
							
							// fechas
							if(listaFormUsuarioAbrevReporte != null) {
								listaFormUsuarioReporte = (HashMap)listaFormUsuarioAbrevReporte.get(reporteIngreso.getCodUsuario());
								for(int i = 1; i <= 5; i++) {
									String etiqueta = "";
									//	datos generales
									reporteIngresoForm = new ReporteIngreso();
									reporteIngresoForm.setCodUsuario(reporteIngreso.getCodUsuario());
									reporteIngresoForm.setNombres(reporteIngreso.getNombres());
									reporteIngresoForm.setCargo(reporteIngreso.getCargo());
									reporteIngresoForm.setNomTerritorio(reporteIngreso.getNomTerritorio());
									reporteIngresoForm.setCodOficina(reporteIngreso.getCodOficina());
									reporteIngresoForm.setDescOficina(reporteIngreso.getDescOficina());
									
									switch(i) {
										case 1: 	etiqueta = "Prioridad";
													break;
										case 2: 	etiqueta = "Objetivos";
													break;
										case 3: 	etiqueta = "Acciones";
													break;
										case 4: 	etiqueta = "Seguimiento 1";
													break;
										case 5: 	etiqueta = "Cierre";
													break;
									}
									
									reporteIngresoForm.setEtiquetaFechas(etiqueta);
									listaDatos = new ArrayList();
									sumaValor = 0;
									
									if(listaFormUsuarioReporte != null) {
										if(listaDiasMeses != null && listaDiasMeses.size() > 0) {
											iterListaDiasMeses = listaDiasMeses.iterator();
											
											while(iterListaDiasMeses.hasNext()) {
												String tempMesAnio = (String)iterListaDiasMeses.next(); 
											
												String valor = (String)listaFormUsuarioReporte.get(String.valueOf(i) + tempMesAnio);
												listaDatos.add(valor != null ? valor : "");
												sumaValor +=  (valor != null ? 1 : 0);
											}
										}
									}
									reporteIngresoForm.setListaDatos(listaDatos);
									reporteIngresoForm.setTotal(String.valueOf(sumaValor));
									reporteIngresoForm.setFormato(2);
									
									listaRegistro.add(reporteIngresoForm);
								}
							}
						}
					}
					
					if(listaUsuario != null && listaUsuario.size() > 0) {
						reporteIngreso = new ReporteIngreso();
						reporteIngreso.setCodUsuario("");
						reporteIngreso.setCargo("");
						reporteIngreso.setNomTerritorio("");
						reporteIngreso.setDescOficina("");
						reporteIngreso.setEtiquetaFechas("");
						listaDatos = new ArrayList();
						reporteIngreso.setListaDatos(listaDatos);
						reporteIngreso.setTotal("");
						reporteIngreso.setFormato(3);
						listaRegistro.add(reporteIngreso);
					}
				}
			}
			
			log.info("[SesionIngresosBean :: reportexTerritorioxAnio] Fin");
		} catch(Exception e) {
			log.error("[SesionIngresosBean :: reportexTerritorioxAnio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaRegistro;
	}
	
	public ArrayList listadoUsuarioReporte(String[] mesAnio, String codTerritorio) {
		ArrayList listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String where = "";
		String condTerritorio = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioReporte] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			where = "WHERE 	(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
						"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') ";
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT cod_usuario " +
					"FROM tiido_ingresos " +
					where + condTerritorio +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoUsuarioReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaUsuario.add(rst.getString("cod_usuario"));
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioReporte] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioAbrevReporte(String[] mesAnio, String codTerritorio) {
		ArrayList listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condFecha = null;
		String condTerritorio = "";
		ReporteIngreso reporteIngreso = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioAbrevReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioAbrevReporte] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			condFecha = " AND (TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
						"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') ";
			
			s = con.createStatement();
			sql = 	"SELECT t.cod_usuario, t.nombres nombres, t.cargo cargo, " +   
		       		"(SELECT r.nom_terr FROM tiido_oficina x, tiido_territorio r WHERE x.cod_terr = r.cod_terr AND x.cod_ofic = t.cod_oficina) territorio, " + 
					"t.cod_oficina cod_ofi, " + 
					"(SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = t.cod_oficina) desc_ofi, " + 
					"(SELECT x.cod_terr FROM tiido_oficina x WHERE x.cod_ofic = t.cod_oficina) cod_terr " +
					"FROM tiido_ingresos t " +
					"WHERE t.id_ingresos IN ( " +
		            "             SELECT MAX(a.id_ingresos) " +
		            "             FROM tiido_ingresos a " +
		            "             WHERE a.cod_usuario = t.cod_usuario " + condFecha + ")" +		                              
		            "          " +  condFecha + condTerritorio + 
					"ORDER BY 1 ASC";
				
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				reporteIngreso = new ReporteIngreso();
				
				reporteIngreso.setCodUsuario(rst.getString("cod_usuario"));
				reporteIngreso.setNombres(rst.getString("nombres"));
				reporteIngreso.setCargo(rst.getString("cargo"));
				reporteIngreso.setNomTerritorio(rst.getString("territorio"));
				reporteIngreso.setCodOficina(rst.getString("cod_ofi"));
				reporteIngreso.setDescOficina(rst.getString("desc_ofi"));
				reporteIngreso.setCodTerritorio(rst.getString("cod_terr"));
				
				listaUsuario.add(reporteIngreso);
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioAbrevReportexAnio(ArrayList mesAnio, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condTerritorio = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
		ReporteIngreso reporteIngreso = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
				
				return null;
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				if(codTerritorio != null) {
					condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
				}
			} else {
				if(codTerritorio != null) {
					condTerritorio = " cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
				}
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = "( ";
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next();
				
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
			} 
			
			s = con.createStatement();
			sql = 	"SELECT t.cod_usuario, t.nombres nombres, t.cargo cargo, " +   
       		"(SELECT r.nom_terr FROM tiido_oficina x, tiido_territorio r WHERE x.cod_terr = r.cod_terr AND x.cod_ofic = t.cod_oficina) territorio, " + 
			"t.cod_oficina cod_ofi, " + 
			"(SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = t.cod_oficina) desc_ofi, " + 
			"(SELECT x.cod_terr FROM tiido_oficina x WHERE x.cod_ofic = t.cod_oficina) cod_terr " +
			"FROM tiido_ingresos t " +
			"WHERE t.id_ingresos IN ( " +
            "             SELECT MAX(a.id_ingresos) " +
            "             FROM tiido_ingresos a " +
            "             WHERE a.cod_usuario = t.cod_usuario AND " + condMesAnio + ")" +		                              
            "          AND " +  condMesAnio + condTerritorio + 
			"ORDER BY 1 ASC";
				
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				reporteIngreso = new ReporteIngreso();
				
				reporteIngreso.setCodUsuario(rst.getString("cod_usuario"));
				reporteIngreso.setNombres(rst.getString("nombres"));
				reporteIngreso.setCargo(rst.getString("cargo"));
				reporteIngreso.setNomTerritorio(rst.getString("territorio"));
				reporteIngreso.setCodOficina(rst.getString("cod_ofi"));
				reporteIngreso.setDescOficina(rst.getString("desc_ofi"));
				reporteIngreso.setCodTerritorio(rst.getString("cod_terr"));
				
				listaUsuario.add(reporteIngreso);
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioAbrevReportexAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioxOficinaAbrevReporte(String[] mesAnio, String codOficina, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condFecha = null;
		String condOficina = "";
		String condTerritorio = "";
		ReporteIngreso reporteIngreso = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			condOficina = " AND cod_oficina = '" + codOficina  + "'";
			
			condFecha = " AND (TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
					"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') ";
			
			s = con.createStatement();
			sql = 	"SELECT t.cod_usuario, t.nombres nombres, t.cargo cargo, " +   
       		"(SELECT r.nom_terr FROM tiido_oficina x, tiido_territorio r WHERE x.cod_terr = r.cod_terr AND x.cod_ofic = t.cod_oficina) territorio, " + 
			"t.cod_oficina cod_ofi, " + 
			"(SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = t.cod_oficina) desc_ofi, " + 
			"(SELECT x.cod_terr FROM tiido_oficina x WHERE x.cod_ofic = t.cod_oficina) cod_terr " +
			"FROM tiido_ingresos t " +
			"WHERE t.id_ingresos IN ( " +
            "             SELECT MAX(a.id_ingresos) " +
            "             FROM tiido_ingresos a " +
            "             WHERE a.cod_usuario = t.cod_usuario " +  condFecha + condOficina + condTerritorio + ") " +		                              
            "          " +  condFecha + condOficina + condTerritorio + 
			"ORDER BY 1 ASC";
				
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				reporteIngreso = new ReporteIngreso();
				
				reporteIngreso.setCodUsuario(rst.getString("cod_usuario"));
				reporteIngreso.setNombres(rst.getString("nombres"));
				reporteIngreso.setCargo(rst.getString("cargo"));
				reporteIngreso.setNomTerritorio(rst.getString("territorio"));
				reporteIngreso.setCodOficina(rst.getString("cod_ofi"));
				reporteIngreso.setDescOficina(rst.getString("desc_ofi"));
				reporteIngreso.setCodTerritorio(rst.getString("cod_terr"));
				
				listaUsuario.add(reporteIngreso);
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioxOficinaAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioxTerritorioAbrevReporte(String[] mesAnio, String nomTerritorioFiltro, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condFecha = null;
		String condOficina = "";
		String condTerritorio = "";
		String condTerritorio2 = "";
		ReporteIngreso reporteIngreso = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = " AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			condTerritorio2 = " AND nom_territorio = '" + nomTerritorioFiltro + "'	 ";
			
			condFecha = " AND (TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
					"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') ";
			
			s = con.createStatement();
			sql = 	"SELECT t.cod_usuario, t.nombres nombres, t.cargo cargo, " +   
       		"(SELECT r.nom_terr FROM tiido_oficina x, tiido_territorio r WHERE x.cod_terr = r.cod_terr AND x.cod_ofic = t.cod_oficina) territorio, " + 
			"t.cod_oficina cod_ofi, " + 
			"(SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = t.cod_oficina) desc_ofi, " + 
			"(SELECT x.cod_terr FROM tiido_oficina x WHERE x.cod_ofic = t.cod_oficina) cod_terr " +
			"FROM tiido_ingresos t " +
			"WHERE t.id_ingresos IN ( " +
            "             SELECT MAX(a.id_ingresos) " +
            "             FROM tiido_ingresos a " +
            "             WHERE a.cod_usuario = t.cod_usuario " +  condFecha + condTerritorio2 + condTerritorio + ") " +		                              
            "          " +  condFecha + condTerritorio2 + condTerritorio + 
			"ORDER BY 1 ASC";
				
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				reporteIngreso = new ReporteIngreso();
				
				reporteIngreso.setCodUsuario(rst.getString("cod_usuario"));
				reporteIngreso.setNombres(rst.getString("nombres"));
				reporteIngreso.setCargo(rst.getString("cargo"));
				reporteIngreso.setNomTerritorio(rst.getString("territorio"));
				reporteIngreso.setCodOficina(rst.getString("cod_ofi"));
				reporteIngreso.setDescOficina(rst.getString("desc_ofi"));
				reporteIngreso.setCodTerritorio(rst.getString("cod_terr"));
				
				listaUsuario.add(reporteIngreso);
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioxTerritorioxAnioAbrevReporte(ArrayList listaAnio, String nomTerritorioFiltro, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condFecha = null;
		String condOficina = "";
		String condTerritorio = "";
		String condTerritorio2 = "";
		ReporteIngreso reporteIngreso = null;
		Iterator iterMesAnio = null;
		String condMesAnio = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] Fin");
				
				return null;
			}
			
			if(listaAnio != null && listaAnio.size() > 0) {
			
				if(codTerritorio != null) {
					condTerritorio = " AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
				}
				
				condTerritorio2 = " AND nom_territorio = '" + nomTerritorioFiltro + "'	 ";
				
				iterMesAnio = listaAnio.iterator();
				condMesAnio = " ( ";
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";
				
				s = con.createStatement();
				sql = 	"SELECT t.cod_usuario, t.nombres nombres, t.cargo cargo, " +   
	       		"(SELECT r.nom_terr FROM tiido_oficina x, tiido_territorio r WHERE x.cod_terr = r.cod_terr AND x.cod_ofic = t.cod_oficina) territorio, " + 
				"t.cod_oficina cod_ofi, " + 
				"(SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = t.cod_oficina) desc_ofi, " + 
				"(SELECT x.cod_terr FROM tiido_oficina x WHERE x.cod_ofic = t.cod_oficina) cod_terr " +
				"FROM tiido_ingresos t " +
				"WHERE t.id_ingresos IN ( " +
	            "             SELECT MAX(a.id_ingresos) " +
	            "             FROM tiido_ingresos a " +
	            "             WHERE a.cod_usuario = t.cod_usuario AND " +  condMesAnio + condTerritorio2 + condTerritorio + ") " +		                              
	            "        AND  " +  condMesAnio + condTerritorio2 + condTerritorio + 
				"ORDER BY 1 ASC";
					
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					reporteIngreso = new ReporteIngreso();
					
					reporteIngreso.setCodUsuario(rst.getString("cod_usuario"));
					reporteIngreso.setNombres(rst.getString("nombres"));
					reporteIngreso.setCargo(rst.getString("cargo"));
					reporteIngreso.setNomTerritorio(rst.getString("territorio"));
					reporteIngreso.setCodOficina(rst.getString("cod_ofi"));
					reporteIngreso.setDescOficina(rst.getString("desc_ofi"));
					reporteIngreso.setCodTerritorio(rst.getString("cod_terr"));
					
					listaUsuario.add(reporteIngreso);
				}
			}	
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioxAnioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioxOficinaxAnioAbrevReporte(ArrayList mesAnio, String codOficina, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condMesAnio = "";
		String condOficina = "";
		String condTerritorio = "";
		ReporteIngreso reporteIngreso = null;
		Iterator iterMesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] Fin");
				
				return null;
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
			
				if(codTerritorio != null) {
					condTerritorio = " AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
				}
				
				condOficina = " AND cod_oficina = '" + codOficina  + "' ";
				
				iterMesAnio = mesAnio.iterator();
				condMesAnio = " ( ";
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
								
				s = con.createStatement();
				sql = 	"SELECT t.cod_usuario, t.nombres nombres, t.cargo cargo, " +   
	       		"(SELECT r.nom_terr FROM tiido_oficina x, tiido_territorio r WHERE x.cod_terr = r.cod_terr AND x.cod_ofic = t.cod_oficina) territorio, " + 
				"t.cod_oficina cod_ofi, " + 
				"(SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = t.cod_oficina) desc_ofi, " + 
				"(SELECT x.cod_terr FROM tiido_oficina x WHERE x.cod_ofic = t.cod_oficina) cod_terr " +
				"FROM tiido_ingresos t " +
				"WHERE t.id_ingresos IN ( " +
	            "             SELECT MAX(a.id_ingresos) " +
	            "             FROM tiido_ingresos a " +
	            "             WHERE a.cod_usuario = t.cod_usuario AND " +  condMesAnio + condOficina + condTerritorio + ") " +		                              
	            "          AND " +  condMesAnio + condOficina + condTerritorio + 
				"ORDER BY 1 ASC";
					
				log.info("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					reporteIngreso = new ReporteIngreso();
					
					reporteIngreso.setCodUsuario(rst.getString("cod_usuario"));
					reporteIngreso.setNombres(rst.getString("nombres"));
					reporteIngreso.setCargo(rst.getString("cargo"));
					reporteIngreso.setNomTerritorio(rst.getString("territorio"));
					reporteIngreso.setCodOficina(rst.getString("cod_ofi"));
					reporteIngreso.setDescOficina(rst.getString("desc_ofi"));
					reporteIngreso.setCodTerritorio(rst.getString("cod_terr"));
					
					listaUsuario.add(reporteIngreso);
				}
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioxOficinaxAnioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioxOficinaReportexAnio(ArrayList mesAnio, String codOficina, String codTerritorio) {
		ArrayList listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String where = "";
		String condOficina = "";
		String condTerritorio = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			condOficina = " AND cod_oficina = '" + codOficina  + "'";
			
			
			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = "( ";
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next();
				
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
			} 
			
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT cod_usuario " +
					"FROM tiido_ingresos " +
					"WHERE " + condMesAnio + condOficina + condTerritorio +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] SQL" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaUsuario.add(rst.getString("cod_usuario"));
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioxOficinaReportexAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoUsuarioxTerritorioReporte(String[] mesAnio, String codTerritorioFiltro, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		ArrayList  listaUsuarioFinal = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String where = "";
		String condTerritorio = "";
		String condTerritorio2 = "";
		Iterator iterListaUsuario = null;
		/*
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] DATASOURCE_CONTEXT:::" + 
					ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = " AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			condTerritorio2 = " AND EXISTS (SELECT o.cod_terr FROM tiido_oficina o WHERE o.cod_terr = '" + codTerritorioFiltro + "') ";
			
			if(mesAnio != null && mesAnio.length == 2) {
				// mes y anio
				where = "WHERE 	(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
						"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') ";
			} else {
				// dia
				if(mesAnio != null && mesAnio.length == 1) {
					// mes y anio
					where = "WHERE 	TO_CHAR(fecha, 'ddmmyyyy') = '" + mesAnio[0] + "' ";  
				}
			}
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT cod_usuario " +
					"FROM tiido_ingresos " +
					where + condTerritorio2 + condTerritorio +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaUsuario.add(rst.getString("cod_usuario"));
			}
			
			if(listaUsuario != null && listaUsuario.size() > 0) {
				iterListaUsuario = listaUsuario.iterator();
				
				while(iterListaUsuario.hasNext()) {
					String codUsuario = (String)iterListaUsuario.next();
					ReporteIngreso reporteIngreso = infoUsuarioReporte(codUsuario);
					
					if(	reporteIngreso.getCodTerritorio() != null &&
						reporteIngreso.getCodTerritorio().equals(codTerritorioFiltro)) {
						listaUsuarioFinal.add(codUsuario);
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		*/
		return listaUsuarioFinal;	
	}
	
	public ArrayList listadoUsuarioxTerritorioReportexAnio(ArrayList mesAnio, String codTerritorioFiltro, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		ArrayList  listaUsuarioFinal = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String where = "";
		String condTerritorio = "";
		String condTerritorio2 = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
		Iterator iterListaUsuario = null;
		/*
		try {
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = " AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			condTerritorio2 = " AND EXISTS (SELECT o.cod_terr FROM tiido_oficina o WHERE o.cod_terr = '" + codTerritorioFiltro + "') ";
			
			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = "( ";
				
				if(mesAnio != null && mesAnio.size() > 0) {
					iterMesAnio = mesAnio.iterator();
					
					while(iterMesAnio.hasNext()) {
						String valor = (String)iterMesAnio.next();
						
						condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
					}
					
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
			} 
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT cod_usuario " +
					"FROM tiido_ingresos " +
					"WHERE " + condMesAnio + condTerritorio2 + condTerritorio +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaUsuario.add(rst.getString("cod_usuario"));
			}
			
			if(listaUsuario != null && listaUsuario.size() > 0) {
				iterListaUsuario = listaUsuario.iterator();
				
				while(iterListaUsuario.hasNext()) {
					String codUsuario = (String)iterListaUsuario.next();
			
					ReporteIngreso reporteIngreso = infoUsuarioReporte(codUsuario);
					
					if(	reporteIngreso.getCodTerritorio() != null &&
						reporteIngreso.getCodTerritorio().equals(codTerritorioFiltro)) {
						listaUsuarioFinal.add(codUsuario);
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] ");
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
				log.error("[SesionIngresosBean :: listadoUsuarioxTerritorioReportexAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		*/
		return listaUsuarioFinal;	
	}
	
	public HashMap listadoIngresosUsuarioReporte(String listaCodUsuario, String[] mesAnio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
			
		try {
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioReporte] Fin");
				
				return null;
			}
			
			where = "WHERE 	(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
					"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') AND " + listaUsuariosFraccionada(listaCodUsuario) + " ";
			
			s = con.createStatement();
			sql = 	   	"SELECT cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') fecha, COUNT(*) num " + 
						"FROM tiido_ingresos t " +
						where + 
						"GROUP BY cod_usuario,TO_CHAR(fecha, 'ddmmyyyy') " +
						"ORDER BY 1, 2, 3";
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaUsuario = new HashMap();
			while (rst.next()) {
				String codUsuario = rst.getString("cod_usuario");
				
				if(listaUsuario.get(codUsuario) ==  null) {
					listaFechas = new HashMap();
					listaFechas.put(rst.getString("fecha"), rst.getString("num"));
					
					listaUsuario.put(codUsuario, listaFechas);
				} else {
					listaFechas = (HashMap)listaUsuario.get(codUsuario);
					listaFechas.put(rst.getString("fecha"), rst.getString("num"));
				}
			}
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoIngresosUsuarioReporte] ");
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
				log.error("[SesionIngresosBean :: listadoIngresosUsuarioReporte] ", e);
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public HashMap listadoIngresosUsuarioxOficinaReporte(String listaCodOficina, String[] mesAnio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaOficina = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
			
		try {
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaReporte] Fin");
				
				return null;
			}
			
			where = "WHERE 	(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
					"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') AND cod_oficina IN (" + listaCodOficina + ") ";
			
			s = con.createStatement();
			sql = 	   	"SELECT cod_oficina, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') fecha, COUNT(*) num " + 
						"FROM tiido_ingresos t " +
						where + 
						"GROUP BY cod_oficina, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') " +
						"ORDER BY 1, 2, 3, 4";
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaOficina = new HashMap();
			while (rst.next()) {
				String codOficina = rst.getString("cod_oficina");
				String codUsuario = rst.getString("cod_usuario");
				
				if(listaOficina.get(codOficina) ==  null) {
					listaUsuario = new HashMap();
					listaFechas = new HashMap();
					
					listaFechas.put(rst.getString("fecha"), rst.getString("num"));
					listaUsuario.put(codUsuario, listaFechas);
					listaOficina.put(codOficina, listaUsuario);
				} else {
					listaUsuario = (HashMap)listaOficina.get(codOficina);
							
					if(listaUsuario.get(codUsuario) ==  null) {
						listaFechas = new HashMap();
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
						
						listaUsuario.put(codUsuario, listaFechas);
					} else {
						listaFechas = (HashMap)listaUsuario.get(codUsuario);
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaReporte] ");
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
				log.error("SesionIngresosBean", e);
				return null;
			}
		}			
		
		return listaOficina;	
	}
	
	public HashMap listadoIngresosUsuarioxTerritorioReporte(String listaCodTerritorio, String[] mesAnio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaTerritorio = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
			
		try {
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioReporte] Fin");
				
				return null;
			}
			
			where = "WHERE 	(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
					"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') AND nom_territorio IN (" + listaCodTerritorio + ") ";
			
			s = con.createStatement();
			sql = 	   	"SELECT nom_territorio, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') fecha, COUNT(*) num " + 
						"FROM tiido_ingresos t " +
						where + 
						"GROUP BY nom_territorio, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') " +
						"ORDER BY 1, 2, 3, 4";
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaTerritorio = new HashMap();
			while (rst.next()) {
				String nomTerritorio = rst.getString("nom_territorio");
				String codUsuario = rst.getString("cod_usuario");
				
				if(listaTerritorio.get(nomTerritorio) ==  null) {
					listaUsuario = new HashMap();
					listaFechas = new HashMap();
					
					listaFechas.put(rst.getString("fecha"), rst.getString("num"));
					listaUsuario.put(codUsuario, listaFechas);
					listaTerritorio.put(nomTerritorio, listaUsuario);
				} else {
					listaUsuario = (HashMap)listaTerritorio.get(nomTerritorio);
							
					if(listaUsuario.get(codUsuario) ==  null) {
						listaFechas = new HashMap();
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
						
						listaUsuario.put(codUsuario, listaFechas);
					} else {
						listaFechas = (HashMap)listaUsuario.get(codUsuario);
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioReporte] ");
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
				log.error("listadoIngresosUsuarioxTerritorioReporte", e);
				return null;
			}
		}			
		
		return listaTerritorio;	
	}
	
	public HashMap listadoIngresosUsuarioxTerritorioxAnioReporte(String listaCodTerritorio, ArrayList listaAnio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaTerritorio = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		Iterator iterListaAnio = null;
		String condMesAnio = "";
			
		try {
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioxAnioReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioxAnioReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioxAnioReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioxAnioReporte] Fin");
				
				return null;
			}
			
			if(listaAnio != null && listaAnio.size() > 0) {
				iterListaAnio = listaAnio.iterator();
				
				condMesAnio = " ( ";
				while(iterListaAnio.hasNext()) {
					String valor = (String)iterListaAnio.next(); 
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") AND nom_territorio IN (" + listaCodTerritorio + ") ";			
				
				s = con.createStatement();
				sql = 	   	"SELECT nom_territorio, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') fecha, COUNT(*) num " + 
							"FROM tiido_ingresos t " +
							"WHERE " + condMesAnio +   
							"GROUP BY nom_territorio, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') " +
							"ORDER BY 1, 2, 3, 4";
				
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioxAnioReporte] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				listaTerritorio = new HashMap();
				while (rst.next()) {
					String nomTerritorio = rst.getString("nom_territorio");
					String codUsuario = rst.getString("cod_usuario");
					
					if(listaTerritorio.get(nomTerritorio) ==  null) {
						listaUsuario = new HashMap();
						listaFechas = new HashMap();
						
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
						listaUsuario.put(codUsuario, listaFechas);
						listaTerritorio.put(nomTerritorio, listaUsuario);
					} else {
						listaUsuario = (HashMap)listaTerritorio.get(nomTerritorio);
								
						if(listaUsuario.get(codUsuario) ==  null) {
							listaFechas = new HashMap();
							listaFechas.put(rst.getString("fecha"), rst.getString("num"));
							
							listaUsuario.put(codUsuario, listaFechas);
						} else {
							listaFechas = (HashMap)listaUsuario.get(codUsuario);
							listaFechas.put(rst.getString("fecha"), rst.getString("num"));
						}
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioxAnioReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoIngresosUsuarioxTerritorioxAnioReporte] ");
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
				e.printStackTrace();
				return null;
			}
		}			
		
		return listaTerritorio;	
	}
	
	public HashMap listadoIngresosUsuarioxOficinaxAnioReporte(String listaCodOficina, ArrayList mesAnio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaOficina = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		Iterator iterMesAnio = null;
		String condMesAnio = "";
			
		try {
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaxAnioReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaxAnioReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaxAnioReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaxAnioReporte] Fin");
				
				return null;
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				iterMesAnio = mesAnio.iterator();
				
				condMesAnio = " ( ";
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
				condMesAnio += "AND cod_oficina IN (" + listaCodOficina + ")  ";
				
				
				s = con.createStatement();
				sql = 	   	"SELECT cod_oficina, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') fecha, COUNT(*) num " + 
							"FROM tiido_ingresos t " +
							"WHERE " +  condMesAnio + 
							"GROUP BY cod_oficina, cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') " +
							"ORDER BY 1, 2, 3, 4";
				
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaxAnioReporte] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				listaOficina = new HashMap();
				while (rst.next()) {
					String codOficina = rst.getString("cod_oficina");
					String codUsuario = rst.getString("cod_usuario");
					
					if(listaOficina.get(codOficina) ==  null) {
						listaUsuario = new HashMap();
						listaFechas = new HashMap();
						
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
						listaUsuario.put(codUsuario, listaFechas);
						listaOficina.put(codOficina, listaUsuario);
					} else {
						listaUsuario = (HashMap)listaOficina.get(codOficina);
								
						if(listaUsuario.get(codUsuario) ==  null) {
							listaFechas = new HashMap();
							listaFechas.put(rst.getString("fecha"), rst.getString("num"));
							
							listaUsuario.put(codUsuario, listaFechas);
						} else {
							listaFechas = (HashMap)listaUsuario.get(codUsuario);
							listaFechas.put(rst.getString("fecha"), rst.getString("num"));
						}
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaxAnioReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoIngresosUsuarioxOficinaxAnioReporte] ");
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
				e.printStackTrace();
				return null;
			}
		}			
		
		return listaOficina;	
	}
	
	public HashMap listadoIngresosUsuarioReportexAnio(String listaCodUsuario, ArrayList mesAnio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
			
		try {
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] Fin");
				
				return null;
			}
			

			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = "WHERE ( ";
				
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
				condMesAnio += "AND " + listaUsuariosFraccionada(listaCodUsuario) + " ";
			 
				s = con.createStatement();
				sql = 	   	"SELECT cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') fecha, COUNT(*) num " + 
							"FROM tiido_ingresos t " +
							condMesAnio + 
							"GROUP BY cod_usuario, TO_CHAR(fecha, 'ddmmyyyy') " +
							"ORDER BY 1, 2, 3";
				
				log.info("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				listaUsuario  = new HashMap();
				while (rst.next()) {
					String codUsuario = rst.getString("cod_usuario");
					
					if(listaUsuario.get(codUsuario) ==  null) {
						listaFechas = new HashMap();
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
						
						listaUsuario.put(codUsuario, listaFechas);
					} else {
						listaFechas = (HashMap)listaUsuario.get(codUsuario);
						listaFechas.put(rst.getString("fecha"), rst.getString("num"));
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] ");
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
				log.error("[SesionIngresosBean :: listadoIngresosUsuarioReportexAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public HashMap listadoFormUsuarioAbrevReporte(String listaCodUsuario, String[] mesAnio, int mes, int anio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			sql = 	   	"SELECT  cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
						"FROM tiido_ingresos_form " +  
						"WHERE 	(TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
						"		TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[1] + "') AND " + listaUsuariosFraccionada(listaCodUsuario) + " " +
						" 		AND mes = " + mes + " AND  anio = " + anio + " " + 
						"ORDER BY 1, 2";
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaUsuario = new HashMap();
			while (rst.next()) {
				String codUsuario = rst.getString("cod_usuario");
				String editUsuario = rst.getString("edit_usuario");
				String marca = "";
				
				if(editUsuario != null && editUsuario.equals("1")) {
					marca = "*";
				}
				
				if(listaUsuario.get(codUsuario) ==  null) {
					listaFechas = new HashMap();
					listaFechas.put(rst.getString("fecha"), 
							"SI" + marca);
					
					listaUsuario.put(codUsuario, listaFechas);
				} else {
					listaFechas = (HashMap)listaUsuario.get(codUsuario);
					listaFechas.put(rst.getString("fecha"), 
							"SI" + marca);
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	private String listaUsuariosFraccionada(String listaCodUsuario) {
		StringBuffer res = new StringBuffer();
		String[] codigos = listaCodUsuario.split(",");
		boolean primero = false;
		for(int i=0; i<codigos.length; i++){
			if(i%1000==0){
				if(i>0)
					res.append(") or ");
				res.append(" cod_usuario in (");
				primero=true;
			}
			if(!primero)
				res.append(",");
			primero=false;
			res.append(codigos[i]);
		}
		res.insert(0, "(");
		res.append(") )");
		
		return res.toString();
	}
	
	public List<String> listarUsuarios(String[] mesAnio, String codTerritorio) {
		ArrayList listaUsuario = null;
		StringBuffer listaCodUsuario = null;
		Iterator iterListaUsuario = null;
		listaUsuario = listadoUsuarioAbrevReporte(mesAnio, codTerritorio);
		ReporteIngreso reporteIngreso = null;
		List result = new ArrayList<String>();
		int i = 0;
		if(listaUsuario != null && listaUsuario.size() > 0) {
			listaCodUsuario = new StringBuffer();
			iterListaUsuario = listaUsuario.iterator();
			
			// lista los codigos del usuario
			while(iterListaUsuario.hasNext()) {			
				reporteIngreso = (ReporteIngreso) iterListaUsuario.next();
				
				listaCodUsuario.append("'");
				listaCodUsuario.append(reporteIngreso.getCodUsuario());
				listaCodUsuario.append("'");
				listaCodUsuario.append(",");
				
				i++;
				
				if(i == 999) {
					listaCodUsuario.deleteCharAt(listaCodUsuario.length() - 1);
					result.add(listaCodUsuario.toString()); 
					listaCodUsuario = new StringBuffer();
					i=0;
				}
			}
			
			
		}
		return result;
	}

	public HashMap listadoFormUsuarioxOficinaAbrevReporte(String listaCodOficina, String[] mesAnio, int mes, int anio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaOficina = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] Fin");
				return null;
			}
			
			s = con.createStatement();
			
			//(2011.02.09) Correccion cruce de datos fecha en subconsulta
			
			sql = 	   	"SELECT	( SELECT i.cod_oficina FROM tiido_ingresos i " + 
						"	      WHERE i.cod_usuario = f.cod_usuario AND " +
						"		  		(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " + 
						"				TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') AND rownum <= 1 ) "  +
						"	      cod_oficina, " +
						"cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
						", cod_gestor_m, cod_oficina_m " +
						"FROM tiido_ingresos_form f " +  
						"WHERE 	(TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
						"		TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[1] + "') AND " +
						"		(  SELECT i.cod_oficina FROM tiido_ingresos i " +
						"			WHERE i.cod_usuario = f.cod_usuario AND " +
						"		  		(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " + 
						"				TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') AND rownum <= 1) "  + 
						" 		IN (" + listaCodOficina + ") " +  
						" 		AND mes = " + mes + " AND  anio = " + anio + " " + 
						"ORDER BY 1, 2, 3, 4";
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] SQL:" + sql);
			rst = s.executeQuery(sql);			
			
			listaOficina = new HashMap();
			while (rst.next()) {
				String codOficina = rst.getString("cod_oficina");
				String codUsuario = rst.getString("cod_usuario")+","+rst.getString("cod_gestor_m")+","+rst.getString("cod_oficina_m");
				String editUsuario = rst.getString("edit_usuario");
				String marca = "";
				
				if(editUsuario != null && editUsuario.equals("1")) {
					marca = "*";
				}
				
				if(listaOficina.get(codOficina) ==  null) {
					listaUsuario = new HashMap();
					listaFechas = new HashMap();
					
					listaFechas.put(rst.getString("fecha"), 
							"SI" + marca);
					listaUsuario.put(codUsuario, listaFechas);
					listaOficina.put(codOficina, listaUsuario);
				} else {
					listaUsuario = (HashMap)listaOficina.get(codOficina);
							
					if(listaUsuario.get(codUsuario) ==  null) {
						listaFechas = new HashMap();
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
						
						listaUsuario.put(codUsuario, listaFechas);
					} else {
						listaFechas = (HashMap)listaUsuario.get(codUsuario);
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioxOficinaAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaOficina;	
	}
	
	public HashMap listadoFormUsuarioxTerritorioAbrevReporte(String listaCodTerritorio, String[] mesAnio, int mes, int anio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaTerritorio = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			//(2011.02.09) Correccion cruce de datos fecha en subconsulta
			sql = 	   	"SELECT	( SELECT i.nom_territorio FROM tiido_ingresos i " + 
						"	      WHERE i.cod_usuario = f.cod_usuario AND " +
						"		  		(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " + 
						"				TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') AND rownum <= 1 ) "  +
						"	      nom_territorio, " +
						"cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
						"FROM tiido_ingresos_form f " +  
						"WHERE 	(TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
						"		TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[1] + "') AND " +
						"		(  		SELECT i.nom_territorio FROM tiido_ingresos i " +
						"				WHERE i.cod_usuario = f.cod_usuario AND " +
						"		  		(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " + 
						"				TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') AND rownum <= 1) "  + 
						" 		IN (" + listaCodTerritorio + ") " +  
						" 		AND mes = " + mes + " AND  anio = " + anio + " " + 
						"ORDER BY 1, 2, 3, 4";
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			listaTerritorio = new HashMap();
			while (rst.next()) {
				String nomTerritorio = rst.getString("nom_territorio");
				String codUsuario = rst.getString("cod_usuario");
				String editUsuario = rst.getString("edit_usuario");
				String marca = "";
				
				if(editUsuario != null && editUsuario.equals("1")) {
					marca = "*";
				}
				
				if(listaTerritorio.get(nomTerritorio) ==  null) {
					listaUsuario = new HashMap();
					listaFechas = new HashMap();
					
					listaFechas.put(rst.getString("fecha"), 
							"SI" + marca);
					listaUsuario.put(codUsuario, listaFechas);
					listaTerritorio.put(nomTerritorio, listaUsuario);
				} else {
					listaUsuario = (HashMap)listaTerritorio.get(nomTerritorio);
							
					if(listaUsuario.get(codUsuario) ==  null) {
						listaFechas = new HashMap();
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
						
						listaUsuario.put(codUsuario, listaFechas);
					} else {
						listaFechas = (HashMap)listaUsuario.get(codUsuario);
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioxTerritorioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaTerritorio;	
	}
	
	public HashMap listadoFormUsuarioxTerritorioxAnioAbrevReporte(String listaCodTerritorio, ArrayList listaAnio, int anio) {/*
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaTerritorio = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		Iterator iterListaAnio = null;
		String condMesAnio = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Fin");
				
				return null;
			}
			
			if(listaAnio != null && listaAnio.size() > 0) {
				iterListaAnio = listaAnio.iterator();
				
				condMesAnio = " ( ";
				while(iterListaAnio.hasNext()) {
					String valor = (String)iterListaAnio.next(); 
					condMesAnio += 	" TO_CHAR(fecha_act, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ")  ";			
			
				s = con.createStatement();
				sql = 	   	"SELECT	( SELECT i.nom_territorio FROM tiido_ingresos i " + 
							"	      WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio + " AND rownum <= 1) " +
							"	     nom_territorio, " +
							"cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
							"FROM tiido_ingresos_form f " +  
							"WHERE 	(" + condMesAnio + ") AND " +
							"		(  SELECT i.nom_territorio FROM tiido_ingresos i " +
							"		   WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio + " AND rownum <= 1) " +					
							" 		 IN (" + listaCodTerritorio + ") " +  
							" 		AND (anio = " + anio + " OR (anio = " + (anio + 1) + " AND mes = 1) ) " + 
							"ORDER BY 1, 2, 3, 4";
				
				log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				listaTerritorio = new HashMap();
				while (rst.next()) {
					String nomTerritorio = rst.getString("nom_territorio");
					String codUsuario = rst.getString("cod_usuario");
					String editUsuario = rst.getString("edit_usuario");
					String marca = "";
					
					if(editUsuario != null && editUsuario.equals("1")) {
						marca = "*";
					}
					
					if(listaTerritorio.get(nomTerritorio) ==  null) {
						listaUsuario = new HashMap();
						listaFechas = new HashMap();
						
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
						listaUsuario.put(codUsuario, listaFechas);
						listaTerritorio.put(nomTerritorio, listaUsuario);
					} else {
						listaUsuario = (HashMap)listaTerritorio.get(nomTerritorio);
								
						if(listaUsuario.get(codUsuario) ==  null) {
							listaFechas = new HashMap();
							listaFechas.put(rst.getString("fecha"), 
									"SI" + marca);
							
							listaUsuario.put(codUsuario, listaFechas);
						} else {
							listaFechas = (HashMap)listaUsuario.get(codUsuario);
							listaFechas.put(rst.getString("fecha"), 
									"SI" + marca);
						}
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaTerritorio;	*/
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaTerritorio = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		Iterator iterListaAnio = null;
		String condMesAnio = "";
		String condMesAnio1 = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Fin");
				
				return null;
			}
			
			if(listaAnio != null && listaAnio.size() > 0) {
				
			    listaTerritorio = new HashMap();
			    iterListaAnio = listaAnio.iterator();
				
				while(iterListaAnio.hasNext()) {
				    
				    String valor = (String)iterListaAnio.next();
				    
				    condMesAnio = " ( ";
					condMesAnio1 = " ( ";				    
					 
					condMesAnio += 	" TO_CHAR(fecha_act, 'mmyyyy') = '" + valor + "' OR ";
					condMesAnio1 += " TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
					
					condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ")  ";			
					condMesAnio1 = condMesAnio1.substring(0, condMesAnio1.length() - 3) + ")  ";
				
					s = con.createStatement();
					sql = 	   	"SELECT	( SELECT i.nom_territorio FROM tiido_ingresos i " + 
								"	      WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio1 + " AND rownum <= 1) " +
								"	     nom_territorio, " +
								"cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
								"FROM tiido_ingresos_form f " +  
								"WHERE 	(" + condMesAnio + ") AND " +
								"		(  SELECT i.nom_territorio FROM tiido_ingresos i " +
								"		   WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio1 + " AND rownum <= 1) " +					
								" 		 IN (" + listaCodTerritorio + ") " +  
								" 		AND (anio = " + anio + " OR (anio = " + (anio + 1) + " AND mes = 1) ) " + 
								"ORDER BY 1, 2, 3, 4";
					
					log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] SQL:" + sql);
					rst = s.executeQuery(sql);		
					
					while (rst.next()) {
						String nomTerritorio = rst.getString("nom_territorio");
						String codUsuario = rst.getString("cod_usuario");
						String editUsuario = rst.getString("edit_usuario");
						String marca = "";
						
						if(editUsuario != null && editUsuario.equals("1")) {
							marca = "*";
						}
						
						if(listaTerritorio.get(nomTerritorio) ==  null) {
							listaUsuario = new HashMap();
							listaFechas = new HashMap();
							
							listaFechas.put(rst.getString("fecha"), 
									"SI" + marca);
							listaUsuario.put(codUsuario, listaFechas);
							listaTerritorio.put(nomTerritorio, listaUsuario);
						} else {
							listaUsuario = (HashMap)listaTerritorio.get(nomTerritorio);
									
							if(listaUsuario.get(codUsuario) ==  null) {
								listaFechas = new HashMap();
								listaFechas.put(rst.getString("fecha"), 
										"SI" + marca);
								
								listaUsuario.put(codUsuario, listaFechas);
							} else {
								listaFechas = (HashMap)listaUsuario.get(codUsuario);
								listaFechas.put(rst.getString("fecha"), 
										"SI" + marca);
							}
						}
					}					
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioxTerritorioxAnioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaTerritorio;	
	
	}
	
	
	public HashMap listadoFormUsuarioxOficinaxAnioAbrevReporte(String listaCodOficina, ArrayList mesAnio, int anio) {
		/*Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaOficina = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Fin");
				
				return null;
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = " ( ";
				
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
				
					condMesAnio += 	" TO_CHAR(fecha_act, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
				
				s = con.createStatement();
				sql = 	   	"SELECT	( SELECT i.cod_oficina FROM tiido_ingresos i " + 
							"	      WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio + " AND rownum <= 1) " +
							"	      cod_oficina, " +
							"cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
							"FROM tiido_ingresos_form f " +  
							"WHERE 	(" + condMesAnio + ") AND " +
							"		(   SELECT i.cod_oficina FROM tiido_ingresos i " +
							"			WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio + " AND rownum <= 1) " +
							" 		IN (" + listaCodOficina + ") " +  
							" 		AND (anio = " + anio + " OR (anio = " + (anio + 1) + " AND mes = 1) ) " + 
							"ORDER BY 1, 2, 3, 4";
				
				log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				listaOficina = new HashMap();
				while (rst.next()) {
					String codOficina = rst.getString("cod_oficina");
					String codUsuario = rst.getString("cod_usuario");
					String editUsuario = rst.getString("edit_usuario");
					String marca = "";
					
					if(editUsuario != null && editUsuario.equals("1")) {
						marca = "*";
					}
					
					if(listaOficina.get(codOficina) ==  null) {
						listaUsuario = new HashMap();
						listaFechas = new HashMap();
						
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
						listaUsuario.put(codUsuario, listaFechas);
						listaOficina.put(codOficina, listaUsuario);
					} else {
						listaUsuario = (HashMap)listaOficina.get(codOficina);
								
						if(listaUsuario.get(codUsuario) ==  null) {
							listaFechas = new HashMap();
							listaFechas.put(rst.getString("fecha"), 
									"SI" + marca);
							
							listaUsuario.put(codUsuario, listaFechas);
						} else {
							listaFechas = (HashMap)listaUsuario.get(codUsuario);
							listaFechas.put(rst.getString("fecha"), 
									"SI" + marca);
						}
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaOficina;	*/
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaOficina = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		String condMesAnio = "";
		String condMesAnio1 = "";
		Iterator iterMesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Fin");
				
				return null;
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
			    listaOficina = new HashMap();	
			    
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next();
					
					condMesAnio = " ( ";
					condMesAnio1 = " ( ";
				
					condMesAnio += 	" TO_CHAR(fecha_act, 'mmyyyy') = '" + valor + "' OR ";
					condMesAnio1 += " TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
					
					condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
					condMesAnio1 = condMesAnio1.substring(0, condMesAnio1.length() - 3) + ") ";
					
					s = con.createStatement();
					sql = 	   	"SELECT	( SELECT i.cod_oficina FROM tiido_ingresos i " + 
								"	      WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio1 + " AND rownum <= 1) " +
								"	      cod_oficina, " +
								"cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
								"FROM tiido_ingresos_form f " +  
								"WHERE 	(" + condMesAnio + ") AND " +
								"		(   SELECT i.cod_oficina FROM tiido_ingresos i " +
								"			WHERE i.cod_usuario = f.cod_usuario AND " + condMesAnio1 + " AND rownum <= 1) " +
								" 		IN (" + listaCodOficina + ") " +  
								" 		AND (anio = " + anio + " OR (anio = " + (anio + 1) + " AND mes = 1) ) " + 
								"ORDER BY 1, 2, 3, 4";
					
					log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] SQL:" + sql);
					rst = s.executeQuery(sql);				
					
					
					while (rst.next()) {
						String codOficina = rst.getString("cod_oficina");
						String codUsuario = rst.getString("cod_usuario");
						String editUsuario = rst.getString("edit_usuario");
						String marca = "";
						
						if(editUsuario != null && editUsuario.equals("1")) {
							marca = "*";
						}
						
						if(listaOficina.get(codOficina) ==  null) {
							listaUsuario = new HashMap();
							listaFechas = new HashMap();
							
							listaFechas.put(rst.getString("fecha"), 
									"SI" + marca);
							listaUsuario.put(codUsuario, listaFechas);
							listaOficina.put(codOficina, listaUsuario);
						} else {
							listaUsuario = (HashMap)listaOficina.get(codOficina);
									
							if(listaUsuario.get(codUsuario) ==  null) {
								listaFechas = new HashMap();
								listaFechas.put(rst.getString("fecha"), 
										"SI" + marca);
								
								listaUsuario.put(codUsuario, listaFechas);
							} else {
								listaFechas = (HashMap)listaUsuario.get(codUsuario);
								listaFechas.put(rst.getString("fecha"), 
										"SI" + marca);
							}
						}
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioxOficinaxAnioAbrevReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaOficina;	
	
	}
	
	public HashMap listadoFormUsuarioAbrevReportexAnio(String listaCodUsuario, ArrayList mesAnio, int anio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		HashMap listaFormUsuario = null;
		HashMap listaUsuario = null;
		HashMap listaFechas = null;
		String where = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] Fin");
				
				return null;
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = "WHERE ( ";
				
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
				
					condMesAnio += 	" TO_CHAR(fecha_act, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
				//condMesAnio += "AND cod_usuario IN (" + listaCodUsuario + ") ";
				condMesAnio += "AND " + listaUsuariosFraccionada(listaCodUsuario) + " ";
				
				s = con.createStatement();
				sql = 	   	"SELECT  cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy'), edit_usuario " +
							"FROM tiido_ingresos_form " +  
							where + condMesAnio + 
							" 		AND (anio = " + anio + " OR (anio = " + (anio + 1) + " AND mes = 1) ) " + 
							"ORDER BY 1, 2";
				
				log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				listaFormUsuario = new HashMap();
				while (rst.next()) {
					String codUsuario = rst.getString("cod_usuario");
					String editUsuario = rst.getString("edit_usuario");
					String marca = "";
					
					if(editUsuario != null && editUsuario.equals("1")) {
						marca = "*";
					}
					
					if(listaUsuario.get(codUsuario) ==  null) {
						listaFechas = new HashMap();
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
						
						listaUsuario.put(codUsuario, listaFechas);
					} else {
						listaFechas = (HashMap)listaUsuario.get(codUsuario);
						listaFechas.put(rst.getString("fecha"), 
								"SI" + marca);
					}
				}
			}
			
			log.info("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] ");
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
				log.error("[SesionIngresosBean :: listadoFormUsuarioAbrevReportexAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaFormUsuario;	
	}
	
	public ArrayList listadoOficinaReporte(String[] mesAnio, String codTerritorio) {
		ArrayList  listaOficina = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String where = "";
		String condTerritorio = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoOficinaReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoOficinaReporte] Fin");
				
				return null;
			}
			
			log.info("[SesionIngresosBean :: listadoOficinaReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoOficinaReporte] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			where = "WHERE 	(TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
					"		TO_CHAR(fecha, 'mmyyyy') = '" + mesAnio[1] + "') ";
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT cod_oficina " +
					"FROM tiido_ingresos " +
					where + condTerritorio +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoOficinaReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaOficina.add(rst.getString("cod_oficina"));
			}
			
			log.info("[SesionIngresosBean :: listadoOficinaReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoOficinaReporte] ");
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
				log.error("[SesionIngresosBean :: listadoOficinaReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaOficina;	
	}
	
	public ArrayList listadoOficinaReportexAnio(ArrayList mesAnio, String codTerritorio) {
		ArrayList  listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condTerritorio = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoOficinaReportexAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoOficinaReportexAnio] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listadoOficinaReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoOficinaReportexAnio] Fin");
				
				return null;
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				if(codTerritorio != null) {
					condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
				}
			} else {
				if(codTerritorio != null) {
					condTerritorio = " cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
				}
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = "( ";
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
				
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
			} 
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT cod_oficina " +
					"FROM tiido_ingresos " +
					"WHERE "  + condMesAnio + condTerritorio + 
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoOficinaReportexAnio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaUsuario.add(rst.getString("cod_oficina"));
			}
			
			log.info("[SesionIngresosBean :: listadoOficinaReportexAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoOficinaReportexAnio] ");
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
				log.error("[SesionIngresosBean :: listadoOficinaReportexAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaUsuario;	
	}
	
	public ArrayList listadoTerritorioReporte(String[] mesAnio, String codTerritorio) {
		ArrayList  listaTerritorio = new ArrayList();
		Iterator iterLista = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String where = "";
		String condTerritorio = "";
		
		try {
			log.info("[SesionIngresosBean :: listadoTerritorioReporte] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoTerritorioReporte] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listadoTerritorioReporte] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoTerritorioReporte] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND t.cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			where = "WHERE 	(TO_CHAR(t.fecha, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
					"		TO_CHAR(t.fecha, 'mmyyyy') = '" + mesAnio[1] + "') ";
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT t.nom_territorio " +
					"FROM tiido_ingresos t, tiido_oficina o " +
					where +  " AND t.cod_oficina = o.cod_ofic " + condTerritorio +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoTerritorioReporte] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaTerritorio.add(rst.getString("nom_territorio"));
			}
			
			log.info("[SesionIngresosBean :: listadoTerritorioReporte] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoTerritorioReporte] ");
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
				log.error("[SesionIngresosBean :: listadoTerritorioReporte] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaTerritorio;	
	}
	
	public ArrayList listadoTerritorioReportexAnio(ArrayList mesAnio, String codTerritorio) {
		ArrayList  listaTerritorio = new ArrayList();
		Iterator iterLista = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String condTerritorio = "";
		String condMesAnio = "";
		Iterator iterMesAnio = null;
		
		try {
			log.info("[SesionIngresosBean :: listadoTerritorioReportexAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoTerritorioReportexAnio] Fin");
				
				return null;
			}
			
			log.info("[SesionIngresosBean :: listadoTerritorioReportexAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoTerritorioReportexAnio] Fin");
				
				return null;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND t.cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			if(mesAnio != null && mesAnio.size() > 0) {
				condMesAnio = "( ";
				
				iterMesAnio = mesAnio.iterator();
				while(iterMesAnio.hasNext()) {
					String valor = (String)iterMesAnio.next(); 
				
					condMesAnio += 	" TO_CHAR(fecha, 'mmyyyy') = '" + valor + "' OR ";
				}
				
				condMesAnio = condMesAnio.substring(0, condMesAnio.length() - 3) + ") ";			
			} 
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT t.nom_territorio " +
					"FROM tiido_ingresos t, tiido_oficina o " +
					"WHERE " + condMesAnio + condTerritorio + " AND t.cod_oficina = o.cod_ofic " + condTerritorio +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listadoTerritorioReportexAnio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaTerritorio.add(rst.getString("nom_territorio"));
			}
			
			log.info("[SesionIngresosBean :: listadoTerritorioReportexAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoTerritorioReportexAnio] ");
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
				log.error("[SesionIngresosBean :: listadoTerritorioReportexAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaTerritorio;	
	}
	
	public ArrayList listarDiasMesesxAnio(int anio) {
		ArrayList listaMeses = new ArrayList();
		ArrayList listaFinal = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		Iterator iterListaMeses = null;
		
		try {
			log.info("[SesionIngresosBean :: listarDiasMesesxAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listarDiasMesesxAnio] Fin");
				
				return null;
			}		
			
			log.info("[SesionIngresosBean :: listarDiasMesesxAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listarDiasMesesxAnio] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT sel_mes " +  
					"FROM tiido_meses_referencia " +
					"WHERE anio = '" + anio +  "' " +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listarDiasMesesxAnio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaMeses.add(rst.getString(1));
			}
			
			if(listaMeses != null && listaMeses.size() > 0) {
				
				iterListaMeses = listaMeses.iterator();
				while(iterListaMeses.hasNext()) {
					String mes = (String)iterListaMeses.next(); 
				
					listaFinal.addAll(	
							ConstantesUtil.diasMesesReportexAnio(Integer.parseInt(mes), anio));
				}
			}
			
			listaFinal.addAll(	
					ConstantesUtil.diasMesesReportexAnio(1, anio + 1));
			
			log.info("[SesionIngresosBean :: listarDiasMesesxAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listarDiasMesesxAnio] ");
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
				log.error("[SesionIngresosBean :: listarDiasMesesxAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaFinal;	
	}
	
	public ArrayList listarFormatMesAnioxAnio(int anio) {
		ArrayList listaMeses = new ArrayList();
		ArrayList listaFinal = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		Iterator iterListaMeses = null;
		
		try {
			log.info("[SesionIngresosBean :: listarFormatMesAnioxAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listarFormatMesAnioxAnio] Fin");
				
				return null;
			}			
			
			log.info("[SesionIngresosBean :: listarFormatMesAnioxAnio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listarFormatMesAnioxAnio] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			sql = 	"SELECT DISTINCT sel_mes " +  
					"FROM tiido_meses_referencia " +
					"WHERE anio = '" + anio +  "' " +
					"ORDER BY 1";
				
			log.info("[SesionIngresosBean :: listarFormatMesAnioxAnio] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			while (rst.next()) {
				listaMeses.add(rst.getString(1));
			}
			
			if(listaMeses != null && listaMeses.size() > 0) {
				iterListaMeses = listaMeses.iterator();
				
				while(iterListaMeses.hasNext()) {
					String mes = (String)iterListaMeses.next(); 
				
					listaFinal.add(ConstantesUtil.fechaFormatNum(Integer.parseInt(mes)) + String.valueOf(anio));
				}
			}
			listaFinal.add(ConstantesUtil.fechaFormatNum(1) + String.valueOf(anio + 1));
			
			log.info("[SesionIngresosBean :: listarFormatMesAnioxAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listarFormatMesAnioxAnio] ");
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
				log.error("[SesionIngresosBean :: listarFormatMesAnioxAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return listaFinal;	
	}
	
	public void insertarIngresoForm(int tipo, int mes, int anio, 
			String codUsuario, String editUsuario, String codGestor, String codOficina) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		long max = -1;
		
		try {
			log.info("[SesionIngresosBean :: insertarIngresoForm] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: insertarIngresoForm] Fin");
				
				return ;
			}			
			
			log.info("[SesionIngresosBean :: insertarIngresoForm] ConstantesUtil.DATASOURCE_CONTEXT" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: insertarIngresoForm] Fin");
				
				return ;
			}
			
			s = con.createStatement();
			sql = 	"SELECT NVL(MAX(form_id) + 1, 1) FROM tiido_ingresos_form";
				
			log.info("[SesionIngresosBean :: insertarIngresoForm] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			if (rst.next()) {
				max = rst.getLong(1);
			}
			
			if(max > 0) {
				sql = 	"INSERT INTO tiido_ingresos_form " +
						"(form_id, tipo_form,  mes, anio, cod_usuario, edit_usuario, cod_gestor_m, cod_oficina_m) " +
						"VALUES ( " + max + ", '" + tipo + "', " + mes + ", " + anio + 
						", '" + codUsuario + "', '" + editUsuario + "', '" + codGestor + "', '" + codOficina + "')";
				log.info("[SesionIngresosBean :: insertarIngresoForm] SQL:" + sql);
				s.executeUpdate(sql);
			}
			
			log.info("[SesionIngresosBean :: insertarIngresoForm] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: insertarIngresoForm] ");
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
				log.error("[SesionIngresosBean :: insertarIngresoForm] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return;
			}
		}			
	}
	
	public void actualizarIngresoFormEditUsuario(long id) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		
		try {
			log.info("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] Fin");
				
				return ;
			}			
			
			log.info("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] Fin");
				
				return ;
			}
			
			s = con.createStatement();
			
			sql = 	"UPDATE tiido_ingresos_form SET edit_usuario = '1' " +
					"WHERE form_id = " + id;
			log.info("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] SQL:" + sql);
			s.executeUpdate(sql);
			
			log.info("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] ");
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
				log.error("[SesionIngresosBean :: actualizarIngresoFormEditUsuario] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return;
			}
		}			
	}
	
	public long existeIngresoForm(int tipo, int mes, int anio, String codUsuario, String fecha, String codGestorM, String codOficinaM) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		int valor = -1;
		long id = 0;
		
		try {
			log.info("[SesionIngresosBean :: existeIngresoForm] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: existeIngresoForm] Fin");
				
				return id;
			}	
			
			log.info("[SesionIngresosBean :: existeIngresoForm] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: existeIngresoForm] Fin");
				
				return id;
			}
			
			s = con.createStatement();
			sql = 	"SELECT form_id FROM iido.tiido_ingresos_form WHERE " +
					"tipo_form = '" + tipo + "' AND " + 
					"to_char(fecha_act, 'YYYYMMDD') = '" + fecha + "' AND " +      
					"cod_usuario = '" + codUsuario + "' AND " +
					"cod_gestor_m = '" + codGestorM + "' AND " +
					"cod_oficina_m = '" + codOficinaM + "' AND " +
					"mes = " + mes + " AND " +
					"anio = " + anio;
				
			log.info("[SesionIngresosBean :: existeIngresoForm] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			if (rst.next()) {
				if(rst.getLong(1) > 0) {
					id = rst.getLong(1);	
				}
			}
			
			log.info("[SesionIngresosBean :: existeIngresoForm] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: existeIngresoForm] ");
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
				log.error("[SesionIngresosBean :: existeIngresoForm] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return id;
			}
		}
		
		return id;
	}
	
	public int listadoIngresoxDia(String diaActual, String codTerritorio) {
		ArrayList listaUsuario = new ArrayList();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String where = "";
		String condTerritorio = "";
		int dias = 0;
		
		try {
			log.info("[SesionIngresosBean :: listadoIngresoxDia] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionIngresosBean :: listadoIngresoxDia] Fin");
				
				return dias;
			}			
			
			log.info("[SesionIngresosBean :: listadoIngresoxDia] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionIngresosBean :: listadoIngresoxDia] Fin");
				
				return dias;
			}
			
			if(codTerritorio != null) {
				condTerritorio = "AND cod_oficina IN (SELECT cod_ofic FROM tiido_oficina WHERE cod_terr = '" + codTerritorio + "') ";
			}
			
			where = "WHERE TO_CHAR(fecha, 'dd/MM/yyyy') = '" + diaActual + "' ";  
			
			s = con.createStatement();
			sql = 	"SELECT COUNT(1) " +
					"FROM tiido_ingresos " +
					where + condTerritorio;
				
			log.info("[SesionIngresosBean :: listadoIngresoxDia] SQL:" + sql);
			rst = s.executeQuery(sql);				
			
			if (rst.next()) {
				dias = rst.getInt(1);
			}
			
			log.info("[SesionIngresosBean :: listadoIngresoxDia] Fin");
		} catch (Exception e) {
			log.error("[SesionIngresosBean :: listadoIngresoxDia] ");
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
				log.error("[SesionIngresosBean :: listadoIngresoxDia] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return dias;
			}
		}			
		
		return dias;	
	}
	
	public static void main(String args[]) {
		String[] mesAnio = new String[]{"1", "2"};
		String sql = null;
		String listaCodOficina = "012";
		String mes = "01"; 
		String anio = "2010"; 
		
		sql = 	   	"SELECT	(SELECT cod_oficina " + 
		"	     FROM " +
		"	    ( SELECT i.cod_oficina FROM tiido_ingresos i " + 
		"	      WHERE i.cod_usuario = f.cod_usuario AND " +
		"		  		(TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[0] + "' OR " + 
		"				TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[1] + "') ) "  +
		"	      WHERE rownum <= 1) cod_oficina, " +
		"cod_usuario, tipo_form || TO_CHAR(fecha_act, 'ddmmyyyy') fecha, edit_usuario " +
		"FROM tiido_ingresos_form " +  
		"WHERE 	(TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[0] + "' OR " +
		"		TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[1] + "') AND " +
		"		(SELECT cod_oficina  " +
		"		FROM (  SELECT i.cod_oficina FROM tiido_ingresos i " +
		"				WHERE i.cod_usuario = f.cod_usuario AND " +
		"		  		(TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[0] + "' OR " + 
		"				TO_CHAR(fecha_act, 'mmyyyy') = '" + mesAnio[1] + "') ) "  + 
		" 		WHERE rownum <= 1) IN (" + listaCodOficina + ") " +  
		" 		AND mes = " + mes + " AND  anio = " + anio + " " + 
		"ORDER BY 1, 2, 3, 4";
		
		log.info(sql);
	}	
}