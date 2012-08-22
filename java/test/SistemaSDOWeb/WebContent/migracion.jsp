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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
String estado=(String)request.getAttribute("estado");
if(estado==null){
	estado="0";
}
String refrescador = "<meta http-equiv=\"refresh\" content=\"10;url=migracionDatosAction.do?method=inicio\">";
if(estado.equals("1")){
	refrescador = "";
}
 %>

<%=refrescador %>
</HEAD>
<BODY>
<form  method="post" name="forms">
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">MIGRACION</td>	
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">

<!-- **** INICIO RESTO DE CÓDIGO DE LA PÁGINA-->			
<%if(estado.equals("0")) {%>
<Table align="center" border="1" bordercolor="#104284" width="300" height="260"><tr><td>
<div align="center"><img src="images/cargando.gif"></div>
</td></tr></Table>
<%}if(estado.equals("1")){ %>
<Table align="center" border="1" bordercolor="#104284"><tr><td>MIGRACIÓN FINALIZADA</td></tr></Table>
<%} %>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->
		</td>
	</tr>
</table>
</form>
</BODY>
</html:html>