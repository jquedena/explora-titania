package com.grupobbva.bc.per.tele.sdo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"unchecked"})
public class OficinaDao extends JdbcDaoSupport
{
    private Logger log = Logger.getLogger(OficinaDao.class);
    public Oficina findByCodOficina(String codOficina)
    {
    	log.info("[OficinaDao :: findByCodOficina] Inicio");
        
        String sql = "SELECT o.cod_ofic cod_ofic, o.nom_ofic nom_ofic, o.cod_terr cod_terr, o.estado estado "
                + "FROM tiido_oficina o,  tiido_territorio t " + "WHERE  o.cod_terr = t.cod_terr AND "
                + "o.cod_ofic = ? AND t.estado = '0' and o.estado='" + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "'";        
        List ofices = getJdbcTemplate().query(sql, new Object[] { codOficina }, new OficinaMapper());
        log.info("[OficinaDao :: findByCodOficina] ofices: " + ofices);
        
        if (ofices != null && !ofices.isEmpty())
        {
        	log.info("[OficinaDao :: findByCodOficina] Fin");
        	return (Oficina) ofices.get(0);
        }
        
        log.info("[OficinaDao :: findByCodOficina] Fin");
        return new Oficina();
    }

    public Vector findAllOficinaByCodTerri_MOD1(String codTerritorio, String anho, String mes)
    {
    	log.info("[OficinaDao :: findAllOficinaByCodTerri_MOD1] Inicio");
    	
        String sql = "Select b.* From tiido_maestro_planes a, tiido_oficina b Where a.cod_ofic = b.cod_ofic And a.cod_terr = b.cod_terr And a.mes = '"
                + mes
                + "' and a.anho = '"
                + anho
                + "' and a.cod_terr='"
                + codTerritorio
                + "' and b.estado='"
                + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "' Order By b.cod_ofic";
        
        List oficinas = getJdbcTemplate().query(sql, new OficinaMapper1());
        if (oficinas != null)
        {
        	log.info("[OficinaDao :: findAllOficinaByCodTerri_MOD1] Fin");
        	return new Vector(oficinas);
        }
        
        log.info("[OficinaDao :: findAllOficinaByCodTerri_MOD1] Fin");
        return null;
    }

    public Vector findAllOficinaByCodTerri_MOD2(String codTerritorio)
    {
        log.info("[OficinaDao :: findAllOficinaByCodTerri_MOD2] Inicio");
        
        String sql = "Select distinct(b.cod_ofic), b.cod_terr, b.nom_ofic, b.estado From tiido_maestro_planes a, tiido_oficina b Where a.cod_ofic = b.cod_ofic And a.cod_terr = b.cod_terr and a.cod_terr='"
                + codTerritorio + "' and b.estado='" + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "' Order By b.cod_ofic";
        List oficinas = getJdbcTemplate().query(sql, new OficinaMapper2());
        if (oficinas != null)
        {
        	log.info("[OficinaDao :: findAllOficinaByCodTerri_MOD2] Fin");
        	return new Vector(oficinas);
        }
        
        log.info("[OficinaDao :: findAllOficinaByCodTerri_MOD2] Fin");
        return null;
    }

    public Vector busOficinaxTerritorio(String codTerritorio, boolean showAll)
    {
    	log.info("[OficinaDao :: busOficinaxTerritorio] Inicio");
    	
        String sql = "SELECT o.cod_ofic, o.nom_ofic,o.estado FROM tiido_oficina o " + "WHERE o.cod_terr='"
                + codTerritorio + "' AND EXISTS(SELECT cod_terr FROM tiido_territorio t WHERE t.cod_terr='"
                + codTerritorio + "' AND t.estado = '0')";
        if (!showAll)
        {
            sql += " and o.estado='" + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "') ";
        }
        
        List oficinas = getJdbcTemplate().query(sql, new OficinaMapper3());
        if (oficinas != null)
        {
        	log.info("[OficinaDao :: busOficinaxTerritorio] Fin");
        	return new Vector(oficinas);
        }
        
        log.info("[OficinaDao :: busOficinaxTerritorio] Fin");
        return null;
    }
    
    public int nuevaOficina(String codTerritorio, String codOficina, String nomOficina, String usuario)
    {
    	log.info("[OficinaDao :: nuevaOficina] Inicio");
    	int res = 0;
    	try{
	    	String sql = "insert into tiido_oficina (COD_OFIC,COD_TERR,NOM_OFIC,ESTADO,usu_regi) values ('" + codOficina + "','"
	                + codTerritorio + "','" + nomOficina + "','" + ConstantesUtil.OFICINA_ESTADO_ACTIVO + "', '" + usuario + "')";
	        getJdbcTemplate().update(sql);
	        res = 1;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		res = -1;
    	}
        log.info("[OficinaDao :: nuevaOficina] Fin");
        return res;
    }
    
