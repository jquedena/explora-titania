package indra.bbva.pizele.action;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.Semaforo;
import indra.bbva.pizele.service.SemaforoService;
import indra.core.DocumentoExcel;

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
@Controller("confSemaforoAction")
@Scope("prototype")

public class ConfSemaforoAction extends ComunAction
{
	private static final long serialVersionUID = 8358237919301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	@Resource
	private  SemaforoService   semaforoService;
    

	// ---- FIELD'S ----	
	
	List<Semaforo> lstSemaforo = new ArrayList<Semaforo>();
		
	private Long valor1;
	private Long valor2;
	private Long valor3;
 
	
	// ---- ACTION'S ----

	
	@Actions( {
		@Action(value="/iniciarConfiguracionSemaforo",
				results={@Result(name="success",type="tiles",location="configSemaforo"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarConfiguracionSemaforo()
	{		

		try
		{	
			
			lstSemaforo =  semaforoService.listarSemaforo(new Semaforo());
			
			for (Semaforo semaforo : lstSemaforo)
			{

				if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_1.longValue() ){
					setValor3(semaforo.getRango1());
				}
				
				if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_2.longValue() ){
					setValor2(semaforo.getRango2());
				}
				
				if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_3.longValue() ){
					setValor1(semaforo.getRango2());
				}
			}
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
		@Action(value="/guardarSemaforo")
	})
	public void guardarSemaforo() throws Exception
	{
		try
		{	  

			Semaforo  semaforo1= new Semaforo();
			Semaforo  semaforo2= new Semaforo();
			Semaforo  semaforo3= new Semaforo();
			
			semaforo1.setId(Constantes.Semaforo.RANGO_1);
			semaforo2.setId(Constantes.Semaforo.RANGO_2);
			semaforo3.setId(Constantes.Semaforo.RANGO_3);
			 
			semaforo3.setRango1(0L);
			semaforo3.setRango2(valor1);

			semaforo2.setRango1(valor1 + 1L) ;
			semaforo2.setRango2(valor2);
			  
			semaforo1.setRango1(valor2+ 1L);
			semaforo1.setRango2(99999L);
			 
			lstSemaforo.add(semaforo1);     
			lstSemaforo.add(semaforo2);
			lstSemaforo.add(semaforo3);
			    
			semaforo1.setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
			semaforo2.setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
			semaforo3.setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
			    
		    this.getSemaforoService().actualizarSemaforos(lstSemaforo);
			super.renderJsonEXITO(super.getMensaje("Semaforo.exito.update"));

		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}

	@Actions( {
		@Action(value="/exportarExcelSemaforo",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"formSemaforo.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	public String exportarExcelSemaforo() throws Exception
	{
		try
		{	
			
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formSemaforo.xls"));
           
			doc.setContentValue(6, 2,getValor3().toString() + "%");
			doc.setContentValue(7, 2,getValor2().toString() + "%");
			doc.setContentValue(8, 2,getValor1().toString() + "%");
			
			lstSemaforo =  semaforoService.listarSemaforo(new Semaforo());
			
			for (Semaforo semaforo : lstSemaforo)
			{

				if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_1.longValue() ){
					doc.setContentValueColor(6, 3, 3, "", semaforo.getColor());					
				}
				
				if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_2.longValue() ){
					doc.setContentValueColor(7, 3, 3, "", semaforo.getColor());
				}
				
				if(semaforo.getId().longValue()== Constantes.Semaforo.RANGO_3.longValue() ){
					doc.setContentValueColor(8, 3, 3, "", semaforo.getColor());
				}
			}
			
			this.setExcelStream(doc.getExcelStream());
				
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage(),ex);
			return ERROR;
		}
		
		return SUCCESS;
		
	}
	
	

	public SemaforoService getSemaforoService() {
		return semaforoService;
	}


	public void setSemaforoService(SemaforoService semaforoService) {
		this.semaforoService = semaforoService;
	}
    
	// ---- GETTER'S AND SETTER'S ----
	
	public Long getValor1() {
		return valor1;
	}

	public void setValor1(Long valor1) {
		this.valor1 = valor1;
	}

	public Long getValor2() {
		return valor2;
	}

	public void setValor2(Long valor2) {
		this.valor2 = valor2;
	}

	public Long getValor3() {
		return valor3;
	}

	public void setValor3(Long valor3) {
		this.valor3 = valor3;
	}
	
	
	  
}
