<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<body>
<logic:notEmpty name="detalles">
	<table border="0" align="center" style="width: 100%">
	<logic:iterate name="detalles" id="descarga">
	<tr>
		<td valign="top" align="center">
			<img src="${pageContext.request.contextPath}/images/icos/eliminar.png" style="cursor:hand;" title="eliminar"
				onclick="eliminarArchivo(${descarga.id},'${descarga.archivo}')"/>
		</td>
		<td>
			<c:if test="${descarga.estado == 1}">
				<table border=0 cellpadding="0" cellspacing="0" style="width: 100%">
				<tr>
					<td><bean:write name="descarga" property="archivo"/></td>
					<td align="right">					
						<img width="60px" src="${pageContext.request.contextPath}/images/btn_espera.gif" tag="progress_espera" 
							/>
					</td>
				</tr>
				</table>
			</c:if>
			<c:if test="${descarga.estado == 2}">
				<table border=0 cellpadding="0" cellspacing="0" style="width: 100%">
				<tr>
					<td>
						<a target="blank" href="${pageContext.request.contextPath}/pages/iilc_descarga_file.jsp?archivo=<bean:write name="descarga" property="archivo"/>"><bean:write name="descarga" property="archivo"/></a>
					</td>
					<td align="right">
						<bean:write name="descarga" property="hora"/>
					</td>
				</tr>
				</table>
			</c:if>
			<c:if test="${descarga.estado == 3}">
				<table border=0 cellpadding="0" cellspacing="0" style="width: 100%">
				<tr>
					<td>
						<a target="blank" href="${pageContext.request.contextPath}/pages/iilc_descarga_file.jsp?archivo=<bean:write name="descarga" property="archivo"/>"><bean:write name="descarga" property="archivo"/> - Archivo con error. </a>
					</td>
					<td align="right">
						<bean:write name="descarga" property="hora"/>
					</td>
				</tr>
				</table>
			</c:if>
		</td>
	</tr>
	</logic:iterate>
	</table>
</logic:notEmpty>

</body>
</html>