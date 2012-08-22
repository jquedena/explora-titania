package indra.bbva.pizele.action;

import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.Backup;
import indra.bbva.pizele.domain.base.Gestor;
import indra.bbva.pizele.domain.extend.BackupDetalle;
import indra.bbva.pizele.service.BackupService;
import indra.bbva.pizele.service.GestorService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ParentPackage("default")
@Controller("confBackupAction")
@Scope("prototype")
public class ConfBackupAction extends ComunAction
{

	private static final long serialVersionUID = 8323237915301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private BackupService backupService;
	
	@Resource
	private GestorService gestorService;
	
	// ---- FIELD'S ----
	
	private List<BackupDetalle> listaBackupVigente;	
	private List<Gestor> listaGestorBackup;
	private Backup backupEdicion;
	
	private String codigoGOF;
	private String codigosBackup;
	
	private String nombreNuevoBackup_Excel;
	private String fechaVigencia_Excel;
	
	// ---- ACTION'S ----
	
	@Actions( {
		@Action(value="/iniciarBackupSuplente",
				results={@Result(name="success",type="tiles",location="configBackup"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarBackupSuplente()
	{		
		try
		{	
			if(CurrentUser.Instance().getTerritorio() != null)
				this.setCodigoTerritorioFiltro(CurrentUser.Instance().getTerritorio().getCodigo());
			if( CurrentUser.Instance().getOficina() != null)
				this.setCodigoOficinaFiltro(CurrentUser.Instance().getOficina().getCodigo());
	
			super.cargarTerritorios();
			super.cargarOficinas();
			
			this.cargarListaGestoresBackup();
			this.cargarListaBackupVigente();
		}
		catch(Exception ex)
		{	
			super.addActionError(ex.getMessage());
			this.logger.error("iniciarBackupSuplente", ex);
			return ERROR;
		}
					
		return SUCCESS;
	}
	
	@Actions( {
		@Action(value="/guardarBackupSuplenteValidacion")
	})
	public void guardarBackupSuplenteValidacion() throws Exception
	{
		try
		{	
			this.cargarListaGestoresBackup();
			
			Date fechaVigencia = FechaUtil.formatoFechaDate(this.getBackupEdicion().getFechaVigente());
			
			if(FechaUtil.compareDate(fechaVigencia, new Date()) > 0)			
				throw new Exception(super.getMensaje("Backup.error.fecha_vigencia"));
			
			Backup objBackupVal = new Backup();
			
			objBackupVal.setCodigoGestorSuplente(this.getBackupEdicion().getCodigoGestorSuplente());
			objBackupVal.setFechaVigente(FechaUtil.format_yyyyMMdd(this.getBackupEdicion().getFechaVigente()));
			List<BackupDetalle> listaBackup = this.getBackupService().listarBackupVigenteDetalleTraslape(objBackupVal, this.getListaGestorBackup());
			
		
			if(listaBackup.size() > 0)
			{
				if(listaBackup.get(0).getFechaVigente().equals(this.getBackupEdicion().getFechaVigente()))
				{
					throw new Exception(super.getMensaje("Backup.error.fecha_vigencia.repetido"));	
				}	
				else
				{
					String msg = "El Gestor " + listaBackup.get(0).getNombreCompleto() + " ya fue registrado como Backup hasta la fecha " +
					listaBackup.get(0).getFechaVigente() + ". &#191;Desea reemplazar la vigencia?";
					
					super.renderJsonPREGUNTA(msg);					
				}			
			}
			else
			{
				this.getBackupEdicion().setCodigoGOF(CurrentUser.Instance().getCodigoRegistro());
				this.getBackupEdicion().setUsuarioCreacion(CurrentUser.Instance().getCodigoRegistro());
				
			
				Gestor gestor = gestorService.obtenerGestor(objBackupVal.getCodigoGestorSuplente(), this.getListaGestorBackup());
				
				
				this.getBackupEdicion().setNombreGestorSuplente(gestor.getNombre());
				this.getBackupEdicion().setApellidoPatergestorSuplente(gestor.getApellidoPaterno());
				this.getBackupEdicion().setApellidoMaternogestorSuplente(gestor.getApellidoMaterno());
				

				this.getBackupEdicion().setFechaVigente(FechaUtil.format_yyyyMMdd(this.getBackupEdicion().getFechaVigente()));
				this.getBackupService().insertarBackup(this.getBackupEdicion());
				
				this.cargarListaBackupVigente();				
				super.renderJsonEXITO_LISTA(super.getMensaje("Backup.exito.insert"), this.getListaBackupVigente());
			}
			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/actualizarBackupSuplente")
	})
	public void actualizarBackupSuplente() throws Exception
	{
		try
		{		
			this.cargarListaGestoresBackup();
			this.getBackupEdicion().setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
			this.getBackupEdicion().setFechaVigente(FechaUtil.format_yyyyMMdd(this.getBackupEdicion().getFechaVigente()));
			this.getBackupService().actualizarBackupVigente(this.getBackupEdicion());
			
			this.cargarListaBackupVigente();				
			super.renderJsonEXITO_LISTA(super.getMensaje("Backup.exito.update"), this.getListaBackupVigente());
						
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/exportarExcelBackupSuplente",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"formBackupSuplente.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	public String exportarExcelBackupSuplente() throws Exception
	{
		try
		{	
			this.cargarListaGestoresBackup();
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formBackupSuplente.xls"));
			doc.setContentValue(6, 1, CurrentUser.Instance().getTerritorio().getDescripcion());
			doc.setContentValue(6, 4, CurrentUser.Instance().getOficina().getDescripcion());
			doc.setContentValue(7, 2, CurrentUser.Instance().getNombreCompleto());
			this.cargarListaBackupVigente();
			
			int rowIndex = 9;
			
			for(int index = 0; index < this.getListaBackupVigente().size(); index++)
			{
				doc.setContentValue(rowIndex, 2, this.getListaBackupVigente().get(index).getCodigoGestorSuplente());
				doc.setContentValue(rowIndex, 3, this.getListaBackupVigente().get(index).getNombreCompleto());
				doc.setContentValue(rowIndex, 5, this.getListaBackupVigente().get(index).getFechaVigente());
				rowIndex++;
			}
			
			rowIndex++;
			
			doc.setLabelValue(rowIndex, 0, "Nuevo Gestor Backup : ");
			doc.setContentValue(rowIndex, 2, this.getNombreNuevoBackup_Excel());
			rowIndex++;
			doc.setLabelValue(rowIndex, 0, "Será Backup hasta el día : ");
			doc.setContentValue(rowIndex, 2, this.getFechaVigencia_Excel());
			
			this.setExcelStream(doc.getExcelStream());			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
		
	}
	
	@Actions( {
		@Action(value="/eliminarBackupSuplente")
	})
	public void eliminarBackupSuplente() throws Exception
	{
		try
		{		
			this.cargarListaGestoresBackup();
			String[] idsArray = this.getCodigosBackup().split("\\|");
			List<Backup> listaBackup = new ArrayList<Backup>();
			Backup objBackup = null;
			
			for(int index = 0; index < idsArray.length; index++)
			{
				objBackup = new Backup();
				objBackup.setId(Long.valueOf(idsArray[index]));
				objBackup.setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
				listaBackup.add(objBackup);
			}
			
			this.getBackupService().eliminarBackup(listaBackup);
			this.cargarListaBackupVigente();				
			super.renderJsonEXITO_LISTA(super.getMensaje("Backup.exito.delete"), this.getListaBackupVigente());
						
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	// ---- PRIVATE METHOD'S ----
	
	public void cargarListaBackupVigente()
	{   
		
		Backup objBackup = new Backup();
		objBackup.setCodigoGOF(CurrentUser.Instance().getCodigoRegistro());
		this.setListaBackupVigente(this.getBackupService().listarBackupVigenteDetalle(objBackup, this.getListaGestorBackup()));
	}
	
	private void cargarListaGestoresBackup()
	{
		this.setListaGestorBackup(this.getGestorService().listarGestorOficina(CurrentUser.Instance().getCodigoOficina()));
	}
	
	// ---- GETTER'S AND SETTER'S ----
	
	public List<BackupDetalle> getListaBackupVigente() {
		return listaBackupVigente;
	}

	public void setListaBackupVigente(List<BackupDetalle> listaBackupVigente) {
		this.listaBackupVigente = listaBackupVigente;
	}

	public BackupService getBackupService() {
		return backupService;
	}

	public void setBackupService(BackupService backupService) {
		this.backupService = backupService;
	}

	public GestorService getGestorService() {
		return gestorService;
	}

	public void setGestorService(GestorService gestorService) {
		this.gestorService = gestorService;
	}

	public List<Gestor> getListaGestorBackup() {
		return listaGestorBackup;
	}

	public void setListaGestorBackup(List<Gestor> listaGestorBackup) {
		this.listaGestorBackup = listaGestorBackup;
	}

	public Backup getBackupEdicion() {
		return backupEdicion;
	}

	public void setBackupEdicion(Backup backupEdicion) {
		this.backupEdicion = backupEdicion;
	}

	public String getCodigosBackup() {
		return codigosBackup;
	}

	public void setCodigosBackup(String codigosBackup) {
		this.codigosBackup = codigosBackup;
	}

	public String getNombreNuevoBackup_Excel() {
		return nombreNuevoBackup_Excel;
	}

	public void setNombreNuevoBackup_Excel(String nombreNuevoBackup_Excel) {
		this.nombreNuevoBackup_Excel = nombreNuevoBackup_Excel;
	}

	public String getFechaVigencia_Excel() {
		return fechaVigencia_Excel;
	}

	public void setFechaVigencia_Excel(String fechaVigencia_Excel) {
		this.fechaVigencia_Excel = fechaVigencia_Excel;
	}
		
}
