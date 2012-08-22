package indra.bbva.pizele.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import indra.bbva.pizele.action.ProcesoCargaAction;

public class CartaLogroMISThread extends Thread {

	private Logger logger = Logger.getLogger(this.getClass());
	private ProcesoCargaAction procesoCargaAction;

	public void run() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmm");
		logger.info("Ejecutado a las :" + formatter.format(new Date()));
		this.getProcesoCargaAction().ejecutaCargaLogrosMIS();
	}

	public ProcesoCargaAction getProcesoCargaAction() {
		return procesoCargaAction;
	}

	public void setProcesoCargaAction(ProcesoCargaAction procesoCargaAction) {
		this.procesoCargaAction = procesoCargaAction;
	}

}
