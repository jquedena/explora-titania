package com.grupobbva.bc.per.tele.sdo.sesion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.grupobbva.bc.per.tele.sdo.dao.OficinaDao;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.spring.XmlConfigLoader;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_oficinaKey;
import entities.Tiido_oficinaLocal;
import entities.Tiido_oficinaLocalHome;
import entities.Tiido_territorioLocal;



/**
 * Bean implementation class for Enterprise Bean: SesionOficina
 */
public class SesionOficinaBean extends JdbcDaoSupport implements javax.ejb.SessionBean
{
    private static Logger log = Logger.getLogger(SesionOficinaBean.class);

    private javax.ejb.SessionContext mySessionCtx;

    private final static String STATIC_Tiido_oficinaLocalHome_REF_NAME = "ejb/Tiido_oficina";

    private final static Class STATIC_Tiido_oficinaLocalHome_CLASS = Tiido_oficinaLocalHome.class;

    private OficinaDao oficinaDao;

    /**
     * getSessionContext
     */
    public javax.ejb.SessionContext getSessionContext()
    {
        return mySessionCtx;
    }

    /**
     * setSessionContext
     */
    public void setSessionContext(javax.ejb.SessionContext ctx)
    {
        mySessionCtx = ctx;
    }

    /**
     * ejbCreate
     */
    public void ejbCreate() throws javax.ejb.CreateException
    {
        try
        {
        	log.info("[SesionOficinaBean :: ejbCreate] Inicio");
        	
        	XmlConfigLoader loader = XmlConfigLoader.getInstance();
            this.oficinaDao = (OficinaDao) loader.getBean("oficinaDao");
            
            log.info("[SesionOficinaBean :: ejbCreate] Fin");
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: ejbCreate] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * ejbActivate
     */
    public void ejbActivate()
    {
    }

    /**
     * ejbPassivate
     */
    public void ejbPassivate()
    {
    }

    /**
     * ejbRemove
     */
    public void ejbRemove()
    {
    }

    /*public Oficina findByCodOficina(String codOficina)
    {
        return oficinaDao.findByCodOficina(codOficina);
    }*/
    
   public Oficina findByCodOficina(String codOficina)
    {
    	Territorio territorio = null;
		Oficina oficina = new Oficina();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;

		try {
			log.info("[SesionOficinaBean :: findByCodigoOficina] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionOficinaBean :: findByCodigoOficina] Fin");
				
				return oficina;
			}
			
			log.info("[SesionOficinaBean :: findByCodigoOficina] DATASOURCE_CONTEXT:::" + 
					ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionOficinaBean :: findByCodigoOficina] Fin");
				
				return oficina;
			}

			s = con.createStatement();
			sql = "SELECT o.cod_ofic cod_ofic, o.nom_ofic nom_ofic, o.cod_terr cod_terr, o.estado estado, t.nom_terr nom_terr " + 
				  "FROM tiido_oficina o,  tiido_territorio t "+
				  "WHERE  o.cod_terr = t.cod_terr AND " +
			      "o.cod_ofic = '" + codOficina + "' AND t.estado = '0' and o.estado='" + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "'";  

			log.info("[SesionOficinaBean :: findByCodigoOficina] SQL:" + sql);
			rst = s.executeQuery(sql);

			if (rst.next()) {
				territorio = new Territorio();
				territorio.setCodTerr(rst.getString("cod_terr"));
				territorio.setNomTerr(rst.getString("nom_terr"));
				
				oficina.setCodOfic(rst.getString("cod_ofic"));
				oficina.setNomOficina(rst.getString("nom_ofic"));
				oficina.setTerr(territorio);				
			}
			
			log.info("[SesionOficinaBean :: findByCodigoOficina] Fin");
		} catch (Exception e) {
			log.error("[SesionOficinaBean :: findByCodigoOficina] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionOficinaBean :: findByCodigoOficina] ");
	        	ConstantesUtil.mostrarMensajeExcepcion(e);
	        	
				return oficina;
			}
		}

		return oficina;
    }

    public boolean findByCodigoOficina(String codOficina)
    {
        Oficina oficina = new Oficina();
        
        try
        {
        	log.info("[SesionOficinaBean :: findByCodigoOficina] Inicio");
        	
            oficina = findByCodOficina(codOficina);
            if (oficina != null && oficina.getCodOfic() != null)
            {
                
            	log.info("[SesionOficinaBean :: findByCodigoOficina] Fin");
            	return true;
            }
            
            log.info("[SesionOficinaBean :: findByCodigoOficina] Fin");
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findByCodigoOficina] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        
        return false;
    }

    public Vector findAllOficinaByCodTerri(String codTerritorio)
    {
        Vector listaOficina = new Vector();
        Tiido_oficinaLocal oficinaLocal = null;
        
        try
        {
        	log.info("[SesionOficinaBean :: findAllOficinaByCodTerri] Inicio");
        	
        	Collection aCollection = find_Tiido_oficinaLocalHome_findAllOficinaByCodTerri(codTerritorio);
            Iterator oficinaIterator = aCollection.iterator();
            while (oficinaIterator.hasNext())
            {
                Oficina oficina = new Oficina();
                Territorio territorio = new Territorio();
                oficinaLocal = (Tiido_oficinaLocal) oficinaIterator.next();
                if (ObjectUtils.equals(oficinaLocal.getEstado(), ConstantesUtil.OFICINA_ESTADO_ACTIVO))
                {
                    territorio.setCodTerr(oficinaLocal.getTiido_territorio_fk().getCod_terr());
                    oficina.setCodOfic(((Tiido_oficinaKey) oficinaLocal.getPrimaryKey()).getCod_ofic());
                    oficina.setFecActu(oficinaLocal.getFec_actu());
                    oficina.setFecRegi(oficinaLocal.getFec_regi());
                    oficina.setTerr(territorio);
                    oficina.setCodNomOficina(((Tiido_oficinaKey) oficinaLocal.getPrimaryKey()).getCod_ofic() + " - "
                            + oficinaLocal.getNom_ofic().toUpperCase());
                    oficina.setUsuActu(oficinaLocal.getUsu_actu());
                    oficina.setUsuRegi(oficinaLocal.getUsu_regi());
                    listaOficina.add(oficina);
                }
            }
            
            log.info("[SesionOficinaBean :: findAllOficinaByCodTerri] Fin");
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findAllOficinaByCodTerri] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	return null;
        }
        
        return listaOficina;
    }

    public Vector findAllOficinaByCodTerri_MOD1(String codTerritorio, String anho, String mes)
    {
    	return oficinaDao.findAllOficinaByCodTerri_MOD1(codTerritorio, anho, mes);
    }

    public Vector findAllOficinaByCodTerri_MOD2(String codTerritorio)
    {
        return oficinaDao.findAllOficinaByCodTerri_MOD2(codTerritorio);
    }

    // INICIO - SP_CAMBIO_TERRITORIO_OFICINA
    public Vector editarTerritoriosDeOficinas(String codOficina, String codTerritorio)
    {
        Connection con = null;
        Context initialContext = null;
        Statement s = null;
        CallableStatement cs = null;
        
        try
        {
        	log.info("[SesionOficinaBean :: editarTerritoriosDeOficinas] Inicio");
        	
        	initialContext = new InitialContext();
            if (initialContext == null)
            {
            	log.info("[SesionOficinaBean :: editarTerritoriosDeOficinas] Fin");
            	return null;
            }
            
            DataSource datasource = (DataSource) initialContext.lookup("jdbc/IIDO");
            if (datasource != null)
            {
                con = datasource.getConnection();
            }
            else
            {
                initialContext = null;
                log.info("[SesionOficinaBean :: editarTerritoriosDeOficinas] Fin");
                
                return null;
            }

            cs = con.prepareCall("{call IIDO.PKG_UTIL.SP_CAMBIO_TERRITORIO_OFICINA(?,?)}");
            cs.setString(1, codOficina);
            cs.setString(2, codTerritorio);
            cs.execute();
            
            log.info("[SesionOficinaBean :: editarTerritoriosDeOficinas] Fin");
            return null;
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: editarTerritoriosDeOficinas] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
            return null;
        }
        finally
        {
            try
            {
                if (cs != null)
                {
                    cs.close();
                }

                if (con != null)
                {
                    con.close();
                }

                if (initialContext != null)
                {
                    initialContext.close();
                }
            }
            catch (Exception e)
            {
            	log.error("[SesionOficinaBean :: editarTerritoriosDeOficinas] ");
            	ConstantesUtil.mostrarMensajeExcepcion(e);
                return null;
            }
        }
    }

    public boolean findOficinaAndTerri(String codTerritorio, String codOfi)
    {
        Tiido_oficinaLocal oficinaLocal = null;
        boolean fExiste = false;
        
        try
        {
        	log.info("[SesionOficinaBean :: findOficinaAndTerri] Inicio");
        	
        	Collection aCollection = find_Tiido_oficinaLocalHome_findAllOficinaByCodTerri(codTerritorio);
            Iterator oficinaIterator = aCollection.iterator();
            while (oficinaIterator.hasNext())
            {
                oficinaLocal = (Tiido_oficinaLocal) oficinaIterator.next();
                if (((Tiido_oficinaKey) oficinaLocal.getPrimaryKey()).getCod_ofic().trim().equals(codOfi.trim())
                        && ConstantesUtil.OFICINA_ESTADO_ACTIVO.equals(oficinaLocal.getEstado()))
                {
                    fExiste = true;
                }
            }
            
            log.info("[SesionOficinaBean :: findOficinaAndTerri] Fin");
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findOficinaAndTerri] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
        	return fExiste;
        }
        
        
        return fExiste;
    }

    public Vector findAllOficinas(){
    	Territorio territorio = null;
		Oficina oficina;
		Vector res = new Vector();
		String sql;
		Context initialContext;
		Connection con = null;
		ResultSet rst = null;
		Statement s = null;
		try {
			initialContext = new InitialContext();
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			con = datasource.getConnection();
			
			sql = "select o.cod_ofic, o.nom_ofic, o.usu_regi, o.fec_regi, o.usu_actu, o.fec_actu, o.estado, o.cod_terr " +
				"from tiido_oficina o, tiido_territorio t " +
				"where o.cod_terr = t.cod_terr and " +
				"t.estado = '0' " +
				"order by o.cod_ofic";
			
			try {
				s = con.createStatement();
				rst = s.executeQuery(sql);

				while (rst.next()) {
					oficina = new Oficina();
					territorio = new Territorio();
					territorio.setCodTerr(rst.getString("cod_terr"));
                    oficina.setTerr(territorio);
                    oficina.setCodOfic(rst.getString("cod_ofic"));
                    oficina.setNomOficina(rst.getString("nom_ofic").toUpperCase());
                    oficina.setFecActu(rst.getDate("fec_actu"));
                    oficina.setFecRegi(rst.getDate("fec_regi"));
                    oficina.setCodNomOficina(oficina.getCodOfic() + " - " + oficina.getNomOficina());
                    oficina.setUsuActu(rst.getString("usu_actu"));
                    oficina.setUsuRegi(rst.getString("usu_regi"));
                    res.add(oficina);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally{
				if (rst != null)
					try { rst.close(); } catch (Throwable e) {}
				if (s != null)
					try { s.close(); } catch (Throwable e) {}
				if (con != null)
					try { con.close(); } catch (Throwable e) {}
			}
			initialContext.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return res;
    }

    public Vector findListaByCodOficina(String codOficina)
    {
        logger.debug("inicio de findListaByCodOficina");
        Vector listaOficina = new Vector();
        Tiido_oficinaLocal oficinaLocal = null;
        
        try
        {
        	log.info("[SesionOficinaBean :: findListaByCodOficina] Inicio");
        	
        	Collection aCollection = find_Tiido_oficinaLocalHome_findListaByCodOficina(codOficina);
            Iterator oficinaIterator = aCollection.iterator();
            while (oficinaIterator.hasNext())
            {
                oficinaLocal = (Tiido_oficinaLocal) oficinaIterator.next();
                if (ConstantesUtil.OFICINA_ESTADO_ACTIVO.equals(oficinaLocal.getEstado()))
                {
                    Oficina oficina = new Oficina();
                    Territorio territorio = new Territorio();
                    territorio.setCodTerr(oficinaLocal.getTiido_territorio_fk().getCod_terr());
                    oficina.setCodOfic(((Tiido_oficinaKey) oficinaLocal.getPrimaryKey()).getCod_ofic());
                    oficina.setFecActu(oficinaLocal.getFec_actu());
                    oficina.setFecRegi(oficinaLocal.getFec_regi());
                    oficina.setTerr(territorio);
                    oficina.setCodNomOficina(((Tiido_oficinaKey) oficinaLocal.getPrimaryKey()).getCod_ofic() + " - "
                            + oficinaLocal.getNom_ofic().toUpperCase());
                    oficina.setUsuActu(oficinaLocal.getUsu_actu());
                    oficina.setUsuRegi(oficinaLocal.getUsu_regi());
                    listaOficina.add(oficina);
                }
            }
            
            log.info("[SesionOficinaBean :: findListaByCodOficina] Fin");
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findListaByCodOficina] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
        	return null;
        }
 
        return listaOficina;
    }

    protected Collection find_Tiido_oficinaLocalHome_findAllOficinaByCodTerri(String codTerritorio)
    {
        
        try
        {
        	log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findAllOficinaByCodTerri] Inicio");
        	
        	Tiido_oficinaLocalHome aTiido_oficinaLocalHome = (Tiido_oficinaLocalHome) ServiceLocatorManager.getLocalHome(
                    STATIC_Tiido_oficinaLocalHome_REF_NAME, STATIC_Tiido_oficinaLocalHome_CLASS);
        	
        	if (aTiido_oficinaLocalHome != null) {
        		log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findAllOficinaByCodTerri] Fin");
        		
                return aTiido_oficinaLocalHome.findAllOficinaByCodTerri(codTerritorio);
        	}
        	
        	log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findAllOficinaByCodTerri] Fin");
        }
        catch (javax.ejb.FinderException e)
        {
        }
        
        return null;
    }

    protected Tiido_oficinaLocal find_Tiido_oficinaLocalHome_findByCodOficina(String codOficina)
    {
        try
        {
        	log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findByCodOficina] Inicio"); 
        	
        	Tiido_oficinaLocalHome aTiido_oficinaLocalHome = (Tiido_oficinaLocalHome) ServiceLocatorManager.getLocalHome(
                    STATIC_Tiido_oficinaLocalHome_REF_NAME, STATIC_Tiido_oficinaLocalHome_CLASS);
        	
        	if (aTiido_oficinaLocalHome != null){
                Tiido_oficinaLocal oficina= aTiido_oficinaLocalHome.findByCodOficina(codOficina);
                if(ConstantesUtil.OFICINA_ESTADO_ACTIVO.equals(oficina.getEstado())){
                	log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findByCodOficina] Fin");
                	
                    return oficina;
                }
                else{
                    throw new FinderException("Zero results");
                }
            }
        	
        	log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findByCodOficina] Fin");
        }
        catch (javax.ejb.FinderException fe)
        {
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findByCodOficina] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        
        return null;
    }

    protected Collection find_Tiido_oficinaLocalHome_findListaByCodOficina(String codOficina)
    {
        try
        {
        	log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findListaByCodOficina] Inicio");
        	
        	Tiido_oficinaLocalHome aTiido_oficinaLocalHome = (Tiido_oficinaLocalHome) ServiceLocatorManager.getLocalHome(
                    STATIC_Tiido_oficinaLocalHome_REF_NAME, STATIC_Tiido_oficinaLocalHome_CLASS);
        	
        	if (aTiido_oficinaLocalHome != null) {
        		log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findListaByCodOficina] Fin");
        		
                return aTiido_oficinaLocalHome.findListaByCodOficina(codOficina);
        	}
        	
        	log.info("[SesionOficinaBean :: find_Tiido_oficinaLocalHome_findListaByCodOficina] Fin");
        }
        catch (javax.ejb.FinderException fe)
        {
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: SesionOficinaBean] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        
        return null;
    }

    public Vector busOficinaxTerritorio(String codTerritorio,boolean showAll)
    {
        return oficinaDao.busOficinaxTerritorio(codTerritorio, showAll);
    }

    public int nuevaOficina(String codTerritorio, String codOficina, 
    		String nomOficina, String usuario)
    {
        return oficinaDao.nuevaOficina(codTerritorio, codOficina, nomOficina, usuario);
    }

    public Vector editarOficina(Oficina oficina)
    {
        oficinaDao.editarOficina(oficina);
        return null;
    }

    public int eliminarOficina(String codOficina)
    {
        return oficinaDao.eliminarOficina(codOficina);
    }

    public Territorio findTerritorioByCodOficina(String codOficina)
    {
        Tiido_oficinaLocal aTiido_oficinaLocal = null;
        Tiido_territorioLocal territorioLocal = null;
        Territorio territorio = new Territorio();
        
        try
        {
        	log.info("[SesionOficinaBean :: findTerritorioByCodOficina] Inicio");
        	
        	aTiido_oficinaLocal = find_Tiido_oficinaLocalHome_findByCodOficina(codOficina);
            if (aTiido_oficinaLocal != null)
            {
                territorioLocal = aTiido_oficinaLocal.getTiido_territorio_fk();
                if (territorioLocal != null)
                {
                    territorio.setCodTerr(territorioLocal.getCod_terr());
                    territorio.setNomTerr(territorioLocal.getNom_terr());
                }
            }
            
            log.info("[SesionOficinaBean :: findTerritorioByCodOficina] Fin");
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findTerritorioByCodOficina] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        
        return territorio;
    }

    public OficinaHija findOficinaHija(OficinaHija oficinaHija)
    {
        Connection con = null;
        Context initialContext = null;
        Statement s = null;
        ResultSet rst = null;
        String sql = null;
        OficinaHija nuevaOficinaHija = null;

        try
        {
        	log.info("[SesionOficinaBean :: findOficinaHija] Inicio");
        	
        	initialContext = new InitialContext();
            if (initialContext == null)
            {
            	log.info("[SesionOficinaBean :: findOficinaHija] Fin");
            	
            	return null;
            }
            
            log.info("[SesionOficinaBean :: findOficinaHija] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
            
            DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

            if (datasource != null)
            {
                con = datasource.getConnection();
            }
            else
            {
                initialContext = null;
                log.info("[SesionOficinaBean :: findOficinaHija] Fin");
                
                return null;
            }

            if (oficinaHija != null)
            {
                s = con.createStatement();
                sql = "SELECT h.oficina_hija_id oficina_hija_id, h.oficina_id oficina_padre_id, "
                        + "h.descripcion oficina_hija_nombre, "
                        + "(SELECT TRIM(o.nom_ofic) FROM tiido_oficina o WHERE o.cod_ofic = h.oficina_id and o.estado='"
                        + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "') oficina_padre_nombre "
                        + "FROM tiido_oficina_hija h " + "WHERE h.oficina_hija_id = '"
                        + oficinaHija.getCodigoOficinaHija() + "'";

                
                log.info("[SesionOficinaBean :: findOficinaHija] SQL:::" + sql);
                rst = s.executeQuery(sql);
                if (rst.next())
                {
                    nuevaOficinaHija = new OficinaHija();
                    nuevaOficinaHija.setCodigoOficinaHija(rst.getString("oficina_hija_id"));
                    nuevaOficinaHija.setNombreOficinaHija(rst.getString("oficina_hija_nombre"));
                    nuevaOficinaHija.setCodigoOficinaPadre(rst.getString("oficina_padre_id"));
                    nuevaOficinaHija.setNombreOficinaPadre(rst.getString("oficina_padre_nombre"));
                }
            }
            
            log.info("[SesionOficinaBean :: findOficinaHija] Fin");
        }
        catch (SQLException e)
        {
        	log.error("[SesionOficinaBean :: findOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        finally
        {
            try
            {
                if (rst != null)
                {
                    rst.close();
                }

                if (s != null)
                {
                    s.close();
                }

                if (con != null)
                {
                    con.close();
                }

                if (initialContext != null)
                {
                    initialContext.close();
                }
            }
            catch (Exception e)
            {
            	log.error("[SesionOficinaBean :: findOficinaHija] ");
            	ConstantesUtil.mostrarMensajeExcepcion(e);
            }
        }

        return nuevaOficinaHija;
    }

    public boolean crearOficinaHija(OficinaHija oficinaHija)
    {
        Connection con = null;
        Context initialContext = null;
        PreparedStatement s = null;
        boolean resp = false;
        String sql = null;

        try
        {
        	log.info("[SesionOficinaBean :: crearOficinaHija] Inicio");
        	
        	initialContext = new InitialContext();
            if (initialContext == null)
            {
                return false;
            }
            
            log.info("[SesionOficinaBean :: crearOficinaHija] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
            
            DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
            if (datasource != null)
            {
                con = datasource.getConnection();
            }
            else
            {
                initialContext = null;
                log.info("[SesionOficinaBean :: crearOficinaHija] Fin");
                
                return resp;
            }

            if (oficinaHija != null)
            {
                sql = "INSERT INTO tiido_oficina_hija (oficina_hija_id, oficina_id, descripcion, usu_regi) " + "VALUES(?, ?, ?, ?)";
                s = con.prepareStatement(sql);
                s.setString(1, oficinaHija.getCodigoOficinaHija());
                s.setString(2, oficinaHija.getCodigoOficinaPadre());
                s.setString(3, oficinaHija.getNombreOficinaHija());
                s.setString(4, oficinaHija.getUsuario());
                
                log.info("[SesionOficinaBean :: crearOficinaHija] SQL:" + sql);
                resp = s.executeUpdate() > 0 ? true : false;
            }
            
            log.info("[SesionOficinaBean :: crearOficinaHija] Fin");
        }
        catch (SQLException e)
        {
        	log.error("[SesionOficinaBean :: crearOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
            resp = false;
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: crearOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
            resp = false;
        }
        finally
        {
            try
            {
                if (s != null)
                {
                    s.close();
                }

                if (con != null)
                {
                    con.close();
                }

                if (initialContext != null)
                {
                    initialContext.close();
                }
            }
            catch (Exception e)
            {
            	log.error("[SesionOficinaBean :: crearOficinaHija] ");
            	ConstantesUtil.mostrarMensajeExcepcion(e);
            	
                resp = false;
            }
        }

        return resp;
    }

    public boolean actualizarOficinaHija(OficinaHija oficinaHija)
    {
        Connection con = null;
        Context initialContext = null;
        PreparedStatement s = null;
        boolean resp = false;
        String sql = null;
        
        try
        {
        	log.info("[SesionOficinaBean :: actualizarOficinaHija] Inicio");
        	
        	initialContext = new InitialContext();
            if (initialContext == null)
            {
            	log.info("[SesionOficinaBean :: actualizarOficinaHija] Fin");
            	
            	return false;
            }
            
            log.info("[SesionOficinaBean :: actualizarOficinaHija] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
            
            DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

            if (datasource != null)
            {
                con = datasource.getConnection();
            }
            else
            {
                initialContext = null;
                return resp;
            }

            if (oficinaHija != null)
            {
                sql = "UPDATE tiido_oficina_hija " + "SET oficina_id = ?,  descripcion = ?, usu_actu = ?, fec_actu=SYSDATE " + 
                      "WHERE oficina_hija_id = ?";

                s = con.prepareStatement(sql);
                s.setString(1, oficinaHija.getCodigoOficinaPadre());
                s.setString(2, oficinaHija.getNombreOficinaHija());
                s.setString(3, oficinaHija.getUsuario());
                s.setString(4, oficinaHija.getCodigoOficinaHija());

                log.info("[SesionOficinaBean :: actualizarOficinaHija] SQL:" + sql);
                resp = s.executeUpdate() > 0 ? true : false;
            }
            
            log.info("[SesionOficinaBean :: actualizarOficinaHija] Fin");
        }
        catch (SQLException e)
        {
        	log.error("[SesionOficinaBean :: actualizarOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
            resp = false;
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: actualizarOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
            resp = false;
        }
        finally
        {
            try
            {
                if (s != null)
                {
                    s.close();
                }

                if (con != null)
                {
                    con.close();
                }

                if (initialContext != null)
                {
                    initialContext.close();
                }
            }
            catch (Exception e)
            {
            	log.error("[SesionOficinaBean :: actualizarOficinaHija] ");
            	ConstantesUtil.mostrarMensajeExcepcion(e);
            	
                resp = false;
            }
        }

        return resp;
    }

    public boolean eliminarOficinaHija(OficinaHija oficinaHija)
    {
        Connection con = null;
        Context initialContext = null;
        Statement s = null;
        boolean resp = false;
        int cont = 0;
        String sql = null;

        try
        {
        	log.info("[SesionOficinaBean :: eliminarOficinaHija] Inicio");
        	
        	initialContext = new InitialContext();
            if (initialContext == null)
            {
            	log.info("[SesionOficinaBean :: eliminarOficinaHija] Fin");
            	
            	return false;
            }
            
            log.info("[SesionOficinaBean :: eliminarOficinaHija] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
            
            DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

            if (datasource != null)
            {
                con = datasource.getConnection();
            }
            else
            {
                initialContext = null;
                log.info("[SesionOficinaBean :: eliminarOficinaHija] Fin");
                
                return false;
            }

            if (oficinaHija != null)
            {
                sql = "DELETE FROM tiido_oficina_hija " + "WHERE oficina_hija_id = '"
                        + oficinaHija.getCodigoOficinaHija() + "'";

                s = con.createStatement();

                log.info("[SesionOficinaBean :: eliminarOficinaHija] SQL:" + sql);
                s.executeQuery(sql);

                if (findOficinaHija(oficinaHija) == null)
                {
                    resp = true;
                }
            }
            
            log.info("[SesionOficinaBean :: eliminarOficinaHija] Fin");
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: eliminarOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
            resp = false;
        }
        finally
        {
            try
            {
                if (s != null)
                {
                    s.close();
                }

                if (con != null)
                {
                    con.close();
                }

                if (initialContext != null)
                {
                    initialContext.close();
                }
            }
            catch (Exception e)
            {
            	log.error("[SesionOficinaBean :: eliminarOficinaHija] ");
            	ConstantesUtil.mostrarMensajeExcepcion(e);
            	
                resp = false;
            }
        }

        return resp;
    }

    public Vector findTodosOficinaHija()
    {
        Connection con = null;
        Context initialContext = null;
        Statement s = null;
        ResultSet rst = null;
        boolean resp = false;
        int cont = 0;
        String sql = null;
        String cond = null;
        OficinaHija nuevaOficinaHija = null;
        Vector vector = null;

        try
        {
        	log.info("[SesionOficinaBean :: findTodosOficinaHija] Inicio");
        	
        	initialContext = new InitialContext();
            if (initialContext == null)
            {
            	log.info("[SesionOficinaBean :: findTodosOficinaHija] Fin");
            	
            	return null;
            }
            
            log.info("[SesionOficinaBean :: findTodosOficinaHija] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
            
            DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

            if (datasource != null)
            {
                con = datasource.getConnection();
            }
            else
            {
                initialContext = null;
                log.info("[SesionOficinaBean :: findTodosOficinaHija] Fin");
                
                return null;
            }

            s = con.createStatement();
            sql = "SELECT h.oficina_hija_id oficina_hija_id, h.oficina_id oficina_padre_id, "
                    + "h.descripcion oficina_hija_nombre, "
                    + "(SELECT o.nom_ofic FROM tiido_oficina o WHERE o.cod_ofic = h.oficina_id and o.estado='"
                    + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "') oficina_padre_nombre " + "FROM tiido_oficina_hija h";

            log.info("[SesionOficinaBean :: findTodosOficinaHija] SQL:" + sql);

            rst = s.executeQuery(sql);
            vector = new Vector();
            while (rst.next())
            {
                nuevaOficinaHija = new OficinaHija();
                nuevaOficinaHija.setCodigoOficinaHija(rst.getString("oficina_hija_id"));
                nuevaOficinaHija.setNombreOficinaHija(rst.getString("oficina_hija_nombre"));
                nuevaOficinaHija.setCodigoOficinaPadre(rst.getString("oficina_padre_id"));
                nuevaOficinaHija.setNombreOficinaPadre(rst.getString("oficina_padre_nombre"));

                vector.add(nuevaOficinaHija);
            }
            
            log.info("[SesionOficinaBean :: findTodosOficinaHija] Fin");
        }
        catch (SQLException e)
        {
        	log.error("[SesionOficinaBean :: findTodosOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findTodosOficinaHija] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        finally
        {
            try
            {
                if (rst != null)
                {
                    rst.close();
                }

                if (s != null)
                {
                    s.close();
                }

                if (con != null)
                {
                    con.close();
                }

                if (initialContext != null)
                {
                    initialContext.close();
                }
            }
            catch (Exception e)
            {
            	log.error("[SesionOficinaBean :: findTodosOficinaHija] ");
            	ConstantesUtil.mostrarMensajeExcepcion(e);
            }
        }

        return vector;
    }

    public Vector findHijas(String codOficinaPadre)
    {
        Connection con = null;
        Context initialContext = null;
        Statement s = null;
        ResultSet rst = null;
        boolean resp = false;
        int cont = 0;
        String sql = null;
        String cond = null;
        OficinaHija nuevaOficinaHija = null;
        Vector vector = null;
        
        try
        {
        	log.info("[SesionOficinaBean :: findHijas] Inicio");
        	
        	initialContext = new InitialContext();
            if (initialContext == null)
            {
            	log.info("[SesionOficinaBean :: findHijas] Fin");
            	
            	return null;
            }
            
            log.info("[SesionOficinaBean :: DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
            
            DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

            if (datasource != null)
            {
                con = datasource.getConnection();
            }
            else
            {
                initialContext = null;
                log.info("[SesionOficinaBean :: findHijas] Fin");
                
                return null;
            }
            s = con.createStatement();
            sql = "SELECT h.oficina_hija_id oficina_hija_id " + "FROM tiido_oficina_hija h " + "WHERE h.oficina_id = '"
                    + codOficinaPadre + "'";

            log.info("[SesionOficinaBean :: findHijas] SQL:" + sql);
            rst = s.executeQuery(sql);
            vector = new Vector();
            while (rst.next())
            {
                nuevaOficinaHija = new OficinaHija();
                nuevaOficinaHija.setCodigoOficinaHija(rst.getString("oficina_hija_id"));
                vector.add(nuevaOficinaHija);
            }
            
            log.info("[SesionOficinaBean :: findHijas] Fin");
        }
        catch (SQLException e)
        {
        	log.error("[SesionOficinaBean :: findHijas] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        catch (Exception e)
        {
        	log.error("[SesionOficinaBean :: findHijas] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        }
        finally
        {
            try
            {
                if (rst != null)
                {
                    rst.close();
                }

                if (s != null)
                {
                    s.close();
                }

                if (con != null)
                {
                    con.close();
                }

                if (initialContext != null)
                {
                    initialContext.close();
                }
            }
            catch (Exception e)
            {
            	log.error("[SesionOficinaBean :: findHijas] ");
            	ConstantesUtil.mostrarMensajeExcepcion(e);
            }
        }

        return vector;
    }

    public Oficina findByCodOficinaHija(String codOficina)
    {
        return oficinaDao.findByCodOficinaHija(codOficina);
    }
    
//	OSCAR CORTEZ - BUSCAR OFICINA POR TERRITORIO
	public Vector busOficinaxTerritorio(String codTerritorio) {
		Vector res = null;
		Oficina bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionOficinaBean :: busOficinaxTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionOficinaBean :: busOficinaxTerritorio] Fin");
				
				return null;
			}
			
			log.info("[SesionOficinaBean :: busOficinaxTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionOficinaBean :: busOficinaxTerritorio] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =

				"SELECT o.cod_ofic, o.nom_ofic FROM tiido_oficina o "
						+ "WHERE o.cod_terr='"
						+ codTerritorio
						+ "' AND EXISTS(SELECT cod_terr FROM tiido_territorio t WHERE t.cod_terr='"
						+ codTerritorio + "' AND t.estado = '0') ";

				log.info("[SesionOficinaBean :: busOficinaxTerritorio] SQL:" + sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Oficina();

					bean.setCodOfic(rst.getString(1));
					bean.setCodNomOficina(rst.getString(2));

					res.add(bean);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			log.info("[SesionOficinaBean :: busOficinaxTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionOficinaBean :: busOficinaxTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionOficinaBean :: busOficinaxTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}

public Vector editarOficina(String codTerritorio, String codOficina,
			String nomOficina) {
		Vector res = null;
		Oficina bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionOficinaBean :: editarOficina] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionOficinaBean :: editarOficina] Fin");
				
				return null;
			}
			
			log.info("[SesionOficinaBean :: editarOficina] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionOficinaBean :: editarOficina] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =

				"UPDATE tiido_oficina SET NOM_OFIC='" + nomOficina
						+ "', COD_TERR='" + codTerritorio
						+ "' WHERE COD_OFIC='" + codOficina + "'";

				log.info("[SesionOficinaBean :: editarOficina] SQL:" + sql);
				s.executeQuery(sql);
				
			} catch (SQLException e) {
				log.error("[SesionOficinaBean :: editarOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionOficinaBean :: editarOficina] Fin");
		} catch (Exception e) {
			log.error("[SesionOficinaBean :: editarOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionOficinaBean :: editarOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}


public Vector nuevaOficina(String codTerritorio, String codOficina,
			String nomOficina) {
		Vector res = null;
		Oficina bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionOficinaBean :: nuevaOficina] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionOficinaBean :: nuevaOficina] Fin");
				
				return null;
			}
			
			log.info("[SesionOficinaBean :: nuevaOficina] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionOficinaBean :: nuevaOficina] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =

				"insert into tiido_oficina (COD_OFIC,COD_TERR,NOM_OFIC) values ('"
						+ codOficina + "','" + codTerritorio + "','"
						+ nomOficina + "')";

				log.info("[SesionOficinaBean :: nuevaOficina] SQL:" + sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Oficina();

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SesionOficinaBean :: nuevaOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionOficinaBean :: nuevaOficina] Fin");
		} catch (Exception e) {
			log.error("[SesionOficinaBean :: nuevaOficina] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionOficinaBean :: nuevaOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				return null;
			}
		}

		return res;
	}
}
