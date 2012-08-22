package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
/**
 * Remote interface for Enterprise Bean: SesionPlanes
 */
public interface SesionPlanes extends javax.ejb.EJBObject {
	public Vector findConsultarPlanesxMes(String codOficina, String anho)
		throws java.rmi.RemoteException;

	public Plan findConsultaPlanesResumen(
		String mes,
		String anho,
		String codEpigrafe,
		String codOficina) throws java.rmi.RemoteException;
	
	public boolean updatePlan(Plan plan) 
			throws java.rmi.RemoteException;
	public boolean createPlan(Plan plan) throws java.rmi.RemoteException;
	/**
	 * LISTA LOS DATOS DE PLANES POR A�O Y UN DETERMINADO
	 * @param anho ==> El anho del plan a listar
	 * @param codOfi ==> La oficina a listar del anho determinado
	 * @return Lista del plan anual
	 */
	public Vector findPlanAnual(String anho, String codOfi)
		throws java.rmi.RemoteException;
	public boolean existeDataMesAnio(String mes, String anio)
		throws java.rmi.RemoteException;
	public Vector findEpigrafesinPlanes(
		String codOficina,
		String anho,
		String mes) throws java.rmi.RemoteException;
	public boolean createUpdatePlan(Plan plan) throws java.rmi.RemoteException;
	public Vector findConsultaPlanes(
		String codTerritorio,
		String codOficina,
		String anho,
		String mes,
		String presuReferencia) throws java.rmi.RemoteException;
	public boolean insertUpdateMesesReferencia(int mes, int anio, int sel_mes)
		throws java.rmi.RemoteException;
	public int findMesesReferencia(int mes, int anio)
		throws java.rmi.RemoteException;
	/**
	 * ELIMINA LOS PLANES INGRESADOS MEDIANTE CARGA DE ARCHIVO
	 * 
	 * @return Borra true si es exitoso y false si no es exitoso
	 */
	/*
	 * public boolean borrarPlanIngresado() { Vector res = null;
	 * ListabusAllTerritorio bean = null; boolean fResult = false; Connection
	 * con = null; Context initialContext = null; Statement s = null; ResultSet
	 * rst = null;
	 * 
	 * try { Calendar calendario = Calendar.getInstance();
	 * 
	 * int mesA = calendario.get(Calendar.MONTH) + 1; int anhoA =
	 * calendario.get(Calendar.YEAR);
	 * 
	 * String cMesA = String.valueOf(mesA);
	 * 
	 * if (mesA < 10) { cMesA = "0" + cMesA; } // BORRAR //cMesA = "06";
	 * 
	 * con = null; initialContext = new InitialContext(); if (initialContext ==
	 * null) { return fResult; }
	 * log.info("ConstantesUtil.DATASOURCE_CONTEXT::: " +
	 * ConstantesUtil.DATASOURCE_CONTEXT); DataSource datasource = (DataSource)
	 * initialContext .lookup(ConstantesUtil.DATASOURCE_CONTEXT);
	 * 
	 * if (datasource != null) { con = datasource.getConnection(); } else {
	 * initialContext = null; return fResult; }
	 * 
	 * s = con.createStatement(); try { String sql = "Delete tiido_planes Where
	 * anho_plan = '" + anhoA + "' and mes_plan = '" + cMesA + "'";
	 * 
	 * log.info("sql::: " + sql); rst = s.executeQuery(sql); fResult =
	 * true; } catch (SQLException e1) { fResult = false; e1.printStackTrace(); } }
	 * catch (Exception e) { e.printStackTrace(); } finally { try { if(rst !=
	 * null) { rst.close(); }
	 * 
	 * if(s != null) { s.close(); }
	 * 
	 * if(con != null) { con.close(); }
	 * 
	 * if(initialContext != null) { initialContext.close(); } } catch (Exception
	 * e) { e.printStackTrace(); return false; } }
	 * 
	 * return fResult; }
	 */

	public boolean borrarPlanIngresado(String usuario)
		throws java.rmi.RemoteException;

	public HashMap<String, Integer> findCantidadPersonal(String anho, String mes,
			String codOfi, String codTerr) throws java.rmi.RemoteException;

	/**
	 * @param year
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public HashMap getListaMeses(int year) throws java.rmi.RemoteException;
}
