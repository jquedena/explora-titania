package indra.bbva.pizele.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.domain.base.RubroLogro;
import indra.bbva.pizele.domain.base.Semaforo;
import indra.bbva.pizele.domain.extend.RankingDetalle;
import indra.bbva.pizele.domain.extend.VerificacionLogroDetalle;
import indra.bbva.pizele.service.ResumenCumplimientoService;
import indra.bbva.pizele.service.SemaforoService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;
import indra.core.ImagenReporte;

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

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;

@ParentPackage("default")
@Controller("informeResumCumpAction")
@Scope("prototype")
public class InformeResumCumpAction extends ComunAction
{

	private static final long serialVersionUID = 8323237915301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private ResumenCumplimientoService resumenCumplimientoService;
	
	// ---- FIELD'S ----
	
	private RubroLogro rubroLogroFiltro;
	private String exportarResumenCumplimiento;
	
	// ---- METHOD'S ----
	
	@Actions( {
		@Action(value="/iniciarResumenCumplimiento",
				results={@Result(name="success",type="tiles",location="informeResumCump"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarResumenCumplimiento()
	{		
		try
		{	
			super.cargarTerritorios();
			super.cargarOficinas();
			super.cargarAnios_DiasAnt_Actual(2);
			super.cargarMeses();
			
			super.setAnio(String.valueOf(FechaUtil.anioActual()));
			super.setMes(super.mesActual());
			super.setSemana(super.semanaActual());
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
		@Action(value="/buscarResumenCumplimiento")
	})
	public void buscarResumenCumplimiento() throws Exception
	{
		try
		{	
			
			super.actualizarDirectorioInforme();
			
			List<RankingDetalle> listaRankingRubroMensual = null;
			List<RankingDetalle> listaRankingRubroSemanal = null;
			List<RankingDetalle> listaRankingGestorMensual = null;
			List<RankingDetalle> listaRankingGestorSemanal = null;
			
			List<ImagenReporte> listaImagenReporte = null;
			
			boolean reporteSemanal = (this.getRubroLogroFiltro().getSemana() != -1L);
						
			if(reporteSemanal)
			{
				listaRankingRubroSemanal = this.getResumenCumplimientoService().listarRankingRubro(this.getRubroLogroFiltro());
				listaRankingGestorSemanal = this.getResumenCumplimientoService().listarRankingGestor(this.getRubroLogroFiltro());
				this.getRubroLogroFiltro().setSemana(-1L);
								
			}
			else
			{
				listaRankingRubroSemanal = new ArrayList<RankingDetalle>();
				listaRankingGestorSemanal = new ArrayList<RankingDetalle>();
			}
			
			listaRankingRubroMensual = this.getResumenCumplimientoService().listarRankingRubro(this.getRubroLogroFiltro());
			listaRankingGestorMensual = this.getResumenCumplimientoService().listarRankingGestor(this.getRubroLogroFiltro());
				
			List<RankingDetalle> listaFinalRankingGestor = new ArrayList<RankingDetalle>();
			RankingDetalle objRankingDetalle = null;
			IILDPeUsuario user = null;
			
			if(listaRankingGestorMensual.size() > 0)
			{
				for(RankingDetalle tempRankingDetalle : listaRankingGestorMensual)
				{
					user = IILDPeUsuario.recuperarUsuario(tempRankingDetalle.getCodGestor());
					if(user != null)
					{
						objRankingDetalle = new RankingDetalle();
						objRankingDetalle.setCodGestor(tempRankingDetalle.getCodGestor());
						objRankingDetalle.setColor(tempRankingDetalle.getColor());
						objRankingDetalle.setPorcentajeCumplimiento(tempRankingDetalle.getPorcentajeCumplimiento());
						objRankingDetalle.setNomGestor(user.getNombre());
						objRankingDetalle.setApellPatGestor(user.getApellido1());
						listaFinalRankingGestor.add(objRankingDetalle);
					}
				}
				
				listaRankingGestorMensual = listaFinalRankingGestor;
			}
			
			if(listaRankingGestorSemanal.size() > 0)
			{
				
				listaFinalRankingGestor = new ArrayList<RankingDetalle>();
				
				for(RankingDetalle tempRankingDetalle : listaRankingGestorSemanal)
				{
					user = IILDPeUsuario.recuperarUsuario(tempRankingDetalle.getCodGestor());
					if(user != null)
					{
						objRankingDetalle = new RankingDetalle();
						objRankingDetalle.setCodGestor(tempRankingDetalle.getCodGestor());
						objRankingDetalle.setColor(tempRankingDetalle.getColor());
						objRankingDetalle.setPorcentajeCumplimiento(tempRankingDetalle.getPorcentajeCumplimiento());
						objRankingDetalle.setNomGestor(user.getNombre());
						objRankingDetalle.setApellPatGestor(user.getApellido1());
						listaFinalRankingGestor.add(objRankingDetalle);
					}
				}
				
				listaRankingGestorSemanal = listaFinalRankingGestor;
			}
			
			if(listaRankingRubroMensual.size() == 0)			
				super.renderJsonRESULTADO("", Constantes.TipoResultado.NO_DATA);
			else
			{
				
				List<Object> listas = new ArrayList<Object>();
				
				List<ImagenReporte> listaImgReporte = new ArrayList<ImagenReporte>();
				listaImgReporte.add(this.crearGraficoBarrasRubro(listaRankingRubroMensual));				
				listaImgReporte.add(this.crearGraficoBarrasGestor(listaRankingGestorMensual));
				if(reporteSemanal)
				{
					listaImgReporte.add(this.crearGraficoBarrasRubro(listaRankingRubroSemanal));
					listaImgReporte.add(this.crearGraficoBarrasGestor(listaRankingGestorSemanal));
				}
								
				listas.add(listaRankingRubroMensual);
				listas.add(listaRankingRubroSemanal);				
				listas.add(listaRankingGestorMensual);
				listas.add(listaRankingGestorSemanal);
				listas.add(listaImgReporte);
				
				
				super.renderJson_LISTAS(listas, "", Constantes.TipoResultado.EXITO);
			}
				
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/exportarExcelResumenCumplimiento",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"formResumenCumplimiento.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	
	public String exportarExcelResumenCumplimiento() throws Exception
	{
		try
		{	

			String[] exportar = this.getExportarResumenCumplimiento().split("\\|");

			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formResumenCumplimiento.xls"));
			
			doc.setContentValue(6, 1, exportar[0]);
            doc.setContentValue(6, 4, exportar[1]);
            doc.setContentValue(7, 1, exportar[2]);
            doc.setContentValue(7, 4, exportar[3]);
            doc.setContentValue(8, 2, exportar[4]);
             
            super.actualizarDirectorioInforme();
 			
 			List<RankingDetalle> listaRankingRubroMensual = null;
 			List<RankingDetalle> listaRankingRubroSemanal = null;
 			List<RankingDetalle> listaRankingGestorMensual = null;
 			List<RankingDetalle> listaRankingGestorSemanal = null;
 			
 			boolean reporteSemanal = (this.getRubroLogroFiltro().getSemana() != -1L);
 			
 			if(reporteSemanal)
 			{
 				listaRankingRubroSemanal = this.getResumenCumplimientoService().listarRankingRubro(this.getRubroLogroFiltro());
 				listaRankingGestorSemanal = this.getResumenCumplimientoService().listarRankingGestor(this.getRubroLogroFiltro());
 				this.getRubroLogroFiltro().setSemana(-1L);
			
 			}
 			else
 			{
 				listaRankingRubroSemanal = new ArrayList<RankingDetalle>();
 				listaRankingGestorSemanal = new ArrayList<RankingDetalle>();
 			}
 			
 			listaRankingRubroMensual = this.getResumenCumplimientoService().listarRankingRubro(this.getRubroLogroFiltro());
 			listaRankingGestorMensual = this.getResumenCumplimientoService().listarRankingGestor(this.getRubroLogroFiltro());
            
 			doc.setImagen(1, 0, super.getServletContext().getRealPath(File.separator + "images" + File.separator + "logo" + File.separator + "bbva.JPG"));
 			
 			
 			List<RankingDetalle> listaFinalRankingGestor = new ArrayList<RankingDetalle>();
			RankingDetalle objRankingDetalle = null;
			IILDPeUsuario user = null;
			
			if(listaRankingGestorMensual.size() > 0)
			{
				for(RankingDetalle tempRankingDetalle : listaRankingGestorMensual)
				{
					user = IILDPeUsuario.recuperarUsuario(tempRankingDetalle.getCodGestor());
					if(user != null)
					{
						objRankingDetalle = new RankingDetalle();
						objRankingDetalle.setCodGestor(tempRankingDetalle.getCodGestor());
						objRankingDetalle.setColor(tempRankingDetalle.getColor());
						objRankingDetalle.setPorcentajeCumplimiento(tempRankingDetalle.getPorcentajeCumplimiento());
						objRankingDetalle.setNomGestor(user.getNombre());
						objRankingDetalle.setApellPatGestor(user.getApellido1());
						listaFinalRankingGestor.add(objRankingDetalle);
					}
				}
				
				listaRankingGestorMensual = listaFinalRankingGestor;
			}
			
			if(listaRankingGestorSemanal.size() > 0)
			{
				
				listaFinalRankingGestor = new ArrayList<RankingDetalle>();
				
				for(RankingDetalle tempRankingDetalle : listaRankingGestorSemanal)
				{
					user = IILDPeUsuario.recuperarUsuario(tempRankingDetalle.getCodGestor());
					if(user != null)
					{
						objRankingDetalle = new RankingDetalle();
						objRankingDetalle.setCodGestor(tempRankingDetalle.getCodGestor());
						objRankingDetalle.setColor(tempRankingDetalle.getColor());
						objRankingDetalle.setPorcentajeCumplimiento(tempRankingDetalle.getPorcentajeCumplimiento());
						objRankingDetalle.setNomGestor(user.getNombre());
						objRankingDetalle.setApellPatGestor(user.getApellido1());
						listaFinalRankingGestor.add(objRankingDetalle);
					}
				}
				
				listaRankingGestorSemanal = listaFinalRankingGestor;
			}
			
 			int filarubromensual = 10; 
 			
 			int _ini = 0;
 			int _fin = 0;
 			
 			if(listaRankingRubroMensual.size() > 0)
 			{
 				ImagenReporte imgReport = this.crearGraficoBarrasRubro(listaRankingRubroMensual);
 				doc.setBarraTitulo(filarubromensual, 1,3, "Ranking Mensual de Rubros");
 				doc.setImagen(filarubromensual, 4, super.obtenerRutaInforme() + imgReport.getFileName());
 				_ini = filarubromensual;
				filarubromensual++;
				
 				doc.setBarraTitulo(filarubromensual, 1, "Rubro");
				doc.setBarraTitulo(filarubromensual, 2, "%");
				doc.setBarraTitulo(filarubromensual, 3, " ");
				filarubromensual++;
				
				for(int i=0;i<listaRankingRubroMensual.size();i++) 
				{	
					doc.setContentValue(filarubromensual, 1, listaRankingRubroMensual.get(i).getDescRubro());
					doc.setContentValue(filarubromensual, 2, listaRankingRubroMensual.get(i).getPorcentajeCumplimiento().toString());
	                doc.setContentValueColor(filarubromensual, 3, 3, "", listaRankingRubroMensual.get(i).getColor());
	                filarubromensual++;
				}
				
				_fin = filarubromensual;
				_ini = _ini + (listaRankingRubroMensual.size() * 2) + 6; // 2 filas de cabecera + 4 filas de separacion

				filarubromensual = filarubromensual +(_ini - _fin);
 			}
 
 			if(listaRankingRubroSemanal.size() > 0)
 			{
 				ImagenReporte imgReport = this.crearGraficoBarrasRubro(listaRankingRubroSemanal);
 				doc.setBarraTitulo(filarubromensual, 1,3, "Ranking Semanal de Rubros");
 				doc.setImagen(filarubromensual, 4, super.obtenerRutaInforme() + imgReport.getFileName());
 				_ini = filarubromensual;
 				filarubromensual++;
 				
				doc.setBarraTitulo(filarubromensual, 1, "Rubro");
				doc.setBarraTitulo(filarubromensual, 2, "%");
				doc.setBarraTitulo(filarubromensual, 3, " ");
				filarubromensual++;
				
				for(int i=0;i<listaRankingRubroSemanal.size();i++) 
				{	
					doc.setContentValue(filarubromensual, 1, listaRankingRubroSemanal.get(i).getDescRubro());
					doc.setContentValue(filarubromensual, 2, listaRankingRubroSemanal.get(i).getPorcentajeCumplimiento().toString());
	                doc.setContentValueColor(filarubromensual, 3, 3, "", listaRankingRubroSemanal.get(i).getColor());
	                filarubromensual++;
				}
				
				_fin = filarubromensual;
				_ini = _ini + (listaRankingRubroSemanal.size() * 2) + 6; // 2 filas de cabecera + 4 filas de separacion

				filarubromensual = filarubromensual +(_ini - _fin);
 			}
            
 			
		
 			if(listaRankingGestorMensual.size() > 0)
 			{
 				ImagenReporte imgReport = this.crearGraficoBarrasGestor(listaRankingGestorMensual);
 				doc.setBarraTitulo(filarubromensual, 1,3, "Ranking Mensual de Gestor");
 				doc.setImagen(filarubromensual, 4, super.obtenerRutaInforme() + imgReport.getFileName());
 				_ini = filarubromensual;
 				filarubromensual++;
 				
				doc.setBarraTitulo(filarubromensual, 1, "Rubro");
				doc.setBarraTitulo(filarubromensual, 2, "%");
				doc.setBarraTitulo(filarubromensual, 3, " ");
				filarubromensual++;
				
				for(int i=0;i<listaRankingGestorMensual.size();i++) 
				{	
					doc.setContentValue(filarubromensual, 1, listaRankingGestorMensual.get(i).getNomGestor());
					doc.setContentValue(filarubromensual, 2, listaRankingGestorMensual.get(i).getPorcentajeCumplimiento().toString());
	                doc.setContentValueColor(filarubromensual, 3, 3, "", listaRankingGestorMensual.get(i).getColor());
	                filarubromensual++;
				}
				
				_fin = filarubromensual;
				_ini = _ini + (listaRankingGestorMensual.size() * 2) + 6; // 2 filas de cabecera + 4 filas de separacion

				filarubromensual = filarubromensual +(_ini - _fin);	
 			}

 			if(listaRankingGestorSemanal.size() > 0)
 			{
 				ImagenReporte imgReport = this.crearGraficoBarrasGestor(listaRankingGestorSemanal);
 				doc.setBarraTitulo(filarubromensual, 1,3, "Ranking Semanal de Gestor");
 				doc.setImagen(filarubromensual, 4, super.obtenerRutaInforme() + imgReport.getFileName());
 				filarubromensual++;
				
 				doc.setBarraTitulo(filarubromensual, 1, "Rubro");
				doc.setBarraTitulo(filarubromensual, 2, "%");
				doc.setBarraTitulo(filarubromensual, 3, " ");
				filarubromensual++;
				
				for(int i=0;i<listaRankingGestorSemanal.size();i++) 
				{	
					doc.setContentValue(filarubromensual, 1, listaRankingGestorSemanal.get(i).getNomGestor());
					doc.setContentValue(filarubromensual, 2, listaRankingGestorSemanal.get(i).getPorcentajeCumplimiento().toString());
	                doc.setContentValueColor(filarubromensual, 3, 3, "", listaRankingGestorSemanal.get(i).getColor());
	                filarubromensual++;
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
	
	private ImagenReporte crearGraficoBarrasRubro(List<RankingDetalle> listaRanking) throws IOException
	{
		
		ImagenReporte objImagenReporte = new ImagenReporte();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();	
		
		int height = 20;
		
		for(RankingDetalle objetoRankingDetalle : listaRanking)
		{
			height += 50;
			dataset.addValue(objetoRankingDetalle.getPorcentajeCumplimiento(), "%", objetoRankingDetalle.getDescRubro());
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("",			
				"",			
				"",			
				dataset,			
				PlotOrientation.HORIZONTAL,			
				true,			
				true,			
				false);	
	
		String fileName = "rankRubro_" + new Date().getTime() + ".jpg";
		
		ChartUtilities.saveChartAsJPEG(new File(super.obtenerRutaInforme() + fileName), chart, 550, height); 
		
		objImagenReporte.setPath(super.getRequest().getContextPath() + "/temp/" + super.obtenerNombreCarpetaInforme() + "/" + fileName);
		objImagenReporte.setHeight(height + 30);
		objImagenReporte.setFileName(fileName);
		
		return objImagenReporte;
	}
	
	private ImagenReporte crearGraficoBarrasGestor(List<RankingDetalle> listaRanking) throws IOException
	{
		
		ImagenReporte objImagenReporte = new ImagenReporte();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();	
		
		int height = 20;
		
		
		for(RankingDetalle objetoRankingDetalle : listaRanking)
		{
			height += 50;
			dataset.addValue(objetoRankingDetalle.getPorcentajeCumplimiento(), "%", objetoRankingDetalle.getNomGestor() + " " + objetoRankingDetalle.getApellPatGestor());
		}
				
		JFreeChart chart = ChartFactory.createBarChart3D("",			
				"",			
				"",			
				dataset,			
				PlotOrientation.HORIZONTAL,			
				true,			
				true,			
				false);	
	
		String fileName = "rankGestor_" + new Date().getTime() + ".jpg";
		
		ChartUtilities.saveChartAsJPEG(new File(super.obtenerRutaInforme() + fileName), chart, 600, height); 
		
		objImagenReporte.setPath(super.getRequest().getContextPath() + "/temp/" + super.obtenerNombreCarpetaInforme() + "/" + fileName);
		objImagenReporte.setHeight(height + 30);
		objImagenReporte.setFileName(fileName);
		
		return objImagenReporte;
	}
	
	// ---- GETTER'S AND SETTER'S ----
		
	public RubroLogro getRubroLogroFiltro() {
		return rubroLogroFiltro;
	}
	public void setRubroLogroFiltro(RubroLogro rubroLogroFiltro) {
		this.rubroLogroFiltro = rubroLogroFiltro;
	}

	public ResumenCumplimientoService getResumenCumplimientoService() {
		return resumenCumplimientoService;
	}

	public void setResumenCumplimientoService(
			ResumenCumplimientoService resumenCumplimientoService) {
		this.resumenCumplimientoService = resumenCumplimientoService;
	}

	public String getExportarResumenCumplimiento() {
		return exportarResumenCumplimiento;
	}

	public void setExportarResumenCumplimiento(String exportarResumenCumplimiento) {
		this.exportarResumenCumplimiento = exportarResumenCumplimiento;
	}
	
}
