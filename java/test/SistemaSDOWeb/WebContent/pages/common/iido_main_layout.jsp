<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: Sistema de Dirección de Oficinas</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<style>
	body{
		overflow: hidden;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/valida.js"></script>
<script type="text/javascript">

	function setFocus(){
            document.forms[0].usuario.focus();
    }
		
	function loginsubmit(){
		if (document.forms[0].usuario.value==''){
			alert("Ingrese código de usuario");
			document.forms[0].usuario.focus();
		}else{
			document.forms[0].submit();
	        document.forms[0].btnLogueo.disabled=true;
		}

	}

	function sessionAction() {	
		// setTimeout("sessionAction()",600000);
		// getSession('sessionAction.do');
	}
	
	/* function ajustarIFrame(){
		var min_width = $(window).width(); // 800;
		var min_height = window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight||0; 
		min_height = min_height - 150 - 70; // area - header - footer
		var objIframe = document.getElementById('ifMain');
		objIframe.style.width='320px';
		objIframe.style.height='240px';
		var the_height=objIframe.contentWindow.document.body.scrollHeight;
		var the_width =objIframe.contentWindow.document.body.scrollWidth;
		
		if(the_height<min_height) the_height = min_height;
		if(the_width<min_width) the_width = min_width;
		the_height+=20;
		
		objIframe.style.height=the_height + 'px';
		objIframe.style.width=the_width + 'px';
	} */
	
	var loadingIndex = '<center><br><br><img src="images/loadinfo_net.gif" border="0" /><br/><label>Cargando Datos.......</label></center>';
	
	function getSession(obj){	
		var address = obj;	
		
		$.ajax({
			url: address,
			dataType: "html",
			type: "POST",
			cache: false,
			error: function(e){
				$("#mid").empty();
				$("#mid").append("<B><label>Error de la Aplicacion</label></B><br/><br/><label>Error no se Encontro la Pagina Solicitada.</label><br/><br/><label>Porfavor Intente de nuevo.</label>");
				return;
			}	
		});
	}
</script>
</head>
<body>
<table border=0 style="width: 100%; height: 100%;" align="center" cellpadding="0" cellspacing="0">
<tr>
	<td style="height:110px;"><jsp:include page="iido_header.jsp" flush="true" /></td>
</tr>
<tr><!-- Medio -->	
	<td valign="top" align="center" style="padding-left: 5px;padding-top: 5px;"><!-- tiles:insert attribute="body" / -->
		<iframe id="ifMain" name="MAIN" src="<%=request.getContextPath()%>/actionBienvenida.do" frameborder="0" width="100%" height="100%"></iframe>
	</td>
</tr><!-- Fin Medio -->
<tr>
	<td style="height:35px;border:1px solid #264971;">
	<div id="footerMain">
		<div id="footer">
			<div align="center">&copy; Copyright 2012 - BBVA Continental - Resoluci&oacute;n Optima 1366 x 768 o Superior</div>
		</div>
	</div>
	</td>
</tr>
</table>
</body>
</html>
