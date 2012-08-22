package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.Vector;
import java.util.Date;
import com.grupobbva.bc.per.tele.sdo.serializable.Seguimiento;
/**
 * Remote interface for Enterprise Bean: SessionUtil
 */
public interface SessionUtil extends javax.ejb.EJBObject {
	public String getCorrelativo(String nomTabla, String nomCampo, String tamano)
		throws java.rmi.RemoteException;
	public Vector consultarPLanesAccion(
		String codigoOficina,
		String mes,
		String anho,
		String codigoGestor) throws java.rmi.RemoteException;
	public Vector consultarCampaniasDetalles(
		String codigoOficina,
		String mes,
		String anho,
		String codigoGestor) throws java.rmi.RemoteException;
	public Vector consultarPlanesAccionesPPG(
		String codigoOficina,
		String mes,
		String anho,
		String codigoGestor) throws java.rmi.RemoteException;
	public Vector consultarCampaniasDetallesPGG(
		String codigoOficina,
		String mes,
		String anho,
		String codigoGestor) throws java.rmi.RemoteException;
	public Vector findAllOficinaConMetas(
		String codTerritorio,
		String mes,
		String anio) throws java.rmi.RemoteException;
	public int xInsertarTPlanes(
		String codigoOficina,
		String mes,
		String anho,
		String codigoEpigrafe,
		String nombreEpigrafe,
		int pesodor,
		int monto,
		int porcAlcanzado,
		int desvpPto,
		int nroMesesFalt,
		int proyCrecMensual,
		int ajusteEstimadoTerr,
		int proyAjusteMensual,
		int saldoMedioJunio,
		int porcSaldoMedioJunio,
		int saldoDiciembreAnterior,
		int saldoMedioDiciembre,
		String codigoTerritorio,
		int porcSaldoMedioDiciembre,
		int factorAjusteSaldoPuntual,
		int historicoBajas,
		int metaMesSaldoPuntual,
		int metaGerenteOficina,
		int prioridad,
		String mesEvaluacion,
		String indicadorDor,
		int varMes,
		int ajustePspto,
		int desvPsptoAjustado,
		int factAjustTerritorial,
		int factAsignGteOf) throws java.rmi.RemoteException;
	public int xInsertarTParametros(
		Date fechaAccion,
		Date fechaSeguimiento1,
		Date fechaSeguimiento2,
		String afectaAccion,
		String afectaSeguimiento,
		String afectaPlanificacion,
		Date fechaPlanificacion) throws java.rmi.RemoteException;
	public Vector xBusAllTablaParametros() throws java.rmi.RemoteException;
	public int xInsertarTMetasGestor(
		String codigoMetaGestor,
		String codigoEpigrafe,
		String codigoOficina,
		String codigoGestor,
		String anho,
		String mes,
		String orden,
		Date fechaGrabacion,
		String porcAsignado,
		String nombreEpigrafe,
		String nombreGestor,
		String codigoTerritorio) throws java.rmi.RemoteException;
	public Vector xBusAllTablaMetasGestor(String contadorMes)
		throws java.rmi.RemoteException;
	public int xInsertarTMaestroPlanes(
		String codigoOficina,
		String mes,
		String anho,
		String codigoTerritorio,
		String prioridad,
		Date fechaGrabacion) throws java.rmi.RemoteException;
	public Vector xBusAllTablaMaestroPlanes(String contadorMes)
		throws java.rmi.RemoteException;
	public int xInsertarTFirmas(
		String anho,
		String mes,
		String item,
		String codigoGestor,
		String codigoOficina,
		String descripcion,
		Date fecha) throws java.rmi.RemoteException;
	public Vector xBusAllTablaFirmas() throws java.rmi.RemoteException;
	public int xInsertarTPerfiles(String codigoPerfil, String nombrePerfil)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaPerfiles() throws java.rmi.RemoteException;
	public int xInsertarTEquivalencias(String codigoCargo, String codigoPerfil)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaEquivalencias() throws java.rmi.RemoteException;
	public int xInsertarTCampanhasDetalle(
		String codigoCampanhaDetalle,
		String nombreCampanha,
		String codigoGestor,
		String mes,
		String anho,
		int nroClientes,
		int compromisoGestor,
		int nroGestorSeguimiento1,
		int nroConcSeguimiento1,
		int montoSeguimiento1,
		int nroGestorSeguimiento2,
		int nroConcSeguimiento2,
		int montoSeguimiento2,
		String codigoOficina,
		String codigoCampanha,
		Date fechaGrabacion,
		Date fechaSeg1,
		Date fechaSeg2,
		String codigoTerritorio) throws java.rmi.RemoteException;
	public Vector xBusAllTablaCampanhasDetalleAntiguo()
		throws java.rmi.RemoteException;
	public int xInsertarTCampanhas(
		String codigoCampania,
		String anho,
		String mes,
		String nombreCampania,
		String codigoOficina,
		String codigoGestor,
		String orden,
		String gte,
		Date fechaGrabacion,
		String codigoTerritorio) throws java.rmi.RemoteException;
	public int xInsertarTOficina(
		String codigoTerritorio,
		String nombreOficina,
		String codigoOficina) throws java.rmi.RemoteException;
	public Vector xBusAllTablaOficinaAntiguo() throws java.rmi.RemoteException;
	public int xInsertarTTerritorio(
		String codigoTerritorio,
		String nombreTerritorio) throws java.rmi.RemoteException;
	public int xInsertarTEpigrafes(
		String codigoepigrafe,
		String nombreepigrafe,
		String anho,
		String indicadorclase,
		String indicadorsubclase,
		String orden,
		String indicadorgrupo,
		String abreviatura,
		String indicadorhijo,
		String indicadorafecta) throws java.rmi.RemoteException;
	public int xInsertarTAcciones(
		String codigoAccion,
		String nomberAccion,
		String codigoGestor,
		String mes,
		String anho,
		int nroClientes,
		int compromisoGestor,
		int nroGestorSeguimiento1,
		int nroConcSeguimiento1,
		int montoSeguimiento1,
		int nroGestorSeguimiento2,
		int nroConcSeguimiento2,
		int montoSeguimiento2,
		String codigoOficina,
		String codigoEpigrafe,
		Date fechaSeg1,
		Date fechaSeg2,
		Date fechaGrabacion,
		String codTerritorio) throws java.rmi.RemoteException;
	public String xDameTerritorio(String codigoOficina)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaTerritorioAntiguo()
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaEpigrafesAntiguo()
		throws java.rmi.RemoteException;
	public String buscarEstadoFlag() throws java.rmi.RemoteException;
	public int actualizarEstadoFlag(String flag)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaAccionesAntiguo(String mes, String anho)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaPlanes(String mes, String anho)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaCampanhasAntiguo(String anho)
		throws java.rmi.RemoteException;
	public Vector buscarUsuariosLDAP(
		String codOficina,
		String codEmpresa,
		int limiteOcurrencias) throws java.rmi.RemoteException;
	public String testearBD() throws java.rmi.RemoteException;
	public Vector exportarTablasTXT(int tabla, int mes, int anio)
		throws java.rmi.RemoteException;
	/**
	 * @param codOfi
	 * @param mes
	 * @param anho
	 * @param codGestor
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzo(String codOfi,
			String mes, String anho, String codGestor)
			throws java.rmi.RemoteException;
	/**
	 * @param codOfi
	 * @param mes
	 * @param anho
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzoPGO(
			String codOfi, String mes, String anho)
			throws java.rmi.RemoteException;
}
