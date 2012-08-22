/*
 * Created on 19/09/2008
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.util;

import igrupobbva.pe.sistemasdoweb.migracion.migracionData;
import proxy.load.Connection;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
/**
 * @author P020796
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ThreadMigracionData extends Thread {
	protected String nombreArchivoTemp;
	protected String nombreArchivoLog;
	
	public void run(){
		
		migracionData objMigracionData = new migracionData();
		//migracionData objMigrarDatosAction = new migracionData();
		objMigracionData.migracion1();
		objMigracionData.migracion1A1();
		objMigracionData.migracion1A2();
		objMigracionData.migracion2();
		objMigracionData.migracion3();
		objMigracionData.migracion4();
		objMigracionData.migracion5Planes1();
		objMigracionData.migracion5Planes2();
		objMigracionData.migracion5Planes3();
		objMigracionData.migracion5Planes4();
		objMigracionData.migracion5Planes5();
		objMigracionData.migracion5Planes6();
		objMigracionData.migracion5Planes7();
		objMigracionData.migracion5Planes8();
		objMigracionData.migracion5Planes9();
		objMigracionData.migracion5Planes10();
		objMigracionData.migracion5Planes11();
		objMigracionData.migracion5Planes12();
		/*****************************************/
		
		Connection ejb = new Connection();		
		@SuppressWarnings("unused")
		int indicador=ejb.actualizarEstadoFlag(ConstantesUtil.ESTADO_PROCESO_OK);
		
		/*CargaArchivoLDAP objCargaArchivoLDAP = new CargaArchivoLDAP();
		boolean res = objCargaArchivoLDAP.iniciaCarga(nombreArchivoTemp,nombreArchivoLog);
		*/		
	}
}
