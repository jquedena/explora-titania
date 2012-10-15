<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.serializable.Empresa"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>Carpetas Comerciales</title>
<link rel="stylesheet" href='${pageContext.request.contextPath}/theme/IIRGEspacio2.css' type="text/css">
<link href="aw_runtime/styles/oso/aw.css" rel="stylesheet">
<%
Vector lista = (Vector) request.getAttribute("listaEmpresa");
if(lista==null) lista = new Vector(0,1);
String titulo = "Pago de Haberes";
int tamanio = lista.size();
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript">

var numChecks=<%= tamanio + 1 %>;

function sendAndClose(){
	var listaCodigos = "";
	for(var i=0;i<=numChecks;i++){
		objChk = document.getElementById("check"+i);
		if(objChk.checked){
			if(listaCodigos.length>0) listaCodigos = listaCodigos + ",";
			listaCodigos = listaCodigos + objChk.value;
		}
	}
	if(listaCodigos.length==0){
		alert("Debe escoger al menos una opción");
		return;
	}
	if(listaCodigos.indexOf('-1')>-1) {
		listaCodigos = '-1';
	}
	window.dialogArguments.codigos = listaCodigos;
	window.returnValue=true;
	window.close();
}

function cargaChecks(){
	var objChk;
	var codigos = "," + window.dialogArguments.codigos + ",";
	
	test = new Boolean(codigos);
	if(!test || codigos==',null,') {
		codigos = ",-1,";
	}
	
	var test = (codigos == ',-1,') ? true : false;
	
	if(test == false) {
		for(var i = 0; i <= numChecks; i++){
			objChk = document.getElementById("check"+i);
			if(objChk == null || objChk == undefined) {
				alert("check"+i);
			}
			if(codigos.indexOf(","+objChk.value+",")>-1 || codigos.indexOf(",-1,")>-1){
				objChk.checked = true;
				test = false;
			}
		}
	}
	
	if(test){
		$("input:checkbox").attr('checked', true);
		codigos = ",-1,";
	}
	
	ajustes();
}

function ajustes(){
	var conteo = 0;
	for(var i = 1; i <= numChecks; i++){
		if(document.getElementById("check"+i).checked)
			conteo++;
	}

	if(conteo==numChecks){
		document.getElementById("check0").checked = true;
	}
	else{
		document.getElementById("check0").checked = false;
	}
}

function ajustesTodos(){
	var chequeado = document.getElementById("check0").checked;
	for(var i = 1; i <= numChecks; i++){
		document.getElementById("check"+i).checked = chequeado;
	}
}

function checkDesdeTexto(obj,todos){
	obj.checked = !obj.checked;
	if(todos)
		ajustesTodos();
	else
		ajustes();
}

window.document.onkeypress = function(event){
	if(!event) var event = window.event;
	if(event.keyCode){
		if(event.keyCode == 27){
			window.close();
		}
		else if(event.keyCode == 13){
			sendAndClose();
		}
	}
	else if(event.which){
		if(event.which == 27){
			window.close();
		}
		else if(event.which == 13){
			sendAndClose();
		}
	}
}

$(function(){
	$("#txtBuscar").keyup(function(){
		if($(this).val().length == 0) {
			$(".errTable").css({'display': 'block'});
			$(".errTable").find('tbody').css({'display': 'block'});
		} else {
			$(".find").each(function(){
				match = $(this).text().toUpperCase().indexOf($("#txtBuscar").val().toUpperCase());
				if(match == 0){
					$(this).parent().parent().parent().css({'display': 'block'});
				} else {
					$(this).parent().parent().parent().css({'display': 'none'});
				}
			});
		}
	})
});
</script>
<style>
td {font-size:10px; vertical-align:middle;}
</style>
</HEAD>
<BODY onload="cargaChecks();">
<table width="100%" height="100%" border="0">
<tr>
	<td style="height:90%;">
		<div style="height:35px;line-height:35px;font-size:14px;text-align:left;vertical-align:middle;font-weight:bold;">
			Pago de Haberes: <input type="text" style="line-height: 16px;vertical-align: middle;" name="txtBuscar" id="txtBuscar" /> 
		</div>
		<div id="panel" style="height:344px;overflow-y:auto;background-color:#fff;border:1px solid black;">
			<table class="errTable" border="0" cellspacing="0" cellpadding="0" align="center" style="width:90%;text-align:center;vertical-align:middle;">
			<tr>
				<td style="width:25px;">
					<input type="checkbox" id="check0" value="-1" onclick="ajustesTodos();">
				</td>
				<td style="text-align: left;">
					<div class='find' onclick="checkDesdeTexto(document.getElementById('check0'),true);">TODOS</div>
				</td>
			</tr>
			</table>		
			<table class="errTable" border="0" cellspacing="0" cellpadding="0" align="center" style="width:90%;text-align:center;vertical-align:middle;">
			<tr>
				<td style="width:25px;">
					<input type="checkbox" id="check1" value="00000000" onclick="ajustes();">
				</td>
				<td style="text-align: left;">
					<div class='find' onclick="checkDesdeTexto(document.getElementById('check1'),true);">NO TIENEN PH</div>
				</td>
			</tr>
			</table>	
		<%
		int i=0;
		int j=0;
		for(i=0; i< lista.size(); i++){
			Empresa bean = (Empresa)lista.elementAt(i);
			j = i + 2;
		%>
			<table class="errTable" border="0" cellspacing="0" cellpadding="0" align="center" style="width:90%;text-align:center;vertical-align:middle;">
			<tr>
				<td style="width:25px;">
					<input type="checkbox" id="check<%=j %>" value="<%=bean.getCod_empresa() %>" onclick="ajustes();">
				</td>
				<td style="text-align: left;">
					<div class='find' onclick="checkDesdeTexto(document.getElementById('check<%=j%>'),false);"><%=bean.getDes_empresa() %></div>
				</td>
			</tr>
			</table>
		<%
		}
		%>
		</div>
	</td>
</tr>
<tr>
	<td style="height:10%;text-align:center;vertical-align:middle;">
		<input type="button" class="boton" onclick="sendAndClose();" value="Aceptar" />
	</td>
</tr>
</table>
</body>
</html:html>
