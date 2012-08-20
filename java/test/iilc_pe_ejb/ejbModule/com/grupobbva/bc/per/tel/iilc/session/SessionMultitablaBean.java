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
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.ibm.etools.service.locator.ServiceLocatorManager;
import com.stefanini.pe.framework.collections.DataColumn;
import com.stefanini.pe.framework.collections.DataRow;
import com.stefanini.pe.framework.collections.DataTable;


/**
 * Bean implementation class for Enterprise Bean: SessionMultitabla
 */
public class SessionMultitablaBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiilc_multitablaLocalHome_REF_NAME = "ejb/Tiilc_multitabla";
	private final static Class STATIC_Tiilc_multitablaLocalHome_CLASS = Tiilc_multitablaLocalHome.class;
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

	public Vector findAllRecord(String cod_mult) throws FinderException {
		Vector records = new Vector();
		InitialContext contexto;
		Tiilc_multitablaLocalHome multitablaLocalHome = null;
		Iterator multitablasIterator = null;
		Collection multitablasCollection = null;
		Object obj = null;
		try {
			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_MULTITABLA);
			multitablaLocalHome = (Tiilc_multitablaLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_multitablaLocalHome.class);
			multitablasCollection = multitablaLocalHome.findAllRecord(cod_mult);
			multitablasIterator = multitablasCollection.iterator();

			while (multitablasIterator.hasNext()) {
				Tiilc_multitablaLocal multitablaLocal = (Tiilc_multitablaLocal) multitablasIterator.next();
				if (!(multitablaLocal.getCod_ele().equals("0"))) {
					Multitabla multitabla = new Multitabla();
					multitabla.setCod_mult(multitablaLocal.getCod_mult());
					multitabla.setCod_ele(multitablaLocal.getCod_ele());
					multitabla.setValor1(multitablaLocal.getValor1());
					multitabla.setValor2(multitablaLocal.getValor2());
					multitabla.setValor3(multitablaLocal.getValor3());
					multitabla.setValor4(multitablaLocal.getValor4());
					records.add(multitabla);
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err
					.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
		}

		return records;

	}

	public Multitabla findRecord(String codigo) throws FinderException {
		Multitabla multitabla = new Multitabla();
		InitialContext contexto;
		Tiilc_multitablaLocalHome multitablaLocalHome = null;
		Tiilc_multitablaLocal multitablaLocal = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_MULTITABLA);
			multitablaLocalHome = (Tiilc_multitablaLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_multitablaLocalHome.class);
			multitablaLocal = multitablaLocalHome.findRecord(codigo);

			if (multitablaLocal != null) {
				multitabla.setCod_mult(multitablaLocal.getCod_mult());
				multitabla.setCod_ele(multitablaLocal.getCod_ele());
				multitabla.setValor1(multitablaLocal.getValor1());
				multitabla.setValor2(multitablaLocal.getValor2());
				multitabla.setValor3(multitablaLocal.getValor3());
				multitabla.setValor4(multitablaLocal.getValor4());
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err
					.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
		}

		return multitabla;

	}

	public Vector findMultitablaxValor2(String valor2) throws FinderException {
		Vector records = new Vector();
		InitialContext contexto;
		Tiilc_multitablaLocalHome multitablaLocalHome = null;
		Iterator multitablasIterator = null;
		Collection multitablasCollection = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_MULTITABLA);
			multitablaLocalHome = (Tiilc_multitablaLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_multitablaLocalHome.class);

			multitablasCollection = multitablaLocalHome
					.findMultitablaxValor2(valor2);
			multitablasIterator = multitablasCollection.iterator();

			while (multitablasIterator.hasNext()) {
				Tiilc_multitablaLocal multitablaLocal = (Tiilc_multitablaLocal) multitablasIterator
						.next();
				Multitabla multitabla = new Multitabla();
				multitabla.setCod_mult(multitablaLocal.getCod_mult());
				multitabla.setCod_ele(multitablaLocal.getCod_ele());
				multitabla.setValor1(multitablaLocal.getValor1());
				multitabla.setValor2(multitablaLocal.getValor2());
				multitabla.setValor3(multitablaLocal.getValor3());
				multitabla.setValor4(multitablaLocal.getValor4());
				records.add(multitabla);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err
					.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
		}

		return records;
	}

	public Vector findAllMultitabla() throws FinderException {
		Vector records = new Vector();
		InitialContext contexto;
		Tiilc_multitablaLocalHome multitablaLocalHome = null;
		Iterator multitablasIterator = null;
		Collection multitablasCollection = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_MULTITABLA);
			multitablaLocalHome = (Tiilc_multitablaLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_multitablaLocalHome.class);

			multitablasCollection = multitablaLocalHome.findAllMultitabla();
			multitablasIterator = multitablasCollection.iterator();

			while (multitablasIterator.hasNext()) {
				Tiilc_multitablaLocal multitablaLocal = (Tiilc_multitablaLocal) multitablasIterator
						.next();
				Multitabla multitabla = new Multitabla();
				multitabla.setCod_mult(multitablaLocal.getCod_mult());
				multitabla.setCod_ele(multitablaLocal.getCod_ele());
				multitabla.setValor1(multitablaLocal.getValor1());
				multitabla.setValor2(multitablaLocal.getValor2());
				multitabla.setValor3(multitablaLocal.getValor3());
				multitabla.setValor4(multitablaLocal.getValor4());
				records.add(multitabla);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err
					.println("Error al probar ejb de entidad: Naming Exception"
							+ e.getMessage());
		}

		return records;
	}

	public Multitabla findMultitabla(String cod_mult, String cod_ele){
		Multitabla multitabla = new Multitabla();

		try {
			Tiilc_multitablaLocal aTiilc_multitablaLocal = find_Tiilc_multitablaLocalHome_findMultitabla(
					cod_mult, cod_ele);
					
			if (aTiilc_multitablaLocal!=null){
				multitabla.setCod_mult(aTiilc_multitablaLocal.getCod_mult());
				multitabla.setCod_ele(aTiilc_multitablaLocal.getCod_ele());
				multitabla.setValor1(aTiilc_multitablaLocal.getValor1());
				multitabla.setValor2(aTiilc_multitablaLocal.getValor2());
				multitabla.setValor3(aTiilc_multitablaLocal.getValor3());
				multitabla.setValor4(aTiilc_multitablaLocal.getValor4());
			}
		} catch (Exception e) {
			System.err.println("Error al extraer data en Multitabla " + e.getMessage());
		}

		return multitabla;

	}
	
	public boolean updateMultitabla(Multitabla multitabla){

		try {
			Tiilc_multitablaLocal aTiilc_multitablaLocal = find_Tiilc_multitablaLocalHome_findMultitabla(
					multitabla.getCod_mult(), multitabla.getCod_ele());
					
			if (aTiilc_multitablaLocal!=null){
				aTiilc_multitablaLocal.setValor1(multitabla.getValor1());
				aTiilc_multitablaLocal.setValor2(multitabla.getValor2());
				aTiilc_multitablaLocal.setValor3(multitabla.getValor3());
				aTiilc_multitablaLocal.setValor4(multitabla.getValor4());
				return true;
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar data en Multitabla " + e.getMessage());
		}
		return false;
	}
	
	public boolean deleteMultitabla(String cod_mult, String cod_ele){

		try {
			Tiilc_multitablaLocal aTiilc_multitablaLocal = find_Tiilc_multitablaLocalHome_findMultitabla(
					cod_mult, cod_ele);
					
			if (aTiilc_multitablaLocal!=null){
				aTiilc_multitablaLocal.remove();
				return true;
			}
		} catch (Exception e) {
			System.err.println("Error al eliminar data en Multitabla " + e.getMessage());
		}
		return false;
	}
	
	public Vector<Multitabla> listaDetalleFiltroComplejo(String tipo, String tipo2, String[] codigos){
		Vector<Multitabla> res = null;
		Multitabla bean = null;
		
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
			
			String listaCodigos = "";
			for(int i=0; i<codigos.length; i++){
				if(!listaCodigos.equals("")) listaCodigos+=",";
				listaCodigos+="'" + codigos[i] + "'";
			}
			
			try {
				String sql = "select a.cod_ele, a.valor1 as nombre, b.valor1 as descripcion from iilc.tiilc_multitabla a, tiilc_multitabla b " +
							"where a.cod_mult = '" + tipo + "' and b.cod_mult = '" + tipo2 + "' and " +
							"a.cod_ele = b.valor2 and " +
							"a.cod_ele in (" + listaCodigos + ") " +
							"order by 1,3";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Multitabla();
					bean.setValor1(rst.getString("nombre"));
					bean.setValor2(rst.getString("descripcion"));
					res.add(bean);					
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
	
	public Vector listaDetalleFiltroSimple(String tipo, String[] codigos){
		Vector res = null;
		Multitabla bean = null;
		
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
			
			String listaCodigos = "";
			for(int i=0; i<codigos.length; i++){
				if(!listaCodigos.equals("")) listaCodigos+=",";
				listaCodigos+="'" + codigos[i] + "'";
			}
			
			try {
				String sql = "select cod_ele, valor1 from iilc.tiilc_multitabla " +
							"where cod_mult = '" + tipo + "' and " +
							"cod_ele in (" + listaCodigos + ") " +
							"order by 1";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Multitabla();
					bean.setValor1(rst.getString("valor1"));
					res.add(bean);					
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
	
	protected Tiilc_multitablaLocal find_Tiilc_multitablaLocalHome_findMultitabla(
			String cod_mult, String cod_ele) {
		Tiilc_multitablaLocalHome aTiilc_multitablaLocalHome = (Tiilc_multitablaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_multitablaLocalHome_REF_NAME,
						STATIC_Tiilc_multitablaLocalHome_CLASS);
		try {
			if (aTiilc_multitablaLocalHome != null)
				return aTiilc_multitablaLocalHome.findMultitabla(cod_mult,
						cod_ele);
		} catch (javax.ejb.FinderException fe) {
			System.err.println("Tabla: Multitabla - No se encontro el registro con c" + (char) 243 + "digo mult" + cod_mult + " c" + (char) 243 + "digo elemento " + cod_ele );
		}
		return null;
	}
	
//	OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS
	public DataTable findEtiquetasSegmentos(DataTable tablaBase) {

		Vector res = null;
		Multitabla bean = null;
		DataTable tablaBase2 = new DataTable();
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

				int contadorColumna = 0;
				int limite = 0;				
				int fila = 1;
				String varTemp = "";
				int totalDias=0;
				int dias=0;
				String sql ="";
				String numSegmento="";				
				
					if (tablaBase.getColumnas().count() > 0) {
						
						
						for(Iterator it = tablaBase.getColumnas().iterator(); it.hasNext();)
						{
							DataColumn column = (DataColumn)it.next();
							tablaBase2.getColumnas().add(column.getColumnName());
						}
						
						for (Iterator it = tablaBase.getColumnas().iterator(); it.hasNext();) {	
							
														
							DataColumn column = (DataColumn) it.next();
						/*	for (Iterator jt = tablaBase.getFilas().iterator(); jt.hasNext();) {
							DataRow row = (DataRow) jt.next();*/
							sql =
							"select e.valor1 as etiquetas, s.valor1 as segmentos from " +
							"(select cod_mult, cod_ele, valor1, valor2 from iilc.tiilc_multitabla where cod_mult='T05') s, " +
							"(select cod_mult, cod_ele, valor1, valor2 from iilc.tiilc_multitabla where cod_mult='T04' " +
							"and cod_ele<>0 order by valor1 asc) e " +
							"where e.cod_ele=s.valor2 " +
							"and e.valor1 = '"+column.getColumnName()+"'";
										
							ResultSet rst = s.executeQuery(sql);
							int cont=0;
							while (rst.next()) {								
								if(contadorColumna==0){
										DataRow row= tablaBase2.NewRow();
										row.set(column.getColumnName(),rst.getString("segmentos"));
										tablaBase2.getFilas().add(row);
								}else
								{
									if(cont<tablaBase2.getFilas().count())
									{	DataRow row= tablaBase2.getFilas().get(cont);										
										 row.set(column.getColumnName(),rst.getString("segmentos"));
										 cont++;
									}else
									{
										DataRow row= tablaBase2.NewRow();
										row.set(column.getColumnName(),rst.getString("segmentos"));
										tablaBase2.getFilas().add(row);	
										cont++;
									}
								}
									
							}
							contadorColumna++;
							//}
						}					
					}
			s.close();
			con.close();
			initialContext.close();
			
			}	catch (SQLException e1) {
				e1.printStackTrace();
				}
			}	catch (Exception e) {
				e.printStackTrace();
				}
		return tablaBase2;
	}
	
	public String[] listaEtiquetasPorCodigo(String codigo) {
		Vector vRes = null;
		String res[] = new String[0];
		Multitabla bean = null;
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

			int contadorColumna = 0;
			int limite = 0;				
			int fila = 1;
			String varTemp = "";
			int totalDias=0;
			int dias=0;
			String sql ="";
			String numSegmento="";				
			
			sql =
			"select valor1 from iilc.tiilc_multitabla where " +
			"cod_mult = 'T05' and valor2 = '" + codigo + "' order by 1";						
			ResultSet rst = s.executeQuery(sql);
			while (rst.next()) {
				if(vRes==null) vRes = new Vector(0,1);
				vRes.add(rst.getString("valor1"));
			}
			
			if(vRes!=null){
				res = new String[vRes.size()];
				for(int i=0; i<vRes.size(); i++){
					res[i] = (String)vRes.elementAt(i);
				}
			}
			
		}catch (SQLException e1) {
			e1.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	//FIN - OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS
//	OSCAR CORTEZ - ETIQUETAS
	public Vector findEtiquetas() {

		Vector res = null;
		Multitabla bean = null;

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
				"select cod_ele, valor1 as etiquetas from iilc.tiilc_multitabla where cod_mult='T04' and cod_ele<>0 order by 1";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Multitabla();
					/*if(i==0){
						etiqueta=rst.getString("etiquetas");
					}						
					if(!etiqueta.equals(rst.getString("etiquetas"))){
						bean.setValor1(rst.getString("etiquetas"));
						res.add(bean);
					}else{
						bean.setValor2(rst.getString("segmentos"));	
					}*/
					bean.setValor1(rst.getString("etiquetas"));					
					res.add(bean);
					
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

	//FIN - OSCAR CORTEZ - ETIQUETAS
	
	public int findCantidadSegmentos() {

		int res = 0;
		Multitabla bean = null;

		try {
			Connection con = null;
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return 0;
			}

			DataSource datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return 0;
			}

			Statement s = con.createStatement();
			String etiqueta="";
			int i=0;
			try {
				String sql =
				"select count(s.valor1) as cantidad from (select cod_mult, cod_ele, valor1, valor2 from iilc.tiilc_multitabla where cod_mult='T05') s, (select cod_mult, cod_ele, valor1, valor2 from tiilc_multitabla where cod_mult='T04' and cod_ele<>0 order by valor1 asc) e where e.cod_ele=s.valor2 group by e.valor1 order by cantidad desc ";

				ResultSet rst = s.executeQuery(sql);
				
				while (rst.next()) {
					if(i==0){
					res= rst.getInt("cantidad");
					i=1;
					}
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
//	OSCAR CORTEZ - ETIQUETAS CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findEtiSeg(String codMult, String codElem) {
		

		Vector res = null;
		Multitabla bean = null;

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
				"select a.valor1 as etiqueta, b.valor1 as segmento from " +
				"(select cod_mult, cod_ele, valor1, valor2, valor3, valor4 from iilc.tiilc_multitabla where cod_mult='"+codMult+"' " +
				"and cod_ele<>0 and cod_ele='"+codElem+"')a, " +
				"(select cod_mult, cod_ele, valor1, valor2, valor3, valor4 from  iilc.tiilc_multitabla where cod_mult='T05' and cod_ele<>0)b  " +
				"where a.cod_ele=b.valor2";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Multitabla();

					bean.setValor1(rst.getString("etiqueta"));
					bean.setValor2(rst.getString("segmento"));
					res.add(bean);					
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

	//FIN - OSCAR CORTEZ - ETIQUETAS CON SEGMENTOS X CODMULT Y CODELEM
	
//	OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findNV(String codMult, String codElem) {

		Vector res = null;
		Multitabla bean = null;

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
				"select a.valor1 as vinculo, b.valor1 as descripcion from " +
				"(select cod_mult, cod_ele, valor1, valor2, valor3, valor4 from iilc.tiilc_multitabla where " +
				"cod_mult='"+codMult+"' and cod_ele<>0 and cod_ele='"+codElem+"')a, " +
				"(select cod_mult, cod_ele, valor1, valor2, valor3, valor4 from iilc.tiilc_multitabla where cod_mult='T08' and cod_ele<>0) b " +
				"where a.cod_ele=b.valor2";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Multitabla();

					bean.setValor1(rst.getString("vinculo"));
					bean.setValor2(rst.getString("descripcion"));
					res.add(bean);					
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

	//FIN - OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM
	
//	OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findFamilias() {

		Vector res = null;
		Multitabla bean = null;

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
				"select cod_mult, cod_ele, valor1, valor2, valor3, valor4 from " +
				" iilc.tiilc_multitabla where cod_mult='T09' and cod_ele<>0";

				ResultSet rst = s.executeQuery(sql);
				int i=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Multitabla();

					bean.setValor1(rst.getString("valor1"));
					bean.setValor2(rst.getString("valor2"));
					res.add(bean);					
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

	//FIN - OSCAR CORTEZ - ETIQUETAS
}