<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Glosario de Cabeceras Comerciales</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#tabs").tabs();
});
</script>
</head>
<body>
<div id="tabs">
	<ul>
	<c:set var="index" value='0' />
	<c:forEach items="${requestScope.listadoRadios}" var="radio">
		<li><a href="#tab-<c:out value="${index}"/>"><c:out value="${radio.descorta}"/></a></li>
		<c:set var="index" value="${index + 1}" />
	</c:forEach>
	</ul>
	<c:set var="index" value='0' />
	<c:forEach items="${requestScope.carpetas}" var="lista">
		<div id="tab-<c:out value="${index}"/>" style="height:402px;overflow:auto;">
		<table cellpadding=0 cellspacing=0 width="95%">
			<tr class="FondoAzul">
				<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;border-left:1px solid #000;border-top:1px solid #000;border-bottom:1px solid #000;">DESCRIPCI&Oacute;N CORTA</td>
				<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;border:1px solid #000;">DESCRIPCI&Oacute;N LARGA</td>
			</tr>
			<c:forEach items="${lista}" var="row">
			<tr>
				<td style="font-size:90%;height: 20px; line-height: 20px; vertical-align: middle;padding-left:10px;border-left:1px solid #000;border-bottom:1px solid #000;"><c:out value="${row.descorta}" /></td>
				<td style="font-size:90%;height: 20px; line-height: 20px; vertical-align: middle;padding-left:10px;border-left:1px solid #000;border-bottom:1px solid #000;border-right:1px solid #000;"><c:out value="${row.deslarga}" /></td>
			</tr>
			</c:forEach>
		</table>
		</div>
		<c:set var="index" value="${index + 1}" />
	</c:forEach>
</div>
<html:form action="administrarCabecera.do">
</html:form>
</body>
</html>