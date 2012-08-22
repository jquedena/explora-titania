package com.grupobbva.bc.per.tel.iilc.session;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocalHome;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Area;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;
import com.ibm.etools.service.locator.ServiceLocatorManager;
/**
 * Bean implementation class for Enterprise Bean: SessionCarga
 */
public class SessionCargaBean implements javax.ejb.SessionBean {
    private javax.ejb.SessionContext mySessionCtx;

    private final static String STATIC_Tiilc_clienteLocalHome_REF_NAME = "ejb/Tiilc_cliente";

    private final static Class STATIC_Tiilc_clienteLocalHome_CLASS = Tiilc_clienteLocalHome.class;

    private final static String STATIC_Tiilc_totalLocalHome_REF_NAME = "ejb/Tiilc_total";

    private final static Class STATIC_Tiilc_totalLocalHome_CLASS = Tiilc_totalLocalHome.class;

    private final static String STATIC_Tiilc_areaLocalHome_REF_NAME = "ejb/Tiilc_area";

    private final static Class STATIC_Tiilc_areaLocalHome_CLASS = Tiilc_areaLocalHome.class;

    private final static String STATIC_Tiilc_territorioLocalHome_REF_NAME = "ejb/Tiilc_territorio";

    private final static Class STATIC_Tiilc_territorioLocalHome_CLASS = Tiilc_territorioLocalHome.class;

    private final static String STATIC_Tiilc_oficinaLocalHome_REF_NAME = "ejb/Tiilc_oficina";

    private final static Class STATIC_Tiilc_oficinaLocalHome_CLASS = Tiilc_oficinaLocalHome.class;

    private final static String STATIC_Tiilc_gestorLocalHome_REF_NAME = "ejb/Tiilc_gestor";

    private final static Class STATIC_Tiilc_gestorLocalHome_CLASS = Tiilc_gestorLocalHome.class;

    private final static String STATIC_Tiilc_multitablaLocalHome_REF_NAME = "ejb/Tiilc_multitabla";

    private final static Class STATIC_Tiilc_multitablaLocalHome_CLASS = Tiilc_multitablaLocalHome.class;

    private final static String STATIC_Tiilc_perfilLocalHome_REF_NAME = "ejb/Tiilc_perfil";

    private final static Class STATIC_Tiilc_perfilLocalHome_CLASS = Tiilc_perfilLocalHome.class;

    private final static String STATIC_Tiilc_permiso_perfilLocalHome_REF_NAME = "ejb/Tiilc_permiso_perfil";

    private final static Class STATIC_Tiilc_permiso_perfilLocalHome_CLASS = Tiilc_permiso_perfilLocalHome.class;

    private int registros_leidos;

    private int clientes_insertados;

    private int totales_insertados;

    private boolean condicion;

    private Cliente cliente;

    private Total total;

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
    
    public boolean deleteClientes(){
		boolean respuesta = false;
		Connection con = null;
		DataSource datasource = null;
		Statement s = null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return false;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
	
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return false;
			}
	
			try {
				boolean updRes = false;
				//while (updRes!=0){
					s = con.createStatement();
					//updRes = s.executeUpdate("DELETE FROM IILC.TIILC_CLIENTE WHERE ROWNUM <= 5000");
					updRes = s.execute("TRUNCATE TABLE IILC.TIILC_CLIENTE");

					s.close();
				//}
				respuesta = updRes;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				s.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return respuesta;

	}
    
    public boolean deleteTotales(){
    	return deleteTable("tiilc_total");
    }
    
    public boolean deleteGestores(){
    	return deleteTable("tiilc_gestor");
    }
    
    public boolean deleteOficinas(){
    	return deleteTable("tiilc_oficina");
    }
	
	public boolean deleteTerritorios(){
    	return deleteTable("tiilc_territorio");
    }
	
	public boolean deleteAreas(){
    	return deleteTable("tiilc_area");
    }
	
	public boolean deleteEmpresas(){
    	return deleteTable("tiilc_empresa");
    }
	
