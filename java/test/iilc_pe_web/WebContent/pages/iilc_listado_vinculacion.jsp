
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
<LINK rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'
	type="text/css">
	<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
	
<TITLE>Carpetas Comerciales</TITLE>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();
	
	function salir(){
		window.location = contexto+"pages/iilc_listado_administrador.jsp";
	}
</script>
</HEAD>

<BODY>

<form >

	<table width="100%" border="0" cellspacing="0" cellpadding="0">

<!-- FILTROS -->
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzul" width="25%">ADMINISTRADOR CABECERA VINCULACI&Oacute;N</TD>
			
			
		</TR>
	</TABLE>
	</td>
</tr>
	</table>
	<br>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		
		<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr><td colspan="2" align="right" ><html:button property="cancelar2" styleClass="boton" onclick="salir();">Salir</html:button></td></tr>
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/listadoVinculacionesVIP.do" >ADMINISTRAR CABECERA VINCULACI&Oacute;N VIP</A></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/listadoVinculacionesGCO.do" >ADMINISTRAR CABECERA VINCULACI&Oacute;N GCO</A></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/listadoVinculacionesPH.do" >ADMINISTRAR CABECERA VINCULACI&Oacute;N PH</A></td>
			</tr>
						<tr>
				<td width="2%"></td>
				<td width="98%">&nbsp;</td>
			</tr>
		</TABLE>
		</td></tr>
	</table>
</form>
</BODY>
</html:html>
