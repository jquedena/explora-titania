package indra.bbva.pizele.action;

import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.AsignacionRubro;
import indra.bbva.pizele.domain.base.ConfEpigrafeAsignados;
import indra.bbva.pizele.domain.base.Epigrafe;
import indra.bbva.pizele.service.ConfEpigrafeAsigService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ParentPackage("default")
@Controller("confRelacionEpigrafeRubroAction")
@Scope("prototype")
public class ConfRelacionEpigrafeRubroAction extends ComunAction {

	private static final long serialVersionUID = 8323237915301658160L;
	private Logger logger = Logger.getLogger(this.getClass());

	// ---- INJECTION'S ----
	@Resource
	private ConfEpigrafeAsigService confEpigrafeAsigService;

	// ---- FIELD'S ----
	private String mesDestino;
	private String anioDestino;
	private Long idRubro;
	private String rubroEpigrafe;
	private String codEpigrafe;
	private String nomEpigrafe;
	private String exportar;
	private List<AsignacionRubro> listaRubroFijo;
	private List<Epigrafe> listaEpigrafeMIS;
	private List<Epigrafe> listaEpigrafeSDO;
	private List<Epigrafe> listaEpigrafeAsignado;

	// ---- ACTION'S ----
	@Actions( { @Action(value = "/iniciarEpigrafeRubro", results = {
		@Result(name = "success", type = "tiles", location = "configRelacionRubroEpigrafe"),
		@Result(name = "error", type = "tiles", location = "panel") })
	})
	public String iniciarEpigrafeRubro() {
		try {
			super.cargarAnios();
			super.cargarMeses();
			
			super.setAnio(String.valueOf(FechaUtil.anioActual()));
			this.setMes(Long.valueOf(FechaUtil.mesActual()) + 6);
			this.cargarRubrosFijos(Long.parseLong(this.getAnio()), null);
			
		} catch (Exception ex) {
			super.addActionError(ex.getMessage());
			this.logger.error(ex.getMessage());
			return ERROR;
		}

		return SUCCESS;
	}

	@Actions( {
		@Action(value="/cargarEpigrafeRubro")
	})
	public void cargarEpigrafeRubro() {
		try {
			this.cargarRubrosFijos(Long.parseLong(this.getAnio()), this.getMes());
			this.cargarEpigrafeSDO(Long.parseLong(this.getAnio()), this.getMes(), null);
			this.cargarEpigrafeAsignado(Long.parseLong(this.getAnio()), this.getMes(), this.getIdRubro());
			
			Map<String, Object> result = new HashMap<String, Object>(); 
			result.put("rubrosFijos", this.getListaRubroFijo());
			result.put("epigrafesSDO", this.getListaEpigrafeSDO());
			result.put("epigrafesAsignados", this.getListaEpigrafeAsignado());
			
			super.renderJsonEXITO_LISTA("Actualizando...", result);	
			
		} catch (Exception ex) {
			super.addActionError(ex.getMessage());
			this.logger.error(ex.getMessage());
		}

	}
	
	@Actions( {
		@Action(value="/buscarEpigrafeMIS")
	})
	public void buscarEpigrafeMIS() {
		try {
			this.cargarEpigrafeMIS(Long.parseLong(this.getAnio()), this.getMes(), null, this.getCodEpigrafe(), this.getNomEpigrafe());
						
			Map<String, Object> result = new HashMap<String, Object>(); 
			result.put("epigrafesMIS", this.getListaEpigrafeMIS());
			
			super.renderJsonEXITO_LISTA("Actualizando...", result);			
		} catch (Exception ex) {		
			super.addActionError(ex.getMessage());
			this.logger.error(ex.getMessage());
		}
	
	}
	
