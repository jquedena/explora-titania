package pe.com.indra.component.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class AbstractSQL {
	protected static Logger log = Logger.getLogger(AbstractSQL.class);
	private DataSource dataSource;
	private Connection cnn = null;
	private Statement stm = null;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public AbstractSQL() {
		log.info("AbstractSQL:Inicializando...");
	}

	protected ResultSet findByParams2(String tableName,
			HashMap<String, Object> parameters) throws DataAccessException {
		cnn = null;
		stm = null;
		ResultSet result = null;
		try {
			StringBuilder sb_criteria = new StringBuilder(" ");
			String criteria = "";
			String query = "select * from " + tableName + " ";
			if (parameters != null && !parameters.isEmpty()) {
				sb_criteria.append(" where ");
				for (Entry<String, Object> entry : parameters.entrySet()) {
					if (entry.getValue() instanceof String) {
						sb_criteria.append(entry.getKey());
						sb_criteria.append(" '");
						sb_criteria.append(entry.getValue());
						sb_criteria.append("' and ");
					} else {
						sb_criteria.append(entry.getKey());
						sb_criteria.append(" ");
						sb_criteria.append(entry.getValue());
						sb_criteria.append(" and ");
					}
				}
				criteria = sb_criteria.toString().trim();
				criteria = criteria.substring(0, criteria.length() - 3);
			}
			log.info("INDRA:AbstractSQL:findByParams2:{" + query + criteria + "}");

			cnn = dataSource.getConnection();
			stm = cnn.createStatement();
			result = stm.executeQuery(query + criteria);

		} catch (Exception ex) {
			log.error("INDRA:AbstractSQL:findByParams2", ex);
			throw new DataAccessException("INDRA:AbstractSQL:findByParams2", ex);
		} 
		
		return result;
	}
	
	public void close() {
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException ex) {
			log.error("INDRA:AbstractSQL:findByParams2", ex);
		}
		try {
			if (cnn != null) {
				cnn.close();
			}
		} catch (SQLException ex) {
			log.error("INDRA:AbstractSQL:findByParams2", ex);
		}
	}
}