	private boolean deleteTable(String nombre){
    	boolean respuesta = false;
		Connection con = null;
		DataSource datasource = null;
		Statement s = null;
    	try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return false;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return false;
			}

			s = con.createStatement();
			try {
				s.executeUpdate("delete from " + nombre);
				respuesta = true;
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				s.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return respuesta;
    }

    public boolean createCliente(Cliente cliente) {
    	boolean respuesta = false;
		/*Connection con = null;
		DataSource datasource = null;
		CallableStatement stmt = null;
    	try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return false;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return false;
			}

			String query = "begin ? := 	CREATE_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
							"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
							"); end;";
			//Statement s = con.createStatement();
			try {
				stmt = con.prepareCall(query);
				stmt.registerOutParameter(1, OracleTypes.VARCHAR);                                           
				stmt.setInt		(2, cliente.getCod_cliente());
				stmt.setString	(3, cliente.getCod_territorio());    
				stmt.setString	(4, cliente.getCod_oficina());
				stmt.setString	(5, cliente.getCod_gestor());     
				stmt.setString(6, cliente.getNro_documento());
				stmt.setString(7, cliente.getNombre());       
				stmt.setString(8, cliente.getCodigo());
				stmt.setString(9, cliente.getSegment1());            
				stmt.setInt(10, cliente.getEdad());
				stmt.setString(11, cliente.getEstcivil());               
				stmt.setString(12, cliente.getPerfil());
				stmt.setString(13, cliente.getDirec1());            
				stmt.setString(14, cliente.getCalle());
				stmt.setString(15, cliente.getNro());                
				stmt.setString(16, cliente.getDistrito());
				stmt.setString(17, cliente.getProvincia());       
				stmt.setString(18, cliente.getDepartamento());
				stmt.setString(19, cliente.getTipo_persona());
				stmt.setString(20, cliente.getClasificacion());
				
				stmt.setString(21, cliente.getTelefono());
				stmt.setString(22, cliente.getCod_empresa());
				stmt.setString(23, cliente.getDes_empresa());
				
				stmt.setString(24, cliente.getVinculacion());
				stmt.setLong(25, cliente.getPper());           
				stmt.setLong(26, cliente.getPcom());
				stmt.setLong(27, cliente.getVnac());                    
				stmt.setLong(28, cliente.getCcte());
				stmt.setLong(29, cliente.getColb());                    
				stmt.setLong(30, cliente.getCnet());
				stmt.setLong(31, cliente.getPaut());                    
				stmt.setLong(32, cliente.getDsct());
				stmt.setLong(33, cliente.getVarc());                    
				stmt.setLong(34, cliente.getCemp());
				stmt.setLong(35, cliente.getCext());                    
				stmt.setLong(36, cliente.getPhip());
				stmt.setLong(37, cliente.getLeas());                    
				stmt.setLong(38, cliente.getVcla());
				stmt.setLong(39, cliente.getCvip());                    
				stmt.setLong(40, cliente.getLinco());
				stmt.setLong(41, cliente.getPmiv());                   
				stmt.setLong(42, cliente.getCloc());
				stmt.setLong(43, cliente.getVrep());                    
				stmt.setLong(44, cliente.getAhsd());
				stmt.setLong(45, cliente.getSonc());                    
				stmt.setLong(46, cliente.getB24());
				stmt.setLong(47, cliente.getCpte());                     
				stmt.setLong(48, cliente.getPref());
				stmt.setLong(49, cliente.getVoro());                    
				stmt.setLong(50, cliente.getAhor());
				stmt.setLong(51, cliente.getSpro());                    
				                                                                                             
				stmt.setLong(52, cliente.getPos());
				stmt.setLong(53, cliente.getPmas());     	               
				stmt.setLong(54, cliente.getLcta());
				stmt.setLong(55, cliente.getVpla());                    
				stmt.setLong(56, cliente.getPlzo());
				stmt.setLong(57, cliente.getPserv());                   
				stmt.setLong(58, cliente.getProm());
				stmt.setLong(59, cliente.getSvid());                    
				stmt.setLong(60, cliente.getVemp());
				stmt.setLong(61, cliente.getSdep());                    
				stmt.setLong(62, cliente.getPh());
				stmt.setLong(63, cliente.getFcex());                      
				stmt.setLong(64, cliente.getVctr());
				stmt.setLong(65, cliente.getFmut());                    
				stmt.setLong(66, cliente.getEmph());
				stmt.setLong(67, cliente.getAval());                    
				stmt.setLong(68, cliente.getMcla());
				stmt.setLong(69, cliente.getCts());                     
				stmt.setLong(70, cliente.getTdeb());
				stmt.setLong(71, cliente.getMoro());                    
				stmt.setLong(72, cliente.getCtsd());
				stmt.setLong(73, cliente.getTvip());                    
				stmt.setLong(74, cliente.getTco());
				stmt.setLong(75, cliente.getT_act2());                   
				stmt.setLong(76, cliente.getT_act3());
				stmt.setLong(77, cliente.getT_act4());                
				stmt.setLong(78, cliente.getT_act5());
				stmt.setLong(79, cliente.getT_act6());                
				stmt.setLong(80, cliente.getTpr());
				stmt.setLong(81, cliente.getT_act_ct2());                
				stmt.setLong(82, cliente.getT_act_ct3());
				stmt.setLong(83, cliente.getT_act_ct4());          
				stmt.setLong(84, cliente.getT_act_ct5());
				stmt.setLong(85, cliente.getT_act_ct6());          
				stmt.setLong(86, cliente.getMargeno());
				stmt.setLong(87, cliente.getBcorie());               
				stmt.setLong(88, cliente.getBcorid());
				stmt.setLong(89, cliente.getBcorii());                
				stmt.setLong(90, cliente.getBcopas());
				stmt.setLong(91, cliente.getBcovol());                
				stmt.setLong(92, cliente.getPorcrie());
				stmt.setLong(93, cliente.getPorcrid());              
				stmt.setLong(94, cliente.getPorcrii());
				stmt.setLong(95, cliente.getSbsrie());               
				stmt.setLong(96, cliente.getSbsrid());
				stmt.setLong(97, cliente.getSbsrii());                    
				stmt.setLong(98, cliente.getSbsjud());
				
				//campos ofertas
				stmt.setString(99, cliente.getIntervpas());
				stmt.setLong(100, cliente.getMofactv());
				stmt.setLong(101, cliente.getCs000lineamaxtc());
				stmt.setString(102, cliente.getMofpasv());
				stmt.setString(103, cliente.getMofserv());
				stmt.setString(104, cliente.getMofcanal());
				stmt.setString(105, cliente.getMphpasv());
				stmt.setLong(106, cliente.getCs000mtoprestamo());
				stmt.setLong(107, cliente.getMontovehicular());
				stmt.setLong(108, cliente.getMontohipotecario());
				stmt.setString(109, cliente.getCtacteoferta());
				stmt.setString(110, cliente.getCtaahoferta());
				stmt.setString(111, cliente.getCtapoferta());
				stmt.setString(112, cliente.getFmutuoofert());
				stmt.setString(113, cliente.getCtactsofert());
				stmt.setBigDecimal(114, cliente.getTconsactv());
				stmt.setLong(115, cliente.getMontosubrogados());
				stmt.setBigDecimal(116, cliente.getTsubactv());
				stmt.setBigDecimal(117, cliente.getThipotactv());
				stmt.setBigDecimal(118, cliente.getTvehicactv());
				stmt.setBigDecimal(119, cliente.getCs000montocta36());
				stmt.setBigDecimal(120, cliente.getTcuot36act());
				stmt.setBigDecimal(121, cliente.getCs000montocta48());
				stmt.setBigDecimal(122, cliente.getTcuot48act());
				stmt.setBigDecimal(123, cliente.getCs000montocta60());
				stmt.setBigDecimal(124, cliente.getTcuot60act());
				stmt.setBigDecimal(125, cliente.getCs000presmena5000());
				stmt.setBigDecimal(126, cliente.getCs000comisdesemen5000());
				stmt.setBigDecimal(127, cliente.getCs000pres5000a15000());
				stmt.setBigDecimal(128, cliente.getC5000comdes15000act());
				stmt.setBigDecimal(129, cliente.getCs000presmaya15000());
				stmt.setBigDecimal(130, cliente.getComdes15000ac());
				stmt.setLong(131, cliente.getCs000linminadqtc());
				stmt.setString(132, cliente.getCs000tipodecredito());
				stmt.setLong(133, cliente.getCs000mixmonprest());
				stmt.setLong(134, cliente.getCs000mixlinasistc());
				stmt.setString(135, cliente.getCs000mixtipotc());
				stmt.setBigDecimal(136, cliente.getCs000prestcmena5000());
				stmt.setBigDecimal(137, cliente.getCs000prestc500015000());
				stmt.setBigDecimal(138, cliente.getCs000prestcmaya15000());
				stmt.setString(139, cliente.getAtribctactepasv());
				stmt.setString(140, cliente.getAtribctaahpasv());
				stmt.setString(141, cliente.getAtribctaplazpasv());
				stmt.setString(142, cliente.getAtribctspasv());
				stmt.setString(143, cliente.getAtribfmutuopasv());
				stmt.setString(144, cliente.getCobofserv());
				stmt.setString(145, cliente.getSvidofserv());
				stmt.setString(146, cliente.getSoncofserv());
				stmt.setString(147, cliente.getSvincofserv());
				stmt.setString(148, cliente.getPhofserv());
				stmt.setString(149, cliente.getDebofserv());
				stmt.setString(150, cliente.getVipofserv());
				stmt.setString(151, cliente.getOfcnetcan());
				stmt.setString(152, cliente.getOfcempcan());
				stmt.setString(153, cliente.getOflincocan());
				stmt.setString(154, cliente.getOfb24can());
				stmt.setString(155, cliente.getOfposcan());
				
				stmt.execute();
				String resultado = stmt.getString(1);

				if (resultado.equalsIgnoreCase("true"))
					respuesta = true;
				else
					respuesta = false;
			} catch (SQLException e1) {
				System.out.println("Error de Acceso a Datos al crear Cliente "+cliente.getCod_cliente()+" " + e1.getMessage() );
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			System.out.println("Error de Acceso a Datos al crear Cliente");
		} finally {
			try {
				stmt.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}*/
		
		return respuesta;
    }

