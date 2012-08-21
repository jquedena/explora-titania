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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
</head>
<body>
<logic:notEmpty name="detalles">
	<table border="0" align="center" style="width: 100%">
	<logic:iterate name="detalles" id="descarga">
	<tr>
		<td>
			<c:if test="${descarga.estado == 1}">
				<table border=0 cellpadding="0" cellspacing="0" style="width: 100%">
				<tr>
					<td><bean:write name="descarga" property="archivo"/></td>
					<td align="right">
						<img width="60px" src="${pageContext.request.contextPath}/images/btn_espera.gif"/>
					</td>
				</tr>
				</table>
			</c:if>
			<c:if test="${descarga.estado == 2}">
				<a target="blank" href="${pageContext.request.contextPath}/pages/iilc_descarga_file.jsp?archivo=<bean:write name="descarga" property="archivo"/>"><bean:write name="descarga" property="archivo"/></a>
			</c:if>
			<c:if test="${descarga.estado == 3}">
				<a target="blank" href="${pageContext.request.contextPath}/pages/iilc_descarga_file.jsp?archivo=<bean:write name="descarga" property="archivo"/>"><bean:write name="descarga" property="archivo"/> - Archivo con error. </a>
			</c:if>
		</td>
	</tr>
	</logic:iterate>
	</table>
</logic:notEmpty>

</body>
</html>