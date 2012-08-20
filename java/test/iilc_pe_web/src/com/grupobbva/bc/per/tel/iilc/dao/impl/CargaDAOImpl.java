package com.grupobbva.bc.per.tel.iilc.dao.impl;
  
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;
import com.ibatis.sqlmap.client.SqlMapClient;

@SuppressWarnings("unchecked")
@Service("iCargaDAO")
public class CargaDAOImpl  implements ICargaDAO {

	private static Logger log = Logger.getLogger(CargaDAOImpl.class);
			
	@Autowired
	private SqlMapClient sqlMapClient;
 
	
    @Autowired
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public boolean actualizarCargaArchivo(int id,Date fecha) throws SQLException {
		Tiilc_adm_carga_archivo tiilc_adm_carga_archivo=new Tiilc_adm_carga_archivo();
		tiilc_adm_carga_archivo.setId_registro(id);
		tiilc_adm_carga_archivo.setFecha_inicio(fecha);  
		sqlMapClient.insert("actualizarProgramacionCarga",tiilc_adm_carga_archivo);
		return true;
	}

	
	public boolean actualizarCargaArchivo(int id,int estado) throws SQLException {
		Tiilc_adm_carga_archivo tiilc_adm_carga_archivo=new Tiilc_adm_carga_archivo();
		tiilc_adm_carga_archivo.setId_registro(id);
		tiilc_adm_carga_archivo.setId_estado(estado);  
		sqlMapClient.insert("actualizarProgramacionCargaEstado",tiilc_adm_carga_archivo);
		return true;
	}

	
	public boolean sobreescribirCargaArchivo(Date fecha,int tipoCarga,int id_estado,String usureg) throws SQLException { 
		Tiilc_adm_carga_archivo tiilc_adm_carga_archivo=new Tiilc_adm_carga_archivo();
		tiilc_adm_carga_archivo.setTipo(tipoCarga);
		tiilc_adm_carga_archivo.setFecha_inicio(fecha);
		tiilc_adm_carga_archivo.setId_estado(id_estado);
		tiilc_adm_carga_archivo.setUsureg(usureg);
		sqlMapClient.insert("sobreescribirProgramacionCarga",tiilc_adm_carga_archivo);
		return false;
	}
	
	
	public boolean crearCargaArchivo(Date fecha,int tipoCarga,int id_estado,String usureg) throws SQLException { 
		Tiilc_adm_carga_archivo tiilc_adm_carga_archivo=new Tiilc_adm_carga_archivo();
		tiilc_adm_carga_archivo.setTipo(tipoCarga);
		tiilc_adm_carga_archivo.setFecha_inicio(fecha);
		tiilc_adm_carga_archivo.setId_estado(id_estado);
		tiilc_adm_carga_archivo.setUsureg(usureg);
		
		sqlMapClient.insert("insertarProgramacionCarga",tiilc_adm_carga_archivo);
		return false;
	}

