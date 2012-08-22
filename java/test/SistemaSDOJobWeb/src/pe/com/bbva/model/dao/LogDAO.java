package pe.com.bbva.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pe.com.bbva.model.entity.Log;
import pe.com.indra.component.model.AbstractSQL;

public class LogDAO extends AbstractSQL {

	public LogDAO() {
		log.info("LogDAO:Inicializando...");
	}
	
    public List<Log> findList(String date) {
        List<Log> list = new ArrayList<Log>();
        ResultSet rst;
        try {
        	HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("fecha like ", date+"%");
            rst = this.findByParams2("IIDO.TIIDO_LOG_CARGA_MIS", parameters);
            
            Log ilog;
            
            while(rst.next()) {
            	ilog=new Log();
            	ilog.setIdlog(rst.getBigDecimal("IDLOG").intValue());
            	ilog.setNroLinea(rst.getBigDecimal("NRO_LINEA").longValue());
            	ilog.setIderror(rst.getBigDecimal("IDERROR").longValue());
            	ilog.setDescError(rst.getString("DESC_ERROR").toString());
            	ilog.setFecha(rst.getString("FECHA").toString());
            }
            
            this.close();
        } catch (Exception e) {
            log.error("[LogService::findList]", e);
        }
        return list;
    }
}
