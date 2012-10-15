package com.grupobbva.bc.per.tel.iilc.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;

@SuppressWarnings("unchecked")
public interface ICargaDAO { 
	
	public List listarIntervalos() throws SQLException;
	public void grabarIntervalos(String valor1,String valor2,int cod_ele) throws SQLException;
	public boolean validarCruzeIntervalos(String valor1,String valor2,String cod_ele) throws SQLException;
	public boolean validarFechas(String fecha)throws ParseException   ;
	public boolean validarEstadoCargaActual(int id,String fecha_original) throws ParseException, SQLException  ;
	public boolean verificarExisteCarga(String fecha,String tipoCarga)  throws SQLException, ParseException ;
	public boolean verificarEstadoProcesoCarga(String fecha,String tipoCarga)   throws SQLException,ParseException;
	public boolean actualizarCargaArchivo(int id,Date fecha) throws SQLException ;
	public boolean actualizarCargaArchivo(int id,int estado) throws SQLException ;
	public boolean crearCargaArchivo(Date fecha,int tipoCarga,int id_estado,String usureg) throws SQLException ;
	public Tiilc_adm_carga_archivo listarCargaArchivo(String tipo) throws SQLException;
	public List listarLogArchivo(String tipo) throws SQLException;
	public List listarCargasArchivos(String tipo) throws SQLException ; 
	public boolean eliminarCargaArchivo(int id) ;
	public boolean sobreescribirCargaArchivo(Date fecha,int tipoCarga,int id_estado,String usureg) throws SQLException ;
	public boolean verificarEstadoProcesoCargaPorID(int id)  throws SQLException, ParseException;
	public Tiilc_adm_carga_archivo obtenerHoraCarga(String tipo,String fecha) throws SQLException ;
	public Tiilc_adm_carga_archivo obtenerCargaDelDia(String tipo,String fecha) throws SQLException ;
	public Tiilc_adm_carga_archivo obtenerCargaPorID(long id) throws SQLException ;
	
	
	public void lanzarCargaCliente(long id) throws SQLException ;
	public void lanzarCargaGestor(long id) throws SQLException ;
	public Object lanzarCargaCentro(long id) throws SQLException ;
	public void lanzarCargaColectivo(long id) throws SQLException ;
	public void lanzarCargaVariofer(long id) throws SQLException ;
	public void lanzarCargaAlmaccc(long id) throws SQLException ;
	public void lanzarCargaEstm(long id) throws SQLException ;
	
	public String sp_calcular_dia() throws SQLException ;
	
	public void actulizarCargaCentro(long estado) throws SQLException ;
	
	public List verificarProgramacionPorRango(Tiilc_adm_carga_archivo objTiilc_adm_carga_archivo) throws SQLException ;
	
}
