<%@page import="java.util.zip.ZipEntry"%>
<%@page import="java.util.zip.ZipOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO"%>

<%
ConexionDAO cnn = new ConexionDAO();
String archivo = request.getParameter("archivo");
String path = cnn.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";

response.setContentType("application/octet-stream");
response.setHeader ("Content-Disposition", "attachment; filename=" + archivo.replaceAll("xls", "zip"));

try {
	ServletOutputStream outZIP = response.getOutputStream();
	
	String inputFile = path + archivo.replaceAll("xls", "zip");
	String xlsFile = path + archivo;
	FileInputStream inXLS = new FileInputStream(xlsFile);
	File zipFile = File.createTempFile(archivo.replaceAll("xls", "zip"), ".tmp") ;
	
	ZipOutputStream zipOUT = new ZipOutputStream(outZIP);
	ZipEntry entry = new ZipEntry(archivo);
	zipOUT.putNextEntry(entry);
	
	byte b[] = new byte[2048];
	int len = 0;
	
	while ((len = inXLS.read(b)) != -1) {
		zipOUT.write(b, 0, len);
	}
	
	zipOUT.closeEntry();
	zipOUT.close();
	
	zipFile.delete();
} catch (Exception e) {
	out.write(e.getMessage());
}
%>