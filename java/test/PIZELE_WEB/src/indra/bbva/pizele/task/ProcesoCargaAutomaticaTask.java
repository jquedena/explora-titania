package indra.bbva.pizele.task;

import indra.bbva.pizele.action.ProcesoCargaAction;
import indra.bbva.pizele.thread.CartaLogroMISThread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ProcesoCargaAutomaticaTask {

	Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private ProcesoCargaAction procesoCargaAction;

	public void ejecutarCargasAutomaticas() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmm");
		logger.debug("Aun estoy vivo :" + formatter.format(new Date()));

		Calendar hoy = Calendar.getInstance();
		String HoraActual = "";

		int horaActual = hoy.get(Calendar.HOUR_OF_DAY);
		int minutoActual = hoy.get(Calendar.MINUTE);

		if (horaActual <= 9)
			HoraActual = "0" + horaActual + ":";
		else
			HoraActual = horaActual + ":";

		if (minutoActual <= 9)
			HoraActual = HoraActual + "0" + minutoActual;
		else
			HoraActual = HoraActual + minutoActual;
		
		ProcesoCargaAction.setHora(HoraActual);
		
		if (this.getProcesoCargaAction().validarEjecucionCargaLogrosMIS()) {
			CartaLogroMISThread th = new CartaLogroMISThread();
			th.setProcesoCargaAction(this.getProcesoCargaAction());
			th.start();
		}

	}

	public ProcesoCargaAction getProcesoCargaAction() {
		return procesoCargaAction;
	}

	public void setProcesoCargaAction(ProcesoCargaAction procesoCargaAction) {
		this.procesoCargaAction = procesoCargaAction;
	}
}