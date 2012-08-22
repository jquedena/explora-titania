package pe.com.bbva.service;

import org.apache.log4j.Logger;

import pe.com.bbva.model.dao.MultitablaDAO;
import pe.com.bbva.model.entity.Multitabla;

public class MultitablaService {

	private Logger log = Logger.getLogger(MultitablaService.class);
	private MultitablaDAO multitablaDAO;

	public MultitablaDAO getMultitablaDAO() {
		return multitablaDAO;
	}

	public void setMultitablaDAO(MultitablaDAO multitablaDAO) {
		this.multitablaDAO = multitablaDAO;
	}

	public String getLogProperties() {
		String logProperties = "";
		try {
			Multitabla multitabla = multitablaDAO.getMultitabla("T17", "1");
			if (multitabla != null) {
				logProperties = multitabla.getValor1();
			}
		} catch (Exception e) {
			log.error("[MultitablaService::getLogProperties]", e);
		}
		return logProperties;
	}
}