	public boolean eliminarCargaArchivo(int id) { 
		try {
			sqlMapClient.delete("eliminarArchivo",id);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return true;
	}

	public Tiilc_adm_carga_archivo listarCargaArchivo(String tipo) throws SQLException {
		Tiilc_adm_carga_archivo object=null;
		List lista=(List)sqlMapClient.queryForList("listarEstadoCarga", tipo);
		if(lista!=null && lista.size()>0){
			object=(Tiilc_adm_carga_archivo)lista.get(0);
		}
		return object;
	}
	
	public Tiilc_adm_carga_archivo obtenerHoraCarga(String tipo,String fecha) {
		Tiilc_adm_carga_archivo object = null;
		try {
			Map paramM = new HashMap();  
			paramM.put("fecha", fecha);  
			paramM.put("tipo", tipo);  
			object=(Tiilc_adm_carga_archivo) sqlMapClient.queryForObject("obtenerHoraCarga",paramM);
		} catch(SQLException ex) {
			log.error(ex);
		}
		return object;
	}
	
	public Tiilc_adm_carga_archivo obtenerCargaDelDia(String tipo,String fecha) {
		Tiilc_adm_carga_archivo object = null;
		try {
			Map paramM = new HashMap();  
			paramM.put("fecha", fecha);  
			paramM.put("tipo", tipo);  
			object=(Tiilc_adm_carga_archivo) sqlMapClient.queryForObject("obtenerCargaDelDia",paramM);
		} catch(SQLException ex) {
			log.error(ex);
		}
		return object;
	}

	public Tiilc_adm_carga_archivo obtenerCargaPorID(long id) throws SQLException {
		Tiilc_adm_carga_archivo object=null;
		Map paramM = new HashMap();  
		paramM.put("id", id);    
		object=(Tiilc_adm_carga_archivo)sqlMapClient.queryForObject("obtenerCargaPorID",paramM); 
		return object;
	}
	
	public List listarCargasArchivos(String tipo) throws SQLException {
		List List=sqlMapClient.queryForList("listarCargas", tipo);
		return List;
	}

	public List listarLogArchivo(String tipo) throws SQLException {
		return   sqlMapClient.queryForList("listarLogArchivo",tipo);
	}

	public boolean validarFechas(String fecha) throws ParseException  { 
		Calendar hoy = Calendar.getInstance();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		String fechaServidor=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR)+ " "+ Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+":"+Utilitario.dosCeros(hoy.get(Calendar.MINUTE)+10);

			Date fechaDateServidor = formatoDelTexto.parse(fechaServidor);
			Date fechaDateSeleccionada=formatoDelTexto.parse(fecha);
			
			if(fechaDateServidor.before(fechaDateSeleccionada)){
				return true;
			}

		return false;
	}

	public boolean validarEstadoCargaActual(int id,String fecha_original) throws ParseException, SQLException  { 
		Calendar hoy = Calendar.getInstance();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		String fechaServidor=Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+hoy.get(Calendar.YEAR)+ " "+ Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+":"+Utilitario.dosCeros(hoy.get(Calendar.MINUTE));

			Date fechaDateServidor = formatoDelTexto.parse(fechaServidor);
			Date fechaDateSeleccionada=formatoDelTexto.parse(fecha_original);
			
			if(fechaDateSeleccionada.before(fechaDateServidor)){ 
				return false;
			}
			
			Tiilc_adm_carga_archivo object=(Tiilc_adm_carga_archivo)sqlMapClient.queryForObject("verificarExistenciaPorID", id);
			if(object.getId_estado()!=1){ 
				return false;
			}
			

		return true;
	}
	
	public boolean verificarExisteCarga(String fecha,String tipoCarga) throws SQLException, ParseException {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
		Map paramM = new HashMap();  
		paramM.put("fecha", formatoDelTexto.parse(fecha));  
		paramM.put("tipoCarga", tipoCarga);  
		Object object=sqlMapClient.queryForObject("verificarExistencia", paramM);
		return object==null?false:true;
	}
	
	public boolean validarCruzeIntervalos(String valor1,String valor2,String cod_ele) throws SQLException{
		ClienteDAOImpl cliente = new ClienteDAOImpl();
		String sql = "select iilc.validar_intervalo('" + cod_ele + "', " + valor1 + ", " + valor2 + ") valida from dual";
		int result = 0;
		Connection cnn = null;
		Statement stm = null;
		try {
			cnn = cliente.getConnection();
			stm = cnn.createStatement();
			ResultSet rss = stm.executeQuery(sql);

			if(rss.next()) {
				result = rss.getInt("valida");
			}
			
		} catch(Exception e) {
			log.error(e);
		} finally {
			try {
				stm.close();
			} catch(SQLException e) {
				log.error(e);
			}
			try {
				cnn.close();
			} catch(SQLException e) {
				log.error(e);
			}
		}
		
		return result==0?false:true;
	}
	
	
	public List listarIntervalos() throws SQLException{
 
		List lista=sqlMapClient.queryForList("listarIntervalos");
		return lista;
	}
	
	
	
