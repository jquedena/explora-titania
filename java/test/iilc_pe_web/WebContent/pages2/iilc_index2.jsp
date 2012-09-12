<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<%@page import="com.grupobbva.bc.per.tel.iilc.logic.FormateaListado"%><html:html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.grupobbva.bc.per.tel.iilc.common.Constantes" %>
<title>CARPETAS COMERCIALES</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<style type="text/css">
img#bg {
  position:fixed;
  top:0;
  left:0;
  width:100%;
}
#full-screen-background-image {
  z-index: -999;
  min-height: 100%;
  min-width: 1024px;
  width: 100%;
  height: auto;
  position: fixed;
  top: 0;
  left: 0;
}
  a.sortHeader
, a.sortHeader:hover
, a.sortHeader:link
, a.sortHeader:visited {
	color: black;
	font-weight: bold;
	font-size: 10px;
	text-decoration: none;
}
  a.linkDetalle
, a.linkDetalle:hover
, a.linkDetalle:link
, a.linkDetalle:visited {
	font-weight: normal;
	font-size: 11px;
}
</style>

<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/bloqueCeldas.css" title="cssEstilosCeldas">
<link rel="stylesheet" href="${pageContext.request.contextPath}/aw_runtime/styles/oso/extras_grilla.css" title="cssEstiloGrilla">
<link rel="stylesheet" href="${pageContext.request.contextPath}/aw_runtime/styles/oso/aw.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/includes/index_combos.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/aw_runtime/lib/aw.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/grilla.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/index_grilla.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/AjaxRequest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/AjaxCommon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript">
var perfilTerritorio = "${requestScope.pTerritorio}";
var perfilOficina = "${requestScope.pOficina}";

function parpadeo(){
	var color = $("#alert_fecha").css("color"); 
	// console.log(color);
	if(color=="#f00" || color=="rgb(255, 0, 0)"){
		$("#alert_fecha").css({"color": "#008000"});
	}else{
		$("#alert_fecha").css({"color": "#f00"});
	}// #f00
	setTimeout("parpadeo()", 1000);
}

function validarPerfilConsulta(){
	if(perfilTerritorio != "") {
		if($("#territorio").val()=="-1"){
			$("#territorio").val(perfilTerritorio);
		}
	}

	if(perfilOficina != "") {
		if($("#oficina").val()=="-1"){
			$("#oficina").val(perfilOficina);
		}
	}
}

function validaPerfil(){
	validarPerfilConsulta();
	perfil = '<c:out value="${sessionScope.perfil.cod_perfil}" />';
	
	if(perfil == "LC01" || perfil == "LC06") {
		if( (($("#territorio").val() == "-1" || $("#territorio").val() == perfilTerritorio) &&
			(document.forms[0].clasificacion.value == '-1'     ) && 
			(document.forms[0].margen_ordinario.value == '-1'   ) && 
			(document.forms[0].etiqueta.value == '-1'           ) && 
			(document.forms[0].edad.value == '-1'               ) && 
			(document.forms[0].cuota_riesgo_total.value == '-1' ) && 
			(document.forms[0].cod_empresa.value == '-2' || 
			 document.forms[0].cod_empresa.value == '-1'     ) && 
			(document.forms[0].tipo_cliente.value == '-1'    )) ){
			alert("Debe seleccionar al menos un campo para la b\u00FAsqueda.");
			return false;
		}
	}
	
	return true;
}

function padL(number, numDigits) {
	var str = number.toString();
	while (str.length < numDigits) str = '0' + str;
	return(str);
}

$(function() {
	$("#radio").buttonset();
	
	$(".cajaPagina").keypress(function(e){
		var tecla= String.fromCharCode((document.all) ? e.keyCode : e.which);
		var digits = "0123456789";
		if(digits.indexOf(tecla)==-1) return false;
	});
});

function sortHeader(o){
	var old = $("#orden").val();
	var act = o.attr('colName');
	var asc = o.attr('asc');

	if(old.indexOf(act) >= -1){
		if(asc == '1'){
			$("#orden").val(act + " asc");
			o.attr('asc', '0');
		}else{
		 	$("#orden").val(act + " desc");
		 	o.attr('asc', '1');
		}
	}
	
	// consulta();
	consultaPagina("pri");
}
 
function openGlosario() {
	url = "administrarCabecera.do?method=glosario";
	window.showModalDialog(url,"","dialogWidth:1000px;dialogHeight:465px;");
}
 
var hayResultados = false;
var numPag=0;
var totalPag=0;
var tipo_detalle = '0';

function pintarDetalles(datos){
	var i;
	var j = 0;
	var html = "";
	var objDiv = document.getElementById("divDetalleFiltros");
	
	html+="<table border='0' cellspacing='0' cellpadding='0' width='97%'>"
	if(datos.length>0){
		for(i=0; i<datos.length; i++){
			if(datos[i][0]!=null){
				j++;
				html+="<tr class='detalle'>";
				html+="<td class='detalle1' width='150'>" + datos[i][0] + "</td>";
				html+="<td class='detalle2'>" + datos[i][1] + "</td>";
				html+="</tr>";
			}
		}
	}
	if(datos.length==0 || j==0){
		html+="<tr>";
		html+="<td class='detalle1' width='150'>&nbsp;</td>";
		html+="<td class='detalle2'>SIN FILTROS</td>";
		html+="</tr>";
	}
	
	html+="</table>";
	objDiv.innerHTML = html;
	objDiv.style.visibility = "visible";
}

function pageInit(){
	limpiarResultados();
	pintarDetalles('');
}

