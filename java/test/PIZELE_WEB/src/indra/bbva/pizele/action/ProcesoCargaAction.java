package indra.bbva.pizele.action;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.domain.base.Parametro;
import indra.bbva.pizele.domain.base.ProcesoAutomatico;
import indra.bbva.pizele.service.ParametroService;
import indra.bbva.pizele.service.ProcesoAutomaticoService;
import indra.core.GenericAction;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ParentPackage("default")
@Controller("procesoCargaAction")
@Scope("prototype")
public class ProcesoCargaAction extends GenericAction {

	private static final long serialVersionUID = 3695775976954224296L;
	private static String hora = "";
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private ParametroService parametroService;

	@Resource
	private ProcesoAutomaticoService procesoAutomaticoService;
	
	public static String getHora() {
		return hora;
	}

	public static void setHora(String hora) {
		ProcesoCargaAction.hora = hora;
	}

	public void ejecutaCargaLogrosMIS() {

		boolean terminoConError = false;
		String msg = "";

		ProcesoAutomatico objProcesoAutomatico = new ProcesoAutomatico();
		objProcesoAutomatico.setIdTipo(Constantes.ProcesoAutomaticoTipo.CargaLogrosEpigrafesMIS);
		objProcesoAutomatico.setIdEstado(Constantes.ProcesoAutomaticoEstado.Pendiente);
		objProcesoAutomatico.setHora(ProcesoCargaAction.getHora());

		try {

			if (this.getProcesoAutomaticoService().listarProcesoAutomatico(objProcesoAutomatico).size() > 0)
				return;

			this.getProcesoAutomaticoService().insertarProcesoAutomatico(objProcesoAutomatico);

			// Ejecutar Proceso de Carga de Logros de epigrafes MIS Independientes del SDO.
			this.getProcesoAutomaticoService().cargarArchivoMISIndependienteSDO();
		} catch (Exception ex) {
			this.logger.error("Error al iniciar la carga", ex);
			msg = ex.getMessage();
			terminoConError = true;
		}

		if (terminoConError) {
			if (objProcesoAutomatico.getId() == null || objProcesoAutomatico.getId() == 0L) {
				this.logger.error("ERROR AL INSERTAR EL REGISTRO DE UN PROCESO AUTOMATICO DE CARGA DE LOGROS DE EPIGRAFES MIS INDEPENDIENTES DEL SDO");
				return;
			} else {
				objProcesoAutomatico.setObservacion(msg);
				objProcesoAutomatico.setIdEstado(Constantes.ProcesoAutomaticoEstado.Terminado_Error);
			}
		} else {
			objProcesoAutomatico.setIdEstado(Constantes.ProcesoAutomaticoEstado.Terminado);
			objProcesoAutomatico.setObservacion("Proceso se realizó con éxito.");
		}

		try {
			this.getProcesoAutomaticoService().actualizarProcesoAutomatico(objProcesoAutomatico);
		} catch (Exception ex) {
			this.logger.error("ERROR AL ACTUALIZAR EL REGISTRO "
				+ objProcesoAutomatico.getId()
				+ " DEL PROCESO AUTOMATICO DE CARGA DE LOGROS DE EPIGRAFES MIS INDEPENDIENTES DEL SDO.");
		}

	}

	public boolean validarEjecucionCargaLogrosMIS() {

		boolean ejecutar = false;

		try {

			Parametro objParamFlagEjecTomaDes = this.getParametroService().obtenerParametro(Constantes.ProcesoCargaLogrosMIS.FLAG_EJECUCION);
			ejecutar = (objParamFlagEjecTomaDes.getValorEntero() == 1L);

			if (ejecutar) {

				if (ProcesoCargaAction.getHora().equals(this.getParametroService().obtenerParametro(Constantes.ProcesoCargaLogrosMIS.HORA_EJECUCION).getValorTexto())) {
					ejecutar = true;
				} else
					ejecutar = false;

				if (ejecutar) {

					ejecutar = false;

					Parametro objFiltro = new Parametro();
					objFiltro.setIdParametroPadre(Constantes.ProcesoCargaLogrosMIS.DIAS_EJECUCION);
					objFiltro.setEstadoRegistro("A");
					List<Parametro> listaDiasEjecucion = this.getParametroService().listarParametroFiltro(objFiltro);

					Calendar hoy = Calendar.getInstance();
					
					for (int index = 0; index < listaDiasEjecucion.size(); index++) {
						if (listaDiasEjecucion.get(index).getValorEntero() == Long.valueOf(hoy.get(Calendar.DAY_OF_WEEK))) {
							ejecutar = true;
							break;
						}
					}

				}

			}

		} catch (Exception ex) {
			this.logger.error("ProcesoCargaAction :: validarEjecucionCargaLogrosMIS", ex);
			ejecutar = false;
		}

		return ejecutar;

	}

	public ParametroService getParametroService() {
		return parametroService;
	}

	public void setParametroService(ParametroService parametroService) {
		this.parametroService = parametroService;
	}

	public ProcesoAutomaticoService getProcesoAutomaticoService() {
		return procesoAutomaticoService;
	}

	public void setProcesoAutomaticoService(
			ProcesoAutomaticoService procesoAutomaticoService) {
		this.procesoAutomaticoService = procesoAutomaticoService;
	}

}
