<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Accion"%>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
<meta name="generator" content="Bluefish 2.0.3" >
<META http-equiv="Content-Style-Type" content="text/css">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
String codOficinaCompleto= (String)request.getAttribute("codOficinaCompleto");
String codGestor= (String) request.getAttribute("codGestor");
String codAnho= (String) request.getAttribute("codAnho");
String codMes= (String) request.getAttribute("codMes");
String nomEpigrafe= (String) request.getAttribute("nomEpigrafe");
String prioridad= (String) request.getAttribute("prioridad");
String restoOficina= (String) request.getAttribute("restoOficina");
String metaGestor= (String) request.getAttribute("metaGestor");
String codEpigrafe= (String) request.getAttribute("codEpigrafe");
String codAccion = (String) request.getParameter("codAccion"); 
Accion dtoAccion = (Accion) request.getAttribute("dtoAccion");
String totalAcciones = (String) request.getAttribute("totalAcciones");
String objetivos = (String) session.getAttribute("___objGestor");
 
String descAccion= "";
int numeroCliente= 0;
int compromisoGestor= 0;

%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>
<script language="javascript">
/**
* Agregar validacion si se ingresa un numero positivo en la caja de texto "Compromiso Gestor (Monto en Miles / Numero)"Äù para el epigrafe "ÄúCartera Atrasada" (Monto o Ratio) emitir el siguiente mensaje de alerta "ÄúEl compromiso de cartera atrasada debe ser negativo"Äù y no permitir grabar. 
* Agregar validacion si se ingresa un numero mayor a 9999 en la caja de texto "Compromiso Gestor"Äù emitir el siguiente mensaje de alerta "El monto ingresado debe corresponder a miles de soles"Äù y debe permitir grabar.
* En el momento que el gestor seleccione un epÌgrafe se debe validar si se registraron objetivos, en caso se hayan registrado se mostrara la pantalla de ingreso de acciones, caso contrario en la siguiente pantalla se emitira el mensaje No hay objetivos para este epigrafe, comunicar al Gerente de Oficina".
*/
var objetivos=parseFloat('<%=objetivos%>');
$(function(){
	if(parseInt(objetivos) == 0) {
		alert("No hay objetivos para este epigrafe, comunicar al Gerente de Oficina");
		$("input[name=Grabar]").attr('disabled', true);
	}
	
	$("input[name=compGestor]").blur(function(){
		/* if(parseFloat($(this).val())>9999) {
			alert("El monto ingresado debe corresponder a miles de soles");
		}*/
		
		var disabled = false;
		var cellContent = '<%=nomEpigrafe%>';
		if(cellContent.toUpperCase().indexOf('CARTERA ATRASADA')>=0) {
			if(parseInt($(this).val())>0) {
				disabled = true;
				alert('La cartera atrasada debe ser negativa');
				$(this).focus();
			}
		} else {
			if(parseInt($(this).val())<0) {
				disabled = true;
				alert('El monto no puede ser negativo');
				$(this).focus();
			}
		}
		
		// $('input[name=Grabar]').attr('disabled', disabled);
	});	
});

