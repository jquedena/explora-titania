<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href='/iilc_pe_web"/theme/IIRGEspacio2.css' rel="stylesheet"
	type="text/css">
<TITLE>Carpetas Comerciales</TITLE>
<style type="text/css">
		<!--
		body {
			margin: 0px;
			font-family: Arial, Sans-serif;
		}
		table {	
			background-position: right 78px;
			background-repeat: no-repeat;
		}
		h1 {
			margin-left:60px;
			margin-top: 20px;
			margin-bottom: 40px;
			color: white;
			font-style: italic;
			font-size: 40px;	
		}
		td {
			font-size: 12px;
			font-style: italic;
			padding-top: 10px;
		}
		td.derecha {
			padding-left: 15px;
		}
		td.peque {
			padding-left: 15px;
			font-size: 10px;
			font-style: normal;
		}
		td.boton {
			padding-top: 20px;
			padding-bottom: 80px;
			padding-left: 80px;
		}
		td.boton a {
			background-color: white;
			background-position: top right;
			background-repeat: no-repeat;
			display: block;
			height: 16px;
			width: 70px;
			margin-left: 5px;
			color: black;
			text-decoration: none;
			font-style: normal;
			padding-right: 5px;
			text-align: center;
		}
		
		td.boton span {
			display: block;
			background-position: top left;
			background-repeat: no-repeat;
		}
		
		td.header {
			padding-top: 0px;
		}
		
		td.mensaje {
			padding-left: 15px;
			font-size: 12px;
			font-style: normal;
			font: bold;
			color:#FF0000;
		}
		-->
</style>
</HEAD>
<script language="javascript">
	function metodo(){
		document.forms[0].submit();
	}
	
 
</script>
<BODY onload="document.forms[0].usuario.focus();">
<html:form action="/accesoIilc.do">
<!-- input type="hidden" name="method"/ -->
<% if(request.getParameter("cerrar_session")!=null) {
%>
<script>
	window.close();
</script>
<% }
%>
<table border="0" cellpadding="0" cellspacing="0" width="743" align="center">
	<tr>
		<td colspan="2" class="header"><img src="<c:out value="${pageContext.request.contextPath}"/>/images/cabeceraBBVA.gif" border="0" width="743" height="78" alt=""></td>
	</tr>
	<tr>
		<td colspan="2"><H1>Carpetas Comerciales</H1></td>
	</tr>
	<tr>
		<td width="400" align="right"><b>Usuario:</b></td>
		<td class="derecha"><html:text property="usuario" size="20" maxlength="256"></html:text></td>
	</tr>
	<tr>
		<td width="400" align="right"><b>Contraseña:</b></td>
		<td class="derecha"><html:password property="clave" size="20" maxlength="256"></html:password></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<c:choose>
			<c:when test="${mensaje != null}">
				<td class="mensaje">${mensaje}</td>
			</c:when>
			<c:otherwise>
				<td class="mensaje">&nbsp;</td>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="boton"><span><img src="<c:out value="${pageContext.request.contextPath}"/>/images/btnAceptarLogin.gif" border="0" width="70" height="20" alt="" onclick="javascript:metodo();"></span></td>
	</tr>
	<tr>
		<td class="header" colspan="2"><img src="<c:out value="${pageContext.request.contextPath}"/>/images/piePaginaBBVA.gif" border="0" width="743" height="134" alt=""></td>
	</tr>	
</table> 
</html:form>  
</BODY>
</html:html>
