package pe.com.indra.component.model;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

public class AbstractSQL {
	protected static Logger log = Logger.getLogger(AbstractSQL.class);
	protected static  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private InitialContext initialContext;
	private DataSource dataSource;
	private Connection cnn = null;
	private CallableStatement stm = null;
		
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public AbstractSQL() {
		log.info("AbstractSQL:Inicializando...");
		
		try {
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.debug("[AbstractSQL] initialContext null");
			}
			
			dataSource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
		} catch (NamingException e) {
			log.error("[AbstractSQL] initialContext NamingException", e);
		}
	}

	protected List<MetaData> getMetadata(ResultSet result) {
		List<MetaData> cols = new ArrayList<MetaData>();
		int i = 0;
		MetaData o = null;
		if(result != null) {
			try {
				ResultSetMetaData metaData = result.getMetaData();
				
				for(i = 1; i <= metaData.getColumnCount(); i++) {
					o = new MetaData();
					o.setColumnName(metaData.getColumnName(i));
					o.setColumnType(metaData.getColumnType(i));
					cols.add(o);
				}
			} catch (SQLException e) {
				log.error("[INDRA:AbstractSQL:getMetadata] initialContext SQLException", e);
			}			
		}
		
		return cols;
	}

	protected int executeProcedureToInt(String procedure, Object[] parameters) {
		int i = 0;
		int indexOut = 0;
		cnn = null;
		stm = null;
		int result = -1;
		try {
			String query;
			String criterio = "";
			
			if (parameters != null && parameters.length > 0) {
				for(i = 0; i <= parameters.length; i++) {
					if(criterio.length() > 0) criterio += ",";
					criterio += "?";
				}
			}
			
			query = "{call " + procedure + "(" + criterio + ")}";
			log.debug("INDRA:AbstractSQL:executeProcedure:{" + query + "}");

			cnn = dataSource.getConnection();
			stm = cnn.prepareCall(query);
			
			if (parameters != null && parameters.length > 0) {
				Object o = null;
				for (i = 1; i <= parameters.length; i++) {
					o = parameters[i - 1];
					if (o instanceof String) {
						stm.setString(i, (String) o);
						log.debug("STRING :: " + i + " - " + o);
					} else if (o instanceof BigDecimal) {
						stm.setBigDecimal(i, (BigDecimal) o);
						log.debug("BIGDECIMAL :: " + i + " - "  + o);
					} else if (o instanceof Date) {
						stm.setDate(i, (Date) o);
						log.debug("DATE :: " + i + " - "  + o);
					} else {
						stm.setObject(i, o);
						log.debug("OBJECT :: " + i + " - "  +o);
					}
				}
			}
			
			indexOut = parameters.length + 1;
			stm.registerOutParameter(indexOut, OracleTypes.INTEGER);
			stm.execute();
			result = stm.getInt(indexOut);
		} catch (Exception ex) {
			log.error("INDRA:AbstractSQL:executeProcedure", ex);
		} 
		
		return result;
	}
	
	protected ResultSet executeProcedure(String procedure, Object[] parameters) {
		int i = 0;
		int out = 0;
		cnn = null;
		stm = null;
		ResultSet result = null;
		try {
			String query;
			String criterio = "";
			
			if (parameters != null && parameters.length > 0) {
				for(i = 0; i <= parameters.length; i++) {
					if(criterio.length() > 0) criterio += ",";
					criterio += "?";
				}
			}
			
			query = "{call " + procedure + "(" + criterio + ")}";
			log.debug("INDRA:AbstractSQL:executeProcedure:{" + query + "}");

			cnn = dataSource.getConnection();
			stm = cnn.prepareCall(query);
			
			if (parameters != null && parameters.length > 0) {
				Object o = null;
				for (i = 1; i <= parameters.length; i++) {
					o = parameters[i - 1];
					if (o instanceof String) {
						stm.setString(i, (String) o);
						log.debug("STRING :: " + i + " - " + o);
					} else if (o instanceof BigDecimal) {
						stm.setBigDecimal(i, (BigDecimal) o);
						log.debug("BIGDECIMAL :: " + i + " - "  + o);
					} else if (o instanceof Date) {
						stm.setDate(i, (Date) o);
						log.debug("DATE :: " + i + " - "  + o);
					} else {
						stm.setObject(i, o);
						log.debug("OBJECT :: " + i + " - "  +o);
					}
				}
			}
			
			out = parameters.length + 1;
			
			stm.registerOutParameter(out, OracleTypes.CURSOR);
			stm.execute();
			result = (ResultSet) stm.getObject(out);
		} catch (Exception ex) {
			log.error("INDRA:AbstractSQL:executeProcedure", ex);
		} 
		
		return result;
	}
	
	protected ResultSet executeProcedure(String procedure, HashMap<String, Object> parameters, String out) {
		int i = 0;
		cnn = null;
		stm = null;
		ResultSet result = null;
		try {
			String query;
			String criterio = "";
			
			if (parameters != null && !parameters.isEmpty()) {
				for(i = 0; i <= parameters.size(); i++) {
					if(criterio.length() > 0) criterio += ",";
					criterio += "?";
				}
			} else {
				if(out != null && out.length() > 0) {
					criterio += "?";
				}
			}
			
			query = "{call " + procedure + "(" + criterio + ")}";
			log.debug("INDRA:AbstractSQL:executeProcedure:{" + query + "}");

			cnn = dataSource.getConnection();
			stm = cnn.prepareCall(query);
			
			if (parameters != null && !parameters.isEmpty()) {
				for (Entry<String, Object> entry : parameters.entrySet()) {
					if (entry.getValue() instanceof String) {
						stm.setString(entry.getKey(), (String) entry.getValue());
						if(entry.getValue() != null) log.debug("STRING :: " + entry.getKey() + " - " + entry.getValue().toString());
					} else if (entry.getValue() instanceof BigDecimal) {
						stm.setBigDecimal(entry.getKey(), (BigDecimal) entry.getValue());
						if(entry.getValue() != null) log.debug("BIGDECIMAL :: " + entry.getKey() + " - "  + entry.getValue().toString());
					} else if (entry.getValue() instanceof Date) {
						stm.setString(entry.getKey(), formatter.format(entry.getValue()));
						if(entry.getValue() != null) log.debug("DATE :: " + entry.getKey() + " - "  + formatter.format(entry.getValue()));
					} else if (entry.getValue() instanceof java.util.Date) {
						stm.setString(entry.getKey(), formatter.format(entry.getValue()));
						if(entry.getValue() != null) log.debug("DATE :: " + entry.getKey() + " - "  + formatter.format(entry.getValue()));
					} else {
						stm.setObject(entry.getKey(), entry.getValue());
						if(entry.getValue() != null) log.debug("OBJECT :: " + entry.getKey() + " - "  + entry.getValue().toString());
					}
				}
			}
			
			stm.registerOutParameter(out, OracleTypes.CURSOR);
			stm.execute();
			result = (ResultSet) stm.getObject(out);
		} catch (Exception ex) {
			log.error("INDRA:AbstractSQL:executeProcedure", ex);
		} 
		
		return result;
	}
	
	protected int executeProcedure(String procedure, HashMap<String, Object> parameters) {
		int i = 0;
		cnn = null;
		stm = null;
		int result = -1;
		try {
			String query;
			String criterio = "";
			
			if (parameters != null && !parameters.isEmpty()) {
				for(i = 0; i < parameters.size(); i++) {
					if(criterio.length() > 0) criterio += ",";
					criterio += "?";
				}
			}
			
			query = "{call " + procedure + "(" + criterio + ")}";
			log.debug("INDRA:AbstractSQL:executeProcedure:{" + query + "}");

			cnn = dataSource.getConnection();
			stm = cnn.prepareCall(query);
			
			if (parameters != null && !parameters.isEmpty()) {
				for (Entry<String, Object> entry : parameters.entrySet()) {
					if (entry.getValue() instanceof String) {
						stm.setString(entry.getKey(), (String) entry.getValue());
						if(entry.getValue() != null) log.debug("STRING :: " + entry.getKey() + " - " + entry.getValue().toString());
					} else if (entry.getValue() instanceof BigDecimal) {
						stm.setBigDecimal(entry.getKey(), (BigDecimal) entry.getValue());
						if(entry.getValue() != null) log.debug("BIGDECIMAL :: " + entry.getKey() + " - "  + entry.getValue().toString());
					} else if (entry.getValue() instanceof Date) {
						stm.setString(entry.getKey(), formatter.format(entry.getValue()));
						if(entry.getValue() != null) log.debug("DATE :: " + entry.getKey() + " - "  + formatter.format(entry.getValue()));
					} else if (entry.getValue() instanceof java.util.Date) {
						stm.setString(entry.getKey(), formatter.format(entry.getValue()));
						if(entry.getValue() != null) log.debug("DATE :: " + entry.getKey() + " - "  + formatter.format(entry.getValue()));
					} else {
						stm.setObject(entry.getKey(), entry.getValue());
						if(entry.getValue() != null) log.debug("OBJECT :: " + entry.getKey() + " - "  + entry.getValue().toString());
					}
				}
			}
			
			stm.execute();
			result = 1;
		} catch (Exception ex) {
			log.error("INDRA:AbstractSQL:executeProcedure", ex);
			result = -1;
		} finally {
			this.close();
		}
		
		return result;
	}
	
	protected ResultSet executeQuery(String query) {
		cnn = null;
		stm = null;
		ResultSet result = null;
		try {
			log.debug("INDRA:AbstractSQL:executeQuery:{" + query + "}");

			cnn = dataSource.getConnection();
			stm = cnn.prepareCall(query);
			result = stm.executeQuery();
		} catch (Exception ex) {
			log.error("INDRA:AbstractSQL:executeQuery", ex);
		} 
		
		return result;
	}
	
	protected boolean execute(String query) {
		cnn = null;
		stm = null;
		boolean result = false;
		try {
			log.debug("INDRA:AbstractSQL:execute:{" + query + "}");

			cnn = dataSource.getConnection();
			stm.executeUpdate(query);
			this.close();
			result = true;
			
		} catch (Exception ex) {
			log.error("INDRA:AbstractSQL:execute", ex);
		} 
		
		return result;
	}
	
	public void close() {
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException ex) {
			log.error("INDRA:AbstractSQL:close", ex);
		}
		try {
			if (cnn != null) {
				cnn.close();
			}
		} catch (SQLException ex) {
			log.error("INDRA:AbstractSQL:close", ex);
		}
	}
}
