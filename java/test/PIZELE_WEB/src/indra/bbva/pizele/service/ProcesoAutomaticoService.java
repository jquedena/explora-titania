package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.ProcesoAutomatico;
import indra.bbva.pizele.persistence.ProcesoAutomaticoPersistence;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcesoAutomaticoService {

	@Autowired
	private ProcesoAutomaticoPersistence procesoAutomaticoPersistence;

	private Logger logger = Logger.getLogger(this.getClass());
			
	@SuppressWarnings("unchecked")
	public List<ProcesoAutomatico> listarProcesoAutomatico(ProcesoAutomatico objProcesoAutomatico) {
		HashMap map = new HashMap();

		if (objProcesoAutomatico.getIdTipo() != null && objProcesoAutomatico.getIdTipo() != 0L)
			map.put("PI_ID_TIPO", objProcesoAutomatico.getIdTipo());
		if (objProcesoAutomatico.getFecha() != null && objProcesoAutomatico.getFecha().length() > 0)
			map.put("PI_FECHA", objProcesoAutomatico.getFecha());
		if (objProcesoAutomatico.getHora() != null && objProcesoAutomatico.getHora().length() > 0)
			map.put("PI_HORA", objProcesoAutomatico.getHora());

		this.procesoAutomaticoPersistence.listarProcesoAutomatico(map);

		return (List<ProcesoAutomatico>) map.get("PROC_AUTOMATIC_CUR_REF");

	}

	@Transactional
	public void insertarProcesoAutomatico(ProcesoAutomatico objProcesoAutomatico) {
		this.procesoAutomaticoPersistence.insertarProcesoAutomatico(objProcesoAutomatico);
	}

	@Transactional
	public void actualizarProcesoAutomatico(ProcesoAutomatico objProcesoAutomatico) {
		this.procesoAutomaticoPersistence.actualizarProcesoAutomatico(objProcesoAutomatico);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void cargarArchivoMISIndependienteSDO() {
		HashMap parameters = new HashMap();
		Object exitCode = null;
		Object errMessage = null;
		int status = 0;
		
		try {
			this.procesoAutomaticoPersistence.validaCargarArchivoMISIndependienteSDO(parameters);
			errMessage = parameters.get("ERRMSG");
			if(errMessage != null) { 
				logger.error(errMessage);
			}
			status = Integer.valueOf(parameters.get("EXITCODE").toString()).intValue();
		} catch(Exception ex) {
			logger.error("Validando la carga.", ex);
			status = -1;
		}

        switch (status) {
        case 1:
        	try {
        		this.procesoAutomaticoPersistence.cargarArchivoMISIndependienteSDO(parameters);
    			errMessage = parameters.get("ERRMSG");
    			if(errMessage != null) { 
    				logger.error(errMessage);
    			}
	        } catch(Exception ex) {
				logger.error("Proceso de carga.", ex);
			}
	        try {
	        	Thread.sleep(120000);
	        	this.procesoAutomaticoPersistence.cambiaEstadoCargarArchivoMISIndependienteSDO(parameters);
				errMessage = parameters.get("ERRMSG");
				if(errMessage != null) { 
					logger.error(errMessage);
				}
	        } catch(Exception ex) {
				logger.error("Actualizado el estado de la carga.", ex);
			}

	        String fileSDO = null;
	        try {
	        	fileSDO = this.procesoAutomaticoPersistence.obtenerRutaDirectorioExterno().get("VALOR1").toString();
	        } catch(Exception ex) {
	        	fileSDO = "/mnt/compartido/iido/files/mis/";
				logger.error("Actualizado el estado de la carga.", ex);
			}
            if(fileSDO.length() > 0) {
            	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmm");
            	File file = new File(fileSDO + "SDOMIS_IND.TXT");
            	File fileTo = new File(fileSDO + "SDOMIS_IND_" + formatter.format(new Date()) + ".TXT");
            	
            	if(file.exists()) {
            		if(file.renameTo(fileTo)) {
            			logger.error("Se renombro con exito el archivo.");
            		} else {
            			logger.error("No se pudo renombrar el archivo.");
            		}
            	}
            }
            
            break;
        case 0:
            logger.error("El trabajo ya se inicio en otra instancia.");
            break;
        case -1:
            logger.error("Ocurrio un error al realizar la validacion. No se ejecutara el Job.");
            break;
        }		
		
		exitCode = parameters.get("EXITCODE");
		errMessage = parameters.get("ERRMSG");
		
		if (exitCode == null) {
			exitCode = "";
		}
		
		if (errMessage == null) {
			errMessage = "";
		}
	}
}