function abrirListaEmpresas(){
	var url = "consulta2.do?method=cargaEmpresa2";
	url+="&territorio=" + document.forms[0].territorio.value;
	url+="&oficina=" + document.forms[0].oficina.value;
	url+="&gestor=" + document.forms[0].gestor.value;
	url+="&nivelVinculacion=" + document.forms[0].nivel_vinculacion.value;
	url+="&clasificacion=" + document.forms[0].clasificacion.value;
	url+="&margenOrdinario=" + document.forms[0].margen_ordinario.value;
	url+="&etiqueta=" + document.forms[0].etiqueta.value;
	url+="&edad=" + document.forms[0].edad.value;
	url+="&cuotaRiesgoTotal=" + document.forms[0].cuota_riesgo_total.value;
	// abrir(url,"iilc_pagohaberes");
	return url;
	// , "iilc_pagohaberes", "toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=450px, height=420px, top=85, left=140");
}

function limpiar(){
	<c:if test="${sessionScope.perfil.cod_perfil=='LC06'}">
		document.forms[0].territorio.value="-1";
		document.forms[0].oficina.value="-1";
		document.forms[0].gestor.value="-1";
	</c:if>
		
	limpiarResultados();
	limpiarFiltros();
	
	<c:if test="${sessionScope.perfil.cod_perfil!='LC06'}">
	if(!document.forms[0].territorio.disabled){
		document.forms[0].territorio.selectedIndex = 0;
		llenarOficinas();
	}
	else if(!document.forms[0].oficina.disabled){
		document.forms[0].oficina.selectedIndex = 0;
		llenarGestores();
	}
	else if(!document.forms[0].gestor.disabled){
		document.forms[0].gestor.selectedIndex = 0;
	}
	</c:if>
	pintarDetalles("");
}

function limpiarFiltros(){
	document.forms[0].nivel_vinculacion.value="-1";
	document.forms[0].clasificacion.value="-1";
	document.forms[0].margen_ordinario.value="-1";
	document.forms[0].etiqueta.value="-1";
	document.forms[0].edad.value="-1";
	document.forms[0].cuota_riesgo_total.value="-1";
	document.forms[0].tipo_cliente.value="-1";
	document.forms[0].cod_cliente.value="";
	resetEmpresa();
	updateBotonesFiltro();
}

function datoFiltro(){
	var codigos;
}

function abrirFiltro(tipo){
	if(tipo==0)
		datoFiltro.codigos = document.forms[0].nivel_vinculacion.value;
	if(tipo==1)
		datoFiltro.codigos = document.forms[0].clasificacion.value;
	if(tipo==2)
		datoFiltro.codigos = document.forms[0].margen_ordinario.value;
	if(tipo==3)
		datoFiltro.codigos = document.forms[0].etiqueta.value;
	if(tipo==4)
		datoFiltro.codigos = document.forms[0].edad.value;
	if(tipo==5)
		datoFiltro.codigos = document.forms[0].cuota_riesgo_total.value;
	if(tipo==6) {
		stipo=0;
		parametros="";
		datoFiltro.codigos = document.forms[0].territorio.value;
	}
	if(tipo==7) {
		stipo=1;
		parametros="&territorio="+document.forms[0].territorio.value;
		datoFiltro.codigos = document.forms[0].oficina.value;
	}
	if(tipo==8) {
		stipo=2;
		parametros="&territorio="+document.forms[0].territorio.value+"&oficina="+document.forms[0].oficina.value;
		datoFiltro.codigos = document.forms[0].gestor.value;
	}
	if(tipo==9)
		datoFiltro.codigos = document.forms[0].tipo_cliente.value;
		
	if(tipo==10)
		datoFiltro.codigos = document.forms[0].cod_empresa.value;
			
	var url = "consulta2.do?method=filtro&tipo=" + tipo + "&d=" + (new Date().getTime());
	var caracteristicas = "dialogWidth:240px;dialogHeight:360px;";
	
	if(tipo==6 || tipo==7 || tipo==8){
		url = "consulta2.do?method=filtroHistorico&tipo=" +stipo+parametros;
	}
	if(tipo==10){
		url = abrirListaEmpresas();
		caracteristicas = "dialogWidth:450px;dialogHeight:420px;"; 
	}	
	
	if(window.showModalDialog(url,datoFiltro,caracteristicas)){
		if(tipo==0)
			document.forms[0].nivel_vinculacion.value = datoFiltro.codigos;
		if(tipo==1)
			document.forms[0].clasificacion.value = datoFiltro.codigos;
		if(tipo==2)
			document.forms[0].margen_ordinario.value = datoFiltro.codigos;
		if(tipo==3)
			document.forms[0].etiqueta.value = datoFiltro.codigos;
		if(tipo==4)
			document.forms[0].edad.value = datoFiltro.codigos;
		if(tipo==5)
			document.forms[0].cuota_riesgo_total.value = datoFiltro.codigos;
		if(tipo==6) {
			document.forms[0].territorio.value = datoFiltro.codigos;
			document.forms[0].oficina.value = '-1';
			document.forms[0].gestor.value = '-1';
		}
		if(tipo==7) {
			document.forms[0].oficina.value = datoFiltro.codigos;
			document.forms[0].gestor.value = '-1';
		}
		if(tipo==8)
			document.forms[0].gestor.value = datoFiltro.codigos;
		if(tipo==9)
			document.forms[0].tipo_cliente.value = datoFiltro.codigos;
		if(tipo==10)
			document.forms[0].cod_empresa.value = datoFiltro.codigos;
			
		// resetEmpresa();
		updateBotonesFiltro();
	}
	else{
		return;
	}
}

