<%
String name = request.getParameter("file");

String rootpath = request.getParameter("rootpath");

response.setContentType ("text/plain");
response.setHeader ("Content-Disposition", "attachment; filename=" + name);
javax.servlet.ServletOutputStream op = response.getOutputStream ();
String root = rootpath;
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