function grabar(codOficinaCompleto, codGestor, codAnho, codMes, nomEpigrafe, prioridad, restoOficina, metaGestor, codEpigrafe){
	var codOficinaCompleto=codOficinaCompleto;
	var codGestor=codGestor;
	var codAnho=codAnho;
	var codMes=codMes;
	var nomEpigrafe=nomEpigrafe;
	var prioridad=prioridad;
	var restoOficina=restoOficina;
	var metaGestor=metaGestor;
	var codEpigrafe=codEpigrafe;
	
	var _valid = 0;	
	
	$("input[name=compGestor]").each(function(){
		if(parseFloat($(this).val())>9999) {
			alert("El monto ingresado debe corresponder a miles de soles");
			_valid = 0;
		}
		
		var cellContent = '<%=nomEpigrafe%>';
		if(cellContent.toUpperCase().indexOf('CARTERA ATRASADA')>=0) {
			if(parseInt($(this).val())>0) {
				alert('La cartera atrasada debe ser negativa');
				$(this).focus();
				_valid = 1;
			}
		} else {
			if(parseInt($(this).val())<0) {
				alert('El monto no puede ser negativo');
				$(this).focus();
				_valid = 1;
			}
		}
	});	

	if(_valid == 1){
		return false;
	}
	
	var descAccion=document.forms.nombreAccion.value;
	var numeroCliente=document.forms.numeroClientes.value;
	var compromisoGestor=document.forms.compGestor.value;
	
	document.forms.codOficinaCompleto.value=codOficinaCompleto;
	document.forms.codGestor.value=codGestor;
	document.forms.codAnho.value=codAnho;
	document.forms.codMes.value=codMes;
	document.forms.nomEpigrafe.value=nomEpigrafe;
	document.forms.prioridad.value=prioridad;
	document.forms.restoOficina.value=restoOficina;
	document.forms.metaGestor.value=metaGestor;
	
	document.forms.descAccion.value=descAccion;
	document.forms.numeroCliente.value=numeroCliente;
	document.forms.compromisoGestor.value=compromisoGestor;
	document.forms.codEpigrafe.value=codEpigrafe;

	if(descAccion == "") {
		alert("Ingrese descripci\u00F3n");
		return false;
	}

	if(numeroCliente == "") {
		alert("Ingrese Nro. de Clientes");
		return false;
	}
		
	if(compromisoGestor == "") {
		alert("Ingrese Compromiso Gestor");
		return false;
	}

	document.forms.action="reportePPGAction.do?method=edicionAccion&codAccion=<%=codAccion %>";
	// var resp = confirm("¬øDesea guardar los cambios?");
	var resp = confirm("Desea guardar los cambios?");
	if(resp) {
		document.forms.submit();
	}
}

function volver(codOficinaCompleto, codGestor, codAnho, codMes, nomEpigrafe, prioridad, restoOficina, metaGestor, codEpigrafe){	
	var codOficinaCompleto=codOficinaCompleto;
	var codGestor=codGestor;
	var codAnho=codAnho;
	var codMes=codMes;
	var nomEpigrafe=nomEpigrafe;
	var prioridad=prioridad;
	var restoOficina=restoOficina;
	var metaGestor=metaGestor;
	var codEpigrafe=codEpigrafe;
	
	document.forms.codOficinaCompleto.value=codOficinaCompleto;
	document.forms.codGestor.value=codGestor;
	document.forms.codAnho.value=codAnho;
	document.forms.codMes.value=codMes;
	document.forms.nomEpigrafe.value=nomEpigrafe;
	document.forms.prioridad.value=prioridad;
	document.forms.restoOficina.value=restoOficina;
	document.forms.metaGestor.value=metaGestor;
	document.forms.codEpigrafe.value=codEpigrafe;
				
	document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones3";
	document.forms.submit();
}
</script>
</HEAD>

<BODY>
<form  method="post" name="forms">
<input type="hidden" name="codAnho" >
<input type="hidden" name="codMes" >
<input type="hidden" name="codOficina" >
<input type="hidden" name="codGestor" >
<input type="hidden" name="codigos" >
<input type="hidden" name="nomEpigrafe" >
<input type="hidden" name="prioridad" >
<input type="hidden" name="restoOficina" >
<input type="hidden" name="metaGestor" >
<input type="hidden" name="codOficinaCompleto" >

<input type="hidden" name="descAccion" >
<input type="hidden" name="numeroCliente" >
<input type="hidden" name="compromisoGestor" >
<input type="hidden" name="codEpigrafe" >

