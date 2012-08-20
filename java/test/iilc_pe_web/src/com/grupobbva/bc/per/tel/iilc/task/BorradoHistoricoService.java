package com.grupobbva.bc.per.tel.iilc.task;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.HistoricoSeguimientoDAO;

@Component
public class BorradoHistoricoService {

	@Autowired
	private HistoricoSeguimientoDAO historicoSeguimientoDAO;

	@Autowired
	public HistoricoSeguimientoDAO getHistoricoSeguimientoDAO() {
		return historicoSeguimientoDAO;
	}

	@Autowired
	public void setHistoricoSeguimientoDAO(
			HistoricoSeguimientoDAO historicoSeguimientoDAO) {
		this.historicoSeguimientoDAO = historicoSeguimientoDAO;
	}

	Logger logger = Logger.getLogger(this.getClass());

	public void ejecutarCarga() {
		historicoSeguimientoDAO.eliminarHistorico();
	}
	
	public void limpiarArchivos() {
		logger.error("Limpiando el directorio");
		ConexionDAO cnn = new ConexionDAO();
		String path = cnn.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";
		deleteWithChildren(path);
	}

	private boolean deleteWithChildren(String path) {  
	    File file = new File(path);  
	    if (!file.exists()) {  
	        return true;  
	    }  
	    if (!file.isDirectory()) {  
	        return file.delete();  
	    }  
	    return this.deleteChildren(file) && file.delete();  
	}  
	  
	private boolean deleteChildren(File dir) {  
	    File[] children = dir.listFiles();  
	    boolean childrenDeleted = true;  
	    for (int i = 0; children != null && i < children.length; i++) {  
	        File child = children[i];  
	        if (child.isDirectory()) {  
	            childrenDeleted = this.deleteChildren(child) && childrenDeleted;  
	        }  
	        if (child.exists()) {  
	            childrenDeleted = child.delete() && childrenDeleted;  
	        }  
	    }  
	    return childrenDeleted;  
	}
}
