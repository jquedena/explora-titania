<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
	<sj:head jqueryui="true" locale="es" jquerytheme="bbva" customBasepath="/PIZELE_WEB/theme"/>

	<script src="<%=request.getContextPath()%>/js/core.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/js/core_vista.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/js/core_validacion.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/js/validacion/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/js/validacion/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/js/core_calculo.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.print.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/js/menu/fg.menu.js" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/app.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/displayTable.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/validacion/validationEngine.jquery.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/menu/fg.menu.css" media="screen" rel="stylesheet"/>
	
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
	<script type="text/javascript">
		var updHeader = false;
	</script>
	
	<style type="text/css">
		.printable {
			border: 1px dotted #CCCCCC ;
			padding: 10px 10px 10px 10px ;
		}
	</style>
</head>

<body>

<div class="tab">
<!--
<ul class="login">
	<li class="left">&nbsp;</li>
	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
	<li class="right">&nbsp;</li>
</ul>
-->
</div>

<div id="toppanel">
	<div class="content clearfix ui-widget ui-widget-content ui-corner-all" style="width: 800px;background-color: white;">
	
	<sj:dialog 
			id="jqDialogCargando" autoOpen="false" modal="true" resizable="false" closeOnEscape="false"	
			height="80" cssStyle="display:none;text-align:center;vertical-align: middle;" dialogClass="hide-title-bar" width="200">
			<table cellpadding="5" cellspacing="0" bgcolor="#ffffff" >
				<tr>
					<td align="right" valign="middle" >
						<img src="<%=request.getContextPath()%>/images/loading8.gif">
					</td>
					<td align="left" valign="middle" style="font-weight: bold;">
						Procesando ...
					</td>
				</tr>
			</table>
	</sj:dialog>
	
	<sj:dialog 
			id="jqDialogCofirmacion" title="Mensaje de Confirmación" autoOpen="false" modal="true" resizable="false" closeOnEscape="true"
			height="140"
			buttons="{'Aceptar':function() { okButton(); },
					  'Cancelar':function() { cancelButton(); } 
					 }">
	</sj:dialog>
	
	<sj:dialog 
			id="jqDialogCofirmacion2" title="Mensaje de Confirmación" autoOpen="false" modal="true" resizable="false" closeOnEscape="true"
			height="140"
			buttons="{'Aceptar':function() { okButton2(); },
					  'Cancelar':function() { cancelButton2(); } 
					 }">
	</sj:dialog>
	
	<sj:dialog 
			id="jqDialogPregunta" title="Mensaje de Confirmación" autoOpen="false" modal="true" resizable="false" closeOnEscape="true"
			height="150" width="300"
			buttons="{'Aceptar':function() { okEjecutar(); },
					  'Cancelar':function() { cancelEjecutar(); } 
					 }">
	</sj:dialog>
	
	<sj:dialog 
			id="jqDialogInfo" title="Información" autoOpen="false" modal="true" resizable="false"
			height="170" 
			buttons="{'Cerrar':function() { closeDialogInfo(); }}">
	</sj:dialog>
	
	<sj:dialog 
			id="jqDialogWarning" title="Advertencia" autoOpen="false" modal="true" resizable="false"
			height="170" 
			buttons="{'Aceptar':function() { closeDialogWarning(); }}">
	</sj:dialog>
	
	<sj:dialog 
			id="jqDialogError" title="Error" autoOpen="false" modal="true" resizable="false"
			height="170" 
			buttons="{'Aceptar':function() { closeDialogError(); }}">
	</sj:dialog>
	
	<table border="0" cellpadding="0" cellspacing="0" align="center" width="800px">
		<tr>
			<td colspan="2" width="100%">
				<tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr>
			<td align="left">
				<tiles:insertAttribute name="menu" />
			</td>
		</tr>
		<tr>
			<td width="100%" valign="top" class="ui-widget-content2 ln_formatos" colspan="2">
				<div align="center" style="padding: 2px 2px 2px 2px;background: white; ">
					<div>
						<s:if test="hasActionErrors()">
							<s:actionerror theme="jquery" cssStyle="text-align:left;font-size:13px;font-weight: bold;"/>
						</s:if>
						<s:if test="hasActionMessages()">
							<s:actionmessage theme="jquery" cssStyle="text-align:left;font-size:13px;font-weight: bold;"/>
						</s:if>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td><br></td>
		</tr>
		<tr>
			<td align="center" style="vertical-align: top;" height="400px">
				<div id="divPrincipal">
					<tiles:insertAttribute name="body" />
				</div>
			</td>
		</tr>
		<tr>
			<td><br></td>
		</tr>
	</table>
	</div> 
</div> 
</body>
<script type="text/javascript">
	function ocultarValidacion() {
		$("form:first").validationEngine('hideAll');
	}

	$(document).ready(function(){
		$(document).ajaxStart(function(){
			$('#jqDialogCargando').dialog('open');
		});
		$(document).ajaxStop(function(){
			$('#jqDialogCargando').dialog('close');
		});
	});
</script>
</html>