	public void grabarIntervalos(String valor1,String valor2,int cod_ele) throws SQLException{
		Map paramM = new HashMap();  
		paramM.put("valor1",valor1);  
		paramM.put("valor2", valor2);
		paramM.put("cod_ele", cod_ele); 
		sqlMapClient.update("grabarIntervalos", paramM);
	}
	
	
	public void lanzarCargaCliente(long id) throws SQLException {
		 sqlMapClient.update("lanzarCargaCliente",id); 
	}

	
	public void lanzarCargaGestor(long id) throws SQLException {
		 sqlMapClient.update("lanzarCargaGestor",id); 
	}

	
	public Object lanzarCargaCentro(long id) throws SQLException {
		ClienteDAOImpl cliente = new ClienteDAOImpl();
		String sql = "{call iilc.piilc_carga_centro.sp_carga_centro(?, ?)}";
		Long result = 0L;
		Connection cnn = null;
		CallableStatement stm = null;
		try {
			cnn = cliente.getConnection();
			stm = cnn.prepareCall(sql);
			stm.registerOutParameter("rptaCarga", java.sql.Types.NUMERIC);
			stm.setLong("v_id_registro", Long.valueOf(id));
			stm.execute();
			
			result = stm.getLong("rptaCarga");
			
		} catch(Exception e) {
			log.error(e);
		} finally {
			try {
				stm.close();
			} catch(SQLException e) {
				log.error(e);
			}
			try {
				cnn.close();
			} catch(SQLException e) {
				log.error(e);
			}
		}
		
		return result;
	}

	
	public void lanzarCargaColectivo(long id) throws SQLException {
		 sqlMapClient.update("lanzarCargaColectivo",id); 
	}

	
	public void lanzarCargaVariofer(long id) throws SQLException {
		 sqlMapClient.update("lanzarCargaVariofer",id); 
	}

	
	public void lanzarCargaAlmaccc(long id) throws SQLException {
		 sqlMapClient.update("lanzarCargaAlmaccc",id); 
	}

	
	
	public void lanzarCargaEstm(long id) throws SQLException {
		 sqlMapClient.update("lanzarCargaEstm",id); 
	}

	public String sp_calcular_dia() throws SQLException {
		 return (String)sqlMapClient.queryForObject("sp_calcular_dia");
	}

	
	
	public boolean verificarEstadoProcesoCarga(String fecha,String tipoCarga)  throws SQLException, ParseException{
		Map paramM = new HashMap();  
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
		paramM.put("fecha", formatoDelTexto.parse(fecha));  
		paramM.put("tipoCarga", tipoCarga);  
		Tiilc_adm_carga_archivo object=(Tiilc_adm_carga_archivo)sqlMapClient.queryForObject("verificarExistencia", paramM);
		return (object!=null && object.getProcesando()==1)?true:false;
	}

	
	public boolean verificarEstadoProcesoCargaPorID(int id)  throws SQLException, ParseException{ 
		Tiilc_adm_carga_archivo object=(Tiilc_adm_carga_archivo)sqlMapClient.queryForObject("verificarExistenciaPorID", id);
		return (object!=null && object.getProcesando()==1)?true:false;
	}

	public void actulizarCargaCentro(long estado) throws SQLException {
		ClienteDAOImpl cliente = new ClienteDAOImpl();
		String sql = "update IILC.tiilc_adm_carga_archivo set id_estado = '1', fecha_fin = sysdate where id_registro in(1, 2)";
		Connection cnn = null;
		Statement stm = null;
		try {
			cnn = cliente.getConnection();
			stm = cnn.createStatement();
			log.info(sql);
			stm.executeUpdate(sql);
			
		} catch(Exception e) {
			log.error(e);
		} finally {
			try {
				stm.close();
			} catch(SQLException e) {
				log.error(e);
			}
			try {
				cnn.close();
			} catch(SQLException e) {
				log.error(e);
			}
		}
	}
}


