
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<TITLE></TITLE>

<%
String temp = (String)request.getAttribute("fechas");
String[] fechas = new String[5];
String[] lTipos = {"Planificación","Reporte PPG","Seguimiento 1","Cierre"};
String lTiposSeleccionado = (String)request.getAttribute("lTiposSeleccionado");
String lAnioSeleccionado = (String)request.getAttribute("lAnioSeleccionado");
if(temp!=null){
	fechas = temp.split(",");
}

String modo = (String)request.getAttribute("modo");
if(modo==null) modo="1";

String file = (String)request.getAttribute("file");
temp="";
 %>
 
<script language="JavaScript">
function consultar(){
	var b = document.getElementById("botonEnvio");
	document.consulta.accion.value = "C";
	b.value="Procesando...";
	b.disabled=true;
	document.consulta.submit();
}
function descargar(f){
	document.consulta.accion.value = "D";
	document.consulta.file.value = f;
	document.consulta.target="_SELF";
	document.consulta.submit();
}
function nuevo(){
	location.href='actionReportesMant.do';
}
</script>

</HEAD>
<BODY>

<form name="consulta" action="actionReportesMant.do" method="post">
<input type="hidden" name="accion" value="" />
<input type="hidden" name="file" value="" />
<table border="0" width="50%" align="center" cellspacing="1" cellpadding="4">
<tr>
	<td class="TituloPag" colspan="2" align="center">
	EXPORTACION DE REPORTES
	</td>
</tr>
<tr>
	<td width="40%">Opci&oacute;n</td>
	<td>
	<select name="tipo">
	<% for(int i=0;i<lTipos.length; i++){
		if(lTiposSeleccionado!=null){
			if(lTipos[i].equals(lTiposSeleccionado))
				temp=" selected";
			else
				temp="";
		}
	%>
	<option<%=temp %> value=<%=i%>><%=lTipos[i] %></option>
	<% } %>
	</select>
	</td>
</tr>
<tr>
	<td>A&ntilde;o</td>
	<td>
	<select name="anio">
	<% for(int i=0;i<fechas.length; i++){
		if(lAnioSeleccionado!=null){
			if(fechas[i].equals(lAnioSeleccionado))
				temp=" selected";
			else
				temp="";
		}
	%>
	<option<%=temp %>><%=fechas[i] %></option>
	<% } %>
	</select>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
	<% if(modo.equals("2")){ %>
		<% if(file!=null){ %>
			<a href="javascript:void(0);" onClick="descargar('<%=file %>');">Descargar resultados en Excel</a>
		<% } else { %>
			No se encontraron resultados.
		<% } %>
	<% } %>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="button" id="botonEnvio" value="Consultar" onClick="consultar();">
	</td>
</tr>
</table>
</form>

</BODY>
</html:html>
