package com.grupobbva.bc.per.tel.iilc.session;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;

import com.ibm.etools.service.locator.ServiceLocatorManager;
/**
 * Bean implementation class for Enterprise Bean: SessionCliente
 */
public class SessionClienteBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiilc_clienteLocalHome_REF_NAME = "ejb/Tiilc_cliente";
	private final static Class STATIC_Tiilc_clienteLocalHome_CLASS = Tiilc_clienteLocalHome.class;
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

	public Cliente findCliente(int cod_cliente) throws FinderException {
		Cliente cliente = new Cliente();
		InitialContext contexto;
		Tiilc_clienteLocalHome clienteLocalHome = null;
		Tiilc_clienteLocal clienteLocal = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_CLIENTE);
			clienteLocalHome = (Tiilc_clienteLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_clienteLocalHome.class);

			clienteLocal = clienteLocalHome
					.findByPrimaryKey(new Tiilc_clienteKey(new BigDecimal(
							cod_cliente)));

			if (clienteLocal != null) {
				cliente.setCod_territorio(clienteLocal.getCod_territorio());
				cliente.setCod_oficina(clienteLocal.getCod_oficina());
				cliente.setCod_gestor(clienteLocal.getCod_gestor());
				cliente.setNro_documento(clienteLocal.getNro_documento());
				cliente.setNombre(clienteLocal.getNombre());
				cliente.setCodigo(clienteLocal.getCodigo());
				cliente.setSegment1(clienteLocal.getSegment1());
				cliente.setEdad(clienteLocal.getEdad().intValue());
				cliente.setEstcivil(clienteLocal.getEstcivil());
				cliente.setPerfil(clienteLocal.getPerfil());
				cliente.setDirec1(clienteLocal.getDirec1());
				cliente.setCalle(clienteLocal.getCalle());
				cliente.setNro(clienteLocal.getNro());
				cliente.setDistrito(clienteLocal.getDistrito());
				cliente.setProvincia(clienteLocal.getProvincia());
				cliente.setDepartamento(clienteLocal.getDepartamento());
				cliente.setTipo_persona(clienteLocal.getTipo_persona());
				cliente.setClasificacion(clienteLocal.getClasificacion());
				cliente.setTelefono(clienteLocal.getTelefono());
				cliente.setVinculacion(clienteLocal.getVinculacion());
				//cliente.setPrefijo(clienteLocal.getPrefijo());

				cliente.setPper(clienteLocal.getPper().intValue());
				cliente.setPcom(clienteLocal.getPcom().intValue());
				cliente.setVnac(clienteLocal.getVnac().intValue());
				cliente.setCcte(clienteLocal.getCcte().intValue());
				cliente.setColb(clienteLocal.getColb().intValue());
				cliente.setCnet(clienteLocal.getCnet().toString());
				cliente.setPaut(clienteLocal.getPaut().intValue());
				cliente.setDsct(clienteLocal.getDsct().intValue());
				cliente.setVarc(clienteLocal.getVarc().intValue());
				cliente.setCemp(clienteLocal.getCemp().toString());
				cliente.setCext(clienteLocal.getCext().intValue());
				cliente.setPhip(clienteLocal.getPhip().intValue());
				cliente.setLeas(clienteLocal.getLeas().intValue());
				cliente.setVcla(clienteLocal.getVcla().intValue());
				cliente.setCvip(clienteLocal.getCvip().intValue());
				cliente.setLinco(clienteLocal.getLinco().toString());
				cliente.setPmiv(clienteLocal.getPmiv().intValue());
				cliente.setCloc(clienteLocal.getCloc().intValue());
				cliente.setVrep(clienteLocal.getVrep().intValue());
				cliente.setAhsd(clienteLocal.getAhsd().intValue());
				cliente.setSonc(clienteLocal.getSonc().intValue());
				cliente.setB24(clienteLocal.getB24().toString());
				cliente.setCpte(clienteLocal.getCpte().intValue());
				cliente.setPref(clienteLocal.getPref().intValue());
				cliente.setVoro(clienteLocal.getVoro().intValue());
				cliente.setAhor(clienteLocal.getAhor().intValue());
				cliente.setSpro(clienteLocal.getSpro().intValue());
				cliente.setPos(clienteLocal.getPos().toString());
				cliente.setPmas(clienteLocal.getPmas().intValue());
				cliente.setLcta(clienteLocal.getLcta().intValue());
				cliente.setVpla(clienteLocal.getVpla().intValue());
				cliente.setPlzo(clienteLocal.getPlzo().intValue());
				cliente.setPserv(clienteLocal.getPserv().intValue());
				cliente.setProm(clienteLocal.getProm().intValue());
				cliente.setSvid(clienteLocal.getSvid().intValue());
				cliente.setVemp(clienteLocal.getVemp().intValue());
				cliente.setSdep(clienteLocal.getSdep().intValue());
				cliente.setPh(clienteLocal.getPh().intValue());
				cliente.setFcex(clienteLocal.getFcex().intValue());
				cliente.setVctr(clienteLocal.getVctr().intValue());
				cliente.setFmut(clienteLocal.getFmut().intValue());
				cliente.setEmph(clienteLocal.getEmph().intValue());
				cliente.setAval(clienteLocal.getAval().intValue());
				cliente.setMcla(clienteLocal.getMcla().intValue());
				cliente.setCts(clienteLocal.getCts().intValue());
				cliente.setTdeb(clienteLocal.getTdeb().intValue());
				cliente.setMoro(clienteLocal.getMoro().intValue());
				cliente.setCtsd(clienteLocal.getCtsd().intValue());
				cliente.setTvip(clienteLocal.getTvip().intValue());

				cliente.setTco(clienteLocal.getTco().intValue());
				cliente.setT_act2(clienteLocal.getT_act2().intValue());
				cliente.setT_act3(clienteLocal.getT_act3().intValue());
				cliente.setT_act4(clienteLocal.getT_act4().intValue());
				cliente.setT_act5(clienteLocal.getT_act5().intValue());
				cliente.setT_act6(clienteLocal.getT_act6().intValue());
				cliente.setTpr(clienteLocal.getTpr().intValue());

				cliente.setT_act_ct2(clienteLocal.getT_act_ct2().intValue());
				cliente.setT_act_ct3(clienteLocal.getT_act_ct3().intValue());
				cliente.setT_act_ct4(clienteLocal.getT_act_ct4().intValue());
				cliente.setT_act_ct5(clienteLocal.getT_act_ct5().intValue());
				cliente.setT_act_ct6(clienteLocal.getT_act_ct6().toString());

				cliente.setMargeno(clienteLocal.getMargeno().intValue());
				cliente.setBcorie(clienteLocal.getBcorie().intValue());
				cliente.setBcorid(clienteLocal.getBcorid().intValue());
				cliente.setBcorii(clienteLocal.getBcorii().intValue());
				cliente.setBcopas(clienteLocal.getBcopas().intValue());
				cliente.setBcovol(clienteLocal.getBcovol().intValue());
				cliente.setPorcrie(clienteLocal.getPorcrie().intValue());
				cliente.setPorcrid(clienteLocal.getPorcrid().intValue());
				cliente.setPorcrii(clienteLocal.getPorcrii().intValue());

				cliente.setSbsrie(clienteLocal.getSbsrie().intValue());
				cliente.setSbsrid(clienteLocal.getSbsrid().intValue());
				cliente.setSbsrii(clienteLocal.getSbsrii().intValue());
				cliente.setSbsjud(clienteLocal.getSbsjud().intValue());
				
				/**
				 * P020795-INI Maria Paula Tomaylla 16/04/2008
				 */
				cliente.setNro_documento(clienteLocal.getNro_documento());
				cliente.setCod_empresa(clienteLocal.getCod_empresa());
				cliente.setDes_empresa(clienteLocal.getDes_empresa());
				/**
				 * P020795-FIN
				 */
			}

		} catch (NamingException e) {
			e.printStackTrace();
			System.err
					.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
		} catch (FinderException e) {
			System.err.println("El cliente " + cod_cliente
					+ " no se encuentra: " + e.getMessage());
		}

		return cliente;

	}

	public boolean deleteCliente(int cod_cliente) {
		boolean respuesta = false;
		Tiilc_clienteLocal aTiilc_clienteLocal = find_Tiilc_clienteLocalHome_findByPrimaryKey(new Tiilc_clienteKey(
				new BigDecimal(cod_cliente)));
		if (aTiilc_clienteLocal != null) {
			try {
				aTiilc_clienteLocal.remove();
				respuesta = true;
			} catch (EJBException e) {
				System.err.println("El cliente " + cod_cliente
						+ " no se puede eliminar: " + e.getMessage());
			} catch (RemoveException e) {
				System.err.println("El cliente " + cod_cliente
						+ " no se puede eliminar: " + e.getMessage());

			}
		}
		return respuesta;
	}
	
	public int countCliente(){
		int res = 0;
		Connection con = null;
		DataSource datasource = null;
		CallableStatement stmt = null;
		String sql = "begin ? := COUNT_CLIENTE(); end;";
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return 0;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
	
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return 0;
			}
			
			try {
				stmt = con.prepareCall(sql);
				stmt.registerOutParameter(1, OracleTypes.NUMBER);
				stmt.execute();
				res = stmt.getInt(1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return res;

	}
	
    public int countClientebyTerritorio(String cod_territorio){
		int res = 0;
		Connection con = null;
		DataSource datasource = null;
		CallableStatement stmt = null;
		String sql = "begin ? := COUNT_CLIENTE_BY_TERRITORIO(?); end;";
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return 0;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
	
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return 0;
			}
			
			try {
				stmt = con.prepareCall(sql);
				stmt.registerOutParameter(1, OracleTypes.NUMBER);
				stmt.setString(2, cod_territorio);
				stmt.execute();
				res = stmt.getInt(1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return res;

	}
    
    public int countClientebyOficina(String cod_territorio, String cod_oficina){
		int res = 0;
		Connection con = null;
		DataSource datasource = null;
		CallableStatement stmt = null;
		String sql = "begin ? := COUNT_CLIENTE_BY_OFICINA(?,?); end;";
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return 0;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
	
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return 0;
			}
			
			try {
				stmt = con.prepareCall(sql);
				stmt.registerOutParameter(1, OracleTypes.NUMBER);
				stmt.setString(2, cod_territorio);
				stmt.setString(3, cod_oficina);
				stmt.execute();
				res = stmt.getInt(1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return res;

	}
    
	public int countClientebyGestor(String cod_territorio, String cod_oficina, String cod_gestor) {
		int res = 0;
		Connection con = null;
		DataSource datasource = null;
		CallableStatement stmt = null;
		String sql = "begin ? := COUNT_CLIENTE_BY_GESTOR(?,?,?); end;";
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return 0;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
	
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return 0;
			}
			
			try {
				stmt = con.prepareCall(sql);
				stmt.registerOutParameter(1, OracleTypes.NUMBER);
				stmt.setString(2, cod_territorio);
				stmt.setString(3, cod_oficina);
				stmt.setString(4, cod_gestor);
				stmt.execute();
				res = stmt.getInt(1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return res;

	}
	
	protected Tiilc_clienteLocal find_Tiilc_clienteLocalHome_findByPrimaryKey(
			Tiilc_clienteKey primaryKey) {
		Tiilc_clienteLocalHome aTiilc_clienteLocalHome = (Tiilc_clienteLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_clienteLocalHome_REF_NAME,
						STATIC_Tiilc_clienteLocalHome_CLASS);
		try {
			if (aTiilc_clienteLocalHome != null)
				return aTiilc_clienteLocalHome.findByPrimaryKey(primaryKey);
		} catch (javax.ejb.FinderException fe) {
			System.err.println("El cliente no se encontro " + primaryKey.cod_cliente);
					
		}
		return null;
	}
}
