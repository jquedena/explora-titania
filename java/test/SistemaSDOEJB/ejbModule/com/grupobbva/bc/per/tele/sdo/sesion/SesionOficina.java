package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.Vector;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
/**
 * Remote interface for Enterprise Bean: SesionOficina
 */
@SuppressWarnings({"unchecked"})
public interface SesionOficina extends javax.ejb.EJBObject {
	public Vector findAllOficinaByCodTerri(String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector findAllOficinas() throws java.rmi.RemoteException;
	public Oficina findByCodOficina(String codOficina)
		throws java.rmi.RemoteException;
	public Vector findListaByCodOficina(String codOficina)
		throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - BUSCAR OFICINA POR TERRITORIO
	public Vector busOficinaxTerritorio(String codTerritorio)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - BUSCAR OFICINA POR TERRITORIO

	//	OSCAR CORTEZ - CREAR NUEVAS OFICINAS
	public Vector nuevaOficina(
		String codTerritorio,
		String codOficina,
		String nomOficina) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - CREAR NUEVAS OFICINAS

	//	OSCAR CORTEZ - EDITAR OFICINAS
	public Vector editarOficina(
		String codTerritorio,
		String codOficina,
		String nomOficina) throws java.rmi.RemoteException;
	public boolean findByCodigoOficina(String codOficina)
		throws java.rmi.RemoteException;
	public boolean findOficinaAndTerri(String codTerritorio, String codOfi)
		throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - BUSQUEDA OFICINAS x codterrtirotio, mes y anho
	public Vector findAllOficinaByCodTerri_MOD1(
		String codTerritorio,
		String anho,
		String mes) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSQUEDA OFICINAS x codterrtirotio, mes y anho

	//	OSCAR CORTEZ - BUSQUEDA OFICINAS x codterrtirotio
	public Vector findAllOficinaByCodTerri_MOD2(String codTerritorio)
		throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSQUEDA OFICINAS x codterrtirotio, mes y anho

	// INICIO - SP_CAMBIO_TERRITORIO_OFICINA 
	public Vector editarTerritoriosDeOficinas(
		String codOficina,
		String codTerritorio) throws java.rmi.RemoteException;
	public Territorio findTerritorioByCodOficina(String codOficina)
		throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - ELIMINAR OFICINAS

	public OficinaHija findOficinaHija(OficinaHija oficinaHija)
		throws java.rmi.RemoteException;
	public boolean crearOficinaHija(OficinaHija oficinaHija)
		throws java.rmi.RemoteException;
	public boolean actualizarOficinaHija(OficinaHija oficinaHija)
		throws java.rmi.RemoteException;
	public boolean eliminarOficinaHija(OficinaHija oficinaHija)
		throws java.rmi.RemoteException;
	public Vector findTodosOficinaHija() throws java.rmi.RemoteException;
	public Vector findHijas(String codOficinaPadre)
		throws java.rmi.RemoteException;
	public Oficina findByCodOficinaHija(String codOficina)
		throws java.rmi.RemoteException;
	public Vector busOficinaxTerritorio(String codTerritorio, boolean showAll)
		throws java.rmi.RemoteException;
	public Vector editarOficina(Oficina oficina)
		throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - EDITAR OFICINAS
	//	OSCAR CORTEZ - ELIMINAR OFICINAS
	/*public Vector eliminarOficina(String codOficina) {
	 Vector res = null;
	 Oficina bean = null;
	 Connection con = null;
	 Context initialContext = null;
	 Statement s = null;
	 ResultSet rst = null;

	 try {
	 initialContext = new InitialContext();
	 if (initialContext == null) {
	 return null;
	 }
	 log.info("ConstantesUtil.DATASOURCE_CONTEXT::: "
	 + ConstantesUtil.DATASOURCE_CONTEXT);
	 DataSource datasource = (DataSource) initialContext
	 .lookup(ConstantesUtil.DATASOURCE_CONTEXT);

	 if (datasource != null) {
	 con = datasource.getConnection();
	 } else {
	 initialContext = null;
	 return null;
	 }

	 s = con.createStatement();
	 try {
	 String sql =

	 "DELETE FROM tiido_oficina WHERE COD_OFIC = '" + codOficina
	 + "'";

	 log.info("sql::: " + sql);
	 rst = s.executeQuery(sql);

	 while (rst.next()) {
	 if (res == null)
	 res = new Vector(0, 1);
	 bean = new Oficina();

	 res.add(bean);
	 }

	 } catch (SQLException e1) {
	 e1.printStackTrace();
	 }
	 } catch (Exception e) {
	 e.printStackTrace();
	 } finally {
	 try {
	 if (rst != null) {
	 rst.close();
	 }

	 if (s != null) {
	 s.close();
	 }

	 if (con != null) {
	 con.close();
	 }

	 if (initialContext != null) {
	 initialContext.close();
	 }
	 } catch (Exception e) {
	 e.printStackTrace();
	 return null;
	 }
	 }

	 return res;
	 }*/

	public int eliminarOficina(String codOficina)
		throws java.rmi.RemoteException;
	public int nuevaOficina(
		String codTerritorio,
		String codOficina,
		String nomOficina,
		String usuario) throws java.rmi.RemoteException;
}
