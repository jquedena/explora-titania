package com.grupobbva.bc.per.tele.sdo.sesionws;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Firmas;
import com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan;
import com.grupobbva.bc.per.tele.sdo.serializable.Menu;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.Parametro;
import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Seguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
/**
 * Remote interface for Enterprise Bean: SesionWS
 */
@SuppressWarnings("unchecked")
public interface SesionWS extends javax.ejb.EJBObject {
	/******************************************************************************
	 * findxCodPerfil :: T. MENU 
	 */
	public Vector findxCodPerfil(String codPerfil)
		throws java.rmi.RemoteException;
	public Vector findAllMenu() throws java.rmi.RemoteException;
	public boolean createMenu(Menu menu) throws java.rmi.RemoteException;
	public boolean deleteMenu(String padre) throws java.rmi.RemoteException;
	public Menu findxIdMenu(String padre) throws java.rmi.RemoteException;
	public boolean updateMenu(Menu menu) throws java.rmi.RemoteException;
	/******************************************************************************
	 * findPermisoPerfilxTipAccxValorRCP :: T. PERMISO PERFIL 
	 */

	public PermisoPerfil findPermisoPerfilxTipAccxValorRCP(
		String codReg,
		String codCat,
		String path) throws java.rmi.RemoteException;
	public Vector findAllPermisoPerfil() throws java.rmi.RemoteException;
	public boolean deletePermisoPerfil(
		String codPerfil,
		String tipoAcceso,
		String valorRCP) throws java.rmi.RemoteException;
	public PermisoPerfil findPermisoPerfilById(
		String codPerfil,
		String tipoAcceso,
		String valorRCP) throws java.rmi.RemoteException;
	/******************************************************************************
	 * findAllPerfil :: T. PERFIL 
	 */
	public Vector findAllPerfil() throws java.rmi.RemoteException;
	
	/******************************************************************************
	 * findAllPerfil :: T. PERFIL
	 * Auitor :: Godofredo Ureta 
	 */
	public Vector findAllEquivalencias() throws java.rmi.RemoteException;
	