function updateBotonesFiltro(){

	<c:if test="${sessionScope.perfil.cod_perfil=='LC06'}">
	if(document.forms[0].territorio.value=='null' || document.forms[0].territorio.value==null || document.forms[0].territorio.value=="-1"){
		if(document.getElementById("btnTerritorio")!=null){
			document.getElementById("btnTerritorio").value = "Todos";
			document.getElementById("btnTerritorio").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnTerritorio")!=null){
			document.getElementById("btnTerritorio").value = "Filtrado";
			document.getElementById("btnTerritorio").className = "botonFiltroLleno";
		}
	}
	if(document.forms[0].oficina.value=='null' || document.forms[0].oficina.value==null || document.forms[0].oficina.value=="-1"){
		if(document.getElementById("btnOficina")!=null){
			document.getElementById("btnOficina").value = "Todos";
			document.getElementById("btnOficina").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnOficina")!=null){
			document.getElementById("btnOficina").value = "Filtrado";
			document.getElementById("btnOficina").className = "botonFiltroLleno";
		}
	}
	if(document.forms[0].gestor.value=='null' || document.forms[0].gestor.value==null || document.forms[0].gestor.value=="-1"){
		if(document.getElementById("btnGestor")!=null){
			document.getElementById("btnGestor").value = "Todos";
			document.getElementById("btnGestor").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnGestor")!=null){
			document.getElementById("btnGestor").value = "Filtrado";
			document.getElementById("btnGestor").className = "botonFiltroLleno";
		}
	}
	</c:if>

	if(document.forms[0].nivel_vinculacion.value=="-1"){
		document.getElementById("btnNivelVinculacion").value = "Todos";
		document.getElementById("btnNivelVinculacion").className = "botonFiltro";
	}
	else{
		document.getElementById("btnNivelVinculacion").value = "Filtrado";
		document.getElementById("btnNivelVinculacion").className = "botonFiltroLleno";
	}
	
	if(document.forms[0].clasificacion.value=="-1"){
		document.getElementById("btnClasificacion").value = "Todos";
		document.getElementById("btnClasificacion").className = "botonFiltro";
	}
	else{
		document.getElementById("btnClasificacion").value = "Filtrado";
		document.getElementById("btnClasificacion").className = "botonFiltroLleno";
	}
	
	if(document.forms[0].margen_ordinario.value=="-1"){
		document.getElementById("btnMargenOrdinario").value = "Todos";
		document.getElementById("btnMargenOrdinario").className = "botonFiltro";
	}
	else{
		document.getElementById("btnMargenOrdinario").value = "Filtrado";
		document.getElementById("btnMargenOrdinario").className = "botonFiltroLleno";
	}
	
	if(document.forms[0].etiqueta.value=="-1"){
		document.getElementById("btnEtiqueta").value = "Todos";
		document.getElementById("btnEtiqueta").className = "botonFiltro";
	}
	else{
		document.getElementById("btnEtiqueta").value = "Filtrado";
		document.getElementById("btnEtiqueta").className = "botonFiltroLleno";
	}
	
	if(document.forms[0].edad.value=="-1"){
		document.getElementById("btnEdad").value = "Todos";
		document.getElementById("btnEdad").className = "botonFiltro";
	}
	else{
		document.getElementById("btnEdad").value = "Filtrado";
		document.getElementById("btnEdad").className = "botonFiltroLleno";
	}
	
	if(document.forms[0].cuota_riesgo_total.value=="-1"){
		document.getElementById("btnCuotaRiesgoTotal").value = "Todos";
		document.getElementById("btnCuotaRiesgoTotal").className = "botonFiltro";
	}
	else{
		document.getElementById("btnCuotaRiesgoTotal").value = "Filtrado";
		document.getElementById("btnCuotaRiesgoTotal").className = "botonFiltroLleno";
	}
	
	if(document.forms[0].tipo_cliente.value=="-1"){
		document.getElementById("btnTipoCliente").value = "Todos";
		document.getElementById("btnTipoCliente").className = "botonFiltro";
	}
	else{
		document.getElementById("btnTipoCliente").value = "Filtrado";
		document.getElementById("btnTipoCliente").className = "botonFiltroLleno";
	}
	
	if(document.forms[0].cod_empresa.value=="-1" || document.forms[0].cod_empresa.value=="-2"){
		document.getElementById("btnCodEmpresa").value = "Todos";
		document.getElementById("btnCodEmpresa").className = "botonFiltro";
	}
	else{
		document.getElementById("btnCodEmpresa").value = "Filtrado";
		document.getElementById("btnCodEmpresa").className = "botonFiltroLleno";
	}
}

<%
	FormateaListado format = (FormateaListado) session.getAttribute("formato");
%>

var _numeroRegistros = 0;
<% if(format != null){ %>
	_numeroRegistros = <%=format.getNum_registros()%>;
<% } %>

function openFile(tipo){
	if(hayResultados){
		flag = true;
		if(_numeroRegistros > <%=session.getAttribute("T00MAX") %>) {
			flag = confirm("Resultado excede el l\u00EDmite de registros permitidos (<%=session.getAttribute("T00MAX") %>). \u00BFDesea igual realizar la descarga\u003F");
		}
		
		if(!flag){
			return;
		}
		
		idAlert = 2;
		clearInterval(idVerificar);
		$("#xthreads").html('<center><img width="60px" src="${pageContext.request.contextPath}/images/btn_espera.gif"/></center>');
		
		AjaxRequest.post({
			 'url':'consultaListadoConduccionAction.do'
			,'parameters':{'method':'descargar', 'tipo': tipo}
			,'timeout':600000
			,'onSuccess':function(req){
				// alert("Se acabar de iniciar el proceso de generaci\u00F3n del archivo.");
				$("#rightPanel").css({"width": "400px", "display": "inline"});
				$("#imgShow").css({"display": "none"});
				$("#imgHide").css({"display": "inline"});
				$("#titlehide").html("Ocultar Descargas aqu&iacute; -&gt;");
				idVerificar = setInterval("verificarCargas()", 5000);   
			}
			,'onTimeout':function(req){ alert("Tiempo de espera agotado. Intente nuevamente."); }
			,'onError':function(req){ alert("Error de comunicaci\u00F3n."); }
		});	
	}
	else{
		alert("No hay resultados para exportar.");
	}
}
function popup(){
	window.open("cargaDatos.do?method=cargaEtiquetaSegmento", "popup", "width=800,height=400,scrollbars=YES,left=220,top=200,screenX=0,screenY=100'");
}
function popup2(){
	window.open("pages/iilc_nivel_vinculacion.jsp", "popup", "width=600,height=400,scrollbars=YES,left=220,top=200,screenX=0,screenY=100'");
}

