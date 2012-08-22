package indra.bbva.pizele.action;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.common.SelectItem;
import indra.bbva.pizele.domain.base.Gestor;
import indra.bbva.pizele.domain.base.Oficina;
import indra.bbva.pizele.domain.base.Parametro;
import indra.bbva.pizele.domain.base.Semaforo;
import indra.bbva.pizele.domain.base.Territorio;
import indra.bbva.pizele.service.GestorService;
import indra.bbva.pizele.service.OficinaService;
import indra.bbva.pizele.service.ParametroService;
import indra.bbva.pizele.service.SemaforoService;
import indra.bbva.pizele.service.TerritorioService;
import indra.core.FechaUtil;
import indra.core.GenericAction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

public class ComunAction extends GenericAction{
	
	private static final long serialVersionUID = 6733772570978436604L;
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private TerritorioService territorioService;
	
	@Resource
	private OficinaService oficinaService;
	
	@Resource
	private ParametroService parametroService;
	
	@Resource(name="gestorService")
	private GestorService ldapPeru2Service;
	
	@Resource
	private SemaforoService semaforoService;
	
	// ---- FIELD'S ----
	
	private String codigoTerritorioFiltro;
	private String codigoOficinaFiltro;
	
	private List<Territorio> listaTerritorios;
	private List<Oficina> listaOficinas;
	private List<SelectItem> listaAnios;
	private List<Parametro> listaMeses;
	private List<Gestor> listaGestores;
		
	private InputStream excelStream;
	
	private String anio = "-1";
	private Long mes = -1L;
	private String semana = "-1";
	
	private Long rangosuperior;
	private Long rangomedio1;
	private Long rangomedio2;
	private Long rangoinferior;
	
	// ---- ACTION'S ----
	
