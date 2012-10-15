package com.grupobbva.bc.per.tel.iilc.session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.ibm.etools.service.locator.ServiceLocatorManager;
/**
 * Bean implementation class for Enterprise Bean: SessionEmpresa
 */
public class SessionEmpresaBean implements javax.ejb.SessionBean {
    private javax.ejb.SessionContext mySessionCtx;

    private final static String STATIC_Tiilc_empresaLocalHome_REF_NAME = "ejb/Tiilc_empresa";
    private final static Class STATIC_Tiilc_empresaLocalHome_CLASS = Tiilc_empresaLocalHome.class;
    /**
     * getSessionContext
     */
    public javax.ejb.SessionContext getSessionContext() {
        return mySessionCtx;
    }

    /**
     * setSessionContext
     */
    public void setSessionContext(javax.ejb.SessionContext ctx) {
        mySessionCtx = ctx;
    }

    /**
     * ejbCreate
     */
    public void ejbCreate() throws javax.ejb.CreateException {
    }

    /**
     * ejbActivate
     */
    public void ejbActivate() {
    }

    /**
     * ejbPassivate
     */
    public void ejbPassivate() {
    }

    /**
     * ejbRemove
     */
    public void ejbRemove() {
    }

	public Empresa datosEmpresa(String codigo) {
		Empresa res = new Empresa();
		try {
			Connection con = null;
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			DataSource datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			Statement s = con.createStatement();
			String etiqueta="";
			try {
				String sql =
				"select cod_empresa, des_empresa " +
				"from iilc.tiilc_empresa " + 
				"where cod_empresa='" + codigo + "'";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					res = new Empresa();
					res.setCod_empresa(rst.getString("cod_empresa"));
					res.setDes_empresa(rst.getString("des_empresa"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			s.close();
			con.close();
			initialContext.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
    
    
    /**
     * 
     * @author P060049 Edgar Zavaleta Sierralta
     *
     */
    public Vector findAllEmpresa() {

        Vector listaEmpresa = new Vector();
        InitialContext contexto;
        Iterator empresaIterator = null;
        Collection empresaCollection = null;
        Object obj = null;
        try {
            empresaCollection = find_Tiilc_empresaLocalHome_findAllEmpresa();	
            empresaIterator = empresaCollection.iterator();
            while (empresaIterator.hasNext()){
                Tiilc_empresaLocal empresaLocal = (Tiilc_empresaLocal)empresaIterator.next();
                Empresa empresa=new Empresa();
                empresa.setCod_empresa(empresaLocal.getCod_empresa());
                empresa.setDes_empresa(empresaLocal.getDes_empresa());
                listaEmpresa.add(empresa);
            }
        } catch (Exception e) {
            System.err.println("Error al traer data de la tabla Empresa");
        }
		return listaEmpresa;
    }
    protected Collection find_Tiilc_empresaLocalHome_findAllEmpresa() {
        Tiilc_empresaLocalHome aTiilc_empresaLocalHome = (Tiilc_empresaLocalHome) ServiceLocatorManager
                .getLocalHome(STATIC_Tiilc_empresaLocalHome_REF_NAME,
                        STATIC_Tiilc_empresaLocalHome_CLASS);
        try {
            if (aTiilc_empresaLocalHome != null)
                return aTiilc_empresaLocalHome.findAllEmpresa();
        } catch (javax.ejb.FinderException fe) {
            fe.printStackTrace();
        }
        return null;
    }
    public Empresa findEmpresaxCodigo(String cod_empresa) throws FinderException{
        Empresa empresa=new Empresa();
        InitialContext contexto;
        Tiilc_empresaLocalHome empresaLocalHome;
        Tiilc_empresaLocal empresaLocal;
        Object obj = null;
        try {
            contexto = new InitialContext(System.getProperties());
            obj = (Object) contexto.lookup(Constantes.EJB_EMPRESA);
            empresaLocalHome = (Tiilc_empresaLocalHome)javax.rmi.PortableRemoteObject.narrow(obj,Tiilc_empresaLocalHome.class);
            empresaLocal = empresaLocalHome.findEmpresaxCodigo(cod_empresa);
            if(empresaLocal!=null){
                empresa.setCod_empresa(empresaLocal.getCod_empresa());
                empresa.setDes_empresa(empresaLocal.getDes_empresa());
            }
            
        }catch (NamingException e){
			e.printStackTrace();
			System.err
					.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
        }
        return empresa;
    }
}
