package pe.com.bbva.service;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import pe.com.bbva.model.dao.LogDAO;
import pe.com.bbva.model.dao.MultitablaDAO;
import pe.com.bbva.model.entity.Log;
import pe.com.bbva.model.entity.Multitabla;

public class LogService {

    private Logger log = Logger.getLogger(LogService.class);
    private LogDAO logDAO;
    private MultitablaDAO multitablaDAO;
    
    public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public MultitablaDAO getMultitablaDAO() {
		return multitablaDAO;
	}

	public void setMultitablaDAO(MultitablaDAO multitablaDAO) {
		this.multitablaDAO = multitablaDAO;
	}

	private List<Log> findList(String date) {
        List<Log> list = logDAO.findList(date);
        return list;
    }
    
    public String getPath() {
        String path = "";
        try {
            Multitabla multitabla = multitablaDAO.getMultitabla("T17", "1");
            if (multitabla != null) {
            	path = multitabla.getValor1();
            }
        } catch (Exception e) {
            log.error("[MultitablaService::getLogProperties]", e);
        }
        return path;
    }

    public boolean createLog() {
        boolean result = true;
        try {
            SimpleDateFormat formatterJob = new SimpleDateFormat("dd-MM-yyyy' T:'HH:mm:ss.SSSZ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy'T'HHmm");
            String day = formatter.format(new Date());
            String dayJob = formatterJob.format(new Date());
            String path = getPath();
            
            String logJob = "Trabajo iniciado al las " + dayJob + "\r\n";
            List<Log> listLog = findList(day.substring(0, 10).replaceAll("-", "/"));
            
            for(Log o : listLog) {
                logJob += o.toString() + "\r\n";
            }
            
            dayJob = formatterJob.format(new Date());
            logJob += "Trabajo terminado al las " + dayJob + "\r\n";
            
            File fileLog = new File(path+"/logJOB-SDO-"+day+".log");
            FileOutputStream out = new FileOutputStream(fileLog);
            out.write(logJob.getBytes());
            out.flush();
            
        } catch (Exception ex) {
            log.error("[LogService::createLog]", ex);
            result = false;
        }
        return result;
    }
}