    public boolean createTotal(Total total) {

        try {

            Tiilc_totalLocal aTiilc_totalLocal = createTiilc_totalLocal(total);
            if(aTiilc_totalLocal!=null)
            	return true;
        } catch (Exception e) {
            System.err.println("Error SessionCarga: createTotal\n");
        }
        return false;
    }

    public boolean createArea(Area area) {

        try {

            Tiilc_areaLocal aTiilc_areaLocal = createTiilc_areaLocal(area
                    .getCod_area(), area.getDes_area());
            return true;
        } catch (Exception e) {
            System.err.println("Error SessionCarga: createArea\n"
                    + e.getMessage());
        }
        return false;
    }

    public boolean createTerritorio(Territorio territorio)
            throws javax.ejb.CreateException {

        try {

            Tiilc_territorioLocal aTiilc_territorioLocal = createTiilc_territorioLocal(
                    territorio.getCod_territorio(), territorio.getCod_area(),
                    territorio.getDes_territorio());
            return true;
        } catch (javax.ejb.CreateException e) {

        }
        return false;
    }

    public boolean createOficina(Oficina oficina) {

        try {

            Tiilc_oficinaLocal aTiilc_oficinaLocal = createTiilc_oficinaLocal(
                    oficina.getCod_oficina(), oficina.getCod_territorio(),
                    oficina.getCod_area(), oficina.getDes_oficina());
            return true;
        } catch (Exception e) {
            System.err.println("Error SessionCarga: createOficina\n"
                    + e.getMessage());
        }
        return false;
    }

