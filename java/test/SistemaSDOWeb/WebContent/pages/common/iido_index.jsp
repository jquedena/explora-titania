<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv='PRAGMA' content='NO-CACHE' />
<meta http-equiv='EXPIRES' content='0' />	
<title>Sistema de Dirección de Oficinas</title>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<%
	String msg = (String) request.getAttribute("msg");
	if(msg == null) msg = "";
	String nomArch  = (String) request.getSession(false).getAttribute("rutaArchivo");
	String rutaFile = (nomArch==null ? request.getContextPath()+"/images/bienvenida.jpg" : nomArch);
	boolean prueba  = (request.getAttribute("preview")!=null);
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script type="text/javascript">
	/*
	function redimension(){
		f = document.getElementById('pagina').offsetHeight;
		if (f < 400) f=820;
		parent.document.getElementById('MAIN').style.height = f + 40;
		
		txtError = '<%=request.getAttribute("txtError")%>';
		if (txtError != null && txtError != '' && txtError != 'null') {
			alert(txtError);
		}
	}
	*/
	//  onload="redimension();"
	$(function(){
		$("#war").css({"display":"none"});
		w = $(window).width();
		h = $(window).height();
		warW = parseInt($("#war").css("width"));
		warH = parseInt($("#war").css("height"));
		
		wleft = (w - warW) + 'px';
		wtop = (h - warH) + 'px';
		
		$("#war").css({"left": wleft, "top": wtop});
		if($("#war").text().length > 0) {
			$("#war").css({"display":"inline"});
		}
	});
</script>
<% request.removeAttribute("txtError");%>
</head>
<body>	
<div id="pagina" style="overflow:auto;">
<% if(prueba){ %>
<br>
<center><h2>Vista Previa</h2></center>
<br>
<% } %>
<div id="war" style="padding:5px;position: absolute; width: 200px; height:90px; left: 0px; top: 0px; background-color:#4f78ba; border: 1px solid #4f78ba;color:#fff;display:none;">
	<c:out value="${requestScope.mensajeVencimientos}" escapeXml="false"/>
</div>
<table border=0 width="100%" align="center">
<tr>
	<td valign="top" width="60%">
	<table border=0 align="center" width="100%" valign="top" cellspacing="0" cellpadding="0">
	 <tr>
		<td width="100%" align="left"  valign="top">
			<table border=0 cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
					<td width="200" class="textocentradoblanco">INICIO</td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #264971; padding:10px;" valign="top" align="center">
			<table border=0 cellpadding="0" cellspacing="0" width="65%">
				<tr>
					<td width="200px" valign="top" rowspan="2">
						<img src="<%=request.getContextPath()%>/downloadImage?file=<%=request.getSession(false).getAttribute("archivoBienvenida") != null ? request.getSession(false).getAttribute("archivoBienvenida").toString() : "" %>" align="middle" width="200">
					</td>
					<td class="textocelda" style="padding-left:10px;" align="left" valign="top">
						<c:out value="${msg}" escapeXml="false"/>
					</td>
				</tr>
				<tr>
					<td class="textocelda" style="padding-left:20px;" align="left" valign="top">
					<p>Modelos de Negocios e Incentivaci&oacute;n<br>Desarrollo Comercial / I+D </p>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</table>
	</td>
	<c:if test = "${not empty requestScope.mensajeTerritorio}">
	<td style="vertical-align:top; align:center;" width="40%">
	<table border=0 align="center" width="100%" height="%" cellspacing="0" cellpadding="0">	
		<tr>
			<td width="100%" align="left"  valign="top">
				<table border=0 cellspacing="0" cellpadding="0">
					<tr>
						<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
						<td width="120" class="textocentradoblanco">MENSAJE</td>
						<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid #264971; background:${requestScope.colorFondo}" valign="top" height="%" align="center">
				<table border=0 width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td class="textocelda" style="padding:10px;" align="left" valign="top">
							<c:out value="${requestScope.mensajeTerritorio}" escapeXml="false"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</td>
	</c:if> 
</tr>
</table>

<% if(prueba){ %>
	<center><input type="button" value="Retornar a Edición" onClick="location.href='actionBienvenida.do?accion=E2';"></center>
<% } %>

</div>
</body>
</html>

