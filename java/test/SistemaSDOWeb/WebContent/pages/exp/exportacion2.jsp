
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
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
/*
String temp = (String)request.getAttribute("fechas");
String[] fechas = new String[5];
if(temp!=null){
	fechas = temp.split(",");
}
*/
String temp = "";
String[] lOpcion = {"Mes","Año"};
String[] lCodMes = {"01","02","03","04","05","06","07","08","09","10","11","12"};
String[] lMes = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
String[] lTipo = {"Usuario","Oficina","Territorio"};
String lOpcionSeleccionado = (String) request.getAttribute("lOpcionSeleccionado");
String lMesSeleccionado = (String) request.getAttribute("lMesSeleccionado");
lMesSeleccionado = lMesSeleccionado.length() == 1 ? "0" + lMesSeleccionado : lMesSeleccionado;  
String lAnioSeleccionado = (String) request.getAttribute("lAnioSeleccionado");
String lTipoSeleccionado = (String) request.getAttribute("lTipoSeleccionado");
String modo = (String)request.getAttribute("modo");
String modoDia = (String)request.getAttribute("modoDia");
if(modo==null) modo="1";

String file = (String) request.getAttribute("file");
String fileDia = (String) request.getAttribute("fileDia");

String fechaHoy = (String) request.getAttribute("fechaHoy");
String contadorDia = (String) request.getAttribute("contadorDia");
// temp = "";
 %>
 
<script language="JavaScript">
function opcionFecha(){
	var o = document.getElementById("pMes");
	if(document.consulta.pOpcion.value=="2"){
		o.style.visibility = "hidden";
		o.style.position = "absolute";
	}
	else{
		o.style.visibility = "visible";
		o.style.position = "relative";
	}
}


function consultar(){
	var b = document.getElementById("botonEnvio");
	var b2 = document.getElementById("botonEnvio2");
	document.consulta.accion.value = "C";
	document.consulta.target="";
	b.value="Procesando...";
	b.disabled=true;
	b2.disabled=true;
	document.consulta.submit();
}
function descargar(f){
	document.consulta.accion.value = "D";
	document.consulta.file.value = f;
	document.consulta.target="_SELF";
	document.consulta.submit();
}

function diario(){
	window.open("actionReportesUsuario.do?accion=D2","_blank");
}

function consultarDia(){
	var b = document.getElementById("botonEnvio");
	var b2 = document.getElementById("botonEnvio2");
	document.consulta.accion.value = "D2";
	document.consulta.target="";
	b.value="Procesando...";
	b.disabled=true;
	b2.disabled=true;
	document.consulta.submit();
}

function nuevo(){
	location.href='actionReportesUsuario.do';
}
</script>

</HEAD>
<BODY onLoad="opcionFecha();">
<form name="consulta" action="actionReportesUsuario.do" method="post">
<input type="hidden" name="accion" value="" />
<input type="hidden" name="file" value="" />
<table border="0" align="center" cellspacing="1" cellpadding="4">
<tr>
	<td class="TituloPag" colspan="2" align="center">
	<b>INGRESO DE USUARIOS</b>
	</td>
</tr>
<tr>
	<td>Opci&oacute;n</td>
	<td>
	<select name="pOpcion" onChange="opcionFecha();">
	<% for(int i=0;i<lOpcion.length;i++){
	 	if(lOpcionSeleccionado!=null){
	 		if(String.valueOf(i + 1).equals(lOpcionSeleccionado))
	 			temp = " selected";
	 		else
	 			temp = "";
	 	}%>
	<option value="<%=(i + 1)%>"<%=temp %>><%=lOpcion[i] %></option>
	<% } %>
	</select>
	</td>
</tr>
<tr>
	<td>Fecha</td>
	<td>
	<select name="pMes" id="pMes">
		<% for(int i=0;i<lMes.length;i++){
		 	if(lMesSeleccionado!=null){
		 		if(String.valueOf(lCodMes[i]).equals(lMesSeleccionado))
		 			temp = " selected";
		 		else
		 			temp = "";
		 	}%>
		<option value="<%=(i+1) %>"<%=temp %>><%=lMes[i] %></option>
		<% } %>
	</select>
	<c:if test="${requestScope.listaAnio != null}">
		<html:select property="pAnio" value="${requestScope.lAnioSeleccionado}">
		<c:forEach items="${requestScope.listaAnio}" var ="anio" >
			<html:option value="${anio.codelem}">${anio.valor1}</html:option>
		</c:forEach>
		</html:select>
	</c:if>
	</td>
</tr>
<tr>
	<td>Tipo Reporte</td>
	<td>
	<select name="pTipo">
	<% for(int i=0;i<lTipo.length;i++){
	 	if(lTipoSeleccionado!=null){
	 		if(String.valueOf(-1 * (i + 1)).equals(lTipoSeleccionado))
	 			temp = " selected";
	 		else
	 			temp = "";
	 	}%>
	<option value="<%=(-1 * (i + 1))%>"<%=temp %>><%=lTipo[i] %></option>
	<% } %>
	</select>
	</td>
</tr>
<tr>
	<td>Archivo</td>
	<td>
	<% if(modo.equals("1")){ %>
		&nbsp;
	<% } else if(modo.equals("2")){ %>
		<% if(file!=null){ %>
			<a href="<%=request.getContextPath()%>/ExportarExcelReporteServlet?file=<%=file%>">Descargar resultados en Excel</a>
		<% } else { %>
			No se encontraron resultados.
		<% } %>
	<% } %>
	</td>
</tr>
<tr class="FondoGris1">
	<td colspan="2" align="center">
	<input type="button" id="botonEnvio" value="Generar Reporte" onClick="consultar();">
	</td>
</tr>
</table>

</form>
<br><br>
<table border="0" width="50%" align="center" cellspacing="1" cellpadding="4">
<tr>
	<td class="TituloPag" colspan="2" align="center">
	<b>INGRESOS DEL DIA</b>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
	Ingresos del <%=fechaHoy %> : <%=contadorDia %>
	<br>
	<% if(modoDia == null){ %>
		&nbsp;
	<% } else if(modoDia.equals("1")){ %>
		<% if(modoDia!=null){ %>
			<a style="font-size: 10px;" href="<%=request.getContextPath()%>/ExportarExcelReporteServlet?file=<%=fileDia%>">Descargar resultados en Excel</a>
		<% } else { %>
			No se encontraron resultados.
		<% } %>
	<% } %>
	<br><br>
	<input type="button" id="botonEnvio2" value="Generar Reporte" onClick="consultarDia();">
	</td>
</tr>
</table>

</BODY>
</html:html>