    public boolean createGestor(Gestor gestor) {

        try {
            Collection aCollection = find_Tiilc_oficinaLocalHome_findAllOficinaxCod_oficina(gestor
                    .getCod_oficina());
            Tiilc_oficinaLocal oficinaLocal = (Tiilc_oficinaLocal) aCollection
                    .iterator().next();
            Tiilc_gestorLocal aTiilc_gestorLocal = createTiilc_gestorLocal(
                    gestor.getCod_gestor(), gestor.getCod_oficina(),
                    oficinaLocal.getTiilc_territorio_fk().getCod_territorio(),
                    oficinaLocal.getTiilc_territorio_fk().getTiilc_area_fk().getCod_area(), 
					gestor.getNom_gestor(), gestor.getReg_gestor(), gestor.getPerfil_gestor());
            return true;
        } catch (Exception e) {
            System.err.println("Error SessionCarga: createGestor\n"
                    + e.getMessage());
        }
        return false;
    }
    
    public boolean createMultitabla(Multitabla multitabla) {

        try {

            Tiilc_multitablaLocal aTiilc_multitablaLocal = createTiilc_multitablaLocal(multitabla);
            return true;
        } catch (Exception e) {
            System.err.println("Error SessionCarga: createMultitabla\n"
                    + e.getMessage());
        }
        return false;
    }

