package indra.bbva.pizele.persistence;

import indra.bbva.pizele.domain.base.Backup;

import java.util.HashMap;
import java.util.List;

public interface BackupPersistence 
{

	@SuppressWarnings("unchecked")
	List listarBackupVigente(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarBackupVigenteDetalle(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarBackupVigenteDetalleTraslape(HashMap params);
	
	@SuppressWarnings("unchecked")
	List listarBackup(HashMap params);
	
    void insertarBackup(Backup objBackup);
    
    void actualizarBackupVigente(Backup objBackup);
	
	void eliminarBackup(Backup objBackup);
	
	
}
