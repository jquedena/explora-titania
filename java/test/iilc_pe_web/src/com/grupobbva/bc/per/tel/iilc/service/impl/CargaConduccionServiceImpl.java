package com.grupobbva.bc.per.tel.iilc.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;
import com.grupobbva.bc.per.tel.iilc.service.ICargaConduccionService;

@Repository("iCargaConduccionService")
public class CargaConduccionServiceImpl implements ICargaConduccionService {
	
	@Autowired
	private ICargaDAO iCargaDAO;

	@Autowired
	public void setICargaDAO(ICargaDAO cargaDAO) {
		iCargaDAO = cargaDAO;
	}

	public int actualizarProgramacion(int id,String fecha,String fecha_original){ 
		
		try{
			String tipoCarga=Constantes.CODIGO_VARIOFER;
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
			e.printStackTrace();
			return 0;
		}
		
	}

	
	public int crearProgramacionCarga(String fecha,String usureg,boolean sobreescritura){ 
		
		try{
			String tipoCarga=Constantes.CODIGO_LCONDUCC;
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
			e.printStackTrace();
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
	
	public List listarFechasProgramadas(){ 
		String tipoCarga=Constantes.CODIGO_LCONDUCC; 
		try {
			return iCargaDAO.listarCargasArchivos(tipoCarga) ;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
	}
	

	public boolean verificarProcesamientoCarga(int id){
		try {
			return iCargaDAO.verificarEstadoProcesoCargaPorID(id);
		} catch (Exception  e) { 
			e.printStackTrace();
			return false;
		}
	}
	
}
