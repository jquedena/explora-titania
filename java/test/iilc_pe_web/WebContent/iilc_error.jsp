
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href='${pageContext.request.contextPath}/theme/IIRGEspacio2.css' rel="stylesheet" type="text/css">
<TITLE>Carpetas Comerciales</TITLE>
</HEAD>
<body bgcolor="#f3f9fa"> 
<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>	
	<tr>
		<td style="font-family: Arial, Swiss, sans-serif; font-size: 15px; font-style: normal; color: #a9767e; font-weight: bold; text-transform: uppercase; text-align: center">
			<c:out value="${mensaje}" escapeXml="false"/>
		</td>
	</tr>
</table> 
</body>
</html:html>