    public void  editarOficina(Oficina oficina){
    	log.info("[OficinaDao :: editarOficina] Inicio");
    	
        String sql = "UPDATE tiido_oficina SET NOM_OFIC='" + oficina.getNomOficina() + "', COD_TERR='"
        + oficina.getCodTerritorio() + "', usu_actu='" + oficina.getUsuActu() +  "', fec_actu=SYSDATE, ESTADO='" + oficina.getEstado() + "' WHERE COD_OFIC='"
        + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
    	
        //actualizar referencias (antiguos FKs) en otras tablas
        sql = "UPDATE TIIDO_ACCIONES SET COD_TERR='" + oficina.getCodTerritorio() + "' WHERE COD_OFIC='" + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
        sql = "UPDATE TIIDO_CAMPANIAS SET COD_TERR='" + oficina.getCodTerritorio() + "' WHERE COD_OFIC='" + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
        sql = "UPDATE TIIDO_CAMPANIAS_DETALLE SET COD_TERR='" + oficina.getCodTerritorio() + "' WHERE COD_OFIC='" + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
        sql = "UPDATE TIIDO_FIRMAS SET COD_TERR='" + oficina.getCodTerritorio() + "' WHERE COD_OFIC='" + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
        sql = "UPDATE TIIDO_MAESTRO_PLANES SET COD_TERR='" + oficina.getCodTerritorio() + "' WHERE COD_OFIC='" + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
        sql = "UPDATE TIIDO_METAS_GESTOR SET COD_TERR='" + oficina.getCodTerritorio() + "' WHERE COD_OFIC='" + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
        sql = "UPDATE TIIDO_PLANES SET COD_TERR='" + oficina.getCodTerritorio() + "' WHERE COD_OFIC='" + oficina.getCodOfic() + "'";
        getJdbcTemplate().update(sql);
        log.info("[OficinaDao :: editarOficina] Fin");
    }
    
    public Oficina findByCodOficinaHija(String codOficina){
    	log.info("[OficinaDao :: findByCodOficinaHija] Inicio");
    	
        String sql = "SELECT h.oficina_id cod_ofic, h.descripcion nom_ofic, o.cod_terr cod_terr, o.estado "
            + "FROM tiido_oficina o,  tiido_territorio t, tiido_oficina_hija h "
            + "WHERE o.cod_ofic = h.oficina_id AND " + "o.cod_terr = t.cod_terr AND "
            + "h.oficina_hija_id = '" + codOficina + "' AND t.estado = '0' and o.estado='"+ConstantesUtil.OFICINA_ESTADO_ACTIVO+"'";
        List ofices = getJdbcTemplate().query(sql, new OficinaMapper());
        
        if (ofices != null && !ofices.isEmpty())
        {
        	log.info("[OficinaDao :: findByCodOficinaHija] Fin");
        	return (Oficina) ofices.get(0);
        }
        
        log.info("[OficinaDao :: findByCodOficinaHija] Fin");
        return new Oficina();
    }
    
    public int eliminarOficina(String codOficina)
    {
    	log.info("[OficinaDao :: eliminarOficina] Inicio");
    	
        String sql = "DELETE FROM tiido_oficina WHERE COD_OFIC = '" + codOficina + "'";
        log.debug("Fin eliminarOficina");
        
        log.info("[OficinaDao :: eliminarOficina] Fin");
        return getJdbcTemplate().update(sql);
    }
    
    
    private static final class OficinaMapper implements RowMapper
    {
    	private Logger log = Logger.getLogger(OficinaMapper.class);
    	
    	public Object mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            Territorio territorio = new Territorio();
            Oficina oficina = new Oficina();
            
            log.info("[OficinaMapper :: mapRow] Inicio");
            
            territorio.setCodTerr(rs.getString("cod_terr"));
            oficina.setCodOfic(rs.getString("cod_ofic"));
            oficina.setNomOficina(rs.getString("nom_ofic"));
            oficina.setEstado(rs.getString("estado"));
            oficina.setTerr(territorio);
            
            log.info("[OficinaMapper :: mapRow] Fin");
            
            return oficina;
        }
    }

    private static final class OficinaMapper1 implements RowMapper
    {
    	private Logger log = Logger.getLogger(OficinaMapper1.class);
    	
    	public Object mapRow(ResultSet rs, int rowNum) throws SQLException
        {
    		Oficina oficina = new Oficina();
    		
    		log.info("[OficinaMapper1 :: mapRow] Inicio");
    		
            oficina.setCodOfic(rs.getString(1));
            oficina.setCodTerritorio(rs.getString(2));
            oficina.setCodNomOficina(rs.getString(1) + " - " + rs.getString(3));
            oficina.setEstado(rs.getString("estado"));
            
            log.info("[OficinaMapper1 :: mapRow] Fin");
            return oficina;
        }
    }

    private static final class OficinaMapper2 implements RowMapper
    {
    	private Logger log = Logger.getLogger(OficinaMapper2.class);
    	
    	public Object mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            Oficina oficina = new Oficina();
            
            log.info("[OficinaMapper2 :: mapRow] Inicio");
            
            oficina.setCodOfic(rs.getString(1));
            oficina.setCodTerritorio(rs.getString(2));
            oficina.setCodNomOficina(rs.getString(3));
            oficina.setEstado(rs.getString("estado"));
            
            log.info("[OficinaMapper2 :: mapRow] Fin");
            return oficina;
        }
    }
    
    private static final class OficinaMapper3 implements RowMapper
    {
    	private Logger log = Logger.getLogger(OficinaMapper3.class);
    	
    	public Object mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            Oficina oficina = new Oficina();
            
            log.info("[OficinaMapper3 :: mapRow] Inicio");
            
            oficina.setCodOfic(rs.getString(1));
            oficina.setCodNomOficina(rs.getString(2));
            oficina.setEstado(rs.getString("estado"));
            
            log.info("[OficinaMapper3 :: mapRow] Fin");
            return oficina;
        }
    }
}
