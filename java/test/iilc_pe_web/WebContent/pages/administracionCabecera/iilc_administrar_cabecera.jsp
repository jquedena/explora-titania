<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%><html>
<head>
<title>iilc_administrar_cabecera</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();
	
	/*function validaCaractaer(e){
		var tecla= String.fromCharCode((document.all) ? e.keyCode : e.which);
		var digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz _";
		if(digits.indexOf(tecla)==-1) return false;
	}*/
	
	$(function(){
		$("input:text").keypress(function(e){
			var tecla= String.fromCharCode((document.all) ? e.keyCode : e.which);
			var digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz _()<>,";
			if(digits.indexOf(tecla)==-1) return false;
		});
		
		$("input[name=salir]").click(function(){
			location.href=contexto+"administrarCabecera.do?method=administrar";
		});
		
		$("input[name=grabar]").click(function(){
			$("form[name=FormBeanConsulta]").submit();
		});
	});
</script>
</head>
<body>
<html:form action="/administrarCabecera" >
<input type="hidden" name="method" value="registrarCabecera"/>
<input type="hidden" name="tipo" value="<%=request.getParameter("tipo")%>"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
	<td style="vertical-align:middle;font-weight: bold;height: 30px;line-height: 30px;" class="FondoAzul">
		<c:out value="${requestScope.title}" escapeXml="false" />
	</td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr>
	<td class="mensajeInformacion" >
	<logic:notEmpty  name="mensaje">
		<bean:write name="mensaje"/>
	</logic:notEmpty>
	</td>
</tr>
<tr>
	<td align="center">
		<html:button property="grabar" styleClass="boton">Grabar</html:button>
		<html:button property="salir" styleClass="boton">Salir</html:button>
	</td>
</tr>
</table>
<br>
<logic:notEmpty name="carpeta">
<table border="0" align="center">
<tr class="FondoAzul">
	<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;">Campo</td>
	<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;">Descripci&oacute;n Corta</td>
	<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;">Descripci&oacute;n Larga</td>
	<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;">Agrupador 1 (Excel)</td>
	<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;">Agrupador 2 (Excel)</td>
	<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;">No Mostrar</td>
</tr>
<logic:iterate name="carpeta" id="cab">
<tr>
	<td>
		<input type="text" id="campo_<bean:write name="cab" property="orden"/>" name="campo_<bean:write name="cab" property="orden"/>" size="15"  value = "<bean:write name="cab" property="campo"/>" disabled />
	</td>
	<td>
		<input <c:if test="${fn:indexOf(cab.detalle, 'disabled')>-1}">disabled</c:if> type="text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_CORTA%>" id="corta_<bean:write name="cab" property="orden"/>" name="corta_<bean:write name="cab" property="orden"/>" size="30" value="<bean:write name="cab" property="descorta"/>" />
	</td>
	<td>
		<input <c:if test="${fn:indexOf(cab.detalle, 'disabled')>-1}">disabled</c:if> type="text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_LARGA%>" id="larga_<bean:write name="cab" property="orden"/>" name="larga_<bean:write name="cab" property="orden"/>" size="50" value="<bean:write name="cab" property="deslarga"/>" />
	</td>
	<td>
		<input <c:if test="${fn:indexOf(cab.detalle, 'disabled')>-1}">disabled</c:if> type="text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_CORTA%>" id="agrupacion_1_<bean:write name="cab" property="orden"/>" name="agrupacion_1_<bean:write name="cab" property="orden"/>" size="30" value="<bean:write name="cab" property="agrupador1"/>" />
	</td>
	<td>
		<input <c:if test="${fn:indexOf(cab.detalle, 'disabled')>-1}">disabled</c:if> type="text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_CORTA%>" id="agrupacion_2_<bean:write name="cab" property="orden"/>" name="agrupacion_2_<bean:write name="cab" property="orden"/>" size="30" value="<bean:write name="cab" property="agrupador2"/>" />
	</td>
	<td>
		<input <c:if test="${fn:indexOf(cab.detalle, 'disabled')>-1}">disabled</c:if> type="checkbox" id="oculto_<bean:write name="cab" property="orden"/>" name="oculto_<bean:write name="cab" property="orden"/>" <c:if test="${cab.oculto=='1'}">checked</c:if> />
	</td>
</tr>
</logic:iterate>
</table>
</logic:notEmpty>
</html:form>
</body>
</html>