    public boolean createPerfil(Perfil perfil) {

        try {

            Tiilc_perfilLocal aTiilc_perfilLocal = createTiilc_perfilLocal(perfil);
            return true;
        } catch (Exception e) {
            System.err.println("Error SessionCarga: createPerfil\n"
                    + e.getMessage());
        }
        return false;
    }

    public boolean createPermisoPerfil(PermisoPerfil permisoPerfil) {

        try {

            Tiilc_permiso_perfilLocal aTiilc_permiso_perfilLocal = createTiilc_permiso_perfilLocal(permisoPerfil);
            return true;
        } catch (Exception e) {
            System.err.println("Error SessionCarga: createPermisoPerfil\n"
                    + e.getMessage());
        }
        return false;
    }

    /**
     * P020795-INI Maria Paula Tomaylla 16/04/2008
     */
    public boolean createEmpresa(Empresa empresa) {

        try {
            Tiilc_empresaLocal aTiilc_empresaLocal = createTiilc_empresaLocal(
                    empresa.getCod_empresa(), empresa.getDes_empresa());
			
			return true;
		} catch (Exception e) {
			System.err.println("Error SessionCarga: createEmpresa\n"
					+ empresa.getCod_empresa());
		}
		return false;
	}
    /**
     * P020795-FIN
     */

	protected Tiilc_totalLocal createTiilc_totalLocal(Total total) {
		Tiilc_totalLocalHome aTiilc_totalLocalHome = (Tiilc_totalLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_totalLocalHome_REF_NAME,
						STATIC_Tiilc_totalLocalHome_CLASS);
		try {
			if (aTiilc_totalLocalHome != null)
				return aTiilc_totalLocalHome.create(total);
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();

		}
		return null;
	}

