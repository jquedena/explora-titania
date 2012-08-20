package com.grupobbva.bc.per.tel.iilc.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat; 
import java.util.List; 
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes; 
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO; 
import com.grupobbva.bc.per.tel.iilc.service.ICargaOfertasService;

@Service("iCargaOfertasService")
public class CargaOfertasServiceImpl implements ICargaOfertasService {
	
	private static Logger log = Logger.getLogger(CargaOfertasServiceImpl.class);
			
	@Autowired
	private ICargaDAO iCargaDAO;

	@Autowired
	public void setICargaDAO(ICargaDAO cargaDAO) {
		iCargaDAO = cargaDAO;
	}
	
	public List listarIntervalos(){
		String tipoCodMult=Constantes.TIPO_COD_MULT_INVERVALOS; 
		try { 
			List lista =iCargaDAO.listarIntervalos(); 
			return lista;
		} catch (Exception e) { 
			log.error(e);
			return null;
		}
	}
	
	public int actualizarProgramacion(int id,String fecha,String fecha_original,String tipoCarga){ 
		
		try{ 
			int id_estado=Constantes.ID_ESTADO_CARGA_PENDIENTE;
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				if(!iCargaDAO.validarEstadoCargaActual(id,fecha_original)){
					return 0;
				}else if(!iCargaDAO.validarFechas(fecha)){
					return 1;
				}else if(iCargaDAO.verificarExisteCarga(fecha,tipoCarga) ){
					return 2;
				}else if(iCargaDAO.verificarEstadoProcesoCarga(fecha,tipoCarga)){
					return 3;
				}else{  
					return iCargaDAO.actualizarCargaArchivo(id,formatoDelTexto.parse(fecha))==true?4:0;
				}
		}catch(Exception e){
			log.error(e);
			return 0;
		}
	}
	
	
	public int validacionIntervalos(String valor1,String valor2,String cod_ele){
		try{ 
				if(Integer.parseInt(valor1)==0 && Integer.parseInt(valor2)==0){
					return 1;
				}
				if(iCargaDAO.validarCruzeIntervalos(valor1, valor2,cod_ele)){
					return 0;
				}
			//del 0  con error
			return 1;//1 es el indicador que todo esta ok 
		}catch(Exception e){
			log.error(e);
			return 0;
		}
	}
	
	
	public boolean grabarIntervalos(String valor1[],String valor2[]){
		try{ 
			int resultadoValidacion;
			int i;
			for(i=0; i < valor1.length; i++){
				if(valor1[i].length()==0) valor1[i] = "0";
				if(valor2[i].length()==0) valor2[i] = "0";
				resultadoValidacion=this.validacionIntervalos(valor1[i],valor2[i], String.valueOf(i));
				if(resultadoValidacion < 1){
					return false;
				}
			}
			for(i=0; i < valor1.length; i++){
				iCargaDAO.grabarIntervalos(valor1[i], valor2[i], i);
			}
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}
	}
	
	
	public int crearProgramacionCarga(String fecha,String usureg,boolean sobreescritura,String tipoCarga){ 
		
		try{ 
			int id_estado=Constantes.ID_ESTADO_CARGA_PENDIENTE;
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			if(sobreescritura){
				if(!iCargaDAO.validarFechas(fecha)){
					return 1;
				}else if(iCargaDAO.verificarEstadoProcesoCarga(fecha,tipoCarga)){
					return 3;
				}else{  
					return iCargaDAO.sobreescribirCargaArchivo(formatoDelTexto.parse(fecha),Integer.parseInt(tipoCarga),id_estado,usureg)==true?4:0;
				} 
			}else{
				if(!iCargaDAO.validarFechas(fecha)){
					return 1;
				}else if(iCargaDAO.verificarExisteCarga(fecha,tipoCarga) ){
					return 2;
				}else if(iCargaDAO.verificarEstadoProcesoCarga(fecha,tipoCarga)){
					return 3;
				}else{  
					return iCargaDAO.crearCargaArchivo(formatoDelTexto.parse(fecha),Integer.parseInt(tipoCarga),id_estado,usureg)==true?4:0;
				} 
			}
		}catch(Exception e){
			log.error(e);
			return 0;
		}
		
	}

	public int eliminarProgramacionCarga(String arreglo[]) throws Exception{ 
	 
		if(arreglo!=null  && arreglo.length>0){
 			for(int i=0;i<arreglo.length;i++){  
 				if(iCargaDAO.verificarEstadoProcesoCargaPorID(Integer.parseInt(arreglo[i]))){ 
 					return 1;
 				}else{
 					iCargaDAO.eliminarCargaArchivo(Integer.parseInt(arreglo[i]));
 				}
 			}
		}
		return 2;
	}
	
	public List listarFechasProgramadas(String tipoCarga){  
		try {
			return iCargaDAO.listarCargasArchivos(tipoCarga) ;
		} catch (SQLException e) { 
			log.error(e);
			return null;
		}
	}
	
	
	public Tiilc_adm_carga_archivo visualizarEstadoCarga(String tipoCarga){  
		try {
			return iCargaDAO.listarCargaArchivo(tipoCarga)   ;
		} catch (Exception  e) { 
			log.error(e);
			return null;
		}
	}
	
	
	public boolean verificarProcesamientoCarga(int id){
		try {
			return iCargaDAO.verificarEstadoProcesoCargaPorID(id);
		} catch (Exception  e) { 
			log.error(e);
			return false;
		}
	}
	
}
