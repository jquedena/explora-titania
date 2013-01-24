<%@ page import="pe.com.titania.jasper.Constante"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=Constante.TITLE%></title>
</head>
<body>
<%
File[] reportList = null;
File reportJasper = null;
try {
	File reportDir = new File(Constante.PATH_JRXML); 
	if(reportDir.isDirectory()) { 
		reportList = reportDir.listFiles(); 
	}
} catch(Exception e) {
	out.println("Error al abrir el directorio.");
}
%>
<form method="post" action="CompileFile.do">
<table style="width: 620px;" border="1" cellpadding="0" cellspacing="0a">
<tr>
	<th style="width: 300px;">Archivo jrmxl</th>
	<th style="width: 300px;">Archivo jasper</th>
	<th style="width: 20px;">&nbsp;</th>
</tr>
<%
	if(reportList != null) {
		for(File report : reportList) {
			// if(!report.isDirectory() && report.getName().indexOf(".jrmxl") > -1) {
				reportJasper = new File(Constante.PATH_JASPER + "/" + report.getName().replaceAll(".jrxml", ".jasper"));
%>
<tr>
	<td><%=report.getName()%></td>
	<td>
	<%
		if(reportJasper.exists()) {
			out.println(reportJasper.getName());
		} else {
			out.println("&nbsp;");	
		}
	%>
	</td>
	<td>
	<%
		out.println("<input type='checkbox' id='" + reportJasper.getName().replaceAll(".jasper", "") + "' name='" + reportJasper.getName().replaceAll(".jasper", "") + "'>");
	%>
	</td>
</tr>
<%
			}
		// }
	}
%>
</table>
<input type="submit" value="Compilar">
</form>
</body>
</html>