<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO"%>

<%
ConexionDAO cnn = new ConexionDAO();
String archivo = request.getParameter("archivo");
String path = cnn.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";

response.setContentType ("text/plain");
response.setHeader ("Content-Disposition", "attachment; filename=" + archivo);
javax.servlet.ServletOutputStream op = response.getOutputStream ();

java.io.InputStream in = null;
byte[] buf = new byte[response.getBufferSize()];
try {
	java.io.File file = new java.io.File(path + archivo);
	response.setContentLength((int)file.length());
	in = new java.io.BufferedInputStream (new java.io.FileInputStream(file) );
	int length;
	
	while ((in != null) && ((length = in.read(buf)) != -1)) {
		op.write(buf,0,length);
	}
} 
finally {
	if (in != null) in.close();
}
%>