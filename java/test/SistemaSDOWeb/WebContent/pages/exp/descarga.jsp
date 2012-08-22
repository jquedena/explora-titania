<%
//import java.io.*;

//String name = "I100121.060915.163000.X75";
String name = (String)request.getAttribute("file");
String rootpath = (String)request.getAttribute("rootpath");
String nombreSalida = (String)request.getAttribute("nombreSalida");
if (nombreSalida==null) nombreSalida=name;

//response.setContentType ("application/download");
response.setContentType ("application/ms-excel");
response.setHeader ("Content-Disposition", "attachment; filename=" + nombreSalida);
javax.servlet.ServletOutputStream op = response.getOutputStream ();
String root = rootpath + "/";

java.io.InputStream in = null;
byte[] buf = new byte[response.getBufferSize()];
try 
{
	java.io.File file = new java.io.File(root+name);
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