/*function mostrarTabla(param,codigo){
	territorio = document.getElementById("territorio").value;
	oficina = document.getElementById("oficina").value;
	gestor = document.getElementById("gestor").value;
	document.forms[0].target="_self";
	document.forms[0].action="cargaDatos.do?method=cargaNVyET&parametro="+param+"&codigo="+codigo+"&codTerritorio="+territorio+"&codOficina="+oficina+"&codGestor="+gestor;
	document.forms[0].submit();
}*/

function consulta(){
	if(!validaPerfil()) {
		return false;
	}
	// ui-state-active

	hayResultados = false;
	document.forms[0].cod_cliente.value = "";
	document.forms[0].tipo_detalle[0].checked = true;
	tipo_detalle = '0';
	
	$(".option-ui").removeClass("ui-state-active");
	$(".option-ui").eq(0).addClass("ui-state-active");
	
	AjaxRequest.post({
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'buscar2',
	    	'tipo_detalle':tipo_detalle,
	    	'territorio':document.forms[0].territorio.value,
	    	'oficina':document.forms[0].oficina.value,
	    	'gestor':document.forms[0].gestor.value,
	    	'nivelVinculacion':document.forms[0].nivel_vinculacion.value,
	    	'clasificacion':document.forms[0].clasificacion.value,
	    	'margenOrdinario':document.forms[0].margen_ordinario.value,
	    	'etiqueta':document.forms[0].etiqueta.value,
	    	'edad':document.forms[0].edad.value,
	    	'cuotaRiesgoTotal':document.forms[0].cuota_riesgo_total.value,
	    	'codEmpresa':(document.forms[0].cod_empresa.value == '-2' ? '-1' : document.forms[0].cod_empresa.value),
	    	'tipoCliente':document.forms[0].tipo_cliente.value,
	    	// 'codCliente':(document.forms[0].cod_cliente.value.length==0 ? '-1' : document.forms[0].cod_cliente.value),
	    	'codCliente':'-1',
	    	'numRegXPag':document.forms[0].numRegXPag.value,
	    	'orden':document.forms[0].orden.value
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
 			procesarResultado(req);
		}
	    ,'onTimeout':function(req){
			alert("Error de comunicación.  Intente nuevamente.");
			mostrarProceso(0);
			desbloquear();
		}
        ,'onError':function(req){
			alert("Error de comunicación.");
			mostrarProceso(0);
			desbloquear();
		}
	  }
	);
	
	limpiarResultados();
	bloquear();
	mostrarProceso(1);
}

function consultaCliente(){
	validarPerfilConsulta();
	
	if(document.forms[0].cod_cliente.value.length==0){
		alert("Ingrese un c\u00F3digo de cliente.");
		document.forms[0].cod_cliente.focus();
		return;
	}
	
	hayResultados = false;
	document.forms[0].tipo_detalle[0].checked = true;
	tipo_detalle = '0';
	$(".option-ui").removeClass("ui-state-active");
    $(".option-ui").eq(0).addClass("ui-state-active");
	AjaxRequest.get({
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'buscar2',
	    	'tipo_detalle':tipo_detalle,
	    	'territorio':document.forms[0].territorio.value,
	    	'oficina':document.forms[0].oficina.value,
	    	'gestor':document.forms[0].gestor.value,
	    	'nivelVinculacion':-1,
	    	'clasificacion':-1,
	    	'margenOrdinario':-1,
	    	'etiqueta':-1,
	    	'edad':-1,
	    	'cuotaRiesgoTotal':-1,
	    	'codEmpresa':-1,
	    	'tipoCliente':-1,
	    	'codCliente':(document.forms[0].cod_cliente.value.length==0 ? '-1' : document.forms[0].cod_cliente.value),
	    	'numRegXPag':document.forms[0].numRegXPag.value,
	    	'orden':document.forms[0].orden.value
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
 			procesarResultado(req);
		}
	    ,'onTimeout':function(req){
			alert("Error de comunicaci\u00F3n.  Intente nuevamente.");
			mostrarProceso(0);
			desbloquear();
		}
        ,'onError':function(req){
			alert("Error de comunicaci\u00F3n.");
			mostrarProceso(0);
			desbloquear();
		}
	  }
	);
	
	limpiarResultados();
	bloquear();
	mostrarProceso(1);
}

function consultaDetalle(num){
	if(!validaPerfil()) {
		return false;
	};
	tipo_detalle = num;
	hayResultados = false;
	var i;
	AjaxRequest.post(
	  {
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'detalle2',
	    	'tipo_detalle':num,
	    	'territorio':document.forms[0].territorio.value,
	    	'oficina':document.forms[0].oficina.value,
	    	'gestor':document.forms[0].gestor.value,
	    	'nivelVinculacion'	:(document.forms[0].cod_cliente.value.length==0 ? document.forms[0].nivel_vinculacion.value 	: '-1'),
	    	'clasificacion'		:(document.forms[0].cod_cliente.value.length==0 ? document.forms[0].clasificacion.value 		: '-1'),
	    	'margenOrdinario'	:(document.forms[0].cod_cliente.value.length==0 ? document.forms[0].margen_ordinario.value 		: '-1'),
	    	'etiqueta'			:(document.forms[0].cod_cliente.value.length==0 ? document.forms[0].etiqueta.value 				: '-1'),
	    	'edad'				:(document.forms[0].cod_cliente.value.length==0 ? document.forms[0].edad.value 					: '-1'),
	    	'cuotaRiesgoTotal'	:(document.forms[0].cod_cliente.value.length==0 ? document.forms[0].cuota_riesgo_total.value 	: '-1'),
	    	'codEmpresa'		:(document.forms[0].cod_cliente.value.length==0 ? (document.forms[0].cod_empresa.value == '-2' ? '-1' : document.forms[0].cod_empresa.value): '-1'),
	    	'tipoCliente'		:(document.forms[0].cod_cliente.value.length==0 ? document.forms[0].tipo_cliente.value 			: '-1'),
	    	'codCliente'		:(document.forms[0].cod_cliente.value.length==0 ? '-1' : document.forms[0].cod_cliente.value),
	    	'numRegXPag'		:document.forms[0].numRegXPag.value,
	    	'orden':document.forms[0].orden.value
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
	    				procesarResultado(req);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicaci\u00F3n.  Intente nuevamente.");
						mostrarProceso(0);
						desbloquear();
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicaci\u00F3n.");
						mostrarProceso(0);
						desbloquear();
		 			}
	  }
	);
	
	limpiarResultados();
	mostrarProceso(1);
	bloquear();
}