	protected Tiilc_areaLocal createTiilc_areaLocal(String cod_area,
			String des_area) {
		Tiilc_areaLocalHome aTiilc_areaLocalHome = (Tiilc_areaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_areaLocalHome_REF_NAME,
						STATIC_Tiilc_areaLocalHome_CLASS);
		try {
			if (aTiilc_areaLocalHome != null)
				return aTiilc_areaLocalHome.create(cod_area, des_area);
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	protected Tiilc_territorioLocal createTiilc_territorioLocal(
			String cod_territorio, String tiilc_area_fk_cod_area,
			String des_territorio) throws javax.ejb.CreateException{
		Tiilc_territorioLocalHome aTiilc_territorioLocalHome = (Tiilc_territorioLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_territorioLocalHome_REF_NAME,
						STATIC_Tiilc_territorioLocalHome_CLASS);
		try {
			if (aTiilc_territorioLocalHome != null)
				return aTiilc_territorioLocalHome.create(cod_territorio,
						tiilc_area_fk_cod_area, des_territorio);
		} catch (javax.ejb.CreateException ce) {
			
		}
		return null;
	}

	protected Tiilc_oficinaLocal createTiilc_oficinaLocal(String cod_oficina,
			String tiilc_territorio_fk_cod_territorio,
			String tiilc_territorio_fk_tiilc_area_fk_cod_area,
			String des_oficina) {
		Tiilc_oficinaLocalHome aTiilc_oficinaLocalHome = (Tiilc_oficinaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_oficinaLocalHome_REF_NAME,
						STATIC_Tiilc_oficinaLocalHome_CLASS);
		try {
			if (aTiilc_oficinaLocalHome != null)
				return aTiilc_oficinaLocalHome
						.create(cod_oficina,
								tiilc_territorio_fk_cod_territorio,
								tiilc_territorio_fk_tiilc_area_fk_cod_area,
								des_oficina);
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	protected Tiilc_gestorLocal createTiilc_gestorLocal(String cod_gestor,
			String tiilc_oficina_fk_cod_oficina,
			String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
			String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area,
			String nom_gestor, String reg_gestor, String perfil_gestor) {
		Tiilc_gestorLocalHome aTiilc_gestorLocalHome = (Tiilc_gestorLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_gestorLocalHome_REF_NAME,
						STATIC_Tiilc_gestorLocalHome_CLASS);
		try {
			if (aTiilc_gestorLocalHome != null)
				return aTiilc_gestorLocalHome
						.create(
								cod_gestor,
								tiilc_oficina_fk_cod_oficina,
								tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
								tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area,
								nom_gestor, reg_gestor, perfil_gestor);
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	
	
	
	protected Tiilc_multitablaLocal createTiilc_multitablaLocal(
			Multitabla multitabla) {
		Tiilc_multitablaLocalHome aTiilc_multitablaLocalHome = (Tiilc_multitablaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_multitablaLocalHome_REF_NAME,
						STATIC_Tiilc_multitablaLocalHome_CLASS);
		try {
			if (aTiilc_multitablaLocalHome != null)
				return aTiilc_multitablaLocalHome.create(multitabla);
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	protected Tiilc_perfilLocal createTiilc_perfilLocal(Perfil perfil) {
		Tiilc_perfilLocalHome aTiilc_perfilLocalHome = (Tiilc_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_perfilLocalHome_CLASS);
		try {
			if (aTiilc_perfilLocalHome != null)
				return aTiilc_perfilLocalHome.create(perfil);
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	protected Tiilc_permiso_perfilLocal createTiilc_permiso_perfilLocal(
			PermisoPerfil permisoPerfil) {
		Tiilc_permiso_perfilLocalHome aTiilc_permiso_perfilLocalHome = (Tiilc_permiso_perfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_permiso_perfilLocalHome_REF_NAME,
						STATIC_Tiilc_permiso_perfilLocalHome_CLASS);
		try {
			if (aTiilc_permiso_perfilLocalHome != null)
				return aTiilc_permiso_perfilLocalHome.create(permisoPerfil);
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}
	protected Collection find_Tiilc_oficinaLocalHome_findAllOficinaxCod_oficina(
			String cod_oficina) {
		Tiilc_oficinaLocalHome aTiilc_oficinaLocalHome = (Tiilc_oficinaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_oficinaLocalHome_REF_NAME,
						STATIC_Tiilc_oficinaLocalHome_CLASS);
		try {
			if (aTiilc_oficinaLocalHome != null)
				return aTiilc_oficinaLocalHome
						.findAllOficinaxCod_oficina(cod_oficina);
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		}
		return null;
	}
    protected Tiilc_empresaLocal createTiilc_empresaLocal(String cod_empresa,
            String des_empresa) {
        Tiilc_empresaLocalHome aTiilc_empresaLocalHome = (Tiilc_empresaLocalHome) ServiceLocatorManager
                .getLocalHome(STATIC_Tiilc_empresaLocalHome_REF_NAME,
                        STATIC_Tiilc_empresaLocalHome_CLASS);
        try {
            if (aTiilc_empresaLocalHome != null)
                return aTiilc_empresaLocalHome.create(cod_empresa, des_empresa);
        } catch (javax.ejb.CreateException ce) {
            System.out.println(cod_empresa+" llave duplicada");
        }
        return null;
    }
}
