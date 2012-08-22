package pruebaBd;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;


public class TestBD {
	public static SimpleDateFormat formatter=  new SimpleDateFormat("yyyyMMdd");
	public static Calendar cal = Calendar.getInstance();
	public static void main(String[] args) throws ParseException {
		Connection conn = null;
		 String password = "";
		 String url = "";
		 String esquema="IIDO";
		 String nomTabla="TIIDO_TERRITORIO";

		try {
			/*
			ctxTempLog = new InitialContext();
		     dsTempLog = (DataSource)ctxTempLog.lookup("jdbc/dbSERV");
		     cnTempLog = dsTempLog.getConnection();
		     */

			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
		 	password = "IIDO";
		 	
		 	conn = DriverManager.getConnection(url, "IIDO", password);
		 	 
		 	@SuppressWarnings("unused")
			java.util.ResourceBundle resource=null;
		 	
			String query =
			"Select * "+ 
			"From " + esquema.trim() + "." + nomTabla.trim();
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			String datos="";
			String queryInsert="";
			while (rs.next()) {
				
				datos = rs.getString(1)+", " + rs.getString(2);

				queryInsert = queryInsert + "\n" + datos;
			}
			rs.close();
			conn.close();
			
			printToExportFile(queryInsert.getBytes(),nomTabla+".csv");
						
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printToExportFile(byte[] trama,String nombre){
	    File f = null;
	    
	    
	    //if (Constante.CONSTANTE_OS.equals("1")){
	    	f=new File("C:/" +formatter.format(cal.getTime()) ); 
		    f.mkdir(); 
	        String archivo = "C:/"+ formatter.format(cal.getTime())+"/"+nombre;
			f = new File(archivo);
		//}
	    
		try {
			FileOutputStream st = new FileOutputStream(f);
			st.write(trama);
			st.close();
			f = null;
			st = null;
		} catch (Exception e) {
			
		}
	}
	
	public static String[] getArrayStrings(String cadena,String delim){
		if (isStringBlank(cadena))
			return new String[0];
		
		StringTokenizer st = new StringTokenizer(cadena,delim);
		String[] array = new String[st.countTokens()];
		int indice = 0;
		while (st.hasMoreTokens()) {
			array[indice] = st.nextToken();
			indice++;
		}
		return array;
	}
	
	public static boolean isStringBlank(String cadena){
		boolean b = false;
		if (cadena == null || cadena.trim().length()==0)
			b = true;
		
		return b;
	}
}