function consultaPaginaNum(e){
	var objPag = document.forms[0].numPag;
	var tecla = (document.all) ? e.keyCode : e.which;
	
	if(tecla==13){
		objPag.value = objPag.value.trimAll();
		if(!esSoloNumero(objPag.value)){
			alert("No es un n\u00FAmero de p\u00E1gina v\u00E1lido");
		}
		else{
			if(objPag.value<1 || objPag.value>totalPag){
				alert("El n\u00FAmero de p\u00E1gina debe estar entre 1 y " + totalPag);
			}
			else{
				consultaPagina(objPag.value)
				return true;
			}
		}
		objPag.value = numPag;
		objPag.focus();
		objPag.select();
	}
}

function consultaPagina(tipo){
	if(!validaPerfil()) {
		return false;
	};
	if(document.forms[0].numRegXPag.value.length==0){
		return;
	}

	hayResultados = false;
	var i;
	
	nuevoNumPag = numPag;
	if(tipo=='pri')
		nuevoNumPag = 1;
	else if(tipo=='ant')
		nuevoNumPag--;
	else if(tipo=='sig')
		nuevoNumPag++;
	else if(tipo=='ult')
		nuevoNumPag = totalPag;
	else
		nuevoNumPag = tipo;
	
	AjaxRequest.post(
	  {
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'paginacion2',
	    	'numPag':nuevoNumPag,
	    	'tipo_detalle':tipo_detalle,
	    	'numRegXPag':document.forms[0].numRegXPag.value,
	    	'orden':document.forms[0].orden.value
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
	    				procesarResultado(req);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicaci\u00F3n.  Intente nuevamente.");
						mostrarProceso(0);
						desbloquear();
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicaci\u00F3n.");
						mostrarProceso(0);
						desbloquear();
		 			}
	  }
	);
	
	limpiarResultados();
	mostrarProceso(1);
	bloquear();
}

