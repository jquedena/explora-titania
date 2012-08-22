package pe.com.bbva.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import pe.com.indra.component.model.AbstractSQL;
import pe.com.indra.component.model.MetaData;

public class ReporteIngresoDAO extends AbstractSQL {

	public static final int REPORTE_DIARIO = 0;
	public static final int REPORTE_MENSUAL = 1;
	public static final int REPORTE_ANUAL = 2;
	public static final int REPORTE_POR_GESTOR = -1;
	public static final int REPORTE_POR_OFICINA = -2;
	public static final int REPORTE_POR_TERRITORIO = -3;
	private static final String CAMPOS_FIJOS = "A.COD_TERR,A.TIPO_FORM,A.COD_USUARIO,A.NOMBRES,A.CARGO,A.TERRITORIO,A.COD_OFI,A.DESC_OFI,A.COD_OFICINA_M,A.NOM_OFIC_M,A.COD_GESTOR_M,A.NOM_GESTOR_M,A.TIPO";
	private List<MetaData> cols;
	
	public ReporteIngresoDAO() {
		log.info("ReporteIngresoDAO:Inicializando...");
	}
	
	public List<MetaData> getCols() {
		return cols;
	}

	private String crearCabeceraMovil(long tipoPeriodo, int mes, int anio, String codTerritorio, String codOficina, int dia) {
		
		String query = "";
		String result = "";
		
	    if(tipoPeriodo == ReporteIngresoDAO.REPORTE_MENSUAL){
	    	query += "SELECT 'DECODE(A.TIPO_FORM, 0, TO_CHAR(SUM(DECODE(A.FECHA, ''' || AX.FECHA2 || ''', DECODE(A.TIPO_FORM, 0, TO_NUMBER(A.CTA), 0), 0))), MAX(DECODE(A.FECHA, ''' || AX.FECHA2 || ''', DECODE(A.TIPO_FORM, 0, '' '', A.CTA), '' ''))) D_' || AX.FECHA2 CAMPO FROM ( ";
	    	query += "SELECT TO_CHAR(A.FECHA, 'DDMMYYYY') FECHA2 FROM IIDO.VIIDO_FECHAS A  ";
	    	query += "WHERE (A.MES = " + mes + " AND A.ANIO = " + anio + ") ";
	    	query += "GROUP BY TO_CHAR(A.FECHA, 'DDMMYYYY') ";
	    	query += ") AX ORDER BY TO_DATE(AX.FECHA2, 'DDMMYYYY')";
	    };
	    
	    if(tipoPeriodo == ReporteIngresoDAO.REPORTE_ANUAL){
	    	query += "SELECT 'DECODE(A.TIPO_FORM, 0, TO_CHAR(SUM(DECODE(A.MESANIO, ''' || AX.FECHA2 || ''', DECODE(A.TIPO_FORM, 0, TO_NUMBER(A.CTA), 0), 0))), MAX(DECODE(A.MESANIO, ''' || AX.FECHA2 || ''', DECODE(A.TIPO_FORM, 0, '' '', A.CTA), '' ''))) M_' || AX.FECHA2 CAMPO FROM ( ";
	    	query += "SELECT TO_CHAR(A.FECHA, 'MMYYYY') FECHA2 FROM IIDO.VIIDO_FECHAS A "; 
	    	query += "WHERE A.ANIO = " + anio + " ";
	    	query += "GROUP BY TO_CHAR(A.FECHA, 'MMYYYY') ";
	    	query += ") AX ORDER BY TO_DATE(AX.FECHA2, 'MMYYYY')";
	    };

	    if(tipoPeriodo == ReporteIngresoDAO.REPORTE_DIARIO){
	    	query += "SELECT 'DECODE(A.TIPO_FORM, 0, TO_CHAR(SUM(DECODE(A.FECHA, ''' || AX.FECHA2 || ''', DECODE(A.TIPO_FORM, 0, TO_NUMBER(A.CTA), 0), 0))), MAX(DECODE(A.FECHA, ''' || AX.FECHA2 || ''', DECODE(A.TIPO_FORM, 0, '' '', A.CTA), '' ''))) D_' || AX.FECHA2 CAMPO FROM ( ";
	    	query += "SELECT TO_CHAR(A.FECHA, 'DDMMYYYY') FECHA2 FROM IIDO.VIIDO_FECHAS A "; 
	    	query += "WHERE (A.MES = " + mes + " AND A.ANIO = " + anio + " AND TO_NUMBER(TO_CHAR(A.FECHA, 'DD')) = " + dia + " ) ";
	    	query += "GROUP BY TO_CHAR(A.FECHA, 'DDMMYYYY') ";
	    	query += ") AX ORDER BY TO_DATE(AX.FECHA2, 'DDMMYYYY')";
	    };
	    
	    ResultSet rss = this.executeQuery(query);
		
	    try {
	    	if(rss != null) {
				while(rss.next()) {
					if(result.length() > 0) result += ",";
					result += rss.getString("CAMPO");
				}
	    	}
		} catch (SQLException e) {
			log.error("[ReporteIngresoDAO::crearCabeceraMovil]", e);
		}
        
        this.close();
	    
		return result;
	}
	
