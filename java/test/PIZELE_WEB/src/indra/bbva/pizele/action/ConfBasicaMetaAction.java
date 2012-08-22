package indra.bbva.pizele.action;

import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.ConfBasicaMeta;
import indra.bbva.pizele.service.ConfBasicaMetaService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@ParentPackage("default")
@Controller("confBasicaMetaAction")
@Scope("prototype")
public class ConfBasicaMetaAction extends ComunAction
{

	private static final long serialVersionUID = 8323237915301658161L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private ConfBasicaMetaService basicaMetaService;
	
	// ---- FIELD'S ----
	private ConfBasicaMeta basicaMeta;
	
	private String  des_terr;
	private String  des_ofi;
	private String  des_anio;
	private String  des_mes;
	private String  des_sem1;
	private String  des_sem2;
	private String  des_sem3;
	private String  des_sem4;
	private String  des_sem5;
	private String  des_min_con_per;
	private String  des_min_con_no_per;
	private String  des_min_vis_per;
	private String  des_min_vis_no_per;
	
	// ---- ACTION'S ----
	
	@Actions( {
		@Action(value="/iniciarConfiguracionBasica",
				results={@Result(name="success",type="tiles",location="configBasicaMeta"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarConfiguracionBasica()
	{		
		try	
		{	
			super.cargarTerritorios();
			super.cargarOficinas();
			super.cargarAnios();
			super.cargarMeses();
			
			String  cod_terr = "-1";
			String  cod_ofic = "-1";
			Long    anio	 = -1L;
			Long  mes		 = -1L;
			
			super.setCurrentUser(CurrentUser.Instance());
			
			if(super.getCurrentUser().getTerritorio() != null)
				cod_terr = super.getCurrentUser().getTerritorio().getCodigo();
			
			if(super.getCurrentUser().getOficina() != null)
				cod_ofic = super.getCurrentUser().getOficina().getCodigo();
						
			this.setBasicaMeta(this.getBasicaMetaService().obtenerConfBasicaMeta(cod_terr, cod_ofic, anio, mes));
			
			if (this.getBasicaMeta()==null) {
				basicaMeta = new ConfBasicaMeta();
				this.getBasicaMeta().setCod_terr(cod_terr);
				this.getBasicaMeta().setCod_ofi(cod_ofic);
				this.getBasicaMeta().setAnio(anio);
				this.getBasicaMeta().setMes(mes);
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
		@Action(value="/cargarConfBasicaMeta")
	})
	public void cargarConfBasicaMeta() throws Exception
	{
		try {
			
			String  cod_terr = this.getBasicaMeta().getCod_terr(); 
			String  cod_ofic = this.getBasicaMeta().getCod_ofi(); 
			Long    anio	 = this.getBasicaMeta().getAnio(); 
			Long    mes		 = this.getBasicaMeta().getMes(); 
			
			this.setBasicaMeta(this.getBasicaMetaService().obtenerConfBasicaMeta(cod_terr, cod_ofic, anio, mes));
			if (this.getBasicaMeta()==null) {
				basicaMeta = new ConfBasicaMeta();
				this.getBasicaMeta().setCod_terr(cod_terr);
				this.getBasicaMeta().setCod_ofi(cod_ofic);
				this.getBasicaMeta().setAnio(anio);
				this.getBasicaMeta().setMes(mes);				
			}
			
			String perfil = "";
			
			if(CurrentUser.Instance() != null) {
				
				if(CurrentUser.Instance().getCodigoPerfil() != null) {
					perfil = CurrentUser.Instance().getCodigoPerfil();  
				} else {
					if(CurrentUser.Instance().getCodigoPerfilGOF() != null) {
						perfil = CurrentUser.Instance().getCodigoPerfilGOF(); 
					}
				}
				
				if(!perfil.equalsIgnoreCase("ADM") && mes.compareTo(-1L) != 0) {
					int diasHabiles1Semana = FechaUtil.omitirPrimeraSemanaDelMesActual(anio.intValue(), mes.intValue() - 6);
		
					if(diasHabiles1Semana <= FechaUtil.SEMANA_CON_TRES_DIAS_HABILES) {
						this.getBasicaMeta().setSemana1(0L);
						this.getBasicaMeta().setSemana2(30L);
						this.getBasicaMeta().setSemana3(30L);
						this.getBasicaMeta().setSemana4(30L);
						this.getBasicaMeta().setSemana5(10L);
					} else if(diasHabiles1Semana == FechaUtil.SEMANA_CON_CUARTO_DIAS_HABILES) {
						this.getBasicaMeta().setSemana1(30L);
						this.getBasicaMeta().setSemana2(30L);
						this.getBasicaMeta().setSemana3(30L);
						this.getBasicaMeta().setSemana4(10L);
						this.getBasicaMeta().setSemana5(0L);
					}
				}
			}
			
			super.renderObjetoJson(this.getBasicaMeta());
			
		} catch (Exception ex) {
			this.logger.error("Cargando Configuración", ex);
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/guardarConfBasicaMeta")
	})
	public void guardarConfBasicaMeta() throws Exception
	{
		try {
			
			if (this.getBasicaMeta().getId()!=null && this.getBasicaMeta().getId()!=0) {
				actualizarConfBasicaMeta();
			}
			else {
				this.getBasicaMeta().setUsuarioCreacion(CurrentUser.Instance().getCodigoRegistro());
				this.getBasicaMetaService().insertarConfMetaBasica(this.getBasicaMeta());
				
				super.renderJsonEXITO(super.getMensaje("ConfBasicaMeta.exito.insert"));
			}
		} catch (Exception ex) {
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}

	@Actions( {
		@Action(value="/actualizarConfBasicaMeta")
	})
	public void actualizarConfBasicaMeta() throws Exception
	{
		try {
			this.getBasicaMeta().setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
			this.getBasicaMetaService().actualizarConfMetaBasica(this.getBasicaMeta());
			
			super.renderJsonEXITO(super.getMensaje("ConfBasicaMeta.exito.update"));
			
		} catch (Exception ex) {
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/eliminarConfBasicaMeta")
	})
	public void eliminarConfBasicaMeta() throws Exception
	{
		try {
			this.getBasicaMeta().setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
			this.getBasicaMetaService().eliminarConfMetaBasica(this.getBasicaMeta());
			
			super.renderJsonEXITO(super.getMensaje("ConfBasicaMeta.exito.delete"));
			
		} catch (Exception ex) {
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/exportarExcelConfigBasicaMeta",
				results={@Result(name="success",type="stream",
								 params={"contentType", "application/vnd.ms-excel",
										 "inputName", "excelStream",
										 "contentDisposition", "attachment;filename=\"formConfigBasicaMeta.xls\"",
										 "bufferSize", "1024"}),
						 @Result(name="error",type="tiles",location="panel")})				
	})
	public String exportarExcelConfigBasicaMeta() throws Exception
	{
		try
		{
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formConfigBasicaMeta.xls"));
			
			doc.setContentValue(6, 1, this.getDes_terr());
			doc.setContentValue(6, 5, this.getDes_ofi());
			doc.setContentValue(7, 1, this.getDes_anio());
			doc.setContentValue(7, 5, this.getDes_mes());
			
			doc.setContentValue(10, 1, String.valueOf(this.getDes_sem1()));
			doc.setContentValue(10, 2, String.valueOf(this.getDes_sem2()));
			doc.setContentValue(10, 3, String.valueOf(this.getDes_sem3()));
			doc.setContentValue(10, 4, String.valueOf(this.getDes_sem4()));
			doc.setContentValue(10, 5, String.valueOf(this.getDes_sem5()));
			long total = 
				Long.parseLong(this.getDes_sem1()) +
				Long.parseLong(this.getDes_sem2()) +
				Long.parseLong(this.getDes_sem3()) +
				Long.parseLong(this.getDes_sem4()) +
				Long.parseLong(this.getDes_sem5());
			doc.setContentValue(10, 6, String.valueOf(total));
			
			doc.setContentValue(13, 1, String.valueOf(this.getDes_min_con_per()));
			doc.setContentValue(13, 2, String.valueOf(this.getDes_min_con_no_per()));
			doc.setContentValue(14, 1, String.valueOf(this.getDes_min_vis_per()));
			doc.setContentValue(14, 2, String.valueOf(this.getDes_min_vis_no_per()));
			
			this.setExcelStream(doc.getExcelStream());			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public ConfBasicaMeta getBasicaMeta() {
		return basicaMeta;
	}


	public void setBasicaMeta(ConfBasicaMeta basicaMeta) {
		this.basicaMeta = basicaMeta;
	}

	public ConfBasicaMetaService getBasicaMetaService() {
		return basicaMetaService;
	}

	public void setBasicaMetaService(ConfBasicaMetaService basicaMetaService) {
		this.basicaMetaService = basicaMetaService;
	}

	public String getDes_terr() {
		return des_terr;
	}

	public void setDes_terr(String des_terr) {
		this.des_terr = des_terr;
	}

	public String getDes_ofi() {
		return des_ofi;
	}

	public void setDes_ofi(String des_ofi) {
		this.des_ofi = des_ofi;
	}

	public String getDes_anio() {
		return des_anio;
	}

	public void setDes_anio(String des_anio) {
		this.des_anio = des_anio;
	}

	public String getDes_mes() {
		return des_mes;
	}

	public void setDes_mes(String des_mes) {
		this.des_mes = des_mes;
	}

	public String getDes_sem1() {
		return des_sem1;
	}

	public void setDes_sem1(String des_sem1) {
		this.des_sem1 = des_sem1;
	}

	public String getDes_sem2() {
		return des_sem2;
	}

	public void setDes_sem2(String des_sem2) {
		this.des_sem2 = des_sem2;
	}

	public String getDes_sem3() {
		return des_sem3;
	}

	public void setDes_sem3(String des_sem3) {
		this.des_sem3 = des_sem3;
	}

	public String getDes_sem4() {
		return des_sem4;
	}

	public void setDes_sem4(String des_sem4) {
		this.des_sem4 = des_sem4;
	}

	public String getDes_sem5() {
		return des_sem5;
	}

	public void setDes_sem5(String des_sem5) {
		this.des_sem5 = des_sem5;
	}

	public String getDes_min_con_per() {
		return des_min_con_per;
	}

	public void setDes_min_con_per(String des_min_con_per) {
		this.des_min_con_per = des_min_con_per;
	}

	public String getDes_min_con_no_per() {
		return des_min_con_no_per;
	}

	public void setDes_min_con_no_per(String des_min_con_no_per) {
		this.des_min_con_no_per = des_min_con_no_per;
	}

	public String getDes_min_vis_per() {
		return des_min_vis_per;
	}

	public void setDes_min_vis_per(String des_min_vis_per) {
		this.des_min_vis_per = des_min_vis_per;
	}

	public String getDes_min_vis_no_per() {
		return des_min_vis_no_per;
	}

	public void setDes_min_vis_no_per(String des_min_vis_no_per) {
		this.des_min_vis_no_per = des_min_vis_no_per;
	}
	
}