	public Perfil findPerfil(String cod_perfil) throws java.rmi.RemoteException;
	public boolean updatePerfil(Perfil perfil) throws java.rmi.RemoteException;
	public boolean updateEquivalencia(Equivalencia equivalencia) throws java.rmi.RemoteException;
	public boolean deletePerfil(String cod_perfil)
		throws java.rmi.RemoteException;
	public boolean createPerfil(Perfil perfil) throws java.rmi.RemoteException;
	/******************************************************************************
	 * findAllPerfil :: T. MULTITABLA 
	 */
	public Vector findByCodMulti(String codMulti)
		throws java.rmi.RemoteException;
	public boolean updateCorporativa(Multitabla multitabla)
		throws java.rmi.RemoteException;
	public Multitabla findByID(String id) throws java.rmi.RemoteException;
	/******************************************************************************
	 * findAllPerfil :: T. OFICINA 
	 */
	public Vector findAllOficinaByCodTerri(String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector findAllOficinas() throws java.rmi.RemoteException;
	
	
	public Vector busAllTerritorio() throws java.rmi.RemoteException;
	public Vector busTerritorioxCod(String codTerritorio)
	throws java.rmi.RemoteException;
	public Vector eliminarTerritorio(String codTerritorio)
	throws java.rmi.RemoteException;
	
	/******************************************************************************/

	/******************************************************************************
	 * findAllPerfil :: T. PARAMETROS
	 */

	public Vector findAllParametro() throws java.rmi.RemoteException;
	public Vector findConsultarPlanesxMes(String codOficina, String anho)
		throws java.rmi.RemoteException;
	/******************************************************************************/

	/******************************************************************************
	 * findAllPerfil :: T. MAESTROPLANES
	 */

	public MaestroPlan findUbicar(
		String mes,
		String anho,
		String codOficina,
		String codTerritorio) throws java.rmi.RemoteException;
	/******************************************************************************/

	/******************************************************************************
	 * findAllPerfil :: T. EQUIVALENCIA
	 */

	public Equivalencia findEquivalenciaByCodCargo(String codCargo)
		throws java.rmi.RemoteException;
	public Vector findAllTerritorio() throws java.rmi.RemoteException;
	public boolean deleteEquivalencia(String cod_cargo)
	throws java.rmi.RemoteException;
	public boolean createEquivalencia(Equivalencia equivalencia) throws java.rmi.RemoteException;
	
	/******************************************************************************
	 * findAllPerfil :: T. TERRITORIO 
	 */
	public Territorio findByCodTerritorio(String codTerritorio)
		throws java.rmi.RemoteException;
	/******************************************************************************
	 * findAllPerfil :: T. OFICINA 
	 */

	public Oficina findByCodOficina(String codOficina)
		throws java.rmi.RemoteException;
	public Parametro findParametroAll() throws java.rmi.RemoteException;
	public Vector findListaByCodOficina(String codOficina)
		throws java.rmi.RemoteException;
	public Multitabla findMultiByPrimaryKey(String codMulti, String codElem)
		throws java.rmi.RemoteException;
	/******************************************************************************/

	/******************************************************************************
	 * findAllPerfil :: T. PLANES
	 */
	
	public Vector findByMultiForPresup(String codMulti, String Valor2)
		throws java.rmi.RemoteException;
	public Plan findConsultaPlanesResumen(
		String mes,
		String anho,
		String codEpigrafe,
		String codOficina) throws java.rmi.RemoteException;
	/******************************************************************************/

	/******************************************************************************
	 * findAllPerfil :: T. EPIGRAFE
	 */
	public Vector findEpiByAnho(String anho) throws java.rmi.RemoteException;
	public Epigrafe findByCodEpigAnho(String codEpigrafe, String anho)
		throws java.rmi.RemoteException;
	/******************************************************************************/

	/******************************************************************************
	 * findAllPerfil :: T. METAS GESTOR
	 */
	public MetasGestor findMetGestorByPrimaryKey(
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String codGestor) throws java.rmi.RemoteException;
	public boolean createMetasGestor(MetasGestor metasGestor)
		throws java.rmi.RemoteException;
	public boolean updateMetasGestor(MetasGestor metasGestor)
		throws java.rmi.RemoteException;
	/******************************************************************************
	 * findAllPerfil :: T. UTILS
	 */
	public String getCorrelativo(String nomTabla, String nomCampo, String tamano)
		throws java.rmi.RemoteException;
	/******************************************************************************
	 * findAllPerfil :: T. FIRMAS
	 */

	public Firmas findFirmByAnoMesCgesItem(
		String anho,
		String mes,
		String codGestor,
		String item) throws java.rmi.RemoteException;
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
	public Vector consultarCampaniasDetallesPGG(
		String codigoOficina,
		String mes,
		String anho,
		String codigoGestor) throws java.rmi.RemoteException;
	public Vector consultarPlanesAccionesPPG(
		String codigoOficina,
		String mes,
		String anho,
		String codigoGestor) throws java.rmi.RemoteException;
	
	public boolean updatePlan(Plan plan)
	throws java.rmi.RemoteException;
	
	/**
	 * CODIGO GENERADO POR OSCAR
	 * @author Stefanini
	 *
	 * To change the template for this generated type comment go to
	 * Window - Preferences - Java - Code Style - Code Templates
	 */
	
	/******************************************************************************
	 * A�O ACCION 
	 */
	public Vector busAllAnho() throws java.rmi.RemoteException;
	public Hashtable reportePGOResumen2(
		String codTerritorio,
		String mes,
		String anho) throws java.rmi.RemoteException;
	/******************************************************************************
	 * REPORTE PGO RESUMEN 
	 */
	public Vector reportePGOResumen(String codTerritorio, Hashtable hash)
		throws java.rmi.RemoteException;
	public Vector busAccionesPGG3(
			String codAnho,
			String codMes,
			String codGestor,
			String codEpigrafe) throws java.rmi.RemoteException;
	public int codigoAccion() throws java.rmi.RemoteException;
	public Vector eliminarAccion(String codAccion)
		throws java.rmi.RemoteException;
	public Vector busAnhosAcciones() throws java.rmi.RemoteException;
	public Vector busAnhoMaxAcciones() throws java.rmi.RemoteException;
	public Vector codOficinaMax(String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector reportePGO1(String codAnho, String codMes, String codOficina)
		throws java.rmi.RemoteException;
	
	/******************************************************************************
	 * REPORTE PGG ACCIONES 
	 */

	public Vector busAllAnhos() throws java.rmi.RemoteException;
	public Vector busGestorxOficina(String codOficina)
		throws java.rmi.RemoteException;
	public Vector busOficinaCodyNom(String codTerritorio)
		throws java.rmi.RemoteException;
	
	public Vector eliminarCampania(String codCamp)
		throws java.rmi.RemoteException;
	public Vector mostrarEditarCampania(String codCamp)
		throws java.rmi.RemoteException;
	/******************************************************************************
	 * REOPRTES 
	 */
	public Vector listaReportePlanificacion() throws java.rmi.RemoteException;
	public Vector busEpigrafeAcciones2(
		String codGestor,
		String anho,
		String mes,
		String codOficina) throws java.rmi.RemoteException;
	public int codigoCampMax() throws java.rmi.RemoteException;
	
	public Vector listaReporteSeguimiento2(String anho, String mes)
		throws java.rmi.RemoteException;
	public Vector listaReporteSeguimiento1(String anho, String mes)
		throws java.rmi.RemoteException;
	public Vector listaReportePPG(String anho, String mes)
		throws java.rmi.RemoteException;
	
	public int busID_IngresoMax() throws java.rmi.RemoteException;
	public boolean createPlan(Plan plan) throws java.rmi.RemoteException;
	public boolean createEpigrafe(Epigrafe epigrafe)
		throws java.rmi.RemoteException;
	public boolean createMaestrPlan(
		String anho,
		String mes,
		String codOfi,
		String codTerr) throws java.rmi.RemoteException;
	// OSCAR CORTEZ

	public Vector busOficinaxTerritorio(String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector findPlanAnual(String anho, String codOficina)
		throws java.rmi.RemoteException;
	public Vector findAllOficinaConMetas(
		String codTerritorio,
		String mes,
		String anio) throws java.rmi.RemoteException;
	public boolean findByCodigoOficina(String codOficina)
		throws java.rmi.RemoteException;
	public boolean findOficinaAndTerri(String codTerritorio, String codOfi)
		throws java.rmi.RemoteException;
	public Vector busTerritorioxRegistroLDAP(String codGestor)
		throws java.rmi.RemoteException;
	/******************************************************************************/
	/** Autor: G. Ureta **/
	/** Metodo: borrarMaestro **/
	/** Detalle: Metodo que Elimina los registros de la tabla Maestro Planes **/
	/******************************************************************************/
	public boolean borrarMaestro() throws java.rmi.RemoteException;
	/******************************************************************************/
	/** Autor: G. Ureta **/
	/** Metodo: borrarPlanIngresado **/
	/** Detalle: Metodo que Elimina los registros de la tabla Epigrafe **/
	/******************************************************************************/
	public boolean borrarEpigrafe() throws java.rmi.RemoteException;
	public Vector findEpigrafeInf(String anho) throws java.rmi.RemoteException;
	/******************************************************************************
	 * findAllPerfil :: T. OFICINA 
	 */

	public Vector findAllOficinaByCodTerri_MOD1(
		String codTerritorio,
		String anho,
		String mes) throws java.rmi.RemoteException;
	public Vector findAllOficinaByCodTerri_MOD2(String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector editarTerritoriosDeOficinas(
		String codOficina,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector pggSeguimiento1(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional1(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Vector pggSeguimiento2(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional2(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public boolean existeDataMaestroPlanesMesAnio(String mes, String anio)
		throws java.rmi.RemoteException;
	public boolean existeDataPlanesMesAnio(String mes, String anio)
		throws java.rmi.RemoteException;
	public Vector findEpigrafesinPlanes(
		String codOficina,
		String anho,
		String mes) throws java.rmi.RemoteException;
	public Vector mostrarEsfuerzoCampania(
		String codGest,
		String mes,
		String anho,
		String codOficina) throws java.rmi.RemoteException;
	public Vector listaCampaniaDetalle(
		String codTerritorio,
		String codOficina,
		String codCamp,
		String mes,
		String anho) throws java.rmi.RemoteException;
	public boolean eliminarCampaniaDetalle(String codCamp)
		throws java.rmi.RemoteException;
	public Territorio findTerritorioByCodOficina(String codOficina)
		throws java.rmi.RemoteException;
	public int actualizarPorcentajeEpigrafe(Epigrafe datos)
		throws java.rmi.RemoteException;
	public Vector busAllTerritorioActivo() throws java.rmi.RemoteException;
	public Vector reportePGOResumenxAnioMes(
		String codTerritorio,
		String mes,
		String anio) throws java.rmi.RemoteException;
	public Vector busGestorxOficinaxAnioxMes(
		String codOficina,
		String mes,
		String anio) throws java.rmi.RemoteException;
	
	public Accion busAccion(String codAccion) throws java.rmi.RemoteException;
	
	public Campanias busCampaniaDetalle(String codCampaniaDetalle)
		throws java.rmi.RemoteException;
	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil)
		throws java.rmi.RemoteException;
	public boolean updatePermisoPerfil(
		PermisoPerfil origPermisoPerfil,
		PermisoPerfil nuevoPermisoPerfil) throws java.rmi.RemoteException;
	public Vector reportePGOEsfuerzos(
		String codAnho,
		String codMes,
		String codOficina) throws java.rmi.RemoteException;
	public int metasGestor(
		String codGestor,
		int anio,
		int mes,
		String codEpigrafe) throws java.rmi.RemoteException;
	public int metasOficina(
		String codOficina,
		int anio,
		int mes,
		String codEpigrafe) throws java.rmi.RemoteException;
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
	public Vector xBusAllTablaFirmas() throws java.rmi.RemoteException;
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
	public Vector xBusAllTablaTerritorioAntiguo()
		throws java.rmi.RemoteException;
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
	public Vector xBusAllTablaEpigrafesAntiguo()
		throws java.rmi.RemoteException;
	public String xDameTerritorio(String codigoOficina)
		throws java.rmi.RemoteException;
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
	public String buscarEstadoFlag() throws java.rmi.RemoteException;
	public int actualizarEstadoFlag(String flag)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaAccionesAntiguo(String mes, String anho)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaPlanes(String mes, String anho)
		throws java.rmi.RemoteException;
	public Vector xBusAllTablaCampanhasAntiguo(String anho)
		throws java.rmi.RemoteException;
	public int obtenerPrimerMesPresup() throws java.rmi.RemoteException;
	public boolean createUpdatePlan(Plan plan) throws java.rmi.RemoteException;
	public Vector buscarUsuariosLDAP(
		String codOficina,
		String codEmpresa,
		int limiteOcurrencias) throws java.rmi.RemoteException;
	public boolean eliminarProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public boolean actualizarProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public boolean crearProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public Vector findTodosProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public ProgSeguimiento findProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional1(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public Vector pggSeguimiento2(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional2(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public ProgSeguimiento findProgramacionSeguimiento(
		String mes,
		String anio,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector pggSeguimiento1(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public Vector busIngresoxDIA(String codTerritorioUsuario)
		throws java.rmi.RemoteException;
	public Vector busIngresoxOFICINAxAnho(
		String anho,
		String codOficina,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxOFICINAxMes(
		String mes,
		String codOficina,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxTERRITORIOxAnho(
		String anho,
		String nomTerritorio,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxTERRITORIOxMes(
		String mes,
		String nomTerritorio,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxUSUARIOxAnho(
		String anho,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxUSUARIOxMes(String mes, String codTerritorioUsuario)
		throws java.rmi.RemoteException;
	public void actualizarIngreso(
		int tipo,
		int idIngreso,
		String mes,
		String anio) throws java.rmi.RemoteException;
	public Vector busIngresoxUsuario(
		String anho,
		String mes,
		String dia,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	/******************************************************************************
	 * INGRESOS 
	 */

	public int nuevoIngreso(
		String id_ingresos,
		String codUsuario,
		String cargo,
		String nomTerritorio,
		String codOficina,
		String nombres) throws java.rmi.RemoteException;
	public Vector busIngresoxOficina(
		String anho,
		String mes,
		String dia,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxTerritorio(
		String anho,
		String mes,
		String dia,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public MetasGestor findGestorByCodigo(String codGestor)
		throws java.rmi.RemoteException;
	public MetasGestor findGestorByCodMonthYear(
		String anho,
		String mes,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	
	/******************************************************************************
	 * findAllPerfil :: T. PLANES
	 */
	@SuppressWarnings("unchecked")
	public Vector findConsultaPlanes(
		String codTerritorio,
		String codOficina,
		String anho,
		String mes,
		String presuReferencia) throws java.rmi.RemoteException;
	public boolean updateElemMultitabla(Multitabla multitabla)
		throws java.rmi.RemoteException;
	public int findMesesReferencia(int mes, int anio)
		throws java.rmi.RemoteException;
	public boolean insertUpdateMesesReferencia(int mes, int anio, int sel_mes)
		throws java.rmi.RemoteException;
	public String testearBD() throws java.rmi.RemoteException;
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
	public Vector distribuirGOF(
		Vector listaGestoresLDAP,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes) throws java.rmi.RemoteException;
	public HashMap buscarResumenMontos(
		Vector listaEpigrafe,
		String codTerritorio,
		String codOficina,
		String anho,
		String mes) throws java.rmi.RemoteException;
	public BigDecimal buscarMontoGestor(
		String codGestor,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes) throws java.rmi.RemoteException;
	public Oficina findByCodOficinaHija(String codOficina)
		throws java.rmi.RemoteException;
	public void editarMensajeTerritorio(
		String codTerritorio,
		String mensaje,
		String colorFondo) throws java.rmi.RemoteException;
	public void eliminarMetaGestoresHijas(Vector listaGestores)
		throws java.rmi.RemoteException;
	public Vector editarOficina(Oficina oficina)
		throws java.rmi.RemoteException;
	/*public Vector eliminarOficina(String codOficina) {

	 SesionOficina aSesionOficina = createSesionOficina();
	 try {
	 Vector aVector = aSesionOficina.eliminarOficina(codOficina);
	 return aVector;
	 } catch (RemoteException ex) {
	 // Auto-generated catch block
	 ex.printStackTrace();
	 return null;
	 }
	 }*/

	public int eliminarOficina(String codOficina)
		throws java.rmi.RemoteException;
	public Vector nuevoTerritorio(
		String codTerritorio,
		String nomTerritorio,
		String mensaje,
		String colorFondo,
		String usuario) throws java.rmi.RemoteException;
	public Vector modificarTerritorio(
		String codTerritorio,
		String nomTerritorio,
		String estado,
		String mensaje,
		String colorFondo,
		String usuario) throws java.rmi.RemoteException;
	/** *************************************************************************** */
	/** Autor: G. Ureta * */
	/** Metodo: borrarPlanIngresado * */
	/** Detalle: Meque Elimina los registros de la tabla Planes * */
	/** *************************************************************************** */
	public boolean borrarPlanIngresado(String usuario)
		throws java.rmi.RemoteException;
	public Vector nuevaAccion(
		String cod_acci,
		String cod_epigrafe,
		String anho,
		String cod_terr,
		String cod_ofic,
		String nom_acci,
		String cod_gest,
		String mes_acci,
		String nro_clie,
		String comp_gest,
		String nro_gest_segu_1,
		String nro_conc_segu_1,
		String mon_segu_1,
		String nro_gest_segu_2,
		String nro_conc_segu_2,
		String mon_segu_2,
		String usuario) throws java.rmi.RemoteException;
	/***************************************************************************
	 * CAMPA�AS
	 */
	public Vector nuevaCampania(
		int codCamp,
		String nomCamp,
		String codOficicina,
		String codTerritorio,
		String codGestor,
		String anho,
		String mes,
		String orden,
		String get,
		String usuario,
		String codEpigrafe) throws java.rmi.RemoteException;
	public Vector editarCampania(
		String anho,
		String mes,
		String nomCamp,
		String orden,
		String codCamp,
		String usuario,
		String codEpigrafe) throws java.rmi.RemoteException;
	// MEQUE ACTUALIZA LA TABLA E SEGUIMIENTOS
	public boolean actualizarSeguimiento1(
		String tipoSeguimiento,
		String numDato,
		String codigo1,
		String codigo2,
		String valor,
		String usuario) throws java.rmi.RemoteException;
	public boolean actualizarSeguimiento2(
		String tipoSeguimiento,
		String numDato,
		String codigo1,
		String codigo2,
		String valor,
		String usuario) throws java.rmi.RemoteException;
	public boolean nuevoCampaniaDetalle(
		String codTerritorio,
		String codOficina,
		String codCampania,
		String mes,
		String anho,
		String nomCampania,
		String codGest,
		int nroClie,
		double compGest,
		String usuario) throws java.rmi.RemoteException;
	public boolean edicionCampaniaDetalle(
		String codCampaniaDetalle,
		String nomCampania,
		int nroClie,
		double compGest,
		String usuario) throws java.rmi.RemoteException;
	public boolean edicionAccion(
		String codAccion,
		String descAccion,
		String numeroCliente,
		String compromisoGestor,
		String usuario) throws java.rmi.RemoteException;
	public void actualizarMetaGestoresPlanes(
		Vector listaEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String codGestorGOF,
		String usuario) throws java.rmi.RemoteException;
	public void actualizarCargoGestoresLDAP(
		Vector listaGestoresLDAP,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String usuario) throws java.rmi.RemoteException;
	public void actualizarGestoresDistribuidosLDAP(
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String usuario) throws java.rmi.RemoteException;
	public void actualizarGestoresEliminadosLDAP(
		Vector listaGestoresLDAP,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String usuario) throws java.rmi.RemoteException;
	public Vector reportexUsuario(
		int dia,
		int mes,
		int anio,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector reportexOficina(
		int dia,
		int mes,
		int anio,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector reportexTerritorio(
		int dia,
		int mes,
		int anio,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector reportexUsuarioxAnio(int anio, String codTerritorio)
		throws java.rmi.RemoteException;
	public ArrayList listarDiasMesesxAnio(int anio)
		throws java.rmi.RemoteException;
	public Vector reportexOficinaxAnio(int anio, String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector reportexTerritorioxAnio(int anio, String codTerritorio)
		throws java.rmi.RemoteException;
	public void insertarIngresoForm(
		int tipo,
		int mes,
		int anio,
		String codUsuario,
		String editUsuario,
		String codGestor,
		String codOficina) throws java.rmi.RemoteException;
	public long existeIngresoForm(
		int tipo,
		int mes,
		int anio,
		String codUsuario,
		String fecha, String codGestorM, String codOficinaM) throws java.rmi.RemoteException;
	public void actualizarIngresoFormEditUsuario(long id)
		throws java.rmi.RemoteException;
	public Vector busOficinaxTerritorio(String codTerritorio, boolean showAll)
		throws java.rmi.RemoteException;
	public Vector exportarTablasTXT(int tabla, int mes, int anio)
		throws java.rmi.RemoteException;
	public int registrarPermisoPerfil(PermisoPerfil permisoPerfil)
		throws java.rmi.RemoteException;
	public int listadoIngresoxDia(String diaActual, String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector nuevaMetaGestor(
		String codMetaGestor,
		String codTerritorio,
		String codOficina,
		String codEpigrafe,
		String anho,
		String codGestor,
		String codigoPerfil,
		String mes,
		Double porc_asig,
		String nom_epigrafe,
		String nom_gestor,
		String usuario) throws java.rmi.RemoteException;
	public int nuevaOficina(
		String codTerritorio,
		String codOficina,
		String nomOficina,
		String usuario) throws java.rmi.RemoteException;

	/** Begin: Juan Quedena */
	
	public HashMap<String, Integer> findCantidadPersonal(String anho, String mes, String codOfi, String codTerr) throws java.rmi.RemoteException;
	
	public BigDecimal promedioMensual(String anho, String mes, String codOfi, String codTerr, String codEpi, String codGestor) throws java.rmi.RemoteException;
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

	/** End: Juan Quedena */
}
