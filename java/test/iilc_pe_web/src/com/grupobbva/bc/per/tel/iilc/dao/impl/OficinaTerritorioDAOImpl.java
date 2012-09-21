package com.grupobbva.bc.per.tel.iilc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.OficinaTerritorio;
import com.grupobbva.bc.per.tel.iilc.beans.PermisoUsuario;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.dao.IOficinaTerritorioDAO;

public class OficinaTerritorioDAOImpl implements IOficinaTerritorioDAO {

	private Logger logger = Logger.getLogger(OficinaTerritorioDAOImpl.class);

	public Connection getConnection(){
		Connection cnn = null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext != null) {
				DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
				if (datasource != null) {
					cnn = datasource.getConnection();
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return cnn;
	}
	
	public boolean verificarGestor(String registro, String codOficina, String cargo) {
		int verificar = -1;
    	try {
    		String query = "";
    		
    		if(cargo.equals("B23")) {
    			query = "select count(1) cta from iilc.tiilc_gestor where cod_oficina = '" + codOficina + "' and perfil_gestor = 'M'";
    		} else {
    			query = "select count(1) cta from iilc.tiilc_gestor where reg_gestor='" + registro + "'";
    		}
    		
    		Connection cnn = getConnection();
    		Statement stm = cnn.createStatement();
    		ResultSet rst = stm.executeQuery(query);
    		
    		if(rst.next()){
    			verificar = rst.getInt("cta");
    		}
    		
    		rst.close();
    		stm.close();
    		cnn.close();
		} catch (Exception e) {
			verificar = -1;
			logger.error("verificarGestor", e);
		}
		return (verificar >= 1);
	}
	
	public int perfil(String codUsuario, String codCargo) {
		int perfil = -1;
    	try {
    		String query = "select a.tipo_acceso"
				+ " from iilc.tiilc_permiso_perfil a"
				+ " where a.valor_rcp in('" + codCargo + "', '" + codUsuario.trim() + "')";
    		
    		Connection cnn = getConnection();
    		Statement stm = cnn.createStatement();
    		ResultSet rst = stm.executeQuery(query);
    		
    		if(rst.next()){
    			perfil = rst.getInt("tipo_acceso");
    		}
    		
    		rst.close();
    		stm.close();
    		cnn.close();
		} catch (Exception e) {
			perfil = -1;
			logger.error(e);
		}
		return perfil;
    }
	
	public String obtenerFiltroPerfil(String perfil) {
		String temp = ""; 
    	try {
    		String query = "select cod_perfil, des_perfil from iilc.tiilc_perfil where cod_perfil in('" + perfil.replaceAll(",", "','") + "')";
    		
    		Connection cnn = getConnection();
    		Statement stm = cnn.createStatement();
    		ResultSet rst = stm.executeQuery(query);

    		while(rst.next()) {
    			
    			if(temp.length() > 0) temp += ", ";
    			temp += rst.getString("des_perfil");
    		}

    		rst.close();
    		stm.close();
    		cnn.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		return temp;
    }
	
	public String obtenerFiltroTerritorio(String codTerr, String codOfic, String codGest, String codUsuario) {
    	String descTerr = "";
    	try {
    		String query = "select a.cod_territorio";
    		query += ", nvl(a.des_territorio, ' ') des_territorio";
    		
    		if(!codOfic.equalsIgnoreCase("-1")) {
	    		query += ", nvl(b.cod_oficina, ' ') cod_oficina";
	    		query += ", nvl(b.des_oficina, ' ') des_oficina";
	    		if(!codGest.equalsIgnoreCase("-1")) {
		    		query += ", nvl(c.cod_gestor, ' ') cod_gestor";
		    		query += ", nvl(c.nom_gestor, ' ') nom_gestor";
	    		}
    		}   		
    		
    		query += " from iilc.tiilc_territorio a ";
			if(codUsuario.length()!=0) { 
				query += "inner join (";
				query += "select cod_territorio from iilc.tiilc_permiso_usuario_consulta where cod_usuario='"; 
				query +=  codUsuario.trim(); 
				query += "' group by cod_territorio) ax on a.cod_territorio=ax.cod_territorio ";
			}
    		
    		
    		if(!codOfic.equalsIgnoreCase("-1")) { 
    			query += "left join iilc.tiilc_oficina b on a.cod_territorio=b.cod_territorio ";
    			if(!codGest.equalsIgnoreCase("-1")) {
    				query += "left join iilc.tiilc_gestor c on b.cod_territorio=c.cod_territorio and b.cod_oficina=c.cod_oficina ";
    			}
    		}
    		
    		query += "where (a.cod_territorio in('" + codTerr.replaceAll(",", "','") + "'))";
    		
    		if(!codOfic.equalsIgnoreCase("-1")) {
    			query += " and (b.cod_oficina in('" + codOfic.replaceAll(",", "','") + "'))";
    			if(!codGest.equalsIgnoreCase("-1")) {
    				query += " and (c.cod_gestor in('" + codGest.replaceAll(",", "','") + "'))";
    			}
    		}
    		
    		query += " order by a.cod_territorio";
    		
    		if(!codOfic.equalsIgnoreCase("-1")) {
    			query += ", b.cod_oficina";
    			if(!codGest.equalsIgnoreCase("-1")) {
    				query += ", c.cod_gestor";
    			}
    		}
    		
    		logger.info("SQL: " + query);
    		
    		String sidTerr = "-1";
    		String sidOfic = "-1";
    		String tmpOfic = "";
    		String sidGest = "-1";
    		String tmpGest = "";
    		String temp = "";
    		
    		Connection cnn = getConnection();
    		Statement stm = cnn.createStatement();
    		ResultSet rst = stm.executeQuery(query);
    		
    		while(rst.next()) {
    			
    			if(sidTerr.equalsIgnoreCase("-1")) sidTerr = rst.getString("des_territorio");
    			if(sidOfic.equalsIgnoreCase("-1") && !codOfic.equalsIgnoreCase("-1")) sidOfic = rst.getString("des_oficina");
    			if(sidGest.equalsIgnoreCase("-1") && !codGest.equalsIgnoreCase("-1")) sidGest = rst.getString("nom_gestor");
    			
    			if(!codGest.equalsIgnoreCase("-1")) {
    				temp = rst.getString("nom_gestor");
    				if(!temp.equalsIgnoreCase(sidGest)){
        				if(tmpGest.length() > 0) tmpGest += ", ";
        				tmpGest += sidGest;
        				sidGest = temp;
        			}
    			} else {
    				tmpGest = "Todos"; 
    			}
    			
    			if(!codOfic.equalsIgnoreCase("-1")) {
    				temp = rst.getString("des_oficina");
    				if(!temp.equalsIgnoreCase(sidOfic)){
        				if(tmpOfic.length() > 0) tmpOfic += ", ";
        				tmpOfic += sidOfic + " (" + tmpGest + ")";
        				sidOfic = temp;
        				tmpGest = "";
        			}
    			} else {
    				tmpOfic = "Todos"; 
    			}
    			
    			temp = rst.getString("des_territorio");
    			if(!temp.equalsIgnoreCase(sidTerr)){
    				if(descTerr.length() > 0) descTerr += "<br>";
    				descTerr += sidTerr + " (" + tmpOfic + ")";
    				sidTerr = temp;
    				tmpOfic = "";
    			}
    		}
    		
    		if(!codGest.equalsIgnoreCase("-1")) {
    			if(tmpGest.length() > 0) tmpGest += ", ";
    			tmpGest += sidGest;
    		} else{
    			tmpGest = "Todos";
    		}
    		
    		if(!codOfic.equalsIgnoreCase("-1")) {
    			if(tmpOfic.length() > 0) tmpOfic += ", ";
    			tmpOfic += sidOfic + " (" + tmpGest + ")";
    		} else{
    			tmpOfic = "Todos";
    		}
    		
    		if(descTerr.length() > 0) descTerr += "<br>";
    		descTerr += sidTerr + " (" + tmpOfic + ")";
    		
    		rst.close();
    		stm.close();
    		cnn.close();
		} catch (Exception e) {
			logger.error("obtenerFiltroTerritorio", e);
		}
		
		return descTerr;
    }
	
	public List<OficinaTerritorio> listarOficina() {
    	List<OficinaTerritorio> listOficinaTerritorio = new ArrayList<OficinaTerritorio>();
    	try {
    		String query = "select a.cod_oficina as codOficina "
	    		+ ", a.cod_territorio as  codTerritorio"
				+ ", a.cod_area as codArea"
				+ ", a.des_oficina as desOficina"
				+ ", b.des_territorio as desTerritorio"
				+ " from iilc.tiilc_oficina a inner join iilc.tiilc_territorio b on a.cod_territorio=b.cod_territorio"
				// + " where b.des_territorio like 'G.T.%'"
				+ " order by b.des_territorio, a.des_oficina";
    		
    		Connection cnn = getConnection();
    		Statement stm = cnn.createStatement();
    		ResultSet rst = stm.executeQuery(query);
    		OficinaTerritorio o;
    		while(rst.next()) {
    			o = new OficinaTerritorio();
    			o.setCodOficina(rst.getString("codOficina"));
    			o.setCodTerritorio(rst.getString("codTerritorio"));
    			o.setCodArea(rst.getString("codArea"));
    			o.setDesOficina(rst.getString("desOficina"));
    			o.setDesTerritorio(rst.getString("desTerritorio"));
    			listOficinaTerritorio.add(o);
    		}
    		
    		rst.close();
    		stm.close();
    		cnn.close();
		} catch (Exception e) {
			logger.error(e);
		}
		return listOficinaTerritorio;
    }
	
	public boolean registrarPermiso(PermisoUsuario o) {
		boolean result = true;
		
		try {
			String query = "{call PIILC_PERMISO_USUARIO.REGISTRAR_PERMISO(?, ?, ?, ?, ?, ?, ?)}";
			
			Connection cnn = getConnection();
			CallableStatement stm = cnn.prepareCall(query);
			
			stm.setString("codUsuario", o.getCodUsuario());
			stm.setString("codOficina", o.getCodOficina());
			stm.setString("codArea", o.getCodArea());
			stm.setString("codTerritorio", o.getCodTerritorio());
			stm.setString("usuReg", o.getUsuReg());
			stm.setString("checked", o.getChecked());
			stm.registerOutParameter("err", Types.INTEGER);
			stm.execute();
			
			int err = stm.getInt("err");
			
			if(err == -1) {
				result = false;
			}
			
			stm.close();
			cnn.close();
		} catch (Exception e) {
			logger.error(e);
			result = false;
		}
		
		return result;
	}

	public List<PermisoUsuario> listarPermiso(String codUsuario) {
		List<PermisoUsuario> listPermisoUsuario = new ArrayList<PermisoUsuario>();
		try {
			String query = "select *"
				+ " from iilc.tiilc_permiso_usuario_consulta"
				+ " where cod_usuario='" + codUsuario + "'";
			
			Connection cnn = getConnection();
			Statement stm = cnn.createStatement();
			ResultSet rst = stm.executeQuery(query);
			PermisoUsuario o;
			while(rst.next()) {
				o = new PermisoUsuario();
				o.setCodOficina(rst.getString("cod_oficina"));
				o.setCodTerritorio(rst.getString("cod_territorio"));
				o.setCodArea(rst.getString("cod_area"));
				o.setCodUsuario(rst.getString("cod_usuario"));
				o.setChecked("on");
				listPermisoUsuario.add(o);
			}
			
			rst.close();
			stm.close();
			cnn.close();
		} catch (Exception e) {
			logger.error(e);
		}
		return listPermisoUsuario;
	}
	
	public boolean eliminarPermiso(String codUsuario) {
		boolean result = true;
	
		try {
			String query = "{call PIILC_PERMISO_USUARIO.ELIMINAR_PERMISO(?, ?)}";
			
			Connection cnn = getConnection();
			CallableStatement stm = cnn.prepareCall(query);
			
			stm.setString("codUsuario", codUsuario);
			stm.registerOutParameter("err", Types.INTEGER);
			stm.execute();
			
			int err = stm.getInt("err");
			
			if(err == -1) {
				result = false;
			}
			
			stm.close();
			cnn.close();
		} catch (Exception e) {
			logger.error(e);
			result = false;
		}
		
		return result;
	}
}
