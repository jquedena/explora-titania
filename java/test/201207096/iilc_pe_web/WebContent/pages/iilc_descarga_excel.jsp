<%
String archivo = (String)request.getSession().getAttribute("exportacion_archivo");
String ruta = (String)request.getSession().getAttribute("exportacion_ruta");

response.setContentType ("text/plain");
response.setHeader ("Content-Disposition", "attachment; filename=" + archivo);
javax.servlet.ServletOutputStream op = response.getOutputStream ();
//String root = rootpath;
java.io.InputStream in = null;
byte[] buf = new byte[response.getBufferSize()];
try 
{
	//java.io.File file = new java.io.File(root+name);
	java.io.File file = new java.io.File(ruta+archivo);
	response.setContentLength((int)file.length());
	in = new java.io.BufferedInputStream (new java.io.FileInputStream(file) );
	int length;
	
	while ((in != null) && ((length = in.read(buf)) != -1))
	{
		op.write(buf,0,length);
	}
} 
finally 
{
	if (in != null) in.close();
}


%>