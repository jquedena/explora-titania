<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.grupobbva.bc.per.tel.iilc.task.Mensajero"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.common.Utilitario"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%>


<%@page import="java.util.Calendar"%><html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/theme/Master.css"
	type="text/css">
<title>iilc_mail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="GENERATOR"
	content="Rational® Application Developer™ para Software de WebSphere®">
</head>
<body>
<%
	Calendar hoy = Calendar.getInstance();
	String fecha= Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+ Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+ hoy.get(Calendar.YEAR)
						+" "+Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+":" + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));

	Mensajero mail = new Mensajero();
	mail.enviarCorreo(Constantes.CODIGO_LCONDUCC,Constantes.ESTADO_CARGA_FIN, fecha);
%>
</body>
</html>