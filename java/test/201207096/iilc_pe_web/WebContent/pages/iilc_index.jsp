<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carpetas Comerciales</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
<style>
	body {overflow: hidden;}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();
	
	$(function() {
		$("#tabs ul li a").hover(function(){
			$("#tabs ul li").removeClass("ui-state-hover");
			$(this).parent().addClass("ui-state-hover");
		});
		
		$("#tabs ul li a").mouseout(function(){
			$("#tabs ul li").removeClass("ui-state-hover");
		});
		
		$("#tabs ul li a").click(function(){
			$("#tabs ul li").removeClass("ui-tabs-selected ui-state-active");
			$(this).parent().addClass("ui-tabs-selected ui-state-active");
		});
		
		$("#lnkClose").click(function(){
			win = open(contexto+"/pages/iilc_end2.jsp", "_blank");
			win.close();
			window.close();
		});
		
		$("#tabs ul li").eq(0).addClass("ui-tabs-selected ui-state-active");
	});
</script>
<base target="${requestScope.frameName}"></base>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" style="width: 100%; height: 100%;">
<tr>
	<td style="height: 38px;" align="center">
		<div id="tabs" style="height: 38px;" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
			<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
			<c:if test="${requestScope.menu != null}">
				<c:forEach items="${requestScope.menu}" var="item">
					<li class="ui-state-default ui-corner-top"><a href='${pageContext.request.contextPath}<c:out value="${item.href}"/>'><c:out value="${item.etiqueta}" escapeXml="false"/></a></li>
				</c:forEach>
				<li class="ui-state-default" style="float:right;"><a id="lnkClose" style="background-image:url('${pageContext.request.contextPath}/images/icos/exit.png');background-repeat:no-repeat;background-position:4px center;padding-left:28px;" href=''>Cerrar Sesi&oacute;n</a></li>
			</c:if>
			<c:if test="${requestScope.menuVinculacion != null}">
				<c:forEach items="${requestScope.menuVinculacion}" var="item">
					<li class="ui-state-default ui-corner-top"><a href='${pageContext.request.contextPath}<c:out value="${item.href}"/>'><c:out value="${item.etiqueta}" escapeXml="false"/></a></li>
				</c:forEach>
			</c:if>
			</ul>
		</div>
	</td>
</tr>
<tr>
	<td><iframe id="${requestScope.frameName}" name="${requestScope.frameName}" src="${pageContext.request.contextPath}${requestScope.indexPage}" frameborder="0" width="100%" height="100%"></iframe></td>
</tr>
</table>
</body>
</html>