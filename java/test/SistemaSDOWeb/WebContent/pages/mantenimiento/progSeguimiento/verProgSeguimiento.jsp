<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<TITLE>Mantenimiento Programación Seguimiento</TITLE>

<script language="javascript">
	function volver(){
		var form = document.forms[0];
		
		form.method.value = "listarProgSeguimiento";
		form.submit();									
	}

var mensaje_error = '<%=request.getAttribute("mensajeExito")%>';

window.onload=function(){
	if (mensaje_error != 'null') {
		alert(mensaje_error);
	}
}
</script>
</HEAD>

<BODY>
<html:form action = "/progSeguimientoAction">
<html:hidden property="method"/>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="${pageContext.request.contextPath}/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>	
					<td><img src="${pageContext.request.contextPath}/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">
			<div align="center"><strong>PROGRAMACI&Oacute;N SEGUIMIENTO</strong></div><br />
			<table cellspacing="1" cellpadding="1" align="center">
				<tr>
			    	<td width="60">&nbsp;</td>
			    	<td width="60">&nbsp;</td>
			    	<td width="60">&nbsp;</td>				    
			    	<td width="60">&nbsp;</td>
				    <td width="60">&nbsp;</td>
				    <td width="60">&nbsp;</td>
				</tr>			
				<tr>
			    	<td width="60">Territorio:</td>
			    	<td width="60">&nbsp;</td>
				    <td colspan = "4">
				    	${requestScope.progSeguimiento.nomTerritorio}				    				
				    </td>
				</tr>				
			  	<tr>
			    	<td >Mes:</td>
			    	<td >&nbsp;</td>
				    <td >${requestScope.progSeguimiento.nomMes}</td>
					<td>&nbsp;</td>
					<td >Año:</td>
				    <td>${requestScope.progSeguimiento.anio}</td>
				</tr>
				<tr>
			    	<td >Fecha Seguimiento 1:</td>
			    	<td align="right">Inicio:</td>
			    	<td>${requestScope.progSeguimiento.seg1Ini}</td>
					<td>&nbsp;</td>
					<td>Fin:</td>
					<td>${requestScope.progSeguimiento.seg1Fin}</td>
				    <td>&nbsp;</td>
				</tr>
				<tr>
			    	<td>Fecha cierre de mes:</td>
			    	<td align="right">Inicio:</td>
				    <td>${requestScope.progSeguimiento.seg2Ini}</td>
					<td>&nbsp;</td>
					<td>Fin:</td>
					 <td>${requestScope.progSeguimiento.seg2Fin}</td>
				    <td>&nbsp;</td>
				</tr>
				<tr>
			    	<td>&nbsp;</td>
			    	<td>&nbsp;</td>
			    	<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>				
				</tr>
			   	<tr>
	    			<td colspan="6">
					    <table align="center">
					    	<tr>
	    						<td colspan = "3" align = "center">	    							
							    	<input type="button" name="btnVolver" value="Volver" onClick="volver();" class="botonnew">
							    </td>
						    </tr>
						</table>
				    </td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>
</BODY>
</html:html>
