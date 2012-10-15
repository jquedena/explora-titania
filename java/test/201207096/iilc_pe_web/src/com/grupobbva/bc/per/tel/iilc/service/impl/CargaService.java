package com.grupobbva.bc.per.tel.iilc.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;
import com.grupobbva.bc.per.tel.iilc.service.ICargaService;


@Repository("iCargaService")
public class CargaService implements ICargaService 
{

	@Autowired
	private ICargaDAO iCargaDAO;
	
	@Autowired
	public void setICargaDAO(ICargaDAO cargaDAO) {
		iCargaDAO = cargaDAO;
	}
	
	public String verificarConflictoCarga(String tipo, Date fecha) throws SQLException 
	{
		Tiilc_adm_carga_archivo objTiilc_adm_carga_archivo = new Tiilc_adm_carga_archivo();
		objTiilc_adm_carga_archivo.setFecha_inicio(fecha);
				
		StringBuilder sbMensaje = new StringBuilder();
		
		if(tipo.equals(Constantes.CODIGO_LCONDUCC))
		{
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_ALMACCC));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(2);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_ALMACCC));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_ESTM));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(2);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_ESTM));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_VARIOFER));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(2);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_VARIOFER));
			
		}
		else if(tipo.equals(Constantes.CODIGO_ALMACCC))
		{
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_LCONDUCC));
			objTiilc_adm_carga_archivo.setHorasAntes(2);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_LCONDUCC));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_ESTM));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_ESTM));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_VARIOFER));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_VARIOFER));
		}
		else if(tipo.equals(Constantes.CODIGO_ESTM))
		{
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_LCONDUCC));
			objTiilc_adm_carga_archivo.setHorasAntes(2);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_LCONDUCC));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_ALMACCC));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_ALMACCC));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_VARIOFER));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_VARIOFER));
		}
		else if(tipo.equals(Constantes.CODIGO_VARIOFER))
		{
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_LCONDUCC));
			objTiilc_adm_carga_archivo.setHorasAntes(2);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_LCONDUCC));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_ALMACCC));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_ALMACCC));
			
			objTiilc_adm_carga_archivo.setTipo(Integer.parseInt(Constantes.CODIGO_ESTM));
			objTiilc_adm_carga_archivo.setHorasAntes(1);
			objTiilc_adm_carga_archivo.setHorasDespues(1);
			sbMensaje.append(this.formarMensaje((List<Tiilc_adm_carga_archivo>)iCargaDAO.verificarProgramacionPorRango(objTiilc_adm_carga_archivo), tipo, Constantes.CODIGO_ESTM));
		}
				
		return sbMensaje.toString();
	}

	private String formarMensaje(List<Tiilc_adm_carga_archivo> lista, String tipoCarga, String tipoVerificacion)
	{
		
		if(lista == null || lista.size() == 0)
			return "";
		
		StringBuilder sbMensaje = new StringBuilder();
		String nombreArchivo = "";
		String recomendacion = "";
				
		if(tipoVerificacion.equals(Constantes.CODIGO_LCONDUCC))
		{
			nombreArchivo = "LCONDUCC";
			recomendacion = "Realize su carga una hora antes o dos horas despues.";
		}					
		else if(tipoVerificacion.equals(Constantes.CODIGO_ALMACCC))
		{
			nombreArchivo = "ALMACCC";
			if(tipoCarga.equals(Constantes.CODIGO_LCONDUCC))
				recomendacion = "Realize su carga dos horas antes o una hora despues.";
			else
				recomendacion = "Realize su carga una hora antes o una hora despues.";
		}			
		else if(tipoVerificacion.equals(Constantes.CODIGO_ESTM))
		{
			nombreArchivo = "ESTM";
			if(tipoCarga.equals(Constantes.CODIGO_LCONDUCC))
				recomendacion = "Realize su carga dos horas antes o una hora despues.";
			else
				recomendacion = "Realize su carga una hora antes o una hora despues.";
		}			
		else if(tipoVerificacion.equals(Constantes.CODIGO_VARIOFER))
		{
			nombreArchivo = "VARIOFER";
			if(tipoCarga.equals(Constantes.CODIGO_LCONDUCC))
				recomendacion = "Realize su carga dos horas antes o una hora despues.";
			else
				recomendacion = "Realize su carga una hora antes o una hora despues.";
		}
		
		sbMensaje.append("Existe una carga programada del archivo " + nombreArchivo + " a las \n");
		
		for(Tiilc_adm_carga_archivo obj : lista)
		{			
			sbMensaje.append(obj.getFecha_inicio_str() + "\n");
		}
		
		sbMensaje.append(recomendacion + "\n");
		
		return sbMensaje.toString();
	}
	
}
