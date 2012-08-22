<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
     
	<title>Acceso LDAP</title>
	
	<sj:head jqueryui="true" locale="es" jquerytheme="bbva" customBasepath="/PIZELE_WEB/theme"/>
	
</head>
<body>

<s:form action="loginAction">	
	
	<s:hidden name="desa" value="desa"></s:hidden>
	<s:textfield name="codldap" value="P008044"></s:textfield>
	<s:textfield name="password"></s:textfield>
	<sj:submit value="Aceptar" button="true"></sj:submit>	
</s:form>



</body>
</html>