<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="com.stefanini.pe.framework.collections.DataTable"%>
<%@page import="com.stefanini.pe.framework.collections.DataRow"%>
<%@page import="com.stefanini.pe.framework.collections.DataColumn"%>
<%@page import="java.util.Iterator"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'
	type="text/css">
<title>Carpetas Comerciales</title>
<%DataTable listaEtiquetaSegmento = (DataTable)request.getAttribute("listaEtiquetaSegmento");
String cantidadSegmentos=(String)request.getAttribute("cantidadSegmentos");
int i=0;
int j=0;

int segmentos= Integer.parseInt(cantidadSegmentos);
 %>
</head>
<body>
<p align="center" class="TituloPagServGen">ETIQUETAS Y SEGMENTOS</p>

<center>

<table cellspacing="0" cellpadding="0" align="center" border="1">    

<% 	
	if(listaEtiquetaSegmento!=null){
		String colorfila = "";
				for (Iterator it = listaEtiquetaSegmento.getColumnas().iterator(); it.hasNext();) {
				DataColumn column = (DataColumn) it.next();
				i++;
				j=0;
				%>
			 <%if (i%2 == 0) { %>
			<tr class="FondoGris1">
			<%} else { %>
			<tr class="FondoGris2">
			<% } %>
					<td><strong><%=column.getColumnName()%></strong>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				 	<%for (Iterator jt = listaEtiquetaSegmento.getFilas().iterator(); jt.hasNext();) { 
				 	DataRow row = (DataRow) jt.next();
				 	%>
				 	<td align="center">&nbsp;&nbsp;<%=row.get(column.getColumnName()) %>&nbsp;&nbsp;</td>
					<%j++;}%>
					
			</tr>
		<%}
	}
%>
</table>
</center>
</body>
</html:html>

