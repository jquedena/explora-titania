<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carpetas Comerciales</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();

	$(function(){		
		$("input[name=salir]").click(function(){
			location.href=contexto+"pages/iilc_listado_administrador.jsp";
		});
	});
</script>
<style>
.subMenu a {
	height: 30px;
	line-height: 30px;
	vertical-align: middle;
	padding-left: 50px;
}
</style>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" style="width:100%;padding: 2px;margin: 2px;">
<tr>
	<td colspan="2" class="FondoAzul" style="vertical-align: middle;padding-left:10px;padding-right:10px;">
		<B>ADMINISTRADOR CABECERA CARPETAS COMERCIALES</B>
	</td>
</tr>
<tr>
	<td colspan="2">&nbsp;</td>
<tbody>
<tr>
	<td class="subMenu FondoGris1" style="border-left: 1px solid #000;border-top: 1px solid #000;border-bottom: 1px solid #000;">
		<a href="${pageContext.request.contextPath}/administrarCabecera.do?method=listarCarpeta&tipo=7">ADMINISTRADOR CABECERA PESTA&Ntilde;A TODO</a><br/>
		<a href="${pageContext.request.contextPath}/administrarCabecera.do?method=listarCarpeta&tipo=8">ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE ACTIVO</a><br/>
		<a href="${pageContext.request.contextPath}/administrarCabecera.do?method=listarCarpeta&tipo=9">ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE TARJETA</a><br/>
		<a href="${pageContext.request.contextPath}/administrarCabecera.do?method=listarCarpeta&tipo=10">ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE PASIVO</a><br/>
		<a href="${pageContext.request.contextPath}/administrarCabecera.do?method=listarCarpeta&tipo=11">ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE SERVICIOS</a><br/>
		<a href="${pageContext.request.contextPath}/administrarCabecera.do?method=listarCarpeta&tipo=12">ADMINISTRADOR CABECERA PESTA&Ntilde;A OTRAS OFERTAS</a><br/>
		<a href="${pageContext.request.contextPath}/administrarCabecera.do?method=listarCarpeta&tipo=13">ADMINISTRADOR CABECERA PESTA&Ntilde;A DETALLE OFERTAS</a>
	</td>
	<td class="FondoGris1" align="right" style="border-right: 1px solid #000;border-top: 1px solid #000;border-bottom: 1px solid #000;padding: 5px;margin: 5px;">
		<input type="button" name="salir" class="boton" value="Salir" />
	</td>
</tr>
</table>
</body>
</html>