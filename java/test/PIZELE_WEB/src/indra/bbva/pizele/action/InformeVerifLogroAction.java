package indra.bbva.pizele.action;


import indra.bbva.pizele.domain.extend.VerificacionLogroDetalle;
import indra.bbva.pizele.domain.extend.VerificacionLogroParametro;
import indra.bbva.pizele.service.VerificacionLogroService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;
import indra.core.ImagenReporte;

import java.io.File;
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
@Controller("informeVerifLogroAction")
@Scope("prototype")
public class InformeVerifLogroAction extends ComunAction
{

	private static final long serialVersionUID = 8323237915301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private VerificacionLogroService verificacionLogroService;
	
	// ---- FIELD'S ----
	
	private VerificacionLogroParametro verificacionLogroParametroFiltro;
	
	
	
	@Actions( {
		@Action(value="/iniciarVerificacionLogros",
				results={@Result(name="success",type="tiles",location="informeVerifLogro"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarVerificacionLogros()
	{		
		try
		{	
			super.cargarTerritorios();
			super.cargarOficinas();
			super.cargarGestores();
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
		@Action(value="/buscarVerificacionLogro")
	})
	public void buscarVerificacionLogro() throws Exception
	{
		try
		{	
			
			super.actualizarDirectorioInforme();
			
			if(this.getVerificacionLogroParametroFiltro().getFechaDesde() != null && this.getVerificacionLogroParametroFiltro().getFechaDesde().length() > 0)
				this.getVerificacionLogroParametroFiltro().setFechaDesde(FechaUtil.format_yyyyMMdd(this.getVerificacionLogroParametroFiltro().getFechaDesde()));
		
			if(this.getVerificacionLogroParametroFiltro().getFechaHasta() != null && this.getVerificacionLogroParametroFiltro().getFechaHasta().length() > 0)
				this.getVerificacionLogroParametroFiltro().setFechaHasta(FechaUtil.format_yyyyMMdd(this.getVerificacionLogroParametroFiltro().getFechaHasta()));
			
			List<VerificacionLogroDetalle> listaVerificacionLogroDetalle = this.getVerificacionLogroService().listarVerificacionLogro(this.getVerificacionLogroParametroFiltro());
						
			ImagenReporte objImagenReporte = new ImagenReporte();
			
			if(listaVerificacionLogroDetalle.size() == 0)
			{
				objImagenReporte.setPath("");
			}
			else
			{
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();	
				
				int width = 0;
				
				for(VerificacionLogroDetalle objetoVerifLogro : listaVerificacionLogroDetalle)
				{
					width += 200;
					dataset.addValue(objetoVerifLogro.getLogroReportado(), "Reportado", objetoVerifLogro.getDescRubro());
					dataset.addValue(objetoVerifLogro.getLogroConcretado(), "Logrado", objetoVerifLogro.getDescRubro());
				}
				
				JFreeChart chart = ChartFactory.createBarChart3D("",			
						"",			
						"",			
						dataset,			
						PlotOrientation.VERTICAL,			
						true,			
						true,			
						false);	
				
				String fileName = "verifLogro_" + new Date().getTime() + ".jpg";
				
				ChartUtilities.saveChartAsJPEG(new File(super.obtenerRutaInforme() + fileName), chart, width, 500); 
				
				objImagenReporte.setPath(super.getRequest().getContextPath() + "/temp/" + super.obtenerNombreCarpetaInforme() + "/" + fileName);
				objImagenReporte.setWidth(width + 50);
				objImagenReporte.setHeight(550);
				
			}
			
			super.renderJsonEXITO_OBJETO("", objImagenReporte);
				
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/exportarExcelVerificacionLogro",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"verificacionLogro.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	public String exportarExcelVerificacionLogro() throws Exception
	{
		try
		{	

			super.actualizarDirectorioInforme();
			
			if(this.getVerificacionLogroParametroFiltro().getFechaDesde() != null && this.getVerificacionLogroParametroFiltro().getFechaDesde().length() > 0)
				this.getVerificacionLogroParametroFiltro().setFechaDesde(FechaUtil.format_yyyyMMdd(this.getVerificacionLogroParametroFiltro().getFechaDesde()));
		
			if(this.getVerificacionLogroParametroFiltro().getFechaHasta() != null && this.getVerificacionLogroParametroFiltro().getFechaHasta().length() > 0)
				this.getVerificacionLogroParametroFiltro().setFechaHasta(FechaUtil.format_yyyyMMdd(this.getVerificacionLogroParametroFiltro().getFechaHasta()));
			
			List<VerificacionLogroDetalle> listaVerificacionLogroDetalle = this.getVerificacionLogroService().listarVerificacionLogro(this.getVerificacionLogroParametroFiltro());
					
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formVerificacionLogro.xls"));
			
			doc.setContentValue(6, 1, this.getVerificacionLogroParametroFiltro().getDescTerritorio());
            doc.setContentValue(6, 4, this.getVerificacionLogroParametroFiltro().getDescOficina());
            doc.setContentValue(7, 1, this.getVerificacionLogroParametroFiltro().getNombreGestor());
            doc.setContentValue(8, 1, this.getVerificacionLogroParametroFiltro().getFechaDesde());
            doc.setContentValue(8, 4, this.getVerificacionLogroParametroFiltro().getFechaHasta());
                        
            doc.setImagen(1, 0, super.getServletContext().getRealPath(File.separator + "images" + File.separator + "logo" + File.separator + "bbva.JPG"));
            
			if(listaVerificacionLogroDetalle.size() > 0)
			{
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();	
				
				int width = 0;
				
				for(VerificacionLogroDetalle objetoVerifLogro : listaVerificacionLogroDetalle)
				{
					width += 100;
					dataset.addValue(objetoVerifLogro.getLogroReportado(), "Reportado", objetoVerifLogro.getDescRubro());
					dataset.addValue(objetoVerifLogro.getLogroConcretado(), "Logrado", objetoVerifLogro.getDescRubro());
				}
				
				JFreeChart chart = ChartFactory.createBarChart3D("",			
						"",			
						"",			
						dataset,			
						PlotOrientation.VERTICAL,			
						true,			
						true,			
						false);	
				
				String fileName = "verifLogro_" + new Date().getTime() + ".jpg";
				
				ChartUtilities.saveChartAsJPEG(new File(super.obtenerRutaInforme() + fileName), chart, width, 500);
				
				doc.setImagen(10, 0,  super.obtenerRutaInforme() + fileName);
				
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


	// ---- GETTER'S AND SETTER'S ----
	
	public VerificacionLogroService getVerificacionLogroService() {
		return verificacionLogroService;
	}

	public void setVerificacionLogroService(
			VerificacionLogroService verificacionLogroService) {
		this.verificacionLogroService = verificacionLogroService;
	}

	public VerificacionLogroParametro getVerificacionLogroParametroFiltro() {
		return verificacionLogroParametroFiltro;
	}

	public void setVerificacionLogroParametroFiltro(
			VerificacionLogroParametro verificacionLogroParametroFiltro) {
		this.verificacionLogroParametroFiltro = verificacionLogroParametroFiltro;
	}
	
}
