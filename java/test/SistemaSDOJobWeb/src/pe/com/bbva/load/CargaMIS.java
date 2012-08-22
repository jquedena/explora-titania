package pe.com.bbva.load;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import pe.com.bbva.service.LogService;
import pe.com.bbva.task.ITask;

public class CargaMIS implements ITask {

    private static Logger log = Logger.getLogger(CargaMIS.class);
    private DataSource dataSource;
    private LogService logService;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    private int initTableMIS() throws SQLException {
        Connection cnn = null;
        CallableStatement stm = null;
        int result = 0;
        String message = "";
        try {
            cnn = dataSource.getConnection();
            stm = cnn.prepareCall("{call IIDO.PKG_CARGA_DATOS.SP_VALIDA_CARGA(?, ?)}");
            stm.registerOutParameter("exitCode", Types.INTEGER);
            stm.registerOutParameter("errMsg", Types.VARCHAR);
            stm.execute();
            result = stm.getInt("exitCode");
            message = stm.getString("errMsg");

            if (message == null) {
                message = "";
            }
            if (message.length() > 0) {
                log.error(message);
            }

        } catch (SQLException e) {
            log.error(e);
            result = -1;
		} finally {
            if (stm != null) {
                stm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return result;
    }

    private void loadTableMIS() throws SQLException {
        Connection cnn = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        int exec = 0;
        String message = "";
        String fileSDO = "";
        try {
            cnn = dataSource.getConnection();
            
            // Obteniendo el nombre del archivo
            stm = cnn.prepareCall("SELECT VALOR1 FROM IIDO.TIIDO_MULTITABLA WHERE COD_MULT='T19'");
            rs = stm.executeQuery();
            
            if(rs.next()) {
            	fileSDO = rs.getString("VALOR1");
            }
            
            // Realizando el proceso de carga
            stm = cnn.prepareCall("{call IIDO.PKG_CARGA_DATOS.SP_CARGA_DATOS_MIS(?, ?)}");
            stm.registerOutParameter("exitCode", Types.INTEGER);
            stm.registerOutParameter("errMsg", Types.VARCHAR);
            stm.execute();
            exec = stm.getInt("exitCode");
            message = stm.getString("errMsg");

            if (message == null) {
                message = "Recupero un valor nulo.";
            }

            
            Thread.sleep(12000);            
            if (exec == 2) {
                log.error("Trabajo ejecutado con exito.");
            } else {
            	log.error("Ocurrio un error, verificar el log.");
                log.error(message);
            }
            
            stm = cnn.prepareCall("{call IIDO.PKG_CARGA_DATOS.SP_CAMBIA_ESTADO(?, ?)}");
        	stm.registerOutParameter("exitCode", Types.INTEGER);
            stm.registerOutParameter("errMsg", Types.VARCHAR);
            stm.execute();
            message = stm.getString("errMsg");
            
            if (message == null) {
                message = "";
            }
            
            if (message.length() > 0) {
                log.error(message);
            }
            
            if(fileSDO.length() > 0) {
            	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmm");
            	File file = new File(fileSDO + "SDOMIS.TXT");
            	File fileTo = new File(fileSDO + "SDOMIS_" + formatter.format(new Date()) + ".TXT");
            	
            	if(file.exists()) {
            		if(file.renameTo(fileTo)) {
            			log.error("Se renombro con exito el archivo.");
            		} else {
            			log.error("No se pudo renombrar el archivo.");
            		}
            	}
            }
            
        } catch (SQLException e) {
        	log.error("=( Detalle: ", e);
        } catch (InterruptedException e) {
        	log.error("=( Detalle: ", e);
		} finally {
            if (stm != null) {
                stm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
    }

    private void createLog() {
        try {
            if (logService.createLog()) {
                log.info("Se escribio correctamente el Log.");
            } else {
                log.info("Ocurrio un error al escribir el Log.");
            }
        } catch (Exception e) {
            log.error("[CargaMIS::createLog]", e);
        }
    }

    public void executeTask() {
        try {
            int initTable = initTableMIS();
            switch (initTable) {
                case 1:
                    loadTableMIS();
                    createLog();
                    break;
                case 0:
                    log.error("El trabajo ya se inicio en otra instancia.");
                    break;
                case -1:
                    log.error("Ocurrio un error al realizar la validacion. No se ejecutara el Job.");
                    break;
            }

        } catch (SQLException ex) {
            log.error(ex);
        }
    }
}
