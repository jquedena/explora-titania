package indra.bbva.pizele.action;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.AsignacionRubro;
import indra.bbva.pizele.domain.extend.AsignacionRubroDetalle;
import indra.bbva.pizele.service.AsignacionRubroService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;

import java.util.ArrayList;
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
@Controller("confRubroAction")
@Scope("prototype")
public class ConfRubroAction extends ComunAction
{

	private static final long serialVersionUID = 8323237915301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private AsignacionRubroService asignacionRubroService;
	
	// ---- FIELD'S ----
	
	private List<AsignacionRubroDetalle> listaRubroFijo;
	private List<AsignacionRubroDetalle> listaRubroAdicional;
	
	private AsignacionRubro asignacionRubro_Filtro;
	
	private String codigosEliminar;
	private String codigosGuardar;
	
	private String exportarRubroFijo;
	
	// ---- ACTION'S ----
	
	@Actions( {
		@Action(value="/iniciarConfiguracionRubro",
				results={@Result(name="success",type="tiles",location="configRubro"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarConfiguracionRubro()
	{		
		try
		{	
			
			super.cargarTerritorios();
			super.cargarOficinas();
			super.cargarAnios();
			super.cargarMeses();
					
			super.setAnio(String.valueOf(FechaUtil.anioActual()));
			this.cargarRubrosFijos(Long.parseLong(String.valueOf(FechaUtil.anioActual())));
				
			super.setCurrentUser(CurrentUser.Instance());
			String perfil = "";
			
			if(CurrentUser.Instance() != null) {
				
				if(CurrentUser.Instance().getCodigoPerfil() != null) {
					perfil = CurrentUser.Instance().getCodigoPerfil();  
				} else {
					if(CurrentUser.Instance().getCodigoPerfilGOF() != null) {
						perfil = CurrentUser.Instance().getCodigoPerfilGOF(); 
					}
				}
			
				if(Constantes.Perfil.GERENTE_TERRITORIO.equalsIgnoreCase(perfil) || Constantes.Perfil.JEFE_PROMOCION_NEGOCIOS.equalsIgnoreCase(perfil)) {
					this.cargarRubrosAdicionales(super.getCurrentUser().getTerritorio().getCodigo()
							, "-1"
							, Long.parseLong(String.valueOf(FechaUtil.anioActual()))
							, -1L);
				}
				else if(Constantes.Perfil.GERENTE_OFICINA.equalsIgnoreCase(perfil)) {
					this.cargarRubrosAdicionales(super.getCurrentUser().getTerritorio().getCodigo()
							, super.getCurrentUser().getOficina().getCodigo()
							, Long.parseLong(String.valueOf(FechaUtil.anioActual()))
							, -1L);
				}
				else if(super.getCurrentUser().getEsBackupSuplente()) {
					this.cargarRubrosAdicionales(super.getCurrentUser().getTerritorio().getCodigo()
							, super.getCurrentUser().getOficina().getCodigo()
							, Long.parseLong(String.valueOf(FechaUtil.anioActual()))
							, -1L);
				}
			}
		}
		catch(Exception ex)
		{	
			super.addActionError(ex.getMessage());
			this.logger.error("iniciarConfiguracionRubro", ex);
			return ERROR;
		}
					
		return SUCCESS;
	}
	
	@Actions( {
		@Action(value="/filtrarRubros")
	})
	public void filtrarRubros() throws Exception
	{
		try
		{
			this.cargarRubrosFijos(this.getAsignacionRubro_Filtro().getAnio());	
			
			this.cargarRubrosAdicionales(this.getAsignacionRubro_Filtro().getCodterr(), 
					 					 this.getAsignacionRubro_Filtro().getCodofic(), 
					 					 this.getAsignacionRubro_Filtro().getAnio(),
					 					 this.getAsignacionRubro_Filtro().getMes());
			
			super.renderJsonEXITO_LISTA_DOBLE(this.getListaRubroFijo(), this.getListaRubroAdicional());
			
		}
		catch(Exception ex)
		{	
			this.logger.error("filtrarRubros", ex);
			super.renderJsonERROR(ex.getMessage());
		}
	}
		
	@Actions( {
		@Action(value="/validarSuprimirRubroFijo")
	})
	public void validarSuprimirRubroFijo() throws Exception
	{
		try
		{
			
			String ids[] = this.getCodigosEliminar().split("\\|");
			AsignacionRubroDetalle objAsignacionRubroDetalle = null;
			
			for(String id : ids)
			{
				if(id.equals(""))
					continue;
			
								
				if(this.getAsignacionRubroService().existeRelacionEpigrafe(Long.parseLong(id)))
				{
					objAsignacionRubroDetalle = new AsignacionRubroDetalle();
					objAsignacionRubroDetalle.setId(Long.parseLong(id));
					objAsignacionRubroDetalle = this.getAsignacionRubroService().listarRubrosAsignadosPorTipo(objAsignacionRubroDetalle).get(0);
					throw new Exception("La asignación del rubro " + objAsignacionRubroDetalle.getNombreRubro() + " no se puede suprimir ya que se encuentra asignada a un epígrafe.");
				}
				
				if(this.getAsignacionRubroService().existeRelacionRubroLogro(Long.parseLong(id)))
				{
					objAsignacionRubroDetalle = new AsignacionRubroDetalle();
					objAsignacionRubroDetalle.setId(Long.parseLong(id));
					objAsignacionRubroDetalle = this.getAsignacionRubroService().listarRubrosAsignadosPorTipo(objAsignacionRubroDetalle).get(0);
					throw new Exception("La asignación del rubro " + objAsignacionRubroDetalle.getNombreRubro() + " nose se puede suprimir ya que se encuentra utilizada en el registro de logros.");
				}
				
			}
			
			super.renderJsonEXITO("");
			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/validarSuprimirRubroAdicional")
	})
	public void validarSuprimirRubroAdicional() throws Exception
	{
		try
		{
			
			String ids[] = this.getCodigosEliminar().split("\\|");
			AsignacionRubroDetalle objAsignacionRubroDetalle = null;
			
			for(String id : ids)
			{
				if(id.equals(""))
					continue;
															
				if(this.getAsignacionRubroService().existeRelacionRubroLogro(Long.parseLong(id)))
				{
					objAsignacionRubroDetalle = new AsignacionRubroDetalle();
					objAsignacionRubroDetalle.setId(Long.parseLong(id));
					objAsignacionRubroDetalle = this.getAsignacionRubroService().listarRubrosAsignadosPorTipo(objAsignacionRubroDetalle).get(0);
					throw new Exception("La asignación del rubro " + objAsignacionRubroDetalle.getNombreRubro() + " nose se puede suprimir ya que se encuentra utilizada en el registro de logros.");
				}
				
			}
			
			super.renderJsonEXITO("");
			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/guardarConfiguracionRubro")
	})
	public void guardarConfiguracionRubro() throws Exception
	{
		try
		{		
			
			super.setCurrentUser(CurrentUser.Instance());
			List<AsignacionRubro> listaAsignacionRubro = new ArrayList<AsignacionRubro>();
			AsignacionRubro objAsignacionRubro = null;
			
			String[] idRubros = null;
			
			if(this.getCodigosGuardar() != null)
			{
				idRubros = this.getCodigosGuardar().split("\\|");

				for(int index = 0; index < idRubros.length; index++)
				{
					objAsignacionRubro = new AsignacionRubro();
					objAsignacionRubro.setIdrubro(Long.parseLong(idRubros[index]));
					objAsignacionRubro.setCodterr(this.getAsignacionRubro_Filtro().getCodterr());
					objAsignacionRubro.setCodofic(this.getAsignacionRubro_Filtro().getCodofic());
					objAsignacionRubro.setAnio(this.getAsignacionRubro_Filtro().getAnio());
					objAsignacionRubro.setMes(this.getAsignacionRubro_Filtro().getMes());
					objAsignacionRubro.setUsuarioCreacion(super.getCurrentUser().getCodigoRegistro());
					listaAsignacionRubro.add(objAsignacionRubro);
				}
			}
					
			AsignacionRubroDetalle objAsignacionRubroDetalle = new AsignacionRubroDetalle();
			objAsignacionRubroDetalle.setCodterr(this.getAsignacionRubro_Filtro().getCodterr());
			objAsignacionRubroDetalle.setCodofic(this.getAsignacionRubro_Filtro().getCodofic());
			objAsignacionRubroDetalle.setAnio(this.getAsignacionRubro_Filtro().getAnio());
			objAsignacionRubroDetalle.setMes(this.getAsignacionRubro_Filtro().getMes());
			if(objAsignacionRubroDetalle.getCodterr().equals("-1"))
				objAsignacionRubroDetalle.setTipoRubro(Constantes.TipoRubro.Fijo);
			else
				objAsignacionRubroDetalle.setTipoRubro(Constantes.TipoRubro.Adicional);
			
			this.getAsignacionRubroService().guardarAsignacionRubros(objAsignacionRubroDetalle, listaAsignacionRubro, super.getCurrentUser().getCodigoRegistro());
									
			super.renderJsonEXITO(super.getMensaje("AsignacionRubro.exito.insert"));
			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
        @Action(value="/exportarExcelRubro",
                        results={@Result(name="success",type="stream",
                                                         params={"contentType", "application/vnd.ms-excel",
                                                                         "inputName", "excelStream",
                                                                         "contentDisposition", "attachment;filename=\"formRubro.xls\"",
                                                                         "bufferSize", "1024"}),
                                         @Result(name="error",type="tiles",location="panel")})
	})
	public String exportarExcelRubro() throws Exception     {
	        try     {                       
	                String[] exportar = this.getExportarRubroFijo().split("\\|");
	                DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formRubro.xls"));
	                doc.setContentValue(6, 1, exportar[0]);
	                doc.setContentValue(6, 4, exportar[1]);
	                doc.setContentValue(7, 1, exportar[2]);
	                doc.setContentValue(7, 4, exportar[3]);
   
	                int index;
	                int rowIndex = 10;
	                
	                for(index = 4; index < exportar.length; index++) {
	                        if(exportar[index].trim().length() > 0) {
	                                if(exportar[index].equalsIgnoreCase("~")) {
	                                        rowIndex++;
	                                        doc.setLabelValue(rowIndex, 0, "Rubros Adicionales");
	                                        doc.setLabelValue(rowIndex + 1, 0, "GERENTE DE TERRITORIO");
	                                        doc.setLabelValue(rowIndex + 2, 0, "ó");
	                                        doc.setLabelValue(rowIndex + 3, 0, "GERENTE DE OFICINA");
	                                        
	                                        doc.setBarraTitulo(rowIndex, 2, 5, "Descripción");	                                        
	                                }
	                                else	                                	
	                                	doc.setContentValue(rowIndex, 2, exportar[index]);
	                                
	                                rowIndex++;
	                        }
	                }
	                
	                this.setExcelStream(doc.getExcelStream());                      
	        }
	        catch(Exception ex) {
	                ex.printStackTrace();
	                this.logger.error(ex.getMessage());
	                return ERROR;
	        }
	        
	        return SUCCESS;
	}


	
	// ---- PRIVATE METHOD'S ----
	
	private void cargarRubrosFijos(Long anio)
	{
		AsignacionRubroDetalle objAsigRubDetFiltro = new AsignacionRubroDetalle();
		objAsigRubDetFiltro.setCodterr("-1");
		objAsigRubDetFiltro.setCodofic("-1");
		objAsigRubDetFiltro.setAnio(anio);
		objAsigRubDetFiltro.setMes(-1L);
		objAsigRubDetFiltro.setTipoRubro(Constantes.TipoRubro.Fijo);
		this.setListaRubroFijo(this.getAsignacionRubroService().listarRubrosAsignadosPorTipo(objAsigRubDetFiltro));				
	}
	
	private void cargarRubrosAdicionales(String codTerr, String codOfi, Long anio, Long mes)
	{
		AsignacionRubroDetalle objAsigRubDetFiltro = new AsignacionRubroDetalle();
		objAsigRubDetFiltro.setCodterr(codTerr);
		objAsigRubDetFiltro.setCodofic(codOfi);
		objAsigRubDetFiltro.setAnio(anio);
		objAsigRubDetFiltro.setMes(mes);
		objAsigRubDetFiltro.setTipoRubro(Constantes.TipoRubro.Adicional);
		this.setListaRubroAdicional(this.getAsignacionRubroService().listarRubrosAsignadosPorTipo(objAsigRubDetFiltro));
	}
	
	// ---- GETTER'S AND SETTER'S ----
	
	public List<AsignacionRubroDetalle> getListaRubroFijo() {
		return listaRubroFijo;
	}


	public void setListaRubroFijo(List<AsignacionRubroDetalle> listaRubroFijo) {
		this.listaRubroFijo = listaRubroFijo;
	}


	public List<AsignacionRubroDetalle> getListaRubroAdicional() {
		return listaRubroAdicional;
	}


	public void setListaRubroAdicional(
			List<AsignacionRubroDetalle> listaRubroAdicional) {
		this.listaRubroAdicional = listaRubroAdicional;
	}

	public AsignacionRubroService getAsignacionRubroService() {
		return asignacionRubroService;
	}

	public void setAsignacionRubroService(
			AsignacionRubroService asignacionRubroService) {
		this.asignacionRubroService = asignacionRubroService;
	}

	public AsignacionRubro getAsignacionRubro_Filtro() {
		return asignacionRubro_Filtro;
	}

	public void setAsignacionRubro_Filtro(AsignacionRubro asignacionRubro_Filtro) {
		this.asignacionRubro_Filtro = asignacionRubro_Filtro;
	}

	public String getCodigosEliminar() {
		return codigosEliminar;
	}

	public void setCodigosEliminar(String codigosEliminar) {
		this.codigosEliminar = codigosEliminar;
	}

	public String getCodigosGuardar() {
		return codigosGuardar;
	}

	public void setCodigosGuardar(String codigosGuardar) {
		this.codigosGuardar = codigosGuardar;
	}

	public String getExportarRubroFijo() {
		return exportarRubroFijo;
	}

	public void setExportarRubroFijo(String exportarRubroFijo) {
		this.exportarRubroFijo = exportarRubroFijo;
	}
	
}
