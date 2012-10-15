<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<HEAD>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">

<TITLE>CARPETAS COMERCIALES</TITLE>

<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
<script language="javascript" src="includes/index_combos.js"></script>

<!-- js y css para grilla -->
<script src="aw_runtime/lib/aw.js" type="text/javascript"></script>
<script src="includes/grilla.js" type="text/javascript"></script>
<link href="aw_runtime/styles/oso/aw.css" rel="stylesheet">
<script src="includes/index_grilla.js" type="text/javascript"></script>
<script src="includes/common.js" type="text/javascript"></script>
<script src="includes/AjaxRequest.js" type="text/javascript"></script>
<script src="includes/AjaxCommon.js" type="text/javascript"></script>
<!-- NO BORRAR LOS ATRIBUTOS TITLE DE ESTOS CSS -->
<link href="aw_runtime/styles/oso/extras_grilla.css" rel="stylesheet" title="cssEstiloGrilla">
<link rel="stylesheet" href="theme/bloqueCeldas.css" title="cssEstilosCeldas">

<script language="javascript">
var hayResultados = false;
var numPag=0;
var totalPag=0;
var tipo_detalle = '0';

function pageInit(){
	limpiarResultados();
	carga();
	pintarDetalles('');
}

function highlight(obj,flag,id){
	if(flag==1){
		obj.className = 'detallehover';
		document.getElementById("td"+(id+3)).className = 'FondoAzulPeqHighlight';
		try{
			document.getElementById("td"+(id+3)+"b").className = 'FondoAzulPeqHighlight';
		} catch(e){}
	}
	else{
		obj.className = 'detalle';
		document.getElementById("td"+(id+3)).className = 'FondoAzulPeq';
		try{
			document.getElementById("td"+(id+3)+"b").className = 'FondoAzulPeq';
		} catch(e){}
	}
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
	    	
	abrir(url,"iilc_pagohaberes");
}

function limpiar(){
	limpiarResultados();
	limpiarFiltros();
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
	pintarDetalles("");
	highlightTab(-1);
}

function limpiarFiltros(){
	document.forms[0].nivel_vinculacion.value="-1";
	document.forms[0].clasificacion.value="-1";
	document.forms[0].margen_ordinario.value="-1";
	document.forms[0].etiqueta.value="-1";
	document.forms[0].edad.value="-1";
	document.forms[0].cuota_riesgo_total.value="-1";
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
	
	var url = "consulta2.do?method=filtro&tipo=" + tipo + "&d=" + (new Date().getTime());
	
	if(window.showModalDialog(url,datoFiltro,"dialogWidth:240px;dialogHeight:360px;")){
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
		
		resetEmpresa();
		updateBotonesFiltro();
	}
	else{
		return;
	}
}

function updateBotonesFiltro(){
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
	
}


function carga(){
	if (document.forms[0].territorio.value != "-1"){
     	if (document.forms[0].oficina.value == "-1"){
    		//document.forms[0].oficina.focus();
     	}else{
	     	if (document.forms[0].gestor.value == "-1"){
	    		//document.forms[0].gestor.focus();
	     	}
	    }
	}    
}

function openFile(tipo){
	if(hayResultados){
		var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300px, height=200px, top=85, left=140";
		ventana = window.open("<c:out value="${pageContext.request.contextPath}"/>/consultaListadoConduccionAction.do?method=espera&tipo="+tipo,"",opciones);
	}
	else{
		alert("No hay resultados para exportar.");
	}
}
function popup(){
window.open("cargaDatos.do?method=cargaEtiquetaSegmento","popup" , "width=800,height=400,scrollbars=YES,left=220,top=200,screenX=0,screenY=100'")
}
function popup2(){
window.open("pages/iilc_nivel_vinculacion.jsp","popup" , "width=600,height=400,scrollbars=YES,left=220,top=200,screenX=0,screenY=100'")
}

function mostrarTabla(param,codigo){
    territorio = document.getElementById("territorio").value;
    oficina = document.getElementById("oficina").value;
    gestor = document.getElementById("gestor").value;

	document.forms[0].target="_self";
	document.forms[0].action="cargaDatos.do?method=cargaNVyET&parametro="+param+"&codigo="+codigo+"&codTerritorio="+territorio+"&codOficina="+oficina+"&codGestor="+gestor;
	document.forms[0].submit();		
}

