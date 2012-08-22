package indra.bbva.pizele.action;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.domain.base.RubroLogro;
import indra.bbva.pizele.domain.base.Semaforo;
import indra.bbva.pizele.domain.extend.InformeParametro;
import indra.bbva.pizele.domain.extend.RankingDetalle;
import indra.bbva.pizele.domain.extend.RubroLogroMeta;
import indra.bbva.pizele.domain.extend.VerificacionLogroDetalle;
import indra.bbva.pizele.service.ResumenCumplimientoService;
import indra.bbva.pizele.service.ResumenEstadisticoService;
import indra.bbva.pizele.service.SemaforoService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;
import indra.core.ImagenReporte;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ParentPackage("default")
@Controller("informeResumEstadisAction")
@Scope("prototype")
public class InformeResumEstadisAction extends ComunAction
{

	private static final long serialVersionUID = 8323237915301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	@Resource
	private ResumenEstadisticoService resumenEstadisticoService;
		
	// ---- FIELD'S ----
		
	private InformeParametro informeParametro;
	
	// ---- ACTION'S ----
	
	@Actions( {
		@Action(value="/iniciarResumenEstadistico",
				results={@Result(name="success",type="tiles",location="informeResumEstadis"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarResumenEstadistico()
	{		
		try
		{	
			super.cargarTerritorios();
			super.cargarOficinas();
			super.cargarGestores();
			super.cargarAniosHistorico();
			super.cargarMeses();
			
			super.setAnio(String.valueOf(FechaUtil.anioActual()));
			super.setMes(super.mesActual());
			super.configurarSemaforo();
			
		}
		catch(Exception ex)
		{	
			super.addActionError(ex.getMessage());
			this.logger.error(ex.getMessage());
			return ERROR;
		}
					
		return SUCCESS;
	}

	@Actions( {
		@Action(value="/buscarResumenEstadistico")
	})
	public void buscarResumenEstadistico() throws Exception
	{
		try
		{	
			
			super.actualizarDirectorioInforme();
			
			List<RubroLogroMeta> listaRubroLogroMeta = this.getResumenEstadisticoService().listarRubroEstadistico(this.getInformeParametro());
						
			if(listaRubroLogroMeta.size() == 0)
				super.renderJsonRESULTADO("", Constantes.TipoResultado.NO_DATA);
			else
			{
				for(RubroLogroMeta objRubroLogroMeta : listaRubroLogroMeta)
				{
					objRubroLogroMeta.setPathReporte(this.crearGraficoBarras(objRubroLogroMeta).getPath());
				}
				
				super.renderJsonEXITO_LISTA("", listaRubroLogroMeta);
			}								
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}

	@Actions( {
		@Action(value="/exportarExcelResumenEstadistico",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"resumenEstadistico.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	public String exportarExcelResumenEstadistico() throws Exception
	{
		try
		{	

			super.actualizarDirectorioInforme();
			
			List<RubroLogroMeta> listaRubroLogroMeta = this.getResumenEstadisticoService().listarRubroEstadistico(this.getInformeParametro());
						
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formResumenEstadistico.xls"));
			
			doc.setImagen(1, 0, super.getServletContext().getRealPath(File.separator + "images" + File.separator + "logo" + File.separator + "bbva.JPG"));
			
			doc.setContentValue(6, 1, this.getInformeParametro().getDescTerritorio());
            doc.setContentValue(6, 4, this.getInformeParametro().getDescOficina());
            doc.setContentValue(7, 1, this.getInformeParametro().getNombreGestor());
            doc.setContentValue(8, 1, this.getInformeParametro().getIdAnio().toString());
            doc.setContentValue(8, 4, this.getInformeParametro().getDescMes());
            
            int column = 0;
            int row = 10;
            
			for(RubroLogroMeta objRubroLogroMeta : listaRubroLogroMeta)
			{
				
				doc.setBarraTitulo(row, column, column + 2,objRubroLogroMeta.getDescRubro());
				doc.setContentValueColor(row, column + 3, column + 3, objRubroLogroMeta.getPorcentajeCumplimiento() + "%", objRubroLogroMeta.getColor());
				
				ImagenReporte objImagenReporte = this.crearGraficoBarras(objRubroLogroMeta);
				
				doc.setImagen(row + 2, column,  super.obtenerRutaInforme() + objImagenReporte.getFileName());
				
				if(column == 0)				
					column = 4;				
				else
				{
					column = 0;
					row += 15;
				}						
					
			}
				 
			this.setExcelStream(doc.getExcelStream());			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
		
	}
	
	// ---- PRIVATE METHOD'S ----
	
	private ImagenReporte crearGraficoBarras(RubroLogroMeta objRubroLogroMeta) throws IOException
	{
		
		ImagenReporte objImagenReporte = new ImagenReporte();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();	
				
		dataset.addValue(objRubroLogroMeta.getPromedioHistorico(), "Prom. Histórico", objRubroLogroMeta.getPromedioHistorico());
		dataset.addValue(objRubroLogroMeta.getMeta(), "Meta", objRubroLogroMeta.getMeta());
		dataset.addValue(objRubroLogroMeta.getLogro(), "Logro", objRubroLogroMeta.getLogro());
		
		JFreeChart chart = ChartFactory.createBarChart3D("",			
				"",			
				"",			
				dataset,			
				PlotOrientation.VERTICAL,			
				true,			
				true,			
				false);	
		
		String fileName = "resumenEstadistico_" + new Date().getTime() + ".jpg";
		
		ChartUtilities.saveChartAsJPEG(new File(super.obtenerRutaInforme() + fileName), chart, 350, 250); 
		
		objImagenReporte.setFileName(fileName);
		objImagenReporte.setPath(super.getRequest().getContextPath() + "/temp/" + super.obtenerNombreCarpetaInforme() + "/" + fileName);

		return objImagenReporte;
	}
	
	// ---- GETTER'S AND SETTER'S ----
	
	public ResumenEstadisticoService getResumenEstadisticoService() {
		return resumenEstadisticoService;
	}

	public void setResumenEstadisticoService(
			ResumenEstadisticoService resumenEstadisticoService) {
		this.resumenEstadisticoService = resumenEstadisticoService;
	}

	public InformeParametro getInformeParametro() {
		return informeParametro;
	}

	public void setInformeParametro(InformeParametro informeParametro) {
		this.informeParametro = informeParametro;
	}

}
