package indra.bbva.pizele.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.domain.base.RubroLogro;
import indra.bbva.pizele.domain.base.Semaforo;
import indra.bbva.pizele.domain.extend.LogroDetalle;
import indra.bbva.pizele.domain.extend.LogroMeta;
import indra.bbva.pizele.domain.extend.OficinaGestor;
import indra.bbva.pizele.service.ConsultaLogroService;
import indra.bbva.pizele.service.SemaforoService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ParentPackage("default")
@Controller("logroConsultaAction")
@Scope("prototype")
public class LogroConsultaAction extends ComunAction
{

	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private ConsultaLogroService consultaLogroService;
	
	// ---- FIELD'S ----
	
	private RubroLogro rubroLogroFiltro;
	
	private List<Rubro> lstrubro;	
	private List<OficinaGestor>  lstoficinagestor;
	private String exportarConsultaLogro;
		
	// ---- ACTION'S ----
	
	@Actions( {
		@Action(value="/iniciarConsultaSemanalMensual",
				results={@Result(name="success",type="tiles",location="consultaLogro"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarConsultaSemanalMensual()
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
		@Action(value="/procesarConsultaLogros")
	})
	public void procesarConsultaLogros() throws Exception
	{
		try
		{		
			
			List<Rubro> listaRubros = null;
			List<OficinaGestor> listaOficinasGestores = null;
			List<LogroMeta> listaLogros = null;
			List<LogroMeta> listaMetas = null;
			List<Semaforo> listaSemaforo = null;
			
			this.getConsultaLogroService().cargarConsultaLogros(this.getRubroLogroFiltro());
			
			listaRubros = this.getConsultaLogroService().getListaRubros();
			listaOficinasGestores = this.getConsultaLogroService().getListaOficinasGestores();
			listaLogros = this.getConsultaLogroService().getListaLogros();
			listaMetas = this.getConsultaLogroService().getListaMetas();
			
			if(listaLogros.size() == 0)			
				super.renderJsonERROR(super.getMensaje("ConsultaLogro.error.no_existe.data"));
			else
			{
				listaSemaforo = this.getSemaforoService().listarSemaforo(null);
				
				List<LogroDetalle> listaLogroDetalle = new ArrayList<LogroDetalle>();
				LogroDetalle objLogroDetalle = null;
				 
				for(OficinaGestor objOficinaGestor : listaOficinasGestores)
				{
					for(Rubro objRubro : listaRubros)
					{
						objLogroDetalle = new LogroDetalle();
						objLogroDetalle.setCodigo(objOficinaGestor.getCodigo());
						objLogroDetalle.setIdRubro(objRubro.getId());
						
						for(LogroMeta objLogroMeta : listaLogros)
						{
							if(objLogroDetalle.getCodigo().equals(objLogroMeta.getCodigo()) && objLogroDetalle.getIdRubro() == objLogroMeta.getIdRubro())
							{
								objLogroDetalle.setLogro(objLogroMeta.getMonto());
								break;
							}
						}
						
						for(LogroMeta objLogroMeta : listaMetas)
						{
							if(objLogroDetalle.getCodigo().equals(objLogroMeta.getCodigo()) && objLogroDetalle.getIdRubro() == objLogroMeta.getIdRubro())
							{
								objLogroDetalle.setMeta(objLogroMeta.getMonto());
								break;
							}
						}
						
						if(objLogroDetalle.getLogro() == null)
							objLogroDetalle.setLogro(0L);
						if(objLogroDetalle.getMeta() == null)
							objLogroDetalle.setMeta(0L);
						
						Long porcentaje = objLogroDetalle.getLogro()*100/(objLogroDetalle.getMeta() == 0L ? 1L : objLogroDetalle.getMeta());
						objLogroDetalle.setPorcentaje(porcentaje + "%");
						
						for(Semaforo objSemaforo : listaSemaforo)
						{
							if(porcentaje >= objSemaforo.getRango1() && porcentaje <= objSemaforo.getRango2())
							{
								objLogroDetalle.setColor(objSemaforo.getColor());
								break;
							}
						}
						
						listaLogroDetalle.add(objLogroDetalle);
						
					}
				}
		
				List<Object> listas = new ArrayList<Object>();
				listas.add(listaRubros);
				listas.add(listaOficinasGestores);				
				listas.add(listaLogroDetalle);
				
				super.renderJsonEXITO_LISTAS(listas, "");
					
			}	
				
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}

	@Actions( {
		@Action(value="/exportarExcelConsultaLogro",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"formConsultaLogros.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	
	public String exportarExcelConsultaLogro() throws Exception
	{
		try
		{	
			
	        List<Rubro> listaRubros;
	        List<OficinaGestor> listaOficinasGestores;
	     	List<LogroMeta> listaLogros;
			List<LogroMeta> listaMetas;
			List<Semaforo> listaSemaforo;
			
	      	listaRubros = this.getConsultaLogroService().getListaRubros();
	      	listaOficinasGestores = this.getConsultaLogroService().getListaOficinasGestores();
			listaLogros = this.getConsultaLogroService().getListaLogros();
			listaMetas = this.getConsultaLogroService().getListaMetas();
	      	
			listaSemaforo = this.getSemaforoService().listarSemaforo(null);

	      	
			String[] exportar = this.getExportarConsultaLogro().split("\\|");
              			
			this.getRubroLogroFiltro().getCodigoTerritorio();
			this.getRubroLogroFiltro().getCodigoOficina();
			this.getRubroLogroFiltro().getAnio();
			this.getRubroLogroFiltro().getMes();
			this.getRubroLogroFiltro().getSemana();
	

			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formConsultaLogros.xls"));
			
			 doc.setContentValue(6, 1, exportar[0]);
             doc.setContentValue(6, 4, exportar[1]);
             doc.setContentValue(7, 1, exportar[2]);
             doc.setContentValue(7, 4, exportar[3]);
             doc.setContentValue(8, 2, exportar[4]);
 
				listaSemaforo = this.getSemaforoService().listarSemaforo(null);
				
				List<LogroDetalle> listaLogroDetalle = new ArrayList<LogroDetalle>();
				LogroDetalle objLogroDetalle = null;
				 
				for(OficinaGestor objOficinaGestor : listaOficinasGestores)
				{
					for(Rubro objRubro : listaRubros)
					{
						objLogroDetalle = new LogroDetalle();
						objLogroDetalle.setCodigo(objOficinaGestor.getCodigo());
						objLogroDetalle.setIdRubro(objRubro.getId());
						
						for(LogroMeta objLogroMeta : listaLogros)
						{
							if(objLogroDetalle.getCodigo().equals(objLogroMeta.getCodigo()) && objLogroDetalle.getIdRubro() == objLogroMeta.getIdRubro())
							{
								objLogroDetalle.setLogro(objLogroMeta.getMonto());
								break;
							}
						}
						
						for(LogroMeta objLogroMeta : listaMetas)
						{
							if(objLogroDetalle.getCodigo().equals(objLogroMeta.getCodigo()) && objLogroDetalle.getIdRubro() == objLogroMeta.getIdRubro())
							{
								objLogroDetalle.setMeta(objLogroMeta.getMonto());
								break;
							}
						}
						
						
						if(objLogroDetalle.getLogro() == null)
							objLogroDetalle.setLogro(0L);
						if(objLogroDetalle.getMeta() == null)
							objLogroDetalle.setMeta(0L);
						
						Long porcentaje = objLogroDetalle.getLogro()*100/(objLogroDetalle.getMeta() == 0L ? 1L : objLogroDetalle.getMeta());
						objLogroDetalle.setPorcentaje(porcentaje + "%");
						
						for(Semaforo objSemaforo : listaSemaforo)
						{
							if(porcentaje >= objSemaforo.getRango1() && porcentaje <= objSemaforo.getRango2())
							{
								objLogroDetalle.setColor(objSemaforo.getColor());
								break;
							}
						}
						
						listaLogroDetalle.add(objLogroDetalle);
						
					}
				}
             
				int rowIndexGestores = 13;
				 int rowIndexmetas = 13;
				 int rowIndexrubros = 11;
				 LogroDetalle ld = null;
	  			for(int x = 0; x < listaOficinasGestores.size(); x++)
	  			{
	  			  doc.setBarraTitulo(rowIndexGestores, 0,this.getConsultaLogroService().getListaOficinasGestores().get(x).getDescripcion()); 
	  			  rowIndexGestores=rowIndexGestores+2;
	  			 
	  	            int col=1;
	  	            int col2=1;
	  	            
	  				for(int y = 0; y < listaRubros.size(); y++)
	  	 			{

		  				if(x==0){
		  				 doc.setBarraTitulo(rowIndexrubros, col, col+1, this.getConsultaLogroService().getListaRubros().get(y).getDescrubro());
		  	            
		  	              doc.setBarraTitulo(rowIndexrubros+1, col,"Metas");
		  	              doc.setBarraTitulo(rowIndexrubros+1, col+1,"Logros");
		  	              col=col+2;
		  	              
		  				}
		  				
		  				ld = new LogroDetalle();
  						ld = obtenerLogroDetalle(listaLogroDetalle, listaOficinasGestores.get(x).getCodigo(),  listaRubros.get(y).getId());
  						
  						doc.setContentValue(rowIndexmetas, col2, ld.getMeta().toString()); 
  						doc.setContentValue(rowIndexmetas, col2+1, ld.getLogro().toString()); 
  						
  						doc.setContentValueColor(rowIndexmetas+1, col2, col2+1, ld.getPorcentaje(), ld.getColor());
  						col2=col2+2;
  						
	  	 			}
	  				rowIndexmetas=rowIndexmetas+2;
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
	
	
	public LogroDetalle obtenerLogroDetalle(List<LogroDetalle> listaLogroDetalle, String codigoGestor, Long idRubro) {
		
		LogroDetalle ld = new LogroDetalle();
		
		for(int z=0;z<listaLogroDetalle.size();z++) {
			
		if(listaLogroDetalle.get(z).getCodigo().equals(codigoGestor) &&
				   listaLogroDetalle.get(z).getIdRubro() == idRubro) {
					ld = new LogroDetalle();
					ld = listaLogroDetalle.get(z);
	 				
				}
		}
		return ld;
	}
	
	// ---- GETTER'S AND SETTER'S ----
	
	public ConsultaLogroService getConsultaLogroService() {
		return consultaLogroService;
	}

	public void setConsultaLogroService(ConsultaLogroService consultaLogroService) {
		this.consultaLogroService = consultaLogroService;
	}

	public RubroLogro getRubroLogroFiltro() {
		return rubroLogroFiltro;
	}

	public void setRubroLogroFiltro(RubroLogro rubroLogroFiltro) {
		this.rubroLogroFiltro = rubroLogroFiltro;
	}
	
	public String getExportarConsultaLogro() {
		return exportarConsultaLogro;
	}

	public void setExportarConsultaLogro(String exportarConsultaLogro) {
		this.exportarConsultaLogro = exportarConsultaLogro;
	}

	public List<Rubro> getLstrubro() {
		return lstrubro;
	}

	public void setLstrubro(List<Rubro> lstrubro) {
		this.lstrubro = lstrubro;
	}

	public List<OficinaGestor> getLstoficinagestor() {
		return lstoficinagestor;
	}

	public void setLstoficinagestor(List<OficinaGestor> lstoficinagestor) {
		this.lstoficinagestor = lstoficinagestor;
	}

}