    public List<Object[]> findIngreso(long tipoReporte, long tipoPeriodo, int mes, int anio, int dia, String codTerritorio, String codOficina) {
    	Object[] row;
        List<Object[]> rows = new ArrayList<Object[]>();
        ResultSet result;
        String query = "";
        String camposVariables = "";
        int i;
        try {
        	camposVariables = crearCabeceraMovil(tipoPeriodo, mes, anio, codTerritorio, codOficina, dia);
        	
            query += "SELECT ";
	        query += ReporteIngresoDAO.CAMPOS_FIJOS;
	        
	        if(camposVariables.trim().length() > 0)
	        	query += ",";
	        
	        query += camposVariables;
	        query += ",SUM(DECODE(A.TIPO_FORM, 0, TO_NUMBER(A.CTA), DECODE(LENGTH(A.CTA), 0, 0, 1))) TOTAL FROM IIDO.VIIDO_INGRESOS_MODIFICADOS A ";
	        query += "WHERE A.ANIO=" + anio;
	        
	        if(tipoPeriodo == ReporteIngresoDAO.REPORTE_DIARIO) 
	        	query += " AND (A.MES=" + mes + " AND TO_NUMBER(SUBSTR(A.FECHA, 1, 2))=" + dia + ")";
	        
	        if(tipoPeriodo == ReporteIngresoDAO.REPORTE_MENSUAL) 
	        	query += " AND (A.MES=" + mes + " OR A.MES=" + (mes + 1) + ")";
	          
	        if(codTerritorio.trim().length() > 0)
	        	query += " AND A.COD_TERR='" + codTerritorio + "'";
	        
	        if(codOficina.trim().length() > 0)
	        	query += " AND A.COD_OFI='" + codOficina + "'";

	        query += " GROUP BY " + CAMPOS_FIJOS;
	        
	        if(tipoReporte == ReporteIngresoDAO.REPORTE_POR_GESTOR)
	        	query += " ORDER BY A.COD_USUARIO, A.COD_OFI, A.TIPO_FORM";
	        
	        if(tipoReporte == ReporteIngresoDAO.REPORTE_POR_OFICINA)
	        	query += " ORDER BY A.COD_OFI, A.COD_USUARIO, A.TIPO_FORM";
	        
	        if(tipoReporte == ReporteIngresoDAO.REPORTE_POR_TERRITORIO)
	        	query += " ORDER BY A.COD_TERR, A.COD_OFI, A.COD_USUARIO, A.TIPO_FORM";
	      
        	result = this.executeQuery(query);
            
            cols = this.getMetadata(result);           
            while(result.next()) {
            	row = new Object[cols.size()];
            	
				for(i = 0; i < cols.size(); i++) {
					switch (cols.get(i).getColumnType()) {
					case Types.CHAR:
					case Types.VARCHAR:
						row[i] = result.getString(cols.get(i).getColumnName());
						break;
					case Types.DECIMAL:
					case Types.DOUBLE:
						row[i] = result.getBigDecimal(cols.get(i).getColumnName()).doubleValue();
						break;
					case Types.INTEGER:
					case Types.BIGINT:
						row[i] = result.getBigDecimal(cols.get(i).getColumnName()).intValue();
						break;
					default:
						row[i] = result.getObject(cols.get(i).getColumnName()).toString();
						break;
					}
				}
				rows.add(row);
            }
            
            this.close();
        } catch (Exception e) {
            log.error("[ReporteIngresoDAO::findIngreso]", e);
        }
        return rows;
    }
}