function validarRespuesta(rpta){
	var res = 0;
	var partes;
	var tmp;
	
	//validar que es un array (0)
	try{
		partes = eval(rpta)[0];
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no v\u00E1lida 1(" + res + ")");
		return false;
	}
	
	//validar que tiene las 6 partes (1)
	try{
		tmp = false;
		tmp = (partes["datosDetalleFiltros"]!=undefined &&
				partes["pagActual"]!=undefined &&
				partes["numPags"]!=undefined &&
				partes["tipoDetalle"]!=undefined &&
				partes["cabeceras"]!=undefined &&
				partes["datos"]!=undefined)
		if(!tmp){
			alert("El servidor ha retornado una respuesta no v\u00E1lida 2(" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no v\u00E1lida 3(" + res + ")");
		return false;
	}
	
	//validar el índice de detalle (2)
	try{
		if(!esSoloNumero(partes["tipoDetalle"])){
			alert("El servidor ha retornado una respuesta no v\u00E1lida 4(" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no v\u00E1lida 5(" + res + ")");
		return false;
	}
	
	//validar la página actual (3)
	try{
		if(!esSoloNumero(partes["pagActual"])){
			alert("El servidor ha retornado una respuesta no v\u00E1lida 6(" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no v\u00E1lida 7(" + res + ")");
		return false;
	}
	
	//validar el total de páginas (4)
	try{
		if(!esSoloNumero(partes["numPags"])){
			alert("El servidor ha retornado una respuesta no v\u00E1lida 8(" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no v\u00E1lida 9(" + res + ")");
		return false;
	}
	return true;
}

function procesarResultado(req){
	var paso = 10;
	var rspText = limpiarDatosAjax(req.responseText);
	if (rspText == "exp"){
		if(confirm("La sesi\u00F3n ha expirado. ¿Desea volver a cargar la p\u00E1gina?")){
			window.location.reload();
		}
	}
	else if (rspText == ""){
		alert("No se obtuvo una respuesta validad del servidor.");
	}
	else {
		if(validarRespuesta(rspText)){
			try{
				var partes = eval(rspText)[0];
				_numeroRegistros = partes["numRegistros"];
				
				if(partes["datos"].length==0){
					if(perfilOficina.length!=0) {
						if(perfilOficina.indexOf(partes["codigoOficna"]) < 0) {
							pintarDetalles(partes["datosDetalleFiltros"]);
							alert(partes["mensaje"]);
						}
					} else {
						pintarDetalles(partes["datosDetalleFiltros"]);
						alert(partes["mensaje"]);
					}
				}
				else{
					paso++;//11
					var cabeceras = partes["cabeceras"];
					
					//alert(partes["datos"][partes["datos"].length-1][0]);
					
					var res = partes["datos"];
					numPag = partes["pagActual"];
					totalPag = partes["numPags"];
					paso++;//12
					pintarDetalles(partes["datosDetalleFiltros"]);
					paso++;//13
					pintarPaginacion(numPag,totalPag);
					paso++;//14
					mostrarResultados();
					paso++;//15
					generarModelo(res,cabeceras);
					paso++;//16
					hayResultados = true;
					
					$(".sortHeader").each(function(){
						var old = $("#orden").val();
						var act = $(this).attr('colName');
						if(old.indexOf(act) > -1) {
							if(old.indexOf("asc") > -1) {
								$(this).attr('asc', '0');
							} else {
								$(this).attr('asc', '1');
							}
						}
					});
				}
			}
			catch(e){
				alert("El servidor ha retornado una respuesta no v\u00E1lida (" + paso + ")");
				limpiarResultados();
			}
		}
	}
	mostrarProceso(0);
	paso++;//17
	desbloquear(hayResultados);
}

function verDetalle(o){
	url = 'consulta2.do?'
		+'method=verDetalle'
		+'&tipo_detalle=0'
		+'&territorio=-1'
		+'&oficina=-1'
		+'&gestor=-1'
		+'&nivelVinculacion=-1'
		+'&clasificacion=-1'
		+'&margenOrdinario=-1'
		+'&etiqueta=-1'
		+'&edad=-1'
		+'&cuotaRiesgoTotal=-1'
		+'&codEmpresa=-1'
		+'&tipoCliente=-1'
		+'&codCliente='+o.html()
		+'&numRegXPag=10'
		+'&orden=';
	window.open(url, "_blank", "width=1350,height=700,scrollbars=YES,left=10,top=10,resizable=YES");
}

function resetEmpresa(){
	//document.forms[0].des_empresa.value = 'TODOS';
	document.forms[0].cod_empresa.value = '-2';
}

var idVerificar = -1;
var idAlert = 1;

function verificarCargas() {

	// ,'onTimeout':function(req){ alert("Tiempo de espera agotado al obtener la lista de archivos."); }
	AjaxRequest.post({
		 'url':'consultaListadoConduccionAction.do'
		,'parameters':{'method':'listarDescargas'}
		,'timeout': 9000
		,'onSuccess':function(req){
			xhtml = req.responseText;
			$("#xthreads").html(xhtml);
			
			if(xhtml.indexOf('img') == -1) {
				if(idAlert!=1){
					clearInterval(idVerificar);
					alert("Se acabaron de realizar todas las descargas.");
				}
			}   
		}
		,'onError':function(req){ alert("Error de comunicaci\u00F3n al obtener la lista de archivos."); }
	});	
}

$(function(){
	$("#btnHide img").click(function(){
		display = $("#rightPanel").css("display");
		if(display=='none'){
			$("#rightPanel").css({"width": "400px", "display": "inline"});
			$("#imgShow").css({"display": "none"});
			$("#imgHide").css({"display": "inline"});
			$("#titlehide").html("Ocultar Descargas aqu&iacute; -&gt;");
		} else{
			$("#leftPanel").css({"width": "100%"});
			$("#rightPanel").css({"width": "0%", "display": "none"});
			$("#imgShow").css({"display": "inline"});
			$("#imgHide").css({"display": "none"});
			$("#titlehide").html("Ver Descargas aqu&iacute; -&gt;");
		}
	});
});
</script>
</head>
<body onload="pageInit();parpadeo();verificarCargas();" >
<table style="width: 100%; height: 100%;">
<tr>
<td id="leftPanel" style="width: 100%;">
	<table style="width: 100%; height: 100%;">
	<tr>
		<td style="width: 100%;height: 20px;" align="right">
			<div id="btnHide">
				<b id="titlehide">Ver descargas aqu&iacute; -&gt;</b>
				<img id="imgShow" style="display: inline" src="${pageContext.request.contextPath}/images/btn_hide_menu.gif">
				<img id="imgHide" style="display: none;" src="${pageContext.request.contextPath}/images/btn_show_menu.gif">
			</div>
		</td>
	</tr>
	<tr>
		<td>
		
<html:form action="/consultaListadoConduccionAction">
	<input type="hidden" name="method" />
	<!-- input type="hidden" name="gestorCombo" value="-1" / -->
	<input type="hidden" name="nivel_vinculacion" value="-1" />
	<input type="hidden" name="clasificacion" value="-1" />
	<input type="hidden" name="margen_ordinario" value="-1" />
	<input type="hidden" name="etiqueta" value="-1" />
	<input type="hidden" name="edad" value="-1" />
	<input type="hidden" name="cuota_riesgo_total" value="-1" />
	<input type="hidden" name="tipo_cliente" value="-1" />
	<input type="hidden" name="orden" id="orden" value="" />
	<input type="hidden" name="btnNivelVinculacion" id="btnNivelVinculacion" value="" />
	<html:hidden property="cod_empresa" value="-2" />
	<table border=0 cellspacing="0">
	<!-- FILTROS -->
	<tr>
		<td style="vertical-align:middle;" colspan="2" >
			<table border=0 width="100%" align="center">
				<c:if test="${sessionScope.perfil.cod_perfil!='LC06'}">
				<tr>
					<td class="FondoAzulPeq" width="16%">TERRITORIO</td>
					<td width="16%">
						<html:select property="territorio" styleId="territorio" disabled='${terr}' styleClass="filtro"
						onchange="resetEmpresa();llenarOficinas()" style="width:165px;">
						<html:option value="-1" selected>TODOS</html:option>
						<c:if test="${listaTerritorio != null}">
							<c:forEach var="territorio" items="${listaTerritorio}">
								<html:option value="${territorio.cod_territorio}">
									<c:out value="${territorio.des_territorio}" />
								</html:option>
							</c:forEach>
						</c:if>
						</html:select>
					</TD>
				<td width="2%"></td>
				<td class="FondoAzulPeq" width="16%">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="20" align="center"><img src="<c:out value="${pageContext.request.contextPath}"/>/images/ajax-loader2.gif" border="0" id="loaderOficina" style="visibility:hidden;" width="16" height="16"></td>
						<td class="FondoAzulPeq">OFICINA</td>
						<td width="20" align="center"></td>
					</tr>
					</table>
				</td>
				<td width="16%"><html:select property="oficina" styleId="oficina" disabled='${ofic}' styleClass="filtro"
					onchange="resetEmpresa();llenarGestores();" style="width:165px;">
					<html:option value="-1" selected>TODOS</html:option>
					<c:if test="${listaOficina != null}">
						<c:forEach var="oficina" items="${listaOficina}">
							<html:option value="${oficina.cod_oficina}">
								<c:out value="${oficina.des_oficina}" />
							</html:option>
						</c:forEach>
					</c:if>
				</html:select></td>
				<td width="2%"></td>
				<td class="FondoAzulPeq" width="16%">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="20" align="center"><img src="<c:out value="${pageContext.request.contextPath}"/>/images/ajax-loader2.gif" border="0" id="loaderGestor" style="visibility:hidden;" width="16" height="16"></td>
						<td class="FondoAzulPeq">GESTOR</td>
						<td width="20" align="center"></td>
					</tr>
					</table>
				</td>
				<td width="16%"><html:select property="gestor" styleId="gestor"  disabled='${gest}' styleClass="filtro2" onchange="resetEmpresa();"    style="width:220px;">
					<html:option    value="-1" selected  >TODOS</html:option>
					<c:if test="${listaGestor != null}">
						<c:forEach var="gestor" items="${listaGestor}">
							<html:option value="${gestor.cod_gestor}">
								<c:out value="${gestor.nom_gestor}" /> - <c:out value="${gestor.perfil_gestor}" />  
							</html:option>
						</c:forEach>
					</c:if>
				</html:select></td>
			</tr>
			</c:if>
			<c:if test="${sessionScope.perfil.cod_perfil=='LC06'}">
			<tr> 
				<td class="FondoAzulPeq" width="16%" align="left" >TERRITORIO</td>
			 	<td width="16%">
					<input type="button" class="botonFiltro" id="btnTerritorio" value="Todos" onclick="abrirFiltro(6);" />
					<input type="hidden" id="territorio" name="territorio" value="-1"/>
			 	</td>
				<td width="2%"></td>
				<td class="FondoAzulPeq"  width="16%">OFICINA</td>
				<td width="16%">
					<input type="button" class="botonFiltro" id="btnOficina" value="Todos" onclick="abrirFiltro(7);" />
					<input type="hidden" id="oficina" name="oficina" value="-1"/>
				</td>
				<td width="2%"></td>
				<td class="FondoAzulPeq" width="16%" >GESTOR</td>
				<td width="16%">
					<input type="button" class="botonFiltro" id="btnGestor" value="Todos" onclick="abrirFiltro(8);" style="width:220px;"/>
					<input type="hidden" id="gestor" name="gestor" value="-1"/>
				</td>
			</tr>
			</c:if>
			<TR>
				<TD class="FondoAzulPeq"><div class="enlace2" align="center"><a href="javascript:popup();">ETIQUETA</a></div></TD>
				<TD><input type="button" class="botonFiltro" id="btnEtiqueta" value="Todos" onclick="abrirFiltro(3);" />
				</TD>
				<TD></TD>			
				<TD class="FondoAzulPeq">CLASIFICACI&Oacute;N</TD>
				<TD><input type="button" class="botonFiltro" id="btnClasificacion" value="Todos" onclick="abrirFiltro(1);" />
				</TD>
				<TD></TD>
				<TD class="FondoAzulPeq">MARGEN ORDINARIO</TD>
				<TD><input type="button" class="botonFiltro" id="btnMargenOrdinario" value="Todos"  style="width:220px;" onclick="abrirFiltro(2);" />
				</TD>
			</TR>
			<TR>
				<td class="FondoAzulPeq">TIPO CLIENTE</td>
				<td>
					<input type="button" class="botonFiltro" id="btnTipoCliente" value="Todos" onclick="abrirFiltro(9);" />
				</td>
				<td></td>
				<TD class="FondoAzulPeq">EDAD</TD>
				<TD><input type="button" class="botonFiltro" id="btnEdad" value="Todos" onclick="abrirFiltro(4);" />
				</TD>
				<TD></TD>
				<TD class="FondoAzulPeq">CUOTA RIESGO TOTAL</TD>
				<TD><input type="button" class="botonFiltro" id="btnCuotaRiesgoTotal" style="width:220px;" value="Todos" onclick="abrirFiltro(5);" />
				</TD>
			</TR>
			<!-- MEJORA : PAGO DE HABERES : P060049 EDGAR ZAVALETA SIERRALTA -->
			<tr>
				<td class="FondoAzulPeq">PAGO DE HABERES</td>
				<td>
					<input type="button" class="botonFiltro" id="btnCodEmpresa" value="Todos" onclick="abrirFiltro(10);" />
					<!--  html:text property="des_empresa" styleClass="empresa" value="TODOS" readonly="true" /><IMG id="buscarPagoHaberes" alt="Agregar" border="0"  src="<c:out value="${pageContext.request.contextPath}"/>/images/search_16.gif" width="16" height="16" style="CURSOR: hand" onclick="abrirListaEmpresas();"/ -->
				</td>
				<td></td>
				<td class="FondoAzulPeq">CLIENTE</td>
				<td><html:text property="cod_cliente" styleClass="empresa" value="" maxlength="8" onblur="if(this.value.length > 0) this.value = padL(this.value, 8);" /><img id="buscarCliente" alt="Buscar" border="0"  src="<c:out value="${pageContext.request.contextPath}"/>/images/search_16.gif" width="16" height="16" style="cursor: hand" onclick="consultaCliente();"/>
				</td>
			</TR>
			<tr>
				<td colspan='8'>
				<table style="width: 100%">
				<tr>
				<td style="width: 25%; height: 30px;vertical-align: middle;">
					<a href="javascript:void(0);" onclick="openGlosario();" >
						<b>Glosario Lineas Comerciales</b>
					</a>
				</td>
				<td style="width: 50%; height: 30px;vertical-align: middle;text-align: center;">
					<div id="alert_fecha" style="font-weight: bold;font-size: 120%;color:#f00;">Fecha de &Uacute;ltima Carga: <c:out value="${requestScope.fechaCarga}"/></div>
				</td>
				<td style="width: 25%;text-align: right;">
				<input name="btnLimpiar" type="button" class="boton" onclick="limpiar();" value="Limpiar" style="width:70px;">
				<html:button property="btnBuscar" styleClass="boton" onclick="consulta();" style="width:70px;">Buscar</html:button>
				</td>
				</tr>
				</table>
				</td>
			</tr>
		</TABLE>
		</td>
	</tr>
	<!-- /FILTROS -->
	
	<!-- DETALLE DE FILTROS -->
	<tr>
		<td style="vertical-align:middle;" colspan="2" > 
			<div id="divDetalleFiltros" class="detalle" style="visibility:hidden;"></div>
		</td>
	</tr>
	<!-- /DETALLE DE FILTROS -->
	
	<!-- TABS -->
	<tr height="38" >
		<td colspan="2">
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr style="background-color:#dceaf4;">
					<td>&nbsp;</td>
					<td style="vertical-align:middle;">
					<div id="radio_txt" style="display:none; height: 38px; font-size: 85%;vertical-align: middle;"></div>
					<div id="radio" style="height: 38px; font-size: 85%;vertical-align: middle;">
					<logic:notEmpty name = "listadoRadios">
						<logic:iterate name="listadoRadios" id="vinc">
							<input type="radio"
								id="radio${vinc.orden}"
								name="tipo_detalle"
								value='<bean:write name="vinc" property="detalle"/>' 
								onclick='<bean:write name="vinc" property="funcion"/>'>
							<label id="radio_txt${vinc.orden}" class="option-ui" for="radio${vinc.orden}"><bean:write name="vinc" property="descorta" /></label>
						</logic:iterate>
	                </logic:notEmpty>
					</div>
					</td>
					<td>
						<table border="0" cellspacing="0" cellpadding="0" align="right">
						<tr>
							<td colspan="2" style="text-align:right;">
								
							</td>
						</tr>
						<tr>
							<td style="text-align:center;padding-left:5px;padding-right:5px;font-size:10px;">
								<img id="btnExcel" 
									src="<c:out value="${pageContext.request.contextPath}"/>/images/btnExcel0.gif" 
									width="28" 
									height="23" 
									border="0"
									style="CURSOR: hand" 
									onclick="openFile('exportacion');">
								<br>Exportar
							</td>
							<td style="text-align:center;padding-left:5px;padding-right:5px;font-size:10px;">
								<img name="mundosueldo" 
									border="0" 
									style="CURSOR: hand"
									src="<c:out value="${pageContext.request.contextPath}"/>/images/almacen2.jpg"
									width="28" height="23"
									onclick="window.open('<c:out value="${requestScope.link1}"/>','iilc_mundosueldo');">
								<br>
								Alm. Oferta
							</td>
						</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="background:url('images/baseFiltros.gif') top repeat-x;height:16px;"></td>
	</tr>
	<!-- /TABS -->
	
	<!-- RESULTADOS -->
	<tr class="FondoClaro">
		<td colspan="2">
			<table border="0" cellspacing="0" cellpadding="0" style="height:100%;table-layout:fixed;width:100%;">
			<tr>
			<td>
				<div id="divProceso" style="height:240px;width:100%;background:url('images/ajaxConsulta.gif') center no-repeat; visibility:hidden; position:absolute;"></div>
				<table style="width: 100%">
				<tr>
					<td style="width: 200px;">&nbsp;</td>
					<td style="text-align: center">
						<div id="divPaginacion" style="text-align:center;">
							<span id="spanPagPri" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver primera página" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_primero.png" width="16" height="16" onclick="consultaPagina('pri')"></span>
							<span id="spanPagAnt" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver página anterior" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_anterior.png" width="16" height="16" onclick="consultaPagina('ant')"></span>
							<span id="spanPagText" style="width:200px;vertical-align:middle;text-align:center;"></span>
							<span id="spanPagSig" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver página siguiente" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_siguiente.png" width="16" height="16" onclick="consultaPagina('sig')"></span>
							<span id="spanPagUlt" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver última página" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_ultimo.png" width="16" height="16" onclick="consultaPagina('ult')"></span>
						</div>
					</td>
					<td style="width: 200px;">
						<span style="float:right;">Clientes por Pag.: <input id="numRegXPag" 
						name="numRegXPag" 
						value="20" 
						maxlength="5" 
						size="5"
						onkeyup ="if(event.keyCode==13){consultaPagina('pri');}" 
						onfocus="this.select();" 
						class="cajaPagina"></span>
					</td>
				</tr>
				</table>
				<div id="divResultados" style="overflow:hidden; width:100%;">
					<input type="hidden" ID="RowNo" NAME="RowNo" value="-1">
					<input type="hidden" ID="ColumnNo" NAME="ColumnNo">
					<span id="myGrid"></span>
				</div>
			</td>
			</tr>
			</table>
		</td>
	</tr>
	<!-- /RESULTADOS -->
	</table>
</html:form>
		
		</td>
	</tr>
	</table>
</td>
<td id="rightPanel" style="display: none; border-left: 1px #dadada solid;" valign="top">
	<table style="width: 290px">
		<tr class="FondoAzul">
		<td class="LCtd" style="height: 30px; line-height: 30px; vertical-align: middle;text-align: center;"><b>Descargas</b></td>
		</tr>
	</table>
	<div id="xthreads"></div>
</td>
</tr>
</table>
</body>
</html:html>