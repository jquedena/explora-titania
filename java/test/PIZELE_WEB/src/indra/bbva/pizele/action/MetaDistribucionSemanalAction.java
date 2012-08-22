package indra.bbva.pizele.action;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.AsignacionRubro;
import indra.bbva.pizele.domain.base.ConfBasicaMeta;
import indra.bbva.pizele.domain.base.MetaMensual;
import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.service.AsignacionRubroService;
import indra.bbva.pizele.service.ConfBasicaMetaService;
import indra.bbva.pizele.service.GestorService;
import indra.bbva.pizele.service.MetaMensualService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;

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
@Controller("metaDistribucionSemanalAction")
@Scope("prototype")
public class MetaDistribucionSemanalAction extends ComunAction
{

	private static final long serialVersionUID = 8323237915301658160L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	@Resource
	private AsignacionRubroService asignacionRubroService;
	@Resource
	private MetaMensualService metaMensualService;
	@Resource
	private GestorService gestorService;
	@Resource
	private ConfBasicaMetaService confBasicaMetaService;
	
	// ---- FIELD'S ----
	private ConfBasicaMeta basicaMeta;
	private AsignacionRubro asignacionRubro;
	private MetaMensual metaMensual;
	private List<Rubro> listaRubro;
	private List<MetaMensual> listaMetasMensuales;
	
	private String metasMensualesValues;
	private String semana1Values;
	private String semana2Values;
	private String semana3Values;
	private String semana4Values;
	private String semana5Values;
	private String chkSemana1Values;
	private String chkSemana2Values;
	private String chkSemana3Values;
	private String chkSemana4Values;
	private String chkSemana5Values;
	
	private String  des_terr;
	private String  des_ofi;
	private String  des_anio;
	private String  des_mes;

	private String xlsHead = "";
	private String xlsBody = "";
	
	private String mesDestino;
	private String anioDestino;
	private int permiso;
	
