package com.grupobbva.bc.per.tel.iilc.conexionEJB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.Descarga;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.dao.impl.DescargaDAOImpl;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.VinculacionGco;
import com.grupobbva.bc.per.tel.iilc.serializable.VinculacionPh;
import com.grupobbva.bc.per.tel.iilc.serializable.VinculacionVip;

@SuppressWarnings({"unused", "unchecked"})
public class ConexionDAO {
	
	private static Logger log = Logger.getLogger(ConexionDAO.class);
	
	public Connection getConexion(){
		Connection con = null;
		String sql = null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}
		} catch (Exception e) {
			log.error("getConexion", e);
		}
		return con;
			
	}

	public AdministracionCargaVinculacion obtenerProgramacionCargaVinculacion(String fechaConcatenada,String tipo)throws SQLException{
		
		AdministracionCargaVinculacion res = null;
		Connection con = null;
		String sql = null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}
			
			if (con == null) {
				return null;
			}
			
			sql = "select ID_REGISTRO,TIPO,to_char(FECHA_INICIO,'dd/MM/yyyy hh24:mi') FECHA_INICIO,ID_ESTADO,to_char(FECHA_FIN,'dd/MM/yyyy hh24:mi') FECHA_FIN ,ARCHIVO_CARGA,FILAS_LEIDAS,FILAS_PROCESADAS,FILAS_NO_PROCESADAS,PROCESANDO, "
				+"USUREG,FECREG,USUMOD,FECMOD  from iilc.TIILC_ADM_CARGA_ARCH_VINCULA where tipo='"+tipo+"' and " +
				" to_char(FECHA_INICIO,'dd/MM/yyyy/HH24/mi') = '" + fechaConcatenada + "' and PROCESANDO = '0'";
			Statement s = con.createStatement();

			try {
				ResultSet rst = s.executeQuery(sql);

				if(rst != null) {
					while (rst.next()) {
						res = new AdministracionCargaVinculacion();
						res.setId_registro(rst.getInt("ID_REGISTRO"));
						res.setTipo(rst.getInt("TIPO"));
						res.setFecha_inicio_casteada(rst.getString("FECHA_INICIO"));
						res.setId_estado(rst.getInt("ID_ESTADO"));
						res.setFecha_fin_casteada(rst.getString("FECHA_FIN"));
						res.setArchivo_carga(rst.getInt("ARCHIVO_CARGA"));
						res.setFilas_leidas(rst.getInt("FILAS_LEIDAS"));
						res.setFilas_no_procesadas(rst.getInt("FILAS_PROCESADAS"));
						res.setFilas_no_procesadas(rst.getInt("FILAS_NO_PROCESADAS"));
						res.setProcesando(rst.getInt("PROCESANDO"));
						res.setUsureg(rst.getString("USUREG"));
						res.setFecreg(rst.getDate("FECREG"));
						res.setUsumod(rst.getString("USUMOD"));
						res.setFecmod(rst.getDate("FECMOD"));
					}
				}
			} catch (SQLException e1) {
				log.error("SQLException [" + sql + "]");
				log.error("obtenerProgramacionCargaVinculacion", e1);
			}
			s.close();
			con.close();
			initialContext.close();
		} catch (Exception e1) {
			log.error("Exception [" + sql + "]");
			log.error("obtenerProgramacionCargaVinculacion", e1);
			con.close();
		}
		return res;
	}
	
	public Multitabla findRecord(String codigo) {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			sql = "select " +
				"COD_MULT,COD_ELE,nvl(VALOR1,'-') VALOR1,nvl(VALOR2,'-') VALOR2,nvl(VALOR3,'-') VALOR3,nvl(VALOR4,'-') VALOR4" +
				" from iilc.tiilc_multitabla where " +
				"COD_MULT = '" + codigo.substring(0,3) + "' and COD_ELE = '" + codigo.substring(3,codigo.length()) + "'";
			Statement s = con.createStatement();
			try {
				ResultSet rst = s.executeQuery(sql);

				//filas
				while (rst.next()) {
					res = new Multitabla();
					res.setCod_mult(rst.getString("COD_MULT"));
					res.setCod_ele(rst.getString("COD_ELE"));
					res.setValor1(rst.getString("VALOR1"));
					res.setValor2(rst.getString("VALOR2"));
					res.setValor3(rst.getString("VALOR3"));
					res.setValor4(rst.getString("VALOR4"));
				}

			} catch (SQLException e1) {
				log.error(e1.getMessage());
				e1.printStackTrace();
			}
			s.close();
			con.close();
			initialContext.close();
		} catch (Exception e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
		}
		return res;
	}
	
	
	
	public boolean deleteVinculacion(String codigo)  {
		Boolean retorno = false;
		Connection con = null;
		String sql = null;
		Statement s=null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			if(codigo.equals("V")){
				sql = " delete from iilc.TIILC_VINCULACION_VIP  ";
			}else if(codigo.equals("P")){
				sql = " delete from iilc.TIILC_VINCULACION_PH  ";
			}else if(codigo.equals("G")){
				sql = " delete from iilc.TIILC_VINCULACION_GCO  ";
			}
			s = con.createStatement();

			s.executeUpdate(sql);
			s.close();
			con.close();
			retorno=true;
		} catch (Exception e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
			retorno=false;
			try{
				s.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		} 
		return retorno;
	}
	
	public boolean deleteLogVinculacion(long id)  {
		Boolean retorno = false;
		Connection con = null;
		String sql = null;
		Statement s=null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
 
				sql = " delete from iilc.TIILC_LOG_ERROR_ARCHVINCULA where ID_REGISTRO="+id+"  ";
			s = con.createStatement();
			s.executeUpdate(sql);
			s.close();
			con.close();
			retorno=true;
		} catch (Exception e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
			retorno=false;
			try{
				s.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		} 
		return retorno;
	}
	
	
	
	public void actualizarEstadoCarga(AdministracionCargaVinculacion horario,String estado,String isEstado) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		Statement s =null;
		try {
		Context initialContext = new InitialContext();
		if (initialContext == null) {

		}
		DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

		if (datasource != null) {
		con = datasource.getConnection();
		} else {
		initialContext = null;

		}

		sql = " update iilc.TIILC_ADM_CARGA_ARCH_VINCULA set id_estado='"+isEstado+"',procesando='"+estado+"' ";
		if (Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO.equals(isEstado) ||
		Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO_ERROR.equals(isEstado)) {
		sql = sql + ", FECHA_FIN = sysdate ";
		}
		sql = sql + " where ID_REGISTRO ='" + horario.getId_registro() + "' ";
		s = con.createStatement();
		s.executeUpdate(sql);
		s.close();
		con.close();

		} catch (Exception e1) {
		log.error(e1.getMessage());
		s.close();
		con.close();
		e1.printStackTrace();
		}
		}


	
	public void eliminarCargaVinculacion( String fecha,String tipo) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		Statement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			sql = " delete from iilc.TIILC_ADM_CARGA_ARCH_VINCULA  where  FECHA_INICIO =to_date('"+fecha+"','dd-MM-yyyy HH24:mi:ss') and TIPO='"+tipo+"' and PROCESANDO=0   ";
			s = con.createStatement();
			s.executeUpdate(sql);
			s.close();
			con.close();
			
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
		} 
	}
	
	
	
	



	
	public List listarCargasVinculacion(String tipo) throws SQLException {
		AdministracionCargaVinculacion res = null;
		List lista=new ArrayList();
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			sql = " select to_char(FECHA_INICIO,'dd-MM-yyyy HH24:mi:ss') fecha " + 
					" from iilc.TIILC_ADM_CARGA_ARCH_VINCULA where TIPO='"+tipo+"' order by FECHA_INICIO desc ";
			s = con.prepareStatement(sql);
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
			res = new AdministracionCargaVinculacion();
			res.setFecha(rs.getString("fecha")); 
			lista.add(res);
			}
			
			s.close();
			con.close();
			return lista;
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
			return null;
		} 
	}
	
	
	
	public List listarLogVinculacion(String tipo) throws SQLException {
		List lista=new ArrayList();
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			sql = "SELECT lo.LINEA||'	'|| lo.DESC_ERROR||'	'||lo.TEXTO   as linea " +
				" FROM IILC.TIILC_LOG_ERROR_ARCHVINCULA lo "+
				" INNER JOIN IILC.tiilc_adm_carga_arch_vincula a on a.id_registro=lo.id_registro "+
				" where tipo="+tipo+" and to_char(a.fecha_inicio,'dd-MM-yyyy')=(select to_char(max(fecha_inicio),'dd-MM-yyyy') " +
				"from IILC.tiilc_adm_carga_arch_vincula where tipo="+tipo+" ) order by lo.LINEA asc ";
			s = con.prepareStatement(sql);
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
				lista.add(rs.getString("linea"));
			}
			
			s.close();
			con.close();
			return lista;
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
			return null;
		} 
	}
	
	
	
	public List listarLogErrorLConduc() throws SQLException {
		List lista=new ArrayList();
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			sql = "  	SELECT  "+
				" lo.LINEA||'|'|| "+
				" lo.TEXTO||'|'|| "+
				" lo.DESC_ERROR   as linea " +
				" FROM IILC.TIILC_ERROR_CARGA  lo where id_registro in (" +
				"SELECT MAX(ID_REGISTRO) ID_REGISTRO FROM IILC.TIILC_ADM_CARGA_ARCHIVO WHERE TIPO = 7) ";
			s = con.prepareStatement(sql);
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
				lista.add(rs.getString("linea"));
			}
			
			s.close();
			con.close();
			return lista;
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
			return null;
		} 
	}
	
	public AdministracionCargaVinculacion listarCargaVinculacion(String tipo) throws SQLException {
		AdministracionCargaVinculacion res = null;
		Connection con = null;
		String sql = null; 
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
			}
			
			sql = " select to_char(a.FECHA_INICIO,'yyyyMMdd HH24mi') as fecha_formateada, to_char(a.fecha_inicio,'yyyy/MM/dd HH24:mi') fecha_inicio,to_char(a.fecha_fin,'yyyy/MM/dd HH24:mi') fecha_fin, a.filas_leidas,a.filas_no_procesadas, a.filas_procesadas, " +
				" c.DESCRIPCION, a.archivo_carga ,a.id_estado,to_char(a.FECHA_INICIO_REAL,'yyyy/MM/dd HH24:mi') fecha_inicio_real from iilc.TIILC_ADM_CARGA_ARCH_VINCULA a  " +
				" inner join iilc.tiilc_estado_carga_arch c on a.id_estado=c.id_estado  " +
				" where TIPO='"+tipo+"'   and to_char(FECHA_INICIO,'dd/mm/yyyy')<=to_char(sysdate,'dd/mm/yyyy')  " +
				" order by FECHA_INICIO  desc ";
			s = con.prepareStatement(sql);
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
			res = new AdministracionCargaVinculacion();
			res.setFecha_inicio_casteada(rs.getString("fecha_inicio"));
			res.setFechaInicioReal(rs.getString("fecha_inicio_real")==null?"":rs.getString("fecha_inicio_real"));
			res.setFecha_fin_casteada(rs.getString("fecha_fin"));
			res.setFilas_leidas(rs.getLong("filas_leidas"));
			res.setFilas_no_procesadas(rs.getLong("filas_no_procesadas"));
			res.setFilas_procesadas(rs.getLong("filas_procesadas"));
			res.setEstadoDescripcion(rs.getString("DESCRIPCION"));
			res.setFecha(rs.getString("fecha_formateada"));
			res.setId_estado(rs.getInt("id_estado"));
			res.setArchivo_cargaDescripcion(rs.getInt("archivo_carga")==1?"Si":"No");
			s.close();
			con.close();
			 return res;
			}
			
			s.close();
			con.close();
			return res;
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
			return null;
		} 
	}
	
	public void crearCargaVinculacion(AdministracionCargaVinculacion objBean) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			sql = " insert into iilc.TIILC_ADM_CARGA_ARCH_VINCULA(ID_REGISTRO,TIPO,FECHA_INICIO,ID_ESTADO,USUREG,FECREG,PROCESANDO) " +
					" values (to_number(SEQ_COD_ADMI_ARCH_VINC.nextval),"+objBean.getTipo()+
					",to_date('"+objBean.getFecha()+"','dd-MM-yyyy HH24:mi:ss')," +
					objBean.getId_estado()+",'"+objBean.getUsureg()+"',sysdate,'0') ";
			s = con.prepareStatement(sql);
			s.executeUpdate(sql);
			s.close();
			con.close();
			
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
		} 
	}
	
	public void actualizarCargaVinculacion(AdministracionCargaVinculacion objBean, String fechaOld) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			StringTokenizer fechaInicioTok=new StringTokenizer(objBean.getFecha()+"-" ,"-");
			String fechaInicio=Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio=fechaInicio+"-"+Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio=fechaInicio+"-"+Utilitario.dosCeros(fechaInicioTok.nextToken());
			objBean.setFecha(fechaInicio);
			
			sql = " update iilc.TIILC_ADM_CARGA_ARCH_VINCULA  " +
					" set   ID_ESTADO='1' , FECHA_FIN=null ,FECHA_INICIO_REAL=null , ARCHIVO_CARGA=0,FILAS_LEIDAS=0,FILAS_PROCESADAS=0,FILAS_NO_PROCESADAS=0,PROCESANDO=0," +
					" FECREG=sysdate,USUREG='" + objBean.getUsureg() + "', USUMOD='',FECMOD=null, " +
					" FECHA_INICIO=to_date('"+objBean.getFecha()+"','dd-MM-yyyy HH24:mi:ss')" +
					" where to_char(FECHA_INICIO,'DD-MM-yyyy')='"+fechaOld+"' and TIPO='"+objBean.getTipo()+"'" +
					" and PROCESANDO='0' ";
			log.info(sql);
			s = con.prepareStatement(sql);
			s.executeUpdate(sql);
			s.close();
			con.close();
			
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
		} 
	}
	
	public void actualizarCargaVinculacion(AdministracionCargaVinculacion objBean) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			StringTokenizer fechaInicioTok=new StringTokenizer(objBean.getFecha()+"-" ,"-");
			String fechaInicio=Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio=fechaInicio+"-"+Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio=fechaInicio+"-"+Utilitario.dosCeros(fechaInicioTok.nextToken());
			objBean.setFecha(fechaInicio);
			
			sql = " update iilc.TIILC_ADM_CARGA_ARCH_VINCULA  " +
					" set   ID_ESTADO='1' , FECHA_FIN=null ,FECHA_INICIO_REAL=null , ARCHIVO_CARGA=0,FILAS_LEIDAS=0,FILAS_PROCESADAS=0,FILAS_NO_PROCESADAS=0,PROCESANDO=0," +
					" FECREG=sysdate,USUREG='" + objBean.getUsureg() + "', USUMOD='',FECMOD=null, " +
					" FECHA_INICIO=to_date('"+objBean.getFecha()+"','dd-MM-yyyy HH24:mi:ss')" +
					" where to_char(FECHA_INICIO,'DD-MM-yyyy')='"+objBean.getFecha().substring(0,10)+"' and TIPO='"+objBean.getTipo()+"'" +
					" and PROCESANDO='0' ";
			log.info(sql);
			s = con.prepareStatement(sql);
			s.executeUpdate(sql);
			s.close();
			con.close();
			
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
		} 
	}

	public int verificarExistenciaCarga(AdministracionCargaVinculacion objBean) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			 
			StringTokenizer fechaInicioTok=new StringTokenizer(objBean.getFecha()+"-" ,"-");
			String fechaInicio=Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio=fechaInicio+"-"+Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio=fechaInicio+"-"+Utilitario.dosCeros(fechaInicioTok.nextToken());
			objBean.setFecha(fechaInicio);
					
			sql = " select ID_REGISTRO,PROCESANDO from iilc.TIILC_ADM_CARGA_ARCH_VINCULA" +
					" where to_date(to_char(FECHA_INICIO,'DD-MM-yyyy'),'DD-MM-yyyy')=to_date('"+objBean.getFecha().substring(0,10)+"','DD-MM-yyyy') and TIPO='"+objBean.getTipo()+"' ";
			
			s = con.prepareStatement(sql);
			ResultSet rs=s.executeQuery(sql);

			
			if(rs.next()){
				int i= rs.getInt("PROCESANDO");
				rs.close();
				s.close();
				con.close();
				return i;
			}
			rs.close();
			s.close();
			con.close();
			return -1;
			
		} catch (Exception e1) {
			log.error(e1.getMessage());
			con.close();
			e1.printStackTrace();
			return 0;
		} 
	}
	
	public int verificarExistenciaCargaSinFecha(AdministracionCargaVinculacion objBean) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			sql = " select ID_REGISTRO,PROCESANDO from iilc.TIILC_ADM_CARGA_ARCH_VINCULA" +
					" where TIPO='"+objBean.getTipo()+"' ";
			
			s = con.prepareStatement(sql);
			ResultSet rs=s.executeQuery(sql);

			
			if(rs.next()){
				int i= rs.getInt("PROCESANDO");
				rs.close();
				s.close();
				con.close();
				return i;
			}
			rs.close();
			s.close();
			con.close();
			return -1;
			
		} catch (Exception e1) {
			log.error(e1.getMessage());
			con.close();
			e1.printStackTrace();
			return 0;
		} 
	}
	
	
	public void registrarLogError(String linea,String descripcion,long numeroLinea,long idRegistro) throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		PreparedStatement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
			
			sql = " insert into iilc.TIILC_LOG_ERROR_ARCHVINCULA(ID_LOG,ID_REGISTRO,LINEA,TEXTO,DESC_ERROR,USUREG,FECREG) " +
					" values (to_number(iilc.SEQ_COD_LOG_ERROR_VINC.nextval),"+idRegistro+","+numeroLinea+",'"+linea.replace("'"," ")+"','"+descripcion+"','WAS',sysdate) ";
			s = con.prepareStatement(sql);
			s.executeUpdate(sql);
			s.close();
			con.close();
			
		} catch (Exception e1) {
			log.error(e1.getMessage());
			s.close();
			con.close();
			e1.printStackTrace();
		} 
	}
	
	public void actualizarAuditoria(AdministracionCargaVinculacion horario)  throws SQLException {
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		Statement s =null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				 
			}
 
			sql = " update iilc.TIILC_ADM_CARGA_ARCH_VINCULA " +
					"set " +
					"FECHA_FIN=sysdate," +
					"ARCHIVO_CARGA='"+horario.getArchivo_carga()+"' " +
					"where ID_REGISTRO ='"+horario.getId_registro()+"'   ";
			s = con.createStatement();
			
			s.executeUpdate(sql);
			s.close();
			con.close();
			
		}  catch (SQLException e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
		}  catch (Exception e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
			s.close();
			con.close();
		} 
	}
	
	public void insertarVinculacionGco(VinculacionGco objetoVinculacion) throws SQLException ,Exception{
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		Statement s =null;
		 
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext .lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
			}
			sql = " insert into iilc.TIILC_VINCULACION_GCO values (" +
					"'"+objetoVinculacion.getCod_territorio()+"'," +
					"'"+objetoVinculacion.getCod_oficina()+"'," +
					"'"+objetoVinculacion.getCodigo_cliente()+"'," +
					"'"+objetoVinculacion.getCod_gestor()+"'," +
					"'"+objetoVinculacion.getNombre_cliente()+"'," +
					"'"+objetoVinculacion.getNom_gestor()+"'," +
					"'"+objetoVinculacion.getSegmento()+"'," +
					"'"+objetoVinculacion.getBloque()+"'," +
					""+objetoVinculacion.getPres_com_letras()+"," +
					""+objetoVinculacion.getCom_exterior()+"," +
					""+objetoVinculacion.getLeasing()+"," +
					""+objetoVinculacion.getRiesgo_firma()+"," +
					""+objetoVinculacion.getTarjeta_cap_tra()+"," +
					""+objetoVinculacion.getTotal_tar_empre()+"," +
					""+objetoVinculacion.getHipo_autos()+"," +
					""+objetoVinculacion.getCta_plazo()+"," +
					""+objetoVinculacion.getFmutuos()+"," +
					""+objetoVinculacion.getCta_cte_ahorro()+"," +
					""+objetoVinculacion.getTotal_sal_pa_py()+"," +
					""+objetoVinculacion.getBolsa()+"," +
					"'"+objetoVinculacion.getHaberes()+"'," +
					"'"+objetoVinculacion.getProveedores()+"'," +
					"'"+objetoVinculacion.getRecaudacion()+"'," +
					"'"+objetoVinculacion.getBanca_internet()+"'," +
					"'"+objetoVinculacion.getSeguros()+"'," +
					""+objetoVinculacion.getPtos_prescom_letras()+"," +
					""+objetoVinculacion.getPtos_com_ext()+"," +
					""+objetoVinculacion.getPtos_leasing()+"," +
					""+objetoVinculacion.getPtos_riesgo_firma()+"," +
					""+objetoVinculacion.getPtos_tarj_cap_trab()+"," +
					""+objetoVinculacion.getPtos_tarj_emp()+"," +
					""+objetoVinculacion.getPtos_hipo_autos()+"," +
					""+objetoVinculacion.getPtos_cta_cte_ahorro()+"," +
					""+objetoVinculacion.getPtos_cta_plazo()+"," +
					""+objetoVinculacion.getPtos_fmutuos()+"," +
					""+objetoVinculacion.getPtos_tot_pas_pym()+"," +
					""+objetoVinculacion.getPtos_bolsa()+"," +
					""+objetoVinculacion.getPtos_pago_haberes()+"," +
					""+objetoVinculacion.getPtos_pago_prov()+"," +
					""+objetoVinculacion.getPtos_recaudaciones()+"," +
					""+objetoVinculacion.getPtos_banca_internet()+"," +
					""+objetoVinculacion.getPtos_seguros()+"," +
					""+objetoVinculacion.getTotal_puntos()+"," +
					"'"+objetoVinculacion.getVinculado()+"'," +
					"'"+objetoVinculacion.getRango_vinculacion()+"'," +
					"'"+objetoVinculacion.getLibre1()+"'," +
					"'"+objetoVinculacion.getLibre2()+"'," +
					"'"+objetoVinculacion.getLibre3()+"'," +
					"'"+objetoVinculacion.getUsureg()+"'," +
							"sysdate) ";

			s = con.createStatement(); 
			s.executeUpdate(sql);
			s.close();
			con.close();
	}
	
	public void insertarVinculacionVip(VinculacionVip objetoVinculacion) throws SQLException ,Exception{
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		Statement s =null;
		 
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext .lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
			}
			sql = " insert into iilc.TIILC_VINCULACION_VIP values (" +
					"'"+objetoVinculacion.getCod_territorio()+"'," +
					"'"+objetoVinculacion.getCod_oficina()+"'," +
					"'"+objetoVinculacion.getCodigo_cliente()+"'," +
					"'"+objetoVinculacion.getCod_gestor()+"'," +
					"'"+objetoVinculacion.getNombre_cliente()+"'," +
					"'"+objetoVinculacion.getNom_gestor()+"'," +
					""+objetoVinculacion.getSegmento()+"," +
					""+objetoVinculacion.getAhorro_cta_cero().replace(",","")+"," +
					""+objetoVinculacion.getCuenta_cte_vip().replace(",","")+"," +
					""+objetoVinculacion.getAhorro_cta_gan().replace(",","")+"," +
					""+objetoVinculacion.getOtras_ctas_ahorro().replace(",","")+"," +
					""+objetoVinculacion.getFamilia1().replace(",","")+"," +
					""+objetoVinculacion.getPlazo().replace(",","")+"," +
					""+objetoVinculacion.getFondos_mutuos().replace(",","")+"," +
					""+objetoVinculacion.getBolsa().replace(",","")+"," +
					""+objetoVinculacion.getCts().replace(",","")+"," +
					""+objetoVinculacion.getFamilia2().replace(",","")+"," +
					""+objetoVinculacion.getPres_libre_dis().replace(",","")+"," +
					""+objetoVinculacion.getPres_auto().replace(",","")+"," +
					""+objetoVinculacion.getPres_hipotecario().replace(",","")+"," +
					""+objetoVinculacion.getTc_activas().replace(",","")+"," +
					""+objetoVinculacion.getFamilia3().replace(",","")+"," +
					""+objetoVinculacion.getInfomail().replace(",","")+"," +
					""+objetoVinculacion.getHaberes().replace(",","")+"," +
					""+objetoVinculacion.getBca_internet().replace(",","")+"," +
					""+objetoVinculacion.getDomiciliado().replace(",","")+"," +
					""+objetoVinculacion.getFamilia4().replace(",","")+"," +
					""+objetoVinculacion.getVida().replace(",","")+"," +
					""+objetoVinculacion.getOnc_dent()+"," +
					""+objetoVinculacion.getProteccion_tc()+"," +
					""+objetoVinculacion.getOtros_seguros()+"," +
					""+objetoVinculacion.getFamilia5()+"," +
					""+objetoVinculacion.getTotal_puntos()+"," +
					"'"+objetoVinculacion.getPerfil()+"'," +
					""+objetoVinculacion.getLibre1()+"," +
					""+objetoVinculacion.getLibre2()+"," +
					""+objetoVinculacion.getLibre3()+"," +
					"'"+objetoVinculacion.getUsureg()+"'," +
							"sysdate) ";
			s = con.createStatement(); 
			s.executeUpdate(sql);
			s.close();
			con.close();
	}
	
	public void insertarVinculacionPh(VinculacionPh objetoVinculacion) throws SQLException ,Exception{
		Multitabla res = null;
		Connection con = null;
		String sql = null;
		Statement s =null;
		 
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				 
			}
			DataSource datasource = (DataSource) initialContext .lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
			}
			sql = " insert into iilc.TIILC_VINCULACION_PH values (" +
					"'"+objetoVinculacion.getCod_territorio()+"'," +
					"'"+objetoVinculacion.getCod_oficina()+"'," +
					"'"+objetoVinculacion.getCodigo_cliente()+"'," +
					"'"+objetoVinculacion.getCod_gestor()+"'," +
					"'"+objetoVinculacion.getDes_territorio()+"'," +
					"'"+objetoVinculacion.getDes_oficina()+"'," +
					"'"+objetoVinculacion.getCodcli_emisora()+"'," +
					"'"+objetoVinculacion.getNom_emisora()+"'," +
					"'"+objetoVinculacion.getNombre()+"'," +
					"'"+objetoVinculacion.getApellido1()+"'," +
					"'"+objetoVinculacion.getApellido2()+"'," +
					"'"+objetoVinculacion.getTipdoc_identidad()+"'," +
					"'"+objetoVinculacion.getDoc_identidad()+"'," +
					"to_date('"+objetoVinculacion.getFecha_nacimiento()+"','yyyy-MM-dd')," +
					"'"+objetoVinculacion.getTipo_tlf1().replace("null", "")+"'," +
					"'"+objetoVinculacion.getCod_ciudad_tlf1().replace("null", "")+"'," +
					"'"+objetoVinculacion.getNro_tlf1().replace("null", "")+"'," +
					"'"+objetoVinculacion.getTipo_tlf2().replace("null", "")+"'," +
					"'"+objetoVinculacion.getCod_ciudad_tlf2().replace("null", "")+"'," +
					"'"+objetoVinculacion.getNro_tlf2().replace("null", "")+"'," +
					"'"+objetoVinculacion.getTipo_tlf3().replace("null", "")+"'," +
					"'"+objetoVinculacion.getCod_ciudad_tlf3()+"'," +
					"'"+objetoVinculacion.getNro_tlf3()+"'," +
					"'"+objetoVinculacion.getSegmento()+"'," +
					"'"+objetoVinculacion.getClasificacion_rcc()+"'," +
					"'"+objetoVinculacion.getRango_ingreso()+"'," +
					""+objetoVinculacion.getSm_prest_consumo().replace("null", "")+"," +
					""+objetoVinculacion.getNro_prest_consumo().replace("null", "")+"," +
					""+objetoVinculacion.getSm_prest_hipo().replace("null", "")+"," +
					""+objetoVinculacion.getNro_prest_hipo().replace("null", "")+"," +
					""+objetoVinculacion.getSm_tarj_cred().replace("null", "")+"," +
					""+objetoVinculacion.getNro_plasticos().replace("null", "")+"," +
					""+objetoVinculacion.getTarj_creditos().replace("null", "")+"," +
					""+objetoVinculacion.getNro_ctas_ahorro().replace("null", "")+"," +
					""+objetoVinculacion.getNro_ctas_vista().replace("null", "")+"," +
					""+objetoVinculacion.getNro_ctas_fmutuos().replace("null", "")+"," +
					""+objetoVinculacion.getNro_ctas_plazo().replace("null", "")+"," +
					""+objetoVinculacion.getNro_ctas_cts().replace("null", "")+"," +
					""+objetoVinculacion.getMargen_ordinario().replace("null", "")+"," +
					""+objetoVinculacion.getMargen_ordinario_acum().replace("null", "")+"," +
					"'"+objetoVinculacion.getTipo_oferta()+"'," +
			 		""+objetoVinculacion.getImp_oferta_consumo()+"," +
					""+objetoVinculacion.getTasa1()+"," +
					""+objetoVinculacion.getTasa2()+"," +
					""+objetoVinculacion.getTasa3()+"," +
					"'"+objetoVinculacion.getImp_oferta_tarjeta()+"'," +
					""+objetoVinculacion.getLinea_tc()+"," +
					"'"+objetoVinculacion.getCanal().replace("null", "")+"'," +
					"'"+objetoVinculacion.getLibre1()+"'," +
					"'"+objetoVinculacion.getLibre2()+"'," +
					"'"+objetoVinculacion.getLibre3()+"'," +
					"'"+objetoVinculacion.getUsureg()+"'," +
							"sysdate) ";
			s = con.createStatement(); 
			s.executeUpdate(sql);
			s.close();
			con.close();
	}
	
	public int insertarDescarga(String registro, String archivo, String descripcion) {
		DescargaDAOImpl dao = new DescargaDAOImpl();
		return dao.insertar(registro, archivo, descripcion);
	}
	
	public void actualizarDescarga(int id, int estado) {
		DescargaDAOImpl dao = new DescargaDAOImpl();
		dao.actualizar(id, estado);
	}
	
	public List<Descarga> listarDescarga(String registro) {
		DescargaDAOImpl dao = new DescargaDAOImpl();
		return dao.findDescargas(registro);
	}
	
}