function consulta(){
	hayResultados = false;
	tipo_detalle = '0';
	
	AjaxRequest.get(
	  {
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'buscar2',
	    	'territorio':document.forms[0].territorio.value,
	    	'oficina':document.forms[0].oficina.value,
	    	'gestor':document.forms[0].gestor.value,
	    	'nivelVinculacion':document.forms[0].nivel_vinculacion.value,
	    	'clasificacion':document.forms[0].clasificacion.value,
	    	'margenOrdinario':document.forms[0].margen_ordinario.value,
	    	'etiqueta':document.forms[0].etiqueta.value,
	    	'edad':document.forms[0].edad.value,
	    	'cuotaRiesgoTotal':document.forms[0].cuota_riesgo_total.value,
	    	'codEmpresa':document.forms[0].cod_empresa.value
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
	    				procesarResultado(req);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicación.  Intente nuevamente.");
						mostrarProceso(0);
						pintarDetalles("");
						desbloquear();
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicación.");
						mostrarProceso(0);
						pintarDetalles("");
						desbloquear();
		 			}
	  }
	);
	
	limpiarResultados();
	bloquear();
	mostrarProceso(1);
}

function consultaDetalle(num){
	tipo_detalle = num;
	hayResultados = false;
	var i;
	AjaxRequest.get(
	  {
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'detalle2',
	    	'tipo_detalle':num
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
	    				procesarResultado(req);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicación.  Intente nuevamente.");
						mostrarProceso(0);
						pintarDetalles("");
						desbloquear();
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicación.");
						mostrarProceso(0);
						pintarDetalles("");
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
			alert("No es un número de página válido");
		}
		else{
			if(objPag.value<1 || objPag.value>totalPag){
				alert("El número de página debe estar entre 1 y " + totalPag);
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
	
	AjaxRequest.get(
	  {
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'paginacion2',
	    	'numPag':nuevoNumPag,
	    	'tipo_detalle':tipo_detalle
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
	    				procesarResultado(req);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicación.  Intente nuevamente.");
						mostrarProceso(0);
						pintarDetalles("");
						desbloquear();
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicación.");
						mostrarProceso(0);
						pintarDetalles("");
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
		alert("El servidor ha retornado una respuesta no válida (" + res + ")");
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
			alert("El servidor ha retornado una respuesta no válida (" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no válida (" + res + ")");
		return false;
	}
	
	//validar el índice de detalle (2)
	try{
		if(!esSoloNumero(partes["tipoDetalle"])){
			alert("El servidor ha retornado una respuesta no válida (" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no válida (" + res + ")");
		return false;
	}
	
	//validar la página actual (3)
	try{
		if(!esSoloNumero(partes["pagActual"])){
			alert("El servidor ha retornado una respuesta no válida (" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no válida (" + res + ")");
		return false;
	}
	
	//validar el total de páginas (4)
	try{
		if(!esSoloNumero(partes["numPags"])){
			alert("El servidor ha retornado una respuesta no válida (" + res + ")");
			return false;
		}
		res++;
	}catch(e){
		alert("El servidor ha retornado una respuesta no válida (" + res + ")");
		return false;
	}
	return true;
}

function procesarResultado(req){
	var paso = 10;
	var rspText = limpiarDatosAjax(req.responseText);
	if (rspText == "exp"){
		if(confirm("La sesión ha expirado. ¿Desea volver a cargar la página?")){
			window.location.reload();
		}
	}
	else {
		if(validarRespuesta(rspText)){
			try{
				var partes = eval(rspText)[0];				
				
				if(partes["datos"].length==0){					
					pintarDetalles(partes["datosDetalleFiltros"]);
					alert("No se encontraron resultados.");
				}
				else{
					paso++;//11
					var cabeceras = partes["cabeceras"];
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
					highlightTab(partes["tipoDetalle"]);
					hayResultados = true;
				}
			}
			catch(e){
			alert("El servidor ha retornado una respuesta no válida (" + paso + ")");
				limpiarResultados();
			}
		}
	}
	mostrarProceso(0);
	paso++;//17
	desbloquear(hayResultados);
}

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
				html+="<tr class='detalle' onmouseover='highlight(this,1," + (i+1) + ");' onmouseout='highlight(this,0," + (i+1) + ");'>";
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
	//if(j>0){
		objDiv.innerHTML = html;
		objDiv.style.visibility = "visible";
	//}
	//else{
	//	objDiv.innerHTML = "";
	//	objDiv.style.visibility = "hidden";
	//}
		
}

function resetEmpresa(){
	document.forms[0].des_empresa.value = 'TODOS';
	document.forms[0].cod_empresa.value = '-1'
}
</script>
</HEAD>

<BODY onload="pageInit();">
<html:form action="/consultaListadoConduccionAction">
<input type="hidden" name="method" />
<!-- input type="hidden" name="gestorCombo" value="-1" / -->
<input type="hidden" name="nivel_vinculacion" value="-1" />
<input type="hidden" name="clasificacion" value="-1" />
<input type="hidden" name="margen_ordinario" value="-1" />
<input type="hidden" name="etiqueta" value="-1" />
<input type="hidden" name="edad" value="-1" />
<input type="hidden" name="cuota_riesgo_total" value="-1" />

<html:hidden property="cod_empresa" value="-1" />

	<div class="headerVersion">1.01.06</div>

	<table class="container" cellspacing="0">

<!-- TITULO -->
<tr>
	<td colspan="2" class="header">CARPETAS COMERCIALES</td>
</tr>
<!-- /TITULO -->

<!-- FILTROS -->
<tr>
	<td style="vertical-align:middle;">
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzulPeq" width="16%" id="td1"><bean:message key="territorio" /></TD>
				<TD width="16%"><html:select property="territorio" styleId="territorio" disabled='${terr}' styleClass="filtro"
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
			<TD width="2%"></TD>
			<TD class="FondoAzulPeq" width="16%" id="td2">
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td width="20" align="center"><img src="images/ajax-loader2.gif" border="0" id="loaderOficina" style="visibility:hidden;" width="16" height="16"></td>
					<td class="FondoAzulPeq" id="td2b">OFICINA</td>
					<td width="20" align="center"></td>
				</tr>
				</table>
			</TD>
			<TD width="16%"><html:select property="oficina" styleId="oficina" disabled='${ofic}' styleClass="filtro"
				onchange="resetEmpresa();llenarGestores();" style="width:165px;">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaOficina != null}">
					<c:forEach var="oficina" items="${listaOficina}">
						<html:option value="${oficina.cod_oficina}">
							<c:out value="${oficina.des_oficina}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD width="2%"></TD>
			<TD class="FondoAzulPeq" width="16%" id="td3">
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td width="20" align="center"><img src="images/ajax-loader2.gif" border="0" id="loaderGestor" style="visibility:hidden;" width="16" height="16"></td>
					<td class="FondoAzulPeq" id="td3b">GESTOR</td>
					<td width="20" align="center"></td>
				</tr>
				</table>
			</TD>
			<TD width="16%"><html:select property="gestor" styleId="gestor" disabled='${gest}' styleClass="filtro2" onchange="resetEmpresa();" style="width:165px;">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaGestor != null}">
					<c:forEach var="gestor" items="${listaGestor}">
						<html:option value="${gestor.cod_gestor}">
							<c:out value="${gestor.nom_gestor}" /> - <c:out value="${gestor.perfil_gestor}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
		</TR>
		<TR>
			<TD class="FondoAzulPeq" id="td4"><div class="enlace2" align="center"><a href="javascript:popup2();">NIVEL DE VINCULACIÓN</a></div></TD>
			<TD><input type="button" class="botonFiltro" id="btnNivelVinculacion" value="Todos" onclick="abrirFiltro(0);" />
			</TD>
			<TD></TD>
			<TD class="FondoAzulPeq" id="td5">CLASIFICACIÓN</TD>
			<TD><input type="button" class="botonFiltro" id="btnClasificacion" value="Todos" onclick="abrirFiltro(1);" />
			</TD>
			<TD></TD>
			<TD class="FondoAzulPeq" id="td6">MARGEN ORDINARIO</TD>
			<TD><input type="button" class="botonFiltro" id="btnMargenOrdinario" value="Todos" onclick="abrirFiltro(2);" />
			</TD>
		</TR>
		<TR>
			<TD class="FondoAzulPeq" id="td7"><div class="enlace2" align="center"><a href="javascript:popup();">ETIQUETA</a></div></TD>
			<TD><input type="button" class="botonFiltro" id="btnEtiqueta" value="Todos" onclick="abrirFiltro(3);" />
			</TD>
			<TD></TD>
			<TD class="FondoAzulPeq" id="td8">EDAD</TD>
			<TD><input type="button" class="botonFiltro" id="btnEdad" value="Todos" onclick="abrirFiltro(4);" />
			</TD>
			<TD></TD>
			<TD class="FondoAzulPeq" id="td9">CUOTA RIESGO TOTAL</TD>
			<TD><input type="button" class="botonFiltro" id="btnCuotaRiesgoTotal" value="Todos" onclick="abrirFiltro(5);" />
			</TD>
		</TR>
		<!-- MEJORA : PAGO DE HABERES : P060049 EDGAR ZAVALETA SIERRALTA -->
		<TR>
			<TD class="FondoAzulPeq" id="td10">PAGO DE HABERES</TD>
			<TD colspan="6">
				<html:text property="des_empresa" styleClass="empresa" value="TODOS" readonly="true" /><IMG id="buscarPagoHaberes" alt="Agregar" border="0"  src="images/search_16.gif" width="16" height="16" style="CURSOR: hand" onclick="abrirListaEmpresas();"/>
			</TD>
			<TD colspan="6">
			<input name="btnLimpiar" type="button" class="boton" onclick="limpiar();" value="Limpiar" style="width:80px;">
			<html:button property="btnBuscar" styleClass="boton" onclick="consulta();" style="width:80px;">BUSCAR</html:button>
			</TD>
		</TR>
	</TABLE>
	</td>
</tr>
<tr>
	<!-- td colspan="2" style="background-color:#dceaf4; height:16px;"></td -->
	<td colspan="2" style="background:url('images/baseFiltros.gif') top repeat-x;height:16px;"></td>
</tr>
<!-- /FILTROS -->





<!-- TABLAS REFERENCIALES -->
<tr class="FondoClaro">
	<td style="vertical-align:middle;">
		<div id="divDetalleFiltros" class="detalle" style="visibility:hidden;">
		
		</div>
	</td>
</tr>
<!-- /TABLAS REFERENCIALES -->








<!-- RESULTADOS -->
<tr class="FondoClaro">
	<td colspan="2">
		<br />
		<table cellspacing="0" cellpadding="0" border="0" style="height:48px;">
		<tr>
			<td class="gridMenu1" id="tdMenu0"><div id="spanMenu0"><a href="javascript:void(0);" onclick="consultaDetalle(0);">TODO</a></div></td>
			<td class="gridMenu1" id="tdMenu1"><div id="spanMenu1"><a href="javascript:void(0);" onclick="consultaDetalle(1);">DETALLE ACTIVO</a></div></td>
			<td class="gridMenu1" id="tdMenu2"><div id="spanMenu2"><a href="javascript:void(0);" onclick="consultaDetalle(2);">DETALLE TARJETAS</a></div></td>
			<td class="gridMenu1" id="tdMenu3"><div id="spanMenu3"><a href="javascript:void(0);" onclick="consultaDetalle(3);">DETALLE PASIVO</a></div></td>
			<td class="gridMenu1" id="tdMenu4"><div id="spanMenu4"><a href="javascript:void(0);" onclick="consultaDetalle(4);">DETALLE SERVICIOS</a></div></td>
			<td class="gridMenu1" id="tdMenu5"><div id="spanMenu5"><a href="javascript:void(0);" onclick="consultaDetalle(5);">DETALLE CANALES</a></div></td>
			<td class="gridMenu1" id="tdMenu6"><div id="spanMenu6"><a href="javascript:void(0);" onclick="consultaDetalle(6);">DETALLE OFERTAS</a></div></td>
			<td class="gridMenu2">
				<div id="divPaginacion">
					<span id="spanPagPri" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver primera página" border="0" style="CURSOR: hand" src="images/btn_primero.png" width="16" height="16" onclick="consultaPagina('pri')"></span>
					<span id="spanPagAnt" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver página anterior" border="0" style="CURSOR: hand" src="images/btn_anterior.png" width="16" height="16" onclick="consultaPagina('ant')"></span>
					<span id="spanPagText" style="width:140px;vertical-align:middle;text-align:center;"></span>
					<span id="spanPagSig" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver página siguiente" border="0" style="CURSOR: hand" src="images/btn_siguiente.png" width="16" height="16" onclick="consultaPagina('sig')"></span>
					<span id="spanPagUlt" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver última página" border="0" style="CURSOR: hand" src="images/btn_ultimo.png" width="16" height="16" onclick="consultaPagina('ult')"></span>
				</div>
			</td>
			<td class="gridMenu3">
				<table border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td style="text-align:center;padding-left:5px;padding-right:5px;font-size:10px;">
						<img id="btnExcel" src="images/btnExcel0.gif" width="28" height="28" border="0"
						style="CURSOR:hand;vertical-align:middle;" onclick="openFile('exportacion');"> Exportar
					</td>
					<td style="text-align:center;padding-left:5px;padding-right:5px;font-size:10px;">
						<IMG name="mundosueldo" border="0" style="CURSOR:hand;vertical-align:middle;"
						src="images/almacen2.gif"
						width="28" height="28"
						onclick="window.open('<c:out value="${requestScope.link1}"/>','iilc_mundosueldo');"> Alm. Oferta
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<div id="divProceso" style="height:240px;width:100%;background:url('images/ajaxConsulta.gif') center no-repeat; visibility:hidden; position:absolute;"></div>
		<div id="divResultados" style="overflow:hidden; width:100%;">
			<input type="hidden" ID="RowNo" NAME="RowNo" value="-1">
			<input type="hidden" ID="ColumnNo" NAME="ColumnNo">
			<span id="myGrid"></span>
		</div>
	</td>
</tr>
<!-- /RESULTADOS -->
</table>
</html:form>
</BODY>
</html:html>