	@Actions( {
		@Action(value="/iniciarDistribucionSemanal",
				results={@Result(name="success",type="tiles",location="metaDistribSemanal"),
						 @Result(name="error",type="tiles",location="panel")})
				
	})
	public String iniciarDistribucionSemanal()
	{		
		try
		{	
			super.cargarTerritorios();
			super.cargarOficinas();
			super.cargarAnios();
			super.cargarMeses();
			
			String cod_ter = "-1";
			String cod_ofi = "-1";
			
			if(CurrentUser.Instance().getTerritorio() != null)
				cod_ter = CurrentUser.Instance().getTerritorio().getCodigo();
			if( CurrentUser.Instance().getOficina() != null)
				cod_ofi = CurrentUser.Instance().getOficina().getCodigo();
			
			Long anio = Long.valueOf(String.valueOf(FechaUtil.anioActual()));
			Long idMes = this.getIdMesEspecifico(this.getListaMeses(), Long.valueOf(String.valueOf(FechaUtil.mesActualToInt())));
			
			this.setListaRubro(this.getAsignacionRubroService().listarRubros_x_Cabecera(cod_ter, cod_ofi, anio, idMes));
			
			super.setAnio(String.valueOf(FechaUtil.anioActual()));
			super.setMes(super.mesActual());
			
			String acceso = CurrentUser.Instance().obtenerTipoAccesoOpcion(Constantes.Opcion_Menu.CONFIG_META_MENSUAL);
			if(Constantes.TipoAcceso.SOLO_LECTURA.equalsIgnoreCase(acceso)) {
				this.permiso = 0;
			} else if(Constantes.TipoAcceso.TOTAL.equalsIgnoreCase(acceso)) {
				this.permiso = 1;
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
		@Action(value="/cargarListaRubrosAsignShort")
	})
	public void cargarListaRubrosAsignShort() throws Exception
	{
		try {
			this.setListaRubro(this.getAsignacionRubroService().listarRubrosAsignShort(this.getAsignacionRubro()));
			super.renderListaObjetosJson(this.getListaRubro());
			
		} catch (Exception ex) {
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/cargarListaCompletaListasMensuales")
	})
	public void cargarListaCompletaListasMensuales() throws Exception
	{
		try {
			String cod_ter = this.getMetaMensual().getCod_terr();
			String cod_ofi = this.getMetaMensual().getCod_ofi();
			Long anio = this.getMetaMensual().getAnio();
			Long idMes = this.getMetaMensual().getMes();
			Long idRubro = this.getMetaMensual().getId_rubro();
			
			this.setListaMetasMensuales(this.getMetaMensualService().getListaCompletaMetasMensuales(cod_ter, cod_ofi, anio, idMes, idRubro));
			super.renderListaObjetosJson(this.getListaMetasMensuales());
			
		} catch (Exception ex) {
			this.logger.error("cargarListaCompletaListasMensuales", ex);
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/calcularMetasSemanales")
	})
	public void calcularMetasSemanales() throws Exception
	{
		try {
			String cod_ter = this.getMetaMensual().getCod_terr();
			String cod_ofi = this.getMetaMensual().getCod_ofi();
			Long anio = this.getMetaMensual().getAnio();
			Long idMes = this.getMetaMensual().getMes();
			Long idRubro = this.getMetaMensual().getId_rubro();
			int diasHabiles1Semana = 0;
			
			this.setListaMetasMensuales(this.getMetaMensualService().getListaCompletaMetasMensuales(cod_ter, cod_ofi, anio, idMes, idRubro));
			
			String[] semana1ValuesArray = this.getSemana1Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana2ValuesArray = this.getSemana2Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana3ValuesArray = this.getSemana3Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana4ValuesArray = this.getSemana4Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana5ValuesArray = this.getSemana5Values().replaceAll("Ausente", "0").split("\\|");
			
			String[] chkSemana1ValuesArray = this.getChkSemana1Values().split("\\|");
			String[] chkSemana2ValuesArray = this.getChkSemana2Values().split("\\|");
			String[] chkSemana3ValuesArray = this.getChkSemana3Values().split("\\|");
			String[] chkSemana4ValuesArray = this.getChkSemana4Values().split("\\|");
			String[] chkSemana5ValuesArray = this.getChkSemana5Values().split("\\|");
			
			String[] metasMensualesValuesArray = this.getMetasMensualesValues().split("\\|");
			
			String mensaje = "";
			String nombreCompleto = "";
			int i=0;
			for (MetaMensual metaMensual: getListaMetasMensuales()) {
				if ((metaMensual.getId_rubro().equals(Constantes.RubroFijosNoDesasignables.CONTACTOS)) ||
					(metaMensual.getId_rubro().equals(Constantes.RubroFijosNoDesasignables.VISITAS)) ) {
					
					/*
					if ((chkSemana1ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana1Minimo().longValue() > new Long(semana1ValuesArray[i]).longValue())
					 || (chkSemana2ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana2Minimo().longValue() > new Long(semana2ValuesArray[i]).longValue())
					 || (chkSemana3ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana3Minimo().longValue() > new Long(semana3ValuesArray[i]).longValue())
					 || (chkSemana4ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana4Minimo().longValue() > new Long(semana4ValuesArray[i]).longValue())
					 || (chkSemana5ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana5Minimo().longValue() > new Long(semana5ValuesArray[i]).longValue())
					 ) {
						nombreCompleto = metaMensual.getApell_pat_gestor() + " " + metaMensual.getApell_mat_gestor() + " " + metaMensual.getNom_gestor();
						mensaje += "Las metas semanales para el gestor "  + nombreCompleto + " deben ser m&iacute;nimo: <br>";
						if (metaMensual.getSemana1Minimo().longValue() > new Long(semana1ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 1: " + metaMensual.getSemana1Minimo() + "<br>";
							semana1ValuesArray[i] = metaMensual.getSemana1Minimo().toString();
						}
						
						if (metaMensual.getSemana2Minimo().longValue() > new Long(semana2ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 2: " + metaMensual.getSemana2Minimo() + "<br>";
							semana2ValuesArray[i] = metaMensual.getSemana2Minimo().toString();
						}
						
						if (metaMensual.getSemana3Minimo().longValue() > new Long(semana3ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 3: " + metaMensual.getSemana3Minimo() + "<br>";
							semana3ValuesArray[i] = metaMensual.getSemana3Minimo().toString();
						}
						
						if (metaMensual.getSemana4Minimo().longValue() > new Long(semana4ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 4: " + metaMensual.getSemana4Minimo() + "<br>";
							semana4ValuesArray[i] = metaMensual.getSemana4Minimo().toString();
						}
						
						if (metaMensual.getSemana5Minimo().longValue() > new Long(semana5ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 5: " + metaMensual.getSemana5Minimo() + "<br>";
							semana5ValuesArray[i] = metaMensual.getSemana5Minimo().toString();
						}
					}
					*/
					
					metaMensual.setSemana1(new Long(semana1ValuesArray[i]));
					metaMensual.setSemana2(new Long(semana2ValuesArray[i]));
					metaMensual.setSemana3(new Long(semana3ValuesArray[i]));
					metaMensual.setSemana4(new Long(semana4ValuesArray[i]));
					metaMensual.setSemana5(new Long(semana5ValuesArray[i]));
					
					metaMensual.setAusente1(chkSemana1ValuesArray[i]);
					metaMensual.setAusente2(chkSemana2ValuesArray[i]);
					metaMensual.setAusente3(chkSemana3ValuesArray[i]);
					metaMensual.setAusente4(chkSemana4ValuesArray[i]);
					metaMensual.setAusente5(chkSemana5ValuesArray[i]);
					
					Long totalMetaMensual = 
						metaMensual.getSemana1() + metaMensual.getSemana2() + 
						metaMensual.getSemana3() + metaMensual.getSemana4() + 
						metaMensual.getSemana5();
					/* if (totalMetaMensual.longValue()<new Long(metasMensualesValuesArray[i]).longValue())
						totalMetaMensual = new Long(metasMensualesValuesArray[i]);*/
					metaMensual.setMeta_mensual(totalMetaMensual);
					
					mensaje += !mensaje.equals("") ? "</p>" : "";
				}
				else {
					
					if (metaMensual.getMeta_sdo().longValue() > new Long(metasMensualesValuesArray[i]).longValue()){
						nombreCompleto = metaMensual.getApell_pat_gestor() + " " + metaMensual.getApell_mat_gestor() + " " + metaMensual.getNom_gestor();
						mensaje += "La Meta Mensual para el gestor "  + nombreCompleto + " debe ser mayor o igual a la Meta SDO.<br>";
						metasMensualesValuesArray[i] = metaMensual.getMeta_sdo().toString();
					}
					
					ConfBasicaMeta confBasicaMeta = confBasicaMetaService.obtenerConfBasicaMeta_x_CAB(cod_ter, cod_ofi, anio, idMes);
					if (confBasicaMeta!=null)
						diasHabiles1Semana = FechaUtil.omitirPrimeraSemanaDelMesActual(anio.intValue(), idMes.intValue() - 6);

						if(diasHabiles1Semana <= FechaUtil.SEMANA_CON_TRES_DIAS_HABILES) {
							confBasicaMeta.setSemana1(0L);
							confBasicaMeta.setSemana2(30L);
							confBasicaMeta.setSemana3(30L);
							confBasicaMeta.setSemana4(30L);
							confBasicaMeta.setSemana5(10L);
						} else if(diasHabiles1Semana == FechaUtil.SEMANA_CON_CUARTO_DIAS_HABILES) {
							confBasicaMeta.setSemana1(30L);
							confBasicaMeta.setSemana2(30L);
							confBasicaMeta.setSemana3(30L);
							confBasicaMeta.setSemana4(10L);
							confBasicaMeta.setSemana5(0L);
						}
					
						Long metaSemana1 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana1()/100d)));
						Long metaSemana2 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana2()/100d)));
						Long metaSemana3 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana3()/100d)));
						Long metaSemana4 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana4()/100d)));
						Long metaSemana5 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana5()/100d)));
						
						metaMensual.setSemana1(metaSemana1);
						metaMensual.setSemana2(metaSemana2);
						metaMensual.setSemana3(metaSemana3);
						metaMensual.setSemana4(metaSemana4);
						metaMensual.setSemana5(metaSemana5);
						metaMensual.setMeta_mensual(new Long(metasMensualesValuesArray[i]));
				}
				
				i++;
			}
			mensaje += !mensaje.equals("") ? "Las metas han sido establecidas con sus valores m&iacute;nimos." : "";
			super.renderJsonEXITO_LISTA(mensaje, this.getListaMetasMensuales());
		} catch (Exception ex) {
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/guardarRegistroMeta")
	})
	public void guardarRegistroMeta() throws Exception
	{
		try {

			String cod_ter = this.getMetaMensual().getCod_terr();
			String cod_ofi = this.getMetaMensual().getCod_ofi();
			Long anio = this.getMetaMensual().getAnio();
			Long idMes = this.getMetaMensual().getMes();
			Long idRubro = this.getMetaMensual().getId_rubro();
			int diasHabiles1Semana = 0;
			
			this.setListaMetasMensuales(this.getMetaMensualService().getListaCompletaMetasMensuales(cod_ter, cod_ofi, anio, idMes, idRubro));
			
			String[] semana1ValuesArray = this.getSemana1Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana2ValuesArray = this.getSemana2Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana3ValuesArray = this.getSemana3Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana4ValuesArray = this.getSemana4Values().replaceAll("Ausente", "0").split("\\|");
			String[] semana5ValuesArray = this.getSemana5Values().replaceAll("Ausente", "0").split("\\|");
			
			String[] chkSemana1ValuesArray = this.getChkSemana1Values().split("\\|");
			String[] chkSemana2ValuesArray = this.getChkSemana2Values().split("\\|");
			String[] chkSemana3ValuesArray = this.getChkSemana3Values().split("\\|");
			String[] chkSemana4ValuesArray = this.getChkSemana4Values().split("\\|");
			String[] chkSemana5ValuesArray = this.getChkSemana5Values().split("\\|");
			
			String[] metasMensualesValuesArray = this.getMetasMensualesValues().split("\\|");
			
			String mensaje = "";
			String nombreCompleto = "";
			int i=0;
			for (MetaMensual metaMensual: getListaMetasMensuales()) {
				if ((metaMensual.getId_rubro().equals(Constantes.RubroFijosNoDesasignables.CONTACTOS)) ||
					(metaMensual.getId_rubro().equals(Constantes.RubroFijosNoDesasignables.VISITAS)) ) {
					
					/*
					if ((chkSemana1ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana1Minimo().longValue() > new Long(semana1ValuesArray[i]).longValue())
					 || (chkSemana2ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana2Minimo().longValue() > new Long(semana2ValuesArray[i]).longValue())
					 || (chkSemana3ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana3Minimo().longValue() > new Long(semana3ValuesArray[i]).longValue())
					 || (chkSemana4ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana4Minimo().longValue() > new Long(semana4ValuesArray[i]).longValue())
					 || (chkSemana5ValuesArray[i].equalsIgnoreCase("N") && metaMensual.getSemana5Minimo().longValue() > new Long(semana5ValuesArray[i]).longValue())
					 ) {
						nombreCompleto = metaMensual.getApell_pat_gestor() + " " + metaMensual.getApell_mat_gestor() + " " + metaMensual.getNom_gestor();
						mensaje += "Las metas semanales para el gestor "  + nombreCompleto + " deben ser m&iacute;nimo: <br>";
						if (metaMensual.getSemana1Minimo().longValue() > new Long(semana1ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 1: " + metaMensual.getSemana1Minimo() + "<br>";
							semana1ValuesArray[i] = metaMensual.getSemana1Minimo().toString();
						}
						
						if (metaMensual.getSemana2Minimo().longValue() > new Long(semana2ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 2: " + metaMensual.getSemana2Minimo() + "<br>";
							semana2ValuesArray[i] = metaMensual.getSemana2Minimo().toString();
						}
						
						if (metaMensual.getSemana3Minimo().longValue() > new Long(semana3ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 3: " + metaMensual.getSemana3Minimo() + "<br>";
							semana3ValuesArray[i] = metaMensual.getSemana3Minimo().toString();
						}
						
						if (metaMensual.getSemana4Minimo().longValue() > new Long(semana4ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 4: " + metaMensual.getSemana4Minimo() + "<br>";
							semana4ValuesArray[i] = metaMensual.getSemana4Minimo().toString();
						}
						
						if (metaMensual.getSemana5Minimo().longValue() > new Long(semana5ValuesArray[i]).longValue()) {
							mensaje += "Para la Semana 5: " + metaMensual.getSemana5Minimo() + "<br>";
							semana5ValuesArray[i] = metaMensual.getSemana5Minimo().toString();
						}
					}
					*/
					
					metaMensual.setSemana1(new Long(semana1ValuesArray[i]));
					metaMensual.setSemana2(new Long(semana2ValuesArray[i]));
					metaMensual.setSemana3(new Long(semana3ValuesArray[i]));
					metaMensual.setSemana4(new Long(semana4ValuesArray[i]));
					metaMensual.setSemana5(new Long(semana5ValuesArray[i]));
					
					metaMensual.setAusente1(chkSemana1ValuesArray[i]);
					metaMensual.setAusente2(chkSemana2ValuesArray[i]);
					metaMensual.setAusente3(chkSemana3ValuesArray[i]);
					metaMensual.setAusente4(chkSemana4ValuesArray[i]);
					metaMensual.setAusente5(chkSemana5ValuesArray[i]);
					
					Long totalMetaMensual = 
						metaMensual.getSemana1() + metaMensual.getSemana2() + 
						metaMensual.getSemana3() + metaMensual.getSemana4() + 
						metaMensual.getSemana5();
					
					/* if (totalMetaMensual.longValue()<new Long(metasMensualesValuesArray[i]).longValue())
						totalMetaMensual = new Long(metasMensualesValuesArray[i]); */
					
					metaMensual.setMeta_mensual(totalMetaMensual);
					
					mensaje += !mensaje.equals("") ? "</p>" : "";
				}
				else {
					
					if (metaMensual.getMeta_sdo().longValue() > new Long(metasMensualesValuesArray[i]).longValue()){
						nombreCompleto = metaMensual.getApell_pat_gestor() + " " + metaMensual.getApell_mat_gestor() + " " + metaMensual.getNom_gestor();
						mensaje += "La Meta Mensual para el gestor "  + nombreCompleto + " debe ser mayor o igual a la Meta SDO.<br>";
						metasMensualesValuesArray[i] = metaMensual.getMeta_sdo().toString();
					}
					
					ConfBasicaMeta confBasicaMeta = confBasicaMetaService.obtenerConfBasicaMeta_x_CAB(cod_ter, cod_ofi, anio, idMes);
					if (confBasicaMeta!=null)
						diasHabiles1Semana = FechaUtil.omitirPrimeraSemanaDelMesActual(anio.intValue(), idMes.intValue() - 6);

					if(diasHabiles1Semana <= FechaUtil.SEMANA_CON_TRES_DIAS_HABILES) {
						confBasicaMeta.setSemana1(0L);
						confBasicaMeta.setSemana2(30L);
						confBasicaMeta.setSemana3(30L);
						confBasicaMeta.setSemana4(30L);
						confBasicaMeta.setSemana5(10L);
					} else if(diasHabiles1Semana == FechaUtil.SEMANA_CON_CUARTO_DIAS_HABILES) {
						confBasicaMeta.setSemana1(30L);
						confBasicaMeta.setSemana2(30L);
						confBasicaMeta.setSemana3(30L);
						confBasicaMeta.setSemana4(10L);
						confBasicaMeta.setSemana5(0L);
					}
					
					Long metaSemana1 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana1()/100d)));
					Long metaSemana2 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana2()/100d)));
					Long metaSemana3 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana3()/100d)));
					Long metaSemana4 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana4()/100d)));
					Long metaSemana5 = Math.round(Math.ceil(Double.parseDouble(metasMensualesValuesArray[i]) * (confBasicaMeta.getSemana5()/100d)));
					
					metaMensual.setSemana1(metaSemana1);
					metaMensual.setSemana2(metaSemana2);
					metaMensual.setSemana3(metaSemana3);
					metaMensual.setSemana4(metaSemana4);
					metaMensual.setSemana5(metaSemana5);
					
					metaMensual.setMeta_mensual(new Long(metasMensualesValuesArray[i]));
				}
				
				
				if (metaMensual.getId()!=null && metaMensual.getId()!=0) {
					metaMensual.setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
					this.getMetaMensualService().actualizarMeta(metaMensual);
				}
				else {
					metaMensual.setUsuarioCreacion(CurrentUser.Instance().getCodigoRegistro());
					this.getMetaMensualService().registrarMeta(metaMensual);
				}
				
				
				i++;
			}
			mensaje += !mensaje.equals("") ? "Las metas han sido establecidas con sus valores m&iacute;nimos." : "";
			mensaje = super.getMensaje("RegistroMeta.exito.insert") + "</p>" + mensaje;
			super.renderJsonEXITO_LISTA(mensaje, this.getListaMetasMensuales());
		
		} catch (Exception ex) {
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/exportarExcelRegistroMeta",
			results={@Result(name="success",type="stream",
				params={"contentType", "application/vnd.ms-excel",
					"inputName", "excelStream",
					"contentDisposition", "attachment;filename=\"formMeta.xls\"",
					"bufferSize", "1024"}),
			@Result(name="error",type="tiles",location="panel")})
	})
	public String exportarExcelRegistroMeta() throws Exception  {
		try {
			int index;
			int indexRow;
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formMeta.xls"));
			String[] expHead = this.getXlsHead().split("\\|");
			String[] expBody = this.getXlsBody().split("\\|");
			String[] row;
			
			doc.setContentValue(6, 1, expHead[0]);
			doc.setContentValue(6, 4, expHead[1]);
			doc.setContentValue(7, 1, expHead[2]);
			doc.setContentValue(7, 4, expHead[3]);
			doc.setContentValue(8, 1, expHead[4]);
			
			if(expBody.length > 0) {
				row = expBody[0].split("\\%");
				doc.setBarraTitulo(10, 0, 3, row[0]);
				for(index = 1; index < row.length; index++) {
					doc.setBarraTitulo(10, 3 + index, row[index]);
				}
				
				for(indexRow = 1; indexRow < expBody.length; indexRow++) {
					row = expBody[indexRow].split("\\%");
					if(row.length > 0) {
						doc.setContentValue(10 + indexRow, 0, 3, row[0]);
						for(index = 1; index < row.length; index++) {
							doc.setContentValue(10 + indexRow, 3 + index, row[index]);
						}
					} else {
						index = 0;
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
	
	@Actions( {
		@Action(value="/copiarMetaMensual")
	})
	public void copiarMetaMensual() throws Exception {
		String cod_ter = this.getMetaMensual().getCod_terr();
		String cod_ofi = this.getMetaMensual().getCod_ofi();
		Long anio = this.getMetaMensual().getAnio();
		Long idMes = this.getMetaMensual().getMes();
		Long idRubro = this.getMetaMensual().getId_rubro();
		Long anioDestino = Long.parseLong(this.getAnioDestino());
		Long idMesDestino = Long.parseLong(this.getMesDestino());
		
		try {		
			super.setCurrentUser(CurrentUser.Instance());
			
			this.getMetaMensualService().copiarMetasMensuales(cod_ter
					, cod_ofi
					, idRubro
					, super.getCurrentUser().getCodigoRegistro()
					, anio
					, idMes
					, anioDestino
					, idMesDestino );
			
			super.renderJsonEXITO(super.getMensaje("RegistroMeta.exito.copy"));
		}
		catch(Exception ex)	{
			ex.printStackTrace();
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}	
	
	//	---- PRIVATE METHOD'S ----
	
	
	public ConfBasicaMeta getBasicaMeta() {
		return basicaMeta;
	}


	public void setBasicaMeta(ConfBasicaMeta basicaMeta) {
		this.basicaMeta = basicaMeta;
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


	public AsignacionRubroService getAsignacionRubroService() {
		return asignacionRubroService;
	}


	public void setAsignacionRubroService(
			AsignacionRubroService asignacionRubroService) {
		this.asignacionRubroService = asignacionRubroService;
	}


	public List<Rubro> getListaRubro() {
		return listaRubro;
	}


	public void setListaRubro(List<Rubro> listaRubro) {
		this.listaRubro = listaRubro;
	}

	public AsignacionRubro getAsignacionRubro() {
		return asignacionRubro;
	}

	public void setAsignacionRubro(AsignacionRubro asignacionRubro) {
		this.asignacionRubro = asignacionRubro;
	}

	public List<MetaMensual> getListaMetasMensuales() {
		return listaMetasMensuales;
	}

	public void setListaMetasMensuales(List<MetaMensual> listaMetasMensuales) {
		this.listaMetasMensuales = listaMetasMensuales;
	}

	public MetaMensualService getMetaMensualService() {
		return metaMensualService;
	}

	public void setMetaMensualService(MetaMensualService metaMensualService) {
		this.metaMensualService = metaMensualService;
	}

	public GestorService getGestorService() {
		return gestorService;
	}

	public void setGestorService(GestorService gestorService) {
		this.gestorService = gestorService;
	}

	public MetaMensual getMetaMensual() {
		return metaMensual;
	}

	public void setMetaMensual(MetaMensual metaMensual) {
		this.metaMensual = metaMensual;
	}

	public String getSemana1Values() {
		return semana1Values;
	}

	public void setSemana1Values(String semana1Values) {
		this.semana1Values = semana1Values;
	}

	public String getSemana2Values() {
		return semana2Values;
	}

	public void setSemana2Values(String semana2Values) {
		this.semana2Values = semana2Values;
	}

	public String getSemana3Values() {
		return semana3Values;
	}

	public void setSemana3Values(String semana3Values) {
		this.semana3Values = semana3Values;
	}

	public String getSemana4Values() {
		return semana4Values;
	}

	public void setSemana4Values(String semana4Values) {
		this.semana4Values = semana4Values;
	}

	public String getSemana5Values() {
		return semana5Values;
	}

	public void setSemana5Values(String semana5Values) {
		this.semana5Values = semana5Values;
	}

	public String getMetasMensualesValues() {
		return metasMensualesValues;
	}

	public void setMetasMensualesValues(String metasMensualesValues) {
		this.metasMensualesValues = metasMensualesValues;
	}

	public String getChkSemana1Values() {
		return chkSemana1Values;
	}

	public void setChkSemana1Values(String chkSemana1Values) {
		this.chkSemana1Values = chkSemana1Values;
	}

	public String getChkSemana2Values() {
		return chkSemana2Values;
	}

	public void setChkSemana2Values(String chkSemana2Values) {
		this.chkSemana2Values = chkSemana2Values;
	}

	public String getChkSemana3Values() {
		return chkSemana3Values;
	}

	public void setChkSemana3Values(String chkSemana3Values) {
		this.chkSemana3Values = chkSemana3Values;
	}

	public String getChkSemana4Values() {
		return chkSemana4Values;
	}

	public void setChkSemana4Values(String chkSemana4Values) {
		this.chkSemana4Values = chkSemana4Values;
	}

	public String getChkSemana5Values() {
		return chkSemana5Values;
	}

	public void setChkSemana5Values(String chkSemana5Values) {
		this.chkSemana5Values = chkSemana5Values;
	}

	public String getXlsHead() {
		return xlsHead;
	}

	public void setXlsHead(String xlsHead) {
		this.xlsHead = xlsHead;
	}

	public String getXlsBody() {
		return xlsBody;
	}

	public void setXlsBody(String xlsBody) {
		this.xlsBody = xlsBody;
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

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
}