<input type="hidden" name="codCamp" >
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">PPG / ACCIONES</td>	
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">


			<!-- **** INICIO RESTO DE C√ìDIGO DE LA P√ÅGINA-->
	<TABLE align="center" >
		<TR>
			<TD>OFICINA</TD>
			<TD ALIGN="left"><%=codOficinaCompleto %></TD>
		</TR>
		<TR>
			<TD>A&Ntilde;O</TD>
			<TD ALIGN="left"><%=codAnho %></TD>
		</TR>
		<TR>
			<TD>MES</TD>
			<TD ALIGN="left">
			<%if(codMes.equals("01")){ %>ENERO<%}else if(codMes.equals("02")){%>FEBRERO<%}else if(codMes.equals("03")){ %>
			MARZO<%}else if(codMes.equals("04")){ %>ABRIL<%}else if(codMes.equals("05")){ %>MAYO<%}else if(codMes.equals("06")){ %>JUNIO<%}
			else if(codMes.equals("07")){ %>JULIO<%}else if(codMes.equals("08")){ %>AGOSTO<%}else if(codMes.equals("09")){ %>SETIEMBRE<%}
			else if(codMes.equals("10")){ %>OCTUBRE<%}else if(codMes.equals("11")){ %>NOVIEMBRE<%}else {%>DICIEMBRE<%}%>
			</TD>
		</TR>
		<TR>
			<TD>PRIORIDAD</TD>
			<TD ALIGN="left">${prioridad}</TD>
		</TR>
		<TR>
			<TD>EPIGRAFE</TD>
			<TD ALIGN="left"><%=nomEpigrafe%></TD>
		</TR>
		<TR>
			<TD>GESTOR</TD>
			<TD ALIGN="left">${nombreGestorAccion}</TD>
		</TR>
		<tr>
			<td>OBJETIVO GESTOR</td>
			<td><%=objetivos%></td>
		</tr>	
		<tr>
			<td>TOTAL DE ACCIONES</td>
			<td><%=totalAcciones%></td>
		</tr>			
	</TABLE>
	
	<BR>

	<TABLE align="center">
		<TR>
			<TD class="FondoAzul8" width="150" height=30>DESCRIPCION</TD>			
			<TD colspan=5>
<input name="nombreAccion" type="text" value="<%=dtoAccion.getNomAccion()  %>"  size=70 maxlength="80" class="cajatexto" onKeyPress="return SoloLetras()"/> </TD>
		</TR>
		<TR>
			<TD class="FondoAzul8">N&deg; de Clientes</TD>
			<TD><input type="text" name="numeroClientes" size=10 maxlength="4" value="<%=dtoAccion.getNumeroCliente() %>" onKeyPress="return validKey(this, event, INT_PATTERN);" class="cajatexto"></TD>

			<TD class="FondoAzul8" width="200">Compromiso Gestor<br>&nbsp;(Monto en Miles) &nbsp;/&nbsp;N&uacute;mero</TD>
			<TD colspan=2><input type="text" name="compGestor" size=10 maxlength="10" value="<%=dtoAccion.getCompGestor() %>" onKeyPress="return validKey(this, event, INT_PATTERN_NEGATIVO);" class="cajatexto"></TD>
		</TR>
	</TABLE>
	<TABLE align="center">
<tr><td align="center">
<c:if test="${sessionScope.gestor.codigoPerfil !='CON'}">
<input type="button" name="Grabar" onClick="grabar('<%=codOficinaCompleto %>', '<%=codGestor %>', '<%=codAnho %>', '<%=codMes %>', '<%=nomEpigrafe %>', '<%=prioridad %>', '<%=restoOficina %>', '<%=metaGestor %>','<%=codEpigrafe %>');" value="Grabar">
</c:if>
&nbsp;
<input type="button" name="Volver" onClick="volver('<%=codOficinaCompleto %>', '<%=codGestor %>', '<%=codAnho %>', '<%=codMes %>', '<%=nomEpigrafe %>', '<%=prioridad %>', '<%=restoOficina %>', '<%=metaGestor %>','<%=codEpigrafe %>');" value="Volver">
</td></tr>


	</TABLE>

<!-- **** FIN RESTO DE C√ìDIGO DE LA P√ÅGINA-->


		</td>
	</tr>
</table>
</form>
</BODY>
</html:html>
