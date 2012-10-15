<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.serializable.Multitabla"%><html>
<head>
<title>Carpeta Comercial - Detalle de Cliente</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
<style>
	* {
		font-size: 100%;
		font-family: Verdana,sans-serif;
		letter-spacing: .03em;
	}
	html {
		margin: 0pt auto;
	}
	body, 
	table,
	table.data,
	table.data tr td,
	table.data tr th {
		font-size: 88%;
		line-height: 16px;
		font-family: Verdana,sans-serif;
		margin: 3px;
		vertical-align:middle;
	}
	table.data tr td table tr td{
		font-size: 90%;
	}
	table.data tr th {
		color: #264971;
		padding: 3px;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
</head>
<body style="padding:0px;margin:0px;">
<table class="data" style="width: 100%;padding:0px;margin:0px;">
<tr class="FondoAzulPeq">
<td style="font-weight: bold;text-align: left;padding-left: 5px;line-height: 30px;vertical-align: middle;">DETALLE CLIENTE</td>
</tr>
<tr>
<td style="height: 8px;background-color: #5f76aa;"></td>
</tr>
<tr>
<td>
	<table style="width: 600px;">
	<tr>
		<td>${requestScope.codigo}: <b>${requestScope.cliente.codigo}</b></td>
		<td colspan="4">${requestScope.nombre}: <b>${requestScope.cliente.nombre}</b></td>
	</tr>
	<tr>
		<td>${requestScope.tipo_persona}: <b>${requestScope.cliente.tipo_persona}</b></td>
		<td>${requestScope.perfil}: <b>${requestScope.cliente.perfil}</b></td>
		<td>${requestScope.estcivil}: <b>${requestScope.cliente.estcivil}</b></td>
		<td>${requestScope.prefijo}: <b>${requestScope.cliente.prefijo}</b></td>
		<td>${requestScope.telefono}: <b>${requestScope.cliente.telefono}</b></td>
	</tr>
	<tr>
		<td>${requestScope.segment1}: <b>${requestScope.cliente.segment1}</b></td>
		<td colspan="4"><!--${requestScope.vinculacion}: <b>${requestScope.cliente.vinculacion}</b>-->&nbsp;</td>
	</tr>
	</table>
</td>
</tr>
<tr>
<td style="height: 8px;background-color: #5f76aa;"></td>
</tr>

<%
	int index = 0; 
	List titulo = (List) request.getAttribute("titulo"); 
	List cuerpo = (List) request.getAttribute("cuerpo");
	Multitabla[] detalle;
	String[][] result;
	String temp;
	String auxi;
	String colN = "";
	StringBuffer print;
	StringBuffer print2;
	StringBuffer print3;
	StringBuffer print4;
	int colspan;
	int cols;
	int i;
	int sw = 0;
	
	int numColsQuibre = 10; 
%>
<c:forEach items="${sessionScope.listadoRadios}" var="radio">
	<tr><td style="font-weight: bold;text-align: left;padding-left: 5px;line-height: 30px;vertical-align: middle;">
		<c:out value="${radio.descorta}"/>
	</td></tr>
	<tr><td>
	<% 
		detalle = (Multitabla[]) titulo.get(index);
		result = (String[][]) cuerpo.get(index);
		request.setAttribute("detalle", detalle); 
		request.setAttribute("result", result[0]); 
	%>
	<table cellpadding=0 cellspacing=0 border=1>
	<!-- Agrupacion -->
	<%
	temp = "***";
	colspan = 0;
	cols = 0;
	auxi = "";
	print = new StringBuffer();
	for(i = 0; i < detalle.length; i++) {
		colN = detalle[i].getValor3() == null ? "" : detalle[i].getValor3();
		auxi += colN;
		
		out.write("<!--");
		out.write(String.valueOf(detalle.length));
		out.write("-->");
		
		if(temp.equalsIgnoreCase("***")) temp = colN;
		if(!temp.equalsIgnoreCase(colN)) {
			print.append("<th colspan='");
			print.append(colspan);
			print.append("'>");
			print.append(temp);
			print.append("</th>");
			temp = colN;
			cols += colspan;
			colspan = 0;
		}
		
		colspan++;
		
		if((detalle.length > numColsQuibre) && (i > numColsQuibre) && index == 6) {
			sw = i;
			break;
		}
	}
	
	if(cols < detalle.length) {
		print.append("<th colspan='");
		print.append(colspan);
		print.append("'>");
		print.append(colN);
		print.append("</th>");
	}
	
	if(auxi.length() > 0 && print.toString().trim().length() > 0) {
		print.insert(0, "<tr>");
		print.append("</tr>");
		out.write(print.toString());
	}

	temp = "***";
	colspan = 0;
	cols = 0;
	auxi = "";
	print = new StringBuffer();
	print2 = new StringBuffer();
	print3 = new StringBuffer();
	for(i = 0; i < detalle.length; i++) {
		// Cabecera Normal
		print2.append("<th>");
		print2.append(detalle[i].getValor1());
		print2.append("</th>");
				
		// Detalle de Resultado
		print3.append("<td>");
		print3.append(result[0][i]);
		print3.append("</td>");
		
		// Agrupamiento 1
		colN = detalle[i].getValor2() == null ? "" : detalle[i].getValor2();
		auxi += colN;
		
		if(temp.equalsIgnoreCase("***")) temp = colN;
		if(!temp.equalsIgnoreCase(colN)) {
			print.append("<th colspan='");
			print.append(colspan);
			print.append("'>");
			print.append(temp);
			print.append("</th>");
			temp = colN;
			cols += colspan;
			colspan = 0;
		}
		
		colspan++;
		
		if((detalle.length > numColsQuibre) && (i > numColsQuibre) && index == 6) {
			break;
		}
	}
	
	if(cols < detalle.length) {
		print.append("<th colspan='");
		print.append(colspan);
		print.append("'>");
		print.append(colN);
		print.append("</th>");
	}
	
	if(auxi.length() > 0 && print.toString().trim().length() > 0) {
		print.insert(0, "<tr>");
		print.append("</tr>");
		out.write(print.toString());
	}
	
	print2.insert(0, "<tr>");
	print2.append("</tr>");
	out.write(print2.toString());
	
	print3.insert(0, "<tr>");
	print3.append("</tr>");
	out.write(print3.toString());
	
	if(index == 6 && sw > 0) {
		int init = 0;
		int j = 0;
		// int x = 0;
		while(sw < (detalle.length - 1) /*&& x < 3*/) {
		// x++;
			out.write("</table>");
			out.write("<table cellpadding=0 cellspacing=0 border=1>");
		
			temp = "***";
			colspan = 0;
			cols = 0;
			auxi = "";
			print = new StringBuffer();
			init = sw + 1;
			j = 0;
			
			for(i = init; i < detalle.length; i++) {
				colN = detalle[i].getValor3() == null ? "" : detalle[i].getValor3();
				auxi += colN;
				
				out.write("<!--");
				out.write(String.valueOf(detalle.length));
				out.write("-->");
				
				if(temp.equalsIgnoreCase("***")) temp = colN;
				if(!temp.equalsIgnoreCase(colN)) {
					print.append("<th colspan='");
					print.append(colspan);
					print.append("'>");
					print.append(temp);
					print.append("</th>");
					temp = colN;
					cols += colspan;
					colspan = 0;
				}
				
				colspan++;
				sw = i;
				j++;
				
				if(j > (numColsQuibre + 1)) {
					break;
				}
			}
		
		out.write("<!-- " + String.valueOf(sw) + " -->");
			
			if(cols < detalle.length) {
				print.append("<th colspan='");
				print.append(colspan);
				print.append("'>");
				print.append(colN);
				print.append("</th>");
			}
			
			if(auxi.length() > 0 && print.toString().trim().length() > 0) {
				print.insert(0, "<tr>");
				print.append("</tr>");
				out.write(print.toString());
			}
	
			temp = "***";
			colspan = 0;
			cols = 0;
			auxi = "";
			j = 0;
			print = new StringBuffer();
			print2 = new StringBuffer();
			print3 = new StringBuffer();
			for(i = init; i < detalle.length; i++) {
				// Cabecera Normal
				print2.append("<th>");
				print2.append(detalle[i].getValor1());
				print2.append("</th>");
						
				// Detalle de Resultado
				print3.append("<td>");
				print3.append(result[0][i]);
				print3.append("</td>");
				
				// Agrupamiento 1
				colN = detalle[i].getValor2() == null ? "" : detalle[i].getValor2();
				auxi += colN;
				
				if(temp.equalsIgnoreCase("***")) temp = colN;
				if(!temp.equalsIgnoreCase(colN)) {
					print.append("<th colspan='");
					print.append(colspan);
					print.append("'>");
					print.append(temp);
					print.append("</th>");
					temp = colN;
					cols += colspan;
					colspan = 0;
				}
				
				colspan++;
				j++;
				if(j > (numColsQuibre + 1)) {
					break;
				}
			}
			
			if(cols < detalle.length) {
				print.append("<th colspan='");
				print.append(colspan);
				print.append("'>");
				print.append(colN);
				print.append("</th>");
			}
			
			if(auxi.length() > 0 && print.toString().trim().length() > 0) {
				print.insert(0, "<tr>");
				print.append("</tr>");
				out.write(print.toString());
			}
			
			print2.insert(0, "<tr>");
			print2.append("</tr>");
			out.write(print2.toString());
			
			print3.insert(0, "<tr>");
			print3.append("</tr>");
			out.write(print3.toString());		
		}
	}
	%>

	</table>
	</td></tr>
	
	<tr>
	<td style="height: 8px;background-color: #5f76aa;"></td>
	</tr>
	
	<% index++; %>
</c:forEach>

</table>
</body>
</html>