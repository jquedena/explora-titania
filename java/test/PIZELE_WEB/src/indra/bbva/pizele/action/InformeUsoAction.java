package indra.bbva.pizele.action;

import indra.bbva.pizele.domain.base.Gerente;
import indra.bbva.pizele.domain.base.InformeUso;
import indra.bbva.pizele.domain.extend.InformeUsoDetalle;
import indra.bbva.pizele.service.GerenteService;
import indra.bbva.pizele.service.InformeUsoService;
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
@Controller("informeUsoAction")
@Scope("prototype")
public class InformeUsoAction extends ComunAction
{
	private static final long serialVersionUID = 8323237915301658160L;
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private InformeUsoService informeUsoService;
	
	@Resource
	private GerenteService gerenteService;

	// ---- FIELD'S ----
	
	private List<InformeUsoDetalle> listarInformeUso;	
	private List<Gerente> listaGerente;
	private InformeUso informeUso;
    
	private InformeUso informeUsoExcel;
	
	private String exportarInformeUso;
		
	@Actions( {
		@Action(value="/iniciarInformeUso",
				results={@Result(name="success",type="tiles",location="informeUso"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})

	public String iniciarInformeUso()
	{		
		try
		{	
			super.cargarTerritorios();
			super.cargarOficinas();
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
		@Action(value="/buscarInformeUso")
	})
	public void buscarInformeUso() throws Exception
	{
		try
		{	
				@SuppressWarnings("unused")
				List<InformeUsoDetalle> lista = new ArrayList<InformeUsoDetalle> ();
					
				InformeUsoDetalle objInformeUso= new InformeUsoDetalle();

				objInformeUso.setCodterr(this.getInformeUso().getCodterr());
				objInformeUso.setCodigoOficina(this.getInformeUso().getCodigoOficina());
				if(this.getInformeUso().getFechaDesde() != null && this.getInformeUso().getFechaDesde().length() > 0)
					objInformeUso.setFechaDesde(FechaUtil.format_yyyyMMdd(this.getInformeUso().getFechaDesde()));
				if(this.getInformeUso().getFechaHasta() != null && this.getInformeUso().getFechaHasta().length() > 0)
					objInformeUso.setFechaHasta(FechaUtil.format_yyyyMMdd(this.getInformeUso().getFechaHasta()));
				
				this.setListarInformeUso(this.getInformeUsoService().listarInformeUso(objInformeUso));

				int promedioPorcMeta = 0;
				int promedioPorcLogro = 0;
				
				for(int i = 0; i < this.getListarInformeUso().size(); i++) 
				{
					
					Gerente objGerente = this.getGerenteService().listarGestorGerente(this.getListarInformeUso().get(i).getCodigoOficina());
					
					if(objGerente != null)
						this.getListarInformeUso().get(i).setNombreGestorGerente(objGerente.getNombreCompleto());
					else
						this.getListarInformeUso().get(i).setNombreGestorGerente("[GERENTE NO REGISTRADO]");
					
					promedioPorcMeta += this.getListarInformeUso().get(i).getPorcentajeMeta();
					promedioPorcLogro += this.getListarInformeUso().get(i).getPorcentajeLogro();
				}
				
				List<InformeUsoDetalle> listaPromedio = new ArrayList<InformeUsoDetalle> ();
				if(this.getListarInformeUso().size() > 0)
				{
					InformeUsoDetalle InformeUsoDetallePromedio = new InformeUsoDetalle();
					InformeUsoDetallePromedio.setPorcentajeMeta(promedioPorcMeta/this.getListarInformeUso().size());
					InformeUsoDetallePromedio.setPorcentajeLogro(promedioPorcLogro/this.getListarInformeUso().size());					
					listaPromedio.add(InformeUsoDetallePromedio);
				}
				
				
				super.renderJsonEXITO_LISTA_DOBLE(this.getListarInformeUso(), listaPromedio);
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}

	
	@Actions( {
		@Action(value="/exportarExcelInfomeUso",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"informeUso.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	public String exportarExcelInfomeUso() throws Exception
	{
		try
		{	
		    InformeUsoDetalle objInformeUso = new InformeUsoDetalle();
		    
			objInformeUso.setCodterr(this.getInformeUsoExcel().getCodterr());
			objInformeUso.setCodigoOficina(this.getInformeUsoExcel().getCodigoOficina());
			if(this.getInformeUsoExcel().getFechaDesde() != null && this.getInformeUsoExcel().getFechaDesde().length() > 0)
				objInformeUso.setFechaDesde(FechaUtil.format_yyyyMMdd(this.getInformeUsoExcel().getFechaDesde()));
			if(this.getInformeUsoExcel().getFechaHasta() != null && this.getInformeUsoExcel().getFechaHasta().length() > 0)
				objInformeUso.setFechaHasta(FechaUtil.format_yyyyMMdd(this.getInformeUsoExcel().getFechaHasta()));
			

			this.setListarInformeUso(this.getInformeUsoService().listarInformeUso(objInformeUso));

			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formInformeUso.xls"));
			
			 doc.setContentValue(6, 1, this.getInformeUsoExcel().getNombreTerritorio());
             doc.setContentValue(6, 4, this.getInformeUsoExcel().getNombreOficina());
             doc.setContentValue(7, 1, this.getInformeUsoExcel().getFechaDesde());
             doc.setContentValue(7, 4, this.getInformeUsoExcel().getFechaHasta());
             
             int promedioPorcMeta = 0;
			 int promedioPorcLogro = 0;
			
			for(int i = 0; i < this.getListarInformeUso().size(); i++) 
			{
				
				Gerente objGerente = this.getGerenteService().listarGestorGerente(this.getListarInformeUso().get(i).getCodigoOficina());
				
				if(objGerente != null)
					this.getListarInformeUso().get(i).setNombreGestorGerente(objGerente.getNombreCompleto());
				else
					this.getListarInformeUso().get(i).setNombreGestorGerente("[GERENTE NO REGISTRADO]");
				
				promedioPorcMeta += this.getListarInformeUso().get(i).getPorcentajeMeta();
				promedioPorcLogro += this.getListarInformeUso().get(i).getPorcentajeLogro();
				
			}
			
			int rowIndex = 13;
            
 			for(int index = 0; index < this.getListarInformeUso().size(); index++)
 			{
 				doc.setContentValue(rowIndex, 0, this.getListarInformeUso().get(index).getNombreTerr()); 
 				doc.setContentValue(rowIndex, 1, this.getListarInformeUso().get(index).getCodigoOficina());
 				doc.setContentValue(rowIndex, 2, this.getListarInformeUso().get(index).getNombreOficina());
 				doc.setContentValue(rowIndex, 3, this.getListarInformeUso().get(index).getNombreGestorGerente());

 				if(this.getListarInformeUso().get(index).getPorcentajeMeta() == 0)
 					doc.setContentValueNO(rowIndex, 4, "NO");
 				else
 					doc.setContentValueSI(rowIndex, 4, "SI");
 				
 				doc.setContentValue(rowIndex, 5, this.getListarInformeUso().get(index).getPorcentajeMeta() + "%");
 				
 				if(this.getListarInformeUso().get(index).getPorcentajeLogro() == 0)
 					doc.setContentValueNO(rowIndex, 6, "NO");
 				else
 					doc.setContentValueSI(rowIndex, 6, "SI");
 				
 				doc.setContentValue(rowIndex, 7, this.getListarInformeUso().get(index).getPorcentajeLogro() + "%");
 				 				
 				doc.setContentValueCenter(rowIndex, 8, this.getListarInformeUso().get(index).getConsecucion() + "%");
 				rowIndex++;
 			}
 			
			if(this.getListarInformeUso().size() > 0)
			{			
				doc.setFooterRight(rowIndex, 0, 3 , "Promedios : ");				
				doc.setFooter(rowIndex, 4, "");
				doc.setFooter(rowIndex, 5, promedioPorcMeta/this.getListarInformeUso().size() + "%");
				doc.setFooter(rowIndex, 6, "");
				doc.setFooter(rowIndex, 7, promedioPorcLogro/this.getListarInformeUso().size() + "%");
				doc.setFooter(rowIndex, 8, (promedioPorcMeta/this.getListarInformeUso().size() + promedioPorcLogro/this.getListarInformeUso().size())*2 + "%");	
			}
			
			this.setExcelStream(doc.getExcelStream());
			
		}
		catch(Exception ex)
		{	
			this.logger.error("exportarExcelInfomeUso", ex);
			return ERROR;
		}
		
		return SUCCESS;
		
	}
	
	// ---- PRIVATE METHOD'S ----
	
	public InformeUsoService getInformeUsoService() {
		return informeUsoService;
	}

	public void setInformeUsoService(InformeUsoService informeUsoService) {
		this.informeUsoService = informeUsoService;
	}
	
	public GerenteService getGerenteService() {
		return gerenteService;
	}


	public void setGerenteService(GerenteService gerenteService) {
		this.gerenteService = gerenteService;
	}


	public List<InformeUsoDetalle> getListarInformeUso() {
		return listarInformeUso;
	}


	public void setListarInformeUso(List<InformeUsoDetalle> listarInformeUso) {
		this.listarInformeUso = listarInformeUso;
	}

	public List<Gerente> getListaGerente() {
		return listaGerente;
	}


	public void setListaGerente(List<Gerente> listaGerente) {
		this.listaGerente = listaGerente;
	}


	public InformeUso getInformeUso() {
		return informeUso;
	}


	public void setInformeUso(InformeUso informeUso) {
		this.informeUso = informeUso;
	}

	public String getExportarInformeUso() {
		return exportarInformeUso;
	}


	public void setExportarInformeUso(String exportarInformeUso) {
		this.exportarInformeUso = exportarInformeUso;
	}


	public InformeUso getInformeUsoExcel() {
		return informeUsoExcel;
	}


	public void setInformeUsoExcel(InformeUso informeUsoExcel) {
		this.informeUsoExcel = informeUsoExcel;
	}

}
