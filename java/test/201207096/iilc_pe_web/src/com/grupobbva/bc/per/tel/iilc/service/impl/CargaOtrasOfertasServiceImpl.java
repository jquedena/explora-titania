package com.grupobbva.bc.per.tel.iilc.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.apache.commons.beanutils.BeanComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.service.ICargaOtrasOfertasService;
import com.grupobbva.bc.per.tel.iilc.service.ICargaService;

@Service("iCargaOtrasOfertasService")
@Scope("singleton")
public class CargaOtrasOfertasServiceImpl implements ICargaOtrasOfertasService{
	@Autowired
	private ICargaDAO iCargaDAO;

	@Autowired
	public void setICargaDAO(ICargaDAO cargaDAO) {
		iCargaDAO = cargaDAO;
	}
	
	@Autowired
	private ICargaService iCargaService;

	private String mensaje;
	
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
				}else
				{
					String msg = this.iCargaService.verificarConflictoCarga(tipoCarga, formatoDelTexto.parse(fecha));
					
					if(msg == null || msg.length() == 0)
					{
						return iCargaDAO.actualizarCargaArchivo(id,formatoDelTexto.parse(fecha))==true?4:0;				
					}						
					else
					{
						this.setMensaje(msg);
						return 10;
					}
				}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int crearProgramacionCarga(String fecha,String usureg,boolean sobreescritura){ 
		
		try{
			String tipoCarga=Constantes.CODIGO_VARIOFER;
			int id_estado=Constantes.ID_ESTADO_CARGA_PENDIENTE;
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			if(sobreescritura){
				if(!iCargaDAO.validarFechas(fecha)){
					return 1;
				}else if(iCargaDAO.verificarEstadoProcesoCarga(fecha,tipoCarga)){
					return 3;
				}else
				{
					String msg = this.iCargaService.verificarConflictoCarga(tipoCarga, formatoDelTexto.parse(fecha));
					
					if(msg == null || msg.length() == 0)
					{
						return iCargaDAO.sobreescribirCargaArchivo(formatoDelTexto.parse(fecha),Integer.parseInt(tipoCarga),id_estado,usureg)==true?4:0;				
					}						
					else
					{
						this.setMensaje(msg);
						return 10;
					}		
				} 
			}else{
				if(!iCargaDAO.validarFechas(fecha)){
					return 1;
				}else if(iCargaDAO.verificarExisteCarga(fecha,tipoCarga) ){
					return 2;
				}else if(iCargaDAO.verificarEstadoProcesoCarga(fecha,tipoCarga)){
					return 3;
				}else
				{  
						
					String msg = this.iCargaService.verificarConflictoCarga(tipoCarga, formatoDelTexto.parse(fecha));
					
					if(msg == null || msg.length() == 0)
					{
						return iCargaDAO.crearCargaArchivo(formatoDelTexto.parse(fecha),Integer.parseInt(tipoCarga),id_estado,usureg)==true?4:0;				
					}						
					else
					{
						this.setMensaje(msg);
						return 10;
					}	
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
		String tipoCarga=Constantes.CODIGO_VARIOFER; 
		try {
			return iCargaDAO.listarCargasArchivos(tipoCarga) ;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
	}
	

	public List listarLogError(String tipo){  
		try {
			return iCargaDAO.listarLogArchivo(tipo) ;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
	}
	

	public Tiilc_adm_carga_archivo visualizarEstadoCarga(){ 
		String tipoCarga=Constantes.CODIGO_VARIOFER; 
		try {
			return iCargaDAO.listarCargaArchivo(tipoCarga)   ;
		} catch (Exception  e) { 
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
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
