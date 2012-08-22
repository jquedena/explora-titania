package indra.bbva.pizele.service;

import indra.bbva.pizele.domain.base.Backup;
import indra.bbva.pizele.domain.base.Gestor;
import indra.bbva.pizele.domain.extend.BackupDetalle;
import indra.bbva.pizele.persistence.BackupPersistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BackupService 
{

	@Autowired
	private BackupPersistence backupPersistence;
	
	@SuppressWarnings("unchecked")
	public Backup listarBackupVigente(Backup objBackup) 
	{
		HashMap map = new HashMap();
		
		if(objBackup.getCodigoGOF() != null && objBackup.getCodigoGOF().length() > 0)
			map.put("PI_COD_GOF", objBackup.getCodigoGOF());
		if(objBackup.getCodigoGestorSuplente() != null && objBackup.getCodigoGestorSuplente().length() > 0)
			map.put("PI_COD_GES_SUP", objBackup.getCodigoGestorSuplente());
		
		this.backupPersistence.listarBackupVigente(map);
		
		List<Backup> listaBackup = (List<Backup>)map.get("BACKUP_CUR_REF");
		
		if(listaBackup.size() == 0)
			return null;
		else
			return listaBackup.get(0);
		
	}
	
	@SuppressWarnings("unchecked")
	private List<BackupDetalle>  listarBackupVigenteDetalle(Backup objBackup) 
	{
		HashMap map = new HashMap();
		
		if(objBackup.getCodigoGOF() != null && objBackup.getCodigoGOF().length() > 0)
			map.put("PI_COD_GOF", objBackup.getCodigoGOF());
		
		backupPersistence.listarBackupVigenteDetalle(map);
		
		return (List<BackupDetalle>)map.get("BACKUP_CUR_REF");
				
	}
	
	public List<BackupDetalle> listarBackupVigenteDetalle(Backup objBackup, List<Gestor> listaGestores) 
	{
		List<BackupDetalle> listaBackupVigenteDetalle = this.listarBackupVigenteDetalle(objBackup);
		
		for (BackupDetalle backupDetalle: listaBackupVigenteDetalle) {
			
			String codusu = backupDetalle.getCodigoGestorSuplente();
			for (Gestor gestor: listaGestores) {
				if (gestor.getCodigoRegistro().equalsIgnoreCase(codusu)) {
					backupDetalle.setNombre(gestor.getNombre());
					backupDetalle.setApellidoPaterno(gestor.getApellidoPaterno());
					backupDetalle.setApellidoMaterno(gestor.getApellidoMaterno());
					break;
				}
			}
		}
		
		return listaBackupVigenteDetalle;	
	}
	
	@SuppressWarnings("unchecked")
	private List<BackupDetalle>  listarBackupVigenteDetalleTraslape(Backup objBackup) 
	{
		HashMap map = new HashMap();
		map.put("PI_COD_GES_SUP", objBackup.getCodigoGestorSuplente());
		map.put("PI_FEC_VIG", objBackup.getFechaVigente());
		
		this.backupPersistence.listarBackupVigenteDetalleTraslape(map);
		
		@SuppressWarnings("unused")
		List<BackupDetalle> lista = (List<BackupDetalle>)map.get("BACKUP_CUR_REF");
		
		return (List<BackupDetalle>)map.get("BACKUP_CUR_REF");
				
	}
	
	public List<BackupDetalle> listarBackupVigenteDetalleTraslape(Backup objBackup, List<Gestor> listaGestores) 
	{
		List<BackupDetalle> listaBackupVigenteDetalle = this.listarBackupVigenteDetalleTraslape(objBackup);

		for (BackupDetalle backupDetalle: listaBackupVigenteDetalle) {

			String codusu = backupDetalle.getCodigoGestorSuplente();
			for (Gestor gestor: listaGestores) {
				if (gestor.getCodigoRegistro().equalsIgnoreCase(codusu)) {
					backupDetalle.setNombre(gestor.getNombre());
					backupDetalle.setApellidoPaterno(gestor.getApellidoPaterno());
					backupDetalle.setApellidoMaterno(gestor.getApellidoMaterno());
					break;
				}
			}
		}

		return listaBackupVigenteDetalle;	
	}
	
	@SuppressWarnings("unchecked")
	public Backup listarBackup(Backup objBackup) 
	{
		HashMap map = new HashMap();
		
		if(objBackup.getId() != null && objBackup.getId() > 0)
			map.put("PI_ID_BACKUP", objBackup.getId());
		
		if(objBackup.getCodigoGOF() != null && objBackup.getCodigoGOF().length() > 0)
			map.put("PI_COD_GOF", objBackup.getCodigoGOF());
	
		this.backupPersistence.listarBackup(map);
		
		List<Backup> listaBackup = (List<Backup>)map.get("BACKUP_CUR_REF");
		
		if(listaBackup.size() == 0)
			return null;
		else
			return listaBackup.get(0);
		
	}
	

	@Transactional
	public void insertarBackup(Backup objBackup) 
	{
		this.backupPersistence.insertarBackup(objBackup);
	}
	
	@Transactional
	public void actualizarBackupVigente(Backup objBackup) 
	{
		this.backupPersistence.actualizarBackupVigente(objBackup);
	}
	
	@Transactional
	public void eliminarBackup(List<Backup> listaBackup) 
	{
		for(int index = 0; index < listaBackup.size(); index++)
		{
			this.backupPersistence.eliminarBackup(listaBackup.get(index));
		}				
	}
	
	
}
