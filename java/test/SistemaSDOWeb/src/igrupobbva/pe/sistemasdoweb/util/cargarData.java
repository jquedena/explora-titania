package igrupobbva.pe.sistemasdoweb.util;

/**
 * @file cargarData.java
 * @version 1.1
 * @author Godofredo Ureta
 * @date   23/05/2009
 * @descriptio Leer informacion de Archivo de Texto para cargarlo a la BD
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.log4j.Logger;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Plan;

@SuppressWarnings({"unused"})
public class cargarData {
	private static Logger log = Logger.getLogger(cargarData.class);
	
	public static void main(String[] args) {
		
		try {
		
			Connection conexion = new Connection();
			FileReader fr = new FileReader("c:\\fichero.txt");
			BufferedReader bf = new BufferedReader(fr);
			String sCadena;
			String valorDato;
			while ((sCadena = bf.readLine())!=null) {
				log.info(sCadena);
				Plan plan = new Plan();
				
				String[] _valorLinea = UtilListas.getArrayStrings(sCadena,",");
				int nNum = _valorLinea.length;
				log.info("Numero de Registros::"+nNum);
				/**
				for(int i =0; i<nNum; i++) {
					valorDato = _valorLinea[i];
					log.info("Dato_"+1+":"+valorDato);
				}
				*/
				
				// Ingresando los registros Seleccionados
				plan.setCodEpigrafe(_valorLinea[0]);
				plan.setNomEpigrafe(_valorLinea[1]);
				plan.setPesoDor(new BigDecimal(_valorLinea[2].trim()));
				plan.setCodOficina(_valorLinea[3]);
				plan.setMes(_valorLinea[4]);
				plan.setAnho(_valorLinea[5]);
				plan.setMonto(UtilListas.tramaToBigDecimal(_valorLinea[6].trim(), 2));
				plan.setPorAlcanzado(UtilListas.tramaToBigDecimal(_valorLinea[7].trim(), 2));
				plan.setDesvPpto(UtilListas.tramaToBigDecimal(_valorLinea[8].trim(), 2));
				plan.setNroMesesFalt(UtilListas.tramaToBigDecimal(_valorLinea[9].trim(), 2));
				plan.setProyCrecMens(UtilListas.tramaToBigDecimal(_valorLinea[10].trim(), 2));
				plan.setAjusEstiTerr(UtilListas.tramaToBigDecimal(_valorLinea[11].trim(), 2));
				plan.setProyAjusMens(UtilListas.tramaToBigDecimal(_valorLinea[12].trim(), 2));
				plan.setSaldMediJunio(UtilListas.tramaToBigDecimal(_valorLinea[13].trim(), 2));
				plan.setPorcSaldMedJun(UtilListas.tramaToBigDecimal(_valorLinea[14].trim(), 2));
				plan.setSaldDiciAnter(UtilListas.tramaToBigDecimal(_valorLinea[15].trim(), 2));
				plan.setSaldMediDici(UtilListas.tramaToBigDecimal(_valorLinea[16].trim(), 2));
				plan.setCodTerritorio(_valorLinea[17]);
				plan.setPorcSaldMedDic(UtilListas.tramaToBigDecimal(_valorLinea[18].trim(), 2));
				plan.setFactAjusSaldPunt(UtilListas.tramaToBigDecimal(_valorLinea[19].trim(), 2));
				plan.setHistBajas(UtilListas.tramaToBigDecimal(_valorLinea[20].trim(), 2));
				plan.setMetaMesSaldPunt(UtilListas.tramaToBigDecimal(_valorLinea[21].trim(), 2));
				plan.setMetaGereOficina(UtilListas.tramaToBigDecimal(_valorLinea[22].trim(), 2));
				plan.setPrioridad(UtilListas.tramaToBigDecimal(_valorLinea[23].trim(), 2));
				plan.setMesEval(_valorLinea[24]);
				plan.setIndDor(_valorLinea[25]);
				
				// Insertando el Registro a la Tabla Planes
				//boolean rst = conexion.createPlan(plan);
				
			} 
				
			 
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}

		
	}

}