	@Actions( {
		@Action(value="/filtrarOficinas")
	})
	public void buscarOficinas() throws Exception
	{		
		try
		{	
			super.renderListaObjetosJson(this.getOficinaService().listarOficinas(this.getCodigoTerritorioFiltro()));
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/filtrarGestores")
	})
	public void buscarGestores() throws Exception
	{		
		try
		{	
			super.renderListaObjetosJson(this.getLdapPeru2Service().listarGestorOficinaSinSubGerente(this.getCodigoOficinaFiltro()));
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	// ----  METHOD'S ----
	
	public void cargarTerritorios()
	{
		this.setListaTerritorios(this.getTerritorioService().listarTerritorios());		
	}
	
	public void cargarOficinas()
	{			
		if(CurrentUser.Instance().getTerritorio() != null)
		{								
			this.setListaOficinas(this.getOficinaService().listarOficinas(CurrentUser.Instance().getTerritorio().getCodigo()));
		}
		else if(this.getCodigoTerritorioFiltro() != null && this.getCodigoTerritorioFiltro().length() > 0)
		{
			this.setListaOficinas(this.getOficinaService().listarOficinas(this.getCodigoTerritorioFiltro()));
		}	
		else
			this.setListaOficinas(new ArrayList<Oficina>());

	}
	
	public void cargarGestores()
	{
		if(CurrentUser.Instance().getTerritorio() != null && CurrentUser.Instance().getOficina() != null)
		{
			this.setListaGestores(this.getLdapPeru2Service().listarGestorOficinaSinSubGerente(CurrentUser.Instance().getOficina().getCodigo()));
		}
		else if(this.getCodigoOficinaFiltro() != null && this.getCodigoOficinaFiltro().length() > 0)
		{
			this.setListaGestores(this.getLdapPeru2Service().listarGestorOficinaSinSubGerente(this.getCodigoOficinaFiltro()));
		}
		else
		{
			this.setListaGestores(new ArrayList<Gestor>());
		}
	}
	
	public void cargarAnios()
	{
		List<SelectItem> listaAnios = new ArrayList<SelectItem>();
		SelectItem objAnio = null;
		int anioActual = FechaUtil.anioActual();
		for(int inicio = (anioActual - 3); inicio <= (anioActual+5); inicio++)
		{
			objAnio = new SelectItem();
			objAnio.setCodigo(String.valueOf(inicio));
			objAnio.setDescripcion(String.valueOf(inicio));
			listaAnios.add(objAnio);
		}
		this.setListaAnios(listaAnios);		
	}
	
	public void cargarAniosHistorico()
	{
		List<SelectItem> listaAnios = new ArrayList<SelectItem>();
		SelectItem objAnio = null;
		int anioActual = FechaUtil.anioActual();
		for(int inicio = 2012; inicio <= anioActual; inicio++)
		{
			objAnio = new SelectItem();
			objAnio.setCodigo(String.valueOf(inicio));
			objAnio.setDescripcion(String.valueOf(inicio));
			listaAnios.add(objAnio);
		}
		this.setListaAnios(listaAnios);		
	}
	
	public void cargarAnios_DiasAnt_Actual(int dias)
	{
		List<SelectItem> listaAnios = new ArrayList<SelectItem>();
		SelectItem objAnio = null;
		int anioActual = FechaUtil.anioActual();
		for(int inicio = (anioActual - dias); inicio <= anioActual; inicio++)
		{
			objAnio = new SelectItem();
			objAnio.setCodigo(String.valueOf(inicio));
			objAnio.setDescripcion(String.valueOf(inicio));
			listaAnios.add(objAnio);
		}
		this.setListaAnios(listaAnios);		
	}
	
	
	public void cargarMeses()
	{
		Parametro objParametro = new Parametro();
		objParametro.setIdParametroPadre(Constantes.ParmetroID.MES);
		this.setListaMeses(this.getParametroService().listarParametro(objParametro));		
	}
	
	public Long getIdMesEspecifico(List<Parametro> listaMeses, Long valorEnteroMes)
	{
		Long idMes = new Long(0);
		valorEnteroMes--;
		for (Parametro parametro : listaMeses) {
			if (parametro.getValorEntero().equals(valorEnteroMes)) {
				idMes = parametro.getId();
				break;
			}
		}
		return idMes;
	}
		
	public Long mesActual()
	{
		Long valorEnteroMes = Long.valueOf(String.valueOf(FechaUtil.mesActualToInt()));
		return this.getIdMesEspecifico(this.getListaMeses(), valorEnteroMes);
	}
	
	public String semanaActual()
	{
		return String.valueOf(FechaUtil.semanaActual());
	}
	
	public void actualizarDirectorioInforme() throws IOException
	{
		File fileInforme = new File(super.getServletContext().getRealPath("temp") + File.separator + "Informe_" + CurrentUser.Instance().getCodigoRegistro());
		if(fileInforme.exists())
		{
			File[] files = fileInforme.listFiles();
			for (File file : files) 
			{
				file.delete();
			}		
		}
		else
		{
			fileInforme.mkdir();
		}
	}
	
	public String obtenerRutaInforme()
	{
		return super.getServletContext().getRealPath("temp") + File.separator + "Informe_" + CurrentUser.Instance().getCodigoRegistro() + File.separator;
	}
	
	public String obtenerNombreCarpetaInforme()
	{
		return "Informe_" + CurrentUser.Instance().getCodigoRegistro();
	}
	
	public void configurarSemaforo()
	{
		
		List<Semaforo> lstSemaforo = new ArrayList<Semaforo>();
		lstSemaforo =  this.getSemaforoService().listarSemaforo(new Semaforo());
		
		for (Semaforo semaforo : lstSemaforo)
		{

			if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_1.longValue() ){
				setRangosuperior(semaforo.getRango1());
			}
			
			if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_2.longValue() ){
				setRangomedio1(semaforo.getRango1());
				setRangomedio2(semaforo.getRango2());
			}
			
			if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_3.longValue() ){
				setRangoinferior(semaforo.getRango2());
			}
		}
	}

	// ---- GETTER'S AND SETTER'S ----
	
	public void setListaOficinas(List<Oficina> listaOficinas) {
		this.listaOficinas = listaOficinas;
	}

	public List<Oficina> getListaOficinas() {
		return listaOficinas;
	}

	public List<Territorio> getListaTerritorios() {
		return listaTerritorios;
	}

	public void setListaTerritorios(List<Territorio> listaTerritorios) {
		this.listaTerritorios = listaTerritorios;
	}

	public List<SelectItem> getListaAnios() {
		return listaAnios;
	}

	public void setListaAnios(List<SelectItem> listaAnios) {
		this.listaAnios = listaAnios;
	}

	public List<Parametro> getListaMeses() {
		return listaMeses;
	}

	public void setListaMeses(List<Parametro> listaMeses) {
		this.listaMeses = listaMeses;
	}

	public TerritorioService getTerritorioService() {
		return territorioService;
	}

	public void setTerritorioService(TerritorioService territorioService) {
		this.territorioService = territorioService;
	}

	public OficinaService getOficinaService() {
		return oficinaService;
	}

	public void setOficinaService(OficinaService oficinaService) {
		this.oficinaService = oficinaService;
	}

	public String getCodigoTerritorioFiltro() {
		return codigoTerritorioFiltro;
	}

	public void setCodigoTerritorioFiltro(String codigoTerritorioFiltro) {
		this.codigoTerritorioFiltro = codigoTerritorioFiltro;
	}

	public ParametroService getParametroService() {
		return parametroService;
	}

	public void setParametroService(ParametroService parametroService) {
		this.parametroService = parametroService;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public GestorService getLdapPeru2Service() {
		return ldapPeru2Service;
	}

	public void setLdapPeru2Service(GestorService ldapPeru2Service) {
		this.ldapPeru2Service = ldapPeru2Service;
	}

	public List<Gestor> getListaGestores() {
		return listaGestores;
	}

	public void setListaGestores(List<Gestor> listaGestores) {
		this.listaGestores = listaGestores;
	}

	public String getCodigoOficinaFiltro() {
		return codigoOficinaFiltro;
	}

	public void setCodigoOficinaFiltro(String codigoOficinaFiltro) {
		this.codigoOficinaFiltro = codigoOficinaFiltro;
	}

	public Long getRangosuperior() {
		return rangosuperior;
	}

	public void setRangosuperior(Long rangosuperior) {
		this.rangosuperior = rangosuperior;
	}

	public Long getRangomedio1() {
		return rangomedio1;
	}

	public void setRangomedio1(Long rangomedio1) {
		this.rangomedio1 = rangomedio1;
	}

	public Long getRangomedio2() {
		return rangomedio2;
	}

	public void setRangomedio2(Long rangomedio2) {
		this.rangomedio2 = rangomedio2;
	}

	public Long getRangoinferior() {
		return rangoinferior;
	}

	public void setRangoinferior(Long rangoinferior) {
		this.rangoinferior = rangoinferior;
	}

	public SemaforoService getSemaforoService() {
		return semaforoService;
	}

	public void setSemaforoService(SemaforoService semaforoService) {
		this.semaforoService = semaforoService;
	}
	
	
	
}

