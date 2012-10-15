<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/displaytag.css" type="text/css">
<TITLE>Carpetas Comerciales</TITLE>
</head>
<body>
<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr><td>
	<!-- TABLA DE TITULO -->
	<TABLE width="100%" align="center">
		<TR >
			<TD class="TituloPagServGen">CONDUCCION DE NEGOCIO POR CARTERAS
			</TD>
		</TR>
	</TABLE>
	</td></tr>
	<tr>
		<td><tiles:insert attribute="filtro"/></td>
	</tr>
	<tr>
		<td><tiles:insert attribute="body"/></td>
	</tr>
</table>
</body>
</html>