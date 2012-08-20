
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
<script language="javascript" src="includes/index_combos.js"></script>

<!-- js y css para grilla -->
<script src="aw_runtime/lib/aw.js" type="text/javascript"></script>
<script src="includes/grilla.js" type="text/javascript"></script>
<link href="aw_runtime/styles/oso/aw.css" rel="stylesheet">
<script src="includes/index_grilla.js" type="text/javascript"></script>
<script src="includes/common.js" type="text/javascript"></script>
<script src="includes/AjaxRequest.js" type="text/javascript"></script>
<script src="includes/AjaxCommon.js" type="text/javascript"></script>
<!-- NO BORRAR LOS ATRIBUTOS TITLE DE ESTOS CSS -->
<link href="aw_runtime/styles/oso/extras_grilla.css" rel="stylesheet" title="cssEstiloGrilla">
<link rel="stylesheet" href="theme/bloqueCeldas.css" title="cssEstilosCeldas">
	
	
	
	
<TITLE>Carpetas Comerciales</TITLE>

</HEAD>
<table width="100%" cellpadding="0" cellspacing="0" >
	<tr class="FondoGris2">
		<td>
			<img src="<c:out value="${pageContext.request.contextPath}"/>/images/dibujo.png" border="0" alt="">
		</td>
		<td align="right" style="vertical-align:middle; font-size: 16px; color: #2d4492; font-weight: bold; text-transform: uppercase">
			 
		</td>
	</tr>
	<tr class="FondoAzul" >
		<td colspan="2" height="10px"></td>
	</tr>
</table>
<BODY >

<form >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="TituloPagServGen">Carpetas Comerciales</td>
		</tr>
	</table>
	<br>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr><td>
			<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="2%" class="FondoAzulSubTitulo"></td>
				<td width="98%" class="FondoAzulSubTitulo">MEN&Uacute; DE ADMINISTRACI&Oacute;N</td>
			</tr>
			</TABLE>
		</td></tr>
		<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr><td colspan="2">&nbsp;</td></tr>
			<!-- 
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/pages/administracionCargaArchivos/iilc_carga_masiva.jsp" target="iilc_carga">Carga Masiva de Informaci&oacute;n</A></td>
			</tr>
			 <tr><td colspan="2">&nbsp;</td></tr>
			  -->
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/pages/administracionCargaArchivos/iilc_adm_carga_lconduc.jsp" target="iilc_carga">Programaci&oacute;n de carga del Listado de Conducci&oacute;n</A></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/mantenimientoTablas.do?method=mantenimiento" target="iilc_mantenimiento">Mantenimiento Tablas</A></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/pages/iilc_descarga.jsp?file=iilc.log&rootpath=<%=(String)request.getAttribute("rutaLog") %>" target="_self">Ver Log</A></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/cargaMasiva.do?method=estadoCargaCliente" target="iilc_estado_carga_0">Estado de carga de Clientes</A></td>
			</tr>

			<tr><td colspan="2">&nbsp;</td></tr>
		</TABLE>
		</td></tr>
	</table>
</form>
</BODY>
</html:html>