	@Actions( {
		@Action(value="/guardarRelacionRubroEpigrafe")
	})
	public void guardarRelacionRubroEpigrafe() throws Exception {
		try {		
			super.setCurrentUser(CurrentUser.Instance());
			
			List<ConfEpigrafeAsignados> listaRubroEpigrafe = new ArrayList<ConfEpigrafeAsignados>();
			ConfEpigrafeAsignados objRubroEpigrafe = null;
			String[] rubroEpigrafe = this.getRubroEpigrafe().split("\\|");
			String[] item = null;
			
			if(this.getRubroEpigrafe().trim().length() == 0) {
				objRubroEpigrafe = new ConfEpigrafeAsignados();
				objRubroEpigrafe.setAnio(Long.parseLong(this.getAnio()));
				objRubroEpigrafe.setMes(this.getMes());
				objRubroEpigrafe.setId_rubro(this.getIdRubro());
				this.getConfEpigrafeAsigService().eliminarTotalRubroEpigrafe(objRubroEpigrafe);
			} else {
				rubroEpigrafe = this.getRubroEpigrafe().split("\\|");
				item = null;
				
				for(int index = 0; index < rubroEpigrafe.length; index++) {
					objRubroEpigrafe = new ConfEpigrafeAsignados();
					objRubroEpigrafe.setAnio(Long.parseLong(this.getAnio()));
					objRubroEpigrafe.setMes(this.getMes());
					objRubroEpigrafe.setId_rubro(this.getIdRubro());
					objRubroEpigrafe.setUsuarioCreacion(super.getCurrentUser().getCodigoRegistro());
					
					item = rubroEpigrafe[index].split("\\_");
					objRubroEpigrafe.setId_epigrafe(item[0]);
					objRubroEpigrafe.setTip_epig(item[1]);
					objRubroEpigrafe.setId(Long.parseLong(item[2]));
					
					listaRubroEpigrafe.add(objRubroEpigrafe);
				}
			
				this.getConfEpigrafeAsigService().guardarRubroEpigrafe(listaRubroEpigrafe);
			}
			
			super.renderJsonEXITO(super.getMensaje("ConfRelacionEpigrafeRubro.exito.insert"));
		}
		catch(Exception ex)	{	
			this.logger.error(ex.getMessage(), ex);
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/copiarRelacionRubroEpigrafe")
	})
	public void copiarRelacionRubroEpigrafe() throws Exception {
		try {		
			super.setCurrentUser(CurrentUser.Instance());
			
			this.getConfEpigrafeAsigService().copiarRubroepigrafe(Long.parseLong(this.getAnioDestino())
					, Long.parseLong(this.getMesDestino())
					, this.getIdRubro()
					, Long.parseLong(this.getAnio())
					, this.getMes()
					, super.getCurrentUser().getCodigoRegistro());
			
			super.renderJsonEXITO(super.getMensaje("ConfRelacionEpigrafeRubro.exito.copy"));
		}
		catch(Exception ex)	{
			ex.printStackTrace();
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	private void cargarRubrosFijos(Long anio, Long mes) {
		AsignacionRubro objAsignacionRubro = new AsignacionRubro();
		objAsignacionRubro.setCodterr(null);
		objAsignacionRubro.setCodofic(null);
		objAsignacionRubro.setAnio(anio);
		objAsignacionRubro.setMes(mes);
		this.setListaRubroFijo(this.getConfEpigrafeAsigService().listarRubros(objAsignacionRubro));
	}

	private void cargarEpigrafeMIS(Long anio, Long mes, Long rubro, String codEpigrafe, String nomEpigrafe) {
		AsignacionRubro objAsignacionRubro = new AsignacionRubro();
		objAsignacionRubro.setIdrubro(rubro);
		objAsignacionRubro.setAnio(anio);
		objAsignacionRubro.setMes(mes);
		this.setListaEpigrafeMIS(this.getConfEpigrafeAsigService().listarEpigrafeMIS(objAsignacionRubro, codEpigrafe, nomEpigrafe));
	}
	
	private void cargarEpigrafeSDO(Long anio, Long mes, Long rubro) {
		AsignacionRubro objAsignacionRubro = new AsignacionRubro();
		objAsignacionRubro.setIdrubro(rubro);
		objAsignacionRubro.setAnio(anio);
		objAsignacionRubro.setMes(mes);
		this.setListaEpigrafeSDO(this.getConfEpigrafeAsigService().listarEpigrafeSDO(objAsignacionRubro));
	}
	
	private void cargarEpigrafeAsignado(Long anio, Long mes, Long rubro) {
		AsignacionRubro objAsignacionRubro = new AsignacionRubro();
		objAsignacionRubro.setIdrubro(rubro);
		objAsignacionRubro.setAnio(anio);
		objAsignacionRubro.setMes(mes);
		this.setListaEpigrafeAsignado(this.getConfEpigrafeAsigService().listarEpigrafesAsignados(objAsignacionRubro));
	}
	
	@Actions( {
		@Action(value="/exportarExcelRubroEpigrafe",
			results={@Result(name="success",type="stream",
				params={"contentType", "application/vnd.ms-excel",
					"inputName", "excelStream",
					"contentDisposition", "attachment;filename=\"formRubroEpigrafe.xls\"",
					"bufferSize", "1024"}),
			@Result(name="error",type="tiles",location="panel")})
	})
	public String exportarExcelRubroEpigrafe() throws Exception  {
		try {
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formRubroEpigrafe.xls"));
			String[] exportar = this.getExportar().split("\\|");
			
			doc.setContentValue(6, 1, exportar[0]);
			doc.setContentValue(6, 4, exportar[1]);
			doc.setContentValue(7, 1, exportar[2]);
			
			int index;
			int rowIndex = 10;
			int colIndex = 3;
			
			if(exportar.length > 3) { 
				for(index = 3; index < exportar.length; index++) {
					if(exportar[index].trim().length() > 0) {
						if(exportar[index].equalsIgnoreCase("~")) {
							rowIndex = 10;
							colIndex = 6;
							index++;
							if(index >= exportar.length) {
								break;
							}
						}
						doc.setContentValue(rowIndex, colIndex, exportar[index]);
						rowIndex++;
					}
				}
			}
			
			this.setExcelStream(doc.getExcelStream());                      
		}
		catch(Exception ex) {
			this.logger.error(ex.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	// ---- GETTER'S AND SETTER'S ----

	public ConfEpigrafeAsigService getConfEpigrafeAsigService() {
		return confEpigrafeAsigService;
	}

	public void setConfEpigrafeAsigService(
			ConfEpigrafeAsigService confEpigrafeAsigService) {
		this.confEpigrafeAsigService = confEpigrafeAsigService;
	}

	public String getMesDestino() {
		return mesDestino;
	}

	public void setMesDestino(String mesDestino) {
		this.mesDestino = mesDestino;
	}

	public String getAnioDestino() {
		return anioDestino;
	}

	public void setAnioDestino(String anioDestino) {
		this.anioDestino = anioDestino;
	}

	public List<AsignacionRubro> getListaRubroFijo() {
		return listaRubroFijo;
	}

	public void setListaRubroFijo(List<AsignacionRubro> listaRubroFijo) {
		this.listaRubroFijo = listaRubroFijo;
	}

	public List<Epigrafe> getListaEpigrafeMIS() {
		return listaEpigrafeMIS;
	}

	public void setListaEpigrafeMIS(List<Epigrafe> listaEpigrafeMIS) {
		this.listaEpigrafeMIS = listaEpigrafeMIS;
	}

	public List<Epigrafe> getListaEpigrafeSDO() {
		return listaEpigrafeSDO;
	}

	public void setListaEpigrafeSDO(List<Epigrafe> listaEpigrafeSDO) {
		this.listaEpigrafeSDO = listaEpigrafeSDO;
	}

	public Long getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(Long idRubro) {
		this.idRubro = idRubro;
	}

	public String getRubroEpigrafe() {
		return rubroEpigrafe;
	}

	public void setRubroEpigrafe(String rubroEpigrafe) {
		this.rubroEpigrafe = rubroEpigrafe;
	}

	public String getCodEpigrafe() {
		return codEpigrafe;
	}

	public void setCodEpigrafe(String codEpigrafe) {
		this.codEpigrafe = codEpigrafe;
	}

	public String getNomEpigrafe() {
		return nomEpigrafe;
	}

	public void setNomEpigrafe(String nomEpigrafe) {
		this.nomEpigrafe = nomEpigrafe;
	}

	public String getExportar() {
		return exportar;
	}

	public void setExportar(String exportar) {
		this.exportar = exportar;
	}

	public List<Epigrafe> getListaEpigrafeAsignado() {
		return listaEpigrafeAsignado;
	}

	public void setListaEpigrafeAsignado(List<Epigrafe> listaEpigrafeAsignado) {
		this.listaEpigrafeAsignado = listaEpigrafeAsignado;
	}
}
