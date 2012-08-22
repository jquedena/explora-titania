package indra.bbva.pizele.persistence;

import indra.bbva.iiwx.domain.base.LDAPPERU2;
import indra.bbva.pizele.domain.base.Parametro;
import indra.bbva.pizele.service.ParametroService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("ldapPeru2PersistenceImpl")
public class LDAPPERU2PersistenceImpl implements LDAPPERU2Persistence {

	private static final long serialVersionUID = 1L;
	private static final Long CARGOS_GERENTES = 45L;
	private static final Long CARGOS_SIN_SUBGERENTES = 46L;
	private static final Long CARGOS_USUARIOS = 47L;
	
	private Logger log = Logger.getLogger(this.getClass());
	private Connection cnn = null;
	private Statement stm = null;
	
	@Autowired
	@Qualifier("dataSourceIIWX")
	private DataSource datasource;
	
	@Autowired
	private ParametroService parametro;
	
	private void open() {
		try {
			cnn = datasource.getConnection();
			stm = cnn.createStatement();
		} catch (SQLException ex) {
			log.error("INDRA:LDAPPERU2PersistenceImpl:open", ex);
			stm = null;
		}
	}
	
	private List<LDAPPERU2> read(String query) {
		List<LDAPPERU2> listaGestores = new ArrayList<LDAPPERU2>();
		LDAPPERU2 gestor;
		try {
			open();
			ResultSet result = null;
			if(stm != null) {
				result = stm.executeQuery(query);
				if(result != null) {
					while(result.next()) {
						gestor = new LDAPPERU2();
						gestor.setCodusu(result.getString("CODUSU"));
						gestor.setNombre(result.getString("NOMBRE"));
						gestor.setApepat(result.getString("APEPAT"));
						gestor.setApemat(result.getString("APEMAT"));
						gestor.setCargo(result.getString("CODCARGO"));
						gestor.setPerfil(result.getString("CODPERFIL"));
						listaGestores.add(gestor);
					}
				}
			}
			close();
		} catch(SQLException ex) {
			log.error("INDRA:LDAPPERU2PersistenceImpl:read", ex);
		}
		return listaGestores;
	}
	
	private void close() {
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException ex) {
			log.error("INDRA:LDAPPERU2PersistenceImpl:close", ex);
		}
		try {
			if (cnn != null) {
				cnn.close();
			}
		} catch (SQLException ex) {
			log.error("INDRA:LDAPPERU2PersistenceImpl:close", ex);
		}
	}
	
	public List<LDAPPERU2> obtenerDatosGerente(String codofi) {
		List<LDAPPERU2> result = new ArrayList<LDAPPERU2>();
		
		Parametro item = parametro.obtenerParametro(LDAPPERU2PersistenceImpl.CARGOS_GERENTES);
		String listaCargos = item != null ? item.getValorTexto() : "''";
		String query = "SELECT CODUSU, NOMBRE, APEPAT, APEMAT, CODCARGO, NULL CODPERFIL FROM IIWX.LDAPPERU2 WHERE CODOFI = '" + codofi + "' AND CODCARGO IN (" + listaCargos + ")";
		result = read(query);
		
		return result;
	}

	public List<LDAPPERU2> obtenerDatosUsuario(String codofi) {
		List<LDAPPERU2> result = new ArrayList<LDAPPERU2>();

		Parametro item = parametro.obtenerParametro(LDAPPERU2PersistenceImpl.CARGOS_USUARIOS);
		String listaCargos = item != null ? item.getValorTexto() : "''";
		String query = "SELECT CODUSU, NOMBRE, APEPAT, APEMAT, CODCARGO, NULL CODPERFIL FROM IIWX.LDAPPERU2 WHERE CODOFI = '" + codofi + "' AND CODCARGO IN (" + listaCargos + ")";
		result = read(query);
		
		return result;
	}

	public List<LDAPPERU2> obtenerDatosUsuarioSinSubGerente(String codofi) {
		List<LDAPPERU2> result = new ArrayList<LDAPPERU2>();

		Parametro item = parametro.obtenerParametro(LDAPPERU2PersistenceImpl.CARGOS_SIN_SUBGERENTES);
		String listaCargos = item != null ? item.getValorTexto() : "''";
		String query = "SELECT CODUSU, NOMBRE, APEPAT, APEMAT, CODCARGO, CODCARGO, " +
			   "(CASE UPPER(CODCARGO) " +
                  "WHEN 'B67' THEN 'EEM' " +
                  "WHEN 'B25' THEN 'GCO' " +
                  "WHEN 'B52' THEN 'GPE' " +
                  "WHEN 'B23' THEN 'EBP' " +
                  "ELSE 'XXX' " +
                "END) CODPERFIL FROM IIWX.LDAPPERU2 WHERE CODOFI = '" + codofi + "' AND CODCARGO IN (" + listaCargos + ")";
		result = read(query);
		
		return result;
	}

}