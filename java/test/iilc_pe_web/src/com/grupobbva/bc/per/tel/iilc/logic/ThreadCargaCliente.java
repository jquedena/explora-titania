/*
 * Created on 03/03/2011
 */
package com.grupobbva.bc.per.tel.iilc.logic;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;

/**
 * @author leharz
 */
public class ThreadCargaCliente extends Thread {
	public void run(){
		//System.out.println("[ThreadCargaCliente] inicio");
    	DataSource datasource = null;
		Connection con = null;
		CallableStatement stmt = null;
    	try {
			Context initialContext = new InitialContext();
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
			con = datasource.getConnection();
			
			String query = "BEGIN " +
							"PIILC_CARGA_CLIENTE.SP_CARGA(); " +
							"END;";
			stmt = con.prepareCall(query);
			stmt.execute();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
    }
}
